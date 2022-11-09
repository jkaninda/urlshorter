## 

# URL Shorter

Simple web URL Shorter built with Spring boot and AlpineJs
### Screenshots

<img src="https://raw.githubusercontent.com/jkaninda/urlshorter/main/screenshots/screenshot.png"/>
<br>
<br>

## Simple docker-compose 

````yml
version: "3.7"
services:

  db:
    image: postgres:14.5
    container_name: db
    pull_policy: if_not_present
    restart: unless-stopped
    volumes:
      - ./postgres:/var/lib/postgresql/data
    environment:
      POSTGRES_DB: ${POSTGRES_DB}
      POSTGRES_PASSWORD: ${POSTGRES_PASSWORD}
      POSTGRES_USER: ${POSTGRES_USER}
    networks:
      - default
  urlshorter:
    container_name: urlshorter
    image: jkaninda/urlshorter:latest
    environment:
      - SPRING_DATASOURCE_URL=jdbc:postgresql://${DB_HOST}:${DB_PORT}/${POSTGRES_DB}
      - SPRING_DATASOURCE_USERNAME=${POSTGRES_USER}
      - SPRING_DATASOURCE_PASSWORD=${POSTGRES_PASSWORD}
      - SPRING_JPA_HIBERNATE_DDL_AUTO=update
      - URL_LENGHT=4
      - DOMAIN_URL=http://localhost:8080
    tty: true
    restart: unless-stopped
    ports:
      - "8080:8080"
    networks:
      - default

````


## 