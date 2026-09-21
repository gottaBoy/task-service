/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.paas.demodel;

import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.Iterator;
import net.ibizsys.paas.core.DEDataSet;
import net.ibizsys.paas.core.DEDataSetFetchContext;
import net.ibizsys.paas.core.DEDataSetQuery;
import net.ibizsys.paas.core.IDEDataQuery;
import net.ibizsys.paas.core.IDEDataSetFetchContext;
import net.ibizsys.paas.core.IDEDataSetGroupParam;
import net.ibizsys.paas.core.IDEDataSetQuery;
import net.ibizsys.paas.core.IDEField;
import net.ibizsys.paas.core.IDataEntity;
import net.ibizsys.paas.core.ModelBase3Impl;
import net.ibizsys.paas.db.DBFetchResult;
import net.ibizsys.paas.demodel.DEDataSetQueryModel;
import net.ibizsys.paas.demodel.IDEDataSetModel;
import net.ibizsys.paas.demodel.IDataEntityModel;
import net.ibizsys.paas.exception.ErrorException;
import net.ibizsys.paas.security.IUserRoleMgr;
import net.ibizsys.paas.service.IService;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.web.IWebContext;
import net.ibizsys.psrt.srv.common.entity.UserRoleData;
import net.ibizsys.psrt.srv.web.WebContext;

