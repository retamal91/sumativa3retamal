package com.everis.data.sumativa2.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.everis.data.sumativa2.models.Login;



@Repository
public interface LoginRepository extends JpaRepository<Login, Long> {

	Login findByEmail(String email);
}