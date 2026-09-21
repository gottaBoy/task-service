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
 *  net.ibizsys.paas.util.KeyValueHelper
 *  net.ibizsys.paas.util.StringBuilderEx
 *  net.ibizsys.paas.util.StringHelper
 *  net.ibizsys.paas.xml.XmlNode
 *  net.sf.json.JSONObject
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 *  org.hibernate.SessionFactory
 */
package net.ibizsys.pscore.srv.sysdesign.service;

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
import net.ibizsys.paas.util.KeyValueHelper;
import net.ibizsys.paas.util.StringBuilderEx;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.xml.XmlNode;
import net.ibizsys.pscore.srv.PSCoreSysServiceBase;
import net.ibizsys.pscore.srv.config.entity.PSSFCodeFolder;
import net.ibizsys.pscore.srv.config.entity.PSSFCodeFolderBase;
import net.ibizsys.pscore.srv.config.entity.PSSFCodeType;
import net.ibizsys.pscore.srv.config.entity.PSSFCodeTypeBase;
import net.ibizsys.pscore.srv.core.IPSDataEntityModel;
import net.ibizsys.pscore.srv.sysdesign.dao.PSSysSFCodeDAO;
import net.ibizsys.pscore.srv.sysdesign.demodel.PSSysSFCodeDEModel;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysSFCode;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysSFPub;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysSFPubBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSystem;
import net.ibizsys.pscore.srv.sysdevstudio.entity.PSMOSFile;
import net.ibizsys.pscore.srv.util.IPSMOSFileFilter;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSSysSFCodeServiceBase
extends PSCoreSysServiceBase<PSSysSFCode> {
    private static final Log log = LogFactory.getLog(PSSysSFCodeServiceBase.class);
    public static final String DATASET_DEFAULT = "DEFAULT";
    private PSSysSFCodeDEModel pSSysSFCodeDEModel;
    private PSSysSFCodeDAO pSSysSFCodeDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.sysdesign.service.PSSysSFCodeService";
    }

    public PSSysSFCodeDEModel getPSSysSFCodeDEModel() {
        if (this.pSSysSFCodeDEModel == null) {
            try {
                this.pSSysSFCodeDEModel = (PSSysSFCodeDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.sysdesign.demodel.PSSysSFCodeDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSSysSFCodeDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSSysSFCodeDEModel();
    }

    public PSSysSFCodeDAO getPSSysSFCodeDAO() {
        if (this.pSSysSFCodeDAO == null) {
            try {
                this.pSSysSFCodeDAO = (PSSysSFCodeDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.sysdesign.dao.PSSysSFCodeDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSSysSFCodeDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSSysSFCodeDAO();
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

    protected void onFillParentInfo(PSSysSFCode pSSysSFCode, String string, String string2, String string3) throws Exception {
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSSFCODE_PSSFCODEFOLDER_PSSFCODEFOLDERID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.config.service.PSSFCodeFolderService", (SessionFactory)this.getSessionFactory());
            PSSFCodeFolder pSSFCodeFolder = (PSSFCodeFolder)iService.getDEModel().createEntity();
            pSSFCodeFolder.set("PSSFCODEFOLDERID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSSFCodeFolder);
            } else {
                iService.get((IEntity)pSSFCodeFolder);
            }
            this.onFillParentInfo_PSSFCodeFolder(pSSysSFCode, pSSFCodeFolder);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSSFCODE_PSSFCODETYPE_PSSFCODETYPEID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.config.service.PSSFCodeTypeService", (SessionFactory)this.getSessionFactory());
            PSSFCodeType pSSFCodeType = (PSSFCodeType)iService.getDEModel().createEntity();
            pSSFCodeType.set("PSSFCODETYPEID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSSFCodeType);
            } else {
                iService.get((IEntity)pSSFCodeType);
            }
            this.onFillParentInfo_PSSFCodeType(pSSysSFCode, pSSFCodeType);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSSFCODE_PSSYSSFPUB_PSSYSSFPUBID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysSFPubService", (SessionFactory)this.getSessionFactory());
            PSSysSFPub pSSysSFPub = (PSSysSFPub)iService.getDEModel().createEntity();
            pSSysSFPub.set("PSSYSSFPUBID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSSysSFPub);
            } else {
                iService.get((IEntity)pSSysSFPub);
            }
            this.onFillParentInfo_PSSysSFPub(pSSysSFCode, pSSysSFPub);
            return;
        }
        super.onFillParentInfo((IEntity)pSSysSFCode, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillParentInfo_PSSFCodeFolder(PSSysSFCode pSSysSFCode, PSSFCodeFolder pSSFCodeFolder) throws Exception {
        pSSysSFCode.setPSSFCodeFolderId(pSSFCodeFolder.getPSSFCodeFolderId());
        pSSysSFCode.setPSSFCodeFolderName(pSSFCodeFolder.getPSSFCodeFolderName());
    }

    protected void onFillParentInfo_PSSFCodeType(PSSysSFCode pSSysSFCode, PSSFCodeType pSSFCodeType) throws Exception {
        pSSysSFCode.setPSSFCodeTypeId(pSSFCodeType.getPSSFCodeTypeId());
        pSSysSFCode.setPSSFCodeTypeName(pSSFCodeType.getPSSFCodeTypeName());
        if (pSSFCodeType.getPSSFCodeFolder() != null) {
            this.onFillParentInfo_PSSFCodeFolder(pSSysSFCode, pSSFCodeType.getPSSFCodeFolder());
        }
    }

    protected void onFillParentInfo_PSSysSFPub(PSSysSFCode pSSysSFCode, PSSysSFPub pSSysSFPub) throws Exception {
        pSSysSFCode.setPSSysSFPubId(pSSysSFPub.getPSSysSFPubId());
        pSSysSFCode.setPSSysSFPubName(pSSysSFPub.getPSSysSFPubName());
    }

    protected boolean onFillEntityKeyValue(PSSysSFCode pSSysSFCode, boolean bl) throws Exception {
        StringBuilderEx stringBuilderEx = new StringBuilderEx();
        Object object = pSSysSFCode.get("PSSYSSFPUBID");
        if (object == null) {
            object = "__EMTPY__";
        }
        stringBuilderEx.append("%1$s", object);
        stringBuilderEx.append("||");
        Object object2 = pSSysSFCode.get("CODEPATH");
        if (object2 == null) {
            object2 = "__EMTPY__";
        }
        stringBuilderEx.append("%1$s", object2);
        stringBuilderEx.append("||");
        Object object3 = pSSysSFCode.get("PSSYSSFCODENAME");
        if (object3 == null) {
            object3 = "__EMTPY__";
        }
        stringBuilderEx.append("%1$s", object3);
        stringBuilderEx.append("||");
        Object object4 = pSSysSFCode.get("FULLCODENAME");
        if (object4 == null) {
            object4 = "__EMTPY__";
        }
        stringBuilderEx.append("%1$s", object4);
        String string = stringBuilderEx.toString();
        pSSysSFCode.set(this.getPSSysSFCodeDEModel().getKeyDEField().getName(), KeyValueHelper.genUniqueId((String)string));
        return true;
    }

    protected void onFillEntityFullInfo(PSSysSFCode pSSysSFCode, boolean bl) throws Exception {
        if (bl && pSSysSFCode.getValidFlag() == null) {
            pSSysSFCode.setValidFlag((Integer)this.getDefaultValue(this.getWebContext(), "", "1", 9));
        }
        super.onFillEntityFullInfo((IEntity)pSSysSFCode, bl);
        this.onFillEntityFullInfo_PSSFCodeFolder(pSSysSFCode, bl);
        this.onFillEntityFullInfo_PSSFCodeType(pSSysSFCode, bl);
        this.onFillEntityFullInfo_PSSysSFPub(pSSysSFCode, bl);
    }

    protected void onFillEntityFullInfo_PSSFCodeFolder(PSSysSFCode pSSysSFCode, boolean bl) throws Exception {
        if (pSSysSFCode.isPSSFCodeFolderIdDirty()) {
            if (pSSysSFCode.getPSSFCodeFolderId() != null) {
                if (pSSysSFCode.getPSSFCodeFolderId() == null || pSSysSFCode.getPSSFCodeFolderName() == null) {
                    PSSFCodeFolder pSSFCodeFolder = pSSysSFCode.getPSSFCodeFolder();
                    pSSysSFCode.setPSSFCodeFolderName(pSSFCodeFolder.getPSSFCodeFolderName());
                }
            } else {
                pSSysSFCode.setPSSFCodeFolderName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_PSSFCodeType(PSSysSFCode pSSysSFCode, boolean bl) throws Exception {
        if (pSSysSFCode.isPSSFCodeTypeIdDirty()) {
            if (pSSysSFCode.getPSSFCodeTypeId() != null) {
                PSSFCodeType pSSFCodeType;
                if (pSSysSFCode.getPSSFCodeTypeId() == null || pSSysSFCode.getPSSFCodeTypeName() == null) {
                    pSSFCodeType = pSSysSFCode.getPSSFCodeType();
                    pSSysSFCode.setPSSFCodeTypeName(pSSFCodeType.getPSSFCodeTypeName());
                }
                if (DataTypeHelper.compare((int)25, (Object)(pSSFCodeType = pSSysSFCode.getPSSFCodeType()).getPSSFCodeFolderId(), (Object)pSSysSFCode.getPSSFCodeFolderId()) != 0L) {
                    pSSysSFCode.setPSSFCodeFolderId(pSSFCodeType.getPSSFCodeFolderId());
                    this.onFillEntityFullInfo_PSSFCodeFolder(pSSysSFCode, bl);
                }
            } else {
                pSSysSFCode.setPSSFCodeTypeName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_PSSysSFPub(PSSysSFCode pSSysSFCode, boolean bl) throws Exception {
    }

    protected void onWriteBackParent(PSSysSFCode pSSysSFCode, boolean bl) throws Exception {
        super.onWriteBackParent((IEntity)pSSysSFCode, bl);
    }

    public ArrayList<PSSysSFCode> selectByPSSFCodeFolder(PSSFCodeFolderBase pSSFCodeFolderBase) throws Exception {
        return this.selectByPSSFCodeFolder(pSSFCodeFolderBase, "", -1);
    }

    public ArrayList<PSSysSFCode> selectByPSSFCodeFolder(PSSFCodeFolderBase pSSFCodeFolderBase, String string) throws Exception {
        return this.selectByPSSFCodeFolder(pSSFCodeFolderBase, string, -1);
    }

    public ArrayList<PSSysSFCode> selectByPSSFCodeFolder(PSSFCodeFolderBase pSSFCodeFolderBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSSFCODEFOLDERID", (Object)pSSFCodeFolderBase.getPSSFCodeFolderId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSSFCodeFolderCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSSFCodeFolderCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSSysSFCode> selectByPSSFCodeType(PSSFCodeTypeBase pSSFCodeTypeBase) throws Exception {
        return this.selectByPSSFCodeType(pSSFCodeTypeBase, "", -1);
    }

    public ArrayList<PSSysSFCode> selectByPSSFCodeType(PSSFCodeTypeBase pSSFCodeTypeBase, String string) throws Exception {
        return this.selectByPSSFCodeType(pSSFCodeTypeBase, string, -1);
    }

    public ArrayList<PSSysSFCode> selectByPSSFCodeType(PSSFCodeTypeBase pSSFCodeTypeBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSSFCODETYPEID", (Object)pSSFCodeTypeBase.getPSSFCodeTypeId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSSFCodeTypeCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSSFCodeTypeCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSSysSFCode> selectByPSSysSFPub(PSSysSFPubBase pSSysSFPubBase) throws Exception {
        return this.selectByPSSysSFPub(pSSysSFPubBase, "", -1);
    }

    public ArrayList<PSSysSFCode> selectByPSSysSFPub(PSSysSFPubBase pSSysSFPubBase, String string) throws Exception {
        return this.selectByPSSysSFPub(pSSysSFPubBase, string, -1);
    }

    public ArrayList<PSSysSFCode> selectByPSSysSFPub(PSSysSFPubBase pSSysSFPubBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSSYSSFPUBID", (Object)pSSysSFPubBase.getPSSysSFPubId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSSysSFPubCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSSysSFPubCond(SelectCond selectCond) throws Exception {
    }

    public void testRemoveByPSSFCodeFolder(PSSFCodeFolder pSSFCodeFolder) throws Exception {
        ArrayList<PSSysSFCode> arrayList = this.selectByPSSFCodeFolder(pSSFCodeFolder, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSFCODEFOLDER");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSSFCodeFolder);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSSFCODE_PSSFCODEFOLDER_PSSFCODEFOLDERID", "", iDataEntityModel.getName(), "PSSYSSFCODE", iDataEntityModel.getDataInfo((IEntity)pSSFCodeFolder), arrayList.get(0)));
        }
    }

    public void resetPSSFCodeFolder(PSSFCodeFolder pSSFCodeFolder) throws Exception {
        ArrayList<PSSysSFCode> arrayList = this.selectByPSSFCodeFolder(pSSFCodeFolder);
        for (PSSysSFCode pSSysSFCode : arrayList) {
            PSSysSFCode pSSysSFCode2 = (PSSysSFCode)this.getDEModel().createEntity();
            pSSysSFCode2.setPSSysSFCodeId(pSSysSFCode.getPSSysSFCodeId());
            pSSysSFCode2.setPSSFCodeFolderId(null);
            this.update(pSSysSFCode2);
        }
    }

    public void removeByPSSFCodeFolder(PSSFCodeFolder pSSFCodeFolder) throws Exception {
        final PSSFCodeFolder pSSFCodeFolder2 = pSSFCodeFolder;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysSFCodeServiceBase.this.onBeforeRemoveByPSSFCodeFolder(pSSFCodeFolder2);
                PSSysSFCodeServiceBase.this.internalRemoveByPSSFCodeFolder(pSSFCodeFolder2);
                PSSysSFCodeServiceBase.this.onAfterRemoveByPSSFCodeFolder(pSSFCodeFolder2);
            }
        });
    }

    protected void onBeforeRemoveByPSSFCodeFolder(PSSFCodeFolder pSSFCodeFolder) throws Exception {
    }

    protected void internalRemoveByPSSFCodeFolder(PSSFCodeFolder pSSFCodeFolder) throws Exception {
        ArrayList<PSSysSFCode> arrayList = this.selectByPSSFCodeFolder(pSSFCodeFolder);
        this.onBeforeRemoveByPSSFCodeFolder(pSSFCodeFolder, arrayList);
        for (PSSysSFCode pSSysSFCode : arrayList) {
            this.remove((IEntity)pSSysSFCode);
        }
        this.onAfterRemoveByPSSFCodeFolder(pSSFCodeFolder, arrayList);
    }

    protected void onAfterRemoveByPSSFCodeFolder(PSSFCodeFolder pSSFCodeFolder) throws Exception {
    }

    protected void onBeforeRemoveByPSSFCodeFolder(PSSFCodeFolder pSSFCodeFolder, ArrayList<PSSysSFCode> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSFCodeFolder(PSSFCodeFolder pSSFCodeFolder, ArrayList<PSSysSFCode> arrayList) throws Exception {
    }

    public void testRemoveByPSSFCodeType(PSSFCodeType pSSFCodeType) throws Exception {
        ArrayList<PSSysSFCode> arrayList = this.selectByPSSFCodeType(pSSFCodeType, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSFCODETYPE");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSSFCodeType);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSSFCODE_PSSFCODETYPE_PSSFCODETYPEID", "", iDataEntityModel.getName(), "PSSYSSFCODE", iDataEntityModel.getDataInfo((IEntity)pSSFCodeType), arrayList.get(0)));
        }
    }

    public void resetPSSFCodeType(PSSFCodeType pSSFCodeType) throws Exception {
        ArrayList<PSSysSFCode> arrayList = this.selectByPSSFCodeType(pSSFCodeType);
        for (PSSysSFCode pSSysSFCode : arrayList) {
            PSSysSFCode pSSysSFCode2 = (PSSysSFCode)this.getDEModel().createEntity();
            pSSysSFCode2.setPSSysSFCodeId(pSSysSFCode.getPSSysSFCodeId());
            pSSysSFCode2.setPSSFCodeTypeId(null);
            this.update(pSSysSFCode2);
        }
    }

    public void removeByPSSFCodeType(PSSFCodeType pSSFCodeType) throws Exception {
        final PSSFCodeType pSSFCodeType2 = pSSFCodeType;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysSFCodeServiceBase.this.onBeforeRemoveByPSSFCodeType(pSSFCodeType2);
                PSSysSFCodeServiceBase.this.internalRemoveByPSSFCodeType(pSSFCodeType2);
                PSSysSFCodeServiceBase.this.onAfterRemoveByPSSFCodeType(pSSFCodeType2);
            }
        });
    }

    protected void onBeforeRemoveByPSSFCodeType(PSSFCodeType pSSFCodeType) throws Exception {
    }

    protected void internalRemoveByPSSFCodeType(PSSFCodeType pSSFCodeType) throws Exception {
        ArrayList<PSSysSFCode> arrayList = this.selectByPSSFCodeType(pSSFCodeType);
        this.onBeforeRemoveByPSSFCodeType(pSSFCodeType, arrayList);
        for (PSSysSFCode pSSysSFCode : arrayList) {
            this.remove((IEntity)pSSysSFCode);
        }
        this.onAfterRemoveByPSSFCodeType(pSSFCodeType, arrayList);
    }

    protected void onAfterRemoveByPSSFCodeType(PSSFCodeType pSSFCodeType) throws Exception {
    }

    protected void onBeforeRemoveByPSSFCodeType(PSSFCodeType pSSFCodeType, ArrayList<PSSysSFCode> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSFCodeType(PSSFCodeType pSSFCodeType, ArrayList<PSSysSFCode> arrayList) throws Exception {
    }

    public void testRemoveByPSSysSFPub(PSSysSFPub pSSysSFPub) throws Exception {
    }

    public void resetPSSysSFPub(PSSysSFPub pSSysSFPub) throws Exception {
        ArrayList<PSSysSFCode> arrayList = this.selectByPSSysSFPub(pSSysSFPub);
        for (PSSysSFCode pSSysSFCode : arrayList) {
            PSSysSFCode pSSysSFCode2 = (PSSysSFCode)this.getDEModel().createEntity();
            pSSysSFCode2.setPSSysSFCodeId(pSSysSFCode.getPSSysSFCodeId());
            pSSysSFCode2.setPSSysSFPubId(null);
            this.update(pSSysSFCode2);
        }
    }

    public void removeByPSSysSFPub(PSSysSFPub pSSysSFPub) throws Exception {
        final PSSysSFPub pSSysSFPub2 = pSSysSFPub;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysSFCodeServiceBase.this.onBeforeRemoveByPSSysSFPub(pSSysSFPub2);
                PSSysSFCodeServiceBase.this.internalRemoveByPSSysSFPub(pSSysSFPub2);
                PSSysSFCodeServiceBase.this.onAfterRemoveByPSSysSFPub(pSSysSFPub2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysSFPub(PSSysSFPub pSSysSFPub) throws Exception {
    }

    protected void internalRemoveByPSSysSFPub(PSSysSFPub pSSysSFPub) throws Exception {
        ArrayList<PSSysSFCode> arrayList = this.selectByPSSysSFPub(pSSysSFPub);
        this.onBeforeRemoveByPSSysSFPub(pSSysSFPub, arrayList);
        for (PSSysSFCode pSSysSFCode : arrayList) {
            this.remove((IEntity)pSSysSFCode);
        }
        this.onAfterRemoveByPSSysSFPub(pSSysSFPub, arrayList);
    }

    protected void onAfterRemoveByPSSysSFPub(PSSysSFPub pSSysSFPub) throws Exception {
    }

    protected void onBeforeRemoveByPSSysSFPub(PSSysSFPub pSSysSFPub, ArrayList<PSSysSFCode> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysSFPub(PSSysSFPub pSSysSFPub, ArrayList<PSSysSFCode> arrayList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(PSSysSFCode pSSysSFCode) throws Exception {
        super.onBeforeRemove(pSSysSFCode);
    }

    protected void replaceParentInfo(PSSysSFCode pSSysSFCode, CloneSession cloneSession) throws Exception {
        IEntity iEntity;
        super.replaceParentInfo((IEntity)pSSysSFCode, cloneSession);
        if (pSSysSFCode.getPSSFCodeFolderId() != null && (iEntity = cloneSession.getEntity("PSSFCODEFOLDER", (Object)pSSysSFCode.getPSSFCodeFolderId())) != null) {
            this.onFillParentInfo_PSSFCodeFolder(pSSysSFCode, (PSSFCodeFolder)iEntity);
        }
        if (pSSysSFCode.getPSSFCodeTypeId() != null && (iEntity = cloneSession.getEntity("PSSFCODETYPE", (Object)pSSysSFCode.getPSSFCodeTypeId())) != null) {
            this.onFillParentInfo_PSSFCodeType(pSSysSFCode, (PSSFCodeType)iEntity);
        }
        if (pSSysSFCode.getPSSysSFPubId() != null && (iEntity = cloneSession.getEntity("PSSYSSFPUB", (Object)pSSysSFCode.getPSSysSFPubId())) != null) {
            this.onFillParentInfo_PSSysSFPub(pSSysSFCode, (PSSysSFPub)iEntity);
        }
    }

    protected void onRemoveEntityUncopyValues(PSSysSFCode pSSysSFCode, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues((IEntity)pSSysSFCode, bl);
    }

    protected void onCheckEntity(boolean bl, PSSysSFCode pSSysSFCode, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_CodePath(bl, pSSysSFCode, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_FullCodeName(bl, pSSysSFCode, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Memo(bl, pSSysSFCode, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSFCodeFolderId(bl, pSSysSFCode, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSFCodeFolderName(bl, pSSysSFCode, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSFCodeTypeId(bl, pSSysSFCode, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSFCodeTypeName(bl, pSSysSFCode, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysSFCodeId(bl, pSSysSFCode, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysSFCodeName(bl, pSSysSFCode, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysSFPubId(bl, pSSysSFCode, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PubCode(bl, pSSysSFCode, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_SysObjId(bl, pSSysSFCode, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_SysObjName(bl, pSSysSFCode, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserCode(bl, pSSysSFCode, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ValidFlag(bl, pSSysSFCode, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, (IEntity)pSSysSFCode, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_CodePath(boolean bl, PSSysSFCode pSSysSFCode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysSFCode.isCodePathDirty() && !bl2 : !pSSysSFCode.isCodePathDirty()) {
            return null;
        }
        String string = pSSysSFCode.getCodePath();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CODEPATH");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_CodePath_Default((IEntity)pSSysSFCode, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CODEPATH");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_FullCodeName(boolean bl, PSSysSFCode pSSysSFCode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysSFCode.isFullCodeNameDirty() && !bl2 : !pSSysSFCode.isFullCodeNameDirty()) {
            return null;
        }
        String string = pSSysSFCode.getFullCodeName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("FULLCODENAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_FullCodeName_Default((IEntity)pSSysSFCode, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("FULLCODENAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Memo(boolean bl, PSSysSFCode pSSysSFCode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysSFCode.isMemoDirty() : !pSSysSFCode.isMemoDirty()) {
            return null;
        }
        String string = pSSysSFCode.getMemo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Memo_Default((IEntity)pSSysSFCode, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSSFCodeFolderId(boolean bl, PSSysSFCode pSSysSFCode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysSFCode.isPSSFCodeFolderIdDirty() : !pSSysSFCode.isPSSFCodeFolderIdDirty()) {
            return null;
        }
        String string = pSSysSFCode.getPSSFCodeFolderId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSFCodeFolderId_Default((IEntity)pSSysSFCode, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSFCODEFOLDERID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSFCodeFolderName(boolean bl, PSSysSFCode pSSysSFCode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysSFCode.isPSSFCodeFolderNameDirty() : !pSSysSFCode.isPSSFCodeFolderNameDirty()) {
            return null;
        }
        String string = pSSysSFCode.getPSSFCodeFolderName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSFCodeFolderName_Default((IEntity)pSSysSFCode, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSFCODEFOLDERNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSFCodeTypeId(boolean bl, PSSysSFCode pSSysSFCode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysSFCode.isPSSFCodeTypeIdDirty() : !pSSysSFCode.isPSSFCodeTypeIdDirty()) {
            return null;
        }
        String string = pSSysSFCode.getPSSFCodeTypeId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSFCodeTypeId_Default((IEntity)pSSysSFCode, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSFCODETYPEID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSFCodeTypeName(boolean bl, PSSysSFCode pSSysSFCode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysSFCode.isPSSFCodeTypeNameDirty() : !pSSysSFCode.isPSSFCodeTypeNameDirty()) {
            return null;
        }
        String string = pSSysSFCode.getPSSFCodeTypeName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSFCodeTypeName_Default((IEntity)pSSysSFCode, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSFCODETYPENAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSysSFCodeId(boolean bl, PSSysSFCode pSSysSFCode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysSFCode.isPSSysSFCodeIdDirty() && !bl2 : !pSSysSFCode.isPSSysSFCodeIdDirty()) {
            return null;
        }
        String string = pSSysSFCode.getPSSysSFCodeId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSSFCODEID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysSFCodeId_Default((IEntity)pSSysSFCode, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSSFCODEID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSysSFCodeName(boolean bl, PSSysSFCode pSSysSFCode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysSFCode.isPSSysSFCodeNameDirty() && !bl2 : !pSSysSFCode.isPSSysSFCodeNameDirty()) {
            return null;
        }
        String string = pSSysSFCode.getPSSysSFCodeName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSSFCODENAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysSFCodeName_Default((IEntity)pSSysSFCode, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSSFCODENAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSysSFPubId(boolean bl, PSSysSFCode pSSysSFCode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysSFCode.isPSSysSFPubIdDirty() && !bl2 : !pSSysSFCode.isPSSysSFPubIdDirty()) {
            return null;
        }
        String string = pSSysSFCode.getPSSysSFPubId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSSFPUBID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysSFPubId_Default((IEntity)pSSysSFCode, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSSFPUBID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PubCode(boolean bl, PSSysSFCode pSSysSFCode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysSFCode.isPubCodeDirty() : !pSSysSFCode.isPubCodeDirty()) {
            return null;
        }
        String string = pSSysSFCode.getPubCode();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PubCode_Default((IEntity)pSSysSFCode, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PUBCODE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_SysObjId(boolean bl, PSSysSFCode pSSysSFCode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysSFCode.isSysObjIdDirty() : !pSSysSFCode.isSysObjIdDirty()) {
            return null;
        }
        String string = pSSysSFCode.getSysObjId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_SysObjId_Default((IEntity)pSSysSFCode, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("SYSOBJID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_SysObjName(boolean bl, PSSysSFCode pSSysSFCode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysSFCode.isSysObjNameDirty() : !pSSysSFCode.isSysObjNameDirty()) {
            return null;
        }
        String string = pSSysSFCode.getSysObjName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_SysObjName_Default((IEntity)pSSysSFCode, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("SYSOBJNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_UserCode(boolean bl, PSSysSFCode pSSysSFCode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysSFCode.isUserCodeDirty() : !pSSysSFCode.isUserCodeDirty()) {
            return null;
        }
        String string = pSSysSFCode.getUserCode();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserCode_Default((IEntity)pSSysSFCode, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("USERCODE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ValidFlag(boolean bl, PSSysSFCode pSSysSFCode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysSFCode.isValidFlagDirty() : !pSSysSFCode.isValidFlagDirty()) {
            return null;
        }
        Integer n = pSSysSFCode.getValidFlag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_ValidFlag_Default((IEntity)pSSysSFCode, bl2, bl3);
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

    protected void onSyncEntity(PSSysSFCode pSSysSFCode, boolean bl) throws Exception {
        super.onSyncEntity((IEntity)pSSysSFCode, bl);
    }

    protected void onSyncIndexEntities(PSSysSFCode pSSysSFCode, boolean bl) throws Exception {
        super.onSyncIndexEntities((IEntity)pSSysSFCode, bl);
    }

    public Object getDataContextValue(PSSysSFCode pSSysSFCode, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null) {
            // empty if block
        }
        if ((object = super.getDataContextValue((IEntity)pSSysSFCode, string, iDataContextParam)) != null) {
            return object;
        }
        PSSysSFPub pSSysSFPub = pSSysSFCode.getPSSysSFPub();
        if (pSSysSFPub != null && pSSysSFPub.contains(string)) {
            return pSSysSFPub.get(string);
        }
        return null;
    }

    protected void onExportMajorModel(PSSysSFCode pSSysSFCode, ArrayList<JSONObject> arrayList, int n) throws Exception {
        super.onExportMajorModel((IEntity)pSSysSFCode, arrayList, n);
    }

    protected String onTestValueRule(String string, String string2, IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        if (StringHelper.compare((String)string, (String)"CODEPATH", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CodePath_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATEDATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateDate_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATEMAN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateMan_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"FULLCODENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_FullCodeName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MEMO", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Memo_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSFCODEFOLDERID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSFCodeFolderId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSFCODEFOLDERNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSFCodeFolderName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSFCODETYPEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSFCodeTypeId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSFCODETYPENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSFCodeTypeName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSSFCODEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysSFCodeId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSSFCODENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysSFCodeName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSSFPUBID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysSFPubId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSSFPUBNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysSFPubName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PUBCODE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PubCode_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"SYSOBJID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_SysObjId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"SYSOBJNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_SysObjName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UPDATEDATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UpdateDate_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UPDATEMAN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UpdateMan_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"USERCODE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UserCode_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"VALIDFLAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ValidFlag_Default(iEntity, bl, bl2);
        }
        return super.onTestValueRule(string, string2, iEntity, bl, bl2);
    }

    protected String onTestValueRule_CodePath_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("CODEPATH", iEntity, bl2, null, false, 500, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[500]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[500]";
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

    protected String onTestValueRule_FullCodeName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("FULLCODENAME", iEntity, bl2, null, false, 150, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[150]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[150]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
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

    protected String onTestValueRule_PSSFCodeFolderId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSFCODEFOLDERID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSFCodeFolderName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSFCODEFOLDERNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSFCodeTypeId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSFCODETYPEID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSFCodeTypeName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSFCODETYPENAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysSFCodeId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSSFCODEID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysSFCodeName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSSFCODENAME", iEntity, bl2, null, false, 50, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysSFPubId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSSFPUBID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysSFPubName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSSFPUBNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PubCode_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PUBCODE", iEntity, bl2, null, false, 0x100000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_SysObjId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("SYSOBJID", iEntity, bl2, null, false, 60, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_SysObjName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("SYSOBJNAME", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
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

    protected String onTestValueRule_UserCode_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("USERCODE", iEntity, bl2, null, false, 0x100000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_ValidFlag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected boolean onMergeChild(String string, String string2, PSSysSFCode pSSysSFCode) throws Exception {
        boolean bl = false;
        if (super.onMergeChild(string, string2, (IEntity)pSSysSFCode)) {
            bl = true;
        }
        return bl;
    }

    protected void onUpdateParent(PSSysSFCode pSSysSFCode) throws Exception {
        Object object = pSSysSFCode.get("PSSYSSFPUBID");
        if (object != null) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysSFPubService", (SessionFactory)this.getSessionFactory());
            iService.mergeChild("DER1N", "DER1N_PSSYSSFCODE_PSSYSSFPUB_PSSYSSFPUBID", object);
        }
        super.onUpdateParent((IEntity)pSSysSFCode);
    }

    protected boolean isNeedUpdateParent() {
        return true;
    }

    @Override
    protected void exportCurXmlModel(PSSysSFCode pSSysSFCode, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSSYSSFCODE");
        if (!bl) {
            pSSysSFCode.setCreateDate(null);
            pSSysSFCode.setCreateMan(null);
            pSSysSFCode.setPSSysSFCodeId(null);
            pSSysSFCode.setUpdateDate(null);
            pSSysSFCode.setUpdateMan(null);
            super.exportCurXmlModel(pSSysSFCode, xmlNode, bl);
        }
    }

    @Override
    protected String getEntityFolderKeyValue(PSSysSFCode pSSysSFCode, PSSystem pSSystem) throws Exception {
        PSSysSFCode pSSysSFCode2 = new PSSysSFCode();
        pSSysSFCode2.setPSSysSFPubId(pSSysSFCode.getPSSysSFPubId());
        pSSysSFCode2.setCodePath(pSSysSFCode.getCodePath());
        pSSysSFCode2.setPSSysSFCodeName(pSSysSFCode.getPSSysSFCodeName());
        pSSysSFCode2.setFullCodeName(pSSysSFCode.getFullCodeName());
        if (this.selectOne((IEntity)pSSysSFCode2, true)) {
            return pSSysSFCode2.getPSSysSFCodeId();
        }
        return super.getEntityFolderKeyValue(pSSysSFCode, pSSystem);
    }

    @Override
    public ObjectNode fillModelV2(ObjectNode objectNode, PSSysSFCode pSSysSFCode, String string) throws Exception {
        objectNode = super.fillModelV2(objectNode, pSSysSFCode, string);
        return objectNode;
    }

    @Override
    public String getModelV2ResScope(IEntity iEntity) throws Exception {
        String string = null;
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSSYSSFPUBID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return StringHelper.format((String)"PSSYSSFPUB#%1$s", (Object)string);
        }
        return super.getModelV2ResScope(iEntity);
    }

    @Override
    public String getModelV2ResScopeDER(IEntity iEntity) throws Exception {
        String string = null;
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSSYSSFPUBID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return "DER1N_PSSYSSFCODE_PSSYSSFPUB_PSSYSSFPUBID";
        }
        return super.getModelV2ResScopeDER(iEntity);
    }

    @Override
    public String getModelV2ResScopeText(IEntity iEntity) throws Exception {
        String string = null;
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSSYSSFPUBID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return DataObject.getStringValue((IDataObject)iEntity, (String)"PSSYSSFPUBNAME", null);
        }
        return super.getModelV2ResScopeText(iEntity);
    }

    @Override
    public boolean setModelV2ResScope(IEntity iEntity, String string, String string2) throws Exception {
        if (StringHelper.compare((String)string, (String)"PSSYSSFPUB", (boolean)true) == 0) {
            iEntity.set("PSSYSSFPUBID", (Object)string2);
            return true;
        }
        return super.setModelV2ResScope(iEntity, string, string2);
    }

    @Override
    public String[] getModelV2ResScopeFields() throws Exception {
        return new String[]{"PSSYSSFPUBID"};
    }

    @Override
    public String getModelV2Tag(PSSysSFCode pSSysSFCode) {
        if (!StringHelper.isNullOrEmpty((String)pSSysSFCode.getPSSysSFCodeName())) {
            return pSSysSFCode.getPSSysSFCodeName();
        }
        return super.getModelV2Tag(pSSysSFCode);
    }

    @Override
    public boolean setModelV2Tag(PSSysSFCode pSSysSFCode, String string) {
        return super.setModelV2Tag(pSSysSFCode, string);
    }

    @Override
    public Map<String, String> getListDRDataFolderFields(Map<String, String> map, PSMOSFile pSMOSFile, IPSMOSFileFilter iPSMOSFileFilter) throws Exception {
        if (map == null) {
            map = new HashMap<String, String>();
        }
        map.put("PSSYSSFCODENAME", "");
        map.put("PSSYSSFPUBID", "");
        return super.getListDRDataFolderFields(map, pSMOSFile, iPSMOSFileFilter);
    }

    @Override
    public boolean getModelV2Entity(PSSysSFCode pSSysSFCode, String string) throws Exception {
        SimpleEntity simpleEntity = new SimpleEntity();
        pSSysSFCode.copyTo((IDataObject)simpleEntity, false);
        simpleEntity.copyTo((IDataObject)pSSysSFCode, true);
        pSSysSFCode.set("PSSYSSFCODENAME", string);
        if (this.select(pSSysSFCode, true)) {
            return true;
        }
        simpleEntity.copyTo((IDataObject)pSSysSFCode, true);
        return super.getModelV2Entity(pSSysSFCode, string);
    }

    @Override
    protected boolean testCompileCurModelV2(PSSysSFCode pSSysSFCode, ObjectNode objectNode, String string, String string2, int n) throws Exception {
        if (n == 1) {
            return false;
        }
        return super.testCompileCurModelV2(pSSysSFCode, objectNode, string, string2, n);
    }
}

