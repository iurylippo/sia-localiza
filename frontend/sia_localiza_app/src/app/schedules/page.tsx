'use client'
import { PageControl } from '@/components/page-control/indext'
import dynamic from 'next/dynamic'
import { ComponentProps } from 'react'

const CalendComponent = dynamic(
  () => {
    return import('@/components/calendar')
  },
  { ssr: false },
)

const wrapper: ComponentProps<'div'>['className'] =
  'flex flex-col w-full h-screen'

const calendarWrapper =
  'flex w-full h-full sm:max-h-[70%] md:max-h-[80%] max-w-[850px] border mx-auto rounded-md justify-center items-center bg-white flex-col'

export default function Shedules(props?: any) {
  return (
    <div>
      <PageControl title="Agenda" />
      <div className={wrapper}>
        <div className={calendarWrapper}>
          <CalendComponent isDark={false} />
        </div>
      </div>
    </div>
  )
}
