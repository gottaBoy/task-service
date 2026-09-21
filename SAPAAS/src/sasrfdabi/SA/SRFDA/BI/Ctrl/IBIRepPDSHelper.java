/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFramework.UtilityEx.StringBuilderEx
 */
package SA.SRFDA.BI.Ctrl;

import SA.SRFDA.BI.Ctrl.Data.BIRepPDS;
import SA.SRFDA.BI.Ctrl.IBIRepPanelHelper;
import SA.SRFDA.BI.Ctrl.IBIRepPartPublishContext;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.UtilityEx.StringBuilderEx;

public interface IBIRepPDSHelper {
    public void Init(ISRFDAGlobalHelper var1, IBIRepPanelHelper var2, BIRepPDS var3) throws Exception;

    public BIRepPDS getBIRepPDS();

    public void Publish(IBIRepPartPublishContext var1, StringBuilderEx var2) throws Exception;

    public boolean isEnableSort();

    public String getSortMeasure() throws Exception;

    public String getSortDir();

    public int getTopCount();
}

