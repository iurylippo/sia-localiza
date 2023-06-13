'use client'

import { weekDays, weekPeriods } from '@/common/constants'
import { cellDates } from '@/common/table/cell-dates'
import { Event } from '@/models/events'
import { ColumnDef } from '@tanstack/react-table'

export const columns: ColumnDef<Event>[] = [
  {
    accessorKey: 'summary',
    header: 'Título',
  },
  {
    accessorKey: 'description',
    header: 'Descrição',
  },
  {
    accessorKey: 'day_week',
    header: 'Dia/Semana',
    accessorFn: (e) => {
      const dayWeek = weekDays.PT.find((w) => w.value === e.day_week)
      if (dayWeek) {
        return dayWeek.name
      }

      return e.day_week
    },
  },
  {
    accessorKey: 'day_period',
    header: 'Dia/Período',
    accessorFn: (e) => {
      const dayPeriod = weekPeriods.PT.find((w) => w.value === e.day_period)
      if (dayPeriod) {
        return dayPeriod.name
      }

      return e.day_period
    },
  },
  {
    accessorKey: 'start_at',
    header: 'Hora/Inicio',
  },
  {
    accessorKey: 'end_at',
    header: 'Hora/Fim',
  },
  ...cellDates,
]
