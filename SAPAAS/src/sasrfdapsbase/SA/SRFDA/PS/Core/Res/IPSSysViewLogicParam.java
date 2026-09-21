/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 */
package SA.SRFDA.PS.Core.Res;

import SA.SRFDA.PS.Core.IPSObject;
import SA.SRFDA.PS.Core.Res.IPSSysViewLogic;
import SA.SRFDA.PS.Core.View.IPSViewLogicParam;
import SA.SRFDA.PS.Data.PSSysViewLogicParam;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;

public interface IPSSysViewLogicParam
extends IPSObject,
IPSViewLogicParam {
    public void init(ISRFDAGlobalHelper var1, IPSSysViewLogic var2, PSSysViewLogicParam var3) throws Exception;

    public IPSSysViewLogic getPSSysViewLogic();

    public String getParamValue();

    public String getParamValue2();
}

