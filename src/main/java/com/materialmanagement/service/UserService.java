package com.materialmanagement.service;

import com.materialmanagement.repository.IUserRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserService implements UserDetailsService {

    @Autowired
    private IUserRepository userRepository;
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return userRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("No se encontro el email"));
    }


    public String singUpUser(com.materialmanagement.model.User user) {
       boolean userExist = userRepository.findByEmail(user.getEmail()).isPresent();
       if (userExist){
           throw new IllegalStateException("El email ya se registro con anterioridad");
       }
       String encodedPassword = bCryptPasswordEncoder.encode(user.getPassword());
       user.setPassword(encodedPassword);
       userRepository.save(user);
        return "Se registro correctamente.";
    }
}
