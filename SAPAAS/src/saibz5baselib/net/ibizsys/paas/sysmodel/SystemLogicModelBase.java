/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.paas.sysmodel;

import java.util.Properties;
import net.ibizsys.paas.core.IActionContext;
import net.ibizsys.paas.core.ModelBaseImpl;
import net.ibizsys.paas.sysmodel.ISystemLogicModel;
import net.ibizsys.paas.sysmodel.ISystemModel;
import net.ibizsys.paas.util.PropertiesHelper;

public abstract class SystemLogicModelBase
extends ModelBaseImpl
implements ISystemLogicModel {
    private ISystemModel iSystemModel = null;
    private String strLogicParams = null;
    protected Properties logicParams = null;
    private String strUniqueTag = null;

    @Override
    public void init(ISystemModel iSystemModel) throws Exception {
        this.iSystemModel = iSystemModel;
        this.onInit();
    }

    @Override
    protected void onInit() throws Exception {
        this.logicParams = PropertiesHelper.load(this.strLogicParams);
        super.onInit();
    }

    public void setLogicParams(String strLogicParams) throws Exception {
        this.strLogicParams = strLogicParams;
    }

    protected Properties getLogicParams() {
        return this.logicParams;
    }

    @Override
    public ISystemModel getSystemModel() {
        return this.iSystemModel;
    }

    @Override
    public String getUniqueTag() {
        return this.strUniqueTag;
    }

    public void setUniqueTag(String strUniqueTag) {
        this.strUniqueTag = strUniqueTag;
    }

    @Override
    public void execute(IActionContext iActionContext, Object objParam) throws Exception {
        this.onExecute(iActionContext, objParam);
    }

    protected abstract void onExecute(IActionContext var1, Object var2) throws Exception;
}

