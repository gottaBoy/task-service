/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Base.ConfigMgr
 *  org.apache.xerces.parsers.DOMParser
 */
package SA.SRFramework.WebEx.UI;

import SA.SRFramework.Base.ConfigMgr;
import SA.SRFramework.WebEx.UI.ExcelReportConfig;
import SA.SRFramework.WebEx.UI.ExcelReportsConfig;
import java.io.File;
import java.util.Hashtable;
import org.apache.xerces.parsers.DOMParser;
import org.w3c.dom.Document;

public class ExcelReportMgr
extends ConfigMgr {
    private final byte[] key;

    public ExcelReportMgr() {
        byte[] byArray = new byte[8];
        byArray[0] = 1;
        byArray[1] = 9;
        byArray[2] = 9;
        byArray[3] = 7;
        byArray[5] = 7;
        byArray[7] = 1;
        this.key = byArray;
    }

    public ExcelReportConfig Get(String strReportId) {
        ExcelReportsConfig configs = this.GetExcelReportsConfig();
        if (configs != null) {
            return configs.getExcelReportConfig(strReportId);
        }
        return null;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    protected ExcelReportsConfig GetExcelReportsConfig() {
        block12: {
            String strExcelReportsConfigPath = this.GetConfigFilePath("common" + this.strFolderSeperator + this.GetRealPath("EXCELREPORT") + ".xml");
            File file = new File(strExcelReportsConfigPath);
            if (file.exists()) {
                long nLastModify = file.lastModified();
                Hashtable hashtable = this.fileList;
                synchronized (hashtable) {
                    Long nCurLastModify;
                    if (this.fileList.containsKey(strExcelReportsConfigPath) && nLastModify == (nCurLastModify = (Long)this.modifydateList.get(strExcelReportsConfigPath))) {
                        return (ExcelReportsConfig)((Object)this.fileList.get(strExcelReportsConfigPath));
                    }
                }
                try {
                    DOMParser parser = new DOMParser();
                    if (this.bEncrypt) {
                        parser.parse(ExcelReportMgr.getContent((String)strExcelReportsConfigPath, (byte[])this.key));
                    } else {
                        parser.parse(strExcelReportsConfigPath);
                    }
                    Document doc = parser.getDocument();
                    ExcelReportsConfig autoCompletesConfig = new ExcelReportsConfig();
                    if (!autoCompletesConfig.LoadConfig(doc.getDocumentElement())) break block12;
                    Hashtable hashtable2 = this.fileList;
                    synchronized (hashtable2) {
                        this.fileList.put(strExcelReportsConfigPath, autoCompletesConfig);
                        this.modifydateList.put(strExcelReportsConfigPath, nLastModify);
                    }
                    return autoCompletesConfig;
                }
                catch (Exception ex) {
                    ex.printStackTrace(System.out);
                }
            }
        }
        return new ExcelReportsConfig();
    }
}

