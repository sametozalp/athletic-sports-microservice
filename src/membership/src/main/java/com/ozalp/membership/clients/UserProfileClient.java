package com.ozalp.membership.clients;

import com.ozalp.membership.business.dtos.responses.UserProfile;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "user-profile", url = "${userProfileClientUrl}")
public interface UserProfileClient {

    @GetMapping("/api/userProfile/getProfileDetail/{id}")
    UserProfile getProfileDetail(@PathVariable int id);

}
