/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Ctrl.Data.Message
 *  SA.SRFDA.Ctrl.IDEDataCtrl
 *  SA.SRFDA.Web.ISRFDAWebContext
 *  SA.SRFDA.Web.SRFDAPage
 *  SA.SRFramework.DataEx.BaseDataEntity
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  SA.SRFramework.WebEx.SRFExAjaxActionResultEx
 *  net.sf.json.JSONObject
 */
package SA.SRFDA.MSG.Web;

import SA.SRFDA.Ctrl.Data.Message;
import SA.SRFDA.Ctrl.IDEDataCtrl;
import SA.SRFDA.Web.ISRFDAWebContext;
import SA.SRFDA.Web.SRFDAPage;
import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.WebEx.SRFExAjaxActionResultEx;
import net.sf.json.JSONObject;

public class MsgHelperPage
extends SRFDAPage {
    public static final String TAG_FOLDER_MSGITEM = "MSGITEM";

    protected void OnLoad() {
        String strFolder = this.getWebContext().GetParamValue("FOLDER");
        String strItem = this.getWebContext().GetParamValue("ITEM");
        if (StringHelper.Compare((String)strFolder, (String)TAG_FOLDER_MSGITEM, (boolean)true) == 0) {
            SRFExAjaxActionResultEx ajaxActionResult = new SRFExAjaxActionResultEx();
            if (StringHelper.IsNullOrEmpty((String)strItem)) {
                this.PageLog((Object)this, 1, "\u6ca1\u6709\u6307\u5b9a\u6d88\u606f\u7f16\u53f7");
                ajaxActionResult.setRetCode(1);
                ajaxActionResult.setErrorInfo("\u6ca1\u6709\u6307\u5b9a\u6d88\u606f\u7f16\u53f7");
                this.Output(ajaxActionResult.ToJSONString());
                return;
            }
            IDEDataCtrl iDataCtrl = this.getDAModelStorage().FindDEDataCtrl("DE0071", (ISRFDAWebContext)this.getWebContext());
            if (iDataCtrl == null) {
                this.PageLog((Object)this, 1, StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u5b9e\u4f53[%1$s]\u6570\u636e\u8bbf\u95ee\u5bf9\u8c61", (Object)"DE0071"));
                ajaxActionResult.setRetCode(1);
                ajaxActionResult.setErrorInfo(StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u5b9e\u4f53[%1$s]\u6570\u636e\u8bbf\u95ee\u5bf9\u8c61", (Object)"DE0071"));
                this.Output(ajaxActionResult.ToJSONString());
                return;
            }
            Message message = new Message();
            message.setMESSAGEID(strItem);
            CallResult callResult = iDataCtrl.Get((BaseDataEntity)message);
            if (callResult.getRetCode() != 0) {
                this.PageLog((Object)this, 1, StringHelper.Format((String)"\u83b7\u53d6\u6d88\u606f\u6570\u636e\u5931\u8d25\uff0c%1$s", (Object)callResult.getErrorInfo()));
                ajaxActionResult.setRetCode(1);
                ajaxActionResult.setErrorInfo(StringHelper.Format((String)"\u83b7\u53d6\u6d88\u606f\u6570\u636e\u5931\u8d25\uff0c%1$s", (Object)callResult.getErrorInfo()));
                this.Output(ajaxActionResult.ToJSONString());
                return;
            }
            if (StringHelper.Compare((String)message.getMSGACCOUNTID(), (String)this.getWebContext().getCurUserId(), (boolean)true) != 0) {
                this.PageLog((Object)this, 1, StringHelper.Format((String)"\u6d88\u606f\u6240\u6709\u8005\u5e76\u975e\u5f53\u524d\u7528\u6237\uff0c\u65e0\u6cd5\u52a0\u8f7d"));
                ajaxActionResult.setRetCode(1);
                ajaxActionResult.setErrorInfo(StringHelper.Format((String)"\u6d88\u606f\u6240\u6709\u8005\u5e76\u975e\u5f53\u524d\u7528\u6237\uff0c\u65e0\u6cd5\u52a0\u8f7d"));
                this.Output(ajaxActionResult.ToJSONString());
                return;
            }
            this.UpdateReadFlag(iDataCtrl, strItem);
            JSONObject jsonObject = new JSONObject();
            message.FillJSONObject(jsonObject);
            ajaxActionResult.setItemObject(jsonObject);
            this.Output(ajaxActionResult.ToJSONString());
            return;
        }
    }

    private void UpdateReadFlag(IDEDataCtrl iDataCtrl, String strMessageId) {
        Message tmpmessage = new Message();
        tmpmessage.setMESSAGEID(strMessageId);
        tmpmessage.SetParamValue("ISREADFLAG", (Object)1);
        try {
            iDataCtrl.Save(false, (BaseDataEntity)tmpmessage);
        }
        catch (Exception exception) {
            // empty catch block
        }
    }
}

