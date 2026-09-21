<#if sysrun.getRunParam7()??>
<#assign runparam7 = sysrun.getRunParam7()>
</#if>
<#if sysrun.getPSApplication()??>
<#assign ibizsys_base_file = '${sysrun.getPSApplication().getPFType()}'>
<#assign local_base_file = ''>
<#if sysrun.getPSApplication().getPSPFStyle().getVersionString()?? && (sysrun.getPSApplication().getPSPFStyle().getVersionString()!='')>
    <#assign ibizsys_base_file += '-${sysrun.getPSApplication().getPSPFStyle().getVersionString()}'>
</#if>
<#if sysrun.getPSApplication().getPSPFStyle().getResLocalPath()?? && (sysrun.getPSApplication().getPSPFStyle().getResLocalPath()!='')>
    <#assign ibizsys_base_file = '${sysrun.getPSApplication().getPSPFStyle().getResLocalPath()}'>
</#if>
<#if app_respath??><#assign local_base_file = '${app_respath}'></#if>
</#if>
<#if sysrun.getRunMode() == "STARTMSAPI">
<#assign depapi = sysrun.getPSDevSlnMSDepAPI()>
<#assign configId = depapi.getId()>
<#assign config = "api"+depapi.getName()>
<#if sysrun.getPSDevSlnMSDepAPI().getPSDCMSPlatform()?? && sysrun.getPSDevSlnMSDepAPI().getPSDCMSPlatform().getPSDCCluster()?? && (sysrun.getPSDevSlnMSDepAPI().getPSDCMSPlatform().getPSDCCluster().getLocalSSHIPAddr()!='')>
<#assign depnode = sysrun.getPSDevSlnMSDepAPI().getPSDCMSPlatform().getPSDCCluster()>
</#if>
<#elseif sysrun.getRunMode() == "STARTMSAPP">
<#assign depapp = sysrun.getPSDevSlnMSDepApp()>
<#assign configId = depapp.getId()>
<#assign config = "app"+depapp.getName()>
<#if sysrun.getPSDevSlnMSDepApp().getPSDCMSPlatform()?? && sysrun.getPSDevSlnMSDepApp().getPSDCMSPlatform().getPSDCCluster()?? && (sysrun.getPSDevSlnMSDepApp().getPSDCMSPlatform().getPSDCCluster().getLocalSSHIPAddr()!='')>
<#assign depnode = sysrun.getPSDevSlnMSDepApp().getPSDCMSPlatform().getPSDCCluster()>
</#if>
</#if>
#!/usr/bin/python
# -*- coding: UTF-8 -*-
import git
import time
import sys
import os
import platform
import jenkins
import json
import requests
import re

##########################################################################通用方法区##########################################################################
#输出日志信息到console区
def writeConsole(content):
    localtime = time.strftime("%m-%d %H:%M:%S", time.localtime())
    datas = json.dumps({'clientid':'CICD', 'topic':'${dsconsoleid}', 'content': '{ "content": "' + localtime + ' ' + content + '", "type":"CONSOLE" }'})
    r = requests.post("${dsconsoleserverurl}", data=datas, headers={'Content-Type': 'application/json'})

#结束输出日志信息到console区
def writeConsoleEnd(content):
    localtime = time.strftime("%m-%d %H:%M:%S", time.localtime())
    datas = json.dumps({'clientid':'CICD', 'topic':'${dsconsoleid}', 'content': '{ "content": "' + localtime + ' \\u001b[34m' + content + '\\u001b[0m", "type":"CONSOLE" }'})
    r = requests.post("${dsconsoleserverurl}", data=datas, headers={'Content-Type': 'application/json'})

#版本库本地文件路径更新/初始化
def prepareGitRepo(git_user,git_repo,git_local,git_branch):
    if os.path.exists(git_local+os.sep+".git"):
        repo = git.Repo(path=git_local)
        repo.git.config("user.name",git_user)
        repo.git.config("user.email",git_user+"@ibizsys.net")
        repo.git.fetch("--all")
        repo.git.reset("--hard","origin/"+git_branch)
    else:
        repo = git.Repo.clone_from(url=git_repo, to_path=git_local,branch=git_branch)
        repo.git.config("user.name",git_user)
        repo.git.config("user.email",git_user+'@ibizsys.net')
    return repo

