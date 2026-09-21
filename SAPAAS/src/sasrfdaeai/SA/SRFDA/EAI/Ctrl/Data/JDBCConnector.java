/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.EAI.Ctrl.Data;

import SA.SRFDA.EAI.Config.BaseJDBCConnectorConfigWriter;
import SA.SRFDA.EAI.Ctrl.Data.BaseEAIObject;

public class JDBCConnector
extends BaseEAIObject {
    public static final String TAG_CONNECTORCW = "CONNECTORCW";

    public String getCONNECTORCW() {
        return this.GetParamStringValue(TAG_CONNECTORCW, this.OnGetDefaultJDBCConnectorCW());
    }

    public void setCONNECTORCW(String strValue) {
        this.SetParamValue(TAG_CONNECTORCW, strValue);
    }

    protected String OnGetDefaultJDBCConnectorCW() {
        return BaseJDBCConnectorConfigWriter.class.getName();
    }
}

