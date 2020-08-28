pipeline {

	agent any
	
	tools {
    		maven 'mvn'
  	}
	
	stages {
	
		stage("unit-test") {
			steps {
				
				// sh 'mvn test -f giornale-app/pom.xml'
			}
		}
	
		stage("build") {
		
			steps {
				step([$class: 'DockerComposeBuilder', dockerComposeFile: 'giornale-app/docker-compose.yml', option: [$class: 'StartService', scale: 1, service: 'giornale'], useCustomDockerComposeFile: true])
			}
			
		}
		
	}
	
}
