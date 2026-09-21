/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.PS.Core.Deploy.PSDevServerTypeImpl
 *  SA.SRFDA.PS.Core.Util.SSHCmd
 *  net.ibizsys.paas.data.DataObject
 *  net.ibizsys.paas.util.StringBuilderEx
 *  net.ibizsys.paas.util.StringHelper
 *  net.ibizsys.pscore.srv.paasmgr.entity.PSDevServer
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.Deploy;

import SA.SRFDA.PS.Core.Deploy.PSDevServerTypeImpl;
import SA.SRFDA.PS.Core.Util.SSHCmd;
import net.ibizsys.paas.data.DataObject;
import net.ibizsys.paas.util.StringBuilderEx;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.pscore.srv.paasmgr.entity.PSDevServer;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public abstract class WindowsOSPSDSTypeImplBase
extends PSDevServerTypeImpl {
    private static final Log log = LogFactory.getLog(WindowsOSPSDSTypeImplBase.class);

    protected void resetUserConnections(PSDevServer psDevServer) throws Exception {
        int nSSHPort = DataObject.getIntegerValue((Object)psDevServer.getSSHPort(), (Integer)22);
        String strWho = SSHCmd.runRemoteScript2((String)psDevServer.getSSHIPAddr(), (int)nSSHPort, (String)psDevServer.getAdminUserName(), (String)psDevServer.getAdminPasswd(), (String)("query user " + psDevServer.getUserName()));
        log.debug((Object)strWho);
        String[] who = strWho.split("\r\n");
        if (who.length <= 1) {
            return;
        }
        int i = 1;
        while (i < who.length) {
            String strLine = who[i].trim();
            StringBuilderEx sBuilderEx = new StringBuilderEx();
            String[] parts = strLine.split("[ ]");
            int j = 0;
            while (j < parts.length) {
                String strPart = parts[j];
                if (!StringHelper.isNullOrEmpty((String)strPart)) {
                    if (j != 0) {
                        sBuilderEx.append(" ");
                    }
                    sBuilderEx.append(strPart);
                }
                ++j;
            }
            parts = sBuilderEx.toString().split("[ ]");
            if (parts.length == 7) {
                SSHCmd.runRemoteScript2((String)psDevServer.getSSHIPAddr(), (int)nSSHPort, (String)psDevServer.getAdminUserName(), (String)psDevServer.getAdminPasswd(), (String)("logoff " + parts[2]));
            } else if (parts.length == 6) {
                SSHCmd.runRemoteScript2((String)psDevServer.getSSHIPAddr(), (int)nSSHPort, (String)psDevServer.getAdminUserName(), (String)psDevServer.getAdminPasswd(), (String)("logoff " + parts[1]));
            }
            ++i;
        }
    }

    protected void changeUserPassword(PSDevServer psDevServer) throws Exception {
        String strRunCmd = StringHelper.format((String)"net user %2$s %1$s", (Object)psDevServer.getPasswd(), (Object)psDevServer.getUserName());
        int nSSHPort = DataObject.getIntegerValue((Object)psDevServer.getSSHPort(), (Integer)22);
        String strRet = SSHCmd.runRemoteScript2((String)psDevServer.getSSHIPAddr(), (int)nSSHPort, (String)psDevServer.getAdminUserName(), (String)psDevServer.getAdminPasswd(), (String)strRunCmd);
        if (strRet.indexOf(" Error ") != -1) {
            throw new Exception(StringHelper.format((String)"\u4fee\u6539\u7528\u6237\u5bc6\u7801\u547d\u4ee4\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)strRet));
        }
    }

    protected void emptyAppFolder(PSDevServer psDevServer, String strFolder) throws Exception {
    }

    protected void emptyFolder(PSDevServer psDevServer, String strFolder) throws Exception {
        String strRunCmd = StringHelper.format((String)"rm -rf %1$s/*", (Object)strFolder);
        int nSSHPort = DataObject.getIntegerValue((Object)psDevServer.getSSHPort(), (Integer)22);
        String strRet = SSHCmd.runRemoteScript2((String)psDevServer.getSSHIPAddr(), (int)nSSHPort, (String)psDevServer.getAdminUserName(), (String)psDevServer.getAdminPasswd(), (String)strRunCmd);
        if (strRet.indexOf(" Error ") != -1) {
            throw new Exception(StringHelper.format((String)"\u6e05\u7a7a\u76ee\u5f55\u547d\u4ee4\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)strRet));
        }
    }

    protected String executeCmd(PSDevServer psDevServer, String strRunCmd) throws Exception {
        int nSSHPort = DataObject.getIntegerValue((Object)psDevServer.getSSHPort(), (Integer)22);
        String strRet = SSHCmd.runRemoteScript2((String)psDevServer.getSSHIPAddr(), (int)nSSHPort, (String)psDevServer.getAdminUserName(), (String)psDevServer.getAdminPasswd(), (String)strRunCmd);
        return strRet;
    }

    protected String uoloadFile(PSDevServer psDevServer, String remotePath, String localPath) throws Exception {
        int nSSHPort = DataObject.getIntegerValue((Object)psDevServer.getSSHPort(), (Integer)22);
        String strRet = SSHCmd.putFileToRemote((String)psDevServer.getSSHIPAddr(), (int)nSSHPort, (String)psDevServer.getAdminUserName(), (String)psDevServer.getAdminPasswd(), (String)localPath, (String)remotePath);
        return strRet;
    }
}

