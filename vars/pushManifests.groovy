def call() {
    echo "Pushing updated manifests to GitHub"
    withCredentials([usernamePassword(
        credentialsId: 'github-credentials',
        usernameVariable: 'GIT_USER',
        passwordVariable: 'GIT_PASS'
    )]) {
        def user = env.GIT_USER
        def pass = env.GIT_PASS
        def build = env.BUILD_NUMBER
        sh """
            git config user.email "jenkins@ci.com"
            git config user.name "Jenkins"
            git add k8s/deployment.yaml
            git commit -m "ci: update image tag to ${build}" || echo "Nothing to commit"
            git push https://${user}:${pass}@github.com/AbdulrahmanYasser27/CloudDevOpsProject.git HEAD:main
        """
    }
}
