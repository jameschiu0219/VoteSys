<template>
  <div class="register-view">
    <h2>註冊</h2>
    <form @submit.prevent="register">
      <input v-model="username" placeholder="使用者名稱" required />
      <input v-model="password" type="password" placeholder="密碼" required />
      <select v-model="role">
        <option value="ROLE_USER">使用者</option>
        <option value="ROLE_ADMIN">管理員</option>
      </select>
      <button type="submit">註冊</button>
    </form>
    <p v-if="message">{{ message }}</p>
  </div>
</template>

<script>
import axios from 'axios';

export default {
  name: 'RegisterView',
  data() {
    return {
      username: '',
      password: '',
      role: 'ROLE_USER',
      message: ''
    };
  },
  methods: {
    async register() {
      try {
        await axios.post('/api/auth/register', {
          username: this.username,
          password: this.password,
          role: this.role
        });
        this.message = '註冊成功，請前往登入';
      } catch (err) {
        this.message = '註冊失敗：' + err.response?.data;
      }
    }
  }
};
</script>

<style scoped>
.register-view {
  max-width: 300px;
  margin: auto;
  padding: 1em;
}
</style>
