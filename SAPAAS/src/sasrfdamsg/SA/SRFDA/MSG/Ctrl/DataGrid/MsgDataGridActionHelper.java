/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Ctrl.BaseDAQueryModelHelper
 *  SA.SRFDA.Ctrl.DEFHelper.IDEFHelper
 *  SA.SRFDA.Ctrl.Data.Message
 *  SA.SRFDA.Ctrl.DataGrid.BaseDADataGridActionHelper
 *  SA.SRFramework.DataEx.BaseDataEntity
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  SA.SRFramework.WebEx.SRFExDGAjaxActionResult
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.MSG.Ctrl.DataGrid;

import SA.SRFDA.Ctrl.BaseDAQueryModelHelper;
import SA.SRFDA.Ctrl.DEFHelper.IDEFHelper;
import SA.SRFDA.Ctrl.Data.Message;
import SA.SRFDA.Ctrl.DataGrid.BaseDADataGridActionHelper;
import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.WebEx.SRFExDGAjaxActionResult;
import java.util.Vector;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class MsgDataGridActionHelper
extends BaseDADataGridActionHelper {
    private static final Log log = LogFactory.getLog(MsgDataGridActionHelper.class);
    public static final String TAG_CUSTOMCALL_MSGREMOVE = "REMOVEMSG";

    protected boolean OnCustomAction(String strAction) {
        if (StringHelper.Compare((String)strAction, (String)TAG_CUSTOMCALL_MSGREMOVE, (boolean)true) == 0) {
            return this.MsgRemove();
        }
        return super.OnCustomAction(strAction);
    }

    protected boolean MsgRemove() {
        SRFExDGAjaxActionResult customActionResult = new SRFExDGAjaxActionResult();
        customActionResult.setReload(true);
        String strKeys = this.getWebContext().GetPostValue("srfdakeys");
        String[] keys = strKeys.split("[,]");
        String strErrorInfo = "";
        int i = 0;
        while (i < keys.length) {
            String strKeyId = keys[i];
            if (!StringHelper.IsNullOrEmpty((String)strKeyId)) {
                Message message = new Message();
                message.setMESSAGEID(strKeyId);
                CallResult callResult = this.getDEDataCtrl().CustomCall(TAG_CUSTOMCALL_MSGREMOVE, (BaseDataEntity)message);
                if (callResult.getRetCode() != 0) {
                    strErrorInfo = StringHelper.Format((String)"\u6d88\u606f\u5220\u9664\u5931\u8d25\uff1a%1$s", (Object)callResult.getErrorInfo());
                    break;
                }
            }
            ++i;
        }
        if (StringHelper.IsNullOrEmpty((String)strErrorInfo)) {
            customActionResult.setJSCode("alert('\u6d88\u606f\u5220\u9664\u6210\u529f\uff01');");
            customActionResult.setRetCode(0);
        } else {
            customActionResult.setRetCode(1);
            customActionResult.setErrorInfo(strErrorInfo);
        }
        this.getPage().Output(customActionResult.ToJSONString());
        return true;
    }

    protected void FillDAQueryModelHelperCondition(Vector<String> userConditions, BaseDAQueryModelHelper daQueryModelHelper) {
        super.FillDAQueryModelHelperCondition(userConditions, daQueryModelHelper);
        IDEFHelper iDEFHelper = daQueryModelHelper.GetMajorDEHelper().GetDEFHelper("MSGACCOUNTID");
        if (iDEFHelper == null) {
            log.error((Object)StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u5b9e\u4f53\u5c5e\u6027[%1$s]\u8f85\u52a9\u5bf9\u8c61", (Object)"MSGACCOUNTID"));
            return;
        }
        userConditions.add(daQueryModelHelper.GetConditionSQL(iDEFHelper, "", "=", this.getWebContext().getCurUserId()));
        IDEFHelper folderDEFHelper = daQueryModelHelper.GetMajorDEHelper().GetDEFHelper("MSGFOLDER");
        if (folderDEFHelper == null) {
            log.error((Object)StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u5b9e\u4f53\u5c5e\u6027[%1$s]\u8f85\u52a9\u5bf9\u8c61", (Object)"MSGFOLDER"));
            return;
        }
        String strMsgFolder = this.getPage().getPageParam("MSGFOLDER", "INBOX");
        userConditions.add(daQueryModelHelper.GetConditionSQL(folderDEFHelper, "", "=", strMsgFolder));
    }

    protected boolean OnGetUserDP() {
        return false;
    }
}

