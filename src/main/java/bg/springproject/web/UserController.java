package bg.springproject.web;

import bg.springproject.model.binding.UserAddBindingModel;
import bg.springproject.model.entity.UserEntity;
import bg.springproject.service.UserService;
import com.google.gson.Gson;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;
    private final Gson gson;

    public UserController(UserService userService, Gson gson) {
        this.userService = userService;
        this.gson = gson;
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public String getAllUsers(){
        List<UserEntity> users = userService.findAllUsers();
        return gson.toJson(users);
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UserEntity> addUser(@RequestBody UserAddBindingModel userAddBindingModel) {

        UserEntity user = userService.saveUserInDB(userAddBindingModel);

        return new ResponseEntity<>(user, HttpStatus.OK);
    }
}
