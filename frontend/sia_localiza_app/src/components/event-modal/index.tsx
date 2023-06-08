'use client'
import { NewEventClickData } from 'kalend/common/interface'
import { useForm } from 'react-hook-form'
import { Modal } from 'react-responsive-modal'
import { zodResolver } from '@hookform/resolvers/zod'
import { Button } from '@/components/layout/button'
import {
  Select,
  SelectContent,
  SelectItem,
  SelectTrigger,
  SelectValue,
} from '@/components/layout/select'
import { toast } from '@/components/layout/use-toast'

import z from 'zod'
import {
  FormField,
  FormItem,
  FormLabel,
  FormControl,
  FormMessage,
  Form,
} from '@/components/layout/form'
import { professorsFake } from '@/@seed/data-fake/professors'
import { formatDateDay, formatDateHour } from '@/utils'
import { subjectsFake } from '@/@seed/data-fake/subjects'
import { PopoverPicker } from '../color-picker'

interface ClassModalProps {
  name?: string
  isModalOpen?: boolean
  onModalClose: () => void
  newEventData?: NewEventClickData
  type: 'create' | 'update'
}

const modalstyles = {
  modal: {
    width: '20rem',
  },
}

const FormSchema = z.object({
  professor_id: z.string({
    required_error: 'Por favor selecione um professor.',
  }),
  subject_id: z.string({
    required_error: 'Por favor selecione uma disciplina.',
  }),
  color: z.string({
    required_error: 'Por favor selecione uma cor.',
  }),
})

export function EventModal({
  name = 'Aula',
  type = 'create',
  isModalOpen = false,
  onModalClose,
  newEventData,
}: ClassModalProps) {
  const form = useForm<z.infer<typeof FormSchema>>({
    resolver: zodResolver(FormSchema),
  })

  const getTitle = () => {
    return type === 'create' ? 'Criar evento' : 'Alterar evento'
  }

  function onSubmit(data: z.infer<typeof FormSchema>) {
    console.log('opa', data)
    toast({
      title: 'You submitted the following values:',
      description: (
        <pre className="mt-2 w-[340px] rounded-md bg-slate-950 p-4">
          <code className="text-white">{JSON.stringify(data, null, 2)}</code>
        </pre>
      ),
    })
  }

  return (
    <Modal
      styles={modalstyles}
      open={isModalOpen}
      onClose={onModalClose}
      center
    >
      <h2 className="mb-2 text-center">{getTitle()}</h2>
      <div className="text-title">
        <div className="flex flex-col gap-1 mb-5 text-sm">
          <div>
            <label className="font-bold">Evento:</label>
            <span> {name}</span>
          </div>
          <div>
            <label className="font-bold">Dia:</label>
            <span> {formatDateDay(newEventData?.day ?? '')}</span>
          </div>
          <div>
            <label className="font-bold">Horário início:</label>
            <span> {formatDateHour(newEventData?.startAt ?? '')}</span>
          </div>
          <div>
            <label className="font-bold">Horário fim:</label>
            <span> {formatDateHour(newEventData?.endAt ?? '')}</span>
          </div>
        </div>

        <div>
          <Form {...form}>
            <form
              onSubmit={form.handleSubmit(onSubmit)}
              className="flex flex-col w-full space-y-3"
            >
              <FormField
                control={form.control}
                name="color"
                render={({ field }) => (
                  <FormItem>
                    <FormLabel>Cor:</FormLabel>

                    <PopoverPicker
                      color={field.value}
                      onChange={field.onChange}
                    />

                    <FormMessage />
                  </FormItem>
                )}
              />

              <FormField
                control={form.control}
                name="professor_id"
                render={({ field }) => (
                  <FormItem>
                    <FormLabel>Professor:</FormLabel>
                    <Select
                      onValueChange={field.onChange}
                      defaultValue={field.value}
                    >
                      <FormControl className="min-w-full">
                        <SelectTrigger>
                          <SelectValue placeholder="Selecionar um(a) professor(a)..." />
                        </SelectTrigger>
                      </FormControl>
                      <SelectContent>
                        {professorsFake.map((p) => (
                          <SelectItem key={p.id} value={p.id}>
                            {p.name}
                          </SelectItem>
                        ))}
                      </SelectContent>
                    </Select>
                    <FormMessage />
                  </FormItem>
                )}
              />
              <FormField
                control={form.control}
                name="subject_id"
                render={({ field }) => (
                  <FormItem>
                    <FormLabel>Disciplina:</FormLabel>
                    <Select
                      onValueChange={field.onChange}
                      defaultValue={field.value}
                    >
                      <FormControl className="min-w-full">
                        <SelectTrigger>
                          <SelectValue placeholder="Selecionar uma disciplina..." />
                        </SelectTrigger>
                      </FormControl>
                      <SelectContent>
                        {subjectsFake.map((p) => (
                          <SelectItem key={p.id} value={p.id}>
                            {p.name}
                          </SelectItem>
                        ))}
                      </SelectContent>
                    </Select>
                    <FormMessage />
                  </FormItem>
                )}
              />
              <Button className="mt-20" type="submit">
                Submit
              </Button>
            </form>
          </Form>
        </div>
      </div>
    </Modal>
  )
}
