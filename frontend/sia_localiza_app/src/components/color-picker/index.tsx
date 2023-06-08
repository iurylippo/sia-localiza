import React, { useCallback, useRef, useState } from 'react'
import { HexColorPicker } from 'react-colorful'

import { useOnClickOutside } from 'usehooks-ts'

interface PopoverPickerProps {
  color: string
  onChange: (color: string) => void
}

// .swatch {
//   width: 28px;
//   height: 28px;
//   border-radius: 8px;
//   border: 3px solid #fff;
//   box-shadow: 0 0 0 1px rgba(0, 0, 0, 0.1), inset 0 0 0 1px rgba(0, 0, 0, 0.1);
//   cursor: pointer;
// }

// .popover {
//   position: absolute;
//   top: calc(100% + 2px);
//   left: 0;
//   border-radius: 9px;
//   box-shadow: 0 6px 12px rgba(0, 0, 0, 0.15);
// }

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
