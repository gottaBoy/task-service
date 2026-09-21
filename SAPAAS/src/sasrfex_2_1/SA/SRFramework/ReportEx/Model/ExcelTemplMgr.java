/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Base.ConfigMgr
 *  SA.SRFramework.Utility.StringHelper
 *  org.apache.xerces.parsers.DOMParser
 */
package SA.SRFramework.ReportEx.Model;

import SA.SRFramework.Base.ConfigMgr;
import SA.SRFramework.ReportEx.Model.FormExcelExportConfig;
import SA.SRFramework.ReportEx.Model.GridExcelExportConfig;
import SA.SRFramework.Utility.StringHelper;
import java.io.File;
import java.util.Hashtable;
import org.apache.xerces.parsers.DOMParser;
import org.w3c.dom.Document;

public class ExcelTemplMgr
extends ConfigMgr {
    private final byte[] key;

    public ExcelTemplMgr() {
        byte[] byArray = new byte[8];
        byArray[0] = 1;
        byArray[1] = 9;
        byArray[2] = 9;
        byArray[3] = 7;
        byArray[5] = 7;
        byArray[7] = 1;
        this.key = byArray;
    }

    public FormExcelExportConfig GetFormExcelExportConfig(String strFormExcelExport) {
        return this.GetFormExcelExportConfig(strFormExcelExport, true);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public FormExcelExportConfig GetFormExcelExportConfig(String strFormExcelExport, boolean bCache) {
        String strDCConfigPath = this.GetConfigFilePath("exceltempl" + this.strFolderSeperator + this.GetRealPath(strFormExcelExport) + ".xml");
        File file = new File(strDCConfigPath);
        if (file.exists()) {
            long nLastModify = file.lastModified();
            if (bCache) {
                Hashtable hashtable = this.fileList;
                synchronized (hashtable) {
                    Long nCurLastModify;
                    if (this.fileList.containsKey(strDCConfigPath) && nLastModify == (nCurLastModify = (Long)this.modifydateList.get(strDCConfigPath))) {
                        return (FormExcelExportConfig)((Object)this.fileList.get(strDCConfigPath));
                    }
                }
            }
            try {
                DOMParser parser = new DOMParser();
                if (this.bEncrypt) {
                    parser.parse(ExcelTemplMgr.getContent((String)strDCConfigPath, (byte[])this.key));
                } else {
                    parser.parse(strDCConfigPath);
                }
                Document doc = parser.getDocument();
                FormExcelExportConfig formExcelExportConfig = new FormExcelExportConfig();
                formExcelExportConfig.LoadConfig(doc.getDocumentElement());
                String strTemplate = formExcelExportConfig.getTemplate();
                if (StringHelper.Length((String)strTemplate) > 0) {
                    String strDirectary = file.getParent();
                    strDirectary = String.valueOf(strDirectary) + File.separator;
                    strDirectary = String.valueOf(strDirectary) + strTemplate;
                    formExcelExportConfig.setTemplate(strDirectary);
                }
                if (bCache) {
                    Hashtable hashtable = this.fileList;
                    synchronized (hashtable) {
                        this.fileList.put(strDCConfigPath, formExcelExportConfig);
                        this.modifydateList.put(strDCConfigPath, nLastModify);
                    }
                }
                return formExcelExportConfig;
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
    public GridExcelExportConfig GetGridExcelExportConfig(String strGridExcelExport) {
        String strDCConfigPath = this.GetConfigFilePath("exceltempl" + this.strFolderSeperator + this.GetRealPath(strGridExcelExport) + ".xml");
        File file = new File(strDCConfigPath);
        if (file.exists()) {
            long nLastModify = file.lastModified();
            Hashtable hashtable = this.fileList;
            synchronized (hashtable) {
                Long nCurLastModify;
                if (this.fileList.containsKey(strDCConfigPath) && nLastModify == (nCurLastModify = (Long)this.modifydateList.get(strDCConfigPath))) {
                    return (GridExcelExportConfig)((Object)this.fileList.get(strDCConfigPath));
                }
            }
            try {
                DOMParser parser = new DOMParser();
                if (this.bEncrypt) {
                    parser.parse(ExcelTemplMgr.getContent((String)strDCConfigPath, (byte[])this.key));
                } else {
                    parser.parse(strDCConfigPath);
                }
                Document doc = parser.getDocument();
                GridExcelExportConfig gridExcelExportConfig = new GridExcelExportConfig();
                gridExcelExportConfig.LoadConfig(doc.getDocumentElement());
                String strTemplate = gridExcelExportConfig.getTemplate();
                if (StringHelper.Length((String)strTemplate) > 0) {
                    String strDirectary = file.getParent();
                    strDirectary = String.valueOf(strDirectary) + File.separator;
                    strDirectary = String.valueOf(strDirectary) + strTemplate;
                    gridExcelExportConfig.setTemplate(strDirectary);
                }
                Hashtable hashtable2 = this.fileList;
                synchronized (hashtable2) {
                    this.fileList.put(strDCConfigPath, gridExcelExportConfig);
                    this.modifydateList.put(strDCConfigPath, nLastModify);
                }
                return gridExcelExportConfig;
            }
            catch (Exception ex) {
                ex.printStackTrace(System.out);
                return null;
            }
        }
        return null;
    }
}

