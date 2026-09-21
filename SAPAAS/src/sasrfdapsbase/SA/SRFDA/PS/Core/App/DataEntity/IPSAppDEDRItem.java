/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.App.DataEntity;

import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDEDRGroup;
import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDataEntityObject;
import SA.SRFDA.PS.Core.App.View.IPSAppView;
import SA.SRFDA.PS.Core.DataEntity.DR.IPSDEDRItem;
import SA.SRFDA.PS.Core.PSModelInterfaceMeta;
import SA.SRFDA.PS.Core.PSModelPFIgnoreMeta;

@PSModelPFIgnoreMeta
@PSModelInterfaceMeta(title="\u5e94\u7528\u5b9e\u4f53\u5173\u7cfb\u6570\u636e\u9879\u6a21\u578b\u5bf9\u8c61\u63a5\u53e3")
public interface IPSAppDEDRItem
extends IPSAppDataEntityObject {
    public IPSDEDRItem getPSDEDRItem();

    public IPSAppDEDRGroup getPSAppDEDRGroup();

    public IPSAppView getPSAppView();
}

