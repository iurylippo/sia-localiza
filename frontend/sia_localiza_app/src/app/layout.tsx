import { ReactNode } from 'react'
import { Inter } from 'next/font/google'
import './globals.css'
import 'react-responsive-modal/styles.css'
import 'kalend/dist/styles/index.css'
import 'react-loading-skeleton/dist/skeleton.css'
import dynamic from 'next/dynamic'
const inter = Inter({ subsets: ['latin'] })

export const metadata = {
  title: 'Create Next App',
  description: 'Generated by create next app',
}

const LayoutComponent = dynamic(
  () => {
    return import('@/components/layout/layout')
  },
  { ssr: false },
)

export default function RootLayout({ children }: { children: ReactNode }) {
  return (
    <html lang="pt-BR">
      {/* <body className={`${inter.className} overflow-y-hidden`}> */}
      <body className={inter.className}>
        <LayoutComponent>{children}</LayoutComponent>
      </body>
    </html>
  )
}
