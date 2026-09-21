/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Ctrl.DEDataCtrl.Model.DEDCBaseProcessConfig
 *  SA.SRFDA.Ctrl.Data.MsgSendQueue
 *  SA.SRFDA.Ctrl.Data.MsgTemplate
 *  SA.SRFDA.Ctrl.IDEDataCtrl
 *  SA.SRFDA.Ctrl.IDEDataCtrlEngineContext
 *  SA.SRFDA.Ctrl.Utility.MacroHelper
 *  SA.SRFDA.DEDC.Ctrl.DEDCProcess
 *  SA.SRFDA.Web.ISRFDAWebContext
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFramework.DataEx.BaseDataEntity
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 */
package SA.SRFDA.DEDC.Ctrl;

import SA.SRFDA.Ctrl.DEDataCtrl.Model.DEDCBaseProcessConfig;
import SA.SRFDA.Ctrl.Data.MsgSendQueue;
import SA.SRFDA.Ctrl.Data.MsgTemplate;
import SA.SRFDA.Ctrl.IDEDataCtrl;
import SA.SRFDA.Ctrl.IDEDataCtrlEngineContext;
import SA.SRFDA.Ctrl.Utility.MacroHelper;
import SA.SRFDA.DEDC.Ctrl.DEDCProcess;
import SA.SRFDA.MSG.Ctrl.MsgTemplateHelper;
import SA.SRFDA.Web.ISRFDAWebContext;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import java.util.Vector;

