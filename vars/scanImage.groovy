def call(String imageName) {
    echo "Scanning image: ${imageName}"
    sh "trivy image --exit-code 0 --severity HIGH,CRITICAL ${imageName}"
}
