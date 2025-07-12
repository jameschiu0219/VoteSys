package hw.votesys.Repo;

import hw.votesys.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepo extends JpaRepository<User, Long> {
    //根據「使用者名稱」從資料庫中查出對應的 User 物件，如果存在就回傳 Optional<User>，否則回傳空值。
    Optional<User> findByUsername(String username);
}
