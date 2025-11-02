def call() {
    echo "🚀 Deploying app..."
    sh '''
    docker stop my-node-app || true
    docker rm my-node-app || true
    docker run -d -p 3000:3000 --name my-node-app node-app:latest
    '''
    echo "✅ Deployment successful! App is running on port 3000."
}

