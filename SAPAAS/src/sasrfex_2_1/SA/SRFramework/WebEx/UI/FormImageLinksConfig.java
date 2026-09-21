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
import SA.SRFramework.WebEx.UI.FormImageLinkConfig;
import java.util.Hashtable;
import org.w3c.dom.Node;

public class FormImageLinksConfig
extends XMLConfig {
    public static final String TAG_FORMIMAGELINKS = "SRFEXFORMIMAGELINKS";
    protected Hashtable formImageLinks = new Hashtable();

    public void OnLoadNode(String strName, Node xmlNode) {
        if (StringHelper.Compare((String)strName, (String)"SRFEXFORMIMAGELINK", (boolean)true) == 0) {
            FormImageLinkConfig formImageLinkConfig = new FormImageLinkConfig();
            if (formImageLinkConfig.LoadConfig(xmlNode)) {
                this.formImageLinks.put(formImageLinkConfig.getID().toUpperCase(), formImageLinkConfig);
            }
            return;
        }
        super.OnLoadNode(strName, xmlNode);
    }

    public FormImageLinkConfig getFormImageLinkConfig(String strFormImageLinkId) {
        if (this.formImageLinks.containsKey(strFormImageLinkId.toUpperCase())) {
            FormImageLinkConfig formImageLinkConfig = (FormImageLinkConfig)((Object)this.formImageLinks.get(strFormImageLinkId.toUpperCase()));
            return formImageLinkConfig;
        }
        return null;
    }
}

