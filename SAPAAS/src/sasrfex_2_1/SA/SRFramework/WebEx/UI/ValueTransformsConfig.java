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
import SA.SRFramework.WebEx.UI.ValueTransformConfig;
import java.util.Hashtable;
import org.w3c.dom.Node;

public class ValueTransformsConfig
extends XMLConfig {
    public static final String TAG_VALUETRANSFORMS = "SRFEXVALUETRANSFORMS";
    protected Hashtable valueTransforms = new Hashtable();

    public void OnLoadNode(String strName, Node xmlNode) {
        if (StringHelper.Compare((String)strName, (String)"SRFEXVALUETRANSFORM", (boolean)true) == 0) {
            ValueTransformConfig valueTransformConfig = new ValueTransformConfig();
            if (valueTransformConfig.LoadConfig(xmlNode)) {
                this.valueTransforms.put(valueTransformConfig.getID().toUpperCase(), valueTransformConfig);
            }
            return;
        }
        super.OnLoadNode(strName, xmlNode);
    }

    public ValueTransformConfig getValueTransformConfig(String strValueTransform) {
        if (this.valueTransforms.containsKey(strValueTransform.toUpperCase())) {
            ValueTransformConfig valueTransformConfig = (ValueTransformConfig)((Object)this.valueTransforms.get(strValueTransform.toUpperCase()));
            return valueTransformConfig;
        }
        return null;
    }
}

