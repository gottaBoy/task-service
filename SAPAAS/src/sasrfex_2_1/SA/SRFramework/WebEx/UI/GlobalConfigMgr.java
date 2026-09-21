/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Base.ConfigMgr
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 *  org.apache.xerces.parsers.DOMParser
 */
package SA.SRFramework.WebEx.UI;

import SA.SRFramework.Base.ConfigMgr;
import SA.SRFramework.Localization.LocalizationConfig;
import SA.SRFramework.ReportEx.Model.ChartStyleConfig;
import SA.SRFramework.WebEx.UI.UserConfigMgr;
import SA.SRFramework.WebEx.UI.UserControlMgr;
import SA.SRFramework.WebEx.UI.WebExConfig;
import java.io.File;
import java.util.Hashtable;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.xerces.parsers.DOMParser;
import org.w3c.dom.Document;

public class GlobalConfigMgr
extends ConfigMgr {
    private static final Log log = LogFactory.getLog(GlobalConfigMgr.class);
    private final byte[] key;
    protected WebExConfig webExConfig;

    public GlobalConfigMgr() {
        byte[] byArray = new byte[8];
        byArray[0] = 1;
        byArray[1] = 9;
        byArray[2] = 9;
        byArray[3] = 7;
        byArray[5] = 7;
        byArray[7] = 1;
        this.key = byArray;
        this.webExConfig = new WebExConfig();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public UserConfigMgr GetUserConfigMgr() {
        String strUserConfigMgrPath = this.GetConfigFilePath("common" + this.strFolderSeperator + "USERCONFIGMGR.xml");
        File file = new File(strUserConfigMgrPath);
        if (file.exists()) {
            long nLastModify = file.lastModified();
            Hashtable hashtable = this.fileList;
            synchronized (hashtable) {
                Long nCurLastModify;
                if (this.fileList.containsKey(strUserConfigMgrPath) && nLastModify == (nCurLastModify = (Long)this.modifydateList.get(strUserConfigMgrPath))) {
                    return (UserConfigMgr)((Object)this.fileList.get(strUserConfigMgrPath));
                }
            }
            try {
                DOMParser parser = new DOMParser();
                if (this.bEncrypt) {
                    parser.parse(GlobalConfigMgr.getContent((String)strUserConfigMgrPath, (byte[])this.key));
                } else {
                    parser.parse(strUserConfigMgrPath);
                }
                Document doc = parser.getDocument();
                UserConfigMgr userConfigMgr = new UserConfigMgr();
                userConfigMgr.LoadConfig(doc.getDocumentElement());
                Hashtable hashtable2 = this.fileList;
                synchronized (hashtable2) {
                    this.fileList.put(strUserConfigMgrPath, userConfigMgr);
                    this.modifydateList.put(strUserConfigMgrPath, nLastModify);
                }
                return userConfigMgr;
            }
            catch (Exception ex) {
                ex.printStackTrace(System.out);
                return null;
            }
        }
        return null;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public UserControlMgr GetUserControlMgr() {
        String strUserControlPath = this.GetConfigFilePath("common" + this.strFolderSeperator + "USERCONTROL.xml");
        File file = new File(strUserControlPath);
        if (file.exists()) {
            long nLastModify = file.lastModified();
            Hashtable hashtable = this.fileList;
            synchronized (hashtable) {
                Long nCurLastModify;
                if (this.fileList.containsKey(strUserControlPath) && nLastModify == (nCurLastModify = (Long)this.modifydateList.get(strUserControlPath))) {
                    return (UserControlMgr)((Object)this.fileList.get(strUserControlPath));
                }
            }
            try {
                DOMParser parser = new DOMParser();
                if (this.bEncrypt) {
                    parser.parse(GlobalConfigMgr.getContent((String)strUserControlPath, (byte[])this.key));
                } else {
                    parser.parse(strUserControlPath);
                }
                Document doc = parser.getDocument();
                UserControlMgr userControlMgr = new UserControlMgr();
                userControlMgr.LoadConfig(doc.getDocumentElement());
                Hashtable hashtable2 = this.fileList;
                synchronized (hashtable2) {
                    this.fileList.put(strUserControlPath, userControlMgr);
                    this.modifydateList.put(strUserControlPath, nLastModify);
                }
                return userControlMgr;
            }
            catch (Exception ex) {
                ex.printStackTrace(System.out);
                return null;
            }
        }
        return null;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ChartStyleConfig GetChartStyleConfig() {
        String strChartStylePath = this.GetConfigFilePath("common" + this.strFolderSeperator + "CHARTSTYLE.xml");
        File file = new File(strChartStylePath);
        if (file.exists()) {
            long nLastModify = file.lastModified();
            Hashtable hashtable = this.fileList;
            synchronized (hashtable) {
                Long nCurLastModify;
                if (this.fileList.containsKey(strChartStylePath) && nLastModify == (nCurLastModify = (Long)this.modifydateList.get(strChartStylePath))) {
                    return (ChartStyleConfig)((Object)this.fileList.get(strChartStylePath));
                }
            }
            try {
                DOMParser parser = new DOMParser();
                if (this.bEncrypt) {
                    parser.parse(GlobalConfigMgr.getContent((String)strChartStylePath, (byte[])this.key));
                } else {
                    parser.parse(strChartStylePath);
                }
                Document doc = parser.getDocument();
                ChartStyleConfig chartStyleConfig = new ChartStyleConfig();
                chartStyleConfig.LoadConfig(doc.getDocumentElement());
                Hashtable hashtable2 = this.fileList;
                synchronized (hashtable2) {
                    this.fileList.put(strChartStylePath, chartStyleConfig);
                    this.modifydateList.put(strChartStylePath, nLastModify);
                }
                return chartStyleConfig;
            }
            catch (Exception ex) {
                ex.printStackTrace(System.out);
                return null;
            }
        }
        return null;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public WebExConfig GetWebExConfig() {
        String strConfigPath = this.GetConfigFilePath("common" + this.strFolderSeperator + "WEBEXCONFIG.xml");
        File file = new File(strConfigPath);
        if (file.exists()) {
            long nLastModify = file.lastModified();
            Hashtable hashtable = this.fileList;
            synchronized (hashtable) {
                Long nCurLastModify;
                if (this.fileList.containsKey(strConfigPath) && nLastModify == (nCurLastModify = (Long)this.modifydateList.get(strConfigPath))) {
                    return (WebExConfig)((Object)this.fileList.get(strConfigPath));
                }
            }
            try {
                DOMParser parser = new DOMParser();
                if (this.bEncrypt) {
                    parser.parse(GlobalConfigMgr.getContent((String)strConfigPath, (byte[])this.key));
                } else {
                    parser.parse(strConfigPath);
                }
                Document doc = parser.getDocument();
                WebExConfig webExConfig = new WebExConfig();
                webExConfig.LoadConfig(doc.getDocumentElement());
                Hashtable hashtable2 = this.fileList;
                synchronized (hashtable2) {
                    this.fileList.put(strConfigPath, webExConfig);
                    this.modifydateList.put(strConfigPath, nLastModify);
                }
                return webExConfig;
            }
            catch (Exception ex) {
                ex.printStackTrace(System.out);
            }
        }
        return this.webExConfig;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public LocalizationConfig GetLocalizationConfig(String strLanguage) {
        String strConfigPath = this.GetConfigFilePath("localization" + this.strFolderSeperator + "LOCALIZATION_" + strLanguage + ".xml");
        File file = new File(strConfigPath);
        if (file.exists()) {
            long nLastModify = file.lastModified();
            Hashtable hashtable = this.fileList;
            synchronized (hashtable) {
                Long nCurLastModify;
                if (this.fileList.containsKey(strConfigPath) && nLastModify == (nCurLastModify = (Long)this.modifydateList.get(strConfigPath))) {
                    return (LocalizationConfig)((Object)this.fileList.get(strConfigPath));
                }
            }
            try {
                DOMParser parser = new DOMParser();
                if (this.bEncrypt) {
                    parser.parse(GlobalConfigMgr.getContent((String)strConfigPath, (byte[])this.key));
                } else {
                    parser.parse(strConfigPath);
                }
                Document doc = parser.getDocument();
                LocalizationConfig localizationConfig = new LocalizationConfig();
                localizationConfig.LoadConfig(doc.getDocumentElement());
                Hashtable hashtable2 = this.fileList;
                synchronized (hashtable2) {
                    this.fileList.put(strConfigPath, localizationConfig);
                    this.modifydateList.put(strConfigPath, nLastModify);
                }
                return localizationConfig;
            }
            catch (Exception ex) {
                ex.printStackTrace(System.out);
            }
        }
        LocalizationConfig localizationConfig = new LocalizationConfig();
        Hashtable hashtable = this.fileList;
        synchronized (hashtable) {
            this.fileList.put(strConfigPath, localizationConfig);
            this.modifydateList.put(strConfigPath, 0);
        }
        return localizationConfig;
    }
}

