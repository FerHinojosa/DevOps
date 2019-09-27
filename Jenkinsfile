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
                sh './gradlew build -d'
                script {
                  try {
                        sh './gradlew clean test --no-daemon'
                    }
                    finally {
                    junit '/build/test-results/test/*.xml'
                }

            }
        }
    }
}
}