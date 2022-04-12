package bg.springproject.service;

import bg.springproject.model.binding.UserAddBindingModel;
import bg.springproject.model.entity.UserEntity;

import java.util.List;

public interface UserService {

    List<UserEntity> findAllUsers();

    UserEntity saveUserInDB(UserAddBindingModel userAddBindingModel);
}
