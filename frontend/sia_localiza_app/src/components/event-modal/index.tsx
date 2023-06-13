'use client'
import { useForm } from 'react-hook-form'
import { Modal } from 'react-responsive-modal'
import { zodResolver } from '@hookform/resolvers/zod'
import { Button } from '@/components/layout/button'

import { toast } from '@/components/layout/use-toast'
import { PaletteIcon, Trash2Icon } from 'lucide-react'

import z from 'zod'
import {
  FormField,
  FormItem,
  FormLabel,
  FormMessage,
  Form,
} from '@/components/layout/form'
import { blockColors } from './styles'
import { Event } from '@/models/events'
import { useEffect, useState } from 'react'
import { Input } from '../layout/input'
import { ComboBox } from '../combo-box'
import { weekDays, weekPeriods } from '@/common/constants'
import { PopoverPicker } from '../color-picker'
import { API } from '@/services/api/axios'
import { AxiosError, HttpStatusCode } from 'axios'

interface ClassModalProps {
  name?: string
  isModalOpen: boolean
  onModalClose: () => void
  data?: Event
  type: 'create' | 'update'
}

const modalstyles = {
  modal: {
    width: '20rem',
  },
}

const FormSchema = z.object({
  summary: z.string({
    required_error: 'Por favor preencha o nome do evento.',
  }),
  day_week: z.string({
    required_error: 'Por favor selecione Dia/Semana.',
  }),
  day_period: z.string({
    required_error: 'Por favor selecione Dia/Período.',
  }),
  start_at: z.string({
    required_error: 'Por favor selecione Hora/Início.',
  }),
  end_at: z.string({
    required_error: 'Por favor selecione Hora/Fim.',
  }),
  color: z
    .string({
      required_error: 'Por favor selecione uma cor.',
    })
    .optional(),
})

