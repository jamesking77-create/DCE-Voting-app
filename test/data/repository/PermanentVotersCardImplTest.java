package data.repository;

import data.model.PermanentVotersCard;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PermanentVotersCardImplTest {
    private PermanentVotersCardRepository permanentVotersCardRepository;
    PermanentVotersCard card1;
    PermanentVotersCard card2;
    @BeforeEach public void setUp(){
        permanentVotersCardRepository = new PermanentVotersCardImpl();
        card1 = new PermanentVotersCard();
        card2 = new PermanentVotersCard();
        card1.setFirstName("james");
        card1.setLastName("king");
        card1.setGender("male");
        card1.setFullName("james king");
        card2.setFirstName("florence");
        card2.setLastName("love");
        card2.setGender("female");
    }
    @Test public void saveOneCard_countIsOneTest(){
        permanentVotersCardRepository.saveVotersCard(card1);
        assertEquals(1, permanentVotersCardRepository.countVotersCard());
    }
    @Test public void saveOneCard_IdOfCardIsOneTest(){
        permanentVotersCardRepository.saveVotersCard(card1);
        assertEquals(1, card1.getPvcId());
    }
    @Test public void saveTwoCard_IdIsGeneratedTest(){
        permanentVotersCardRepository.saveVotersCard(card1);
        assertEquals(1, card1.getPvcId());
        permanentVotersCardRepository.saveVotersCard(card2);
        assertEquals(2, card2.getPvcId());
    }

    @Test public void saveTwoCardWithSameId_countIsOneTest(){
        permanentVotersCardRepository.saveVotersCard(card1);
        assertEquals(1, card1.getPvcId());
        card2.setLastName("gold");
        permanentVotersCardRepository.saveVotersCard(card1);
        assertEquals(1, permanentVotersCardRepository.countVotersCard());
    }

    @Test public void saveTwoCard_FindCardByIdTest(){
        PermanentVotersCard firstCard = permanentVotersCardRepository.saveVotersCard(card1);
        assertEquals(1, card1.getPvcId());
        PermanentVotersCard foundCard1 = permanentVotersCardRepository.findVotersCardById(1);
        assertEquals(firstCard, foundCard1);
        PermanentVotersCard secondCard = permanentVotersCardRepository.saveVotersCard(card2);
        assertEquals(2, card2.getPvcId());
        PermanentVotersCard foundCard2 = permanentVotersCardRepository.findVotersCardById(2);
        assertEquals(secondCard, foundCard2);
    }

    @Test public void saveOneCard_findCardByNameTest(){
        PermanentVotersCard savedCard = permanentVotersCardRepository.saveVotersCard(card1);
        assertEquals(1, card1.getPvcId());
        PermanentVotersCard foundCard = permanentVotersCardRepository.findVotersCardByName(card1.getFullName());
        assertEquals(savedCard, foundCard);


    }

  @Test public void saveTwoCard_deleteOneCardCountIsOneTest(){
      permanentVotersCardRepository.saveVotersCard(card1);
      assertEquals(1, card1.getPvcId());
      permanentVotersCardRepository.saveVotersCard(card2);
      assertEquals(2, card2.getPvcId());
      permanentVotersCardRepository.deleteVotersCardById(2);
      assertEquals(1, permanentVotersCardRepository.countVotersCard());
  }



}