package com.blog.blog.payloads;

import lombok.Data;

@Data
public class PasswordDto {
    private String email;
    private String oldPassword;
    private String newPassword;
}
