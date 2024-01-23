/*
    CREDENCIALES NECESARIAS
    - SonarQube     (Token de acceso)
    - Github        (Usuario y clave)
    - DockerHub     (Usuario y clave)
    - Kubernetes    (Token del service account de Jenkins)

    HERRAMIENTAS NECESARIAS
    - Java 20
    - Docker 24.0.2 (Cualquier versión que soporte --password-stdin)
    - Maven 3.9.3
    - NodeJS 16.20.1

    PLUGINS NECESARIOS
    - Slack
    - Docker
    - Kubernetes
    - JUnit
    - EmailText

    CONSIDERACIONES
    * Se debe configurar como multibranch pipeline
    * Deben existir las ramas master y develop
    * Se debe configurar la cloud de kubernetes para el acceso al servidor
 */

def ARTIFACT_ID
def IDENTIFICADOR_PROYECTO
def IDENTIFICADOR_UNICO_BUILD
def RAMA_PARA_CLONAR

pipeline {

agent any

   tools {
        // Install the Maven version configured as "M3" and add it to the path.
        maven "maven3.8.8"
        jdk 'java21'
        dockerTool 'docker-2'
    }

    environment {

        HORA_DESPLIEGUE = sh(returnStdout: true, script: "date '+%A %W %Y %X'").trim()

        GITHUB_DESPLIEGUE_URL = "https://github.com/Facundodg/Generar-Sello.git"

        GITHUB_CREDENCIALES = "github"
        DOCKERHUB_CREDENCIALES = "dockerhub"
        KUBERNETES_CREDENCIALES = "k8s-jenkins-account-15"
        SONARQUBE_CREDENCIALES = 'sonarqube'
        PUERTO_EXTERNO = 5050

        CANAL_SLACK = "#canal-slack"            // TODO: Por reemplazar
        CORREO_A_NOTIFICAR = "dim@gmail.com"    // TODO: Por reemplazar

        CARPETA_APLICACION = './'
        //CARPETA_DESPLIEGUE = 'despliegue'

    }

   stages {



    stage('Message start deploy') {

        steps {

            discordSend description: "Inicio de deploy!!!", footer: "Inicado", link: env.BUILD_URL, result: currentBuild.currentResult, title: "Deploy Api-habilitaciones", webhookURL: "https://discord.com/api/webhooks/1173648912838561922/iB8YUryvKbcj66EWQa2e6161BDuygkfaMx57VUalxPnDAMvoRHcYKxJTaxV4nfBEdoxi"

        }

    }

    stage('Iniciando variables') {

        steps {

            dir("${CARPETA_APLICACION}"){

                script {

                    PROYECTO_VERSION = sh(returnStdout: true, script: 'mvn help:evaluate -Dexpression=project.version -q -DforceStdout')
                    ARTIFACT_ID = sh(script: "mvn help:evaluate -Dexpression=project.artifactId -f pom.xml -q -DforceStdout", returnStdout: true).trim()
                    IDENTIFICADOR_PROYECTO = "${ARTIFACT_ID}:${PROYECTO_VERSION}"
                    IDENTIFICADOR_UNICO_BUILD = "${IDENTIFICADOR_PROYECTO}.${BUILD_NUMBER}"

                }

            }


        }

    }

    /*

    stage('SonarQube Analysis') {

    environment {

        SONAR_SCANNER_HOME = tool 'sonarScaner' //nombre en la configuracion de las tools de jenkins
        SONAR_SERVER = 'sonarqube'
        SONAR_HOST_IP = '172.17.0.4' // IP interna de Docker de SonarQube, debido a que SonarQube corre en un contenedor (docker inspect nombre_contenedo_SonarQube)
        SONAR_PORT = '9000' //puerto donde esta trabajando el contenedor
        SONAR_SRC = 'src/'
        SONAR_ENCODING = 'UTF-8'

    }


    steps {
            dir("${CARPETA_APLICACION}"){
                withSonarQubeEnv(installationName: "${SONAR_SERVER}", credentialsId: "${SONARQUBE_CREDENCIALES}") {
                    sh "${SONAR_SCANNER_HOME}/bin/sonar-scanner \
                        -Dsonar.projectName=${ARTIFACT_ID} \
                        -Dsonar.projectVersion=${PROYECTO_VERSION} \
                        -Dsonar.projectKey=${IDENTIFICADOR_PROYECTO} \
                        -Dsonar.host.url=http://${SONAR_HOST_IP}:${SONAR_PORT} \
                        -Dsonar.sources=${SONAR_SRC} \
                        -Dsonar.java.binaries=. \
                        -Dsonar.sourceEncoding=${SONAR_ENCODING}"
                }
            }
        }
    }
    */
      stage('Tools initialization') {
          steps {
              script {

                    if (env.BRANCH_NAME){

                        RAMA_PARA_CLONAR = env.BRANCH_NAME

                    }
                    else{

                        RAMA_PARA_CLONAR = 'Dev'

                    }


                  DOCKER_VERSION = sh(returnStdout: true, script: 'docker version').trim()
                  JAVA_VERSION = sh(returnStdout: true, script: 'java -version').trim()
                  MAVEN_VERSION = sh(returnStdout: true, script: 'mvn -v').trim()

                  echo "Docker version: ${DOCKER_VERSION}"
                  echo "Java version: ${JAVA_VERSION}"
                  echo "Maven version: ${MAVEN_VERSION}"
              }
          }
      }


      stage('Build Maven') {

            steps{

                    sh "mvn -version"
                    sh "mvn clean package -DskipTests"

                }

            }



     stage('Build and run') {

        environment{
             PUERTO_INTERNO = 5050
             NOMBRE_CONTENEDOR = "habilitacion_api_docker_compose"
             IDENTIFICADOR_IMAGEN = "habilitacion_api_docker_compose"
             SSH_CREDENTIALS = '-----BEGIN OPENSSH PRIVATE KEY-----
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
MEBQ==
-----END OPENSSH PRIVATE KEY-----'
         }

        steps {
            script {

                dir ("${CARPETA_APLICACION}"){
                    // Verifica si existe un archivo Dockerfile en la subcarpeta actual
                    if (!fileExists("Dockerfile")) {
                        error "Dockerfile not found"
                    }


                    //---------ZONA DE PRUEBAS JENKINS----------

                    sh "docker build -t ${IDENTIFICADOR_IMAGEN} ."

                    //ssh desarrollo@172.20.255.15 'cd /home/desarrollo/deploy && docker-compose up -d'
                    //ssh desarrollo@172.20.255.15 'cd /home/desarrollo/deploy && docker-compose up -d'

                    sh 'cat ~/.ssh/known_hosts'

                    sshagent (credentials: ['$SSH_CREDENTIALS']) {
                    sh 'ssh -o StrictHostKeyChecking=no desarrollo@172.20.255.15 && cd /home/desarrollo/deploy && docker-compose up -d'
                    }
                    
                    sh 'docker network connect estaciones_my-habilitacion ${IDENTIFICADOR_IMAGEN}'





















                    


                    

                    //sh "docker run --network estaciones_my-habilitacion -d -p ${PUERTO_EXTERNO}:${PUERTO_INTERNO} --name ${NOMBRE_CONTENEDOR} ${IDENTIFICADOR_IMAGEN}"



                    /*

                    withCredentials([usernamePassword(credentialsId: "${DOCKERHUB_CREDENCIALES}", usernameVariable: 'DOCKERHUB_USERNAME', passwordVariable: 'DOCKERHUB_PASSWORD')]) {

                        // Construye la imagen de Docker usando el nombre y la versión obtenidos
                        sh "docker build -t \$DOCKERHUB_USERNAME/${IDENTIFICADOR_UNICO_BUILD} ."

                        // Sube la imagen a DockerHub
                        sh 'echo $DOCKERHUB_USERNAME'
                        sh 'echo $DOCKERHUB_PASSWORD | docker login -u $DOCKERHUB_USERNAME --password-stdin'
                        sh "docker push \$DOCKERHUB_USERNAME/${IDENTIFICADOR_UNICO_BUILD}"
                    }

                     */
                }

            }
        }

     }

    /*
    stage('Deploy kubernetes'){

        when { //when: Es una directiva condicional que controla cuándo debe ejecutarse este stage
            anyOf { // anyOf: significa que el stage se ejecutará si al menos una de estas condiciones es verdadera

                branch 'master'
                branch 'develop'

                expression{
                    return (RAMA_PARA_CLONAR == 'develop' || RAMA_PARA_CLONAR == 'master') // condicional
                }
            }
        }

        environment {

            CARPETA_MANIFIESTO = "${RAMA_PARA_CLONAR == 'master' ? 'prod' : 'dev'}"
            DIRECCION_DESPLIEGUE = "${WORKSPACE}/${CARPETA_DESPLIEGUE}"

            //para exponer el cluster a este puerto tenes que tirar el siguiente comando en el servidor
            //kubectl proxy --accept-hosts '^.*' --address '0.0.0.0' --port 8445
            KUBE_SERVIDOR = "172.20.255.15:8445" //IP DEL SERVIDOR D ONDE ESTAS DESPLEGADO EL CLUSTER, PUERTO POR DEFECTO

        }

        steps {

            checkout scmGit(branches: [[name: 'master']], extensions: [[$class: 'RelativeTargetDirectory', relativeTargetDir: "${CARPETA_DESPLIEGUE}"]], userRemoteConfigs: [[credentialsId: "${GITHUB_CREDENCIALES_DEPLOY}", url: "${GITHUB_DESPLIEGUE_URL}"]])

            dir ("${CARPETA_DESPLIEGUE}"){

                withCredentials([usernamePassword(credentialsId: "${DOCKERHUB_CREDENCIALES}", usernameVariable: 'DOCKERHUB_USERNAME', passwordVariable: 'DOCKERHUB_PASSWORD')]) {

                    // Actualiza el archivo de despliegue con la última versión de la aplicación
                    sh "sed -i s+\$DOCKERHUB_USERNAME/${ARTIFACT_ID}:TAG+\$DOCKERHUB_USERNAME/${ARTIFACT_ID}:${IDENTIFICADOR_UNICO_BUILD}+g ${DIRECCION_DESPLIEGUE}/${CARPETA_MANIFIESTO}/general/monolito.yaml"

                    sh "cat ${DIRECCION_DESPLIEGUE}/${CARPETA_MANIFIESTO}/general/monolito.yaml"
                }


                withCredentials([string(credentialsId: "${KUBERNETES_CREDENCIALES}", variable: 'KUBE_TOKEN')]) {
                    // sh 'kubectl --token $KUBE_TOKEN --server ${SEVER} --insecure-skip-lts-verify=true apply -f ${FOLDER}'
                    sh "kubectl --token \$KUBE_TOKEN --server ${KUBE_SERVIDOR} apply -R -f ${DIRECCION_DESPLIEGUE}/${CARPETA_MANIFIESTO}/basedatos"
                    sh "kubectl --token \$KUBE_TOKEN --server ${KUBE_SERVIDOR} apply -R -f ${DIRECCION_DESPLIEGUE}/${CARPETA_MANIFIESTO}/general"
                }
            }

        }

    }
    */

    stage('Message finish deploy') {


        steps {

            sh "echo ${HORA_DESPLIEGUE}"

            discordSend description: "Deploy de estaciones echo!!!", footer: "Hora de inicio de despliegue: ${HORA_DESPLIEGUE} ", link: env.BUILD_URL, result: currentBuild.currentResult, title: "Deploy Api-habilitaciones", webhookURL: "https://discord.com/api/webhooks/1173648912838561922/iB8YUryvKbcj66EWQa2e6161BDuygkfaMx57VUalxPnDAMvoRHcYKxJTaxV4nfBEdoxi"

        }

    }

   }


 }
