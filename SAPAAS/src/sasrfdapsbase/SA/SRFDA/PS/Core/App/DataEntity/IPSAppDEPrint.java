/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 */
package SA.SRFDA.PS.Core.App.DataEntity;

import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDataEntity;
import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDataEntityObject;
import SA.SRFDA.PS.Core.DataEntity.Print.IPSDEPrint;
import SA.SRFDA.PS.Core.PSModelInterfaceMeta;
import SA.SRFDA.PS.Data.PSDEPrint;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;

@PSModelInterfaceMeta(title="\u5e94\u7528\u5b9e\u4f53\u6253\u5370\u6a21\u578b\u5bf9\u8c61\u63a5\u53e3", model="PSDEPrint")
public interface IPSAppDEPrint
extends IPSDEPrint,
IPSAppDataEntityObject {
    public void init(ISRFDAGlobalHelper var1, IPSAppDataEntity var2, PSDEPrint var3) throws Exception;
}

