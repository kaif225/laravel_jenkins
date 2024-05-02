FROM php:8.1-fpm-alpine
WORKDIR /app
COPY . .
RUN apk update; \
    apk add --no-cache curl git zip
RUN rm -rf /var/cache/*; \
    cp .env.example .env

RUN curl -sS https://getcomposer.org/installer | php -- --install-dir=/usr/local/bin --filename=composer; \
    chmod +x /usr/local/bin/composer
RUN composer config --no-plugins allow-plugins.phpstan/extension-installer true; \
    composer install --no-interaction --prefer-dist; \
    php artisan key:generate

CMD ["vendor/bin/phpunit"] 




