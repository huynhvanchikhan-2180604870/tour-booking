package com.hock.tour_booking.security.auth_serivce;

import com.hock.tour_booking.entity.Role;
import com.hock.tour_booking.entity.User;

public interface UserSerivce {
    User saveUser(User user);
    Role saveRole(Role role);
    void addRoleToUser(String username, String roleName);
}
