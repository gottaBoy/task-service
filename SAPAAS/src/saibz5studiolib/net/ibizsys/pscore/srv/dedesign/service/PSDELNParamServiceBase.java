/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.fasterxml.jackson.databind.node.ObjectNode
 *  javax.annotation.PostConstruct
 *  net.ibizsys.paas.core.IDEDataSetFetchContext
 *  net.ibizsys.paas.dao.DAOGlobal
 *  net.ibizsys.paas.dao.IDAO
 *  net.ibizsys.paas.data.DataObject
 *  net.ibizsys.paas.data.IDataObject
 *  net.ibizsys.paas.db.DBFetchResult
 *  net.ibizsys.paas.db.ISelectCond
 *  net.ibizsys.paas.db.SelectCond
 *  net.ibizsys.paas.demodel.DEModelGlobal
 *  net.ibizsys.paas.demodel.IDataEntityModel
 *  net.ibizsys.paas.entity.EntityError
 *  net.ibizsys.paas.entity.EntityFieldError
 *  net.ibizsys.paas.entity.IEntity
 *  net.ibizsys.paas.entity.SimpleEntity
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
package net.ibizsys.pscore.srv.dedesign.service;

import com.fasterxml.jackson.databind.node.ObjectNode;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.PostConstruct;
import net.ibizsys.paas.core.IDEDataSetFetchContext;
import net.ibizsys.paas.dao.DAOGlobal;
import net.ibizsys.paas.dao.IDAO;
import net.ibizsys.paas.data.DataObject;
import net.ibizsys.paas.data.IDataObject;
import net.ibizsys.paas.db.DBFetchResult;
import net.ibizsys.paas.db.ISelectCond;
import net.ibizsys.paas.db.SelectCond;
import net.ibizsys.paas.demodel.DEModelGlobal;
import net.ibizsys.paas.demodel.IDataEntityModel;
import net.ibizsys.paas.entity.EntityError;
import net.ibizsys.paas.entity.EntityFieldError;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.entity.SimpleEntity;
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
import net.ibizsys.pscore.srv.dedesign.dao.PSDELNParamDAO;
import net.ibizsys.pscore.srv.dedesign.demodel.PSDELNParamDEModel;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEField;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEFieldBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDELNParam;
import net.ibizsys.pscore.srv.dedesign.entity.PSDELogicNode;
import net.ibizsys.pscore.srv.dedesign.entity.PSDELogicNodeBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDELogicParam;
import net.ibizsys.pscore.srv.dedesign.entity.PSDELogicParamBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDataEntity;
import net.ibizsys.pscore.srv.dedesign.entity.PSDataEntityBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysMsgTempl;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysMsgTemplBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysSequence;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysSequenceBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysTranslator;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysTranslatorBase;
import net.ibizsys.pscore.srv.sysdevstudio.entity.PSMOSFile;
import net.ibizsys.pscore.srv.util.IPSMOSFileFilter;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDELNParamServiceBase
extends PSCoreSysServiceBase<PSDELNParam> {
    private static final Log log = LogFactory.getLog(PSDELNParamServiceBase.class);
    public static final String DATASET_DEFAULT = "DEFAULT";
    private PSDELNParamDEModel pSDELNParamDEModel;
    private PSDELNParamDAO pSDELNParamDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.dedesign.service.PSDELNParamService";
    }

    public PSDELNParamDEModel getPSDELNParamDEModel() {
        if (this.pSDELNParamDEModel == null) {
            try {
                this.pSDELNParamDEModel = (PSDELNParamDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.dedesign.demodel.PSDELNParamDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDELNParamDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSDELNParamDEModel();
    }

    public PSDELNParamDAO getPSDELNParamDAO() {
        if (this.pSDELNParamDAO == null) {
            try {
                this.pSDELNParamDAO = (PSDELNParamDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.dedesign.dao.PSDELNParamDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDELNParamDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSDELNParamDAO();
    }

    protected DBFetchResult onfetchDataSet(String string, IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        if (StringHelper.compare((String)string, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.fetchDefault(iDEDataSetFetchContext);
        }
        return super.onfetchDataSet(string, iDEDataSetFetchContext);
    }

    protected DBFetchResult onfetchDataSetTemp(String string, IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        if (StringHelper.compare((String)string, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.fetchTempDefault(iDEDataSetFetchContext);
        }
        return super.onfetchDataSetTemp(string, iDEDataSetFetchContext);
    }

    @Override
    protected void onExecuteAction(String string, IEntity iEntity) throws Exception {
        super.onExecuteAction(string, iEntity);
    }

    public DBFetchResult fetchDefault(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_DEFAULT, false);
        return dBFetchResult;
    }

    public DBFetchResult fetchTempDefault(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_DEFAULT, true);
        return dBFetchResult;
    }

    protected void onFillParentInfo(PSDELNParam pSDELNParam, String string, String string2, String string3) throws Exception {
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDELNPARAM_PSDATAENTITY_PSDEID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDataEntityService", (SessionFactory)this.getSessionFactory());
            PSDataEntity pSDataEntity = (PSDataEntity)iService.getDEModel().createEntity();
            pSDataEntity.set("PSDATAENTITYID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDataEntity);
            } else {
                iService.get(pSDataEntity);
            }
            this.onFillParentInfo_PSDE(pSDELNParam, pSDataEntity);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDELNPARAM_PSDEFIELD_DSTPSDEFID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEFieldService", (SessionFactory)this.getSessionFactory());
            PSDEField pSDEField = (PSDEField)iService.getDEModel().createEntity();
            pSDEField.set("PSDEFIELDID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDEField);
            } else {
                iService.get(pSDEField);
            }
            this.onFillParentInfo_DstPSDEF(pSDELNParam, pSDEField);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDELNPARAM_PSDEFIELD_SRCPSDEFID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEFieldService", (SessionFactory)this.getSessionFactory());
            PSDEField pSDEField = (PSDEField)iService.getDEModel().createEntity();
            pSDEField.set("PSDEFIELDID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDEField);
            } else {
                iService.get(pSDEField);
            }
            this.onFillParentInfo_SrcPSDEF(pSDELNParam, pSDEField);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDELNPARAM_PSDELOGICNODE_PSDELOGICNODEID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDELogicNodeService", (SessionFactory)this.getSessionFactory());
            PSDELogicNode pSDELogicNode = (PSDELogicNode)iService.getDEModel().createEntity();
            pSDELogicNode.set("PSDELOGICNODEID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDELogicNode);
            } else {
                iService.get(pSDELogicNode);
            }
            this.onFillParentInfo_PSDELogicNode(pSDELNParam, pSDELogicNode);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDELNPARAM_PSDELOGICPARAM_DSTPSDLPARAMID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDELogicParamService", (SessionFactory)this.getSessionFactory());
            PSDELogicParam pSDELogicParam = (PSDELogicParam)iService.getDEModel().createEntity();
            pSDELogicParam.set("PSDELOGICPARAMID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDELogicParam);
            } else {
                iService.get(pSDELogicParam);
            }
            this.onFillParentInfo_DstPSDLParam(pSDELNParam, pSDELogicParam);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDELNPARAM_PSDELOGICPARAM_SRCPSDLPARAMID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDELogicParamService", (SessionFactory)this.getSessionFactory());
            PSDELogicParam pSDELogicParam = (PSDELogicParam)iService.getDEModel().createEntity();
            pSDELogicParam.set("PSDELOGICPARAMID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDELogicParam);
            } else {
                iService.get(pSDELogicParam);
            }
            this.onFillParentInfo_SrcPSDLParam(pSDELNParam, pSDELogicParam);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDELNPARAM_PSSYSMSGTEMPL_PSSYSMSGTEMPLID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysMsgTemplService", (SessionFactory)this.getSessionFactory());
            PSSysMsgTempl pSSysMsgTempl = (PSSysMsgTempl)iService.getDEModel().createEntity();
            pSSysMsgTempl.set("PSSYSMSGTEMPLID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSSysMsgTempl);
            } else {
                iService.get(pSSysMsgTempl);
            }
            this.onFillParentInfo_PSSysMsgTempl(pSDELNParam, pSSysMsgTempl);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDELNPARAM_PSSYSSEQUENCE_PSSYSSEQUENCEID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysSequenceService", (SessionFactory)this.getSessionFactory());
            PSSysSequence pSSysSequence = (PSSysSequence)iService.getDEModel().createEntity();
            pSSysSequence.set("PSSYSSEQUENCEID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSSysSequence);
            } else {
                iService.get(pSSysSequence);
            }
            this.onFillParentInfo_PSSysSequeue(pSDELNParam, pSSysSequence);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDELNPARAM_PSSYSTRANSLATOR_PSSYSTRANSLATORID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysTranslatorService", (SessionFactory)this.getSessionFactory());
            PSSysTranslator pSSysTranslator = (PSSysTranslator)iService.getDEModel().createEntity();
            pSSysTranslator.set("PSSYSTRANSLATORID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSSysTranslator);
            } else {
                iService.get(pSSysTranslator);
            }
            this.onFillParentInfo_PSSysTranslator(pSDELNParam, pSSysTranslator);
            return;
        }
        super.onFillParentInfo(pSDELNParam, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        if (StringHelper.compare((String)string, (String)"DER1N_PSDELNPARAM_PSDELOGICNODE_PSDELOGICNODEID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDELogicNodeService", (SessionFactory)this.getSessionFactory());
            PSDELogicNode pSDELogicNode = (PSDELogicNode)iService.getDEModel().createEntity();
            pSDELogicNode.set("PSDELOGICNODEID", string2);
            return this.onSyncDER1NData_PSDELogicNode(pSDELogicNode, string3);
        }
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillParentInfo_PSDE(PSDELNParam pSDELNParam, PSDataEntity pSDataEntity) throws Exception {
        pSDELNParam.setPSDEId(pSDataEntity.getPSDataEntityId());
        pSDELNParam.setPSDEName(pSDataEntity.getPSDataEntityName());
    }

    protected void onFillParentInfo_DstPSDEF(PSDELNParam pSDELNParam, PSDEField pSDEField) throws Exception {
        pSDELNParam.setDstPSDEFId(pSDEField.getPSDEFieldId());
        pSDELNParam.setDstPSDEFName(pSDEField.getPSDEFieldName());
    }

    protected void onFillParentInfo_SrcPSDEF(PSDELNParam pSDELNParam, PSDEField pSDEField) throws Exception {
        pSDELNParam.setSrcPSDEFId(pSDEField.getPSDEFieldId());
        pSDELNParam.setSrcPSDEFName(pSDEField.getPSDEFieldName());
    }

    protected void onFillParentInfo_PSDELogicNode(PSDELNParam pSDELNParam, PSDELogicNode pSDELogicNode) throws Exception {
        pSDELNParam.setPSDELogicId(pSDELogicNode.getPSDELogicId());
        pSDELNParam.setPSDELogicNodeId(pSDELogicNode.getPSDELogicNodeId());
        pSDELNParam.setPSDELogicNodeName(pSDELogicNode.getPSDELogicNodeName());
    }

    protected String onSyncDER1NData_PSDELogicNode(PSDELogicNode pSDELogicNode, String string) throws Exception {
        if (StringHelper.isNullOrEmpty((String)string)) {
            this.removeByPSDELogicNode(pSDELogicNode);
        } else {
            HashMap<String, String> hashMap = new HashMap<String, String>();
            String[] stringArray = StringHelper.splitEx((String)string);
            if (stringArray != null) {
                for (int i = 0; i < stringArray.length; ++i) {
                    if (StringHelper.isNullOrEmpty((String)stringArray[i])) continue;
                    hashMap.put(stringArray[i], "");
                }
            }
            ArrayList<PSDELNParam> arrayList = this.selectByPSDELogicNode(pSDELogicNode);
            for (PSDELNParam pSDELNParam : arrayList) {
                if (hashMap.containsKey(DataObject.getStringValue((IDataObject)pSDELNParam, (String)"PSDELNPARAMID", (String)""))) continue;
                this.remove(pSDELNParam);
            }
        }
        return null;
    }

    protected void onFillParentInfo_DstPSDLParam(PSDELNParam pSDELNParam, PSDELogicParam pSDELogicParam) throws Exception {
        pSDELNParam.setDstParamPSDEId(pSDELogicParam.getParamPSDEId());
        pSDELNParam.setDstPSDLParamId(pSDELogicParam.getPSDELogicParamId());
        pSDELNParam.setDstPSDLParamName(pSDELogicParam.getPSDELogicParamName());
    }

    protected void onFillParentInfo_SrcPSDLParam(PSDELNParam pSDELNParam, PSDELogicParam pSDELogicParam) throws Exception {
        pSDELNParam.setSrcParamPSDEId(pSDELogicParam.getParamPSDEId());
        pSDELNParam.setSrcPSDLParamId(pSDELogicParam.getPSDELogicParamId());
        pSDELNParam.setSrcPSDLParamName(pSDELogicParam.getPSDELogicParamName());
    }

    protected void onFillParentInfo_PSSysMsgTempl(PSDELNParam pSDELNParam, PSSysMsgTempl pSSysMsgTempl) throws Exception {
        pSDELNParam.setPSSysMsgTemplId(pSSysMsgTempl.getPSSysMsgTemplId());
        pSDELNParam.setPSSysMsgTemplName(pSSysMsgTempl.getPSSysMsgTemplName());
    }

    protected void onFillParentInfo_PSSysSequeue(PSDELNParam pSDELNParam, PSSysSequence pSSysSequence) throws Exception {
        pSDELNParam.setPSSysSequenceId(pSSysSequence.getPSSysSequenceId());
        pSDELNParam.setPSSysSequenceName(pSSysSequence.getPSSysSequenceName());
    }

    protected void onFillParentInfo_PSSysTranslator(PSDELNParam pSDELNParam, PSSysTranslator pSSysTranslator) throws Exception {
        pSDELNParam.setPSSysTranslatorId(pSSysTranslator.getPSSysTranslatorId());
        pSDELNParam.setPSSysTranslatorName(pSSysTranslator.getPSSysTranslatorName());
    }

    protected void onFillEntityFullInfo(PSDELNParam pSDELNParam, boolean bl) throws Exception {
        if (bl) {
            // empty if block
        }
        super.onFillEntityFullInfo(pSDELNParam, bl);
        this.onFillEntityFullInfo_PSDE(pSDELNParam, bl);
        this.onFillEntityFullInfo_DstPSDEF(pSDELNParam, bl);
        this.onFillEntityFullInfo_SrcPSDEF(pSDELNParam, bl);
        this.onFillEntityFullInfo_PSDELogicNode(pSDELNParam, bl);
        this.onFillEntityFullInfo_DstPSDLParam(pSDELNParam, bl);
        this.onFillEntityFullInfo_SrcPSDLParam(pSDELNParam, bl);
        this.onFillEntityFullInfo_PSSysMsgTempl(pSDELNParam, bl);
        this.onFillEntityFullInfo_PSSysSequeue(pSDELNParam, bl);
        this.onFillEntityFullInfo_PSSysTranslator(pSDELNParam, bl);
    }

    protected void onFillEntityFullInfo_PSDE(PSDELNParam pSDELNParam, boolean bl) throws Exception {
        if (pSDELNParam.isPSDEIdDirty()) {
            if (pSDELNParam.getPSDEId() != null) {
                if (pSDELNParam.getPSDEId() == null || pSDELNParam.getPSDEName() == null) {
                    PSDataEntity pSDataEntity = pSDELNParam.getPSDE();
                    pSDELNParam.setPSDEName(pSDataEntity.getPSDataEntityName());
                }
            } else {
                pSDELNParam.setPSDEName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_DstPSDEF(PSDELNParam pSDELNParam, boolean bl) throws Exception {
        if (pSDELNParam.isDstPSDEFIdDirty()) {
            if (pSDELNParam.getDstPSDEFId() != null) {
                if (pSDELNParam.getDstPSDEFId() == null || pSDELNParam.getDstPSDEFName() == null) {
                    PSDEField pSDEField = pSDELNParam.getDstPSDEF();
                    pSDELNParam.setDstPSDEFName(pSDEField.getPSDEFieldName());
                }
            } else {
                pSDELNParam.setDstPSDEFName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_SrcPSDEF(PSDELNParam pSDELNParam, boolean bl) throws Exception {
        if (pSDELNParam.isSrcPSDEFIdDirty()) {
            if (pSDELNParam.getSrcPSDEFId() != null) {
                if (pSDELNParam.getSrcPSDEFId() == null || pSDELNParam.getSrcPSDEFName() == null) {
                    PSDEField pSDEField = pSDELNParam.getSrcPSDEF();
                    pSDELNParam.setSrcPSDEFName(pSDEField.getPSDEFieldName());
                }
            } else {
                pSDELNParam.setSrcPSDEFName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_PSDELogicNode(PSDELNParam pSDELNParam, boolean bl) throws Exception {
        if (pSDELNParam.isPSDELogicNodeIdDirty()) {
            if (pSDELNParam.getPSDELogicNodeId() != null) {
                if (pSDELNParam.getPSDELogicId() == null || pSDELNParam.getPSDELogicNodeId() == null || pSDELNParam.getPSDELogicNodeName() == null) {
                    PSDELogicNode pSDELogicNode = pSDELNParam.getPSDELogicNode();
                    pSDELNParam.setPSDELogicId(pSDELogicNode.getPSDELogicId());
                    pSDELNParam.setPSDELogicNodeName(pSDELogicNode.getPSDELogicNodeName());
                }
            } else {
                pSDELNParam.setPSDELogicId(null);
                pSDELNParam.setPSDELogicNodeName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_DstPSDLParam(PSDELNParam pSDELNParam, boolean bl) throws Exception {
        if (pSDELNParam.isDstPSDLParamIdDirty()) {
            if (pSDELNParam.getDstPSDLParamId() != null) {
                if (pSDELNParam.getDstPSDLParamId() == null || pSDELNParam.getDstPSDLParamName() == null) {
                    PSDELogicParam pSDELogicParam = pSDELNParam.getDstPSDLParam();
                    pSDELNParam.setDstParamPSDEId(pSDELogicParam.getParamPSDEId());
                    pSDELNParam.setDstPSDLParamName(pSDELogicParam.getPSDELogicParamName());
                }
            } else {
                pSDELNParam.setDstParamPSDEId(null);
                pSDELNParam.setDstPSDLParamName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_SrcPSDLParam(PSDELNParam pSDELNParam, boolean bl) throws Exception {
        if (pSDELNParam.isSrcPSDLParamIdDirty()) {
            if (pSDELNParam.getSrcPSDLParamId() != null) {
                if (pSDELNParam.getSrcPSDLParamId() == null || pSDELNParam.getSrcPSDLParamName() == null) {
                    PSDELogicParam pSDELogicParam = pSDELNParam.getSrcPSDLParam();
                    pSDELNParam.setSrcParamPSDEId(pSDELogicParam.getParamPSDEId());
                    pSDELNParam.setSrcPSDLParamName(pSDELogicParam.getPSDELogicParamName());
                }
            } else {
                pSDELNParam.setSrcParamPSDEId(null);
                pSDELNParam.setSrcPSDLParamName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_PSSysMsgTempl(PSDELNParam pSDELNParam, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSSysSequeue(PSDELNParam pSDELNParam, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSSysTranslator(PSDELNParam pSDELNParam, boolean bl) throws Exception {
    }

    protected void onWriteBackParent(PSDELNParam pSDELNParam, boolean bl) throws Exception {
        super.onWriteBackParent(pSDELNParam, bl);
    }

    public ArrayList<PSDELNParam> selectByPSDE(PSDataEntityBase pSDataEntityBase) throws Exception {
        return this.selectByPSDE(pSDataEntityBase, "", -1);
    }

    public ArrayList<PSDELNParam> selectByPSDE(PSDataEntityBase pSDataEntityBase, String string) throws Exception {
        return this.selectByPSDE(pSDataEntityBase, string, -1);
    }

    public ArrayList<PSDELNParam> selectByPSDE(PSDataEntityBase pSDataEntityBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDEID", (Object)pSDataEntityBase.getPSDataEntityId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSDECond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSDECond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDELNParam> selectByDstPSDEF(PSDEFieldBase pSDEFieldBase) throws Exception {
        return this.selectByDstPSDEF(pSDEFieldBase, "", -1);
    }

    public ArrayList<PSDELNParam> selectByDstPSDEF(PSDEFieldBase pSDEFieldBase, String string) throws Exception {
        return this.selectByDstPSDEF(pSDEFieldBase, string, -1);
    }

    public ArrayList<PSDELNParam> selectByDstPSDEF(PSDEFieldBase pSDEFieldBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("DSTPSDEFID", (Object)pSDEFieldBase.getPSDEFieldId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByDstPSDEFCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByDstPSDEFCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDELNParam> selectBySrcPSDEF(PSDEFieldBase pSDEFieldBase) throws Exception {
        return this.selectBySrcPSDEF(pSDEFieldBase, "", -1);
    }

    public ArrayList<PSDELNParam> selectBySrcPSDEF(PSDEFieldBase pSDEFieldBase, String string) throws Exception {
        return this.selectBySrcPSDEF(pSDEFieldBase, string, -1);
    }

    public ArrayList<PSDELNParam> selectBySrcPSDEF(PSDEFieldBase pSDEFieldBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("SRCPSDEFID", (Object)pSDEFieldBase.getPSDEFieldId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectBySrcPSDEFCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectBySrcPSDEFCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDELNParam> selectByPSDELogicNode(PSDELogicNodeBase pSDELogicNodeBase) throws Exception {
        return this.selectByPSDELogicNode(pSDELogicNodeBase, "", -1);
    }

    public ArrayList<PSDELNParam> selectByPSDELogicNode(PSDELogicNodeBase pSDELogicNodeBase, String string) throws Exception {
        return this.selectByPSDELogicNode(pSDELogicNodeBase, string, -1);
    }

    public ArrayList<PSDELNParam> selectByPSDELogicNode(PSDELogicNodeBase pSDELogicNodeBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDELOGICNODEID", (Object)pSDELogicNodeBase.getPSDELogicNodeId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSDELogicNodeCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSDELogicNodeCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDELNParam> selectTempByPSDELogicNode(PSDELogicNodeBase pSDELogicNodeBase) throws Exception {
        return this.selectTempByPSDELogicNode(pSDELogicNodeBase, "");
    }

    public ArrayList<PSDELNParam> selectTempByPSDELogicNode(PSDELogicNodeBase pSDELogicNodeBase, String string) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDELOGICNODEID", (Object)pSDELogicNodeBase.getPSDELogicNodeId());
        selectCond.setOrderInfo(string);
        this.onFillSelectTempByPSDELogicNodeCond(selectCond);
        return this.selectTemp((ISelectCond)selectCond);
    }

    protected void onFillSelectTempByPSDELogicNodeCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDELNParam> selectByDstPSDLParam(PSDELogicParamBase pSDELogicParamBase) throws Exception {
        return this.selectByDstPSDLParam(pSDELogicParamBase, "", -1);
    }

    public ArrayList<PSDELNParam> selectByDstPSDLParam(PSDELogicParamBase pSDELogicParamBase, String string) throws Exception {
        return this.selectByDstPSDLParam(pSDELogicParamBase, string, -1);
    }

    public ArrayList<PSDELNParam> selectByDstPSDLParam(PSDELogicParamBase pSDELogicParamBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("DSTPSDLPARAMID", (Object)pSDELogicParamBase.getPSDELogicParamId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByDstPSDLParamCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByDstPSDLParamCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDELNParam> selectTempByDstPSDLParam(PSDELogicParamBase pSDELogicParamBase) throws Exception {
        return this.selectTempByDstPSDLParam(pSDELogicParamBase, "");
    }

    public ArrayList<PSDELNParam> selectTempByDstPSDLParam(PSDELogicParamBase pSDELogicParamBase, String string) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("DSTPSDLPARAMID", (Object)pSDELogicParamBase.getPSDELogicParamId());
        selectCond.setOrderInfo(string);
        this.onFillSelectTempByDstPSDLParamCond(selectCond);
        return this.selectTemp((ISelectCond)selectCond);
    }

    protected void onFillSelectTempByDstPSDLParamCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDELNParam> selectBySrcPSDLParam(PSDELogicParamBase pSDELogicParamBase) throws Exception {
        return this.selectBySrcPSDLParam(pSDELogicParamBase, "", -1);
    }

    public ArrayList<PSDELNParam> selectBySrcPSDLParam(PSDELogicParamBase pSDELogicParamBase, String string) throws Exception {
        return this.selectBySrcPSDLParam(pSDELogicParamBase, string, -1);
    }

    public ArrayList<PSDELNParam> selectBySrcPSDLParam(PSDELogicParamBase pSDELogicParamBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("SRCPSDLPARAMID", (Object)pSDELogicParamBase.getPSDELogicParamId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectBySrcPSDLParamCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectBySrcPSDLParamCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDELNParam> selectTempBySrcPSDLParam(PSDELogicParamBase pSDELogicParamBase) throws Exception {
        return this.selectTempBySrcPSDLParam(pSDELogicParamBase, "");
    }

    public ArrayList<PSDELNParam> selectTempBySrcPSDLParam(PSDELogicParamBase pSDELogicParamBase, String string) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("SRCPSDLPARAMID", (Object)pSDELogicParamBase.getPSDELogicParamId());
        selectCond.setOrderInfo(string);
        this.onFillSelectTempBySrcPSDLParamCond(selectCond);
        return this.selectTemp((ISelectCond)selectCond);
    }

    protected void onFillSelectTempBySrcPSDLParamCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDELNParam> selectByPSSysMsgTempl(PSSysMsgTemplBase pSSysMsgTemplBase) throws Exception {
        return this.selectByPSSysMsgTempl(pSSysMsgTemplBase, "", -1);
    }

    public ArrayList<PSDELNParam> selectByPSSysMsgTempl(PSSysMsgTemplBase pSSysMsgTemplBase, String string) throws Exception {
        return this.selectByPSSysMsgTempl(pSSysMsgTemplBase, string, -1);
    }

    public ArrayList<PSDELNParam> selectByPSSysMsgTempl(PSSysMsgTemplBase pSSysMsgTemplBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSSYSMSGTEMPLID", (Object)pSSysMsgTemplBase.getPSSysMsgTemplId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSSysMsgTemplCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSSysMsgTemplCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDELNParam> selectByPSSysSequeue(PSSysSequenceBase pSSysSequenceBase) throws Exception {
        return this.selectByPSSysSequeue(pSSysSequenceBase, "", -1);
    }

    public ArrayList<PSDELNParam> selectByPSSysSequeue(PSSysSequenceBase pSSysSequenceBase, String string) throws Exception {
        return this.selectByPSSysSequeue(pSSysSequenceBase, string, -1);
    }

    public ArrayList<PSDELNParam> selectByPSSysSequeue(PSSysSequenceBase pSSysSequenceBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSSYSSEQUENCEID", (Object)pSSysSequenceBase.getPSSysSequenceId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSSysSequeueCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSSysSequeueCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDELNParam> selectByPSSysTranslator(PSSysTranslatorBase pSSysTranslatorBase) throws Exception {
        return this.selectByPSSysTranslator(pSSysTranslatorBase, "", -1);
    }

    public ArrayList<PSDELNParam> selectByPSSysTranslator(PSSysTranslatorBase pSSysTranslatorBase, String string) throws Exception {
        return this.selectByPSSysTranslator(pSSysTranslatorBase, string, -1);
    }

    public ArrayList<PSDELNParam> selectByPSSysTranslator(PSSysTranslatorBase pSSysTranslatorBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSSYSTRANSLATORID", (Object)pSSysTranslatorBase.getPSSysTranslatorId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSSysTranslatorCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSSysTranslatorCond(SelectCond selectCond) throws Exception {
    }

    public void testRemoveByPSDE(PSDataEntity pSDataEntity) throws Exception {
        ArrayList<PSDELNParam> arrayList = this.selectByPSDE(pSDataEntity, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDATAENTITY");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDataEntity);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDELNPARAM_PSDATAENTITY_PSDEID", "", iDataEntityModel.getName(), "PSDELNPARAM", iDataEntityModel.getDataInfo(pSDataEntity), arrayList.get(0)));
        }
    }

    public void resetPSDE(PSDataEntity pSDataEntity) throws Exception {
        ArrayList<PSDELNParam> arrayList = this.selectByPSDE(pSDataEntity);
        for (PSDELNParam pSDELNParam : arrayList) {
            PSDELNParam pSDELNParam2 = (PSDELNParam)this.getDEModel().createEntity();
            pSDELNParam2.setPSDELNParamId(pSDELNParam.getPSDELNParamId());
            pSDELNParam2.setPSDEId(null);
            this.update(pSDELNParam2);
        }
    }

    public void removeByPSDE(PSDataEntity pSDataEntity) throws Exception {
        final PSDataEntity pSDataEntity2 = pSDataEntity;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDELNParamServiceBase.this.onBeforeRemoveByPSDE(pSDataEntity2);
                PSDELNParamServiceBase.this.internalRemoveByPSDE(pSDataEntity2);
                PSDELNParamServiceBase.this.onAfterRemoveByPSDE(pSDataEntity2);
            }
        });
    }

    protected void onBeforeRemoveByPSDE(PSDataEntity pSDataEntity) throws Exception {
    }

    protected void internalRemoveByPSDE(PSDataEntity pSDataEntity) throws Exception {
        ArrayList<PSDELNParam> arrayList = this.selectByPSDE(pSDataEntity);
        this.onBeforeRemoveByPSDE(pSDataEntity, arrayList);
        for (PSDELNParam pSDELNParam : arrayList) {
            this.remove(pSDELNParam);
        }
        this.onAfterRemoveByPSDE(pSDataEntity, arrayList);
    }

    protected void onAfterRemoveByPSDE(PSDataEntity pSDataEntity) throws Exception {
    }

    protected void onBeforeRemoveByPSDE(PSDataEntity pSDataEntity, ArrayList<PSDELNParam> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDE(PSDataEntity pSDataEntity, ArrayList<PSDELNParam> arrayList) throws Exception {
    }

    public void testRemoveByDstPSDEF(PSDEField pSDEField) throws Exception {
    }

    public void resetDstPSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSDELNParam> arrayList = this.selectByDstPSDEF(pSDEField);
        for (PSDELNParam pSDELNParam : arrayList) {
            PSDELNParam pSDELNParam2 = (PSDELNParam)this.getDEModel().createEntity();
            pSDELNParam2.setPSDELNParamId(pSDELNParam.getPSDELNParamId());
            pSDELNParam2.setDstPSDEFId(null);
            this.update(pSDELNParam2);
        }
    }

    public void removeByDstPSDEF(PSDEField pSDEField) throws Exception {
        final PSDEField pSDEField2 = pSDEField;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDELNParamServiceBase.this.onBeforeRemoveByDstPSDEF(pSDEField2);
                PSDELNParamServiceBase.this.internalRemoveByDstPSDEF(pSDEField2);
                PSDELNParamServiceBase.this.onAfterRemoveByDstPSDEF(pSDEField2);
            }
        });
    }

    protected void onBeforeRemoveByDstPSDEF(PSDEField pSDEField) throws Exception {
    }

    protected void internalRemoveByDstPSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSDELNParam> arrayList = this.selectByDstPSDEF(pSDEField);
        this.onBeforeRemoveByDstPSDEF(pSDEField, arrayList);
        for (PSDELNParam pSDELNParam : arrayList) {
            this.remove(pSDELNParam);
        }
        this.onAfterRemoveByDstPSDEF(pSDEField, arrayList);
    }

    protected void onAfterRemoveByDstPSDEF(PSDEField pSDEField) throws Exception {
    }

    protected void onBeforeRemoveByDstPSDEF(PSDEField pSDEField, ArrayList<PSDELNParam> arrayList) throws Exception {
    }

    protected void onAfterRemoveByDstPSDEF(PSDEField pSDEField, ArrayList<PSDELNParam> arrayList) throws Exception {
    }

    public void testRemoveBySrcPSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSDELNParam> arrayList = this.selectBySrcPSDEF(pSDEField, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEFIELD");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDEField);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDELNPARAM_PSDEFIELD_SRCPSDEFID", "", iDataEntityModel.getName(), "PSDELNPARAM", iDataEntityModel.getDataInfo(pSDEField), arrayList.get(0)));
        }
    }

    public void resetSrcPSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSDELNParam> arrayList = this.selectBySrcPSDEF(pSDEField);
        for (PSDELNParam pSDELNParam : arrayList) {
            PSDELNParam pSDELNParam2 = (PSDELNParam)this.getDEModel().createEntity();
            pSDELNParam2.setPSDELNParamId(pSDELNParam.getPSDELNParamId());
            pSDELNParam2.setSrcPSDEFId(null);
            this.update(pSDELNParam2);
        }
    }

    public void removeBySrcPSDEF(PSDEField pSDEField) throws Exception {
        final PSDEField pSDEField2 = pSDEField;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDELNParamServiceBase.this.onBeforeRemoveBySrcPSDEF(pSDEField2);
                PSDELNParamServiceBase.this.internalRemoveBySrcPSDEF(pSDEField2);
                PSDELNParamServiceBase.this.onAfterRemoveBySrcPSDEF(pSDEField2);
            }
        });
    }

    protected void onBeforeRemoveBySrcPSDEF(PSDEField pSDEField) throws Exception {
    }

    protected void internalRemoveBySrcPSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSDELNParam> arrayList = this.selectBySrcPSDEF(pSDEField);
        this.onBeforeRemoveBySrcPSDEF(pSDEField, arrayList);
        for (PSDELNParam pSDELNParam : arrayList) {
            this.remove(pSDELNParam);
        }
        this.onAfterRemoveBySrcPSDEF(pSDEField, arrayList);
    }

    protected void onAfterRemoveBySrcPSDEF(PSDEField pSDEField) throws Exception {
    }

    protected void onBeforeRemoveBySrcPSDEF(PSDEField pSDEField, ArrayList<PSDELNParam> arrayList) throws Exception {
    }

    protected void onAfterRemoveBySrcPSDEF(PSDEField pSDEField, ArrayList<PSDELNParam> arrayList) throws Exception {
    }

    public void testRemoveByPSDELogicNode(PSDELogicNode pSDELogicNode) throws Exception {
    }

    public void resetPSDELogicNode(PSDELogicNode pSDELogicNode) throws Exception {
        ArrayList<PSDELNParam> arrayList = this.selectByPSDELogicNode(pSDELogicNode);
        for (PSDELNParam pSDELNParam : arrayList) {
            PSDELNParam pSDELNParam2 = (PSDELNParam)this.getDEModel().createEntity();
            pSDELNParam2.setPSDELNParamId(pSDELNParam.getPSDELNParamId());
            pSDELNParam2.setPSDELogicNodeId(null);
            this.update(pSDELNParam2);
        }
    }

    public void resetTempPSDELogicNode(PSDELogicNode pSDELogicNode) throws Exception {
        ArrayList<PSDELNParam> arrayList = this.selectTempByPSDELogicNode(pSDELogicNode);
        for (PSDELNParam pSDELNParam : arrayList) {
            PSDELNParam pSDELNParam2 = (PSDELNParam)this.getDEModel().createEntity();
            pSDELNParam2.setPSDELNParamId(pSDELNParam.getPSDELNParamId());
            pSDELNParam2.setPSDELogicNodeId(null);
            this.updateTemp(pSDELNParam2);
        }
    }

    public void removeByPSDELogicNode(PSDELogicNode pSDELogicNode) throws Exception {
        final PSDELogicNode pSDELogicNode2 = pSDELogicNode;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDELNParamServiceBase.this.onBeforeRemoveByPSDELogicNode(pSDELogicNode2);
                PSDELNParamServiceBase.this.internalRemoveByPSDELogicNode(pSDELogicNode2);
                PSDELNParamServiceBase.this.onAfterRemoveByPSDELogicNode(pSDELogicNode2);
            }
        });
    }

    protected void onBeforeRemoveByPSDELogicNode(PSDELogicNode pSDELogicNode) throws Exception {
    }

    protected void internalRemoveByPSDELogicNode(PSDELogicNode pSDELogicNode) throws Exception {
        ArrayList<PSDELNParam> arrayList = this.selectByPSDELogicNode(pSDELogicNode);
        this.onBeforeRemoveByPSDELogicNode(pSDELogicNode, arrayList);
        for (PSDELNParam pSDELNParam : arrayList) {
            this.remove(pSDELNParam);
        }
        this.onAfterRemoveByPSDELogicNode(pSDELogicNode, arrayList);
    }

    protected void onAfterRemoveByPSDELogicNode(PSDELogicNode pSDELogicNode) throws Exception {
    }

    protected void onBeforeRemoveByPSDELogicNode(PSDELogicNode pSDELogicNode, ArrayList<PSDELNParam> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDELogicNode(PSDELogicNode pSDELogicNode, ArrayList<PSDELNParam> arrayList) throws Exception {
    }

    public void testRemoveByDstPSDLParam(PSDELogicParam pSDELogicParam) throws Exception {
    }

    public void resetDstPSDLParam(PSDELogicParam pSDELogicParam) throws Exception {
        ArrayList<PSDELNParam> arrayList = this.selectByDstPSDLParam(pSDELogicParam);
        for (PSDELNParam pSDELNParam : arrayList) {
            PSDELNParam pSDELNParam2 = (PSDELNParam)this.getDEModel().createEntity();
            pSDELNParam2.setPSDELNParamId(pSDELNParam.getPSDELNParamId());
            pSDELNParam2.setDstPSDLParamId(null);
            this.update(pSDELNParam2);
        }
    }

    public void resetTempDstPSDLParam(PSDELogicParam pSDELogicParam) throws Exception {
        ArrayList<PSDELNParam> arrayList = this.selectTempByDstPSDLParam(pSDELogicParam);
        for (PSDELNParam pSDELNParam : arrayList) {
            PSDELNParam pSDELNParam2 = (PSDELNParam)this.getDEModel().createEntity();
            pSDELNParam2.setPSDELNParamId(pSDELNParam.getPSDELNParamId());
            pSDELNParam2.setDstPSDLParamId(null);
            this.updateTemp(pSDELNParam2);
        }
    }

    public void removeByDstPSDLParam(PSDELogicParam pSDELogicParam) throws Exception {
        final PSDELogicParam pSDELogicParam2 = pSDELogicParam;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDELNParamServiceBase.this.onBeforeRemoveByDstPSDLParam(pSDELogicParam2);
                PSDELNParamServiceBase.this.internalRemoveByDstPSDLParam(pSDELogicParam2);
                PSDELNParamServiceBase.this.onAfterRemoveByDstPSDLParam(pSDELogicParam2);
            }
        });
    }

    protected void onBeforeRemoveByDstPSDLParam(PSDELogicParam pSDELogicParam) throws Exception {
    }

    protected void internalRemoveByDstPSDLParam(PSDELogicParam pSDELogicParam) throws Exception {
        ArrayList<PSDELNParam> arrayList = this.selectByDstPSDLParam(pSDELogicParam);
        this.onBeforeRemoveByDstPSDLParam(pSDELogicParam, arrayList);
        for (PSDELNParam pSDELNParam : arrayList) {
            this.remove(pSDELNParam);
        }
        this.onAfterRemoveByDstPSDLParam(pSDELogicParam, arrayList);
    }

    protected void onAfterRemoveByDstPSDLParam(PSDELogicParam pSDELogicParam) throws Exception {
    }

    protected void onBeforeRemoveByDstPSDLParam(PSDELogicParam pSDELogicParam, ArrayList<PSDELNParam> arrayList) throws Exception {
    }

    protected void onAfterRemoveByDstPSDLParam(PSDELogicParam pSDELogicParam, ArrayList<PSDELNParam> arrayList) throws Exception {
    }

    public void testRemoveBySrcPSDLParam(PSDELogicParam pSDELogicParam) throws Exception {
    }

    public void resetSrcPSDLParam(PSDELogicParam pSDELogicParam) throws Exception {
        ArrayList<PSDELNParam> arrayList = this.selectBySrcPSDLParam(pSDELogicParam);
        for (PSDELNParam pSDELNParam : arrayList) {
            PSDELNParam pSDELNParam2 = (PSDELNParam)this.getDEModel().createEntity();
            pSDELNParam2.setPSDELNParamId(pSDELNParam.getPSDELNParamId());
            pSDELNParam2.setSrcPSDLParamId(null);
            this.update(pSDELNParam2);
        }
    }

    public void resetTempSrcPSDLParam(PSDELogicParam pSDELogicParam) throws Exception {
        ArrayList<PSDELNParam> arrayList = this.selectTempBySrcPSDLParam(pSDELogicParam);
        for (PSDELNParam pSDELNParam : arrayList) {
            PSDELNParam pSDELNParam2 = (PSDELNParam)this.getDEModel().createEntity();
            pSDELNParam2.setPSDELNParamId(pSDELNParam.getPSDELNParamId());
            pSDELNParam2.setSrcPSDLParamId(null);
            this.updateTemp(pSDELNParam2);
        }
    }

    public void removeBySrcPSDLParam(PSDELogicParam pSDELogicParam) throws Exception {
        final PSDELogicParam pSDELogicParam2 = pSDELogicParam;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDELNParamServiceBase.this.onBeforeRemoveBySrcPSDLParam(pSDELogicParam2);
                PSDELNParamServiceBase.this.internalRemoveBySrcPSDLParam(pSDELogicParam2);
                PSDELNParamServiceBase.this.onAfterRemoveBySrcPSDLParam(pSDELogicParam2);
            }
        });
    }

    protected void onBeforeRemoveBySrcPSDLParam(PSDELogicParam pSDELogicParam) throws Exception {
    }

    protected void internalRemoveBySrcPSDLParam(PSDELogicParam pSDELogicParam) throws Exception {
        ArrayList<PSDELNParam> arrayList = this.selectBySrcPSDLParam(pSDELogicParam);
        this.onBeforeRemoveBySrcPSDLParam(pSDELogicParam, arrayList);
        for (PSDELNParam pSDELNParam : arrayList) {
            this.remove(pSDELNParam);
        }
        this.onAfterRemoveBySrcPSDLParam(pSDELogicParam, arrayList);
    }

    protected void onAfterRemoveBySrcPSDLParam(PSDELogicParam pSDELogicParam) throws Exception {
    }

    protected void onBeforeRemoveBySrcPSDLParam(PSDELogicParam pSDELogicParam, ArrayList<PSDELNParam> arrayList) throws Exception {
    }

    protected void onAfterRemoveBySrcPSDLParam(PSDELogicParam pSDELogicParam, ArrayList<PSDELNParam> arrayList) throws Exception {
    }

    public void testRemoveByPSSysMsgTempl(PSSysMsgTempl pSSysMsgTempl) throws Exception {
        ArrayList<PSDELNParam> arrayList = this.selectByPSSysMsgTempl(pSSysMsgTempl, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSMSGTEMPL");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSSysMsgTempl);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDELNPARAM_PSSYSMSGTEMPL_PSSYSMSGTEMPLID", "", iDataEntityModel.getName(), "PSDELNPARAM", iDataEntityModel.getDataInfo(pSSysMsgTempl), arrayList.get(0)));
        }
    }

    public void resetPSSysMsgTempl(PSSysMsgTempl pSSysMsgTempl) throws Exception {
        ArrayList<PSDELNParam> arrayList = this.selectByPSSysMsgTempl(pSSysMsgTempl);
        for (PSDELNParam pSDELNParam : arrayList) {
            PSDELNParam pSDELNParam2 = (PSDELNParam)this.getDEModel().createEntity();
            pSDELNParam2.setPSDELNParamId(pSDELNParam.getPSDELNParamId());
            pSDELNParam2.setPSSysMsgTemplId(null);
            this.update(pSDELNParam2);
        }
    }

    public void removeByPSSysMsgTempl(PSSysMsgTempl pSSysMsgTempl) throws Exception {
        final PSSysMsgTempl pSSysMsgTempl2 = pSSysMsgTempl;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDELNParamServiceBase.this.onBeforeRemoveByPSSysMsgTempl(pSSysMsgTempl2);
                PSDELNParamServiceBase.this.internalRemoveByPSSysMsgTempl(pSSysMsgTempl2);
                PSDELNParamServiceBase.this.onAfterRemoveByPSSysMsgTempl(pSSysMsgTempl2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysMsgTempl(PSSysMsgTempl pSSysMsgTempl) throws Exception {
    }

    protected void internalRemoveByPSSysMsgTempl(PSSysMsgTempl pSSysMsgTempl) throws Exception {
        ArrayList<PSDELNParam> arrayList = this.selectByPSSysMsgTempl(pSSysMsgTempl);
        this.onBeforeRemoveByPSSysMsgTempl(pSSysMsgTempl, arrayList);
        for (PSDELNParam pSDELNParam : arrayList) {
            this.remove(pSDELNParam);
        }
        this.onAfterRemoveByPSSysMsgTempl(pSSysMsgTempl, arrayList);
    }

    protected void onAfterRemoveByPSSysMsgTempl(PSSysMsgTempl pSSysMsgTempl) throws Exception {
    }

    protected void onBeforeRemoveByPSSysMsgTempl(PSSysMsgTempl pSSysMsgTempl, ArrayList<PSDELNParam> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysMsgTempl(PSSysMsgTempl pSSysMsgTempl, ArrayList<PSDELNParam> arrayList) throws Exception {
    }

    public void testRemoveByPSSysSequeue(PSSysSequence pSSysSequence) throws Exception {
        ArrayList<PSDELNParam> arrayList = this.selectByPSSysSequeue(pSSysSequence, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSSEQUENCE");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSSysSequence);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDELNPARAM_PSSYSSEQUENCE_PSSYSSEQUENCEID", "", iDataEntityModel.getName(), "PSDELNPARAM", iDataEntityModel.getDataInfo(pSSysSequence), arrayList.get(0)));
        }
    }

    public void resetPSSysSequeue(PSSysSequence pSSysSequence) throws Exception {
        ArrayList<PSDELNParam> arrayList = this.selectByPSSysSequeue(pSSysSequence);
        for (PSDELNParam pSDELNParam : arrayList) {
            PSDELNParam pSDELNParam2 = (PSDELNParam)this.getDEModel().createEntity();
            pSDELNParam2.setPSDELNParamId(pSDELNParam.getPSDELNParamId());
            pSDELNParam2.setPSSysSequenceId(null);
            this.update(pSDELNParam2);
        }
    }

    public void removeByPSSysSequeue(PSSysSequence pSSysSequence) throws Exception {
        final PSSysSequence pSSysSequence2 = pSSysSequence;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDELNParamServiceBase.this.onBeforeRemoveByPSSysSequeue(pSSysSequence2);
                PSDELNParamServiceBase.this.internalRemoveByPSSysSequeue(pSSysSequence2);
                PSDELNParamServiceBase.this.onAfterRemoveByPSSysSequeue(pSSysSequence2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysSequeue(PSSysSequence pSSysSequence) throws Exception {
    }

    protected void internalRemoveByPSSysSequeue(PSSysSequence pSSysSequence) throws Exception {
        ArrayList<PSDELNParam> arrayList = this.selectByPSSysSequeue(pSSysSequence);
        this.onBeforeRemoveByPSSysSequeue(pSSysSequence, arrayList);
        for (PSDELNParam pSDELNParam : arrayList) {
            this.remove(pSDELNParam);
        }
        this.onAfterRemoveByPSSysSequeue(pSSysSequence, arrayList);
    }

    protected void onAfterRemoveByPSSysSequeue(PSSysSequence pSSysSequence) throws Exception {
    }

    protected void onBeforeRemoveByPSSysSequeue(PSSysSequence pSSysSequence, ArrayList<PSDELNParam> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysSequeue(PSSysSequence pSSysSequence, ArrayList<PSDELNParam> arrayList) throws Exception {
    }

    public void testRemoveByPSSysTranslator(PSSysTranslator pSSysTranslator) throws Exception {
        ArrayList<PSDELNParam> arrayList = this.selectByPSSysTranslator(pSSysTranslator, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSTRANSLATOR");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSSysTranslator);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDELNPARAM_PSSYSTRANSLATOR_PSSYSTRANSLATORID", "", iDataEntityModel.getName(), "PSDELNPARAM", iDataEntityModel.getDataInfo(pSSysTranslator), arrayList.get(0)));
        }
    }

    public void resetPSSysTranslator(PSSysTranslator pSSysTranslator) throws Exception {
        ArrayList<PSDELNParam> arrayList = this.selectByPSSysTranslator(pSSysTranslator);
        for (PSDELNParam pSDELNParam : arrayList) {
            PSDELNParam pSDELNParam2 = (PSDELNParam)this.getDEModel().createEntity();
            pSDELNParam2.setPSDELNParamId(pSDELNParam.getPSDELNParamId());
            pSDELNParam2.setPSSysTranslatorId(null);
            this.update(pSDELNParam2);
        }
    }

    public void removeByPSSysTranslator(PSSysTranslator pSSysTranslator) throws Exception {
        final PSSysTranslator pSSysTranslator2 = pSSysTranslator;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDELNParamServiceBase.this.onBeforeRemoveByPSSysTranslator(pSSysTranslator2);
                PSDELNParamServiceBase.this.internalRemoveByPSSysTranslator(pSSysTranslator2);
                PSDELNParamServiceBase.this.onAfterRemoveByPSSysTranslator(pSSysTranslator2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysTranslator(PSSysTranslator pSSysTranslator) throws Exception {
    }

    protected void internalRemoveByPSSysTranslator(PSSysTranslator pSSysTranslator) throws Exception {
        ArrayList<PSDELNParam> arrayList = this.selectByPSSysTranslator(pSSysTranslator);
        this.onBeforeRemoveByPSSysTranslator(pSSysTranslator, arrayList);
        for (PSDELNParam pSDELNParam : arrayList) {
            this.remove(pSDELNParam);
        }
        this.onAfterRemoveByPSSysTranslator(pSSysTranslator, arrayList);
    }

    protected void onAfterRemoveByPSSysTranslator(PSSysTranslator pSSysTranslator) throws Exception {
    }

    protected void onBeforeRemoveByPSSysTranslator(PSSysTranslator pSSysTranslator, ArrayList<PSDELNParam> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysTranslator(PSSysTranslator pSSysTranslator, ArrayList<PSDELNParam> arrayList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(PSDELNParam pSDELNParam) throws Exception {
        super.onBeforeRemove(pSDELNParam);
    }

    public void removeTempByDstPSDLParam(PSDELogicParam pSDELogicParam) throws Exception {
        final PSDELogicParam pSDELogicParam2 = pSDELogicParam;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDELNParamServiceBase.this.onBeforeRemoveTempByDstPSDLParam(pSDELogicParam2);
                PSDELNParamServiceBase.this.internalRemoveTempByDstPSDLParam(pSDELogicParam2);
                PSDELNParamServiceBase.this.onAfterRemoveTempByDstPSDLParam(pSDELogicParam2);
            }
        });
    }

    protected void onBeforeRemoveTempByDstPSDLParam(PSDELogicParam pSDELogicParam) throws Exception {
    }

    protected void internalRemoveTempByDstPSDLParam(PSDELogicParam pSDELogicParam) throws Exception {
        ArrayList<PSDELNParam> arrayList = this.selectTempByDstPSDLParam(pSDELogicParam);
        this.onBeforeRemoveTempByDstPSDLParam(pSDELogicParam, arrayList);
        for (PSDELNParam pSDELNParam : arrayList) {
            this.removeTemp(pSDELNParam);
        }
        this.onAfterRemoveTempByDstPSDLParam(pSDELogicParam, arrayList);
    }

    protected void onAfterRemoveTempByDstPSDLParam(PSDELogicParam pSDELogicParam) throws Exception {
    }

    protected void onBeforeRemoveTempByDstPSDLParam(PSDELogicParam pSDELogicParam, ArrayList<PSDELNParam> arrayList) throws Exception {
    }

    protected void onAfterRemoveTempByDstPSDLParam(PSDELogicParam pSDELogicParam, ArrayList<PSDELNParam> arrayList) throws Exception {
    }

    public void removeTempBySrcPSDLParam(PSDELogicParam pSDELogicParam) throws Exception {
        final PSDELogicParam pSDELogicParam2 = pSDELogicParam;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDELNParamServiceBase.this.onBeforeRemoveTempBySrcPSDLParam(pSDELogicParam2);
                PSDELNParamServiceBase.this.internalRemoveTempBySrcPSDLParam(pSDELogicParam2);
                PSDELNParamServiceBase.this.onAfterRemoveTempBySrcPSDLParam(pSDELogicParam2);
            }
        });
    }

    protected void onBeforeRemoveTempBySrcPSDLParam(PSDELogicParam pSDELogicParam) throws Exception {
    }

    protected void internalRemoveTempBySrcPSDLParam(PSDELogicParam pSDELogicParam) throws Exception {
        ArrayList<PSDELNParam> arrayList = this.selectTempBySrcPSDLParam(pSDELogicParam);
        this.onBeforeRemoveTempBySrcPSDLParam(pSDELogicParam, arrayList);
        for (PSDELNParam pSDELNParam : arrayList) {
            this.removeTemp(pSDELNParam);
        }
        this.onAfterRemoveTempBySrcPSDLParam(pSDELogicParam, arrayList);
    }

    protected void onAfterRemoveTempBySrcPSDLParam(PSDELogicParam pSDELogicParam) throws Exception {
    }

    protected void onBeforeRemoveTempBySrcPSDLParam(PSDELogicParam pSDELogicParam, ArrayList<PSDELNParam> arrayList) throws Exception {
    }

    protected void onAfterRemoveTempBySrcPSDLParam(PSDELogicParam pSDELogicParam, ArrayList<PSDELNParam> arrayList) throws Exception {
    }

    public void removeTempByPSDELogicNode(PSDELogicNode pSDELogicNode) throws Exception {
        final PSDELogicNode pSDELogicNode2 = pSDELogicNode;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDELNParamServiceBase.this.onBeforeRemoveTempByPSDELogicNode(pSDELogicNode2);
                PSDELNParamServiceBase.this.internalRemoveTempByPSDELogicNode(pSDELogicNode2);
                PSDELNParamServiceBase.this.onAfterRemoveTempByPSDELogicNode(pSDELogicNode2);
            }
        });
    }

    protected void onBeforeRemoveTempByPSDELogicNode(PSDELogicNode pSDELogicNode) throws Exception {
    }

    protected void internalRemoveTempByPSDELogicNode(PSDELogicNode pSDELogicNode) throws Exception {
        ArrayList<PSDELNParam> arrayList = this.selectTempByPSDELogicNode(pSDELogicNode);
        this.onBeforeRemoveTempByPSDELogicNode(pSDELogicNode, arrayList);
        for (PSDELNParam pSDELNParam : arrayList) {
            this.removeTemp(pSDELNParam);
        }
        this.onAfterRemoveTempByPSDELogicNode(pSDELogicNode, arrayList);
    }

    protected void onAfterRemoveTempByPSDELogicNode(PSDELogicNode pSDELogicNode) throws Exception {
    }

    protected void onBeforeRemoveTempByPSDELogicNode(PSDELogicNode pSDELogicNode, ArrayList<PSDELNParam> arrayList) throws Exception {
    }

    protected void onAfterRemoveTempByPSDELogicNode(PSDELogicNode pSDELogicNode, ArrayList<PSDELNParam> arrayList) throws Exception {
    }

    protected void replaceParentInfo(PSDELNParam pSDELNParam, CloneSession cloneSession) throws Exception {
        IEntity iEntity;
        super.replaceParentInfo(pSDELNParam, cloneSession);
        if (pSDELNParam.getPSDEId() != null && (iEntity = cloneSession.getEntity("PSDATAENTITY", (Object)pSDELNParam.getPSDEId())) != null) {
            this.onFillParentInfo_PSDE(pSDELNParam, (PSDataEntity)iEntity);
        }
        if (pSDELNParam.getDstPSDEFId() != null && (iEntity = cloneSession.getEntity("PSDEFIELD", (Object)pSDELNParam.getDstPSDEFId())) != null) {
            this.onFillParentInfo_DstPSDEF(pSDELNParam, (PSDEField)iEntity);
        }
        if (pSDELNParam.getSrcPSDEFId() != null && (iEntity = cloneSession.getEntity("PSDEFIELD", (Object)pSDELNParam.getSrcPSDEFId())) != null) {
            this.onFillParentInfo_SrcPSDEF(pSDELNParam, (PSDEField)iEntity);
        }
        if (pSDELNParam.getPSDELogicNodeId() != null && (iEntity = cloneSession.getEntity("PSDELOGICNODE", (Object)pSDELNParam.getPSDELogicNodeId())) != null) {
            this.onFillParentInfo_PSDELogicNode(pSDELNParam, (PSDELogicNode)iEntity);
        }
        if (pSDELNParam.getDstPSDLParamId() != null && (iEntity = cloneSession.getEntity("PSDELOGICPARAM", (Object)pSDELNParam.getDstPSDLParamId())) != null) {
            this.onFillParentInfo_DstPSDLParam(pSDELNParam, (PSDELogicParam)iEntity);
        }
        if (pSDELNParam.getSrcPSDLParamId() != null && (iEntity = cloneSession.getEntity("PSDELOGICPARAM", (Object)pSDELNParam.getSrcPSDLParamId())) != null) {
            this.onFillParentInfo_SrcPSDLParam(pSDELNParam, (PSDELogicParam)iEntity);
        }
        if (pSDELNParam.getPSSysMsgTemplId() != null && (iEntity = cloneSession.getEntity("PSSYSMSGTEMPL", (Object)pSDELNParam.getPSSysMsgTemplId())) != null) {
            this.onFillParentInfo_PSSysMsgTempl(pSDELNParam, (PSSysMsgTempl)iEntity);
        }
        if (pSDELNParam.getPSSysSequenceId() != null && (iEntity = cloneSession.getEntity("PSSYSSEQUENCE", (Object)pSDELNParam.getPSSysSequenceId())) != null) {
            this.onFillParentInfo_PSSysSequeue(pSDELNParam, (PSSysSequence)iEntity);
        }
        if (pSDELNParam.getPSSysTranslatorId() != null && (iEntity = cloneSession.getEntity("PSSYSTRANSLATOR", (Object)pSDELNParam.getPSSysTranslatorId())) != null) {
            this.onFillParentInfo_PSSysTranslator(pSDELNParam, (PSSysTranslator)iEntity);
        }
    }

    protected void onRemoveEntityUncopyValues(PSDELNParam pSDELNParam, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues(pSDELNParam, bl);
    }

    protected void onCheckEntity(boolean bl, PSDELNParam pSDELNParam, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_AggMode(bl, pSDELNParam, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_CustomDstParam(bl, pSDELNParam, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_CustomSrcParam(bl, pSDELNParam, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_DefaultValue(bl, pSDELNParam, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_DirectCode(bl, pSDELNParam, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_DstIndex(bl, pSDELNParam, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_DstPSDEFId(bl, pSDELNParam, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_DstPSDEFName(bl, pSDELNParam, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_DstPSDLParamId(bl, pSDELNParam, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_DstPSDLParamName(bl, pSDELNParam, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_DstSortDir(bl, pSDELNParam, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_DynaModelFlag(bl, pSDELNParam, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_InOutFlag(bl, pSDELNParam, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Memo(bl, pSDELNParam, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_OrderValue(bl, pSDELNParam, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Params(bl, pSDELNParam, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ParamTag(bl, pSDELNParam, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ParamTag2(bl, pSDELNParam, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ParamType(bl, pSDELNParam, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ParamTypeText(bl, pSDELNParam, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEId(bl, pSDELNParam, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDELNParamId(bl, pSDELNParam, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDELNParamName(bl, pSDELNParam, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDELogicId(bl, pSDELNParam, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDELogicNodeId(bl, pSDELNParam, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDELogicNodeName(bl, pSDELNParam, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEName(bl, pSDELNParam, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDynaInstId(bl, pSDELNParam, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSObjData(bl, pSDELNParam, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSObjData2(bl, pSDELNParam, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSObjId(bl, pSDELNParam, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSObjName(bl, pSDELNParam, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSObjType(bl, pSDELNParam, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSObjTypeName(bl, pSDELNParam, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysMsgTemplId(bl, pSDELNParam, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysSequenceId(bl, pSDELNParam, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysTranslatorId(bl, pSDELNParam, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_SrcIndex(bl, pSDELNParam, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_SrcPSDEFId(bl, pSDELNParam, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_SrcPSDEFName(bl, pSDELNParam, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_SrcPSDLParamId(bl, pSDELNParam, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_SrcPSDLParamName(bl, pSDELNParam, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_SrcSize(bl, pSDELNParam, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_SrcValue(bl, pSDELNParam, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_SrcValueStdDataType(bl, pSDELNParam, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_SrcValueType(bl, pSDELNParam, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_SrcValueTypeText(bl, pSDELNParam, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserCat(bl, pSDELNParam, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag(bl, pSDELNParam, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag2(bl, pSDELNParam, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag3(bl, pSDELNParam, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag4(bl, pSDELNParam, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, pSDELNParam, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_AggMode(boolean bl, PSDELNParam pSDELNParam, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDELNParam.isAggModeDirty() : !pSDELNParam.isAggModeDirty()) {
            return null;
        }
        String string = pSDELNParam.getAggMode();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_AggMode_Default(pSDELNParam, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("AGGMODE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_CustomDstParam(boolean bl, PSDELNParam pSDELNParam, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDELNParam.isCustomDstParamDirty() : !pSDELNParam.isCustomDstParamDirty()) {
            return null;
        }
        String string = pSDELNParam.getCustomDstParam();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_CustomDstParam_Default(pSDELNParam, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CUSTOMDSTPARAM");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_CustomSrcParam(boolean bl, PSDELNParam pSDELNParam, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDELNParam.isCustomSrcParamDirty() : !pSDELNParam.isCustomSrcParamDirty()) {
            return null;
        }
        String string = pSDELNParam.getCustomSrcParam();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_CustomSrcParam_Default(pSDELNParam, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CUSTOMSRCPARAM");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_DefaultValue(boolean bl, PSDELNParam pSDELNParam, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDELNParam.isDefaultValueDirty() : !pSDELNParam.isDefaultValueDirty()) {
            return null;
        }
        String string = pSDELNParam.getDefaultValue();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_DefaultValue_Default(pSDELNParam, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DEFAULTVALUE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_DirectCode(boolean bl, PSDELNParam pSDELNParam, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDELNParam.isDirectCodeDirty() : !pSDELNParam.isDirectCodeDirty()) {
            return null;
        }
        String string = pSDELNParam.getDirectCode();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_DirectCode_Default(pSDELNParam, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DIRECTCODE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_DstIndex(boolean bl, PSDELNParam pSDELNParam, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDELNParam.isDstIndexDirty() : !pSDELNParam.isDstIndexDirty()) {
            return null;
        }
        Integer n = pSDELNParam.getDstIndex();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_DstIndex_Default(pSDELNParam, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DSTINDEX");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_DstPSDEFId(boolean bl, PSDELNParam pSDELNParam, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDELNParam.isDstPSDEFIdDirty() : !pSDELNParam.isDstPSDEFIdDirty()) {
            return null;
        }
        String string = pSDELNParam.getDstPSDEFId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_DstPSDEFId_Default(pSDELNParam, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DSTPSDEFID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_DstPSDEFName(boolean bl, PSDELNParam pSDELNParam, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDELNParam.isDstPSDEFNameDirty() : !pSDELNParam.isDstPSDEFNameDirty()) {
            return null;
        }
        String string = pSDELNParam.getDstPSDEFName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_DstPSDEFName_Default(pSDELNParam, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DSTPSDEFNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_DstPSDLParamId(boolean bl, PSDELNParam pSDELNParam, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDELNParam.isDstPSDLParamIdDirty() : !pSDELNParam.isDstPSDLParamIdDirty()) {
            return null;
        }
        String string = pSDELNParam.getDstPSDLParamId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_DstPSDLParamId_Default(pSDELNParam, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DSTPSDLPARAMID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_DstPSDLParamName(boolean bl, PSDELNParam pSDELNParam, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDELNParam.isDstPSDLParamNameDirty() : !pSDELNParam.isDstPSDLParamNameDirty()) {
            return null;
        }
        String string = pSDELNParam.getDstPSDLParamName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_DstPSDLParamName_Default(pSDELNParam, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DSTPSDLPARAMNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_DstSortDir(boolean bl, PSDELNParam pSDELNParam, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDELNParam.isDstSortDirDirty() : !pSDELNParam.isDstSortDirDirty()) {
            return null;
        }
        String string = pSDELNParam.getDstSortDir();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_DstSortDir_Default(pSDELNParam, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DSTSORTDIR");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_DynaModelFlag(boolean bl, PSDELNParam pSDELNParam, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDELNParam.isDynaModelFlagDirty() : !pSDELNParam.isDynaModelFlagDirty()) {
            return null;
        }
        Integer n = pSDELNParam.getDynaModelFlag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_DynaModelFlag_Default(pSDELNParam, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DYNAMODELFLAG");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_InOutFlag(boolean bl, PSDELNParam pSDELNParam, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDELNParam.isInOutFlagDirty() : !pSDELNParam.isInOutFlagDirty()) {
            return null;
        }
        Integer n = pSDELNParam.getInOutFlag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_InOutFlag_Default(pSDELNParam, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("INOUTFLAG");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Memo(boolean bl, PSDELNParam pSDELNParam, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDELNParam.isMemoDirty() : !pSDELNParam.isMemoDirty()) {
            return null;
        }
        String string = pSDELNParam.getMemo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Memo_Default(pSDELNParam, bl2, bl3);
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

    protected EntityFieldError onCheckField_OrderValue(boolean bl, PSDELNParam pSDELNParam, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDELNParam.isOrderValueDirty() && !bl2 : !pSDELNParam.isOrderValueDirty()) {
            return null;
        }
        Integer n = pSDELNParam.getOrderValue();
        if (bl) {
            if (bl2 && n == null) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ORDERVALUE");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string = null;
            string = this.onTestValueRule_OrderValue_Default(pSDELNParam, bl2, bl3);
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

    protected EntityFieldError onCheckField_Params(boolean bl, PSDELNParam pSDELNParam, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDELNParam.isParamsDirty() : !pSDELNParam.isParamsDirty()) {
            return null;
        }
        String string = pSDELNParam.getParams();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Params_Default(pSDELNParam, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PARAMS");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ParamTag(boolean bl, PSDELNParam pSDELNParam, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDELNParam.isParamTagDirty() : !pSDELNParam.isParamTagDirty()) {
            return null;
        }
        String string = pSDELNParam.getParamTag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_ParamTag_Default(pSDELNParam, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PARAMTAG");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ParamTag2(boolean bl, PSDELNParam pSDELNParam, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDELNParam.isParamTag2Dirty() : !pSDELNParam.isParamTag2Dirty()) {
            return null;
        }
        String string = pSDELNParam.getParamTag2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_ParamTag2_Default(pSDELNParam, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PARAMTAG2");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ParamType(boolean bl, PSDELNParam pSDELNParam, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDELNParam.isParamTypeDirty() && !bl2 : !pSDELNParam.isParamTypeDirty()) {
            return null;
        }
        String string = pSDELNParam.getParamType();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PARAMTYPE");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_ParamType_Default(pSDELNParam, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PARAMTYPE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ParamTypeText(boolean bl, PSDELNParam pSDELNParam, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDELNParam.isParamTypeTextDirty() : !pSDELNParam.isParamTypeTextDirty()) {
            return null;
        }
        String string = pSDELNParam.getParamTypeText();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_ParamTypeText_Default(pSDELNParam, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PARAMTYPETEXT");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDEId(boolean bl, PSDELNParam pSDELNParam, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDELNParam.isPSDEIdDirty() : !pSDELNParam.isPSDEIdDirty()) {
            return null;
        }
        String string = pSDELNParam.getPSDEId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEId_Default(pSDELNParam, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDELNParamId(boolean bl, PSDELNParam pSDELNParam, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDELNParam.isPSDELNParamIdDirty() && !bl2 : !pSDELNParam.isPSDELNParamIdDirty()) {
            return null;
        }
        String string = pSDELNParam.getPSDELNParamId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDELNPARAMID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDELNParamId_Default(pSDELNParam, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDELNPARAMID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDELNParamName(boolean bl, PSDELNParam pSDELNParam, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDELNParam.isPSDELNParamNameDirty() : !pSDELNParam.isPSDELNParamNameDirty()) {
            return null;
        }
        String string = pSDELNParam.getPSDELNParamName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDELNParamName_Default(pSDELNParam, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDELNPARAMNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDELogicId(boolean bl, PSDELNParam pSDELNParam, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDELNParam.isPSDELogicIdDirty() : !pSDELNParam.isPSDELogicIdDirty()) {
            return null;
        }
        String string = pSDELNParam.getPSDELogicId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDELogicId_Default(pSDELNParam, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDELogicNodeId(boolean bl, PSDELNParam pSDELNParam, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDELNParam.isPSDELogicNodeIdDirty() : !pSDELNParam.isPSDELogicNodeIdDirty()) {
            return null;
        }
        String string = pSDELNParam.getPSDELogicNodeId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDELogicNodeId_Default(pSDELNParam, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDELogicNodeName(boolean bl, PSDELNParam pSDELNParam, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDELNParam.isPSDELogicNodeNameDirty() : !pSDELNParam.isPSDELogicNodeNameDirty()) {
            return null;
        }
        String string = pSDELNParam.getPSDELogicNodeName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDELogicNodeName_Default(pSDELNParam, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDEName(boolean bl, PSDELNParam pSDELNParam, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDELNParam.isPSDENameDirty() : !pSDELNParam.isPSDENameDirty()) {
            return null;
        }
        String string = pSDELNParam.getPSDEName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEName_Default(pSDELNParam, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDENAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDynaInstId(boolean bl, PSDELNParam pSDELNParam, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDELNParam.isPSDynaInstIdDirty() : !pSDELNParam.isPSDynaInstIdDirty()) {
            return null;
        }
        String string = pSDELNParam.getPSDynaInstId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDynaInstId_Default(pSDELNParam, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDYNAINSTID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSObjData(boolean bl, PSDELNParam pSDELNParam, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDELNParam.isPSObjDataDirty() : !pSDELNParam.isPSObjDataDirty()) {
            return null;
        }
        String string = pSDELNParam.getPSObjData();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSObjData_Default(pSDELNParam, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSOBJDATA");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSObjData2(boolean bl, PSDELNParam pSDELNParam, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDELNParam.isPSObjData2Dirty() : !pSDELNParam.isPSObjData2Dirty()) {
            return null;
        }
        String string = pSDELNParam.getPSObjData2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSObjData2_Default(pSDELNParam, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSOBJDATA2");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSObjId(boolean bl, PSDELNParam pSDELNParam, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDELNParam.isPSObjIdDirty() : !pSDELNParam.isPSObjIdDirty()) {
            return null;
        }
        String string = pSDELNParam.getPSObjId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSObjId_Default(pSDELNParam, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSOBJID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSObjName(boolean bl, PSDELNParam pSDELNParam, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDELNParam.isPSObjNameDirty() : !pSDELNParam.isPSObjNameDirty()) {
            return null;
        }
        String string = pSDELNParam.getPSObjName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSObjName_Default(pSDELNParam, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSOBJNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSObjType(boolean bl, PSDELNParam pSDELNParam, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDELNParam.isPSObjTypeDirty() : !pSDELNParam.isPSObjTypeDirty()) {
            return null;
        }
        String string = pSDELNParam.getPSObjType();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSObjType_Default(pSDELNParam, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSOBJTYPE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSObjTypeName(boolean bl, PSDELNParam pSDELNParam, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDELNParam.isPSObjTypeNameDirty() : !pSDELNParam.isPSObjTypeNameDirty()) {
            return null;
        }
        String string = pSDELNParam.getPSObjTypeName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSObjTypeName_Default(pSDELNParam, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSOBJTYPENAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSysMsgTemplId(boolean bl, PSDELNParam pSDELNParam, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDELNParam.isPSSysMsgTemplIdDirty() : !pSDELNParam.isPSSysMsgTemplIdDirty()) {
            return null;
        }
        String string = pSDELNParam.getPSSysMsgTemplId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysMsgTemplId_Default(pSDELNParam, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSMSGTEMPLID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSysSequenceId(boolean bl, PSDELNParam pSDELNParam, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDELNParam.isPSSysSequenceIdDirty() : !pSDELNParam.isPSSysSequenceIdDirty()) {
            return null;
        }
        String string = pSDELNParam.getPSSysSequenceId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysSequenceId_Default(pSDELNParam, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSSEQUENCEID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSysTranslatorId(boolean bl, PSDELNParam pSDELNParam, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDELNParam.isPSSysTranslatorIdDirty() : !pSDELNParam.isPSSysTranslatorIdDirty()) {
            return null;
        }
        String string = pSDELNParam.getPSSysTranslatorId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysTranslatorId_Default(pSDELNParam, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSTRANSLATORID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_SrcIndex(boolean bl, PSDELNParam pSDELNParam, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDELNParam.isSrcIndexDirty() : !pSDELNParam.isSrcIndexDirty()) {
            return null;
        }
        Integer n = pSDELNParam.getSrcIndex();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_SrcIndex_Default(pSDELNParam, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("SRCINDEX");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_SrcPSDEFId(boolean bl, PSDELNParam pSDELNParam, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDELNParam.isSrcPSDEFIdDirty() : !pSDELNParam.isSrcPSDEFIdDirty()) {
            return null;
        }
        String string = pSDELNParam.getSrcPSDEFId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_SrcPSDEFId_Default(pSDELNParam, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("SRCPSDEFID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_SrcPSDEFName(boolean bl, PSDELNParam pSDELNParam, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDELNParam.isSrcPSDEFNameDirty() : !pSDELNParam.isSrcPSDEFNameDirty()) {
            return null;
        }
        String string = pSDELNParam.getSrcPSDEFName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_SrcPSDEFName_Default(pSDELNParam, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("SRCPSDEFNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_SrcPSDLParamId(boolean bl, PSDELNParam pSDELNParam, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDELNParam.isSrcPSDLParamIdDirty() : !pSDELNParam.isSrcPSDLParamIdDirty()) {
            return null;
        }
        String string = pSDELNParam.getSrcPSDLParamId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_SrcPSDLParamId_Default(pSDELNParam, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("SRCPSDLPARAMID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_SrcPSDLParamName(boolean bl, PSDELNParam pSDELNParam, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDELNParam.isSrcPSDLParamNameDirty() : !pSDELNParam.isSrcPSDLParamNameDirty()) {
            return null;
        }
        String string = pSDELNParam.getSrcPSDLParamName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_SrcPSDLParamName_Default(pSDELNParam, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("SRCPSDLPARAMNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_SrcSize(boolean bl, PSDELNParam pSDELNParam, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDELNParam.isSrcSizeDirty() : !pSDELNParam.isSrcSizeDirty()) {
            return null;
        }
        Integer n = pSDELNParam.getSrcSize();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_SrcSize_Default(pSDELNParam, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("SRCSIZE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_SrcValue(boolean bl, PSDELNParam pSDELNParam, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDELNParam.isSrcValueDirty() : !pSDELNParam.isSrcValueDirty()) {
            return null;
        }
        String string = pSDELNParam.getSrcValue();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_SrcValue_Default(pSDELNParam, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("SRCVALUE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_SrcValueStdDataType(boolean bl, PSDELNParam pSDELNParam, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDELNParam.isSrcValueStdDataTypeDirty() : !pSDELNParam.isSrcValueStdDataTypeDirty()) {
            return null;
        }
        Integer n = pSDELNParam.getSrcValueStdDataType();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_SrcValueStdDataType_Default(pSDELNParam, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("SRCVALUESTDDATATYPE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_SrcValueType(boolean bl, PSDELNParam pSDELNParam, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDELNParam.isSrcValueTypeDirty() : !pSDELNParam.isSrcValueTypeDirty()) {
            return null;
        }
        String string = pSDELNParam.getSrcValueType();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_SrcValueType_Default(pSDELNParam, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("SRCVALUETYPE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_SrcValueTypeText(boolean bl, PSDELNParam pSDELNParam, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDELNParam.isSrcValueTypeTextDirty() : !pSDELNParam.isSrcValueTypeTextDirty()) {
            return null;
        }
        String string = pSDELNParam.getSrcValueTypeText();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_SrcValueTypeText_Default(pSDELNParam, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("SRCVALUETYPETEXT");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_UserCat(boolean bl, PSDELNParam pSDELNParam, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDELNParam.isUserCatDirty() : !pSDELNParam.isUserCatDirty()) {
            return null;
        }
        String string = pSDELNParam.getUserCat();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserCat_Default(pSDELNParam, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("USERCAT");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_UserTag(boolean bl, PSDELNParam pSDELNParam, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDELNParam.isUserTagDirty() : !pSDELNParam.isUserTagDirty()) {
            return null;
        }
        String string = pSDELNParam.getUserTag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag_Default(pSDELNParam, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag2(boolean bl, PSDELNParam pSDELNParam, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDELNParam.isUserTag2Dirty() : !pSDELNParam.isUserTag2Dirty()) {
            return null;
        }
        String string = pSDELNParam.getUserTag2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag2_Default(pSDELNParam, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag3(boolean bl, PSDELNParam pSDELNParam, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDELNParam.isUserTag3Dirty() : !pSDELNParam.isUserTag3Dirty()) {
            return null;
        }
        String string = pSDELNParam.getUserTag3();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag3_Default(pSDELNParam, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("USERTAG3");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_UserTag4(boolean bl, PSDELNParam pSDELNParam, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDELNParam.isUserTag4Dirty() : !pSDELNParam.isUserTag4Dirty()) {
            return null;
        }
        String string = pSDELNParam.getUserTag4();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag4_Default(pSDELNParam, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("USERTAG4");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected void onSyncEntity(PSDELNParam pSDELNParam, boolean bl) throws Exception {
        super.onSyncEntity(pSDELNParam, bl);
    }

    protected void onSyncIndexEntities(PSDELNParam pSDELNParam, boolean bl) throws Exception {
        super.onSyncIndexEntities(pSDELNParam, bl);
    }

    public Object getDataContextValue(PSDELNParam pSDELNParam, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null) {
            if (StringHelper.compare((String)iDataContextParam.getDEName(), (String)"PSDEFIELD", (boolean)true) == 0 && StringHelper.compare((String)iDataContextParam.getDEFName(), (String)"PSDEID", (boolean)true) == 0 && (StringHelper.isNullOrEmpty((String)iDataContextParam.getReferItem()) || StringHelper.compare((String)iDataContextParam.getReferItem(), (String)"DSTPSDEFID", (boolean)true) == 0 || StringHelper.compare((String)iDataContextParam.getReferItem(), (String)"DSTPSDEFNAME", (boolean)true) == 0) && (object = super.getDataContextValue(pSDELNParam, "dstparampsdeid", iDataContextParam)) != null) {
                return object;
            }
            if (StringHelper.compare((String)iDataContextParam.getDEName(), (String)"PSDEFIELD", (boolean)true) == 0 && StringHelper.compare((String)iDataContextParam.getDEFName(), (String)"PSDEID", (boolean)true) == 0 && (StringHelper.isNullOrEmpty((String)iDataContextParam.getReferItem()) || StringHelper.compare((String)iDataContextParam.getReferItem(), (String)"SRCPSDEFID", (boolean)true) == 0 || StringHelper.compare((String)iDataContextParam.getReferItem(), (String)"SRCPSDEFNAME", (boolean)true) == 0) && (object = super.getDataContextValue(pSDELNParam, "srcparampsdeid", iDataContextParam)) != null) {
                return object;
            }
        }
        if ((object = super.getDataContextValue(pSDELNParam, string, iDataContextParam)) != null) {
            return object;
        }
        PSDELogicNode pSDELogicNode = pSDELNParam.getPSDELogicNode();
        if (pSDELogicNode != null && pSDELogicNode.contains(string)) {
            return pSDELogicNode.get(string);
        }
        return null;
    }

    protected void onExportMajorModel(PSDELNParam pSDELNParam, ArrayList<JSONObject> arrayList, int n) throws Exception {
        super.onExportMajorModel(pSDELNParam, arrayList, n);
    }

    protected String onTestValueRule(String string, String string2, IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        if (StringHelper.compare((String)string, (String)"AGGMODE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_AggMode_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATEDATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateDate_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATEMAN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateMan_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CUSTOMDSTPARAM", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CustomDstParam_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CUSTOMSRCPARAM", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CustomSrcParam_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DEFAULTVALUE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DefaultValue_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DIRECTCODE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DirectCode_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DSTINDEX", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DstIndex_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DSTPARAMPSDEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DstParamPSDEId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DSTPSDEFID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DstPSDEFId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DSTPSDEFNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DstPSDEFName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DSTPSDLPARAMID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DstPSDLParamId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DSTPSDLPARAMNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DstPSDLParamName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DSTSORTDIR", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DstSortDir_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DYNAMODELFLAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DynaModelFlag_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"INOUTFLAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_InOutFlag_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MEMO", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Memo_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ORDERVALUE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_OrderValue_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PARAMS", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Params_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PARAMTAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ParamTag_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PARAMTAG2", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ParamTag2_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PARAMTYPE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ParamType_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PARAMTYPETEXT", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ParamTypeText_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDELNPARAMID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDELNParamId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDELNPARAMNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDELNParamName_Default(iEntity, bl, bl2);
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
        if (StringHelper.compare((String)string, (String)"PSDENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDYNAINSTID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDynaInstId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSOBJDATA", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSObjData_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSOBJDATA2", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSObjData2_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSOBJID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSObjId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSOBJNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSObjName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSOBJTYPE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSObjType_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSOBJTYPENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSObjTypeName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSMSGTEMPLID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysMsgTemplId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSMSGTEMPLNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysMsgTemplName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSSEQUENCEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysSequenceId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSSEQUENCENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysSequenceName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSTRANSLATORID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysTranslatorId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSTRANSLATORNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysTranslatorName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"SRCINDEX", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_SrcIndex_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"SRCPARAMPSDEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_SrcParamPSDEId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"SRCPSDEFID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_SrcPSDEFId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"SRCPSDEFNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_SrcPSDEFName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"SRCPSDLPARAMID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_SrcPSDLParamId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"SRCPSDLPARAMNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_SrcPSDLParamName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"SRCSIZE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_SrcSize_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"SRCVALUE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_SrcValue_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"SRCVALUESTDDATATYPE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_SrcValueStdDataType_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"SRCVALUETYPE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_SrcValueType_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"SRCVALUETYPETEXT", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_SrcValueTypeText_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UPDATEDATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UpdateDate_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UPDATEMAN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UpdateMan_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"USERCAT", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UserCat_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"USERTAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UserTag_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"USERTAG2", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UserTag2_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"USERTAG3", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UserTag3_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"USERTAG4", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UserTag4_Default(iEntity, bl, bl2);
        }
        return super.onTestValueRule(string, string2, iEntity, bl, bl2);
    }

    protected String onTestValueRule_AggMode_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("AGGMODE", iEntity, bl2, null, false, 20, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[20]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[20]";
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

    protected String onTestValueRule_CustomDstParam_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("CUSTOMDSTPARAM", iEntity, bl2, null, false, 60, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_CustomSrcParam_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("CUSTOMSRCPARAM", iEntity, bl2, null, false, 60, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_DefaultValue_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("DEFAULTVALUE", iEntity, bl2, null, false, 2000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[2000]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[2000]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_DirectCode_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("DIRECTCODE", iEntity, bl2, null, false, 0x100000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_DstIndex_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_DstParamPSDEId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("DSTPARAMPSDEID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_DstPSDEFId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("DSTPSDEFID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_DstPSDEFName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("DSTPSDEFNAME", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_DstPSDLParamId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("DSTPSDLPARAMID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_DstPSDLParamName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("DSTPSDLPARAMNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_DstSortDir_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("DSTSORTDIR", iEntity, bl2, null, false, 10, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[10]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[10]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_DynaModelFlag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_InOutFlag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_Memo_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("MEMO", iEntity, bl2, null, false, 2000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[2000]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[2000]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_OrderValue_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_Params_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PARAMS", iEntity, bl2, null, false, 0x100000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_ParamTag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PARAMTAG", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_ParamTag2_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PARAMTAG2", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_ParamType_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PARAMTYPE", iEntity, bl2, null, false, 40, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[40]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[40]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_ParamTypeText_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PARAMTYPETEXT", iEntity, bl2, null, false, 50, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDEId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDELNParamId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDELNPARAMID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDELNParamName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDELNPARAMNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
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

    protected String onTestValueRule_PSDEName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDENAME", iEntity, bl2, null, false, 60, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDynaInstId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDYNAINSTID", iEntity, bl2, null, false, 60, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSObjData_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSOBJDATA", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSObjData2_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSOBJDATA2", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSObjId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSOBJID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSObjName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSOBJNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSObjType_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSOBJTYPE", iEntity, bl2, null, false, 50, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSObjTypeName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSOBJTYPENAME", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysMsgTemplId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSMSGTEMPLID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysMsgTemplName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSMSGTEMPLNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysSequenceId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSSEQUENCEID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysSequenceName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSSEQUENCENAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysTranslatorId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSTRANSLATORID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysTranslatorName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSTRANSLATORNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_SrcIndex_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_SrcParamPSDEId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("SRCPARAMPSDEID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_SrcPSDEFId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("SRCPSDEFID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_SrcPSDEFName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("SRCPSDEFNAME", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_SrcPSDLParamId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("SRCPSDLPARAMID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_SrcPSDLParamName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("SRCPSDLPARAMNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_SrcSize_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_SrcValue_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("SRCVALUE", iEntity, bl2, null, false, 2000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[2000]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[2000]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_SrcValueStdDataType_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_SrcValueType_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("SRCVALUETYPE", iEntity, bl2, null, false, 40, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[40]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[40]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_SrcValueTypeText_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("SRCVALUETYPETEXT", iEntity, bl2, null, false, 50, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]";
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

    protected String onTestValueRule_UserCat_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("USERCAT", iEntity, bl2, null, false, 10, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[10]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[10]";
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

    protected String onTestValueRule_UserTag3_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("USERTAG3", iEntity, bl2, null, false, 50, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_UserTag4_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("USERTAG4", iEntity, bl2, null, false, 50, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected boolean onMergeChild(String string, String string2, PSDELNParam pSDELNParam) throws Exception {
        boolean bl = false;
        if (super.onMergeChild(string, string2, pSDELNParam)) {
            bl = true;
        }
        return bl;
    }

    protected void onUpdateParent(PSDELNParam pSDELNParam) throws Exception {
        super.onUpdateParent(pSDELNParam);
    }

    @Override
    protected void exportCurXmlModel(PSDELNParam pSDELNParam, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSDELNPARAM");
        if (!bl) {
            pSDELNParam.setPSDELogicId(null);
            pSDELNParam.setDstParamPSDEId(null);
            pSDELNParam.setDstPSDLParamId(null);
            pSDELNParam.setSrcParamPSDEId(null);
            pSDELNParam.setSrcPSDLParamId(null);
            pSDELNParam.setPSDELogicId(null);
            pSDELNParam.setPSDELogicNodeId(null);
            pSDELNParam.setPSDELogicNodeName(null);
            super.exportCurXmlModel(pSDELNParam, xmlNode, bl);
        }
    }

    @Override
    public ObjectNode fillModelV2(ObjectNode objectNode, PSDELNParam pSDELNParam, String string) throws Exception {
        objectNode = super.fillModelV2(objectNode, pSDELNParam, string);
        return objectNode;
    }

    @Override
    public String getModelV2ResScope(IEntity iEntity) throws Exception {
        String string = null;
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSDELOGICNODEID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return StringHelper.format((String)"PSDELOGICNODE#%1$s", (Object)string);
        }
        return super.getModelV2ResScope(iEntity);
    }

    @Override
    public String getModelV2ResScopeDER(IEntity iEntity) throws Exception {
        String string = null;
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSDELOGICNODEID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return "DER1N_PSDELNPARAM_PSDELOGICNODE_PSDELOGICNODEID";
        }
        return super.getModelV2ResScopeDER(iEntity);
    }

    @Override
    public String getModelV2ResScopeText(IEntity iEntity) throws Exception {
        String string = null;
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSDELOGICNODEID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return DataObject.getStringValue((IDataObject)iEntity, (String)"PSDELOGICNODENAME", null);
        }
        return super.getModelV2ResScopeText(iEntity);
    }

    @Override
    public boolean setModelV2ResScope(IEntity iEntity, String string, String string2) throws Exception {
        if (StringHelper.compare((String)string, (String)"PSDELOGICNODE", (boolean)true) == 0) {
            iEntity.set("PSDELOGICNODEID", (Object)string2);
            return true;
        }
        return super.setModelV2ResScope(iEntity, string, string2);
    }

    @Override
    public String[] getModelV2ResScopeFields() throws Exception {
        return new String[]{"PSDELOGICNODEID"};
    }

    @Override
    public String getModelV2Tag(PSDELNParam pSDELNParam) {
        return super.getModelV2Tag(pSDELNParam);
    }

    @Override
    public boolean setModelV2Tag(PSDELNParam pSDELNParam, String string) {
        return super.setModelV2Tag(pSDELNParam, string);
    }

    @Override
    public Map<String, String> getListDRDataFolderFields(Map<String, String> map, PSMOSFile pSMOSFile, IPSMOSFileFilter iPSMOSFileFilter) throws Exception {
        if (map == null) {
            map = new HashMap<String, String>();
        }
        map.put("PSDELOGICNODEID", "");
        return super.getListDRDataFolderFields(map, pSMOSFile, iPSMOSFileFilter);
    }

    @Override
    public boolean getModelV2Entity(PSDELNParam pSDELNParam, String string) throws Exception {
        SimpleEntity simpleEntity = new SimpleEntity();
        pSDELNParam.copyTo((IDataObject)simpleEntity, false);
        simpleEntity.copyTo((IDataObject)pSDELNParam, true);
        return super.getModelV2Entity(pSDELNParam, string);
    }

    @Override
    protected boolean testCompileCurModelV2(PSDELNParam pSDELNParam, ObjectNode objectNode, String string, String string2, int n) throws Exception {
        if (n == 1) {
            return false;
        }
        return super.testCompileCurModelV2(pSDELNParam, objectNode, string, string2, n);
    }
}

