/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.codelist.ICodeList
 *  net.ibizsys.paas.util.StringHelper
 *  net.ibizsys.pswf.core.IWFLinkModel
 *  net.ibizsys.pswf.core.IWFModel
 *  net.ibizsys.pswf.core.IWFProcessModel
 *  net.ibizsys.pswf.core.IWFVersionModel
 */
package net.ibizsys.pswf.core;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import net.ibizsys.paas.codelist.ICodeList;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.pswf.core.IWFLinkModel;
import net.ibizsys.pswf.core.IWFModel;
import net.ibizsys.pswf.core.IWFParallelSubWFProcessModel;
import net.ibizsys.pswf.core.IWFProcessModel;
import net.ibizsys.pswf.core.IWFVersionModel;

public abstract class WFVersionModelBase
implements IWFVersionModel {
    private String strId = "";
    private String strName = "";
    private IWFModel iWFModel = null;
    private IWFProcessModel startWFProcessModel = null;
    private ArrayList<IWFProcessModel> wfProcessModelList = new ArrayList();
    private ArrayList<IWFLinkModel> wfLinkModelList = new ArrayList();
    private HashMap<String, IWFProcessModel> wfProcessModelMap = new HashMap();
    private HashMap<String, IWFProcessModel> wfProcessModelMap2 = new HashMap();
    private int nWFVersion = 0;
    private boolean bWFParallelSubWFProcessModel = false;
    private String strWFMode = "";
    private String strBPMNModel = "";

    public void init(IWFModel iWFModel) throws Exception {
        this.iWFModel = iWFModel;
        this.onInit();
    }

    protected void onInit() throws Exception {
        this.prepareWFProcessModels();
        this.prepareWFLinkModels();
    }

    protected void prepareWFProcessModels() throws Exception {
    }

    protected void prepareWFLinkModels() throws Exception {
    }

    protected void registerWFProcessModel(IWFProcessModel iWFProcessModel) throws Exception {
        String strWFStepValue;
        String strId;
        if (iWFProcessModel.isStartProcess()) {
            if (this.getStartWFProcessModel() != null) {
                throw new Exception(StringHelper.format((String)"\u6d41\u7a0b\u6a21\u578b\u4e2d\u5df2\u7ecf\u5b58\u5728\u5f00\u59cb\u5904\u7406\uff0c\u4e0d\u80fd\u91cd\u590d\u5b9a\u4e49"));
            }
            this.setStartWFProcessModel(iWFProcessModel);
        }
        if (this.wfProcessModelMap.containsKey(strId = iWFProcessModel.getId())) {
            throw new Exception(StringHelper.format((String)"\u6d41\u7a0b\u6a21\u578b\u4e2d\u5df2\u7ecf\u5b58\u5728\u6807\u8bc6\u4e3a[%1$s]\u7684\u5904\u7406\uff0c\u4e0d\u80fd\u91cd\u590d\u5b9a\u4e49", (Object)strId));
        }
        this.wfProcessModelMap.put(strId, iWFProcessModel);
        if (!StringHelper.isNullOrEmpty((String)iWFProcessModel.getBPMNModelId())) {
            if (this.wfProcessModelMap.containsKey(iWFProcessModel.getBPMNModelId())) {
                throw new Exception(StringHelper.format((String)"\u6d41\u7a0b\u6a21\u578b\u4e2d\u5df2\u7ecf\u5b58\u5728BPMN\u6807\u8bc6\u4e3a[%1$s]\u7684\u5904\u7406\uff0c\u4e0d\u80fd\u91cd\u590d\u5b9a\u4e49", (Object)iWFProcessModel.getBPMNModelId()));
            }
            this.wfProcessModelMap.put(iWFProcessModel.getBPMNModelId(), iWFProcessModel);
        }
        if (!StringHelper.isNullOrEmpty((String)(strWFStepValue = iWFProcessModel.getWFStepValue()))) {
            if (this.wfProcessModelMap2.containsKey(strWFStepValue)) {
                throw new Exception(StringHelper.format((String)"\u6d41\u7a0b\u6a21\u578b\u4e2d\u5df2\u7ecf\u5b58\u5728\u6b65\u9aa4\u503c\u4e3a[%1$s]\u7684\u5904\u7406\uff0c\u4e0d\u80fd\u91cd\u590d\u5b9a\u4e49", (Object)strWFStepValue));
            }
            this.wfProcessModelMap2.put(strWFStepValue, iWFProcessModel);
        }
        this.wfProcessModelList.add(iWFProcessModel);
        if (!this.bWFParallelSubWFProcessModel && iWFProcessModel instanceof IWFParallelSubWFProcessModel) {
            this.bWFParallelSubWFProcessModel = true;
        }
    }

    protected void registerWFLinkModel(IWFLinkModel iWFLinkModel) throws Exception {
        IWFProcessModel iWFProcessModel = this.getWFProcessModel(iWFLinkModel.getFrom(), false);
        iWFProcessModel.registerWFLinkModel(iWFLinkModel);
        this.wfLinkModelList.add(iWFLinkModel);
    }

    public String getId() {
        return this.strId;
    }

    public String getName() {
        return this.strName;
    }

    protected void setId(String strId) {
        this.strId = strId;
    }

    protected void setName(String strName) {
        this.strName = strName;
    }

    public String getWFMode() {
        return this.strWFMode;
    }

    protected void setWFMode(String strWFMode) {
        this.strWFMode = strWFMode;
    }

    public IWFModel getWFModel() {
        return this.iWFModel;
    }

    public Iterator<IWFProcessModel> getWFProcessModels() {
        return this.wfProcessModelList.iterator();
    }

    public Iterator<IWFLinkModel> getWFLinkModels() {
        return this.wfLinkModelList.iterator();
    }

    public IWFProcessModel getWFProcessModel(String strWFProcessModelName, boolean bTryMode) throws Exception {
        IWFProcessModel iWFProcessModel = this.wfProcessModelMap.get(strWFProcessModelName);
        if (iWFProcessModel == null && !bTryMode) {
            throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u83b7\u53d6\u5de5\u4f5c\u6d41[%1$s]\u6307\u5b9a\u5904\u7406\uff0c\u6807\u8bc6\u4e3a[%2$s]", (Object)this.getName(), (Object)strWFProcessModelName));
        }
        return iWFProcessModel;
    }

    public int getWFVersion() {
        return this.nWFVersion;
    }

    public IWFProcessModel getWFProcessModelByWFStepValue(String strWFStepValue, boolean bTryMode) throws Exception {
        IWFProcessModel iWFProcessModel = this.wfProcessModelMap2.get(strWFStepValue);
        if (iWFProcessModel == null && !bTryMode) {
            throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u5904\u7406\uff0c\u6b65\u9aa4\u503c\u4e3a[%1$s]", (Object)strWFStepValue));
        }
        return iWFProcessModel;
    }

    public IWFProcessModel getStartWFProcessModel() {
        return this.startWFProcessModel;
    }

    protected void setStartWFProcessModel(IWFProcessModel startWFProcessModel) {
        this.startWFProcessModel = startWFProcessModel;
    }

    protected void setWFVersion(int nWFVersion) {
        this.nWFVersion = nWFVersion;
    }

    public boolean hasWFParallelSubWFProcessModel() {
        return this.bWFParallelSubWFProcessModel;
    }

    public String getBPMNModel() {
        return this.strBPMNModel;
    }

    protected void setBPMNModel(String strBPMNModel) {
        this.strBPMNModel = strBPMNModel;
    }

    public ICodeList getWFStepCodeList() {
        return this.getWFModel().getWFStepCodeList();
    }
}

