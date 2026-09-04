pipeline {
  agent any
  tools { maven 'Maven-3.9' ; jdk 'JDK-17' }
  stages {
    stage('Checkout') { steps { checkout scm } }
    stage('Test') { steps { sh 'mvn clean test -Dbrowser=chrome -Denv=staging -Dgroups=smoke' } }
  }
  post {
    always { archiveArtifacts artifacts: 'reports/**/*.html,reports/screenshots/**/*.png,logs/**/*.log', allowEmptyArchive: true }
    success { slackSend channel: '#qa-alerts', message: "Selenium smoke passed: ${env.BUILD_URL}" }
    failure { mail to: 'qa@example.com', subject: "Selenium failed ${env.BUILD_NUMBER}", body: "Check ${env.BUILD_URL}" }
  }
}
