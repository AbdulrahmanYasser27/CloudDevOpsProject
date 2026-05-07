@Library('shared-library') _

pipeline {
    agent any

    environment {
        IMAGE_NAME = "abdulrahman1235/python-app:${BUILD_NUMBER}"
    }

    stages {
        stage('Build Image') {
            steps {
                buildImage("${IMAGE_NAME}")
            }
        }

        stage('Scan Image') {
            steps {
                scanImage("${IMAGE_NAME}")
            }
        }

        stage('Push Image') {
            steps {
                pushImage("${IMAGE_NAME}")
            }
        }

        stage('Delete Image Locally') {
            steps {
                deleteImageLocally("${IMAGE_NAME}")
            }
        }

        stage('Update Manifests') {
            steps {
                updateManifests("${IMAGE_NAME}")
            }
        }

        stage('Push Manifests') {
            steps {
                pushManifests()
            }
        }
    }

    post {
        success {
            echo "Pipeline completed successfully! ✅"
        }
        failure {
            echo "Pipeline failed! ❌"
        }
    }
}
