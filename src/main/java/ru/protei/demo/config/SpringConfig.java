package ru.protei.demo.config;

import ru.protei.demo.entity.Status;
import ru.protei.demo.entity.User;
import ru.protei.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.util.Calendar;
import java.util.List;

@Configuration
@EnableScheduling
public class SpringConfig {

    private final UserRepository userRepository;

    @Autowired
    public SpringConfig(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Scheduled(fixedRate = 1000)
    public void scheduleFixedRateTask() {

        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.MINUTE, -5);
        List<User> users = userRepository.findAllByStatusAndLastSeenIsLessThan(Status.Online, calendar.getTime());

        for (User user: users){
            user.setStatus(Status.Away);
            userRepository.save(user);
            System.out.println("Статус изменен");
        }
    }
}
