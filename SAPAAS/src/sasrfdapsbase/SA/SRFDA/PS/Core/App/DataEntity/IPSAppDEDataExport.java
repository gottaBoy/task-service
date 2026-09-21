/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 */
package SA.SRFDA.PS.Core.App.DataEntity;

import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDEDataSet;
import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDataEntity;
import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDataEntityObject;
import SA.SRFDA.PS.Core.DataEntity.DataExport.IPSDEDataExport;
import SA.SRFDA.PS.Core.PSModelInterfaceMeta;
import SA.SRFDA.PS.Data.PSDEDataExport;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;

@PSModelInterfaceMeta(title="\u5e94\u7528\u5b9e\u4f53\u6570\u636e\u5bfc\u51fa\u6a21\u578b\u5bf9\u8c61\u63a5\u53e3", model="PSDEDataExport")
public interface IPSAppDEDataExport
extends IPSDEDataExport,
IPSAppDataEntityObject {
    public void init(ISRFDAGlobalHelper var1, IPSAppDataEntity var2, PSDEDataExport var3) throws Exception;

    public IPSAppDEDataSet getPSAppDEDataSet();
}

