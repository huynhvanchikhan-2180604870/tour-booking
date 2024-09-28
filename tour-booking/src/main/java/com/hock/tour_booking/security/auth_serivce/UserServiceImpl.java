package com.hock.tour_booking.security.auth_serivce;

import com.hock.tour_booking.entity.Role;
import com.hock.tour_booking.entity.User;
import com.hock.tour_booking.security.auth_repo.RoleRepository;
import com.hock.tour_booking.security.auth_repo.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@Transactional
@RequiredArgsConstructor
@Slf4j
public class UserServiceImpl implements UserSerivce{
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    private final PasswordEncoder passwordEncoder;

    @Override
    public User saveUser(User user) {
        user.setPassword_hash(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    @Override
    public Role saveRole(Role role) {
        return roleRepository.save(role);
    }

    @Override
    public void addRoleToUser(String username, String roleName) {
        User user = userRepository.findByEmail(username).get();
        Role role = roleRepository.findByName(roleName);
        user.getRoles().add(role);
    }
}
