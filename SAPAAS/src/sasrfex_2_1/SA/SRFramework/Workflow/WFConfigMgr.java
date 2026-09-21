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
package SA.SRFramework.Workflow;

import SA.SRFramework.Base.ConfigMgr;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.Workflow.WFConfig;
import java.io.File;
import java.util.Hashtable;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.xerces.parsers.DOMParser;
import org.w3c.dom.Document;

public class WFConfigMgr
extends ConfigMgr {
    private static final Log log = LogFactory.getLog(WFConfigMgr.class);
    private final byte[] key;

    public WFConfigMgr() {
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
    protected Document GetDocument(String strWFConfigId) {
        String strWorkflowConfigPath = this.GetConfigFilePath("workflow" + this.strFolderSeperator + this.GetRealPath(strWFConfigId) + ".xml");
        File file = new File(strWorkflowConfigPath);
        if (file.exists()) {
            long nLastModify = file.lastModified();
            Hashtable hashtable = this.fileList;
            synchronized (hashtable) {
                Long nCurLastModify;
                if (this.fileList.containsKey(strWorkflowConfigPath) && nLastModify == (nCurLastModify = (Long)this.modifydateList.get(strWorkflowConfigPath))) {
                    Document doc = (Document)this.fileList.get(strWorkflowConfigPath);
                    return doc;
                }
            }
            try {
                DOMParser parser = new DOMParser();
                if (this.bEncrypt) {
                    parser.parse(WFConfigMgr.getContent((String)strWorkflowConfigPath, (byte[])this.key));
                } else {
                    parser.parse(strWorkflowConfigPath);
                }
                Document doc = parser.getDocument();
                this.fileList.put(strWorkflowConfigPath, doc);
                this.modifydateList.put(strWorkflowConfigPath, nLastModify);
                return doc;
            }
            catch (Exception ex) {
                log.error((Object)"\u52a0\u8f7d\u6d41\u7a0b\u914d\u7f6e\u6587\u4ef6\u51fa\u73b0\u9519\u8bef", (Throwable)ex);
                return null;
            }
        }
        log.error((Object)StringHelper.Format((String)"\u6d41\u7a0b\u914d\u7f6e\u6587\u4ef6[%1$s]\u4e0d\u5b58\u5728", (Object)strWorkflowConfigPath));
        return null;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public WFConfig GetWFConfigConfig(String strWFConfigId) {
        Document doc = this.GetDocument(strWFConfigId);
        if (doc == null) {
            return null;
        }
        try {
            Document document = doc;
            synchronized (document) {
                WFConfig wfConfig = new WFConfig();
                if (wfConfig.LoadConfig(doc.getDocumentElement())) {
                    return wfConfig;
                }
            }
            return null;
        }
        catch (Exception ex) {
            log.error((Object)"\u52a0\u8f7d\u6d41\u7a0b\u914d\u7f6e\u6570\u636e\u51fa\u73b0\u9519\u8bef", (Throwable)ex);
            return null;
        }
    }
}

