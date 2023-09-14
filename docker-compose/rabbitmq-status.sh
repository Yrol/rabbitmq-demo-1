#!/bin/bash
# rabbitmq-status.sh

apt-get update -y

yes | apt-get install curl

curlResult=$(curl -s -o /dev/null -I -w "%{http_code}" http://rabbitmq:15672)

echo "results status code:" $curlResult

while [[ ! $curlResult == "200" ]]; do
  >&2 echo "RabbitMQ is not up yet!"
  sleep 1
  curlResult=$(curl -s -o /dev/null -I -w "%{http_code}" http://rabbitmq:15672)
done

echo "RabbitMQ is up!"

/cnb/process/web