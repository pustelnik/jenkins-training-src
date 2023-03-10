def runTests = false

pipeline {
    agent any
    environment {
        DEPLOY_TO = 'staging'
    }
    stages {
        stage('Example Build') {
            steps {
                echo 'Hello World'
                withEnv(['TEST=wartosc', 'DRUGA=2']) {
                    sh '''
                        echo ${TEST}
                        echo ${DRUGA}
                    '''
                }
            }
        }
        stage('Example Test') {
            when {
                expression { runTests }
            }
            steps {
                echo 'Running tests'
            }
        }
        stage('Example Deploy') {
            when {
                // branch 'production'
                anyOf {
                    environment name: 'DEPLOY_TO', value: 'production'
                    environment name: 'DEPLOY_TO', value: 'staging'
                }
            }
            steps {
                echo 'Deploying'
            }
        }
    }
}