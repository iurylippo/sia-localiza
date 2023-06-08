'use client'
import React, { useEffect, useState } from 'react'
import { DateTime } from 'luxon'
import Kalend, { CalendarView, KalendProps, OnEventDragFinish } from 'kalend'
import { generateDemoEvents } from './helpers'
import { NewEventClickData } from 'kalend/common/interface'
import { EventModal } from '../event-modal'

const CalendComponent = (props: KalendProps) => {
  const [openCreateEventModal, setOpenCreateEventModal] = useState(false)
  const [demoEvents, setDemoEvents] = useState([])
  const [newEventData, setNewEventData] = useState<NewEventClickData>()

  // Create and load demo events
  useEffect(() => {
    setDemoEvents(generateDemoEvents(DateTime.now(), 80))
  }, [])

  const handleCreateEventModalClose = () => setOpenCreateEventModal(false)

  const onNewEventClick = (data: NewEventClickData) => {
    setNewEventData(data)
    console.log(data)
  }

  // Callback for event click
  const onEventClick = (data: KalendProps) => {
    const msg = `Click on event action\n\n Callback data:\n\n${JSON.stringify(
      data,
    )}`
    console.log(msg)
  }

  // Callback after dragging is finished
  const onEventDragFinish: OnEventDragFinish = (
    prev: any,
    current: any,
    data: any,
  ) => {
    setDemoEvents(data)
  }

  useEffect(() => {
    if (newEventData) {
      setOpenCreateEventModal(true)
    }
  }, [newEventData])

  return (
    <>
      <EventModal
        isModalOpen={openCreateEventModal}
        onModalClose={() => handleCreateEventModalClose}
        type="create"
        newEventData={newEventData}
      />

      <Kalend
        {...props}
        kalendRef={props.kalendRef}
        onNewEventClick={onNewEventClick}
        initialView={CalendarView.WEEK}
        disabledViews={[]}
        onEventClick={onEventClick}
        events={demoEvents}
        initialDate={new Date().toISOString()}
        hourHeight={60}
        timeFormat="24"
        showWeekNumbers={true}
        timezone={'America/Recife'}
        // draggingDisabledConditions={{
        //   summary: 'Computers',
        //   allDay: false,
        //   color: 'pink',
        // }}
        onEventDragFinish={onEventDragFinish}
        onStateChange={props.onStateChange}
        selectedView={props.selectedView}
        showTimeLine={true}
        autoScroll={true}
        language="ptBR"
        // disabledDragging={true}
        colors={{
          light: {
            primaryColor: 'blue',
          },
          dark: {
            primaryColor: 'orange',
          },
        }}
      />
    </>
  )
}

export default CalendComponent
