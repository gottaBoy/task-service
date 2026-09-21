/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.paas.appmodel;

import net.ibizsys.paas.appmodel.IAppViewModel;
import net.ibizsys.paas.core.ModelBaseImpl;

public class AppViewModel
extends ModelBaseImpl
implements IAppViewModel {
    private String strTitle = null;
    private String strModuleName = null;
    private String strOpenMode = null;
    private int nWidth = 0;
    private int nHeight = 0;
    private String strViewUrl = null;
    private String strAppId = null;
    private Object objUserData = null;
    private Object objUserData2 = null;

    @Override
    public String getTitle() {
        return this.strTitle;
    }

    @Override
    public String getModuleName() {
        return this.strModuleName;
    }

    @Override
    public String getOpenMode() {
        return this.strOpenMode;
    }

    @Override
    public int getWidth() {
        return this.nWidth;
    }

    @Override
    public int getHeight() {
        return this.nHeight;
    }

    public void setTitle(String strTitle) {
        this.strTitle = strTitle;
    }

    public void setModuleName(String strModuleName) {
        this.strModuleName = strModuleName;
    }

    public void setName(String strName) {
        this.strName = strName;
    }

    public void setId(String strId) {
        this.strId = strId;
    }

    public void setOpenMode(String strOpenMode) {
        this.strOpenMode = strOpenMode;
    }

    public void setWidth(int nWidth) {
        this.nWidth = nWidth;
    }

    public void setHeight(int nHeight) {
        this.nHeight = nHeight;
    }

    @Override
    public String getViewUrl() {
        return this.strViewUrl;
    }

    public void setViewUrl(String strViewUrl) {
        this.strViewUrl = strViewUrl;
    }

    @Override
    public String getAppId() {
        return this.strAppId;
    }

    public void setAppId(String strAppId) {
        this.strAppId = strAppId;
    }

    @Override
    public Object getUserData() {
        return this.objUserData;
    }

    public void setUserData(Object objUserData) {
        this.objUserData = objUserData;
    }

    @Override
    public Object getUserData2() {
        return this.objUserData2;
    }

    public void setUserData2(Object objUserData2) {
        this.objUserData2 = objUserData2;
    }
}

