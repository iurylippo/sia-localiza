import { useMutation } from 'react-query'
// import jwtDecode from 'jwt-decode'

import { BASE_API } from '@/services/api/axios'
import { TokenService } from '@/services/api/token'
import { useUserStore } from '@/services/store/useUserStore'
import {
  UserDataType,
  UserLoginData,
  UserSignInResponseType,
} from '@/common/types'

// type AccessTokenDecodedType = {
//   tenant_id: string
//   iat: number
//   exp: number
//   sub: string
// }

export function useUserAuth() {
  const { setUserStore } = useUserStore()

  async function refreshTokenAutomation(autoRefetch = true) {
    const tokenStored = TokenService.getAccessToken()
    const refreshTokenStored = TokenService.getRefreshToken()

    if (!refreshTokenStored) {
      localStorage.clear()
      return false
    }

    const isTokenExpired = tokenStored ? TokenService.isExpiredToken() : true

    if (isTokenExpired && !autoRefetch) return false
    if (isTokenExpired && autoRefetch) {
      try {
        const result = await BASE_API.post(
          '/users/auth/refresh_token',
          {},
          {
            headers: {
              Authorization: `Bearer ${TokenService.getRefreshToken()}`,
            },
          },
        )

        const { access_token: accessToken, refresh_token: refreshToken } =
          result.data

        TokenService.setAccessToken(accessToken)
        TokenService.setRefreshToken(refreshToken)
        return true
      } catch (error) {
        localStorage.clear()
        return false
      }
    }

    return true
  }

  function storeUserSignInDataResponse(data: UserSignInResponseType) {
    TokenService.setAccessToken(data.access_token)
    TokenService.setRefreshToken(data.refresh_token)
    // const decoded = jwtDecode(data.token) as AccessTokenDecodedType

    const userStore: UserDataType = {
      name: data?.user?.name,
      email: data?.user?.email,
      userId: data?.user?.id,
    }
    setUserStore(userStore)
  }

  const userSignInMutation = useMutation(
    (data: UserLoginData) => {
      return BASE_API.post('/auth/authenticate', {
        email: data.email,
        password: data.password,
      })
    },
    {
      retry: false,
      onSuccess: (data: { data: UserSignInResponseType }) => {
        storeUserSignInDataResponse(data.data)
      },
    },
  )
  return {
    userSignInMutation,
    refreshTokenAutomation,
  }
}
