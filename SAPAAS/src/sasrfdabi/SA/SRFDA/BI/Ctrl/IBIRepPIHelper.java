/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 */
package SA.SRFDA.BI.Ctrl;

import SA.SRFDA.BI.Ctrl.Data.BIRepPI;
import SA.SRFDA.BI.Ctrl.IBIRepPanelHelper;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;

public interface IBIRepPIHelper {
    public void Init(ISRFDAGlobalHelper var1, IBIRepPanelHelper var2, BIRepPI var3) throws Exception;

    public BIRepPI getBIRepPI();

    public String getBIRepPartId();

    public String getBIRepPIId();

    public String getCustomContent();

    public String getBIRepPDSId();

    public String getBIRepPQId();

    public String getCustomCaption();

    public boolean isShowCaption();

    public boolean isShowBorder();
}

