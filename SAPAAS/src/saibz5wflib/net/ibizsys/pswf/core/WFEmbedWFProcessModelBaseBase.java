/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.util.StringHelper
 *  net.ibizsys.pswf.core.IWFLinkModel
 */
package net.ibizsys.pswf.core;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.pswf.core.IWFEmbedWFProcessModelBase;
import net.ibizsys.pswf.core.IWFEmbedWFReturnModel;
import net.ibizsys.pswf.core.IWFLinkModel;
import net.ibizsys.pswf.core.IWFProcSubWFModel;
import net.ibizsys.pswf.core.WFProcessModelBase;

public abstract class WFEmbedWFProcessModelBaseBase
extends WFProcessModelBase
implements IWFEmbedWFProcessModelBase {
    private ArrayList<IWFEmbedWFReturnModel> wfEmbedWFReturnModelList = new ArrayList();
    private HashMap<String, IWFEmbedWFReturnModel> wfEmbedWFReturnModelMap = new HashMap();
    private ArrayList<IWFProcSubWFModel> wfProcSubWFModelList = new ArrayList();

    @Override
    public void registerWFLinkModel(IWFLinkModel iWFLinkModel) throws Exception {
        super.registerWFLinkModel(iWFLinkModel);
        if (iWFLinkModel instanceof IWFEmbedWFReturnModel) {
            IWFEmbedWFReturnModel iWFEmbedWFReturnModel = (IWFEmbedWFReturnModel)iWFLinkModel;
            this.wfEmbedWFReturnModelList.add(iWFEmbedWFReturnModel);
            this.wfEmbedWFReturnModelMap.put(iWFEmbedWFReturnModel.getReturnValue(), iWFEmbedWFReturnModel);
        }
    }

    @Override
    public IWFEmbedWFReturnModel getWFEmbedWFReturnModelByValue(String strValue, boolean bTryMode) throws Exception {
        IWFEmbedWFReturnModel iWFEmbedWFReturnModel = this.wfEmbedWFReturnModelMap.get(strValue);
        if (iWFEmbedWFReturnModel == null && !bTryMode) {
            throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u5d4c\u5165\u6d41\u7a0b\u8fd4\u56de\u8fde\u63a5\uff0c\u8fd4\u56de\u503c\u4e3a[%1$s]", (Object)strValue));
        }
        return iWFEmbedWFReturnModel;
    }

    @Override
    public Iterator<IWFProcSubWFModel> getWFProcSubWFModels() {
        return this.wfProcSubWFModelList.iterator();
    }

    public void registerWFProcSubWFModel(IWFProcSubWFModel iWFProcSubWFModel) throws Exception {
        this.wfProcSubWFModelList.add(iWFProcSubWFModel);
    }

    @Override
    public boolean isSuspendProcess() {
        return true;
    }
}

