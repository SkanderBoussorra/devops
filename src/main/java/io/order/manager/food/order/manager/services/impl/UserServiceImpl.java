package io.order.manager.food.order.manager.services.impl;


import io.order.manager.food.order.manager.Exeptions.MyException;
import io.order.manager.food.order.manager.dto.UserDTO;
import io.order.manager.food.order.manager.entities.User;
import io.order.manager.food.order.manager.enums.ResultEnum;
import io.order.manager.food.order.manager.mappers.UserMapper;
import io.order.manager.food.order.manager.repositories.UserRepository;
import io.order.manager.food.order.manager.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.DependsOn;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.stream.Collectors;

@Service
@DependsOn("passwordEncoder")
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private UserMapper userMapper;

    @Override
    public UserDTO findOne(String email) {
        return userMapper.convertEntityToDto(userRepository.findByEmail(email));
    }

    @Override
    public Collection<UserDTO> findByRole(String role) {
        Collection<User> users = userRepository.findAllByRole(role);
        return users.stream().map(x-> userMapper.convertEntityToDto(x)).collect(Collectors.toList());
    }

    @Override
    @Transactional
    public UserDTO save(UserDTO userDTO) {
        //register
        userDTO.setPassword(passwordEncoder.encode(userDTO.getPassword()));
        try {
            User savedUser = userRepository.save(userMapper.convertDtoToEntity(userDTO));

            // initial Cart;
            //return userRepository.save(savedUser);
            return userMapper.convertEntityToDto(savedUser);

        } catch (Exception e) {
            throw new MyException(ResultEnum.VALID_ERROR);
        }

    }

    @Override
    @Transactional
    public void update(UserDTO userDTO) {
        UserDTO oldUser = userMapper.convertEntityToDto(userRepository.findByEmail(userDTO.getEmail()));
        oldUser.setPassword(passwordEncoder.encode(userDTO.getPassword()));
        oldUser.setName(userDTO.getName());
        oldUser.setPhone(userDTO.getPhone());
        oldUser.setAddress(userDTO.getAddress());
        userRepository.save(userMapper.convertDtoToEntity(oldUser));
    }

}
