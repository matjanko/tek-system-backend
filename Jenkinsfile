pipeline {
    agent none
    stages {
        stage('Maven build') {
            agent {
                docker {
                    image 'maven:3-alpine'
                }
            }
            steps {
                sh'cp -r /home/mjankowski/properties/tek-system-backend/application-prod.properties /var/lib/docker/volumes/jenkins-data/_data/workspace/tek-system-backend-develop/src/main/resources/'
                sh 'mvn package'
            }
        }
        stage('Docker build') {
            steps {
                echo "Docker build"
            }
        }
        stage('Docker run') {
            steps {
                echo "Docker run"
            }
        }
    }
}