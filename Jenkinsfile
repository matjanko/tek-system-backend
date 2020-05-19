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
        def isRunning = sh (script: ' docker inspect --format=\'{{.State.Running}}\' tek-system-backend', returnStdout: true)
        if (isRunning) {
            docker.stop("tek-system-backend")
            docker.remove("tek-system-backend")
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
