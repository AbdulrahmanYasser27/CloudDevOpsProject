def call(String imageName, String ecrRegistry, String awsRegion) {
    echo "Pushing image to ECR: ${imageName}"
    sh """
        aws ecr get-login-password --region ${awsRegion} | \
        docker login --username AWS --password-stdin ${ecrRegistry}
        docker push ${imageName}
    """
}
