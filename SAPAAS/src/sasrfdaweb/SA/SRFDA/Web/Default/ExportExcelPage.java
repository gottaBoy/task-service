/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Utility.StringHelper
 *  com.jspsmart.upload.SmartUpload
 */
package SA.SRFDA.Web.Default;

import SA.SRFDA.Web.SRFDAPage;
import SA.SRFramework.Utility.StringHelper;
import com.jspsmart.upload.SmartUpload;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ExportExcelPage
extends SRFDAPage {
    public ExportExcelPage() {
        this.setMainPage(true);
        this.setOutputDebug(false);
        this.setNoCache(false);
    }

    protected void OnInitComponents() {
        super.OnInitComponents();
        String strFileName = this.webContext.GetParamValue("FILEID");
        if (StringHelper.IsNullOrEmpty((String)strFileName)) {
            return;
        }
        String strExportType = this.webContext.GetParamValue("EXPORTTYPE");
        String strFullFileName = "";
        try {
            String strFileSuffix = "";
            if (StringHelper.Compare((String)strExportType, (String)"HTML", (boolean)true) == 0) {
                strFileSuffix = "htm";
                this.getResponse().setContentType("text/html;charset=GBK");
                this.getResponse().setCharacterEncoding("GBK");
                strFullFileName = StringHelper.Format((String)"%1$s%2$s%3$s%4$s.%5$s", (Object)this.getWebContext().getGlobalHelper().GetTempPath(), (Object)this.getWebContext().getSessionId(), (Object)File.separator, (Object)strFileName, (Object)strFileSuffix);
                this.ExportGridViewHTML(strFullFileName);
            } else {
                this.getResponse().setContentType("application/vnd.ms-excel;charset=GBK");
                this.getResponse().setCharacterEncoding("GBK");
                strFileSuffix = "xls";
                strFullFileName = StringHelper.Format((String)"%1$s%2$s%3$s%4$s.%5$s", (Object)this.getWebContext().getGlobalHelper().GetTempPath(), (Object)this.getWebContext().getSessionId(), (Object)File.separator, (Object)strFileName, (Object)strFileSuffix);
                SmartUpload su = new SmartUpload();
                su.initialize(this.pageContext);
                su.downloadFile(strFullFileName);
                this.pageContext.getOut().clear();
            }
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void ExportGridViewHTML(String strFullFileName) {
        FileInputStream fis = null;
        try {
            this.getResponse().getOutputStream().flush();
            fis = new FileInputStream(new File(strFullFileName));
            if (fis == null || fis.available() <= 0) {
                return;
            }
            try {
                byte[] bytes = new byte[fis.available()];
                int nCnt = fis.read(bytes);
                this.getResponse().getOutputStream().write(bytes);
            }
            catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            catch (IOException e) {
                e.printStackTrace();
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            if (fis != null) {
                try {
                    fis.close();
                }
                catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

