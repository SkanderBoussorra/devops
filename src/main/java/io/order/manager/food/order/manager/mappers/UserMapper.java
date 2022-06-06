package io.order.manager.food.order.manager.mappers;


import io.order.manager.food.order.manager.dto.UserDTO;
import io.order.manager.food.order.manager.entities.User;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserMapper {
    @Autowired
    private ModelMapper modelMapper;

    public UserDTO convertEntityToDto(User user){

        modelMapper.getConfiguration()
                .setMatchingStrategy(MatchingStrategies.LOOSE);
        UserDTO userDTO = new UserDTO();
        userDTO = modelMapper.map(user, UserDTO.class);
        return userDTO;
    }

    public User convertDtoToEntity(UserDTO userDTO){
        modelMapper.getConfiguration()
                .setMatchingStrategy(MatchingStrategies.LOOSE);
        User user = new User();
        user = modelMapper.map(userDTO, User.class);
        return user;
    }
}
