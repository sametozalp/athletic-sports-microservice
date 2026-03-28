package com.ozalp.auth.business.impls;

import com.ozalp.auth.business.dtos.requests.QuickStartRequest;
import com.ozalp.auth.business.dtos.requests.RegisterRequest;
import com.ozalp.auth.business.dtos.responses.AuthResponse;
import com.ozalp.auth.business.mappers.AuthMapper;
import com.ozalp.auth.business.services.AuthService;
import com.ozalp.auth.dataAccess.AuthRepository;
import com.ozalp.auth.models.entities.Auth;
import com.ozalp.auth.models.entities.UserProfile;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.ozalp.events.QuickStartEvent;
import org.ozalp.events.UserCreatedEvent;
import org.ozalp.managers.BaseImpl;
import org.ozalp.utils.consts.EventConst;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class AuthImpl extends BaseImpl<Auth> implements AuthService {

    private final AuthRepository repository;
    //    private final AuthValidation validation;
    private final AuthMapper mapper;
    private final KafkaTemplate<String, UserCreatedEvent> kafkaTemplate;
    private final KafkaTemplate<String, QuickStartEvent> quickStartKafkaTemplate;

    @Transactional
    @Override
    public AuthResponse register(RegisterRequest request) {
        Auth reqAuth = mapper.toEntity(request);

        UserProfile profile = new UserProfile();
        profile.setAuth(reqAuth);
        profile.setName("user");
        reqAuth.setUserProfile(profile);

        Auth saved = repository.save(reqAuth);
        kafkaTemplate.send(EventConst.Topics.CREATED_USER_PROFILE, new UserCreatedEvent(saved.getEmail(), saved.getUsername()));
        return mapper.toResponse(saved);
    }

    @Transactional
    @Override
    public AuthResponse quickStart(QuickStartRequest request) {
        Auth reqAuth = mapper.toEntity(request);

        UserProfile profile = new UserProfile();
        profile.setAuth(reqAuth);
        profile.setName("user");
        reqAuth.setUserProfile(profile);

        Auth saved = repository.save(reqAuth);
        quickStartKafkaTemplate.send(EventConst.QuickStartSaga.QUICK_START_AUTH_STAGE_COMPLETED, new QuickStartEvent(saved.getId(), saved.getEmail(), saved.getUsername(), request.getOrganizationId()));
        return mapper.toResponse(saved);
    }

    @Override
    public void createRootAdmin() {
        if (!repository.existsByUsername("admin")) {
            Auth auth = new Auth();
            auth.setEmail("admin@gmail.com");
            auth.setUsername("admin");
            auth.setPassword("123456");

            UserProfile profile = new UserProfile();
            profile.setAuth(auth);
            profile.setName("admin");
            auth.setUserProfile(profile);

            repository.save(auth);
        }
    }

    @Override
    protected JpaRepository<Auth, Integer> getRepository() {
        return repository;
    }
}
