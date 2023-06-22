create table if not exists tokens(
    "id" UUID NOT NULL,
    "token" VARCHAR NOT NULL,
    "type" VARCHAR NOT NULL,
    "revoked" BOOLEAN NOT NULL DEFAULT FALSE,
    "expired" BOOLEAN NOT NULL DEFAULT FALSE,
    "user_id" UUID NOT NULL,
    "created_at" TIMESTAMP(6) NOT NULL DEFAULT CURRENT_TIMESTAMP,
    "updated_at" TIMESTAMP(6) NOT NULL DEFAULT CURRENT_TIMESTAMP,

    CONSTRAINT "tokens_pkey" PRIMARY KEY ("id")
);

-- CreateIndex
CREATE UNIQUE INDEX "tokens_token_type_user_id_key" ON "tokens"("token","type","user_id");

-- AddForeignKey
ALTER TABLE "tokens" ADD CONSTRAINT "tokens_user_id_fkey" FOREIGN KEY ("user_id") REFERENCES "users"("id") ON DELETE CASCADE ON UPDATE CASCADE;