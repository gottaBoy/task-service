/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 */
package SA.SRFDA.PS.Core.App.DataEntity;

import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDEAction;
import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDataEntity;
import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDataEntityObject;
import SA.SRFDA.PS.Core.DataEntity.DataImport.IPSDEDataImport;
import SA.SRFDA.PS.Core.PSModelInterfaceMeta;
import SA.SRFDA.PS.Data.PSDEDataImport;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;

@PSModelInterfaceMeta(title="\u5e94\u7528\u5b9e\u4f53\u6570\u636e\u5bfc\u5165\u6a21\u578b\u5bf9\u8c61\u63a5\u53e3", model="PSDEDataImp")
public interface IPSAppDEDataImport
extends IPSDEDataImport,
IPSAppDataEntityObject {
    public void init(ISRFDAGlobalHelper var1, IPSAppDataEntity var2, PSDEDataImport var3) throws Exception;

    public IPSAppDEAction getCreatePSAppDEAction();

    public IPSAppDEAction getUpdatePSAppDEAction();
}

