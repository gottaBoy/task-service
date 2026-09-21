/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Base.ConfigMgr
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 *  org.apache.xerces.parsers.DOMParser
 */
package SA.SRFDA.Common;

import SA.SRFDA.Ctrl.DEFHelper.DEFHelperMgr;
import SA.SRFDA.Ctrl.FormCtrlHelper.FormCtrlWriterMgr;
import SA.SRFDA.Ctrl.ToolbarWriter.ToolbarItemWriterMgr;
import SA.SRFDA.Model.DGColRenderMgr;
import SA.SRFDA.Model.ValueFuncMgr;
import SA.SRFDA.Model.ValueRuleMgr;
import SA.SRFDA.Web.Utility.GlobalHelperEx;
import SA.SRFramework.Base.ConfigMgr;
import java.io.File;
import java.util.Hashtable;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.xerces.parsers.DOMParser;
import org.w3c.dom.Document;

public class DAConfigMgr
extends ConfigMgr {
    private final byte[] key;
    protected GlobalHelperEx globalHelperEx;
    private static final Log log = LogFactory.getLog(DAConfigMgr.class);

    public DAConfigMgr() {
        byte[] byArray = new byte[8];
        byArray[0] = 1;
        byArray[1] = 9;
        byArray[2] = 9;
        byArray[3] = 7;
        byArray[5] = 7;
        byArray[7] = 1;
        this.key = byArray;
        this.globalHelperEx = null;
    }

    public void setGlobalHelperEx(GlobalHelperEx globalHelperEx) {
        this.globalHelperEx = globalHelperEx;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ToolbarItemWriterMgr getToolbarItemWriterMgr() {
        String strConfigPath = this.GetConfigFilePath("da_common" + this.strFolderSeperator + "TOOLBARITEMWRITERS.xml");
        File file = new File(strConfigPath);
        if (file.exists()) {
            long nLastModify = file.lastModified();
            Hashtable hashtable = this.fileList;
            synchronized (hashtable) {
                Long nCurLastModify;
                if (this.fileList.containsKey(strConfigPath) && nLastModify == (nCurLastModify = (Long)this.modifydateList.get(strConfigPath))) {
                    return (ToolbarItemWriterMgr)((Object)this.fileList.get(strConfigPath));
                }
            }
            try {
                DOMParser parser = new DOMParser();
                if (this.bEncrypt) {
                    parser.parse(DAConfigMgr.getContent((String)strConfigPath, (byte[])this.key));
                } else {
                    parser.parse(strConfigPath);
                }
                Document doc = parser.getDocument();
                ToolbarItemWriterMgr formCtrlHelperMgr = new ToolbarItemWriterMgr();
                formCtrlHelperMgr.setGlobalHelperEx(this.globalHelperEx);
                formCtrlHelperMgr.LoadConfig(doc.getDocumentElement());
                Hashtable hashtable2 = this.fileList;
                synchronized (hashtable2) {
                    this.fileList.put(strConfigPath, formCtrlHelperMgr);
                    this.modifydateList.put(strConfigPath, nLastModify);
                }
                return formCtrlHelperMgr;
            }
            catch (Exception ex) {
                log.error((Object)ex);
                return null;
            }
        }
        return null;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public FormCtrlWriterMgr getFormCtrlWriterMgr() {
        String strConfigPath = this.GetConfigFilePath("da_common" + this.strFolderSeperator + "FORMCTRLWRITERS.xml");
        File file = new File(strConfigPath);
        if (file.exists()) {
            long nLastModify = file.lastModified();
            Hashtable hashtable = this.fileList;
            synchronized (hashtable) {
                Long nCurLastModify;
                if (this.fileList.containsKey(strConfigPath) && nLastModify == (nCurLastModify = (Long)this.modifydateList.get(strConfigPath))) {
                    return (FormCtrlWriterMgr)((Object)this.fileList.get(strConfigPath));
                }
            }
            try {
                DOMParser parser = new DOMParser();
                if (this.bEncrypt) {
                    parser.parse(DAConfigMgr.getContent((String)strConfigPath, (byte[])this.key));
                } else {
                    parser.parse(strConfigPath);
                }
                Document doc = parser.getDocument();
                FormCtrlWriterMgr formCtrlHelperMgr = new FormCtrlWriterMgr();
                formCtrlHelperMgr.setGlobalHelperEx(this.globalHelperEx);
                formCtrlHelperMgr.LoadConfig(doc.getDocumentElement());
                Hashtable hashtable2 = this.fileList;
                synchronized (hashtable2) {
                    this.fileList.put(strConfigPath, formCtrlHelperMgr);
                    this.modifydateList.put(strConfigPath, nLastModify);
                }
                return formCtrlHelperMgr;
            }
            catch (Exception ex) {
                log.error((Object)ex);
                return null;
            }
        }
        return null;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public DEFHelperMgr getDEFHelperMgr() {
        String strConfigPath = this.GetConfigFilePath("da_common" + this.strFolderSeperator + "DEFHELPERS.xml");
        File file = new File(strConfigPath);
        if (file.exists()) {
            long nLastModify = file.lastModified();
            Hashtable hashtable = this.fileList;
            synchronized (hashtable) {
                Long nCurLastModify;
                if (this.fileList.containsKey(strConfigPath) && nLastModify == (nCurLastModify = (Long)this.modifydateList.get(strConfigPath))) {
                    return (DEFHelperMgr)((Object)this.fileList.get(strConfigPath));
                }
            }
            try {
                DOMParser parser = new DOMParser();
                if (this.bEncrypt) {
                    parser.parse(DAConfigMgr.getContent((String)strConfigPath, (byte[])this.key));
                } else {
                    parser.parse(strConfigPath);
                }
                Document doc = parser.getDocument();
                DEFHelperMgr defDataTypeMgr = new DEFHelperMgr();
                defDataTypeMgr.setGlobalHelperEx(this.globalHelperEx);
                defDataTypeMgr.LoadConfig(doc.getDocumentElement());
                Hashtable hashtable2 = this.fileList;
                synchronized (hashtable2) {
                    this.fileList.put(strConfigPath, defDataTypeMgr);
                    this.modifydateList.put(strConfigPath, nLastModify);
                }
                return defDataTypeMgr;
            }
            catch (Exception ex) {
                log.error((Object)ex);
                return null;
            }
        }
        return null;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ValueFuncMgr getValueFuncMgr() {
        String strConfigPath = this.GetConfigFilePath("da_common" + this.strFolderSeperator + "VALUEFUNCS.xml");
        File file = new File(strConfigPath);
        if (file.exists()) {
            long nLastModify = file.lastModified();
            Hashtable hashtable = this.fileList;
            synchronized (hashtable) {
                Long nCurLastModify;
                if (this.fileList.containsKey(strConfigPath) && nLastModify == (nCurLastModify = (Long)this.modifydateList.get(strConfigPath))) {
                    return (ValueFuncMgr)((Object)this.fileList.get(strConfigPath));
                }
            }
            try {
                DOMParser parser = new DOMParser();
                if (this.bEncrypt) {
                    parser.parse(DAConfigMgr.getContent((String)strConfigPath, (byte[])this.key));
                } else {
                    parser.parse(strConfigPath);
                }
                Document doc = parser.getDocument();
                ValueFuncMgr searchFuncMgr = new ValueFuncMgr();
                searchFuncMgr.LoadConfig(doc.getDocumentElement());
                Hashtable hashtable2 = this.fileList;
                synchronized (hashtable2) {
                    this.fileList.put(strConfigPath, searchFuncMgr);
                    this.modifydateList.put(strConfigPath, nLastModify);
                }
                return searchFuncMgr;
            }
            catch (Exception ex) {
                log.error((Object)ex);
                return null;
            }
        }
        return null;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ValueRuleMgr getValueRuleMgr() {
        String strConfigPath = this.GetConfigFilePath("da_common" + this.strFolderSeperator + "VALUERULES.xml");
        File file = new File(strConfigPath);
        if (file.exists()) {
            long nLastModify = file.lastModified();
            Hashtable hashtable = this.fileList;
            synchronized (hashtable) {
                Long nCurLastModify;
                if (this.fileList.containsKey(strConfigPath) && nLastModify == (nCurLastModify = (Long)this.modifydateList.get(strConfigPath))) {
                    return (ValueRuleMgr)((Object)this.fileList.get(strConfigPath));
                }
            }
            try {
                DOMParser parser = new DOMParser();
                if (this.bEncrypt) {
                    parser.parse(DAConfigMgr.getContent((String)strConfigPath, (byte[])this.key));
                } else {
                    parser.parse(strConfigPath);
                }
                Document doc = parser.getDocument();
                ValueRuleMgr valueRuleMgr = new ValueRuleMgr();
                valueRuleMgr.LoadConfig(doc.getDocumentElement());
                Hashtable hashtable2 = this.fileList;
                synchronized (hashtable2) {
                    this.fileList.put(strConfigPath, valueRuleMgr);
                    this.modifydateList.put(strConfigPath, nLastModify);
                }
                return valueRuleMgr;
            }
            catch (Exception ex) {
                log.error((Object)ex);
                return null;
            }
        }
        return null;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public DGColRenderMgr getDGColRenderMgr() {
        String strConfigPath = this.GetConfigFilePath("da_common" + this.strFolderSeperator + "DGCOLRENDERS.xml");
        File file = new File(strConfigPath);
        if (file.exists()) {
            long nLastModify = file.lastModified();
            Hashtable hashtable = this.fileList;
            synchronized (hashtable) {
                Long nCurLastModify;
                if (this.fileList.containsKey(strConfigPath) && nLastModify == (nCurLastModify = (Long)this.modifydateList.get(strConfigPath))) {
                    return (DGColRenderMgr)((Object)this.fileList.get(strConfigPath));
                }
            }
            try {
                DOMParser parser = new DOMParser();
                if (this.bEncrypt) {
                    parser.parse(DAConfigMgr.getContent((String)strConfigPath, (byte[])this.key));
                } else {
                    parser.parse(strConfigPath);
                }
                Document doc = parser.getDocument();
                DGColRenderMgr dgColRenderMgr = new DGColRenderMgr();
                dgColRenderMgr.LoadConfig(doc.getDocumentElement());
                Hashtable hashtable2 = this.fileList;
                synchronized (hashtable2) {
                    this.fileList.put(strConfigPath, dgColRenderMgr);
                    this.modifydateList.put(strConfigPath, nLastModify);
                }
                return dgColRenderMgr;
            }
            catch (Exception ex) {
                log.error((Object)ex);
                return null;
            }
        }
        return null;
    }
}

