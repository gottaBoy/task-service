/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.App.View;

import SA.SRFDA.PS.Core.App.Control.IPSAppCounter;
import SA.SRFDA.PS.Core.App.IPSApplicationObject;
import SA.SRFDA.PS.Core.PF.IPSPFXCodeObject;
import SA.SRFDA.PS.Core.PSModelInterfaceMeta;
import SA.SRFDA.PS.Core.View.IPSUIAction;

@PSModelInterfaceMeta(title="\u5e94\u7528\u754c\u9762\u884c\u4e3a\u6a21\u578b\u5bf9\u8c61\u63a5\u53e3")
public interface IPSAppUIAction
extends IPSUIAction,
IPSApplicationObject {
    public String getParamJOString();

    public String getContextJOString();

    @Override
    public String getCounterId();

    public IPSAppCounter getPSAppCounter() throws Exception;

    public String getCounterParamJOString();

    public IPSPFXCodeObject getRender();
}

