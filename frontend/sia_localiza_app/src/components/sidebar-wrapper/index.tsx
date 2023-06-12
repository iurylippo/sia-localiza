'use client'
import React, { PropsWithChildren, useState } from 'react'
import Navbar from '../layout/navbar'
import Sidebar from '../layout/sidebar'

export function SideBarWrapper(props: PropsWithChildren) {
  const [showSidebar, setShowSidebar] = useState(false)

  return (
    <div className="grid h-screen overflow-hidden bg-white grid-rows-header">
      <div className="z-10 bg-white shadow-sm">
        <Navbar onMenuButtonClick={() => setShowSidebar((prev) => !prev)} />
      </div>

      <div className="grid md:grid-cols-sidebar ">
        <div className="shadow-md">
          <Sidebar open={showSidebar} setOpen={setShowSidebar} />
        </div>
        <div className="h-screen p-4 overflow-y-scroll">{props.children}</div>
      </div>
    </div>
  )
}
