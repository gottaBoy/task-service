/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Ctrl.BaseDEDataCtrl
 *  SA.SRFDA.Ctrl.IDEDataCtrl
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFramework.Base.XMLConfig
 *  SA.SRFramework.DataEx.BaseDataEntity
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  SA.SRFramework.UtilityEx.StringBuilderEx
 *  SA.SRFramework.XML.XMLNode
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.EAI.Ctrl.DataCtrl;

import SA.SRFDA.Ctrl.BaseDEDataCtrl;
import SA.SRFDA.Ctrl.IDEDataCtrl;
import SA.SRFDA.EAI.Ctrl.Data.EAIProcessConfig;
import SA.SRFDA.EAI.Ctrl.Data.EAIService;
import SA.SRFDA.EAI.Model.EAIBaseProcessConfig;
import SA.SRFDA.EAI.Model.EAIConfig;
import SA.SRFDA.EAI.Model.EAIProcessesConfig;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.Base.XMLConfig;
import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.UtilityEx.StringBuilderEx;
import SA.SRFramework.XML.XMLNode;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Vector;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class EAIServiceDataCtrl
extends BaseDEDataCtrl {
    private static final Log log = LogFactory.getLog(EAIServiceDataCtrl.class);

    public CallResult MarkAllServiceStop() {
        StringBuilderEx sql = new StringBuilderEx();
        sql.Append("UPDATE t_SRFEAISERVICE SET SERVICESTATUS='STOP'");
        return BaseDEDataCtrl.ExecuteWithoutResult((ISRFDAGlobalHelper)this.globalHelperEx, (String)sql.toString(), null);
    }

    public CallResult CopyDetail(BaseDataEntity dataEntity, Object srcKey) {
        CallResult callResult = super.CopyDetail(dataEntity, srcKey);
        if (callResult.IsError()) {
            return callResult;
        }
        EAIService eaiService = new EAIService();
        eaiService.Proxy(dataEntity);
        if (StringHelper.IsNullOrEmpty((String)eaiService.getSVRMODEL())) {
            return callResult;
        }
        XMLNode xmlNode = XMLNode.LoadFromXML((String)eaiService.getSVRMODEL());
        if (xmlNode == null) {
            return callResult;
        }
        XMLNode processesNode = xmlNode.GetChildNodeByNodeName(EAIProcessesConfig.TAG_EAIPROCESSES);
        if (processesNode == null) {
            return callResult;
        }
        IDEDataCtrl eaiProcessDataCtrl = this.globalHelperEx.getDAModelStorage().FindDEDataCtrlEx("EAI0010", (IDEDataCtrl)this);
        if (eaiProcessDataCtrl == null) {
            log.error((Object)StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u5b9e\u4f53[%1$s]\u6570\u636e\u64cd\u4f5c\u5bf9\u8c61", (Object)"EAI0010"));
            return callResult;
        }
        ArrayList childs = processesNode.getChildNodes();
        if (childs == null) {
            return callResult;
        }
        for (XMLNode processNode : childs) {
            String strProcessId = processNode.GetExtValue("PROCESSCONFIGID", "");
            if (StringHelper.IsNullOrEmpty((String)strProcessId)) continue;
            EAIProcessConfig eaiProcessConfig = new EAIProcessConfig();
            eaiProcessConfig.setEAIPROCESSCONFIGID(strProcessId);
            callResult = eaiProcessDataCtrl.Get((BaseDataEntity)eaiProcessConfig);
            if (callResult.IsError()) {
                log.error((Object)StringHelper.Format((String)"\u83b7\u53d6[%1$s][%2$s]\u6570\u636e\u5931\u8d25\uff0c%3$s", (Object)"EAI0010", (Object)strProcessId, (Object)callResult.getErrorInfo()));
                return callResult;
            }
            eaiProcessDataCtrl.RemoveUncopyValue((BaseDataEntity)eaiProcessConfig);
            callResult = eaiProcessDataCtrl.Save(true, (BaseDataEntity)eaiProcessConfig);
            if (callResult.IsError()) {
                log.error((Object)StringHelper.Format((String)"\u4fdd\u5b58[%1$s]\u6570\u636e\u5931\u8d25\uff0c%2$s", (Object)"EAI0010", (Object)callResult.getErrorInfo()));
                return callResult;
            }
            processNode.SetValue("PROCESSCONFIGID", eaiProcessConfig.getEAIPROCESSCONFIGID());
        }
        EAIService eaiService2 = new EAIService();
        eaiService2.setEAISERVICEID(eaiService.getEAISERVICEID());
        eaiService2.setSVRMODEL(XMLNode.Export((XMLNode)xmlNode));
        callResult = this.Save(false, eaiService2);
        if (callResult.IsError()) {
            log.error((Object)StringHelper.Format((String)"\u4fdd\u5b58[%1$s][%2$s]\u6570\u636e\u5931\u8d25\uff0c%3$s", (Object)"EAI0001", (Object)eaiService.getEAISERVICEID(), (Object)callResult.getErrorInfo()));
            return callResult;
        }
        eaiService.setSVRMODEL(eaiService2.getSVRMODEL());
        return callResult;
    }

    protected CallResult OnExport(BaseDataEntity baseDataEntity, Vector<XMLNode> list, boolean bFrameOnly) {
        CallResult callResult = super.OnExport(baseDataEntity, list, bFrameOnly);
        if (callResult.IsError()) {
            return callResult;
        }
        EAIService eaiService = new EAIService();
        eaiService.Proxy(baseDataEntity);
        if (StringHelper.IsNullOrEmpty((String)eaiService.getSVRMODEL())) {
            return callResult;
        }
        EAIConfig eaiConfig = new EAIConfig();
        if (!XMLConfig.LoadFromXML((String)eaiService.getSVRMODEL(), (XMLConfig)eaiConfig)) {
            callResult.setRetCode(1);
            callResult.setErrorInfo("\u52a0\u8f7d\u670d\u52a1\u6a21\u578b\u5931\u8d25");
            return callResult;
        }
        IDEDataCtrl eaiProcessDataCtrl = this.globalHelperEx.getDAModelStorage().FindDEDataCtrlEx("EAI0010", (IDEDataCtrl)this);
        if (eaiProcessDataCtrl == null) {
            log.error((Object)StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u5b9e\u4f53[%1$s]\u6570\u636e\u64cd\u4f5c\u5bf9\u8c61", (Object)"EAI0010"));
            return callResult;
        }
        Iterator iterator = eaiConfig.getProcessesConfig().iterator();
        while (iterator.hasNext()) {
            EAIBaseProcessConfig processConfig = (EAIBaseProcessConfig)((Object)iterator.next());
            if (StringHelper.IsNullOrEmpty((String)processConfig.getProcessConfigId())) continue;
            EAIProcessConfig eaiProcessConfig = new EAIProcessConfig();
            eaiProcessConfig.setEAIPROCESSCONFIGID(processConfig.getProcessConfigId());
            callResult = eaiProcessDataCtrl.Export((BaseDataEntity)eaiProcessConfig, list, true, bFrameOnly);
            if (!callResult.IsError()) continue;
            return callResult;
        }
        return callResult;
    }
}

