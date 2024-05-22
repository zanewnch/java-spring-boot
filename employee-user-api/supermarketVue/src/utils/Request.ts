import axios from 'axios'
const request = axios.create({
  baseURL: 'http://localhost:8080/api',
  timeout: 5000
})

request.interceptors.request.use((config) => {
  return config;
})
request.interceptors.response.use(
  (response) => {
    return response;
  },
  (error) => {
    return Promise.reject(new Error(error.message));
  }
)

export default request;
