CREATE TABLE IF NOT EXISTS campus_events(
    "id" UUID NOT NULL,
    "event_id" UUID NOT NULL,
    "description" TEXT,
    "professor_id" UUID NOT NULL,
    "subject_id" UUID NOT NULL,
    "class" VARCHAR NOT NULL,
    "created_at" TIMESTAMP(6) NOT NULL DEFAULT CURRENT_TIMESTAMP,
    "updated_at" TIMESTAMP(6) NOT NULL DEFAULT CURRENT_TIMESTAMP,

    CONSTRAINT "campus_events_pkey" PRIMARY KEY ("id")
);