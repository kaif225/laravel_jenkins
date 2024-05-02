def buildAndTestLaravelApp() {
    stage('Build Docker image') {
        steps {
            script {
                docker.build('laravel-app', '.')
            }
        }
    }
    stage('Run PHPUnit tests') {
        steps {
            script {
                docker.image('laravel-app').inside('-v ${PWD}:/var/www/html') {
                    sh 'composer install --no-interaction --prefer-dist'
                    sh 'cp .env.example .env'
                    sh 'php artisan key:generate'
                    sh 'vendor/bin/phpunit'
                }
            }
        }
    }
}