public class DEDCSendMsgProcess
extends DEDCProcess {
    public CallResult Execute(IDEDataCtrlEngineContext dedcContext, DEDCBaseProcessConfig processConfig) {
        IDEDataCtrl msqDataCtrl;
        String strFileAt4;
        String strFileAt3;
        String strFileAt2;
        String strFileAt;
        MsgSendQueue msq;
        CallResult callResult = super.Execute(dedcContext, processConfig);
        if (callResult.IsError()) {
            return callResult;
        }
        String strSrcDataEntity = processConfig.getDEDCProcess().getSRCDATAENTITY();
        BaseDataEntity srcDataEntity = null;
        srcDataEntity = dedcContext.GetDataEntity(strSrcDataEntity);
        if (srcDataEntity == null) {
            callResult.setRetCode(5);
            callResult.setErrorInfo(StringHelper.Format((String)"\u6307\u5b9a\u6e90\u6570\u636e\u5bf9\u8c61[%1$s]\u65e0\u6548", (Object)strSrcDataEntity));
            return callResult;
        }
        dedcContext.DebugOutput((Object)this, StringHelper.Format((String)"\u6e90\u6570\u636e\u5bf9\u8c61[%1$s]", (Object)strSrcDataEntity));
        String strMsgTemplateId = processConfig.getDEDCProcess().getPARAM1();
        if (StringHelper.IsNullOrEmpty((String)strMsgTemplateId)) {
            callResult.setRetCode(5);
            callResult.setErrorInfo(StringHelper.Format((String)"\u6ca1\u6709\u6307\u5b9a\u6d88\u606f\u6a21\u677f\u7f16\u53f7"));
            return callResult;
        }
        dedcContext.DebugOutput((Object)this, StringHelper.Format((String)"\u6d88\u606f\u6a21\u677f[%1$s]", (Object)strMsgTemplateId));
        IDEDataCtrl iMsgTemplateDataCtrl = dedcContext.GetGlobalHelper().getDAModelStorage().FindDEDataCtrl("DE0076", dedcContext.GetPersonId(), dedcContext.GetWebContext());
        if (iMsgTemplateDataCtrl == null) {
            callResult.setRetCode(1);
            callResult.setErrorInfo(StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u5b9e\u4f53[%1$s]\u6570\u636e\u8bbf\u95ee\u5bf9\u8c61", (Object)"DE0076"));
            return callResult;
        }
        MsgTemplate msgTemplate = new MsgTemplate();
        msgTemplate.setMSGTEMPLATEID(strMsgTemplateId);
        callResult = iMsgTemplateDataCtrl.Get((BaseDataEntity)msgTemplate);
        if (callResult.IsError()) {
            callResult.setErrorInfo(StringHelper.Format((String)"\u83b7\u53d6\u6307\u5b9a\u6d88\u606f\u6a21\u677f[%1$s]\u5931\u8d25\uff0c%2$s", (Object)strMsgTemplateId, (Object)callResult.getErrorInfo()));
            dedcContext.Log(1, (Object)this, callResult.getErrorInfo());
            return callResult;
        }
        BaseDataEntity dstDataEntity = new BaseDataEntity();
        srcDataEntity.CopyTo(dstDataEntity, true);
        callResult = this.FillDataEntity(dedcContext, processConfig, srcDataEntity, dstDataEntity);
        if (callResult.IsError()) {
            callResult.setErrorInfo(StringHelper.Format((String)"\u586b\u5145\u76ee\u6807\u5b9e\u4f53\u5c5e\u6027\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
            dedcContext.Log(1, (Object)this, callResult.getErrorInfo());
            return callResult;
        }
        String strUserList = DEDCSendMsgProcess.GetUserList(processConfig.getDEDCProcess().getPARAM4(), dedcContext, dstDataEntity);
        String strAddressList = DEDCSendMsgProcess.GetUserList(processConfig.getDEDCProcess().getPARAM5(), dedcContext, dstDataEntity);
        dedcContext.DebugOutput(null, StringHelper.Format((String)"\u76ee\u6807\u8d26\u6237\u5217\u8868[%1$s]", (Object)strUserList));
        dedcContext.DebugOutput(null, StringHelper.Format((String)"\u76ee\u6807\u5730\u5740\u5217\u8868[%1$s]", (Object)strAddressList));
        if (StringHelper.IsNullOrEmpty((String)strUserList) && StringHelper.IsNullOrEmpty((String)strAddressList)) {
            callResult.setRetCode(5);
            callResult.setErrorInfo("\u6ca1\u6709\u6307\u5b9a\u6d88\u606f\u76ee\u6807\u7528\u6237\u53ca\u6d88\u606f\u76ee\u6807\u5730\u5740");
            dedcContext.Log(1, (Object)this, callResult.getErrorInfo());
            return callResult;
        }
        Vector<MsgSendQueue> msqs = new Vector<MsgSendQueue>();
        if ((processConfig.getDEDCProcess().getPARAM7() & 1) != 0) {
            callResult = MsgTemplateHelper.GetMsgSendQueue(1, msgTemplate, dstDataEntity, dedcContext.GetGlobalHelper(), dedcContext.GetWebContext(), null, dedcContext.GetPersonId());
            if (callResult.IsError()) {
                return callResult;
            }
            msq = (MsgSendQueue)callResult.getUserObject();
            strFileAt = processConfig.getDEDCProcess().getPARAM11();
            strFileAt2 = processConfig.getDEDCProcess().getPARAM12();
            strFileAt3 = processConfig.getDEDCProcess().getPARAM13();
            strFileAt4 = processConfig.getDEDCProcess().getPARAM14();
            if (!StringHelper.IsNullOrEmpty((String)strFileAt)) {
                msq.setFILEAT(srcDataEntity.GetParamStringValue(strFileAt, null));
            }
            if (!StringHelper.IsNullOrEmpty((String)strFileAt2)) {
                msq.setFILEAT2(srcDataEntity.GetParamStringValue(strFileAt2, null));
            }
            if (!StringHelper.IsNullOrEmpty((String)strFileAt3)) {
                msq.setFILEAT3(srcDataEntity.GetParamStringValue(strFileAt3, null));
            }
            if (!StringHelper.IsNullOrEmpty((String)strFileAt4)) {
                msq.setFILEAT4(srcDataEntity.GetParamStringValue(strFileAt4, null));
            }
            msqs.add(msq);
        }
        if ((processConfig.getDEDCProcess().getPARAM7() & 2) != 0) {
            callResult = MsgTemplateHelper.GetMsgSendQueue(2, msgTemplate, dstDataEntity, dedcContext.GetGlobalHelper(), dedcContext.GetWebContext(), null, dedcContext.GetPersonId());
            if (callResult.IsError()) {
                return callResult;
            }
            msq = (MsgSendQueue)callResult.getUserObject();
            strFileAt = processConfig.getDEDCProcess().getPARAM11();
            strFileAt2 = processConfig.getDEDCProcess().getPARAM12();
            strFileAt3 = processConfig.getDEDCProcess().getPARAM13();
            strFileAt4 = processConfig.getDEDCProcess().getPARAM14();
            if (!StringHelper.IsNullOrEmpty((String)strFileAt)) {
                msq.setFILEAT(srcDataEntity.GetParamStringValue(strFileAt, null));
            }
            if (!StringHelper.IsNullOrEmpty((String)strFileAt2)) {
                msq.setFILEAT2(srcDataEntity.GetParamStringValue(strFileAt2, null));
            }
            if (!StringHelper.IsNullOrEmpty((String)strFileAt3)) {
                msq.setFILEAT3(srcDataEntity.GetParamStringValue(strFileAt3, null));
            }
            if (!StringHelper.IsNullOrEmpty((String)strFileAt4)) {
                msq.setFILEAT4(srcDataEntity.GetParamStringValue(strFileAt4, null));
            }
            msqs.add(msq);
        }
        if ((processConfig.getDEDCProcess().getPARAM7() & 4) != 0) {
            callResult = MsgTemplateHelper.GetMsgSendQueue(4, msgTemplate, dstDataEntity, dedcContext.GetGlobalHelper(), dedcContext.GetWebContext(), null, dedcContext.GetPersonId());
            if (callResult.IsError()) {
                return callResult;
            }
            msq = (MsgSendQueue)callResult.getUserObject();
            msqs.add(msq);
        }
        if ((msqDataCtrl = dedcContext.GetGlobalHelper().getDAModelStorage().FindDEDataCtrl("DE0077", dedcContext.GetPersonId(), dedcContext.GetWebContext())) == null) {
            callResult.setRetCode(1);
            callResult.setErrorInfo(StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u5b9e\u4f53[%1$s]\u6570\u636e\u8bbf\u95ee\u5bf9\u8c61", (Object)"DE0077"));
            return callResult;
        }
        for (MsgSendQueue msq2 : msqs) {
            msq2.setDSTUSERS(strUserList);
            msq2.setDSTADDRESSES(strAddressList);
            callResult = msqDataCtrl.Save(true, (BaseDataEntity)msq2);
            if (!callResult.IsError()) continue;
            return callResult;
        }
        return callResult;
    }

    private static String GetUserList(String strList, IDEDataCtrlEngineContext dedcContext, BaseDataEntity dataEntity) {
        String strRet = "";
        strList = strList.replace("\r\n", ";");
        strList = strList.replace("\r", ";");
        strList = strList.replace("\n", ";");
        String[] users = strList.split("[;]");
        int i = 0;
        while (i < users.length) {
            CallResult callResult = MacroHelper.GetValue((String)users[i], (ISRFDAWebContext)dedcContext.GetWebContext(), (ISRFDAGlobalHelper)dedcContext.GetGlobalHelper(), (String)dedcContext.GetPersonId(), (BaseDataEntity)dataEntity);
            if (callResult.IsError()) {
                dedcContext.Log(4, (Object)dedcContext, StringHelper.Format((String)"\u65e0\u6cd5\u5b8f\u53d8\u91cf[%1$s]", (Object)users[i]));
            } else {
                if (!StringHelper.IsNullOrEmpty((String)strRet)) {
                    strRet = String.valueOf(strRet) + ";";
                }
                strRet = String.valueOf(strRet) + callResult.getUserObject().toString();
                dedcContext.DebugOutput(null, StringHelper.Format((String)"\u8ba1\u7b97\u5b8f\u53d8\u91cf[%1$s]\u503c\u4e3a[%2$s]", (Object)users[i], (Object)callResult.getUserObject().toString()));
            }
            ++i;
        }
        return strRet;
    }
}

