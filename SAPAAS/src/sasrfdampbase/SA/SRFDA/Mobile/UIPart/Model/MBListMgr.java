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
package SA.SRFDA.Mobile.UIPart.Model;

import SA.SRFDA.Mobile.UIPart.Model.MBListConfig;
import SA.SRFramework.Base.ConfigMgr;
import SA.SRFramework.Utility.StringHelper;
import java.io.File;
import java.util.Hashtable;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.xerces.parsers.DOMParser;
import org.w3c.dom.Document;

public class MBListMgr
extends ConfigMgr {
    private static final Log log = LogFactory.getLog(MBListMgr.class);
    private final byte[] key;

    public MBListMgr() {
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
    protected Document GetDocument(String strMBListId) {
        String strDGConfigPath = this.GetConfigFilePath("mblist" + this.strFolderSeperator + this.GetRealPath(strMBListId) + ".xml");
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
                    parser.parse(MBListMgr.getContent((String)strDGConfigPath, (byte[])this.key));
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
                log.error((Object)StringHelper.Format((String)"\u52a0\u8f7d\u79fb\u52a8\u5e94\u7528\u5217\u8868\u914d\u7f6e\u6587\u4ef6[%1$s]\u51fa\u73b0\u9519\u8bef", (Object)strDGConfigPath), (Throwable)ex);
                return null;
            }
        }
        log.error((Object)StringHelper.Format((String)"\u79fb\u52a8\u5e94\u7528\u5217\u8868\u914d\u7f6e\u6587\u4ef6[%1$s]\u4e0d\u5b58\u5728", (Object)strMBListId));
        return null;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public MBListConfig GetMBListConfig(String strMBListId) {
        Document doc = this.GetDocument(strMBListId);
        if (doc == null) {
            return null;
        }
        try {
            MBListConfig mbListConfig = new MBListConfig();
            Document document = doc;
            synchronized (document) {
                if (mbListConfig.LoadConfig(doc.getDocumentElement())) {
                    mbListConfig.setConfigId(strMBListId);
                    return mbListConfig;
                }
            }
            return null;
        }
        catch (Exception ex) {
            log.error((Object)"\u52a0\u8f7d\u79fb\u52a8\u5e94\u7528\u5217\u8868\u914d\u7f6e\u51fa\u73b0\u9519\u8bef", (Throwable)ex);
            return null;
        }
    }

    protected String GetConfigRootFolder() {
        return "mblist";
    }
}

