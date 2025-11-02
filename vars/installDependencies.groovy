def call() {
    dir('app') {
        echo "📦 Installing dependencies..."
        sh 'npm install'
    }
}
