import { CONSTANTS } from '@/config/constants'

const { STORE_ACCESSTOKEN_KEY, STORE_REFRESHTOKEN_KEY } = CONSTANTS

export class TokenService {
  static getAccessToken(): string | null {
    const token = localStorage.getItem(STORE_ACCESSTOKEN_KEY)
    return token || null
  }

  static setAccessToken(token: string): void {
    localStorage.setItem(STORE_ACCESSTOKEN_KEY, token)
  }

  static removeAccessToken(): void {
    localStorage.removeItem(STORE_ACCESSTOKEN_KEY)
  }

  static getRefreshToken(): string | null {
    const token = localStorage.getItem(STORE_REFRESHTOKEN_KEY)
    return token || null
  }

  static setRefreshToken(token: string): void {
    localStorage.setItem(STORE_REFRESHTOKEN_KEY, token)
  }

  static removeRefreshToken(): void {
    localStorage.removeItem(STORE_REFRESHTOKEN_KEY)
  }

  //   static isExpiredToken(): boolean {
  //     const token = localStorage.getItem(STORE_ACCESSTOKEN_KEY)

  //     if (!token) return true

  //     const isExpiredStoragedToken = isExpired(token)
  //     return isExpiredStoragedToken
  //   }
}
