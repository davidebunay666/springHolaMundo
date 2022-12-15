pipeline {
    agent any

    stages {
        stage('SCM') {
            steps {
               git branch: 'main', url: 'https://github.com/davidebunay666/springHolaMundo'
            }
        }

    
    stage ('Build Java maven') {
           steps {
            //bat(script: 'dir' , returnStdout:true);
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
       
    stage ("Deploy AKS") {
           steps {
            //bat(script: 'az aks get-credentials --resource-group devops --name devops-cluster  & kubectl config get-contexts --kubeconfig=%KUBE_PATH_CONFIG%', returnStdout: true);
            //bat(script: 'kubectl config use-context devops-cluster  --kubeconfig=%KUBE_PATH_CONFIG%', returnStdout: true);
            //bat(script: 'kubectl apply -f k8s.yml --kubeconfig=%KUBE_PATH_CONFIG%', returnStdout: true);         
           }
       }
    
    
    }
}
