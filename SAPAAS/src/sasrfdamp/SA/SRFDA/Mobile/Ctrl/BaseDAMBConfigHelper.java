/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Ctrl.ConfigPathHelper
 *  SA.SRFDA.Ctrl.IDAMBConfigHelper
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFramework.XML.SimpleXMLWriter
 *  SA.SRFramework.XML.XMLNode
 */
package SA.SRFDA.Mobile.Ctrl;

import SA.SRFDA.Ctrl.ConfigPathHelper;
import SA.SRFDA.Ctrl.IDAMBConfigHelper;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.XML.SimpleXMLWriter;
import SA.SRFramework.XML.XMLNode;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

public abstract class BaseDAMBConfigHelper
implements IDAMBConfigHelper {
    private ISRFDAGlobalHelper iDAGlobalHelper = null;
    private String strLanguage = "";
    private String strPageModel = "";

    public void Init(ISRFDAGlobalHelper globalHelperEx, String strLanguage, String strPageModel) throws Exception {
        this.iDAGlobalHelper = globalHelperEx;
        this.strLanguage = strLanguage;
        this.strPageModel = strPageModel;
        if (this.iDAGlobalHelper == null) {
            throw new Exception("\u5168\u5c40\u8f85\u52a9\u5bf9\u8c61\u65e0\u6548");
        }
    }

    public ISRFDAGlobalHelper getGlobalHelper() {
        return this.iDAGlobalHelper;
    }

    public String getLanguage() {
        return this.strLanguage;
    }

    public String getPageModel() {
        return this.strPageModel;
    }

    public static void ExportConfigFile(XMLNode rootNode, String strConfigPath) throws Exception {
        StringBuilder sb = new StringBuilder();
        SimpleXMLWriter writer = new SimpleXMLWriter(sb);
        writer.WriteRaw("<?xml version=\"1.0\" encoding=\"utf-8\" ?>\r\n");
        rootNode.Save(writer);
        OutputStreamWriter out = new OutputStreamWriter((OutputStream)new FileOutputStream(strConfigPath), "UTF-8");
        out.write(sb.toString());
        out.flush();
        out.close();
    }

    public static String GetRuntimeMBListConfigPath(String strRoot, String strConfigId) {
        return BaseDAMBConfigHelper.GetMBListConfigPath(strRoot, "configex_runtime", strConfigId);
    }

    public static String GetMBListConfigPath(String strRoot, String strConfigFolder, String strConfigId) {
        return ConfigPathHelper.GetConfigFilePath((String)strRoot, (String)strConfigFolder, (String)"mblist", (String)strConfigId);
    }
}

