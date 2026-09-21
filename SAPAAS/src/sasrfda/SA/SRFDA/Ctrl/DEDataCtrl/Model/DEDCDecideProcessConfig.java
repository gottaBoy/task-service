/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Data.DataTypeHelper
 *  SA.SRFramework.Utility.StringHelper
 */
package SA.SRFDA.Ctrl.DEDataCtrl.Model;

import SA.SRFDA.Ctrl.DEDataCtrl.Model.DEDCBaseProcessConfig;
import SA.SRFDA.Ctrl.DEDataCtrl.Model.DEDCConnectionsConfig;
import SA.SRFramework.Data.DataTypeHelper;
import SA.SRFramework.Utility.StringHelper;
import org.w3c.dom.Node;

public class DEDCDecideProcessConfig
extends DEDCBaseProcessConfig {
    public static String TAG_DEDCDECISION = "SRFEXDEDCDECISION";
    public static final String TAG_PARAMID = "PARAMID";
    public static final String TAG_DATATYPE = "DATATYPE";
    protected DEDCConnectionsConfig eaiConnectionsConfig = new DEDCConnectionsConfig(this);
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

    @Override
    public void OnLoadNode(String strName, Node xmlNode) {
        if (StringHelper.Compare((String)DEDCConnectionsConfig.TAG_DEDCCONNECTIONS, (String)strName, (boolean)true) == 0) {
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

    public DEDCConnectionsConfig getConnectionsConfig() {
        return this.eaiConnectionsConfig;
    }
}

