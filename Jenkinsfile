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
        def isRunning = sh "docker inspect --format=\'{{.State.Running}}\' tek-system-backend"
        if (isRunning) {
            sh "docker stop tek-system-backend"
            sh "docker rm tek-system-backend"
        }
    }
    stage('Container build') {
        image = docker.build("tek-system-backend")
    }
    stage('Container run') {
        image.run("-p 9090:9090 --name tek-system-backend")
        sleep 10
    }
}
