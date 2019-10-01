pipeline {
    agent any
    environment {
        //Docker credentials
        DOCKER_USER_NAME = 'gato756'
        DOCKER_PASSWORD = 'Bichito123'
        //New tag for docker
        DOCKER_TAG_NEW = '1.1'
        DOCKER_TAG_CURRENT = '1.0'
        //Docker repository
        DOCKER_REPOSITORY = 'gato756/awt04webservice_1.0'
        TAG = VersionNumber projectStartDate: '09/23/2019', versionNumberString: '${BUILD_NUMBER}', versionPrefix: 'v1.', worstResultForIncrement: 'FAILURE'
        GIT_BRANCH = sh(returnStdout: true, script: 'git rev-parse --abbrev-ref HEAD').trim()
    }
    stages {
        stage('Build') {
            agent {
                docker { image '${DOCKER_REPOSITORY}:${DOCKER_TAG_CURRENT}' }
            }
            steps {
                echo 'Building..'
                echo '${GIT_BRANCH} /////  ${GIT_BRANCH#*/}'
                //sh 'chmod +x gradlew'
                sh './gradlew build'
            }
            post {
                always {
                    junit 'build/test-results/test/*.xml'
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
                copyArtifacts fingerprintArtifacts: true, parameters: 'build/libs*.jar', projectName: '${JOB_NAME}', selector: lastWithArtifacts(), target: './jar'
                sh 'ls -al jar'
                sh 'docker ps -a'
            }
        }
        stage('SonarCloud') {
            steps {
                sh 'chmod +x gradlew'
                sh './gradlew sonarqube -Dsonar.projectKey=andybazualdo -Dsonar.organization=andybazualdo -Dsonar.host.url=https://sonarcloud.io -Dsonar.login=16e96c988a578b8f8dd2b8bf381c19fcc11194f3'
            }
        }
        stage('Docker push') {
            steps {
                sh 'ls -al'
                sh 'pwd'
                sh 'echo Start updating to docker hub .......'
                sh 'echo "${DOCKER_PASSWORD}" | docker login --username ${DOCKER_USER_NAME} --password-stdin'
                sh 'docker build -t ${DOCKER_REPOSITORY}:${TAG} .'
                sh 'docker push ${DOCKER_REPOSITORY}:${TAG}'
            }
        }
        stage('Release') {
            steps {
                sh 'ls -al'
                sh 'echo {GIT_BRANCH}'
            }
        }
    }
    post{
       /* failure {
            emailext attachLog: true, compressLog: true, body: 'The process to generate a new verion of ${GIT_BRANCH}. Log with the info is attached ',
                     subject: 'Build Notification: ${JOB_NAME}-Build# ${BUILD_NUMBER} ${currentBuild.result}',
                     to: 'fernando.hinojosa@live.com'
        }*/
        always {
            cleanWs deleteDirs: true, notFailBuild: true
        }
    }
}