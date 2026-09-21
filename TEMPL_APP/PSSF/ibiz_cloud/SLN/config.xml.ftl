<#ibiztemplate>
TARGET=PSSYSTEM
</#ibiztemplate>
<#if pub.getPSDeployCenter()?? && sysrun.getRunMode()??>
<#if pub.getPSDeployCenter().getCIType()?? && (pub.getPSDeployCenter().getCIType()=="JENKINS") >
<#if sysrun.getRunMode() == "STARTMSAPI">
<#assign depapi = sysrun.getPSDevSlnMSDepAPI()>
<#assign configId = depapi.getId()>
<#assign config = "api"+depapi.getName()>
<#assign depnode = sysrun.getPSDevSlnMSDepAPI().getPSDCMSPlatformNode()>
<#assign depplatform = sysrun.getPSDevSlnMSDepAPI().getPSDCMSPlatform()>
<#elseif sysrun.getRunMode() == "STARTMSAPP">
<#assign depapp = sysrun.getPSDevSlnMSDepApp()>
<#assign configId = depapp.getId()>
<#assign config = "app"+depapp.getName()>
<#assign depnode = sysrun.getPSDevSlnMSDepApp().getPSDCMSPlatformNode()>
<#assign depplatform = sysrun.getPSDevSlnMSDepApp().getPSDCMSPlatform()>
</#if>
<#if sys.getPSSVNInstRepo().getGitBranch()?? && sys.getPSSVNInstRepo().getGitBranch()!="">
      <#assign branch=sys.getPSSVNInstRepo().getGitBranch()>
    <#else>
      <#assign branch='master'>
</#if>
<?xml version='1.1' encoding='UTF-8'?>
<project>
  <actions/>
  <description>${sys.codeName}</description>
  <keepDependencies>false</keepDependencies>
  <properties>
    <hudson.model.ParametersDefinitionProperty>
      <parameterDefinitions>
        <hudson.model.StringParameterDefinition>
          <name>para1</name>
          <description></description>
          <defaultValue>para1</defaultValue>
          <trim>false</trim>
        </hudson.model.StringParameterDefinition>
        <hudson.model.StringParameterDefinition>
          <name>para2</name>
          <description></description>
          <defaultValue>para2</defaultValue>
          <trim>false</trim>
        </hudson.model.StringParameterDefinition>      
        <hudson.model.StringParameterDefinition>
          <name>para3</name>
          <description></description>
          <defaultValue>para3</defaultValue>
          <trim>false</trim>
        </hudson.model.StringParameterDefinition>         
        <hudson.model.StringParameterDefinition>
          <name>para4</name>
          <description></description>
          <defaultValue>para4</defaultValue>
          <trim>false</trim>
        </hudson.model.StringParameterDefinition>         
        <hudson.model.StringParameterDefinition>
          <name>para5</name>
          <description></description>
          <defaultValue>para5</defaultValue>
          <trim>false</trim>
        </hudson.model.StringParameterDefinition>              
      </parameterDefinitions>
    </hudson.model.ParametersDefinitionProperty>
  </properties>
  <scm class="hudson.scm.NullSCM"/>
  <canRoam>true</canRoam>
  <disabled>false</disabled>
  <blockBuildWhenDownstreamBuilding>false</blockBuildWhenDownstreamBuilding>
  <blockBuildWhenUpstreamBuilding>false</blockBuildWhenUpstreamBuilding>
  <triggers/>
  <concurrentBuild>false</concurrentBuild>
  <builders>
    <hudson.tasks.Shell>
      <command>
      BUILD_ID=DONTKILLME
      source /etc/profile
      rm -rf ${sys.codeName?lower_case}
	  git clone -b ${branch} $para2 ${sys.codeName?lower_case}/
      export NODE_OPTIONS=--max-old-space-size=4096
      cd ${sys.codeName?lower_case}/
<#if sysrun.getRunMode() == "STARTMSAPP">
      mkdir -p /var/lib/jenkins/appcache/${depapp.getId()}
      if [ -e app_${pub.getPSApplication().getPKGCodeName()}/.dynamic ]
      then
          cd app_${pub.getPSApplication().getPKGCodeName()}
      else
          cd app_${pub.getPSApplication().getPKGCodeName()}/app
      fi
