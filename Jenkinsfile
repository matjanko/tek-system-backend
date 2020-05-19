pipeline {
    agent any
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
            script{
                def isRunning = sh (script: "docker inspect -f '{{.State.Running}}' tek-system-backend", returnStatus: true)
                if (isRunning) {
                    sh "docker stop tek-system-backend"
                    sh "docker rm tek-system-backend"
                }

                sh "docker build -t tek-system-backend ."
            }
        }
        stage('Docker run') {
            steps {
                sh "docker run -d -p 9090:9090 tek-system-backend --name tek-system-backend"
            }
        }
    }
}