/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Ctrl.BaseDEHelper
 *  SA.SRFDA.Ctrl.IDEDataCtrl
 *  SA.SRFDA.Web.SRFDAHttpModule
 *  SA.SRFramework.Utility.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.Web;

import SA.SRFDA.Ctrl.BaseDEHelper;
import SA.SRFDA.Ctrl.IDEDataCtrl;
import SA.SRFDA.Ctrl.SearchForm.BaseDASearchFormActionHelper;
import SA.SRFDA.Web.SRFDAHttpModule;
import SA.SRFDA.Web.SRFDAPage;
import SA.SRFramework.Utility.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class SRFDAWebHttpModule
extends SRFDAHttpModule {
    private static Log log = LogFactory.getLog(SRFDAWebHttpModule.class);

    protected void OnAfterInit() {
        super.OnAfterInit();
        boolean bSFLoadDefaultFromUrl = this.contextHelperEx.getWebExConfig().GetValue("SRFDA", "SFLOADDEFAULTFROMURL", false);
        log.info((Object)StringHelper.Format((String)"\u641c\u7d22\u8868\u5355\u4eceURL\u4e2d\u52a0\u8f7d\u9ed8\u8ba4\u503c[%1$s]", (Object)(bSFLoadDefaultFromUrl ? "\u662f" : "\u5426")));
        BaseDASearchFormActionHelper.setLoadDefaultFromUrl(bSFLoadDefaultFromUrl);
        boolean bPrintAction = this.contextHelperEx.getWebExConfig().GetValue("SRFDA", "PRINTACTION", true);
        log.info((Object)StringHelper.Format((String)"\u5b9e\u4f53\u9ed8\u8ba4\u542f\u7528\u6253\u5370\u529f\u80fd[%1$s]", (Object)(bPrintAction ? "\u662f" : "\u5426")));
        BaseDEHelper.setEnablePrintDefault((boolean)bPrintAction);
        boolean bHelpAction = this.contextHelperEx.getWebExConfig().GetValue("SRFDA", "HELPACTION", true);
        log.info((Object)StringHelper.Format((String)"\u5b9e\u4f53\u9ed8\u8ba4\u542f\u7528\u5e2e\u52a9\u529f\u80fd[%1$s]", (Object)(bHelpAction ? "\u662f" : "\u5426")));
        BaseDEHelper.setEnableHelpDefault((boolean)bHelpAction);
        boolean bImportAction = this.contextHelperEx.getWebExConfig().GetValue("SRFDA", "IMPORTACTION", true);
        log.info((Object)StringHelper.Format((String)"\u5b9e\u4f53\u9ed8\u8ba4\u542f\u7528\u5bfc\u5165\u6570\u636e\u529f\u80fd[%1$s]", (Object)(bImportAction ? "\u662f" : "\u5426")));
        BaseDEHelper.setEnableImportDefault((boolean)bImportAction);
        boolean bExportAction = this.contextHelperEx.getWebExConfig().GetValue("SRFDA", "EXPORTACTION", true);
        log.info((Object)StringHelper.Format((String)"\u5b9e\u4f53\u9ed8\u8ba4\u542f\u7528\u5bfc\u51fa\u6570\u636e\u529f\u80fd[%1$s]", (Object)(bExportAction ? "\u662f" : "\u5426")));
        BaseDEHelper.setEnableExportDefault((boolean)bExportAction);
        this.OnPreparePageLogDataCtrl();
    }

    protected void OnPreparePageLogDataCtrl() {
        if (this.contextHelperEx.getDAModelVersion() >= 11060400) {
            IDEDataCtrl pageLogDataCtrl = this.contextHelperEx.getDAModelStorage().FindDEDataCtrl("DE0144", "SYSTEM", null);
            if (pageLogDataCtrl == null) {
                log.error((Object)StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u5b9e\u4f53[%1$s]\u6570\u636e\u8bbf\u95ee\u5bf9\u8c61", (Object)"DE0144"));
                return;
            }
            SRFDAPage.setPageLogDataCtrl(pageLogDataCtrl);
        }
    }
}

