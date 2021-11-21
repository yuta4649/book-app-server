package com.example.book.app.dto.msg;

import com.example.book.app.dto.UserDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * ログインリクエストのレスポンス
 *
 * @author YutaMori
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public final class LoginRespMsg {

    /**
     * ユーザー情報
     */
    private UserDto user;
}
