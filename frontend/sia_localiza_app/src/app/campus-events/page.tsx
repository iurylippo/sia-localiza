'use client'

import { DataTable } from '@/components/data-table'
import { useEffect, useState } from 'react'
import { cellActions } from '@/common/table/cell-actions'
import { API } from '../../services/api/axios'
import { PageControl } from '@/components/page-control/indext'
import { columns } from './table/columns'
import { CampusEvent } from '@/models/campus-event'
import { toast } from '@/components/layout/use-toast'
import { CampusEventModal } from '@/components/campus-event-modal/indext'

export default function CampusEvents() {
  const [data, setData] = useState<CampusEvent[]>([])
  const [
    isCampusEventCreateUpdateModalOpen,
    setIsCampusEventCreateUpdateModalOpen,
  ] = useState(false)
  const [isLoading, setIsLoading] = useState(false)
  const [currentCampusEventUpdate, setCurrentCampusEventUpdate] =
    useState<CampusEvent>()

  const handleCloseCreateUpdateModal = async () => {
    setIsCampusEventCreateUpdateModalOpen(false)
    await loadCampusEventsData()
  }

  const loadCampusEventsData = async () => {
    try {
      console.log('consultado...')
      setIsLoading(true)
      const response = await API.get<CampusEvent[]>('/events/campus')
      setData(response.data)
      setIsLoading(false)
      console.log('consultou...')
    } catch (err: any) {
      toast({
        title: 'Houve algum problema!',
      })
    }
  }

  const handleCampusEventsDelete = async (id: string) => {
    try {
      setIsLoading(true)

      await API.delete(`/events/campus/${id}`)

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

  useEffect(() => {
    const loadData = loadCampusEventsData
    loadData()
  }, [])

  const handleUpdate = (model: CampusEvent) => {
    setCurrentCampusEventUpdate(model)
    setIsCampusEventCreateUpdateModalOpen(true)
  }

  const handleDelete = async (id: string) => {
    await handleCampusEventsDelete(id)
    await loadCampusEventsData()
  }

  const cols = [
    ...columns,
    cellActions<CampusEvent>({
      onClickUpdate: (model) => handleUpdate(model),
      onClickDelete: (id) => handleDelete(id),
    }),
  ]

  return (
    <div>
      <PageControl
        title="Campus Eventos"
        createButtonAction={() => {
          setCurrentCampusEventUpdate(undefined)
          setIsCampusEventCreateUpdateModalOpen(true)
        }}
      />
      <CampusEventModal
        isModalOpen={isCampusEventCreateUpdateModalOpen}
        onModalClose={handleCloseCreateUpdateModal}
        data={currentCampusEventUpdate}
        type={currentCampusEventUpdate ? 'update' : 'create'}
      />
      <div className="container py-10 mx-auto">
        <DataTable columns={cols} data={data} isLoading={isLoading} />
      </div>
    </div>
  )
}