#版本库重构模式
def rebuildRepo(git_user,git_local,git_branch,git_memo):
    if os.path.exists(git_local+os.sep+".git"):
        flag=False
        rootdir = git_local
        for root,dirs,files in os.walk(rootdir):
            for i in files:
                path = os.path.join(root,i)
                if os.path.isfile(path) and path.find(".git")==-1:
                    edituser=repo.git.log(path).split("\n")[1].split(" ")[1]
                    if edituser=="" or edituser==git_user:                           
                        os.remove(path)
                        flag=True
                        repo.git.rm(path)
        if flag:
            repo.git.commit("-m "+git_memo)
            repo.git.push("origin", git_branch)   

#版本库提交
def pushRepo(git_user,git_local,git_branch,git_memo):
    writeConsole('[开始执行]   发布代码提交')
    repo = git.Repo(path=git_local)
    flag=False
    writeConsole('[开始执行]    代码变更计算')   
    for i in (repo.git.status("-s").split("\n")):
        if i.startswith(" M"):           
            editfile=i.split(" ")[2]
            edituser=repo.git.log(editfile).split("\n")[1].split(" ")[1]
            if edituser=="" or edituser==git_user:
                repo.git.add(editfile,"-f")
                flag = True
        elif i.startswith("??"):
            flag = True
            editfile = i.split(" ")[1]
            repo.git.add(editfile, "-f")      
    writeConsoleEnd('[结束执行]   代码变更计算')
    writeConsole('[开始执行]    变更代码提交')
    if flag:
        repo.git.commit("-m "+git_memo)
        repo.git.push("origin", git_branch)
    repo.git.fetch("--all")
    repo.git.reset('--hard','origin/'+git_branch)
    writeConsoleEnd('[结束执行]    变更代码提交')
    writeConsoleEnd('[结束执行]   发布代码提交')   

#文档版本库提交
def pushDocRepo(git_user,git_local,git_branch,git_memo,gitlab_ci):
    if(platform.system()=="Linux"):
        os.system(r"cp -p -rf %s %s" %(gitlab_ci,git_local))
    else:
        os.system(r"xcopy %s %s /I/E/Y/D" %(gitlab_ci,git_local))    
    writeConsole('[开始执行]   发布文档提交')
    repo = git.Repo(path=git_local)
    repo.git.add("-A", ".")      
    repo.git.commit("-m "+git_memo)
    repo.git.push("origin", git_branch)
    writeConsoleEnd('[结束执行]   发布文档提交')

#RT模型版本库提交
def pushRTRepo(git_user,git_local,git_branch,git_memo):
    writeConsole('[开始执行]   发布模型提交')
    repo = git.Repo(path=git_local)
    repo.git.add("-A", ".")      
    repo.git.commit("-m "+git_memo)
    repo.git.push("origin", git_branch)
    writeConsoleEnd('[结束执行]   发布模型提交')

#前端初始文件拷贝
def copyAppRes(local_res,local_res_target):
    os.system(r"mkdir -p %s" %(local_res_target))
    if(platform.system()=="Linux"):
        os.system(r"cp -p -rf %s %s" %(local_res,local_res_target))
    else:
        os.system(r"xcopy %s %s /I/E/Y/D" %(local_res,local_res_target))

