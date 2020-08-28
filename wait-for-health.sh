HEALTH_ENDPOINT=http://localhost:8081/actuator/health

if [ ! -z "$1" ]; then
    echo 'endpoint: ' $1
    HEALTH_ENDPOINT=$1
fi

attempt_counter=0
max_attempts=2

until $(curl --output /dev/null --silent --head --fail $HEALTH_ENDPOINT); do
    if [ ${attempt_counter} -eq ${max_attempts} ];then
      echo "Max attempts reached"
      exit 1
    fi

    echo 'attempt n.' $attempt_counter 'endpoint' $HEALTH_ENDPOINT

    printf '.'
    attempt_counter=$(($attempt_counter+1))
    sleep 5
done