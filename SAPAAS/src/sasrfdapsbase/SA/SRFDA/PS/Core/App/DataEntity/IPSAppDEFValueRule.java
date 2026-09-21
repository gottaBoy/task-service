/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.App.DataEntity;

import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDEField;
import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDataEntityObject;
import SA.SRFDA.PS.Core.DEField.ValueRule.IPSDEFValueRule;
import SA.SRFDA.PS.Core.PSModelInterfaceMeta;

@PSModelInterfaceMeta(title="\u5e94\u7528\u5b9e\u4f53\u5c5e\u6027\u503c\u89c4\u5219\u6a21\u578b\u5bf9\u8c61\u63a5\u53e3", model="PSDEFValueRule")
public interface IPSAppDEFValueRule
extends IPSDEFValueRule,
IPSAppDataEntityObject {
    public IPSAppDEField getPSAppDEField();
}

