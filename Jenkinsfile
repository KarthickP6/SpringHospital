pipeline {
    agent any
    
    stages {
        stage ('scm') {
            steps {
                 url: 'https://github.com/KarthickP6/SpringHospital.git'
            }
        }

        stage ('Build') {
            steps {
                sh 'mvn -Dmaven.test.failure.ignore=true install' 
            }
           
        }
    }
}
