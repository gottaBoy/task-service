/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.pswf.core;

import java.util.ArrayList;
import java.util.Iterator;
import net.ibizsys.pswf.core.IWFLinkCondModel;
import net.ibizsys.pswf.core.IWFLinkGroupCondModel;
import net.ibizsys.pswf.core.WFLinkCondModelBase;

public class WFLinkGroupCondModel
extends WFLinkCondModelBase
implements IWFLinkGroupCondModel {
    private ArrayList<IWFLinkCondModel> wfLinkCondModelList = new ArrayList();
    private String strGroupOP = "AND";
    private boolean bNotMode = false;

    @Override
    public String getCondType() {
        return "GROUP";
    }

    @Override
    public String getGroupOP() {
        return this.strGroupOP;
    }

    @Override
    public boolean isNotMode() {
        return this.bNotMode;
    }

    @Override
    public Iterator<IWFLinkCondModel> getWFLinkCondModels() {
        return this.wfLinkCondModelList.iterator();
    }

    public ArrayList<IWFLinkCondModel> getWFLinkCondModelList() {
        return this.wfLinkCondModelList;
    }

    public void setGroupOP(String strGroupOP) {
        this.strGroupOP = strGroupOP;
    }

    public void setNotMode(boolean bNotMode) {
        this.bNotMode = bNotMode;
    }
}

