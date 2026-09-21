/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 */
package SA.SRFDA.PS.Core.App.DataEntity;

import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDataEntity;
import SA.SRFDA.PS.Core.App.IPSApplication;
import SA.SRFDA.PS.Core.DataEntity.UIAction.IPSDEUIActionGroup;
import SA.SRFDA.PS.Core.IPSModelSortable;
import SA.SRFDA.PS.Core.PSModelInterfaceMeta;
import SA.SRFDA.PS.Data.PSDEUIActionGroup;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;

@PSModelInterfaceMeta(title="\u5e94\u7528\u5b9e\u4f53\u754c\u9762\u884c\u4e3a\u7ec4\u6a21\u578b\u5bf9\u8c61\u63a5\u53e3", model="PSDEUIActionGroup")
public interface IPSAppDEUIActionGroup
extends IPSDEUIActionGroup,
IPSModelSortable {
    public void init(ISRFDAGlobalHelper var1, IPSApplication var2, IPSAppDataEntity var3, PSDEUIActionGroup var4) throws Exception;

    public IPSAppDataEntity getPSAppDataEntity();

    public IPSApplication getPSApplication();

    public String getUniqueTag();
}

