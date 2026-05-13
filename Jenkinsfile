@Library('shared-library') _

pipeline {
    agent any

    environment {
        ECR_REGISTRY = "781978598486.dkr.ecr.us-east-1.amazonaws.com"
        ECR_REPO     = "clouddevops-app"
        IMAGE_NAME   = "${ECR_REGISTRY}/${ECR_REPO}:${BUILD_NUMBER}"
        AWS_REGION   = "us-east-1"
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
                pushImage("${IMAGE_NAME}", "${ECR_REGISTRY}", "${AWS_REGION}")
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
