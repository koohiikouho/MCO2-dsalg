public class Friendship {
    private Integer account;
    private Integer isFriendsWith;

    public Friendship(Integer isFriendsWith, Integer account) {
        this.account = account;
        this.isFriendsWith = isFriendsWith;
    }

    public Integer getAccount() {
        return account;
    }

    public Integer getIsFriendsWith() {
        return isFriendsWith;
    }

    public void setAccount(Integer account) {
        this.account = account;
    }

    public void setIsFriendsWith(Integer isFriendsWith) {
        this.isFriendsWith = isFriendsWith;
    }
}
