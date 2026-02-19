package com.ozalp.membership.business.impls;

import com.ozalp.membership.business.dtos.requests.CreateMembershipRequestRequest;
import com.ozalp.membership.business.dtos.responses.MembershipRequestResponse;
import com.ozalp.membership.business.mappers.UserOrganizationMapper;
import com.ozalp.membership.business.services.MembershipRequestService;
import com.ozalp.membership.dataAccess.MembershipRequestRepository;
import com.ozalp.membership.models.entities.MembershipRequest;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MembershipRequestImpl implements MembershipRequestService {

    private final MembershipRequestRepository repository;
    private final UserOrganizationMapper mapper;

    @Override
    public MembershipRequest findById(int id) {
        return repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("User organization not found"));
    }

    @Override
    public MembershipRequest save(MembershipRequest membershipRequest) {
        return repository.save(membershipRequest);
    }

    @Override
    public void delete(int id) {
        MembershipRequest membershipRequest = findById(id);
        membershipRequest.markAsDelete();
        repository.save(membershipRequest);
    }

    @Override
    public MembershipRequestResponse create(CreateMembershipRequestRequest request) {
        MembershipRequest membershipRequest = mapper.toEntity(request);
        return mapper.toResponse(repository.save(membershipRequest));
    }
}
