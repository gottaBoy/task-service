/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.util.StringHelper
 */
package net.ibizsys.pswf.core;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.pswf.core.IWFLinkCondModel;
import net.ibizsys.pswf.core.IWFLinkGroupCondModel;
import net.ibizsys.pswf.core.WFLinkCustomCondModel;
import net.ibizsys.pswf.core.WFLinkGroupCondModel;
import net.ibizsys.pswf.core.WFLinkSingleCondModel;

public class RootWFLinkGroupCondModel
extends WFLinkGroupCondModel {
    protected HashMap<String, WFLinkGroupCondModel> wfLinkGroupCondModelMap = new HashMap();

    public WFLinkGroupCondModel addGroupCond(String strId, String strPId) throws Exception {
        WFLinkGroupCondModel wfLinkGroupCondModel = new WFLinkGroupCondModel();
        wfLinkGroupCondModel.setId(strId);
        wfLinkGroupCondModel.setPId(strPId);
        this.wfLinkGroupCondModelMap.put(strId, wfLinkGroupCondModel);
        if (StringHelper.isNullOrEmpty((String)strPId)) {
            this.getWFLinkCondModelList().add(wfLinkGroupCondModel);
        } else {
            WFLinkGroupCondModel parentWFLinkGroupCondModel = this.wfLinkGroupCondModelMap.get(strPId);
            if (parentWFLinkGroupCondModel == null) {
                throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u6761\u4ef6\uff0c\u6807\u8bc6\u4e3a[%1$s]", (Object)strPId));
            }
            parentWFLinkGroupCondModel.getWFLinkCondModelList().add(wfLinkGroupCondModel);
        }
        return wfLinkGroupCondModel;
    }

    public WFLinkSingleCondModel addSingleCond(String strId, String strPId) throws Exception {
        WFLinkSingleCondModel wfLinkSingleCondModel = new WFLinkSingleCondModel();
        wfLinkSingleCondModel.setId(strId);
        wfLinkSingleCondModel.setPId(strPId);
        if (StringHelper.isNullOrEmpty((String)strPId)) {
            this.getWFLinkCondModelList().add(wfLinkSingleCondModel);
        } else {
            WFLinkGroupCondModel parentWFLinkGroupCondModel = this.wfLinkGroupCondModelMap.get(strPId);
            if (parentWFLinkGroupCondModel == null) {
                throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u6761\u4ef6\uff0c\u6807\u8bc6\u4e3a[%1$s]", (Object)strPId));
            }
            parentWFLinkGroupCondModel.getWFLinkCondModelList().add(wfLinkSingleCondModel);
        }
        return wfLinkSingleCondModel;
    }

    public WFLinkCustomCondModel addCustomCond(String strId, String strPId) throws Exception {
        WFLinkCustomCondModel wfLinkCustomCondModel = new WFLinkCustomCondModel();
        wfLinkCustomCondModel.setId(strId);
        wfLinkCustomCondModel.setPId(strPId);
        if (StringHelper.isNullOrEmpty((String)strPId)) {
            this.getWFLinkCondModelList().add(wfLinkCustomCondModel);
        } else {
            WFLinkGroupCondModel parentWFLinkGroupCondModel = this.wfLinkGroupCondModelMap.get(strPId);
            if (parentWFLinkGroupCondModel == null) {
                throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u6761\u4ef6\uff0c\u6807\u8bc6\u4e3a[%1$s]", (Object)strPId));
            }
            parentWFLinkGroupCondModel.getWFLinkCondModelList().add(wfLinkCustomCondModel);
        }
        return wfLinkCustomCondModel;
    }

    public ArrayList<IWFLinkCondModel> getAllWFLinkCondModels() {
        ArrayList<IWFLinkCondModel> allItems = new ArrayList<IWFLinkCondModel>();
        for (IWFLinkCondModel iWFLinkCondModel : this.getWFLinkCondModelList()) {
            allItems.add(iWFLinkCondModel);
            if (!(iWFLinkCondModel instanceof IWFLinkGroupCondModel)) continue;
            this.fillLinkCondModels((IWFLinkGroupCondModel)iWFLinkCondModel, allItems);
        }
        return allItems;
    }

    protected void fillLinkCondModels(IWFLinkGroupCondModel iWFLinkGroupCondModel, ArrayList<IWFLinkCondModel> allItems) {
        Iterator<IWFLinkCondModel> wfLinkCondModels = iWFLinkGroupCondModel.getWFLinkCondModels();
        while (wfLinkCondModels.hasNext()) {
            IWFLinkCondModel iWFLinkCondModel = wfLinkCondModels.next();
            allItems.add(iWFLinkCondModel);
            if (!(iWFLinkCondModel instanceof IWFLinkGroupCondModel)) continue;
            this.fillLinkCondModels((IWFLinkGroupCondModel)iWFLinkCondModel, allItems);
        }
    }
}

