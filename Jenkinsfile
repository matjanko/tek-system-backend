pipeline {
    agent none
    stages {
        stage("Permission") {
            agent any
            steps {
                sh "chown root:jenkins /var/lib/docker"
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