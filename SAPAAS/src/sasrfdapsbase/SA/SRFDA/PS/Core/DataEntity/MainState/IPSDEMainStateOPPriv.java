/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 */
package SA.SRFDA.PS.Core.DataEntity.MainState;

import SA.SRFDA.PS.Core.DataEntity.MainState.IPSDEMainState;
import SA.SRFDA.PS.Core.DataEntity.Priv.IPSDEOPPriv;
import SA.SRFDA.PS.Core.IPSModelObject;
import SA.SRFDA.PS.Core.PSModelInterfaceMeta;
import SA.SRFDA.PS.Data.PSDEMainStateOPPriv;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;

@PSModelInterfaceMeta(title="\u5b9e\u4f53\u4e3b\u72b6\u6001\u64cd\u4f5c\u6807\u8bc6\u6a21\u578b\u5bf9\u8c61\u63a5\u53e3", model="PSDEMSOPPriv")
public interface IPSDEMainStateOPPriv
extends IPSModelObject {
    public void init(ISRFDAGlobalHelper var1, IPSDEMainState var2, PSDEMainStateOPPriv var3) throws Exception;

    public IPSDEMainState getPSDEMainState();

    public String getPSDEOPPrivId();

    public IPSDEOPPriv getPSDEOPPriv();
}

