# base image
FROM node:10.15.0 as builder

# install chrome for protractor tests
#RUN wget -q -O - https://dl-ssl.google.com/linux/linux_signing_key.pub | apt-key add -
#RUN sh -c 'echo "deb [arch=amd64] http://dl.google.com/linux/chrome/deb/ stable main" >> /etc/apt/sources.list.d/google.list'
#RUN apt-get update && apt-get install -yq google-chrome-stable
RUN apt-get update && apt-get install -y sudo && rm -rf /var/lib/apt/lists/*

# set working directory
RUN mkdir /usr/src/app
WORKDIR /usr/src/app

# add `/usr/src/app/node_modules/.bin` to $PATH
ENV PATH /usr/src/app/node_modules/.bin:$PATH

# install and cache app dependencies
COPY package.json /usr/src/app/package.json
RUN sudo chown -R $(whoami) /usr/src/node_modules/ and sudo chgrp -R $(whoami) /usr/src/node_modules/
RUN sudo npm install
RUN sudo npm install -g @angular/cli@1.7.1

# add app
COPY . /usr/src/app

FROM nginx:alpine
COPY nginx.conf /etc/nginx/nginx.conf

RUN rm -rf /usr/share/nginx/html/*
COPY --from=builder /usr/src/app/dist/vehicle-monitoring-ui /usr/share/nginx/html
COPY --from=builder /usr/src/app/entrypoint.sh /usr/share/nginx/
#EXPOSE 80
#CMD ["nginx", "-g", "daemon off;"]
#RUN chmod +x /usr/share/nginx/entrypoint.sh
#CMD ["/bin/sh", "/usr/share/nginx/entrypoint.sh"]

