/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.Ctrl;

import SA.SRFDA.Ctrl.Data.DETBBHandler;
import SA.SRFDA.Ctrl.IDAObjectHelper;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;

public interface IDETBBHandlerHelper
extends IDAObjectHelper {
    public void Init(ISRFDAGlobalHelper var1, DETBBHandler var2) throws Exception;

    public String getDEId();

    public String getOldHandler();

    public String getNewHandler();

    public String getMemo();
}

