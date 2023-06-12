export const CONSTANTS = {
  API_BACKEND: process.env.APP_API_URL,
  ENV: process.env.APP_ENV as
    | 'development'
    | 'staging'
    | 'production'
    | undefined,
  DISABLE_IN_PRO: process.env.APP_ENV === 'production',
  STORE_ACCESSTOKEN_KEY: '@app_accessToken',
  STORE_REFRESHTOKEN_KEY: '@app_refreshToken',
}
