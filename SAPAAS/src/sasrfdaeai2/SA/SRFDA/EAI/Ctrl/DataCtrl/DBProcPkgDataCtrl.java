/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Ctrl.Data.DERINDEX
 *  SA.SRFDA.Ctrl.IDEDataCtrl
 *  SA.SRFramework.DataEx.BaseDataEntity
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  SA.SRFramework.XML.XMLNode
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.EAI.Ctrl.DataCtrl;

import SA.SRFDA.Ctrl.Data.DERINDEX;
import SA.SRFDA.Ctrl.IDEDataCtrl;
import SA.SRFDA.EAI.Ctrl.DataCtrl.DBOPPKGDataCtrl;
import SA.SRFDA.EAI.Data.DBOPProc;
import SA.SRFDA.EAI.Data.DBProcPkg;
import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.XML.XMLNode;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Vector;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class DBProcPkgDataCtrl
extends DBOPPKGDataCtrl {
    private static final Log log = LogFactory.getLog(DBProcPkgDataCtrl.class);

    @Override
    public CallResult CopyDetail(BaseDataEntity dataEntity, Object srcKey) {
        CallResult callResult = new CallResult();
        DBProcPkg deDataCtrl = new DBProcPkg();
        deDataCtrl.Proxy(dataEntity);
        try {
            String strModel = DBProcPkgDataCtrl.ClonePkgProcModel(deDataCtrl.getPROCMODEL(), this);
            DBProcPkg deDataCtrl2 = new DBProcPkg();
            deDataCtrl2.setEAIDBPROCPKGID(deDataCtrl.getEAIDBPROCPKGID());
            deDataCtrl2.setPROCMODEL(strModel);
            callResult = this.Save(false, deDataCtrl2);
            if (callResult.IsError()) {
                log.error((Object)StringHelper.Format((String)"\u4fdd\u5b58[%1$s][%2$s]\u6570\u636e\u5931\u8d25\uff0c%3$s", (Object)"EAI0064", (Object)deDataCtrl.getEAIDBPROCPKGID(), (Object)callResult.getErrorInfo()));
                return callResult;
            }
            deDataCtrl.setPROCMODEL(deDataCtrl2.getPROCMODEL());
        }
        catch (Exception ex) {
            callResult.setRetCode(1);
            callResult.setErrorInfo(ex.getMessage());
        }
        return callResult;
    }

    @Override
    public CallResult OnExport(BaseDataEntity baseDataEntity, Vector<XMLNode> list, boolean bFrameOnly) {
        CallResult callResult = super.OnExport(baseDataEntity, list, bFrameOnly);
        if (callResult.IsError()) {
            return callResult;
        }
        DBProcPkg deDataCtrl = new DBProcPkg();
        deDataCtrl.Proxy(baseDataEntity);
        XMLNode xmlNode = XMLNode.LoadFromXML((String)deDataCtrl.getPROCMODEL());
        if (xmlNode == null) {
            return callResult;
        }
        XMLNode processesNode = xmlNode.GetChildNodeByNodeName("SRFDBOPPROCS");
        if (processesNode == null) {
            return callResult;
        }
        IDEDataCtrl dbopProcDataCtrl = this.globalHelperEx.getDAModelStorage().FindDEDataCtrlEx("EAI0060", (IDEDataCtrl)this);
        if (dbopProcDataCtrl == null) {
            log.error((Object)StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u5b9e\u4f53[%1$s]\u6570\u636e\u64cd\u4f5c\u5bf9\u8c61", (Object)"EAI0060"));
            return callResult;
        }
        ArrayList childs = processesNode.getChildNodes();
        if (childs == null) {
            return callResult;
        }
        Vector indexList = dbopProcDataCtrl.GetDEHelper().GetDERINDEXs(true);
        Hashtable<String, IDEDataCtrl> indexTable = new Hashtable<String, IDEDataCtrl>();
        for (DERINDEX dERINDEX : indexList) {
            IDEDataCtrl ctrl = this.globalHelperEx.getDAModelStorage().FindDEDataCtrlEx(dERINDEX.getDEID(), (IDEDataCtrl)this);
            if (ctrl == null) {
                log.error((Object)StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u5b9e\u4f53[%1$s]\u6570\u636e\u64cd\u4f5c\u5bf9\u8c61", (Object)dERINDEX.getDEID()));
                callResult.setRetCode(1);
                return callResult;
            }
            indexTable.put(dERINDEX.getTYPEVALUE(), ctrl);
        }
        for (XMLNode processNode : childs) {
            String strProcessId = processNode.GetExtValue("PROCESSCONFIG", "");
            if (StringHelper.IsNullOrEmpty((String)strProcessId)) continue;
            DBOPProc procDE = new DBOPProc();
            procDE.setEAIDBOPPROCID(strProcessId);
            dbopProcDataCtrl.Get((BaseDataEntity)procDE);
            IDEDataCtrl realDataCtrl = (IDEDataCtrl)indexTable.get(procDE.getEAIDBOPPROCTYPE());
            BaseDataEntity baseDE = new BaseDataEntity();
            baseDE.SetParamValue(realDataCtrl.GetDEHelper().GetKeyDEFHelper().getName(), (Object)procDE.getEAIDBOPPROCID());
            callResult = realDataCtrl.Export(baseDE, list, true, bFrameOnly);
            if (!callResult.IsError()) continue;
            return callResult;
        }
        return callResult;
    }
}

