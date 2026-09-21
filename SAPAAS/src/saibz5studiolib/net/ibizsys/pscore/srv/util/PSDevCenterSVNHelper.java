/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package net.ibizsys.pscore.srv.util;

import java.io.File;
import java.io.Serializable;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.pscore.srv.devcenter.entity.PSDevCenterSVN;
import net.ibizsys.pscore.srv.paasmgr.entity.PSSVNServerBase;
import net.ibizsys.pscore.srv.util.PSStudioEnvHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSDevCenterSVNHelper {
    private static final Log log = LogFactory.getLog(PSDevCenterSVNHelper.class);
    private static PSDevCenterSVNHelper instance = null;

    public static void setInstance(PSDevCenterSVNHelper pSDevCenterSVNHelper) {
        instance = pSDevCenterSVNHelper;
    }

    public static PSDevCenterSVNHelper getInstance() {
        if (instance == null) {
            instance = new PSDevCenterSVNHelper();
        }
        return instance;
    }

    public void checkOut(PSDevCenterSVN pSDevCenterSVN, String string) throws Exception {
        try {
            Serializable serializable;
            String string2 = "";
            String string3 = "";
            String string4 = "";
            String string5 = "";
            string2 = pSDevCenterSVN.getGitPath();
            string3 = pSDevCenterSVN.getGitBranch();
            if (pSDevCenterSVN.getPSSVNInstRepo() != null) {
                if (StringHelper.isNullOrEmpty((String)string2)) {
                    string2 = pSDevCenterSVN.getPSSVNInstRepo().getGitPath();
                }
                if (StringHelper.isNullOrEmpty((String)string3)) {
                    string3 = pSDevCenterSVN.getPSSVNInstRepo().getGitBranch();
                }
                if ((serializable = pSDevCenterSVN.getPSSVNInstRepo().getPSSVNServer()) != null) {
                    string4 = ((PSSVNServerBase)serializable).getGITUserName();
                    string5 = ((PSSVNServerBase)serializable).getGITPassword();
                }
            }
            if (StringHelper.isNullOrEmpty((String)string2)) {
                throw new Exception(StringHelper.format((String)"\u6ca1\u6709\u6307\u5b9a\u6a21\u578b\u4ed3\u5e93\u5730\u5740"));
            }
            if (StringHelper.isNullOrEmpty((String)string3)) {
                string3 = "master";
            }
            string3 = "*" + string3;
            serializable = new File(string);
            File file = ((File)serializable).getParentFile();
            if (file != null && !file.exists()) {
                file.mkdirs();
            }
            String string6 = "";
            string6 = PSStudioEnvHelper.getCurrent().isLinux() ? StringHelper.format((String)"python %1$s%2$spyutils%2$smodelhelp.py %3$s %4$s %5$s%6$s USR %7$s %8$s", (Object)PSStudioEnvHelper.getCurrent().getToolFolder(), (Object)File.separator, (Object)"dynamic", (Object)string, (Object)string2, (Object)string3, (Object)string4, (Object)string5) : StringHelper.format((String)"cmd.exe /c python %1$s%2$spyutils%2$smodelhelp.py %3$s %4$s %5$s%6$s USR %7$s %8$s", (Object)PSStudioEnvHelper.getCurrent().getToolFolder(), (Object)File.separator, (Object)"dynamic", (Object)string, (Object)string2, (Object)string3, (Object)string4, (Object)string5);
            PSStudioEnvHelper.Result result = PSStudioEnvHelper.getCurrent().executeBat(string6);
        }
        catch (Exception exception) {
            log.error((Object)String.format("\u5e94\u7528\u4e2d\u5fc3\u4ee3\u7801\u4ed3\u5e93\u6267\u884c\u7b7e\u51fa\u64cd\u4f5c\u53d1\u751f\u5f02\u5e38\uff0c%1$s", exception.getMessage()), (Throwable)exception);
            throw new Exception(String.format("\u5e94\u7528\u4e2d\u5fc3\u4ee3\u7801\u4ed3\u5e93\u6267\u884c\u7b7e\u51fa\u64cd\u4f5c\u53d1\u751f\u5f02\u5e38\uff0c%1$s", exception.getMessage()), exception);
        }
    }

    public void checkIn(PSDevCenterSVN pSDevCenterSVN, String string) throws Exception {
        try {
            Serializable serializable;
            String string2 = "";
            String string3 = "";
            String string4 = "";
            String string5 = "";
            string2 = pSDevCenterSVN.getGitPath();
            string3 = pSDevCenterSVN.getGitBranch();
            if (pSDevCenterSVN.getPSSVNInstRepo() != null) {
                if (StringHelper.isNullOrEmpty((String)string2)) {
                    string2 = pSDevCenterSVN.getPSSVNInstRepo().getGitPath();
                }
                if (StringHelper.isNullOrEmpty((String)string3)) {
                    string3 = pSDevCenterSVN.getPSSVNInstRepo().getGitBranch();
                }
                if ((serializable = pSDevCenterSVN.getPSSVNInstRepo().getPSSVNServer()) != null) {
                    string4 = ((PSSVNServerBase)serializable).getGITUserName();
                    string5 = ((PSSVNServerBase)serializable).getGITPassword();
                }
            }
            if (StringHelper.isNullOrEmpty((String)string2)) {
                throw new Exception(StringHelper.format((String)"\u6ca1\u6709\u6307\u5b9a\u6a21\u578b\u4ed3\u5e93\u5730\u5740"));
            }
            if (StringHelper.isNullOrEmpty((String)string3)) {
                string3 = "master";
            }
            string3 = "*" + string3;
            serializable = new File(string);
            File file = ((File)serializable).getParentFile();
            if (file != null && !file.exists()) {
                file.mkdirs();
            }
            String string6 = "";
            string6 = PSStudioEnvHelper.getCurrent().isLinux() ? StringHelper.format((String)"python %1$s%2$spyutils%2$smodelhelp.py %3$s %4$s %5$s%6$s PUB %7$s %8$s", (Object)PSStudioEnvHelper.getCurrent().getToolFolder(), (Object)File.separator, (Object)"dynamic", (Object)string, (Object)string2, (Object)string3, (Object)string4, (Object)string5) : StringHelper.format((String)"cmd.exe /c python %1$s%2$spyutils%2$smodelhelp.py %3$s %4$s %5$s%6$s PUB %7$s %8$s", (Object)PSStudioEnvHelper.getCurrent().getToolFolder(), (Object)File.separator, (Object)"dynamic", (Object)string, (Object)string2, (Object)string3, (Object)string4, (Object)string5);
            PSStudioEnvHelper.Result result = PSStudioEnvHelper.getCurrent().executeBat(string6);
        }
        catch (Exception exception) {
            log.error((Object)String.format("\u5e94\u7528\u4e2d\u5fc3\u4ee3\u7801\u4ed3\u5e93\u6267\u884c\u7b7e\u5165\u64cd\u4f5c\u53d1\u751f\u5f02\u5e38\uff0c%1$s", exception.getMessage()), (Throwable)exception);
            throw new Exception(String.format("\u5e94\u7528\u4e2d\u5fc3\u4ee3\u7801\u4ed3\u5e93\u6267\u884c\u7b7e\u5165\u64cd\u4f5c\u53d1\u751f\u5f02\u5e38\uff0c%1$s", exception.getMessage()), exception);
        }
    }

    public void revert(PSDevCenterSVN pSDevCenterSVN, String string, String string2) throws Exception {
        try {
            Object object;
            String string3 = "";
            String string4 = "";
            String string5 = "";
            String string6 = "";
            string3 = pSDevCenterSVN.getGitPath();
            string4 = pSDevCenterSVN.getGitBranch();
            if (pSDevCenterSVN.getPSSVNInstRepo() != null) {
                if (StringHelper.isNullOrEmpty((String)string3)) {
                    string3 = pSDevCenterSVN.getPSSVNInstRepo().getGitPath();
                }
                if (StringHelper.isNullOrEmpty((String)string4)) {
                    string4 = pSDevCenterSVN.getPSSVNInstRepo().getGitBranch();
                }
                if ((object = pSDevCenterSVN.getPSSVNInstRepo().getPSSVNServer()) != null) {
                    string5 = ((PSSVNServerBase)object).getGITUserName();
                    string6 = ((PSSVNServerBase)object).getGITPassword();
                }
            }
            if (StringHelper.isNullOrEmpty((String)string3)) {
                throw new Exception(StringHelper.format((String)"\u6ca1\u6709\u6307\u5b9a\u6a21\u578b\u4ed3\u5e93\u5730\u5740"));
            }
            if (StringHelper.isNullOrEmpty((String)string4)) {
                string4 = "master";
            }
            string4 = "*" + string4;
            object = "";
            object = PSStudioEnvHelper.getCurrent().isLinux() ? StringHelper.format((String)"python %1$s%2$spyutils%2$smodelhelp.py %3$s %4$s %5$s%6$s RESET %7$s %8$s %9$s", (Object)PSStudioEnvHelper.getCurrent().getToolFolder(), (Object)File.separator, (Object)"dynamic", (Object)string, (Object)string3, (Object)string4, (Object)string5, (Object)string6, (Object)string2) : StringHelper.format((String)"cmd.exe /c python %1$s%2$spyutils%2$smodelhelp.py %3$s %4$s %5$s%6$s RESET %7$s %8$s %9$s", (Object)PSStudioEnvHelper.getCurrent().getToolFolder(), (Object)File.separator, (Object)"dynamic", (Object)string, (Object)string3, (Object)string4, (Object)string5, (Object)string6, (Object)string2);
            PSStudioEnvHelper.Result result = PSStudioEnvHelper.getCurrent().executeBat((String)object);
        }
        catch (Exception exception) {
            log.error((Object)String.format("\u5e94\u7528\u4e2d\u5fc3\u4ee3\u7801\u4ed3\u5e93\u6267\u884c\u6807\u8bb0\u53cd\u505a\u64cd\u4f5c\u53d1\u751f\u5f02\u5e38\uff0c%1$s", exception.getMessage()), (Throwable)exception);
            throw new Exception(String.format("\u5e94\u7528\u4e2d\u5fc3\u4ee3\u7801\u4ed3\u5e93\u6267\u884c\u6807\u8bb0\u53cd\u505a\u64cd\u4f5c\u53d1\u751f\u5f02\u5e38\uff0c%1$s", exception.getMessage()), exception);
        }
    }

    public void verify(PSDevCenterSVN pSDevCenterSVN) throws Exception {
    }
}

