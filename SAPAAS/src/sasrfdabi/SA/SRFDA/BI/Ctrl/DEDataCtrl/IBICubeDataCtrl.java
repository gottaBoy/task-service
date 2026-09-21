/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Ctrl.Data.Threshold
 *  SA.SRFDA.Ctrl.IDEDataCtrl
 *  SA.SRFramework.DataEx.CallResult
 */
package SA.SRFDA.BI.Ctrl.DEDataCtrl;

import SA.SRFDA.BI.Ctrl.Data.BICubeDimension;
import SA.SRFDA.Ctrl.Data.Threshold;
import SA.SRFDA.Ctrl.IDEDataCtrl;
import SA.SRFramework.DataEx.CallResult;
import java.util.Vector;

public interface IBICubeDataCtrl
extends IDEDataCtrl {
    public CallResult ListBICubeDimensions(String var1, Vector<BICubeDimension> var2);

    public CallResult ListBICubeThresholds(String var1, Vector<Threshold> var2);
}

