package com.example.book.domain.repository;


import com.example.book.domain.entity.User;
import com.example.book.domain.entity.Users;
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

    /**
     * UserAllを外部結合で取得する
     *
     * @param mailAddress メールアドレス
     * @return Optional<UserAll>
     */
    @Query("SELECT * FROM USER JOIN USER_AUTH ON USER_AUTH.user_id = USER.user_id WHERE USER.mail_address = :mailAddress AND USER.deleted_flg = 0")
    Optional<Users> findByMailAddress(@Param("mailAddress") String mailAddress);
}
