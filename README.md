# Jenkins automated pipeline

###### Aim : To design an automated end-to-end flow for a simple spring boot application, so that a commit made by developer in IntelliJ IDEA, builds the project, creates an image and deploys image to Docker Hub. 

## Stages

### Poll code from SCM
- Git repo authentication configured using SSH

### Build
- Apache Maven used to build the project
- As simple as running :
```console
aryak@Aryaks-MacBook-Pro Desktop % mvn clean install
```

### Test
- Junit 5 test cases are run against the build.
- Mockito used for mocking beans
- An email is sent if the build failure occurs. 
- Jacoco used for Test Code Coverage report 
![](/JacocoReport.png)

### Build Docker image
- A Dockerfile is written to specify image layers
```console
docker build -t aryak0512/my-app:latest .
```
- Connect Jenkins to Docker Hub
```console
docker login -u ${name} -p ${passed}
```
- Credentials passed as variables

### Push image to Docker hub
```console
docker push aryak0512/my-app:latest
```