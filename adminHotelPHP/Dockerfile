FROM php:7.0-apache

COPY conexiones /var/www/html/HOTEL/conexiones
COPY css /var/www/html/HOTEL/css
COPY imagenes /var/www/html/HOTEL/imagenes
COPY paginas /var/www/html/HOTEL/paginas
COPY index.html /var/www/html/HOTEL/index.html

RUN docker-php-ext-install mysqli
RUN docker-php-ext-install pdo_mysql

EXPOSE 80