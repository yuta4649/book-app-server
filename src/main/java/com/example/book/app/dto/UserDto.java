package com.example.book.app.dto;

import com.example.book.domain.entity.Users;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.apache.commons.lang3.StringUtils;

import java.io.Serializable;

/**
 * ユーザーのDto
 *
 * @author YutaMori
 */
@Data
@AllArgsConstructor
public class UserDto implements Serializable {

    /**
     * serialVersionUID
     */
    private static final long serialVersionUID = 1L;

    /**
     * ユーザーID ※クライアントの返却地には含まれない
     */
    @JsonIgnore
    private String userId;

    /**
     * ユーザー名
     */
    private String userName;

    /**
     * ログインID
     */
    private String loginId;

    /**
     * 初期パスワードフラグ
     */
    private boolean initialPasswordFlg;

    /**
     * UserDtoを作成する
     */
    public static UserDto of(Users user) {
        return new UserDto(
                user.getUserId(),
                user.getUserName(),
                user.getLoginId(),
                StringUtils.isEmpty(user.getPassword())
        );
    }
}
