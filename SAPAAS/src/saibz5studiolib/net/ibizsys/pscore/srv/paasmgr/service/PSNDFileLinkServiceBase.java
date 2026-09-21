/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.PostConstruct
 *  net.ibizsys.paas.core.IDEDataSetFetchContext
 *  net.ibizsys.paas.dao.DAOGlobal
 *  net.ibizsys.paas.dao.IDAO
 *  net.ibizsys.paas.db.DBFetchResult
 *  net.ibizsys.paas.db.ISelectCond
 *  net.ibizsys.paas.db.SelectCond
 *  net.ibizsys.paas.demodel.DEModelGlobal
 *  net.ibizsys.paas.entity.EntityError
 *  net.ibizsys.paas.entity.EntityFieldError
 *  net.ibizsys.paas.entity.IEntity
 *  net.ibizsys.paas.service.CloneSession
 *  net.ibizsys.paas.service.IDataContextParam
 *  net.ibizsys.paas.service.IService
 *  net.ibizsys.paas.service.IServiceWork
 *  net.ibizsys.paas.service.ITransaction
 *  net.ibizsys.paas.service.ServiceGlobal
 *  net.ibizsys.paas.util.DataTypeHelper
 *  net.ibizsys.paas.util.StringHelper
 *  net.ibizsys.paas.xml.XmlNode
 *  net.sf.json.JSONObject
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 *  org.hibernate.SessionFactory
 */
package net.ibizsys.pscore.srv.paasmgr.service;

