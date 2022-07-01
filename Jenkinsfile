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
            sh "scp -P 1025 build/libs/*.jar root@210.89.190.215:~/somoim/app/somoim.jar"
          }
        }

        stage('Deploy') {
            when {
              branch 'main'
            }
            steps {
                script {
                  sh "ssh -p 1025 root@210.89.190.215 -T sh < /var/lib/jenkins/deploy.sh"
                }
            }
        }
    }
}