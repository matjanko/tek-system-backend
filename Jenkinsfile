node {
    def image
    def imageName = "tek-system-backend"

    stage('Clone repository') {
        checkout scm
    }
    stage('Maven build') {
        docker.image('maven:3-alpine').inside() {
            sh 'mvn package'
        }
    }
    stage('Container inspect') {
        def isRunning = sh(script: "docker inspect --format=\'{{.State.Running}}\' ${imageName}", returnStatus: true)
        if (isRunning == 0) {
            sh "docker stop ${imageName}"
            sh "docker rm ${imageName}"
        }
    }
    stage('Container build') {
        image = docker.build(imageName)
    }
    stage('Container run') {
        image.run("-p 9090:9090 --name ${imageName} --restart=always")
        sleep 40
    }
}
