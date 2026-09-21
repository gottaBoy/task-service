/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.controller.RedirectViewControllerBase
 *  net.ibizsys.paas.core.IDERIndex
 *  net.ibizsys.paas.core.IDEWF
 *  net.ibizsys.paas.data.DataObject
 *  net.ibizsys.paas.data.IDataObject
 *  net.ibizsys.paas.demodel.IDataEntityModel
 *  net.ibizsys.paas.entity.IEntity
 *  net.ibizsys.paas.service.IService
 *  net.ibizsys.paas.util.StringHelper
 *  net.ibizsys.paas.web.AjaxActionResult
 *  net.ibizsys.pswf.core.IWFModel
 *  net.ibizsys.pswf.core.IWFVersionModel
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package net.ibizsys.pswf.controller;

import net.ibizsys.paas.controller.RedirectViewControllerBase;
import net.ibizsys.paas.core.IDERIndex;
import net.ibizsys.paas.core.IDEWF;
import net.ibizsys.paas.data.DataObject;
import net.ibizsys.paas.data.IDataObject;
import net.ibizsys.paas.demodel.IDataEntityModel;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.service.IService;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.web.AjaxActionResult;
import net.ibizsys.pswf.controller.IWFDEViewController;
import net.ibizsys.pswf.core.IWFModel;
import net.ibizsys.pswf.core.IWFVersionModel;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public abstract class WFDataRedirectViewControllerBase
extends RedirectViewControllerBase
implements IWFDEViewController {
    private static final Log log = LogFactory.getLog(WFDataRedirectViewControllerBase.class);
    private IWFModel iWFModel = null;
    private IDEWF iDEWF = null;
    private boolean bWFIAMode = false;
    private String strWFStepValue = "";
    private int nWFVersion = -1;
    private ThreadLocal<IDataEntityModel> curDEModel = new ThreadLocal();

    public WFDataRedirectViewControllerBase() throws Exception {
        this.setEnableWorkflow(true);
    }

    protected AjaxActionResult onGetRDView(boolean bUrlMode) throws Exception {
        String strDEId = this.getWebContext().getViewParamValue("srfdeid");
        if (StringHelper.isNullOrEmpty((String)strDEId)) {
            strDEId = this.getWebContext().getPostOrParamValue("srfdeid");
        }
        if (StringHelper.isNullOrEmpty((String)strDEId)) {
            throw new Exception(StringHelper.format((String)"\u6ca1\u6709\u6307\u5b9a\u6570\u636e\u5b9e\u4f53"));
        }
        this.curDEModel.set(this.getSystemModel().getDataEntityModel(strDEId));
        return super.onGetRDView(bUrlMode);
    }

    public IDataEntityModel getRealDEModel() {
        return this.curDEModel.get();
    }

    public IService getRealService() {
        try {
            return this.getRealDEModel().getService(this.getSessionFactory());
        }
        catch (Exception e) {
            log.error((Object)e.getMessage(), (Throwable)e);
            return null;
        }
    }

    @Override
    public IWFModel getWFModel() {
        return this.iWFModel;
    }

    protected void setWFModel(IWFModel iWFModel) {
        this.iWFModel = iWFModel;
    }

    @Override
    public IWFVersionModel getWFVersionModel() {
        return this.getWFModel().getLastWFVersionModel();
    }

    @Override
    public boolean isWFIAMode() {
        return this.bWFIAMode;
    }

    protected void setWFIAMode(boolean bWFIAMode) {
        this.bWFIAMode = bWFIAMode;
    }

    @Override
    public IDEWF getDEWF() {
        return this.iDEWF;
    }

    protected void setDEWF(IDEWF iDEWF) {
        this.iDEWF = iDEWF;
    }

    @Override
    public String getWFStepValue() {
        return this.strWFStepValue;
    }

    public void setWFStepValue(String strWFStepValue) {
        this.strWFStepValue = strWFStepValue;
    }

    @Override
    public int getWFVersion() {
        return this.nWFVersion;
    }

    public void setWFVersion(int nWFVersion) {
        this.nWFVersion = nWFVersion;
    }

    protected IDataEntityModel getRealDEModel(IEntity iEntity) throws Exception {
        IDataEntityModel curDEModel = this.getRealDEModel();
        if (StringHelper.isNullOrEmpty((String)curDEModel.getIndexDEType())) {
            return curDEModel;
        }
        Object objKeyValue = iEntity.get(curDEModel.getKeyDEField().getName());
        while (true) {
            String strIndexType;
            if (StringHelper.isNullOrEmpty((String)(strIndexType = DataObject.getStringValue((IDataObject)iEntity, (String)curDEModel.getIndexTypeDEField().getName(), null)))) {
                throw new Exception(StringHelper.format((String)"\u5f53\u524d\u6570\u636e\u672a\u63d0\u4f9b\u7d22\u5f15\u7c7b\u578b\u503c"));
            }
            IDERIndex iDERIndex = curDEModel.getDERIndex(true, strIndexType);
            curDEModel = this.getSystemModel().getDataEntityModel(iDERIndex.getMinorDEId());
            if (StringHelper.isNullOrEmpty((String)curDEModel.getIndexDEType())) {
                return curDEModel;
            }
            iEntity = this.getActiveEntity(curDEModel, objKeyValue);
        }
    }
}

