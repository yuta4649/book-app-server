package com.example.book.domain.repository;


import com.example.book.domain.entity.User;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * Userを管理するリポジトリ
 *
 * @author YutaMori
 */
@Repository
public interface UserRepository extends CrudRepository<User, String> {

    /**
     * メールアドレスからUser情報を取得する
     *
     * @param mailAddress メールアドレス
     * @return Optional<User>
     */
    @Query("SELECT * FROM USER WHERE mail_address = :mailAddress AND deleted_flg = 0")
    Optional<User> getUserByMailAddress(@Param("mailAddress") String mailAddress);

}