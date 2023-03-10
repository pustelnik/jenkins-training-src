pipeline {
    agent any

    stages {
        stage('Hello') {
            steps {
                echo 'Hello World'
            }
        }
        // run jobs in parallel and wait for completion
        stage('Run jobs in parallel') {
            parallel {
                stage('job 01') {
                    steps {
                        build '01-simple'
                    }
                }
                stage('job 02') {
                    steps {
                        build '02-parallel'
                    }
                }
                stage('job 03') {
                    steps {
                        build '03-conditionals'
                    }
                }
                stage('job 08') {
                    steps {
                        build job: '08-parameters', parameters: [
                            string(name: 'PERSON', value: 'Mr Jenkins'),
                            text(name: 'BIOGRAPHY', value: ''),
                            booleanParam(name: 'TOGGLE', value: true),
                            string(name: 'CHOICE', value: 'One'),
                            password(name: 'PASSWORD', description: 'Enter a password', value: '<DEFAULT>')
                        ]
                    }
                }
            }
        }
    }
}
