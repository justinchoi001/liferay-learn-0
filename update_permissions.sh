#!/bin/bash

for file_name in `find . -type f -name "*.sh"`
do
	chmod 744 ${file_name}
done

for file_name in `find . -type f -name "gradlew"`
do
	chmod 744 ${file_name}
done