/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.hibernate.SessionFactory
 */
package net.ibizsys.paas.demodel;

import java.util.ArrayList;
import net.ibizsys.paas.core.IDataEntity;
import net.ibizsys.paas.demodel.IDEUIActionModel;
import net.ibizsys.paas.demodel.IDataEntityModel;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.view.UIActionModelBase;
import net.ibizsys.paas.web.AjaxActionResult;
import net.ibizsys.paas.web.UIActionModelAjaxActionResult;
import org.hibernate.SessionFactory;

public abstract class DEUIActionModelBase<ET extends IEntity>
extends UIActionModelBase
implements IDEUIActionModel<ET> {
    private IDataEntity iDataEntity = null;
    private boolean bReloadData = false;
    private String strDEActionName = "";
    private String strSuccessMsg = null;
    private String strDataAccessAction = null;
    private boolean bCloseEditView = false;
    private boolean bGlobalUIAction = false;

    @Override
    public void init(IDataEntity iDataEntity) throws Exception {
        this.setDataEntity(iDataEntity);
        this.onInit();
    }

    @Override
    protected void onInit() throws Exception {
    }

    protected void initAnnotation(Class c) {
    }

    @Override
    public IDataEntityModel<ET> getDEModel() {
        return (IDataEntityModel)this.getDataEntity();
    }

    @Override
    public IDataEntity getDataEntity() {
        return this.iDataEntity;
    }

    protected void setDataEntity(IDataEntity iDataEntity) {
        this.iDataEntity = iDataEntity;
    }

    @Override
    public String getDEActionName() {
        return this.strDEActionName;
    }

    public void setDEActionName(String strDEActionName) {
        this.strDEActionName = strDEActionName;
    }

    @Override
    public void execute(ArrayList<ET> entities, SessionFactory sessionFactory) throws Exception {
        this.onExecute(entities, sessionFactory);
    }

    protected void onExecute(ArrayList<ET> entities, SessionFactory sessionFactory) throws Exception {
        if (StringHelper.compare(this.getActionTarget(), "NONE", true) == 0) {
            ET et = this.getDEModel().createEntity();
            this.getDEModel().getService(sessionFactory).executeAction(this.getDEActionName(), (IEntity)et);
        } else if (StringHelper.compare(this.getActionTarget(), "SINGLEKEY", true) == 0 || StringHelper.compare(this.getActionTarget(), "SINGLEDATA", true) == 0 || StringHelper.compare(this.getActionTarget(), "MULTIKEY", true) == 0 || StringHelper.compare(this.getActionTarget(), "MULTIDATA", true) == 0) {
            this.getDEModel().getService(sessionFactory).executeAction(this.getDEActionName(), entities);
        } else {
            throw new Exception(StringHelper.format("\u65e0\u6cd5\u8bc6\u522b\u7684\u76ee\u6807\u7c7b\u578b[%1$s]", this.getActionTarget()));
        }
    }

    @Override
    public boolean isReloadData() {
        return this.bReloadData;
    }

    public void setReloadData(boolean bReloadData) {
        this.bReloadData = bReloadData;
    }

    public void setId(String strId) {
        this.strId = strId;
    }

    public void setName(String strName) {
        this.strName = strName;
    }

    @Override
    public String getSuccessMsg() {
        return this.strSuccessMsg;
    }

    public void setSuccessMsg(String strSuccessMsg) {
        this.strSuccessMsg = strSuccessMsg;
    }

    @Override
    public String getDataAccessAction() {
        if (!StringHelper.isNullOrEmpty(this.strDataAccessAction)) {
            return this.strDataAccessAction;
        }
        if (StringHelper.compare(this.getActionTarget(), "NONE", true) == 0) {
            return "";
        }
        return "UPDATE";
    }

    public void setDataAccessAction(String strDataAccessAction) {
        this.strDataAccessAction = strDataAccessAction;
    }

    @Override
    public boolean isCloseEditView() {
        return this.bCloseEditView;
    }

    public void setCloseEditView(boolean bCloseEditView) {
        this.bCloseEditView = bCloseEditView;
    }

    @Override
    public boolean isClosePopupView() {
        return this.bCloseEditView;
    }

    @Override
    public void setClosePopupView(boolean bCloseEditView) {
        this.bCloseEditView = bCloseEditView;
    }

    @Override
    public boolean isGlobalUIAction() {
        return this.bGlobalUIAction;
    }

    public void setGlobalUIAction(boolean bGlobalUIAction) {
        this.bGlobalUIAction = bGlobalUIAction;
    }

    @Override
    public AjaxActionResult getRuntimeModelAjaxActionResult(SessionFactory sessionFactory) throws Exception {
        if (!this.isEnableRuntimeModel()) {
            throw new Exception("\u4e0d\u652f\u6301\u8fd0\u884c\u65f6\u6a21\u578b");
        }
        UIActionModelAjaxActionResult uiActionModelAjaxActionResult = new UIActionModelAjaxActionResult();
        this.onFillRuntimeModelAjaxActionResult(uiActionModelAjaxActionResult, sessionFactory);
        return uiActionModelAjaxActionResult;
    }

    protected void onFillRuntimeModelAjaxActionResult(UIActionModelAjaxActionResult uiActionModelAjaxActionResult, SessionFactory sessionFactory) throws Exception {
    }
}

