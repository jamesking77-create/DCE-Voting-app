package data.repository;

import data.model.PoliticalParty;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PoliticalPartyRepositoryImplTest {
    private PoliticalPartyRepository politicalPartyRepository;
    private PoliticalParty politicalParty;
    private PoliticalParty politicalParty2;

    @BeforeEach public void setUp(){
        politicalParty = new PoliticalParty();
        politicalParty2 = new PoliticalParty();
        politicalPartyRepository = new PoliticalPartyRepositoryImpl();
        politicalParty.setName("APC");
        politicalParty2.setName("LP");
    }

    @Test public void saveOneParty_countIsOneTest(){
        politicalPartyRepository.savePoliticalParty(politicalParty);
        assertEquals(1, politicalPartyRepository.countParty());
    }
    @Test public void saveOneParty_PartyIdIsOneTest(){
        politicalPartyRepository.savePoliticalParty(politicalParty2);
        assertEquals(1, politicalParty2.getId());
    }
    @Test public  void saveOneParty_FindPartyByIdTest(){
        PoliticalParty savedParty = politicalPartyRepository.savePoliticalParty(politicalParty2);
        assertEquals(1, politicalParty2.getId());
        PoliticalParty foundParty =  politicalPartyRepository.findPartyById(1);
        assertEquals(savedParty, foundParty);
    }

    @Test public void saveTwoParty_FindAllPartyTest(){
        politicalPartyRepository.savePoliticalParty(politicalParty2);
        assertEquals(1, politicalParty2.getId());
        politicalPartyRepository.savePoliticalParty(politicalParty);
        assertEquals(2, politicalParty.getId());
        politicalPartyRepository.findAllParty();
        assertEquals(2, politicalPartyRepository.findAllParty().size());
    }
    @Test public void saveTwoParty_deletePartyById_CountIsOneTest(){
        politicalPartyRepository.savePoliticalParty(politicalParty2);
        assertEquals(1, politicalParty2.getId());
        politicalPartyRepository.savePoliticalParty(politicalParty);
        assertEquals(2, politicalParty.getId());
        politicalPartyRepository.deletePartyById(2);
        assertEquals(1, politicalPartyRepository.countParty());
    }
    @Test public void saveTwoParty_deleteAllParty_countIsZeroTest(){
        politicalPartyRepository.savePoliticalParty(politicalParty2);
        assertEquals(1, politicalParty2.getId());
        politicalPartyRepository.savePoliticalParty(politicalParty);
        assertEquals(2, politicalParty.getId());
        politicalPartyRepository.deleteAllParty();
        assertEquals(0, politicalPartyRepository.countParty());
    }
}