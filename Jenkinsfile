pipeline {
    agent {
        docker {
            image 'maven:3-alpine'
            args '-u root --privileged'
        }
    }
    stages {
        stage('Build') {
            steps {
                sh 'mvn -v'
            }
        }
    }
}