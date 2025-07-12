package hw.votesys.Repo;

import hw.votesys.entity.VoteItem;
import org.springframework.data.jpa.repository.JpaRepository;

//直接操作SQL資料表
public interface VoteItemRepo extends JpaRepository<VoteItem,Integer> {
}
