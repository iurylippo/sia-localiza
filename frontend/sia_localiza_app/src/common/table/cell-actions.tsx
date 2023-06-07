'use client'
import { Button } from '@/components/layout/button'
import {
  DropdownMenu,
  DropdownMenuContent,
  DropdownMenuItem,
  DropdownMenuLabel,
  DropdownMenuSeparator,
  DropdownMenuTrigger,
} from '@/components/layout/dropdown-menu'
import { LucideEdit, LucideTrash2, MoreHorizontal } from 'lucide-react'

export function cellActions<Model extends { id: string }>({
  onClickUpdate,
  onClickDelete,
}: {
  onClickUpdate: (model: Model) => void
  onClickDelete: (id: string) => void
}) {
  return {
    id: 'actions',
    header: 'Ações',
    cell: ({ row }: any) => {
      const current = row.original as Model

      return (
        <DropdownMenu>
          <DropdownMenuTrigger asChild>
            <Button variant="ghost" className="w-8 h-8 p-0">
              <MoreHorizontal className="w-4 h-4" />
            </Button>
          </DropdownMenuTrigger>
          <DropdownMenuContent align="end">
            <DropdownMenuLabel>Ações</DropdownMenuLabel>
            <DropdownMenuSeparator />
            <DropdownMenuItem
              className="flex items-center justify-start"
              onClick={() => onClickUpdate(current)}
            >
              <div className="flex items-center justify-start w-5 h-5">
                <LucideEdit color="var(--color-alert)" size={15} />
              </div>
              <span className="ml-2">Editar</span>
            </DropdownMenuItem>
            <DropdownMenuItem
              className="flex items-center justify-start"
              onClick={() => onClickDelete(current?.id)}
            >
              <div className="flex items-center justify-start w-5 h-5">
                <LucideTrash2 color="var(--color-danger)" size={18} />
              </div>
              <span className="ml-2">Excluir</span>
            </DropdownMenuItem>
          </DropdownMenuContent>
        </DropdownMenu>
      )
    },
  }
}
