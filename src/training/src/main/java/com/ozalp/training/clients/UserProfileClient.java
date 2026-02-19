package com.ozalp.training.clients;

import com.ozalp.training.business.dtos.responses.UserProfile;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "user-profile", url = "${userProfileClientUrl}")
public interface UserProfileClient {

    @GetMapping("/api/userProfile/getById/{id}")
    UserProfile getUserById(int id);

}
