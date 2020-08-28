pipeline {

	agent any
	
	stages {
		stage("build per test di integrazione") {
			steps {
				sh 'mvn clean install -DskipTests -P integrationTest'
			}
		}
		
		stage("test unitari") {
			steps {
				sh 'mvn test -f giornale-app/pom.xml'
			}
		}
		
		stage("esecuzione integration test") {
			steps {
				sh 'echo $USER'
				sh 'newgrp docker'
				sh 'docker-compose -f giornale-app/docker-compose.yml up --build -d'
				sh './wait-for-health.sh http://localhost:8081/actuator/health'
				sh 'mvn clean test-compile failsafe:integration-test failsafe:verify -f giornale-it/pom.xml'
				sh "docker-compose -f giornale-app/docker-compose.yml down -v"
			}
		}
		
		stage("build con profilo produzione") {
			steps {
				sh 'mvn clean install -DskipTests -P prod'
			}
		}
		
		stage("Push immagine docker su repository") {
			steps {
				sh "echo 'docker build ...'"
				sh "echo 'docker push ...'" 
			}
		}
		
		stage("Aggiornamento pacchetto") {
			steps {
				sh "echo 'kubectlf apply -f ...'"
			}
		} 
	}
	
	post {
    	always {
        	sh "docker-compose -f giornale-app/docker-compose.yml down -v || true"
    	}
	}
}
