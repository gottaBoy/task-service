/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 */
package SA.SRFDA.WS.Ctrl;

import SA.SRFDA.WS.Ctrl.BaseWSObject;
import SA.SRFDA.WS.Ctrl.Data.WSPageTempl;
import SA.SRFDA.WS.Ctrl.Data.WSPageType;
import SA.SRFDA.WS.Ctrl.IWSPageTypeHelper;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import java.util.Vector;

public class WSPageTypeHelper
extends BaseWSObject
implements IWSPageTypeHelper {
    Vector<WSPageTempl> pageTempls = new Vector();
    protected WSPageType wsPageType = null;

    @Override
    public void Init(ISRFDAGlobalHelper iDAGlobalHelper, WSPageType wsPageType) throws Exception {
        this.iDAGlobalHelper = iDAGlobalHelper;
        this.wsPageType = wsPageType;
        this.OnInit();
    }

    protected void OnInit() throws Exception {
    }

    @Override
    public WSPageType getWSPageType() throws Exception {
        return this.wsPageType;
    }

    protected String getId() {
        return this.wsPageType.getWSPAGETYPEID();
    }

    protected String getName() {
        return this.wsPageType.getWSPAGETYPENAME();
    }

    @Override
    public String getHelperObject() {
        return this.wsPageType.getHELPEROBJECT();
    }

    @Override
    public String getPageObject() {
        return this.wsPageType.getPAGEOBJECT();
    }
}

