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
package net.ibizsys.pscore.srv.sysdevstudio.service;

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
import net.ibizsys.pscore.srv.dedesign.entity.PSDELogic;
import net.ibizsys.pscore.srv.dedesign.entity.PSDELogicBase;
import net.ibizsys.pscore.srv.sysdevstudio.dao.PSUWDELogicNodeDAO;
import net.ibizsys.pscore.srv.sysdevstudio.demodel.PSUWDELogicNodeDEModel;
import net.ibizsys.pscore.srv.sysdevstudio.entity.PSUWDELogicNode;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSUWDELogicNodeServiceBase
extends PSCoreSysServiceBase<PSUWDELogicNode> {
    private static final Log log = LogFactory.getLog(PSUWDELogicNodeServiceBase.class);
    public static final String DATASET_DEFAULT = "DEFAULT";
    private PSUWDELogicNodeDEModel pSUWDELogicNodeDEModel;
    private PSUWDELogicNodeDAO pSUWDELogicNodeDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.sysdevstudio.service.PSUWDELogicNodeService";
    }

    public PSUWDELogicNodeDEModel getPSUWDELogicNodeDEModel() {
        if (this.pSUWDELogicNodeDEModel == null) {
            try {
                this.pSUWDELogicNodeDEModel = (PSUWDELogicNodeDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.sysdevstudio.demodel.PSUWDELogicNodeDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSUWDELogicNodeDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSUWDELogicNodeDEModel();
    }

    public PSUWDELogicNodeDAO getPSUWDELogicNodeDAO() {
        if (this.pSUWDELogicNodeDAO == null) {
            try {
                this.pSUWDELogicNodeDAO = (PSUWDELogicNodeDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.sysdevstudio.dao.PSUWDELogicNodeDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSUWDELogicNodeDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSUWDELogicNodeDAO();
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

    protected void onFillParentInfo(PSUWDELogicNode pSUWDELogicNode, String string, String string2, String string3) throws Exception {
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSUWDELOGICNODE_PSDELOGIC_PSDELOGICID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDELogicService", (SessionFactory)this.getSessionFactory());
            PSDELogic pSDELogic = (PSDELogic)iService.getDEModel().createEntity();
            pSDELogic.set("PSDELOGICID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDELogic);
            } else {
                iService.get((IEntity)pSDELogic);
            }
            this.onFillParentInfo_PSDELogic(pSUWDELogicNode, pSDELogic);
            return;
        }
        super.onFillParentInfo((IEntity)pSUWDELogicNode, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillParentInfo_PSDELogic(PSUWDELogicNode pSUWDELogicNode, PSDELogic pSDELogic) throws Exception {
        pSUWDELogicNode.setPSDELogicId(pSDELogic.getPSDELogicId());
    }

    protected void onFillEntityFullInfo(PSUWDELogicNode pSUWDELogicNode, boolean bl) throws Exception {
        if (bl && pSUWDELogicNode.getDraftFlag() == null) {
            pSUWDELogicNode.setDraftFlag((Integer)this.getDefaultValue(this.getWebContext(), "", "1", 9));
        }
        super.onFillEntityFullInfo((IEntity)pSUWDELogicNode, bl);
        this.onFillEntityFullInfo_PSDELogic(pSUWDELogicNode, bl);
    }

    protected void onFillEntityFullInfo_PSDELogic(PSUWDELogicNode pSUWDELogicNode, boolean bl) throws Exception {
    }

    protected void onWriteBackParent(PSUWDELogicNode pSUWDELogicNode, boolean bl) throws Exception {
        super.onWriteBackParent((IEntity)pSUWDELogicNode, bl);
    }

    public ArrayList<PSUWDELogicNode> selectByPSDELogic(PSDELogicBase pSDELogicBase) throws Exception {
        return this.selectByPSDELogic(pSDELogicBase, "", -1);
    }

    public ArrayList<PSUWDELogicNode> selectByPSDELogic(PSDELogicBase pSDELogicBase, String string) throws Exception {
        return this.selectByPSDELogic(pSDELogicBase, string, -1);
    }

    public ArrayList<PSUWDELogicNode> selectByPSDELogic(PSDELogicBase pSDELogicBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDELOGICID", (Object)pSDELogicBase.getPSDELogicId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSDELogicCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSDELogicCond(SelectCond selectCond) throws Exception {
    }

    public void testRemoveByPSDELogic(PSDELogic pSDELogic) throws Exception {
    }

    public void resetPSDELogic(PSDELogic pSDELogic) throws Exception {
        ArrayList<PSUWDELogicNode> arrayList = this.selectByPSDELogic(pSDELogic);
        for (PSUWDELogicNode pSUWDELogicNode : arrayList) {
            PSUWDELogicNode pSUWDELogicNode2 = (PSUWDELogicNode)this.getDEModel().createEntity();
            pSUWDELogicNode2.setPSDELogicNodeId(pSUWDELogicNode.getPSDELogicNodeId());
            pSUWDELogicNode2.setPSDELogicId(null);
            this.update(pSUWDELogicNode2);
        }
    }

    public void removeByPSDELogic(PSDELogic pSDELogic) throws Exception {
        final PSDELogic pSDELogic2 = pSDELogic;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSUWDELogicNodeServiceBase.this.onBeforeRemoveByPSDELogic(pSDELogic2);
                PSUWDELogicNodeServiceBase.this.internalRemoveByPSDELogic(pSDELogic2);
                PSUWDELogicNodeServiceBase.this.onAfterRemoveByPSDELogic(pSDELogic2);
            }
        });
    }

    protected void onBeforeRemoveByPSDELogic(PSDELogic pSDELogic) throws Exception {
    }

    protected void internalRemoveByPSDELogic(PSDELogic pSDELogic) throws Exception {
        ArrayList<PSUWDELogicNode> arrayList = this.selectByPSDELogic(pSDELogic);
        this.onBeforeRemoveByPSDELogic(pSDELogic, arrayList);
        for (PSUWDELogicNode pSUWDELogicNode : arrayList) {
            this.remove((IEntity)pSUWDELogicNode);
        }
        this.onAfterRemoveByPSDELogic(pSDELogic, arrayList);
    }

    protected void onAfterRemoveByPSDELogic(PSDELogic pSDELogic) throws Exception {
    }

    protected void onBeforeRemoveByPSDELogic(PSDELogic pSDELogic, ArrayList<PSUWDELogicNode> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDELogic(PSDELogic pSDELogic, ArrayList<PSUWDELogicNode> arrayList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(PSUWDELogicNode pSUWDELogicNode) throws Exception {
        super.onBeforeRemove(pSUWDELogicNode);
    }

    protected void replaceParentInfo(PSUWDELogicNode pSUWDELogicNode, CloneSession cloneSession) throws Exception {
        IEntity iEntity;
        super.replaceParentInfo((IEntity)pSUWDELogicNode, cloneSession);
        if (pSUWDELogicNode.getPSDELogicId() != null && (iEntity = cloneSession.getEntity("PSDELOGIC", (Object)pSUWDELogicNode.getPSDELogicId())) != null) {
            this.onFillParentInfo_PSDELogic(pSUWDELogicNode, (PSDELogic)iEntity);
        }
    }

    protected void onRemoveEntityUncopyValues(PSUWDELogicNode pSUWDELogicNode, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues((IEntity)pSUWDELogicNode, bl);
    }

    protected void onCheckEntity(boolean bl, PSUWDELogicNode pSUWDELogicNode, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_LogicNodeType(bl, pSUWDELogicNode, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDELogicId(bl, pSUWDELogicNode, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDELogicNodeId(bl, pSUWDELogicNode, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDELogicNodeName(bl, pSUWDELogicNode, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_DraftFlag(bl, pSUWDELogicNode, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, (IEntity)pSUWDELogicNode, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_LogicNodeType(boolean bl, PSUWDELogicNode pSUWDELogicNode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSUWDELogicNode.isLogicNodeTypeDirty() && !bl2 : !pSUWDELogicNode.isLogicNodeTypeDirty()) {
            return null;
        }
        String string = pSUWDELogicNode.getLogicNodeType();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("LOGICNODETYPE");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_LogicNodeType_Default((IEntity)pSUWDELogicNode, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("LOGICNODETYPE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDELogicId(boolean bl, PSUWDELogicNode pSUWDELogicNode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSUWDELogicNode.isPSDELogicIdDirty() : !pSUWDELogicNode.isPSDELogicIdDirty()) {
            return null;
        }
        String string = pSUWDELogicNode.getPSDELogicId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDELogicId_Default((IEntity)pSUWDELogicNode, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDELOGICID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDELogicNodeId(boolean bl, PSUWDELogicNode pSUWDELogicNode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSUWDELogicNode.isPSDELogicNodeIdDirty() && !bl2 : !pSUWDELogicNode.isPSDELogicNodeIdDirty()) {
            return null;
        }
        String string = pSUWDELogicNode.getPSDELogicNodeId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDELOGICNODEID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDELogicNodeId_Default((IEntity)pSUWDELogicNode, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDELOGICNODEID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDELogicNodeName(boolean bl, PSUWDELogicNode pSUWDELogicNode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSUWDELogicNode.isPSDELogicNodeNameDirty() && !bl2 : !pSUWDELogicNode.isPSDELogicNodeNameDirty()) {
            return null;
        }
        String string = pSUWDELogicNode.getPSDELogicNodeName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDELOGICNODENAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDELogicNodeName_Default((IEntity)pSUWDELogicNode, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDELOGICNODENAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_DraftFlag(boolean bl, PSUWDELogicNode pSUWDELogicNode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSUWDELogicNode.isDraftFlagDirty() : !pSUWDELogicNode.isDraftFlagDirty()) {
            return null;
        }
        Integer n = pSUWDELogicNode.getDraftFlag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_DraftFlag_Default((IEntity)pSUWDELogicNode, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("SRFDRAFTFLAG");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected void onSyncEntity(PSUWDELogicNode pSUWDELogicNode, boolean bl) throws Exception {
        super.onSyncEntity((IEntity)pSUWDELogicNode, bl);
    }

    protected void onSyncIndexEntities(PSUWDELogicNode pSUWDELogicNode, boolean bl) throws Exception {
        super.onSyncIndexEntities((IEntity)pSUWDELogicNode, bl);
    }

    public Object getDataContextValue(PSUWDELogicNode pSUWDELogicNode, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null) {
            // empty if block
        }
        if ((object = super.getDataContextValue((IEntity)pSUWDELogicNode, string, iDataContextParam)) != null) {
            return object;
        }
        return null;
    }

    protected void onExportMajorModel(PSUWDELogicNode pSUWDELogicNode, ArrayList<JSONObject> arrayList, int n) throws Exception {
        super.onExportMajorModel((IEntity)pSUWDELogicNode, arrayList, n);
    }

    protected String onTestValueRule(String string, String string2, IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        if (StringHelper.compare((String)string, (String)"LOGICNODETYPE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_LogicNodeType_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDELOGICID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDELogicId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDELOGICNODEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDELogicNodeId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDELOGICNODENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDELogicNodeName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"SRFDRAFTFLAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DraftFlag_Default(iEntity, bl, bl2);
        }
        return super.onTestValueRule(string, string2, iEntity, bl, bl2);
    }

    protected String onTestValueRule_LogicNodeType_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("LOGICNODETYPE", iEntity, bl2, null, false, 40, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[40]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[40]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDELogicId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDELOGICID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDELogicNodeId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDELOGICNODEID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDELogicNodeName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDELOGICNODENAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_DraftFlag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected boolean onMergeChild(String string, String string2, PSUWDELogicNode pSUWDELogicNode) throws Exception {
        boolean bl = false;
        if (super.onMergeChild(string, string2, (IEntity)pSUWDELogicNode)) {
            bl = true;
        }
        return bl;
    }

    protected void onUpdateParent(PSUWDELogicNode pSUWDELogicNode) throws Exception {
        super.onUpdateParent((IEntity)pSUWDELogicNode);
    }

    @Override
    protected void exportCurXmlModel(PSUWDELogicNode pSUWDELogicNode, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSUWDELOGICNODE");
        if (!bl) {
            pSUWDELogicNode.setPSDELogicNodeId(null);
            super.exportCurXmlModel(pSUWDELogicNode, xmlNode, bl);
        }
    }

    @Override
    public Object getDataType(PSUWDELogicNode pSUWDELogicNode) throws Exception {
        return pSUWDELogicNode.getLogicNodeType();
    }
}

