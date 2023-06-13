import axios, { HttpStatusCode } from 'axios'
import { CONSTANTS } from '@/config/constants'
import { TokenService } from '../token'

const { API_BACKEND } = CONSTANTS

const USER_TOKEN = TokenService.getAccessToken()
const AuthStr = USER_TOKEN
  ? { Authorization: 'Bearer '.concat(USER_TOKEN) }
  : undefined

export const API = axios.create({
  baseURL: API_BACKEND,
  headers: AuthStr,
})

export const BASE_API = axios.create({
  baseURL: API_BACKEND,
})

export async function autoUpdateRefreshToken() {
  const currentRefreshToken = TokenService.getRefreshToken()

  if (!currentRefreshToken) {
    window.location.href = '/login'
    return
  }

  const result = await API.post(
    '/auth/refresh-token',
    {},
    {
      headers: {
        Authorization: `Bearer ${currentRefreshToken}`,
      },
    },
  )

  const { access_token: accessToken, refresh_token: refreshToken } = result.data
  TokenService.setAccessToken(accessToken)
  TokenService.setRefreshToken(refreshToken)
}

API.interceptors.request.use((req) => {
  if (req.headers) {
    req.headers.Authorization = `Bearer ${TokenService.getAccessToken()}`
  }
  return req
})

API.interceptors.response.use(
  (res) => {
    return res
  },
  async (err) => {
    const originalConfig = err.config

    if (err.response) {
      if (
        err.response.status === HttpStatusCode.Unauthorized &&
        !originalConfig._retry &&
        originalConfig.url !== '/auth/refresh-token'
      ) {
        console.log('tentando refresh!')
        originalConfig._retry = true

        try {
          await autoUpdateRefreshToken()
          return API(originalConfig)
        } catch (_error) {
          localStorage.clear()
          window.location.href = '/login'
          return Promise.reject(_error)
        }
      }
    }

    return Promise.reject(err)
  },
)
