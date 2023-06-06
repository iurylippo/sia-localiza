'use client'
import React, { PropsWithChildren, useState } from 'react'
import Navbar from './navbar'
import Sidebar from './sidebar'

const Layout = (props: PropsWithChildren) => {
  // eslint-disable-next-line no-unused-vars
  const [showSidebar, setShowSidebar] = useState(false)

  return (
    <div className="grid h-screen overflow-hidden grid-rows-header bg-zinc-100">
      <div className="z-10 bg-white shadow-sm">
        <Navbar onMenuButtonClick={() => setShowSidebar((prev) => !prev)} />
      </div>

      <div className="grid md:grid-cols-sidebar ">
        <div className="shadow-md bg-zinc-50">
          <Sidebar open={showSidebar} setOpen={setShowSidebar} />
        </div>
        <div className="h-screen p-4 overflow-y-scroll">{props.children}</div>
      </div>
    </div>
  )
}
export default Layout
