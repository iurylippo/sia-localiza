DROP INDEX "events_summary_key";

-- CreateIndex
CREATE UNIQUE INDEX "events_summary_day_week_day_period_start_at_end_at_key" ON "events"("summary", "day_week", "day_period", "start_at", "end_at");
