package com.blog.blog.payloads;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class UserDto {

    private Integer id;

    @NotEmpty(message = "Name is required!")
    @Size(min = 4,message = "Username must have minimum 4 character!")
    private String name;

    @Email(message = "Email is not valid!")
    @NotEmpty(message = "Email is required!")
    private String email;

    @NotEmpty(message = "Password is required!")
    @Size(min = 8,max = 16,message = "Password must 8 to 16 character!")
    private String password;

    @NotEmpty(message = "This field is required!")
    private String about;

    public String getPassword(){
        return this.password;
    }

    public void setPassword(String password){
        this.password = password;
    }
}
