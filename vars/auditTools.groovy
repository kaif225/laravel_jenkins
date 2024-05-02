def call() {
    node { 
        sh """ 
           git --version
           docker.build('laravel-app', '.')
           """
    }
}
