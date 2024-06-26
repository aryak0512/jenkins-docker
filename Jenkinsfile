pipeline {

    agent any

    environment{

        // these params are binded to tabs in the Jenkins dashboard global configuration tab
        mavenHome = tool 'my-maven'
        dockerHome = tool 'my-docker'
        //jdkHome = tool 'my-jdk'

        // adding docker and maven to path
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

        stage ("Create Docker Image"){
            steps{
                script{
                    // image reference created
                    dockerImage = docker.build("aryak0512/my-app:latest")
                    echo "Docker image created..."
                }
            }
        }

        stage ("Push Docker Image"){
            steps{
                script{
                    // retrieve auth details with id 'Docker' from credentials tab of Jenkins dashboard
                    withCredentials([usernamePassword(credentialsId: 'Docker', passwordVariable: 'passed', usernameVariable: 'name')]) {

                        // login to docker hub
                        sh 'docker login -u ${name} -p ${passed}'

                        // push to registry
                        dockerImage.push()
                        echo "Docker Image pushed to registry..."
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