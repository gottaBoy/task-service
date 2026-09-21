/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFramework.UtilityEx.StringBuilderEx
 */
package SA.SRFDA.BI.Ctrl;

import SA.SRFDA.BI.Ctrl.Data.BIRepPDSQ;
import SA.SRFDA.BI.Ctrl.IBIRepPDSHelper;
import SA.SRFDA.BI.Ctrl.IBIRepPartPublishContext;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.UtilityEx.StringBuilderEx;

public interface IBIRepPDSQHelper {
    public void Init(ISRFDAGlobalHelper var1, IBIRepPDSHelper var2, BIRepPDSQ var3) throws Exception;

    public BIRepPDSQ getBIRepPDSQ();

    public void Publish(IBIRepPartPublishContext var1, StringBuilderEx var2) throws Exception;
}

