def call() {
    echo "🏗️ Building Docker image..."
    echo "Building version: ${env.APP_VERSION}"
    sh "docker build -t node-app:${env.APP_VERSION} -t node-app:latest ."
}

