/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 */
package SA.SRFDA.BI.Ctrl;

import SA.SRFDA.BI.Ctrl.Data.BIRepPanel;
import SA.SRFDA.BI.Ctrl.IBIRepPTHelper;
import SA.SRFDA.BI.Ctrl.IBIRepPartHelper;
import SA.SRFDA.BI.Ctrl.IBIRepRPHelper;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;

public interface IBIRepPanelHelper
extends IBIRepPartHelper {
    public void Init(ISRFDAGlobalHelper var1, IBIRepPTHelper var2, BIRepPanel var3) throws Exception;

    public String getPanelModel() throws Exception;

    public String getRepRPModel(IBIRepRPHelper var1) throws Exception;
}

