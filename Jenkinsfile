pipeline {
    agent any

    stages {
        stage('Test') {
            steps {
                sh './gradlew test'
            }
        }

        stage('Build') {
            steps {
                sh './gradlew clean build'
            }
        }

        stage('Send jar') {
          when {
            branch 'main'
          }
          steps {
            sh "scp -P ${DEPLOY_SVR_PORT} build/libs/*.jar ${DEPLOY_SVR_HOST}:~/somoim/app/somoim.jar"
          }
        }

        stage('Deploy') {
            when {
              branch 'main'
            }
            steps {
                script {
                  sh "ssh -p ${DEPLOY_SVR_PORT} ${DEPLOY_SVR_HOST} -T sh < /var/lib/jenkins/deploy.sh"
                }
            }
        }
    }
}