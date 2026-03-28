package com.ozalp.membership.business.impls;

import com.ozalp.membership.business.dtos.requests.CreateMembershipRequestRequest;
import com.ozalp.membership.business.dtos.responses.MembershipRequestResponse;
import com.ozalp.membership.business.dtos.responses.Organization;
import com.ozalp.membership.business.dtos.responses.UserProfile;
import com.ozalp.membership.business.mappers.UserOrganizationMapper;
import com.ozalp.membership.business.services.MembershipRequestService;
import com.ozalp.membership.clients.OrganizationClient;
import com.ozalp.membership.clients.UserProfileClient;
import com.ozalp.membership.dataAccess.MembershipRequestRepository;
import com.ozalp.membership.models.entities.MembershipRequest;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.ozalp.events.MembershipRequestCreatedEvent;
import org.ozalp.managers.BaseImpl;
import org.ozalp.utils.consts.EventConst;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class MembershipRequestImpl extends BaseImpl<MembershipRequest> implements MembershipRequestService {

    private final MembershipRequestRepository repository;
    private final UserOrganizationMapper mapper;
    private final OrganizationClient organizationClient;
    private final UserProfileClient userProfileClient;
    private final KafkaTemplate<String, MembershipRequestCreatedEvent> kafkaTemplate;

    @Override
    protected JpaRepository<MembershipRequest, Integer> getRepository() {
        return repository;
    }

    @Override
    @Transactional
    public MembershipRequestResponse create(CreateMembershipRequestRequest request) {
        MembershipRequest membershipRequest = mapper.toEntity(request);
        Organization organization = organizationClient.getOrganizationDetail(request.getOrganizationId());
        UserProfile userProfile = userProfileClient.getProfileDetail(request.getUserProfileId());

        kafkaTemplate.send(EventConst.Topics.CREATED_MEMBERSHIP, new MembershipRequestCreatedEvent(userProfile.getEmail(), organization.getName()));
        return mapper.toResponse(repository.save(membershipRequest), organization, userProfile);
    }
}
