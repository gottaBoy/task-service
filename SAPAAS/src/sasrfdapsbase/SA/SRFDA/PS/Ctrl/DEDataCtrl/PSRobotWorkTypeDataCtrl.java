/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 *  SA.SRFramework.DataEx.CallResult
 *  net.ibizsys.paas.db.ISelectCond
 *  net.ibizsys.paas.db.SelectCond
 *  net.ibizsys.paas.entity.IEntity
 *  net.ibizsys.paas.service.ServiceGlobal
 *  net.ibizsys.paas.util.StringHelper
 *  net.ibizsys.pscore.srv.config.entity.PSDCBKType
 *  net.ibizsys.pscore.srv.config.entity.PSRobotWorkType
 *  net.ibizsys.pscore.srv.config.entity.PSSysDevBTType
 *  net.ibizsys.pscore.srv.config.service.PSDCBKTypeService
 *  net.ibizsys.pscore.srv.config.service.PSRobotWorkTypeService
 *  net.ibizsys.pscore.srv.config.service.PSSysDevBTTypeService
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Ctrl.DEDataCtrl;

import SA.SRFDA.PS.Core.DevStudio.IPSBKTaskWork;
import SA.SRFDA.PS.Core.DevStudio.PSBKTaskWorkHelper;
import SA.SRFDA.PS.Ctrl.DEDataCtrl.PSDEDataCtrl;
import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.DataEx.CallResult;
import java.util.ArrayList;
import net.ibizsys.paas.db.ISelectCond;
import net.ibizsys.paas.db.SelectCond;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.pscore.srv.config.entity.PSDCBKType;
import net.ibizsys.pscore.srv.config.entity.PSRobotWorkType;
import net.ibizsys.pscore.srv.config.entity.PSSysDevBTType;
import net.ibizsys.pscore.srv.config.service.PSDCBKTypeService;
import net.ibizsys.pscore.srv.config.service.PSRobotWorkTypeService;
import net.ibizsys.pscore.srv.config.service.PSSysDevBTTypeService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSRobotWorkTypeDataCtrl
extends PSDEDataCtrl {
    private static final Log log = LogFactory.getLog(PSRobotWorkTypeDataCtrl.class);
    public static final String CUSTOMCALL_INITLIST = "INITLIST";

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
        if (StringHelper.compare((String)strCallName, (String)CUSTOMCALL_INITLIST, (boolean)true) == 0) {
            return this.initList();
        }
        return super.OnCustomCall(strCallName, dataEntity);
    }

    public CallResult initList() {
        CallResult callResult = new CallResult();
        try {
            if (this.getTransactionManager() != null) {
                this.getTransactionManager().Commit();
            }
            PSBKTaskWorkHelper.execute(new IPSBKTaskWork(){

                @Override
                public void execute(Object obj) throws Exception {
                    PSRobotWorkTypeDataCtrl.this.onInitList();
                }
            });
            return callResult;
        }
        catch (Exception ex) {
            log.error((Object)StringHelper.format((String)"\u521d\u59cb\u5316\u673a\u5668\u4eba\u5de5\u4f5c\u7c7b\u578b\u5217\u8868\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)ex.getMessage()), (Throwable)ex);
            callResult.setRetCode(1);
            callResult.setErrorInfo(ex.getMessage());
            return callResult;
        }
    }

    protected void onInitList() throws Exception {
        PSSysDevBTTypeService psSysDevBTTypeService = (PSSysDevBTTypeService)ServiceGlobal.getService(PSSysDevBTTypeService.class);
        PSDCBKTypeService psDCBKTypeService = (PSDCBKTypeService)ServiceGlobal.getService(PSDCBKTypeService.class);
        PSRobotWorkTypeService psRobotWorkTypeService = (PSRobotWorkTypeService)ServiceGlobal.getService(PSRobotWorkTypeService.class);
        ArrayList<PSSysDevBTType> psSysDevBTTypeList = psSysDevBTTypeService.select((ISelectCond)new SelectCond());
        for (PSSysDevBTType psSysDevBTType : psSysDevBTTypeList) {
            PSRobotWorkType psRobotWorkType = new PSRobotWorkType();
            psRobotWorkType.setPSRobotWorkTypeId("SYSBKTASK|" + psSysDevBTType.getPSSysDevBTTypeId());
            if (psRobotWorkTypeService.checkKey(psRobotWorkType) != 0) continue;
            psRobotWorkType.setPSRobotWorkTypeName(psSysDevBTType.getPSSysDevBTTypeName());
            psRobotWorkType.setValidFlag(Integer.valueOf(1));
            psRobotWorkType.setUserTag("SYSBKTASK");
            psRobotWorkType.setUserTag2(psSysDevBTType.getPSSysDevBTTypeId());
            psRobotWorkType.setEnergy(Integer.valueOf(0));
            psRobotWorkTypeService.create(psRobotWorkType);
        }
        ArrayList<PSDCBKType> psDCBKTypeList = psDCBKTypeService.select((ISelectCond)new SelectCond());
        for (PSDCBKType psDCBKType : psDCBKTypeList) {
            PSRobotWorkType psRobotWorkType = new PSRobotWorkType();
            psRobotWorkType.setPSRobotWorkTypeId("DCBKTASK|" + psDCBKType.getPSDCBKTypeId());
            if (psRobotWorkTypeService.checkKey(psRobotWorkType) != 0) continue;
            psRobotWorkType.setPSRobotWorkTypeName(psDCBKType.getPSDCBKTypeName());
            psRobotWorkType.setValidFlag(Integer.valueOf(1));
            psRobotWorkType.setUserTag("DCBKTASK");
            psRobotWorkType.setUserTag2(psDCBKType.getPSDCBKTypeId());
            psRobotWorkType.setEnergy(Integer.valueOf(0));
            psRobotWorkTypeService.create(psRobotWorkType);
        }
    }

    @Override
    protected void onReloadModel(BaseDataEntity dataEntity) throws Exception {
        String strPSRobotWorkTypeId = dataEntity.getParamStringValue("PSROBOTWORKTYPEID", "");
        this.getPSModelStorage().resetPSRobotWorkType(strPSRobotWorkTypeId);
        this.getPSModelStorage().getPSRobotWorkType(strPSRobotWorkTypeId, false);
    }
}
