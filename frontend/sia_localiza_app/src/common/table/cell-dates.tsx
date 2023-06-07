import { formatDate } from '@/utils'

function cellFormat(field: 'created_at' | 'updated_at') {
  return {
    cell: ({ row }: any) => {
      const date = row.getValue(field) as string
      const formatted = formatDate(date)

      return <div>{formatted}</div>
    },
  }
}

export const cellDates = [
  {
    accessorKey: 'created_at',
    header: 'Data criação',
    ...cellFormat('created_at'),
  },
  {
    accessorKey: 'updated_at',
    header: 'Data alteração',
    ...cellFormat('updated_at'),
  },
]
