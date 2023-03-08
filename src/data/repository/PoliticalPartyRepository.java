package data.repository;

import data.model.PoliticalParty;

import java.util.List;

public interface PoliticalPartyRepository {
    PoliticalParty savePoliticalParty(PoliticalParty politicalParty);
    PoliticalParty findPartyById(int id);
    PoliticalParty findPartyByPartyName(String partyName);
    long countParty();
    List<PoliticalParty> findAllParty();
    void deletePartyById(int id);
    void deleteAllParty();
}
