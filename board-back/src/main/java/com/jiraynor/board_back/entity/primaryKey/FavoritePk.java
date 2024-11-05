package com.jiraynor.board_back.entity.primaryKey;

import java.io.Serializable;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FavoritePk implements Serializable{
    @Column(name="user_email")
    private String userEmail;
    @Column(name="boardNumber")
    private int boardNumber;
    


    
}
