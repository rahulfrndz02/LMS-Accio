package com.LMS.LMSBackend.Service;

import com.LMS.LMSBackend.Enums.CardStatus;
import com.LMS.LMSBackend.Models.Card;
import com.LMS.LMSBackend.Models.Student;
import org.springframework.stereotype.Service;

@Service
public class CardService {


    public Card createCard(Student student){

        Card newCard = new Card();


        newCard.setCardStatus(CardStatus.ACTIVATED);
        newCard.setStudent(student); //For that new foreign key column

        return newCard;
    }


    //findById
    //



}