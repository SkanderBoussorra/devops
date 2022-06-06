package io.order.manager.food.order.manager.services;


import io.order.manager.food.order.manager.dto.UserDTO;
import org.springframework.stereotype.Service;

import java.util.Collection;

public interface UserService {
    UserDTO findOne(String email);

    Collection<UserDTO> findByRole(String role);

    UserDTO save(UserDTO userDTO);

    void update(UserDTO userDTO);
}