import java.util.ArrayList;
import javax.annotation.PostConstruct;
import net.ibizsys.paas.core.IDEDataSetFetchContext;
import net.ibizsys.paas.dao.DAOGlobal;
import net.ibizsys.paas.dao.IDAO;
import net.ibizsys.paas.db.DBFetchResult;
import net.ibizsys.paas.db.ISelectCond;
import net.ibizsys.paas.db.SelectCond;
import net.ibizsys.paas.demodel.DEModelGlobal;
import net.ibizsys.paas.entity.EntityError;
import net.ibizsys.paas.entity.EntityFieldError;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.service.CloneSession;
import net.ibizsys.paas.service.IDataContextParam;
import net.ibizsys.paas.service.IService;
import net.ibizsys.paas.service.IServiceWork;
import net.ibizsys.paas.service.ITransaction;
import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.paas.util.DataTypeHelper;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.xml.XmlNode;
import net.ibizsys.pscore.srv.PSCoreSysServiceBase;
import net.ibizsys.pscore.srv.core.IPSDataEntityModel;
import net.ibizsys.pscore.srv.paasmgr.dao.PSNDFileLinkDAO;
import net.ibizsys.pscore.srv.paasmgr.demodel.PSNDFileLinkDEModel;
import net.ibizsys.pscore.srv.paasmgr.entity.PSNDFile;
import net.ibizsys.pscore.srv.paasmgr.entity.PSNDFileBase;
import net.ibizsys.pscore.srv.paasmgr.entity.PSNDFileLink;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSNDFileLinkServiceBase
extends PSCoreSysServiceBase<PSNDFileLink> {
    private static final Log log = LogFactory.getLog(PSNDFileLinkServiceBase.class);
    private PSNDFileLinkDEModel pSNDFileLinkDEModel;
    private PSNDFileLinkDAO pSNDFileLinkDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.paasmgr.service.PSNDFileLinkService";
    }

    public PSNDFileLinkDEModel getPSNDFileLinkDEModel() {
        if (this.pSNDFileLinkDEModel == null) {
            try {
                this.pSNDFileLinkDEModel = (PSNDFileLinkDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.paasmgr.demodel.PSNDFileLinkDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSNDFileLinkDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSNDFileLinkDEModel();
    }

    public PSNDFileLinkDAO getPSNDFileLinkDAO() {
        if (this.pSNDFileLinkDAO == null) {
            try {
                this.pSNDFileLinkDAO = (PSNDFileLinkDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.paasmgr.dao.PSNDFileLinkDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSNDFileLinkDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSNDFileLinkDAO();
    }

    protected DBFetchResult onfetchDataSet(String string, IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        return super.onfetchDataSet(string, iDEDataSetFetchContext);
    }

    @Override
    protected void onExecuteAction(String string, IEntity iEntity) throws Exception {
        super.onExecuteAction(string, iEntity);
    }

    protected void onFillParentInfo(PSNDFileLink pSNDFileLink, String string, String string2, String string3) throws Exception {
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSNDFILELINK_PSNDFILE_PSNDFILEID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.paasmgr.service.PSNDFileService", (SessionFactory)this.getSessionFactory());
            PSNDFile pSNDFile = (PSNDFile)iService.getDEModel().createEntity();
            pSNDFile.set("PSNDFILEID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSNDFile);
            } else {
                iService.get((IEntity)pSNDFile);
            }
            this.onFillParentInfo_PSNDFile(pSNDFileLink, pSNDFile);
            return;
        }
        super.onFillParentInfo((IEntity)pSNDFileLink, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillParentInfo_PSNDFile(PSNDFileLink pSNDFileLink, PSNDFile pSNDFile) throws Exception {
        pSNDFileLink.setPSNDFileId(pSNDFile.getPSNDFileId());
        pSNDFileLink.setPSNDFileName(pSNDFile.getPSNDFileName());
    }

    protected void onFillEntityFullInfo(PSNDFileLink pSNDFileLink, boolean bl) throws Exception {
        if (bl) {
            // empty if block
        }
        super.onFillEntityFullInfo((IEntity)pSNDFileLink, bl);
        this.onFillEntityFullInfo_PSNDFile(pSNDFileLink, bl);
    }

    protected void onFillEntityFullInfo_PSNDFile(PSNDFileLink pSNDFileLink, boolean bl) throws Exception {
    }

    protected void onWriteBackParent(PSNDFileLink pSNDFileLink, boolean bl) throws Exception {
        super.onWriteBackParent((IEntity)pSNDFileLink, bl);
    }

    public ArrayList<PSNDFileLink> selectByPSNDFile(PSNDFileBase pSNDFileBase) throws Exception {
        return this.selectByPSNDFile(pSNDFileBase, "", -1);
    }

    public ArrayList<PSNDFileLink> selectByPSNDFile(PSNDFileBase pSNDFileBase, String string) throws Exception {
        return this.selectByPSNDFile(pSNDFileBase, string, -1);
    }

    public ArrayList<PSNDFileLink> selectByPSNDFile(PSNDFileBase pSNDFileBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSNDFILEID", (Object)pSNDFileBase.getPSNDFileId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSNDFileCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSNDFileCond(SelectCond selectCond) throws Exception {
    }

    public void testRemoveByPSNDFile(PSNDFile pSNDFile) throws Exception {
    }

    public void resetPSNDFile(PSNDFile pSNDFile) throws Exception {
        ArrayList<PSNDFileLink> arrayList = this.selectByPSNDFile(pSNDFile);
        for (PSNDFileLink pSNDFileLink : arrayList) {
            PSNDFileLink pSNDFileLink2 = (PSNDFileLink)this.getDEModel().createEntity();
            pSNDFileLink2.setPSNDFileLinkId(pSNDFileLink.getPSNDFileLinkId());
            pSNDFileLink2.setPSNDFileId(null);
            this.update(pSNDFileLink2);
        }
    }

    public void removeByPSNDFile(PSNDFile pSNDFile) throws Exception {
        final PSNDFile pSNDFile2 = pSNDFile;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSNDFileLinkServiceBase.this.onBeforeRemoveByPSNDFile(pSNDFile2);
                PSNDFileLinkServiceBase.this.internalRemoveByPSNDFile(pSNDFile2);
                PSNDFileLinkServiceBase.this.onAfterRemoveByPSNDFile(pSNDFile2);
            }
        });
    }

    protected void onBeforeRemoveByPSNDFile(PSNDFile pSNDFile) throws Exception {
    }

    protected void internalRemoveByPSNDFile(PSNDFile pSNDFile) throws Exception {
        ArrayList<PSNDFileLink> arrayList = this.selectByPSNDFile(pSNDFile);
        this.onBeforeRemoveByPSNDFile(pSNDFile, arrayList);
        for (PSNDFileLink pSNDFileLink : arrayList) {
            this.remove((IEntity)pSNDFileLink);
        }
        this.onAfterRemoveByPSNDFile(pSNDFile, arrayList);
    }

    protected void onAfterRemoveByPSNDFile(PSNDFile pSNDFile) throws Exception {
    }

    protected void onBeforeRemoveByPSNDFile(PSNDFile pSNDFile, ArrayList<PSNDFileLink> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSNDFile(PSNDFile pSNDFile, ArrayList<PSNDFileLink> arrayList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(PSNDFileLink pSNDFileLink) throws Exception {
        super.onBeforeRemove(pSNDFileLink);
    }

    protected void replaceParentInfo(PSNDFileLink pSNDFileLink, CloneSession cloneSession) throws Exception {
        IEntity iEntity;
        super.replaceParentInfo((IEntity)pSNDFileLink, cloneSession);
        if (pSNDFileLink.getPSNDFileId() != null && (iEntity = cloneSession.getEntity("PSNDFILE", (Object)pSNDFileLink.getPSNDFileId())) != null) {
            this.onFillParentInfo_PSNDFile(pSNDFileLink, (PSNDFile)iEntity);
        }
    }

    protected void onRemoveEntityUncopyValues(PSNDFileLink pSNDFileLink, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues((IEntity)pSNDFileLink, bl);
    }

    protected void onCheckEntity(boolean bl, PSNDFileLink pSNDFileLink, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_Memo(bl, pSNDFileLink, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSNDFileId(bl, pSNDFileLink, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSNDFileLinkId(bl, pSNDFileLink, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSNDFileLinkName(bl, pSNDFileLink, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, (IEntity)pSNDFileLink, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_Memo(boolean bl, PSNDFileLink pSNDFileLink, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSNDFileLink.isMemoDirty() : !pSNDFileLink.isMemoDirty()) {
            return null;
        }
        String string = pSNDFileLink.getMemo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Memo_Default((IEntity)pSNDFileLink, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("MEMO");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSNDFileId(boolean bl, PSNDFileLink pSNDFileLink, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSNDFileLink.isPSNDFileIdDirty() : !pSNDFileLink.isPSNDFileIdDirty()) {
            return null;
        }
        String string = pSNDFileLink.getPSNDFileId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSNDFileId_Default((IEntity)pSNDFileLink, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSNDFILEID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSNDFileLinkId(boolean bl, PSNDFileLink pSNDFileLink, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSNDFileLink.isPSNDFileLinkIdDirty() && !bl2 : !pSNDFileLink.isPSNDFileLinkIdDirty()) {
            return null;
        }
        String string = pSNDFileLink.getPSNDFileLinkId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSNDFILELINKID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSNDFileLinkId_Default((IEntity)pSNDFileLink, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSNDFILELINKID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSNDFileLinkName(boolean bl, PSNDFileLink pSNDFileLink, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSNDFileLink.isPSNDFileLinkNameDirty() && !bl2 : !pSNDFileLink.isPSNDFileLinkNameDirty()) {
            return null;
        }
        String string = pSNDFileLink.getPSNDFileLinkName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSNDFILELINKNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSNDFileLinkName_Default((IEntity)pSNDFileLink, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSNDFILELINKNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected void onSyncEntity(PSNDFileLink pSNDFileLink, boolean bl) throws Exception {
        super.onSyncEntity((IEntity)pSNDFileLink, bl);
    }

    protected void onSyncIndexEntities(PSNDFileLink pSNDFileLink, boolean bl) throws Exception {
        super.onSyncIndexEntities((IEntity)pSNDFileLink, bl);
    }

    public Object getDataContextValue(PSNDFileLink pSNDFileLink, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null) {
            // empty if block
        }
        if ((object = super.getDataContextValue((IEntity)pSNDFileLink, string, iDataContextParam)) != null) {
            return object;
        }
        return null;
    }

    protected void onExportMajorModel(PSNDFileLink pSNDFileLink, ArrayList<JSONObject> arrayList, int n) throws Exception {
        super.onExportMajorModel((IEntity)pSNDFileLink, arrayList, n);
    }

    protected String onTestValueRule(String string, String string2, IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        if (StringHelper.compare((String)string, (String)"CREATEDATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)"DEFAULT", (boolean)true) == 0) {
            return this.onTestValueRule_CreateDate_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATEMAN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)"DEFAULT", (boolean)true) == 0) {
            return this.onTestValueRule_CreateMan_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MEMO", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)"DEFAULT", (boolean)true) == 0) {
            return this.onTestValueRule_Memo_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSNDFILEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)"DEFAULT", (boolean)true) == 0) {
            return this.onTestValueRule_PSNDFileId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSNDFILELINKID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)"DEFAULT", (boolean)true) == 0) {
            return this.onTestValueRule_PSNDFileLinkId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSNDFILELINKNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)"DEFAULT", (boolean)true) == 0) {
            return this.onTestValueRule_PSNDFileLinkName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSNDFILENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)"DEFAULT", (boolean)true) == 0) {
            return this.onTestValueRule_PSNDFileName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UPDATEDATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)"DEFAULT", (boolean)true) == 0) {
            return this.onTestValueRule_UpdateDate_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UPDATEMAN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)"DEFAULT", (boolean)true) == 0) {
            return this.onTestValueRule_UpdateMan_Default(iEntity, bl, bl2);
        }
        return super.onTestValueRule(string, string2, iEntity, bl, bl2);
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

    protected String onTestValueRule_Memo_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("MEMO", iEntity, bl2, null, false, 1000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1000]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1000]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSNDFileId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSNDFILEID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSNDFileLinkId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSNDFILELINKID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSNDFileLinkName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSNDFILELINKNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSNDFileName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSNDFILENAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
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

    protected boolean onMergeChild(String string, String string2, PSNDFileLink pSNDFileLink) throws Exception {
        boolean bl = false;
        if (super.onMergeChild(string, string2, (IEntity)pSNDFileLink)) {
            bl = true;
        }
        return bl;
    }

    protected void onUpdateParent(PSNDFileLink pSNDFileLink) throws Exception {
        super.onUpdateParent((IEntity)pSNDFileLink);
    }

    @Override
    protected void exportCurXmlModel(PSNDFileLink pSNDFileLink, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSNDFILELINK");
        if (!bl) {
            pSNDFileLink.setCreateDate(null);
            pSNDFileLink.setCreateMan(null);
            pSNDFileLink.setPSNDFileLinkId(null);
            pSNDFileLink.setPSNDFileName(null);
            pSNDFileLink.setUpdateDate(null);
            pSNDFileLink.setUpdateMan(null);
            super.exportCurXmlModel(pSNDFileLink, xmlNode, bl);
        }
    }
}

