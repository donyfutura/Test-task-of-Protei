package com.example.demo.repository;

import com.example.demo.entity.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {

    User findByEmail(String email);

    List<User> findAllByStatusAndLastSeenIsLessThan(Status status, Date lastSeen);
}
