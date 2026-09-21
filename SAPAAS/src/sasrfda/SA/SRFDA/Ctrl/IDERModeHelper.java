/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.Ctrl;

import SA.SRFDA.Ctrl.Data.DERMode;
import SA.SRFDA.Ctrl.IDAObjectHelper;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;

public interface IDERModeHelper
extends IDAObjectHelper {
    public void Init(ISRFDAGlobalHelper var1, DERMode var2) throws Exception;

    public String getMemo();

    @Override
    public int getVersion();

    public String getHelperObject();

    public int getOrderFlag();

    public String getHelperParam();

    public String getTVPPublisher();

    public String getTVPPublisherParam();
}