#前端初始文件拷贝
def addRtModelCI(rt_ci,rt_local,git_local,git_branch,git_repo,git_memo,runner_tag,pre_port,pre_modelpath):
    if(platform.system()=="Linux"):
        os.system(r"cp -p -rf %s %s" %(rt_ci,rt_local))        
        os.system(r"sed -i 's#git_local#%s#g' %s" %(git_local,rt_local+'/.gitlab-ci.yml'))
        os.system(r"sed -i 's#git_branch#%s#g' %s" %(git_branch,rt_local+'/.gitlab-ci.yml'))
        os.system(r"sed -i 's#git_repo#%s#g' %s" %(git_repo,rt_local+'/.gitlab-ci.yml'))
        os.system(r"sed -i 's#git_memo#%s#g' %s" %(git_memo,rt_local+'/.gitlab-ci.yml'))
        os.system(r"sed -i 's#runner_tag#%s#g' %s" %(runner_tag,rt_local+'/.gitlab-ci.yml'))
        os.system(r"sed -i 's#pre_port#%s#g' %s" %(pre_port,rt_local+'/.gitlab-ci.yml'))
        os.system(r"sed -i 's#pre_modelpath#%s#g' %s" %(pre_modelpath,rt_local+'/.gitlab-ci.yml'))
    else:
        os.system(r"xcopy %s %s /I/E/Y/D" %(rt_ci,rt_local))
        os.system(r"sed -i 's#git_local#%s#g' %s" %(git_local,rt_local+'/.gitlab-ci.yml'))
        os.system(r"sed -i 's#git_branch#%s#g' %s" %(git_branch,rt_local+'/.gitlab-ci.yml'))
        os.system(r"sed -i 's#git_repo#%s#g' %s" %(git_repo,rt_local+'\\.gitlab-ci.yml'))
        os.system(r"sed -i 's#git_memo#%s#g' %s" %(git_memo,rt_local+'\\.gitlab-ci.yml'))        
        os.system(r"sed -i 's#runner_tag#%s#g' %s" %(runner_tag,rt_local+'/.gitlab-ci.yml'))
        os.system(r"sed -i 's#pre_port#%s#g' %s" %(pre_port,rt_local+'/.gitlab-ci.yml'))
        os.system(r"sed -i 's#pre_modelpath#%s#g' %s" %(pre_modelpath,rt_local+'/.gitlab-ci.yml'))        
      


##########################################################################通用参数区##########################################################################
#######################code版本库参数区#######################
#分支名称
#freemark-param：branch
#python-param：git_branch
<#if sys.getPSSVNInstRepo().getGitBranch()?? && sys.getPSSVNInstRepo().getGitBranch()!="">
    <#assign branch=sys.getPSSVNInstRepo().getGitBranch()>
<#else>
    <#assign branch='master'>
</#if>
git_branch="${branch}"

#提交用户信息
#远程仓库地址
#python-param：git_user
#python-param：git_repo
<#if sys.getPSSVNInstRepo().getGitRepo()?? && sys.getPSSVNInstRepo().getGitRepo()=="IBIZ">
git_user = "${gituser}"
git_path = '${sys.getPSSVNInstRepo().getGitPath()}'
<#else>
</#if>   
<#if sys.getPSSVNInstRepo().getGitRepo()?? && sys.getPSSVNInstRepo().getGitRepo()=="GITEE">
git_user = "ibizdev"
git_path = '${sys.getPSSVNInstRepo().getGitPath()}'
git_prj  = '${sys.getPSSVNInstRepo().getGitProject()}' 
<#else>
</#if>    
git_repo = git_path

#本地文件路径
#python-param：git_local
if(platform.system()=="Linux"):
    git_local = "${codefolder}/${sys.getPSDevCenterDomain()}/${sys.getPubSystemId()}/${sys.getVCName()}/${sys.codeName}"
else:
    git_local = "${codefolder}\\${sys.getPSDevCenterDomain()}\\${sys.getPubSystemId()}\\${sys.getVCName()}\\${sys.codeName}"

#前端初始化文件目标目录
#python-param：local_res_target
<#if sysrun.getPSApplication()??>
#创建目录
if(platform.system()=="Linux"):
    local_res_target="${codefolder}/${sys.getPSDevCenterDomain()}/${sys.getPubSystemId()}/${sys.getVCName()}/${sys.codeName}/app_${sysrun.getPSApplication().getPKGCodeName()}${local_base_file}"
else:
    local_res_target="${codefolder}\\${sys.getPSDevCenterDomain()}\\${sys.getPubSystemId()}\\${sys.getVCName()}\\${sys.codeName}\\app_${sysrun.getPSApplication().getPKGCodeName()}${local_base_file}"
</#if> 

#前端初始化文件源目录
#python-param：local_res
<#if sysrun.getPSApplication()??>
<#if sysrun.getPSApplication().getPSPFStyle().getResLocalPath()?? && (sysrun.getPSApplication().getPSPFStyle().getResLocalPath()!='')>
if(platform.system()=="Linux"):
    local_res="${ibizsys_base_file}/*"
