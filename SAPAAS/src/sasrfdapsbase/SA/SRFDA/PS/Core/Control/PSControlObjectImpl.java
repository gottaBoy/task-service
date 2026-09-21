/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.fasterxml.jackson.databind.node.ObjectNode
 *  net.ibizsys.paas.util.StringHelper
 */
package SA.SRFDA.PS.Core.Control;

import SA.SRFDA.PS.Core.Control.IPSControl;
import SA.SRFDA.PS.Core.Control.IPSControlObject;
import SA.SRFDA.PS.Core.PSObjectImpl;
import com.fasterxml.jackson.databind.node.ObjectNode;
import net.ibizsys.paas.util.StringHelper;

public class PSControlObjectImpl
extends PSObjectImpl
implements IPSControlObject {
    @Override
    public IPSControl getOwnedPSControl() {
        return null;
    }

    @Override
    public String getPSSysModelInstId() {
        return this.getOwnedPSControl().getPSSysModelInstId();
    }

    @Override
    public String getFullModelName() {
        if (this.getOwnedPSControl() != null) {
            return StringHelper.format((String)"%1$s|%2$s", (Object)this.getOwnedPSControl().getFullModelName(), (Object)this.getModelName());
        }
        return super.getFullModelName();
    }

    @Override
    protected void onFillModelRefNode(ObjectNode objectNode, String strModelRefType) throws Exception {
        objectNode.put("modelref", true);
        if (!StringHelper.isNullOrEmpty((String)this.getModelRefId())) {
            objectNode.put("id", this.getModelRefId());
        }
    }

    @Override
    protected String onGetMOSFilePath() {
        return null;
    }

    @Override
    protected String onGetRTMOSFilePath() {
        return null;
    }
}

