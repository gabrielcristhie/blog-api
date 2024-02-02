package com.solides.blog.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import com.solides.blog.DTO.UserDTO;
import com.solides.blog.domain.entities.User;
import com.solides.blog.repository.UserRepository;
import com.solides.blog.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	private UserRepository userRepository;
	
	@Override
	public UserDTO createUser(UserDTO userDTO) {
		User user = modelMapper.map(userDTO, User.class);
		User savedUser = this.userRepository.save(user);
		return modelMapper.map(savedUser, UserDTO.class);
	}
}