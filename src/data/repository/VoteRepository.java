package data.repository;

import data.model.Vote;

import java.util.List;

public interface VoteRepository {
    Vote saveVote(Vote vote);
    Vote findVoteById(int id);
    List<Vote> findAllVote();
    void deleteVoteById(int id);
    void deleteAllVote();

    long countVote();
}
