/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Base.XMLConfig
 *  SA.SRFramework.Utility.StringHelper
 */
package SA.SRFDA.Model;

import SA.SRFDA.Model.DGModelGroupLogicConfig;
import SA.SRFDA.Model.DGModelJoinQueriesConfig;
import SA.SRFramework.Base.XMLConfig;
import SA.SRFramework.Utility.StringHelper;
import org.w3c.dom.Node;

public abstract class DGModelBaseQueryConfig
extends XMLConfig {
    public static final String TAG_DEID = "DEID";
    public static final String TAG_EXTSELECT = "EXTSELECT";
    public static final String TAG_ALIAS = "ALIAS";
    protected DGModelJoinQueriesConfig joinQueriesConfig = null;
    protected DGModelGroupLogicConfig logicConfig = null;
    protected String strDEID = "";
    protected String strExtSelect = "";
    protected String strAlias = "";

    public void OnLoadNode(String strName, Node xmlNode) {
        if (StringHelper.Compare((String)strName, (String)"SRFDADGMODELJOINQUERIES", (boolean)true) == 0) {
            if (this.joinQueriesConfig == null) {
                this.joinQueriesConfig = new DGModelJoinQueriesConfig();
            }
            this.joinQueriesConfig.LoadConfig(xmlNode);
            return;
        }
        if (StringHelper.Compare((String)strName, (String)"SRFDADGMODELGROUPLOGIC", (boolean)true) == 0) {
            if (this.logicConfig == null) {
                this.logicConfig = new DGModelGroupLogicConfig();
            }
            this.logicConfig.LoadConfig(xmlNode);
            return;
        }
        super.OnLoadNode(strName, xmlNode);
    }

    public DGModelJoinQueriesConfig getJoinQueriesConfig() {
        return this.joinQueriesConfig;
    }

    public DGModelGroupLogicConfig getLogicConfig() {
        return this.logicConfig;
    }

    protected void OnSetProperty(String strName, String strValue) {
        if (StringHelper.Compare((String)strName, (String)TAG_DEID, (boolean)true) == 0) {
            this.strDEID = strValue;
            return;
        }
        if (StringHelper.Compare((String)strName, (String)TAG_EXTSELECT, (boolean)true) == 0) {
            this.strExtSelect = strValue;
            return;
        }
        if (StringHelper.Compare((String)strName, (String)TAG_ALIAS, (boolean)true) == 0) {
            this.strAlias = strValue;
            return;
        }
        super.OnSetProperty(strName, strValue);
    }

    public String getDEID() {
        return this.strDEID;
    }

    public void setDEID(String strDEID) {
        this.strDEID = strDEID;
    }

    public String getExtSelect() {
        return this.strExtSelect;
    }

    public void setExtSelect(String strExtSelect) {
        this.strExtSelect = strExtSelect;
    }

    public String getAlias() {
        return this.strAlias;
    }

    public void setAlias(String strAlias) {
        this.strAlias = strAlias;
    }

    public void InitLogicConfig() {
        if (this.logicConfig != null) {
            return;
        }
        this.logicConfig = new DGModelGroupLogicConfig();
    }

    public void SetLogicConfig(DGModelGroupLogicConfig logicConfig) {
        this.logicConfig = logicConfig;
    }

    public void InitJoinQueriesConfig() {
        if (this.joinQueriesConfig != null) {
            return;
        }
        this.joinQueriesConfig = new DGModelJoinQueriesConfig();
    }

    public void SetJoinQueriesConfig(DGModelJoinQueriesConfig joinQueriesConfig) {
        this.joinQueriesConfig = joinQueriesConfig;
    }
}

