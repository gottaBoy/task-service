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
package SA.SRFramework.ValueRule;

import SA.SRFramework.Base.ConfigMgr;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.ValueRule.FormValueRuleConfig;
import SA.SRFramework.ValueRule.ValueRuleConfig;
import java.io.File;
import java.util.Hashtable;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.xerces.parsers.DOMParser;
import org.w3c.dom.Document;

public class ValueRuleMgr
extends ConfigMgr {
    private static final Log log = LogFactory.getLog(ValueRuleMgr.class);
    private final byte[] key;

    public ValueRuleMgr() {
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
    public ValueRuleConfig GetValueRuleConfig(String strValueRuleId) {
        String strVRConfigPath = this.GetConfigFilePath("valuerule" + this.strFolderSeperator + this.GetRealPath(strValueRuleId) + ".xml");
        File file = new File(strVRConfigPath);
        if (file.exists()) {
            long nLastModify = file.lastModified();
            Hashtable hashtable = this.fileList;
            synchronized (hashtable) {
                Long nCurLastModify;
                if (this.fileList.containsKey(strVRConfigPath) && nLastModify == (nCurLastModify = (Long)this.modifydateList.get(strVRConfigPath))) {
                    return (ValueRuleConfig)((Object)this.fileList.get(strVRConfigPath));
                }
            }
            try {
                DOMParser parser = new DOMParser();
                if (this.bEncrypt) {
                    parser.parse(ValueRuleMgr.getContent((String)strVRConfigPath, (byte[])this.key));
                } else {
                    parser.parse(strVRConfigPath);
                }
                Document doc = parser.getDocument();
                ValueRuleConfig valueRuleConfig = new ValueRuleConfig();
                valueRuleConfig.LoadConfig(doc.getDocumentElement());
                Hashtable hashtable2 = this.fileList;
                synchronized (hashtable2) {
                    this.fileList.put(strVRConfigPath, valueRuleConfig);
                    this.modifydateList.put(strVRConfigPath, nLastModify);
                }
                return valueRuleConfig;
            }
            catch (Exception ex) {
                log.error((Object)StringHelper.Format((String)"\u52a0\u8f7d\u503c\u89c4\u5219\u914d\u7f6e[%1$s]\u51fa\u73b0\u9519\u8bef[%2$s]", (Object)strValueRuleId, (Object)ex.getMessage()));
                return null;
            }
        }
        return null;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public FormValueRuleConfig GetFormValueRuleConfig(String strFormValueRuleId) {
        String strVRConfigPath = this.GetConfigFilePath("formvaluerule" + this.strFolderSeperator + this.GetRealPath(strFormValueRuleId) + ".xml");
        File file = new File(strVRConfigPath);
        if (file.exists()) {
            long nLastModify = file.lastModified();
            Hashtable hashtable = this.fileList;
            synchronized (hashtable) {
                Long nCurLastModify;
                if (this.fileList.containsKey(strVRConfigPath) && nLastModify == (nCurLastModify = (Long)this.modifydateList.get(strVRConfigPath))) {
                    return (FormValueRuleConfig)((Object)this.fileList.get(strVRConfigPath));
                }
            }
            try {
                DOMParser parser = new DOMParser();
                if (this.bEncrypt) {
                    parser.parse(ValueRuleMgr.getContent((String)strVRConfigPath, (byte[])this.key));
                } else {
                    parser.parse(strVRConfigPath);
                }
                Document doc = parser.getDocument();
                FormValueRuleConfig formValueRuleConfig = new FormValueRuleConfig();
                formValueRuleConfig.LoadConfig(doc.getDocumentElement());
                Hashtable hashtable2 = this.fileList;
                synchronized (hashtable2) {
                    this.fileList.put(strVRConfigPath, formValueRuleConfig);
                    this.modifydateList.put(strVRConfigPath, nLastModify);
                }
                return formValueRuleConfig;
            }
            catch (Exception ex) {
                log.error((Object)StringHelper.Format((String)"\u52a0\u8f7d\u8868\u5355\u503c\u89c4\u5219\u914d\u7f6e[%1$s]\u51fa\u73b0\u9519\u8bef[%2$s]", (Object)strFormValueRuleId, (Object)ex.getMessage()));
                return null;
            }
        }
        return null;
    }
}

