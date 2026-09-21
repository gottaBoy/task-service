/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Ctrl.IDEHelper
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 */
package SA.SRFDA.Mobile.UIPart;

import SA.SRFDA.Ctrl.IDEHelper;
import SA.SRFDA.Mobile.UIPart.IMobilePublishContext;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;

public interface IMobileUIPart {
    public String getId();

    public IDEHelper getDEHelper();

    public ISRFDAGlobalHelper getDAGlobalHelper();

    public String getUniqueName();

    public void PreparePublish(IMobilePublishContext var1) throws Exception;

    public void Publish(IMobilePublishContext var1) throws Exception;
}

