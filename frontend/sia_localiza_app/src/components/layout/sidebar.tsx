'use client'
import React, { useRef } from 'react'
import classNames from 'classnames'
import Link from 'next/link'
import Image from 'next/image'
import { defaultNavItems } from './nav-Items'
import { useOnClickOutside } from 'usehooks-ts'
// define a NavItem prop
export type NavItem = {
  label: string
  href: string
  icon: React.ReactNode
}
// add NavItem prop to component prop
type Props = {
  open: boolean
  navItems?: NavItem[]
  setOpen(open: boolean): void
}
const Sidebar = ({ open, navItems = defaultNavItems, setOpen }: Props) => {
  const ref = useRef<HTMLDivElement>(null)
  useOnClickOutside(ref, (e) => {
    setOpen(false)
  })
  return (
    <div
      className={classNames({
        'flex flex-col justify-between': true, // layout
        'bg-primary-500 text-zinc-50': true, // colors
        'md:w-full md:sticky md:top-16 md:z-0 top-0 z-20 fixed': true, // positioning
        'md:h-[calc(100vh_-_64px)] h-full w-[300px]': true, // for height and width
        'transition-transform .3s ease-in-out md:-translate-x-0': true, // animations
        '-translate-x-full ': !open, // hide sidebar to the left when closed
      })}
      ref={ref}
    >
      <nav className="top-0 md:sticky md:top-16">
        {/* nav items */}
        <ul className="flex flex-col gap-2 py-2">
          {navItems.map((item, index) => {
            return (
              <Link key={index} href={item.href}>
                <li
                  className={classNames({
                    'text-indigo-100 hover:bg-title': true, // colors
                    'flex gap-4 items-center ': true, // layout
                    'transition-colors duration-300': true, // animation
                    'rounded-md p-2 mx-2': true, // self style
                  })}
                >
                  {item.icon} {item.label}
                </li>
              </Link>
            )
          })}
        </ul>
      </nav>
      {/* account  */}
      <div className="p-4 border-t border-t-indigo-800">
        <div className="flex items-center gap-4">
          <Image
            src={
              'https://images.unsplash.com/photo-1472099645785-5658abf4ff4e?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=facearea&facepad=2&w=256&h=256&q=80'
            }
            height={36}
            width={36}
            alt="profile image"
            className="rounded-full"
          />
          <div className="flex flex-col ">
            <span className="my-0 text-indigo-50">Tom Cook</span>
            <Link href="/" className="text-sm text-indigo-200">
              View Profile
            </Link>
          </div>
        </div>
      </div>
    </div>
  )
}
export default Sidebar
