package com.ozalp.membership.business.impls;

import com.ozalp.membership.business.dtos.requests.CreateMembershipRequest;
import com.ozalp.membership.business.dtos.responses.MembershipResponse;
import com.ozalp.membership.business.dtos.responses.Organization;
import com.ozalp.membership.business.dtos.responses.UserProfile;
import com.ozalp.membership.business.mappers.MembershipMapper;
import com.ozalp.membership.business.services.MembershipService;
import com.ozalp.membership.clients.OrganizationClient;
import com.ozalp.membership.clients.UserProfileClient;
import com.ozalp.membership.dataAccess.MembershipRepository;
import com.ozalp.membership.models.entities.Membership;
import lombok.RequiredArgsConstructor;
import org.ozalp.events.MembershipCreatedEvent;
import org.ozalp.managers.BaseImpl;
import org.ozalp.utils.consts.EventConst;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class MembershipImpl extends BaseImpl<Membership> implements MembershipService {

    private final MembershipRepository repository;
    private final MembershipMapper mapper;
    private final OrganizationClient organizationClient;
    private final UserProfileClient userProfileClient;
    private final KafkaTemplate<String, MembershipCreatedEvent> kafkaTemplate;

    @Override
    protected JpaRepository<Membership, Integer> getRepository() {
        return repository;
    }

    @Override
    public MembershipResponse create(CreateMembershipRequest request) {
        Organization organization = organizationClient.getOrganizationDetail(request.getOrganizationId());
        UserProfile userProfile = userProfileClient.getProfileDetail(request.getUserProfileId());

        Membership membership = mapper.toEntity(request);
        membership.setOrganizationId(organization.getId());
        membership.setUserProfileId(userProfile.getId());
        membership.setJoinedAt(LocalDateTime.now());

        Membership savedMembership = repository.save(membership);
        kafkaTemplate.send(EventConst.Topics.CREATED_MEMBERSHIP, new MembershipCreatedEvent(userProfile.getEmail(), organization.getName()));
        return mapper.toResponse(savedMembership, organization, userProfile);
    }
}
