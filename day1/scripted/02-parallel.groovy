node {
    stage('Sequential stage') {
        println('...')
        sh 'sleep 2'
    }
    def jobs = [
        'job1': {
            node('jdk17') {
                stage('job1') {
                    println('inside job1')
                    sh 'sleep 10'
                }
            }
        },
        'job2': {
            node('jdk17') {
                stage('job2') {
                    println('inside job2')
                    sh 'sleep 4'
                }
            }
        }
    ]
    parallel jobs
    stage('Sequential stage 2') {
        println('...')
        sh 'sleep 2'
    }
}

