package data.repository;

import data.model.Vote;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class VoteRepositoryImplTest {
    private Vote vote;
    private  Vote vote2;
    private VoteRepository voteRepository;
    @BeforeEach public void setUp(){
        vote = new Vote();
        vote2 = new Vote();
        voteRepository = new VoteRepositoryImpl();
        vote.setThumbPrint(1);
        vote2.setThumbPrint(2);
    }

    @Test public void saveOneVote_countIsOneTest(){
        voteRepository.saveVote(vote);
        assertEquals(1, voteRepository.countVote());
    }
    @Test public void saveOneVote_voteIdIsOneTest(){
        Vote savedVote = voteRepository.saveVote(vote);
        assertEquals(1, savedVote.getVoteId());
    }
    @Test public void saveOneVote_FindVoteByIdTest(){
        Vote savedVote = voteRepository.saveVote(vote);
        assertEquals(1, savedVote.getVoteId());
        Vote foundVote = voteRepository.findVoteById(1);
        assertEquals(savedVote, foundVote);
    }
    @Test public void saveTwoVotesWithSamId_countIsOneTest(){
        voteRepository.saveVote(vote);
        vote.setThumbPrint(3);
        voteRepository.saveVote(vote);
        assertEquals(1, voteRepository.countVote());
    }
    @Test public void saveTwoVote_findVoteByIdTest(){
        voteRepository.saveVote(vote);
        assertEquals(1, vote.getVoteId());
        Vote savedVote =  voteRepository.saveVote(vote2);
        assertEquals(2, vote2.getVoteId());
        Vote foundVote =  voteRepository.findVoteById(2);
       assertEquals(savedVote, foundVote);
    }
    @Test public void saveTwoVote_deleteVoteById_countIsOneTest(){
        voteRepository.saveVote(vote);
        assertEquals(1, voteRepository.countVote());
        voteRepository.saveVote(vote2);
        assertEquals(2, voteRepository.countVote());
        voteRepository.deleteVoteById(2);
        assertEquals(1, voteRepository.countVote());
    }

    @Test public void saveTwoVote_deleteAllVote_countIsZeroTest(){
        voteRepository.saveVote(vote);
        assertEquals(1, voteRepository.countVote());
        voteRepository.saveVote(vote2);
        assertEquals(2, voteRepository.countVote());
        voteRepository.deleteAllVote();
        assertEquals(0, voteRepository.countVote());

    }

    @Test public void saveTwoVotes_findAllVotesTest(){
        voteRepository.saveVote(vote);
        assertEquals(1, voteRepository.countVote());
        voteRepository.saveVote(vote2);
        assertEquals(2, voteRepository.countVote());
        voteRepository.findAllVote();
        assertEquals(2, voteRepository.findAllVote().size());

    }

}