<template>
  <div class="login-view">
    <h2>登入</h2>
    <form @submit.prevent="login">
      <input v-model="username" placeholder="使用者名稱" required/>
      <input v-model="password" type="password" placeholder="密碼" required/>
      <button @click="login">登入</button>
    </form>
  </div>
</template>
<script setup>
import {ref} from 'vue'
import axios from 'axios'

const username = ref('')
const password = ref('')

const login = async () => {
  try {
    await axios.post('/login', new URLSearchParams({
      username: username.value,
      password: password.value
    }))
    alert('登入成功')
  } catch (err) {
    alert('登入失敗')
  }
}
</script>