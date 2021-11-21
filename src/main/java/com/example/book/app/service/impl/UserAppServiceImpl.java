package com.example.book.app.service.impl;

import com.example.book.app.dto.UserDto;
import com.example.book.app.dto.msg.LoginReqMsg;
import com.example.book.app.service.UserAppService;
import com.example.book.domain.entity.User;
import com.example.book.domain.entity.Users;
import com.example.book.domain.repository.UserRepository;
import com.example.book.domain.service.UserDomainService;
import com.example.book.security.SystemAuthority;
import com.google.common.collect.Lists;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalTime;
import java.util.List;

/**
 * UserAppServiceのimplements
 *
 * @author YutaMori
 */
@Service
@Transactional
@RequiredArgsConstructor
public class UserAppServiceImpl implements UserAppService {

    /**
     * UserDomainService
     */
    private final UserDomainService userDomainService;

    /**
     * UserRepository
     */
    private final UserRepository userRepository;

    /**
     * {@inheritDoc}
     */
    @Override
    public User getUserByMailAddress(String mailAddress) {
        return userDomainService.getUserByMailAddress(mailAddress);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UsernamePasswordAuthenticationToken login(LoginReqMsg loginReqMsg) {

        Users users = userRepository.findByMailAddress(loginReqMsg.getMailAddress()).orElseThrow(()
                -> new BadCredentialsException("User not found"));
        // ユーザーがロックされている場合処理を抜ける
        if (users.getLockedFlg().equals("1")) {
            throw new BadCredentialsException("locked account");
        }
        // ユーザーが本登録されていない場合処理を抜ける
        if (users.getRegistrationStatus().equals("N")) {
            throw new BadCredentialsException("not registered");
        }
        LocalTime now = LocalTime.now();
        LocalTime availableStart = LocalTime.of(0, 0, 0);
        LocalTime availableEnd = LocalTime.of(23, 0, 0);
        if (now.isBefore(availableStart) || now.isAfter(availableEnd)) {
            throw new BadCredentialsException("out of login time");
        }

        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        if (!encoder.matches(loginReqMsg.getPassword(), users.getPassword()) && !loginReqMsg.getPassword().equals(users.getPassword())) {
            throw new BadCredentialsException("Password is incorrect");
        }

        List<GrantedAuthority> authorities = Lists.newArrayList(SystemAuthority.ROLE_USER);
        if (users.getAuthorizationType().equals(SystemAuthority.ROLE_ADMIN.getAuthority())) {
            authorities.add(SystemAuthority.ROLE_ADMIN);
        }
        UserDto userDto = UserDto.of(users);
        return new UsernamePasswordAuthenticationToken(userDto, loginReqMsg.getPassword(), authorities);
    }
}
