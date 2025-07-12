package hw.votesys.Controller;

import java.util.List;

// Getter/Setter
//提供 Controller 傳遞參數給 Service
public class VoteRequest {
    private String user;    //使用者名稱
    private List<Integer> itemIds;  // 投票選項的 ID 陣列

    public String getUser() {
        return user;
    }
    public void setUser(String user) {
        this.user = user;
    }
    public List<Integer> getItemIds() {
        return itemIds;
    }
    public void setItemIds(List<Integer> itemIds) {
        this.itemIds = itemIds;
    }
}
