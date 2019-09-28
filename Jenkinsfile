pipeline {
    agent any
    stages {
        stage('Build') {
            agent {
                docker { image 'gato756/awt04webservice_1.0:1.0' }
            }
            steps {
                echo 'Building..'
                sh 'chmod +x gradlew'
                //sh './gradlew clean'
                sh './gradlew build'
            }
            post {
                always {
                    sh 'ls -la build/*'
                    junit 'build/test-results/test/*.xml'
                    archiveArtifacts 'build/libs/*.jar'
                }
            }
        }
        stage ('2'){
            steps {
                sh 'ls -la'
                sh 'ls -la build'
            }
        }
    }
}