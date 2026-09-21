/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package net.ibizsys.paas.ctrlmodel;

import java.util.HashMap;
import java.util.Iterator;
import net.ibizsys.paas.control.IControlCustomizable;
import net.ibizsys.paas.controller.IViewController;
import net.ibizsys.paas.core.IDataEntity;
import net.ibizsys.paas.ctrlhandler.ICtrlRender;
import net.ibizsys.paas.ctrlmodel.ICtrlModel;
import net.ibizsys.paas.demodel.IDataEntityModel;
import net.ibizsys.paas.util.KeyValueHelper;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.view.IView;
import net.ibizsys.paas.web.WebContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public abstract class CtrlModelBase
implements ICtrlModel,
IControlCustomizable {
    private static final Log log = LogFactory.getLog(CtrlModelBase.class);
    private HashMap<String, Object> ctrlParams = null;
    private String strId = "";
    private String strName = "";
    private IViewController iViewController = null;
    private String strUniqueId = KeyValueHelper.genGuidEx();
    private IView iView = null;
    private boolean bEnableDynaCtrl = false;
    private boolean bEnableCustomize = false;

    @Override
    public void init(IViewController iViewController) throws Exception {
        this.setViewController(iViewController);
        this.onInit();
        this.prepareCtrlModel();
    }

    protected void onInit() throws Exception {
    }

    protected void prepareCtrlModel() throws Exception {
    }

    @Override
    public IViewController getViewController() {
        return this.iViewController;
    }

    protected void setViewController(IViewController iViewController) {
        this.iViewController = iViewController;
        if (this.iViewController == null) {
            this.iView = null;
        } else if (this.iViewController instanceof IView) {
            this.iView = (IView)((Object)this.iViewController);
        }
    }

    @Override
    public IDataEntityModel getDEModel() {
        return this.getViewController().getDEModel();
    }

    @Override
    public IView getView() {
        return this.iView;
    }

    @Override
    public IDataEntity getDataEntity() {
        return this.getDEModel();
    }

    @Override
    public String getId() {
        if (StringHelper.isNullOrEmpty(this.strId)) {
            return this.getUniqueId();
        }
        return this.strId;
    }

    protected void setId(String strId) {
        this.strId = strId;
    }

    @Override
    public String getName() {
        return this.strName;
    }

    protected void setName(String strName) {
        this.strName = strName;
    }

    protected String getUniqueId() {
        return this.strUniqueId;
    }

    @Override
    public void setCtrlParam(String strParamName, Object objValue) {
        if (this.ctrlParams == null) {
            this.ctrlParams = new HashMap();
        }
        strParamName = strParamName.toUpperCase();
        this.ctrlParams.put(strParamName, objValue);
    }

    @Override
    public Object getCtrlParam(String strParamName) {
        if (this.ctrlParams == null) {
            return null;
        }
        return this.ctrlParams.get(strParamName.toUpperCase());
    }

    @Override
    public boolean containsCtrlParam(String strParamName) {
        if (this.ctrlParams == null) {
            return false;
        }
        return this.ctrlParams.get(strParamName.toUpperCase()) != null;
    }

    @Override
    public String getCtrlParam(String strParamName, String strDefault) {
        Object objValue = this.getCtrlParam(strParamName);
        if (objValue == null) {
            return strDefault;
        }
        return objValue.toString();
    }

    @Override
    public boolean getCtrlParam(String strParamName, boolean bDefault) {
        Object objValue = this.getCtrlParam(strParamName);
        if (objValue == null) {
            return bDefault;
        }
        return StringHelper.compare(objValue.toString(), "TRUE", true) == 0;
    }

    @Override
    public int getCtrlParam(String strParamName, int nDefault) {
        Object objValue = this.getCtrlParam(strParamName);
        if (objValue == null) {
            return nDefault;
        }
        try {
            return Integer.parseInt(objValue.toString());
        }
        catch (Exception ex) {
            log.error((Object)ex);
            return nDefault;
        }
    }

    @Override
    public Iterator<String> getCtrlParamNames() {
        if (this.ctrlParams == null) {
            return null;
        }
        return this.ctrlParams.keySet().iterator();
    }

    @Override
    public ICtrlRender getCtrlRender() throws Exception {
        return this.getViewController().getAppModel().getCtrlRender(this.getControlType(), WebContext.getRender());
    }

    @Override
    public ICtrlRender getCtrlRender(String strRenderType) throws Exception {
        return this.getViewController().getAppModel().getCtrlRender(this.getControlType(), strRenderType);
    }

    public boolean isEnableDynaCtrl() {
        return this.bEnableDynaCtrl;
    }

    protected void setEnableDynaCtrl(boolean bEnableDynaCtrl) {
        this.bEnableDynaCtrl = bEnableDynaCtrl;
    }

    @Override
    public boolean isEnableCustomize() {
        return this.bEnableCustomize;
    }

    protected void setEnableCustomize(boolean bEnableCustomize) {
        this.bEnableCustomize = bEnableCustomize;
    }
}

