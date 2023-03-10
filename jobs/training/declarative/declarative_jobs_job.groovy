def names = [
    '01-simple',
    '02-parallel',
    '03-conditionals',
    '04-post',
    '05-options',
    '06-environment',
    '07-matrix',
    '08-parameters',
    '09-error-catching',
    '10-build-job',
    '11-dir',
]

names.each { name ->
    pipelineJob("training/declarative/${name}") {
        definition {
            cpsScm {
                scm {
                    git {
                        remote {
                            // name('remoteB')
                            url('https://github.com/pustelnik/jenkins-training-src.git')
                        }
                        extensions {
                            cleanAfterCheckout()
                        }
                    }
                }
                scriptPath("day1/declarative/${name}.groovy")
            }
        }
    }
}

