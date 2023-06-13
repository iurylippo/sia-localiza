'use client'
import { CampusEvent } from '@/models/campus-event'
import { Modal } from 'react-responsive-modal'

interface ClassModalProps {
  title: string
  isModalOpen: boolean
  onModalClose: () => void
  data?: CampusEvent
}

export function ClassModal({
  title,
  isModalOpen,
  onModalClose,
  data,
}: ClassModalProps) {
  return (
    <Modal open={isModalOpen} onClose={onModalClose} center>
      <div className="flex flex-col p-4 border rounded text-title">
        <h2 className="text-lg">{title}</h2>
        <div className="flex flex-col mb-3">
          <div className="flex gap-2">
            <span className="font-bold">Dia/Semana:</span>
            <span>{data?.event.day_week}</span>
          </div>
          <div className="flex gap-2">
            <span className="font-bold">Dia/Turno:</span>
            <span>{data?.event.day_period}</span>
          </div>
        </div>
        <div className="flex flex-col">
          <div className="flex gap-2">
            <span className="font-bold">Professor:</span>
            <span>{data?.professor.name}</span>
          </div>
          <div className="flex gap-2">
            <span className="font-bold">Disciplina:</span>
            <span>{data?.subject.name}</span>
          </div>
          <div className="flex gap-2">
            <span className="font-bold">Hora/Início:</span>
            <span>{data?.event.start_at}</span>
          </div>
          <div className="flex gap-2">
            <span className="font-bold">Hora/Fim:</span>
            <span>{data?.event.end_at}</span>
          </div>
        </div>
      </div>
    </Modal>
  )
}
