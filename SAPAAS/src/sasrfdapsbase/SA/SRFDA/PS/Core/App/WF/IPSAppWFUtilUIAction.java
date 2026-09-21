/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.App.WF;

import SA.SRFDA.PS.Core.App.IPSApplicationObject;
import SA.SRFDA.PS.Core.App.View.IPSAppUIAction;
import SA.SRFDA.PS.Core.App.WF.IPSAppWF;
import SA.SRFDA.PS.Core.PSModelInterfaceMeta;
import SA.SRFDA.PS.Core.PSModelPFIgnoreMeta;
import SA.SRFDA.PS.Core.WF.IPSWFUtilUIAction;

@PSModelPFIgnoreMeta
@PSModelInterfaceMeta(title="\u5e94\u7528\u5de5\u4f5c\u6d41\u529f\u80fd\u754c\u9762\u884c\u4e3a\u6a21\u578b\u5bf9\u8c61\u63a5\u53e3", model="PSWFUtilUIAction")
public interface IPSAppWFUtilUIAction
extends IPSWFUtilUIAction,
IPSApplicationObject {
    public IPSAppUIAction getPSAppUIAction();

    public IPSAppWF getPSAppWF();
}

