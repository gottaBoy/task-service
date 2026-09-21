/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFramework.Base;

import SA.SRFramework.Base.PropertiesConfig;
import SA.SRFramework.Base.XMLConfig;
import SA.SRFramework.Utility.StringHelper;
import org.w3c.dom.Node;

public class XMLConfigEx
extends XMLConfig {
    protected PropertiesConfig propertiesConfig = new PropertiesConfig();

    @Override
    protected void OnLoadNode(String strName, Node xmlNode) {
        if (StringHelper.Compare(strName, "SRFPROPERTIES", true) == 0) {
            this.propertiesConfig.LoadConfig(xmlNode);
            return;
        }
        super.OnLoadNode(strName, xmlNode);
    }

    public PropertiesConfig getPropertiesConfig() {
        return this.propertiesConfig;
    }
}

