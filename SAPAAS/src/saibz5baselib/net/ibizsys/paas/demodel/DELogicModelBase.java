/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.paas.demodel;

import net.ibizsys.paas.core.IActionContext;
import net.ibizsys.paas.core.IDataEntity;
import net.ibizsys.paas.core.ModelBase3Impl;
import net.ibizsys.paas.dao.IDAO;
import net.ibizsys.paas.demodel.IDELogicModel;
import net.ibizsys.paas.demodel.IDataEntityModel;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.service.ActionSessionManager;
import net.ibizsys.paas.service.IService;
import net.ibizsys.paas.sysmodel.ISystemModel;
import net.ibizsys.paas.util.DataTypeHelper;
import net.ibizsys.paas.util.StringHelper;

public abstract class DELogicModelBase<ET extends IEntity>
extends ModelBase3Impl
implements IDELogicModel<ET> {
    private String strDefaultParamName = null;
    private IDataEntity iDataEntity = null;

    @Override
    public void init(IDataEntity iDataEntity) throws Exception {
        this.setDataEntity(iDataEntity);
        this.onInit();
    }

    protected ISystemModel getSystemModel() {
        return (ISystemModel)this.getDataEntity().getSystem();
    }

    protected void initAnnotation(Class c) {
    }

    @Override
    public IDataEntity getDataEntity() {
        return this.iDataEntity;
    }

    protected void setDataEntity(IDataEntity iDataEntity) {
        this.iDataEntity = iDataEntity;
    }

    protected IService<ET> getService(IActionContext iActionContext) throws Exception {
        return ((IDataEntityModel)this.getDataEntity()).getService(iActionContext.getSessionFactory());
    }

    protected IDAO<ET> getDAO(IActionContext iActionContext) throws Exception {
        return this.getService(iActionContext).getDAO();
    }

    @Override
    public void execute(IActionContext iActionContext) throws Exception {
        this.onExecute(iActionContext);
    }

    protected abstract void onExecute(IActionContext var1) throws Exception;

    public static boolean testCond(Object objSrcValue, String strOP, Object strDstValue) throws Exception {
        if (StringHelper.compare(strOP, "ISNULL", true) == 0) {
            return objSrcValue == null;
        }
        if (StringHelper.compare(strOP, "ISNOTNULL", true) == 0) {
            return objSrcValue != null;
        }
        long nRet = DataTypeHelper.compare(DataTypeHelper.getObjectDataType(objSrcValue), objSrcValue, strDstValue);
        if (StringHelper.compare(strOP, "EQ", true) == 0) {
            return nRet == 0L;
        }
        if (StringHelper.compare(strOP, "NOTEQ", true) == 0) {
            return nRet != 0L;
        }
        if (StringHelper.compare(strOP, "GT", true) == 0) {
            return nRet > 0L;
        }
        if (StringHelper.compare(strOP, "GTANDEQ", true) == 0) {
            return nRet >= 0L;
        }
        if (StringHelper.compare(strOP, "LT", true) == 0) {
            return nRet < 0L;
        }
        if (StringHelper.compare(strOP, "LTANDEQ", true) == 0) {
            return nRet <= 0L;
        }
        throw new Exception(StringHelper.format("\u65e0\u6cd5\u8bc6\u522b\u7684\u8868\u8fbe\u5f0f[%1$s]", strOP));
    }

    protected void setId(String strId) {
        this.strId = strId;
    }

    protected void setName(String strName) {
        this.strName = strName;
    }

    @Override
    public String getDefaultParamName() {
        return this.strDefaultParamName;
    }

    protected void setDefaultParamName(String strDefaultParamName) {
        this.strDefaultParamName = strDefaultParamName;
    }

    protected IEntity getEnvEntity() throws Exception {
        if (ActionSessionManager.getCurrentSession() == null) {
            throw new Exception("\u5f53\u524d\u6ca1\u6709\u64cd\u4f5c\u4f1a\u8bdd");
        }
        return ActionSessionManager.getCurrentSession().getEnvEntity(true);
    }
}

