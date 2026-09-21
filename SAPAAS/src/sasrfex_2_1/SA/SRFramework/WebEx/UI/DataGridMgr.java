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
import SA.SRFramework.WebEx.DGEx.UI.DGExConfig;
import SA.SRFramework.WebEx.UI.DataGridConfig;
import java.io.File;
import java.util.Hashtable;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.xerces.parsers.DOMParser;
import org.w3c.dom.Document;

public class DataGridMgr
extends ConfigMgr {
    private static final Log log = LogFactory.getLog(DataGridMgr.class);
    private final byte[] key;
    private boolean bLoadDGTemplate;

    public DataGridMgr() {
        byte[] byArray = new byte[8];
        byArray[0] = 1;
        byArray[1] = 9;
        byArray[2] = 9;
        byArray[3] = 7;
        byArray[5] = 7;
        byArray[7] = 1;
        this.key = byArray;
        this.bLoadDGTemplate = true;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    protected Document GetDocument(String strDataGridId) {
        String strDGConfigPath = this.GetConfigFilePath("datagrid" + this.strFolderSeperator + this.GetRealPath(strDataGridId) + ".xml");
        File file = new File(strDGConfigPath);
        if (file.exists()) {
            long nLastModify = file.lastModified();
            Hashtable hashtable = this.fileList;
            synchronized (hashtable) {
                Long nCurLastModify;
                if (this.fileList.containsKey(strDGConfigPath) && nLastModify == (nCurLastModify = (Long)this.modifydateList.get(strDGConfigPath))) {
                    Document doc = (Document)this.fileList.get(strDGConfigPath);
                    return doc;
                }
            }
            try {
                DOMParser parser = new DOMParser();
                if (this.bEncrypt) {
                    parser.parse(DataGridMgr.getContent((String)strDGConfigPath, (byte[])this.key));
                } else {
                    parser.parse(strDGConfigPath);
                }
                Document doc = parser.getDocument();
                Hashtable hashtable2 = this.fileList;
                synchronized (hashtable2) {
                    this.fileList.put(strDGConfigPath, doc);
                    this.modifydateList.put(strDGConfigPath, nLastModify);
                }
                return doc;
            }
            catch (Exception ex) {
                log.error((Object)StringHelper.Format((String)"\u52a0\u8f7d\u6570\u636e\u8868\u683c\u914d\u7f6e\u6587\u4ef6[%1$s]\u51fa\u73b0\u9519\u8bef", (Object)strDGConfigPath), (Throwable)ex);
                return null;
            }
        }
        log.error((Object)StringHelper.Format((String)"\u6570\u636e\u8868\u683c\u914d\u7f6e\u6587\u4ef6[%1$s]\u4e0d\u5b58\u5728", (Object)strDataGridId));
        return null;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public DataGridConfig GetDataGridConfig(String strDataGridId) {
        Document doc;
        Document docTemplate = null;
        if (this.bLoadDGTemplate) {
            docTemplate = this.GetDocument("DG_TEMPLATE");
        }
        if ((doc = this.GetDocument(strDataGridId)) == null) {
            return null;
        }
        try {
            Document document;
            DataGridConfig dataGridConfig = new DataGridConfig();
            if (docTemplate != null) {
                document = docTemplate;
                synchronized (document) {
                    dataGridConfig.LoadConfig(docTemplate.getDocumentElement());
                }
            }
            document = doc;
            synchronized (document) {
                if (dataGridConfig.LoadConfig(doc.getDocumentElement())) {
                    dataGridConfig.setConfigId(strDataGridId);
                    return dataGridConfig;
                }
            }
            return null;
        }
        catch (Exception ex) {
            log.error((Object)"\u52a0\u8f7d\u6570\u636e\u8868\u683c\u914d\u7f6e\u6570\u636e\u51fa\u73b0\u9519\u8bef", (Throwable)ex);
            return null;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public DGExConfig GetDGExConfig(String strDataGridId) {
        Document doc = this.GetDocument(strDataGridId);
        if (doc == null) {
            return null;
        }
        try {
            DGExConfig dataGridConfig = new DGExConfig();
            Document document = doc;
            synchronized (document) {
                if (dataGridConfig.LoadConfig(doc.getDocumentElement())) {
                    dataGridConfig.setConfigId(strDataGridId);
                    return dataGridConfig;
                }
            }
            return null;
        }
        catch (Exception ex) {
            log.error((Object)"\u52a0\u8f7d\u6570\u636e\u8868\u683c\u914d\u7f6e\u6570\u636e\u51fa\u73b0\u9519\u8bef", (Throwable)ex);
            return null;
        }
    }

    public boolean isLoadDGTemplate() {
        return this.bLoadDGTemplate;
    }

    public void setLoadDGTemplate(boolean bLoadDGTemplate) {
        this.bLoadDGTemplate = bLoadDGTemplate;
    }

    protected String GetConfigRootFolder() {
        return "datagrid";
    }
}

