package ru.protei.demo.repository;

import ru.protei.demo.entity.Status;
import ru.protei.demo.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {

    User findByEmail(String email);

    List<User> findAllByStatusAndLastSeenIsLessThan(Status status, Date lastSeen);
}
