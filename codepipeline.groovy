pipeline {
    agent any
    stages {
        stage('Getting Git Repo') {
            steps {
                git branch: 'main', url: 'https://github.com/shaharyar-devops/new-webpage.git'
            }
        }
        stage('Build') {
            steps {
                sh 'docker build -t myapp:latest .'
            }
        }
        stage('Deploy') {
            steps{
                sh '''
        docker stop myapp || true
        docker rm myapp || true
        docker run -d -p 8000:80 --name myapp myapp:latest
        '''
            }
        }
    }
}