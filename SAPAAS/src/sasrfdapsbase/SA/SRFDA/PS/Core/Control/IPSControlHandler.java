/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.Control;

import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDataEntity;
import SA.SRFDA.PS.Core.Control.IPSControl;
import SA.SRFDA.PS.Core.Control.IPSControlHandlerAction;
import SA.SRFDA.PS.Core.IPSModelObject;
import SA.SRFDA.PS.Core.PSModelInterfaceMeta;
import SA.SRFDA.PS.Core.PSModelRTIgnoreMeta;
import java.util.Iterator;

@PSModelInterfaceMeta(title="\u754c\u9762\u90e8\u4ef6\u5904\u7406\u5668\u6a21\u578b\u57fa\u7840\u5bf9\u8c61\u63a5\u53e3", implement="PSMDAjaxControlHandlerImpl")
@PSModelRTIgnoreMeta
public interface IPSControlHandler
extends IPSModelObject {
    public int getTempMode();

    public IPSControl getPSControl();

    public IPSAppDataEntity getPSAppDataEntity();

    public Iterator<? extends IPSControlHandlerAction> getPSHandlerActions();

    public IPSControlHandlerAction getPSControlHandlerAction(String var1, boolean var2) throws Exception;
}

