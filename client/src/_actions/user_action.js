import axios from "axios";
import {
  LOGIN_USER,
  REGISTER_USER,
  AUTH_USER
} from './types';
export function loginUser(dataToSubmit) { //body에 넣어준 값들을 파라미터를 통해서 받아준다.

  const request = axios.post('/api/sign/login', dataToSubmit)
    .then(response => response.data) //서버(백엔드)에서 받은 data를 request에 저장해준다.

    return {
      type: LOGIN_USER, // types.js 에서 몰아서 관리하기 위해서 "LOGIN_USER"에서 다음 형태로 바꿔준다
      payload: request 
  } //쉽게 말해 reducer에 action에서 보내주는 역할을 한다.
}

export function registerUser(dataToSubmit) { //body에 넣어준 값들을 파라미터를 통해서 받아준다.

  const request = axios.post('/api/sign/signup', dataToSubmit)
    .then(response => response.data) //서버(백엔드)에서 받은 data를 request에 저장해준다.

    return {
      type: REGISTER_USER, // types.js 에서 몰아서 관리하기 위해서 "REGISTER_USER"에서 다음 형태로 바꿔준다
      payload: request 
  } //쉽게 말해 reducer에 action에서 보내주는 역할을 한다.
}

export function auth() { 

  const request = axios.get('/api/users/auth')
    .then(response => response.data)

    return {
      type: AUTH_USER, 
      payload: request 
  } 
}