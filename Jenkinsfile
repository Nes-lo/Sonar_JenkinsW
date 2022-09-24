pipeline{
    agent any

    stages{

    stage('gradlew clean')
       {
          steps{
          bat "cls"
           }
        }

       stage('build'){
          steps{
          bat "gradlew build -x test"
          }
       }

       stage('test'){
                 steps{
                 bat "gradlew test"
                 }
         }

       /*  stage('cobertura'){
                   steps{
                   bat "jacocoTestReport"
                   }
                }
*/

       stage('SonarQube analysis') {
           withSonarQubeEnv() { // Will pick the global server connection you have configured
             sh './gradlew sonarqube'
           }
         }
    }
}