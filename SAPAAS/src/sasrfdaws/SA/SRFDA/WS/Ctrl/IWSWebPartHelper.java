/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 */
package SA.SRFDA.WS.Ctrl;

import SA.SRFDA.WS.Ctrl.Data.WSWebPart;
import SA.SRFDA.WS.Ctrl.IWSWBTypeHelper;
import SA.SRFDA.WS.Ctrl.IWSWebPartPublishContext;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;

public interface IWSWebPartHelper {
    public void Init(ISRFDAGlobalHelper var1, IWSWBTypeHelper var2, WSWebPart var3) throws Exception;

    public WSWebPart getWSWebPart();

    public void Publish(IWSWebPartPublishContext var1) throws Exception;
}

