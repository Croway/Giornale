pipeline {

	agent any
	
	stages {
		stage("build-it") {
			steps {
				sh 'echo build'
				sh 'mvn clean install -DskipTests -P integrationTest'
			}
		}
		
		stage("unit-test") {
			steps {
				sh 'echo unit'
				// sh 'mvn test -f giornale-app/pom.xml'
			}
		}
		
		stage("integration-test") {
			steps {
				sh 'echo $USER'
				sh 'newgrp docker'
				sh 'docker-compose -f giornale-app/docker-compose.yml up --build'
			}
		}
		
		stage("build-prod") {
			steps {
				sh 'echo build'
				// sh 'mvn clean install -DskipTests'
			}
		}
		
	}
	
	post {
        	always {
            	sh "docker-compose -f giornale-app/docker-compose.yml down -v"
        	}
    	}
}
