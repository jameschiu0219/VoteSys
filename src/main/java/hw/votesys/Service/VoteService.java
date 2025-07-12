package hw.votesys.Service;

import hw.votesys.Repo.VoteItemRepo;
import hw.votesys.Repo.VoteRecordRepo;
import hw.votesys.entity.VoteItem;
import hw.votesys.entity.VoteRecord;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VoteService {
    @Autowired
    private JdbcTemplate jdbc;

    @Autowired
    private VoteItemRepo voteItemRepo;

    @Autowired
    private VoteRecordRepo  voteRecordRepo;



    //使用者對多個項目進行投票，呼叫 stored procedure
    @Transactional
    public void vote(String voter, List<Integer> itemIds) {
        for (Integer itemId : itemIds) {
            jdbc.update("CALL vote(?, ?)", voter, itemId);
        }
    }

    // 呼叫 stored procedure 新增投票項目
    public void addVoteItem(String name) {
        jdbc.update("CALL add_vote_item(?)", name);
    }

    //查詢所有投票項目
    public List<VoteItem> getAllVoteItems() {
        return voteItemRepo.findAll();
    }
    //查詢投票紀錄，用於統計票數
    public List<VoteRecord> getAllVoteRecords() {
        return voteRecordRepo.findAll();
    }
}
