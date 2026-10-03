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
package net.ibizsys.pscore.srv.sysdevstudio.service;

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
import net.ibizsys.pscore.srv.sysdevstudio.dao.PSDSPanelToolBoxDAO;
import net.ibizsys.pscore.srv.sysdevstudio.demodel.PSDSPanelToolBoxDEModel;
import net.ibizsys.pscore.srv.sysdevstudio.entity.PSDSPanelToolBox;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDSPanelToolBoxServiceBase
extends PSCoreSysServiceBase<PSDSPanelToolBox> {
    private static final Log log = LogFactory.getLog(PSDSPanelToolBoxServiceBase.class);
    public static final String DATASET_BUTTON = "Button";
    public static final String DATASET_CONTAINER = "Container";
    public static final String DATASET_CONTROL = "Control";
    public static final String DATASET_CTRLPOS = "CtrlPos";
    public static final String DATASET_DEFAULT = "DEFAULT";
    public static final String DATASET_FIELD = "Field";
    public static final String DATASET_RAWITEM = "RawItem";
    private PSDSPanelToolBoxDEModel pSDSPanelToolBoxDEModel;
    private PSDSPanelToolBoxDAO pSDSPanelToolBoxDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.sysdevstudio.service.PSDSPanelToolBoxService";
    }

    public PSDSPanelToolBoxDEModel getPSDSPanelToolBoxDEModel() {
        if (this.pSDSPanelToolBoxDEModel == null) {
            try {
                this.pSDSPanelToolBoxDEModel = (PSDSPanelToolBoxDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.sysdevstudio.demodel.PSDSPanelToolBoxDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDSPanelToolBoxDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSDSPanelToolBoxDEModel();
    }

    public PSDSPanelToolBoxDAO getPSDSPanelToolBoxDAO() {
        if (this.pSDSPanelToolBoxDAO == null) {
            try {
                this.pSDSPanelToolBoxDAO = (PSDSPanelToolBoxDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.sysdevstudio.dao.PSDSPanelToolBoxDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDSPanelToolBoxDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSDSPanelToolBoxDAO();
    }

    protected DBFetchResult onfetchDataSet(String string, IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        if (StringHelper.compare((String)string, (String)DATASET_BUTTON, (boolean)true) == 0) {
            return this.fetchButton(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_CONTAINER, (boolean)true) == 0) {
            return this.fetchContainer(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_CONTROL, (boolean)true) == 0) {
            return this.fetchControl(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_CTRLPOS, (boolean)true) == 0) {
            return this.fetchCtrlPos(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.fetchDefault(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_FIELD, (boolean)true) == 0) {
            return this.fetchField(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_RAWITEM, (boolean)true) == 0) {
            return this.fetchRawItem(iDEDataSetFetchContext);
        }
        return super.onfetchDataSet(string, iDEDataSetFetchContext);
    }

    @Override
    protected void onExecuteAction(String string, IEntity iEntity) throws Exception {
        super.onExecuteAction(string, iEntity);
    }

    public DBFetchResult fetchButton(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_BUTTON, false);
        return dBFetchResult;
    }

    public DBFetchResult fetchContainer(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CONTAINER, false);
        return dBFetchResult;
    }

    public DBFetchResult fetchControl(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CONTROL, false);
        return dBFetchResult;
    }

    public DBFetchResult fetchCtrlPos(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CTRLPOS, false);
        return dBFetchResult;
    }

    public DBFetchResult fetchDefault(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_DEFAULT, false);
        return dBFetchResult;
    }

    public DBFetchResult fetchField(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_FIELD, false);
        return dBFetchResult;
    }

    public DBFetchResult fetchRawItem(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_RAWITEM, false);
        return dBFetchResult;
    }

    protected void onFillParentInfo(PSDSPanelToolBox pSDSPanelToolBox, String string, String string2, String string3) throws Exception {
        super.onFillParentInfo(pSDSPanelToolBox, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillEntityFullInfo(PSDSPanelToolBox pSDSPanelToolBox, boolean bl) throws Exception {
        if (bl) {
            // empty if block
        }
        super.onFillEntityFullInfo(pSDSPanelToolBox, bl);
    }

    protected void onWriteBackParent(PSDSPanelToolBox pSDSPanelToolBox, boolean bl) throws Exception {
        super.onWriteBackParent(pSDSPanelToolBox, bl);
    }

    @Override
    protected void onBeforeRemove(PSDSPanelToolBox pSDSPanelToolBox) throws Exception {
        super.onBeforeRemove(pSDSPanelToolBox);
    }

    protected void onRemoveEntityUncopyValues(PSDSPanelToolBox pSDSPanelToolBox, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues(pSDSPanelToolBox, bl);
    }

    protected void onCheckEntity(boolean bl, PSDSPanelToolBox pSDSPanelToolBox, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_Cat(bl, pSDSPanelToolBox, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_IconCls(bl, pSDSPanelToolBox, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_InitParams(bl, pSDSPanelToolBox, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ItemType(bl, pSDSPanelToolBox, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_OrderValue(bl, pSDSPanelToolBox, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDSPanelToolBoxId(bl, pSDSPanelToolBox, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDSPanelToolBoxName(bl, pSDSPanelToolBox, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ToolBoxType(bl, pSDSPanelToolBox, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ToolTip(bl, pSDSPanelToolBox, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag(bl, pSDSPanelToolBox, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag2(bl, pSDSPanelToolBox, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ValidFlag(bl, pSDSPanelToolBox, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, pSDSPanelToolBox, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_Cat(boolean bl, PSDSPanelToolBox pSDSPanelToolBox, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDSPanelToolBox.isCatDirty() && !bl2 : !pSDSPanelToolBox.isCatDirty()) {
            return null;
        }
        String string = pSDSPanelToolBox.getCat();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CAT");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_Cat_Default(pSDSPanelToolBox, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CAT");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_IconCls(boolean bl, PSDSPanelToolBox pSDSPanelToolBox, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDSPanelToolBox.isIconClsDirty() : !pSDSPanelToolBox.isIconClsDirty()) {
            return null;
        }
        String string = pSDSPanelToolBox.getIconCls();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_IconCls_Default(pSDSPanelToolBox, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ICONCLS");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_InitParams(boolean bl, PSDSPanelToolBox pSDSPanelToolBox, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDSPanelToolBox.isInitParamsDirty() : !pSDSPanelToolBox.isInitParamsDirty()) {
            return null;
        }
        String string = pSDSPanelToolBox.getInitParams();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_InitParams_Default(pSDSPanelToolBox, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("INITPARAMS");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ItemType(boolean bl, PSDSPanelToolBox pSDSPanelToolBox, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDSPanelToolBox.isItemTypeDirty() : !pSDSPanelToolBox.isItemTypeDirty()) {
            return null;
        }
        String string = pSDSPanelToolBox.getItemType();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_ItemType_Default(pSDSPanelToolBox, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ITEMTYPE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_OrderValue(boolean bl, PSDSPanelToolBox pSDSPanelToolBox, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDSPanelToolBox.isOrderValueDirty() && !bl2 : !pSDSPanelToolBox.isOrderValueDirty()) {
            return null;
        }
        Integer n = pSDSPanelToolBox.getOrderValue();
        if (bl) {
            if (bl2 && n == null) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ORDERVALUE");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string = null;
            string = this.onTestValueRule_OrderValue_Default(pSDSPanelToolBox, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ORDERVALUE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDSPanelToolBoxId(boolean bl, PSDSPanelToolBox pSDSPanelToolBox, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDSPanelToolBox.isPSDSPanelToolBoxIdDirty() && !bl2 : !pSDSPanelToolBox.isPSDSPanelToolBoxIdDirty()) {
            return null;
        }
        String string = pSDSPanelToolBox.getPSDSPanelToolBoxId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDSPANELTOOLBOXID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDSPanelToolBoxId_Default(pSDSPanelToolBox, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDSPANELTOOLBOXID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDSPanelToolBoxName(boolean bl, PSDSPanelToolBox pSDSPanelToolBox, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDSPanelToolBox.isPSDSPanelToolBoxNameDirty() && !bl2 : !pSDSPanelToolBox.isPSDSPanelToolBoxNameDirty()) {
            return null;
        }
        String string = pSDSPanelToolBox.getPSDSPanelToolBoxName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDSPANELTOOLBOXNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDSPanelToolBoxName_Default(pSDSPanelToolBox, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDSPANELTOOLBOXNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ToolBoxType(boolean bl, PSDSPanelToolBox pSDSPanelToolBox, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDSPanelToolBox.isToolBoxTypeDirty() && !bl2 : !pSDSPanelToolBox.isToolBoxTypeDirty()) {
            return null;
        }
        String string = pSDSPanelToolBox.getToolBoxType();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("TOOLBOXTYPE");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_ToolBoxType_Default(pSDSPanelToolBox, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("TOOLBOXTYPE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ToolTip(boolean bl, PSDSPanelToolBox pSDSPanelToolBox, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDSPanelToolBox.isToolTipDirty() : !pSDSPanelToolBox.isToolTipDirty()) {
            return null;
        }
        String string = pSDSPanelToolBox.getToolTip();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_ToolTip_Default(pSDSPanelToolBox, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("TOOLTIP");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_UserTag(boolean bl, PSDSPanelToolBox pSDSPanelToolBox, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDSPanelToolBox.isUserTagDirty() : !pSDSPanelToolBox.isUserTagDirty()) {
            return null;
        }
        String string = pSDSPanelToolBox.getUserTag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag_Default(pSDSPanelToolBox, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("USERTAG");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_UserTag2(boolean bl, PSDSPanelToolBox pSDSPanelToolBox, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDSPanelToolBox.isUserTag2Dirty() : !pSDSPanelToolBox.isUserTag2Dirty()) {
            return null;
        }
        String string = pSDSPanelToolBox.getUserTag2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag2_Default(pSDSPanelToolBox, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("USERTAG2");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ValidFlag(boolean bl, PSDSPanelToolBox pSDSPanelToolBox, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDSPanelToolBox.isValidFlagDirty() && !bl2 : !pSDSPanelToolBox.isValidFlagDirty()) {
            return null;
        }
        Integer n = pSDSPanelToolBox.getValidFlag();
        if (bl) {
            if (bl2 && n == null) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("VALIDFLAG");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string = null;
            string = this.onTestValueRule_ValidFlag_Default(pSDSPanelToolBox, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("VALIDFLAG");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected void onSyncEntity(PSDSPanelToolBox pSDSPanelToolBox, boolean bl) throws Exception {
        super.onSyncEntity(pSDSPanelToolBox, bl);
    }

    protected void onSyncIndexEntities(PSDSPanelToolBox pSDSPanelToolBox, boolean bl) throws Exception {
        super.onSyncIndexEntities(pSDSPanelToolBox, bl);
    }

    public Object getDataContextValue(PSDSPanelToolBox pSDSPanelToolBox, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null) {
            // empty if block
        }
        if ((object = super.getDataContextValue(pSDSPanelToolBox, string, iDataContextParam)) != null) {
            return object;
        }
        return null;
    }

    protected void onExportMajorModel(PSDSPanelToolBox pSDSPanelToolBox, ArrayList<JSONObject> arrayList, int n) throws Exception {
        super.onExportMajorModel(pSDSPanelToolBox, arrayList, n);
    }

    protected String onTestValueRule(String string, String string2, IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        if (StringHelper.compare((String)string, (String)"CAT", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Cat_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATEDATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateDate_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATEMAN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateMan_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ICONCLS", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_IconCls_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"INITPARAMS", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_InitParams_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ITEMTYPE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ItemType_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ORDERVALUE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_OrderValue_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDSPANELTOOLBOXID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDSPanelToolBoxId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDSPANELTOOLBOXNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDSPanelToolBoxName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"TOOLBOXTYPE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ToolBoxType_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"TOOLTIP", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ToolTip_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UPDATEDATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UpdateDate_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UPDATEMAN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UpdateMan_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"USERTAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UserTag_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"USERTAG2", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UserTag2_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"VALIDFLAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ValidFlag_Default(iEntity, bl, bl2);
        }
        return super.onTestValueRule(string, string2, iEntity, bl, bl2);
    }

    protected String onTestValueRule_Cat_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("CAT", iEntity, bl2, null, false, 30, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
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

    protected String onTestValueRule_IconCls_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("ICONCLS", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_InitParams_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("INITPARAMS", iEntity, bl2, null, false, 4000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[4000]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[4000]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_ItemType_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("ITEMTYPE", iEntity, bl2, null, false, 30, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_OrderValue_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_PSDSPanelToolBoxId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDSPANELTOOLBOXID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDSPanelToolBoxName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDSPANELTOOLBOXNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_ToolBoxType_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("TOOLBOXTYPE", iEntity, bl2, null, false, 30, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_ToolTip_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("TOOLTIP", iEntity, bl2, null, false, 2000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[2000]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[2000]";
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

    protected String onTestValueRule_UserTag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("USERTAG", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_UserTag2_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("USERTAG2", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_ValidFlag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected boolean onMergeChild(String string, String string2, PSDSPanelToolBox pSDSPanelToolBox) throws Exception {
        boolean bl = false;
        if (super.onMergeChild(string, string2, pSDSPanelToolBox)) {
            bl = true;
        }
        return bl;
    }

    protected void onUpdateParent(PSDSPanelToolBox pSDSPanelToolBox) throws Exception {
        super.onUpdateParent(pSDSPanelToolBox);
    }

    @Override
    protected void exportCurXmlModel(PSDSPanelToolBox pSDSPanelToolBox, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSDSPANELTOOLBOX");
        if (!bl) {
            pSDSPanelToolBox.setCreateDate(null);
            pSDSPanelToolBox.setCreateMan(null);
            pSDSPanelToolBox.setPSDSPanelToolBoxId(null);
            pSDSPanelToolBox.setUpdateDate(null);
            pSDSPanelToolBox.setUpdateMan(null);
            super.exportCurXmlModel(pSDSPanelToolBox, xmlNode, bl);
        }
    }
}

