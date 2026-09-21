/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  SA.SRFramework.UtilityEx.ObjectHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.Ctrl;

import SA.SRFDA.Ctrl.BaseDAGlobalModel;
import SA.SRFDA.Ctrl.Data.DERGroupFolder;
import SA.SRFDA.Ctrl.IDERGroupFolderHelper;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.UtilityEx.ObjectHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class DERGroupFolderGlobalModel
extends BaseDAGlobalModel<String, DERGroupFolder, IDERGroupFolderHelper> {
    private static final Log log = LogFactory.getLog(DERGroupFolderGlobalModel.class);

    @Override
    protected CallResult OnInit() {
        CallResult callResult = super.OnInit();
        if (callResult.IsError()) {
            return callResult;
        }
        return callResult;
    }

    @Override
    protected DERGroupFolder GetObject(String objObjectId) {
        DERGroupFolder derGroupFolder = new DERGroupFolder();
        CallResult callRsult = this.iDAGlobalHelper.getDAModelHelper().GetDERGroupFolder(objObjectId, derGroupFolder);
        if (callRsult.IsError()) {
            log.error((Object)StringHelper.Format((String)"\u83b7\u53d6\u5b9e\u4f53\u5173\u7cfb\u6a21\u5f0f[%1$s]\u53d1\u751f\u9519\u8bef\uff0c%2$s", (Object)objObjectId, (Object)callRsult.getErrorInfo()));
            return null;
        }
        return derGroupFolder;
    }

    @Override
    protected Boolean TestObjectRenew(DERGroupFolder obj) {
        return false;
    }

    @Override
    protected IDERGroupFolderHelper OnCreateModelHelper(DERGroupFolder derGroupFolder) throws Exception {
        String strHelperObject = "SA.SRFDA.Ctrl.DERGroupFolderHelper";
        Object objDERGroupFolderHelper = ObjectHelper.Create((String)strHelperObject);
        if (objDERGroupFolderHelper == null) {
            throw new Exception(StringHelper.Format((String)"\u65e0\u6cd5\u5efa\u7acb\u5b9e\u4f53\u5173\u7cfb\u6a21\u5f0f[%1$s]\u8f85\u52a9\u5bf9\u8c61[%2$s]", (Object)derGroupFolder.getDERGROUPFOLDERID(), (Object)strHelperObject));
        }
        if (!(objDERGroupFolderHelper instanceof IDERGroupFolderHelper)) {
            throw new Exception(StringHelper.Format((String)"\u5b9e\u4f53\u5173\u7cfb\u6a21\u5f0f[%1$s]\u8f85\u52a9\u5bf9\u8c61[%2$s]\u7c7b\u578b\u4e0d\u6b63\u786e", (Object)derGroupFolder.getDERGROUPFOLDERID(), (Object)strHelperObject));
        }
        IDERGroupFolderHelper iDERGroupFolderHelper = (IDERGroupFolderHelper)objDERGroupFolderHelper;
        iDERGroupFolderHelper.Init(this.iDAGlobalHelper, derGroupFolder);
        return iDERGroupFolderHelper;
    }
}

