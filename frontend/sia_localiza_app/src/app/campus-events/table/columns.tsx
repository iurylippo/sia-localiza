'use client'

import { weekDays, weekPeriods } from '@/common/constants'
import { cellDates } from '@/common/table/cell-dates'
import { CampusEvent } from '@/models/campus-event'
import { ColumnDef } from '@tanstack/react-table'

export const columns: ColumnDef<CampusEvent>[] = [
  {
    accessorKey: 'event',
    header: 'Evento',
    accessorFn: (e) => e.event.summary,
  },
  {
    accessorKey: 'event_day_week',
    header: 'Dia/Semana',
    accessorFn: (e) => {
      const dayWeek = weekDays.PT.find((w) => w.value === e.event.day_week)
      if (dayWeek) {
        return dayWeek.name
      }

      return e.event.day_week
    },
  },
  {
    accessorKey: 'event_day_period',
    header: 'Dia/Período',
    accessorFn: (e) => {
      const dayPeriod = weekPeriods.PT.find(
        (w) => w.value === e.event.day_period,
      )
      if (dayPeriod) {
        return dayPeriod.name
      }

      return e.event.day_period
    },
  },
  {
    accessorKey: 'event_start_at',
    header: 'Hora/Inicio',
    accessorFn: (e) => e.event.start_at,
  },
  {
    accessorKey: 'event_end_at',
    header: 'Hora/Fim',
    accessorFn: (e) => e.event.end_at,
  },
  {
    accessorKey: 'professor',
    header: 'Professor',
    accessorFn: (e) => e.professor.name,
  },
  {
    accessorKey: 'subject',
    header: 'Disciplina',
    accessorFn: (e) => e.subject.name,
  },
  {
    accessorKey: 'class',
    header: 'Classe',
    accessorFn: (e) => e.class,
  },
  ...cellDates,
]
