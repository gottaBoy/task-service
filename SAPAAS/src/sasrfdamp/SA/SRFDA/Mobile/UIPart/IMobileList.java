/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Ctrl.Data.MBList
 *  SA.SRFDA.Ctrl.IDEHelper
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 */
package SA.SRFDA.Mobile.UIPart;

import SA.SRFDA.Ctrl.Data.MBList;
import SA.SRFDA.Ctrl.IDEHelper;
import SA.SRFDA.Mobile.UIPart.IMobileUIPart;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;

public interface IMobileList
extends IMobileUIPart {
    public void Init(ISRFDAGlobalHelper var1, IDEHelper var2, String var3, MBList var4) throws Exception;
}

