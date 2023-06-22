-- CreateIndex
CREATE UNIQUE INDEX "campus_events_event_id_professor_id_subject_id_class_code_key" ON "campus_events"("event_id", "professor_id", "subject_id", "class");

-- AddForeignKey
ALTER TABLE "campus_events" ADD CONSTRAINT "campus_events_event_id_fkey" FOREIGN KEY ("event_id") REFERENCES "events"("id") ON DELETE CASCADE ON UPDATE CASCADE;
ALTER TABLE "campus_events" ADD CONSTRAINT "campus_events_professor_id_fkey" FOREIGN KEY ("professor_id") REFERENCES "professors"("id") ON DELETE CASCADE ON UPDATE CASCADE;
ALTER TABLE "campus_events" ADD CONSTRAINT "campus_events_subject_id_fkey" FOREIGN KEY ("subject_id") REFERENCES "subjects"("id") ON DELETE CASCADE ON UPDATE CASCADE;