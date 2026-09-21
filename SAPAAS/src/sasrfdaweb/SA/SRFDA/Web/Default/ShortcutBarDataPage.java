/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Ctrl.Data.Chart
 *  SA.SRFDA.Ctrl.Data.UserShortcut
 *  SA.SRFDA.Ctrl.IDEDataCtrl
 *  SA.SRFDA.Web.ISRFDAWebContext
 *  SA.SRFramework.DataEx.BaseDataEntity
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.Web.Default;

import SA.SRFDA.Ctrl.Data.Chart;
import SA.SRFDA.Ctrl.Data.UserShortcut;
import SA.SRFDA.Ctrl.IDEDataCtrl;
import SA.SRFDA.Web.ISRFDAWebContext;
import SA.SRFDA.Web.SRFDAPage;
import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class ShortcutBarDataPage
extends SRFDAPage {
    protected Chart chart = new Chart();
    private static final Log log = LogFactory.getLog(ShortcutBarDataPage.class);

    public ShortcutBarDataPage() {
        this.setMainPage(true);
        this.setOutputDebug(false);
    }

    @Override
    protected boolean PreparePageEnv() {
        if (!super.PreparePageEnv()) {
            return false;
        }
        this.strPageDataEntityId = "DE0061";
        return this.LoadPageDataEntity();
    }

    protected void OnLoadBackEnd() {
        String strKey = StringHelper.Format((String)"%1$s:%2$s", (Object)this.getWebContext().getCurUserId(), (Object)this.getWebContext().getCurUserMode());
        String strAction = this.getWebContext().getAction();
        if (StringHelper.Compare((String)strAction, (String)"get", (boolean)true) == 0) {
            String strEmpty = "<?xml version=\"1.0\" encoding=\"utf-8\" ?><SHORTCUTBAR />";
            UserShortcut usershortcut = new UserShortcut();
            usershortcut.setUSERSHORTCUTID(strKey);
            CallResult callResult = this.getDEHelper().GetDEDataCtrl("", (ISRFDAWebContext)this.getWebContext()).Get((BaseDataEntity)usershortcut);
            if (callResult.getRetCode() == 0) {
                if (StringHelper.IsNullOrEmpty((String)usershortcut.getSCMODEL())) {
                    this.Output(strEmpty);
                } else {
                    this.Output(usershortcut.getSCMODEL());
                }
                return;
            }
            if (callResult.getRetCode() == 3) {
                this.Output(strEmpty);
                return;
            }
            return;
        }
        if (StringHelper.Compare((String)strAction, (String)"save", (boolean)true) == 0) {
            UserShortcut usershortcut = new UserShortcut();
            usershortcut.setUSERSHORTCUTID(strKey);
            IDEDataCtrl iDEDataCtrl = this.getDEHelper().GetDEDataCtrl("", (ISRFDAWebContext)this.getWebContext());
            CallResult callResult = iDEDataCtrl.CheckKeyState((BaseDataEntity)usershortcut);
            if (callResult.getRetCode() != 0) {
                this.PageLog((Object)this, 1, StringHelper.Format((String)"\u68c0\u67e5\u6570\u636e\u952e\u503c\u72b6\u6001\u5931\u8d25\uff0c%1$s", (Object)callResult.getErrorInfo()));
                return;
            }
            usershortcut.setSCMODEL(this.getWebContext().GetPostValue("scmodel"));
            usershortcut.setOWNERID(this.getWebContext().getCurUserId());
            int nKeyState = (Integer)callResult.getUserObject();
            callResult = iDEDataCtrl.Save(nKeyState == 0, (BaseDataEntity)usershortcut);
            if (callResult.getRetCode() != 0) {
                this.PageLog((Object)this, 1, StringHelper.Format((String)"\u4fdd\u5b58\u7528\u6237\u5feb\u6377\u65b9\u5f0f\u6a21\u578b\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
                return;
            }
            return;
        }
    }
}

