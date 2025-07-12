<template>
  <div class="vote-view">
    <h2>投票項目</h2>
    <div v-if="items.length">
      <form @submit.prevent="submitVote">
        <div v-for="item in items" :key="item.itemId">
          <label>
            <input type="checkbox" :value="item.itemId" v-model="selected" />
            {{ item.itemName }}（票數：{{ item.votes }}）
          </label>
        </div>
        <button type="submit">送出投票</button>
      </form>
    </div>
    <p v-else>載入中...</p>
    <p v-if="message">{{ message }}</p>
  </div>
</template>

<script>
import axios from 'axios';

export default {
  name: 'VoteView',
  data() {
    return {
      items: [],
      selected: [],
      message: ''
    };
  },
  async mounted() {
    const res = await axios.get('/api/vote/items');
    const records = await axios.get('/api/vote/records');
    const voteCounts = records.data.reduce((acc, r) => {
      acc[r.itemId] = (acc[r.itemId] || 0) + 1;
      return acc;
    }, {});
    this.items = res.data.map(i => ({
      ...i,
      votes: voteCounts[i.itemId] || 0
    }));
  },
  methods: {
    async submitVote() {
      const user = prompt('請輸入你的使用者名稱');
      try {
        await axios.post('/api/vote/submit', {
          user,
          itemIds: this.selected
        });
        this.message = '投票成功！';
      } catch (e) {
        this.message = '投票失敗';
      }
    }
  }
};
</script>

<style scoped>
.vote-view {
  max-width: 500px;
  margin: auto;
}
</style>
