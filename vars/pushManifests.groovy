def call() {
    echo "Pushing updated manifests to GitHub"
    withCredentials([usernamePassword(
        credentialsId: 'github-credentials',
        usernameVariable: 'GIT_USER',
        passwordVariable: 'GIT_PASS'
    )]) {
        sh """
            git config user.email "jenkins@ci.com"
            git config user.name "Jenkins"
            git add k8s/deployment.yaml
            git commit -m "ci: update image tag to ${BUILD_NUMBER}" || echo "Nothing to commit"
            git push https://${GIT_USER}:${GIT_PASS}@github.com/AbdulrahmanYasser27/CloudDevOpsProject.git HEAD:master
        """
    }
}