else:
    local_res="${ibizsys_base_file}\\*.*"
<#else>
if(platform.system()=="Linux"):
    local_res="${toolfolder}/APP/${ibizsys_base_file}/APP/*"
else:
    local_res="${toolfolder}\\APP\\${ibizsys_base_file}\\APP\\*.*"
</#if> 
</#if> 

#是否重构
#python-param：rebuild
<#if sysrun.isRebuildMode()>
rebuild=True
<#else>
rebuild=False
</#if>

#提交信息
#python-param：git_memo
<#if memo??>
git_memo="${memo}"
<#else>          
git_memo="ibizdev提交"  
</#if>

#######################doc版本库参数区#######################
#是否文档模式
if(len(sys.argv)==3 and sys.argv[2]=='PUBDOC'):
    doc_mode=True
else:
    doc_mode=False

#分支名称
#freemark-param：doc_branch
#python-param：doc_branch
<#if sys.getDocPSSVNInstRepo()?? && sys.getDocPSSVNInstRepo().getGitBranch()?? && sys.getDocPSSVNInstRepo().getGitBranch()!="">
    <#assign doc_branch=sys.getDocPSSVNInstRepo().getGitBranch()>
<#else>
    <#assign doc_branch='master'>
</#if>
doc_branch="${doc_branch}"

#提交用户信息
#远程仓库地址
#python-param：doc_user
#python-param：doc_repo
<#if sys.getDocPSSVNInstRepo()?? && sys.getDocPSSVNInstRepo().getGitRepo()?? && sys.getDocPSSVNInstRepo().getGitRepo()=="IBIZ">
doc_user = "${gituser}"
doc_path = '${sys.getDocPSSVNInstRepo().getGitPath()}'
if '@' not in doc_path:
    doc_path = doc_path.replace("http://", "http://oauth2:${gitpass}@")
else:
    doc_path = re.sub("http://oauth2:.*@","http://oauth2:${gitpass}@",doc_path)
<#else>
</#if>   
<#if sys.getDocPSSVNInstRepo()?? && sys.getDocPSSVNInstRepo().getGitRepo()?? && sys.getDocPSSVNInstRepo().getGitRepo()=="GITEE">
doc_user = "ibizdev"
doc_path = '${sys.getDocPSSVNInstRepo().getGitPath()}'
doc_prj  = '${sys.getDocPSSVNInstRepo().getGitProject()}' 
<#else>
</#if>    
<#if sys.getDocPSSVNInstRepo()?? && sys.getDocPSSVNInstRepo().getGitRepo()??>
doc_repo = doc_path
</#if>

#本地文件路径
#python-param：doc_local
<#if sys.getDocPSSVNInstRepo()??>
if(platform.system()=="Linux"):
    doc_local = "${codefolder}/${sys.getPSDevCenterDomain()}/${sys.getPubSystemId()}/@DOCUMENT"
else:
    doc_local = "${codefolder}\\${sys.getPSDevCenterDomain()}\\${sys.getPubSystemId()}\\@DOCUMENT"
</#if> 

#本地文档目录
#python-param：gitlab_ci
<#if sys.getDocPSSVNInstRepo()??>
if(platform.system()=="Linux"):
    gitlab_ci = "${codefolder}/${sys.getPSDevCenterDomain()}/${sys.getPubSystemId()}/@DOCUMENT/${pub.codeName}/.gitlab-ci.yml"
else:
    gitlab_ci = "${codefolder}\\${sys.getPSDevCenterDomain()}\\${sys.getPubSystemId()}\\@DOCUMENT\\${pub.codeName}\\.gitlab-ci.yml"
</#if>

#提交信息
#python-param：doc_memo
<#if memo??>
doc_memo="${memo}"
<#else>          
doc_memo="ibizdev提交" 
</#if>

#######################rtmodel版本库参数区#######################
#是否运行时模型
if(len(sys.argv)==3 and sys.argv[2]=='PUBMODEL'):
    rt_mode=True
else:
    rt_mode=False

#分支名称
#freemark-param：rt_branch
#python-param：rt_branch
<#if sys.getRTPSSVNInstRepo()?? && sys.getRTPSSVNInstRepo().getGitBranch()?? && sys.getRTPSSVNInstRepo().getGitBranch()!="">
    <#assign rt_branch=sys.getRTPSSVNInstRepo().getGitBranch()>
