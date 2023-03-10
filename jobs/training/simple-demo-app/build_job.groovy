multibranchPipelineJob("training/simple-demo-app/build") {
    branchSources {
        git {
            id('123456789') // IMPORTANT: use a constant and unique identifier
            remote('https://github.com/pustelnik/training-simple-demo-app.git')
        }
    }
    orphanedItemStrategy {
        discardOldItems {
            numToKeep(20)
        }
    }
    factory {
        workflowBranchProjectFactory {
            scriptPath("Jenkinsfile")
        }
    }
}