pipeline {
  agent any

  tools {
    maven 'Maven3.8.4'
  }

  stages {
    stage('Build') {
      steps {
          bat "mvn -Dmaven.test.failure.ignore=true clean package"
        }
      }
     stage ('OWASP Dependency-Check Vulnerabilities') {
      steps {
          bat 'mvn dependency-check:check'

        dependencyCheckPublisher pattern: 'target/dependency-check-report.xml'
      }
    }
  }
}
