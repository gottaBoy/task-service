/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.sf.json.JSONObject
 */
package net.ibizsys.paas.controller;

import java.util.HashMap;
import net.ibizsys.paas.appmodel.IAppViewModel;
import net.ibizsys.paas.appmodel.IApplicationRuntime;
import net.ibizsys.paas.controller.IRedirectViewController;
import net.ibizsys.paas.controller.ViewControllerBase;
import net.ibizsys.paas.core.IDERIndex;
import net.ibizsys.paas.data.DataObject;
import net.ibizsys.paas.demodel.IDEWFModel;
import net.ibizsys.paas.demodel.IDataEntityModel;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.service.IService;
import net.ibizsys.paas.util.JSONObjectHelper;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.web.AjaxActionResult;
import net.sf.json.JSONObject;

public abstract class RedirectViewControllerBase
extends ViewControllerBase
implements IRedirectViewController {
    private boolean bEnableWorkflow = false;
    protected static ThreadLocal<String> rdViewKey = new ThreadLocal();
    protected static ThreadLocal<JSONObject> rdViewParam = new ThreadLocal();
    private HashMap<String, String> rdViewMap = new HashMap();

    protected void registerRDView(String strRDMode, String strAppViewId) {
        this.rdViewMap.put(strRDMode, strAppViewId);
    }

    protected String getRDViewId(String strRDMode, IDataEntityModel iDEModel, IEntity iEntity) throws Exception {
        return this.getRDViewId(strRDMode);
    }

    protected String getRDViewId(String strRDMode) {
        return this.rdViewMap.get(strRDMode);
    }

    @Override
    protected AjaxActionResult onViewAjaxAction(String strAction) throws Exception {
        if (StringHelper.compare(strAction, "GETRDVIEW", true) == 0) {
            return this.onGetRDView();
        }
        if (StringHelper.compare(strAction, "GETRDVIEWURL", true) == 0) {
            return this.onGetRDView(true);
        }
        return super.onViewAjaxAction(strAction);
    }

    protected AjaxActionResult onGetRDView() throws Exception {
        return this.onGetRDView(false);
    }

    protected AjaxActionResult onGetRDView(boolean bUrlMode) throws Exception {
        AjaxActionResult ajaxActionResult = new AjaxActionResult();
        String strKeyValue = this.getWebContext().getViewParamValue("srfkey");
        if (StringHelper.isNullOrEmpty(strKeyValue)) {
            strKeyValue = this.getWebContext().getViewParamValue("srfkeys");
        }
        if (StringHelper.isNullOrEmpty(strKeyValue)) {
            strKeyValue = this.getWebContext().getPostOrParamValue("srfkey");
        }
        if (StringHelper.isNullOrEmpty(strKeyValue)) {
            throw new Exception(StringHelper.format("\u6ca1\u6709\u6307\u5b9a\u89c6\u56fe\u6570\u636e\u4e3b\u952e"));
        }
        rdViewKey.set(null);
        rdViewParam.set(null);
        IAppViewModel iAppViewModel = this.getRDAppViewModel(strKeyValue);
        if (iAppViewModel != null) {
            if (bUrlMode) {
                HashMap<String, String> paramMap = new HashMap<String, String>();
                paramMap.put("SRFKEY", strKeyValue);
                String strViewUrl = this.getAppModel().getAppPFHelper().getAppViewUrl(iAppViewModel, paramMap);
                String strAppUrl = ((IApplicationRuntime)((Object)this.getAppModel())).getApplicationUrl();
                if (!StringHelper.isNullOrEmpty(strAppUrl)) {
                    strViewUrl = String.valueOf(strAppUrl) + strViewUrl;
                }
                ajaxActionResult.setGotoPath(strViewUrl);
            } else {
                JSONObject viewParam;
                JSONObject rdview = this.getAppModel().getAppPFHelper().getAppViewJSONObject(iAppViewModel);
                strKeyValue = rdViewKey.get();
                if (strKeyValue != null) {
                    rdview.put("srfkey", JSONObjectHelper.stripQuotes(strKeyValue, true));
                }
                if ((viewParam = rdViewParam.get()) != null) {
                    rdview.put("viewparam", (Object)viewParam);
                }
                ajaxActionResult.setExtAttr("rdview", rdview);
            }
            return ajaxActionResult;
        }
        ajaxActionResult.setRetCode(5);
        ajaxActionResult.setErrorInfo("\u65e0\u6cd5\u627e\u5230\u5bf9\u5e94\u7684\u8df3\u8f6c\u89c6\u56fe");
        return ajaxActionResult;
    }

    @Override
    public IAppViewModel getRDAppViewModel(String strKeyValue) throws Exception {
        IDEWFModel iDEWF;
        IEntity iEntity = this.getActiveEntity(strKeyValue);
        IDataEntityModel iRealDEModel = this.getRealDEModel(iEntity);
        if (iRealDEModel != this.getRealDEModel()) {
            iEntity = this.getActiveEntity(iRealDEModel, strKeyValue);
        }
        boolean bDataInWF = false;
        boolean bWFMode = false;
        if (this.isEnableWorkflow() && (iDEWF = iRealDEModel.testDataInWF(iEntity)) != null) {
            bDataInWF = true;
            bWFMode = iDEWF.testUserWFSubmit(iEntity, this.getWebContext().getCurUserId(), this.getSessionFactory());
        }
        String strPDTViewParam = this.getDESDDEViewPDTParam(iRealDEModel, iEntity, bDataInWF, bWFMode);
        Object objNewKey = iEntity.get("srfkey");
        if (!StringHelper.isNullOrEmpty(objNewKey)) {
            rdViewKey.set(DataObject.getStringValue(objNewKey));
        }
        String strRDMode = strPDTViewParam;
        if (iRealDEModel != this.getDEModel()) {
            strRDMode = String.valueOf(iRealDEModel.getName()) + ":" + strPDTViewParam;
        }
        IAppViewModel iAppViewModel = null;
        String strRDViewId = this.getRDViewId(strRDMode, iRealDEModel, iEntity);
        if (StringHelper.isNullOrEmpty(strRDViewId)) {
            String strDEViewId = iRealDEModel.getDEViewIdByPDT(strPDTViewParam, false);
            iAppViewModel = this.getAppModel().getAppViewByDEViewId(strDEViewId, false);
        } else {
            iAppViewModel = this.getAppModel().getAppView(strRDViewId, false);
        }
        return iAppViewModel;
    }

    protected String getDESDDEViewPDTParam(IDataEntityModel iDEModel, IEntity iEntity, boolean bDataInWF, boolean bWFWorkMode) throws Exception {
        return iDEModel.getSDDEViewPDTParam(iEntity, bDataInWF, bWFWorkMode, this.getAppModel().getAppType());
    }

    protected IDataEntityModel getRealDEModel(IEntity iEntity) throws Exception {
        IDataEntityModel curDEModel = this.getRealDEModel();
        if (StringHelper.isNullOrEmpty(curDEModel.getIndexDEType())) {
            return curDEModel;
        }
        Object objKeyValue = iEntity.get(curDEModel.getKeyDEField().getName());
        while (true) {
            String strIndexType;
            if (StringHelper.isNullOrEmpty(strIndexType = DataObject.getStringValue(iEntity, curDEModel.getIndexTypeDEField().getName(), null))) {
                throw new Exception(StringHelper.format("\u5f53\u524d\u6570\u636e\u672a\u63d0\u4f9b\u7d22\u5f15\u7c7b\u578b\u503c"));
            }
            IDERIndex iDERIndex = curDEModel.getDERIndex(true, strIndexType);
            curDEModel = this.getSystemModel().getDataEntityModel(iDERIndex.getMinorDEId());
            if (StringHelper.isNullOrEmpty(curDEModel.getIndexDEType())) {
                return curDEModel;
            }
            iEntity = this.getActiveEntity(curDEModel, objKeyValue);
        }
    }

    protected IEntity getActiveEntity(Object strKeyValue) throws Exception {
        IService iService = this.getRealService();
        Object iEntity = iService.getDEModel().createEntity();
        iEntity.set(iService.getDEModel().getKeyDEField().getName(), strKeyValue);
        iService.get(iEntity);
        return iEntity;
    }

    public IService getRealService() {
        return this.getService();
    }

    public IDataEntityModel getRealDEModel() {
        return this.getDEModel();
    }

    protected IEntity getActiveEntity(IDataEntityModel iRealDEModel, Object strKeyValue) throws Exception {
        Object iEntity = iRealDEModel.createEntity();
        iEntity.set(iRealDEModel.getKeyDEField().getName(), strKeyValue);
        IService iService = iRealDEModel.getService(this.getSessionFactory());
        if (!iService.autoGet(iEntity, true)) {
            throw new Exception(StringHelper.format("\u65e0\u6cd5\u83b7\u53d6\u4f20\u5165\u6570\u636e"));
        }
        return iEntity;
    }

    @Override
    public boolean isEnableWorkflow() {
        return this.bEnableWorkflow;
    }

    protected void setEnableWorkflow(boolean bEnableWorkflow) {
        this.bEnableWorkflow = bEnableWorkflow;
    }
}

