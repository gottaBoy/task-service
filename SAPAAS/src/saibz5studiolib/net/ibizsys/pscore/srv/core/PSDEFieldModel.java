/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.demodel.DEFieldModel
 *  net.ibizsys.paas.util.StringHelper
 */
package net.ibizsys.pscore.srv.core;

import net.ibizsys.paas.demodel.DEFieldModel;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.pscore.srv.core.IPSDEFieldModel;

public class PSDEFieldModel
extends DEFieldModel
implements IPSDEFieldModel {
    private String strMemo = null;
    private String strValueRuleName = null;
    private Integer nLength = null;
    private Integer nMaxValue = null;
    private Integer nMinValue = null;
    private String strCodeName = null;
    private String strServiceCodeName = null;
    private int nUserInputMode = 3;

    public void setMemo(String string) {
        this.strMemo = string;
    }

    @Override
    public String getMemo() {
        return this.strMemo;
    }

    public void setValueRuleName(String string) {
        this.strValueRuleName = string;
    }

    @Override
    public String getValueRuleName() {
        return this.strValueRuleName;
    }

    public void setLength(Integer n) {
        this.nLength = n;
    }

    @Override
    public Integer getLength() {
        return this.nLength;
    }

    public void setMinValue(Integer n) {
        this.nMinValue = n;
    }

    @Override
    public Integer getMinValue() {
        return this.nMinValue;
    }

    public void setMaxValue(Integer n) {
        this.nMaxValue = n;
    }

    @Override
    public Integer getMaxValue() {
        return this.nMaxValue;
    }

    @Override
    public int getUserInputMode() {
        return this.nUserInputMode;
    }

    public void setUserInputMode(int n) {
        this.nUserInputMode = n;
    }

    @Override
    public String getCodeName() {
        return this.strCodeName;
    }

    public void setCodeName(String string) {
        this.strCodeName = string;
    }

    @Override
    public String getServiceCodeName() {
        if (!StringHelper.isNullOrEmpty((String)this.strServiceCodeName)) {
            return this.strServiceCodeName;
        }
        return this.getCodeName();
    }

    public void setServiceCodeName(String string) {
        this.strServiceCodeName = string;
    }
}

