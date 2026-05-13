def call(String imageName) {
    echo "Updating Kubernetes manifests with new image"
    sh "sed -i 's|image: 781978598486.dkr.ecr.us-east-1.amazonaws.com/clouddevops-app:.*|image: ${imageName}|g' k8s/deployment.yaml"
}
