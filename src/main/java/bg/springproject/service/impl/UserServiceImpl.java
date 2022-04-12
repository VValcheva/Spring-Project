package bg.springproject.service.impl;

import bg.springproject.model.binding.UserAddBindingModel;
import bg.springproject.model.entity.UserEntity;
import bg.springproject.repository.UserRepository;
import bg.springproject.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    public UserServiceImpl(UserRepository userRepository, ModelMapper modelMapper) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<UserEntity> findAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public UserEntity saveUserInDB(UserAddBindingModel userAddBindingModel) {
        return modelMapper.map(userRepository
                .save(modelMapper.map(userAddBindingModel, UserEntity.class)), UserEntity.class);
    }
}