<#else>
    <#assign rt_branch='master'>
</#if>
rt_branch="${rt_branch}"

#提交用户信息
#远程仓库地址
#python-param：rt_user
#python-param：rt_repo
<#if sys.getRTPSSVNInstRepo()?? && sys.getRTPSSVNInstRepo().getGitRepo()?? && sys.getRTPSSVNInstRepo().getGitRepo()=="IBIZ">
rt_user = "${gituser}"
rt_path = '${sys.getRTPSSVNInstRepo().getGitPath()}'
if '@' not in rt_path:
    rt_path = rt_path.replace("http://", "http://oauth2:${gitpass}@")
else:
    rt_path = re.sub("http://oauth2:.*@","http://oauth2:${gitpass}@",rt_path)
<#else>
</#if>   
<#if sys.getRTPSSVNInstRepo()?? && sys.getRTPSSVNInstRepo().getGitRepo()?? && sys.getRTPSSVNInstRepo().getGitRepo()=="GITEE">
rt_user = "ibizdev"
rt_path = '${sys.getRTPSSVNInstRepo().getGitPath()}'
rt_prj  = '${sys.getRTPSSVNInstRepo().getGitProject()}' 
<#else>
</#if>    
<#if sys.getRTPSSVNInstRepo()?? && sys.getRTPSSVNInstRepo().getGitRepo()??>
rt_repo = rt_path
</#if>

#本地文件路径
#python-param：rt_local
<#if sys.getRTPSSVNInstRepo()??>
if(platform.system()=="Linux"):
    rt_local = "${codefolder}/${sys.getPSDevCenterDomain()}/${sys.getPubSystemId()}/@RUNTIME"
else:
    rt_local = "${codefolder}\\${sys.getPSDevCenterDomain()}\\${sys.getPubSystemId()}\\@RUNTIME"
</#if>

#预览runner标识
#python-param：runner_tag
<#assign runner_tag=pub.getPSSFStyleParam().getStyleParam("runner_tag","")>
runner_tag="${runner_tag}"

#预览端口
#python-param：pre_port
<#assign pre_port=pub.getPSSFStyleParam().getStyleParam("http_port","3000")>
pre_port="${pre_port}"

#模型路径
#python-param：pre_modelpath
pre_modelpath=""

#ci模板文件路径
#python-param：rt_ci
if(platform.system()=="Linux"):
    rt_ci="${toolfolder}/pyutils/.gitlab-ci.yml"
else:
    rt_ci="${toolfolder}\\pyutils\\.gitlab-ci.yml"

#提交信息
#python-param：rt_memo
<#if memo??>
rt_memo="${memo}"
<#else>          
rt_memo="ibizdev提交" 
</#if>

##########################################################################主体程序区##########################################################################
#######################code版本库begin程序区#######################
callback_tag=False
if(sys.argv[1]=='begin'):
    writeConsole('[开始执行]   初始化项目目录')    
    if doc_mode:
        #更新/初始化版本库本地文件路径
        doc_repo=prepareGitRepo(doc_user,doc_repo,doc_local,doc_branch)
    elif rt_mode:
        #更新/初始化版本库本地文件路径
        rt_repo=prepareGitRepo(rt_user,rt_repo,rt_local,rt_branch)
    else:
        #更新/初始化版本库本地文件路径
        repo=prepareGitRepo(git_user,git_repo,git_local,git_branch)
        #code版本库重构
        if rebuild:
            rebuildRepo(git_user,git_local,git_branch,git_memo)
        #code版本库拷贝初始文件-仅仅支持code版本库
        writeConsole('[开始执行]    拷贝初始文件')  
        copyAppRes(local_res,local_res_target)
        writeConsoleEnd('[结束执行]    拷贝初始文件')
    writeConsoleEnd('[结束执行]   初始化项目目录')

