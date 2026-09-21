/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Data.DataTypeHelper
 *  SA.SRFramework.Utility.StringHelper
 */
package SRFWF.Model;

import SA.SRFramework.Data.DataTypeHelper;
import SA.SRFramework.Utility.StringHelper;
import SRFWF.Ctrl.SRFWFDecideProcess;
import SRFWF.Model.WFBaseProcessConfig;
import SRFWF.Model.WFConnectionsConfig;
import org.w3c.dom.Node;

public class WFDecideProcessConfig
extends WFBaseProcessConfig {
    public static String TAG_WFDECISION = "SRFEXWFDECISION";
    public static final String TAG_PARAMID = "PARAMID";
    public static final String TAG_DATATYPE = "DATATYPE";
    protected WFConnectionsConfig wfConnectionsConfig = new WFConnectionsConfig(this);
    protected String strParamId = "";
    protected int nDataType = 25;

    public WFDecideProcessConfig() {
        this.setObject(SRFWFDecideProcess.class.getName());
    }

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
        if (StringHelper.Compare((String)WFConnectionsConfig.TAG_WFCONNECTIONS, (String)strName, (boolean)true) == 0) {
            this.wfConnectionsConfig.LoadConfig(xmlNode);
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

    public WFConnectionsConfig getConnectionsConfig() {
        return this.wfConnectionsConfig;
    }
}

