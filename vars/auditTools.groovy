def call() {
    node { 
        sh """ 
           cd ${WORKSPACE}/laravel_jenkins && \
           git --version && \
           docker build -t laravel2_image .
           """
    }
}
