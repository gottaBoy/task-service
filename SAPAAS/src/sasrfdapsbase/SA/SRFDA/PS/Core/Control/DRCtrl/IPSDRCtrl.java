/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.control.drctrl.DRCtrlRootItem
 *  net.ibizsys.paas.control.drctrl.IDRCtrl
 */
package SA.SRFDA.PS.Core.Control.DRCtrl;

import SA.SRFDA.PS.Core.App.Control.IPSAppCounterRef;
import SA.SRFDA.PS.Core.Control.Counter.IPSSysCounterRef;
import SA.SRFDA.PS.Core.Control.IPSAjaxControl;
import SA.SRFDA.PS.Core.PSModelInterfaceMeta;
import net.ibizsys.paas.control.drctrl.DRCtrlRootItem;
import net.ibizsys.paas.control.drctrl.IDRCtrl;

@PSModelInterfaceMeta(title="\u6570\u636e\u5173\u7cfb\u90e8\u4ef6\u6a21\u578b\u57fa\u7840\u5bf9\u8c61\u63a5\u53e3")
public interface IPSDRCtrl
extends IPSAjaxControl,
IDRCtrl {
    public boolean isIncludeMajor();

    public IPSSysCounterRef getPSSysCounterRef();

    public DRCtrlRootItem getRootItem();

    public IPSAppCounterRef getPSAppCounterRef();
}

