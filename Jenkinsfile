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
        stage('Docker inspect') {
            steps {
                catchError {
                    sh '''
                        docker stop tek-system-backend
                        docker rm tek-system-backend
                    '''
                }
                echo currentBuild.result
            }
        }
        stage('Docker build') {
            steps {
                sh "docker build -t tek-system-backend ."
            }
        }
        stage('Docker run') {
            steps {
                sh "docker run -d -p 9090:9090 --name tek-system-backend tek-system-backend"
            }
        }
    }
}