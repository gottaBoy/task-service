/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 */
package SA.SRFDA.PS.Core.Deploy;

import SA.SRFDA.PS.Core.Deploy.IPSDevSlnMSDepFunc;
import SA.SRFDA.PS.Core.IPSModelObject;
import SA.SRFDA.PS.Data.PSDevSlnMSDepFuncItem;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;

public interface IPSDevSlnMSDepFuncItem
extends IPSModelObject {
    public static final String ITEMTYPE_APP = "APP";
    public static final String ITEMTYPE_API = "API";

    public void init(ISRFDAGlobalHelper var1, IPSDevSlnMSDepFunc var2, PSDevSlnMSDepFuncItem var3) throws Exception;

    public String getItemType();

    public IPSDevSlnMSDepFunc getPSDevSlnMSDepFunc();
}

