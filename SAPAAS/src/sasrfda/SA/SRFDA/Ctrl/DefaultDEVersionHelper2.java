/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Data.CallParamList
 *  SA.SRFramework.DataEx.BaseDataEntity
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.Ctrl;

import SA.SRFDA.Ctrl.BaseDEDataCtrl;
import SA.SRFDA.Ctrl.Data.DEField;
import SA.SRFDA.Ctrl.Data.DataEntity;
import SA.SRFDA.Ctrl.IDEVersionHelper;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.Data.CallParamList;
import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import java.sql.Timestamp;
import java.util.Date;
import java.util.HashMap;
import java.util.Vector;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class DefaultDEVersionHelper2
implements IDEVersionHelper {
    private static final Log log = LogFactory.getLog(DefaultDEVersionHelper2.class);
    protected String strDEId = "";
    protected HashMap<Object, Integer> deVersionMap = new HashMap();
    protected long lastRunTime = -1L;
    protected int nRunTimer = 0;
    protected ISRFDAGlobalHelper iDAGlobalHelper = null;
    protected String strQueryVersionSQL = "";
    protected String strPagingQueryVersionSQL = "";
    protected String strPagingQueryVersionSQL2 = "";
    protected String strDBStorage = "";
    protected String strKeyField = "";
    protected String strVersionField = "";
    protected Timestamp lastUpdateDate = null;
    protected DataEntity dataEntity = null;
    protected String strUpdateDateField = "";

    @Override
    public void Init(ISRFDAGlobalHelper iDAGlobalHelper, DataEntity dataEntity) throws Exception {
        this.iDAGlobalHelper = iDAGlobalHelper;
        this.dataEntity = dataEntity;
        this.strDEId = dataEntity.getDEID();
        CallResult callResult = new CallResult();
        Vector<DEField> fields = new Vector<DEField>();
        iDAGlobalHelper.getDAModelHelper().GetDEFieldsNoSort(this.strDEId, fields);
        if (callResult.IsError()) {
            log.error((Object)StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u5b9e\u4f53[%1$s]\u5c5e\u6027\uff0c%2$s", (Object)this.strDEId, (Object)callResult.getErrorInfo()));
            throw new Exception(StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u5b9e\u4f53[%1$s]\u5c5e\u6027\uff0c%2$s", (Object)this.strDEId, (Object)callResult.getErrorInfo()));
        }
        for (DEField defield : fields) {
            if (!defield.isPKEY()) continue;
            this.strKeyField = defield.getDEFNAME();
            break;
        }
        this.strVersionField = dataEntity.getVERFIELD();
        if (dataEntity.isEXITINGMODEL()) {
            for (DEField defield : fields) {
                if (StringHelper.Compare((String)defield.getPREDEFINETYPE(), (String)"UPDATEDATE", (boolean)true) != 0) continue;
                this.strUpdateDateField = defield.getDEFNAME();
                break;
            }
        } else {
            this.strUpdateDateField = "UPDATEDATE";
        }
        this.strQueryVersionSQL = StringHelper.Format((String)"SELECT %3$s,%1$s from %2$s where %3$s=?", (Object)this.strVersionField, (Object)dataEntity.getTABLENAME(), (Object)this.strKeyField);
        if (StringHelper.IsNullOrEmpty((String)this.strUpdateDateField)) {
            this.strPagingQueryVersionSQL = StringHelper.Format((String)"SELECT %3$s,%1$s from %2$s ", (Object)this.strVersionField, (Object)dataEntity.getTABLENAME(), (Object)this.strKeyField);
        } else {
            this.strPagingQueryVersionSQL = StringHelper.Format((String)"SELECT %3$s,%1$s,%4$s from %2$s ", (Object)this.strVersionField, (Object)dataEntity.getTABLENAME(), (Object)this.strKeyField, (Object)this.strUpdateDateField);
            this.strPagingQueryVersionSQL2 = StringHelper.Format((String)"SELECT %3$s,%1$s,%4$s from %2$s where %4$s>? ", (Object)this.strVersionField, (Object)dataEntity.getTABLENAME(), (Object)this.strKeyField, (Object)this.strUpdateDateField);
        }
        this.strDBStorage = dataEntity.getDBSTORAGE();
        this.nRunTimer = dataEntity.getVERCHECKTIMER() * 1000;
        this.RunTimer(new Date().getTime());
    }

    @Override
    public String getDEId() {
        return this.strDEId;
    }

    @Override
    public int GetDataVersion(Object objDataId) {
        return this.GetDataVersion(objDataId, false);
    }

    @Override
    public int GetDataVersion(Object objDataId, boolean bReset) {
        Integer nVersion = -1;
        if (!bReset && (nVersion = this.deVersionMap.get(objDataId)) != null) {
            return nVersion;
        }
        CallParamList callParamList = new CallParamList();
        callParamList.Add(objDataId);
        BaseDataEntity data = new BaseDataEntity();
        CallResult callResult = BaseDEDataCtrl.SelectSingleEx(this.iDAGlobalHelper, this.strDBStorage, this.strQueryVersionSQL, callParamList.GetList(), data);
        if (callResult == null || callResult.getRetCode() != 0) {
            log.error((Object)StringHelper.Format((String)"\u67e5\u8be2\u6570\u636e\u53d1\u751f\u9519\u8bef\uff0c%1$s\r\n%2$s", (Object)(callResult == null ? "\u672a\u77e5\u9519\u8bef" : callResult.getErrorInfo()), (Object)this.strQueryVersionSQL));
            callResult.setRetCode(1);
            callResult.setErrorInfo(StringHelper.Format((String)"\u67e5\u8be2\u6570\u636e\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)(callResult == null ? "\u672a\u77e5\u9519\u8bef" : callResult.getErrorInfo())));
            return -1;
        }
        nVersion = data.GetParamIntValue(this.strVersionField, -1);
        this.deVersionMap.put(data.GetParamValue(this.strKeyField), nVersion);
        return nVersion;
    }

    @Override
    public void RunTimer(long nTime) {
        if (this.lastRunTime == -1L || nTime - this.lastRunTime >= (long)this.nRunTimer) {
            this.lastRunTime = nTime;
            this.deVersionMap.clear();
        }
    }
}

