package org.daiict.authn_authz.service;

import org.daiict.authn_authz.model.UserDetail;
import org.daiict.authn_authz.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetail createUser(UserDetail user) {

        return userRepository.save(user);

    }

    @Override
    public boolean checkEmail(String email) {
        return userRepository.existsByEmail(email);
    }
}
