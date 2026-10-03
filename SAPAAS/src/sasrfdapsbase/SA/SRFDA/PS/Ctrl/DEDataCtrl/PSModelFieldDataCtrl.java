/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 *  SA.SRFramework.DataEx.CallResult
 *  net.ibizsys.paas.entity.IEntity
 *  net.ibizsys.paas.service.ServiceGlobal
 *  net.ibizsys.paas.util.StringHelper
 *  net.ibizsys.pscore.srv.config.entity.PSModelField
 *  net.ibizsys.pscore.srv.config.service.PSModelFieldService
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Ctrl.DEDataCtrl;

import SA.SRFDA.PS.Core.DevStudio.IPSBKTaskWork;
import SA.SRFDA.PS.Core.DevStudio.PSBKTaskWorkHelper;
import SA.SRFDA.PS.Ctrl.DEDataCtrl.PSDEDataCtrl;
import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.DataEx.CallResult;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.pscore.srv.config.entity.PSModelField;
import net.ibizsys.pscore.srv.config.service.PSModelFieldService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSModelFieldDataCtrl
extends PSDEDataCtrl {
    private static final Log log = LogFactory.getLog(PSModelFieldDataCtrl.class);
    public static final String CUSTOMCALL_SETVALID = "SETVALID";
    public static final String CUSTOMCALL_UNSETVALID = "UNSETVALID";
    public static final String CUSTOMCALL_SETCONCEPT = "SETCONCEPT";
    public static final String CUSTOMCALL_UNSETCONCEPT = "UNSETCONCEPT";

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
        if (StringHelper.compare((String)strCallName, (String)CUSTOMCALL_SETVALID, (boolean)true) == 0) {
            return this.setValid(dataEntity, true);
        }
        if (StringHelper.compare((String)strCallName, (String)CUSTOMCALL_UNSETVALID, (boolean)true) == 0) {
            return this.setValid(dataEntity, false);
        }
        if (StringHelper.compare((String)strCallName, (String)CUSTOMCALL_SETCONCEPT, (boolean)true) == 0) {
            return this.setConcept(dataEntity, true);
        }
        if (StringHelper.compare((String)strCallName, (String)CUSTOMCALL_UNSETCONCEPT, (boolean)true) == 0) {
            return this.setConcept(dataEntity, false);
        }
        return super.OnCustomCall(strCallName, dataEntity);
    }

    public CallResult setValid(final BaseDataEntity dataEntity, final boolean bValid) {
        CallResult callResult = new CallResult();
        try {
            if (this.getTransactionManager() != null) {
                this.getTransactionManager().Commit();
            }
            PSBKTaskWorkHelper.execute(new IPSBKTaskWork(){

                @Override
                public void execute(Object obj) throws Exception {
                    PSModelFieldDataCtrl.this.onSetValid(dataEntity, bValid);
                }
            });
            return callResult;
        }
        catch (Exception ex) {
            log.error((Object)StringHelper.format((String)"\u8bbe\u7f6e\u6a21\u578b\u5c5e\u6027\u6709\u6548\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)ex.getMessage()), (Throwable)ex);
            callResult.setRetCode(1);
            callResult.setErrorInfo(ex.getMessage());
            return callResult;
        }
    }

    protected void onSetValid(BaseDataEntity dataEntity, boolean bValid) throws Exception {
        PSModelFieldService psModelFieldService = (PSModelFieldService)ServiceGlobal.getService(PSModelFieldService.class);
        PSModelField psModelField = new PSModelField();
        psModelField.setPSModelFieldId(dataEntity.getParamStringValue("PSMODELFIELDID", ""));
        psModelField.setValidFlag(Integer.valueOf(bValid ? 1 : 0));
        psModelFieldService.update(psModelField, false);
    }

    public CallResult setConcept(final BaseDataEntity dataEntity, final boolean bConcept) {
        CallResult callResult = new CallResult();
        try {
            if (this.getTransactionManager() != null) {
                this.getTransactionManager().Commit();
            }
            PSBKTaskWorkHelper.execute(new IPSBKTaskWork(){

                @Override
                public void execute(Object obj) throws Exception {
                    PSModelFieldDataCtrl.this.onSetConcept(dataEntity, bConcept);
                }
            });
            return callResult;
        }
        catch (Exception ex) {
            log.error((Object)StringHelper.format((String)"\u8bbe\u7f6e\u6a21\u578b\u5c5e\u6027\u6982\u5ff5\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)ex.getMessage()), (Throwable)ex);
            callResult.setRetCode(1);
            callResult.setErrorInfo(ex.getMessage());
            return callResult;
        }
    }

    protected void onSetConcept(BaseDataEntity dataEntity, boolean bConcept) throws Exception {
        PSModelFieldService psModelFieldService = (PSModelFieldService)ServiceGlobal.getService(PSModelFieldService.class);
        PSModelField psModelField = new PSModelField();
        psModelField.setPSModelFieldId(dataEntity.getParamStringValue("PSMODELFIELDID", ""));
        psModelField.setConceptFlag(Integer.valueOf(bConcept ? 1 : 0));
        psModelFieldService.update(psModelField, false);
    }
}
