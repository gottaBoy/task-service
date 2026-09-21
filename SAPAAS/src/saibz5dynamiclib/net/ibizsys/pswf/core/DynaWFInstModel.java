/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.codelist.ICodeList
 *  net.ibizsys.paas.util.StringHelper
 *  net.ibizsys.pswf.core.IWFVersionModel
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package net.ibizsys.pswf.core;

import java.util.HashMap;
import net.ibizsys.paas.codelist.ICodeList;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.pswf.core.IDynaWFModel;
import net.ibizsys.pswf.core.IWFVersionModel;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class DynaWFInstModel {
    private static final Log log = LogFactory.getLog(DynaWFInstModel.class);
    private HashMap<Integer, IWFVersionModel> wfVersionModelMap = new HashMap();
    private HashMap<String, IWFVersionModel> lastWFVersionModelMap = new HashMap();
    private HashMap<String, IWFVersionModel> wfVersionModelMap2 = new HashMap();
    private String strDynaSysInstId = null;
    private IWFVersionModel lastWFVersionModel = null;
    private ICodeList wfStepCodeList = null;
    private ICodeList entityStateCodeList = null;
    private String strEntityWFState = "";
    private String strRemindMsgTemplId = "";
    private String strWXAccountId = "";
    private String strWXEntAppId = "";

    public DynaWFInstModel(IDynaWFModel iDynaWFModel, String strDynaSysInstId) {
        this.strDynaSysInstId = strDynaSysInstId;
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

    public void registerWFVersionModel(IWFVersionModel iWFVersionModel) throws Exception {
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

    public void setWFStepCodeList(ICodeList wfStepCodeList) {
        this.wfStepCodeList = wfStepCodeList;
    }

    public void setEntityStateCodeList(ICodeList entityStateCodeList) {
        this.entityStateCodeList = entityStateCodeList;
    }

    public String getRemindMsgTemplId() {
        return this.strRemindMsgTemplId;
    }

    public void setRemindMsgTemplId(String strRemindMsgTemplId) {
        this.strRemindMsgTemplId = strRemindMsgTemplId;
    }

    public String getWXAccountId() {
        return this.strWXAccountId;
    }

    public String getWXEntAppId() {
        return this.strWXEntAppId;
    }

    public void setWXAccountId(String strWXAccountId) {
        this.strWXAccountId = strWXAccountId;
    }

    public void setWXEntAppId(String strWXEntAppId) {
        this.strWXEntAppId = strWXEntAppId;
    }

    public IWFVersionModel getWFVersionModel(String strWFVersionId) throws Exception {
        IWFVersionModel iWFVersionModel = this.wfVersionModelMap2.get(strWFVersionId);
        if (iWFVersionModel == null) {
            throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u6d41\u7a0b\u6a21\u578b\uff0c\u6807\u8bc6\u4e3a[%1$s]", (Object)strWFVersionId));
        }
        return iWFVersionModel;
    }

    public String getDynaSysInstId() {
        return this.strDynaSysInstId;
    }
}

