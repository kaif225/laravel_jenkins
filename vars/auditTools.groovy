def call() {
    node {
        checkout scm
        // Build the Docker image
        docker.build('laravel-app', '.')
    }
}
