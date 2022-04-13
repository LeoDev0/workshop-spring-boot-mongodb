package com.leodev0.workshopmongo.resources;

import com.leodev0.workshopmongo.domain.User;
import com.leodev0.workshopmongo.dto.UserDTO;
import com.leodev0.workshopmongo.services.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

    private final UserService userService;

    public UserResource(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<List<UserDTO>> findAll() {
        List<User> list = userService.findAll();
        List<UserDTO> listDTO = list.stream().map(
                user -> new UserDTO(user)
        ).collect(Collectors.toList());

//        List<UserDTO> listDTO = list.stream().map((user) -> {
//            UserDTO userDto = new UserDTO();
//            BeanUtils.copyProperties(user, userDto);
//            return userDto;
//        }).collect(Collectors.toList());

        return ResponseEntity.ok().body(listDTO);
    }
}
