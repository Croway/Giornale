pipeline {

	agent any
	
	tools {
    		maven 'M3'
  	}
	
	stages {
	
		stage("unit-test") {
			steps {
				
				sh 'mvn test -f giornale-app/pom.xml'
			}
		}
	
		stage("build") {
		
			steps {
				sh 'echo OK'
			}
			
		}
		
	}
	
}
