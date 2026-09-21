/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Ctrl.DEFHelper.IDEFHelper
 *  SA.SRFDA.Ctrl.IDEHelper
 *  SA.SRFDA.Web.ISRFDAWebContext
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFramework.DataEx.BaseDataEntity
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  net.ibizsys.paas.xml.SimpleXmlWriter
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Ctrl.DEDataCtrl;

import SA.SRFDA.Ctrl.DEFHelper.IDEFHelper;
import SA.SRFDA.Ctrl.IDEHelper;
import SA.SRFDA.PS.Ctrl.DEDataCtrl.IPSTemplDataCtrl;
import SA.SRFDA.PS.Ctrl.DEDataCtrl.PSDEDataCtrl;
import SA.SRFDA.Web.ISRFDAWebContext;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Hashtable;
import net.ibizsys.paas.xml.SimpleXmlWriter;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public abstract class PSTemplDataCtrlBase
extends PSDEDataCtrl
implements IPSTemplDataCtrl {
    private static final Log log = LogFactory.getLog(PSTemplDataCtrlBase.class);
    public static final String CUSTOMCALL_IMPORTTEMPL = "IMPORTTEMPL";
    public static final String CUSTOMCALL_EXPORTTEMPL = "EXPORTTEMPL";
    protected String strCodeFolder = null;

    public void Init(IDEHelper iDEHelper, ISRFDAGlobalHelper globalHelperEx, String strCurPersonId, ISRFDAWebContext webContext) {
        super.Init(iDEHelper, globalHelperEx, strCurPersonId, webContext);
        this.strCodeFolder = this.getGlobalHelper().getWebExConfig().GetValue("SRFPS", "TEMPLFOLDER", null);
    }

    @Override
    protected CallResult OnCustomCall(String strCallName, BaseDataEntity dataEntity) {
        if (StringHelper.Compare((String)strCallName, (String)CUSTOMCALL_IMPORTTEMPL, (boolean)true) == 0) {
            return this.importTempl(dataEntity);
        }
        if (StringHelper.Compare((String)strCallName, (String)CUSTOMCALL_EXPORTTEMPL, (boolean)true) == 0) {
            return this.exportTempl(dataEntity);
        }
        return super.OnCustomCall(strCallName, dataEntity);
    }

    public CallResult exportTempl(BaseDataEntity dataEntity) {
        CallResult callResult = this.Get(dataEntity);
        if (callResult.IsError()) {
            return callResult;
        }
        try {
            this.onExportTempl(dataEntity);
            return callResult;
        }
        catch (Exception ex) {
            log.error((Object)StringHelper.Format((String)"\u5bfc\u51fa\u6a21\u677f\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)ex.getMessage()), (Throwable)ex);
            callResult.setRetCode(1);
            callResult.setErrorInfo(ex.getMessage());
            return callResult;
        }
    }

    protected void onExportTempl(BaseDataEntity dataEntity) throws Exception {
        String strDataFolder = this.getTemplFolder(dataEntity);
        File dataFolder = new File(strDataFolder);
        if (!dataFolder.exists()) {
            dataFolder.mkdirs();
        }
        HashMap<String, String> templMap = this.getCodeTemplMap();
        String strMetaDataFile = StringHelper.Format((String)"%1$s%2$smetadata.xml", (Object)strDataFolder, (Object)File.separator);
        PSTemplDataCtrlBase.writeFile(strMetaDataFile, this.exportMetaData(dataEntity, templMap));
        if (templMap != null) {
            for (String strKey : templMap.keySet()) {
                String strFileName = templMap.get(strKey);
                if (StringHelper.IsNullOrEmpty((String)strFileName)) {
                    strFileName = String.valueOf(strKey.toLowerCase()) + ".txt";
                }
                String strTemplFile = StringHelper.Format((String)"%1$s%2$s%3$s", (Object)strDataFolder, (Object)File.separator, (Object)strFileName);
                String strCode = dataEntity.getParamStringValue(strKey, "");
                PSTemplDataCtrlBase.writeFile(strTemplFile, strCode);
            }
        }
    }

    public CallResult importTempl(BaseDataEntity dataEntity) {
        CallResult callResult = this.Get(dataEntity);
        if (callResult.IsError()) {
            return callResult;
        }
        try {
            this.onImportTempl(dataEntity);
            return callResult;
        }
        catch (Exception ex) {
            log.error((Object)StringHelper.Format((String)"\u5bfc\u5165\u6a21\u677f\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)ex.getMessage()), (Throwable)ex);
            callResult.setRetCode(1);
            callResult.setErrorInfo(ex.getMessage());
            return callResult;
        }
    }

    protected void onImportTempl(BaseDataEntity dataEntity) throws Exception {
    }

    protected abstract String getRootFolder() throws Exception;

    @Override
    public abstract String getTemplFolder(BaseDataEntity var1) throws Exception;

    protected HashMap<String, String> getCodeTemplMap() throws Exception {
        return null;
    }

    protected String exportMetaData(BaseDataEntity dataEntity, HashMap<String, String> ignoreMap) throws Exception {
        StringBuilder sb = new StringBuilder();
        SimpleXmlWriter xmlWriter = new SimpleXmlWriter(sb);
        xmlWriter.writeRaw("<?xml version=\"1.0\" encoding=\"utf-8\" ?>");
        xmlWriter.writeRaw("\r\n");
        xmlWriter.writeStartElement(this.GetDEHelper().getName());
        Hashtable hashTable = dataEntity.getParamList();
        Enumeration en = hashTable.keys();
        while (en.hasMoreElements()) {
            String strKey = (String)en.nextElement();
            if (StringHelper.Compare((String)strKey, (String)"CREATEMAN", (boolean)true) == 0 || StringHelper.Compare((String)strKey, (String)"CREATEDATE", (boolean)true) == 0 || StringHelper.Compare((String)strKey, (String)"UPDATEMAN", (boolean)true) == 0 || StringHelper.Compare((String)strKey, (String)"UPDATEDATE", (boolean)true) == 0 || ignoreMap != null && ignoreMap.containsKey(strKey)) continue;
            Object objValue = dataEntity.getParamValue(strKey);
            if (!(objValue instanceof String)) {
                String strValueFormat = "";
                IDEFHelper iDEFHelper = this.GetDEHelper().GetDEFHelper(strKey);
                if (iDEFHelper != null) {
                    strValueFormat = iDEFHelper.GetFormCtrl().GetItemFormat();
                }
                objValue = StringHelper.IsNullOrEmpty((String)strValueFormat) ? objValue.toString() : StringHelper.Format((String)strValueFormat, (Object)objValue);
            }
            xmlWriter.writeStartElement(strKey);
            xmlWriter.writeValue((String)objValue);
            xmlWriter.writeEndElement(false);
        }
        xmlWriter.writeEndElement();
        return sb.toString();
    }

    public static void writeFile(String strFilePath, String strCode) throws Exception {
        String strContent;
        File dstFile = new File(strFilePath);
        if (dstFile.exists() && StringHelper.Compare((String)(strContent = PSTemplDataCtrlBase.readFile(strFilePath)), (String)strCode, (boolean)false) == 0) {
            return;
        }
        OutputStreamWriter write = new OutputStreamWriter((OutputStream)new FileOutputStream(new File(strFilePath)), "UTF-8");
        BufferedWriter writer = new BufferedWriter(write);
        writer.write(strCode);
        writer.flush();
        writer.close();
    }

    static String readFile(String strFilePath) throws Exception {
        StringBuffer sb;
        block15: {
            sb = new StringBuffer();
            InputStreamReader reader = null;
            try {
                try {
                    int nLength;
                    FileInputStream fis = new FileInputStream(strFilePath);
                    reader = new InputStreamReader((InputStream)fis, "UTF-8");
                    char[] buf = new char[4096];
                    while ((nLength = reader.read(buf)) != -1) {
                        sb.append(new String(buf, 0, nLength));
                    }
                }
                catch (Exception e) {
                    e.printStackTrace();
                    if (reader != null) {
                        try {
                            reader.close();
                        }
                        catch (IOException iOException) {}
                    }
                    break block15;
                }
            }
            catch (Throwable throwable) {
                if (reader != null) {
                    try {
                        reader.close();
                    }
                    catch (IOException iOException) {
                        // empty catch block
                    }
                }
                throw throwable;
            }
            if (reader != null) {
                try {
                    reader.close();
                }
                catch (IOException iOException) {
                    // empty catch block
                }
            }
        }
        return sb.toString();
    }
}

