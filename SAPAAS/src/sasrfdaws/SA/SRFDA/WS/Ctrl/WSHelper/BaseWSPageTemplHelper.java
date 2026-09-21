/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 */
package SA.SRFDA.WS.Ctrl.WSHelper;

import SA.SRFDA.WS.Ctrl.BaseWSObject;
import SA.SRFDA.WS.Ctrl.Data.WSPageTempl;
import SA.SRFDA.WS.Ctrl.IWSPageTemplHelper;
import SA.SRFDA.WS.Ctrl.IWSPageTypeHelper;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;

public class BaseWSPageTemplHelper
extends BaseWSObject
implements IWSPageTemplHelper {
    ISRFDAGlobalHelper iDAGlobalHelper = null;
    IWSPageTypeHelper iWSPageTypeHelper = null;
    WSPageTempl wsPageTempl = null;

    @Override
    public void Init(ISRFDAGlobalHelper iDAGlobalHelper, IWSPageTypeHelper iWSPageTypeHelper, WSPageTempl wsPageTempl) throws Exception {
        this.iDAGlobalHelper = iDAGlobalHelper;
        this.iWSPageTypeHelper = iWSPageTypeHelper;
        this.wsPageTempl = wsPageTempl;
    }

    @Override
    public IWSPageTypeHelper getWSPageTypeHelper() {
        return this.iWSPageTypeHelper;
    }

    @Override
    public WSPageTempl getWsPageTempl() throws Exception {
        return this.wsPageTempl;
    }
}

