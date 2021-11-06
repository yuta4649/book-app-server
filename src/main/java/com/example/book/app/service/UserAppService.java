package com.example.book.app.service;


import com.example.book.domain.entity.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Userの情報を扱うAppServiceインターフェース
 *
 * @author YutaMori
 */
@Service
@Transactional
public interface UserAppService {

    /**
     * メールアドレスからUser情報を取得する
     *
     * @param mailAddress メールアドレス
     * @return User
     */
    public User getUserByMailAddress(String mailAddress);
}
