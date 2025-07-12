import { defineConfig } from 'vite'
import vue from '@vitejs/plugin-vue'

export default defineConfig({
  plugins: [vue()],
  server: {
    port: 5173, // Vite 開發伺服器的 port（可改）
    proxy: {
      '/api': {
        target: 'http://localhost:8181', // 資料庫 port（可改）
        changeOrigin: true,
        rewrite: (path) => path.replace(/^\/api/, ''),
      },
    },
  },
})


// import { defineConfig } from 'vite'
// import vue from '@vitejs/plugin-vue'
//
// // https://vite.dev/config/
// export default defineConfig({
//   plugins: [vue()],
// })
