/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Base.XMLConfig
 *  SA.SRFramework.Utility.StringHelper
 */
package SA.SRFramework.ValueRule;

import SA.SRFramework.Base.XMLConfig;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.ValueRule.StringLengthConfig;
import java.util.Hashtable;
import org.w3c.dom.Node;

public class StringLengthsConfig
extends XMLConfig {
    public static final String TAG_STRINGLENGTHS = "SRFEXSTRINGLENGTHS";
    public static final String TAG_DEFAULT = "DEFAULT";
    protected Hashtable stringLengths = new Hashtable();
    protected int nDefault = 60;

    protected void OnSetProperty(String strName, String strValue) {
        if (StringHelper.Compare((String)strName, (String)TAG_DEFAULT, (boolean)true) == 0) {
            this.nDefault = StringLengthsConfig.GetValue((String)strValue, (int)this.nDefault);
            return;
        }
        super.OnSetProperty(strName, strValue);
    }

    public void OnLoadNode(String strName, Node xmlNode) {
        if (StringHelper.Compare((String)strName, (String)"SRFEXSTRINGLENGTH", (boolean)true) == 0) {
            StringLengthConfig stringLengthConfig = new StringLengthConfig();
            if (stringLengthConfig.LoadConfig(xmlNode)) {
                this.stringLengths.put(stringLengthConfig.getID().toUpperCase(), stringLengthConfig);
            }
            return;
        }
        super.OnLoadNode(strName, xmlNode);
    }

    public int getStringMaxLength(String strFormItemId) {
        StringLengthConfig stringLengthConfig;
        int nValue = this.nDefault;
        if (this.stringLengths.containsKey(strFormItemId.toUpperCase()) && (stringLengthConfig = (StringLengthConfig)((Object)this.stringLengths.get(strFormItemId.toUpperCase()))) != null && stringLengthConfig.getValue() > 0) {
            nValue = stringLengthConfig.getValue();
        }
        return nValue;
    }
}

