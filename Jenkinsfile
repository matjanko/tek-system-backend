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
                sh '''
                    mvn clean
                    mvn package                 
                '''
            }
        }
        stage('Docker inspect') {
            steps {
                script {
                    env.test="test"
                }
                catchError(buildResult: 'SUCCESS', stageResult: 'FAILURE') {
                    sh '''
                        docker stop tek-system-backend
                        docker rm tek-system-backend
                    '''
                }
            }
        }
        stage('Docker build') {
            steps {
                sh '''
                    docker build -t tek-system-backend:$BUILD_NUMBER .
                '''
            }
        }
        stage('Docker run') {
            steps {
                sh '''
                    docker run -d -p 9090:9090 --name tek-system-backend tek-system-backend:$BUILD_NUMBER
                '''
            }
        }
    }
}