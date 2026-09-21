/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.PostConstruct
 *  net.ibizsys.paas.core.IDEDataSetFetchContext
 *  net.ibizsys.paas.dao.DAOGlobal
 *  net.ibizsys.paas.dao.IDAO
 *  net.ibizsys.paas.db.DBFetchResult
 *  net.ibizsys.paas.demodel.DEModelGlobal
 *  net.ibizsys.paas.entity.EntityError
 *  net.ibizsys.paas.entity.EntityFieldError
 *  net.ibizsys.paas.entity.IEntity
 *  net.ibizsys.paas.service.IDataContextParam
 *  net.ibizsys.paas.service.IService
 *  net.ibizsys.paas.service.ServiceGlobal
 *  net.ibizsys.paas.util.StringHelper
 *  net.ibizsys.paas.xml.XmlNode
 *  net.sf.json.JSONObject
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 *  org.hibernate.SessionFactory
 */
package net.ibizsys.pscore.srv.dedesign.service;

import java.util.ArrayList;
import javax.annotation.PostConstruct;
import net.ibizsys.paas.core.IDEDataSetFetchContext;
import net.ibizsys.paas.dao.DAOGlobal;
import net.ibizsys.paas.dao.IDAO;
import net.ibizsys.paas.db.DBFetchResult;
import net.ibizsys.paas.demodel.DEModelGlobal;
import net.ibizsys.paas.entity.EntityError;
import net.ibizsys.paas.entity.EntityFieldError;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.service.IDataContextParam;
import net.ibizsys.paas.service.IService;
import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.xml.XmlNode;
import net.ibizsys.pscore.srv.PSCoreSysServiceBase;
import net.ibizsys.pscore.srv.core.IPSDataEntityModel;
import net.ibizsys.pscore.srv.dedesign.dao.PSDEModelCntDAO;
import net.ibizsys.pscore.srv.dedesign.demodel.PSDEModelCntDEModel;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEModelCnt;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDEModelCntServiceBase
extends PSCoreSysServiceBase<PSDEModelCnt> {
    private static final Log log = LogFactory.getLog(PSDEModelCntServiceBase.class);
    public static final String DATASET_DEFAULT = "DEFAULT";
    private PSDEModelCntDEModel pSDEModelCntDEModel;
    private PSDEModelCntDAO pSDEModelCntDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.dedesign.service.PSDEModelCntService";
    }

    public PSDEModelCntDEModel getPSDEModelCntDEModel() {
        if (this.pSDEModelCntDEModel == null) {
            try {
                this.pSDEModelCntDEModel = (PSDEModelCntDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.dedesign.demodel.PSDEModelCntDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDEModelCntDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSDEModelCntDEModel();
    }

    public PSDEModelCntDAO getPSDEModelCntDAO() {
        if (this.pSDEModelCntDAO == null) {
            try {
                this.pSDEModelCntDAO = (PSDEModelCntDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.dedesign.dao.PSDEModelCntDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDEModelCntDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSDEModelCntDAO();
    }

    protected DBFetchResult onfetchDataSet(String string, IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        if (StringHelper.compare((String)string, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.fetchDefault(iDEDataSetFetchContext);
        }
        return super.onfetchDataSet(string, iDEDataSetFetchContext);
    }

    @Override
    protected void onExecuteAction(String string, IEntity iEntity) throws Exception {
        super.onExecuteAction(string, iEntity);
    }

    public DBFetchResult fetchDefault(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_DEFAULT, false);
        return dBFetchResult;
    }

    protected void onFillParentInfo(PSDEModelCnt pSDEModelCnt, String string, String string2, String string3) throws Exception {
        super.onFillParentInfo((IEntity)pSDEModelCnt, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillEntityFullInfo(PSDEModelCnt pSDEModelCnt, boolean bl) throws Exception {
        if (bl) {
            // empty if block
        }
        super.onFillEntityFullInfo((IEntity)pSDEModelCnt, bl);
    }

    protected void onWriteBackParent(PSDEModelCnt pSDEModelCnt, boolean bl) throws Exception {
        super.onWriteBackParent((IEntity)pSDEModelCnt, bl);
    }

    @Override
    protected void onBeforeRemove(PSDEModelCnt pSDEModelCnt) throws Exception {
        super.onBeforeRemove(pSDEModelCnt);
    }

    protected void onRemoveEntityUncopyValues(PSDEModelCnt pSDEModelCnt, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues((IEntity)pSDEModelCnt, bl);
    }

    protected void onCheckEntity(boolean bl, PSDEModelCnt pSDEModelCnt, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_CLCnt(bl, pSDEModelCnt, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_DEACCnt(bl, pSDEModelCnt, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_DEActionCnt(bl, pSDEModelCnt, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_DECalendarCnt(bl, pSDEModelCnt, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_DEChartCnt(bl, pSDEModelCnt, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_DEDashboardCnt(bl, pSDEModelCnt, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_DEDataViewCnt(bl, pSDEModelCnt, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_DEDQCnt(bl, pSDEModelCnt, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_DEDRCnt(bl, pSDEModelCnt, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_DEDRGrpCnt(bl, pSDEModelCnt, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_DEDRItemCnt(bl, pSDEModelCnt, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_DEDSCnt(bl, pSDEModelCnt, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_DEFieldCnt(bl, pSDEModelCnt, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_DEFormCnt(bl, pSDEModelCnt, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_DEGridCnt(bl, pSDEModelCnt, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_DEListCnt(bl, pSDEModelCnt, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_DELogicCnt(bl, pSDEModelCnt, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_DEMapViewCnt(bl, pSDEModelCnt, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_DEMSCnt(bl, pSDEModelCnt, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_DEOPPrivCnt(bl, pSDEModelCnt, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_DEPanelCnt(bl, pSDEModelCnt, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_DEPortletCnt(bl, pSDEModelCnt, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_DERCnt(bl, pSDEModelCnt, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_DERCnt2(bl, pSDEModelCnt, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_DEReportCnt(bl, pSDEModelCnt, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_DESearchBarCnt(bl, pSDEModelCnt, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_DEToolbarCnt(bl, pSDEModelCnt, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_DETreeCnt(bl, pSDEModelCnt, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_DEUACnt(bl, pSDEModelCnt, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_DEUAGrpCnt(bl, pSDEModelCnt, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_DEWFCnt(bl, pSDEModelCnt, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_IndexCnt(bl, pSDEModelCnt, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEModelCntId(bl, pSDEModelCnt, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEModelCntName(bl, pSDEModelCnt, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, (IEntity)pSDEModelCnt, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_CLCnt(boolean bl, PSDEModelCnt pSDEModelCnt, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEModelCnt.isCLCntDirty() : !pSDEModelCnt.isCLCntDirty()) {
            return null;
        }
        Integer n = pSDEModelCnt.getCLCnt();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_CLCnt_Default((IEntity)pSDEModelCnt, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CLCNT");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_DEACCnt(boolean bl, PSDEModelCnt pSDEModelCnt, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEModelCnt.isDEACCntDirty() : !pSDEModelCnt.isDEACCntDirty()) {
            return null;
        }
        Integer n = pSDEModelCnt.getDEACCnt();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_DEACCnt_Default((IEntity)pSDEModelCnt, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DEACCNT");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_DEActionCnt(boolean bl, PSDEModelCnt pSDEModelCnt, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEModelCnt.isDEActionCntDirty() : !pSDEModelCnt.isDEActionCntDirty()) {
            return null;
        }
        Integer n = pSDEModelCnt.getDEActionCnt();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_DEActionCnt_Default((IEntity)pSDEModelCnt, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DEACTIONCNT");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_DECalendarCnt(boolean bl, PSDEModelCnt pSDEModelCnt, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEModelCnt.isDECalendarCntDirty() : !pSDEModelCnt.isDECalendarCntDirty()) {
            return null;
        }
        Integer n = pSDEModelCnt.getDECalendarCnt();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_DECalendarCnt_Default((IEntity)pSDEModelCnt, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DECALENDARCNT");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_DEChartCnt(boolean bl, PSDEModelCnt pSDEModelCnt, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEModelCnt.isDEChartCntDirty() : !pSDEModelCnt.isDEChartCntDirty()) {
            return null;
        }
        Integer n = pSDEModelCnt.getDEChartCnt();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_DEChartCnt_Default((IEntity)pSDEModelCnt, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DECHARTCNT");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_DEDashboardCnt(boolean bl, PSDEModelCnt pSDEModelCnt, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEModelCnt.isDEDashboardCntDirty() : !pSDEModelCnt.isDEDashboardCntDirty()) {
            return null;
        }
        Integer n = pSDEModelCnt.getDEDashboardCnt();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_DEDashboardCnt_Default((IEntity)pSDEModelCnt, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DEDASHBOARDCNT");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_DEDataViewCnt(boolean bl, PSDEModelCnt pSDEModelCnt, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEModelCnt.isDEDataViewCntDirty() : !pSDEModelCnt.isDEDataViewCntDirty()) {
            return null;
        }
        Integer n = pSDEModelCnt.getDEDataViewCnt();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_DEDataViewCnt_Default((IEntity)pSDEModelCnt, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DEDATAVIEWCNT");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_DEDQCnt(boolean bl, PSDEModelCnt pSDEModelCnt, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEModelCnt.isDEDQCntDirty() : !pSDEModelCnt.isDEDQCntDirty()) {
            return null;
        }
        Integer n = pSDEModelCnt.getDEDQCnt();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_DEDQCnt_Default((IEntity)pSDEModelCnt, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DEDQCNT");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_DEDRCnt(boolean bl, PSDEModelCnt pSDEModelCnt, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEModelCnt.isDEDRCntDirty() : !pSDEModelCnt.isDEDRCntDirty()) {
            return null;
        }
        Integer n = pSDEModelCnt.getDEDRCnt();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_DEDRCnt_Default((IEntity)pSDEModelCnt, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DEDRCNT");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_DEDRGrpCnt(boolean bl, PSDEModelCnt pSDEModelCnt, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEModelCnt.isDEDRGrpCntDirty() : !pSDEModelCnt.isDEDRGrpCntDirty()) {
            return null;
        }
        Integer n = pSDEModelCnt.getDEDRGrpCnt();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_DEDRGrpCnt_Default((IEntity)pSDEModelCnt, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DEDRGRPCNT");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_DEDRItemCnt(boolean bl, PSDEModelCnt pSDEModelCnt, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEModelCnt.isDEDRItemCntDirty() : !pSDEModelCnt.isDEDRItemCntDirty()) {
            return null;
        }
        Integer n = pSDEModelCnt.getDEDRItemCnt();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_DEDRItemCnt_Default((IEntity)pSDEModelCnt, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DEDRITEMCNT");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_DEDSCnt(boolean bl, PSDEModelCnt pSDEModelCnt, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEModelCnt.isDEDSCntDirty() : !pSDEModelCnt.isDEDSCntDirty()) {
            return null;
        }
        Integer n = pSDEModelCnt.getDEDSCnt();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_DEDSCnt_Default((IEntity)pSDEModelCnt, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DEDSCNT");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_DEFieldCnt(boolean bl, PSDEModelCnt pSDEModelCnt, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEModelCnt.isDEFieldCntDirty() : !pSDEModelCnt.isDEFieldCntDirty()) {
            return null;
        }
        Integer n = pSDEModelCnt.getDEFieldCnt();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_DEFieldCnt_Default((IEntity)pSDEModelCnt, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DEFIELDCNT");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_DEFormCnt(boolean bl, PSDEModelCnt pSDEModelCnt, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEModelCnt.isDEFormCntDirty() : !pSDEModelCnt.isDEFormCntDirty()) {
            return null;
        }
        Integer n = pSDEModelCnt.getDEFormCnt();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_DEFormCnt_Default((IEntity)pSDEModelCnt, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DEFORMCNT");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_DEGridCnt(boolean bl, PSDEModelCnt pSDEModelCnt, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEModelCnt.isDEGridCntDirty() : !pSDEModelCnt.isDEGridCntDirty()) {
            return null;
        }
        Integer n = pSDEModelCnt.getDEGridCnt();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_DEGridCnt_Default((IEntity)pSDEModelCnt, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DEGRIDCNT");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_DEListCnt(boolean bl, PSDEModelCnt pSDEModelCnt, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEModelCnt.isDEListCntDirty() : !pSDEModelCnt.isDEListCntDirty()) {
            return null;
        }
        Integer n = pSDEModelCnt.getDEListCnt();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_DEListCnt_Default((IEntity)pSDEModelCnt, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DELISTCNT");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_DELogicCnt(boolean bl, PSDEModelCnt pSDEModelCnt, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEModelCnt.isDELogicCntDirty() : !pSDEModelCnt.isDELogicCntDirty()) {
            return null;
        }
        Integer n = pSDEModelCnt.getDELogicCnt();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_DELogicCnt_Default((IEntity)pSDEModelCnt, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DELOGICCNT");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_DEMapViewCnt(boolean bl, PSDEModelCnt pSDEModelCnt, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEModelCnt.isDEMapViewCntDirty() : !pSDEModelCnt.isDEMapViewCntDirty()) {
            return null;
        }
        Integer n = pSDEModelCnt.getDEMapViewCnt();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_DEMapViewCnt_Default((IEntity)pSDEModelCnt, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DEMAPVIEWCNT");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_DEMSCnt(boolean bl, PSDEModelCnt pSDEModelCnt, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEModelCnt.isDEMSCntDirty() : !pSDEModelCnt.isDEMSCntDirty()) {
            return null;
        }
        Integer n = pSDEModelCnt.getDEMSCnt();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_DEMSCnt_Default((IEntity)pSDEModelCnt, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DEMSCNT");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_DEOPPrivCnt(boolean bl, PSDEModelCnt pSDEModelCnt, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEModelCnt.isDEOPPrivCntDirty() : !pSDEModelCnt.isDEOPPrivCntDirty()) {
            return null;
        }
        Integer n = pSDEModelCnt.getDEOPPrivCnt();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_DEOPPrivCnt_Default((IEntity)pSDEModelCnt, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DEOPPRIVCNT");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_DEPanelCnt(boolean bl, PSDEModelCnt pSDEModelCnt, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEModelCnt.isDEPanelCntDirty() : !pSDEModelCnt.isDEPanelCntDirty()) {
            return null;
        }
        Integer n = pSDEModelCnt.getDEPanelCnt();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_DEPanelCnt_Default((IEntity)pSDEModelCnt, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DEPANELCNT");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_DEPortletCnt(boolean bl, PSDEModelCnt pSDEModelCnt, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEModelCnt.isDEPortletCntDirty() : !pSDEModelCnt.isDEPortletCntDirty()) {
            return null;
        }
        Integer n = pSDEModelCnt.getDEPortletCnt();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_DEPortletCnt_Default((IEntity)pSDEModelCnt, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DEPORTLETCNT");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_DERCnt(boolean bl, PSDEModelCnt pSDEModelCnt, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEModelCnt.isDERCntDirty() : !pSDEModelCnt.isDERCntDirty()) {
            return null;
        }
        Integer n = pSDEModelCnt.getDERCnt();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_DERCnt_Default((IEntity)pSDEModelCnt, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DERCNT");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_DERCnt2(boolean bl, PSDEModelCnt pSDEModelCnt, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEModelCnt.isDERCnt2Dirty() : !pSDEModelCnt.isDERCnt2Dirty()) {
            return null;
        }
        Integer n = pSDEModelCnt.getDERCnt2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_DERCnt2_Default((IEntity)pSDEModelCnt, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DERCNT2");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_DEReportCnt(boolean bl, PSDEModelCnt pSDEModelCnt, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEModelCnt.isDEReportCntDirty() : !pSDEModelCnt.isDEReportCntDirty()) {
            return null;
        }
        Integer n = pSDEModelCnt.getDEReportCnt();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_DEReportCnt_Default((IEntity)pSDEModelCnt, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DEREPORTCNT");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_DESearchBarCnt(boolean bl, PSDEModelCnt pSDEModelCnt, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEModelCnt.isDESearchBarCntDirty() : !pSDEModelCnt.isDESearchBarCntDirty()) {
            return null;
        }
        Integer n = pSDEModelCnt.getDESearchBarCnt();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_DESearchBarCnt_Default((IEntity)pSDEModelCnt, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DESEARCHBARCNT");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_DEToolbarCnt(boolean bl, PSDEModelCnt pSDEModelCnt, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEModelCnt.isDEToolbarCntDirty() : !pSDEModelCnt.isDEToolbarCntDirty()) {
            return null;
        }
        Integer n = pSDEModelCnt.getDEToolbarCnt();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_DEToolbarCnt_Default((IEntity)pSDEModelCnt, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DETOOLBARCNT");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_DETreeCnt(boolean bl, PSDEModelCnt pSDEModelCnt, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEModelCnt.isDETreeCntDirty() : !pSDEModelCnt.isDETreeCntDirty()) {
            return null;
        }
        Integer n = pSDEModelCnt.getDETreeCnt();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_DETreeCnt_Default((IEntity)pSDEModelCnt, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DETREECNT");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_DEUACnt(boolean bl, PSDEModelCnt pSDEModelCnt, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEModelCnt.isDEUACntDirty() : !pSDEModelCnt.isDEUACntDirty()) {
            return null;
        }
        Integer n = pSDEModelCnt.getDEUACnt();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_DEUACnt_Default((IEntity)pSDEModelCnt, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DEUACNT");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_DEUAGrpCnt(boolean bl, PSDEModelCnt pSDEModelCnt, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEModelCnt.isDEUAGrpCntDirty() : !pSDEModelCnt.isDEUAGrpCntDirty()) {
            return null;
        }
        Integer n = pSDEModelCnt.getDEUAGrpCnt();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_DEUAGrpCnt_Default((IEntity)pSDEModelCnt, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DEUAGRPCNT");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_DEWFCnt(boolean bl, PSDEModelCnt pSDEModelCnt, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEModelCnt.isDEWFCntDirty() : !pSDEModelCnt.isDEWFCntDirty()) {
            return null;
        }
        Integer n = pSDEModelCnt.getDEWFCnt();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_DEWFCnt_Default((IEntity)pSDEModelCnt, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DEWFCNT");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_IndexCnt(boolean bl, PSDEModelCnt pSDEModelCnt, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEModelCnt.isIndexCntDirty() : !pSDEModelCnt.isIndexCntDirty()) {
            return null;
        }
        Integer n = pSDEModelCnt.getIndexCnt();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_IndexCnt_Default((IEntity)pSDEModelCnt, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("INDEXCNT");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDEModelCntId(boolean bl, PSDEModelCnt pSDEModelCnt, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEModelCnt.isPSDEModelCntIdDirty() && !bl2 : !pSDEModelCnt.isPSDEModelCntIdDirty()) {
            return null;
        }
        String string = pSDEModelCnt.getPSDEModelCntId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEMODELCNTID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEModelCntId_Default((IEntity)pSDEModelCnt, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEMODELCNTID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDEModelCntName(boolean bl, PSDEModelCnt pSDEModelCnt, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEModelCnt.isPSDEModelCntNameDirty() && !bl2 : !pSDEModelCnt.isPSDEModelCntNameDirty()) {
            return null;
        }
        String string = pSDEModelCnt.getPSDEModelCntName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEMODELCNTNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEModelCntName_Default((IEntity)pSDEModelCnt, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEMODELCNTNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected void onSyncEntity(PSDEModelCnt pSDEModelCnt, boolean bl) throws Exception {
        super.onSyncEntity((IEntity)pSDEModelCnt, bl);
    }

    protected void onSyncIndexEntities(PSDEModelCnt pSDEModelCnt, boolean bl) throws Exception {
        super.onSyncIndexEntities((IEntity)pSDEModelCnt, bl);
    }

    public Object getDataContextValue(PSDEModelCnt pSDEModelCnt, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null) {
            // empty if block
        }
        if ((object = super.getDataContextValue((IEntity)pSDEModelCnt, string, iDataContextParam)) != null) {
            return object;
        }
        return null;
    }

    protected void onExportMajorModel(PSDEModelCnt pSDEModelCnt, ArrayList<JSONObject> arrayList, int n) throws Exception {
        super.onExportMajorModel((IEntity)pSDEModelCnt, arrayList, n);
    }

    protected String onTestValueRule(String string, String string2, IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        if (StringHelper.compare((String)string, (String)"CLCNT", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CLCnt_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATEDATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateDate_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATEMAN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateMan_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DEACCNT", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DEACCnt_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DEACTIONCNT", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DEActionCnt_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DECALENDARCNT", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DECalendarCnt_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DECHARTCNT", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DEChartCnt_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DEDASHBOARDCNT", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DEDashboardCnt_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DEDATAVIEWCNT", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DEDataViewCnt_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DEDQCNT", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DEDQCnt_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DEDRCNT", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DEDRCnt_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DEDRGRPCNT", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DEDRGrpCnt_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DEDRITEMCNT", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DEDRItemCnt_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DEDSCNT", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DEDSCnt_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DEFIELDCNT", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DEFieldCnt_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DEFORMCNT", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DEFormCnt_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DEGRIDCNT", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DEGridCnt_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DELISTCNT", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DEListCnt_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DELOGICCNT", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DELogicCnt_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DEMAPVIEWCNT", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DEMapViewCnt_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DEMSCNT", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DEMSCnt_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DEOPPRIVCNT", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DEOPPrivCnt_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DEPANELCNT", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DEPanelCnt_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DEPORTLETCNT", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DEPortletCnt_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DERCNT", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DERCnt_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DERCNT2", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DERCnt2_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DEREPORTCNT", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DEReportCnt_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DESEARCHBARCNT", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DESearchBarCnt_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DETOOLBARCNT", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DEToolbarCnt_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DETREECNT", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DETreeCnt_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DEUACNT", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DEUACnt_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DEUAGRPCNT", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DEUAGrpCnt_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DEWFCNT", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DEWFCnt_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"INDEXCNT", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_IndexCnt_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEMODELCNTID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEModelCntId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEMODELCNTNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEModelCntName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UPDATEDATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UpdateDate_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UPDATEMAN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UpdateMan_Default(iEntity, bl, bl2);
        }
        return super.onTestValueRule(string, string2, iEntity, bl, bl2);
    }

    protected String onTestValueRule_CLCnt_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_CreateDate_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_CreateMan_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("CREATEMAN", iEntity, bl2, null, false, 60, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_DEACCnt_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_DEActionCnt_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_DECalendarCnt_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_DEChartCnt_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_DEDashboardCnt_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_DEDataViewCnt_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_DEDQCnt_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_DEDRCnt_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_DEDRGrpCnt_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_DEDRItemCnt_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_DEDSCnt_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_DEFieldCnt_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_DEFormCnt_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_DEGridCnt_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_DEListCnt_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_DELogicCnt_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_DEMapViewCnt_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_DEMSCnt_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_DEOPPrivCnt_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_DEPanelCnt_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_DEPortletCnt_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_DERCnt_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_DERCnt2_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_DEReportCnt_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_DESearchBarCnt_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_DEToolbarCnt_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_DETreeCnt_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_DEUACnt_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_DEUAGrpCnt_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_DEWFCnt_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_IndexCnt_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_PSDEModelCntId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEMODELCNTID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDEModelCntName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEMODELCNTNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_UpdateDate_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_UpdateMan_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("UPDATEMAN", iEntity, bl2, null, false, 60, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected boolean onMergeChild(String string, String string2, PSDEModelCnt pSDEModelCnt) throws Exception {
        boolean bl = false;
        if (super.onMergeChild(string, string2, (IEntity)pSDEModelCnt)) {
            bl = true;
        }
        return bl;
    }

    protected void onUpdateParent(PSDEModelCnt pSDEModelCnt) throws Exception {
        super.onUpdateParent((IEntity)pSDEModelCnt);
    }

    @Override
    protected void exportCurXmlModel(PSDEModelCnt pSDEModelCnt, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSDEMODELCNT");
        if (!bl) {
            pSDEModelCnt.setCreateDate(null);
            pSDEModelCnt.setCreateMan(null);
            pSDEModelCnt.setPSDEModelCntId(null);
            pSDEModelCnt.setUpdateDate(null);
            pSDEModelCnt.setUpdateMan(null);
            super.exportCurXmlModel(pSDEModelCnt, xmlNode, bl);
        }
    }
}

