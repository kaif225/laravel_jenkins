def call() {
    node { 
        sh """ 
           git clone https://github.com/kaif225/laravel_jenkins.git && \
           cd ${WORKSPACE}/laravel_jenkins && \
           docker build -t laravel2_image .
           git --version 
           """
    }
}
