package com.ozalp.organization.clients;

import com.ozalp.organization.business.dtos.responses.UserProfile;
import org.ozalp.utils.consts.ApiConst;
import org.ozalp.utils.consts.ApiParams;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "user-profile", url = "${userProfileClientUrl}")
public interface UserProfileClient {

    //    @GetMapping("/api/userProfile/getProfileDetail/{id}")
    @GetMapping(ApiConst.ApiPath.USER_PROFILE + ApiParams.UserProfile.GET_PROFILE_DETAIL)
    UserProfile getProfileDetail(@PathVariable int id);

}
