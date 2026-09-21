/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Ctrl.BaseDEDataCtrl
 *  SA.SRFDA.Ctrl.DEDataCtrl.Model.DEDCBaseProcessConfig
 *  SA.SRFDA.Ctrl.DEDataCtrl.Model.DEDCProcessesConfig
 *  SA.SRFDA.Ctrl.Data.DEDCProcess
 *  SA.SRFDA.Ctrl.IDEDataCtrl
 *  SA.SRFramework.DataEx.BaseDataEntity
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  SA.SRFramework.XML.XMLNode
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.BR.Ctrl.DEDataCtrl;

import SA.SRFDA.BR.Ctrl.Data.BRAction;
import SA.SRFDA.Ctrl.BaseDEDataCtrl;
import SA.SRFDA.Ctrl.DEDataCtrl.Model.DEDCBaseProcessConfig;
import SA.SRFDA.Ctrl.DEDataCtrl.Model.DEDCProcessesConfig;
import SA.SRFDA.Ctrl.Data.DEDCProcess;
import SA.SRFDA.Ctrl.IDEDataCtrl;
import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.XML.XMLNode;
import java.util.ArrayList;
import java.util.Vector;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class BRActionDataCtrl
extends BaseDEDataCtrl {
    private static final Log log = LogFactory.getLog(BRActionDataCtrl.class);

    public CallResult CopyDetail(BaseDataEntity dataEntity, Object srcKey) {
        CallResult callResult = super.CopyDetail(dataEntity, srcKey);
        if (callResult.IsError()) {
            return callResult;
        }
        BRAction brAction = new BRAction();
        brAction.Proxy(dataEntity);
        if (StringHelper.IsNullOrEmpty((String)brAction.getACTIONMODEL())) {
            return callResult;
        }
        XMLNode xmlNode = XMLNode.LoadFromXML((String)brAction.getACTIONMODEL());
        if (xmlNode == null) {
            return callResult;
        }
        XMLNode processesNode = xmlNode.GetChildNodeByNodeName(DEDCProcessesConfig.TAG_DEDCPROCESSES);
        if (processesNode == null) {
            return callResult;
        }
        IDEDataCtrl dedcProcessDataCtrl = this.globalHelperEx.getDAModelStorage().FindDEDataCtrlEx("DE0211", (IDEDataCtrl)this);
        if (dedcProcessDataCtrl == null) {
            log.error((Object)StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u5b9e\u4f53[%1$s]\u6570\u636e\u64cd\u4f5c\u5bf9\u8c61", (Object)"DE0211"));
            return callResult;
        }
        ArrayList childs = processesNode.getChildNodes();
        if (childs == null) {
            return callResult;
        }
        for (XMLNode processNode : childs) {
            String strProcessId = processNode.GetExtValue("PROCESSCONFIGID", "");
            if (StringHelper.IsNullOrEmpty((String)strProcessId)) continue;
            DEDCProcess dedcProcess = new DEDCProcess();
            dedcProcess.setDEDCPROCESSID(strProcessId);
            callResult = dedcProcessDataCtrl.Get((BaseDataEntity)dedcProcess);
            if (callResult.IsError()) {
                log.error((Object)StringHelper.Format((String)"\u83b7\u53d6[%1$s][%2$s]\u6570\u636e\u5931\u8d25\uff0c%3$s", (Object)"DE0211", (Object)strProcessId, (Object)callResult.getErrorInfo()));
                return callResult;
            }
            dedcProcessDataCtrl.RemoveUncopyValue((BaseDataEntity)dedcProcess);
            callResult = dedcProcessDataCtrl.Save(true, (BaseDataEntity)dedcProcess);
            if (callResult.IsError()) {
                log.error((Object)StringHelper.Format((String)"\u4fdd\u5b58[%1$s]\u6570\u636e\u5931\u8d25\uff0c%2$s", (Object)"DE0211", (Object)callResult.getErrorInfo()));
                return callResult;
            }
            processNode.SetValue("PROCESSCONFIGID", dedcProcess.getDEDCPROCESSID());
        }
        BRAction brAction2 = new BRAction();
        brAction2.setBRACTIONID(brAction.getBRACTIONID());
        brAction2.setACTIONMODEL(XMLNode.Export((XMLNode)xmlNode));
        callResult = this.Save(false, brAction2);
        if (callResult.IsError()) {
            log.error((Object)StringHelper.Format((String)"\u4fdd\u5b58[%1$s][%2$s]\u6570\u636e\u5931\u8d25\uff0c%3$s", (Object)"BR0003", (Object)brAction.getBRACTIONID(), (Object)callResult.getErrorInfo()));
            return callResult;
        }
        brAction.setACTIONMODEL(brAction2.getACTIONMODEL());
        return callResult;
    }

    protected CallResult OnExport(BaseDataEntity baseDataEntity, Vector<XMLNode> list, boolean bFrameOnly) {
        CallResult callResult = super.OnExport(baseDataEntity, list, bFrameOnly);
        if (callResult.IsError()) {
            return callResult;
        }
        BRAction brAction = new BRAction();
        brAction.Proxy(baseDataEntity);
        if (brAction.getDEDCConfig() == null) {
            return callResult;
        }
        IDEDataCtrl dedcProcessDataCtrl = this.globalHelperEx.getDAModelStorage().FindDEDataCtrlEx("DE0211", (IDEDataCtrl)this);
        if (dedcProcessDataCtrl == null) {
            log.error((Object)StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u5b9e\u4f53[%1$s]\u6570\u636e\u64cd\u4f5c\u5bf9\u8c61", (Object)"DE0211"));
            return callResult;
        }
        for (DEDCBaseProcessConfig processConfig : brAction.getDEDCConfig().getProcessesConfig()) {
            if (StringHelper.IsNullOrEmpty((String)processConfig.getProcessConfigId())) continue;
            DEDCProcess dedcProcess = new DEDCProcess();
            dedcProcess.setDEDCPROCESSID(processConfig.getProcessConfigId());
            callResult = dedcProcessDataCtrl.Export((BaseDataEntity)dedcProcess, list, true, bFrameOnly);
            if (!callResult.IsError()) continue;
            return callResult;
        }
        return callResult;
    }
}

