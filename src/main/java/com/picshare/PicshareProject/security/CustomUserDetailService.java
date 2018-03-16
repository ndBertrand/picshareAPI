package com.picshare.PicshareProject.security;




import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.picshare.PicshareProject.dao.entities.CustomUserDetails;
import com.picshare.PicshareProject.dao.entities.User;
import com.picshare.PicshareProject.dao.repository.UserRepository;


@Service
public class CustomUserDetailService implements UserDetailsService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<User> optionalUser = userRepository.findByUsername(username);

		optionalUser.orElseThrow(() -> new UsernameNotFoundException("Username not Found"));
		return optionalUser.map(user -> {
			return new CustomUserDetails(user);
		}).get();

	}

}
