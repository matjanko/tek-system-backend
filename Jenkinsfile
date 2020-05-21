node {
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
    stage("Docker inspect") {

    }
    stage("Docker build") {

    }
    stage("Docker run") {

    }
    stage("Clean workspace") {

    }
}