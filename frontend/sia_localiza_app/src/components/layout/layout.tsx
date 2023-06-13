'use client'
import React, { PropsWithChildren } from 'react'
import { SideBarWrapper } from '../sidebar-wrapper'
import { LoginLayout } from './login'
import { QueryClient, QueryClientProvider } from 'react-query'
import { Toaster } from './toaster'
const queryClient = new QueryClient()

const Layout = (props: PropsWithChildren) => {
  return (
    <div>
      <Toaster />
      <QueryClientProvider client={queryClient}>
        {document.location.pathname === '/login' ? (
          <LoginLayout />
        ) : (
          <SideBarWrapper>{props.children}</SideBarWrapper>
        )}
      </QueryClientProvider>
    </div>
  )
}
export default Layout
