/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.appmodel.IAppViewModel
 *  net.ibizsys.paas.core.IDERIndex
 *  net.ibizsys.paas.data.DataObject
 *  net.ibizsys.paas.data.IDataObject
 *  net.ibizsys.paas.demodel.DEModelGlobal
 *  net.ibizsys.paas.demodel.IDEWFModel
 *  net.ibizsys.paas.demodel.IDataEntityModel
 *  net.ibizsys.paas.entity.IEntity
 *  net.ibizsys.paas.util.StringHelper
 *  net.ibizsys.paas.web.AjaxActionResult
 *  net.sf.json.JSONObject
 */
package SA.SRFDA.PS.Core.JIT.Controller;

import SA.SRFDA.PS.Core.App.View.IPSAppDERedirectView;
import SA.SRFDA.PS.Core.JIT.Controller.IPSJITRedirectViewController;
import SA.SRFDA.PS.Core.JIT.Controller.PSJITViewController;
import java.util.HashMap;
import net.ibizsys.paas.appmodel.IAppViewModel;
import net.ibizsys.paas.core.IDERIndex;
import net.ibizsys.paas.data.DataObject;
import net.ibizsys.paas.data.IDataObject;
import net.ibizsys.paas.demodel.DEModelGlobal;
import net.ibizsys.paas.demodel.IDEWFModel;
import net.ibizsys.paas.demodel.IDataEntityModel;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.web.AjaxActionResult;
import net.sf.json.JSONObject;

