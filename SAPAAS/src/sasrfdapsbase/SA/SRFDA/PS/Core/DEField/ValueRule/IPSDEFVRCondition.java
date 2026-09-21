/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  net.ibizsys.paas.core.valuerule.IDEFVRCondition
 */
package SA.SRFDA.PS.Core.DEField.ValueRule;

import SA.SRFDA.PS.Core.DEField.ValueRule.IPSDEFVRGroupCondition;
import SA.SRFDA.PS.Core.DEField.ValueRule.IPSDEFValueRule;
import SA.SRFDA.PS.Core.IPSModelObject;
import SA.SRFDA.PS.Core.PSModelInterfaceMeta;
import SA.SRFDA.PS.Core.Res.IPSLanguageRes;
import SA.SRFDA.PS.Data.PSDEFValueRuleCond;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import java.util.ArrayList;
import net.ibizsys.paas.core.valuerule.IDEFVRCondition;

@PSModelInterfaceMeta(title="\u5b9e\u4f53\u5c5e\u6027\u503c\u89c4\u5219\u6761\u4ef6\u6a21\u578b\u5bf9\u8c61\u63a5\u53e3", typefield="condType", model="PSDEFVRCond")
public interface IPSDEFVRCondition
extends IDEFVRCondition,
IPSModelObject {
    public static final String CONDTYPE_GROUP = "GROUP";
    public static final String CONDTYPE_NULLRULE = "NULLRULE";
    public static final String CONDTYPE_VALUERANGE = "VALUERANGE";
    public static final String CONDTYPE_VALUERANGE2 = "VALUERANGE2";
    public static final String CONDTYPE_REGEX = "REGEX";
    public static final String CONDTYPE_STRINGLENGTH = "STRINGLENGTH";
    public static final String CONDTYPE_SIMPLE = "SIMPLE";
    public static final String CONDTYPE_VALUERANGE3 = "VALUERANGE3";
    public static final String CONDTYPE_QUERYCOUNT = "QUERYCOUNT";
    public static final String CONDTYPE_VALUERECURSION = "VALUERECURSION";
    public static final String CONDTYPE_SYSVALUERULE = "SYSVALUERULE";

    public void init(ISRFDAGlobalHelper var1, IPSDEFValueRule var2, IPSDEFVRGroupCondition var3, PSDEFValueRuleCond var4) throws Exception;

    public IPSDEFValueRule getPSDEFValueRule();

    public IPSDEFVRGroupCondition getPSDEFVRGroupCondition();

    public String getCondType();

    public String getRuleInfo();

    public void fillRelatedPSDEFields(ArrayList<String> var1);

    public boolean isNotMode();

    public boolean isTryMode();

    public boolean isKeyCond();

    public String getCondTag();

    public String getCondTag2();

    public IPSLanguageRes getRuleInfoPSLanguageRes();

    public String getRuleInfoLanResTag();
}

