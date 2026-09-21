/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 */
package SA.SRFDA.BI.Ctrl;

import SA.SRFDA.BI.Ctrl.Data.BIRepPT;
import SA.SRFDA.BI.Ctrl.Data.BIRepPanel;
import SA.SRFDA.BI.Ctrl.IBIRepPanelHelper;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;

public interface IBIRepPTHelper {
    public void Init(ISRFDAGlobalHelper var1, BIRepPT var2) throws Exception;

    public IBIRepPanelHelper FindBIRepPanel(BIRepPanel var1) throws Exception;

    public String getPTModel();

    public int getVersion();
}

