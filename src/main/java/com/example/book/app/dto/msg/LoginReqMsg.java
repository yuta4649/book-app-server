package com.example.book.app.dto.msg;

import lombok.Getter;
import lombok.Setter;

/**
 * ログインリクエストのメッセージ
 *
 * @author YutaMori
 */
@Getter
@Setter
public class LoginReqMsg {

    /**
     * メールアドレス
     */
    private String mailAddress;

    /**
     * パスワード
     */
    private String password;

}
