/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Ctrl.BaseDEDataCtrl
 *  SA.SRFDA.Ctrl.IDEDataCtrl
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFramework.Data.CallParamList
 *  SA.SRFramework.DataEx.BaseDataEntity
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  SA.SRFramework.UtilityEx.StringBuilderEx
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.TM.Ctrl;

import SA.SRFDA.Ctrl.BaseDEDataCtrl;
import SA.SRFDA.Ctrl.IDEDataCtrl;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.Data.CallParamList;
import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.UtilityEx.StringBuilderEx;
import SA.TM.Ctrl.BaseTMObject;
import SA.TM.Ctrl.Data.TMBTPlanTaskRes;
import SA.TM.Ctrl.Data.TMBTTaskRes;
import SA.TM.Ctrl.Data.TMResCD;
import SA.TM.Ctrl.Data.TMTaskRes;
import SA.TM.Ctrl.Data.TMTaskResAE;
import SA.TM.Ctrl.ITMActionContext;
import SA.TM.Ctrl.ITMComplexResHelper;
import SA.TM.Ctrl.ITMResBaseHelper;
import SA.TM.Ctrl.ITMTaskResArrangeEngine;
import SA.TM.Ctrl.Utility.TMGrooveEngine;
import java.sql.Connection;
import java.util.Hashtable;
import java.util.Vector;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 */
public class TMTaskResArrangeEngine
extends BaseTMObject
implements ITMTaskResArrangeEngine {
    private static final Log log = LogFactory.getLog(TMTaskResArrangeEngine.class);
    protected TMTaskResAE tmTaskResAE = null;
    protected String strDBStorage = "";

    @Override
    public void Init(ISRFDAGlobalHelper iDAGlobalHelper, TMTaskResAE tmTaskResAE) throws Exception {
        this.iDAGlobalHelper = iDAGlobalHelper;
        this.tmTaskResAE = tmTaskResAE;
        this.OnInit();
    }

    @Override
    protected void OnInit() throws Exception {
    }

    @Override
    public String getId() {
        return this.tmTaskResAE.getTMTASKRESAEID();
    }

    @Override
    public String getName() {
        return this.tmTaskResAE.getTMTASKRESAENAME();
    }

    @Override
    public int getVersion() {
        return this.tmTaskResAE.getVERSION();
    }

    @Override
    public void Arrange(ITMActionContext iTMActionContext, Vector<TMTaskRes> tmTaskReses) throws Exception {
        IDEDataCtrl tmTaskResDataCtrl = iTMActionContext.getDEDataCtrl("TM0115");
        this.strDBStorage = tmTaskResDataCtrl.GetDEHelper().GetDBStorage();
        for (TMTaskRes tmTaskRes : tmTaskReses) {
            if (StringHelper.IsNullOrEmpty((String)tmTaskRes.getTMRESCDID())) continue;
            tmTaskRes.setTMRESCDID("");
            CallResult callResult = tmTaskResDataCtrl.Save(false, (BaseDataEntity)tmTaskRes);
            if (!callResult.IsError()) continue;
            throw new Exception(StringHelper.Format((String)"\u4efb\u52a1\u8d44\u6e90\u89e3\u9664\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
        }
        if (iTMActionContext.getTransactionManager() != null) {
            iTMActionContext.getTransactionManager().CommitAndBegin();
        }
        for (TMTaskRes tmTaskRes : tmTaskReses) {
            String strTMResCDId = this.OnCalcResCDScore(iTMActionContext, tmTaskRes, null, null);
            if (StringHelper.IsNullOrEmpty((String)strTMResCDId)) continue;
            tmTaskRes.setTMRESCDID(strTMResCDId);
            CallResult callResult = tmTaskResDataCtrl.Save(false, (BaseDataEntity)tmTaskRes);
            if (callResult.IsError()) {
                throw new Exception(StringHelper.Format((String)"\u4efb\u52a1\u8d44\u6e90\u7ed1\u5b9a\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
            }
            if (iTMActionContext.getTransactionManager() == null) continue;
            iTMActionContext.getTransactionManager().CommitAndBegin();
        }
        if (iTMActionContext.getTransactionManager() != null) {
            iTMActionContext.getTransactionManager().CommitAndBegin();
        }
    }

    @Override
    public String CalcResCDScore(ITMActionContext iTMActionContext, TMTaskRes tmTaskRes, Hashtable<String, Float> tmResCDScoreMap, Hashtable<String, String> tmResCDScoreInfoMap) throws Exception {
        return this.OnCalcResCDScore(iTMActionContext, tmTaskRes, tmResCDScoreMap, tmResCDScoreInfoMap);
    }

    protected String OnCalcResCDScore(ITMActionContext iTMActionContext, TMTaskRes tmTaskRes, Hashtable<String, Float> tmResCDScoreMap, Hashtable<String, String> tmResCDScoreInfoMap) throws Exception {
        if (tmTaskRes.isBEGINTIMENull() || tmTaskRes.isENDTIMENull()) {
            throw new Exception(StringHelper.Format((String)"\u4efb\u52a1\u8d44\u6e90\u65f6\u95f4\u65e0\u6548"));
        }
        CallParamList callParamList = new CallParamList();
        StringBuilderEx sb = new StringBuilderEx();
        sb.Append(" select t1.TMRESCDID,t1.TMRESBASEID,t1.PRIORITY,t2.TMTASKRESID,t2.TMTASKBASEID,t2.TASKRESTYPE from SRFT_TMRESCD_BASE t1  INNER JOIN SRFT_TMTASKRES_BASE t2 on t2.TMRESCATALOGID = t1.TMRESCATALOGID where not exists ( select  * from  SRFT_TMRESBOOKING_BASE t10 where t10.BEGINTIME<t2.ENDTIME AND t10.ENDTIME>t2.BEGINTIME AND t1.TMRESBASEID= t10.TMRESBASEID  ) AND  t2.TMTASKRESID=? order by t1.PRIORITY desc ");
        callParamList.Add((Object)tmTaskRes.getTMTASKRESID());
        Vector tmResCDs = new Vector();
        CallResult callResult = BaseDEDataCtrl.SelectMultiEx((ISRFDAGlobalHelper)this.iDAGlobalHelper, (Connection)iTMActionContext.getDBConnection(this.strDBStorage), (String)this.strDBStorage, (String)sb.toString(), (Vector)callParamList.GetList(), tmResCDs, (String)TMResCD.class.getName());
        if (callResult.IsError()) {
            throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u4efb\u52a1\u8d44\u6e90\u53ef\u7528\u8d44\u6e90\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
        }
        if (tmResCDs.size() == 0) {
            log.debug((Object)StringHelper.Format((String)"\u6ca1\u6709\u627e\u5230\u4efb\u52a1\u8d44\u6e90[%1$s]\u6240\u9700\u8981\u7684\u8d44\u6e90[%2$s][%3$s]", (Object)tmTaskRes.getTMTASKBASEID(), (Object)tmTaskRes.getTASKRESTYPE(), (Object)tmTaskRes.getTMRESCATALOGID()));
            return "";
        }
        Vector<TMResCD> validResCDs = new Vector<TMResCD>();
        Hashtable<String, BaseDataEntity> tmResCDScoreParamMap = new Hashtable<String, BaseDataEntity>();
        for (TMResCD tmResCD : tmResCDs) {
            ITMResBaseHelper iTMResBaseHelper = this.getTMModelStorage().FindTMResource(tmResCD.getTMRESBASEID());
            if (iTMResBaseHelper.TestValidTime(tmTaskRes.getBEGINTIME(), tmTaskRes.getENDTIME())) {
                validResCDs.add(tmResCD);
                BaseDataEntity scoreParam = new BaseDataEntity();
                scoreParam.SetParamValue("\u6743\u503c", (Object)tmResCD.getPRIORITY());
                tmResCDScoreParamMap.put(tmResCD.getTMRESCDID(), scoreParam);
                continue;
            }
            if (tmResCDScoreMap == null) continue;
            tmResCDScoreMap.put(tmResCD.getTMRESCDID(), Float.valueOf(-1.0f));
        }
        this.OnCalcResCDScoreParam(iTMActionContext, tmTaskRes, validResCDs, tmResCDScoreParamMap);
        String strExpression = this.OnGetExpression(iTMActionContext, tmTaskRes);
        if (StringHelper.IsNullOrEmpty((String)strExpression)) {
            strExpression = "\u6743\u503c";
        }
        float fMaxValue = -1.0f;
        TMResCD bestResCD = null;
        TMGrooveEngine tmGrooveEngine = new TMGrooveEngine();
        Hashtable<String, Object> macroValueMap = new Hashtable<String, Object>();
        for (TMResCD tmResCD : validResCDs) {
            macroValueMap.clear();
            int nTempId = 1001;
            String strCurExpression = strExpression;
            BaseDataEntity scoreParam = tmResCDScoreParamMap.get(tmResCD.getTMRESCDID());
            for (Object objKey : scoreParam.getParamList().keySet()) {
                String strParamId = StringHelper.Format((String)"SRFTEMP%1$s", (Object)(++nTempId));
                macroValueMap.put(strParamId, scoreParam.GetParamValue(objKey.toString()));
                strCurExpression = strCurExpression.replace(objKey.toString(), strParamId);
            }
            Object objValue = tmGrooveEngine.Calc(macroValueMap, strCurExpression);
            if (objValue == null) {
                throw new Exception(StringHelper.Format((String)"\u65e0\u6cd5\u8ba1\u7b97\u8868\u5355\u5f0f[%1$s]\u5206\u503c", (Object)strExpression));
            }
            float fValue = Float.parseFloat(objValue.toString());
            if (fValue > 1.0E8f) {
                fValue = 1.0E8f;
            }
            if (fValue < 0.0f) {
                fValue = 0.0f;
            }
            log.debug((Object)StringHelper.Format((String)"\u8d44\u6e90\u5206\u7c7b[%1$s][%2$s]\u5f97\u5206[%3$s]", (Object)tmResCD.getTMRESCDID(), (Object)tmResCD.getTMRESBASEID(), (Object)Float.valueOf(fValue)));
            if (tmResCDScoreMap != null) {
                tmResCDScoreMap.put(tmResCD.getTMRESCDID(), Float.valueOf(fValue));
            }
            if (!(fValue > fMaxValue)) continue;
            fMaxValue = fValue;
            bestResCD = tmResCD;
        }
        if (bestResCD == null) {
            return "";
        }
        return bestResCD.getTMRESCDID();
    }

    @Override
    public String CalcResCDScore(ITMActionContext iTMActionContext, TMBTTaskRes tmBTTaskRes, TMBTPlanTaskRes tmBTPlanTaskRes, Hashtable<String, Float> tmResCDScoreMap, Hashtable<String, String> tmResCDScoreInfoMap) throws Exception {
        return this.OnCalcResCDScore(iTMActionContext, tmBTTaskRes, tmBTPlanTaskRes, tmResCDScoreMap, tmResCDScoreInfoMap);
    }

    protected String OnCalcResCDScore(ITMActionContext iTMActionContext, TMBTTaskRes tmBTTaskRes, TMBTPlanTaskRes tmBTPlanTaskRes, Hashtable<String, Float> tmResCDScoreMap, Hashtable<String, String> tmResCDScoreInfoMap) throws Exception {
        if (tmBTPlanTaskRes.isBEGINTIMENull() || tmBTPlanTaskRes.isENDTIMENull()) {
            throw new Exception(StringHelper.Format((String)"\u4efb\u52a1\u8d44\u6e90\u65f6\u95f4\u65e0\u6548"));
        }
        CallParamList callParamList = new CallParamList();
        StringBuilderEx sb = new StringBuilderEx();
        if (StringHelper.Compare((String)this.getTMModelHelper().getDBType(), (String)"DB2", (boolean)true) == 0) {
            sb.Append(" \twith rpl (TMBTPLANID,PTMBTPLANID) as  ( select TMBTPLANID,PTMBTPLANID  from SRFT_TMBTPLAN_BASE  where TMBTPLANID=? union all  select  parent.TMBTPLANID,parent.PTMBTPLANID from rpl child, SRFT_TMBTPLAN_BASE parent where child.PTMBTPLANID=parent.TMBTPLANID)  select t1.TMRESCDID,t1.TMRESBASEID,t1.PRIORITY,t2.TMBTTASKRESID,t2.TMBTTASKID,t2.TASKRESTYPE from SRFT_TMRESCD_BASE t1  INNER JOIN SRFT_TMBTTASKRES_BASE t2 on t2.TMRESCATALOGID = t1.TMRESCATALOGID  where  not exists  ( select  * from  SRFT_TMBTPLANCAL_BASE t10  INNER JOIN rpl ON t10.TMBTPLANID=rpl.TMBTPLANID  where t10.BEGINTIME<? AND t10.ENDTIME>? AND t1.TMRESBASEID= t10.TMRESBASEID \t) AND  t2.TMBTTASKRESID=? order by t1.PRIORITY desc ");
            callParamList.Add((Object)tmBTPlanTaskRes.getTMBTPLANID());
            callParamList.AddDateTime((Object)tmBTPlanTaskRes.getENDTIME());
            callParamList.AddDateTime((Object)tmBTPlanTaskRes.getBEGINTIME());
            callParamList.Add((Object)tmBTTaskRes.getTMBTTASKRESID());
        } else {
            sb.Append(" select t1.TMRESCDID,t1.TMRESBASEID,t1.PRIORITY,t2.TMBTTASKRESID,t2.TMBTTASKID,t2.TASKRESTYPE from SRFT_TMRESCD_BASE t1  INNER JOIN SRFT_TMBTTASKRES_BASE t2 on t2.TMRESCATALOGID = t1.TMRESCATALOGID  where  not exists  ( select  * from  SRFT_TMBTPLANCAL_BASE t10  where t10.tmbtplanid in (select TMBTPLANID from (select PTMBTPLANID,TMBTPLANID from srft_TMBTPLAN_base ) t connect by prior t.PTMBTPLANID = t.TMBTPLANID start with t.TMBTPLANID = ?)  AND   t10.BEGINTIME<? AND t10.ENDTIME>? AND t1.TMRESBASEID= t10.TMRESBASEID \t) AND  t2.TMBTTASKRESID=? order by t1.PRIORITY desc ");
            callParamList.Add((Object)tmBTPlanTaskRes.getTMBTPLANID());
            callParamList.AddDateTime((Object)tmBTPlanTaskRes.getENDTIME());
            callParamList.AddDateTime((Object)tmBTPlanTaskRes.getBEGINTIME());
            callParamList.Add((Object)tmBTTaskRes.getTMBTTASKRESID());
        }
        Vector tmResCDs = new Vector();
        CallResult callResult = BaseDEDataCtrl.SelectMultiEx((ISRFDAGlobalHelper)this.iDAGlobalHelper, (Connection)iTMActionContext.getDBConnection(this.strDBStorage), (String)this.strDBStorage, (String)sb.toString(), (Vector)callParamList.GetList(), tmResCDs, (String)TMResCD.class.getName());
        if (callResult.IsError()) {
            throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u4efb\u52a1\u8d44\u6e90\u53ef\u7528\u8d44\u6e90\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
        }
        if (tmResCDs.size() == 0) {
            log.debug((Object)StringHelper.Format((String)"\u6ca1\u6709\u627e\u5230\u4efb\u52a1\u8d44\u6e90[%1$s]\u6240\u9700\u8981\u7684\u8d44\u6e90[%2$s][%3$s]", (Object)tmBTTaskRes.getTMBTTASKID(), (Object)tmBTTaskRes.getTASKRESTYPE(), (Object)tmBTTaskRes.getTMRESCATALOGID()));
            return "";
        }
        Vector<TMResCD> validResCDs = new Vector<TMResCD>();
        Hashtable<String, BaseDataEntity> tmResCDScoreParamMap = new Hashtable<String, BaseDataEntity>();
        for (TMResCD tmResCD : tmResCDs) {
            ITMResBaseHelper iTMResBaseHelper = this.getTMModelStorage().FindTMResource(tmResCD.getTMRESBASEID());
            if (iTMResBaseHelper.TestValidTime(tmBTPlanTaskRes.getBEGINTIME(), tmBTPlanTaskRes.getENDTIME())) {
                if (iTMResBaseHelper.isComplexResource()) {
                    ITMComplexResHelper iTMComplexResHelper = (ITMComplexResHelper)iTMResBaseHelper;
                    callParamList.Reset();
                    sb.Reset();
                    if (StringHelper.Compare((String)this.getTMModelHelper().getDBType(), (String)"DB2", (boolean)true) == 0) {
                        sb.Append(" \twith rpl (TMBTPLANID,PTMBTPLANID) as  ( select TMBTPLANID,PTMBTPLANID  from SRFT_TMBTPLAN_BASE  where TMBTPLANID=? union all  select  parent.TMBTPLANID,parent.PTMBTPLANID from rpl child, SRFT_TMBTPLAN_BASE parent where child.PTMBTPLANID=parent.TMBTPLANID)  select count(*)  as CNT from srft_TMCOMPLEXRESDETAIL_Base t1  inner join srft_TMRESCD_BASE t2 ON t1.TMCOMPLEXRESID = t2.TMRESBASEID  where  not exists  ( select  * from  SRFT_TMBTPLANCAL_BASE t10  INNER JOIN rpl ON t10.TMBTPLANID=rpl.TMBTPLANID  where t10.BEGINTIME<? AND t10.ENDTIME>? AND t1.TMRESBASEID= t10.TMRESBASEID \t) AND  t2.TMRESCDID=? ");
                        callParamList.Add((Object)tmBTPlanTaskRes.getTMBTPLANID());
                        callParamList.AddDateTime((Object)tmBTPlanTaskRes.getENDTIME());
                        callParamList.AddDateTime((Object)tmBTPlanTaskRes.getBEGINTIME());
                        callParamList.Add((Object)tmResCD.getTMRESCDID());
                    } else {
                        sb.Append(" select count(*) as CNT from srft_TMCOMPLEXRESDETAIL_Base t1   inner join srft_TMRESCD_BASE t2 ON t1.TMCOMPLEXRESID = t2.TMRESBASEID  where  not exists  ( select  * from  SRFT_TMBTPLANCAL_BASE t10  where t10.tmbtplanid in (select TMBTPLANID from (select PTMBTPLANID,TMBTPLANID from srft_TMBTPLAN_base ) t connect by prior t.PTMBTPLANID = t.TMBTPLANID start with t.TMBTPLANID = ?)  AND   t10.BEGINTIME<? AND t10.ENDTIME>? AND t1.TMRESBASEID= t10.TMRESBASEID \t) AND  t2.TMRESCDID=?  ");
                        callParamList.Add((Object)tmBTPlanTaskRes.getTMBTPLANID());
                        callParamList.AddDateTime((Object)tmBTPlanTaskRes.getENDTIME());
                        callParamList.AddDateTime((Object)tmBTPlanTaskRes.getBEGINTIME());
                        callParamList.Add((Object)tmResCD.getTMRESCDID());
                    }
                    BaseDataEntity cnt = new BaseDataEntity();
                    callResult = BaseDEDataCtrl.SelectSingleEx((ISRFDAGlobalHelper)this.iDAGlobalHelper, (Connection)iTMActionContext.getDBConnection(this.strDBStorage), (String)this.strDBStorage, (String)sb.toString(), (Vector)callParamList.GetList(), (BaseDataEntity)cnt);
                    if (callResult.IsError()) {
                        throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u590d\u5408\u8d44\u6e90\u660e\u7ec6\u72b6\u6001\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
                    }
                    if (cnt.GetParamIntValue("CNT", 0) != iTMComplexResHelper.getComplexResDetails().size()) {
                        if (tmResCDScoreMap == null) continue;
                        tmResCDScoreMap.put(tmResCD.getTMRESCDID(), Float.valueOf(-1.0f));
                        continue;
                    }
                }
                validResCDs.add(tmResCD);
                BaseDataEntity scoreParam = new BaseDataEntity();
                scoreParam.SetParamValue("\u6743\u503c", (Object)tmResCD.getPRIORITY());
                tmResCDScoreParamMap.put(tmResCD.getTMRESCDID(), scoreParam);
                continue;
            }
            if (tmResCDScoreMap == null) continue;
            tmResCDScoreMap.put(tmResCD.getTMRESCDID(), Float.valueOf(-1.0f));
        }
        this.OnCalcResCDScoreParam(iTMActionContext, tmBTTaskRes, tmBTPlanTaskRes, validResCDs, tmResCDScoreParamMap);
        boolean bDefaultExp = false;
        String strExpression = this.OnGetExpression(iTMActionContext, tmBTTaskRes);
        if (StringHelper.IsNullOrEmpty((String)strExpression)) {
            strExpression = "\u6743\u503c";
            bDefaultExp = true;
        }
        float fMaxValue = -1.0f;
        TMResCD bestResCD = null;
        TMGrooveEngine tmGrooveEngine = new TMGrooveEngine();
        Hashtable<String, Object> macroValueMap = new Hashtable<String, Object>();
        for (TMResCD tmResCD : validResCDs) {
            float fValue = tmResCD.getPRIORITY();
            if (!bDefaultExp) {
                macroValueMap.clear();
                int nTempId = 1001;
                String strCurExpression = strExpression;
                BaseDataEntity scoreParam = tmResCDScoreParamMap.get(tmResCD.getTMRESCDID());
                for (Object objKey : scoreParam.getParamList().keySet()) {
                    String strParamId = StringHelper.Format((String)"SRFTEMP%1$s", (Object)(++nTempId));
                    macroValueMap.put(strParamId, scoreParam.GetParamValue(objKey.toString()));
                    strCurExpression = strCurExpression.replace(objKey.toString(), strParamId);
                }
                Object objValue = tmGrooveEngine.Calc(macroValueMap, strCurExpression);
                if (objValue == null) {
                    throw new Exception(StringHelper.Format((String)"\u65e0\u6cd5\u8ba1\u7b97\u8868\u5355\u5f0f[%1$s]\u5206\u503c", (Object)strExpression));
                }
                fValue = Float.parseFloat(objValue.toString());
            }
            if (fValue > 1.0E8f) {
                fValue = 1.0E8f;
            }
            if (fValue < 0.0f) {
                fValue = 0.0f;
            }
            log.debug((Object)StringHelper.Format((String)"\u8d44\u6e90\u5206\u7c7b[%1$s:%2$s][%3$s:%4$s]\u5f97\u5206[%5$s]", (Object)tmResCD.getTMRESCDID(), (Object)tmResCD.getTMRESCDNAME(), (Object)tmResCD.getTMRESBASEID(), (Object)tmResCD.getTMRESBASENAME(), (Object)Float.valueOf(fValue)));
            if (tmResCDScoreMap != null) {
                tmResCDScoreMap.put(tmResCD.getTMRESCDID(), Float.valueOf(fValue));
            }
            if (!(fValue > fMaxValue)) continue;
            fMaxValue = fValue;
            bestResCD = tmResCD;
        }
        if (bestResCD == null) {
            return "";
        }
        return bestResCD.getTMRESCDID();
    }

    protected String OnGetExpression(ITMActionContext iTMActionContext, TMTaskRes tmTaskRes) throws Exception {
        return this.tmTaskResAE.getEXP();
    }

    protected String OnGetExpression(ITMActionContext iTMActionContext, TMBTTaskRes tmBTTaskRes) throws Exception {
        return "";
    }

    protected void OnCalcResCDScoreParam(ITMActionContext iTMActionContext, TMTaskRes tmTaskRes, Vector<TMResCD> validResCDs, Hashtable<String, BaseDataEntity> tmResCDScoreParamMap) throws Exception {
    }

    protected void OnCalcResCDScoreParam(ITMActionContext iTMActionContext, TMBTTaskRes tmBTTaskRes, TMBTPlanTaskRes tmBTPlanTaskRes, Vector<TMResCD> validResCDs, Hashtable<String, BaseDataEntity> tmResCDScoreParamMap) throws Exception {
    }
}

