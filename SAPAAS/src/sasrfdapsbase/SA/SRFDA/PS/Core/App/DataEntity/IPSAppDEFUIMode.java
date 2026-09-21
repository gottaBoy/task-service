/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 */
package SA.SRFDA.PS.Core.App.DataEntity;

import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDEField;
import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDataEntityObject;
import SA.SRFDA.PS.Core.DEField.IPSDEFUIMode;
import SA.SRFDA.PS.Core.PSModelInterfaceMeta;
import SA.SRFDA.PS.Core.PSModelPFIgnoreMeta;
import SA.SRFDA.PS.Data.PSDEFUIMode;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;

@PSModelPFIgnoreMeta
@PSModelInterfaceMeta(title="\u5e94\u7528\u5b9e\u4f53\u5c5e\u6027\u754c\u9762\u914d\u7f6e\u6a21\u5f0f\u6a21\u578b\u5bf9\u8c61\u63a5\u53e3", implement="PSDEFUIModeImpl", model="PSDEFUIMode")
public interface IPSAppDEFUIMode
extends IPSDEFUIMode,
IPSAppDataEntityObject {
    public void init(ISRFDAGlobalHelper var1, IPSAppDEField var2, PSDEFUIMode var3) throws Exception;

    public IPSAppDEField getPSAppDEField();
}

