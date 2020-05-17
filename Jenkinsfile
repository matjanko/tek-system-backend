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
                sh'cp home/mjankowski/properties/tek-system-backend/application-prod.properties var/lib/docker/volumes/jenkins-data/workspace/tek-system-backend/src/main/resources/'
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