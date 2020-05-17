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
                sh 'cd target/'
                sh 'java -jar tek-system-0.0.1-SNAPSHOT.jar --spring.profiles.active=prod'
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