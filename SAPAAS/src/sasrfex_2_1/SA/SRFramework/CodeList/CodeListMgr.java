/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Base.ConfigMgr
 *  SA.SRFramework.Data.BaseDBCallerHelper
 *  SA.SRFramework.Utility.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 *  org.apache.xerces.parsers.DOMParser
 */
package SA.SRFramework.CodeList;

import SA.SRFramework.Base.ConfigMgr;
import SA.SRFramework.CodeList.CodeListConfig;
import SA.SRFramework.CodeList.CodeListRefreshTimer;
import SA.SRFramework.CodeList.ICodeListFiller;
import SA.SRFramework.CodeList.ICodeListFiller2;
import SA.SRFramework.CodeList.ICodeListQuery;
import SA.SRFramework.Data.BaseDBCallerHelper;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.UtilityEx.ObjectHelper;
import SA.SRFramework.WebEx.Utility.ISRFExGlobalHelper;
import java.io.File;
import java.util.Hashtable;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.xerces.parsers.DOMParser;
import org.w3c.dom.Document;

public class CodeListMgr
extends ConfigMgr {
    private static final Log log = LogFactory.getLog(CodeListMgr.class);
    private final byte[] key;
    private CodeListRefreshTimer codeListRefreshTimer;
    private ISRFExGlobalHelper iGlobalHelper;
    protected Hashtable<String, BaseDBCallerHelper> callerMap;

    public CodeListMgr() {
        byte[] byArray = new byte[8];
        byArray[0] = 1;
        byArray[1] = 9;
        byArray[2] = 9;
        byArray[3] = 7;
        byArray[5] = 7;
        byArray[7] = 1;
        this.key = byArray;
        this.codeListRefreshTimer = null;
        this.iGlobalHelper = null;
        this.callerMap = new Hashtable();
    }

    public void setDBCallerHelper(BaseDBCallerHelper dbCallerHelper) {
        this.callerMap.put("", dbCallerHelper);
    }

    public void setGlobalHelper(ISRFExGlobalHelper iGlobalHelper) {
        this.iGlobalHelper = iGlobalHelper;
    }

    public ISRFExGlobalHelper getGlobalHelper() {
        return this.iGlobalHelper;
    }

    public void setDBCallerHelper(String strMode, BaseDBCallerHelper dbCallerHelper) {
        this.callerMap.put(strMode.toUpperCase(), dbCallerHelper);
    }

    protected BaseDBCallerHelper getDBCallerHelper(String strMode) {
        if (this.callerMap.containsKey(strMode = strMode.toUpperCase())) {
            return this.callerMap.get(strMode);
        }
        return this.callerMap.get("");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void ResetCodeListConfig(String strCodeListId) {
        strCodeListId = strCodeListId.toUpperCase();
        String strCLConfigPath = this.GetConfigFilePath("codelist" + this.strFolderSeperator + this.GetRealPath(strCodeListId) + ".xml");
        Hashtable hashtable = this.fileList;
        synchronized (hashtable) {
            if (this.fileList.contains(strCLConfigPath)) {
                this.fileList.remove(strCLConfigPath);
            }
            if (this.modifydateList.contains(strCLConfigPath)) {
                this.modifydateList.remove(strCLConfigPath);
            }
        }
    }

    public CodeListConfig GetCodeListConfig(String strCodeListId, String strLanguage) {
        if (!StringHelper.IsNullOrEmpty((String)strLanguage)) {
            String strCodeListIdEx = StringHelper.Format((String)"%1$s_%2$s", (Object)strCodeListId, (Object)strLanguage);
            CodeListConfig codeListConfig = this.GetCodeListConfig(strCodeListIdEx);
            if (codeListConfig != null) {
                return codeListConfig;
            }
            log.warn((Object)StringHelper.Format((String)"\u4ee3\u7801\u8868[%1$s]\u6ca1\u6709\u5b9a\u4e49\u8bed\u8a00[%2$s]", (Object)strCodeListId, (Object)strLanguage));
        }
        return this.GetCodeListConfig(strCodeListId);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public CodeListConfig GetCodeListConfig(String strCodeListId) {
        strCodeListId = strCodeListId.toUpperCase();
        String strCLConfigPath = this.GetConfigFilePath("codelist" + this.strFolderSeperator + this.GetRealPath(strCodeListId) + ".xml");
        File file = new File(strCLConfigPath);
        if (!file.exists()) return null;
        long nLastModify = file.lastModified();
        Hashtable hashtable = this.fileList;
        synchronized (hashtable) {
            Long nCurLastModify;
            if (this.fileList.containsKey(strCLConfigPath) && nLastModify == (nCurLastModify = (Long)this.modifydateList.get(strCLConfigPath))) {
                return (CodeListConfig)((Object)this.fileList.get(strCLConfigPath));
            }
        }
        try {
            DOMParser parser = new DOMParser();
            if (this.bEncrypt) {
                parser.parse(CodeListMgr.getContent((String)strCLConfigPath, (byte[])this.key));
            } else {
                parser.parse(strCLConfigPath);
            }
            Document doc = parser.getDocument();
            CodeListConfig codeListConfig = new CodeListConfig();
            codeListConfig.LoadConfig(doc.getDocumentElement());
            if (!codeListConfig.isUserScope() && StringHelper.Length((String)codeListConfig.getFiller()) > 0) {
                Object obj = ObjectHelper.Create(codeListConfig.getFiller());
                if (obj == null) {
                    log.error((Object)StringHelper.Format((String)"\u4ee3\u7801\u8868\u914d\u7f6e[%1$s]\u586b\u5145\u5668[%2$s]\u65e0\u6548\uff0c\u65e0\u6cd5\u5efa\u7acb\u5bf9\u8c61", (Object)strCodeListId, (Object)codeListConfig.getFiller()));
                    return null;
                }
                if (obj instanceof ICodeListFiller2) {
                    ICodeListFiller2 iCodeListFiller2 = (ICodeListFiller2)obj;
                    iCodeListFiller2.setGlobalHelper(this.iGlobalHelper);
                }
                if (!(obj instanceof ICodeListFiller)) {
                    log.error((Object)StringHelper.Format((String)"\u4ee3\u7801\u8868\u914d\u7f6e[%1$s]\u586b\u5145\u5668[%2$s]\u65e0\u6548\uff0c\u6ca1\u6709\u5b9e\u73b0\u63a5\u53e3[ICodeListFiller]", (Object)strCodeListId, (Object)codeListConfig.getFiller()));
                    return null;
                }
                ICodeListFiller iCodeListFiller = (ICodeListFiller)obj;
                iCodeListFiller.Fill(this.getDBCallerHelper(codeListConfig.getDBCallerMode()), codeListConfig);
                if (obj instanceof ICodeListQuery) {
                    ICodeListQuery iCodeListQuery = (ICodeListQuery)obj;
                    codeListConfig.SetRealTimeQueryParam(this.getDBCallerHelper(codeListConfig.getDBCallerMode()), iCodeListQuery);
                }
            }
            Hashtable hashtable2 = this.fileList;
            synchronized (hashtable2) {
                this.fileList.put(strCLConfigPath, codeListConfig);
                this.modifydateList.put(strCLConfigPath, nLastModify);
                return codeListConfig;
            }
        }
        catch (Exception ex) {
            log.error((Object)StringHelper.Format((String)"\u52a0\u8f7d\u4ee3\u7801\u8868\u914d\u7f6e[%1$s]\u51fa\u73b0\u9519\u8bef[%2$s]", (Object)strCodeListId, (Object)ex.getMessage()));
            return null;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public synchronized void ResetAllCodeList() {
        Hashtable hashtable = this.fileList;
        synchronized (hashtable) {
            this.fileList.clear();
            this.modifydateList.clear();
        }
    }

    public synchronized void StartRefreshTimer() {
        if (this.codeListRefreshTimer != null) {
            return;
        }
        this.codeListRefreshTimer = new CodeListRefreshTimer(this, 1200000);
    }

    public synchronized void StopRefreshTimer() {
        if (this.codeListRefreshTimer == null) {
            return;
        }
        this.codeListRefreshTimer.cancel();
        this.codeListRefreshTimer = null;
    }
}

