/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  com.fasterxml.jackson.databind.node.ObjectNode
 *  net.sf.json.JSONObject
 */
package SA.SRFDA.PS.Core.App.Control;

import SA.SRFDA.PS.Core.App.Control.IPSAppCounter;
import SA.SRFDA.PS.Core.App.Control.IPSAppCounterRef;
import SA.SRFDA.PS.Core.Control.Counter.PSSysCounterRefImpl;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import net.sf.json.JSONObject;

public class PSAppCounterRefImpl
extends PSSysCounterRefImpl
implements IPSAppCounterRef {
    private IPSAppCounter iPSAppCounter = null;

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSAppCounter iPSAppCounter, JSONObject jsonRefMode) throws Exception {
        this.iPSAppCounter = iPSAppCounter;
        super.init(iDAGlobalHelper, iPSAppCounter, jsonRefMode);
    }

    @Override
    @PSModelRTMeta(description="\u5e94\u7528\u8ba1\u6570\u5668", child=true)
    public IPSAppCounter getPSAppCounter() {
        return this.iPSAppCounter;
    }

    @Override
    protected void onFillModelRefNode(ObjectNode objectNode, String strModelRefType) throws Exception {
        super.onFillModelRefNode(objectNode, strModelRefType);
    }
}

