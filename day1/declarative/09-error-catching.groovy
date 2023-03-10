pipeline {
    agent any

    stages {
        stage('Hello') {
            steps {
                echo 'Hello World'
            }
        }
        stage('Errors...') {
            steps {
                catchError(buildResult: 'SUCCESS', message: 'oh no!', stageResult: 'FAILURE') {
                    sh 'exit -1'
                }
            }
        }
        stage('Bye') {
            steps {
                echo 'bye bye'
            }
        }
    }
}
