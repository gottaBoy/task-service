/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.PS.Core.Deploy.PSMavenServerTypeImpl
 *  SA.SRFDA.PS.Core.Util.CmdHelper
 *  SA.SRFDA.PS.Ctrl.DEDataCtrl.PSDEDataCtrl
 *  SA.SRFDA.PS.Data.PSMavenRepo
 *  SA.SRFramework.DataEx.BaseDataEntity
 *  net.ibizsys.paas.entity.IEntity
 *  net.ibizsys.pscore.srv.paasmgr.entity.PSMavenRepo
 *  net.ibizsys.pscore.srv.paasmgr.entity.PSMavenServer
 */
package SA.SRFDA.PS.Core.Deploy;

import SA.SRFDA.PS.Core.Deploy.PSMavenServerTypeImpl;
import SA.SRFDA.PS.Core.Util.CmdHelper;
import SA.SRFDA.PS.Ctrl.DEDataCtrl.PSDEDataCtrl;
import SA.SRFDA.PS.Data.PSMavenRepo;
import SA.SRFramework.DataEx.BaseDataEntity;
import java.io.File;
import java.io.FileWriter;
import java.util.UUID;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.pscore.srv.paasmgr.entity.PSMavenServer;

public class NexusPSMavenServerTypeImpl
extends PSMavenServerTypeImpl {
    public String getInstallPath(String strOSType) {
        return null;
    }

    public void createMavenRepo(PSMavenRepo psMavenRepo2) throws Exception {
        net.ibizsys.pscore.srv.paasmgr.entity.PSMavenRepo psMavenRepo = new net.ibizsys.pscore.srv.paasmgr.entity.PSMavenRepo();
        PSDEDataCtrl.convertEntity2((BaseDataEntity)psMavenRepo2, (IEntity)psMavenRepo);
        PSMavenServer psMavenServer = psMavenRepo.getPSMavenServer();
        String mavenServerUserName = psMavenServer.getMavenUserName();
        String mavenServerPasswd = psMavenServer.getMavenPasswd();
        String APIPath = psMavenServer.getAPIPath();
        String mavenRepoUserName = psMavenRepo.getMavenUserName();
        String mavenRepoPsswd = psMavenRepo.getMavenPasswd();
        String mavenRepoROUserName = psMavenRepo.getROUserName();
        String mavenRepoROPasswd = psMavenRepo.getROPasswd();
        String mavenRepoName = psMavenRepo.getPSMavenRepoName();
        String repoJsonFilePath = String.valueOf(System.getProperty("java.io.tmpdir")) + "repo.json";
        String repoFunName = UUID.randomUUID().toString().toUpperCase();
        String repoContent = String.format("{\"name\": \"%1$s\",\"type\": \"groovy\",\"content\": \"repository.createMavenHosted('%2$s','default',true,org.sonatype.nexus.repository.maven.VersionPolicy.SNAPSHOT)\"}", repoFunName, mavenRepoName);
        this.executeJsonScript(mavenServerUserName, mavenServerPasswd, APIPath, repoJsonFilePath, repoFunName, repoContent);
        String adminUserJsonFilePath = String.valueOf(System.getProperty("java.io.tmpdir")) + "adminuser.json";
        String adminRoleJsonFilePath = String.valueOf(System.getProperty("java.io.tmpdir")) + "adminrole.json";
        String adminRoleFunName = UUID.randomUUID().toString().toUpperCase();
        String adminRoleConent = String.format("{\"name\": \"%1$s\",\"type\": \"groovy\",\"content\": \"security.addRole('nx-%2$s','nx-%2$s','nx-%2$s',['nx-repository-view-maven2-%3$s-*','nx-repository-admin-maven2-%3$s-*','nx-userschangepw'],[''])\"}", adminRoleFunName, mavenRepoUserName, mavenRepoName);
        this.executeJsonScript(mavenServerUserName, mavenServerPasswd, APIPath, adminRoleJsonFilePath, adminRoleFunName, adminRoleConent);
        String adminUserFunName = UUID.randomUUID().toString().toUpperCase();
        String adminUserConent = String.format("{\"name\": \"%1$s\",\"type\": \"groovy\",\"content\": \"security.addUser('%2$s','%2$s','%2$s','%2$s',true,'%3$s',['nx-%2$s'])\"}", adminUserFunName, mavenRepoUserName, mavenRepoPsswd);
        this.executeJsonScript(mavenServerUserName, mavenServerPasswd, APIPath, adminUserJsonFilePath, adminUserFunName, adminUserConent);
        String addRoUserJsonFilePath = String.valueOf(System.getProperty("java.io.tmpdir")) + "rouser.json";
        String addRoUserRoleJsonFilePath = String.valueOf(System.getProperty("java.io.tmpdir")) + "rouserrole.json";
        String roRoleFunName = UUID.randomUUID().toString().toUpperCase();
        String roRoleConent = String.format("{\"name\": \"%1$s\",\"type\": \"groovy\",\"content\": \"security.addRole('nx-%2$s','nx-%2$s','nx-%2$s',['nx-repository-admin-maven2-%3$s-read','nx-repository-admin-maven2-%3$s-browse','nx-repository-view-maven2-%3$s-read','nx-repository-view-maven2-%3$s-browse'],[''])\"}", roRoleFunName, mavenRepoROUserName, mavenRepoName);
        this.executeJsonScript(mavenServerUserName, mavenServerPasswd, APIPath, addRoUserRoleJsonFilePath, roRoleFunName, roRoleConent);
        String roUserFunName = UUID.randomUUID().toString().toUpperCase();
        String roUserConent = String.format("{\"name\": \"%1$s\",\"type\": \"groovy\",\"content\": \"security.addUser('%2$s','%2$s','%2$s','%2$s',true,'%3$s',['nx-%2$s'])\"}", roUserFunName, mavenRepoROUserName, mavenRepoROPasswd);
        this.executeJsonScript(mavenServerUserName, mavenServerPasswd, APIPath, addRoUserJsonFilePath, roUserFunName, roUserConent);
    }

    public void updateMavenRepo(PSMavenRepo psMavenRepo2, int nMode) throws Exception {
        net.ibizsys.pscore.srv.paasmgr.entity.PSMavenRepo psMavenRepo = new net.ibizsys.pscore.srv.paasmgr.entity.PSMavenRepo();
        PSDEDataCtrl.convertEntity2((BaseDataEntity)psMavenRepo2, (IEntity)psMavenRepo);
        if (nMode == 1) {
            return;
        }
        if (nMode == 2) {
            return;
        }
    }

    public void executeJsonScript(String mavenServerUserName, String mavenServerPasswd, String APIPath, String jsonScriptPath, String funName, String content) throws Exception {
        String strToolFolder = this.getDAGlobalHelper().getWebExConfig().GetValue("SRFPS", "TOOLFOLDER", null);
        String CURL_PATH = String.format("%1$s\\curl\\I386\\curl.exe", strToolFolder);
        File jsonFile = new File(jsonScriptPath);
        if (!jsonFile.exists()) {
            jsonFile.createNewFile();
        }
        FileWriter writer = new FileWriter(jsonFile, false);
        writer.write(content);
        writer.close();
        CmdHelper cmdHelper = new CmdHelper();
        String uploadScriptCmd = String.format("%1$s -v -X POST -u %2$s:%3$s --header \"Content-Type: application/json\" %4$s -d @%5$s", CURL_PATH, mavenServerUserName, mavenServerPasswd, APIPath, jsonScriptPath);
        cmdHelper.executeBat(uploadScriptCmd);
        String runScriptCmd = String.format("%1$s -v -X POST -u %2$s:%3$s --header \"Content-Type: text/plain\" %4$s/%5$s/run", CURL_PATH, mavenServerUserName, mavenServerPasswd, APIPath, funName);
        cmdHelper.executeBat(runScriptCmd);
        String delFunCmd = String.format("%1$s -v -X DELETE -u %2$s:%3$s %4$s/%5$s", CURL_PATH, mavenServerUserName, mavenServerPasswd, APIPath, funName);
        cmdHelper.executeBat(delFunCmd);
        if (jsonFile.exists()) {
            jsonFile.delete();
        }
    }
}

