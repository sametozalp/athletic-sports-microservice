package com.ozalp.auth.business.impls;

import com.ozalp.auth.business.dtos.requests.RegisterRequest;
import com.ozalp.auth.business.dtos.responses.AuthResponse;
import com.ozalp.auth.business.mappers.AuthMapper;
import com.ozalp.auth.business.services.AuthService;
import com.ozalp.auth.dataAccess.AuthRepository;
import com.ozalp.auth.models.entities.Auth;
import com.ozalp.auth.models.entities.UserProfile;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class AuthImpl implements AuthService {

    private final AuthRepository repository;
    //    private final AuthValidation validation;
    private final AuthMapper mapper;

    @Override
    public Auth findById(int id) {
        return repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("User not found"));
    }

    @Override
    public Auth save(Auth auth) {
        return repository.save(auth);
    }

    @Override
    public void delete(int id) {
        Auth auth = findById(id);
        auth.markAsDelete();
        repository.save(auth);
    }

    @Transactional
    @Override
    public AuthResponse register(RegisterRequest request) {
        Auth reqAuth = mapper.toEntity(request);

        UserProfile profile = new UserProfile();
        profile.setAuth(reqAuth);
        profile.setName("user");
        reqAuth.setUserProfile(profile);

        Auth saved = repository.save(reqAuth);
        return mapper.toResponse(saved);
    }
}
