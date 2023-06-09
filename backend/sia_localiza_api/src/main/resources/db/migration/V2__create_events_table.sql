CREATE TYPE "DayWeek" AS ENUM ('segunda', 'terca', 'quarta', 'quinta', 'sexta', 'sabado', 'domingo');

CREATE TYPE "DayPeriod" AS ENUM ('manha', 'tarde', 'noite');

CREATE TABLE IF NOT EXISTS events(
    "id" UUID NOT NULL,
    "summary" VARCHAR NOT NULL,
    "description" TEXT,
    "day_week" "DayWeek" NOT NULL,
    "day_period" "DayPeriod" NOT NULL,
    "start_at" TIME NOT NULL,
    "end_at" TIME NOT NULL,
    "created_at" TIMESTAMP(6) NOT NULL DEFAULT CURRENT_TIMESTAMP,
    "updated_at" TIMESTAMP(6) NOT NULL DEFAULT CURRENT_TIMESTAMP,

    CONSTRAINT "events_pkey" PRIMARY KEY ("id")
);

-- CreateIndex
CREATE UNIQUE INDEX "events_summary_key" ON "events"("summary");