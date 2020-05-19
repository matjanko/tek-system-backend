node {
    stage('Clone repository') {
        checkout scm
    }
    stage('Maven build') {
        docker.image('maven:3-alpine').inside() {
            sh 'mvn package'
        }
    }
    stage('Container inspect') {

    }
    stage('Container build') {
        docker.build("tek-system-backend")
    }
    stage('Container run') {

    }
}
