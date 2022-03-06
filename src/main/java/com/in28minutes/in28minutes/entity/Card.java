package com.in28minutes.in28minutes.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
@Getter
@Setter
public class Card implements Serializable {

    @Id
    private String cardNumber;

    @Column(name = "user_id")
    private Long userId;
}
