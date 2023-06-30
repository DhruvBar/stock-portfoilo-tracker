package org.daiict.authn_authz.repository;

import org.daiict.authn_authz.model.UserDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserDetails,Integer> {
}
