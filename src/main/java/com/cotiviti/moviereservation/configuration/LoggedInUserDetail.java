package com.cotiviti.moviereservation.configuration;

import com.cotiviti.moviereservation.user.domain.Role;
import com.cotiviti.moviereservation.user.domain.User;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.*;

public class LoggedInUserDetail {
    public static Map<String, Object> getLoggedInUserDetail() {
        Map<String, Object> loggedInUserDetail = new HashMap<>();
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User principal = (User) authentication.getPrincipal();
        loggedInUserDetail.put("id", principal.getId());
        loggedInUserDetail.put("email", principal.getEmail());
        loggedInUserDetail.put("roles", principal.getRoles());
        return loggedInUserDetail;
    }

    public static List<String> getLoggedInUserRoles() {
        List<String> data = new ArrayList<>();
        Map<String, Object> loggedInUserDetail = getLoggedInUserDetail();
        Set result = (Set) loggedInUserDetail.get("roles");
        List<Role> roleList = new ArrayList<>(result);
        for (Role role : roleList) {
            data.add(role.getName());
        }
        return data;
    }
}
