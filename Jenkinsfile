pipeline {

	agent any
	
	stages {
		stage("build") {
			steps {
				sh 'echo build'
				// sh 'mvn clean install -DskipTests'
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
	}
}
