/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.WS.Ctrl;

import SA.SRFDA.WS.Ctrl.Data.WSPageWB;
import SA.SRFDA.WS.Ctrl.IWSPageHelper;

public interface IWSWebPartPublishContext {
    public WSPageWB getWSpageWb();

    public IWSPageHelper getWSPageHelper();

    public void setWebPartPublishedModel(String var1);

    public String getWebPartPublishedModel();
}

