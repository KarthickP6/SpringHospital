pipeline {
  stages{
     stage('SCM Checkout'){
      git 'https://github.com/KarthickP6/SpringHospital'
     }
     stage('Compile-Package'){
      sh 'mvn package'
    }
  }
 
}
