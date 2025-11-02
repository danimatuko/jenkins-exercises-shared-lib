def call() {
    dir('app') {
        withCredentials([usernamePassword(
            credentialsId: 'github-credentials',
            usernameVariable: 'USER',
            passwordVariable: 'PASS'
        )]) {
            def branch = env.BRANCH_NAME ?: 'main'

            echo "📤 Pushing version bump to branch: ${branch}"

            sh """
                git config user.name "Jenkins CI"
                git config user.email "jenkins@jenkins-exercises.com"
                git add package.json package-lock.json
                git commit -m "ci: bump version to ${env.APP_VERSION}"
                git push https://${USER}:${PASS}@github.com/danimatuko/jenkins-exercises.git HEAD:${branch}
            """
        }
    }
}

