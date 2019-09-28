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
                    //publishHTML([allowMissing: false, alwaysLinkToLastBuild: false, keepAll: false, reportDir: 'build/tests/test', reportFiles: 'index.html', reportName: 'HTML Report', reportTitles: ''])
                    archiveArtifacts 'build/libs/*.jar'
                    sh 'ls -al'
                    sh 'pwd'
                    script {
                        step ([$class: 'DevOps',
                               projectName: '',
                               filter: "build/libs/*.zip",
                               target: 'jar']);
                    }
                }
            }
        }
        stage ('Build docker image'){
            steps {
                sh 'echo Docker'
            }
        }
    }
}