def call() {
    dir('app') {
        echo "🔢 Incrementing version..."
        sh 'npm version patch --no-git-tag-version'
        def packageJson = readJSON file: 'package.json'
        env.APP_VERSION = packageJson.version
        echo "📦 New version: ${env.APP_VERSION}"
    }
}

