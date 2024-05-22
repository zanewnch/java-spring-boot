import { fileURLToPath, URL } from 'node:url'

import { defineConfig } from 'vite'
import vue from '@vitejs/plugin-vue'

// https://vitejs.dev/config/
export default defineConfig({
  plugins: [
    vue(),
  ],
  resolve: {
    alias: {
      '@': fileURLToPath(new URL('./src', import.meta.url))
    }
  },
  server: {
    proxy: {
      '/api': {
        target: 'http://localhost:8080/api', // 指向後端的地址
        changeOrigin: true,
        // 可選：如果你的 API 需要路徑重寫，可以在這裡設置 他的意思就是把/api 轉換成empty string
        // rewrite: (path) => path.replace(/^\/api/, ''),
      }
    },
  }
})
