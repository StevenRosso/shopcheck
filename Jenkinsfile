pipeline {
    agent any

    options {
        buildDiscarder(logRotator(numToKeepStr: '10'))
    }

    stages {
        stage('Check tools') {
            steps {
                sh 'java -version'
                sh 'mvn -version'
            }
        }
        stage('Run Cucumber tests') {
            steps {
                sh 'mvn -B test "-Dcucumber.filter.tags=not @ui"'
            }
        }
    }

    post {
        always {
            junit testResults: 'target/cucumber-reports/cucumber.xml', allowEmptyResults: true
            archiveArtifacts artifacts: 'target/cucumber-reports/**', allowEmptyArchive: true
        }
    }
}
