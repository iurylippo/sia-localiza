'use client'
import React, { PropsWithChildren } from 'react'
import { SideBarWrapper } from '../sidebar-wrapper'
import { LoginLayout } from './login'

const Layout = (props: PropsWithChildren) => {
  return (
    <div>
      {document.location.pathname === '/login' ? (
        <LoginLayout />
      ) : (
        <SideBarWrapper>{props.children}</SideBarWrapper>
      )}
    </div>
  )
}
export default Layout
