/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.ModelBase2Impl
 *  net.ibizsys.paas.util.StringHelper
 */
package net.ibizsys.ssdyna.core;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import net.ibizsys.paas.core.ModelBase2Impl;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.ssdyna.core.IDynaDEFormTemplModel;
import net.ibizsys.ssdyna.core.IDynaDETemplModel;
import net.ibizsys.ssdyna.core.IDynaDEViewTemplModel;

public class DynaDETemplModel
extends ModelBase2Impl
implements IDynaDETemplModel {
    private HashMap<String, IDynaDEViewTemplModel> dynaDEViewTemplModelMap = new HashMap();
    private ArrayList<IDynaDEViewTemplModel> dynaDEViewTemplModelList = new ArrayList();
    private HashMap<String, IDynaDEFormTemplModel> dynaDEFormTemplModelMap = new HashMap();
    private ArrayList<IDynaDEFormTemplModel> dynaDEFormTemplModelList = new ArrayList();
    private String strTemplDEId = null;
    private String strTemplDEName = null;

    public void setId(String strId) {
        this.strId = strId;
    }

    public void setName(String strName) {
        this.strName = strName;
    }

    public void setTemplDEId(String strTemplDEId) {
        this.strTemplDEId = strTemplDEId;
    }

    public void setTemplDEName(String strTemplDEName) {
        this.strTemplDEName = strTemplDEName;
    }

    @Override
    public String getTemplDEId() {
        return this.strTemplDEId;
    }

    @Override
    public String getTemplDEName() {
        return this.strTemplDEName;
    }

    @Override
    public void registerDynaDEViewTemplModel(IDynaDEViewTemplModel iDynaDEViewTemplModel) throws Exception {
        this.dynaDEViewTemplModelMap.put(iDynaDEViewTemplModel.getId(), iDynaDEViewTemplModel);
        this.dynaDEViewTemplModelList.add(iDynaDEViewTemplModel);
    }

    @Override
    public IDynaDEViewTemplModel getDynaDEViewTemplModel(String strDynaDEViewTemplModelId) throws Exception {
        IDynaDEViewTemplModel iDynaDEViewTemplModel = this.dynaDEViewTemplModelMap.get(strDynaDEViewTemplModelId);
        if (iDynaDEViewTemplModel == null) {
            throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u52a8\u6001\u5b9e\u4f53\u89c6\u56fe\u6a21\u677f\u5bf9\u8c61[%1$s]", (Object)strDynaDEViewTemplModelId));
        }
        return iDynaDEViewTemplModel;
    }

    @Override
    public Iterator<IDynaDEViewTemplModel> getDynaDEViewTemplModels() {
        return this.dynaDEViewTemplModelList.iterator();
    }

    @Override
    public void registerDynaDEFormTemplModel(IDynaDEFormTemplModel iDynaDEFormTemplModel) throws Exception {
        this.dynaDEFormTemplModelMap.put(iDynaDEFormTemplModel.getId(), iDynaDEFormTemplModel);
        this.dynaDEFormTemplModelList.add(iDynaDEFormTemplModel);
    }

    @Override
    public IDynaDEFormTemplModel getDynaDEFormTemplModel(String strDynaDEFormTemplModelId) throws Exception {
        IDynaDEFormTemplModel iDynaDEFormTemplModel = this.dynaDEFormTemplModelMap.get(strDynaDEFormTemplModelId);
        if (iDynaDEFormTemplModel == null) {
            throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u52a8\u6001\u5b9e\u4f53\u8868\u5355\u6a21\u677f\u5bf9\u8c61[%1$s]", (Object)strDynaDEFormTemplModelId));
        }
        return iDynaDEFormTemplModel;
    }

    @Override
    public Iterator<IDynaDEFormTemplModel> getDynaDEFormTemplModels() {
        return this.dynaDEFormTemplModelList.iterator();
    }
}

