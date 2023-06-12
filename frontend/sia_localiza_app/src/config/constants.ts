export const CONSTANTS = {
  API_BACKEND: 'http://127.0.0.1:8000/api/v1',
  ENV: process.env.APP_ENV as
    | 'development'
    | 'staging'
    | 'production'
    | undefined,
  DISABLE_IN_PRO: process.env.APP_ENV === 'production',
  STORE_ACCESSTOKEN_KEY: '@app_accessToken',
  STORE_REFRESHTOKEN_KEY: '@app_refreshToken',
}
