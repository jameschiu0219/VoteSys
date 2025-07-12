package hw.votesys.Controller.VoteController;

import hw.votesys.Controller.VoteRequest;
import hw.votesys.Service.VoteService;
import hw.votesys.entity.VoteItem;
import hw.votesys.entity.VoteRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

//驗證身分後決定是投票或新增選項
@RestController
@RequestMapping("/api/vote")
public class VoteController {
    @Autowired
    private VoteService voteService;

    // 查詢所有投票項目
    @GetMapping("/items")
    public List<VoteItem> getAllItems() {
        return voteService.getAllVoteItems();
    }

    // 查詢所有投票紀錄（for 統計）
    @GetMapping("/records")
    public List<VoteRecord> getAllRecords() {
        return voteService.getAllVoteRecords();
    }

    // 使用者投票（一次投多個）
    @PostMapping("/submit")
    //requstbody把前端傳來的json轉成voterequest物件
    public ResponseEntity<String> vote(@RequestBody VoteRequest request) {
        voteService.vote(request.getUser(), request.getItemIds());
        return ResponseEntity.ok("投票成功");
    }

    // 管理員新增投票項目（權限限制）
    //@PreAuthorize("hasRole('ADMIN')")   //僅限「角色是 ADMIN」的使用者可以使用
    @PostMapping("/item")
    public ResponseEntity<String> addItem(@RequestBody Map<String, String> body) {
        voteService.addVoteItem(body.get("name"));
        return ResponseEntity.ok("新增成功");
    }
}
