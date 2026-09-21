/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.App.Control;

import SA.SRFDA.PS.Core.App.Control.IPSAppCounterRef;
import SA.SRFDA.PS.Core.CodeList.IPSCodeList;
import SA.SRFDA.PS.Core.Control.Counter.IPSSysCounterRef;
import SA.SRFDA.PS.Core.IPSModelObject;
import SA.SRFDA.PS.Core.PSModelInterfaceMeta;

@PSModelInterfaceMeta(title="\u5e94\u7528\u89c6\u56fe\u5feb\u901f\u5206\u7ec4\u6a21\u578b\u5bf9\u8c61\u63a5\u53e3")
public interface IPSAppViewQuickGroup
extends IPSModelObject {
    public IPSCodeList getPSCodeList();

    public IPSSysCounterRef getPSSysCounterRef();

    public IPSAppCounterRef getPSAppCounterRef();
}

