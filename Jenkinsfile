pipeline {
    agent {
        docker {
            image 'maven:3-alpine'
            args '-u root:sudo'
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