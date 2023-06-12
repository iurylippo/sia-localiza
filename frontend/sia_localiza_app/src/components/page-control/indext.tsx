'use client'

interface PageControlProps {
  title: string
}

export function PageControl({ title }: PageControlProps) {
  return (
    <div className="container mx-auto mt-4 text-lg">
      <h1>{title}</h1>
    </div>
  )
}
