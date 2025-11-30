# syntax=docker/dockerfile:1

FROM node:24-trixie-slim AS builder
RUN corepack enable
WORKDIR /app
COPY package.json pnpm-lock.yaml ./
RUN --mount=type=cache,id=pnpm,target=/root/.local/share/pnpm/store \
    pnpm i --frozen-lockfile
COPY . .
RUN pnpm build

FROM nginx:1.28-alpine-slim
COPY --from=builder /app/dist /usr/share/nginx/html