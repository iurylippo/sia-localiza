'use client'

import { cellDates } from '@/common/table/cell-dates'
import { Professor } from '@/models/professors'
import { ColumnDef } from '@tanstack/react-table'

export const columns: ColumnDef<Professor>[] = [
  // {
  //   accessorKey: 'id',
  //   header: '#',
  // },
  {
    accessorKey: 'code',
    header: 'Código',
  },
  {
    accessorKey: 'name',
    header: 'Nome',
  },
  {
    accessorKey: 'description',
    header: 'Descrição',
  },
  ...cellDates,
]
