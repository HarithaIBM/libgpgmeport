node('linux')
{
  stage ('Poll') {
    checkout([
      $class: 'GitSCM',
      branches: [[name: '*/main']],
      doGenerateSubmoduleConfigurations: false,
      extensions: [],
      userRemoteConfigs: [[url: 'https://github.com/ZOSOpenTools/libgpgmeport.git']]])
  }
  stage('Build') {
    build job: 'Port-Pipeline', parameters: [string(name: 'PORT_GITHUB_REPO', value: 'https://github.com/ZOSOpenTools/libgpgmeport.git'), string(name: 'PORT_DESCRIPTION', value: 'GnuPG Made Easy (GPGME) is a C language library that allows to add' ), string(name: 'BUILD_LINE', value: 'DEV') ]
  }
}
