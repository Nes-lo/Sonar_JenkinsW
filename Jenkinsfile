pipeline{
    agent any

    stages{

       stage('gradlew clean')
       {
          steps{
          sh "clean"
           }
        }

       stage('build'){
          steps{
          sh "gradlew build -x test"
          }
       }

       stage('test'){
                 steps{
                 sh "gradlew test"
                 }
         }

         stage('cobertura'){
                   steps{
                   sh "jacocoTestReport"
                   }
                }


       stage('sonar'){
                   steps{
                   sh "gradlew sonarqube"
                   }
           }
    }
}