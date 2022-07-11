package com.tw.userservice.Repository;

import com.tw.userservice.Model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User,Long>{

}
