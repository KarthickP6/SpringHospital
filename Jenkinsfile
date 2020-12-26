
  node{
     stage('SCM Checkout'){
     
      git 'https://github.com/KarthickP6/SpringHospital'
    
     }
     stage('Compile-Package'){
      def mvnHome = tool name: 'Maven', type: 'maven'
       def javaHome = tool name: 'jdk', type: 'jdk'
       bat "${mvnHome}/bin/mvn package"
    }
  }
 

