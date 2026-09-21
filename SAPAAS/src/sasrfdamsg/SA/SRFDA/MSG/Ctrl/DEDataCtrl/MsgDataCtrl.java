/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Ctrl.BaseDEDataCtrl
 *  SA.SRFDA.Ctrl.Data.Message
 *  SA.SRFDA.Ctrl.Data.MsgAccount
 *  SA.SRFDA.Ctrl.IDEDataCtrl
 *  SA.SRFramework.Base.XMLConfig
 *  SA.SRFramework.CodeList.CodeItemConfig
 *  SA.SRFramework.CodeList.CodeListConfig
 *  SA.SRFramework.DataEx.BaseDataEntity
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.Helper
 *  SA.SRFramework.Utility.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.MSG.Ctrl.DEDataCtrl;

import SA.SRFDA.Ctrl.BaseDEDataCtrl;
import SA.SRFDA.Ctrl.Data.Message;
import SA.SRFDA.Ctrl.Data.MsgAccount;
import SA.SRFDA.Ctrl.IDEDataCtrl;
import SA.SRFramework.Base.XMLConfig;
import SA.SRFramework.CodeList.CodeItemConfig;
import SA.SRFramework.CodeList.CodeListConfig;
import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.Helper;
import SA.SRFramework.Utility.StringHelper;
import java.sql.Timestamp;
import java.util.Date;
import java.util.Vector;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class MsgDataCtrl
extends BaseDEDataCtrl {
    public static final String TAG_CUSTOMCALL_SEND = "SEND";
    public static final String TAG_CUSTOMCALL_MSGREMOVE = "REMOVEMSG";
    private static final Log log = LogFactory.getLog(MsgDataCtrl.class);

    protected CallResult OnCustomCall(String strCallName, BaseDataEntity dataEntity) {
        if (StringHelper.Compare((String)strCallName, (String)TAG_CUSTOMCALL_SEND, (boolean)true) == 0) {
            return this.Send(dataEntity);
        }
        if (StringHelper.Compare((String)strCallName, (String)TAG_CUSTOMCALL_MSGREMOVE, (boolean)true) == 0) {
            return this.RemoveMsg(dataEntity);
        }
        return super.OnCustomCall(strCallName, dataEntity);
    }

    public CallResult RemoveMsg(BaseDataEntity dataEntity) {
        CallResult callResult = new CallResult();
        Message message = null;
        if (dataEntity instanceof Message) {
            message = (Message)dataEntity;
        } else {
            message = new Message();
            dataEntity.CopyTo((BaseDataEntity)message, true);
        }
        message.setMSGFOLDER("REMOVE");
        callResult = this.Save(false, (BaseDataEntity)message);
        if (callResult.getRetCode() != 0) {
            callResult.setErrorInfo(StringHelper.Format((String)"\u5220\u9664\u6d88\u606f\u9519\u8bef\uff1a%1$s", (Object)callResult.getErrorInfo()));
            return callResult;
        }
        return callResult;
    }

    protected CallResult Send(BaseDataEntity dataEntity) {
        String strMsgFromAccountId;
        String strMsgCC;
        int i;
        CallResult callResult = this.Get(dataEntity);
        Date recvDate = new Date();
        String strMsgFolder = dataEntity.GetParamStringValue("MSGFOLDER", "");
        if (StringHelper.Compare((String)strMsgFolder, (String)"DRAFT", (boolean)true) != 0) {
            callResult.setRetCode(5);
            callResult.setErrorInfo(StringHelper.Format((String)"\u5fc5\u987b\u662f\u8349\u7a3f\u7bb1\u7684\u6d88\u606f\u624d\u80fd\u53d1\u9001"));
            return callResult;
        }
        IDEDataCtrl msgAccDataCtrl = this.globalHelperEx.getDAModelStorage().FindDEDataCtrl("DE0070", this.getWebContext());
        if (msgAccDataCtrl == null) {
            callResult.setRetCode(1);
            callResult.setErrorInfo(StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u6d88\u606f\u5e10\u6237\u6570\u636e\u5bf9\u8c61"));
            return callResult;
        }
        String strMsgTO = dataEntity.GetParamStringValue("MSGTO", "");
        if (StringHelper.IsNullOrEmpty((String)strMsgTO)) {
            callResult.setRetCode(5);
            callResult.setErrorInfo(StringHelper.Format((String)"\u6ca1\u6709\u6307\u5b9a\u6d88\u606f\u6536\u4ef6\u4eba"));
            return callResult;
        }
        Vector<MsgAccount> msgAccountList = new Vector<MsgAccount>();
        if (strMsgTO.indexOf("<?xml") == 0) {
            CodeListConfig codeListConfig = new CodeListConfig();
            XMLConfig.LoadFromXML((String)strMsgTO, (XMLConfig)codeListConfig);
            if (codeListConfig.getCodeItems() != null) {
                i = 0;
                while (i < codeListConfig.getCodeItems().size()) {
                    CodeItemConfig codeItemConfig = (CodeItemConfig)codeListConfig.getCodeItems().get(i);
                    MsgAccount msgAccount = new MsgAccount();
                    msgAccount.setMSGACCOUNTID(codeItemConfig.getValue());
                    msgAccount.setMSGACCOUNTNAME(codeItemConfig.getText());
                    msgAccountList.add(msgAccount);
                    ++i;
                }
            }
        } else {
            String[] msgtos = strMsgTO.split("[;]");
            i = 0;
            while (i < msgtos.length) {
                String strAddress = msgtos[i];
                if (!StringHelper.IsNullOrEmpty((String)(strAddress = strAddress.trim()))) {
                    MsgAccount accCond = new MsgAccount();
                    accCond.setMSGADDRESS(strAddress);
                    callResult = msgAccDataCtrl.CustomCall("GETBYADDRESS", (BaseDataEntity)accCond);
                    if (callResult.getRetCode() != 0) {
                        log.error((Object)StringHelper.Format((String)"\u67e5\u8be2\u6d88\u606f\u8d26\u6237[%1$s]\u5931\u8d25\uff0c%2$s", (Object)accCond, (Object)callResult.getErrorInfo()));
                        callResult.setErrorInfo(StringHelper.Format((String)"\u67e5\u8be2\u6d88\u606f\u8d26\u6237[%1$s]\u5931\u8d25", (Object)accCond.getMSGADDRESS()));
                        return callResult;
                    }
                    msgAccountList.add(accCond);
                }
                ++i;
            }
        }
        if (!StringHelper.IsNullOrEmpty((String)(strMsgCC = dataEntity.GetParamStringValue("MSGCC", "")))) {
            if (strMsgCC.indexOf("<?xml") == 0) {
                CodeListConfig codeListConfig = new CodeListConfig();
                XMLConfig.LoadFromXML((String)strMsgCC, (XMLConfig)codeListConfig);
                if (codeListConfig.getCodeItems() != null) {
                    int i2 = 0;
                    while (i2 < codeListConfig.getCodeItems().size()) {
                        CodeItemConfig codeItemConfig = (CodeItemConfig)codeListConfig.getCodeItems().get(i2);
                        MsgAccount msgAccount = new MsgAccount();
                        msgAccount.setMSGACCOUNTID(codeItemConfig.getValue());
                        msgAccount.setMSGACCOUNTNAME(codeItemConfig.getText());
                        msgAccountList.add(msgAccount);
                        ++i2;
                    }
                }
            } else {
                String[] msgccs = strMsgCC.split("[;]");
                int i3 = 0;
                while (i3 < msgccs.length) {
                    String strAddress = msgccs[i3];
                    if (!StringHelper.IsNullOrEmpty((String)(strAddress = strAddress.trim()))) {
                        MsgAccount accCond = new MsgAccount();
                        accCond.setMSGADDRESS(strAddress);
                        callResult = msgAccDataCtrl.CustomCall("GETBYADDRESS", (BaseDataEntity)accCond);
                        if (callResult.getRetCode() != 0) {
                            log.error((Object)StringHelper.Format((String)"\u67e5\u8be2\u6d88\u606f\u8d26\u6237[%1$s]\u5931\u8d25\uff0c%2$s", (Object)accCond, (Object)callResult.getErrorInfo()));
                            callResult.setErrorInfo(StringHelper.Format((String)"\u67e5\u8be2\u6d88\u606f\u8d26\u6237[%1$s]\u5931\u8d25", (Object)accCond));
                            return callResult;
                        }
                        msgAccountList.add(accCond);
                    }
                    ++i3;
                }
            }
        }
        if (StringHelper.Compare((String)(strMsgFromAccountId = dataEntity.GetParamStringValue("MSGFROMACCOUNTID", "")), (String)"", (boolean)true) == 0) {
            strMsgFromAccountId = this.getWebContext().getCurUserId();
        }
        for (MsgAccount msgAccount : msgAccountList) {
            Message newMessage = new Message();
            dataEntity.CopyTo((BaseDataEntity)newMessage, true);
            newMessage.setMESSAGEID(Helper.GenGuidEx());
            newMessage.setMSGFOLDER("INBOX");
            newMessage.setMSGACCOUNTID(msgAccount.getMSGACCOUNTID());
            newMessage.setMSGFROMACCOUNTID(strMsgFromAccountId);
            newMessage.SetParamValue("RECVTIME", (Object)new Timestamp(recvDate.getTime()));
            newMessage.RemoveParam("ISREADFLAG");
            newMessage.SetParamValue("SENDTIME", (Object)new Timestamp(recvDate.getTime()));
            callResult = this.Save(true, (BaseDataEntity)newMessage);
            if (callResult.getRetCode() == 0) continue;
            callResult.setErrorInfo(StringHelper.Format((String)"\u53d1\u9001\u6d88\u606f\u5931\u8d25\uff0c%1$s", (Object)callResult.getErrorInfo()));
            log.error((Object)callResult.getErrorInfo());
            return callResult;
        }
        Message message = new Message();
        message.setMESSAGEID(dataEntity.GetParamStringValue("MESSAGEID", ""));
        message.setMSGFOLDER("SENDED");
        message.SetParamValue("SENDTIME", (Object)new Timestamp(recvDate.getTime()));
        callResult = this.Save(false, (BaseDataEntity)message);
        if (callResult.getRetCode() != 0) {
            callResult.setErrorInfo(StringHelper.Format((String)"\u66f4\u65b0\u6d88\u606f\u72b6\u6001\u5931\u8d25\uff0c%1$s", (Object)callResult.getErrorInfo()));
            log.error((Object)callResult.getErrorInfo());
            return callResult;
        }
        message.CopyTo(dataEntity, true);
        return callResult;
    }
}

