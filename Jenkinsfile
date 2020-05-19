node {
    def image
    stage('Clone repository') {
        checkout scm
    }
    stage('Maven build') {
        docker.image('maven:3-alpine').inside() {
            sh 'mvn package'
        }
    }
    stage('Container inspect') {
        docker.inspect()
    }
    stage('Container build') {
        image = docker.build("tek-system-backend")
    }
    stage('Container run') {
        image.run("-d -p 9090:9090 --name tek-system-backend")
        sleep 20
    }
}
