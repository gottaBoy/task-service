/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.codelist.ICodeList
 *  net.ibizsys.paas.core.ModelBaseImpl
 *  net.ibizsys.paas.entity.IEntity
 *  net.ibizsys.paas.sysmodel.ISystemModel
 *  net.ibizsys.paas.util.StringHelper
 *  net.ibizsys.pswf.core.IWFModel
 *  net.ibizsys.pswf.core.IWFService
 *  net.ibizsys.pswf.core.IWFVersionModel
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package net.ibizsys.pswf.core;

import java.util.HashMap;
import java.util.Iterator;
import net.ibizsys.paas.codelist.ICodeList;
import net.ibizsys.paas.core.ModelBaseImpl;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.sysmodel.ISystemModel;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.pswf.core.IWFModel;
import net.ibizsys.pswf.core.IWFService;
import net.ibizsys.pswf.core.IWFVersionModel;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public abstract class WFModelBase
extends ModelBaseImpl
implements IWFModel {
    private static final Log log = LogFactory.getLog(WFModelBase.class);
    private HashMap<Integer, IWFVersionModel> wfVersionModelMap = new HashMap();
    private HashMap<String, IWFVersionModel> lastWFVersionModelMap = new HashMap();
    private HashMap<String, IWFVersionModel> wfVersionModelMap2 = new HashMap();
    private IWFVersionModel lastWFVersionModel = null;
    private ICodeList wfStepCodeList = null;
    private ICodeList entityStateCodeList = null;
    private HashMap<String, String> entityWFStateMap = new HashMap();
    private IWFService iWFService = null;
    private String strEntityWFState = "";
    private String strRemindMsgTemplId = "";
    private String strWXAccountId = "";
    private String strWXEntAppId = "";
    private Object objRuntimeId = null;
    private String strWFEngineType = "EMBEDDED";
    private String strNameLanResTag = null;
    private String strWFEngineCat = null;
    private String strDefaultDEName = null;

    protected void setId(String strId) {
        this.strId = strId;
    }

    protected void setName(String strName) {
        this.strName = strName;
    }

    public abstract ISystemModel getSystemModel();

    public IEntity createEntity(String strDEName) throws Exception {
        return this.getSystemModel().getDataEntityModel(strDEName).createEntity();
    }

    public ICodeList getWFStepCodeList() {
        return this.wfStepCodeList;
    }

    public ICodeList getEntityStateCodeList() {
        return this.entityStateCodeList;
    }

    public IWFVersionModel getLastWFVersionModel() {
        return this.lastWFVersionModel;
    }

    public IWFVersionModel getLastWFVersionModel(String strWFMode) throws Exception {
        if (StringHelper.isNullOrEmpty((String)strWFMode)) {
            return this.getLastWFVersionModel();
        }
        IWFVersionModel iWFVersionModel = this.lastWFVersionModelMap.get(strWFMode);
        if (iWFVersionModel == null) {
            log.warn((Object)StringHelper.format((String)"\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u6d41\u7a0b\u6a21\u5f0f\u7684\u6700\u65b0\u7248\u672c\u6a21\u578b\uff0c\u6a21\u5f0f\u4e3a[%1$s]", (Object)strWFMode));
            return this.getLastWFVersionModel();
        }
        return iWFVersionModel;
    }

    public IWFVersionModel getWFVersionModelByWFVersion(int nVersion) throws Exception {
        if (nVersion == -1) {
            return this.getLastWFVersionModel();
        }
        IWFVersionModel iWFVersionModel = this.wfVersionModelMap.get(nVersion);
        if (iWFVersionModel == null) {
            throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u6d41\u7a0b\u6a21\u578b\uff0c\u7248\u672c\u4e3a[%1$s]", (Object)nVersion));
        }
        return iWFVersionModel;
    }

    protected void registerWFVersionModel(IWFVersionModel iWFVersionModel) throws Exception {
        IWFVersionModel lastWFVersionModel;
        if (this.lastWFVersionModel == null || this.lastWFVersionModel.getWFVersion() < iWFVersionModel.getWFVersion()) {
            this.lastWFVersionModel = iWFVersionModel;
        }
        this.wfVersionModelMap2.put(iWFVersionModel.getId(), iWFVersionModel);
        this.wfVersionModelMap.put(iWFVersionModel.getWFVersion(), iWFVersionModel);
        if (!(StringHelper.isNullOrEmpty((String)iWFVersionModel.getWFMode()) || (lastWFVersionModel = this.lastWFVersionModelMap.get(iWFVersionModel.getWFMode())) != null && iWFVersionModel.getWFVersion() <= lastWFVersionModel.getWFVersion())) {
            this.lastWFVersionModelMap.put(iWFVersionModel.getWFMode(), iWFVersionModel);
        }
    }

    protected void setWFStepCodeList(ICodeList wfStepCodeList) {
        this.wfStepCodeList = wfStepCodeList;
    }

    protected void setEntityStateCodeList(ICodeList entityStateCodeList) {
        this.entityStateCodeList = entityStateCodeList;
    }

    public Iterator<String> getEntityWFStates() {
        return this.entityWFStateMap.keySet().iterator();
    }

    public boolean isEntityWFState(String strWFState) {
        return this.entityWFStateMap.containsKey(strWFState);
    }

    protected void registerEntityWFState(String strWFState) {
        this.entityWFStateMap.put(strWFState, "");
        if (StringHelper.isNullOrEmpty((String)this.strEntityWFState)) {
            this.strEntityWFState = strWFState;
        }
    }

    public IWFService getWFService() {
        return this.iWFService;
    }

    protected void setWFService(IWFService iWFService) {
        this.iWFService = iWFService;
    }

    public String getEntityWFState() {
        return this.strEntityWFState;
    }

    public String getRemindMsgTemplId() {
        return this.strRemindMsgTemplId;
    }

    protected void setRemindMsgTemplId(String strRemindMsgTemplId) {
        this.strRemindMsgTemplId = strRemindMsgTemplId;
    }

    public String getWXAccountId() {
        return this.strWXAccountId;
    }

    public String getWXEntAppId() {
        return this.strWXEntAppId;
    }

    protected void setWXAccountId(String strWXAccountId) {
        this.strWXAccountId = strWXAccountId;
    }

    protected void setWXEntAppId(String strWXEntAppId) {
        this.strWXEntAppId = strWXEntAppId;
    }

    public Object getRuntimeId() {
        if (this.objRuntimeId == null) {
            return this.getId();
        }
        return this.objRuntimeId;
    }

    public void setRuntimeId(Object objRuntimeId) {
        this.objRuntimeId = objRuntimeId;
    }

    public IWFVersionModel getWFVersionModel(String strWFVersionId) throws Exception {
        IWFVersionModel iWFVersionModel = this.wfVersionModelMap2.get(strWFVersionId);
        if (iWFVersionModel == null) {
            throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u6d41\u7a0b\u6a21\u578b\uff0c\u6807\u8bc6\u4e3a[%1$s]", (Object)strWFVersionId));
        }
        return iWFVersionModel;
    }

    public String getWFEngineType() {
        return this.strWFEngineType;
    }

    protected void setWFEngineType(String strWFEngineType) {
        this.strWFEngineType = strWFEngineType;
    }

    public String getNameLanResTag() {
        return this.strNameLanResTag;
    }

    protected void setNameLanResTag(String strNameLanResTag) {
        this.strNameLanResTag = strNameLanResTag;
    }

    public String getWFEngineCat() {
        if (StringHelper.isNullOrEmpty((String)this.strWFEngineCat)) {
            return this.getWFEngineType();
        }
        return this.strWFEngineCat;
    }

    protected void setWFEngineCat(String strWFEngineCat) {
        this.strWFEngineCat = strWFEngineCat;
    }

    public String getDefaultDEName() {
        return this.strDefaultDEName;
    }

    protected void setDefaultDEName(String strDefaultDEName) {
        this.strDefaultDEName = strDefaultDEName;
    }
}

