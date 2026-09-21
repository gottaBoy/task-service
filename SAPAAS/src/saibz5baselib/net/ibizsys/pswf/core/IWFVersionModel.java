/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.pswf.core;

import java.util.Iterator;
import net.ibizsys.paas.codelist.ICodeList;
import net.ibizsys.pswf.core.IWFLinkModel;
import net.ibizsys.pswf.core.IWFModel;
import net.ibizsys.pswf.core.IWFProcessModel;

public interface IWFVersionModel {
    public void init(IWFModel var1) throws Exception;

    public String getId();

    public String getName();

    public int getWFVersion();

    public IWFModel getWFModel();

    public Iterator<IWFProcessModel> getWFProcessModels();

    public Iterator<IWFLinkModel> getWFLinkModels();

    public IWFProcessModel getWFProcessModel(String var1, boolean var2) throws Exception;

    public IWFProcessModel getWFProcessModelByWFStepValue(String var1, boolean var2) throws Exception;

    public IWFProcessModel getStartWFProcessModel();

    public boolean hasWFParallelSubWFProcessModel();

    public String getWFMode();

    public String getBPMNModel();

    public ICodeList getWFStepCodeList();
}

