/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 */
package SA.SRFDA.PS.Core.ValueRule;

import SA.SRFDA.PS.Core.IPSSystem;
import SA.SRFDA.PS.Core.IPSSystemObject;
import SA.SRFDA.PS.Core.PSModelInterfaceMeta;
import SA.SRFDA.PS.Core.Pub.IPSSysSFPubObject;
import SA.SRFDA.PS.Core.Pub.IPSXCodeObject;
import SA.SRFDA.PS.Core.Res.IPSLanguageRes;
import SA.SRFDA.PS.Core.Res.IPSSysPFPlugin;
import SA.SRFDA.PS.Core.Res.IPSSysSFPlugin;
import SA.SRFDA.PS.Core.System.IPSSystemModule;
import SA.SRFDA.PS.Data.PSSysValueRule;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;

@PSModelInterfaceMeta(title="\u7cfb\u7edf\u9884\u7f6e\u503c\u89c4\u5219\u6a21\u578b\u5bf9\u8c61\u63a5\u53e3", model="PSSysValueRule")
public interface IPSSysValueRule
extends IPSSystemObject,
IPSSysSFPubObject {
    public static final String RULETYPE_SCRIPT = "SCRIPT";
    public static final String RULETYPE_REG = "REG";
    public static final String RULETYPE_REGEX = "REGEX";
    public static final String RULETYPE_CUSTOM = "CUSTOM";
    public static final int RULEHOLDER_BACKEND = 1;
    public static final int RULEHOLDER_FRONT = 2;
    public static final int RULEHOLDER_BACKENDANDFRONT = 3;

    public void init(ISRFDAGlobalHelper var1, IPSSystem var2, PSSysValueRule var3) throws Exception;

    public String getRuleType();

    public String getRuleInfo();

    public String getRegExCode();

    public String getScriptCode();

    public String getCustomObject();

    public String getCustomParams();

    public String getRegExCode2();

    public String getRegExCode3();

    public String getRegExCode4();

    public IPSSystemModule getPSSystemModule();

    @Override
    public String getCodeName();

    public boolean isEnableBackend();

    public boolean isEnableFront();

    public int getRuleHolder();

    public IPSSysPFPlugin getPSSysPFPlugin();

    public IPSSysSFPlugin getPSSysSFPlugin();

    public IPSXCodeObject getRender();

    public String getRuleTag();

    public String getRuleTag2();

    public String getUniqueTag();

    public IPSLanguageRes getRuleInfoPSLanguageRes();

    public String getRuleInfoLanResTag();
}

