/**
 * 
 */
package com.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.user.model.User;

/**
 * @author vssundararaman
 *
 */
@RepositoryRestResource
public interface UserRepository extends JpaRepository<User, Long>{

}
