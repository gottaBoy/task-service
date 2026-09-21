/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 */
package SA.SRFDA.BI.Ctrl;

import SA.SRFDA.BI.Ctrl.Data.BIRepFilter;
import SA.SRFDA.BI.Ctrl.IBIRepPartHelper;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;

public interface IBIRepFilterHelper
extends IBIRepPartHelper {
    public void Init(ISRFDAGlobalHelper var1, BIRepFilter var2) throws Exception;

    public int getCaptionWidth();
}

