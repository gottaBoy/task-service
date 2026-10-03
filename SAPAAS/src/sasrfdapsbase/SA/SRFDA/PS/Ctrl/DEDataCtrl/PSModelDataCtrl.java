/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 *  SA.SRFramework.DataEx.CallResult
 *  net.ibizsys.paas.entity.IEntity
 *  net.ibizsys.paas.service.ServiceGlobal
 *  net.ibizsys.paas.util.StringHelper
 *  net.ibizsys.pscore.srv.config.entity.PSModel
 *  net.ibizsys.pscore.srv.config.service.PSModelService
 *  net.ibizsys.pscore.srv.dedesign.entity.PSDataEntity
 *  net.ibizsys.pscore.srv.dedesign.service.PSDataEntityService
 *  net.ibizsys.pscore.srv.sysdesign.entity.PSSystem
 *  net.ibizsys.pscore.srv.sysdesign.entity.PSSystemBase
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
import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.pscore.srv.config.entity.PSModel;
import net.ibizsys.pscore.srv.config.service.PSModelService;
import net.ibizsys.pscore.srv.dedesign.entity.PSDataEntity;
import net.ibizsys.pscore.srv.dedesign.service.PSDataEntityService;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSystem;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSystemBase;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSModelDataCtrl
extends PSDEDataCtrl {
    private static final Log log = LogFactory.getLog(PSModelDataCtrl.class);
    public static final String CUSTOMCALL_INITLIST = "INITLIST";
    public static final String CUSTOMCALL_TOGGLESYSMODEL = "TOGGLESYSMODEL";
    public static final String CUSTOMCALL_TOGGLESYSMODEL_NONE = "TOGGLESYSMODEL_NONE";
    public static final String CUSTOMCALL_TOGGLEMODELSTATE = "TOGGLEMODELSTATE";
    public static final String CUSTOMCALL_INITMODEL = "INITMODEL";

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
        if (StringHelper.compare((String)strCallName, (String)CUSTOMCALL_TOGGLESYSMODEL, (boolean)true) == 0) {
            return this.toggleModelInstMode(dataEntity);
        }
        if (StringHelper.compare((String)strCallName, (String)CUSTOMCALL_TOGGLESYSMODEL_NONE, (boolean)true) == 0) {
            return this.toggleModelInstMode_None(dataEntity);
        }
        if (StringHelper.compare((String)strCallName, (String)CUSTOMCALL_TOGGLEMODELSTATE, (boolean)true) == 0) {
            return this.toggleModelState(dataEntity);
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
                    PSModelDataCtrl.this.onInitList();
                }
            });
            return callResult;
        }
        catch (Exception ex) {
            log.error((Object)StringHelper.format((String)"\u521d\u59cb\u5316\u5b9e\u4f53\u5217\u8868\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)ex.getMessage()), (Throwable)ex);
            callResult.setRetCode(1);
            callResult.setErrorInfo(ex.getMessage());
            return callResult;
        }
    }

    protected void onInitList() throws Exception {
        PSSystem psSystem = new PSSystem();
        psSystem.setPSSystemId("86E2A266-4D1E-49F0-A12D-D636905457A3");
        PSDataEntityService psDataEntityService = (PSDataEntityService)ServiceGlobal.getService(PSDataEntityService.class);
        ArrayList<PSDataEntity> psDataEntityList = psDataEntityService.selectByPSSystem((PSSystemBase)psSystem);
        PSModelService psModelService = (PSModelService)ServiceGlobal.getService(PSModelService.class);
        for (PSDataEntity psDataEntity : psDataEntityList) {
            PSModel psModel = new PSModel();
            psModel.setPSModelId(psDataEntity.getPSDataEntityName());
            if (!psModelService.get(psModel, true)) {
                psModel.setPSModelName(psDataEntity.getLogicName());
                psModel.setModelDEId(psDataEntity.getDESN());
                psModel.setValidFlag(Integer.valueOf(1));
                if (psDataEntity.getPSHelpModule() != null && psDataEntity.getPSHelpModule().getPSHelpPrj() != null && psDataEntity.getPSHelpModule().getPSHelpArticle() != null && !StringHelper.isNullOrEmpty((String)psDataEntity.getPSHelpModule().getPSHelpPrj().getPrjSN()) && !StringHelper.isNullOrEmpty((String)psDataEntity.getPSHelpModule().getPSHelpArticle().getArticleSN())) {
                    psModel.setArticleUrl(StringHelper.format((String)"../prjs/%1$s.htm#%2$s/", (Object)psDataEntity.getPSHelpModule().getPSHelpPrj().getPrjSN().toLowerCase(), (Object)psDataEntity.getPSHelpModule().getPSHelpArticle().getArticleSN().toLowerCase()));
                }
                psModelService.create(psModel, false);
                continue;
            }
            if (StringHelper.isNullOrEmpty((String)psModel.getArticleUrl()) && psDataEntity.getPSHelpModule() != null && psDataEntity.getPSHelpModule() != null && psDataEntity.getPSHelpModule().getPSHelpPrj() != null && psDataEntity.getPSHelpModule().getPSHelpArticle() != null && !StringHelper.isNullOrEmpty((String)psDataEntity.getPSHelpModule().getPSHelpPrj().getPrjSN()) && !StringHelper.isNullOrEmpty((String)psDataEntity.getPSHelpModule().getPSHelpArticle().getArticleSN())) {
                psModel.setArticleUrl(StringHelper.format((String)"../prjs/%1$s.htm#%2$s/", (Object)psDataEntity.getPSHelpModule().getPSHelpPrj().getPrjSN().toLowerCase(), (Object)psDataEntity.getPSHelpModule().getPSHelpArticle().getArticleSN().toLowerCase()));
            }
            psModel.setModelDEId(psDataEntity.getDESN());
            psModelService.update(psModel, false);
        }
    }

    public CallResult toggleModelState(BaseDataEntity dataEntity) {
        CallResult callResult = this.Get(dataEntity);
        if (callResult.IsError()) {
            return callResult;
        }
        try {
            if (this.getTransactionManager() != null) {
                this.getTransactionManager().Commit();
            }
            final BaseDataEntity dataEntity2 = dataEntity;
            PSBKTaskWorkHelper.execute(new IPSBKTaskWork(){

                @Override
                public void execute(Object obj) throws Exception {
                    PSModelDataCtrl.this.onToggleModelState(dataEntity2);
                }
            });
            return callResult;
        }
        catch (Exception ex) {
            log.error((Object)StringHelper.format((String)"\u5207\u6362\u6a21\u578b\u72b6\u6001\u6807\u5fd7\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)ex.getMessage()), (Throwable)ex);
            callResult.setRetCode(1);
            callResult.setErrorInfo(ex.getMessage());
            return callResult;
        }
    }

    protected void onToggleModelState(BaseDataEntity dataEntity) throws Exception {
    }

    public CallResult toggleModelInstMode(BaseDataEntity dataEntity) {
        CallResult callResult = this.Get(dataEntity);
        if (callResult.IsError()) {
            return callResult;
        }
        try {
            if (this.getTransactionManager() != null) {
                this.getTransactionManager().Commit();
            }
            final BaseDataEntity dataEntity2 = dataEntity;
            PSBKTaskWorkHelper.execute(new IPSBKTaskWork(){

                @Override
                public void execute(Object obj) throws Exception {
                    PSModelDataCtrl.this.onToggleModelInstMode(dataEntity2, -1);
                }
            });
            return callResult;
        }
        catch (Exception ex) {
            log.error((Object)StringHelper.format((String)"\u5207\u6362\u6a21\u578b\u5b9e\u4f8b\u6a21\u5f0f\u6807\u5fd7\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)ex.getMessage()), (Throwable)ex);
            callResult.setRetCode(1);
            callResult.setErrorInfo(ex.getMessage());
            return callResult;
        }
    }

    public CallResult toggleModelInstMode_None(BaseDataEntity dataEntity) {
        CallResult callResult = new CallResult();
        try {
            if (this.getTransactionManager() != null) {
                this.getTransactionManager().Commit();
            }
            final BaseDataEntity dataEntity2 = dataEntity;
            PSBKTaskWorkHelper.execute(new IPSBKTaskWork(){

                @Override
                public void execute(Object obj) throws Exception {
                    PSModelDataCtrl.this.onToggleModelInstMode(dataEntity2, 0);
                }
            });
            return callResult;
        }
        catch (Exception ex) {
            log.error((Object)StringHelper.format((String)"\u5207\u6362\u6a21\u578b\u5b9e\u4f8b\u6a21\u5f0f\u6807\u5fd7\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)ex.getMessage()), (Throwable)ex);
            callResult.setRetCode(1);
            callResult.setErrorInfo(ex.getMessage());
            return callResult;
        }
    }

    protected void onToggleModelInstMode(BaseDataEntity dataEntity, int nMode) throws Exception {
        PSModel psModel = new PSModel();
        psModel.setPSModelId(dataEntity.getParamStringValue("PSMODELID", ""));
        if (nMode == -1) {
            int nCurMode = dataEntity.GetParamIntValue("MODELINSTMODE", 0);
            nCurMode = nCurMode == 0 ? 3 : 0;
            psModel.setModelInstMode(Integer.valueOf(nCurMode));
        } else {
            psModel.setModelInstMode(Integer.valueOf(nMode));
        }
        PSModelService psModelService = (PSModelService)ServiceGlobal.getService(PSModelService.class);
        psModelService.update(psModel, false);
    }
}