#######################code版本库end程序区########################
if(sys.argv[1]=='end'):
    if os.environ.get('PUSH_DELAY_TIME') != None:
        time.sleep(int(os.environ.get('PUSH_DELAY_TIME')))
    if doc_mode:
        pushDocRepo(doc_user,doc_local,doc_branch,doc_memo,gitlab_ci)
    elif rt_mode:
        try:
            addRtModelCI(rt_ci,rt_local,git_local,git_branch,git_repo,git_memo,runner_tag,pre_port,pre_modelpath)
            pushRTRepo(rt_user,rt_local,rt_branch,rt_memo)
        except git.exc.GitCommandError:
            print('无模型变化')
    else:
        pushRepo(git_user,git_local,git_branch,git_memo)
    callback_tag=True    

#######################code版本库deploy程序区#######################
<#if sys.getPSDeployCenter()??>
<#assign deployid = sys.getPubSystemId()>
<#if packmode?? && packmode=="all">
callback_tag=True
if(len(sys.argv)==3 and (sys.argv[2]=='STARTMSAPP' or sys.argv[2]=='STARTX' or sys.argv[2]=='STARTMSAPI') and sys.argv[1]=='end'):
        if(platform.system()=="Linux"):
            config = '${codefolder}/${sys.getPSDevCenterDomain()}/${sys.getPubSystemId()}/${sys.getVCName()}/${sys.codeName}/config.xml'
        else:
            config = '${codefolder}\\${sys.getPSDevCenterDomain()}\\${sys.getPubSystemId()}\\${sys.getVCName()}\\${sys.codeName}\\config.xml'    
        jenkins_url = "http://${sys.getPSDeployCenter().getRemoteAddress()}:${((sys.getPSDeployCenter().getRemotePort())?c)!8080}/jenkins"
        jenkins_userid = "${sys.getPSDeployCenter().getRemoteUserName()}"
        jenkins_apitoken = "${sys.getPSDeployCenter().getRemotePassword()}"
        server = jenkins.Jenkins(jenkins_url, username=jenkins_userid, password=jenkins_apitoken) 
<#if sysrun.getPSDevSlnMSDepAPI()??>
<#assign deployid = sysrun.getPSDevSlnMSDepAPI().getId()>
<#if dep_cdtype?? && (dep_cdtype=="SWARM") && depnode??>
<#assign successinfo_1 = "微服务接口部署成功">
<#assign successinfo_2 = "镜像推送"+sys.getPSDeployCenter().getPSRegistryRepo().getConnStr()>
<#assign successinfo_3 = "接口部署Swarm集群">
<#assign successinfo_4 = "正在启动......">
<#assign successinfo_5 = "启动预计耗时1~2分钟，访问地��� http://"+depnode.getLocalSSHIPAddr()+":"+sysrun.getPSDevSlnMSDepAPI().getPSDCMSPlatformNode().getLocalSSHPort()?c>
<#assign failureinfo = "微服务接口部署失败，请查看部署输出信息进行确认，更多请访问 https://bbs.ibizlab.cn">
<#assign dep_regurl = sys.getPSDeployCenter().getPSRegistryRepo().getConnStr()>
</#if>
<#elseif sysrun.getPSDevSlnMSDepApp()??>
<#assign deployid = sysrun.getPSDevSlnMSDepApp().getId()>
<#if dep_cdtype?? && (dep_cdtype=="SWARM") && depnode??>
<#assign successinfo_1 = "微服务应用部署成功">
<#assign successinfo_2 = "镜像推送"+sys.getPSDeployCenter().getPSRegistryRepo().getConnStr()>
<#assign successinfo_3 = "应用部署Swarm集群">
<#assign successinfo_4 = "正在启动......">
<#assign successinfo_5 = "启动预计耗时1~2分钟，访问地址 http://"+depnode.getLocalSSHIPAddr()+":"+sysrun.getPSDevSlnMSDepApp().getPSDCMSPlatformNode().getLocalSSHPort()?c>
<#assign failureinfo = "微服务应用部署失败，请查看部署输出信息进行确认，更多请访问 https://bbs.ibizlab.cn">
<#assign dep_regurl = sys.getPSDeployCenter().getPSRegistryRepo().getConnStr()>
</#if>
</#if>
        jobname = '${deployid}' 
        packmode = ''
        srcimagename = ''
        dstimagename = ''
<#if packmode?? && dstimagename??>
        packmode = '${packmode}'
        dstimagename = '${dep_regurl}/${dstimagename}'
