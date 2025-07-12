package hw.votesys.Repo;

import hw.votesys.entity.VoteRecord;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VoteRecordRepo extends JpaRepository<VoteRecord,Integer> {

}
