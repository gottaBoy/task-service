/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Ctrl.IDEDataCtrl
 *  SA.SRFramework.DataEx.BaseDataEntity
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  net.ibizsys.paas.entity.IEntity
 *  net.ibizsys.paas.service.ServiceGlobal
 *  net.ibizsys.paas.util.DateHelper
 *  net.ibizsys.pscore.srv.paasmgr.entity.PSSysModelInst
 *  net.ibizsys.pscore.srv.paasmgr.service.PSSysModelInstService
 *  net.ibizsys.pscore.srv.util.PSSysModelInstGlobal
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 *  org.hibernate.SessionFactory
 */
package SA.SRFDA.PS.Ctrl.DEDataCtrl;

import SA.SRFDA.Ctrl.IDEDataCtrl;
import SA.SRFDA.PS.Ctrl.DEDataCtrl.PSDEDataCtrl;
import SA.SRFDA.PS.Data.PSSysModelQuery;
import SA.SRFDA.PS.Data.PSSysModelQueryRet;
import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import java.util.ArrayList;
import java.util.Date;
import java.util.Vector;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.paas.util.DateHelper;
import net.ibizsys.pscore.srv.paasmgr.entity.PSSysModelInst;
import net.ibizsys.pscore.srv.paasmgr.service.PSSysModelInstService;
import net.ibizsys.pscore.srv.util.PSSysModelInstGlobal;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public class PSSysModelQueryDataCtrl
extends PSDEDataCtrl {
    private static final Log log = LogFactory.getLog(PSSysModelQueryDataCtrl.class);
    public static final String CUSTOMCALL_QUERY = "QUERY";

    @Override
    protected CallResult OnBeforeSave(boolean bInsert, String strActionMode, BaseDataEntity dataEntity, BaseDataEntity lastDataEntity) {
        CallResult callResult = super.OnBeforeSave(bInsert, strActionMode, dataEntity, lastDataEntity);
        if (callResult.isError()) {
            return callResult;
        }
        return callResult;
    }

    @Override
    protected CallResult OnCustomCall(String strCallName, BaseDataEntity dataEntity) {
        if (StringHelper.Compare((String)strCallName, (String)CUSTOMCALL_QUERY, (boolean)true) == 0) {
            return this.queryModel(dataEntity);
        }
        return super.OnCustomCall(strCallName, dataEntity);
    }

    public CallResult queryModel(BaseDataEntity dataEntity) {
        CallResult callResult = this.Get(dataEntity);
        if (callResult.IsError()) {
            return callResult;
        }
        try {
            if (this.getTransactionManager() != null) {
                this.getTransactionManager().Commit();
            }
            PSSysModelQuery psSysModelQuery = new PSSysModelQuery();
            psSysModelQuery.proxy(dataEntity);
            if (!psSysModelQuery.getVALIDFLAG()) {
                throw new Exception(StringHelper.Format((String)"[%1$s]\u6ca1\u6709\u542f\u7528", (Object)psSysModelQuery.getPSSYSMODELQUERYNAME()));
            }
            IDEDataCtrl psSysModelInstDataCtrl = this.GetRelatedDataCtrl("DE1895");
            BaseDataEntity cond = new BaseDataEntity();
            if (!StringHelper.IsNullOrEmpty((String)psSysModelQuery.getPSSVRDOMAINID())) {
                cond.setParamValue("PSSVRDOMAINID", (Object)psSysModelQuery.getPSSVRDOMAINID());
            }
            cond.setParamValue("INSTSTATE", (Object)"30");
            Vector<BaseDataEntity> psSysModelInstList = new Vector<BaseDataEntity>();
            callResult = psSysModelInstDataCtrl.Select(cond, psSysModelInstList);
            if (callResult.isError()) {
                return callResult;
            }
            String strName = DateHelper.toDateTimeString((Date)new Date());
            for (BaseDataEntity baseDataEntity : psSysModelInstList) {
                SA.SRFDA.PS.Data.PSSysModelInst psSysModelInst2 = new SA.SRFDA.PS.Data.PSSysModelInst();
                psSysModelInst2.proxy(baseDataEntity);
                if (psSysModelInst2.getMODELVER() < psSysModelQuery.getMODELVER()) continue;
                this.onQueryModel(psSysModelQuery, psSysModelInst2, StringHelper.Format((String)"\u6a21\u578b\u67e5\u8be2[%1$s]", (Object)strName));
            }
            return callResult;
        }
        catch (Exception ex) {
            log.error((Object)StringHelper.Format((String)"\u67e5\u8be2\u7cfb\u7edf\u6a21\u578b\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)ex.getMessage()), (Throwable)ex);
            callResult.setRetCode(1);
            callResult.setErrorInfo(ex.getMessage());
            return callResult;
        }
    }

    protected void onQueryModel(PSSysModelQuery psSysModelQuery, SA.SRFDA.PS.Data.PSSysModelInst psSysModelInst, String strQueryName) throws Exception {
        PSSysModelInst psSysModelInst2 = new PSSysModelInst();
        PSDEDataCtrl.convertEntity2(psSysModelInst, (IEntity)psSysModelInst2);
        SessionFactory sessionFactory = PSSysModelInstGlobal.getSessionFactory((PSSysModelInst)psSysModelInst2);
        PSSysModelInstService psSysModelInstService = (PSSysModelInstService)ServiceGlobal.getService(PSSysModelInstService.class, (SessionFactory)sessionFactory);
        ArrayList list = psSysModelInstService.select(psSysModelQuery.getQUERYCODE(), null);
        if (list.size() == 0) {
            return;
        }
        IDEDataCtrl psSysModelQueryRetDataCtrl = this.GetRelatedDataCtrl("DE1934");
        PSSysModelQueryRet psSysModelQueryRet = new PSSysModelQueryRet();
        PSDEDataCtrl.convertEntity((IEntity)list.get(0), psSysModelQueryRet);
        psSysModelQueryRet.setPSSYSMODELQUERYRETNAME(strQueryName);
        psSysModelQueryRet.setPSSYSMODELINSTID(psSysModelInst.getPSSYSMODELINSTID());
        psSysModelQueryRet.setPSSYSMODELINSTNAME(psSysModelInst.getPSSYSMODELINSTNAME());
        psSysModelQueryRet.setPSSYSMODELQUERYID(psSysModelQuery.getPSSYSMODELQUERYID());
        psSysModelQueryRet.setPSSYSMODELQUERYNAME(psSysModelQuery.getPSSYSMODELQUERYNAME());
        CallResult callResult = psSysModelQueryRetDataCtrl.Save(true, (BaseDataEntity)psSysModelQueryRet);
        if (callResult.isError()) {
            throw new Exception(StringHelper.Format((String)"\u4fdd\u5b58\u6a21\u578b\u5e93[%1$s]\u67e5\u8be2\u8bb0\u5f55\u53d1\u751f\u9519\u8bef\uff0c%2$s", (Object)psSysModelInst.getPSSYSMODELINSTNAME(), (Object)callResult.getErrorInfo()));
        }
    }
}
