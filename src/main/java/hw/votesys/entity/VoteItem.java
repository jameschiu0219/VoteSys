package hw.votesys.entity;

import jakarta.persistence.*;

//對應資料庫的資料表vote_item
//設private封裝避免資料被竄改
@Entity
@Table(name = "vote_item")
public class VoteItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer itemId;

    @Column(nullable = false)
    private String itemName;
}