export function EventModal({
  name = 'Aula',
  type = 'create',
  isModalOpen,
  onModalClose,
  data,
}: ClassModalProps) {
  const [isModalOpenIntern, setIsModalOpenIntern] = useState(false)

  const form = useForm<z.infer<typeof FormSchema>>({
    resolver: zodResolver(FormSchema),
    defaultValues: {
      summary: data?.summary,
      day_week: data?.day_week,
      day_period: data?.day_period,
      start_at: data?.start_at,
      end_at: data?.end_at,
      color: data?.color,
    },
  })

  useEffect(() => {
    setIsModalOpenIntern(isModalOpen)
  }, [isModalOpen])

  useEffect(() => {
    if (type === 'update') {
      if (data?.summary) {
        form.setValue('summary', data.summary)
      }
      if (data?.color) {
        form.setValue('color', data.color)
      }
      if (data?.day_week) {
        form.setValue('day_week', data.day_week)
      }
      if (data?.day_period) {
        form.setValue('day_period', data.day_period)
      }
      if (data?.start_at) {
        form.setValue('end_at', data.start_at)
      }
      if (data?.end_at) {
        form.setValue('end_at', data.end_at)
      }
    }

    if (type === 'create') {
      form.reset()
      form.setValue('summary', 'Aula')
    }
  }, [data])

  const getTitle = () => {
    return type === 'create' ? 'Criar evento' : 'Alterar evento'
  }

  async function create(formData: z.infer<typeof FormSchema>) {
    try {
      await API.post('events', formData)
      toast({
        title: 'Evento criado com sucesso!',
        variant: 'sucess',
      })
      setIsModalOpenIntern(false)
      onModalClose()
    } catch (err: any) {
      if (err) {
        const erroAxios = err as AxiosError<{ message: string }>
        console.log(erroAxios)
        if (
          erroAxios?.response?.status === HttpStatusCode.BadRequest &&
          erroAxios?.response?.data?.message
        ) {
          const messageError = err.response.data.message as string
          if (messageError) {
            toast({
              title: messageError,
              variant: 'destructive',
            })
            return
          }
        }
      }
      toast({
        title: 'Houve algum problema!',
        variant: 'destructive',
      })
    }
  }

  async function update(formData: Event) {
    try {
      await API.put(`events/${data?.id}`, formData)
      toast({
        title: 'Evento alterado com sucesso!',
        variant: 'sucess',
      })
      setIsModalOpenIntern(false)
      onModalClose()
    } catch (err: any) {
      if (err) {
        const erroAxios = err as AxiosError<{ message: string }>
        console.log(erroAxios)
        if (
          erroAxios?.response?.status === HttpStatusCode.BadRequest &&
          erroAxios?.response?.data?.message
        ) {
          const messageError = err.response.data.message as string
          if (messageError) {
            toast({
              title: messageError,
              variant: 'destructive',
            })
            return
          }
        }
      }
      toast({
        title: 'Houve algum problema!',
        variant: 'destructive',
      })
    }
  }

  async function onSubmit(data: z.infer<typeof FormSchema>) {
    if (type === 'create') {
      await create(data)
    }
    if (type === 'update') {
      await update(data as Event)
    }
  }

  return (
    <Modal
      styles={modalstyles}
      open={isModalOpenIntern}
      onClose={onModalClose}
      center
    >
      <h2 className="mb-2 text-center">{getTitle()}</h2>
      <div className="text-title">
        <div className="flex flex-col gap-1 mb-5 text-sm">
          {type === 'update' && (
            <div>
              <Trash2Icon
                className="cursor-pointer"
                color="var(--color-danger)"
              />
            </div>
          )}
        </div>
        <div>
          <Form {...form}>
            <form
              onSubmit={form.handleSubmit(onSubmit)}
              className="flex flex-col w-full p-4 space-y-3 border rounded"
            >
              <FormField
                control={form.control}
                name="summary"
                render={({ field }) => (
                  <FormItem>
                    <FormLabel>Evento:</FormLabel>
                    <Input
                      defaultValue={field.value}
                      onChange={field.onChange}
                    />
                    <FormMessage />
                  </FormItem>
                )}
              />

              <FormField
                control={form.control}
                name="day_week"
                render={({ field }) => (
                  <FormItem>
                    <FormLabel>Dia/Semana:</FormLabel>
                    <ComboBox
                      defaultValue={data?.day_week}
                      emptyLabel="dia/semana..."
                      options={weekDays.PT.map((w) => ({
                        label: w.name,
                        value: w.value,
                      }))}
                      onSelect={field.onChange}
                    />
                    <FormMessage />
                  </FormItem>
                )}
              />
              <FormField
                control={form.control}
                name="day_period"
                render={({ field }) => (
                  <FormItem>
                    <FormLabel>Dia/Período:</FormLabel>
                    <ComboBox
                      defaultValue={data?.day_period}
                      emptyLabel="dia/período..."
                      options={weekPeriods.PT.map((w) => ({
                        label: w.name,
                        value: w.value,
                      }))}
                      onSelect={field.onChange}
                    />
                    <FormMessage />
                  </FormItem>
                )}
              />
              <FormField
                control={form.control}
                name="start_at"
                render={({ field }) => (
                  <FormItem>
                    <FormLabel>Hora/Início:</FormLabel>
                    <Input
                      onChange={field.onChange}
                      defaultValue={field.value}
                    />
                    <FormMessage />
                  </FormItem>
                )}
              />
              <FormField
                control={form.control}
                name="end_at"
                render={({ field }) => (
                  <FormItem>
                    <FormLabel>Hora/Fim:</FormLabel>
                    <Input
                      onChange={field.onChange}
                      defaultValue={field.value}
                    />
                    <FormMessage />
                  </FormItem>
                )}
              />
              <FormField
                control={form.control}
                name="color"
                render={({ field }) => (
                  <FormItem>
                    <FormLabel>Cor:</FormLabel>
                    <div className="flex gap-1">
                      <PopoverPicker
                        color={field.value || '#fff'}
                        onChange={field.onChange}
                      />
                      <PaletteIcon />
                    </div>
                    <div className="flex flex-wrap justify-start gap-1">
                      {blockColors.map(({ styles, color }) => (
                        <div
                          onClick={() => form.setValue('color', color)}
                          key={color}
                          style={{ backgroundColor: color }}
                          className={`${styles}`}
                        ></div>
                      ))}
                    </div>
                    <FormMessage />
                  </FormItem>
                )}
              />
              <Button type="submit">Salvar</Button>
            </form>
          </Form>
        </div>
      </div>
    </Modal>
  )
}
