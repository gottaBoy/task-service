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
import SA.SRFramework.WebEx.SP.UI.SPExConfig;
import SA.SRFramework.WebEx.UI.SearchPanelConfig;
import SA.SRFramework.WebEx.UI.SearchPanelExConfig;
import java.io.File;
import java.util.Hashtable;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.xerces.parsers.DOMParser;
import org.w3c.dom.Document;

public class SearchPanelMgr
extends ConfigMgr {
    private static final Log log = LogFactory.getLog(SearchPanelMgr.class);
    private final byte[] key;

    public SearchPanelMgr() {
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
    protected Document GetDocument(String strSearchPanelId) {
        String strDGConfigPath = this.GetConfigFilePath("searchpanel" + this.strFolderSeperator + this.GetRealPath(strSearchPanelId) + ".xml");
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
                    parser.parse(SearchPanelMgr.getContent((String)strDGConfigPath, (byte[])this.key));
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
                log.error((Object)"\u52a0\u8f7d\u641c\u7d22\u9762\u677f\u914d\u7f6e\u6587\u4ef6\u51fa\u73b0\u9519\u8bef", (Throwable)ex);
                return null;
            }
        }
        log.error((Object)StringHelper.Format((String)"\u641c\u7d22\u9762\u677f\u914d\u7f6e\u6587\u4ef6[%1$s]\u4e0d\u5b58\u5728", (Object)strDGConfigPath));
        return null;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public SearchPanelConfig GetSearchPanelConfig(String strSearchPanelId) {
        Document doc = this.GetDocument(strSearchPanelId);
        if (doc == null) {
            return null;
        }
        try {
            Document document = doc;
            synchronized (document) {
                SearchPanelConfig searchPanelConfig = new SearchPanelConfig();
                if (searchPanelConfig.LoadConfig(doc.getDocumentElement())) {
                    searchPanelConfig.setConfigId(strSearchPanelId);
                    return searchPanelConfig;
                }
            }
            return null;
        }
        catch (Exception ex) {
            log.error((Object)"\u52a0\u8f7d\u641c\u7d22\u9762\u677f\u914d\u7f6e\u6570\u636e\u51fa\u73b0\u9519\u8bef", (Throwable)ex);
            return null;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public SearchPanelExConfig GetSearchPanelExConfig(String strSearchPanelId) {
        Document doc = this.GetDocument(strSearchPanelId);
        if (doc == null) {
            return null;
        }
        try {
            Document document = doc;
            synchronized (document) {
                SearchPanelExConfig searchPanelExConfig = new SearchPanelExConfig();
                if (searchPanelExConfig.LoadConfig(doc.getDocumentElement())) {
                    searchPanelExConfig.setConfigId(strSearchPanelId);
                    return searchPanelExConfig;
                }
            }
            return null;
        }
        catch (Exception ex) {
            log.error((Object)"\u52a0\u8f7d\u641c\u7d22\u9762\u677f\u914d\u7f6e\u6570\u636e\u51fa\u73b0\u9519\u8bef", (Throwable)ex);
            return null;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public SPExConfig GetSPExConfig(String strSearchPanelId) {
        Document doc = this.GetDocument(strSearchPanelId);
        if (doc == null) {
            return null;
        }
        try {
            Document document = doc;
            synchronized (document) {
                SPExConfig spExConfig = new SPExConfig();
                if (spExConfig.LoadConfig(doc.getDocumentElement())) {
                    spExConfig.setConfigId(strSearchPanelId);
                    return spExConfig;
                }
            }
            return null;
        }
        catch (Exception ex) {
            log.error((Object)"\u52a0\u8f7d\u641c\u7d22\u9762\u677f\u914d\u7f6e\u6570\u636e\u51fa\u73b0\u9519\u8bef", (Throwable)ex);
            return null;
        }
    }

    public String GetRealConfigPath(String strSearchPanelId) {
        String strConfigPath = this.GetConfigFilePath("searchpanel" + this.strFolderSeperator + this.GetRealPath(strSearchPanelId) + ".xml");
        return strConfigPath;
    }

    protected String GetConfigRootFolder() {
        return "searchpanel";
    }
}

