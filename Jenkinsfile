pipeline {

	agent any
	
	tools {
    		maven 'mvn'
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
