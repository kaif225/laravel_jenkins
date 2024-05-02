def call() {
    node { 
        sh """ 
           git clone https://github.com/kaif225/laravel_jenkins.git && \
           git --version 
           """
    }
}
