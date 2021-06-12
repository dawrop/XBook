package com.dawrop.XBook.security;

import com.dawrop.XBook.models.ERole;
import com.dawrop.XBook.security.services.UserDetailsImpl;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

public class AccessCheck {
    public static boolean hasRole(ERole role) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        Object principal = authentication.getPrincipal();

        if (principal instanceof UserDetailsImpl) {
            UserDetailsImpl userDetails = (UserDetailsImpl) principal;
            userDetails.getAuthorities().stream().forEach( err -> System.out.println(err.getAuthority()));
        } else {
            System.out.println("dsasd");
        }


        return authentication.getAuthorities().stream().anyMatch(r -> r.getAuthority().equals(role.getName()));
    }


}
