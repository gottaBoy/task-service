/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 */
package SA.SRFDA.EAI.Ctrl;

import SA.SRFDA.EAI.Ctrl.BaseDBOPObject;
import SA.SRFDA.EAI.Ctrl.IDBOPSetting;
import SA.SRFDA.EAI.Data.DBOPDTMap;
import SA.SRFDA.EAI.Data.DBOPPKGParam;
import SA.SRFDA.EAI.Data.DBOPSetting;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import java.util.Hashtable;
import java.util.Vector;

public class BaseDBOPSetting
extends BaseDBOPObject
implements IDBOPSetting {
    protected DBOPSetting dbOPSetting = null;
    protected Hashtable<String, DBOPDTMap> dataTypeTable = new Hashtable();
    protected Vector<DBOPPKGParam> dbopSysProcParams = new Vector();
    protected Vector<DBOPPKGParam> dbopSysDeclareParams = new Vector();
    protected Hashtable<String, String> paramMap = new Hashtable();

    @Override
    public void Init(ISRFDAGlobalHelper iDAGlobalHelper, DBOPSetting dbOPSetting) throws Exception {
        this.setGlobalHelper(iDAGlobalHelper);
        this.dbOPSetting = dbOPSetting;
        this.OnPrepareDBOPDTMap();
        this.OnPrepareSysParams();
        this.OnInit();
    }

    protected void OnPrepareDBOPDTMap() throws Exception {
        Vector<DBOPDTMap> list = new Vector<DBOPDTMap>();
        CallResult callResult = this.getDBOPModelHelper().GetDBOPDTMaps(this.dbOPSetting.getEAIDBOPSETTINGID(), list);
        if (callResult.IsError()) {
            throw new Exception(StringHelper.Format((String)"\u83b7\u53d6%1$s]\u6570\u636e\u5e93\u6570\u636e\u7c7b\u578b\u6620\u5c04\u5931\u8d25\uff0c%2$s", (Object)this.dbOPSetting.getDBTYPE(), (Object)callResult.getErrorInfo()));
        }
        for (DBOPDTMap dbopdtMap : list) {
            this.dataTypeTable.put(dbopdtMap.getEAIDBOPDTMAPNAME(), dbopdtMap);
        }
    }

    protected void OnPrepareSysParams() throws Exception {
        Vector<DBOPPKGParam> list = new Vector<DBOPPKGParam>();
        CallResult callResult = this.getDBOPModelHelper().GetDBOPSysParams(this.dbOPSetting.getEAIDBOPSETTINGID(), list);
        if (callResult.IsError()) {
            throw new Exception(StringHelper.Format((String)"\u83b7\u53d6[%1$s]\u6570\u636e\u5e93\u9884\u5b9a\u4e49\u7cfb\u7edf\u53c2\u6570\u5931\u8d25\uff0c%2$s", (Object)this.dbOPSetting.getDBTYPE(), (Object)callResult.getErrorInfo()));
        }
        for (DBOPPKGParam param : list) {
            if (StringHelper.Compare((String)param.getPARAMTYPE(), (String)"INTERNAL", (boolean)true) == 0) {
                this.dbopSysDeclareParams.add(param);
            } else {
                this.dbopSysProcParams.add(param);
            }
            this.paramMap.put(param.getEAIDBOPPKGPARAMNAME(), StringHelper.Format((String)"%1$s%2$s", (Object)"SRF_", (Object)param.getEAIDBOPPKGPARAMNAME()));
        }
    }

    protected void OnInit() throws Exception {
    }

    @Override
    public DBOPSetting getDBOPSetting() {
        return this.dbOPSetting;
    }

    @Override
    public DBOPDTMap FindDBDataType(String strDataType) throws Exception {
        if (this.dataTypeTable.containsKey(strDataType)) {
            return this.dataTypeTable.get(strDataType);
        }
        throw new Exception(StringHelper.Format((String)"\u672a\u627e\u5230\u7c7b\u578b[%1$s]\u5bf9\u5e94\u7684\u6570\u636e\u5e93\u7c7b\u578b", (Object)strDataType));
    }

    @Override
    public Vector<DBOPPKGParam> getSysProcParams() {
        return this.dbopSysProcParams;
    }

    @Override
    public Vector<DBOPPKGParam> getSysDeclareParams() {
        return this.dbopSysDeclareParams;
    }

    @Override
    public String getLogDetailBeginCode() throws Exception {
        return this.dbOPSetting.getLOGDETAILBEGINCODE();
    }

    @Override
    public String getLogDetailEndCode() throws Exception {
        return this.dbOPSetting.getLOGDETAILENDCODE();
    }

    @Override
    public String getInitCode() {
        return this.dbOPSetting.getINITCODE();
    }

    @Override
    public String FindPkgParam(String strParamId) {
        if (this.paramMap.containsKey(strParamId)) {
            return this.paramMap.get(strParamId);
        }
        return "";
    }

    @Override
    public String getLineComment() {
        if (StringHelper.IsNullOrEmpty((String)this.dbOPSetting.getLINECOMMENT())) {
            return "--";
        }
        return this.dbOPSetting.getLINECOMMENT();
    }
}

