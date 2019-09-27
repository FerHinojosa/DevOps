pipeline {
    agent any
    stages {
        stage('Build') {
           /* agent {
                docker { image 'gato756/awt04webservice_1.0:1.0' }
            } */
            steps {
                echo 'Building..'
                sh 'chmod +x gradlew'
                sh './gradlew clean'
                sh './gradlew init'
                sh './gradlew build'
                sh './gradlew test'
                sh 'echo hola'
            }
        }
    }
}
