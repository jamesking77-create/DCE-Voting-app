package data.repository;

import data.model.PermanentVotersCard;

public interface PermanentVotersCardRepository {
    PermanentVotersCard saveVotersCard(PermanentVotersCard permanentVotersCard);
    long countVotersCard();
    PermanentVotersCard findVotersCardById(int id);
    PermanentVotersCard findVotersCardByName(String name);
    void deleteVotersCardById(int id);


}
