/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.PS.Core.ResMgr.IPSUserMgrAPI
 *  SA.SRFramework.Utility.StringHelper
 *  SA.SRFramework.UtilityEx.PropertiesHelper
 *  SA.SRFramework.UtilityEx.StringBuilderEx
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.ResMgr;

import SA.SRFDA.PS.Core.ResMgr.IPSUserMgrAPI;
import SA.SRFDA.PS.Core.ResMgr.PSSSHAPIBase;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.UtilityEx.PropertiesHelper;
import SA.SRFramework.UtilityEx.StringBuilderEx;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.Properties;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSOpenLDAPAPIImpl
extends PSSSHAPIBase
implements IPSUserMgrAPI {
    private static final Log log = LogFactory.getLog(PSOpenLDAPAPIImpl.class);
    private Properties cfg = new Properties();
    private String strLdapUser = "";
    private String strLdapPass = "";
    private String strLdapDC = "";
    private String strServerUser = "";
    private String strServerIp = "";
    private String strServerPass = "";
    private int nServerPort = 22;
    private String strServerLdapProfile = "";

    public PSOpenLDAPAPIImpl() throws Exception {
        this.cfg.load(PSOpenLDAPAPIImpl.class.getClassLoader().getResourceAsStream("saps-ldap.properties"));
        this.strLdapUser = PropertiesHelper.GetProperty((Properties)this.cfg, (String)"ldap.user");
        this.strLdapPass = PropertiesHelper.GetProperty((Properties)this.cfg, (String)"ldap.pass");
        this.strLdapDC = PropertiesHelper.GetProperty((Properties)this.cfg, (String)"ldap.dc");
        if (StringHelper.IsNullOrEmpty((String)this.strLdapDC)) {
            this.strLdapDC = "ou=People,dc=ibizsys,dc=net";
        }
        this.strServerUser = PropertiesHelper.GetProperty((Properties)this.cfg, (String)"server.user");
        this.strServerPass = PropertiesHelper.GetProperty((Properties)this.cfg, (String)"server.pass");
        this.strServerIp = PropertiesHelper.GetProperty((Properties)this.cfg, (String)"server.ip");
        this.nServerPort = PropertiesHelper.GetProperty((Properties)this.cfg, (String)"server.port", (int)22);
        this.strServerLdapProfile = PropertiesHelper.GetProperty((Properties)this.cfg, (String)"server.ldapprofile");
        boolean bInit = PropertiesHelper.GetProperty((Properties)this.cfg, (String)"server.initconn", (boolean)false);
        if (bInit) {
            PSOpenLDAPAPIImpl.getConnection(this.strServerIp, this.nServerPort, this.strServerUser, this.strServerPass);
        }
    }

    public void createUser(String strLoginName, String Memo) throws Exception {
        String strProfile = this.createUserProfile(strLoginName, Memo);
        PSOpenLDAPAPIImpl.putFileToRemote(this.strServerIp, this.nServerPort, this.strServerUser, this.strServerPass, strProfile, this.strServerLdapProfile);
        File file = new File(strProfile);
        String strName = file.getName();
        StringBuilderEx sb = new StringBuilderEx();
        sb.Append("ldapadd -x -D \"%1$s\" -w %2$s -f %3$s%4$s", (Object)this.strLdapUser, (Object)this.strLdapPass, (Object)this.strServerLdapProfile, (Object)strName);
        PSOpenLDAPAPIImpl.runRemoteScript(this.strServerIp, this.nServerPort, this.strServerUser, this.strServerPass, sb.toString());
    }

    public void changeUserPwd(String strLoginName, String strPassword, String strOriPassword) throws Exception {
        StringBuilderEx sb = new StringBuilderEx();
        sb.Append("ldappasswd -x -D \"%1$s\" -w %2$s  \"uid=%3$s,%5$s\" -s %4$s", (Object)this.strLdapUser, (Object)this.strLdapPass, (Object)strLoginName, (Object)strPassword, (Object)this.strLdapDC);
        PSOpenLDAPAPIImpl.runRemoteScript(this.strServerIp, this.nServerPort, this.strServerUser, this.strServerPass, sb.toString());
    }

    protected String createUserProfile(String strLoginName, String strMemo) throws Exception {
        File fTemp = File.createTempFile(strLoginName, ".ldif");
        log.info((Object)String.format("\u5efa\u7acb\u7528\u6237[%1$s]\u914d\u7f6e\u6587\u4ef6[%2$s]", strLoginName, fTemp.getPath()));
        OutputStreamWriter write = new OutputStreamWriter((OutputStream)new FileOutputStream(fTemp), "UTF-8");
        BufferedWriter writer = new BufferedWriter(write);
        StringBuilderEx sb = new StringBuilderEx();
        sb.Append("dn: uid=%1$s,%2$s\r\n", (Object)strLoginName, (Object)this.strLdapDC);
        sb.Append("uid: %1$s\r\n", (Object)strLoginName);
        sb.Append("cn: %1$s\r\n", (Object)strLoginName);
        sb.Append("objectClass: account\r\n");
        sb.Append("objectClass: posixAccount\r\n");
        sb.Append("objectClass: top\r\n");
        sb.Append("objectClass: shadowAccount\r\n");
        sb.Append("userPassword: {crypt}$6$zrHHfFot$y8oXmGonqWEfHXOT3jR7OyRTIlT4u45jlVpMPeT6k58BMoa/cCeAzuV7H0mcsB42k/WOLIXg7rumwzNigOj7G/\r\n");
        sb.Append("shadowLastChange: 16866\r\n");
        sb.Append("shadowMin: 0\r\n");
        sb.Append("shadowMax: 99999\r\n");
        sb.Append("shadowWarning: 7\r\n");
        sb.Append("loginShell: /bin/bash\r\n");
        sb.Append("uidNumber: 1001\r\n");
        sb.Append("gidNumber: 1001\r\n");
        if (strLoginName.indexOf("@") == -1) {
            sb.Append("description: %1$s@ibizlab.cn\r\n", (Object)strLoginName.toLowerCase());
        }
        sb.Append("homeDirectory: /home/%1$s\r\n", (Object)strLoginName);
        writer.write(sb.toString());
        writer.close();
        return fTemp.getPath();
    }
}

