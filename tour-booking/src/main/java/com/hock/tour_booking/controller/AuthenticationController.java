package com.hock.tour_booking.controller;

import com.hock.tour_booking.dto.reponse.AuthReponse;
import com.hock.tour_booking.dto.request.AuthRequets;
import com.hock.tour_booking.security.auth_repo.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/auth")
@RequiredArgsConstructor
public class AuthenticationController {
    @Autowired
    private AuthenticationService authenticationService;



    @PostMapping("/login")
    public ResponseEntity<AuthReponse> login(@RequestBody AuthRequets authRequets){
        return ResponseEntity.ok(authenticationService.authenticate(authRequets));
    }
}
