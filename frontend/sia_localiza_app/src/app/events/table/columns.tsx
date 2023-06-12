'use client'

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
  },
  {
    accessorKey: 'day_period',
    header: 'Dia/Período',
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
