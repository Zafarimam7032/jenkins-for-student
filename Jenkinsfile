pipeline
{
agent any

stages{

stage("this is cleaning stage"){
steps{
bat "mvn clean"
}
}
stage("this is testing stage"){
steps{
bat "mvn test"
}
}
stage("this is package  stage"){
steps{
bat "mvn package"
}
}
}
}


