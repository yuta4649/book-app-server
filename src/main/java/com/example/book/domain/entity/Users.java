package com.example.book.domain.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;

/**
 * ユーザー
 *
 * @author YutaMori
 */
@Getter
@Setter
public class Users extends BaseEntity implements AutoGeneratedIdManageable {

    /**
     * ユーザーID
     */
    @Id
    private String userId;

    /**
     * パスワード
     */
    private String password;

    /**
     * Mailアドレス
     */
    private String mailAddress;

    /**
     * ユーザー名
     */
    private String userName;

    /**
     * ログインID
     */
    private String loginId;

    /**
     * 登録状態
     */
    private String registrationStatus;

    /**
     * 権限の種類
     */
    private String authorizationType;

    /**
     * エラーカウント
     */
    private int errorCount;

    /**
     * ロック状態
     */
    private String lockedFlg;

    /**
     * {@inheritDoc}
     */
    @Override
    public String getAutoGeneratedId() {
        return this.userId;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setAutoGeneratedId(String id) {
        this.userId = id;
    }
}
