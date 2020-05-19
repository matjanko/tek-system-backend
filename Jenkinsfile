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

    }
    stage('Container build') {
        image = docker.build(imageName)
    }
    stage('Container run') {
        image.run("-p 9090:9090 --name ${imageName} --restart=always")
        sleep 40
    }
}