<#if depapp.getUserParam("dockerimage","")?? && depapp.getUserParam("dockerimage","")!="">    
      sed -i "s#dstimage#${depapp.getUserParam("dockerimage","")}#g" swarm.yaml
      docker -H $para1 stack deploy --compose-file=swarm.yaml ${depplatform.getName()} --with-registry-auth    
<#else>
<#if pub.getPSDeployCenter().getCDType()?? && (pub.getPSDeployCenter().getCDType()=="SWARM") >           
      sed -i "s#dstimage#$para5#g" swarm.yaml      
      if [[ $para3 = all ]];then
          mv Dockerfile-ALL Dockerfile      
          sed -i "s#/api#/<#if sys.getDeploySysId()??><#if (sys.getDeploySysId()?length gt 16)>${sys.getName()?lower_case}<#else>${sys.getDeploySysId()?lower_case}</#if><#else>${sys.getName()?lower_case}</#if>__${pub.getPSApplication().getPKGCodeName()?lower_case}#g" src/environments/environment.ts  
          sed -i "s#outputDir#//outputDir#g" vue.config.js 
          yarn
          ln -s /var/lib/jenkins/appcache/${depapp.getId()} node_modules/.cache
          yarn build
      else
          if [ -e .dynamic ]
          then
              mv <#if pub?? && pub.getModelFolder?? && pub.getModelFolder()??> ../${pub.getModelFolder()}/PSSYSAPPS/${pub.getPSApplication().getCodeName()}</#if> model
          else
              mv <#if pub?? && pub.getModelFolder?? && pub.getModelFolder()??> ../../${pub.getModelFolder()}/PSSYSAPPS/${pub.getPSApplication().getCodeName()}</#if> model
          fi
          sed -i "s#srcimagename#$para4#g" Dockerfile-MODEL
          mv Dockerfile-MODEL Dockerfile
      fi          
      docker build -t $para5 .
      docker push $para5
      docker -H $para1 stack deploy --compose-file=swarm.yaml ${depplatform.getName()} --with-registry-auth
<#elseif  pub.getPSDeployCenter().getCDType()?? && (pub.getPSDeployCenter().getCDType()=="K8S") >      
      if [[ $para3 = all ]];then
          mv Dockerfile-ALL Dockerfile      
          sed -i "s#/api#/<#if sys.getDeploySysId()??><#if (sys.getDeploySysId()?length gt 16)>${sys.getName()?lower_case}<#else>${sys.getDeploySysId()?lower_case}</#if><#else>${sys.getName()?lower_case}</#if>__${pub.getPSApplication().getPKGCodeName()?lower_case}#g" src/environments/environment.ts     
          sed -i "s#outputDir#//outputDir#g" vue.config.js 
          yarn
          ln -s /var/lib/jenkins/appcache/${depapp.getId()} node_modules/.cache
          yarn build
      else
          if [ -e .dynamic ]
          then
              mv <#if pub?? && pub.getModelFolder?? && pub.getModelFolder()??> ../${pub.getModelFolder()}/PSSYSAPPS/${pub.getPSApplication().getCodeName()}</#if> model
          else
              mv <#if pub?? && pub.getModelFolder?? && pub.getModelFolder()??> ../../${pub.getModelFolder()}/PSSYSAPPS/${pub.getPSApplication().getCodeName()}</#if> model
          fi  
          sed -i "s#srcimagename#$para4#g" Dockerfile-MODEL
          mv Dockerfile-MODEL Dockerfile
      fi
      docker build -t $para5 .
      docker push $para5