public abstract class DEDataSetModelBase
extends ModelBase3Impl
implements IDEDataSetModel {
    private IDataEntity iDataEntity = null;
    private DEDataSet deDataSetAnno = null;
    private boolean bEnableGroup = false;
    private int nGroupTopCount = -1;
    private boolean bEnableOrgDR = false;
    private boolean bEnableSecDR = false;
    private boolean bEnableSecBC = false;
    private long nOrgDR = 0L;
    private long nSecDR = 0L;
    private String strSecBC = "";
    private boolean bEnableUserDR = false;
    private String strUserDRAction = "READ";
    private String strCustomDRMode = null;
    private String strCustomDRMode2 = null;
    private String strCustomDRModeParam = null;
    private String strCustomDRMode2Param = null;
    private boolean bEnableCache = false;
    private String strCacheScope = null;
    private int nCacheTimeout = -1;
    private String strMajorSortField = null;
    private String strMajorSortDir = null;
    private String strMinorSortField = null;
    private String strMinorSortDir = null;
    private int nPageSize = -1;
    private String strCacheUniStateId = null;
    private String strCacheUniStateDELogicId = null;
    private String strCacheHookState = null;
    private String strActiveDataDELogicId = null;
    protected ArrayList<IDEDataSetGroupParam> deDataSetGroupParamList = new ArrayList();
    protected ArrayList<IDEDataSetQuery> deDataSetQueryList = new ArrayList();

    @Override
    public void init(IDataEntity iDataEntity) throws Exception {
        this.setDataEntity(iDataEntity);
        this.prepareDEDataSetGroupParams();
        this.onInit();
    }

    @Override
    protected void onInit() throws Exception {
        if (this.deDataSetAnno != null) {
            DEDataSetQuery[] dEDataSetQueryArray = this.deDataSetAnno.queries();
            int n = dEDataSetQueryArray.length;
            int n2 = 0;
            while (n2 < n) {
                DEDataSetQuery deDataSetQuery = dEDataSetQueryArray[n2];
                this.deDataSetQueryList.add(new DEDataSetQueryModel(deDataSetQuery));
                ++n2;
            }
        }
    }

    protected void prepareDEDataSetGroupParams() throws Exception {
    }

    protected void initAnnotation(Class c) {
        Annotation[] annotations = c.getAnnotations();
        if (annotations != null) {
            Annotation[] annotationArray = annotations;
            int n = annotations.length;
            int n2 = 0;
            while (n2 < n) {
                Annotation annotation = annotationArray[n2];
                if (annotation instanceof DEDataSet) {
                    this.setDEDataSetAnno((DEDataSet)annotation);
                }
                ++n2;
            }
        }
    }

    @Override
    public IDataEntity getDataEntity() {
        return this.iDataEntity;
    }

    protected void setDataEntity(IDataEntity iDataEntity) {
        this.iDataEntity = iDataEntity;
    }

    public IDataEntityModel getDEModel() {
        return (IDataEntityModel)this.getDataEntity();
    }

    public DEDataSet getDEDataSetAnno() {
        return this.deDataSetAnno;
    }

    protected void setDEDataSetAnno(DEDataSet deDataSetAnno) {
        this.deDataSetAnno = deDataSetAnno;
    }

    @Override
    public String getId() {
        return this.getDEDataSetAnno().id();
    }

    @Override
    public String getName() {
        return this.getDEDataSetAnno().name();
    }

    @Override
    public Iterator<IDEDataSetQuery> getDEDataSetQueries() {
        return this.deDataSetQueryList.iterator();
    }

    @Override
    public Iterator<IDEDataQuery> getDEDataQueries() throws Exception {
        return null;
    }

    @Override
    public boolean isCustomDS() {
        return false;
    }

    @Override
    public DBFetchResult fetchDEDataSet(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        throw new Exception("\u6ca1\u6709\u5b9e\u73b0");
    }

    @Override
    public boolean isEnableGroup() {
        return this.bEnableGroup;
    }

    protected void setEnableGroup(boolean bEnableGroup) {
        this.bEnableGroup = bEnableGroup;
    }

    @Override
    public Iterator<IDEDataSetGroupParam> getDEDataSetGroupParams() {
        return this.deDataSetGroupParamList.iterator();
    }

    protected void registerDEDataSetGroupParam(IDEDataSetGroupParam iDEDataSetGroupParam) {
        this.deDataSetGroupParamList.add(iDEDataSetGroupParam);
    }

    @Override
    public int getGroupTopCount() {
        return this.nGroupTopCount;
    }

    protected void setGroupTopCount(int nGroupTopCount) {
        this.nGroupTopCount = nGroupTopCount;
    }

    @Override
    public boolean isEnableOrgDR() {
        return this.bEnableOrgDR;
    }

    @Override
    public boolean isEnableSecDR() {
        return this.bEnableSecDR;
    }

    @Override
    public boolean isEnableSecBC() {
        return this.bEnableSecBC;
    }

    @Override
    public long getOrgDR() {
        return this.nOrgDR;
    }

    @Override
    public long getSecDR() {
        return this.nSecDR;
    }

    @Override
    public String getSecBC() {
        return this.strSecBC;
    }

    protected void setEnableOrgDR(boolean bEnableOrgDR) {
        this.bEnableOrgDR = bEnableOrgDR;
    }

    protected void setEnableSecDR(boolean bEnableSecDR) {
        this.bEnableSecDR = bEnableSecDR;
    }

    protected void setEnableSecBC(boolean bEnableSecBC) {
        this.bEnableSecBC = bEnableSecBC;
    }

    protected void setOrgDR(long nOrgDR) {
        this.nOrgDR = nOrgDR;
    }

    protected void setSecDR(long nSecDR) {
        this.nSecDR = nSecDR;
    }

    protected void setSecBC(String strSecBC) {
        this.strSecBC = strSecBC;
    }

    @Override
    public boolean isEnableUserDR() {
        return this.bEnableUserDR;
    }

    protected void setEnableUserDR(boolean bEnableUserDR) {
        this.bEnableUserDR = bEnableUserDR;
    }

    @Override
    public String getUserDRAction() {
        return this.strUserDRAction;
    }

    @Override
    public void fillDEDataSetFetchDataRange(IService iService, IWebContext iWebContext, IDEDataSetFetchContext deDataSetFetchContextImpl) throws Exception {
        if (this.isEnableUserDR() || this.isEnableOrgDR() || this.isEnableSecDR() || this.isEnableSecBC() || !StringHelper.isNullOrEmpty(this.getCustomDRMode()) || !StringHelper.isNullOrEmpty(this.getCustomDRMode2())) {
            ArrayList<String> condList = new ArrayList<String>();
            if (iService == null) {
                iService = this.getDEModel().getService();
            }
            if (iWebContext == null && (iWebContext = deDataSetFetchContextImpl.getWebContext()) == null) {
                iWebContext = WebContext.getCurrent();
            }
            if (StringHelper.isNullOrEmpty(iWebContext.getCurUserId())) {
                throw new ErrorException(2, "\u7528\u6237\u8fd8\u672a\u767b\u5f55");
            }
            IUserRoleMgr iUserRoleMgr = iWebContext.getUserRoleMgr();
            if (iWebContext.isSuperUser()) {
                condList.add("1=1");
            } else {
                String strCode;
                ArrayList<UserRoleData> list;
                if (this.isEnableUserDR() && (list = iUserRoleMgr.getUserRoleDatas(this.getDEModel().getId(), this.getUserDRAction())) != null) {
                    for (UserRoleData userRoleData : list) {
                        String strCode2 = iUserRoleMgr.getUserRoleDataCond(iService, userRoleData, deDataSetFetchContextImpl);
                        if (StringHelper.isNullOrEmpty(strCode2)) continue;
                        condList.add(strCode2);
                    }
                }
                if (!(this.isEnableUserDR() && condList.size() <= 0 && !iWebContext.isOrgAdmin() || StringHelper.isNullOrEmpty(strCode = iUserRoleMgr.getDEDataRangeCond(iService, this, deDataSetFetchContextImpl)))) {
                    condList.add(strCode);
                }
            }
            IDEField orgIdDEField = this.getDEModel().getDEFieldByPDT("ORGID", true);
            IDEField secIdDEField = this.getDEModel().getDEFieldByPDT("ORGSECTORID", true);
            DEDataSetFetchContext.enableOrgDRCond(deDataSetFetchContextImpl, orgIdDEField, secIdDEField, condList);
        }
    }

    @Override
    public String getCustomDRMode() {
        return this.strCustomDRMode;
    }

    @Override
    public String getCustomDRMode2() {
        return this.strCustomDRMode2;
    }

    @Override
    public String getCustomDRModeParam() {
        return this.strCustomDRModeParam;
    }

    @Override
    public String getCustomDRMode2Param() {
        return this.strCustomDRMode2Param;
    }

    protected void setCustomDRMode(String strCustomDRMode) {
        this.strCustomDRMode = strCustomDRMode;
    }

    protected void setCustomDRMode2(String strCustomDRMode2) {
        this.strCustomDRMode2 = strCustomDRMode2;
    }

    protected void setCustomDRModeParam(String strCustomDRModeParam) {
        this.strCustomDRModeParam = strCustomDRModeParam;
    }

    protected void setCustomDRMode2Param(String strCustomDRMode2Param) {
        this.strCustomDRMode2Param = strCustomDRMode2Param;
    }

    @Override
    public boolean isEnableDEDataRange() {
        return this.isEnableUserDR() || this.isEnableOrgDR() || this.isEnableSecDR() || this.isEnableSecBC() || !StringHelper.isNullOrEmpty(this.getCustomDRMode()) || !StringHelper.isNullOrEmpty(this.getCustomDRMode2());
    }

    @Override
    public boolean isEnableCache() {
        return this.bEnableCache;
    }

    @Override
    public String getCacheScope() {
        return this.strCacheScope;
    }

    @Override
    public int getCacheTimeout() {
        return this.nCacheTimeout;
    }

    @Override
    public String getMajorSortField() {
        return this.strMajorSortField;
    }

    @Override
    public String getMajorSortDir() {
        return this.strMajorSortDir;
    }

    @Override
    public String getMinorSortField() {
        return this.strMinorSortField;
    }

    @Override
    public String getMinorSortDir() {
        return this.strMinorSortDir;
    }

    @Override
    public int getPageSize() {
        return this.nPageSize;
    }

    protected void setEnableCache(boolean bEnableCache) {
        this.bEnableCache = bEnableCache;
    }

    protected void setCacheScope(String strCacheScope) {
        this.strCacheScope = strCacheScope;
    }

    protected void setCacheTimeout(int nCacheTimeout) {
        this.nCacheTimeout = nCacheTimeout;
    }

    protected void setMajorSortField(String strMajorSortField) {
        this.strMajorSortField = strMajorSortField;
    }

    protected void setMajorSortDir(String strMajorSortDir) {
        this.strMajorSortDir = strMajorSortDir;
    }

    protected void setMinorSortField(String strMinorSortField) {
        this.strMinorSortField = strMinorSortField;
    }

    protected void setMinorSortDir(String strMinorSortDir) {
        this.strMinorSortDir = strMinorSortDir;
    }

    protected void setPageSize(int nPageSize) {
        this.nPageSize = nPageSize;
    }

    @Override
    public String getCacheUniStateId() {
        return this.strCacheUniStateId;
    }

    @Override
    public String getCacheUniStateDELogicId() {
        return this.strCacheUniStateDELogicId;
    }

    @Override
    public String getCacheHookState() {
        return this.strCacheHookState;
    }

    protected void setCacheUniStateId(String strCacheUniStateId) {
        this.strCacheUniStateId = strCacheUniStateId;
    }

    protected void setCacheUniStateDELogicId(String strCacheUniStateDELogicId) {
        this.strCacheUniStateDELogicId = strCacheUniStateDELogicId;
    }

    protected void setCacheHookState(String strCacheHookState) {
        this.strCacheHookState = strCacheHookState;
    }

    @Override
    public String getActiveDataDELogicId() {
        return this.strActiveDataDELogicId;
    }

    protected void setActiveDataDELogicId(String strActiveDataDELogicId) {
        this.strActiveDataDELogicId = strActiveDataDELogicId;
    }
}