</#if>
<#if packmode?? && packmode=="model" && srcimagename??>        
        srcimagename = '${dep_regurl}/${srcimagename}'
</#if>      
        #初始化JOB配置
        try:
            server.assert_job_exists(jobname, exception_message='job %s does not exist.......')
        except jenkins.JenkinsException as e:
            with open(config,'r', encoding='UTF-8') as f:
                profile = f.read()
            server.create_job(jobname, profile)
        with open(config,'r', encoding='UTF-8') as f:
            profile = f.read()
        server.reconfig_job(jobname, profile)
        #触发构建

<#if dep_cdtype?? && (dep_cdtype=="SWARM") && depnode??>
        server.build_job(jobname,{'para1': 'tcp://${depnode.getLocalSSHIPAddr()}:2375','para2': git_repo,'para3': packmode,'para4': dstimagename,'para5': git_user})
<#elseif  depnode??>
        server.build_job(jobname,{'para1': '${depnode.getSSHPassword()}','para2': git_repo})
<#elseif  sysrun.getPSAppServer()??>
        server.build_job(jobname,{'para1': 'tcp://${sysrun.getPSAppServer().getRemoteAddress()}:2375','para2': git_repo})
<#else>
        server.build_job(jobname)        
</#if>
        time.sleep(10)
        inQueue = server.get_job_info(jobname)['inQueue']
        if str(inQueue) == 'True':
            number = server.get_job_info(jobname)['nextBuildNumber']
        else:
            number = server.get_job_info(jobname)['nextBuildNumber']-1
<#if dsconsoleserverurl??>       
        #输出日志到console区
        flag = False
        preresult = ''
        #输出开始分割线
        headers = {'Content-Type': 'application/json'}
        datas = json.dumps({'clientid':'CICD','topic':'${dsconsoleid}','content':'{ "content":"------------------------------------ 开始调度 jenkins作业 -----------------------------------","type":"CONSOLE","subtype":"jenkins" }'})
        r = requests.post("${dsconsoleserverurl}", data=datas, headers=headers)
        while True:
            #最新结果
            curresult=server.get_build_console_output(jobname,number)
            #转换后的结果
            result=curresult.replace(preresult, "").replace("'", "").replace('"', '')
            #循环输出
            for i in (result.split("\n")):
<#if debugmode == "1">
                if (not (i.find("+")>=0 or len(i) == 0)):
<#elseif debugmode == "0">
                if (not (i.find("INFO")>=0 or i.find("+")>=0 or len(i) == 0)):
</#if>
                    headers = {'Content-Type': 'application/json'}
                    datas = json.dumps({'clientid':'CICD','topic':'${dsconsoleid}','content':'{ "content":"'+i.replace('\n', '').replace('\r', '')+'","type":"CONSOLE","subtype":"jenkins" }'})
                    r = requests.post("${dsconsoleserverurl}", data=datas, headers=headers)
            if 'Finished: SUCCESS' in curresult:
                print('SUCCESS')
<#if dep_cdtype?? && (dep_cdtype=="SWARM") && depnode??>                
                print("${successinfo_1}")
                print("${successinfo_2}")
                print("${successinfo_3}")
                print("${successinfo_4}")
                print("")
                print("${successinfo_5}")
                print("")
</#if>               
                break 
            elif 'Finished: FAILURE' in curresult:        
                print('FAILURE')
<#if dep_cdtype?? && (dep_cdtype=="SWARM") && depnode??>                
                print("${failureinfo}")
</#if>                
                break                 
            preresult = curresult       
        #输出结束分割线
        headers = {'Content-Type': 'application/json'}
        datas = json.dumps({'clientid':'CICD','topic':'${dsconsoleid}','content':'{ "content":"------------------------------------ 结束调度 jenkins作业 -----------------------------------","type":"CONSOLE","subtype":"jenkins" }'})
        r = requests.post("${dsconsoleserverurl}", data=datas, headers=headers)        
