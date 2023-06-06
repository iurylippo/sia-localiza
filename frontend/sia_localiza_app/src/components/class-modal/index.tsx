'use client'
import { Modal } from 'react-responsive-modal'

interface ClassModalProps {
  title: string
  isModalOpen: boolean
  onModalClose: () => void
  campusFloor: any
}

export function ClassModal({
  title,
  isModalOpen,
  onModalClose,
  campusFloor,
}: ClassModalProps) {
  return (
    <Modal open={isModalOpen} onClose={onModalClose} center>
      <h2>{title}</h2>
      <div>
        <span>Professor:</span>
        <span>Horario:</span>
        <span>dia:</span>
      </div>
    </Modal>
  )
}
