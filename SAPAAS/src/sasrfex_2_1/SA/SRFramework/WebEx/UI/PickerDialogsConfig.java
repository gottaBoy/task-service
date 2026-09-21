/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Base.XMLConfig
 *  SA.SRFramework.Utility.StringHelper
 */
package SA.SRFramework.WebEx.UI;

import SA.SRFramework.Base.XMLConfig;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.WebEx.UI.PickerDialogConfig;
import java.util.Hashtable;
import org.w3c.dom.Node;

public class PickerDialogsConfig
extends XMLConfig {
    public static final String TAG_PICKERDIALOGS = "SRFEXPICKERDIALOGS";
    protected Hashtable pickerDialogs = new Hashtable();

    public void OnLoadNode(String strName, Node xmlNode) {
        if (StringHelper.Compare((String)strName, (String)"SRFEXPICKERDIALOG", (boolean)true) == 0) {
            PickerDialogConfig pickerDialogConfig = new PickerDialogConfig();
            if (pickerDialogConfig.LoadConfig(xmlNode)) {
                this.pickerDialogs.put(pickerDialogConfig.getID().toUpperCase(), pickerDialogConfig);
            }
            return;
        }
        super.OnLoadNode(strName, xmlNode);
    }

    public PickerDialogConfig getPickerDialogConfig(String strPickerDialogId) {
        if (this.pickerDialogs.containsKey(strPickerDialogId.toUpperCase())) {
            PickerDialogConfig pickerDialogConfig = (PickerDialogConfig)((Object)this.pickerDialogs.get(strPickerDialogId.toUpperCase()));
            return pickerDialogConfig;
        }
        return null;
    }
}

