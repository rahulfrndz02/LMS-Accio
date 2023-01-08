package com.LMS.studentcard.Models;


import com.LMS.studentcard.Enums.CardStatus;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table
@Getter
@Setter
public class Card {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;


    @Enumerated(value = EnumType.STRING)
    private CardStatus cardStatus;


    @OneToOne
    @JoinColumn
    private Student student;

}