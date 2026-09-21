/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.paas.demodel;

import net.ibizsys.paas.core.ModelBase3Impl;
import net.ibizsys.paas.demodel.IDEFInputTipModel;

public class DEFInputTipModel
extends ModelBase3Impl
implements IDEFInputTipModel {
    private String strContent = null;
    private String strContentLanResTag = null;
    private String strMoreUrl = null;
    private boolean bEnableClose = true;
    private String strUniqueTag = null;

    public void setId(String strId) {
        this.strId = strId;
    }

    public void setName(String strName) {
        this.strName = strName;
    }

    @Override
    public String getContent() {
        return this.strContent;
    }

    @Override
    public String getContentLanResTag() {
        return this.strContentLanResTag;
    }

    @Override
    public String getMoreUrl() {
        return this.strMoreUrl;
    }

    @Override
    public boolean isEnableClose() {
        return this.bEnableClose;
    }

    public void setContent(String strContent) {
        this.strContent = strContent;
    }

    public void setContentLanResTag(String strContentLanResTag) {
        this.strContentLanResTag = strContentLanResTag;
    }

    public void setMoreUrl(String strMoreUrl) {
        this.strMoreUrl = strMoreUrl;
    }

    public void setEnableClose(boolean bEnableClose) {
        this.bEnableClose = bEnableClose;
    }

    @Override
    public String getUniqueTag() {
        return this.strUniqueTag;
    }

    public void setUniqueTag(String strUniqueTag) {
        this.strUniqueTag = strUniqueTag;
    }
}

