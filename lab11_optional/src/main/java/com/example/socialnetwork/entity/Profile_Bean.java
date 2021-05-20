package com.example.socialnetwork.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Profile_Bean {
    private String user_name;
    private String email;
    private String profile_picture;
    private String id;
    private String access_token;
}
