/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Data.DataTypeHelper
 *  SA.SRFramework.Utility.StringHelper
 */
package SA.SRFDA.EAI.Model;

import SA.SRFDA.EAI.Model.EAIBaseProcessConfig;
import SA.SRFDA.EAI.Model.EAIConnectionsConfig;
import SA.SRFramework.Data.DataTypeHelper;
import SA.SRFramework.Utility.StringHelper;
import org.w3c.dom.Node;

public class EAIDecideProcessConfig
extends EAIBaseProcessConfig {
    public static String TAG_EAIDECISION = "SRFEXEAIDECISION";
    public static final String TAG_PARAMID = "PARAMID";
    public static final String TAG_DATATYPE = "DATATYPE";
    protected EAIConnectionsConfig eaiConnectionsConfig = new EAIConnectionsConfig(this);
    protected String strParamId = "";
    protected int nDataType = 25;

    @Override
    protected void OnSetProperty(String strName, String strValue) {
        if (StringHelper.Compare((String)strName, (String)TAG_PARAMID, (boolean)true) == 0) {
            this.strParamId = strValue;
            return;
        }
        if (StringHelper.Compare((String)strName, (String)TAG_DATATYPE, (boolean)true) == 0) {
            this.nDataType = DataTypeHelper.FromString((String)strValue);
            return;
        }
        super.OnSetProperty(strName, strValue);
    }

    public void OnLoadNode(String strName, Node xmlNode) {
        if (StringHelper.Compare((String)EAIConnectionsConfig.TAG_EAICONNECTIONS, (String)strName, (boolean)true) == 0) {
            this.eaiConnectionsConfig.LoadConfig(xmlNode);
            return;
        }
        super.OnLoadNode(strName, xmlNode);
    }

    public String getParamId() {
        return this.strParamId;
    }

    public void setParamId(String value) {
        this.strParamId = value;
    }

    public EAIConnectionsConfig getConnectionsConfig() {
        return this.eaiConnectionsConfig;
    }
}

