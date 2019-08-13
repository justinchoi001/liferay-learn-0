#!/bin/bash

copyDir='./commerce/developer-guide/tutorial/_template'

for dir in `find ./commerce/developer-guide/tutorial/ -maxdepth 2 -type d -regex '.*liferay\-....\.zip'`
do
	cp -rf ${copyDir}/. ${dir}
done