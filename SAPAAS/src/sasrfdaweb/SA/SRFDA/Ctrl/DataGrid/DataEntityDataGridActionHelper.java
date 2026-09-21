/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Ctrl.IDEHelper
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.Helper
 *  SA.SRFramework.Utility.StringHelper
 *  SA.SRFramework.WebEx.SRFExAjaxActionResult
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.Ctrl.DataGrid;

import SA.SRFDA.Ctrl.DataGrid.BaseDADataGridActionHelper;
import SA.SRFDA.Ctrl.IDEHelper;
import SA.SRFDA.Web.Utility.DEDataImportTemplateHelper;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.Helper;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.WebEx.SRFExAjaxActionResult;
import java.io.File;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class DataEntityDataGridActionHelper
extends BaseDADataGridActionHelper {
    private static final Log log = LogFactory.getLog(BaseDADataGridActionHelper.class);

    @Override
    protected boolean OnCustomAction(String strAction) {
        if (StringHelper.Compare((String)strAction, (String)"IMPORTTEMPLATE", (boolean)true) == 0) {
            this.OnExportDEImportTemplate();
            return true;
        }
        return super.OnCustomAction(strAction);
    }

    protected boolean OnExportDEImportTemplate() {
        CallResult callResult;
        SRFExAjaxActionResult exportResult = new SRFExAjaxActionResult();
        String strTempFileName = Helper.GenGuid();
        String strDir = StringHelper.Format((String)"%1$s%2$s", (Object)this.getWebContext().getGlobalHelper().GetTempPath(), (Object)this.getWebContext().getSessionId());
        File dir = new File(strDir);
        dir.mkdirs();
        String strFullFileName = StringHelper.Format((String)"%1$s%2$s%3$s%4$s.%5$s", (Object)this.getWebContext().getGlobalHelper().GetTempPath(), (Object)this.getWebContext().getSessionId(), (Object)File.separator, (Object)strTempFileName, (Object)"xls");
        String strKeys = this.getWebContext().GetPostValue("srfdakeys");
        if (StringHelper.IsNullOrEmpty((String)strKeys)) {
            exportResult.setRetCode(5);
            exportResult.setErrorInfo(StringHelper.Format((String)"\u6ca1\u6709\u6307\u5b9a\u5b9e\u4f53\u53c2\u6570"));
            this.getPage().Output(exportResult.ToJSONString());
            return true;
        }
        String[] keys = strKeys.split("[,]");
        IDEHelper deHelper = this.getWebContext().getGlobalHelper().getDAModelStorage().FindDEHelper(keys[0]);
        if (deHelper == null) {
            exportResult.setRetCode(1);
            exportResult.setErrorInfo(StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u5b9e\u4f53[%1$s]\u8f85\u52a9\u5bf9\u8c61", (Object)keys[0]));
            this.getPage().Output(exportResult.ToJSONString());
            return true;
        }
        try {
            callResult = DEDataImportTemplateHelper.Output((ISRFDAGlobalHelper)this.getWebContext().getGlobalHelper(), deHelper, strFullFileName);
        }
        catch (Exception e) {
            callResult = new CallResult();
            callResult.setRetCode(1);
            callResult.setErrorInfo(StringHelper.Format((String)"\u5efa\u7acb\u5bfc\u5165\u6a21\u677f\u6587\u4ef6\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)e.getMessage()));
            log.error((Object)callResult.getErrorInfo(), (Throwable)e);
        }
        if (callResult.getRetCode() != 0) {
            callResult.From((CallResult)exportResult);
            this.getPage().Output(exportResult.ToJSONString());
            return true;
        }
        String strDownloadURL = "";
        strDownloadURL = StringHelper.Format((String)"../srfpage/exportexcel.jsp?FILEID=%1$s&EXPORTTYPE=%2$s", (Object)strTempFileName, (Object)"");
        String strScript = "";
        strScript = StringHelper.IsNullOrEmpty((String)this.getPage().getPageModel()) ? StringHelper.Format((String)"SRFUtility.root().location='%1$s';", (Object)strDownloadURL) : StringHelper.Format((String)"SRFUtility.download('%1$s');", (Object)strDownloadURL);
        exportResult.setJSCode(strScript);
        this.getPage().Output(exportResult.ToJSONString());
        return true;
    }
}

