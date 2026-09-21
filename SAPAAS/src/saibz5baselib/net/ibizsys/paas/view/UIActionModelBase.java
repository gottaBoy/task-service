/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.paas.view;

import net.ibizsys.paas.core.ModelBase3Impl;
import net.ibizsys.paas.view.IUIActionModel;

public abstract class UIActionModelBase
extends ModelBase3Impl
implements IUIActionModel {
    private String strUIActionTag = null;
    private String strUIActionType = null;
    private String strUIActionMode = null;
    private String strCaption = null;
    private String strTooltip = null;
    private String strCapLanResTag = null;
    private String strTooltipLanResTag = null;
    private String strActionTarget = null;
    private String strIconCls = null;
    private String strIconPath = null;
    private String strIconClsX = null;
    private String strIconPathX = null;
    private boolean bEnableRuntimeModel = false;
    private boolean bClosePopupView = false;

    @Override
    public String getUIActionTag() {
        return this.strUIActionTag;
    }

    @Override
    public String getUIActionType() {
        return this.strUIActionType;
    }

    @Override
    public String getUIActionMode() {
        return this.strUIActionMode;
    }

    @Override
    public String getCaption() {
        return this.strCaption;
    }

    @Override
    public String getTooltip() {
        return this.strTooltip;
    }

    @Override
    public String getCapLanResTag() {
        return this.strCapLanResTag;
    }

    @Override
    public String getTooltipLanResTag() {
        return this.strTooltipLanResTag;
    }

    @Override
    public String getActionTarget() {
        return this.strActionTarget;
    }

    @Override
    public String getIconCls() {
        return this.strIconCls;
    }

    @Override
    public String getIconPath() {
        return this.strIconPath;
    }

    @Override
    public String getIconClsX() {
        return this.strIconClsX;
    }

    @Override
    public String getIconPathX() {
        return this.strIconPathX;
    }

    public void setUIActionTag(String strUIActionTag) {
        this.strUIActionTag = strUIActionTag;
    }

    public void setUIActionType(String strUIActionType) {
        this.strUIActionType = strUIActionType;
    }

    public void setUIActionMode(String strUIActionMode) {
        this.strUIActionMode = strUIActionMode;
    }

    public void setCaption(String strCaption) {
        this.strCaption = strCaption;
    }

    public void setTooltip(String strTooltip) {
        this.strTooltip = strTooltip;
    }

    public void setCapLanResTag(String strCapLanResTag) {
        this.strCapLanResTag = strCapLanResTag;
    }

    public void setTooltipLanResTag(String strTooltipLanResTag) {
        this.strTooltipLanResTag = strTooltipLanResTag;
    }

    public void setActionTarget(String strActionTarget) {
        this.strActionTarget = strActionTarget;
    }

    public void setIconCls(String strIconCls) {
        this.strIconCls = strIconCls;
    }

    public void setIconPath(String strIconPath) {
        this.strIconPath = strIconPath;
    }

    public void setIconClsX(String strIconClsX) {
        this.strIconClsX = strIconClsX;
    }

    public void setIconPathX(String strIconPathX) {
        this.strIconPathX = strIconPathX;
    }

    @Override
    public boolean isEnableRuntimeModel() {
        return this.bEnableRuntimeModel;
    }

    public void setEnableRuntimeModel(boolean bEnableRuntimeModel) {
        this.bEnableRuntimeModel = bEnableRuntimeModel;
    }

    @Override
    public boolean isClosePopupView() {
        return this.bClosePopupView;
    }

    public void setClosePopupView(boolean bClosePopupView) {
        this.bClosePopupView = bClosePopupView;
    }
}

