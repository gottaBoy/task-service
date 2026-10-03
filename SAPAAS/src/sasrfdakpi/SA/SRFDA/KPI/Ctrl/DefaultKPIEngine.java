/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.GlobalHelperEx
 *  SA.SRFramework.DataEx.BaseDBCallerHelperEx
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.DateParser
 *  SA.SRFramework.Utility.Helper
 *  SA.SRFramework.Utility.StringHelper
 *  SA.SRFramework.UtilityEx.ObjectHelper
 *  javax.servlet.ServletContext
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.KPI.Ctrl;

import SA.SRFDA.KPI.Client.KPIParam;
import SA.SRFDA.KPI.Ctrl.Data.KPIInst;
import SA.SRFDA.KPI.Ctrl.Data.KPIInstData;
import SA.SRFDA.KPI.Ctrl.Data.KPIMP;
import SA.SRFDA.KPI.Ctrl.Data.KPIPoint;
import SA.SRFDA.KPI.Ctrl.Data.KPISet;
import SA.SRFDA.KPI.Ctrl.DatabaseMPProcess;
import SA.SRFDA.KPI.Ctrl.FormulaMPProcess;
import SA.SRFDA.KPI.Ctrl.ISRFKPIContext;
import SA.SRFDA.KPI.Ctrl.ISRFKPIDataCtrl;
import SA.SRFDA.KPI.Ctrl.ISRFKPIEngine;
import SA.SRFDA.KPI.Ctrl.ISRFMPProcess;
import SA.SRFDA.KPI.Ctrl.KPIPointProcess;
import SA.SRFDA.Web.Utility.GlobalHelperEx;
import SA.SRFramework.DataEx.BaseDBCallerHelperEx;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.DateParser;
import SA.SRFramework.Utility.Helper;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.UtilityEx.ObjectHelper;
import java.util.Date;
import java.util.TreeMap;
import java.util.Vector;
import javax.servlet.ServletContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class DefaultKPIEngine
implements ISRFKPIEngine,
ISRFKPIContext {
    private static Log log = LogFactory.getLog(DefaultKPIEngine.class);
    protected BaseDBCallerHelperEx dbCallerHelper = null;
    protected ServletContext servletContext = null;
    protected GlobalHelperEx contextHelper = null;
    protected ISRFKPIDataCtrl kpiDataCtrl = null;
    protected int nMaxLoopCount = 100;
    protected TreeMap<String, Object> mpValues = new TreeMap();
    protected KPIInst kpiInst = new KPIInst();
    protected TreeMap<String, KPIMP> mpMap = new TreeMap();
    protected String strCurOPPersonId = "";
    protected KPISet kpiSet = new KPISet();

    @Override
    public CallResult Init(ServletContext servletContext, BaseDBCallerHelperEx dbCallerHelper, String strKPISetId) {
        this.dbCallerHelper = dbCallerHelper;
        this.servletContext = servletContext;
        this.contextHelper = (GlobalHelperEx)servletContext.getAttribute("SRFDACONTEXTHELPER");
        this.kpiDataCtrl = this.CreateKPIDataCtrl();
        if (this.kpiDataCtrl == null) {
            CallResult ret = new CallResult();
            ret.setRetCode(1);
            ret.setErrorInfo("\u65e0\u6cd5\u5efa\u7acb\u8bc4\u4f30\u5f15\u64ce\u6570\u636e\u5bf9\u8c61");
            return ret;
        }
        this.kpiDataCtrl.Init(servletContext, this.dbCallerHelper);
        CallResult ret = this.kpiDataCtrl.GetKPISet(strKPISetId, this.kpiSet);
        if (ret == null || ret.getRetCode() != 0) {
            return this.LogAndReturn("Init", StringHelper.Format((String)"\u83b7\u53d6KPI\u914d\u7f6e\u6570\u636e[%1$s]", (Object)strKPISetId), ret);
        }
        if (this.kpiSet.getKPISTATE() != 1) {
            return this.LogAndReturn("Init", StringHelper.Format((String)"KPI\u914d\u7f6e[%1$s]\u5f53\u524d\u5904\u4e8e\u975e\u6b63\u5e38\u4f7f\u7528\u72b6\u6001", (Object)strKPISetId), ret);
        }
        return ret;
    }

    protected ISRFKPIDataCtrl CreateKPIDataCtrl() {
        String strDataCtrlObject = this.contextHelper.getWebExConfig().GetValue("SRFKPI", "KPIDATACTRL", "");
        if (StringHelper.IsNullOrEmpty((String)strDataCtrlObject)) {
            log.error((Object)StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6KPI\u5f15\u64ce\u6570\u636e\u5bf9\u8c61"));
            return null;
        }
        Object objDataCtrl = ObjectHelper.Create((String)strDataCtrlObject);
        if (objDataCtrl == null) {
            log.error((Object)StringHelper.Format((String)"\u65e0\u6cd5\u5efa\u7acbKPI\u5f15\u64ce\u6570\u636e\u5bf9\u8c61[%1$s]", (Object)objDataCtrl));
            return null;
        }
        if (objDataCtrl instanceof ISRFKPIDataCtrl) {
            return (ISRFKPIDataCtrl)objDataCtrl;
        }
        log.error((Object)StringHelper.Format((String)"\u5bf9\u8c61[%1$s]\u6ca1\u6709\u5b9e\u73b0\u63a5\u53e3[ISRFKPIDataCtrl]", (Object)objDataCtrl));
        return null;
    }

    @Override
    public CallResult StartNew(KPIParam kpiParam) {
        this.mpValues.clear();
        this.kpiInst.Reset();
        CallResult ret = this.kpiDataCtrl.GetKPIInst(kpiParam.getKpiSetId(), kpiParam.getUserData(), kpiParam.getUserData2(), kpiParam.getUserData3(), kpiParam.getUserData4(), kpiParam.getBatSN(), this.kpiInst);
        if (ret == null) {
            return this.LogAndReturn("StartNew", StringHelper.Format((String)"\u83b7\u53d6KPI\u5b9e\u4f8b[%1$s]\u5931\u8d25", (Object)kpiParam.getUserData()), ret);
        }
        if (ret.getRetCode() == 0) {
            if (this.kpiInst.isCLOSE()) {
                return this.LogAndReturn("StartNew", StringHelper.Format((String)"\u6307\u5b9a[%1$s]KPI\u5b9e\u4f8b\u5df2\u7ecf\u5173\u95ed\uff0c\u65e0\u6cd5\u518d\u6b21\u8bc4\u4f30", (Object)kpiParam.getUserData()), null);
            }
            this.strCurOPPersonId = kpiParam.getOpPersonId();
            Vector<KPIInstData> kpiInstDatas = new Vector<KPIInstData>();
            ret = this.kpiDataCtrl.GetKPIInstDatas(this.kpiInst.getKPIINSTID(), kpiInstDatas);
            if (ret.getRetCode() != 0) {
                return this.LogAndReturn("StartNew", StringHelper.Format((String)"\u83b7\u53d6KPI\u5b9e\u4f8b[%1$s]\u5f53\u524d\u7ed3\u679c\u660e\u7ec6\u5931\u8d25", (Object)this.kpiInst.getKPIINSTID()), ret);
            }
        } else {
            if (ret.getRetCode() != 3) {
                return this.LogAndReturn("StartNew", StringHelper.Format((String)"\u83b7\u53d6KPI\u5b9e\u4f8b[%1$s]\u5931\u8d25", (Object)kpiParam.getUserData()), ret);
            }
            this.kpiInst.setKPIINSTID(Helper.GenGuidEx());
            this.kpiInst.setKPIINSTNAME(StringHelper.Format((String)"%1$s[%2$s]", (Object)this.kpiSet.getKPISETNAME(), (Object)DateParser.toDateTimeString((Date)new Date())));
            this.kpiInst.setKPISETID(this.kpiSet.getKPISETID());
            this.kpiInst.setKPIVERSION(this.kpiSet.getKPIVERSION());
            this.kpiInst.setUSERDATA(kpiParam.getUserData());
            this.kpiInst.setUSERDATA2(kpiParam.getUserData2());
            this.kpiInst.setUSERDATA3(kpiParam.getUserData3());
            this.kpiInst.setUSERDATA4(kpiParam.getUserData4());
            this.kpiInst.setOWNER(kpiParam.getOpPersonId());
            this.kpiInst.setIMPORTANCEFLAG(0);
            this.kpiInst.setBATSN(kpiParam.getBatSN());
            ret = this.kpiDataCtrl.AddKPIInst(this.kpiInst, kpiParam.getOpPersonId());
            if (ret == null || ret.getRetCode() != 0) {
                return this.LogAndReturn("StartNew", StringHelper.Format((String)"\u5efa\u7acbKPI\u5b9e\u4f8b\u5931\u8d25"), ret);
            }
        }
        if ((ret = this.GetKPIPoint(null)).getRetCode() != 0) {
            return this.LogAndReturn("StartNew", StringHelper.Format((String)"\u8ba1\u7b97KPI\u7ed3\u679c\u5931\u8d25"), ret);
        }
        String strUpdateCmd = this.kpiSet.getUPDATECMD();
        if (!StringHelper.IsNullOrEmpty((String)strUpdateCmd) && (ret = this.UpdateToUserData(strUpdateCmd, ret.getUserObject())).getRetCode() != 0) {
            return this.LogAndReturn("StartNew", StringHelper.Format((String)"\u540c\u6b65KPI\u7ed3\u679c\u5931\u8d25"), ret);
        }
        return ret;
    }

    protected CallResult UpdateToUserData(String strUpdateCmd, Object objValue) {
        strUpdateCmd = StringHelper.Format((String)strUpdateCmd, (Object)objValue, (Object)this.kpiSet.getKPISETID(), (Object)this.kpiInst.getUSERDATA(), (Object)this.kpiInst.getUSERDATA2(), (Object)this.kpiInst.getUSERDATA3(), (Object)this.kpiInst.getUSERDATA4(), (Object)this.kpiInst.getBATSN());
        return this.kpiDataCtrl.ExecRawSql(strUpdateCmd);
    }

    protected CallResult GetKPIPoint(KPIPoint pKPIPoint) {
        double fMinValue;
        double fMaxValue;
        CallResult ret;
        String strPKPIPointId = "";
        strPKPIPointId = pKPIPoint == null ? "" : pKPIPoint.getKPIPOINTID();
        Vector<KPIPoint> points = new Vector<KPIPoint>();
        CallResult callResult = this.kpiDataCtrl.GetKPISetPoints(this.kpiSet.getKPISETID(), strPKPIPointId, points);
        if (callResult.getRetCode() != 0) {
            log.error((Object)StringHelper.Format((String)"\u83b7\u53d6KPI\u6a21\u578b[%1$s][%2$s]", (Object)this.kpiSet.getKPISETID(), (Object)strPKPIPointId));
            return callResult;
        }
        if (points.size() == 0 && pKPIPoint != null) {
            KPIPointProcess kpiPointProcess = new KPIPointProcess();
            callResult = kpiPointProcess.Process(pKPIPoint, this);
            if (callResult.getRetCode() != 0) {
                return callResult;
            }
            log.info((Object)StringHelper.Format((String)"\u8ba1\u7b97[%1$s]\u5f97\u5230[%2$s]", (Object)pKPIPoint.getKPIPOINTNAME(), (Object)callResult.getUserObject()));
            KPIInstData instData = new KPIInstData();
            instData.setKPIINSTDATANAME(pKPIPoint.getKPIPOINTNAME());
            instData.setKPIMPNAME(pKPIPoint.getKPIPOINTNAME());
            instData.setKPIINSTID(this.kpiInst.getKPIINSTID());
            instData.setKPIPOINTID(pKPIPoint.getKPIPOINTID());
            instData.setMPSCORE(callResult.getUserObject());
            CallResult ret2 = this.kpiDataCtrl.AddKPIInstData(instData, this.strCurOPPersonId);
            if (ret2.getRetCode() != 0) {
                return ret2;
            }
            String strUpdateCmd = pKPIPoint.getUPDATECMD();
            if (!StringHelper.IsNullOrEmpty((String)strUpdateCmd) && (ret2 = this.UpdateToUserData(strUpdateCmd, callResult.getUserObject())).getRetCode() != 0) {
                return ret2;
            }
            return callResult;
        }
        double fValue = 0.0;
        for (KPIPoint kpiPoint : points) {
            callResult = this.GetKPIPoint(kpiPoint);
            if (callResult.getRetCode() != 0) {
                log.error((Object)StringHelper.Format((String)"\u8ba1\u7b97[%1$s]\u51fa\u73b0\u9519\u8bef,%2$s", (Object)kpiPoint.getKPIPOINTID(), (Object)callResult.getErrorInfo()));
                return callResult;
            }
            Double fCurVaue = (Double)callResult.getUserObject();
            fValue += fCurVaue.doubleValue();
        }
        if (pKPIPoint != null) {
            double fMinValue2;
            double fMaxValue2;
            if (pKPIPoint.GetParamValue("MAXSCORE") != null && fValue > (fMaxValue2 = pKPIPoint.getMAXSCORE())) {
                fValue = fMaxValue2;
            }
            if (pKPIPoint.GetParamValue("MINSCORE") != null && fValue < (fMinValue2 = pKPIPoint.getMINSCORE())) {
                fValue = fMinValue2;
            }
            callResult.setUserObject((Object)fValue);
            log.info((Object)StringHelper.Format((String)"\u8ba1\u7b97[%1$s]\u5f97\u5230[%2$s]", (Object)pKPIPoint.getKPIPOINTNAME(), (Object)fValue));
            KPIInstData instData = new KPIInstData();
            instData.setKPIMPNAME(pKPIPoint.getKPIPOINTNAME());
            instData.setKPIINSTDATANAME(pKPIPoint.getKPIPOINTNAME());
            instData.setKPIINSTID(this.kpiInst.getKPIINSTID());
            instData.setKPIPOINTID(pKPIPoint.getKPIPOINTID());
            instData.setMPSCORE(fValue);
            ret = this.kpiDataCtrl.AddKPIInstData(instData, this.strCurOPPersonId);
            if (ret.getRetCode() != 0) {
                return ret;
            }
            String strUpdateCmd = pKPIPoint.getUPDATECMD();
            if (!StringHelper.IsNullOrEmpty((String)strUpdateCmd) && (ret = this.UpdateToUserData(strUpdateCmd, fValue)).getRetCode() != 0) {
                return ret;
            }
            return callResult;
        }
        if (this.kpiSet.GetParamValue("MAXSCORE") != null && fValue > (fMaxValue = this.kpiSet.getMAXSCORE())) {
            fValue = fMaxValue;
        }
        if (this.kpiSet.GetParamValue("MINSCORE") != null && fValue < (fMinValue = this.kpiSet.getMINSCORE())) {
            fValue = fMinValue;
        }
        callResult.setUserObject((Object)fValue);
        KPIInstData instData = new KPIInstData();
        instData.setKPIINSTDATANAME(this.kpiSet.getKPISETID());
        instData.setKPIMPNAME(this.kpiSet.getKPISETID());
        instData.setKPIINSTID(this.kpiInst.getKPIINSTID());
        instData.setMPSCORE(callResult.getUserObject());
        ret = this.kpiDataCtrl.AddKPIInstData(instData, this.strCurOPPersonId);
        if (ret.getRetCode() != 0) {
            return ret;
        }
        return callResult;
    }

    @Override
    public GlobalHelperEx getContextHelper() {
        return this.contextHelper;
    }

    @Override
    public Integer IntV(String strMPSN) {
        CallResult callResult = this.GetMP(strMPSN);
        if (callResult.getRetCode() != 0) {
            return null;
        }
        return Integer.parseInt(callResult.getUserObject().toString());
    }

    @Override
    public String StrV(String strMPSN) {
        CallResult callResult = this.GetMP(strMPSN);
        if (callResult.getRetCode() != 0) {
            return null;
        }
        return callResult.getUserObject().toString();
    }

    @Override
    public Double DoubleV(String strMPSN) {
        CallResult callResult = this.GetMP(strMPSN);
        if (callResult.getRetCode() != 0) {
            return null;
        }
        return Double.parseDouble(callResult.getUserObject().toString());
    }

    @Override
    public String UD1() {
        return this.kpiInst.getUSERDATA();
    }

    @Override
    public String UD2() {
        return this.kpiInst.getUSERDATA2();
    }

    @Override
    public String UD3() {
        return this.kpiInst.getUSERDATA3();
    }

    @Override
    public String UD4() {
        return this.kpiInst.getUSERDATA4();
    }

    @Override
    public int BATSN() {
        return this.kpiInst.getBATSN();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public CallResult GetMP(String strMPSN) {
        Object objProcess;
        Object strObject;
        CallResult callResult = new CallResult();
        strMPSN = strMPSN.toUpperCase();
        TreeMap<String, Object> treeMap = (TreeMap<String, Object>)(TreeMap)this.mpMap;
        synchronized (treeMap) {
            if (this.mpMap.containsKey(strMPSN)) {
                callResult.setRetCode(1);
                callResult.setErrorInfo(StringHelper.Format((String)"KPI\u6d4b\u70b9[%1$s]\u5b58\u5728\u5d4c\u5957\u5f15\u7528\u5173\u7cfb\uff0c\u65e0\u6cd5\u5904\u7406", (Object)strMPSN));
                log.error((Object)callResult.getErrorInfo());
                return callResult;
            }
        }
        treeMap = this.mpValues;
        synchronized (treeMap) {
            if (this.mpValues.containsKey(strMPSN)) {
                callResult.setUserObject(this.mpValues.get(strMPSN));
                return callResult;
            }
        }
        KPIMP mp = new KPIMP();
        callResult = this.kpiDataCtrl.GetKPIMP(strMPSN, mp);
        if (callResult.getRetCode() != 0) {
            return callResult;
        }
        ISRFMPProcess iProcess = null;
        if (StringHelper.Compare((String)mp.getMPTYPE(), (String)"PROGRAM", (boolean)true) == 0) {
            strObject = mp.getCUSTOMOBJECT();
            if (StringHelper.IsNullOrEmpty((String)strObject)) {
                callResult.setRetCode(1);
                callResult.setErrorInfo(StringHelper.Format((String)"KPI\u6d4b\u70b9[%1$s]\u4e3a\u81ea\u5b9a\u4e49\u5904\u7406\uff0c\u4f46\u6ca1\u6709\u6307\u5b9a\u5904\u7406\u5bf9\u8c61", (Object)strMPSN));
                log.error((Object)callResult.getErrorInfo());
                return callResult;
            }
            objProcess = ObjectHelper.Create((String)strObject);
            if (objProcess == null) {
                callResult.setRetCode(1);
                callResult.setErrorInfo(StringHelper.Format((String)"\u65e0\u6cd5\u5efa\u7acbKPI\u6d4b\u70b9[%1$s]\u81ea\u5b9a\u4e49\u5904\u7406\u5bf9\u8c61[%2$s]", (Object)strMPSN, (Object)strObject));
                log.error((Object)callResult.getErrorInfo());
                return callResult;
            }
            if (!(objProcess instanceof ISRFMPProcess)) {
                callResult.setRetCode(1);
                callResult.setErrorInfo(StringHelper.Format((String)"KPI\u6d4b\u70b9[%1$s]\u81ea\u5b9a\u4e49\u5904\u7406\u5bf9\u8c61[%2$s]\u7c7b\u578b\u4e0d\u6b63\u786e", (Object)strMPSN, (Object)strObject));
                log.error((Object)callResult.getErrorInfo());
                return callResult;
            }
            iProcess = (ISRFMPProcess)((Object)objProcess);
        } else if (StringHelper.Compare((String)mp.getMPTYPE(), (String)"DATABASE", (boolean)true) == 0) {
            iProcess = new DatabaseMPProcess();
        } else if (StringHelper.Compare((String)mp.getMPTYPE(), (String)"FORMULA", (boolean)true) == 0) {
            iProcess = new FormulaMPProcess();
        }
        if (iProcess == null) {
            callResult.setRetCode(1);
            callResult.setErrorInfo(StringHelper.Format((String)"KPI\u6d4b\u70b9[%1$s]\u5904\u7406\u5bf9\u8c61\u65e0\u6548", (Object)strMPSN));
            log.error((Object)callResult.getErrorInfo());
            return callResult;
        }
        strObject = this.mpMap;
        synchronized (strObject) {
            this.mpMap.put(strMPSN, mp);
        }
        callResult = iProcess.Process(mp, this);
        strObject = this.mpMap;
        synchronized (strObject) {
            this.mpMap.remove(strMPSN);
        }
        if (callResult.getRetCode() == 0) {
            CallResult ret;
            Object objValue = callResult.getUserObject();
            if (objValue == null) {
                objValue = "";
                callResult.setUserObject(objValue);
            }
            objProcess = this.mpValues;
            synchronized (objProcess) {
                this.mpValues.put(strMPSN, objValue);
            }
            log.info((Object)StringHelper.Format((String)"\u8ba1\u7b97\u6d4b\u70b9[%1$s]\u5f97\u5230[%2$s]", (Object)strMPSN, (Object)objValue));
            String strUpdateCmd = mp.getUPDATECMD();
            if (!StringHelper.IsNullOrEmpty((String)strUpdateCmd) && (ret = this.UpdateToUserData(strUpdateCmd, objValue)).getRetCode() != 0) {
                return ret;
            }
        }
        return callResult;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public CallResult SetMP(String strMPSN, Object objValue) {
        CallResult callResult = new CallResult();
        strMPSN = strMPSN.toUpperCase();
        KPIMP mp = null;
        TreeMap<String, Object> treeMap = (TreeMap<String, Object>)(TreeMap)this.mpMap;
        synchronized (treeMap) {
            mp = this.mpMap.get(strMPSN);
        }
        if (mp == null) {
            callResult.setRetCode(1);
            callResult.setErrorInfo(StringHelper.Format((String)"\u83b7\u53d6KPI\u6d4b\u70b9[%1$s]\u914d\u7f6e\u6570\u636e\u5931\u8d25", (Object)strMPSN));
            log.error((Object)callResult.getErrorInfo());
            return callResult;
        }
        if (objValue == null) {
            callResult.setRetCode(1);
            callResult.setErrorInfo(StringHelper.Format((String)"\u83b7\u53d6KPI\u6d4b\u70b9[%1$s]\u8ba1\u7b97\u503c\u65e0\u6548", (Object)strMPSN));
            log.error((Object)callResult.getErrorInfo());
            return callResult;
        }
        treeMap = this.mpValues;
        synchronized (treeMap) {
            this.mpValues.put(strMPSN, objValue);
        }
        String strValue = "";
        strValue = objValue instanceof Date ? DateParser.toDateTimeString((Date)((Date)objValue)) : objValue.toString();
        KPIInstData instData = new KPIInstData();
        instData.setKPIINSTID(this.kpiInst.getKPISETID());
        instData.setKPIMPNAME(strMPSN);
        instData.setMPVALUE(strValue);
        return this.kpiDataCtrl.AddKPIInstData(instData, this.strCurOPPersonId);
    }

    protected CallResult LogAndReturn(String strFunc, String strErrorInfo, CallResult ret) {
        String strRealErrorInfo = StringHelper.Format((String)"%1$s\uff0c%2$s", (Object)strErrorInfo, (Object)(ret == null ? "\u4e0d\u660e\u9519\u8bef" : ret.getErrorInfo()));
        CallResult callResult = new CallResult();
        if (ret == null) {
            callResult.setRetCode(1);
        } else {
            callResult.setRetCode(ret.getRetCode());
        }
        callResult.setErrorInfo(strRealErrorInfo);
        return callResult;
    }

    protected CallResult LogAndReturn2(String strFunc, String strErrorInfo, Exception ex) {
        String strRealErrorInfo = StringHelper.Format((String)"%1$s\uff0c%2$s", (Object)strErrorInfo, (Object)ex.getMessage());
        CallResult callResult = new CallResult();
        callResult.setRetCode(1);
        callResult.setErrorInfo(strRealErrorInfo);
        return callResult;
    }

    public int getMaxLoopCount() {
        return this.nMaxLoopCount;
    }

    public void setMaxLoopCount(int maxLoopCount) {
        this.nMaxLoopCount = maxLoopCount;
    }
}

