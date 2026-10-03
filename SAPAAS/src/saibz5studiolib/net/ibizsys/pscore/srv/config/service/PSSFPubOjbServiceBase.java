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
package net.ibizsys.pscore.srv.config.service;

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
import net.ibizsys.pscore.srv.config.dao.PSSFPubOjbDAO;
import net.ibizsys.pscore.srv.config.demodel.PSSFPubOjbDEModel;
import net.ibizsys.pscore.srv.config.entity.PSSF;
import net.ibizsys.pscore.srv.config.entity.PSSFBase;
import net.ibizsys.pscore.srv.config.entity.PSSFPubOjb;
import net.ibizsys.pscore.srv.config.entity.PSSFPubOjbBase;
import net.ibizsys.pscore.srv.config.entity.PSSFStyle;
import net.ibizsys.pscore.srv.config.entity.PSSFStyleBase;
import net.ibizsys.pscore.srv.config.service.PSSFPubObjParamService;
import net.ibizsys.pscore.srv.config.service.PSSFPubObjParamServiceBase;
import net.ibizsys.pscore.srv.config.service.PSSFPubOjbService;
import net.ibizsys.pscore.srv.core.IPSDataEntityModel;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSSFPubOjbServiceBase
extends PSCoreSysServiceBase<PSSFPubOjb> {
    private static final Log log = LogFactory.getLog(PSSFPubOjbServiceBase.class);
    public static final String DATASET_DEFAULT = "DEFAULT";
    private PSSFPubOjbDEModel pSSFPubOjbDEModel;
    private PSSFPubOjbDAO pSSFPubOjbDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.config.service.PSSFPubOjbService";
    }

    public PSSFPubOjbDEModel getPSSFPubOjbDEModel() {
        if (this.pSSFPubOjbDEModel == null) {
            try {
                this.pSSFPubOjbDEModel = (PSSFPubOjbDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.config.demodel.PSSFPubOjbDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSSFPubOjbDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSSFPubOjbDEModel();
    }

    public PSSFPubOjbDAO getPSSFPubOjbDAO() {
        if (this.pSSFPubOjbDAO == null) {
            try {
                this.pSSFPubOjbDAO = (PSSFPubOjbDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.config.dao.PSSFPubOjbDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSSFPubOjbDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSSFPubOjbDAO();
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

    protected void onFillParentInfo(PSSFPubOjb pSSFPubOjb, String string, String string2, String string3) throws Exception {
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSFPUBOBJ_PSSFPUBOBJ_PPSSFPUBOBJID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.config.service.PSSFPubOjbService", (SessionFactory)this.getSessionFactory());
            PSSFPubOjb pSSFPubOjb2 = (PSSFPubOjb)iService.getDEModel().createEntity();
            pSSFPubOjb2.set("PSSFPUBOBJID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSSFPubOjb2);
            } else {
                iService.get(pSSFPubOjb2);
            }
            this.onFillParentInfo_Ppssfpubobj(pSSFPubOjb, pSSFPubOjb2);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSFPUBOBJ_PSSFSTYLE_PSSFSTYLEID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.config.service.PSSFStyleService", (SessionFactory)this.getSessionFactory());
            PSSFStyle pSSFStyle = (PSSFStyle)iService.getDEModel().createEntity();
            pSSFStyle.set("PSSFSTYLEID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSSFStyle);
            } else {
                iService.get(pSSFStyle);
            }
            this.onFillParentInfo_PSSFStyle(pSSFPubOjb, pSSFStyle);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSFPUBOBJ_PSSF_PSSFID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.config.service.PSSFService", (SessionFactory)this.getSessionFactory());
            PSSF pSSF = (PSSF)iService.getDEModel().createEntity();
            pSSF.set("PSSFID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSSF);
            } else {
                iService.get(pSSF);
            }
            this.onFillParentInfo_Pssf(pSSFPubOjb, pSSF);
            return;
        }
        super.onFillParentInfo(pSSFPubOjb, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillParentInfo_Ppssfpubobj(PSSFPubOjb pSSFPubOjb, PSSFPubOjb pSSFPubOjb2) throws Exception {
        pSSFPubOjb.setPPSSFPubObjId(pSSFPubOjb2.getPSSFPubObjId());
        pSSFPubOjb.setPPSSFPubObjName(pSSFPubOjb2.getPSSFPubObjName());
    }

    protected void onFillParentInfo_PSSFStyle(PSSFPubOjb pSSFPubOjb, PSSFStyle pSSFStyle) throws Exception {
        pSSFPubOjb.setPSSFStyleId(pSSFStyle.getPSSFStyleId());
        pSSFPubOjb.setPSSFStyleName(pSSFStyle.getPSSFStyleName());
    }

    protected void onFillParentInfo_Pssf(PSSFPubOjb pSSFPubOjb, PSSF pSSF) throws Exception {
        pSSFPubOjb.setPSSFId(pSSF.getPSSFId());
        pSSFPubOjb.setPSSFName(pSSF.getPSSFName());
    }

    protected void onFillEntityFullInfo(PSSFPubOjb pSSFPubOjb, boolean bl) throws Exception {
        if (bl && pSSFPubOjb.getValidFlag() == null) {
            pSSFPubOjb.setValidFlag((Integer)this.getDefaultValue(this.getWebContext(), "", "1", 9));
        }
        super.onFillEntityFullInfo(pSSFPubOjb, bl);
        this.onFillEntityFullInfo_Ppssfpubobj(pSSFPubOjb, bl);
        this.onFillEntityFullInfo_PSSFStyle(pSSFPubOjb, bl);
        this.onFillEntityFullInfo_Pssf(pSSFPubOjb, bl);
    }

    protected void onFillEntityFullInfo_Ppssfpubobj(PSSFPubOjb pSSFPubOjb, boolean bl) throws Exception {
        if (pSSFPubOjb.isPPSSFPubObjIdDirty()) {
            if (pSSFPubOjb.getPPSSFPubObjId() != null) {
                if (pSSFPubOjb.getPPSSFPubObjId() == null || pSSFPubOjb.getPPSSFPubObjName() == null) {
                    PSSFPubOjb pSSFPubOjb2 = pSSFPubOjb.getPpssfpubobj();
                    pSSFPubOjb.setPPSSFPubObjName(pSSFPubOjb2.getPSSFPubObjName());
                }
            } else {
                pSSFPubOjb.setPPSSFPubObjName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_PSSFStyle(PSSFPubOjb pSSFPubOjb, boolean bl) throws Exception {
        if (pSSFPubOjb.isPSSFStyleIdDirty()) {
            if (pSSFPubOjb.getPSSFStyleId() != null) {
                if (pSSFPubOjb.getPSSFStyleId() == null || pSSFPubOjb.getPSSFStyleName() == null) {
                    PSSFStyle pSSFStyle = pSSFPubOjb.getPSSFStyle();
                    pSSFPubOjb.setPSSFStyleName(pSSFStyle.getPSSFStyleName());
                }
            } else {
                pSSFPubOjb.setPSSFStyleName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_Pssf(PSSFPubOjb pSSFPubOjb, boolean bl) throws Exception {
        if (pSSFPubOjb.isPSSFIdDirty()) {
            if (pSSFPubOjb.getPSSFId() != null) {
                if (pSSFPubOjb.getPSSFId() == null || pSSFPubOjb.getPSSFName() == null) {
                    PSSF pSSF = pSSFPubOjb.getPssf();
                    pSSFPubOjb.setPSSFName(pSSF.getPSSFName());
                }
            } else {
                pSSFPubOjb.setPSSFName(null);
            }
        }
    }

    protected void onWriteBackParent(PSSFPubOjb pSSFPubOjb, boolean bl) throws Exception {
        super.onWriteBackParent(pSSFPubOjb, bl);
    }

    public ArrayList<PSSFPubOjb> selectByPpssfpubobj(PSSFPubOjbBase pSSFPubOjbBase) throws Exception {
        return this.selectByPpssfpubobj(pSSFPubOjbBase, "", -1);
    }

    public ArrayList<PSSFPubOjb> selectByPpssfpubobj(PSSFPubOjbBase pSSFPubOjbBase, String string) throws Exception {
        return this.selectByPpssfpubobj(pSSFPubOjbBase, string, -1);
    }

    public ArrayList<PSSFPubOjb> selectByPpssfpubobj(PSSFPubOjbBase pSSFPubOjbBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PPSSFPUBOBJID", (Object)pSSFPubOjbBase.getPSSFPubObjId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPpssfpubobjCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPpssfpubobjCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSSFPubOjb> selectByPSSFStyle(PSSFStyleBase pSSFStyleBase) throws Exception {
        return this.selectByPSSFStyle(pSSFStyleBase, "", -1);
    }

    public ArrayList<PSSFPubOjb> selectByPSSFStyle(PSSFStyleBase pSSFStyleBase, String string) throws Exception {
        return this.selectByPSSFStyle(pSSFStyleBase, string, -1);
    }

    public ArrayList<PSSFPubOjb> selectByPSSFStyle(PSSFStyleBase pSSFStyleBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSSFSTYLEID", (Object)pSSFStyleBase.getPSSFStyleId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSSFStyleCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSSFStyleCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSSFPubOjb> selectByPssf(PSSFBase pSSFBase) throws Exception {
        return this.selectByPssf(pSSFBase, "", -1);
    }

    public ArrayList<PSSFPubOjb> selectByPssf(PSSFBase pSSFBase, String string) throws Exception {
        return this.selectByPssf(pSSFBase, string, -1);
    }

    public ArrayList<PSSFPubOjb> selectByPssf(PSSFBase pSSFBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSSFID", (Object)pSSFBase.getPSSFId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPssfCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPssfCond(SelectCond selectCond) throws Exception {
    }

    public void testRemoveByPpssfpubobj(PSSFPubOjb pSSFPubOjb) throws Exception {
        ArrayList<PSSFPubOjb> arrayList = this.selectByPpssfpubobj(pSSFPubOjb, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSFPUBOJB");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSSFPubOjb);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSFPUBOBJ_PSSFPUBOBJ_PPSSFPUBOBJID", "", iDataEntityModel.getName(), "PSSFPUBOBJ", iDataEntityModel.getDataInfo(pSSFPubOjb), arrayList.get(0)));
        }
    }

    public void resetPpssfpubobj(PSSFPubOjb pSSFPubOjb) throws Exception {
        ArrayList<PSSFPubOjb> arrayList = this.selectByPpssfpubobj(pSSFPubOjb);
        for (PSSFPubOjb pSSFPubOjb2 : arrayList) {
            PSSFPubOjb pSSFPubOjb3 = (PSSFPubOjb)this.getDEModel().createEntity();
            pSSFPubOjb3.setPSSFPubObjId(pSSFPubOjb2.getPSSFPubObjId());
            pSSFPubOjb3.setPPSSFPubObjId(null);
            this.update(pSSFPubOjb3);
        }
    }

    public void removeByPpssfpubobj(PSSFPubOjb pSSFPubOjb) throws Exception {
        final PSSFPubOjb pSSFPubOjb2 = pSSFPubOjb;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSFPubOjbServiceBase.this.onBeforeRemoveByPpssfpubobj(pSSFPubOjb2);
                PSSFPubOjbServiceBase.this.internalRemoveByPpssfpubobj(pSSFPubOjb2);
                PSSFPubOjbServiceBase.this.onAfterRemoveByPpssfpubobj(pSSFPubOjb2);
            }
        });
    }

    protected void onBeforeRemoveByPpssfpubobj(PSSFPubOjb pSSFPubOjb) throws Exception {
    }

    protected void internalRemoveByPpssfpubobj(PSSFPubOjb pSSFPubOjb) throws Exception {
        ArrayList<PSSFPubOjb> arrayList = this.selectByPpssfpubobj(pSSFPubOjb);
        this.onBeforeRemoveByPpssfpubobj(pSSFPubOjb, arrayList);
        for (PSSFPubOjb pSSFPubOjb2 : arrayList) {
            this.remove(pSSFPubOjb2);
        }
        this.onAfterRemoveByPpssfpubobj(pSSFPubOjb, arrayList);
    }

    protected void onAfterRemoveByPpssfpubobj(PSSFPubOjb pSSFPubOjb) throws Exception {
    }

    protected void onBeforeRemoveByPpssfpubobj(PSSFPubOjb pSSFPubOjb, ArrayList<PSSFPubOjb> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPpssfpubobj(PSSFPubOjb pSSFPubOjb, ArrayList<PSSFPubOjb> arrayList) throws Exception {
    }

    public void testRemoveByPSSFStyle(PSSFStyle pSSFStyle) throws Exception {
        ArrayList<PSSFPubOjb> arrayList = this.selectByPSSFStyle(pSSFStyle, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSFSTYLE");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSSFStyle);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSFPUBOBJ_PSSFSTYLE_PSSFSTYLEID", "", iDataEntityModel.getName(), "PSSFPUBOBJ", iDataEntityModel.getDataInfo(pSSFStyle), arrayList.get(0)));
        }
    }

    public void resetPSSFStyle(PSSFStyle pSSFStyle) throws Exception {
        ArrayList<PSSFPubOjb> arrayList = this.selectByPSSFStyle(pSSFStyle);
        for (PSSFPubOjb pSSFPubOjb : arrayList) {
            PSSFPubOjb pSSFPubOjb2 = (PSSFPubOjb)this.getDEModel().createEntity();
            pSSFPubOjb2.setPSSFPubObjId(pSSFPubOjb.getPSSFPubObjId());
            pSSFPubOjb2.setPSSFStyleId(null);
            this.update(pSSFPubOjb2);
        }
    }

    public void removeByPSSFStyle(PSSFStyle pSSFStyle) throws Exception {
        final PSSFStyle pSSFStyle2 = pSSFStyle;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSFPubOjbServiceBase.this.onBeforeRemoveByPSSFStyle(pSSFStyle2);
                PSSFPubOjbServiceBase.this.internalRemoveByPSSFStyle(pSSFStyle2);
                PSSFPubOjbServiceBase.this.onAfterRemoveByPSSFStyle(pSSFStyle2);
            }
        });
    }

    protected void onBeforeRemoveByPSSFStyle(PSSFStyle pSSFStyle) throws Exception {
    }

    protected void internalRemoveByPSSFStyle(PSSFStyle pSSFStyle) throws Exception {
        ArrayList<PSSFPubOjb> arrayList = this.selectByPSSFStyle(pSSFStyle);
        this.onBeforeRemoveByPSSFStyle(pSSFStyle, arrayList);
        for (PSSFPubOjb pSSFPubOjb : arrayList) {
            this.remove(pSSFPubOjb);
        }
        this.onAfterRemoveByPSSFStyle(pSSFStyle, arrayList);
    }

    protected void onAfterRemoveByPSSFStyle(PSSFStyle pSSFStyle) throws Exception {
    }

    protected void onBeforeRemoveByPSSFStyle(PSSFStyle pSSFStyle, ArrayList<PSSFPubOjb> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSFStyle(PSSFStyle pSSFStyle, ArrayList<PSSFPubOjb> arrayList) throws Exception {
    }

    public void testRemoveByPssf(PSSF pSSF) throws Exception {
        ArrayList<PSSFPubOjb> arrayList = this.selectByPssf(pSSF, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSF");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSSF);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSFPUBOBJ_PSSF_PSSFID", "", iDataEntityModel.getName(), "PSSFPUBOBJ", iDataEntityModel.getDataInfo(pSSF), arrayList.get(0)));
        }
    }

    public void resetPssf(PSSF pSSF) throws Exception {
        ArrayList<PSSFPubOjb> arrayList = this.selectByPssf(pSSF);
        for (PSSFPubOjb pSSFPubOjb : arrayList) {
            PSSFPubOjb pSSFPubOjb2 = (PSSFPubOjb)this.getDEModel().createEntity();
            pSSFPubOjb2.setPSSFPubObjId(pSSFPubOjb.getPSSFPubObjId());
            pSSFPubOjb2.setPSSFId(null);
            this.update(pSSFPubOjb2);
        }
    }

    public void removeByPssf(PSSF pSSF) throws Exception {
        final PSSF pSSF2 = pSSF;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSFPubOjbServiceBase.this.onBeforeRemoveByPssf(pSSF2);
                PSSFPubOjbServiceBase.this.internalRemoveByPssf(pSSF2);
                PSSFPubOjbServiceBase.this.onAfterRemoveByPssf(pSSF2);
            }
        });
    }

    protected void onBeforeRemoveByPssf(PSSF pSSF) throws Exception {
    }

    protected void internalRemoveByPssf(PSSF pSSF) throws Exception {
        ArrayList<PSSFPubOjb> arrayList = this.selectByPssf(pSSF);
        this.onBeforeRemoveByPssf(pSSF, arrayList);
        for (PSSFPubOjb pSSFPubOjb : arrayList) {
            this.remove(pSSFPubOjb);
        }
        this.onAfterRemoveByPssf(pSSF, arrayList);
    }

    protected void onAfterRemoveByPssf(PSSF pSSF) throws Exception {
    }

    protected void onBeforeRemoveByPssf(PSSF pSSF, ArrayList<PSSFPubOjb> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPssf(PSSF pSSF, ArrayList<PSSFPubOjb> arrayList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(PSSFPubOjb pSSFPubOjb) throws Exception {
        PSCoreSysServiceBase pSCoreSysServiceBase = (PSSFPubObjParamService)ServiceGlobal.getService(PSSFPubObjParamService.class, (SessionFactory)this.getSessionFactory());
        ((PSSFPubObjParamServiceBase)pSCoreSysServiceBase).testRemoveByPssfpubobj(pSSFPubOjb);
        ((PSSFPubObjParamServiceBase)pSCoreSysServiceBase).removeByPssfpubobj(pSSFPubOjb);
        pSCoreSysServiceBase = (PSSFPubOjbService)ServiceGlobal.getService(PSSFPubOjbService.class, (SessionFactory)this.getSessionFactory());
        ((PSSFPubOjbServiceBase)pSCoreSysServiceBase).testRemoveByPpssfpubobj(pSSFPubOjb);
        super.onBeforeRemove(pSSFPubOjb);
    }

    protected void replaceParentInfo(PSSFPubOjb pSSFPubOjb, CloneSession cloneSession) throws Exception {
        IEntity iEntity;
        super.replaceParentInfo(pSSFPubOjb, cloneSession);
        if (pSSFPubOjb.getPPSSFPubObjId() != null && (iEntity = cloneSession.getEntity("PSSFPUBOBJ", (Object)pSSFPubOjb.getPPSSFPubObjId())) != null) {
            this.onFillParentInfo_Ppssfpubobj(pSSFPubOjb, (PSSFPubOjb)iEntity);
        }
        if (pSSFPubOjb.getPSSFStyleId() != null && (iEntity = cloneSession.getEntity("PSSFSTYLE", (Object)pSSFPubOjb.getPSSFStyleId())) != null) {
            this.onFillParentInfo_PSSFStyle(pSSFPubOjb, (PSSFStyle)iEntity);
        }
        if (pSSFPubOjb.getPSSFId() != null && (iEntity = cloneSession.getEntity("PSSF", (Object)pSSFPubOjb.getPSSFId())) != null) {
            this.onFillParentInfo_Pssf(pSSFPubOjb, (PSSF)iEntity);
        }
    }

    protected void onRemoveEntityUncopyValues(PSSFPubOjb pSSFPubOjb, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues(pSSFPubOjb, bl);
    }

    protected void onCheckEntity(boolean bl, PSSFPubOjb pSSFPubOjb, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_MacroParams(bl, pSSFPubOjb, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Memo(bl, pSSFPubOjb, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PPSSFPubObjId(bl, pSSFPubOjb, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PPSSFPubObjName(bl, pSSFPubOjb, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSFId(bl, pSSFPubOjb, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSFName(bl, pSSFPubOjb, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSFPubObjId(bl, pSSFPubOjb, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSFPubObjName(bl, pSSFPubOjb, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSFStyleId(bl, pSSFPubOjb, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSFStyleName(bl, pSSFPubOjb, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PubObj(bl, pSSFPubOjb, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PubObjTag(bl, pSSFPubOjb, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PubObjTag2(bl, pSSFPubOjb, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Target(bl, pSSFPubOjb, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ValidFlag(bl, pSSFPubOjb, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, pSSFPubOjb, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_MacroParams(boolean bl, PSSFPubOjb pSSFPubOjb, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSFPubOjb.isMacroParamsDirty() : !pSSFPubOjb.isMacroParamsDirty()) {
            return null;
        }
        String string = pSSFPubOjb.getMacroParams();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_MacroParams_Default(pSSFPubOjb, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("MACROPARAMS");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Memo(boolean bl, PSSFPubOjb pSSFPubOjb, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSFPubOjb.isMemoDirty() : !pSSFPubOjb.isMemoDirty()) {
            return null;
        }
        String string = pSSFPubOjb.getMemo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Memo_Default(pSSFPubOjb, bl2, bl3);
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

    protected EntityFieldError onCheckField_PPSSFPubObjId(boolean bl, PSSFPubOjb pSSFPubOjb, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSFPubOjb.isPPSSFPubObjIdDirty() : !pSSFPubOjb.isPPSSFPubObjIdDirty()) {
            return null;
        }
        String string = pSSFPubOjb.getPPSSFPubObjId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PPSSFPubObjId_Default(pSSFPubOjb, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PPSSFPUBOBJID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PPSSFPubObjName(boolean bl, PSSFPubOjb pSSFPubOjb, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSFPubOjb.isPPSSFPubObjNameDirty() : !pSSFPubOjb.isPPSSFPubObjNameDirty()) {
            return null;
        }
        String string = pSSFPubOjb.getPPSSFPubObjName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PPSSFPubObjName_Default(pSSFPubOjb, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PPSSFPUBOBJNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSFId(boolean bl, PSSFPubOjb pSSFPubOjb, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSFPubOjb.isPSSFIdDirty() : !pSSFPubOjb.isPSSFIdDirty()) {
            return null;
        }
        String string = pSSFPubOjb.getPSSFId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSFId_Default(pSSFPubOjb, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSFID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSFName(boolean bl, PSSFPubOjb pSSFPubOjb, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSFPubOjb.isPSSFNameDirty() : !pSSFPubOjb.isPSSFNameDirty()) {
            return null;
        }
        String string = pSSFPubOjb.getPSSFName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSFName_Default(pSSFPubOjb, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSFNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSFPubObjId(boolean bl, PSSFPubOjb pSSFPubOjb, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSFPubOjb.isPSSFPubObjIdDirty() && !bl2 : !pSSFPubOjb.isPSSFPubObjIdDirty()) {
            return null;
        }
        String string = pSSFPubOjb.getPSSFPubObjId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSFPUBOBJID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSFPubObjId_Default(pSSFPubOjb, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSFPUBOBJID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSFPubObjName(boolean bl, PSSFPubOjb pSSFPubOjb, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSFPubOjb.isPSSFPubObjNameDirty() && !bl2 : !pSSFPubOjb.isPSSFPubObjNameDirty()) {
            return null;
        }
        String string = pSSFPubOjb.getPSSFPubObjName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSFPUBOBJNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSFPubObjName_Default(pSSFPubOjb, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSFPUBOBJNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSFStyleId(boolean bl, PSSFPubOjb pSSFPubOjb, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSFPubOjb.isPSSFStyleIdDirty() : !pSSFPubOjb.isPSSFStyleIdDirty()) {
            return null;
        }
        String string = pSSFPubOjb.getPSSFStyleId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSFStyleId_Default(pSSFPubOjb, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSFSTYLEID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSFStyleName(boolean bl, PSSFPubOjb pSSFPubOjb, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSFPubOjb.isPSSFStyleNameDirty() : !pSSFPubOjb.isPSSFStyleNameDirty()) {
            return null;
        }
        String string = pSSFPubOjb.getPSSFStyleName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSFStyleName_Default(pSSFPubOjb, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSFSTYLENAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PubObj(boolean bl, PSSFPubOjb pSSFPubOjb, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSFPubOjb.isPubObjDirty() && !bl2 : !pSSFPubOjb.isPubObjDirty()) {
            return null;
        }
        String string = pSSFPubOjb.getPubObj();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PUBOBJ");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PubObj_Default(pSSFPubOjb, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PUBOBJ");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PubObjTag(boolean bl, PSSFPubOjb pSSFPubOjb, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSFPubOjb.isPubObjTagDirty() : !pSSFPubOjb.isPubObjTagDirty()) {
            return null;
        }
        String string = pSSFPubOjb.getPubObjTag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PubObjTag_Default(pSSFPubOjb, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PUBOBJTAG");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PubObjTag2(boolean bl, PSSFPubOjb pSSFPubOjb, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSFPubOjb.isPubObjTag2Dirty() : !pSSFPubOjb.isPubObjTag2Dirty()) {
            return null;
        }
        String string = pSSFPubOjb.getPubObjTag2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PubObjTag2_Default(pSSFPubOjb, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PUBOBJTAG2");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Target(boolean bl, PSSFPubOjb pSSFPubOjb, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSFPubOjb.isTargetDirty() && !bl2 : !pSSFPubOjb.isTargetDirty()) {
            return null;
        }
        String string = pSSFPubOjb.getTarget();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("TARGET");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_Target_Default(pSSFPubOjb, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("TARGET");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ValidFlag(boolean bl, PSSFPubOjb pSSFPubOjb, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSFPubOjb.isValidFlagDirty() && !bl2 : !pSSFPubOjb.isValidFlagDirty()) {
            return null;
        }
        Integer n = pSSFPubOjb.getValidFlag();
        if (bl) {
            if (bl2 && n == null) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("VALIDFLAG");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string = null;
            string = this.onTestValueRule_ValidFlag_Default(pSSFPubOjb, bl2, bl3);
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

    protected void onSyncEntity(PSSFPubOjb pSSFPubOjb, boolean bl) throws Exception {
        super.onSyncEntity(pSSFPubOjb, bl);
    }

    protected void onSyncIndexEntities(PSSFPubOjb pSSFPubOjb, boolean bl) throws Exception {
        super.onSyncIndexEntities(pSSFPubOjb, bl);
    }

    public Object getDataContextValue(PSSFPubOjb pSSFPubOjb, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null) {
            // empty if block
        }
        if ((object = super.getDataContextValue(pSSFPubOjb, string, iDataContextParam)) != null) {
            return object;
        }
        return null;
    }

    protected void onExportMajorModel(PSSFPubOjb pSSFPubOjb, ArrayList<JSONObject> arrayList, int n) throws Exception {
        super.onExportMajorModel(pSSFPubOjb, arrayList, n);
    }

    protected String onTestValueRule(String string, String string2, IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        if (StringHelper.compare((String)string, (String)"CREATEDATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateDate_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATEMAN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateMan_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MACROPARAMS", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_MacroParams_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MEMO", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Memo_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PPSSFPUBOBJID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PPSSFPubObjId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PPSSFPUBOBJNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PPSSFPubObjName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSFID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSFId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSFNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSFName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSFPUBOBJID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSFPubObjId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSFPUBOBJNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSFPubObjName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSFSTYLEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSFStyleId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSFSTYLENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSFStyleName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PUBOBJ", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PubObj_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PUBOBJTAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PubObjTag_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PUBOBJTAG2", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PubObjTag2_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"TARGET", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Target_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UPDATEDATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UpdateDate_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UPDATEMAN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UpdateMan_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"VALIDFLAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ValidFlag_Default(iEntity, bl, bl2);
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

    protected String onTestValueRule_MacroParams_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("MACROPARAMS", iEntity, bl2, null, false, 2000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[2000]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[2000]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_Memo_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("MEMO", iEntity, bl2, null, false, 4000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[4000]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[4000]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PPSSFPubObjId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PPSSFPUBOBJID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PPSSFPubObjName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PPSSFPUBOBJNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSFId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSFID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSFName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSFNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSFPubObjId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSFPUBOBJID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSFPubObjName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSFPUBOBJNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSFStyleId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSFSTYLEID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSFStyleName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSFSTYLENAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PubObj_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PUBOBJ", iEntity, bl2, null, false, 250, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[250]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[250]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PubObjTag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PUBOBJTAG", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PubObjTag2_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PUBOBJTAG2", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_Target_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("TARGET", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
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

    protected String onTestValueRule_ValidFlag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected boolean onMergeChild(String string, String string2, PSSFPubOjb pSSFPubOjb) throws Exception {
        boolean bl = false;
        if (super.onMergeChild(string, string2, pSSFPubOjb)) {
            bl = true;
        }
        return bl;
    }

    protected void onUpdateParent(PSSFPubOjb pSSFPubOjb) throws Exception {
        super.onUpdateParent(pSSFPubOjb);
    }

    @Override
    protected void exportCurXmlModel(PSSFPubOjb pSSFPubOjb, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSSFPUBOJB");
        if (!bl) {
            pSSFPubOjb.setCreateDate(null);
            pSSFPubOjb.setCreateMan(null);
            pSSFPubOjb.setPSSFPubObjId(null);
            pSSFPubOjb.setUpdateDate(null);
            pSSFPubOjb.setUpdateMan(null);
            super.exportCurXmlModel(pSSFPubOjb, xmlNode, bl);
        }
    }
}

