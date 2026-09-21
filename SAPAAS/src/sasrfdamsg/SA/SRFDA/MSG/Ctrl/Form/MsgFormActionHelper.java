/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Ctrl.Data.Message
 *  SA.SRFDA.Ctrl.Form.BaseDAFormActionHelper
 *  SA.SRFramework.Base.XMLConfig
 *  SA.SRFramework.CodeList.CodeItemConfig
 *  SA.SRFramework.CodeList.CodeListConfig
 *  SA.SRFramework.DataEx.BaseDataEntity
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  SA.SRFramework.WebEx.Form.SRFExFormItemErrors
 *  SA.SRFramework.WebEx.SRFExControl
 *  SA.SRFramework.XML.SimpleXMLWriter
 */
package SA.SRFDA.MSG.Ctrl.Form;

import SA.SRFDA.Ctrl.Data.Message;
import SA.SRFDA.Ctrl.Form.BaseDAFormActionHelper;
import SA.SRFramework.Base.XMLConfig;
import SA.SRFramework.CodeList.CodeItemConfig;
import SA.SRFramework.CodeList.CodeListConfig;
import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.WebEx.Form.SRFExFormItemErrors;
import SA.SRFramework.WebEx.SRFExControl;
import SA.SRFramework.XML.SimpleXMLWriter;
import java.util.TreeMap;

