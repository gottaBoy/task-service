/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Ctrl.Data.Message
 *  SA.SRFDA.Ctrl.IDEDataCtrl
 *  SA.SRFDA.Web.Default.BaseMainPage
 *  SA.SRFDA.Web.ISRFDAWebContext
 *  SA.SRFramework.Base.XMLConfig
 *  SA.SRFramework.CodeList.CodeItemConfig
 *  SA.SRFramework.CodeList.CodeListConfig
 *  SA.SRFramework.DataEx.BaseDataEntity
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  SA.SRFramework.WebEx.SRFExFileUploader
 *  SA.SRFramework.WebEx.Utility.ContextHelper
 */
package SA.SRFDA.MSG.Web;

import SA.SRFDA.Ctrl.Data.Message;
import SA.SRFDA.Ctrl.IDEDataCtrl;
import SA.SRFDA.Web.Default.BaseMainPage;
import SA.SRFDA.Web.ISRFDAWebContext;
import SA.SRFramework.Base.XMLConfig;
import SA.SRFramework.CodeList.CodeItemConfig;
import SA.SRFramework.CodeList.CodeListConfig;
import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.WebEx.SRFExFileUploader;
import SA.SRFramework.WebEx.Utility.ContextHelper;

public class MsgInfoViewPage
extends BaseMainPage {
    protected Message message = new Message();
    protected String strKeyParamValue = "";
    protected String strFileAttachmentsList = "";

    protected boolean PreparePageEnv() {
        if (!super.PreparePageEnv()) {
            return false;
        }
        this.strPageDataEntityId = "DE0071";
        if (!this.LoadPageDataEntity()) {
            return false;
        }
        if (StringHelper.IsNullOrEmpty((String)this.getPageModel())) {
            String strMessageId = this.getWebContext().GetParamValue("MESSAGEID");
            if (StringHelper.IsNullOrEmpty((String)strMessageId)) {
                return false;
            }
            IDEDataCtrl iDataCtrl = this.getDEHelper().GetDEDataCtrl("", (ISRFDAWebContext)this.getWebContext());
            if (iDataCtrl == null) {
                this.PageLog((Object)this, 1, StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u5b9e\u4f53[%1$s]\u6570\u636e\u8bbf\u95ee\u5bf9\u8c61", (Object)"DE0071"));
                return false;
            }
            this.message.setMESSAGEID(strMessageId);
            CallResult callResult = iDataCtrl.Get((BaseDataEntity)this.message);
            if (callResult.getRetCode() != 0) {
                this.PageLog((Object)this, 1, StringHelper.Format((String)"\u83b7\u53d6\u6d88\u606f\u6570\u636e\u5931\u8d25\uff0c%1$s", (Object)callResult.getErrorInfo()));
                return false;
            }
            if (StringHelper.Compare((String)this.message.getMSGACCOUNTID(), (String)this.getWebContext().getCurUserId(), (boolean)true) != 0) {
                this.PageLog((Object)this, 1, StringHelper.Format((String)"\u6d88\u606f\u6240\u6709\u8005\u5e76\u975e\u5f53\u524d\u7528\u6237\uff0c\u65e0\u6cd5\u52a0\u8f7d"));
                return false;
            }
            this.UpdateReadFlag(iDataCtrl);
            this.strFileAttachmentsList = SRFExFileUploader.RenderFileList((String)this.message.getATTACHMENTS(), (ContextHelper)this.getWebContext().getGlobalHelper(), (String)"");
        }
        return true;
    }

    protected void OnInitBackEnd() {
        super.OnInitBackEnd();
    }

    public String GetMsgSubject() {
        return this.message.getMESSAGENAME();
    }

    public String GetMsgSendTime() {
        Object objSendTime = this.message.GetParamValue("SENDTIME");
        if (objSendTime != null) {
            return StringHelper.Format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)objSendTime);
        }
        return "";
    }

    public String GetMsgFROM() {
        String strFromMsgAccountId = this.message.getMSGFROMACCOUNTID();
        if (StringHelper.IsNullOrEmpty((String)strFromMsgAccountId)) {
            return "";
        }
        return StringHelper.Format((String)"%1$s [%2$s]", (Object)this.message.getMSGFROMACCOUNTNAME(), (Object)this.message.getFROMMSGADDRESS());
    }

    public String GetMsgTO() {
        String strMsgTo = this.message.getMSGTO();
        if (!StringHelper.IsNullOrEmpty((String)strMsgTo)) {
            if (strMsgTo.indexOf("<?xml") == 0) {
                strMsgTo = this.ParseMsgAccountXML(strMsgTo);
            } else if (strMsgTo.length() > 50) {
                strMsgTo = String.valueOf(strMsgTo.substring(0, 49)) + "...";
            }
        }
        return strMsgTo;
    }

    public String GetMsgCC() {
        String strMsgCC = this.message.getMSGCC();
        if (!StringHelper.IsNullOrEmpty((String)strMsgCC)) {
            if (strMsgCC.indexOf("<?xml") == 0) {
                strMsgCC = this.ParseMsgAccountXML(strMsgCC);
            } else if (strMsgCC.length() > 50) {
                strMsgCC = String.valueOf(strMsgCC.substring(0, 49)) + "...";
            }
        }
        return strMsgCC;
    }

    public String ParseMsgAccountXML(String strXML) {
        String strDst = "";
        CodeListConfig codeListConfig = new CodeListConfig();
        XMLConfig.LoadFromXML((String)strXML, (XMLConfig)codeListConfig);
        if (codeListConfig.getCodeItems() != null) {
            int i = 0;
            while (i < codeListConfig.getCodeItems().size()) {
                CodeItemConfig codeItemConfig = (CodeItemConfig)codeListConfig.getCodeItems().get(i);
                if (!StringHelper.IsNullOrEmpty((String)strDst)) {
                    strDst = String.valueOf(strDst) + ";";
                }
                strDst = String.valueOf(strDst) + codeItemConfig.getText();
                ++i;
            }
        }
        return strDst;
    }

    public String GetMsgCONTENT() {
        return this.message.getCONTENT().replace("\r\n", "<br>");
    }

    public String GetMsgATTACHMENTS() {
        return this.strFileAttachmentsList;
    }

    public boolean IsMsgHasAttachments() {
        return !StringHelper.IsNullOrEmpty((String)this.strFileAttachmentsList);
    }

    public void UpdateReadFlag(IDEDataCtrl iDataCtrl) {
        Message tmpmessage = new Message();
        tmpmessage.setMESSAGEID(this.message.getMESSAGEID());
        tmpmessage.SetParamValue("ISREADFLAG", (Object)1);
        try {
            iDataCtrl.Save(false, (BaseDataEntity)tmpmessage);
        }
        catch (Exception exception) {
            // empty catch block
        }
    }
}