</#if>
#一键发布支持前发布-ey定制
<#else>
<#if runparam7?? && runparam7=="1">
callback_tag=True
if(sys.argv[1]=='end'):
        if(platform.system()=="Linux"):
            config = '${codefolder}/${sys.getPSDevCenterDomain()}/${sys.getPubSystemId()}/${sys.getVCName()}/${sys.codeName}/config.xml'
        else:
            config = '${codefolder}\\${sys.getPSDevCenterDomain()}\\${sys.getPubSystemId()}\\${sys.getVCName()}\\${sys.codeName}\\config.xml'    
        jenkins_url = "http://${sys.getPSDeployCenter().getRemoteAddress()}:${((sys.getPSDeployCenter().getRemotePort())?c)!8080}/jenkins"
        jenkins_userid = "${sys.getPSDeployCenter().getRemoteUserName()}"
        jenkins_apitoken = "${sys.getPSDeployCenter().getRemotePassword()}"
        server = jenkins.Jenkins(jenkins_url, username=jenkins_userid, password=jenkins_apitoken) 
        jobname = '${deployid}'
<#assign successinfo_1 = "全代码发布成功">
<#assign failureinfo = "全代码发布失败，请查看输出信息进行确认">
        #初始化JOB配置
        try:
            server.assert_job_exists(jobname, exception_message='job %s does not exist.......')
        except jenkins.JenkinsException as e:
            with open(config,'r', encoding='UTF-8') as f:
                profile = f.read()
            server.create_job(jobname, profile)
        with open(config,'r', encoding='UTF-8') as f:
            profile = f.read()
        server.reconfig_job(jobname, profile)
        writeConsole('[开始执行]    全代码发布') 
        #触发构建
        server.build_job(jobname,{'para1': '127.0.0.1','para2': git_repo,'para5': git_user})
        time.sleep(10)
        inQueue = server.get_job_info(jobname)['inQueue']
        if str(inQueue) == 'True':
            number = server.get_job_info(jobname)['nextBuildNumber']
        else:
            number = server.get_job_info(jobname)['nextBuildNumber']-1
<#if dsconsoleserverurl??>       
        #输出日志到console区
        flag = False
        preresult = ''
        #输出开始分割线
        headers = {'Content-Type': 'application/json'}
        datas = json.dumps({'clientid':'CICD','topic':'${dsconsoleid}','content':'{ "content":"------------------------------------ 开始调度 jenkins作业 -----------------------------------","type":"CONSOLE","subtype":"jenkins" }'})
        r = requests.post("${dsconsoleserverurl}", data=datas, headers=headers)
        while True:
            #最新结果
            curresult=server.get_build_console_output(jobname,number)
            #转换后的结果
            result=curresult.replace(preresult, "").replace("'", "").replace('"', '')
            #循环输出
            for i in (result.split("\n")):
<#if debugmode == "1">
                if (not (i.find("+")>=0 or len(i) == 0)):
<#elseif debugmode == "0">
                if (not (i.find("INFO")>=0 or i.find("+")>=0 or len(i) == 0)):
</#if>
                    headers = {'Content-Type': 'application/json'}
                    datas = json.dumps({'clientid':'CICD','topic':'${dsconsoleid}','content':'{ "content":"'+i.replace('\n', '').replace('\r', '')+'","type":"CONSOLE","subtype":"jenkins" }'})
                    r = requests.post("${dsconsoleserverurl}", data=datas, headers=headers)
            if 'Finished: SUCCESS' in curresult:
                print("${successinfo_1}")
                print("")
                break 
            elif 'Finished: FAILURE' in curresult:                 
                print("${failureinfo}")
                break                 
            preresult = curresult
        #输出结束分割线
        headers = {'Content-Type': 'application/json'}
        datas = json.dumps({'clientid':'CICD','topic':'${dsconsoleid}','content':'{ "content":"------------------------------------ 结束调度 jenkins作业 -----------------------------------","type":"CONSOLE","subtype":"jenkins" }'})
        r = requests.post("${dsconsoleserverurl}", data=datas, headers=headers)     
        writeConsoleEnd('[结束执行]   全代码发布')   
</#if>
</#if>
</#if>
<#if packmode?? && packmode!="all">
callback_tag=True
</#if>
</#if>
if(sys.argv[1]=='begin'):
    callback_tag=False
if callback_tag:
#地址回调
<#if callbackurl??>
    os.system(r"curl '${callbackurl}'")
</#if>
