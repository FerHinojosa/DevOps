pipeline {
    agent{label'master'}
    environment {
        DOCKER_USERNAME = '5917362014'
        DOCKER_PASSWORD = '0123456789'
        DOCKER_ID = '5917362014/webserver'
    }
    stages {
        stage ('Build') {
            agent {
                docker {image 'openjdk:11.0.4'}
            }
            steps {
                sh 'chmod +x gradlew'
                sh './gradlew build'
                sh 'pwd'
            }
            post{
                always {
                    junit 'build/test-results/test/*.xml'
                    publishHTML([allowMissing: false, 
                                alwaysLinkToLastBuild: false, 
                                keepAll: false, 
                                reportDir: 'build/reports/tests/test', 
                                reportFiles: 'index.html', 
                                reportName: 'Unit TestHTML Report', 
                                reportTitles: ''])
                }
                success {
                  archiveArtifacts 'build/libs/*.jar'
                  stash includes: 'build/libs/*.jar', name: 'package_build'
                  sh 'pwd'
                }
            }
        }
        stage ('Code Quality'){
            steps {
                sh 'chmod +x gradlew'
                sh './gradlew sonarqube \
                -Dsonar.projectKey=FerHinojosa_DevOps \
                -Dsonar.organization=ferhinojosa \
                -Dsonar.host.url=https://sonarcloud.io \
                -Dsonar.login=62a479ec2b7172fa65c868d0acac404f4f969da9'
            }
        }
        stage ('Deploy to Dev'){
            agent{label'master'}
            steps {
                unstash 'package_build'
                sh 'docker-compose up -d'
                sh 'docker-compose down || true'                
            }
        }
        stage ('Run Smoke Tests'){
            steps {
                echo 'Run Smoke Testing!!'
                sh 'exit 0'
            }
        }
        stage ('Docker Build'){
            agent{label'master'}
            when {
                anyOf{
                    branch 'master'; branch 'develop'
                }
            }
            steps{
                unstash 'package_build'
                sh 'docker build -t ${DOCKER_ID}:v1.${BUILD_NUMBER} .'
                sh 'docker login -u ${DOCKER_USERNAME} -p ${DOCKER_PASSWORD}'
                sh "docker push ${DOCKER_ID}:v1.${BUILD_NUMBER}"
                sh 'docker images' 
            }
        }
        stage ('Promote to QA'){
            agent{label'slave02'}
            steps {
                unstash 'package_build'
                sh 'docker-compose -f docker-composePromote.yml up -d'
            }
        }
        stage ('Test'){
            steps {
                echo 'Run end to end test.'
                sh 'exit 0'
            }
        }
    }
    post {
        always {
            sh 'docker-compose down || true'
            sh 'docker-compose -f docker-composePromote.yml down'
            echo 'Execute when it success'
        }
        failure {
            cleanWs deleteDirs: true, notFailBuild: true
            emailext attachLog: true, compressLog: true, body: 'The process to generate a new verion of ${BRANCH_NAME}. Log with the info is attached ',
                     subject: 'Build Notification: ${JOB_NAME}-Build# ${BUILD_NUMBER} ${currentBuild.result}',
                     to: 'fernando.hinojosa@live.com'
        }
        success {
            echo 'Execute when it success'
        }*/
    }
    
}  
