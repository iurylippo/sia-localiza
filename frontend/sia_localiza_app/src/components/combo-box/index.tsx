'use client'

import { Check, ChevronsUpDown } from 'lucide-react'

import {
  Command,
  CommandEmpty,
  CommandGroup,
  CommandInput,
  CommandItem,
} from '@/components/layout/command'
import {
  Popover,
  PopoverContent,
  PopoverTrigger,
} from '@/components/layout/popover'
import { useEffect, useState } from 'react'
import { Button } from '../layout/button'
import { cn } from '@/utils'

export interface ComboBoxOption {
  label: string
  value: string
}

interface ComboBoxProps {
  defaultValue?: string
  options: ComboBoxOption[]
  onSelect: (value: string) => void
  emptyLabel: string
}

export function ComboBox({
  defaultValue = '',
  emptyLabel,
  options = [],
  onSelect,
}: ComboBoxProps) {
  const [open, setOpen] = useState(false)
  const [selected, setSelected] = useState<ComboBoxOption | null>(null)

  useEffect(() => {
    if (selected === null && defaultValue !== '') {
      setSelected(
        options.find(
          (o) =>
            o.value === defaultValue || o.label.toLowerCase() === defaultValue,
        ) || null,
      )
    }
  }, [])

  const handleCommandSelect = (currentValue: string) => {
    if (
      currentValue === selected?.value ||
      currentValue === selected?.label?.toLocaleLowerCase()
    ) {
      setSelected(null)
      return
    }

    const optionFound = options.find(
      (o) => o.value === currentValue || o.label.toLowerCase() === currentValue,
    )
    console.log('optionFound', optionFound)
    if (optionFound) {
      setSelected(optionFound)
    }
  }

  useEffect(() => {
    console.log('value', selected)
    if (selected && selected?.value !== '') {
      onSelect(selected.value)
    }
  }, [selected])

  return (
    <Popover open={open} onOpenChange={setOpen}>
      <PopoverTrigger asChild>
        <Button
          variant="outline"
          role="combobox"
          aria-expanded={open}
          className="w-[200px] justify-between"
        >
          {selected?.label || emptyLabel}
          <ChevronsUpDown className="w-4 h-4 ml-2 opacity-50 shrink-0" />
        </Button>
      </PopoverTrigger>
      <PopoverContent className="w-[200px] p-0">
        <Command>
          <CommandInput placeholder={emptyLabel} />
          <CommandEmpty>Sem dados...</CommandEmpty>
          <CommandGroup>
            {options.map((option) => (
              <CommandItem
                key={option.value}
                onSelect={(currentValue) => {
                  handleCommandSelect(currentValue)
                  setOpen(false)
                }}
              >
                <Check
                  className={cn(
                    'mr-2 h-4 w-4',
                    selected?.value === option.value
                      ? 'opacity-100'
                      : 'opacity-0',
                  )}
                />
                {option.label}
              </CommandItem>
            ))}
          </CommandGroup>
        </Command>
      </PopoverContent>
    </Popover>
  )
}
