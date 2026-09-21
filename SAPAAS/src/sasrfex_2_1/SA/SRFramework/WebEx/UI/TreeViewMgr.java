/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Base.ConfigMgr
 *  SA.SRFramework.Utility.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 *  org.apache.xerces.parsers.DOMParser
 */
package SA.SRFramework.WebEx.UI;

import SA.SRFramework.Base.ConfigMgr;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.WebEx.UI.TreePanelConfig;
import java.io.File;
import java.util.Hashtable;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.xerces.parsers.DOMParser;
import org.w3c.dom.Document;

public class TreeViewMgr
extends ConfigMgr {
    private static final Log log = LogFactory.getLog(TreeViewMgr.class);
    private final byte[] key;

    public TreeViewMgr() {
        byte[] byArray = new byte[8];
        byArray[0] = 1;
        byArray[1] = 9;
        byArray[2] = 9;
        byArray[3] = 7;
        byArray[5] = 7;
        byArray[7] = 1;
        this.key = byArray;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    protected Document GetDocument(String strTreeViewId) {
        String strDPConfigPath = this.GetConfigFilePath("treeview" + this.strFolderSeperator + this.GetRealPath(strTreeViewId) + ".xml");
        File file = new File(strDPConfigPath);
        if (file.exists()) {
            long nLastModify = file.lastModified();
            Hashtable hashtable = this.fileList;
            synchronized (hashtable) {
                Long nCurLastModify;
                if (this.fileList.containsKey(strDPConfigPath) && nLastModify == (nCurLastModify = (Long)this.modifydateList.get(strDPConfigPath))) {
                    Document doc = (Document)this.fileList.get(strDPConfigPath);
                    return doc;
                }
            }
            try {
                DOMParser parser = new DOMParser();
                if (this.bEncrypt) {
                    parser.parse(TreeViewMgr.getContent((String)strDPConfigPath, (byte[])this.key));
                } else {
                    parser.parse(strDPConfigPath);
                }
                Document doc = parser.getDocument();
                Hashtable hashtable2 = this.fileList;
                synchronized (hashtable2) {
                    this.fileList.put(strDPConfigPath, doc);
                    this.modifydateList.put(strDPConfigPath, nLastModify);
                }
                return doc;
            }
            catch (Exception ex) {
                log.error((Object)"\u52a0\u8f7d\u6811\u89c6\u56fe\u914d\u7f6e\u6587\u4ef6\u51fa\u73b0\u9519\u8bef", (Throwable)ex);
                return null;
            }
        }
        log.error((Object)StringHelper.Format((String)"\u6811\u89c6\u56fe\u914d\u7f6e\u6587\u4ef6[%1$s]\u4e0d\u5b58\u5728", (Object)strDPConfigPath));
        return null;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public TreePanelConfig GetTreePanelConfig(String strTreeViewId) {
        Document doc = this.GetDocument(strTreeViewId);
        if (doc == null) {
            return null;
        }
        try {
            Document document = doc;
            synchronized (document) {
                TreePanelConfig treePanelConfig = new TreePanelConfig();
                if (treePanelConfig.LoadConfig(doc.getDocumentElement())) {
                    return treePanelConfig;
                }
            }
            return null;
        }
        catch (Exception ex) {
            log.error((Object)"\u52a0\u8f7d\u6811\u89c6\u56fe\u914d\u7f6e\u6570\u636e\u51fa\u73b0\u9519\u8bef", (Throwable)ex);
            return null;
        }
    }

    protected String GetConfigRootFolder() {
        return "treeview";
    }
}

