#!/usr/bin/env bash

taskName=task$1
package=org.pitrecki.codewars
clasName=$2

echo "Attempt to create task folder $taskName"
mkdir $taskName

cd $taskName
pwd

echo "Attempt to init gradle project $taskName"
gradle init --type java-application --test-framework junit --project-name $taskName --dsl groovy --package $package

echo "Removing not necessary files in $taskName"
rm -rf .gradle gradle .gitignore gradlew gradlew.bat settings.gradle App*
find . -name 'App*.java' -type f -delete

echo "Apply changes for build.gradle"
echo "apply plugin: 'application'"  > build.gradle
echo "mainClassName = '$package.$2'"  >> build.gradle

echo "Adding unstashed files to git repo"
git add .

echo "Add $taskName in settings.gradle"
echo "include '$taskName'" >>  ../settings.gradle
