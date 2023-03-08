package data.repository;

import data.model.PoliticalParty;

import java.util.ArrayList;
import java.util.List;

public class PoliticalPartyRepositoryImpl implements  PoliticalPartyRepository{

    private  int count;
    private List<PoliticalParty> politicalParties = new ArrayList<>();
    @Override
    public PoliticalParty savePoliticalParty(PoliticalParty politicalParty) {
        boolean partyIsNotSaved = politicalParty.getId() == 0;
        if (partyIsNotSaved){
            saveNewParty(politicalParty);
            politicalParties.add(politicalParty);
            count++;
        }

        return politicalParty;
    }

    private void saveNewParty(PoliticalParty politicalParty) {
        politicalParty.setId(generatePartyId());
    }

    private int generatePartyId() {
        return count + 1;
    }

    @Override
    public PoliticalParty findPartyById(int id) {
        for (PoliticalParty party: politicalParties) {
            if (id == party.getId()) return party;
        }
        return null;
    }

    @Override
    public PoliticalParty findPartyByPartyName(String partyName) {
        return null;
    }

    @Override
    public long countParty() {
        return count;
    }

    @Override
    public List<PoliticalParty> findAllParty() {
        return politicalParties;
    }

    @Override
    public void deletePartyById(int id) {
        for (PoliticalParty party: politicalParties) {
            if (id == party.getId()){
                politicalParties.remove(party);
                count--;
                break;
            }
        }
    }

    @Override
    public void deleteAllParty() {
        politicalParties.removeAll(politicalParties);
        count = politicalParties.size();
    }
}
