package com.trexgui.spring.service;

import com.trexgui.spring.domain.User;
import com.trexgui.spring.web.dto.UserUpdateDto;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserUpdateDtoService {

    private UserService userService;
    private ModelMapper modelMapper;

    public UserUpdateDtoService(UserService userService, ModelMapper modelMapper) {
        this.userService = userService;
        this.modelMapper = modelMapper;
    }

    public List<UserUpdateDto> findAll(){
        List<User> userList = userService.findAllEagerly();
        List<UserUpdateDto> userUpdateDtosList = new ArrayList<>();

        for(User user : userList){
            userUpdateDtosList.add(modelMapper.map(user, UserUpdateDto.class));
        }
        return userUpdateDtosList;
    }

    public UserUpdateDto findById(Long id){
        return modelMapper.map(userService.findByIdEagerly(id), UserUpdateDto.class);
    }


}
