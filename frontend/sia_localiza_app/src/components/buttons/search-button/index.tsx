import { Button } from '@/components/layout/button'
import { SearchIcon } from 'lucide-react'

interface SearchButtonProps {
  title?: string
  onClick?: () => void
}

export function SearchButton({ title, onClick }: SearchButtonProps) {
  return (
    <Button size="sm" onClick={onClick}>
      <SearchIcon size={20} />
      {title && <span className="ml-2">{title}</span>}
    </Button>
  )
}
