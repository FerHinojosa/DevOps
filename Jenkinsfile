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
                    sh 'ls -al'
                    sh 'pwd'
                }
            }
        }
        stage('Copy Artifacts') {
            steps {
                sh 'echo Start Coping .......'
                sh 'ls -al'
                sh 'pwd'
                copyArtifacts fingerprintArtifacts: true, parameters: 'build/libs*.jar', projectName: 'DevOps/develop', selector: lastWithArtifacts(), target: './jar'
                sh 'ls -al jar'
                sh 'docker ps -a'
            }
        }
        stage('Update Docker Container') {
            agent {
                dockerfile true
            }
            steps {
                docker login
                sh 'echo Start Coping .......'
                sh 'docker login -u gato756 -p Bichito123'
                sh '(docker build -f dockerfile -t gato756/awt04webservice_1.0:1.1 && docker commit gato756/awt04webservice_1.0:1.1 && docker push gato756/awt04webservice_1.0:1.1)'
            }
        }
       /*stage('Update Docker Container other way') {
            app = docker.build('gato756/awt04webservice_1.0:1.1')
            docker.withRegistry('https://registry.hub.docker.com', 'docker-hub') {
            app.push("${env.BUILD_NUMBER}")
            app.push("latest")
        }*/
    }
}