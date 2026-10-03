/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.fasterxml.jackson.databind.JsonNode
 *  com.fasterxml.jackson.databind.node.ArrayNode
 *  com.fasterxml.jackson.databind.node.ObjectNode
 *  javax.annotation.PostConstruct
 *  net.ibizsys.paas.core.IDEDataSetFetchContext
 *  net.ibizsys.paas.dao.DAOGlobal
 *  net.ibizsys.paas.dao.IDAO
 *  net.ibizsys.paas.data.DataObject
 *  net.ibizsys.paas.data.IDataObject
 *  net.ibizsys.paas.db.DBFetchResult
 *  net.ibizsys.paas.db.ISelectCond
 *  net.ibizsys.paas.db.ISelectField
 *  net.ibizsys.paas.db.SelectCond
 *  net.ibizsys.paas.db.SelectContext
 *  net.ibizsys.paas.db.SelectField
 *  net.ibizsys.paas.demodel.DEModelGlobal
 *  net.ibizsys.paas.demodel.IDataEntityModel
 *  net.ibizsys.paas.entity.EntityBase
 *  net.ibizsys.paas.entity.EntityError
 *  net.ibizsys.paas.entity.EntityFieldError
 *  net.ibizsys.paas.entity.IEntity
 *  net.ibizsys.paas.service.CloneSession
 *  net.ibizsys.paas.service.IDataContextParam
 *  net.ibizsys.paas.service.IService
 *  net.ibizsys.paas.service.IServiceWork
 *  net.ibizsys.paas.service.ITransaction
 *  net.ibizsys.paas.service.ServiceGlobal
 *  net.ibizsys.paas.service.SessionFactoryManager
 *  net.ibizsys.paas.util.DataTypeHelper
 *  net.ibizsys.paas.util.JsonNodeHelper
 *  net.ibizsys.paas.util.StringHelper
 *  net.ibizsys.paas.xml.XmlNode
 *  net.sf.json.JSONObject
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 *  org.hibernate.SessionFactory
 */
