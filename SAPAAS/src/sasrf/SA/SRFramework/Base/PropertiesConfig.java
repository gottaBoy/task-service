/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFramework.Base;

import SA.SRFramework.Base.PropertyConfig;
import SA.SRFramework.Base.XMLCollectionConfig;
import SA.SRFramework.Utility.StringHelper;
import org.w3c.dom.Node;

public class PropertiesConfig
extends XMLCollectionConfig<PropertyConfig> {
    public static final String TAG_PROPERTIES = "SRFPROPERTIES";

    @Override
    protected void OnLoadNode(String strName, Node xmlNode) {
        PropertyConfig propertyConfig;
        if (StringHelper.Compare(strName, "SRFPROPERTY", true) == 0 && (propertyConfig = new PropertyConfig()).LoadConfig(xmlNode)) {
            this.add(propertyConfig);
            return;
        }
        super.OnLoadNode(strName, xmlNode);
    }

    public PropertyConfig FindProperty(String strId) {
        for (PropertyConfig propertyConfig : this) {
            if (StringHelper.Compare(propertyConfig.getID(), strId, true) != 0) continue;
            return propertyConfig;
        }
        return null;
    }
}

