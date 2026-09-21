/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFramework.UtilityEx.StringBuilderEx
 */
package SA.SRFDA.BI.Ctrl;

import SA.SRFDA.BI.Ctrl.Data.BIRepPQ;
import SA.SRFDA.BI.Ctrl.IBIRepPanelHelper;
import SA.SRFDA.BI.Ctrl.IBIRepPartPublishContext;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.UtilityEx.StringBuilderEx;

public interface IBIRepPQHelper {
    public void Init(ISRFDAGlobalHelper var1, IBIRepPanelHelper var2, BIRepPQ var3) throws Exception;

    public BIRepPQ getBIRepPQ();

    public void Publish(IBIRepPartPublishContext var1, StringBuilderEx var2) throws Exception;
}

