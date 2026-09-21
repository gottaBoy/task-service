/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.Control;

import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDELogic;
import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDEMethod;
import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDataEntity;
import SA.SRFDA.PS.Core.Control.IPSControl;
import SA.SRFDA.PS.Core.IPSModelObject;
import SA.SRFDA.PS.Core.PSModelInterfaceMeta;

@PSModelInterfaceMeta(title="\u754c\u9762\u90e8\u4ef6\u884c\u4e3a\u6a21\u578b\u57fa\u7840\u5bf9\u8c61\u63a5\u53e3", implement="PSAjaxControlHandlerActionImpl")
public interface IPSControlAction
extends IPSModelObject {
    public IPSControl getPSControl();

    public IPSAppDataEntity getPSAppDataEntity();

    public IPSAppDEMethod getPSAppDEMethod();

    public IPSAppDELogic getADPSAppDELogic();

    public int getTimeout();

    public String getActionName();

    public String getActionDesc();
}

