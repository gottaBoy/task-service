/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Ctrl.IDEDataCtrl
 *  SA.SRFDA.TS.Ctrl.BaseScheduleEngineTask
 *  SA.SRFDA.TS.Ctrl.Data.TSSDTask
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFramework.DataEx.BaseDataEntity
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.IM.Ctrl.Task;

import SA.IM.Ctrl.Task.IMContactsRender;
import SA.SRFDA.Ctrl.IDEDataCtrl;
import SA.SRFDA.TS.Ctrl.BaseScheduleEngineTask;
import SA.SRFDA.TS.Ctrl.Data.TSSDTask;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import java.io.File;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class IMContactsMakerTask2
extends BaseScheduleEngineTask {
    private static final Log log = LogFactory.getLog(IMContactsMakerTask2.class);
    private String strRootTreeId = "";
    private IDEDataCtrl orgTreeDataCtrl = null;
    private IDEDataCtrl orgDataCtrl = null;

    public CallResult Execute(TSSDTask paramTSSDTask) {
        CallResult callResult = new CallResult();
        this.strRootTreeId = paramTSSDTask.getTASKPARAM();
        if (StringHelper.IsNullOrEmpty((String)this.strRootTreeId)) {
            callResult.setRetCode(5);
            callResult.setErrorInfo("\u672a\u53d1\u73b0\u7ec4id");
            log.error((Object)"\u672a\u53d1\u73b0\u7ec4id");
            return callResult;
        }
        log.debug((Object)StringHelper.Format((String)"\u5f00\u59cb\u51c6\u5907\u6821\u9a8c\u7ec4[%1$s]", (Object)this.strRootTreeId));
        try {
            String strTreeVersion = this.getNewVersion();
            log.debug((Object)StringHelper.Format((String)"\u6bd4\u8f83\u540e\u6821\u9a8c\u7248\u672c\u53f7[%1$s]", (Object)strTreeVersion));
            if (StringHelper.IsNullOrEmpty((String)strTreeVersion)) {
                return callResult;
            }
            log.info((Object)StringHelper.Format((String)"\u51c6\u5907\u4ece\u6839\u8282\u70b9[%1$s]\u5bfc\u51fa\u6570\u636e", (Object)this.strRootTreeId));
            String strRootOrgId = this.strRootTreeId;
            String strOutputFile = this.getOutputPath();
            strOutputFile = String.valueOf(strOutputFile) + File.separator + "Contacts.xml";
            IMContactsRender iMContactsRender = new IMContactsRender();
            iMContactsRender.Init(this.getGlobalHelper());
            callResult = iMContactsRender.Export(strOutputFile, strRootOrgId);
            if (callResult.IsOk()) {
                BaseDataEntity org = new BaseDataEntity();
                org.SetParamValue("IMORGTREEID", (Object)this.strRootTreeId);
                org.SetParamValue("VERSION", (Object)strTreeVersion);
                return this.orgTreeDataCtrl.Save(false, org);
            }
        }
        catch (Exception ex) {
            log.error((Object)ex);
            callResult.setRetCode(1);
            callResult.setErrorInfo(ex.getMessage());
        }
        return callResult;
    }

    private String getNewVersion() {
        String strVersion2;
        if (this.orgTreeDataCtrl == null) {
            this.orgTreeDataCtrl = this.getDEDataCtrl("IM0068");
        }
        if (this.orgDataCtrl == null) {
            this.orgDataCtrl = this.getDEDataCtrl("IM0067");
        }
        BaseDataEntity orgTree = new BaseDataEntity();
        orgTree.SetParamValue("IMORGTREEID", (Object)this.strRootTreeId);
        BaseDataEntity org = new BaseDataEntity();
        org.SetParamValue("IMORGID", (Object)this.strRootTreeId);
        CallResult callResult = this.orgTreeDataCtrl.Get(orgTree);
        CallResult callResult2 = this.orgDataCtrl.Get(org);
        if (callResult.IsError() || callResult2.IsError()) {
            log.error((Object)"\u67e5\u8be2orgtree \u548corg \u5b9e\u4f53\u6570\u636e\u9519\u8bef");
            return "";
        }
        String strVersion = org.GetParamStringValue("VERSION", "");
        if (StringHelper.Compare((String)strVersion, (String)(strVersion2 = orgTree.GetParamStringValue("VERSION", "")), (boolean)true) != 0) {
            return strVersion;
        }
        return "";
    }

    private String getOutputPath() {
        if (this.iScheduleEngineContext != null) {
            return this.getGlobalHelper().GetAppRootPath();
        }
        return "";
    }

    private ISRFDAGlobalHelper getGlobalHelper() {
        return this.iScheduleEngineContext.getDAGlobalHelper();
    }

    private IDEDataCtrl getDEDataCtrl(String strDEID) {
        return this.iScheduleEngineContext.getDAGlobalHelper().getDAModelStorage().FindDEDataCtrl(strDEID, "SYSTEM", null);
    }
}

