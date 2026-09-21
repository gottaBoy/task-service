/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 */
package SA.SRFDA.BI.Ctrl;

import SA.SRFDA.BI.Ctrl.Data.BIRepFI;
import SA.SRFDA.BI.Ctrl.IBIRepFIPublishContext;
import SA.SRFDA.BI.Ctrl.IBIRepFITypeHelper;
import SA.SRFDA.BI.Ctrl.IBIRepFilterHelper;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;

public interface IBIRepFIHelper {
    public void Init(ISRFDAGlobalHelper var1, IBIRepFilterHelper var2, IBIRepFITypeHelper var3, BIRepFI var4) throws Exception;

    public IBIRepFITypeHelper getBIRepFIType();

    public int getColumnSpan();

    public void Publish(IBIRepFIPublishContext var1) throws Exception;

    public boolean isShowCaption();

    public String getCaption();
}

