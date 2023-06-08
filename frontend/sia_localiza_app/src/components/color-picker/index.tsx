import React, { useCallback, useRef, useState } from 'react'
import { HexColorPicker } from 'react-colorful'

import { useOnClickOutside } from 'usehooks-ts'

interface PopoverPickerProps {
  color: string
  onChange: (color: string) => void
}

export const PopoverPicker = ({ color, onChange }: PopoverPickerProps) => {
  const popover = useRef<HTMLDivElement>(null)
  const [isOpen, toggle] = useState(false)

  const close = useCallback(() => toggle(false), [])
  useOnClickOutside(popover, close)

  return (
    <div className="relative">
      <div
        className="w-6 h-6 border rounded-sm shadow-sm cursor-pointer"
        style={{ backgroundColor: color }}
        onClick={() => toggle(true)}
      />

      {isOpen && (
        <div
          className="absolute top-[calc(100% + 2px)] left-0 rounded-sm shadow-sm"
          ref={popover}
        >
          <HexColorPicker color={color} onChange={onChange} />
        </div>
      )}
    </div>
  )
}