public class MsgFormActionHelper
extends BaseDAFormActionHelper {
    protected boolean bSendMsg = false;
    protected boolean bXMLAddress = false;

    protected boolean OnBeforeProcess() {
        if (!super.OnBeforeProcess()) {
            return false;
        }
        if (StringHelper.Compare((String)this.getWebContext().GetPostValue("srfsendmsg"), (String)"TRUE", (boolean)true) == 0) {
            this.bSendMsg = true;
        }
        this.bXMLAddress = this.getWebContext().getWebExConfig().GetValue("SRFMSG", "XMLADDRESS", false);
        return true;
    }

    protected void OnLoadActionFillForm(BaseDataEntity dataEntity) {
        Message message = new Message();
        dataEntity.CopyTo((BaseDataEntity)message, true);
        Message tmpmessage = new Message();
        tmpmessage.setMESSAGEID(message.getMESSAGEID());
        tmpmessage.SetParamValue("ISREADFLAG", (Object)1);
        try {
            this.getDEDataCtrl().Save(false, (BaseDataEntity)tmpmessage);
        }
        catch (Exception exception) {
            // empty catch block
        }
        String strMSGMODE = this.getWebContext().GetParamValue("MSGMODE");
        if (!StringHelper.IsNullOrEmpty((String)strMSGMODE)) {
            dataEntity.SetParamValue("MESSAGEID", (Object)"");
        }
        if (StringHelper.Compare((String)strMSGMODE, (String)"REPLY", (boolean)true) == 0) {
            if (this.bXMLAddress) {
                CodeListConfig codeListConfig = new CodeListConfig();
                if (!StringHelper.IsNullOrEmpty((String)message.getMSGFROMACCOUNTID())) {
                    CodeItemConfig codeItemConfig = new CodeItemConfig();
                    codeItemConfig.setValue(message.getMSGFROMACCOUNTID());
                    codeItemConfig.setText(message.getMSGFROMACCOUNTNAME());
                    codeListConfig.AddCodeItemConfig(codeItemConfig);
                }
                dataEntity.SetParamValue("MSGTO", (Object)this.ExportMsgAccountXML(codeListConfig));
            } else {
                dataEntity.SetParamValue("MSGTO", (Object)message.getFROMMSGADDRESS());
            }
            dataEntity.SetParamValue("MSGCC", (Object)"");
            dataEntity.SetParamValue("MESSAGENAME", (Object)("\u7b54\u590d\uff1a" + message.getMESSAGENAME()));
            dataEntity.SetParamValue("CONTENT", (Object)("\r\n\r\n---------------------------------------------------------------------------------\r\n" + message.getCONTENT()));
        } else if (StringHelper.Compare((String)strMSGMODE, (String)"ALLREPLY", (boolean)true) == 0) {
            if (this.bXMLAddress) {
                CodeListConfig codeListConfig = new CodeListConfig();
                if (!StringHelper.IsNullOrEmpty((String)message.getMSGFROMACCOUNTID())) {
                    CodeItemConfig codeItemConfig = new CodeItemConfig();
                    codeItemConfig.setValue(message.getMSGFROMACCOUNTID());
                    codeItemConfig.setText(message.getMSGFROMACCOUNTNAME());
                    codeListConfig.AddCodeItemConfig(codeItemConfig);
                }
                if (!StringHelper.IsNullOrEmpty((String)message.getMSGCC())) {
                    XMLConfig.LoadFromXML((String)message.getMSGCC(), (XMLConfig)codeListConfig);
                }
                if (!StringHelper.IsNullOrEmpty((String)message.getMSGTO())) {
                    XMLConfig.LoadFromXML((String)message.getMSGTO(), (XMLConfig)codeListConfig);
                }
                dataEntity.SetParamValue("MSGTO", (Object)this.ExportMsgAccountXML(codeListConfig));
            } else {
                dataEntity.SetParamValue("MSGTO", (Object)(String.valueOf(message.getFROMMSGADDRESS()) + ";" + message.getMSGCC() + ";" + message.getMSGTO()));
            }
            dataEntity.SetParamValue("MSGCC", (Object)"");
            dataEntity.SetParamValue("MESSAGENAME", (Object)("\u7b54\u590d\uff1a" + message.getMESSAGENAME()));
            dataEntity.SetParamValue("CONTENT", (Object)("\r\n\r\n---------------------------------------------------------------------------------\r\n" + message.getCONTENT()));
        } else if (StringHelper.Compare((String)strMSGMODE, (String)"TRANS", (boolean)true) == 0) {
            dataEntity.SetParamValue("MSGTO", (Object)"");
            dataEntity.SetParamValue("MSGCC", (Object)"");
            dataEntity.SetParamValue("MESSAGENAME", (Object)("\u8f6c\u53d1\uff1a" + message.getMESSAGENAME()));
        }
        super.OnLoadActionFillForm(dataEntity);
    }

    protected CallResult OnSaveActionBeforeInsert(BaseDataEntity dataEntity) {
        dataEntity.SetParamValue("MSGACCOUNTID", (Object)this.getWebContext().getCurUserId());
        dataEntity.SetParamValue("MSGFOLDER", (Object)"DRAFT");
        return super.OnSaveActionBeforeInsert(dataEntity);
    }

    protected boolean OnSaveActionFillDataEntity(BaseDataEntity dataEntity, SRFExFormItemErrors formItemErrors) {
        String strMsgTo;
        if (!super.OnSaveActionFillDataEntity(dataEntity, formItemErrors)) {
            return false;
        }
        if (this.bSendMsg && StringHelper.IsNullOrEmpty((String)(strMsgTo = dataEntity.GetParamStringValue("MSGTO", "")))) {
            SRFExControl msgToControl = this.form1.FindControl("MSGTO");
            if (msgToControl != null) {
                formItemErrors.Register(msgToControl, 1, "\u5fc5\u987b\u6307\u5b9a\u6536\u4ef6\u4eba");
            } else {
                formItemErrors.Register("", "", 1, "\u5fc5\u987b\u6307\u5b9a\u6536\u4ef6\u4eba");
            }
            return false;
        }
        return true;
    }

    protected CallResult OnSaveActionAfterInsert(CallResult callResult, BaseDataEntity dataEntity) {
        if ((callResult = super.OnSaveActionAfterInsert(callResult, dataEntity)).getRetCode() != 0) {
            return callResult;
        }
        if (this.bSendMsg && (callResult = this.SendMessage(callResult, dataEntity)).getRetCode() == 0) {
            this.AppendExtJSCode("alert('\u6d88\u606f\u53d1\u9001\u6210\u529f');window.close();");
        }
        return callResult;
    }

    protected CallResult OnSaveActionAfterUpdate(CallResult callResult, BaseDataEntity dataEntity) {
        if ((callResult = super.OnSaveActionAfterUpdate(callResult, dataEntity)).getRetCode() != 0) {
            return callResult;
        }
        if (this.bSendMsg && (callResult = this.SendMessage(callResult, dataEntity)).getRetCode() == 0) {
            this.AppendExtJSCode("alert('\u6d88\u606f\u53d1\u9001\u6210\u529f');window.close();");
        }
        return callResult;
    }

    protected CallResult SendMessage(CallResult callResult, BaseDataEntity dataEntity) {
        return this.getDEDataCtrl().CustomCall("SEND", dataEntity);
    }

    protected CallResult OnTestDataAction(BaseDataEntity dataEntity, String strAction) {
        return new CallResult();
    }

    protected String ExportMsgAccountXML(CodeListConfig codeListConfig) {
        if (codeListConfig.getCodeItems() == null || codeListConfig.getCodeItems().size() == 0) {
            return "";
        }
        TreeMap<String, Integer> accMap = new TreeMap<String, Integer>();
        StringBuilder sb = new StringBuilder();
        SimpleXMLWriter xmlWriter = new SimpleXMLWriter(sb);
        xmlWriter.WriteRaw("<?xml version=\"1.0\" encoding=\"utf-8\" ?>");
        xmlWriter.WriteStartElement("SRFEXCODELIST");
        if (codeListConfig.getCodeItems() != null) {
            int i = 0;
            while (i < codeListConfig.getCodeItems().size()) {
                CodeItemConfig codeItemConfig = (CodeItemConfig)codeListConfig.getCodeItems().get(i);
                if (!accMap.containsKey(codeItemConfig.getValue())) {
                    xmlWriter.WriteStartElement("SRFEXCODEITEM");
                    xmlWriter.WriteAttributeString("TEXT", codeItemConfig.getText());
                    xmlWriter.WriteAttributeString("VALUE", codeItemConfig.getValue());
                    xmlWriter.WriteEndElement();
                    accMap.put(codeItemConfig.getValue(), 0);
                }
                ++i;
            }
        }
        xmlWriter.WriteEndElement();
        return sb.toString();
    }
}

