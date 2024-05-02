def call() {
    node { 
        sh """ 
           git --version && \
           docker build -t laravel2_image .
           """
    }
}
