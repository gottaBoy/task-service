/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Default.BaseMainPage
 *  SA.SRFramework.Utility.StringHelper
 *  com.jspsmart.upload.SmartUpload
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Web;

import SA.SRFDA.PS.Core.JIT.Web.PSJITWebContext;
import SA.SRFDA.Web.Default.BaseMainPage;
import SA.SRFramework.Utility.StringHelper;
import com.jspsmart.upload.SmartUpload;
import java.io.File;
import java.util.Date;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class SystemModelLogPage
extends BaseMainPage {
    private static final Log log = LogFactory.getLog(SystemModelLogPage.class);

    protected void OnInitComponents() {
        super.OnInitComponents();
        if (PSJITWebContext.getInstance() != null) {
            PSJITWebContext.setCurrent(null);
        }
        try {
            String strSystemLogFilePath;
            File file;
            String strPSDevSlnSysId = this.getWebContext().GetParamValue("PSDEVSLNSYSID");
            String strPSSystemId = this.getWebContext().GetParamValue("PSSYSID");
            String strUserId = this.getRequest().getHeader("X-SRFUSERID");
            String strLoginName = this.getRequest().getHeader("X-SRFLOGINNAME");
            String strId = "";
            if (!StringHelper.IsNullOrEmpty((String)strPSDevSlnSysId)) {
                String strUserName = this.getRequest().getHeader("X-SRFUSERNAME");
                if (StringHelper.IsNullOrEmpty((String)strUserId)) {
                    return;
                }
                strId = strPSDevSlnSysId;
            } else if (!StringHelper.IsNullOrEmpty((String)strPSSystemId)) {
                if (StringHelper.IsNullOrEmpty((String)this.getWebContext().getCurUserId())) {
                    return;
                }
                strId = strPSSystemId;
            } else {
                return;
            }
            String strCodeFolder = this.getDAGlobalHelper().getWebExConfig().GetValue("SRFPS", "CODEFOLDER", null);
            if (!StringHelper.IsNullOrEmpty((String)strCodeFolder) && (file = new File(strSystemLogFilePath = StringHelper.Format((String)"%2$s/active.log", (Object)new Date(), (Object)(strCodeFolder = StringHelper.Format((String)"%1$s/_SYSLOG/%2$s", (Object)strCodeFolder, (Object)strId))))).exists()) {
                SmartUpload su = new SmartUpload();
                su.initialize(this.pageContext);
                su.downloadFile(strSystemLogFilePath);
            }
        }
        catch (Exception e) {
            this.PageLog((Object)this, 1, e.getMessage(), e);
        }
    }
}

