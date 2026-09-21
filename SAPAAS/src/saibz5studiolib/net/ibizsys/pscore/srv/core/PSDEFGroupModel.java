/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.ModelBase2Impl
 *  net.ibizsys.paas.util.StringHelper
 */
package net.ibizsys.pscore.srv.core;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import net.ibizsys.paas.core.ModelBase2Impl;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.pscore.srv.core.IPSDEFGroupDetailModel;
import net.ibizsys.pscore.srv.core.IPSDEFGroupModel;

public class PSDEFGroupModel
extends ModelBase2Impl
implements IPSDEFGroupModel {
    private List<IPSDEFGroupDetailModel> psDEFGroupDetailModelList = new ArrayList<IPSDEFGroupDetailModel>();
    private Map<String, IPSDEFGroupDetailModel> psDEFGroupDetailModelMap = new HashMap<String, IPSDEFGroupDetailModel>();
    private String strMemo = null;

    public void setMemo(String string) {
        this.strMemo = string;
    }

    @Override
    public String getMemo() {
        return this.strMemo;
    }

    public void setId(String string) {
        this.strId = string;
    }

    public void setName(String string) {
        this.strName = string;
    }

    public void registerPSDEFGroupDetailModel(IPSDEFGroupDetailModel iPSDEFGroupDetailModel) throws Exception {
        if (this.psDEFGroupDetailModelMap.containsKey(iPSDEFGroupDetailModel.getId())) {
            throw new Exception(StringHelper.format((String)"\u5c5e\u6027\u7ec4\u5df2\u5b58\u5728\u6807\u8bc6\u4e3a[%1$s]\u7684\u6210\u5458", (Object)iPSDEFGroupDetailModel.getId()));
        }
        if (this.psDEFGroupDetailModelMap.containsKey(iPSDEFGroupDetailModel.getName())) {
            throw new Exception(StringHelper.format((String)"\u5c5e\u6027\u7ec4\u5df2\u5b58\u5728\u540d\u79f0\u4e3a[%1$s]\u7684\u6210\u5458", (Object)iPSDEFGroupDetailModel.getName()));
        }
        this.psDEFGroupDetailModelList.add(iPSDEFGroupDetailModel);
        this.psDEFGroupDetailModelMap.put(iPSDEFGroupDetailModel.getId(), iPSDEFGroupDetailModel);
        this.psDEFGroupDetailModelMap.put(iPSDEFGroupDetailModel.getName(), iPSDEFGroupDetailModel);
    }

    @Override
    public Iterator<IPSDEFGroupDetailModel> getPSDEFGroupDetailModels() {
        if (this.psDEFGroupDetailModelList == null || this.psDEFGroupDetailModelList.size() == 0) {
            return null;
        }
        return this.psDEFGroupDetailModelList.iterator();
    }

    @Override
    public IPSDEFGroupDetailModel getPSDEFGroupDetailModel(String string, boolean bl) throws Exception {
        IPSDEFGroupDetailModel iPSDEFGroupDetailModel = this.psDEFGroupDetailModelMap.get(string);
        if (iPSDEFGroupDetailModel == null && !bl) {
            throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u83b7\u53d6\u6807\u8bc6\u6216\u540d\u79f0\u4e3a[%1$s]\u7684\u6210\u5458", (Object)string));
        }
        return iPSDEFGroupDetailModel;
    }
}

