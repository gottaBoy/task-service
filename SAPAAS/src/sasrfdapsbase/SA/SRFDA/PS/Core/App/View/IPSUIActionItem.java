/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.App.View;

import SA.SRFDA.PS.Core.App.View.IPSAppView;
import SA.SRFDA.PS.Core.App.View.IPSAppViewUIAction;
import SA.SRFDA.PS.Core.PSModelInterfaceMeta;
import SA.SRFDA.PS.Core.PSModelRTIgnoreMeta;

@PSModelInterfaceMeta(title="\u754c\u9762\u884c\u4e3a\u9879\u6a21\u578b\u5bf9\u8c61\u63a5\u53e3")
@PSModelRTIgnoreMeta
public interface IPSUIActionItem
extends IPSAppViewUIAction {
    public IPSAppViewUIAction getPSAppViewUIAction();

    @Override
    public IPSAppView getPSAppView();
}

