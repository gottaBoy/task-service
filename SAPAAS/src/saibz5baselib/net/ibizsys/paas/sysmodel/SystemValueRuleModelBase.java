/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.paas.sysmodel;

import java.util.Properties;
import net.ibizsys.paas.core.ModelBaseImpl;
import net.ibizsys.paas.sysmodel.ISystemModel;
import net.ibizsys.paas.sysmodel.ISystemValueRuleModel;
import net.ibizsys.paas.util.PropertiesHelper;
import net.ibizsys.paas.web.WebContext;

public abstract class SystemValueRuleModelBase
extends ModelBaseImpl
implements ISystemValueRuleModel {
    private ISystemModel iSystemModel = null;
    private String strUniqueTag = null;
    protected Properties ruleParams = null;
    private String strRuleParams = null;
    private String strRuleInfo = null;

    @Override
    public void init(ISystemModel iSystemModel) throws Exception {
        this.iSystemModel = iSystemModel;
        this.onInit();
    }

    @Override
    public ISystemModel getSystemModel() {
        return this.iSystemModel;
    }

    public void setRuleParams(String strRuleParams) {
        this.strRuleParams = strRuleParams;
    }

    @Override
    protected void onInit() throws Exception {
        this.ruleParams = PropertiesHelper.load(this.strRuleParams);
        super.onInit();
    }

    protected Properties getRuleParams() {
        return this.ruleParams;
    }

    @Override
    public String getRuleType() {
        return "CUSTOM";
    }

    @Override
    public String getUniqueTag() {
        return this.strUniqueTag;
    }

    public void setUniqueTag(String strUniqueTag) {
        this.strUniqueTag = strUniqueTag;
    }

    public void setId(String strId) {
        this.strId = strId;
    }

    public void setName(String strName) {
        this.strName = strName;
    }

    @Override
    public String getRuleInfo() {
        return this.strRuleInfo;
    }

    public void setRuleInfo(String strRuleInfo) {
        this.strRuleInfo = strRuleInfo;
    }

    protected String getLocalization(String strResId, String strDefault) {
        if (WebContext.getCurrent() != null) {
            return WebContext.getCurrent().getLocalization(strResId, null, strDefault);
        }
        return strDefault;
    }

    protected String getLocalization(String strResId, Object[] params, String strDefault) {
        if (WebContext.getCurrent() != null) {
            return WebContext.getCurrent().getLocalization(strResId, params, strDefault);
        }
        return strDefault;
    }
}

