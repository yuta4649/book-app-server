package com.example.book.domain.service;

import com.example.book.domain.entity.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * User情報を扱うDomainServiceインターフェース
 *
 * @author YutaMori
 */
@Service
@Transactional
public interface UserDomainService {

    /**
     * メールアドレスからUser情報を取得する
     *
     * @param mailAddress メールアドレス
     * @return User
     */
    public User getUserByMailAddress(String mailAddress);
}
