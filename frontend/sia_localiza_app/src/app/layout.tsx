import { ReactNode } from 'react'
import { Inter } from 'next/font/google'
import './globals.css'
import 'react-responsive-modal/styles.css'
import Layout from '@/components/layout/layout'
const inter = Inter({ subsets: ['latin'] })

export const metadata = {
  title: 'Create Next App',
  description: 'Generated by create next app',
}

export default function RootLayout({ children }: { children: ReactNode }) {
  return (
    <html lang="pt-BR">
      {/* <body className={`${inter.className} overflow-y-hidden`}> */}
      <body className={inter.className}>
        <Layout>{children}</Layout>
      </body>
    </html>
  )
}
