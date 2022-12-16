pipeline {
    agent any
     environment {
        AWS_ACCESS_KEY_ID     = credentials('jenkins_aws_key_id')
        AWS_SECRET_ACCESS_KEY = credentials('jenkins_aws_key_secret')
    }

    stages {
        stage('SCM') {
            steps {
               git branch: 'main', url: 'https://github.com/davidebunay666/springHolaMundo'
            }
        }

    
    stage ('Build Java maven') {
           steps {
             bat(script: 'dir' , returnStdout:true);
            //bat(script: 'dotnet restore' , returnStdout:true);
            //bat(script: 'dotnet build' , returnStdout:true);
            //bat(script: 'dotnet test' , returnStdout:true);
           }
       }
    
    stage ("Docker Build") {
           
           steps{
             // docker login  
             bat(script: 'docker build -t davidbunay66/springboot:latest .' , returnStdout:true);
             bat(script: 'docker push davidbunay66/springboot:latest' , returnStdout:true);  
           }
       }
       
    stage ('K8S Deploy') {
            steps {
              bat (script:  'aws configure set region us-east-1',returnStdout: true);
              bat(script: 'kubectl config use-context arn:aws:eks:us-east-1:200694411616:cluster/cluster-devops  --kubeconfig=%KUBE_PATH_CONFIG%', returnStdout: true);
              bat(script: 'Kubectl delete --all pods --kubeconfig=%KUBE_PATH_CONFIG% & kubectl apply -f Devops.yaml --kubeconfig=%KUBE_PATH_CONFIG%', returnStdout: true);
            }      
            
    }
    
    
    
    }
}
