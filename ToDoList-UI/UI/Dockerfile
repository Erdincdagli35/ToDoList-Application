FROM node:14 AS todolist-frontend
WORKDIR /app
COPY . .
RUN npm --clean install
RUN npm run build --prod

# Stage 2
FROM nginx:stable-alpine
RUN rm /etc/nginx/conf.d/default.conf
COPY nginx.conf /etc/nginx/conf.d

COPY --from=todolist-frontend /app/dist /usr/share/nginx/html
EXPOSE 80
CMD ["nginx", "-g", "daemon off;"]
