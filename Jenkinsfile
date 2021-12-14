def tomcatWeb = '''C:\\Program Files\\Apache Software Foundation\\Tomcat 9.0\\webapps\\Milestone1b.war'''
pipeline {
  agent any

  tools {
    maven 'Maven3.8.4'
  }
  stages {
    stage('Build') {
      steps {
          bat "mvn clean package"
        }
      }
     stage ('OWASP Dependency-Check Vulnerabilities') {
      steps {
          bat 'mvn dependency-check:check'

        dependencyCheckPublisher pattern: 'target/dependency-check-report.xml'
      }
    }
    stage('SonarQube analysis') {
      steps {
        withSonarQubeEnv(credentialsId: '	sonarqube-token', installationName: 'SonarQube') {
           bat 'mvn sonar:sonar -Dsonar.dependencyCheck.jsonReportPath=target/dependency-check-report.json -Dsonar.dependencyCheck.xmlReportPath=target/dependency-check-report.xml -Dsonar.dependencyCheck.htmlReportPath=target/dependency-check-report.html'
        }
      }
    }
    stage('Deploy') {
      steps {
         bat '''copy target\\Milestone1B.war "C:\\Program Files\\Apache Software Foundation\\Tomcat 9.0\\webapps\\Milestone1b.war"'''
      }
    }
  }
}
