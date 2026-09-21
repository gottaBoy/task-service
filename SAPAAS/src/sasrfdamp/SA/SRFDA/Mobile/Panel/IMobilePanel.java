/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Ctrl.Data.MBPanel
 *  SA.SRFDA.Ctrl.IDEHelper
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 */
package SA.SRFDA.Mobile.Panel;

import SA.SRFDA.Ctrl.Data.MBPanel;
import SA.SRFDA.Ctrl.IDEHelper;
import SA.SRFDA.Mobile.UIPart.IMobileUIPart;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import java.util.Vector;

public interface IMobilePanel
extends IMobileUIPart {
    public void Init(ISRFDAGlobalHelper var1, IDEHelper var2, String var3, MBPanel var4) throws Exception;

    public void CalcRelatedParts(Vector<String> var1) throws Exception;

    public void GetRelatedUIParts(Vector<IMobileUIPart> var1) throws Exception;
}

