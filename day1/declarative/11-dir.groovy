pipeline {
    agent any

    stages {
        stage('Create dir') {
            steps {
                sh 'mkdir test; ls -al'
            }
        }
        stage('Create file in test dir') {
            steps {
                dir('test') {
                    sh '''
                        pwd
                        echo "test" > test.txt
                        ls -al
                    '''
                }
                sh '''
                    echo 'outside dir'
                    pwd
                    ls -al
                '''
            }
        }
    }
}
