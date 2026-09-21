/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.paas.view;

import java.util.ArrayList;
import net.ibizsys.paas.controller.IViewController;
import net.ibizsys.paas.core.ISystem;
import net.ibizsys.paas.sysmodel.ISystemModel;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.view.IStaticViewMsgModel;
import net.ibizsys.paas.view.IViewMsgModel;
import net.ibizsys.paas.view.ViewMessage;

public class StaticViewMsgModel
extends ViewMessage
implements IStaticViewMsgModel {
    private String strMsgTemplateId = null;
    private String strTitleLanResTag = null;
    private ISystemModel iSystemModel = null;
    private String strUniqueTag = null;
    private int nOrderValue = 99999999;

    @Override
    public int fillViewMessages(IViewController iViewController, ArrayList<IViewMsgModel> viewMessageList) throws Exception {
        viewMessageList.add(this);
        return 1;
    }

    @Override
    public String getMsgTemplateId() {
        return this.strMsgTemplateId;
    }

    public void setMsgTemplateId(String strMsgTemplateId) {
        this.strMsgTemplateId = strMsgTemplateId;
    }

    @Override
    public String getTitleLanResTag() {
        return this.strTitleLanResTag;
    }

    public void setTitleLanResTagId(String strTitleLanResTag) {
        this.strTitleLanResTag = strTitleLanResTag;
    }

    @Override
    public void init(ISystemModel iSystemModel) throws Exception {
        this.iSystemModel = iSystemModel;
        if (!StringHelper.isNullOrEmpty(this.getUserTag()) && !StringHelper.isNullOrEmpty(this.getUserTag2())) {
            this.strUniqueTag = StringHelper.format("%1$s||%2$s", this.getUserTag(), this.getUserTag2());
        } else if (!StringHelper.isNullOrEmpty(this.getUserTag())) {
            this.strUniqueTag = this.getUserTag();
        } else if (!StringHelper.isNullOrEmpty(this.getUserTag2())) {
            this.strUniqueTag = this.getUserTag2();
        }
        this.onInit();
    }

    @Override
    public String getUniqueTag() {
        return this.strUniqueTag;
    }

    @Override
    public ISystemModel getSystemModel() {
        return this.iSystemModel;
    }

    @Override
    public ISystem getSystem() {
        return this.getSystemModel();
    }

    @Override
    public int getOrderValue() {
        return this.nOrderValue;
    }

    public void setOrderValue(int nOrderValue) {
        this.nOrderValue = nOrderValue;
    }
}

