export type UserDataType = {
  name: string
  email: string
  userId: string
}

export type UserSignInResponseType = {
  access_token: string
  refresh_token: string
  user: {
    name: string
    email: string
    id: string
  }
}

export type UserLoginData = {
  email: string
  password: string
}
