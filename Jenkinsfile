pipeline {

	agent any
	
	stages {
	
		stage("build") {
			steps {
				sh 'mvn clean install -DskipTests'
			}
		}
		
		stage("unit-test") {
			steps {
				sh 'echo ok'
				sh 'mvn test -s /home/federico/ -f giornale-app/pom.xml'
			}
		}
	
		stage("integration-test") {
		
			steps {
				sh 'docker ps'
				
			}
			
		}
		
	}
	
}
