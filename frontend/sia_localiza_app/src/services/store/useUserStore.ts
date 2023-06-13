/* eslint-disable no-unused-vars */
import { UserDataType } from '@/common/types'
import { create } from 'zustand'
import { persist } from 'zustand/middleware'

export const useUserStore = create<
  UserDataType & {
    setUserStore: (user: UserDataType) => void
    setNewNameUserStore: (name: string) => void
    setNewEmailUserStore: (name: string) => void
  }
>()(
  persist(
    (set) => ({
      email: '',
      name: '',
      userId: '',
      setUserStore: (user: UserDataType) =>
        set({
          name: user.name,
          email: user.email,
          userId: user.userId,
        }),
      setNewNameUserStore: (name: string) => set({ name }),
      setNewEmailUserStore: (email: string) => set({ email }),
    }),
    {
      name: 'useUserStore',
    },
  ),
)
