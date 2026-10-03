package SA.SRFDA.EAI.Ctrl.DataCtrl;

import SA.SRFDA.Ctrl.BaseDEDataCtrl;
import SA.SRFDA.Ctrl.Data.DERINDEX;
import SA.SRFDA.Ctrl.IDEDataCtrl;
import SA.SRFDA.EAI.Ctrl.DBOPPKGFactory;
import SA.SRFDA.EAI.Data.DBOPPKG;
import SA.SRFDA.EAI.Data.DBOPProc;
import SA.SRFDA.EAI.Model.DBOPProcessesConfig;
import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.XML.XMLNode;
import java.util.HashMap;
import java.util.Map;
import java.util.Vector;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class DBOPPKGDataCtrl extends BaseDEDataCtrl implements IDBOPPKGDataCtrl {
    private static final Log log = LogFactory.getLog(DBOPPKGDataCtrl.class);
    public static final String CUSTOMCALL_PUBLISH = "PUBLISH";

    @Override
    protected CallResult OnCustomCall(String strCallName, BaseDataEntity dataEntity) {
        if (StringHelper.Compare(strCallName, CUSTOMCALL_PUBLISH, true) == 0) {
            return this.OnPublish(dataEntity);
        }
        return super.OnCustomCall(strCallName, dataEntity);
    }

    protected CallResult OnPublish(BaseDataEntity dataEntity) {
        DBOPPKG pkg = new DBOPPKG();
        pkg.Proxy(dataEntity);
        return this.Publish(pkg.getEAIDBOPPKGID(), true);
    }

    @Override
    public CallResult Publish(String strPkgId, boolean bAlwaysCreate) {
        CallResult result = new CallResult();
        try {
            DBOPPKGFactory.Create(strPkgId, this.globalHelperEx).Publish(bAlwaysCreate);
        } catch (Exception ex) {
            log.error("Failed to publish database operation package " + strPkgId, ex);
            result.setRetCode(1);
            result.setErrorInfo(ex.getMessage());
        }
        return result;
    }

    @Override
    public CallResult CopyDetail(BaseDataEntity dataEntity, Object srcKey) {
        CallResult result = super.CopyDetail(dataEntity, srcKey);
        if (result.IsError()) {
            return result;
        }
        DBOPPKG pkg = new DBOPPKG();
        pkg.Proxy(dataEntity);
        if (StringHelper.IsNullOrEmpty(pkg.getPROCMODEL())) {
            return result;
        }
        try {
            String model = clonePkgProcModel(pkg.getPROCMODEL(), this, pkg.getEAIDBOPPKGID());
            DBOPPKG update = new DBOPPKG();
            update.setEAIDBOPPKGID(pkg.getEAIDBOPPKGID());
            update.setPROCMODEL(model);
            result = this.Save(false, update);
            if (!result.IsError()) {
                pkg.setPROCMODEL(model);
            }
        } catch (Exception ex) {
            log.error("Failed to copy database operation package model", ex);
            result.setRetCode(1);
            result.setErrorInfo(ex.getMessage());
        }
        return result;
    }

    @Override
    protected CallResult OnExport(BaseDataEntity dataEntity, Vector<XMLNode> list, boolean bFrameOnly) {
        CallResult result = super.OnExport(dataEntity, list, bFrameOnly);
        if (result.IsError() || this instanceof DBProcPkgDataCtrl) {
            return result;
        }
        DBOPPKG pkg = new DBOPPKG();
        pkg.Proxy(dataEntity);
        if (StringHelper.IsNullOrEmpty(pkg.getPROCMODEL())) {
            return result;
        }
        try {
            XMLNode processes = getProcesses(pkg.getPROCMODEL());
            if (processes == null || processes.getChildNodes() == null) {
                return result;
            }
            IDEDataCtrl procCtrl = this.GetRelatedDataCtrl("EAI0060");
            if (procCtrl == null) {
                throw new Exception("No data controller for database operation process EAI0060");
            }
            for (XMLNode process : processes.getChildNodes()) {
                String id = process.GetExtValue("PROCESSCONFIG", "");
                if (StringHelper.IsNullOrEmpty(id)) {
                    continue;
                }
                DBOPProc proc = new DBOPProc();
                proc.setEAIDBOPPROCID(id);
                result = procCtrl.Get(proc);
                if (result.IsError()) {
                    return result;
                }
                IDEDataCtrl realCtrl = findProcessCtrl(procCtrl, proc.getEAIDBOPPROCTYPE(), this);
                BaseDataEntity record = new BaseDataEntity();
                record.SetParamValue(realCtrl.GetDEHelper().GetKeyDEFHelper().getName(), id);
                result = realCtrl.Export(record, list, true, bFrameOnly);
                if (result.IsError()) {
                    return result;
                }
            }
        } catch (Exception ex) {
            log.error("Failed to export database operation package model", ex);
            result.setRetCode(1);
            result.setErrorInfo(ex.getMessage());
        }
        return result;
    }

    public static String ClonePkgProcModel(String model, IDEDataCtrl pkgCtrl) throws Exception {
        return clonePkgProcModel(model, pkgCtrl, null);
    }

    private static String clonePkgProcModel(String model, IDEDataCtrl pkgCtrl, String targetPkgId) throws Exception {
        if (StringHelper.IsNullOrEmpty(model)) {
            return model;
        }
        XMLNode root = XMLNode.LoadFromXML(model);
        if (root == null) {
            throw new Exception("Invalid database operation package model XML");
        }
        XMLNode processes = root.GetChildNodeByNodeName(DBOPProcessesConfig.TAG_SRFDBOPPROCS);
        if (processes == null || processes.getChildNodes() == null) {
            return model;
        }
        IDEDataCtrl procCtrl = pkgCtrl.GetRelatedDataCtrl("EAI0060");
        if (procCtrl == null) {
            throw new Exception("No data controller for database operation process EAI0060");
        }
        Map<String, String> copied = new HashMap<String, String>();
        for (XMLNode process : processes.getChildNodes()) {
            String id = process.GetExtValue("PROCESSCONFIG", "");
            if (StringHelper.IsNullOrEmpty(id)) {
                continue;
            }
            String newId = copied.get(id);
            if (newId == null) {
                DBOPProc proc = new DBOPProc();
                proc.setEAIDBOPPROCID(id);
                CallResult result = procCtrl.Get(proc);
                if (result.IsError()) {
                    throw new Exception("Failed to load process " + id + ": " + result.getErrorInfo());
                }
                IDEDataCtrl realCtrl = findProcessCtrl(procCtrl, proc.getEAIDBOPPROCTYPE(), pkgCtrl);
                String keyName = realCtrl.GetDEHelper().GetKeyDEFHelper().getName();
                BaseDataEntity record = new BaseDataEntity();
                record.SetParamValue(keyName, id);
                result = realCtrl.Get(record);
                if (result.IsError()) {
                    throw new Exception("Failed to load process " + id + ": " + result.getErrorInfo());
                }
                boolean hasPkgId = record.ContainesParam(DBOPProc.TAG_EAIDBOPPKGID);
                realCtrl.RemoveUncopyValue(record);
                if (!StringHelper.IsNullOrEmpty(targetPkgId) && hasPkgId) {
                    record.SetParamValue(DBOPProc.TAG_EAIDBOPPKGID, targetPkgId);
                }
                result = realCtrl.Save(true, record);
                if (result.IsError()) {
                    throw new Exception("Failed to copy process " + id + ": " + result.getErrorInfo());
                }
                newId = record.GetParamStringValue(keyName, "");
                if (StringHelper.IsNullOrEmpty(newId) || id.equals(newId)) {
                    throw new Exception("Copying process " + id + " did not generate a new ID");
                }
                result = realCtrl.CopyDetail(record, id);
                if (result.IsError()) {
                    throw new Exception("Failed to copy process details " + id + ": " + result.getErrorInfo());
                }
                copied.put(id, newId);
            }
            process.SetValue("PROCESSCONFIG", newId);
        }
        return XMLNode.Export(root);
    }

    private static XMLNode getProcesses(String model) throws Exception {
        XMLNode root = XMLNode.LoadFromXML(model);
        if (root == null) {
            throw new Exception("Invalid database operation package model XML");
        }
        return root.GetChildNodeByNodeName(DBOPProcessesConfig.TAG_SRFDBOPPROCS);
    }

    private static IDEDataCtrl findProcessCtrl(IDEDataCtrl procCtrl, String type, IDEDataCtrl pkgCtrl) throws Exception {
        Vector<DERINDEX> indexes = procCtrl.GetDEHelper().GetDERINDEXs(true);
        for (DERINDEX index : indexes) {
            if (StringHelper.Compare(index.getTYPEVALUE(), type, true) == 0) {
                IDEDataCtrl ctrl = pkgCtrl.GetRelatedDataCtrl(index.getDEID());
                if (ctrl != null) {
                    return ctrl;
                }
            }
        }
        throw new Exception("No data controller for database operation process type " + type);
    }
}