package net.ibizsys.pscore.srv.devcenter.service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import javax.annotation.PostConstruct;
import net.ibizsys.paas.core.IDEDataSetFetchContext;
import net.ibizsys.paas.dao.DAOGlobal;
import net.ibizsys.paas.dao.IDAO;
import net.ibizsys.paas.data.DataObject;
import net.ibizsys.paas.data.IDataObject;
import net.ibizsys.paas.db.DBFetchResult;
import net.ibizsys.paas.db.ISelectCond;
import net.ibizsys.paas.db.ISelectField;
import net.ibizsys.paas.db.SelectCond;
import net.ibizsys.paas.db.SelectContext;
import net.ibizsys.paas.db.SelectField;
import net.ibizsys.paas.demodel.DEModelGlobal;
import net.ibizsys.paas.demodel.IDataEntityModel;
import net.ibizsys.paas.entity.EntityBase;
import net.ibizsys.paas.entity.EntityError;
import net.ibizsys.paas.entity.EntityFieldError;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.service.CloneSession;
import net.ibizsys.paas.service.IDataContextParam;
import net.ibizsys.paas.service.IService;
import net.ibizsys.paas.service.IServiceWork;
import net.ibizsys.paas.service.ITransaction;
import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.paas.service.SessionFactoryManager;
import net.ibizsys.paas.util.DataTypeHelper;
import net.ibizsys.paas.util.JsonNodeHelper;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.xml.XmlNode;
import net.ibizsys.pscore.srv.PSCoreSysServiceBase;
import net.ibizsys.pscore.srv.core.IPSDataEntityModel;
import net.ibizsys.pscore.srv.devcenter.dao.PSDCModelTemplDAO;
import net.ibizsys.pscore.srv.devcenter.demodel.PSDCModelTemplDEModel;
import net.ibizsys.pscore.srv.devcenter.entity.PSDCMTDEF;
import net.ibizsys.pscore.srv.devcenter.entity.PSDCModelTempl;
import net.ibizsys.pscore.srv.devcenter.entity.PSDevCenter;
import net.ibizsys.pscore.srv.devcenter.entity.PSDevCenterBase;
import net.ibizsys.pscore.srv.devcenter.service.PSDCMTDECatService;
import net.ibizsys.pscore.srv.devcenter.service.PSDCMTDECatServiceBase;
import net.ibizsys.pscore.srv.devcenter.service.PSDCMTDEFService;
import net.ibizsys.pscore.srv.devcenter.service.PSDCMTDEFServiceBase;
import net.ibizsys.pscore.srv.helpdesign.entity.PSHelpSection;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSln;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSlnBase;
import net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnSysService;
import net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnSysServiceBase;
import net.ibizsys.pscore.srv.sysdevstudio.entity.PSMOSFile;
import net.ibizsys.pscore.srv.util.IPSMOSFileAction;
import net.ibizsys.pscore.srv.util.PSModelV2Helper;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDCModelTemplServiceBase
extends PSCoreSysServiceBase<PSDCModelTempl> {
    private static final Log log = LogFactory.getLog(PSDCModelTemplServiceBase.class);
    public static final String DATASET_ALLDC = "AllDC";
    public static final String DATASET_CURDC = "CurDC";
    public static final String DATASET_CURDCALL = "CurDCAll";
    public static final String DATASET_CURSLN = "CurSln";
    public static final String DATASET_DEFAULT = "DEFAULT";
    private PSDCModelTemplDEModel pSDCModelTemplDEModel;
    private PSDCModelTemplDAO pSDCModelTemplDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.devcenter.service.PSDCModelTemplService";
    }

    public PSDCModelTemplDEModel getPSDCModelTemplDEModel() {
        if (this.pSDCModelTemplDEModel == null) {
            try {
                this.pSDCModelTemplDEModel = (PSDCModelTemplDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.devcenter.demodel.PSDCModelTemplDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDCModelTemplDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSDCModelTemplDEModel();
    }

    public PSDCModelTemplDAO getPSDCModelTemplDAO() {
        if (this.pSDCModelTemplDAO == null) {
            try {
                this.pSDCModelTemplDAO = (PSDCModelTemplDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.devcenter.dao.PSDCModelTemplDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDCModelTemplDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSDCModelTemplDAO();
    }

    protected DBFetchResult onfetchDataSet(String string, IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        if (StringHelper.compare((String)string, (String)DATASET_ALLDC, (boolean)true) == 0) {
            return this.fetchAllDC(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_CURDC, (boolean)true) == 0) {
            return this.fetchCurDC(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_CURDCALL, (boolean)true) == 0) {
            return this.fetchCurDCAll(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_CURSLN, (boolean)true) == 0) {
            return this.fetchCurSln(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.fetchDefault(iDEDataSetFetchContext);
        }
        return super.onfetchDataSet(string, iDEDataSetFetchContext);
    }

    @Override
    protected void onExecuteAction(String string, IEntity iEntity) throws Exception {
        super.onExecuteAction(string, iEntity);
    }

    public DBFetchResult fetchAllDC(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_ALLDC, false);
        return dBFetchResult;
    }

    public DBFetchResult fetchCurDC(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CURDC, false);
        return dBFetchResult;
    }

    public DBFetchResult fetchCurDCAll(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CURDCALL, false);
        return dBFetchResult;
    }

    public DBFetchResult fetchCurSln(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CURSLN, false);
        return dBFetchResult;
    }

    public DBFetchResult fetchDefault(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_DEFAULT, false);
        return dBFetchResult;
    }

    protected void onFillParentInfo(PSDCModelTempl pSDCModelTempl, String string, String string2, String string3) throws Exception {
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDCMODELTEMPL_PSDEVCENTER_PSDEVCENTERID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.devcenter.service.PSDevCenterService", (SessionFactory)this.getSessionFactory());
            PSDevCenter pSDevCenter = (PSDevCenter)iService.getDEModel().createEntity();
            pSDevCenter.set("PSDEVCENTERID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDevCenter);
            } else {
                iService.get(pSDevCenter);
            }
            this.onFillParentInfo_PSDevCenter(pSDCModelTempl, pSDevCenter);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDCMODELTEMPL_PSDEVSLN_PSDEVSLNID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnService", (SessionFactory)this.getSessionFactory());
            PSDevSln pSDevSln = (PSDevSln)iService.getDEModel().createEntity();
            pSDevSln.set("PSDEVSLNID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDevSln);
            } else {
                iService.get(pSDevSln);
            }
            this.onFillParentInfo_PSDevSln(pSDCModelTempl, pSDevSln);
            return;
        }
        super.onFillParentInfo(pSDCModelTempl, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillParentInfo_PSDevCenter(PSDCModelTempl pSDCModelTempl, PSDevCenter pSDevCenter) throws Exception {
        pSDCModelTempl.setPSDevCenterId(pSDevCenter.getPSDevCenterId());
        pSDCModelTempl.setPSDevCenterName(pSDevCenter.getPSDevCenterName());
    }

    protected void onFillParentInfo_PSDevSln(PSDCModelTempl pSDCModelTempl, PSDevSln pSDevSln) throws Exception {
        pSDCModelTempl.setPSDevSlnId(pSDevSln.getPSDevSlnId());
        pSDCModelTempl.setPSDevSlnName(pSDevSln.getPSDevSlnName());
    }

    protected void onFillEntityFullInfo(PSDCModelTempl pSDCModelTempl, boolean bl) throws Exception {
        if (bl && pSDCModelTempl.getPSDCMTDEFsCnt() == null) {
            pSDCModelTempl.setPSDCMTDEFsCnt((Integer)this.getDefaultValue(this.getWebContext(), "", "0", 9));
        }
        super.onFillEntityFullInfo(pSDCModelTempl, bl);
        this.onFillEntityFullInfo_PSDevCenter(pSDCModelTempl, bl);
        this.onFillEntityFullInfo_PSDevSln(pSDCModelTempl, bl);
    }

    protected void onFillEntityFullInfo_PSDevCenter(PSDCModelTempl pSDCModelTempl, boolean bl) throws Exception {
        if (pSDCModelTempl.isPSDevCenterIdDirty()) {
            if (pSDCModelTempl.getPSDevCenterId() != null) {
                if (pSDCModelTempl.getPSDevCenterId() == null || pSDCModelTempl.getPSDevCenterName() == null) {
                    PSDevCenter pSDevCenter = pSDCModelTempl.getPSDevCenter();
                    pSDCModelTempl.setPSDevCenterName(pSDevCenter.getPSDevCenterName());
                }
            } else {
                pSDCModelTempl.setPSDevCenterName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_PSDevSln(PSDCModelTempl pSDCModelTempl, boolean bl) throws Exception {
    }

    protected void onWriteBackParent(PSDCModelTempl pSDCModelTempl, boolean bl) throws Exception {
        super.onWriteBackParent(pSDCModelTempl, bl);
    }

    public ArrayList<PSDCModelTempl> selectByPSDevCenter(PSDevCenterBase pSDevCenterBase) throws Exception {
        return this.selectByPSDevCenter(pSDevCenterBase, "", -1);
    }

    public ArrayList<PSDCModelTempl> selectByPSDevCenter(PSDevCenterBase pSDevCenterBase, String string) throws Exception {
        return this.selectByPSDevCenter(pSDevCenterBase, string, -1);
    }

    public ArrayList<PSDCModelTempl> selectByPSDevCenter(PSDevCenterBase pSDevCenterBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDEVCENTERID", (Object)pSDevCenterBase.getPSDevCenterId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSDevCenterCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSDevCenterCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDCModelTempl> selectByPSDevSln(PSDevSlnBase pSDevSlnBase) throws Exception {
        return this.selectByPSDevSln(pSDevSlnBase, "", -1);
    }

    public ArrayList<PSDCModelTempl> selectByPSDevSln(PSDevSlnBase pSDevSlnBase, String string) throws Exception {
        return this.selectByPSDevSln(pSDevSlnBase, string, -1);
    }

    public ArrayList<PSDCModelTempl> selectByPSDevSln(PSDevSlnBase pSDevSlnBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDEVSLNID", (Object)pSDevSlnBase.getPSDevSlnId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSDevSlnCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSDevSlnCond(SelectCond selectCond) throws Exception {
    }

    public void testRemoveByPSDevCenter(PSDevCenter pSDevCenter) throws Exception {
    }

    public void resetPSDevCenter(PSDevCenter pSDevCenter) throws Exception {
        ArrayList<PSDCModelTempl> arrayList = this.selectByPSDevCenter(pSDevCenter);
        for (PSDCModelTempl pSDCModelTempl : arrayList) {
            PSDCModelTempl pSDCModelTempl2 = (PSDCModelTempl)this.getDEModel().createEntity();
            pSDCModelTempl2.setPSDCModelTemplId(pSDCModelTempl.getPSDCModelTemplId());
            pSDCModelTempl2.setPSDevCenterId(null);
            this.update(pSDCModelTempl2);
        }
    }

    public void removeByPSDevCenter(PSDevCenter pSDevCenter) throws Exception {
        final PSDevCenter pSDevCenter2 = pSDevCenter;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDCModelTemplServiceBase.this.onBeforeRemoveByPSDevCenter(pSDevCenter2);
                PSDCModelTemplServiceBase.this.internalRemoveByPSDevCenter(pSDevCenter2);
                PSDCModelTemplServiceBase.this.onAfterRemoveByPSDevCenter(pSDevCenter2);
            }
        });
    }

    protected void onBeforeRemoveByPSDevCenter(PSDevCenter pSDevCenter) throws Exception {
    }

    protected void internalRemoveByPSDevCenter(PSDevCenter pSDevCenter) throws Exception {
        ArrayList<PSDCModelTempl> arrayList = this.selectByPSDevCenter(pSDevCenter);
        this.onBeforeRemoveByPSDevCenter(pSDevCenter, arrayList);
        for (PSDCModelTempl pSDCModelTempl : arrayList) {
            this.remove(pSDCModelTempl);
        }
        this.onAfterRemoveByPSDevCenter(pSDevCenter, arrayList);
    }

    protected void onAfterRemoveByPSDevCenter(PSDevCenter pSDevCenter) throws Exception {
    }

    protected void onBeforeRemoveByPSDevCenter(PSDevCenter pSDevCenter, ArrayList<PSDCModelTempl> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDevCenter(PSDevCenter pSDevCenter, ArrayList<PSDCModelTempl> arrayList) throws Exception {
    }

    public void testRemoveByPSDevSln(PSDevSln pSDevSln) throws Exception {
        ArrayList<PSDCModelTempl> arrayList = this.selectByPSDevSln(pSDevSln, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEVSLN");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDevSln);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDCMODELTEMPL_PSDEVSLN_PSDEVSLNID", "", iDataEntityModel.getName(), "PSDCMODELTEMPL", iDataEntityModel.getDataInfo(pSDevSln), arrayList.get(0)));
        }
    }

    public void resetPSDevSln(PSDevSln pSDevSln) throws Exception {
        ArrayList<PSDCModelTempl> arrayList = this.selectByPSDevSln(pSDevSln);
        for (PSDCModelTempl pSDCModelTempl : arrayList) {
            PSDCModelTempl pSDCModelTempl2 = (PSDCModelTempl)this.getDEModel().createEntity();
            pSDCModelTempl2.setPSDCModelTemplId(pSDCModelTempl.getPSDCModelTemplId());
            pSDCModelTempl2.setPSDevSlnId(null);
            this.update(pSDCModelTempl2);
        }
    }

    public void removeByPSDevSln(PSDevSln pSDevSln) throws Exception {
        final PSDevSln pSDevSln2 = pSDevSln;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDCModelTemplServiceBase.this.onBeforeRemoveByPSDevSln(pSDevSln2);
                PSDCModelTemplServiceBase.this.internalRemoveByPSDevSln(pSDevSln2);
                PSDCModelTemplServiceBase.this.onAfterRemoveByPSDevSln(pSDevSln2);
            }
        });
    }

    protected void onBeforeRemoveByPSDevSln(PSDevSln pSDevSln) throws Exception {
    }

    protected void internalRemoveByPSDevSln(PSDevSln pSDevSln) throws Exception {
        ArrayList<PSDCModelTempl> arrayList = this.selectByPSDevSln(pSDevSln);
        this.onBeforeRemoveByPSDevSln(pSDevSln, arrayList);
        for (PSDCModelTempl pSDCModelTempl : arrayList) {
            this.remove(pSDCModelTempl);
        }
        this.onAfterRemoveByPSDevSln(pSDevSln, arrayList);
    }

    protected void onAfterRemoveByPSDevSln(PSDevSln pSDevSln) throws Exception {
    }

    protected void onBeforeRemoveByPSDevSln(PSDevSln pSDevSln, ArrayList<PSDCModelTempl> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDevSln(PSDevSln pSDevSln, ArrayList<PSDCModelTempl> arrayList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(PSDCModelTempl pSDCModelTempl) throws Exception {
        PSCoreSysServiceBase pSCoreSysServiceBase = (PSDCMTDECatService)ServiceGlobal.getService(PSDCMTDECatService.class, (SessionFactory)this.getSessionFactory());
        ((PSDCMTDECatServiceBase)pSCoreSysServiceBase).testRemoveByPSDCModelTempl(pSDCModelTempl);
        ((PSDCMTDECatServiceBase)pSCoreSysServiceBase).removeByPSDCModelTempl(pSDCModelTempl);
        pSCoreSysServiceBase = (PSDCMTDEFService)ServiceGlobal.getService(PSDCMTDEFService.class, (SessionFactory)this.getSessionFactory());
        ((PSDCMTDEFServiceBase)pSCoreSysServiceBase).testRemoveByPSDCModelTempl(pSDCModelTempl);
        ((PSDCMTDEFServiceBase)pSCoreSysServiceBase).removeByPSDCModelTempl(pSDCModelTempl);
        pSCoreSysServiceBase = (PSDevSlnSysService)ServiceGlobal.getService(PSDevSlnSysService.class, (SessionFactory)this.getSessionFactory());
        ((PSDevSlnSysServiceBase)pSCoreSysServiceBase).testRemoveByPSDCModelTempl(pSDCModelTempl);
        super.onBeforeRemove(pSDCModelTempl);
    }

    protected void replaceParentInfo(PSDCModelTempl pSDCModelTempl, CloneSession cloneSession) throws Exception {
        IEntity iEntity;
        super.replaceParentInfo(pSDCModelTempl, cloneSession);
        if (pSDCModelTempl.getPSDevCenterId() != null && (iEntity = cloneSession.getEntity("PSDEVCENTER", (Object)pSDCModelTempl.getPSDevCenterId())) != null) {
            this.onFillParentInfo_PSDevCenter(pSDCModelTempl, (PSDevCenter)iEntity);
        }
        if (pSDCModelTempl.getPSDevSlnId() != null && (iEntity = cloneSession.getEntity("PSDEVSLN", (Object)pSDCModelTempl.getPSDevSlnId())) != null) {
            this.onFillParentInfo_PSDevSln(pSDCModelTempl, (PSDevSln)iEntity);
        }
    }

    protected void onRemoveEntityUncopyValues(PSDCModelTempl pSDCModelTempl, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues(pSDCModelTempl, bl);
    }

    protected void onCheckEntity(boolean bl, PSDCModelTempl pSDCModelTempl, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_DEFNameMaxLength(bl, pSDCModelTempl, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_DENameMaxLength(bl, pSDCModelTempl, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_IgnoreDefaultFields(bl, pSDCModelTempl, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Memo(bl, pSDCModelTempl, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDCModelTemplId(bl, pSDCModelTempl, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDCModelTemplName(bl, pSDCModelTempl, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDCMTDEFsCnt(bl, pSDCModelTempl, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDevCenterId(bl, pSDCModelTempl, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDevCenterName(bl, pSDCModelTempl, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDevSlnId(bl, pSDCModelTempl, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_TablePrefix(bl, pSDCModelTempl, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_TablePrefixFlag(bl, pSDCModelTempl, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_View2Prefix(bl, pSDCModelTempl, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_View3Prefix(bl, pSDCModelTempl, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_View4Prefix(bl, pSDCModelTempl, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ViewPrefix(bl, pSDCModelTempl, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ViewPrefixFlag(bl, pSDCModelTempl, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, pSDCModelTempl, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_DEFNameMaxLength(boolean bl, PSDCModelTempl pSDCModelTempl, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCModelTempl.isDEFNameMaxLengthDirty() : !pSDCModelTempl.isDEFNameMaxLengthDirty()) {
            return null;
        }
        Integer n = pSDCModelTempl.getDEFNameMaxLength();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_DEFNameMaxLength_Default(pSDCModelTempl, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DEFNAMEMAXLENGTH");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_DENameMaxLength(boolean bl, PSDCModelTempl pSDCModelTempl, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCModelTempl.isDENameMaxLengthDirty() : !pSDCModelTempl.isDENameMaxLengthDirty()) {
            return null;
        }
        Integer n = pSDCModelTempl.getDENameMaxLength();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_DENameMaxLength_Default(pSDCModelTempl, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DENAMEMAXLENGTH");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_IgnoreDefaultFields(boolean bl, PSDCModelTempl pSDCModelTempl, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCModelTempl.isIgnoreDefaultFieldsDirty() : !pSDCModelTempl.isIgnoreDefaultFieldsDirty()) {
            return null;
        }
        Integer n = pSDCModelTempl.getIgnoreDefaultFields();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_IgnoreDefaultFields_Default(pSDCModelTempl, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("IGNOREDEFAULTFIELDS");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Memo(boolean bl, PSDCModelTempl pSDCModelTempl, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCModelTempl.isMemoDirty() : !pSDCModelTempl.isMemoDirty()) {
            return null;
        }
        String string = pSDCModelTempl.getMemo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Memo_Default(pSDCModelTempl, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDCModelTemplId(boolean bl, PSDCModelTempl pSDCModelTempl, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCModelTempl.isPSDCModelTemplIdDirty() && !bl2 : !pSDCModelTempl.isPSDCModelTemplIdDirty()) {
            return null;
        }
        String string = pSDCModelTempl.getPSDCModelTemplId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDCMODELTEMPLID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDCModelTemplId_Default(pSDCModelTempl, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDCMODELTEMPLID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDCModelTemplName(boolean bl, PSDCModelTempl pSDCModelTempl, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCModelTempl.isPSDCModelTemplNameDirty() && !bl2 : !pSDCModelTempl.isPSDCModelTemplNameDirty()) {
            return null;
        }
        String string = pSDCModelTempl.getPSDCModelTemplName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDCMODELTEMPLNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDCModelTemplName_Default(pSDCModelTempl, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDCMODELTEMPLNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        } else {
            boolean bl4 = true;
            if (string == null) {
                bl4 = false;
            }
            if (bl4) {
                String string3 = "";
                string3 = "PSDEVCENTERID";
                string3 = string3 + ";";
                string3 = string3 + "PSDEVSLNID";
                String string4 = this.checkFieldDupRule(this.getPSDCModelTemplDEModel(), "PSDCMODELTEMPLNAME", string3, pSDCModelTempl, bl2, bl3);
                if (!StringHelper.isNullOrEmpty((String)string4)) {
                    EntityFieldError entityFieldError = new EntityFieldError();
                    entityFieldError.setFieldName("PSDCMODELTEMPLNAME");
                    entityFieldError.setErrorType(3);
                    entityFieldError.setErrorInfo(string4);
                    return entityFieldError;
                }
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDCMTDEFsCnt(boolean bl, PSDCModelTempl pSDCModelTempl, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCModelTempl.isPSDCMTDEFsCntDirty() : !pSDCModelTempl.isPSDCMTDEFsCntDirty()) {
            return null;
        }
        Integer n = pSDCModelTempl.getPSDCMTDEFsCnt();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_PSDCMTDEFsCnt_Default(pSDCModelTempl, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDCMTDEFSCNT");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDevCenterId(boolean bl, PSDCModelTempl pSDCModelTempl, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCModelTempl.isPSDevCenterIdDirty() : !pSDCModelTempl.isPSDevCenterIdDirty()) {
            return null;
        }
        String string = pSDCModelTempl.getPSDevCenterId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDevCenterId_Default(pSDCModelTempl, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEVCENTERID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDevCenterName(boolean bl, PSDCModelTempl pSDCModelTempl, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCModelTempl.isPSDevCenterNameDirty() : !pSDCModelTempl.isPSDevCenterNameDirty()) {
            return null;
        }
        String string = pSDCModelTempl.getPSDevCenterName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDevCenterName_Default(pSDCModelTempl, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEVCENTERNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDevSlnId(boolean bl, PSDCModelTempl pSDCModelTempl, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCModelTempl.isPSDevSlnIdDirty() : !pSDCModelTempl.isPSDevSlnIdDirty()) {
            return null;
        }
        String string = pSDCModelTempl.getPSDevSlnId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDevSlnId_Default(pSDCModelTempl, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEVSLNID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_TablePrefix(boolean bl, PSDCModelTempl pSDCModelTempl, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCModelTempl.isTablePrefixDirty() : !pSDCModelTempl.isTablePrefixDirty()) {
            return null;
        }
        String string = pSDCModelTempl.getTablePrefix();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_TablePrefix_Default(pSDCModelTempl, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("TABLEPREFIX");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_TablePrefixFlag(boolean bl, PSDCModelTempl pSDCModelTempl, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCModelTempl.isTablePrefixFlagDirty() : !pSDCModelTempl.isTablePrefixFlagDirty()) {
            return null;
        }
        Integer n = pSDCModelTempl.getTablePrefixFlag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_TablePrefixFlag_Default(pSDCModelTempl, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("TABLEPREFIXFLAG");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_View2Prefix(boolean bl, PSDCModelTempl pSDCModelTempl, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCModelTempl.isView2PrefixDirty() : !pSDCModelTempl.isView2PrefixDirty()) {
            return null;
        }
        String string = pSDCModelTempl.getView2Prefix();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_View2Prefix_Default(pSDCModelTempl, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("VIEW2PREFIX");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_View3Prefix(boolean bl, PSDCModelTempl pSDCModelTempl, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCModelTempl.isView3PrefixDirty() : !pSDCModelTempl.isView3PrefixDirty()) {
            return null;
        }
        String string = pSDCModelTempl.getView3Prefix();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_View3Prefix_Default(pSDCModelTempl, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("VIEW3PREFIX");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_View4Prefix(boolean bl, PSDCModelTempl pSDCModelTempl, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCModelTempl.isView4PrefixDirty() : !pSDCModelTempl.isView4PrefixDirty()) {
            return null;
        }
        String string = pSDCModelTempl.getView4Prefix();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_View4Prefix_Default(pSDCModelTempl, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("VIEW4PREFIX");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ViewPrefix(boolean bl, PSDCModelTempl pSDCModelTempl, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCModelTempl.isViewPrefixDirty() : !pSDCModelTempl.isViewPrefixDirty()) {
            return null;
        }
        String string = pSDCModelTempl.getViewPrefix();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_ViewPrefix_Default(pSDCModelTempl, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("VIEWPREFIX");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ViewPrefixFlag(boolean bl, PSDCModelTempl pSDCModelTempl, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCModelTempl.isViewPrefixFlagDirty() : !pSDCModelTempl.isViewPrefixFlagDirty()) {
            return null;
        }
        Integer n = pSDCModelTempl.getViewPrefixFlag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_ViewPrefixFlag_Default(pSDCModelTempl, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("VIEWPREFIXFLAG");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected void onSyncEntity(PSDCModelTempl pSDCModelTempl, boolean bl) throws Exception {
        super.onSyncEntity(pSDCModelTempl, bl);
    }

    protected void onSyncIndexEntities(PSDCModelTempl pSDCModelTempl, boolean bl) throws Exception {
        super.onSyncIndexEntities(pSDCModelTempl, bl);
    }

    public Object getDataContextValue(PSDCModelTempl pSDCModelTempl, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null) {
            // empty if block
        }
        if ((object = super.getDataContextValue(pSDCModelTempl, string, iDataContextParam)) != null) {
            return object;
        }
        return null;
    }

    protected void onExportMajorModel(PSDCModelTempl pSDCModelTempl, ArrayList<JSONObject> arrayList, int n) throws Exception {
        super.onExportMajorModel(pSDCModelTempl, arrayList, n);
    }

    protected String onTestValueRule(String string, String string2, IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        if (StringHelper.compare((String)string, (String)"CREATEDATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateDate_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATEMAN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateMan_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DEFNAMEMAXLENGTH", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DEFNameMaxLength_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DENAMEMAXLENGTH", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DENameMaxLength_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"IGNOREDEFAULTFIELDS", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_IgnoreDefaultFields_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MEMO", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Memo_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDCMODELTEMPLID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDCModelTemplId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDCMODELTEMPLNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDCModelTemplName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDCMTDEFSCNT", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDCMTDEFsCnt_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEVCENTERID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDevCenterId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEVCENTERNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDevCenterName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEVSLNID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDevSlnId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEVSLNNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDevSlnName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"TABLEPREFIX", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_TablePrefix_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"TABLEPREFIXFLAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_TablePrefixFlag_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UPDATEDATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UpdateDate_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UPDATEMAN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UpdateMan_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"VIEW2PREFIX", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_View2Prefix_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"VIEW3PREFIX", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_View3Prefix_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"VIEW4PREFIX", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_View4Prefix_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"VIEWPREFIX", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ViewPrefix_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"VIEWPREFIXFLAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ViewPrefixFlag_Default(iEntity, bl, bl2);
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

    protected String onTestValueRule_DEFNameMaxLength_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_DENameMaxLength_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_IgnoreDefaultFields_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
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

    protected String onTestValueRule_PSDCModelTemplId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDCMODELTEMPLID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDCModelTemplName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDCMODELTEMPLNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDCMTDEFsCnt_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_PSDevCenterId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEVCENTERID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDevCenterName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEVCENTERNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDevSlnId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEVSLNID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDevSlnName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEVSLNNAME", iEntity, bl2, null, false, 60, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_TablePrefix_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("TABLEPREFIX", iEntity, bl2, null, false, 30, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_TablePrefixFlag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
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

    protected String onTestValueRule_View2Prefix_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("VIEW2PREFIX", iEntity, bl2, null, false, 30, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_View3Prefix_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("VIEW3PREFIX", iEntity, bl2, null, false, 30, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_View4Prefix_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("VIEW4PREFIX", iEntity, bl2, null, false, 30, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_ViewPrefix_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("VIEWPREFIX", iEntity, bl2, null, false, 30, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_ViewPrefixFlag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    @Override
    protected boolean isPrepareLastForUpdate() {
        return true;
    }

    protected boolean onMergeChild(String string, String string2, PSDCModelTempl pSDCModelTempl) throws Exception {
        boolean bl = false;
        if ((StringHelper.isNullOrEmpty((String)string) || (StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDCMTDEF_PSDCMODELTEMPL_PSDCMODELTEMPLID", (boolean)true) == 0) && this.onMergeChild_PSDCMTDEFs(pSDCModelTempl)) {
            bl = true;
        }
        if (super.onMergeChild(string, string2, pSDCModelTempl)) {
            bl = true;
        }
        return bl;
    }

    protected boolean onMergeChild_PSDCMTDEFs(PSDCModelTempl pSDCModelTempl) throws Exception {
        SelectContext selectContext = new SelectContext();
        SelectField selectField = new SelectField();
        selectField.setAlias("PSDCMTDEFSCNT");
        selectField.setFunc("COUNT");
        selectContext.addSelectField((ISelectField)selectField);
        String string = DataObject.getStringValue((Object)pSDCModelTempl.getPSDCModelTemplId());
        IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.devcenter.service.PSDCMTDEFService", (SessionFactory)this.getSessionFactory());
        selectContext.set("PSDCMODELTEMPLID", (Object)pSDCModelTempl.getPSDCModelTemplId());
        ArrayList<? extends IEntity> arrayList = null;
        arrayList = string.indexOf("SRFTEMPKEY:") == 0 ? iService.selectTemp((ISelectCond)selectContext) : iService.select((ISelectCond)selectContext);
        if (arrayList.size() == 0) {
            throw new Exception("\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u6570\u636e");
        }
        IEntity iEntity = arrayList.get(0);
        iEntity.copyTo((IDataObject)pSDCModelTempl, false);
        return true;
    }

    protected void onUpdateParent(PSDCModelTempl pSDCModelTempl) throws Exception {
        super.onUpdateParent(pSDCModelTempl);
    }

    protected void onCopyDetails(PSDCModelTempl pSDCModelTempl, Object object) throws Exception {
        Object object2;
        PSDCModelTempl pSDCModelTempl2 = new PSDCModelTempl();
        pSDCModelTempl2.set("PSDCMODELTEMPLID", object);
        String string = DataObject.getStringValue((Object)pSDCModelTempl.get("PSDCMODELTEMPLID"));
        PSCoreSysServiceBase pSCoreSysServiceBase = (PSDCMTDEFService)ServiceGlobal.getService(PSDCMTDEFService.class, (SessionFactory)this.getSessionFactory());
        ArrayList<? extends EntityBase> arrayList = ((PSDCMTDEFServiceBase)pSCoreSysServiceBase).selectByPSDCModelTempl(pSDCModelTempl2);
        for (EntityBase entityBase : arrayList) {
            object2 = entityBase.get("PSDCMTDEFID");
            pSCoreSysServiceBase.getDraftFrom(entityBase);
            pSCoreSysServiceBase.fillParentInfo(entityBase, "DER1N", "DER1N_PSDCMTDEF_PSDCMODELTEMPL_PSDCMODELTEMPLID", string);
            pSCoreSysServiceBase.create(entityBase);
            pSCoreSysServiceBase.copyDetails(entityBase, object2);
        }
        pSCoreSysServiceBase = (PSDCMTDECatService)ServiceGlobal.getService(PSDCMTDECatService.class, (SessionFactory)this.getSessionFactory());
        arrayList = ((PSDCMTDECatServiceBase)pSCoreSysServiceBase).selectByPSDCModelTempl(pSDCModelTempl2);
        for (EntityBase entityBase : arrayList) {
            object2 = entityBase.get("PSDCMTDECATID");
            pSCoreSysServiceBase.getDraftFrom(entityBase);
            pSCoreSysServiceBase.fillParentInfo(entityBase, "DER1N", "DER1N_PSDCMTDECAT_PSDCMODELTEMPL_PSDCMODELTEMPLID", string);
            pSCoreSysServiceBase.create(entityBase);
            pSCoreSysServiceBase.copyDetails(entityBase, object2);
        }
        super.onCopyDetails(pSDCModelTempl, object);
    }

    @Override
    protected void exportCurXmlModel(PSDCModelTempl pSDCModelTempl, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSDCMODELTEMPL");
        if (!bl) {
            pSDCModelTempl.setCreateDate(null);
            pSDCModelTempl.setCreateMan(null);
            pSDCModelTempl.setPSDCModelTemplId(null);
            pSDCModelTempl.setPSDCMTDEFsCnt(null);
            pSDCModelTempl.setPSDevSlnName(null);
            pSDCModelTempl.setUpdateDate(null);
            pSDCModelTempl.setUpdateMan(null);
            super.exportCurXmlModel(pSDCModelTempl, xmlNode, bl);
        }
    }

    protected boolean isExportRelatedModelV2(String string) {
        if (StringHelper.compare((String)"DER1N_PSDCMTDEF_PSDCMODELTEMPL_PSDCMODELTEMPLID", (String)string, (boolean)true) == 0) {
            return this.getExportCurModelV2Level() >= 60;
        }
        return true;
    }

    @Override
    protected void onExportRelatedModelV2(PSDCModelTempl pSDCModelTempl, String string, String string2) throws Exception {
        File file = null;
        if (this.isExportRelatedModelV2("DER1N_PSDCMTDEF_PSDCMODELTEMPL_PSDCMODELTEMPLID") && (file = new File(StringHelper.format((String)"%1$s%2$s%3$s%2$sPSDCMODELTEMPL#%4$s#ALL.txt", (Object)string2, (Object)File.separator, (Object)"PSDCMTDEF", (Object)pSDCModelTempl.getPSDCModelTemplId()))).exists()) {
            PSDCMTDEFService pSDCMTDEFService = (PSDCMTDEFService)ServiceGlobal.getService(PSDCMTDEFService.class, (SessionFactory)this.getSessionFactory());
            String string3 = pSDCMTDEFService.getModelV2Name(false);
            String string4 = string + File.separator + string3;
            File file2 = new File(string4);
            if (!file2.exists()) {
                file2.mkdirs();
            }
            ArrayList<String> arrayList = PSModelV2Helper.readFile2(file);
            for (String string5 : arrayList) {
                if (StringHelper.isNullOrEmpty((String)string5)) continue;
                ObjectNode objectNode = (ObjectNode)JsonNodeHelper.fromString((String)string5);
                PSDCMTDEF pSDCMTDEF = new PSDCMTDEF();
                PSModelV2Helper.fromJSONObject((IDataObject)pSDCMTDEF, objectNode, false);
                String string6 = pSDCMTDEFService.getModelV2Tag(pSDCMTDEF);
                if (StringHelper.isNullOrEmpty((String)string6)) {
                    throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u8ba1\u7b97\u6a21\u578b[%1$s][%2$s]\u6807\u8bb0", (Object)"PSDCMTDEF", (Object)pSDCMTDEF.getPSDCMTDEFId()));
                }
                string6 = PSModelV2Helper.getModelV2TagFolderName(string6);
                file2 = new File(string4 + File.separator + string6);
                if (!file2.exists()) {
                    file2.mkdirs();
                }
                pSDCMTDEFService.exportModelV2(pSDCMTDEF, string4 + File.separator + string6, string2);
            }
        }
        super.onExportRelatedModelV2(pSDCModelTempl, string, string2);
    }

    @Override
    protected void onExportCurModelV2(PSDCModelTempl pSDCModelTempl, ObjectNode objectNode, String string, boolean bl) throws Exception {
        File file = null;
        if (bl || !this.isExportRelatedModelV2("DER1N_PSDCMTDEF_PSDCMODELTEMPL_PSDCMODELTEMPLID")) {
            PSDCMTDEFService pSDCMTDEFService = (PSDCMTDEFService)ServiceGlobal.getService(PSDCMTDEFService.class, (SessionFactory)this.getSessionFactory());
            ArrayList<ObjectNode> arrayList = null;
            if (!StringHelper.isNullOrEmpty((String)string)) {
                file = new File(StringHelper.format((String)"%1$s%2$s%3$s%2$sPSDCMODELTEMPL#%4$s#ALL.txt", (Object)string, (Object)File.separator, (Object)"PSDCMTDEF", (Object)pSDCModelTempl.getPSDCModelTemplId()));
                if (file.exists()) {
                    arrayList = new ArrayList<ObjectNode>();
                    for (String line : PSModelV2Helper.readFile2(file)) {
                        if (StringHelper.isNullOrEmpty((String)line)) continue;
                        arrayList.add((ObjectNode)JsonNodeHelper.fromString(line));
                    }
                }
            } else {
                arrayList = new ArrayList<ObjectNode>();
                String scope = StringHelper.format((String)"PSDCMODELTEMPL#%1$s", (Object)pSDCModelTempl.getPSDCModelTemplId());
                for (PSDCMTDEF child : pSDCMTDEFService.selectByPSDCModelTempl(pSDCModelTempl)) {
                    if (StringHelper.compare((String)scope, (String)pSDCMTDEFService.getModelV2ResScope(child), (boolean)false) != 0) continue;
                    arrayList.add(PSModelV2Helper.toJSONObject(child, false));
                }
            }
            if (arrayList != null && arrayList.size() > 0) {
                ArrayNode childNodes = objectNode.putArray(pSDCMTDEFService.getModelV2Name(false).toLowerCase());
                Collections.sort(arrayList, new Comparator<ObjectNode>(){

                    @Override
                    public int compare(ObjectNode objectNode, ObjectNode objectNode2) {
                        int n;
                        int n2 = 1000;
                        int n3 = 1000;
                        if (objectNode.has("ordervalue")) {
                            n2 = objectNode.get("ordervalue").asInt();
                        }
                        if (objectNode2.has("ordervalue")) {
                            n3 = objectNode2.get("ordervalue").asInt();
                        }
                        if ((n = n2 - n3) != 0) {
                            return n;
                        }
                        String string = null;
                        String string2 = null;
                        if (objectNode.has("psdcmtdefname")) {
                            string = objectNode.get("psdcmtdefname").asText();
                        }
                        if (objectNode2.has("psdcmtdefname")) {
                            string2 = objectNode2.get("psdcmtdefname").asText();
                        }
                        return StringHelper.compare((String)string, string2, (boolean)false);
                    }
                });
                for (ObjectNode childNode : arrayList) {
                    PSDCMTDEF child = new PSDCMTDEF();
                    PSModelV2Helper.fromJSONObject((IDataObject)child, childNode, false);
                    childNodes.add((JsonNode)pSDCMTDEFService.exportModelV2(child, string));
                }
            }
        }
        super.onExportCurModelV2(pSDCModelTempl, objectNode, string, bl);
    }

    @Override
    protected void onEmptyModelV2(PSDCModelTempl pSDCModelTempl) throws Exception {
        super.onEmptyModelV2(pSDCModelTempl);
    }

    @Override
    protected boolean onContainsRelatedModelV2Entity(String string, int n) throws Exception {
        PSDCMTDEFService pSDCMTDEFService = (PSDCMTDEFService)ServiceGlobal.getService(PSDCMTDEFService.class, (SessionFactory)this.getSessionFactory());
        if (pSDCMTDEFService.containsModelV2Entity(string, n)) {
            return true;
        }
        return super.onContainsRelatedModelV2Entity(string, n);
    }

    @Override
    protected IEntity onGetRelatedModelV2Entity(PSDCModelTempl pSDCModelTempl, String string, String string2) throws Exception {
        IEntity iEntity = null;
        PSDCMTDEF pSDCMTDEF = new PSDCMTDEF();
        pSDCMTDEF.set("PSDCMODELTEMPLID", pSDCModelTempl.getPSDCModelTemplId());
        PSDCMTDEFService pSDCMTDEFService = (PSDCMTDEFService)ServiceGlobal.getService(PSDCMTDEFService.class, (SessionFactory)this.getSessionFactory());
        iEntity = pSDCMTDEFService.getModelV2Entity(pSDCMTDEF, string, string2);
        if (iEntity != null) {
            return iEntity;
        }
        return super.onGetRelatedModelV2Entity(pSDCModelTempl, string, string2);
    }

    @Override
    protected void onCompileRelatedModelV2(PSDCModelTempl pSDCModelTempl, ObjectNode objectNode, String string, String string2, int n) throws Exception {
        if (!PSDCModelTemplServiceBase.isSimpleImportExportMode("")) {
            PSDCMTDEFService pSDCMTDEFService = (PSDCMTDEFService)ServiceGlobal.getService(PSDCMTDEFService.class, (SessionFactory)this.getSessionFactory());
            ArrayNode arrayNode = null;
            String string3 = pSDCMTDEFService.getModelV2Name(null, false);
            if (objectNode != null) {
                arrayNode = JsonNodeHelper.getArray((ObjectNode)objectNode, (String)string3.toLowerCase());
            }
            if (arrayNode != null) {
                for (int i = 0; i < arrayNode.size(); ++i) {
                    ObjectNode objectNode2 = (ObjectNode)arrayNode.get(i);
                    PSDCMTDEF pSDCMTDEF = new PSDCMTDEF();
                    pSDCMTDEF.setPSDCModelTemplId(pSDCModelTempl.getPSDCModelTemplId());
                    pSDCMTDEF.setPSDCModelTemplName(pSDCModelTempl.getPSDCModelTemplName());
                    pSDCMTDEFService.compileModelV2(pSDCMTDEF, objectNode2, string, null, n);
                }
            } else {
                String string4 = StringHelper.format((String)"%1$s%2$s%3$s", (Object)string2, (Object)File.separator, (Object)string3);
                File file = new File(string4);
                if (file.exists()) {
                    File[] fileArray;
                    for (File file2 : fileArray = file.listFiles()) {
                        if (!file2.isDirectory()) continue;
                        PSDCMTDEF pSDCMTDEF = new PSDCMTDEF();
                        pSDCMTDEF.setPSDCModelTemplId(pSDCModelTempl.getPSDCModelTemplId());
                        pSDCMTDEF.setPSDCModelTemplName(pSDCModelTempl.getPSDCModelTemplName());
                        pSDCMTDEFService.compileModelV2(pSDCMTDEF, null, string, file2.getCanonicalPath(), n);
                    }
                }
            }
        }
        super.onCompileRelatedModelV2(pSDCModelTempl, objectNode, string, string2, n);
    }

    @Override
    protected PSMOSFile onPasteFile(PSDCModelTempl pSDCModelTempl, PSMOSFile pSMOSFile, String string, IPSMOSFileAction iPSMOSFileAction) throws Exception {
        PSMOSFile pSMOSFile2 = null;
        if ((StringHelper.isNullOrEmpty((String)string) || StringHelper.compare((String)string, (String)"DER1N_PSDCMTDEF_PSDCMODELTEMPL_PSDCMODELTEMPLID", (boolean)true) == 0) && (pSMOSFile2 = this.onPasteFile_PSDCMTDEFs(pSDCModelTempl, pSMOSFile, iPSMOSFileAction)) != null) {
            return pSMOSFile2;
        }
        return super.onPasteFile(pSDCModelTempl, pSMOSFile, string, iPSMOSFileAction);
    }

    protected PSMOSFile onPasteFile_PSDCMTDEFs(PSDCModelTempl pSDCModelTempl, PSMOSFile pSMOSFile, IPSMOSFileAction iPSMOSFileAction) throws Exception {
        if (StringHelper.compare((String)pSMOSFile.getPSModelType(), (String)PSModelV2Helper.getModelV2Name("PSDCMTDEF", true), (boolean)false) == 0) {
            PSDCMTDEFService pSDCMTDEFService = (PSDCMTDEFService)ServiceGlobal.getService(PSDCMTDEFService.class, (SessionFactory)this.getSessionFactory());
            PSDCMTDEF pSDCMTDEF = new PSDCMTDEF();
            pSDCMTDEF.setPSDCMTDEFId(pSMOSFile.getPSModelId());
            if (!pSDCMTDEFService.get(pSDCMTDEF, true)) {
                throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u83b7\u53d6\u6a21\u578b[%1$s|%2$s]", (Object)pSMOSFile.getPSMOSFileId(), (Object)pSMOSFile.getPSModelId()));
            }
            if (StringHelper.compare((String)pSDCMTDEF.getPSDCModelTemplId(), (String)pSDCModelTempl.getPSDCModelTemplId(), (boolean)false) == 0) {
                throw new Exception(StringHelper.format((String)"\u76ee\u6807\u8def\u5f84\u4e0e\u6e90\u8def\u5f84\u4e00\u81f4"));
            }
            ObjectNode objectNode = pSDCMTDEFService.exportModelV2(pSDCMTDEF);
            pSDCMTDEF.reset();
            if (!pSDCMTDEFService.setModelV2ResScope(pSDCMTDEF, "PSDCMODELTEMPL", pSDCModelTempl.getPSDCModelTemplId())) {
                throw new Exception("\u65e0\u6cd5\u8bbe\u7f6e\u6a21\u578b\u57df");
            }
            pSDCMTDEFService.importModelV2(pSDCMTDEF, objectNode);
            SessionFactoryManager.commit();
            return pSDCMTDEFService.getFile(pSDCMTDEF);
        }
        return null;
    }

    @Override
    protected void onFillPasteHelps(PSDCModelTempl pSDCModelTempl, List<PSHelpSection> list) throws Exception {
        this.onFillPasteHelps_PSDCMTDEFs(pSDCModelTempl, list);
        super.onFillPasteHelps(pSDCModelTempl, list);
    }

    protected void onFillPasteHelps_PSDCMTDEFs(PSDCModelTempl pSDCModelTempl, List<PSHelpSection> list) throws Exception {
        PSHelpSection pSHelpSection = new PSHelpSection();
        pSHelpSection.setSectionType("USER");
        pSHelpSection.setSectionParam("PSDCMTDEF");
        pSHelpSection.setSectionParam2("DER1N_PSDCMTDEF_PSDCMODELTEMPL_PSDCMODELTEMPLID");
        pSHelpSection.setContent("\u7c98\u8d34\u5176\u5b83[\u5e94\u7528\u4e2d\u5fc3\u6a21\u578b\u6a21\u677f]\u7684[\u6a21\u578b\u6a21\u677f\u9884\u7f6e\u5c5e\u6027]");
        list.add(pSHelpSection);
    }
}
