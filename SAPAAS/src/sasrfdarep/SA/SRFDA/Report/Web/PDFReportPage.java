/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Data.SelectResult
 *  SA.SRFramework.Utility.Helper
 *  SA.SRFramework.Utility.StringHelper
 *  com.jspsmart.upload.SmartUpload
 *  net.sf.jasperreports.engine.JRDataSource
 *  net.sf.jasperreports.engine.JasperRunManager
 */
package SA.SRFDA.Report.Web;

import SA.SRFDA.Report.DAJRDataSource;
import SA.SRFDA.Report.Web.ReportPage;
import SA.SRFramework.Data.SelectResult;
import SA.SRFramework.Utility.Helper;
import SA.SRFramework.Utility.StringHelper;
import com.jspsmart.upload.SmartUpload;
import java.util.Map;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JasperRunManager;

public class PDFReportPage
extends ReportPage {
    @Override
    protected String GetTmpFilePath() {
        return StringHelper.Format((String)"%1$s%2$s.pdf", (Object)this.getWebContext().getGlobalHelper().GetTempPath(), (Object)Helper.GenGuid());
    }

    @Override
    protected void ExportReportFile(String strReportPath, String strTempPath, Map parameters, SelectResult selectResult) {
        try {
            String strFileName;
            JasperRunManager.runReportToPdfFile((String)strReportPath, (String)strTempPath, (Map)parameters, (JRDataSource)new DAJRDataSource(selectResult.getMainTable()));
            String strNewFileName = strFileName = String.valueOf(this.report.getREPORTNAME()) + ".pdf";
            SmartUpload su = new SmartUpload();
            su.initialize(this.pageContext);
            su.downloadFile(strTempPath, "", strNewFileName);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}

