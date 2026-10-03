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
 *  net.ibizsys.paas.demodel.IDataEntityModel
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
package net.ibizsys.pscore.srv.bidesign.service;

import java.util.ArrayList;
import javax.annotation.PostConstruct;
import net.ibizsys.paas.core.IDEDataSetFetchContext;
import net.ibizsys.paas.dao.DAOGlobal;
import net.ibizsys.paas.dao.IDAO;
import net.ibizsys.paas.db.DBFetchResult;
import net.ibizsys.paas.db.ISelectCond;
import net.ibizsys.paas.db.SelectCond;
import net.ibizsys.paas.demodel.DEModelGlobal;
import net.ibizsys.paas.demodel.IDataEntityModel;
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
import net.ibizsys.pscore.srv.bidesign.dao.PSSysBICubeMSCondDAO;
import net.ibizsys.pscore.srv.bidesign.demodel.PSSysBICubeMSCondDEModel;
import net.ibizsys.pscore.srv.bidesign.entity.PSSysBICubeMSCond;
import net.ibizsys.pscore.srv.bidesign.entity.PSSysBICubeMSCondBase;
import net.ibizsys.pscore.srv.bidesign.entity.PSSysBICubeMeasure;
import net.ibizsys.pscore.srv.bidesign.entity.PSSysBICubeMeasureBase;
import net.ibizsys.pscore.srv.bidesign.service.PSSysBICubeMSCondService;
import net.ibizsys.pscore.srv.config.entity.PSDBValueOP;
import net.ibizsys.pscore.srv.config.entity.PSDBValueOPBase;
import net.ibizsys.pscore.srv.config.entity.PSVarType;
import net.ibizsys.pscore.srv.config.entity.PSVarTypeBase;
import net.ibizsys.pscore.srv.core.IPSDataEntityModel;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEField;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEFieldBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysDBVF;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysDBVFBase;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSSysBICubeMSCondServiceBase
extends PSCoreSysServiceBase<PSSysBICubeMSCond> {
    private static final Log log = LogFactory.getLog(PSSysBICubeMSCondServiceBase.class);
    public static final String DATASET_DEFAULT = "DEFAULT";
    private PSSysBICubeMSCondDEModel pSSysBICubeMSCondDEModel;
    private PSSysBICubeMSCondDAO pSSysBICubeMSCondDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.bidesign.service.PSSysBICubeMSCondService";
    }

    public PSSysBICubeMSCondDEModel getPSSysBICubeMSCondDEModel() {
        if (this.pSSysBICubeMSCondDEModel == null) {
            try {
                this.pSSysBICubeMSCondDEModel = (PSSysBICubeMSCondDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.bidesign.demodel.PSSysBICubeMSCondDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSSysBICubeMSCondDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSSysBICubeMSCondDEModel();
    }

    public PSSysBICubeMSCondDAO getPSSysBICubeMSCondDAO() {
        if (this.pSSysBICubeMSCondDAO == null) {
            try {
                this.pSSysBICubeMSCondDAO = (PSSysBICubeMSCondDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.bidesign.dao.PSSysBICubeMSCondDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSSysBICubeMSCondDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSSysBICubeMSCondDAO();
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

    protected void onFillParentInfo(PSSysBICubeMSCond pSSysBICubeMSCond, String string, String string2, String string3) throws Exception {
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSBICUBEMSCOND_PSDBVALUEOP_PSDBVALUEOPID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.config.service.PSDBValueOPService", (SessionFactory)this.getSessionFactory());
            PSDBValueOP pSDBValueOP = (PSDBValueOP)iService.getDEModel().createEntity();
            pSDBValueOP.set("PSDBVALUEOPID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDBValueOP);
            } else {
                iService.get(pSDBValueOP);
            }
            this.onFillParentInfo_PSDBValueOP(pSSysBICubeMSCond, pSDBValueOP);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSBICUBEMSCOND_PSDEFIELD_PSDEFID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEFieldService", (SessionFactory)this.getSessionFactory());
            PSDEField pSDEField = (PSDEField)iService.getDEModel().createEntity();
            pSDEField.set("PSDEFIELDID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDEField);
            } else {
                iService.get(pSDEField);
            }
            this.onFillParentInfo_PSDEF(pSSysBICubeMSCond, pSDEField);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSBICUBEMSCOND_PSSYSBICUBEMEASURE_PSSYSBICUBEMEASUREID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.bidesign.service.PSSysBICubeMeasureService", (SessionFactory)this.getSessionFactory());
            PSSysBICubeMeasure pSSysBICubeMeasure = (PSSysBICubeMeasure)iService.getDEModel().createEntity();
            pSSysBICubeMeasure.set("PSSYSBICUBEMEASUREID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSSysBICubeMeasure);
            } else {
                iService.get(pSSysBICubeMeasure);
            }
            this.onFillParentInfo_PSSysBICubeMeasure(pSSysBICubeMSCond, pSSysBICubeMeasure);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSBICUBEMSCOND_PSSYSBICUBEMSCOND_PPSSYSBICUBEMSCONDID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.bidesign.service.PSSysBICubeMSCondService", (SessionFactory)this.getSessionFactory());
            PSSysBICubeMSCond pSSysBICubeMSCond2 = (PSSysBICubeMSCond)iService.getDEModel().createEntity();
            pSSysBICubeMSCond2.set("PSSYSBICUBEMSCONDID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSSysBICubeMSCond2);
            } else {
                iService.get(pSSysBICubeMSCond2);
            }
            this.onFillParentInfo_PPSSysBICubeMSCond(pSSysBICubeMSCond, pSSysBICubeMSCond2);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSBICUBEMSCOND_PSSYSDBVF_PSSYSDBVFID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysDBVFService", (SessionFactory)this.getSessionFactory());
            PSSysDBVF pSSysDBVF = (PSSysDBVF)iService.getDEModel().createEntity();
            pSSysDBVF.set("PSSYSDBVFID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSSysDBVF);
            } else {
                iService.get(pSSysDBVF);
            }
            this.onFillParentInfo_PSSysDBVF(pSSysBICubeMSCond, pSSysDBVF);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSBICUBEMSCOND_PSVARTYPE_PSVARTYPEID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.config.service.PSVarTypeService", (SessionFactory)this.getSessionFactory());
            PSVarType pSVarType = (PSVarType)iService.getDEModel().createEntity();
            pSVarType.set("PSVARTYPEID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSVarType);
            } else {
                iService.get(pSVarType);
            }
            this.onFillParentInfo_PSVarType(pSSysBICubeMSCond, pSVarType);
            return;
        }
        super.onFillParentInfo(pSSysBICubeMSCond, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillParentInfo_PSDBValueOP(PSSysBICubeMSCond pSSysBICubeMSCond, PSDBValueOP pSDBValueOP) throws Exception {
        pSSysBICubeMSCond.setPSDBValueOPId(pSDBValueOP.getPSDBValueOPId());
        pSSysBICubeMSCond.setPSDBValueOPName(pSDBValueOP.getPSDBValueOPName());
    }

    protected void onFillParentInfo_PSDEF(PSSysBICubeMSCond pSSysBICubeMSCond, PSDEField pSDEField) throws Exception {
        pSSysBICubeMSCond.setPSDEFId(pSDEField.getPSDEFieldId());
        pSSysBICubeMSCond.setPSDEFName(pSDEField.getPSDEFieldName());
    }

    protected void onFillParentInfo_PSSysBICubeMeasure(PSSysBICubeMSCond pSSysBICubeMSCond, PSSysBICubeMeasure pSSysBICubeMeasure) throws Exception {
        pSSysBICubeMSCond.setPSSysBICubeMeasureId(pSSysBICubeMeasure.getPSSysBICubeMeasureId());
        pSSysBICubeMSCond.setPSSysBICubeMeasureName(pSSysBICubeMeasure.getPSSysBICubeMeasureName());
    }

    protected void onFillParentInfo_PPSSysBICubeMSCond(PSSysBICubeMSCond pSSysBICubeMSCond, PSSysBICubeMSCond pSSysBICubeMSCond2) throws Exception {
        pSSysBICubeMSCond.setPPSSysBICubeMSCondId(pSSysBICubeMSCond2.getPSSysBICubeMSCondId());
        pSSysBICubeMSCond.setPPSSysBICubeMSCondName(pSSysBICubeMSCond2.getPSSysBICubeMSCondName());
    }

    protected void onFillParentInfo_PSSysDBVF(PSSysBICubeMSCond pSSysBICubeMSCond, PSSysDBVF pSSysDBVF) throws Exception {
        pSSysBICubeMSCond.setPSSysDBVFId(pSSysDBVF.getPSSysDBVFId());
        pSSysBICubeMSCond.setPSSysDBVFName(pSSysDBVF.getPSSysDBVFName());
    }

    protected void onFillParentInfo_PSVarType(PSSysBICubeMSCond pSSysBICubeMSCond, PSVarType pSVarType) throws Exception {
        pSSysBICubeMSCond.setPSVarTypeId(pSVarType.getPSVarTypeId());
        pSSysBICubeMSCond.setPSVARTypeName(pSVarType.getPSVarTypeName());
    }

    protected void onFillEntityFullInfo(PSSysBICubeMSCond pSSysBICubeMSCond, boolean bl) throws Exception {
        if (bl) {
            // empty if block
        }
        super.onFillEntityFullInfo(pSSysBICubeMSCond, bl);
        this.onFillEntityFullInfo_PSDBValueOP(pSSysBICubeMSCond, bl);
        this.onFillEntityFullInfo_PSDEF(pSSysBICubeMSCond, bl);
        this.onFillEntityFullInfo_PSSysBICubeMeasure(pSSysBICubeMSCond, bl);
        this.onFillEntityFullInfo_PPSSysBICubeMSCond(pSSysBICubeMSCond, bl);
        this.onFillEntityFullInfo_PSSysDBVF(pSSysBICubeMSCond, bl);
        this.onFillEntityFullInfo_PSVarType(pSSysBICubeMSCond, bl);
    }

    protected void onFillEntityFullInfo_PSDBValueOP(PSSysBICubeMSCond pSSysBICubeMSCond, boolean bl) throws Exception {
        if (pSSysBICubeMSCond.isPSDBValueOPIdDirty()) {
            if (pSSysBICubeMSCond.getPSDBValueOPId() != null) {
                if (pSSysBICubeMSCond.getPSDBValueOPId() == null || pSSysBICubeMSCond.getPSDBValueOPName() == null) {
                    PSDBValueOP pSDBValueOP = pSSysBICubeMSCond.getPSDBValueOP();
                    pSSysBICubeMSCond.setPSDBValueOPName(pSDBValueOP.getPSDBValueOPName());
                }
            } else {
                pSSysBICubeMSCond.setPSDBValueOPName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_PSDEF(PSSysBICubeMSCond pSSysBICubeMSCond, boolean bl) throws Exception {
        if (pSSysBICubeMSCond.isPSDEFIdDirty()) {
            if (pSSysBICubeMSCond.getPSDEFId() != null) {
                if (pSSysBICubeMSCond.getPSDEFId() == null || pSSysBICubeMSCond.getPSDEFName() == null) {
                    PSDEField pSDEField = pSSysBICubeMSCond.getPSDEF();
                    pSSysBICubeMSCond.setPSDEFName(pSDEField.getPSDEFieldName());
                }
            } else {
                pSSysBICubeMSCond.setPSDEFName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_PSSysBICubeMeasure(PSSysBICubeMSCond pSSysBICubeMSCond, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PPSSysBICubeMSCond(PSSysBICubeMSCond pSSysBICubeMSCond, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSSysDBVF(PSSysBICubeMSCond pSSysBICubeMSCond, boolean bl) throws Exception {
        if (pSSysBICubeMSCond.isPSSysDBVFIdDirty()) {
            if (pSSysBICubeMSCond.getPSSysDBVFId() != null) {
                if (pSSysBICubeMSCond.getPSSysDBVFId() == null || pSSysBICubeMSCond.getPSSysDBVFName() == null) {
                    PSSysDBVF pSSysDBVF = pSSysBICubeMSCond.getPSSysDBVF();
                    pSSysBICubeMSCond.setPSSysDBVFName(pSSysDBVF.getPSSysDBVFName());
                }
            } else {
                pSSysBICubeMSCond.setPSSysDBVFName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_PSVarType(PSSysBICubeMSCond pSSysBICubeMSCond, boolean bl) throws Exception {
        if (pSSysBICubeMSCond.isPSVarTypeIdDirty()) {
            if (pSSysBICubeMSCond.getPSVarTypeId() != null) {
                if (pSSysBICubeMSCond.getPSVarTypeId() == null || pSSysBICubeMSCond.getPSVARTypeName() == null) {
                    PSVarType pSVarType = pSSysBICubeMSCond.getPSVarType();
                    pSSysBICubeMSCond.setPSVARTypeName(pSVarType.getPSVarTypeName());
                }
            } else {
                pSSysBICubeMSCond.setPSVARTypeName(null);
            }
        }
    }

    protected void onWriteBackParent(PSSysBICubeMSCond pSSysBICubeMSCond, boolean bl) throws Exception {
        super.onWriteBackParent(pSSysBICubeMSCond, bl);
    }

    public ArrayList<PSSysBICubeMSCond> selectByPSDBValueOP(PSDBValueOPBase pSDBValueOPBase) throws Exception {
        return this.selectByPSDBValueOP(pSDBValueOPBase, "", -1);
    }

    public ArrayList<PSSysBICubeMSCond> selectByPSDBValueOP(PSDBValueOPBase pSDBValueOPBase, String string) throws Exception {
        return this.selectByPSDBValueOP(pSDBValueOPBase, string, -1);
    }

    public ArrayList<PSSysBICubeMSCond> selectByPSDBValueOP(PSDBValueOPBase pSDBValueOPBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDBVALUEOPID", (Object)pSDBValueOPBase.getPSDBValueOPId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSDBValueOPCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSDBValueOPCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSSysBICubeMSCond> selectByPSDEF(PSDEFieldBase pSDEFieldBase) throws Exception {
        return this.selectByPSDEF(pSDEFieldBase, "", -1);
    }

    public ArrayList<PSSysBICubeMSCond> selectByPSDEF(PSDEFieldBase pSDEFieldBase, String string) throws Exception {
        return this.selectByPSDEF(pSDEFieldBase, string, -1);
    }

    public ArrayList<PSSysBICubeMSCond> selectByPSDEF(PSDEFieldBase pSDEFieldBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDEFID", (Object)pSDEFieldBase.getPSDEFieldId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSDEFCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSDEFCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSSysBICubeMSCond> selectByPSSysBICubeMeasure(PSSysBICubeMeasureBase pSSysBICubeMeasureBase) throws Exception {
        return this.selectByPSSysBICubeMeasure(pSSysBICubeMeasureBase, "", -1);
    }

    public ArrayList<PSSysBICubeMSCond> selectByPSSysBICubeMeasure(PSSysBICubeMeasureBase pSSysBICubeMeasureBase, String string) throws Exception {
        return this.selectByPSSysBICubeMeasure(pSSysBICubeMeasureBase, string, -1);
    }

    public ArrayList<PSSysBICubeMSCond> selectByPSSysBICubeMeasure(PSSysBICubeMeasureBase pSSysBICubeMeasureBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSSYSBICUBEMEASUREID", (Object)pSSysBICubeMeasureBase.getPSSysBICubeMeasureId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSSysBICubeMeasureCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSSysBICubeMeasureCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSSysBICubeMSCond> selectByPPSSysBICubeMSCond(PSSysBICubeMSCondBase pSSysBICubeMSCondBase) throws Exception {
        return this.selectByPPSSysBICubeMSCond(pSSysBICubeMSCondBase, "", -1);
    }

    public ArrayList<PSSysBICubeMSCond> selectByPPSSysBICubeMSCond(PSSysBICubeMSCondBase pSSysBICubeMSCondBase, String string) throws Exception {
        return this.selectByPPSSysBICubeMSCond(pSSysBICubeMSCondBase, string, -1);
    }

    public ArrayList<PSSysBICubeMSCond> selectByPPSSysBICubeMSCond(PSSysBICubeMSCondBase pSSysBICubeMSCondBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PPSSYSBICUBEMSCONDID", (Object)pSSysBICubeMSCondBase.getPSSysBICubeMSCondId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPPSSysBICubeMSCondCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPPSSysBICubeMSCondCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSSysBICubeMSCond> selectByPSSysDBVF(PSSysDBVFBase pSSysDBVFBase) throws Exception {
        return this.selectByPSSysDBVF(pSSysDBVFBase, "", -1);
    }

    public ArrayList<PSSysBICubeMSCond> selectByPSSysDBVF(PSSysDBVFBase pSSysDBVFBase, String string) throws Exception {
        return this.selectByPSSysDBVF(pSSysDBVFBase, string, -1);
    }

    public ArrayList<PSSysBICubeMSCond> selectByPSSysDBVF(PSSysDBVFBase pSSysDBVFBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSSYSDBVFID", (Object)pSSysDBVFBase.getPSSysDBVFId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSSysDBVFCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSSysDBVFCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSSysBICubeMSCond> selectByPSVarType(PSVarTypeBase pSVarTypeBase) throws Exception {
        return this.selectByPSVarType(pSVarTypeBase, "", -1);
    }

    public ArrayList<PSSysBICubeMSCond> selectByPSVarType(PSVarTypeBase pSVarTypeBase, String string) throws Exception {
        return this.selectByPSVarType(pSVarTypeBase, string, -1);
    }

    public ArrayList<PSSysBICubeMSCond> selectByPSVarType(PSVarTypeBase pSVarTypeBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSVARTYPEID", (Object)pSVarTypeBase.getPSVarTypeId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSVarTypeCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSVarTypeCond(SelectCond selectCond) throws Exception {
    }

    public void testRemoveByPSDBValueOP(PSDBValueOP pSDBValueOP) throws Exception {
        ArrayList<PSSysBICubeMSCond> arrayList = this.selectByPSDBValueOP(pSDBValueOP, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDBVALUEOP");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDBValueOP);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSBICUBEMSCOND_PSDBVALUEOP_PSDBVALUEOPID", "", iDataEntityModel.getName(), "PSSYSBICUBEMSCOND", iDataEntityModel.getDataInfo(pSDBValueOP), arrayList.get(0)));
        }
    }

    public void resetPSDBValueOP(PSDBValueOP pSDBValueOP) throws Exception {
        ArrayList<PSSysBICubeMSCond> arrayList = this.selectByPSDBValueOP(pSDBValueOP);
        for (PSSysBICubeMSCond pSSysBICubeMSCond : arrayList) {
            PSSysBICubeMSCond pSSysBICubeMSCond2 = (PSSysBICubeMSCond)this.getDEModel().createEntity();
            pSSysBICubeMSCond2.setPSSysBICubeMSCondId(pSSysBICubeMSCond.getPSSysBICubeMSCondId());
            pSSysBICubeMSCond2.setPSDBValueOPId(null);
            this.update(pSSysBICubeMSCond2);
        }
    }

    public void removeByPSDBValueOP(PSDBValueOP pSDBValueOP) throws Exception {
        final PSDBValueOP pSDBValueOP2 = pSDBValueOP;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysBICubeMSCondServiceBase.this.onBeforeRemoveByPSDBValueOP(pSDBValueOP2);
                PSSysBICubeMSCondServiceBase.this.internalRemoveByPSDBValueOP(pSDBValueOP2);
                PSSysBICubeMSCondServiceBase.this.onAfterRemoveByPSDBValueOP(pSDBValueOP2);
            }
        });
    }

    protected void onBeforeRemoveByPSDBValueOP(PSDBValueOP pSDBValueOP) throws Exception {
    }

    protected void internalRemoveByPSDBValueOP(PSDBValueOP pSDBValueOP) throws Exception {
        ArrayList<PSSysBICubeMSCond> arrayList = this.selectByPSDBValueOP(pSDBValueOP);
        this.onBeforeRemoveByPSDBValueOP(pSDBValueOP, arrayList);
        for (PSSysBICubeMSCond pSSysBICubeMSCond : arrayList) {
            this.remove(pSSysBICubeMSCond);
        }
        this.onAfterRemoveByPSDBValueOP(pSDBValueOP, arrayList);
    }

    protected void onAfterRemoveByPSDBValueOP(PSDBValueOP pSDBValueOP) throws Exception {
    }

    protected void onBeforeRemoveByPSDBValueOP(PSDBValueOP pSDBValueOP, ArrayList<PSSysBICubeMSCond> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDBValueOP(PSDBValueOP pSDBValueOP, ArrayList<PSSysBICubeMSCond> arrayList) throws Exception {
    }

    public void testRemoveByPSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSSysBICubeMSCond> arrayList = this.selectByPSDEF(pSDEField, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEFIELD");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDEField);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSBICUBEMSCOND_PSDEFIELD_PSDEFID", "", iDataEntityModel.getName(), "PSSYSBICUBEMSCOND", iDataEntityModel.getDataInfo(pSDEField), arrayList.get(0)));
        }
    }

    public void resetPSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSSysBICubeMSCond> arrayList = this.selectByPSDEF(pSDEField);
        for (PSSysBICubeMSCond pSSysBICubeMSCond : arrayList) {
            PSSysBICubeMSCond pSSysBICubeMSCond2 = (PSSysBICubeMSCond)this.getDEModel().createEntity();
            pSSysBICubeMSCond2.setPSSysBICubeMSCondId(pSSysBICubeMSCond.getPSSysBICubeMSCondId());
            pSSysBICubeMSCond2.setPSDEFId(null);
            this.update(pSSysBICubeMSCond2);
        }
    }

    public void removeByPSDEF(PSDEField pSDEField) throws Exception {
        final PSDEField pSDEField2 = pSDEField;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysBICubeMSCondServiceBase.this.onBeforeRemoveByPSDEF(pSDEField2);
                PSSysBICubeMSCondServiceBase.this.internalRemoveByPSDEF(pSDEField2);
                PSSysBICubeMSCondServiceBase.this.onAfterRemoveByPSDEF(pSDEField2);
            }
        });
    }

    protected void onBeforeRemoveByPSDEF(PSDEField pSDEField) throws Exception {
    }

    protected void internalRemoveByPSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSSysBICubeMSCond> arrayList = this.selectByPSDEF(pSDEField);
        this.onBeforeRemoveByPSDEF(pSDEField, arrayList);
        for (PSSysBICubeMSCond pSSysBICubeMSCond : arrayList) {
            this.remove(pSSysBICubeMSCond);
        }
        this.onAfterRemoveByPSDEF(pSDEField, arrayList);
    }

    protected void onAfterRemoveByPSDEF(PSDEField pSDEField) throws Exception {
    }

    protected void onBeforeRemoveByPSDEF(PSDEField pSDEField, ArrayList<PSSysBICubeMSCond> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDEF(PSDEField pSDEField, ArrayList<PSSysBICubeMSCond> arrayList) throws Exception {
    }

    public void testRemoveByPSSysBICubeMeasure(PSSysBICubeMeasure pSSysBICubeMeasure) throws Exception {
    }

    public void resetPSSysBICubeMeasure(PSSysBICubeMeasure pSSysBICubeMeasure) throws Exception {
        ArrayList<PSSysBICubeMSCond> arrayList = this.selectByPSSysBICubeMeasure(pSSysBICubeMeasure);
        for (PSSysBICubeMSCond pSSysBICubeMSCond : arrayList) {
            PSSysBICubeMSCond pSSysBICubeMSCond2 = (PSSysBICubeMSCond)this.getDEModel().createEntity();
            pSSysBICubeMSCond2.setPSSysBICubeMSCondId(pSSysBICubeMSCond.getPSSysBICubeMSCondId());
            pSSysBICubeMSCond2.setPSSysBICubeMeasureId(null);
            this.update(pSSysBICubeMSCond2);
        }
    }

    public void removeByPSSysBICubeMeasure(PSSysBICubeMeasure pSSysBICubeMeasure) throws Exception {
        final PSSysBICubeMeasure pSSysBICubeMeasure2 = pSSysBICubeMeasure;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysBICubeMSCondServiceBase.this.onBeforeRemoveByPSSysBICubeMeasure(pSSysBICubeMeasure2);
                PSSysBICubeMSCondServiceBase.this.internalRemoveByPSSysBICubeMeasure(pSSysBICubeMeasure2);
                PSSysBICubeMSCondServiceBase.this.onAfterRemoveByPSSysBICubeMeasure(pSSysBICubeMeasure2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysBICubeMeasure(PSSysBICubeMeasure pSSysBICubeMeasure) throws Exception {
    }

    protected void internalRemoveByPSSysBICubeMeasure(PSSysBICubeMeasure pSSysBICubeMeasure) throws Exception {
        ArrayList<PSSysBICubeMSCond> arrayList = this.selectByPSSysBICubeMeasure(pSSysBICubeMeasure);
        this.onBeforeRemoveByPSSysBICubeMeasure(pSSysBICubeMeasure, arrayList);
        for (PSSysBICubeMSCond pSSysBICubeMSCond : arrayList) {
            this.remove(pSSysBICubeMSCond);
        }
        this.onAfterRemoveByPSSysBICubeMeasure(pSSysBICubeMeasure, arrayList);
    }

    protected void onAfterRemoveByPSSysBICubeMeasure(PSSysBICubeMeasure pSSysBICubeMeasure) throws Exception {
    }

    protected void onBeforeRemoveByPSSysBICubeMeasure(PSSysBICubeMeasure pSSysBICubeMeasure, ArrayList<PSSysBICubeMSCond> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysBICubeMeasure(PSSysBICubeMeasure pSSysBICubeMeasure, ArrayList<PSSysBICubeMSCond> arrayList) throws Exception {
    }

    public void testRemoveByPPSSysBICubeMSCond(PSSysBICubeMSCond pSSysBICubeMSCond) throws Exception {
    }

    public void resetPPSSysBICubeMSCond(PSSysBICubeMSCond pSSysBICubeMSCond) throws Exception {
        ArrayList<PSSysBICubeMSCond> arrayList = this.selectByPPSSysBICubeMSCond(pSSysBICubeMSCond);
        for (PSSysBICubeMSCond pSSysBICubeMSCond2 : arrayList) {
            PSSysBICubeMSCond pSSysBICubeMSCond3 = (PSSysBICubeMSCond)this.getDEModel().createEntity();
            pSSysBICubeMSCond3.setPSSysBICubeMSCondId(pSSysBICubeMSCond2.getPSSysBICubeMSCondId());
            pSSysBICubeMSCond3.setPPSSysBICubeMSCondId(null);
            this.update(pSSysBICubeMSCond3);
        }
    }

    public void removeByPPSSysBICubeMSCond(PSSysBICubeMSCond pSSysBICubeMSCond) throws Exception {
        final PSSysBICubeMSCond pSSysBICubeMSCond2 = pSSysBICubeMSCond;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysBICubeMSCondServiceBase.this.onBeforeRemoveByPPSSysBICubeMSCond(pSSysBICubeMSCond2);
                PSSysBICubeMSCondServiceBase.this.internalRemoveByPPSSysBICubeMSCond(pSSysBICubeMSCond2);
                PSSysBICubeMSCondServiceBase.this.onAfterRemoveByPPSSysBICubeMSCond(pSSysBICubeMSCond2);
            }
        });
    }

    protected void onBeforeRemoveByPPSSysBICubeMSCond(PSSysBICubeMSCond pSSysBICubeMSCond) throws Exception {
    }

    protected void internalRemoveByPPSSysBICubeMSCond(PSSysBICubeMSCond pSSysBICubeMSCond) throws Exception {
        ArrayList<PSSysBICubeMSCond> arrayList = this.selectByPPSSysBICubeMSCond(pSSysBICubeMSCond);
        this.onBeforeRemoveByPPSSysBICubeMSCond(pSSysBICubeMSCond, arrayList);
        for (PSSysBICubeMSCond pSSysBICubeMSCond2 : arrayList) {
            this.remove(pSSysBICubeMSCond2);
        }
        this.onAfterRemoveByPPSSysBICubeMSCond(pSSysBICubeMSCond, arrayList);
    }

    protected void onAfterRemoveByPPSSysBICubeMSCond(PSSysBICubeMSCond pSSysBICubeMSCond) throws Exception {
    }

    protected void onBeforeRemoveByPPSSysBICubeMSCond(PSSysBICubeMSCond pSSysBICubeMSCond, ArrayList<PSSysBICubeMSCond> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPPSSysBICubeMSCond(PSSysBICubeMSCond pSSysBICubeMSCond, ArrayList<PSSysBICubeMSCond> arrayList) throws Exception {
    }

    public void testRemoveByPSSysDBVF(PSSysDBVF pSSysDBVF) throws Exception {
        ArrayList<PSSysBICubeMSCond> arrayList = this.selectByPSSysDBVF(pSSysDBVF, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSDBVF");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSSysDBVF);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSBICUBEMSCOND_PSSYSDBVF_PSSYSDBVFID", "", iDataEntityModel.getName(), "PSSYSBICUBEMSCOND", iDataEntityModel.getDataInfo(pSSysDBVF), arrayList.get(0)));
        }
    }

    public void resetPSSysDBVF(PSSysDBVF pSSysDBVF) throws Exception {
        ArrayList<PSSysBICubeMSCond> arrayList = this.selectByPSSysDBVF(pSSysDBVF);
        for (PSSysBICubeMSCond pSSysBICubeMSCond : arrayList) {
            PSSysBICubeMSCond pSSysBICubeMSCond2 = (PSSysBICubeMSCond)this.getDEModel().createEntity();
            pSSysBICubeMSCond2.setPSSysBICubeMSCondId(pSSysBICubeMSCond.getPSSysBICubeMSCondId());
            pSSysBICubeMSCond2.setPSSysDBVFId(null);
            this.update(pSSysBICubeMSCond2);
        }
    }

    public void removeByPSSysDBVF(PSSysDBVF pSSysDBVF) throws Exception {
        final PSSysDBVF pSSysDBVF2 = pSSysDBVF;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysBICubeMSCondServiceBase.this.onBeforeRemoveByPSSysDBVF(pSSysDBVF2);
                PSSysBICubeMSCondServiceBase.this.internalRemoveByPSSysDBVF(pSSysDBVF2);
                PSSysBICubeMSCondServiceBase.this.onAfterRemoveByPSSysDBVF(pSSysDBVF2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysDBVF(PSSysDBVF pSSysDBVF) throws Exception {
    }

    protected void internalRemoveByPSSysDBVF(PSSysDBVF pSSysDBVF) throws Exception {
        ArrayList<PSSysBICubeMSCond> arrayList = this.selectByPSSysDBVF(pSSysDBVF);
        this.onBeforeRemoveByPSSysDBVF(pSSysDBVF, arrayList);
        for (PSSysBICubeMSCond pSSysBICubeMSCond : arrayList) {
            this.remove(pSSysBICubeMSCond);
        }
        this.onAfterRemoveByPSSysDBVF(pSSysDBVF, arrayList);
    }

    protected void onAfterRemoveByPSSysDBVF(PSSysDBVF pSSysDBVF) throws Exception {
    }

    protected void onBeforeRemoveByPSSysDBVF(PSSysDBVF pSSysDBVF, ArrayList<PSSysBICubeMSCond> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysDBVF(PSSysDBVF pSSysDBVF, ArrayList<PSSysBICubeMSCond> arrayList) throws Exception {
    }

    public void testRemoveByPSVarType(PSVarType pSVarType) throws Exception {
        ArrayList<PSSysBICubeMSCond> arrayList = this.selectByPSVarType(pSVarType, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSVARTYPE");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSVarType);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSBICUBEMSCOND_PSVARTYPE_PSVARTYPEID", "", iDataEntityModel.getName(), "PSSYSBICUBEMSCOND", iDataEntityModel.getDataInfo(pSVarType), arrayList.get(0)));
        }
    }

    public void resetPSVarType(PSVarType pSVarType) throws Exception {
        ArrayList<PSSysBICubeMSCond> arrayList = this.selectByPSVarType(pSVarType);
        for (PSSysBICubeMSCond pSSysBICubeMSCond : arrayList) {
            PSSysBICubeMSCond pSSysBICubeMSCond2 = (PSSysBICubeMSCond)this.getDEModel().createEntity();
            pSSysBICubeMSCond2.setPSSysBICubeMSCondId(pSSysBICubeMSCond.getPSSysBICubeMSCondId());
            pSSysBICubeMSCond2.setPSVarTypeId(null);
            this.update(pSSysBICubeMSCond2);
        }
    }

    public void removeByPSVarType(PSVarType pSVarType) throws Exception {
        final PSVarType pSVarType2 = pSVarType;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysBICubeMSCondServiceBase.this.onBeforeRemoveByPSVarType(pSVarType2);
                PSSysBICubeMSCondServiceBase.this.internalRemoveByPSVarType(pSVarType2);
                PSSysBICubeMSCondServiceBase.this.onAfterRemoveByPSVarType(pSVarType2);
            }
        });
    }

    protected void onBeforeRemoveByPSVarType(PSVarType pSVarType) throws Exception {
    }

    protected void internalRemoveByPSVarType(PSVarType pSVarType) throws Exception {
        ArrayList<PSSysBICubeMSCond> arrayList = this.selectByPSVarType(pSVarType);
        this.onBeforeRemoveByPSVarType(pSVarType, arrayList);
        for (PSSysBICubeMSCond pSSysBICubeMSCond : arrayList) {
            this.remove(pSSysBICubeMSCond);
        }
        this.onAfterRemoveByPSVarType(pSVarType, arrayList);
    }

    protected void onAfterRemoveByPSVarType(PSVarType pSVarType) throws Exception {
    }

    protected void onBeforeRemoveByPSVarType(PSVarType pSVarType, ArrayList<PSSysBICubeMSCond> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSVarType(PSVarType pSVarType, ArrayList<PSSysBICubeMSCond> arrayList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(PSSysBICubeMSCond pSSysBICubeMSCond) throws Exception {
        PSSysBICubeMSCondService pSSysBICubeMSCondService = (PSSysBICubeMSCondService)ServiceGlobal.getService(PSSysBICubeMSCondService.class, (SessionFactory)this.getSessionFactory());
        pSSysBICubeMSCondService.testRemoveByPPSSysBICubeMSCond(pSSysBICubeMSCond);
        pSSysBICubeMSCondService.removeByPPSSysBICubeMSCond(pSSysBICubeMSCond);
        super.onBeforeRemove(pSSysBICubeMSCond);
    }

    protected void replaceParentInfo(PSSysBICubeMSCond pSSysBICubeMSCond, CloneSession cloneSession) throws Exception {
        IEntity iEntity;
        super.replaceParentInfo(pSSysBICubeMSCond, cloneSession);
        if (pSSysBICubeMSCond.getPSDBValueOPId() != null && (iEntity = cloneSession.getEntity("PSDBVALUEOP", (Object)pSSysBICubeMSCond.getPSDBValueOPId())) != null) {
            this.onFillParentInfo_PSDBValueOP(pSSysBICubeMSCond, (PSDBValueOP)iEntity);
        }
        if (pSSysBICubeMSCond.getPSDEFId() != null && (iEntity = cloneSession.getEntity("PSDEFIELD", (Object)pSSysBICubeMSCond.getPSDEFId())) != null) {
            this.onFillParentInfo_PSDEF(pSSysBICubeMSCond, (PSDEField)iEntity);
        }
        if (pSSysBICubeMSCond.getPSSysBICubeMeasureId() != null && (iEntity = cloneSession.getEntity("PSSYSBICUBEMEASURE", (Object)pSSysBICubeMSCond.getPSSysBICubeMeasureId())) != null) {
            this.onFillParentInfo_PSSysBICubeMeasure(pSSysBICubeMSCond, (PSSysBICubeMeasure)iEntity);
        }
        if (pSSysBICubeMSCond.getPPSSysBICubeMSCondId() != null && (iEntity = cloneSession.getEntity("PSSYSBICUBEMSCOND", (Object)pSSysBICubeMSCond.getPPSSysBICubeMSCondId())) != null) {
            this.onFillParentInfo_PPSSysBICubeMSCond(pSSysBICubeMSCond, (PSSysBICubeMSCond)iEntity);
        }
        if (pSSysBICubeMSCond.getPSSysDBVFId() != null && (iEntity = cloneSession.getEntity("PSSYSDBVF", (Object)pSSysBICubeMSCond.getPSSysDBVFId())) != null) {
            this.onFillParentInfo_PSSysDBVF(pSSysBICubeMSCond, (PSSysDBVF)iEntity);
        }
        if (pSSysBICubeMSCond.getPSVarTypeId() != null && (iEntity = cloneSession.getEntity("PSVARTYPE", (Object)pSSysBICubeMSCond.getPSVarTypeId())) != null) {
            this.onFillParentInfo_PSVarType(pSSysBICubeMSCond, (PSVarType)iEntity);
        }
    }

    protected void onRemoveEntityUncopyValues(PSSysBICubeMSCond pSSysBICubeMSCond, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues(pSSysBICubeMSCond, bl);
    }

    protected void onCheckEntity(boolean bl, PSSysBICubeMSCond pSSysBICubeMSCond, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_CondType(bl, pSSysBICubeMSCond, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_CondValue(bl, pSSysBICubeMSCond, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_CondValueText(bl, pSSysBICubeMSCond, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_CustomCond(bl, pSSysBICubeMSCond, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_CustomType(bl, pSSysBICubeMSCond, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_GroupNotFlag(bl, pSSysBICubeMSCond, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_GroupOP(bl, pSSysBICubeMSCond, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_IgnoreEmpty(bl, pSSysBICubeMSCond, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Memo(bl, pSSysBICubeMSCond, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_OrderValue(bl, pSSysBICubeMSCond, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PPSSysBICubeMSCondId(bl, pSSysBICubeMSCond, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDBValueOPId(bl, pSSysBICubeMSCond, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDBValueOPName(bl, pSSysBICubeMSCond, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEFId(bl, pSSysBICubeMSCond, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEFName(bl, pSSysBICubeMSCond, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEId(bl, pSSysBICubeMSCond, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysBICubeMeasureId(bl, pSSysBICubeMSCond, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysBICubeMSCondId(bl, pSSysBICubeMSCond, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysBICubeMSCondName(bl, pSSysBICubeMSCond, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysDBVFId(bl, pSSysBICubeMSCond, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysDBVFName(bl, pSSysBICubeMSCond, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSVarTypeId(bl, pSSysBICubeMSCond, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSVARTypeName(bl, pSSysBICubeMSCond, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserCat(bl, pSSysBICubeMSCond, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag(bl, pSSysBICubeMSCond, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag2(bl, pSSysBICubeMSCond, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag3(bl, pSSysBICubeMSCond, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag4(bl, pSSysBICubeMSCond, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, pSSysBICubeMSCond, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_CondType(boolean bl, PSSysBICubeMSCond pSSysBICubeMSCond, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysBICubeMSCond.isCondTypeDirty() && !bl2 : !pSSysBICubeMSCond.isCondTypeDirty()) {
            return null;
        }
        String string = pSSysBICubeMSCond.getCondType();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CONDTYPE");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_CondType_Default(pSSysBICubeMSCond, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CONDTYPE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_CondValue(boolean bl, PSSysBICubeMSCond pSSysBICubeMSCond, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysBICubeMSCond.isCondValueDirty() : !pSSysBICubeMSCond.isCondValueDirty()) {
            return null;
        }
        String string = pSSysBICubeMSCond.getCondValue();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_CondValue_Default(pSSysBICubeMSCond, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CONDVALUE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_CondValueText(boolean bl, PSSysBICubeMSCond pSSysBICubeMSCond, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysBICubeMSCond.isCondValueTextDirty() : !pSSysBICubeMSCond.isCondValueTextDirty()) {
            return null;
        }
        String string = pSSysBICubeMSCond.getCondValueText();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_CondValueText_Default(pSSysBICubeMSCond, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CONDVALUETEXT");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_CustomCond(boolean bl, PSSysBICubeMSCond pSSysBICubeMSCond, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysBICubeMSCond.isCustomCondDirty() : !pSSysBICubeMSCond.isCustomCondDirty()) {
            return null;
        }
        String string = pSSysBICubeMSCond.getCustomCond();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_CustomCond_Default(pSSysBICubeMSCond, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CUSTOMCOND");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_CustomType(boolean bl, PSSysBICubeMSCond pSSysBICubeMSCond, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysBICubeMSCond.isCustomTypeDirty() : !pSSysBICubeMSCond.isCustomTypeDirty()) {
            return null;
        }
        String string = pSSysBICubeMSCond.getCustomType();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_CustomType_Default(pSSysBICubeMSCond, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CUSTOMTYPE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_GroupNotFlag(boolean bl, PSSysBICubeMSCond pSSysBICubeMSCond, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysBICubeMSCond.isGroupNotFlagDirty() : !pSSysBICubeMSCond.isGroupNotFlagDirty()) {
            return null;
        }
        Integer n = pSSysBICubeMSCond.getGroupNotFlag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_GroupNotFlag_Default(pSSysBICubeMSCond, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("GROUPNOTFLAG");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_GroupOP(boolean bl, PSSysBICubeMSCond pSSysBICubeMSCond, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysBICubeMSCond.isGroupOPDirty() : !pSSysBICubeMSCond.isGroupOPDirty()) {
            return null;
        }
        String string = pSSysBICubeMSCond.getGroupOP();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_GroupOP_Default(pSSysBICubeMSCond, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("GROUPOP");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_IgnoreEmpty(boolean bl, PSSysBICubeMSCond pSSysBICubeMSCond, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysBICubeMSCond.isIgnoreEmptyDirty() : !pSSysBICubeMSCond.isIgnoreEmptyDirty()) {
            return null;
        }
        Integer n = pSSysBICubeMSCond.getIgnoreEmpty();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_IgnoreEmpty_Default(pSSysBICubeMSCond, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("IGNOREEMPTY");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Memo(boolean bl, PSSysBICubeMSCond pSSysBICubeMSCond, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysBICubeMSCond.isMemoDirty() : !pSSysBICubeMSCond.isMemoDirty()) {
            return null;
        }
        String string = pSSysBICubeMSCond.getMemo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Memo_Default(pSSysBICubeMSCond, bl2, bl3);
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

    protected EntityFieldError onCheckField_OrderValue(boolean bl, PSSysBICubeMSCond pSSysBICubeMSCond, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysBICubeMSCond.isOrderValueDirty() : !pSSysBICubeMSCond.isOrderValueDirty()) {
            return null;
        }
        Integer n = pSSysBICubeMSCond.getOrderValue();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_OrderValue_Default(pSSysBICubeMSCond, bl2, bl3);
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

    protected EntityFieldError onCheckField_PPSSysBICubeMSCondId(boolean bl, PSSysBICubeMSCond pSSysBICubeMSCond, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysBICubeMSCond.isPPSSysBICubeMSCondIdDirty() : !pSSysBICubeMSCond.isPPSSysBICubeMSCondIdDirty()) {
            return null;
        }
        String string = pSSysBICubeMSCond.getPPSSysBICubeMSCondId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PPSSysBICubeMSCondId_Default(pSSysBICubeMSCond, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PPSSYSBICUBEMSCONDID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDBValueOPId(boolean bl, PSSysBICubeMSCond pSSysBICubeMSCond, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysBICubeMSCond.isPSDBValueOPIdDirty() : !pSSysBICubeMSCond.isPSDBValueOPIdDirty()) {
            return null;
        }
        String string = pSSysBICubeMSCond.getPSDBValueOPId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDBValueOPId_Default(pSSysBICubeMSCond, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDBVALUEOPID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDBValueOPName(boolean bl, PSSysBICubeMSCond pSSysBICubeMSCond, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysBICubeMSCond.isPSDBValueOPNameDirty() : !pSSysBICubeMSCond.isPSDBValueOPNameDirty()) {
            return null;
        }
        String string = pSSysBICubeMSCond.getPSDBValueOPName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDBValueOPName_Default(pSSysBICubeMSCond, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDBVALUEOPNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDEFId(boolean bl, PSSysBICubeMSCond pSSysBICubeMSCond, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysBICubeMSCond.isPSDEFIdDirty() : !pSSysBICubeMSCond.isPSDEFIdDirty()) {
            return null;
        }
        String string = pSSysBICubeMSCond.getPSDEFId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEFId_Default(pSSysBICubeMSCond, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEFID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDEFName(boolean bl, PSSysBICubeMSCond pSSysBICubeMSCond, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysBICubeMSCond.isPSDEFNameDirty() : !pSSysBICubeMSCond.isPSDEFNameDirty()) {
            return null;
        }
        String string = pSSysBICubeMSCond.getPSDEFName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEFName_Default(pSSysBICubeMSCond, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEFNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDEId(boolean bl, PSSysBICubeMSCond pSSysBICubeMSCond, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysBICubeMSCond.isPSDEIdDirty() : !pSSysBICubeMSCond.isPSDEIdDirty()) {
            return null;
        }
        String string = pSSysBICubeMSCond.getPSDEId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEId_Default(pSSysBICubeMSCond, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSSysBICubeMeasureId(boolean bl, PSSysBICubeMSCond pSSysBICubeMSCond, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysBICubeMSCond.isPSSysBICubeMeasureIdDirty() : !pSSysBICubeMSCond.isPSSysBICubeMeasureIdDirty()) {
            return null;
        }
        String string = pSSysBICubeMSCond.getPSSysBICubeMeasureId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysBICubeMeasureId_Default(pSSysBICubeMSCond, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSBICUBEMEASUREID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSysBICubeMSCondId(boolean bl, PSSysBICubeMSCond pSSysBICubeMSCond, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysBICubeMSCond.isPSSysBICubeMSCondIdDirty() && !bl2 : !pSSysBICubeMSCond.isPSSysBICubeMSCondIdDirty()) {
            return null;
        }
        String string = pSSysBICubeMSCond.getPSSysBICubeMSCondId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSBICUBEMSCONDID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysBICubeMSCondId_Default(pSSysBICubeMSCond, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSBICUBEMSCONDID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSysBICubeMSCondName(boolean bl, PSSysBICubeMSCond pSSysBICubeMSCond, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysBICubeMSCond.isPSSysBICubeMSCondNameDirty() && !bl2 : !pSSysBICubeMSCond.isPSSysBICubeMSCondNameDirty()) {
            return null;
        }
        String string = pSSysBICubeMSCond.getPSSysBICubeMSCondName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSBICUBEMSCONDNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysBICubeMSCondName_Default(pSSysBICubeMSCond, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSBICUBEMSCONDNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSysDBVFId(boolean bl, PSSysBICubeMSCond pSSysBICubeMSCond, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysBICubeMSCond.isPSSysDBVFIdDirty() : !pSSysBICubeMSCond.isPSSysDBVFIdDirty()) {
            return null;
        }
        String string = pSSysBICubeMSCond.getPSSysDBVFId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysDBVFId_Default(pSSysBICubeMSCond, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSDBVFID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSysDBVFName(boolean bl, PSSysBICubeMSCond pSSysBICubeMSCond, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysBICubeMSCond.isPSSysDBVFNameDirty() : !pSSysBICubeMSCond.isPSSysDBVFNameDirty()) {
            return null;
        }
        String string = pSSysBICubeMSCond.getPSSysDBVFName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysDBVFName_Default(pSSysBICubeMSCond, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSDBVFNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSVarTypeId(boolean bl, PSSysBICubeMSCond pSSysBICubeMSCond, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysBICubeMSCond.isPSVarTypeIdDirty() : !pSSysBICubeMSCond.isPSVarTypeIdDirty()) {
            return null;
        }
        String string = pSSysBICubeMSCond.getPSVarTypeId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSVarTypeId_Default(pSSysBICubeMSCond, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSVARTYPEID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSVARTypeName(boolean bl, PSSysBICubeMSCond pSSysBICubeMSCond, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysBICubeMSCond.isPSVARTypeNameDirty() : !pSSysBICubeMSCond.isPSVARTypeNameDirty()) {
            return null;
        }
        String string = pSSysBICubeMSCond.getPSVARTypeName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSVARTypeName_Default(pSSysBICubeMSCond, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSVARTYPENAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_UserCat(boolean bl, PSSysBICubeMSCond pSSysBICubeMSCond, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysBICubeMSCond.isUserCatDirty() : !pSSysBICubeMSCond.isUserCatDirty()) {
            return null;
        }
        String string = pSSysBICubeMSCond.getUserCat();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserCat_Default(pSSysBICubeMSCond, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag(boolean bl, PSSysBICubeMSCond pSSysBICubeMSCond, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysBICubeMSCond.isUserTagDirty() : !pSSysBICubeMSCond.isUserTagDirty()) {
            return null;
        }
        String string = pSSysBICubeMSCond.getUserTag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag_Default(pSSysBICubeMSCond, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag2(boolean bl, PSSysBICubeMSCond pSSysBICubeMSCond, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysBICubeMSCond.isUserTag2Dirty() : !pSSysBICubeMSCond.isUserTag2Dirty()) {
            return null;
        }
        String string = pSSysBICubeMSCond.getUserTag2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag2_Default(pSSysBICubeMSCond, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag3(boolean bl, PSSysBICubeMSCond pSSysBICubeMSCond, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysBICubeMSCond.isUserTag3Dirty() : !pSSysBICubeMSCond.isUserTag3Dirty()) {
            return null;
        }
        String string = pSSysBICubeMSCond.getUserTag3();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag3_Default(pSSysBICubeMSCond, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag4(boolean bl, PSSysBICubeMSCond pSSysBICubeMSCond, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysBICubeMSCond.isUserTag4Dirty() : !pSSysBICubeMSCond.isUserTag4Dirty()) {
            return null;
        }
        String string = pSSysBICubeMSCond.getUserTag4();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag4_Default(pSSysBICubeMSCond, bl2, bl3);
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

    protected void onSyncEntity(PSSysBICubeMSCond pSSysBICubeMSCond, boolean bl) throws Exception {
        super.onSyncEntity(pSSysBICubeMSCond, bl);
    }

    protected void onSyncIndexEntities(PSSysBICubeMSCond pSSysBICubeMSCond, boolean bl) throws Exception {
        super.onSyncIndexEntities(pSSysBICubeMSCond, bl);
    }

    public Object getDataContextValue(PSSysBICubeMSCond pSSysBICubeMSCond, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null) {
            // empty if block
        }
        if ((object = super.getDataContextValue(pSSysBICubeMSCond, string, iDataContextParam)) != null) {
            return object;
        }
        return null;
    }

    protected void onExportMajorModel(PSSysBICubeMSCond pSSysBICubeMSCond, ArrayList<JSONObject> arrayList, int n) throws Exception {
        super.onExportMajorModel(pSSysBICubeMSCond, arrayList, n);
    }

    protected String onTestValueRule(String string, String string2, IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        if (StringHelper.compare((String)string, (String)"CONDTYPE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CondType_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CONDVALUE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CondValue_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CONDVALUETEXT", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CondValueText_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATEDATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateDate_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATEMAN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateMan_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CUSTOMCOND", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CustomCond_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CUSTOMTYPE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CustomType_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"GROUPNOTFLAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_GroupNotFlag_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"GROUPOP", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_GroupOP_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"IGNOREEMPTY", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_IgnoreEmpty_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MEMO", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Memo_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ORDERVALUE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_OrderValue_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PPSSYSBICUBEMSCONDID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PPSSysBICubeMSCondId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PPSSYSBICUBEMSCONDNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PPSSysBICubeMSCondName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDBVALUEOPID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDBValueOPId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDBVALUEOPNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDBValueOPName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEFID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEFId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEFNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEFName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSBICUBEMEASUREID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysBICubeMeasureId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSBICUBEMEASURENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysBICubeMeasureName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSBICUBEMSCONDID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysBICubeMSCondId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSBICUBEMSCONDNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysBICubeMSCondName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSDBVFID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysDBVFId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSDBVFNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysDBVFName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSVARTYPEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSVarTypeId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSVARTYPENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSVARTypeName_Default(iEntity, bl, bl2);
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

    protected String onTestValueRule_CondType_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("CONDTYPE", iEntity, bl2, null, false, 20, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[20]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[20]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_CondValue_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("CONDVALUE", iEntity, bl2, null, false, 2000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[2000]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[2000]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_CondValueText_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("CONDVALUETEXT", iEntity, bl2, null, false, 2000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[2000]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[2000]";
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

    protected String onTestValueRule_CustomCond_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("CUSTOMCOND", iEntity, bl2, null, false, 0x100000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_CustomType_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("CUSTOMTYPE", iEntity, bl2, null, false, 30, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_GroupNotFlag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_GroupOP_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("GROUPOP", iEntity, bl2, null, false, 10, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[10]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[10]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_IgnoreEmpty_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
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

    protected String onTestValueRule_PPSSysBICubeMSCondId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PPSSYSBICUBEMSCONDID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PPSSysBICubeMSCondName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PPSSYSBICUBEMSCONDNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDBValueOPId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDBVALUEOPID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDBValueOPName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDBVALUEOPNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDEFId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEFID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDEFName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEFNAME", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDEId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEID", iEntity, bl2, null, false, 60, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysBICubeMeasureId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSBICUBEMEASUREID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysBICubeMeasureName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSBICUBEMEASURENAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysBICubeMSCondId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSBICUBEMSCONDID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysBICubeMSCondName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSBICUBEMSCONDNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysDBVFId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSDBVFID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysDBVFName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSDBVFNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSVarTypeId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSVARTYPEID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSVARTypeName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSVARTYPENAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
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
            if (this.checkFieldStringLengthRule("USERTAG", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_UserTag2_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("USERTAG2", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
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

    protected boolean onMergeChild(String string, String string2, PSSysBICubeMSCond pSSysBICubeMSCond) throws Exception {
        boolean bl = false;
        if (super.onMergeChild(string, string2, pSSysBICubeMSCond)) {
            bl = true;
        }
        return bl;
    }

    protected void onUpdateParent(PSSysBICubeMSCond pSSysBICubeMSCond) throws Exception {
        super.onUpdateParent(pSSysBICubeMSCond);
    }

    @Override
    protected void exportCurXmlModel(PSSysBICubeMSCond pSSysBICubeMSCond, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSSYSBICUBEMSCOND");
        if (!bl) {
            pSSysBICubeMSCond.setCreateDate(null);
            pSSysBICubeMSCond.setCreateMan(null);
            pSSysBICubeMSCond.setPSSysBICubeMSCondId(null);
            pSSysBICubeMSCond.setUpdateDate(null);
            pSSysBICubeMSCond.setUpdateMan(null);
            super.exportCurXmlModel(pSSysBICubeMSCond, xmlNode, bl);
        }
    }
}

