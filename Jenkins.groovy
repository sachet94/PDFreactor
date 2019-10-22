pipeline {
    agents any
    stages {
        stage ('Initialize') {
            sh ```
            echo "PATH = $(PATH)"
            echo "M2_HOME = $(M2_HOME)"
            ```
        }
    }
    stage ('Build') {
        steps {
            echo "Hello World"
        }
    }
}

//this file is in code.
// This Project type will be pipeline
// In pipeline Project go to pipeline where you can paste the groovy code or give the path og the code. Select git and repo url.
// Script path : will be Scriptname 


// Jenkinsfile (Declarative Pipeline)
pipeline {
    agent any //Jenkins node if want to execute using specific node we need to mention the node name. 

    stages {
        stage('Build') {     //Name can be anything 
            steps {
                echo 'Building..'
            }
        }
        stage('Test') {
            steps {
                echo 'Testing..'
            }
        }
        stage('Deploy') {
            steps {
                echo 'Deploying....'
            }
        }
    }
}

Automate the Pipeline


pipeline{
    agent any

    stages {
        stage('Build') {
            steps
            sh 'mvn clean package'
        }
        post{   //here post means post build actions
            success{     //here "success is a condition which means the build will go only if the build goes success"
                echo: 'Archiving artifacts now'
                archiveArtifacts artifacts : '**/*.war'
                   }
            }
            }
        stage ('Deploy Build') {   //we are adding a downstream by below syntax
            steps {
                build job : 'name of the project that we to do after above are done'
            }
        }
        

        stage('Deploy to prduction') {
            steps {
                timeout (time: 5, unit: 'DAY') //units should be in capitals
                    input message: 'Approve PRODUCTION Deployment'
                }

                build job: 'Job name' //this will again be a downstream job in the pipeline
            
            }

            post{
                success{
                    echo 'Deployment on PRODUCTION is successful'
                }
                failure{
                    echo 'Deployment to PRODUCTION is Failure'
                }
            }
        }
    

    

//Link to find how to use jenkinfile https://jenkins.io/doc/book/pipeline/jenkinsfile/ &  https://jenkins.io/doc/book/pipeline/syntax/ 

SLAVE:
It can be started by ssh.or start directly from slave machine using command line.
