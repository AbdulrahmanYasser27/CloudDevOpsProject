def call(String imageName) {
    echo "Updating Kubernetes manifests with new image"
    sh "sed -i 's|image: abdulrahman1235/python-app:.*|image: ${imageName}|g' k8s/deployment.yaml"
}
