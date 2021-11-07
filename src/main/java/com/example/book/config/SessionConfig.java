package com.example.book.config;


import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
import org.springframework.context.annotation.Configuration;

/**
 * セッションの設定config
 *
 * @author YutaMori
 */
@Configuration
@ConditionalOnWebApplication
public class SessionConfig {
}
