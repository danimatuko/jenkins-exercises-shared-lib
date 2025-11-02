def call() {
    dir('app') {
        echo "🧪 Running tests..."
        sh 'npm test'
    }
}
