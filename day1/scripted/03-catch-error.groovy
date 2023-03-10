node {
    stage('Build') {
        println 'building...'
    }
    stage('Test') {
        try {
            sh 'exit -1'
        } catch(exc) {
            println 'oh no! some test failed!'
        }
    }
    stage('Deploy') {
        println 'Deploying'
    }
}