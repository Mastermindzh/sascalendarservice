FROM openjdk:8

#datadog
RUN apt-get update
RUN apt-get install apt-transport-https
RUN  sh -c "echo 'deb https://apt.datadoghq.com/ stable main' > /etc/apt/sources.list.d/datadog.list"
RUN  apt-key adv --keyserver keyserver.ubuntu.com --recv-keys C7A7DA52
RUN  apt-get update
RUN  apt-get install datadog-agent
RUN  sh -c "sed 's/api_key:.*/api_key: 50991df250bc83a0dcc8f406b61680c0/' /etc/dd-agent/datadog.conf.example > /etc/dd-agent/datadog.conf"

COPY . /usr/src/myapp
WORKDIR /usr/src/myapp

CMD ["bash", "target/universal/play_scala_rest_framework-1.0/bin/play_scala_rest_framework"]
