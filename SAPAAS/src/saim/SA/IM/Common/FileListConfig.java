/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Base.XMLConfigEx
 *  SA.SRFramework.Utility.StringHelper
 */
package SA.IM.Common;

import SA.IM.Common.FileConfig;
import SA.SRFramework.Base.XMLConfigEx;
import SA.SRFramework.Utility.StringHelper;
import java.util.Vector;
import org.w3c.dom.Node;

public class FileListConfig
extends XMLConfigEx {
    public static final String TAG_NODE_FILE = "FILE";
    Vector<FileConfig> files = new Vector();

    public Vector<FileConfig> getFiles() {
        return this.files;
    }

    public void setFiles(Vector<FileConfig> files) {
        this.files = files;
    }

    protected void OnLoadNode(String strNodeName, Node node) {
        if (StringHelper.Compare((String)strNodeName, (String)TAG_NODE_FILE, (boolean)true) == 0) {
            FileConfig config = new FileConfig();
            boolean bOK = config.LoadConfig(node);
            if (bOK) {
                this.getFiles().add(config);
            }
            return;
        }
        super.OnLoadNode(strNodeName, node);
    }
}

