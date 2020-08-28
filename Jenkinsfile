pipeline {

	agent any
	
	stages {
		stage("build-it") {
			steps {
				sh 'mvn clean install -DskipTests -P integrationTest'
			}
		}
		
		stage("unit-test") {
			steps {
				sh 'mvn test -f giornale-app/pom.xml'
			}
		}
		
		stage("integration-test") {
			steps {
				sh 'echo $USER'
				sh 'newgrp docker'
				sh 'docker-compose -f giornale-app/docker-compose.yml up --build -d'
				sh './wait-for-health.sh http://localhost:8081/actuator/health'
				sh 'mvn clean test-compile failsafe:integration-test failsafe:verify -f giornale-it/pom.xml'
				sh "docker-compose -f giornale-app/docker-compose.yml down -v"
			}
		}
		
		stage("build-prod") {
			steps {
				sh 'mvn clean install -DskipTests -P prod'
			}
		}
		
		stage("push-to-repo") {
			steps {
				sh "echo 'dockerize application'"
				sh "echo 'push docker application to repo'" 
			}
		} 
	}
	
	post {
    	always {
        	sh "docker-compose -f giornale-app/docker-compose.yml down -v || true"
    	}
	}
}
