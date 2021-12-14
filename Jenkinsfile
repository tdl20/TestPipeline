pipeline {
  agent any

  tools {
    maven 'Maven3.8.4'
  }
  def tomcatWeb = 'C:\\Program Files\\Apache Software Foundation\\Tomcat 10.0_Tomcat10.0\\webapps'
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
    stage('SonarQube analysis') {
      steps {
        withSonarQubeEnv(credentialsId: '	sonarqube-token', installationName: 'SonarQube') {
           bat 'mvn sonar:sonar -Dsonar.dependencyCheck.jsonReportPath=target/dependency-check-report.json -Dsonar.dependencyCheck.xmlReportPath=target/dependency-check-report.xml -Dsonar.dependencyCheck.htmlReportPath=target/dependency-check-report.html'
        }
      }
    }
    stage('Deploy') {
      steps {
         bat "copy target\\Milestone1B-0.0.1-SNAPSHOT.war \"${tomcatweb}\\Milestone1b.war\""
      }
    }
  }
}
