/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 */
package SA.SRFDA.PS.Core.Service;

import SA.SRFDA.PS.Core.IPSModelObject;
import SA.SRFDA.PS.Core.PSModelInterfaceMeta;
import SA.SRFDA.PS.Core.PSModelPFIgnoreMeta;
import SA.SRFDA.PS.Core.Service.IPSSubSysServiceAPI;
import SA.SRFDA.PS.Core.Service.IPSSubSysServiceAPIDE;
import SA.SRFDA.PS.Data.PSSubSysSADERS;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;

@PSModelPFIgnoreMeta
@PSModelInterfaceMeta(title="\u5916\u90e8\u7cfb\u7edf\u670d\u52a1\u63a5\u53e3\u5b9e\u4f53\u5173\u7cfb\u6a21\u578b\u5bf9\u8c61\u63a5\u53e3", model="PSSubSysSADERS")
public interface IPSSubSysServiceAPIDERS
extends IPSModelObject {
    public void init(ISRFDAGlobalHelper var1, IPSSubSysServiceAPI var2, PSSubSysSADERS var3) throws Exception;

    public IPSSubSysServiceAPI getPSSubSysServiceAPI();

    public String getPPSSubSysSADEId();

    public String getCPSSubSysSADEId();

    public int getOrderValue();

    public int getMasterOrder();

    public IPSSubSysServiceAPIDE getMajorPSSubSysServiceAPIDE() throws Exception;

    public IPSSubSysServiceAPIDE getMinorPSSubSysServiceAPIDE() throws Exception;

    public String getParentFilter();

    @Override
    public String getCodeName();

    public String getCodeName2();

    public String getRSTag();

    public String getRSTag2();

    public boolean isArray();
}

