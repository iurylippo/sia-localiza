'use client'

import { Bars3Icon } from '@heroicons/react/24/outline'
import classNames from 'classnames'
type Props = {
  onMenuButtonClick(): void
}
const Navbar = (props: Props) => {
  return (
    <nav
      className={classNames({
        'bg-white text-zinc-500': true, // colors
        'flex items-center': true, // layout
        'w-full fixed z-10 px-4 shadow-sm h-16': true, // positioning & styling
      })}
    >
      <div className="text-lg font-bold">My Logo</div>
      <div className="flex-grow"></div> {/** spacer */}
      <button className="md:hidden" onClick={props.onMenuButtonClick}>
        <Bars3Icon className="w-6 h-6" />
      </button>
    </nav>
  )
}
export default Navbar
