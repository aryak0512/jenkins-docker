pipeline {
    agent any

    environment{

        // adding docker and maven to path, provided in config
        mavenHome = tool 'my-maven'
        dockerHome = tool 'my-docker'
        //jdkHome = tool 'my-jdk'
        PATH = "$dockerHome/bin:$mavenHome/bin:$PATH"
    }

    stages {

        stage("build") {
            steps {
                sh "mvn --version"
                sh "docker --version"
                sh "java --version"
                echo "Building..."
                sh "mvn clean install"
            }
        }

        stage("test") {
            steps {
                echo "Testing..."
                sh "mvn test"
            }
        }

        stage("integration test") {
            steps {
                echo "Integration Testing..."
                sh "mvn failsafe:integration-test failsafe:verify"
            }
        }

        stage("deploy") {
            steps {
                echo "Deploying..."
            }
        }
//
        stage ("Create Docker Image"){
            steps{
                script{
                   dockerImage = docker.build("aryak0512/test-pipeline:latest")
                }
            }
        }

        stage ("Push Docker Image"){
            steps{
                script{

                    docker.withRegistry('', docker){
                        dockerImage.push()
                    }

                }
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