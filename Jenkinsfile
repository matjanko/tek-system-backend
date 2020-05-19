pipeline {
    agent any
    stages {
        def containerName = "tek-system-backend"
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
        }
        stage('Docker build') {
            def isRunning = sh (script: "docker inspect -f '{{.State.Running}}' ${containerName}", returnStatus: true)
            if (isRunning) {
                sh "docker stop ${containerName}"
                sh "docker rm ${containerName}"
            }

            sh "docker build -t ${containerName} ."

        }
        stage('Docker run') {
            steps {
                sh "docker run -d -p 9090:9090 ${containerName} --name ${containerName}"
            }
        }
    }
}