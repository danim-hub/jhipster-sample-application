#!/usr/bin/env groovy

node {
    stage('checkout') {
        checkout scm
    }

    stage('check java') {
        bat "java -version"
    }

    stage('clean') {
        env.JAVA_HOME="${tool 'jdk-8u181'}"
        env.PATH="${env.JAVA_HOME}/bin:${env.PATH}"
        bat "./mvnw.cmd clean"
    }

    stage('backend tests') {
        try {
            bat "./mvnw.cmd test"
        } catch(err) {
            throw err
        } finally {
            junit '**/target/surefire-reports/TEST-*.xml'
        }
    }

    stage('packaging') {
        bat "./mvnw.cmd verify -Pprod -DskipTests"
        archiveArtifacts artifacts: '**/target/*.war', fingerprint: true
    }
}
