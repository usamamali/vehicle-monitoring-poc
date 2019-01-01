FROM nginx:alpine
COPY nginx.conf /etc/nginx/nginx.conf
#COPY default.conf /etc/nginx/conf.d/default.conf
#COPY default_location /etc/nginx/vhost.d/default_location
WORKDIR /usr/share/nginx/html
COPY dist/vehicle-monitoring-ui .
#COPY start.sh /
#RUN chmod +x /start.sh
#ENTRYPOINT /start.sh


