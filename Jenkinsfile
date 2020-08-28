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
				sh 'sleep 60'
				sh 'mvn clean test-compile failsafe:integration-test failsafe:verify -f giornale-it/pom.xml'
				sh "docker-compose -f giornale-app/docker-compose.yml down -v"
			}
		}
		
		stage("build-prod") {
			steps {
				sh 'mvn clean install -DskipTests -P prod'
			}
		}
		
	}
	
	post {
    	always {
        	sh "docker-compose -f giornale-app/docker-compose.yml down -v || true"
    	}
	}
}
