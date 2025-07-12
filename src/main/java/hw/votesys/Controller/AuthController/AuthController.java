package hw.votesys.Controller.AuthController;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {

    @PostMapping("/login/success")
    public ResponseEntity<?> loginSuccess(Authentication authentication) {
        return ResponseEntity.ok("登入成功，歡迎 " + authentication.getName());
    }

    @PostMapping("/login/failure")
    public ResponseEntity<?> loginFailure() {
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                .body("帳號或密碼錯誤");
    }

    @PostMapping("/logout/success")
    public ResponseEntity<?> logoutSuccess() {
        return ResponseEntity.ok("成功登出");
    }
}