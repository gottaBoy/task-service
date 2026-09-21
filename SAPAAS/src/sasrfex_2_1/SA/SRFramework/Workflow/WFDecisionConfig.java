/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Data.DataTypeHelper
 *  SA.SRFramework.Utility.StringHelper
 */
package SA.SRFramework.Workflow;

import SA.SRFramework.Data.DataTypeHelper;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.Workflow.WFConnectionsConfig;
import SA.SRFramework.Workflow.WFEntityConfig;
import org.w3c.dom.Node;

public class WFDecisionConfig
extends WFEntityConfig {
    public static final String TAG_WFDECISION = "SRFEXWFDECISION";
    public static final String TAG_OBJECT = "OBJECT";
    public static final String TAG_PARAMID = "PARAMID";
    public static final String TAG_DATATYPE = "DATATYPE";
    protected WFConnectionsConfig connectsConfig = new WFConnectionsConfig();
    protected String strObject = null;
    protected String strParamId = "";
    protected int nDataType = 25;

    @Override
    public void OnLoadNode(String strName, Node xmlNode) {
        if (StringHelper.Compare((String)strName, (String)"SRFEXWFCONNECTIONS", (boolean)true) == 0) {
            this.connectsConfig.LoadConfig(xmlNode);
            return;
        }
        super.OnLoadNode(strName, xmlNode);
    }

    public WFConnectionsConfig getConnectionsConfig() {
        return this.connectsConfig;
    }

    @Override
    protected void OnSetProperty(String strName, String strValue) {
        if (StringHelper.Compare((String)strName, (String)TAG_OBJECT, (boolean)true) == 0) {
            this.strObject = strValue;
            return;
        }
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

    public String getObject() {
        return this.strObject;
    }

    public void setObject(String value) {
        this.strObject = value;
    }

    public String getParamId() {
        return this.strParamId;
    }

    public void setParamId(String value) {
        this.strParamId = value;
    }

    public int getDataType() {
        return this.nDataType;
    }

    public void setDataType(int nDataType) {
        this.nDataType = nDataType;
    }
}

