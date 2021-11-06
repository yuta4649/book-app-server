package com.example.book.app.service.impl;

import com.example.book.app.service.UserAppService;
import com.example.book.domain.entity.User;
import com.example.book.domain.service.UserDomainService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
     * メールアドレスからUser情報を取得する
     *
     * @param mailAddress メールアドレス
     * @return User
     */
    @Override
    public User getUserByMailAddress(String mailAddress) {
        return userDomainService.getUserByMailAddress(mailAddress);
    }
}
