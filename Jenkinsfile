pipeline {
    agent any

    stages{
        stage('Build'){
            steps {
                echo 'Building..'
                sh './mvnw package -DskipTests'
            }
        }
        stage('Test'){
            steps {
                echo 'Testing..'
            }
        }
        stage('Deploy'){
            steps{
                echo 'Deploying...'
            }
        }
    }
}