<#else>
      echo &apos;echo &quot;$para1&quot;&apos; &gt; apppasswd.sh
      chmod -R 777 *
      setsid env SSH_ASKPASS=&apos;./apppasswd.sh&apos; DISPLAY=&apos;none:0&apos; ssh ${depnode.getSSHUserName()}@${depnode.getSSHIPAddr()} &quot;mkdir -p ${depnode.getWorkshopPath()}/${configId}&quot;
      setsid env SSH_ASKPASS=&apos;./apppasswd.sh&apos; DISPLAY=&apos;none:0&apos; scp -r ${pub.getCodeName()?lower_case}-app-${pub.getPSApplication().getPKGCodeName()?lower_case}.jar ${depnode.getSSHUserName()}@${depnode.getSSHIPAddr()}:${depnode.getWorkshopPath()}/${configId}
      setsid env SSH_ASKPASS=&apos;./apppasswd.sh&apos; DISPLAY=&apos;none:0&apos; ssh ${depnode.getSSHUserName()}@${depnode.getSSHIPAddr()} &quot;ps -ef | grep &apos;${depnode.getWorkshopPath()}/${configId}&apos;| tr -s &apos; &apos;|cut -d&apos; &apos; -f2,8,9  | grep -v grep | grep &apos;jar&apos; | cut -d&apos; &apos; -f1|xargs  --no-run-if-empty kill -9&quot;
      setsid env SSH_ASKPASS=&apos;./apppasswd.sh&apos; DISPLAY=&apos;none:0&apos; ssh ${depnode.getSSHUserName()}@${depnode.getSSHIPAddr()} &quot;source /etc/profile;source ~/.bash_profile; nohup java -jar -Xms512m -Xmx1024m -XX:PermSize=128M -XX:MaxPermSize=128m ${depnode.getWorkshopPath()}/${configId}/${pub.getCodeName()?lower_case}-app-${pub.getPSApplication().getPKGCodeName()?lower_case}.jar &gt;&gt;${depnode.getWorkshopPath()}/${configId}/${sys.codeName?lower_case}_${config?lower_case}-`date --date=&apos;0 days ago&apos; +%Y-%m-%d`.log 2&gt;&amp;1 &amp;&quot;
</#if>
</#if>
</#if>
<#if sysrun.getRunMode() == "STARTMSAPI">   
<#if depapi.getUserParam("dockerimage","")?? && depapi.getUserParam("dockerimage","")!="">    
      cd ${pub.getCodeName()?lower_case}-provider 
      sed -i "s#dstimage#$para5#g" pom.xml
      sed -i "s#dstimage#$para5#g" src/main/docker/${pub.getCodeName()?lower_case}-provider-${pub.getPSSysServiceAPI().getCodeName()?lower_case}.yaml      
      docker -H $para1 stack deploy --compose-file=src/main/docker/${pub.getCodeName()?lower_case}-provider-${pub.getPSSysServiceAPI().getCodeName()?lower_case}.yaml ${depplatform.getName()} --with-registry-auth      
<#else>
      mvn clean package -P${pub.getPSSysServiceAPI().getCodeName()?lower_case}
      mvn install -P${pub.getPSSysServiceAPI().getCodeName()?lower_case}
<#if pub.getPSDeployCenter().getCDType()?? && (pub.getPSDeployCenter().getCDType()=="SWARM") >           
      cd ${pub.getCodeName()?lower_case}-provider
      sed -i "s#dstimage#$para5#g" pom.xml 
      sed -i "s#dstimage#$para5#g" src/main/docker/${pub.getCodeName()?lower_case}-provider-${pub.getPSSysServiceAPI().getCodeName()?lower_case}.yaml 
<#if depapi.getUserParam("multiplatform","")?? && depapi.getUserParam("multiplatform","")=="true">   
      mvn -P${pub.getPSSysServiceAPI().getCodeName()?lower_case} exec:exec@prepare
      mvn -P${pub.getPSSysServiceAPI().getCodeName()?lower_case} exec:exec@buildpush      
<#else>   
      mvn -P${pub.getPSSysServiceAPI().getCodeName()?lower_case} docker:build
      mvn -P${pub.getPSSysServiceAPI().getCodeName()?lower_case} docker:push
</#if>     
      docker -H $para1 stack deploy --compose-file=src/main/docker/${pub.getCodeName()?lower_case}-provider-${pub.getPSSysServiceAPI().getCodeName()?lower_case}.yaml ${depplatform.getName()} --with-registry-auth      
<#elseif  pub.getPSDeployCenter().getCDType()?? && (pub.getPSDeployCenter().getCDType()=="K8S") >
      cd ${pub.getCodeName()?lower_case}-provider
      sed -i "s#dstimage#$para5#g" pom.xml
      sed -i "s#dstimage#$para5#g" src/main/docker/${pub.getCodeName()?lower_case}-provider-${pub.getPSSysServiceAPI().getCodeName()?lower_case}-k8s.yaml 
