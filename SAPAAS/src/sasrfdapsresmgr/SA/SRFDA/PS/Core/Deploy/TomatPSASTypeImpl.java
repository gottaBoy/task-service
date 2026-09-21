/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.PS.Core.Util.SSHCmd
 *  SA.SRFDA.PS.Ctrl.DEDataCtrl.PSDEDataCtrl
 *  SA.SRFDA.PS.Data.PSAppServer
 *  SA.SRFramework.DataEx.BaseDataEntity
 *  net.ibizsys.paas.data.DataObject
 *  net.ibizsys.paas.entity.IEntity
 *  net.ibizsys.paas.util.StringHelper
 *  net.ibizsys.pscore.srv.PSCoreSysServiceBase
 *  net.ibizsys.pscore.srv.paasmgr.entity.PSAppServer
 *  net.ibizsys.pscore.srv.paasmgr.entity.PSROSServer
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.Deploy;

import SA.SRFDA.PS.Core.Deploy.LinuxOSPSASTypeImplBase;
import SA.SRFDA.PS.Core.Util.SSHCmd;
import SA.SRFDA.PS.Ctrl.DEDataCtrl.PSDEDataCtrl;
import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.ArrayList;
import java.util.List;
import net.ibizsys.paas.data.DataObject;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.pscore.srv.PSCoreSysServiceBase;
import net.ibizsys.pscore.srv.paasmgr.entity.PSAppServer;
import net.ibizsys.pscore.srv.paasmgr.entity.PSROSServer;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class TomatPSASTypeImpl
extends LinuxOSPSASTypeImplBase {
    private static final Log log = LogFactory.getLog(TomatPSASTypeImpl.class);

    public void initBookingRes(SA.SRFDA.PS.Data.PSAppServer psAppServerV3) throws Exception {
        PSAppServer psAppServer = new PSAppServer();
        PSDEDataCtrl.convertEntity2((BaseDataEntity)psAppServerV3, (IEntity)psAppServer);
        psAppServer.setSessionFactory(PSCoreSysServiceBase.getCurMajorSessionFactory());
        log.debug((Object)"\u91cd\u7f6e\u7528\u6237\u8fde\u63a5");
        this.resetUserConnections(psAppServer);
        log.debug((Object)"\u4fee\u6539\u4e3b\u673a\u5bc6\u7801");
        this.changeUserPassword(psAppServer);
        log.debug((Object)"\u5173\u95ed\u670d\u52a1\u5668");
        this.shutdownServer(psAppServer, true);
        log.debug((Object)"\u4e0a\u4f20\u670d\u52a1\u5668\u6587\u4ef6");
        this.updateServerConfig(psAppServer);
        log.debug((Object)"\u65b0\u5efa\u6570\u636e\u5e93");
        this.createDatabase(psAppServer);
        log.debug((Object)"\u4fee\u6539\u6570\u636e\u5e93\u7528\u6237\u5bc6\u7801");
        this.changeDbPassword(psAppServer);
        log.debug((Object)"\u6570\u636e\u5e93\u8d4b\u6743");
        this.grantDatabase(psAppServer);
        super.initBookingRes(psAppServerV3);
    }

    protected void startupServer(PSAppServer psAppServer) throws Exception {
        this.executeCmd(psAppServer, psAppServer.getStartCmd());
    }

    protected void updateServerConfig(PSAppServer psAppServer) throws Exception {
        String strASFolder = psAppServer.getAppFolder();
        String strASConfFolder = null;
        if (StringHelper.isNullOrEmpty((String)strASFolder)) {
            strASConfFolder = "/usr/local/tomcat/conf";
        } else {
            if (strASFolder.charAt(strASFolder.length() - 1) == '/') {
                strASFolder = strASFolder.substring(0, strASFolder.length() - 1);
            }
            strASConfFolder = strASFolder.indexOf("webapps") != -1 ? strASFolder.replace("webapps", "conf") : String.valueOf(strASConfFolder) + "/conf";
            strASConfFolder = strASConfFolder.replace("//", "/");
        }
        ArrayList<String> portMapList = new ArrayList<String>();
        portMapList.add("8080;" + psAppServer.getHttpPort());
        this.updateTomcatPort(psAppServer, strASConfFolder, portMapList);
    }

    protected void shutdownServer(PSAppServer psAppServer, boolean bEmptyFolder) throws Exception {
        this.executeCmd(psAppServer, psAppServer.getStopCmd());
        if (bEmptyFolder) {
            String strASFolder = psAppServer.getAppFolder();
            if (StringHelper.isNullOrEmpty((String)strASFolder)) {
                strASFolder = "/usr/local/tomcat/webapps";
            } else {
                if (strASFolder.charAt(strASFolder.length() - 1) == '/') {
                    strASFolder = strASFolder.substring(0, strASFolder.length() - 1);
                }
                if (strASFolder.indexOf("webapps") == -1) {
                    strASFolder = String.valueOf(strASFolder) + "/webapps";
                    strASFolder = strASFolder.replace("//", "/");
                }
            }
            this.emptyAppFolder(psAppServer, strASFolder);
            this.emptyFolder(psAppServer, strASFolder.replace("webapps", "conf/Catalina"));
            this.emptyFolder(psAppServer, strASFolder.replace("webapps", "log"));
            this.emptyFolder(psAppServer, strASFolder.replace("webapps", "tmp"));
            this.emptyFolder(psAppServer, strASFolder.replace("webapps", "work/Catalina"));
            String strUploadFolder = psAppServer.getUploadPath();
            if (!StringHelper.isNullOrEmpty((String)strUploadFolder)) {
                this.emptyFolder(psAppServer, strUploadFolder);
            }
        }
    }

    public void uninitBookingRes(SA.SRFDA.PS.Data.PSAppServer psAppServerV3) throws Exception {
        PSAppServer psAppServer = new PSAppServer();
        PSDEDataCtrl.convertEntity2((BaseDataEntity)psAppServerV3, (IEntity)psAppServer);
        psAppServer.setSessionFactory(PSCoreSysServiceBase.getCurMajorSessionFactory());
        this.resetUserConnections(psAppServer);
        this.changeUserPassword(psAppServer);
        this.shutdownServer(psAppServer, false);
        this.backupDatabase(psAppServer);
        this.dropDatabase(psAppServer);
        this.changeDbPassword(psAppServer);
        super.uninitBookingRes(psAppServerV3);
    }

    public void updateTomcatPort(PSAppServer psAppServer, String strFolder, List<String> portMapList) throws Exception {
        PSROSServer psrosServer = psAppServer.getPSROSServer();
        if (psrosServer != null) {
            int nSSHPort = DataObject.getIntegerValue((Object)psrosServer.getPort(), (Integer)22);
            String runCmd = StringHelper.format((String)"/ibiz5/FirewallByIp.sh %1$s %2$s", (Object)psAppServer.getIpAddr(), (Object)psAppServer.getHttpPort());
            String strRet = SSHCmd.runRemoteScript2((String)psrosServer.getIPAddr(), (int)nSSHPort, (String)psrosServer.getUserName(), (String)psrosServer.getPassWD(), (String)runCmd);
            if (strRet.indexOf(" Error ") != -1) {
                throw new Exception(StringHelper.format((String)"\u8def\u7531\u7aef\u53e3\u5730\u5740\u8f6c\u53d1\u66f4\u6539\u5931\u8d25\uff0c%1$s", (Object)strRet));
            }
        } else {
            int nSSHPort = DataObject.getIntegerValue((Object)psAppServer.getSSHPort(), (Integer)22);
            String runCmd = StringHelper.format((String)"cp /ibiz5/%1$s.xml %2$s/server.xml", (Object)psAppServer.getUserName(), (Object)strFolder);
            String strRet = SSHCmd.runRemoteScript2((String)psAppServer.getSSHIPAddr(), (int)nSSHPort, (String)psAppServer.getAdminUserName(), (String)psAppServer.getAdminPasswd(), (String)runCmd);
            if (strRet.indexOf(" Error ") != -1) {
                throw new Exception(StringHelper.format((String)"\u62f7\u8d1d\u5907\u4efd\u6587\u4ef6\u547d\u4ee4\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)strRet));
            }
            runCmd = "";
            int i = 0;
            while (i < portMapList.size()) {
                String[] portMap;
                String strPortMap = portMapList.get(i);
                if (!StringHelper.isNullOrEmpty((String)strPortMap) && (portMap = strPortMap.split(";")).length >= 2) {
                    if (!StringHelper.isNullOrEmpty((String)runCmd)) {
                        runCmd = String.valueOf(runCmd) + " && ";
                    }
                    runCmd = String.valueOf(runCmd) + StringHelper.format((String)"echo 'sed -i \"s/%1$s/%2$s/g\" %3$s/server.xml' > %3$s/serverConfUpdate.sh", (Object)portMap[0], (Object)portMap[1], (Object)strFolder);
                }
                ++i;
            }
            if (!StringHelper.isNullOrEmpty((String)runCmd)) {
                strRet = SSHCmd.runRemoteScript2((String)psAppServer.getSSHIPAddr(), (int)nSSHPort, (String)psAppServer.getAdminUserName(), (String)psAppServer.getAdminPasswd(), (String)runCmd);
                if (strRet.indexOf(" Error ") != -1) {
                    throw new Exception(StringHelper.format((String)"\u5199\u5165.sh\u547d\u4ee4\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)strRet));
                }
                runCmd = StringHelper.format((String)"chmod 777 %1$s/serverConfUpdate.sh  &&  %1$s/serverConfUpdate.sh", (Object)strFolder);
                strRet = SSHCmd.runRemoteScript2((String)psAppServer.getSSHIPAddr(), (int)nSSHPort, (String)psAppServer.getAdminUserName(), (String)psAppServer.getAdminPasswd(), (String)runCmd);
                if (strRet.indexOf(" Error ") != -1) {
                    throw new Exception(StringHelper.format((String)"\u7ed9.sh\u6587\u4ef6\u53ef\u6267\u884c\u6743\u9650\u5e76\u6267\u884c\u547d\u4ee4\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)strRet));
                }
            }
        }
    }

    public String getStartupCmd(String strOSType, String strInstallPath) {
        String strCmd = StringHelper.format((String)"%1$s/bin/startup.sh", (Object)strInstallPath);
        strCmd = strCmd.replace("/webapps", "");
        return strCmd;
    }

    public String getShutdownCmd(String strOSType, String strInstallPath) {
        String strCmd = StringHelper.format((String)"%1$s/bin/shutdown.sh", (Object)strInstallPath);
        strCmd = strCmd.replace("/webapps", "");
        return strCmd;
    }
}

