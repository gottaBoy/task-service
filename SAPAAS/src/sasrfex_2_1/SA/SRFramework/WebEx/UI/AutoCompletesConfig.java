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
import SA.SRFramework.WebEx.UI.AutoCompleteConfig;
import java.util.Hashtable;
import org.w3c.dom.Node;

public class AutoCompletesConfig
extends XMLConfig {
    public static final String TAG_AUTOCOMPLETES = "SRFEXAUTOCOMPLETES";
    protected Hashtable autoCompletes = new Hashtable();

    public void OnLoadNode(String strName, Node xmlNode) {
        if (StringHelper.Compare((String)strName, (String)"SRFEXAUTOCOMPLETE", (boolean)true) == 0) {
            AutoCompleteConfig autoCompleteConfig = new AutoCompleteConfig();
            if (autoCompleteConfig.LoadConfig(xmlNode)) {
                this.autoCompletes.put(autoCompleteConfig.getID().toUpperCase(), autoCompleteConfig);
            }
            return;
        }
        super.OnLoadNode(strName, xmlNode);
    }

    public AutoCompleteConfig getAutoCompleteConfig(String strACMode) {
        if (this.autoCompletes.containsKey(strACMode.toUpperCase())) {
            AutoCompleteConfig autoCompleteConfig = (AutoCompleteConfig)((Object)this.autoCompletes.get(strACMode.toUpperCase()));
            return autoCompleteConfig;
        }
        return null;
    }
}

