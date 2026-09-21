/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Ctrl.IDEDataCtrl
 *  SA.SRFDA.Ctrl.IDEHelper
 *  SA.SRFDA.Web.Utility.GlobalHelperEx
 *  SA.SRFramework.Data.DBResult
 *  SA.SRFramework.Data.SelectResult
 *  SA.SRFramework.DataEx.BaseDBCallerHelperEx
 *  SA.SRFramework.DataEx.BaseDataEntity
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  SA.SRFramework.UtilityEx.ObjectHelper
 *  javax.servlet.ServletContext
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.KPI.Ctrl;

import SA.SRFDA.Ctrl.IDEDataCtrl;
import SA.SRFDA.Ctrl.IDEHelper;
import SA.SRFDA.KPI.Ctrl.Data.KPIInst;
import SA.SRFDA.KPI.Ctrl.Data.KPIInstData;
import SA.SRFDA.KPI.Ctrl.Data.KPIMP;
import SA.SRFDA.KPI.Ctrl.Data.KPIPoint;
import SA.SRFDA.KPI.Ctrl.Data.KPISet;
import SA.SRFDA.KPI.Ctrl.ISRFKPIDataCtrl;
import SA.SRFDA.Web.Utility.GlobalHelperEx;
import SA.SRFramework.Data.DBResult;
import SA.SRFramework.Data.SelectResult;
import SA.SRFramework.DataEx.BaseDBCallerHelperEx;
import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.UtilityEx.ObjectHelper;
import java.util.Vector;
import javax.servlet.ServletContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class DefaultKPIDataCtrl
implements ISRFKPIDataCtrl {
    protected BaseDBCallerHelperEx dbCallerHelper = null;
    protected ServletContext servletContext = null;
    private static final Log log = LogFactory.getLog(DefaultKPIDataCtrl.class);
    public static final String TAG_KPISETDEID = "KPI0001";
    protected GlobalHelperEx globalHelperEx = null;
    protected IDEDataCtrl setDataCtrl = null;

    @Override
    public void Init(ServletContext servletContext, BaseDBCallerHelperEx dbCallerHelper) {
        this.dbCallerHelper = dbCallerHelper;
        this.servletContext = servletContext;
        this.globalHelperEx = (GlobalHelperEx)servletContext.getAttribute("SRFDACONTEXTHELPER");
        IDEHelper wfDEHelper = this.globalHelperEx.getDAModelStorage().FindDEHelper(TAG_KPISETDEID);
        if (wfDEHelper == null) {
            log.error((Object)"\u65e0\u6cd5\u83b7\u53d6KPI\u914d\u7f6e\u5b9e\u4f53\u8f85\u52a9\u5bf9\u8c61");
            return;
        }
        this.setDataCtrl = wfDEHelper.GetDEDataCtrl("SYSTEM", null);
        if (this.setDataCtrl == null) {
            log.error((Object)"\u65e0\u6cd5\u83b7\u53d6KPI\u914d\u7f6e\u5b9e\u4f53\u6570\u636e\u64cd\u4f5c\u5bf9\u8c61");
            return;
        }
    }

    @Override
    public CallResult AddKPIInst(KPIInst instance, String strOpPersonId) {
        CallResult callResult = new CallResult();
        IDEDataCtrl kpiInstCtrl = this.globalHelperEx.getDAModelStorage().FindDEDataCtrl("KPI0002", strOpPersonId, null);
        if (kpiInstCtrl == null) {
            callResult.setRetCode(1);
            callResult.setErrorInfo("\u65e0\u6cd5\u83b7\u53d6\u5b9e\u4f53[KPIINST]\u6570\u636e\u8bbf\u95ee\u5bf9\u8c61");
            log.error((Object)callResult.getErrorInfo());
            return callResult;
        }
        callResult = kpiInstCtrl.Save(true, (BaseDataEntity)instance);
        if (callResult.getRetCode() != 0) {
            log.error((Object)StringHelper.Format((String)"\u4fdd\u5b58KPI\u5b9e\u4f8b\u5931\u8d25\uff0c%1$s", (Object)callResult.getErrorInfo()));
            return callResult;
        }
        return callResult;
    }

    @Override
    public CallResult ExecRawSql(String strSQL) {
        CallResult callResult = new CallResult();
        try {
            DBResult dbResult = this.dbCallerHelper.CallRaw3WithoutReturn(strSQL, null);
            if (dbResult == null) {
                callResult.setRetCode(1);
                callResult.setErrorInfo("\u4e0d\u660e\u9519\u8bef");
                return callResult;
            }
            callResult.From(dbResult);
            return callResult;
        }
        catch (Exception ex) {
            callResult.setRetCode(1);
            callResult.setErrorInfo(ex.getMessage());
            return callResult;
        }
    }

    public CallResult FinishKPIInst(KPIInst instance, String strOpPersonId) {
        return null;
    }

    @Override
    public CallResult GetKPIInst(String strInstanceId, KPIInst instance) {
        return null;
    }

    @Override
    public CallResult GetKPIInst(String strKPISetId, String strUserData, String strUserData2, String strUserData3, String strUserData4, int nBatSN, KPIInst instance) {
        String strSql = StringHelper.Format((String)"select * from T_SRFKPIINST where  UPPER(KPISETID)=UPPER('%1$s')  ", (Object)strKPISetId);
        strSql = StringHelper.IsNullOrEmpty((String)strUserData) ? String.valueOf(strSql) + " AND (USERDATA IS NULL) " : String.valueOf(strSql) + StringHelper.Format((String)" AND (USERDATA = '%1$s') ", (Object)strUserData);
        strSql = StringHelper.IsNullOrEmpty((String)strUserData2) ? String.valueOf(strSql) + " AND (USERDATA2 IS NULL) " : String.valueOf(strSql) + StringHelper.Format((String)" AND (USERDATA2 = '%1$s') ", (Object)strUserData2);
        strSql = StringHelper.IsNullOrEmpty((String)strUserData3) ? String.valueOf(strSql) + " AND (USERDATA3 IS NULL) " : String.valueOf(strSql) + StringHelper.Format((String)" AND (USERDATA3 = '%1$s') ", (Object)strUserData3);
        strSql = StringHelper.IsNullOrEmpty((String)strUserData4) ? String.valueOf(strSql) + " AND (USERDATA4 IS NULL) " : String.valueOf(strSql) + StringHelper.Format((String)" AND (USERDATA4 = '%1$s') ", (Object)strUserData4);
        strSql = String.valueOf(strSql) + StringHelper.Format((String)" AND (BATSN = %1$s) ", (Object)nBatSN);
        return this.SelectRaw(strSql, instance, "");
    }

    @Override
    public CallResult GetKPIInstDatas(String strKPIInstId, Vector<KPIInstData> list) {
        String strSql = StringHelper.Format((String)"select * from  V_SRFKPIINSTDATA  t1 WHERE UPPER(t1.KPIINSTID)= '%1$s'", (Object)strKPIInstId.toUpperCase());
        return this.SelectRaw(strSql, list, KPIInstData.class.getName(), "");
    }

    @Override
    public CallResult GetKPISetPoints(String strKPISetId, String strPKPIPointId, Vector<KPIPoint> list) {
        String strSql = "";
        strSql = StringHelper.IsNullOrEmpty((String)strPKPIPointId) ? StringHelper.Format((String)"select * from  T_SRFKPIPOINT  t1 WHERE UPPER(t1.KPISETID)= '%1$s' AND t1.PKPIPOINTID IS NULL", (Object)strKPISetId.toUpperCase()) : StringHelper.Format((String)"select * from  T_SRFKPIPOINT  t1 WHERE UPPER(t1.KPISETID)= '%1$s' AND t1.PKPIPOINTID ='%2$s'", (Object)strKPISetId.toUpperCase(), (Object)strPKPIPointId.toUpperCase());
        return this.SelectRaw(strSql, list, KPIPoint.class.getName(), "");
    }

    @Override
    public CallResult GetKPIMP(String strKPIMPId, KPIMP mp) {
        String strSql = StringHelper.Format((String)"select * from  T_SRFKPIMP  t1 WHERE   UPPER(t1.KPIMPSN) = '%1$s'", (Object)strKPIMPId.toUpperCase());
        return this.SelectRaw(strSql, mp, "");
    }

    @Override
    public CallResult AddKPIInstData(KPIInstData instData, String strOpPersonId) {
        CallResult callResult = new CallResult();
        IDEDataCtrl kpiInstDataCtrl = this.globalHelperEx.getDAModelStorage().FindDEDataCtrl("KPI0004", strOpPersonId, null);
        if (kpiInstDataCtrl == null) {
            callResult.setRetCode(1);
            callResult.setErrorInfo("\u65e0\u6cd5\u83b7\u53d6\u5b9e\u4f53[KPIINSTDATA]\u6570\u636e\u8bbf\u95ee\u5bf9\u8c61");
            log.error((Object)callResult.getErrorInfo());
            return callResult;
        }
        String strInstDataKey = StringHelper.Format((String)"%1$s_%2$s", (Object)instData.getKPIINSTID(), (Object)instData.getKPIMPNAME());
        BaseDataEntity checkkeyparam = new BaseDataEntity();
        checkkeyparam.SetParamValue("KPIINSTDATAID", (Object)strInstDataKey);
        instData.SetParamValue("KPIINSTDATAID", strInstDataKey);
        callResult = kpiInstDataCtrl.CheckKeyState(checkkeyparam);
        if (callResult.getRetCode() != 0 || callResult.getUserObject() == null) {
            callResult.setRetCode(1);
            callResult.setErrorInfo(StringHelper.Format((String)"\u68c0\u67e5\u6570\u636e\u4e3b\u952e\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
            return callResult;
        }
        boolean bInsert = false;
        int nState = (Integer)callResult.getUserObject();
        if (nState == 0) {
            bInsert = true;
        } else if (nState == 1) {
            bInsert = false;
        }
        callResult = kpiInstDataCtrl.Save(bInsert, (BaseDataEntity)instData);
        if (callResult.getRetCode() != 0) {
            log.error((Object)StringHelper.Format((String)"\u4fdd\u5b58KPI\u5b9e\u4f8b\u6570\u636e\u5931\u8d25\uff0c%1$s", (Object)callResult.getErrorInfo()));
            return callResult;
        }
        return callResult;
    }

    @Override
    public CallResult GetKPISet(String strKPISetId, KPISet kpiSet) {
        String strSql = StringHelper.Format((String)"select * from  T_SRFKPISET  t1 WHERE UPPER(t1.KPISETID)= '%1$s' ", (Object)strKPISetId.toUpperCase());
        return this.SelectRaw(strSql, kpiSet, "");
    }

    public CallResult ResetKPIInst(KPIInst instance, String strOpPersonId) {
        return null;
    }

    public CallResult UserCloseKPIInst(KPIInst instance, String strOpPersonId) {
        return null;
    }

    protected CallResult SelectRaw(String strSQL, BaseDataEntity dataEntity, String strOpPersonId) {
        CallResult callResult = new CallResult();
        try {
            SelectResult selectResult = this.dbCallerHelper.CallRaw2(strSQL);
            if (selectResult == null) {
                callResult.setRetCode(1);
                callResult.setErrorInfo("\u4e0d\u660e\u9519\u8bef");
                return callResult;
            }
            if (selectResult.getRetCode() != 0) {
                callResult.From((DBResult)selectResult);
                return callResult;
            }
            if (selectResult.getMainTable() == null) {
                callResult.setRetCode(1);
                callResult.setErrorInfo("\u6ca1\u6709\u8fd4\u56de\u6570\u636e\u8868\u5bf9\u8c61");
                return callResult;
            }
            if (selectResult.getMainTable().GetRowCount() == 0) {
                callResult.setRetCode(3);
                return callResult;
            }
            dataEntity.FromDataRow(selectResult.getMainTable().GetRow(0));
            callResult.setRetCode(0);
            return callResult;
        }
        catch (Exception ex) {
            callResult.setRetCode(1);
            callResult.setErrorInfo(ex.getMessage());
            return callResult;
        }
    }

    protected CallResult SelectRaw(String strSQL, Vector dataEntities, String strObject, String strOpPersonId) {
        CallResult callResult = new CallResult();
        try {
            SelectResult selectResult = this.dbCallerHelper.CallRaw2(strSQL);
            if (selectResult == null) {
                callResult.setRetCode(1);
                callResult.setErrorInfo("\u4e0d\u660e\u9519\u8bef");
                return callResult;
            }
            if (selectResult.getRetCode() != 0) {
                callResult.From((DBResult)selectResult);
                return callResult;
            }
            if (selectResult.getMainTable() == null) {
                callResult.setRetCode(1);
                callResult.setErrorInfo("\u6ca1\u6709\u8fd4\u56de\u6570\u636e\u8868\u5bf9\u8c61");
                return callResult;
            }
            int nCount = selectResult.getMainTable().GetRowCount();
            int i = 0;
            while (i < nCount) {
                Object obj;
                BaseDataEntity dataEntity = null;
                if (!StringHelper.IsNullOrEmpty((String)strObject) && (obj = ObjectHelper.Create((String)strObject)) != null && obj instanceof BaseDataEntity) {
                    dataEntity = (BaseDataEntity)obj;
                }
                if (dataEntity == null) {
                    dataEntity = new BaseDataEntity();
                }
                dataEntity.FromDataRow(selectResult.getMainTable().GetRow(i));
                dataEntities.add(dataEntity);
                ++i;
            }
            callResult.setRetCode(0);
            return callResult;
        }
        catch (Exception ex) {
            callResult.setRetCode(1);
            callResult.setErrorInfo(ex.getMessage());
            return callResult;
        }
    }
}

