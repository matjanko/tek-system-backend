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
                sh 'mvn package'
            }
        }
        stage('Docker build') {
            steps {
                sh 'docker build --tag tek-system-backend'
            }
        }
        stage('Docker run') {
            steps {
                echo "Docker run"
            }
        }
    }
}