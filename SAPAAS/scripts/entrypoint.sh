#!/bin/bash
if [[ X"" != X"$IMPORT_BATCH_SIZE" ]];then
  sed -i "s#import-batch-size#$IMPORT_BATCH_SIZE#g" /app/application/apache-tomcat-task/webapps/SAPAAS/configex/common/WEBEXCONFIG.xml
else
  sed -i "s#import-batch-size#2000#g" /app/application/apache-tomcat-task/webapps/SAPAAS/configex/common/WEBEXCONFIG.xml
fi 
sed -i "s#callback-url#$IPADDR#g" /app/application/apache-tomcat-task/webapps/SAPAAS/configex/common/WEBEXCONFIG.xml
sed -i "s#DBUSERNAME#$DBUSERNAME#g" /app/application/apache-tomcat-task/webapps/SAPAAS/META-INF/context.xml
sed -i "s#DBPASSWORD#$DBPASSWORD#g" /app/application/apache-tomcat-task/webapps/SAPAAS/META-INF/context.xml
sed -i "s#DBSERVERIP#$DBSERVERIP#g" /app/application/apache-tomcat-task/webapps/SAPAAS/META-INF/context.xml
sed -i "s#DBSERVERPORT#$DBSERVERPORT#g" /app/application/apache-tomcat-task/webapps/SAPAAS/META-INF/context.xml
sed -i "s#COREDBNAME#$COREDBNAME#g" /app/application/apache-tomcat-task/webapps/SAPAAS/META-INF/context.xml

sed -i "s#DBUSERNAME#$DBUSERNAME#g" /app/application/apache-tomcat-task/webapps/SAPAAS/WEB-INF/classes/saps-apimode.properties
sed -i "s#DBPASSWORD#$DBPASSWORD#g" /app/application/apache-tomcat-task/webapps/SAPAAS/WEB-INF/classes/saps-apimode.properties
sed -i "s#DBSERVERIP#$DBSERVERIP#g" /app/application/apache-tomcat-task/webapps/SAPAAS/WEB-INF/classes/saps-apimode.properties
sed -i "s#DBSERVERPORT#$DBSERVERPORT#g" /app/application/apache-tomcat-task/webapps/SAPAAS/WEB-INF/classes/saps-apimode.properties
sed -i "s#COREDBNAME#$COREDBNAME#g" /app/application/apache-tomcat-task/webapps/SAPAAS/WEB-INF/classes/saps-apimode.properties

cp -rf /taskfile/* /app/application/taskfile/
cp -rf /taskfile/* /app/application/taskfile/
rm -rf /app/TEMPL
cp -rf /app/TEMPL_APP /app/TEMPL
rm -rf /app/application/taskfile/TEMPL
cp -rf /app/TEMPL_TASK /app/application/taskfile/TEMPL
rm -rf /app/application/taskfile/tool/pyutils/githelp.py.ftl
cp -rf /app/githelp.py.ftl /app/application/taskfile/tool/pyutils/githelp.py.ftl
source /etc/locale.conf
source /etc/profile
echo "root:Abcd@1234" | chpasswd
nohup /usr/sbin/sshd -D >/dev/null 2>&1 &
nohup /usr/sbin/httpd >/dev/null 2>&1 &
/app/application/apache-tomcat-task/bin/startup.sh
tail -f /app/application/apache-tomcat-task/logs/catalina.out