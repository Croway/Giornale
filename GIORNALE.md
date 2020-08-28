# APPLICAZIONE

Gestore di un giornale online, permette il salvataggio di notizie (titolo + corpo) e commenti associati ad ogni notizia.

## Database

docker run -p 3307:3306 --name giornale-mysql -e MYSQL_ROOT_PASSWORD=pa55word -e MYSQL_DATABASE=giornale -d mysql

## Test

mvn clean test-compile failsafe:integration-test failsafe:verify -f giornale-it/pom.xml

## Jenkins

docker run -p 8080:8080 -p 50000:50000 -d -v jenkins_home:/var/jenkins_home jenkins/jenkins:lts

user: admin
pass: pa55word!