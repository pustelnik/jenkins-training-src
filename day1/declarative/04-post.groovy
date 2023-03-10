pipeline {
    agent any
    parameters {
        booleanParam 'fail'
    }
    stages {
        stage('Example') {
            steps {
                echo 'Hello World'
            }
        }
        stage('Fail') {
            when {
                params?.fail
            }
            steps {
                sh 'exit -1'
            }
        }
    }
    post { 
        always { 
            echo 'I will always say Hello again!'
        }
        success {
            echo 'congrats, success!'
        }
        aborted {
            echo 'aborted build'
        }
        failure {
            echo 'after failure'
        }
        regression {
            echo 'oh no, regression!'
        }
    }
}