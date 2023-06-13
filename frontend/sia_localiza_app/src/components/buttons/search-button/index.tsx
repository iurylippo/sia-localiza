import { Button } from '@/components/layout/button'
import { SearchIcon } from 'lucide-react'

interface SearchButtonProps {
  title?: string
  onClick?: () => void
  isLoading?: boolean
}

export function SearchButton({
  title,
  onClick,
  isLoading = false,
}: SearchButtonProps) {
  return (
    <Button size="sm" onClick={onClick}>
      {isLoading ? (
        <svg
          version="1.1"
          id="loader-1"
          xmlns="http://www.w3.org/2000/svg"
          x="0px"
          y="0px"
          width="30px"
          height="30px"
          viewBox="0 0 50 50"
          xmlSpace="preserve"
        >
          <path
            fill="#fff"
            d="M25.251,6.461c-10.318,0-18.683,8.365-18.683,18.683h4.068c0-8.071,6.543-14.615,14.615-14.615V6.461z"
          >
            <animateTransform
              attributeType="xml"
              attributeName="transform"
              type="rotate"
              from="0 25 25"
              to="360 25 25"
              dur="0.6s"
              repeatCount="indefinite"
            />
          </path>
        </svg>
      ) : (
        <>
          <SearchIcon size={20} />
          {title && <span className="ml-2">{title}</span>}
        </>
      )}
    </Button>
  )
}
