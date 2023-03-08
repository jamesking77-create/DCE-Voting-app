package data.repository;

import data.model.PermanentVotersCard;

import java.util.ArrayList;
import java.util.List;

public class PermanentVotersCardImpl  implements PermanentVotersCardRepository{

    private int count;

    private final List<PermanentVotersCard> votersCards = new ArrayList<>();
    @Override
    public PermanentVotersCard saveVotersCard(PermanentVotersCard permanentVotersCard) {
        boolean cardHasNotBeenSaved = permanentVotersCard.getPvcId() == 0;
        if (cardHasNotBeenSaved) {
            saveNewCard(permanentVotersCard);
            votersCards.add(permanentVotersCard);
            count++;
        }
        return permanentVotersCard;
    }

    private void saveNewCard(PermanentVotersCard permanentVotersCard) {
        permanentVotersCard.setPvcId(generateCardId());
    }

    private int generateCardId() {
        return count+1;
    }

    @Override
    public long countVotersCard() {
        return count;
    }

    @Override
    public PermanentVotersCard findVotersCardById(int id) {
        for (PermanentVotersCard card: votersCards) {
            if (id == card.getPvcId()) return card;
        }
        return null;
    }

    @Override
    public PermanentVotersCard findVotersCardByName(String name) {
        for (PermanentVotersCard card: votersCards) {
            if (name.equals(card.getFullName())) return card;
        }
        return null;
    }

    @Override
    public void deleteVotersCardById(int id) {
        for (PermanentVotersCard card: votersCards) {
            if (id == card.getPvcId()){
                votersCards.remove(card);
                count--;
                break;
            }
        }
    }
}
