/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Utility.StringHelper
 */
package SA.SRFDA.WS.Ctrl;

import SA.SRFDA.WS.Ctrl.Data.WSPageWB;
import SA.SRFDA.WS.Ctrl.Data.WSWebPart;
import SA.SRFDA.WS.Ctrl.IWSPageHelper;
import SA.SRFDA.WS.Ctrl.IWSWebPartPublishContext;
import SA.SRFramework.Utility.StringHelper;

public class DefaultWSWebPartPublishContext
implements IWSWebPartPublishContext {
    WSPageWB wsPageWB = null;
    IWSPageHelper iWSPageHelper = null;
    WSWebPart wsWebPart = null;
    String strPublishedModel = "";

    public DefaultWSWebPartPublishContext(IWSPageHelper iWSPageHelper, WSWebPart wsWebPart, WSPageWB wsPageWB) {
        this.wsWebPart = wsWebPart;
        this.iWSPageHelper = iWSPageHelper;
        this.wsPageWB = wsPageWB;
    }

    @Override
    public WSPageWB getWSpageWb() {
        return this.wsPageWB;
    }

    @Override
    public String getWebPartPublishedModel() {
        if (StringHelper.IsNullOrEmpty((String)this.strPublishedModel)) {
            this.strPublishedModel = this.getNullPublishedModel();
        }
        return this.strPublishedModel;
    }

    @Override
    public void setWebPartPublishedModel(String strPublishedModel) {
        this.strPublishedModel = strPublishedModel;
    }

    protected String getNullPublishedModel() {
        return "&nbsp;";
    }

    @Override
    public IWSPageHelper getWSPageHelper() {
        return this.iWSPageHelper;
    }
}

