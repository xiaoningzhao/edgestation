package com.agmachine.edgestation.services;

import com.agmachine.edgestation.models.User;
import com.agmachine.edgestation.repositories.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public boolean login(User user) {
        if(userRepository.existsUserByUserName(user.getUserName())){
            if(userRepository.findUserByUserName(user.getUserName()).getPassword().equals(user.getPassword())){
                return true;
            }
        }
        return false;
    }
}
