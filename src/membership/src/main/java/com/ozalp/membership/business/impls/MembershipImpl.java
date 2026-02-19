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
import com.ozalp.membership.models.enums.MembershipStatus;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MembershipImpl implements MembershipService {

    private final MembershipRepository repository;
    private final MembershipMapper mapper;
    private final OrganizationClient organizationClient;
    private final UserProfileClient userProfileClient;

    @Override
    public Membership findById(int id) {
        return repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Membership not found"));
    }

    @Override
    public Membership save(Membership membership) {
        return repository.save(membership);
    }

    @Override
    public void delete(int id) {
        Membership membership = findById(id);
        membership.markAsDelete();
        repository.save(membership);
    }

    @Override
    public MembershipResponse create(CreateMembershipRequest request) {
        Organization organization = organizationClient.getOrganizationDetail(request.getOrganizationId());
        UserProfile userProfile = userProfileClient.getProfileDetail(request.getUserProfileId());

        Membership membership = mapper.toEntity(request);
        membership.setOrganizationId(organization.getId());
        membership.setUserProfileId(userProfile.getId());
        MembershipResponse response = mapper.toResponse(repository.save(membership));
        response.setMembershipStatus(MembershipStatus.ACTIVE);
        response.setOrganization(organization);
        response.setUserProfile(userProfile);
        return response;
    }
}
