pipeline {

	agent any
	
	tools {
    		maven 'mvn'
  	}
	
	stages {
	
		stage("unit-test") {
			steps {
				sh 'echo ok'
				// sh 'mvn test -f giornale-app/pom.xml'
			}
		}
	
		stage("build") {
		
			steps {
				step([$class: 'DockerComposeBuilder', dockerComposeFile: 'docker-compose.yml', option: [$class: 'ExecuteCommandInsideContainer', command: '--build up', index: 1, privilegedMode: false, service: 'giornale', workDir: 'giornale-app'], useCustomDockerComposeFile: true])
				// sh 'mvn clean test-compile failsafe:integration-test failsafe:verify -f giornale-it/pom.xml'				
				step([$class: 'DockerComposeBuilder', dockerComposeFile: 'docker-compose.yml', option: [$class: 'ExecuteCommandInsideContainer', command: 'down', index: 1, privilegedMode: false, service: 'giornale', workDir: 'giornale-app'], useCustomDockerComposeFile: true])
			}
			
		}
		
	}
	
}
