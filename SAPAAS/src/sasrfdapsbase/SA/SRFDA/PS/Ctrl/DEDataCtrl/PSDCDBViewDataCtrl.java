/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Ctrl.IDEDataCtrl
 *  SA.SRFramework.DataEx.BaseDataEntity
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  net.ibizsys.paas.util.Base64Helper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Ctrl.DEDataCtrl;

import SA.SRFDA.Ctrl.IDEDataCtrl;
import SA.SRFDA.PS.Core.Database.IPSDBType;
import SA.SRFDA.PS.Core.Database.IPSDBType3;
import SA.SRFDA.PS.Core.Deploy.IPSDBDevInst;
import SA.SRFDA.PS.Ctrl.DEDataCtrl.PSDCDBInstDataCtrl;
import SA.SRFDA.PS.Ctrl.DEDataCtrl.PSDEDataCtrl;
import SA.SRFDA.PS.Data.PSDCDBView;
import SA.SRFDA.PS.Data.PSDevCenterDBInst;
import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import java.util.Vector;
import net.ibizsys.paas.util.Base64Helper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSDCDBViewDataCtrl
extends PSDEDataCtrl {
    private static final Log log = LogFactory.getLog(PSDCDBViewDataCtrl.class);
    public static final String CUSTOMCALL_GETCODE = "GETCODE";
    public static final String TAG_MODELLIST = "SRFMODELLIST";

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
        if (StringHelper.Compare((String)strCallName, (String)CUSTOMCALL_GETCODE, (boolean)true) == 0) {
            return this.getDBModelCode(dataEntity);
        }
        return super.OnCustomCall(strCallName, dataEntity);
    }

    public CallResult getDBModelCode(BaseDataEntity dataEntity) {
        CallResult callResult = new CallResult();
        try {
            if (this.getTransactionManager() != null) {
                this.getTransactionManager().Commit();
            }
            String strCodeType = dataEntity.getParamStringValue("SRFCODETYPE", "");
            PSDCDBView psDCDBView = new PSDCDBView();
            psDCDBView.proxy(dataEntity);
            this.onGetDBModelCode(psDCDBView, strCodeType);
            return callResult;
        }
        catch (Exception ex) {
            log.error((Object)StringHelper.Format((String)"\u67e5\u8be2\u6570\u636e\u5e93\u4ee3\u7801\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)ex.getMessage()), (Throwable)ex);
            callResult.setRetCode(1);
            callResult.setErrorInfo(ex.getMessage());
            return callResult;
        }
    }

    protected void onGetDBModelCode(PSDCDBView psDCDBView, String strCodeType) throws Exception {
        CallResult callResult = new CallResult();
        String strPSDBDevInstId = null;
        if (psDCDBView.getPSDCDBINSTID().indexOf("JITDBINST:") != 0) {
            IDEDataCtrl psDCDBInstDataCtrl = this.GetRelatedDataCtrl("DE2015");
            PSDevCenterDBInst psDevCenterDBInst = new PSDevCenterDBInst();
            psDevCenterDBInst.setPSDEVCENTERDBINSTID(psDCDBView.getPSDCDBINSTID());
            callResult = psDCDBInstDataCtrl.Get((BaseDataEntity)psDevCenterDBInst);
            if (callResult.isError()) {
                throw new Exception(StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u5e94\u7528\u4e2d\u5fc3\u6570\u636e\u5e93\u5b9e\u4f8b"));
            }
            strPSDBDevInstId = psDevCenterDBInst.getPSDBDEVINSTID();
        } else {
            strPSDBDevInstId = psDCDBView.getPSDCDBINSTID().substring("JITDBINST:".length());
        }
        IPSDBDevInst iPSDBDevInst = this.getPSModelStorage().getPSDBDevInst(strPSDBDevInstId);
        IPSDBType iPSDBType = this.getPSModelStorage().getPSDBType(iPSDBDevInst.getDBType());
        if (!(iPSDBType instanceof IPSDBType3)) {
            throw new Exception(StringHelper.Format((String)"\u6570\u636e\u5e93\u7c7b\u578b[%1$s]\u672a\u63d0\u4f9b\u6a21\u578b\u67e5\u8be2\u80fd\u529b", (Object)iPSDBType.getName()));
        }
        IPSDBType3 iPSDBType3 = (IPSDBType3)((Object)iPSDBType);
        Vector<BaseDataEntity> modelList = new Vector<BaseDataEntity>();
        callResult = iPSDBType3.generateSQL(iPSDBDevInst, "VIEW", psDCDBView.getPSDCDBVIEWID(), strCodeType, modelList);
        if (callResult.isError()) {
            throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u6570\u636e\u5e93\u6a21\u578b\u4ee3\u7801\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
        }
        psDCDBView.set(TAG_MODELLIST, Base64Helper.encodeBytes((byte[])PSDCDBInstDataCtrl.toJsonString(modelList).getBytes()));
    }
}

