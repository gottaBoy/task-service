/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.PF;

import SA.SRFDA.PS.Core.PF.IPSPFCodeFolder;
import SA.SRFDA.PS.Core.PF.PSPFCodeFolderImpl;
import SA.SRFDA.PS.Core.PF.PSPFGlobalModelBase;
import SA.SRFDA.PS.Data.PSPFCodeFolder;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSPFCodeFolderGlobalModel
extends PSPFGlobalModelBase<String, PSPFCodeFolder, IPSPFCodeFolder> {
    private static final Log log = LogFactory.getLog(PSPFCodeFolderGlobalModel.class);

    @Override
    protected CallResult OnInit() {
        this.bEnableEmptyMap = true;
        return super.OnInit();
    }

    @Override
    protected PSPFCodeFolder GetObject(String strPSPFCodeFolderId) {
        PSPFCodeFolder PSPFCodeFolder2 = new PSPFCodeFolder();
        CallResult callResult = this.iPSModelHelper.getPSPFCodeFolder(strPSPFCodeFolderId, PSPFCodeFolder2);
        if (callResult.IsError()) {
            log.error((Object)StringHelper.Format((String)"\u83b7\u53d6\u6307\u5b9a\u4e91\u5e73\u53f0\u5e94\u7528\u4ee3\u7801\u76ee\u5f55[%1$s]\u53d1\u751f\u9519\u8bef\uff0c%2$s", (Object)strPSPFCodeFolderId, (Object)callResult.getErrorInfo()));
            return null;
        }
        return PSPFCodeFolder2;
    }

    @Override
    protected IPSPFCodeFolder OnCreateModelHelper(PSPFCodeFolder vt) throws Exception {
        PSPFCodeFolderImpl iPSPFCodeFolder = new PSPFCodeFolderImpl();
        iPSPFCodeFolder.init(this.iDAGlobalHelper, this.getPSPF(), vt);
        return iPSPFCodeFolder;
    }

    @Override
    protected Boolean TestObjectRenew(PSPFCodeFolder obj) {
        return false;
    }

    @Override
    protected String getObjectId(PSPFCodeFolder vt) {
        return vt.getPSPFCODEFOLDERID();
    }
}

