#! /bin/bash
# Variables
DOCKER_TAG=$1
DOCKERRUN_FILE="Dockerrun.aws.json"
DOCKERCFG=".dockercfg"
DOCKER_CONFIG="/home/travis/.docker/config.json"
EB_BUCKET=$2
EB_ENV=$3
PREFIX="deploy/$DOCKER_TAG"
APP_NAME=$4
DEPLOYMENT_REGION=$5
IMAGE_NAME=$6
DEPLOYMENT_ENV_NAME=$7
DOCKER_USERNAME=$8
DOCKER_REPOSITORY=$9
DOCKER_PASSWORD=${10}
DOCKER_EMAIL=${11}
DOCKER_IMAGE="$DOCKER_USERNAME/$DOCKER_REPOSITORY"

echo "::::: Creating Dockerrun.aws.json file :::::"
# Replace vars in the DOCKERRUN_FILE 
ls
#cat $DOCKERRUN_FILE
# | sed 's||'$EB_BUCKET'|g' \
#  | sed 's||'$DOCKER_IMAGE'|g' \
#  | sed 's||'$DOCKER_TAG'|g' \
#  > $DOCKERRUN_FILE
#sleep 30
aws s3 cp $DOCKERRUN_FILE s3://$EB_BUCKET/$PREFIX/$DOCKERRUN_FILE
echo "::::: Copied :::::"
sleep 30
echo "::::: Creating new Elastic Beanstalk version :::::"
# Run aws command to create a new EB application with label
aws elasticbeanstalk create-application-version \
    --region=$DEPLOYMENT_REGION \
    --application-name $APP_NAME \
  --version-label $DOCKER_TAG \
    --source-bundle S3Bucket=$EB_BUCKET,S3Key=$PREFIX/$DOCKERRUN_FILE
  
sleep 30  
echo "::::: Updating Elastic Beanstalk environment :::::"
aws elasticbeanstalk update-environment \
  --environment-id $EB_ENV \
  --environment-name $DEPLOYMENT_ENV_NAME \
  --application-name $APP_NAME \
  --version-label $DOCKER_TAG
echo "::::: Removing file :::::"
sleep 30  
rm $DOCKERCFG
#rm $DOCKERRUN_FILE
