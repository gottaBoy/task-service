/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Utility.StringHelper
 */
package SA.SRFDA.Ctrl.DataNotify.Model;

import SA.SRFDA.Ctrl.DataNotify.Model.DataNotifyBaseLogicConfig;
import SA.SRFDA.Ctrl.DataNotify.Model.DataNotifyCustomLogicConfig;
import SA.SRFDA.Ctrl.DataNotify.Model.DataNotifySingleLogicConfig;
import SA.SRFramework.Utility.StringHelper;
import java.util.Vector;
import org.w3c.dom.Node;

public class DataNotifyGroupLogicConfig
extends DataNotifyBaseLogicConfig {
    public static final String TAG_SRFDADATANOTIFYGROUPLOGIC = "SRFDADATANOTIFYGROUPLOGIC";
    protected Vector<DataNotifyBaseLogicConfig> childLogics = new Vector();
    public static final String TAG_NOT = "NOT";
    protected boolean bNot = false;

    public void OnLoadNode(String strName, Node xmlNode) {
        if (StringHelper.Compare((String)strName, (String)TAG_SRFDADATANOTIFYGROUPLOGIC, (boolean)true) == 0) {
            DataNotifyGroupLogicConfig item = new DataNotifyGroupLogicConfig();
            item.LoadConfig(xmlNode);
            this.childLogics.add(item);
            return;
        }
        if (StringHelper.Compare((String)strName, (String)"SRFDADATANOTIFYCUSTOMLOGIC", (boolean)true) == 0) {
            DataNotifyCustomLogicConfig item = new DataNotifyCustomLogicConfig();
            item.LoadConfig(xmlNode);
            this.childLogics.add(item);
            return;
        }
        if (StringHelper.Compare((String)strName, (String)"SRFDADATANOTIFYSINGLELOGIC", (boolean)true) == 0) {
            DataNotifySingleLogicConfig item = new DataNotifySingleLogicConfig();
            item.LoadConfig(xmlNode);
            this.childLogics.add(item);
            return;
        }
        super.OnLoadNode(strName, xmlNode);
    }

    @Override
    protected void OnSetProperty(String strName, String strValue) {
        if (StringHelper.Compare((String)strName, (String)TAG_NOT, (boolean)true) == 0) {
            this.setNot(DataNotifyGroupLogicConfig.GetValue((String)strValue, (boolean)this.bNot));
            return;
        }
        super.OnSetProperty(strName, strValue);
    }

    public boolean isNot() {
        return this.bNot;
    }

    public void setNot(boolean not) {
        this.bNot = not;
    }

    public Vector<DataNotifyBaseLogicConfig> getChildLogics() {
        return this.childLogics;
    }
}

