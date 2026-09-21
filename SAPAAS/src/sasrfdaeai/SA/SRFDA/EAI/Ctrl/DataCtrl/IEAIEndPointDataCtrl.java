/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Ctrl.IDEDataCtrl
 *  SA.SRFramework.DataEx.CallResult
 */
package SA.SRFDA.EAI.Ctrl.DataCtrl;

import SA.SRFDA.Ctrl.IDEDataCtrl;
import SA.SRFDA.EAI.Ctrl.Data.EAIEndPoint;
import SA.SRFramework.DataEx.CallResult;
import java.util.Vector;

public interface IEAIEndPointDataCtrl
extends IDEDataCtrl {
    public CallResult GetInboundEndPoints(Vector<EAIEndPoint> var1);

    public CallResult GetOutboundEndPoints(Vector<EAIEndPoint> var1);
}

