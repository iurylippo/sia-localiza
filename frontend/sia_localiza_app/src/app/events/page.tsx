'use client'

import { DataTable } from '@/components/data-table'
import { useEffect, useState } from 'react'
import { cellActions } from '@/common/table/cell-actions'
import { API } from '../../services/api/axios'
import { PageControl } from '@/components/page-control/indext'
import { columns } from './table/columns'
import { Event } from '@/models/events'

export default function Events() {
  const [data, setData] = useState<Event[]>([])

  useEffect(() => {
    const loadData = async () => {
      const response = await API.get<Event[]>('/events')
      setData(response.data)
    }
    loadData()
  }, [])

  const handleUpdate = (model: Event) => {
    console.log('update', model)
  }

  const handleDelete = (id: string) => {
    console.log('delete', id)
  }

  const cols = [
    ...columns,
    cellActions<Event>({
      onClickUpdate: (model) => handleUpdate(model),
      onClickDelete: (id) => handleDelete(id),
    }),
  ]

  return (
    <div>
      <PageControl title="Eventos" />

      <div className="container py-10 mx-auto">
        <DataTable columns={cols} data={data} />
      </div>
    </div>
  )
}
