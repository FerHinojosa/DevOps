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
                sh './gradlew build'
            }
            post {
                always {
                    junit 'build/test-results/test/*.xml'
                    //publishHTML([allowMissing: false, alwaysLinkToLastBuild: false, keepAll: false, reportDir: 'build/tests/test', reportFiles: 'index.html', reportName: 'HTML Report', reportTitles: ''])
                    archiveArtifacts 'build/libs/*.jar'
                }
            }
        }
        stage('Copy Artifacts') {
            steps {
                sh 'echo Start Coping .......'
                copyArtifacts fingerprintArtifacts: true, parameters: 'build/libs*.jar', projectName: 'DevOps/develop', selector: lastWithArtifacts(), target: './jar'
                sh 'ls -al'
                sh 'pwd'
            }
        }
        stage ('Build docker image'){
                agent { dockerfile true }
            steps {
                sh 'echo Docker'
                sh 'ls -al'
                sh 'pwd'
            }
        }
    }
}