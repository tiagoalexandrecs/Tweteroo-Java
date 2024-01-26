package com.api.tweteroo.Services;

import org.springframework.stereotype.Service;

import com.api.tweteroo.Dtos.UserDto;
import com.api.tweteroo.Models.UserModel;
import com.api.tweteroo.Repositories.UserRepository;

import java.util.List;
import java.util.Optional;


@Service
public class UserService {
    final UserRepository userRepository;

    UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<UserModel> findAll() {
		  return userRepository.findAll();
		}
		
		public Optional<UserModel> findById(Long id) {
		    return userRepository.findById(id);
		}
		
		public Optional<UserModel> save(UserDto dto) {
            boolean exists = userRepository.existsByUsername(dto.getUsername());
            if (exists) {
                return Optional.empty();
            }
		    UserModel user = new UserModel(dto);
		    return Optional.of(userRepository.save(user));
		}
		
	
    
}
