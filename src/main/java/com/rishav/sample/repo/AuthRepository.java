package com.rishav.sample.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import com.rishav.sample.model.MyUsers;

public interface AuthRepository extends JpaRepository<MyUsers, Long>  {

	Optional<MyUsers> findByUname(String user_name);

}
