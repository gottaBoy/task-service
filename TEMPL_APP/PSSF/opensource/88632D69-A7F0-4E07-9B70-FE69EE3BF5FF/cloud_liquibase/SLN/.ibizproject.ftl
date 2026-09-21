<#ibiztemplate>
TARGET=PSSYSTEM
</#ibiztemplate>
type: PSSYSTEM
psdevsln: ${sys.getPSDevSlnId()}
psdevslnsys: ${sys.getPubSystemId()}
psdevslnsysname: ${sys.getLogicName()}
<#if sys.getPSSVNInstRepo?? && sys.getPSSVNInstRepo()?? && sys.getPSSVNInstRepo().getGitPath?? && sys.getPSSVNInstRepo().getGitPath()??>
git-remote: ${sys.getPSSVNInstRepo().getGitPath()}
<#else>
# 需自行补充 git-remote 参数，值为 git 地址
</#if>