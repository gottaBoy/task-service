/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  net.ibizsys.paas.core.valuerule.IDEFValueRule
 */
package SA.SRFDA.PS.Core.DEField.ValueRule;

import SA.SRFDA.PS.Core.DEField.IPSDEField;
import SA.SRFDA.PS.Core.DEField.IPSDEFieldObject;
import SA.SRFDA.PS.Core.DEField.ValueRule.IPSDEFVRCondition;
import SA.SRFDA.PS.Core.DEField.ValueRule.IPSDEFVRGroupCondition;
import SA.SRFDA.PS.Core.IPSModelObject;
import SA.SRFDA.PS.Core.PSModelInterfaceMeta;
import SA.SRFDA.PS.Core.Pub.IPSXCodeObject;
import SA.SRFDA.PS.Core.Res.IPSLanguageRes;
import SA.SRFDA.PS.Core.Res.IPSSysPFPlugin;
import SA.SRFDA.PS.Core.Res.IPSSysSFPlugin;
import SA.SRFDA.PS.Data.PSDEFValueRule;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import java.util.Iterator;
import net.ibizsys.paas.core.valuerule.IDEFValueRule;

@PSModelInterfaceMeta(title="\u5b9e\u4f53\u5c5e\u6027\u503c\u89c4\u5219\u6a21\u578b\u5bf9\u8c61\u63a5\u53e3", model="PSDEFValueRule")
public interface IPSDEFValueRule
extends IPSDEFieldObject,
IDEFValueRule,
IPSModelObject {
    public static final String VRTYPE_NORMAL = "NORMAL";
    public static final String VRTYPE_FORMITEMS = "FORMITEMS";
    public static final String VRTYPE_SCRIPT = "SCRIPT";

    public void init(ISRFDAGlobalHelper var1, IPSDEField var2, PSDEFValueRule var3) throws Exception;

    public boolean isDefaultMode();

    @Override
    public String getCodeName();

    public String getTypeDetail();

    public String getRuleInfo();

    public IPSDEFVRGroupCondition getPSDEFVRGroupCondition();

    public Iterator<IPSDEField> getRelatedPSDEFields();

    public boolean isCheckDefault();

    public Iterator<IPSDEFVRCondition> getAllPSDEFVRConditions();

    public int getRuleHolder();

    public boolean isEnableBackend();

    public boolean isEnableFront();

    public IPSSysPFPlugin getPSSysPFPlugin();

    public IPSSysSFPlugin getPSSysSFPlugin();

    public IPSXCodeObject getRender();

    public String getRuleTag();

    public String getRuleTag2();

    public boolean isCustomCode();

    public String getScriptCode();

    public IPSLanguageRes getRuleInfoPSLanguageRes();

    public String getRuleInfoLanResTag();
}

