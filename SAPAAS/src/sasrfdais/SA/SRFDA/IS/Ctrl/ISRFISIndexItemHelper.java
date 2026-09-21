/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.CallResult
 */
package SA.SRFDA.IS.Ctrl;

import SA.SRFDA.IS.Ctrl.Data.ISItem;
import SA.SRFDA.IS.Ctrl.ISRFISIndexContext;
import SA.SRFDA.IS.Ctrl.IndexDocument;
import SA.SRFramework.DataEx.CallResult;
import java.util.Date;
import java.util.Vector;

public interface ISRFISIndexItemHelper {
    public CallResult Index(ISRFISIndexContext var1, ISItem var2, boolean var3, Date var4, Vector<IndexDocument> var5);
}

