node {
    def container

    stage("Checkout") {
        checkout scm
    }
    stage("Maven build") {
        docker.image('maven:3-alpine').inside() {
            sh '''
                mvn clean
                mvn package
            '''
        }
    }
    stage("Docker stop") {
        try {
            sh '''
                docker stop tek-system-backend
                docker rm tek-system-backend
            '''
        } catch (Exception e) {
            e.getMessage()
        }
    }
    stage("Docker build") {
        container = docker.build('tek-system-backend:$BUILD_NUMBER')
    }
    stage("Docker run") {
        container.run('-p 9090:9090 --name tek-system-backend')
    }
    stage("Clean workspace") {

    }
}