def names = [
    '01-simple',
    '02-parallel',
    '03-catch-error',
]

names.each { name ->
    pipelineJob("training/scripted/${name}") {
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
                scriptPath("day1/scripted/${name}.groovy")
            }
        }
    }
}

