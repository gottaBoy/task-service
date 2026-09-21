/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core;

import SA.SRFDA.PS.Core.App.IPSApplication;
import SA.SRFDA.PS.Core.IPSModelObject;
import SA.SRFDA.PS.Core.IPSObject;
import SA.SRFDA.PS.Core.JIT.SysModel.IPSJITSystemModel;
import SA.SRFDA.PS.Core.PF.IPSPFStyle;
import SA.SRFDA.PS.Core.PSModelIgnoreMeta;
import SA.SRFDA.PS.Core.Pub.IPSGenerateCodeResult;
import SA.SRFDA.PS.Core.Pub.IPSSysPubRuntime;
import SA.SRFDA.PS.Core.Pub.IPSSysSFPub;
import SA.SRFDA.PS.Core.SF.IPSSFStyle;
import SA.SRFDA.PS.Core.Workspace.IPSWorkspace;
import SA.SRFDA.PS.Data.PSAppViewCode;
import SA.SRFDA.PS.Data.PSSysIssue;
import SA.SRFDA.PS.Data.PSSysSFCode;
import java.util.ArrayList;
import java.util.Iterator;

@PSModelIgnoreMeta
public interface IPSSystemUtil {
    public static final String TEMPLENGINEVER_DEFAULT = "DEFAULT";
    public static final String TEMPLENGINEVER_V2 = "V2";
    public static final String TEMPLFOLDER_V2_SLN = "SLN";
    public static final String TEMPLFOLDER_V2_PRJ = "PRJ";
    public static final String TEMPLFOLDER_V2_TOOL = "TOOL";
    public static final String DEPLOYSYSTYPE_ORGWFSYS = "ORGWFSYS";
    public static final String DEPLOYSYSTYPE_ORGSECTORWFSYS = "ORGSECTORWFSYS";
    public static final String DEPLOYSYSTYPE_USER = "USER";
    public static final String DEPLOYSYSTYPE_USER2 = "USER2";
    public static final String CODENAMEMODE_LOWER_UNDERSCORE = "LOWER_UNDERSCORE";
    public static final String CODENAMEMODE_UPPER_UNDERSCORE = "UPPER_UNDERSCORE";
    public static final String CODENAMEMODE_LOWER_CAMEL = "LOWER_CAMEL";
    public static final String CODENAMEMODE_UPPER_CAMEL = "UPPER_CAMEL";
    public static final String CODENAMEMODE_LOWER = "LOWER";
    public static final String CODENAMEMODE_UPPER = "UPPER";
    public static final String CODENAMEMODE_LOWER_HYPHEN = "LOWER_HYPHEN";
    public static final String CODENAMEMODE_NONE = "NONE";

    public void writeFile(String var1, String var2, Object var3) throws Exception;

    public boolean writeFile2(String var1, String var2, Object var3) throws Exception;

    public void pubPFCode(IPSSysPubRuntime var1, IPSApplication var2, String var3, String var4, String var5, Object var6) throws Exception;

    public void pubSFCode(IPSSysPubRuntime var1, IPSSysSFPub var2, String var3, String var4, String var5, Object var6) throws Exception;

    public void resetFileCache();

    public IPSJITSystemModel getPSJITSystemModel(boolean var1) throws Exception;

    public boolean hasPSJITSystemModel() throws Exception;

    public ArrayList<IPSObject> getPSModels(String var1, String var2) throws Exception;

    public Iterator<PSSysSFCode> getPSModelSFCodes(String var1, String var2) throws Exception;

    public Iterator<PSAppViewCode> getPSModelPFCodes(String var1, String var2) throws Exception;

    public IPSGenerateCodeResult getPSModelCodeSnippet(String var1, String var2, String var3) throws Exception;

    public void log(int var1, IPSModelObject var2, String var3);

    public void log(int var1, IPSModelObject var2, String var3, String var4);

    public void log(int var1, IPSModelObject var2, String var3, String var4, String var5);

    public void active();

    public int getCheckModelVer();

    public void logPSSysIssue(IPSModelObject var1, PSSysIssue var2) throws Exception;

    public IPSSysConsole getPSSysConsole();

    public int getModelInstVer();

    public String getTemplEngineVer();

    public int getSampleDataId();

    public boolean isDebugMode();

    public String getDeploySysId();

    public String getDeploySysTag();

    public String getDeploySysTag2();

    public String getDeploySysType();

    public String getDeploySysOrgId();

    public String getDeploySysOrgSectorId();

    public String getPSDevCenterId();

    public String getPSDevCenterName();

    public String getPSDevSlnId();

    public IPSWorkspace getPSWorkspace();

    public void testPSModelLimit(IPSModelObject var1, String var2, int var3) throws Exception;

    public String getRuntimePSSysModelInstId();

    public IPSSFStyle getPSSFStyle(String var1, String var2, String var3) throws Exception;

    public IPSPFStyle getPSPFStyle(String var1, String var2, String var3) throws Exception;

    public String getSysTag();

    public String getSysTag2();

    public String getSysTag3();

    public String getSysTag4();

    public static interface IPSSysConsole {
        public void log(String var1, String var2);

        public void warn(String var1, String var2);

        public void error(String var1, String var2);

        public void warn(String var1, String var2, String var3, String var4, String var5);

        public void error(String var1, String var2, String var3, String var4, String var5);
    }
}