<#if depapi.getUserParam("multiplatform","")?? && depapi.getUserParam("multiplatform","")=="true">   
      mvn -P${pub.getPSSysServiceAPI().getCodeName()?lower_case} exec:exec@prepare
      mvn -P${pub.getPSSysServiceAPI().getCodeName()?lower_case} exec:exec@buildpush      
<#else>   
      mvn -P${pub.getPSSysServiceAPI().getCodeName()?lower_case} docker:build
      mvn -P${pub.getPSSysServiceAPI().getCodeName()?lower_case} docker:push
</#if> 
      set +e
      kubectl --kubeconfig ~/shanghai-demo-01 delete -f src/main/docker/${pub.getCodeName()?lower_case}-provider-${pub.getPSSysServiceAPI().getCodeName()?lower_case}-k8s.yaml -n ${depplatform.getName()?lower_case}
      set -e
      kubectl --kubeconfig ~/shanghai-demo-01 create -f src/main/docker/${pub.getCodeName()?lower_case}-provider-${pub.getPSSysServiceAPI().getCodeName()?lower_case}-k8s.yaml -n ${depplatform.getName()?lower_case}
<#else>
      echo &apos;echo &quot;$para1&quot;&apos; &gt; apppasswd.sh
      chmod -R 777 *
      setsid env SSH_ASKPASS=&apos;./apppasswd.sh&apos; DISPLAY=&apos;none:0&apos; ssh ${depnode.getSSHUserName()}@${depnode.getSSHIPAddr()} &quot;mkdir -p ${depnode.getWorkshopPath()}/${configId}&quot;
      setsid env SSH_ASKPASS=&apos;./apppasswd.sh&apos; DISPLAY=&apos;none:0&apos; scp -r ${pub.getCodeName()?lower_case}-provider-${pub.getPSSysServiceAPI().getCodeName()?lower_case}.jar ${depnode.getSSHUserName()}@${depnode.getSSHIPAddr()}:${depnode.getWorkshopPath()}/${configId}
      setsid env SSH_ASKPASS=&apos;./apppasswd.sh&apos; DISPLAY=&apos;none:0&apos; ssh ${depnode.getSSHUserName()}@${depnode.getSSHIPAddr()} &quot;ps -ef | grep &apos;${depnode.getWorkshopPath()}/${configId}&apos;| tr -s &apos; &apos;|cut -d&apos; &apos; -f2,8,9  | grep -v grep | grep &apos;jar&apos; | cut -d&apos; &apos; -f1|xargs  --no-run-if-empty kill -9&quot;
      setsid env SSH_ASKPASS=&apos;./apppasswd.sh&apos; DISPLAY=&apos;none:0&apos; ssh ${depnode.getSSHUserName()}@${depnode.getSSHIPAddr()} &quot;source /etc/profile;source ~/.bash_profile; nohup java -jar -Xms512m -Xmx1024m -XX:PermSize=128M -XX:MaxPermSize=128m ${depnode.getWorkshopPath()}/${configId}/${pub.getCodeName()?lower_case}-provider-${pub.getPSSysServiceAPI().getCodeName()?lower_case}.jar &gt;&gt;${depnode.getWorkshopPath()}/${configId}/${sys.codeName?lower_case}_${config?lower_case}-`date --date=&apos;0 days ago&apos; +%Y-%m-%d`.log 2&gt;&amp;1 &amp;&quot;
</#if>
</#if>
</#if>
      </command>
    </hudson.tasks.Shell>
  </builders>
  <publishers>
    <hudson.plugins.ws__cleanup.WsCleanup plugin="ws-cleanup@0.34">
      <patterns class="empty-list"/>
      <deleteDirs>false</deleteDirs>
      <skipWhenFailed>false</skipWhenFailed>
      <cleanWhenSuccess>true</cleanWhenSuccess>
      <cleanWhenUnstable>true</cleanWhenUnstable>
      <cleanWhenFailure>true</cleanWhenFailure>
      <cleanWhenNotBuilt>true</cleanWhenNotBuilt>
      <cleanWhenAborted>true</cleanWhenAborted>
      <notFailBuild>false</notFailBuild>
      <cleanupMatrixParent>false</cleanupMatrixParent>
      <externalDelete></externalDelete>
    </hudson.plugins.ws__cleanup.WsCleanup>
  </publishers>
  <buildWrappers/>
</project>
</#if>
</#if>
