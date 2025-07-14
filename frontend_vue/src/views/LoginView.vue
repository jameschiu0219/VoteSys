<template>
  <div class="login-container">
    <h2>使用者登入</h2>
    <form @submit.prevent="handleLogin">
      <div>
        <label>帳號：</label>
        <input v-model="username" type="text" required />
      </div>
      <div>
        <label>密碼：</label>
        <input v-model="password" type="password" required />
      </div>
      <button type="submit">登入</button>
      <p v-if="errorMessage" class="error">{{ errorMessage }}</p>
    </form>
  </div>
</template>

<script>
import axios from 'axios';

export default {
  name: 'Login',
  data() {
    return {
      username: '',
      password: '',
      errorMessage: ''
    };
  },
  methods: {
    async handleLogin() {
      try {
        const response = await axios.post('http://localhost:8181/api/auth/login', {
          username: this.username,
          password: this.password
        });

        const token = response.data.token;
        localStorage.setItem('token', token);
        this.$router.push('/dashboard'); // 成功會重新導向
      } catch (error) {
        this.errorMessage = '登入失敗，請確認帳號密碼';
        console.error(error);
      }
    }
  }
};
</script>

<style scoped>
.login-container {
  max-width: 400px;
  margin: 50px auto;
  padding: 30px;
  border: 1px solid #ccc;
  border-radius: 8px;
  background-color: #0066CC;
}
label {
  display: block;
  margin-top: 10px;
}
input {
  width: 100%;
  padding: 8px;
  margin-top: 5px;
}
button {
  margin-top: 20px;
  padding: 10px 20px;
}
.error {
  color: red;
  margin-top: 10px;
}
</style>
