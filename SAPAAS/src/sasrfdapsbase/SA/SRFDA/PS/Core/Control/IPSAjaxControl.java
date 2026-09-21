/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.control.IAjaxControl
 */
package SA.SRFDA.PS.Core.Control;

import SA.SRFDA.PS.Core.Control.Ajax.IPSAjaxControlHandler;
import SA.SRFDA.PS.Core.Control.IPSAjaxControlParam;
import SA.SRFDA.PS.Core.Control.IPSControl;
import SA.SRFDA.PS.Core.PSModelInterfaceMeta;
import net.ibizsys.paas.control.IAjaxControl;

@PSModelInterfaceMeta(title="\u5f02\u6b65\u5904\u7406\u754c\u9762\u90e8\u4ef6\u6a21\u578b\u57fa\u7840\u5bf9\u8c61\u63a5\u53e3")
public interface IPSAjaxControl
extends IPSControl,
IAjaxControl {
    public IPSAjaxControlParam getPSAjaxControlParam();

    public IPSAjaxControlHandler getPSAjaxControlHandler();

    public boolean isTempMode();

    public boolean isAutoLoad();

    public boolean isEnableItemPrivilege();

    public int getRecvAjaxActionMode();

    public boolean isAjaxCtrl();

    public boolean isShowBusyIndicator();

    public boolean isLocalMode();
}

