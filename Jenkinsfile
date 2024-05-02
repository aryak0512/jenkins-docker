pipeline {
    agent any

    environment{

        // adding docker and maven to path, provided in config
        mavenHome = tool 'my-maven'
        dockerHome = tool 'my-docker'
        PATH = "$dockerHome/bin:$mavenHome/bin:$PATH"
    }

    stages {

        stage("build") {
            steps {
                sh "mvn --version"
                sh "docker --version"
                echo "Building..."
            }
        }

        stage("test") {
            steps {
                echo "Testing..."
            }
        }

        stage("integration test") {
            steps {
                echo "Integration Testing..."
            }
        }

        stage("deploy") {
            steps {
                echo "Deploying..."
            }
        }
    }

    post{
        success{
            echo "I execute on success..."
        }
        failure{
            echo "I execute on failure..."
        }
        always{
            echo "I always execute..."
        }
    }
}