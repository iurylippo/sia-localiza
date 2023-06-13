'use client'

import { DataTable } from '@/components/data-table'
import { useEffect, useState } from 'react'
import { cellActions } from '@/common/table/cell-actions'
import { API } from '../../services/api/axios'
import { PageControl } from '@/components/page-control/indext'
import { columns } from './table/columns'
import { Event } from '@/models/events'
import { toast } from '@/components/layout/use-toast'
import { EventModal } from '@/components/event-modal'

export default function Events() {
  const [data, setData] = useState<Event[]>([])
  const [isEventCreateUpdateModalOpen, setIsEventCreateUpdateModalOpen] =
    useState(false)
  const [isLoading, setIsLoading] = useState(false)
  const [currentEventUpdate, setCurrentEventUpdate] = useState<Event>()

  const handleCloseCreateUpdateModal = async () => {
    setIsEventCreateUpdateModalOpen(false)
    await loadEventsData()
  }

  const loadEventsData = async () => {
    try {
      setIsLoading(true)
      const response = await API.get<Event[]>('/events')
      setData(response.data)
      setIsLoading(false)
    } catch (err: any) {
      toast({
        title: 'Houve algum problema!',
      })
    }
  }

  const handleEventsDelete = async (id: string) => {
    try {
      setIsLoading(true)

      await API.delete(`/events/${id}`)

      setIsLoading(false)
      toast({
        title: 'Removido com sucesso!',
        variant: 'sucess',
      })
    } catch (err: any) {
      toast({
        title: 'Houve algum problema!',
        variant: 'destructive',
      })
    }
  }

  const handleUpdate = (model: Event) => {
    setCurrentEventUpdate(model)
    setIsEventCreateUpdateModalOpen(true)
  }

  const handleDelete = async (id: string) => {
    await handleEventsDelete(id)
    await loadEventsData()
  }

  const cols = [
    ...columns,
    cellActions<Event>({
      onClickUpdate: (model) => handleUpdate(model),
      onClickDelete: (id) => handleDelete(id),
    }),
  ]

  useEffect(() => {
    const loadData = loadEventsData
    loadData()
  }, [])

  return (
    <div>
      <PageControl
        title="Eventos"
        createButtonAction={() => {
          setCurrentEventUpdate(undefined)
          setIsEventCreateUpdateModalOpen(true)
        }}
      />
      <EventModal
        isModalOpen={isEventCreateUpdateModalOpen}
        onModalClose={handleCloseCreateUpdateModal}
        data={currentEventUpdate}
        type={currentEventUpdate ? 'update' : 'create'}
      />
      <div className="container py-10 mx-auto">
        <DataTable columns={cols} data={data} isLoading={isLoading} />
      </div>
    </div>
  )
}
