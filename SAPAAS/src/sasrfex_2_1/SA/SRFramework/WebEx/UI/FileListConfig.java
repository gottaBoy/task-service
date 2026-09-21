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
import SA.SRFramework.WebEx.UI.FileItemConfig;
import java.util.Vector;
import org.w3c.dom.Node;

public class FileListConfig
extends XMLConfig {
    public static final String TAG_NODE_FILE = "FILE";
    Vector<FileItemConfig> files = new Vector();

    public Vector<FileItemConfig> getFileItemConfigs() {
        return this.files;
    }

    public void setFileItemConfigs(Vector<FileItemConfig> files) {
        this.files = files;
    }

    protected void OnLoadNode(String strNodeName, Node node) {
        if (StringHelper.Compare((String)strNodeName, (String)TAG_NODE_FILE, (boolean)true) == 0) {
            FileItemConfig config = new FileItemConfig();
            boolean bOK = config.LoadConfig(node);
            if (bOK) {
                this.files.add(config);
            }
            return;
        }
        super.OnLoadNode(strNodeName, node);
    }
}

