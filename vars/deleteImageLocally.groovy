def call(String imageName) {
    echo "Deleting local image: ${imageName}"
    sh "docker rmi ${imageName} || true"
}
