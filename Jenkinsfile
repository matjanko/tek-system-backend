pipeline {
    agent none
    stages {
        stage("Permission") {
            agent any
            steps {
                sh "chown root:jenkins /run/docker.sock"
            }
        }

        stage('Maven build') {
            agent {
                docker {
                    image 'maven:3-alpine'
                }
            }
            steps {
                sh 'mvn -v'
            }
        }
    }
}