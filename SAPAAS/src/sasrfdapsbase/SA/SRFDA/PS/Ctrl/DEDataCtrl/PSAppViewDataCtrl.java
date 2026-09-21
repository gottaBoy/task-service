/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Ctrl.IDEDataCtrl
 *  SA.SRFramework.DataEx.BaseDataEntity
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Ctrl.DEDataCtrl;

import SA.SRFDA.Ctrl.IDEDataCtrl;
import SA.SRFDA.PS.Core.App.IPSApplication;
import SA.SRFDA.PS.Core.App.View.IPSAppView;
import SA.SRFDA.PS.Core.IPSDevSlnSys;
import SA.SRFDA.PS.Core.IPSSystem;
import SA.SRFDA.PS.Core.PF.IPSPF;
import SA.SRFDA.PS.Core.PF.IPSPFStyle;
import SA.SRFDA.PS.Core.PF.IPSPFViewTempl;
import SA.SRFDA.PS.Core.Pub.IPSPFViewCodePublisher;
import SA.SRFDA.PS.Core.Pub.PSPublishContextImpl;
import SA.SRFDA.PS.Ctrl.DEDataCtrl.PSModelDEDataCtrl;
import SA.SRFDA.PS.Data.PSAppView;
import SA.SRFDA.PS.Data.PSDataEntity;
import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import java.util.Iterator;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSAppViewDataCtrl
extends PSModelDEDataCtrl {
    private static final Log log = LogFactory.getLog(PSAppViewDataCtrl.class);
    public static final String CUSTOMCALL_GENERATECODE = "GENERATECODE";

    @Override
    protected CallResult OnBeforeSave(boolean bInsert, String strActionMode, BaseDataEntity dataEntity, BaseDataEntity lastDataEntity) {
        CallResult callResult = super.OnBeforeSave(bInsert, strActionMode, dataEntity, lastDataEntity);
        if (callResult.isError()) {
            return callResult;
        }
        return callResult;
    }

    @Override
    protected CallResult OnAfterSaveOK(boolean bInsert, String strActionMode, BaseDataEntity dataEntity, BaseDataEntity lastDataEntity) {
        CallResult callResult = super.OnAfterSaveOK(bInsert, strActionMode, dataEntity, lastDataEntity);
        if (callResult.isError()) {
            return callResult;
        }
        if (bInsert) {
            PSDataEntity psDataEntity = new PSDataEntity();
            psDataEntity.proxy(dataEntity);
        }
        return callResult;
    }

    protected CallResult OnBeforeRemove(String strActionMode, BaseDataEntity dataEntity) {
        return super.OnBeforeRemove(strActionMode, dataEntity);
    }

    protected CallResult OnAfterRemoveOK(String strActionMode, BaseDataEntity dataEntity) {
        return super.OnAfterRemoveOK(strActionMode, dataEntity);
    }

    @Override
    protected CallResult OnCustomCall(String strCallName, BaseDataEntity dataEntity) {
        if (StringHelper.Compare((String)strCallName, (String)CUSTOMCALL_GENERATECODE, (boolean)true) == 0) {
            return this.generateCode(dataEntity);
        }
        return super.OnCustomCall(strCallName, dataEntity);
    }

    public CallResult generateCode(BaseDataEntity dataEntity) {
        CallResult callResult = new CallResult();
        PSAppView psAppView = new PSAppView();
        psAppView.proxy(dataEntity);
        try {
            this.onGenerateCode(psAppView);
            return callResult;
        }
        catch (Exception ex) {
            log.error((Object)StringHelper.Format((String)"\u751f\u6210\u89c6\u56fe[%1$s]\u4ee3\u7801\u53d1\u751f\u5f02\u5e38\uff0c%2$s", (Object)psAppView.getPSAPPVIEWNAME(), (Object)ex.getMessage()), (Throwable)ex);
            callResult.setRetCode(1);
            callResult.setErrorInfo(ex.getMessage());
            return callResult;
        }
    }

    protected void onGenerateCode(PSAppView psAppView) throws Exception {
        IPSApplication iPSApplication = null;
        IPSSystem iPSSystem = null;
        IPSAppView iPSAppView = null;
        String strPSDevSlnSysId = psAppView.getParamStringValue("PSDEVSLNSYSID", "");
        if (StringHelper.IsNullOrEmpty((String)strPSDevSlnSysId)) {
            iPSSystem = this.getPSModelStorage().getPSSystem(psAppView.getPSSYSTEMID());
        } else {
            IPSDevSlnSys iPSDevSlnSys = this.getPSModelStorage().getPSDevSlnSys(strPSDevSlnSysId);
            iPSSystem = iPSDevSlnSys.getPSSystem(false);
        }
        iPSApplication = iPSSystem.getPSApplication(psAppView.getPSSYSAPPID());
        iPSAppView = iPSApplication.getPSAppView(psAppView.getPSAPPVIEWID(), null);
        if (!StringHelper.IsNullOrEmpty((String)iPSAppView.getSubAppFolderName())) {
            return;
        }
        IPSPF iPSPF = iPSApplication.getPSPF();
        IPSPFStyle iPSPFStyle = iPSAppView.getPSPFStyle();
        PSPublishContextImpl psPublishContextImpl = new PSPublishContextImpl((IDEDataCtrl)this);
        psPublishContextImpl.setPSSysModelInstId(iPSSystem.getPSSysModelInstId());
        Iterator<IPSPFViewTempl> psPFViewTempls = iPSPFStyle.getPSPFViewTempls(iPSAppView);
        while (psPFViewTempls.hasNext()) {
            IPSPFViewTempl iPSPFViewTempl = psPFViewTempls.next();
            IPSPFViewCodePublisher iPSPFViewCodePublisher = iPSPFViewTempl.getPSPFViewCodePublisher();
            iPSPFViewCodePublisher.generateCode(psPublishContextImpl, iPSAppView);
            iPSPFViewCodePublisher.close();
        }
    }
}

