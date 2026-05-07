def call(String imageName) {
    echo "Pushing image: ${imageName}"
    withCredentials([usernamePassword(
        credentialsId: 'dockerhub-credentials',
        usernameVariable: 'DOCKER_USER',
        passwordVariable: 'DOCKER_PASS'
    )]) {
        sh "echo $DOCKER_PASS | docker login -u $DOCKER_USER --password-stdin"
        sh "docker push ${imageName}"
    }
}
