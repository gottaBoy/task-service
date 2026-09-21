/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Utility.StringHelper
 *  SA.SRFramework.XML.SimpleXMLWriter
 *  SA.SRFramework.XML.XMLNode
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.Ctrl;

import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.XML.SimpleXMLWriter;
import SA.SRFramework.XML.XMLNode;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public abstract class BaseDAConfigHelper {
    private static final Log log = LogFactory.getLog(BaseDAConfigHelper.class);
    protected ISRFDAGlobalHelper globalHelperEx = null;
    protected String strLanguage = "";
    protected String strPageModel = "";
    protected String strDGResponseType = "";

    public boolean Init(ISRFDAGlobalHelper globalHelperEx, String strLanguage, String strPageModel) {
        this.globalHelperEx = globalHelperEx;
        this.strLanguage = strLanguage;
        this.strPageModel = strPageModel;
        if (StringHelper.IsNullOrEmpty((String)this.strPageModel)) {
            this.strDGResponseType = globalHelperEx.getWebExConfig().GetValue("SRFDA.DACONFIG", "DGRESPONSE", "JSON");
        }
        return true;
    }

    public ISRFDAGlobalHelper getGlobalHelper() {
        return this.globalHelperEx;
    }

    public String getLanguage() {
        return this.strLanguage;
    }

    public String getPageModel() {
        return this.strPageModel;
    }

    public static boolean ExportConfigFile(XMLNode rootNode, String strConfigPath) {
        try {
            StringBuilder sb = new StringBuilder();
            SimpleXMLWriter writer = new SimpleXMLWriter(sb);
            writer.WriteRaw("<?xml version=\"1.0\" encoding=\"utf-8\" ?>\r\n");
            rootNode.Save(writer);
            OutputStreamWriter out = new OutputStreamWriter((OutputStream)new FileOutputStream(strConfigPath), "UTF-8");
            out.write(sb.toString());
            out.flush();
            out.close();
        }
        catch (Exception ex) {
            log.error((Object)StringHelper.Format((String)"\u5bfc\u51fa\u914d\u7f6e\u6587\u4ef6[%1$s]\u53d1\u751f\u9519\u8bef", (Object)strConfigPath), (Throwable)ex);
            return false;
        }
        return true;
    }
}

