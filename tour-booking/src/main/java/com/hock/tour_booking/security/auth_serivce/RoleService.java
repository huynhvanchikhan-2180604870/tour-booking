package com.hock.tour_booking.security.auth_serivce;

import com.hock.tour_booking.entity.Role;
import com.hock.tour_booking.security.auth_repo.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleService {
    @Autowired
    private RoleRepository roleRepository;
    public Role getRole(String role) {
        return roleRepository.findByName(role);
    }
}