public class PSJITRedirectViewController
extends PSJITViewController
implements IPSJITRedirectViewController {
    public static final String VIEWACTION_GETRDVIEW = "GETRDVIEW";
    private boolean bEnableWorkflow = false;
    private HashMap<String, String> rdViewMap = new HashMap();

    @Override
    protected void prepareViewParam() throws Exception {
        super.prepareViewParam();
        if (this.getPSAppView().isRedirectView() && this.getPSAppView().isPSDEView() && this.getPSAppView() instanceof IPSAppDERedirectView) {
            IPSAppDERedirectView iPSAppDERedirectView = (IPSAppDERedirectView)this.getPSAppView();
            this.setEnableWorkflow(iPSAppDERedirectView.isEnableWorkflow());
        }
    }

    protected void registerRDView(String strRDMode, String strAppViewId) {
        this.rdViewMap.put(strRDMode, strAppViewId);
    }

    protected String getRDViewId(String strRDMode) {
        return this.rdViewMap.get(strRDMode);
    }

    protected AjaxActionResult onViewAjaxAction(String strAction) throws Exception {
        if (StringHelper.compare((String)strAction, (String)VIEWACTION_GETRDVIEW, (boolean)true) == 0) {
            return this.onGetRDView();
        }
        return super.onViewAjaxAction(strAction);
    }

    protected AjaxActionResult onGetRDView() throws Exception {
        AjaxActionResult ajaxActionResult = new AjaxActionResult();
        String strKeyValue = this.getWebContext().getViewParamValue("srfkey");
        if (StringHelper.isNullOrEmpty((String)strKeyValue)) {
            strKeyValue = this.getWebContext().getViewParamValue("srfkeys");
        }
        if (StringHelper.isNullOrEmpty((String)strKeyValue)) {
            throw new Exception(StringHelper.format((String)"\u6ca1\u6709\u6307\u5b9a\u89c6\u56fe\u6570\u636e\u4e3b\u952e"));
        }
        IAppViewModel iAppViewModel = this.getRDAppViewModel(strKeyValue);
        if (iAppViewModel != null) {
            JSONObject rdview = this.getAppModel().getAppPFHelper().getAppViewJSONObject(iAppViewModel);
            ajaxActionResult.setExtAttr("rdview", (Object)rdview);
            return ajaxActionResult;
        }
        ajaxActionResult.setRetCode(5);
        ajaxActionResult.setErrorInfo("\u65e0\u6cd5\u627e\u5230\u5bf9\u5e94\u7684\u8df3\u8f6c\u89c6\u56fe");
        return ajaxActionResult;
    }

    public IAppViewModel getRDAppViewModel(String strKeyValue) throws Exception {
        String strPDTViewParam;
        IDEWFModel iDEWF;
        IEntity iEntity = this.getActiveEntity(strKeyValue);
        IDataEntityModel iRealDEModel = this.getRealDEModel(iEntity);
        if (iRealDEModel != this.getDEModel()) {
            iEntity = this.getActiveEntity(iRealDEModel, strKeyValue);
        }
        boolean bDataInWF = false;
        boolean bWFMode = false;
        if (this.isEnableWorkflow() && (iDEWF = iRealDEModel.testDataInWF(iEntity)) != null) {
            bDataInWF = true;
            bWFMode = iDEWF.testUserWFSubmit(iEntity, this.getWebContext().getCurUserId(), this.getSessionFactory());
        }
        String strRDMode = strPDTViewParam = iRealDEModel.getSDDEViewPDTParam(iEntity, bDataInWF, bWFMode);
        if (iRealDEModel != this.getDEModel()) {
            strRDMode = String.valueOf(iRealDEModel.getName()) + ":" + strPDTViewParam;
        }
        IAppViewModel iAppViewModel = null;
        String strRDViewId = this.getRDViewId(strRDMode);
        if (StringHelper.isNullOrEmpty((String)strRDViewId)) {
            String strDEViewId = iRealDEModel.getDEViewIdByPDT(strPDTViewParam, false);
            iAppViewModel = this.getAppModel().getAppViewByDEViewId(strDEViewId, false);
        } else {
            iAppViewModel = this.getAppModel().getAppView(strRDViewId, false);
        }
        return iAppViewModel;
    }

    protected IDataEntityModel getRealDEModel(IEntity iEntity) throws Exception {
        IDataEntityModel curDEModel = this.getDEModel();
        if (StringHelper.isNullOrEmpty((String)curDEModel.getIndexDEType())) {
            return curDEModel;
        }
        Object objKeyValue = iEntity.get(this.getDEModel().getKeyDEField().getName());
        while (true) {
            String strIndexType;
            if (StringHelper.isNullOrEmpty((String)(strIndexType = DataObject.getStringValue((IDataObject)iEntity, (String)curDEModel.getIndexTypeDEField().getName(), null)))) {
                throw new Exception(StringHelper.format((String)"\u5f53\u524d\u6570\u636e\u672a\u63d0\u4f9b\u7d22\u5f15\u7c7b\u578b\u503c"));
            }
            IDERIndex iDERIndex = curDEModel.getDERIndex(true, strIndexType);
            if (StringHelper.isNullOrEmpty((String)(curDEModel = DEModelGlobal.getDEModel((String)iDERIndex.getMinorDEId())).getIndexDEType())) {
                return curDEModel;
            }
            iEntity = this.getActiveEntity(curDEModel, objKeyValue);
        }
    }

    protected IEntity getActiveEntity(Object strKeyValue) throws Exception {
        IEntity iEntity = this.getService().getDEModel().createEntity();
        iEntity.set(this.getDEModel().getKeyDEField().getName(), strKeyValue);
        this.getService().get(iEntity);
        return iEntity;
    }

    protected IEntity getActiveEntity(IDataEntityModel iRealDEModel, Object strKeyValue) throws Exception {
        IEntity iEntity = iRealDEModel.createEntity();
        iEntity.set(iRealDEModel.getKeyDEField().getName(), strKeyValue);
        iRealDEModel.getService(this.getSessionFactory()).get(iEntity);
        return iEntity;
    }

    public boolean isEnableWorkflow() {
        return this.bEnableWorkflow;
    }

    protected void setEnableWorkflow(boolean bEnableWorkflow) {
        this.bEnableWorkflow = bEnableWorkflow;
    }
}

