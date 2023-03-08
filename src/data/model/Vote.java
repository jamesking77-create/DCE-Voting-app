package data.model;

public class Vote {
    private int voteId;
    private int thumbPrint;

    private int userId;
    private int politicalPartyId;

    public int getVoteId() {
        return voteId;
    }

    public void setVoteId(int voteId) {
        this.voteId = voteId;
    }

    public int getThumbPrint() {
        return thumbPrint;
    }

    public void setThumbPrint(int politicalPartyId) {
        this.thumbPrint = politicalPartyId;
    }
}
