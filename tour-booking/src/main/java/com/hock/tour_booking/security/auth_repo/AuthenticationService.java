package com.hock.tour_booking.security.auth_repo;

import com.hock.tour_booking.dto.reponse.AuthReponse;
import com.hock.tour_booking.dto.request.AuthRequets;
import com.hock.tour_booking.entity.Role;
import com.hock.tour_booking.entity.User;
import com.hock.tour_booking.security.auth_serivce.JwtService;
import com.hock.tour_booking.security.auth_serivce.RoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@RequiredArgsConstructor
public class AuthenticationService {
    private final UserRepository userRepository;
    private final AuthenticationManager authenticationManager;
    private final RoleCustomRepo roleCustomRepo;
    private final JwtService jwtService;
    private final RoleService roleService;

    public AuthReponse authenticate(AuthRequets authRequets) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authRequets.getEmail(), authRequets.getPassword()));
        User user = userRepository.findByEmail(authRequets.getEmail()).orElseThrow();
        List<Role> roles = new ArrayList<>();
        List<String> temp = null;
        if(user != null) {
            temp = roleCustomRepo.getAllRoles(user);
           temp.forEach(role -> {
               Role r = roleService.getRole(role);
               roles.add(r);
           });
        }

        Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
        Set<Role> sets = new HashSet<>();
        roles.forEach(role -> {
            Role existingRole = roleService.getRole(role.getName());
            if (existingRole != null) {
                sets.add(existingRole);
            }
        });
        user.setRoles(sets);
        sets.forEach(role -> authorities.add(new SimpleGrantedAuthority(role.getName())));

        var jwtToken = jwtService.generateToken(user, authorities);
        var jwtRefresnToken = jwtService.generateRefreshToken(user, authorities);
        return AuthReponse.builder().token(jwtToken).refreshToke(jwtRefresnToken).build();
    }
}
