package org.daiict.authn_authz.service;


import org.daiict.authn_authz.model.UserDetail;

public interface UserService {

    public UserDetail createUser(UserDetail user);

    public boolean checkEmail(String email);

}
