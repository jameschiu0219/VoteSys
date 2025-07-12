package hw.votesys.entity;

import jakarta.persistence.*;

//對應資料庫的資料表vote_record
//設private封裝避免資料被竄改
@Entity
@Table(name = "vote_record")
public class VoteRecord {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String voterName;

    @ManyToOne
    @JoinColumn(name = "vote_item_id")
    private VoteItem voteItem;

    // Getter 和 Setter
    public Long getId() {
        return id;
    }

    public String getVoterName() {
        return voterName;
    }

    public void setVoterName(String voterName) {
        this.voterName = voterName;
    }

    public VoteItem getVoteItem() {
        return voteItem;
    }

    public void setVoteItem(VoteItem voteItem) {
        this.voteItem = voteItem;
    }
}
