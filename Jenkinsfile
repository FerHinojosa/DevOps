pipeline {
    agent any
    environment {
        //Docker credentials
        DOCKER_USER_NAME = 'gato756'
        DOCKER_PASSWORD = 'Bichito1234'
        //New tag for docker
        DOCKER_TAG_NEW = '1.1'
        DOCKER_TAG_CURRENT = '1.0'
        //Docker repository
        DOCKER_REPOSITORY = 'gato756/awt04webservice_1.0'
    }
    stages {
        stage('Build') {
            agent {
                docker { image '${DOCKER_REPOSITORY}:${DOCKER_TAG_CURRENT}' }
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
                failure {
                    emailext body: 'The build process was not completed ',
                            subject: 'Failure',
                            to: 'fernando.hinojosa@live.com'
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
            post{
                failure {
                    emailext body: 'The Copy Artifacts process was not completed ',
                            subject: 'Failure',
                            to: 'fernando.hinojosa@live.com'
                }
            }
        }
        stage('SonarCloud') {
            steps {
                sh 'chmod +x gradlew'
                //sh './gradlew sonarqube -Dsonar.projectKey=andybazualdo -Dsonar.organization=andybazualdo -Dsonar.host.url=https://sonarcloud.io -Dsonar.login=16e96c988a578b8f8dd2b8bf381c19fcc11194f3'
            }
            post{
                failure {
                    emailext body: 'The sonarCloud process was not completed ',
                            subject: 'Failure',
                            to: 'fernando.hinojosa@live.com'
                }
            }
        }
        stage('Docker push') {
            /*agent {
                dockerfile true
            }*/
            steps {

                //dockerfile true
                sh 'ls -al'
                sh 'pwd'
                sh 'echo Start updating to docker hub .......'
                //sh 'docker login -u ${DOCKER_USER_NAME} -p {DOCKER_PASSWORD}'
                sh 'echo "${DOCKER_PASSWORD}" | docker login --username ${DOCKER_USER_NAME} --password-stdin'
                sh 'docker build -t ${DOCKER_REPOSITORY}:${DOCKER_TAG_NEW} .'
                sh 'docker push ${DOCKER_REPOSITORY}:${DOCKER_TAG_NEW}'
            }
            post{
                failure {
                    emailext body: 'The docker push process was not completed ',
                            subject: 'Failure',
                            to: 'fernando.hinojosa@live.com'
                }
            }
        }
    }
    post{
        always {
            cleanWs deleteDirs: true, notFailBuild: true
        }
    }
}