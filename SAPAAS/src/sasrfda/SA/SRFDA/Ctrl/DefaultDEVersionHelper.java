/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Data.CallParamList
 *  SA.SRFramework.Data.DataRow
 *  SA.SRFramework.Data.SelectResult2
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
import SA.SRFramework.Data.DataRow;
import SA.SRFramework.Data.SelectResult2;
import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import java.sql.Timestamp;
import java.util.Date;
import java.util.HashMap;
import java.util.Vector;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class DefaultDEVersionHelper
implements IDEVersionHelper {
    private static final Log log = LogFactory.getLog(DefaultDEVersionHelper.class);
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
            callResult.setRetCode(1);
            callResult.setErrorInfo(StringHelper.Format((String)"\u67e5\u8be2\u6570\u636e\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)(callResult == null ? "\u672a\u77e5\u9519\u8bef" : callResult.getErrorInfo())));
            log.error((Object)StringHelper.Format((String)"\u67e5\u8be2\u6570\u636e\u53d1\u751f\u9519\u8bef\uff0c%1$s\r\n%2$s", (Object)(callResult == null ? "\u672a\u77e5\u9519\u8bef" : callResult.getErrorInfo()), (Object)this.strQueryVersionSQL));
            return -1;
        }
        nVersion = data.GetParamIntValue(this.strVersionField, -1);
        this.deVersionMap.put(data.GetParamValue(this.strKeyField), nVersion);
        return nVersion;
    }

    @Override
    public void RunTimer(long nTime) {
        if (this.lastRunTime == -1L || nTime - this.lastRunTime >= (long)this.nRunTimer) {
            int nTotalSize;
            block15: {
                this.lastRunTime = nTime;
                boolean bHasUpdateDate = !StringHelper.IsNullOrEmpty((String)this.strUpdateDateField);
                String strSQL = "";
                CallParamList callParamList = new CallParamList();
                if (!bHasUpdateDate) {
                    strSQL = this.strPagingQueryVersionSQL;
                } else if (this.lastUpdateDate == null) {
                    strSQL = this.strPagingQueryVersionSQL;
                } else {
                    strSQL = this.strPagingQueryVersionSQL2;
                    callParamList.AddDateTime((Object)this.lastUpdateDate);
                }
                SelectResult2 selectResult = BaseDEDataCtrl.SelectMultiExReturnRS(this.iDAGlobalHelper, null, this.strDBStorage, strSQL, callParamList.GetList());
                if (selectResult == null || selectResult.getRetCode() != 0) {
                    log.error((Object)StringHelper.Format((String)"\u67e5\u8be2\u6570\u636e\u53d1\u751f\u9519\u8bef\uff0c%1$s\r\n%2$s", (Object)(selectResult == null ? "\u672a\u77e5\u9519\u8bef" : selectResult.getErrorInfo()), (Object)strSQL));
                    return;
                }
                nTotalSize = 0;
                try {
                    try {
                        int nReadSize;
                        int PAGESIZE = 100;
                        BaseDataEntity dataEntity = new BaseDataEntity();
                        do {
                            nReadSize = selectResult.getMainTable().ReadRows(PAGESIZE);
                            int i = 0;
                            while (i < selectResult.getMainTable().GetRowCount()) {
                                DataRow dr = selectResult.getMainTable().GetRow(i);
                                dataEntity.FromDataRow(dr, true);
                                String strDataId = dataEntity.GetParamStringValue(this.strKeyField, "");
                                int nVersion = dataEntity.GetParamIntValue(this.strVersionField, -1);
                                if (bHasUpdateDate && !dataEntity.IsParamNull(this.strUpdateDateField)) {
                                    Timestamp updateDate = dataEntity.GetParamTimestampValue(this.strUpdateDateField, null);
                                    if (this.lastUpdateDate == null || updateDate.getTime() > this.lastUpdateDate.getTime() || updateDate.getTime() == this.lastUpdateDate.getTime() && updateDate.getNanos() > this.lastUpdateDate.getNanos()) {
                                        this.lastUpdateDate = updateDate;
                                    }
                                }
                                this.deVersionMap.put(strDataId, nVersion);
                                ++i;
                            }
                            nTotalSize += nReadSize;
                        } while (nReadSize >= PAGESIZE);
                    }
                    catch (Exception ex) {
                        log.error((Object)ex);
                        selectResult.Close();
                        break block15;
                    }
                }
                catch (Throwable throwable) {
                    selectResult.Close();
                    throw throwable;
                }
                selectResult.Close();
            }
            long nRunTime = new Date().getTime() - this.lastRunTime;
            log.debug((Object)StringHelper.Format((String)"\u66f4\u65b0\u5b9e\u4f53[%1$s]\u7248\u672c\u8017\u65f6 %2$sms\uff0c\u66f4\u65b0\u8bb0\u5f55\u6570 %3$s", (Object)this.strDEId, (Object)nRunTime, (Object)nTotalSize));
        }
    }
}

