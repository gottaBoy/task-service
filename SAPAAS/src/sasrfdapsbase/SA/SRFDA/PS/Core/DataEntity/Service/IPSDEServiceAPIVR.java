/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 */
package SA.SRFDA.PS.Core.DataEntity.Service;

import SA.SRFDA.PS.Core.DEField.ValueRule.IPSDEFValueRule;
import SA.SRFDA.PS.Core.DataEntity.Service.IPSDEServiceAPI;
import SA.SRFDA.PS.Core.IPSModelObject;
import SA.SRFDA.PS.Core.PSModelIgnoreMeta;
import SA.SRFDA.PS.Data.PSDESAVR;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;

@PSModelIgnoreMeta
public interface IPSDEServiceAPIVR
extends IPSModelObject {
    public static final String VRTYPE_DEFVALUERULE = "DEFVALUERULE";
    public static final String VRTYPE_SYSVALUERULE = "SYSVALUERULE";

    public void init(ISRFDAGlobalHelper var1, IPSDEServiceAPI var2, PSDESAVR var3) throws Exception;

    public IPSDEServiceAPI getPSDEServiceAPI();

    @Override
    public String getCodeName();

    public int getOrderValue();

    public String getValueRuleType();

    public IPSDEFValueRule getPSDEFValueRule();
}

