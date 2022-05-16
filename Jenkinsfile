pipeline {
    agent any

    stages {
        stage('Checkout') {
            steps {
              checkout scm
            }
        }

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
    }
}