/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.paas.core;

import java.util.ArrayList;
import java.util.Iterator;
import net.ibizsys.paas.core.IDEDataQueryCodeCond;
import net.ibizsys.paas.core.ModelBaseImpl;

public class DEDataQueryCodeCondImpl
extends ModelBaseImpl
implements IDEDataQueryCodeCond {
    private String strDEFName = null;
    private String strCondType = null;
    private String strCondOp = null;
    private String strCondValue = null;
    private String strCustomCond = null;
    private String strPredefinedCond = null;
    private String strDEFieldExp = null;
    private boolean bNotMode = false;
    private int nStdDataType = 0;
    private String strValueFunc = null;
    private ArrayList<IDEDataQueryCodeCond> childDEDataQueryCondList = new ArrayList();

    @Override
    public String getDEFName() {
        return this.strDEFName;
    }

    @Override
    public String getCondType() {
        return this.strCondType;
    }

    @Override
    public String getCondOp() {
        return this.strCondOp;
    }

    @Override
    public String getCondValue() {
        return this.strCondValue;
    }

    public void setDEFName(String strDEFName) {
        this.strDEFName = strDEFName;
    }

    public void setCondType(String strCondType) {
        this.strCondType = strCondType;
    }

    public void setCondOp(String strCondOp) {
        this.strCondOp = strCondOp;
    }

    public void setCondValue(String strCondValue) {
        this.strCondValue = strCondValue;
    }

    @Override
    public String getCustomCond() {
        return this.strCustomCond;
    }

    public void setCustomCond(String strCustomCond) {
        this.strCustomCond = strCustomCond;
    }

    @Override
    public Iterator<IDEDataQueryCodeCond> getChildDEDataQueryConds() {
        if (this.childDEDataQueryCondList == null || this.childDEDataQueryCondList.size() == 0) {
            return null;
        }
        return this.childDEDataQueryCondList.iterator();
    }

    public void addChildDEDataQueryCond(IDEDataQueryCodeCond iDEDataQueryCond) {
        this.childDEDataQueryCondList.add(iDEDataQueryCond);
    }

    @Override
    public String getPredefindedCond() {
        return this.strPredefinedCond;
    }

    @Override
    public String getDEFieldExp() {
        return this.strDEFieldExp;
    }

    @Deprecated
    public void setPredefindedCond(String strPredefinedCond) {
        this.strPredefinedCond = strPredefinedCond;
    }

    @Override
    public String getPredefinedCode() {
        return this.strPredefinedCond;
    }

    public void setPredefinedCond(String strPredefinedCond) {
        this.strPredefinedCond = strPredefinedCond;
    }

    public void setDEFieldExp(String strDEFieldExp) {
        this.strDEFieldExp = strDEFieldExp;
    }

    @Override
    public boolean isNotMode() {
        return this.bNotMode;
    }

    public void setNotMode(boolean bNotMode) {
        this.bNotMode = bNotMode;
    }

    @Override
    public int getStdDataType() {
        return this.nStdDataType;
    }

    public void setStdDataType(int nStdDataType) {
        this.nStdDataType = nStdDataType;
    }

    @Override
    public String getValueFunc() {
        return this.strValueFunc;
    }

    public void setValueFunc(String strValueFunc) {
        this.strValueFunc = strValueFunc;
    }
}

