/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.PS.Core.Deploy.PSAppServerTypeImpl
 *  SA.SRFDA.PS.Core.Util.SSHCmd
 *  net.ibizsys.paas.data.DataObject
 *  net.ibizsys.paas.util.StringHelper
 *  net.ibizsys.pscore.srv.paasmgr.entity.PSAppServer
 *  net.ibizsys.pscore.srv.paasmgr.entity.PSDBDevInst
 */
package SA.SRFDA.PS.Core.Deploy;

import SA.SRFDA.PS.Core.Deploy.PSAppServerTypeImpl;
import SA.SRFDA.PS.Core.Util.SSHCmd;
import net.ibizsys.paas.data.DataObject;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.pscore.srv.paasmgr.entity.PSAppServer;
import net.ibizsys.pscore.srv.paasmgr.entity.PSDBDevInst;

public abstract class LinuxOSPSASTypeImplBase
extends PSAppServerTypeImpl {
    protected void resetUserConnections(PSAppServer psAppServer) throws Exception {
        String[] who;
        int nSSHPort = DataObject.getIntegerValue((Object)psAppServer.getSSHPort(), (Integer)22);
        String strWho = SSHCmd.runRemoteScript2((String)psAppServer.getSSHIPAddr(), (int)nSSHPort, (String)psAppServer.getAdminUserName(), (String)psAppServer.getAdminPasswd(), (String)"who");
        String[] stringArray = who = strWho.split("\r\n");
        int n = who.length;
        int n2 = 0;
        while (n2 < n) {
            String string = stringArray[n2];
            if (string.indexOf(psAppServer.getUserName()) == 0) {
                String pst = string.substring(string.indexOf("pts/"), string.indexOf("pts/") + 8);
                String strCmd = "pkill -kill -t " + pst;
                String strPkill = SSHCmd.runRemoteScript2((String)psAppServer.getSSHIPAddr(), (int)nSSHPort, (String)psAppServer.getAdminUserName(), (String)psAppServer.getAdminPasswd(), (String)strCmd);
                if (strPkill.indexOf(" Error ") != -1) {
                    throw new Exception(StringHelper.format((String)"\u91cd\u7f6e\u7528\u6237\u8fde\u63a5\u547d\u4ee4\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)strPkill));
                }
            }
            ++n2;
        }
    }

    protected void changeUserPassword(PSAppServer psAppServer) throws Exception {
        String strRunCmd = StringHelper.format((String)"echo \"%1$s\" | passwd --stdin %2$s", (Object)psAppServer.getPasswd(), (Object)psAppServer.getUserName());
        int nSSHPort = DataObject.getIntegerValue((Object)psAppServer.getSSHPort(), (Integer)22);
        String strRet = SSHCmd.runRemoteScript2((String)psAppServer.getSSHIPAddr(), (int)nSSHPort, (String)psAppServer.getAdminUserName(), (String)psAppServer.getAdminPasswd(), (String)strRunCmd);
        if (strRet.indexOf(" Error ") != -1) {
            throw new Exception(StringHelper.format((String)"\u4fee\u6539\u7528\u6237\u5bc6\u7801\u547d\u4ee4\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)strRet));
        }
    }

    protected void emptyAppFolder(PSAppServer psAppServer, String strFolder) throws Exception {
        String strRunCmd = StringHelper.format((String)"cd %1$s  &&  rm -rf `ls | grep -v docs | grep -v manager | grep -v ROOT` ", (Object)strFolder);
        int nSSHPort = DataObject.getIntegerValue((Object)psAppServer.getSSHPort(), (Integer)22);
        String strRet = SSHCmd.runRemoteScript2((String)psAppServer.getSSHIPAddr(), (int)nSSHPort, (String)psAppServer.getAdminUserName(), (String)psAppServer.getAdminPasswd(), (String)strRunCmd);
        if (strRet.indexOf(" Error ") != -1) {
            throw new Exception(StringHelper.format((String)"\u6e05\u7a7a\u9879\u76ee\u76ee\u5f55\u547d\u4ee4\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)strRet));
        }
    }

    protected void emptyFolder(PSAppServer psAppServer, String strFolder) throws Exception {
        String strRunCmd = StringHelper.format((String)"rm -rf %1$s/*", (Object)strFolder);
        int nSSHPort = DataObject.getIntegerValue((Object)psAppServer.getSSHPort(), (Integer)22);
        String strRet = SSHCmd.runRemoteScript2((String)psAppServer.getSSHIPAddr(), (int)nSSHPort, (String)psAppServer.getAdminUserName(), (String)psAppServer.getAdminPasswd(), (String)strRunCmd);
        if (strRet.indexOf(" Error ") != -1) {
            throw new Exception(StringHelper.format((String)"\u6e05\u7a7a\u76ee\u5f55\u547d\u4ee4\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)strRet));
        }
    }

    protected void backupDatabase(PSAppServer psAppServer) throws Exception {
        String strRunCmd = null;
        int nSSHPort = DataObject.getIntegerValue((Object)psAppServer.getSSHPort(), (Integer)22);
        for (PSDBDevInst o : psAppServer.getPSDBDevInsts()) {
            String strRet;
            if (StringHelper.isNullOrEmpty((String)o.getPSDBServer().getDBUserName()) || StringHelper.isNullOrEmpty((String)o.getPSDBServer().getDBPasswd())) continue;
            if (StringHelper.compare((String)o.getDBType(), (String)"MYSQL5", (boolean)true) == 0) {
                strRunCmd = StringHelper.format((String)"mysqldump -u %1$s -p'%2$s' %3$s > /ibiz5/dbback/", (Object)o.getPSDBServer().getDBUserName(), (Object)o.getPSDBServer().getDBPasswd(), (Object)o.getDBName());
                strRunCmd = String.valueOf(strRunCmd) + "$(date +%y%m%d%H%M%S).sql";
            }
            if (StringHelper.isNullOrEmpty(strRunCmd) || (strRet = SSHCmd.runRemoteScript2((String)psAppServer.getSSHIPAddr(), (int)nSSHPort, (String)psAppServer.getAdminUserName(), (String)psAppServer.getAdminPasswd(), (String)strRunCmd)).indexOf(" Error ") == -1) continue;
            throw new Exception(StringHelper.format((String)"\u5907\u4efd\u5f53\u524d\u6570\u636e\u5e93\u547d\u4ee4\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)strRet));
        }
    }

    protected void dropDatabase(PSAppServer psAppServer) throws Exception {
        String strRunCmd = null;
        int nSSHPort = DataObject.getIntegerValue((Object)psAppServer.getSSHPort(), (Integer)22);
        for (PSDBDevInst o : psAppServer.getPSDBDevInsts()) {
            String strRet;
            if (StringHelper.isNullOrEmpty((String)o.getPSDBServer().getDBUserName()) || StringHelper.isNullOrEmpty((String)o.getPSDBServer().getDBPasswd())) continue;
            if (StringHelper.compare((String)o.getDBType(), (String)"MYSQL5", (boolean)true) == 0) {
                strRunCmd = StringHelper.format((String)"echo 'drop database %1$s' | mysql -u %2$s -p'%3$s'", (Object)o.getDBName(), (Object)o.getPSDBServer().getDBUserName(), (Object)o.getPSDBServer().getDBPasswd());
            }
            if (StringHelper.isNullOrEmpty(strRunCmd) || (strRet = SSHCmd.runRemoteScript2((String)psAppServer.getSSHIPAddr(), (int)nSSHPort, (String)psAppServer.getAdminUserName(), (String)psAppServer.getAdminPasswd(), (String)strRunCmd)).indexOf(" Error ") == -1) continue;
            throw new Exception(StringHelper.format((String)"\u5907\u4efd\u5f53\u524d\u6570\u636e\u5e93\u547d\u4ee4\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)strRet));
        }
    }

    protected void changeDbPassword(PSAppServer psAppServer) throws Exception {
        String strRunCmd = null;
        int nSSHPort = DataObject.getIntegerValue((Object)psAppServer.getSSHPort(), (Integer)22);
        for (PSDBDevInst o : psAppServer.getPSDBDevInsts()) {
            String strRet;
            if (StringHelper.isNullOrEmpty((String)o.getPSDBServer().getDBUserName()) || StringHelper.isNullOrEmpty((String)o.getPSDBServer().getDBPasswd())) continue;
            if (StringHelper.compare((String)o.getDBType(), (String)"MYSQL5", (boolean)true) == 0) {
                strRunCmd = StringHelper.format((String)"echo \"set password for %1$s@localhost = password('%2$s')\" | mysql -u %3$s -p'%4$s'", (Object)o.getUserName(), (Object)o.getPasswd(), (Object)o.getPSDBServer().getDBUserName(), (Object)o.getPSDBServer().getDBPasswd());
            }
            if (StringHelper.isNullOrEmpty(strRunCmd) || (strRet = SSHCmd.runRemoteScript2((String)psAppServer.getSSHIPAddr(), (int)nSSHPort, (String)psAppServer.getAdminUserName(), (String)psAppServer.getAdminPasswd(), strRunCmd)).indexOf(" Error ") == -1) continue;
            throw new Exception(StringHelper.format((String)"\u4fee\u6539\u6570\u636e\u5e93\u7528\u6237\u5bc6\u7801\u547d\u4ee4\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)strRet));
        }
    }

    protected void createDatabase(PSAppServer psAppServer) throws Exception {
        String strRunCmd = null;
        int nSSHPort = DataObject.getIntegerValue((Object)psAppServer.getSSHPort(), (Integer)22);
        for (PSDBDevInst o : psAppServer.getPSDBDevInsts()) {
            String strRet;
            if (StringHelper.isNullOrEmpty((String)o.getPSDBServer().getDBUserName()) || StringHelper.isNullOrEmpty((String)o.getPSDBServer().getDBPasswd())) continue;
            if (StringHelper.compare((String)o.getDBType(), (String)"MYSQL5", (boolean)true) == 0) {
                strRunCmd = StringHelper.format((String)"echo \"CREATE DATABASE %1$s DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci\" | mysql -u %2$s -p'%3$s'", (Object)o.getDBName(), (Object)o.getPSDBServer().getDBUserName(), (Object)o.getPSDBServer().getDBPasswd());
            }
            if (StringHelper.isNullOrEmpty(strRunCmd) || (strRet = SSHCmd.runRemoteScript2((String)psAppServer.getSSHIPAddr(), (int)nSSHPort, (String)psAppServer.getAdminUserName(), (String)psAppServer.getAdminPasswd(), (String)strRunCmd)).indexOf(" Error ") == -1) continue;
            throw new Exception(StringHelper.format((String)"\u65b0\u5efa\u6570\u636e\u5e93\u547d\u4ee4\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)strRet));
        }
    }

    protected void grantDatabase(PSAppServer psAppServer) throws Exception {
        String strRunCmd = null;
        int nSSHPort = DataObject.getIntegerValue((Object)psAppServer.getSSHPort(), (Integer)22);
        for (PSDBDevInst o : psAppServer.getPSDBDevInsts()) {
            String strRet;
            if (StringHelper.isNullOrEmpty((String)o.getPSDBServer().getDBUserName()) || StringHelper.isNullOrEmpty((String)o.getPSDBServer().getDBPasswd())) continue;
            if (StringHelper.compare((String)o.getDBType(), (String)"MYSQL5", (boolean)true) == 0) {
                strRunCmd = StringHelper.format((String)"echo \"GRANT ALL PRIVILEGES ON %1$s.* to %2$s@localhost\" | mysql -u %3$s -p'%4$s'", (Object)o.getDBName(), (Object)o.getUserName(), (Object)o.getPSDBServer().getDBUserName(), (Object)o.getPSDBServer().getDBPasswd());
            }
            if (StringHelper.isNullOrEmpty(strRunCmd) || (strRet = SSHCmd.runRemoteScript2((String)psAppServer.getSSHIPAddr(), (int)nSSHPort, (String)psAppServer.getAdminUserName(), (String)psAppServer.getAdminPasswd(), strRunCmd)).indexOf(" Error ") == -1) continue;
            throw new Exception(StringHelper.format((String)"\u6570\u636e\u5e93\u6388\u6743\u547d\u4ee4\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)strRet));
        }
    }

    protected String executeCmd(PSAppServer psAppServer, String strRunCmd) throws Exception {
        int nSSHPort = DataObject.getIntegerValue((Object)psAppServer.getSSHPort(), (Integer)22);
        String strRet = SSHCmd.runRemoteScript2((String)psAppServer.getSSHIPAddr(), (int)nSSHPort, (String)psAppServer.getAdminUserName(), (String)psAppServer.getAdminPasswd(), (String)strRunCmd);
        return strRet;
    }

    protected String uoloadFile(PSAppServer psAppServer, String remotePath, String localPath) throws Exception {
        int nSSHPort = DataObject.getIntegerValue((Object)psAppServer.getSSHPort(), (Integer)22);
        String strRet = SSHCmd.putFileToRemote((String)psAppServer.getSSHIPAddr(), (int)nSSHPort, (String)psAppServer.getAdminUserName(), (String)psAppServer.getAdminPasswd(), (String)localPath, (String)remotePath);
        return strRet;
    }
}

