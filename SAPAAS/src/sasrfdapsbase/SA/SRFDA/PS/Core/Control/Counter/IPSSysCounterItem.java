/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 */
package SA.SRFDA.PS.Core.Control.Counter;

import SA.SRFDA.PS.Core.Control.Counter.IPSSysCounter;
import SA.SRFDA.PS.Core.IPSObject;
import SA.SRFDA.PS.Core.PSModelInterfaceMeta;
import SA.SRFDA.PS.Data.PSSysCounterItem;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;

@PSModelInterfaceMeta(title="\u7cfb\u7edf\u8ba1\u6570\u5668\u9879\u6a21\u578b\u5bf9\u8c61\u63a5\u53e3", model="PSSysCounterItem")
public interface IPSSysCounterItem
extends IPSObject {
    public void init(ISRFDAGlobalHelper var1, IPSSysCounter var2, PSSysCounterItem var3) throws Exception;

    public String getLogicName();

    public IPSSysCounter getPSSysCounter();
}

