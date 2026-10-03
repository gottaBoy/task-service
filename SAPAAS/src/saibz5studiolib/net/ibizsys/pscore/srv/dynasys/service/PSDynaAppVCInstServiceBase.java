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
package net.ibizsys.pscore.srv.dynasys.service;

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
import net.ibizsys.pscore.srv.core.IPSDataEntityModel;
import net.ibizsys.pscore.srv.dynasys.dao.PSDynaAppVCInstDAO;
import net.ibizsys.pscore.srv.dynasys.demodel.PSDynaAppVCInstDEModel;
import net.ibizsys.pscore.srv.dynasys.entity.PSDynaAppVCInst;
import net.ibizsys.pscore.srv.dynasys.entity.PSDynaAppViewCtrl;
import net.ibizsys.pscore.srv.dynasys.entity.PSDynaAppViewCtrlBase;
import net.ibizsys.pscore.srv.dynasys.entity.PSDynaAppViewInst;
import net.ibizsys.pscore.srv.dynasys.entity.PSDynaAppViewInstBase;
import net.ibizsys.pscore.srv.dynasys.entity.PSDynaDEFormInst;
import net.ibizsys.pscore.srv.dynasys.entity.PSDynaDEFormInstBase;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDynaAppVCInstServiceBase
extends PSCoreSysServiceBase<PSDynaAppVCInst> {
    private static final Log log = LogFactory.getLog(PSDynaAppVCInstServiceBase.class);
    public static final String DATASET_DEFAULT = "DEFAULT";
    private PSDynaAppVCInstDEModel pSDynaAppVCInstDEModel;
    private PSDynaAppVCInstDAO pSDynaAppVCInstDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.dynasys.service.PSDynaAppVCInstService";
    }

    public PSDynaAppVCInstDEModel getPSDynaAppVCInstDEModel() {
        if (this.pSDynaAppVCInstDEModel == null) {
            try {
                this.pSDynaAppVCInstDEModel = (PSDynaAppVCInstDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.dynasys.demodel.PSDynaAppVCInstDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDynaAppVCInstDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSDynaAppVCInstDEModel();
    }

    public PSDynaAppVCInstDAO getPSDynaAppVCInstDAO() {
        if (this.pSDynaAppVCInstDAO == null) {
            try {
                this.pSDynaAppVCInstDAO = (PSDynaAppVCInstDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.dynasys.dao.PSDynaAppVCInstDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDynaAppVCInstDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSDynaAppVCInstDAO();
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

    protected void onFillParentInfo(PSDynaAppVCInst pSDynaAppVCInst, String string, String string2, String string3) throws Exception {
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDYNAAPPVCINST_PSDYNAAPPVIEWCTRL_PSDYNAAPPVIEWCTRLID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dynasys.service.PSDynaAppViewCtrlService", (SessionFactory)this.getSessionFactory());
            PSDynaAppViewCtrl pSDynaAppViewCtrl = (PSDynaAppViewCtrl)iService.getDEModel().createEntity();
            pSDynaAppViewCtrl.set("PSDYNAAPPVIEWCTRLID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDynaAppViewCtrl);
            } else {
                iService.get(pSDynaAppViewCtrl);
            }
            this.onFillParentInfo_PSDynaAppViewCtrl(pSDynaAppVCInst, pSDynaAppViewCtrl);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDYNAAPPVCINST_PSDYNAAPPVIEWINST_PSDYNAAPPVIEWINSTID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dynasys.service.PSDynaAppViewInstService", (SessionFactory)this.getSessionFactory());
            PSDynaAppViewInst pSDynaAppViewInst = (PSDynaAppViewInst)iService.getDEModel().createEntity();
            pSDynaAppViewInst.set("PSDYNAAPPVIEWINSTID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDynaAppViewInst);
            } else {
                iService.get(pSDynaAppViewInst);
            }
            this.onFillParentInfo_PSDynaAppViewInst(pSDynaAppVCInst, pSDynaAppViewInst);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDYNAAPPVCINST_PSDYNADEFORMINST_PSDYNADEFORMINSTID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dynasys.service.PSDynaDEFormInstService", (SessionFactory)this.getSessionFactory());
            PSDynaDEFormInst pSDynaDEFormInst = (PSDynaDEFormInst)iService.getDEModel().createEntity();
            pSDynaDEFormInst.set("PSDYNADEFORMINSTID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDynaDEFormInst);
            } else {
                iService.get(pSDynaDEFormInst);
            }
            this.onFillParentInfo_PSDynaDEForm(pSDynaAppVCInst, pSDynaDEFormInst);
            return;
        }
        super.onFillParentInfo(pSDynaAppVCInst, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillParentInfo_PSDynaAppViewCtrl(PSDynaAppVCInst pSDynaAppVCInst, PSDynaAppViewCtrl pSDynaAppViewCtrl) throws Exception {
        pSDynaAppVCInst.setPSDynaAppViewCtrlId(pSDynaAppViewCtrl.getPSDynaAppViewCtrlId());
        pSDynaAppVCInst.setPSDynaAppViewCtrlName(pSDynaAppViewCtrl.getPSDynaAppViewCtrlName());
    }

    protected void onFillParentInfo_PSDynaAppViewInst(PSDynaAppVCInst pSDynaAppVCInst, PSDynaAppViewInst pSDynaAppViewInst) throws Exception {
        pSDynaAppVCInst.setPSDynaAppViewInstId(pSDynaAppViewInst.getPSDynaAppViewInstId());
        pSDynaAppVCInst.setPSDynaAppViewInstName(pSDynaAppViewInst.getPSDynaAppViewInstName());
    }

    protected void onFillParentInfo_PSDynaDEForm(PSDynaAppVCInst pSDynaAppVCInst, PSDynaDEFormInst pSDynaDEFormInst) throws Exception {
        pSDynaAppVCInst.setPSDynaDEFormInstId(pSDynaDEFormInst.getPSDynaDEFormInstId());
        pSDynaAppVCInst.setPSDynaDEFormInstName(pSDynaDEFormInst.getPSDynaDEFormInstName());
    }

    protected void onFillEntityFullInfo(PSDynaAppVCInst pSDynaAppVCInst, boolean bl) throws Exception {
        if (bl) {
            // empty if block
        }
        super.onFillEntityFullInfo(pSDynaAppVCInst, bl);
        this.onFillEntityFullInfo_PSDynaAppViewCtrl(pSDynaAppVCInst, bl);
        this.onFillEntityFullInfo_PSDynaAppViewInst(pSDynaAppVCInst, bl);
        this.onFillEntityFullInfo_PSDynaDEForm(pSDynaAppVCInst, bl);
    }

    protected void onFillEntityFullInfo_PSDynaAppViewCtrl(PSDynaAppVCInst pSDynaAppVCInst, boolean bl) throws Exception {
        if (pSDynaAppVCInst.isPSDynaAppViewCtrlIdDirty()) {
            if (pSDynaAppVCInst.getPSDynaAppViewCtrlId() != null) {
                if (pSDynaAppVCInst.getPSDynaAppViewCtrlId() == null || pSDynaAppVCInst.getPSDynaAppViewCtrlName() == null) {
                    PSDynaAppViewCtrl pSDynaAppViewCtrl = pSDynaAppVCInst.getPSDynaAppViewCtrl();
                    pSDynaAppVCInst.setPSDynaAppViewCtrlName(pSDynaAppViewCtrl.getPSDynaAppViewCtrlName());
                }
            } else {
                pSDynaAppVCInst.setPSDynaAppViewCtrlName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_PSDynaAppViewInst(PSDynaAppVCInst pSDynaAppVCInst, boolean bl) throws Exception {
        if (pSDynaAppVCInst.isPSDynaAppViewInstIdDirty()) {
            if (pSDynaAppVCInst.getPSDynaAppViewInstId() != null) {
                if (pSDynaAppVCInst.getPSDynaAppViewInstId() == null || pSDynaAppVCInst.getPSDynaAppViewInstName() == null) {
                    PSDynaAppViewInst pSDynaAppViewInst = pSDynaAppVCInst.getPSDynaAppViewInst();
                    pSDynaAppVCInst.setPSDynaAppViewInstName(pSDynaAppViewInst.getPSDynaAppViewInstName());
                }
            } else {
                pSDynaAppVCInst.setPSDynaAppViewInstName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_PSDynaDEForm(PSDynaAppVCInst pSDynaAppVCInst, boolean bl) throws Exception {
        if (pSDynaAppVCInst.isPSDynaDEFormInstIdDirty()) {
            if (pSDynaAppVCInst.getPSDynaDEFormInstId() != null) {
                if (pSDynaAppVCInst.getPSDynaDEFormInstId() == null || pSDynaAppVCInst.getPSDynaDEFormInstName() == null) {
                    PSDynaDEFormInst pSDynaDEFormInst = pSDynaAppVCInst.getPSDynaDEForm();
                    pSDynaAppVCInst.setPSDynaDEFormInstName(pSDynaDEFormInst.getPSDynaDEFormInstName());
                }
            } else {
                pSDynaAppVCInst.setPSDynaDEFormInstName(null);
            }
        }
    }

    protected void onWriteBackParent(PSDynaAppVCInst pSDynaAppVCInst, boolean bl) throws Exception {
        super.onWriteBackParent(pSDynaAppVCInst, bl);
    }

    public ArrayList<PSDynaAppVCInst> selectByPSDynaAppViewCtrl(PSDynaAppViewCtrlBase pSDynaAppViewCtrlBase) throws Exception {
        return this.selectByPSDynaAppViewCtrl(pSDynaAppViewCtrlBase, "", -1);
    }

    public ArrayList<PSDynaAppVCInst> selectByPSDynaAppViewCtrl(PSDynaAppViewCtrlBase pSDynaAppViewCtrlBase, String string) throws Exception {
        return this.selectByPSDynaAppViewCtrl(pSDynaAppViewCtrlBase, string, -1);
    }

    public ArrayList<PSDynaAppVCInst> selectByPSDynaAppViewCtrl(PSDynaAppViewCtrlBase pSDynaAppViewCtrlBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDYNAAPPVIEWCTRLID", (Object)pSDynaAppViewCtrlBase.getPSDynaAppViewCtrlId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSDynaAppViewCtrlCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSDynaAppViewCtrlCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDynaAppVCInst> selectByPSDynaAppViewInst(PSDynaAppViewInstBase pSDynaAppViewInstBase) throws Exception {
        return this.selectByPSDynaAppViewInst(pSDynaAppViewInstBase, "", -1);
    }

    public ArrayList<PSDynaAppVCInst> selectByPSDynaAppViewInst(PSDynaAppViewInstBase pSDynaAppViewInstBase, String string) throws Exception {
        return this.selectByPSDynaAppViewInst(pSDynaAppViewInstBase, string, -1);
    }

    public ArrayList<PSDynaAppVCInst> selectByPSDynaAppViewInst(PSDynaAppViewInstBase pSDynaAppViewInstBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDYNAAPPVIEWINSTID", (Object)pSDynaAppViewInstBase.getPSDynaAppViewInstId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSDynaAppViewInstCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSDynaAppViewInstCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDynaAppVCInst> selectByPSDynaDEForm(PSDynaDEFormInstBase pSDynaDEFormInstBase) throws Exception {
        return this.selectByPSDynaDEForm(pSDynaDEFormInstBase, "", -1);
    }

    public ArrayList<PSDynaAppVCInst> selectByPSDynaDEForm(PSDynaDEFormInstBase pSDynaDEFormInstBase, String string) throws Exception {
        return this.selectByPSDynaDEForm(pSDynaDEFormInstBase, string, -1);
    }

    public ArrayList<PSDynaAppVCInst> selectByPSDynaDEForm(PSDynaDEFormInstBase pSDynaDEFormInstBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDYNADEFORMINSTID", (Object)pSDynaDEFormInstBase.getPSDynaDEFormInstId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSDynaDEFormCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSDynaDEFormCond(SelectCond selectCond) throws Exception {
    }

    public void testRemoveByPSDynaAppViewCtrl(PSDynaAppViewCtrl pSDynaAppViewCtrl) throws Exception {
        ArrayList<PSDynaAppVCInst> arrayList = this.selectByPSDynaAppViewCtrl(pSDynaAppViewCtrl, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDYNAAPPVIEWCTRL");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDynaAppViewCtrl);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDYNAAPPVCINST_PSDYNAAPPVIEWCTRL_PSDYNAAPPVIEWCTRLID", "", iDataEntityModel.getName(), "PSDYNAAPPVCINST", iDataEntityModel.getDataInfo(pSDynaAppViewCtrl), arrayList.get(0)));
        }
    }

    public void resetPSDynaAppViewCtrl(PSDynaAppViewCtrl pSDynaAppViewCtrl) throws Exception {
        ArrayList<PSDynaAppVCInst> arrayList = this.selectByPSDynaAppViewCtrl(pSDynaAppViewCtrl);
        for (PSDynaAppVCInst pSDynaAppVCInst : arrayList) {
            PSDynaAppVCInst pSDynaAppVCInst2 = (PSDynaAppVCInst)this.getDEModel().createEntity();
            pSDynaAppVCInst2.setPSDynaAppVCInstId(pSDynaAppVCInst.getPSDynaAppVCInstId());
            pSDynaAppVCInst2.setPSDynaAppViewCtrlId(null);
            this.update(pSDynaAppVCInst2);
        }
    }

    public void removeByPSDynaAppViewCtrl(PSDynaAppViewCtrl pSDynaAppViewCtrl) throws Exception {
        final PSDynaAppViewCtrl pSDynaAppViewCtrl2 = pSDynaAppViewCtrl;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDynaAppVCInstServiceBase.this.onBeforeRemoveByPSDynaAppViewCtrl(pSDynaAppViewCtrl2);
                PSDynaAppVCInstServiceBase.this.internalRemoveByPSDynaAppViewCtrl(pSDynaAppViewCtrl2);
                PSDynaAppVCInstServiceBase.this.onAfterRemoveByPSDynaAppViewCtrl(pSDynaAppViewCtrl2);
            }
        });
    }

    protected void onBeforeRemoveByPSDynaAppViewCtrl(PSDynaAppViewCtrl pSDynaAppViewCtrl) throws Exception {
    }

    protected void internalRemoveByPSDynaAppViewCtrl(PSDynaAppViewCtrl pSDynaAppViewCtrl) throws Exception {
        ArrayList<PSDynaAppVCInst> arrayList = this.selectByPSDynaAppViewCtrl(pSDynaAppViewCtrl);
        this.onBeforeRemoveByPSDynaAppViewCtrl(pSDynaAppViewCtrl, arrayList);
        for (PSDynaAppVCInst pSDynaAppVCInst : arrayList) {
            this.remove(pSDynaAppVCInst);
        }
        this.onAfterRemoveByPSDynaAppViewCtrl(pSDynaAppViewCtrl, arrayList);
    }

    protected void onAfterRemoveByPSDynaAppViewCtrl(PSDynaAppViewCtrl pSDynaAppViewCtrl) throws Exception {
    }

    protected void onBeforeRemoveByPSDynaAppViewCtrl(PSDynaAppViewCtrl pSDynaAppViewCtrl, ArrayList<PSDynaAppVCInst> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDynaAppViewCtrl(PSDynaAppViewCtrl pSDynaAppViewCtrl, ArrayList<PSDynaAppVCInst> arrayList) throws Exception {
    }

    public void testRemoveByPSDynaAppViewInst(PSDynaAppViewInst pSDynaAppViewInst) throws Exception {
    }

    public void resetPSDynaAppViewInst(PSDynaAppViewInst pSDynaAppViewInst) throws Exception {
        ArrayList<PSDynaAppVCInst> arrayList = this.selectByPSDynaAppViewInst(pSDynaAppViewInst);
        for (PSDynaAppVCInst pSDynaAppVCInst : arrayList) {
            PSDynaAppVCInst pSDynaAppVCInst2 = (PSDynaAppVCInst)this.getDEModel().createEntity();
            pSDynaAppVCInst2.setPSDynaAppVCInstId(pSDynaAppVCInst.getPSDynaAppVCInstId());
            pSDynaAppVCInst2.setPSDynaAppViewInstId(null);
            this.update(pSDynaAppVCInst2);
        }
    }

    public void removeByPSDynaAppViewInst(PSDynaAppViewInst pSDynaAppViewInst) throws Exception {
        final PSDynaAppViewInst pSDynaAppViewInst2 = pSDynaAppViewInst;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDynaAppVCInstServiceBase.this.onBeforeRemoveByPSDynaAppViewInst(pSDynaAppViewInst2);
                PSDynaAppVCInstServiceBase.this.internalRemoveByPSDynaAppViewInst(pSDynaAppViewInst2);
                PSDynaAppVCInstServiceBase.this.onAfterRemoveByPSDynaAppViewInst(pSDynaAppViewInst2);
            }
        });
    }

    protected void onBeforeRemoveByPSDynaAppViewInst(PSDynaAppViewInst pSDynaAppViewInst) throws Exception {
    }

    protected void internalRemoveByPSDynaAppViewInst(PSDynaAppViewInst pSDynaAppViewInst) throws Exception {
        ArrayList<PSDynaAppVCInst> arrayList = this.selectByPSDynaAppViewInst(pSDynaAppViewInst);
        this.onBeforeRemoveByPSDynaAppViewInst(pSDynaAppViewInst, arrayList);
        for (PSDynaAppVCInst pSDynaAppVCInst : arrayList) {
            this.remove(pSDynaAppVCInst);
        }
        this.onAfterRemoveByPSDynaAppViewInst(pSDynaAppViewInst, arrayList);
    }

    protected void onAfterRemoveByPSDynaAppViewInst(PSDynaAppViewInst pSDynaAppViewInst) throws Exception {
    }

    protected void onBeforeRemoveByPSDynaAppViewInst(PSDynaAppViewInst pSDynaAppViewInst, ArrayList<PSDynaAppVCInst> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDynaAppViewInst(PSDynaAppViewInst pSDynaAppViewInst, ArrayList<PSDynaAppVCInst> arrayList) throws Exception {
    }

    public void testRemoveByPSDynaDEForm(PSDynaDEFormInst pSDynaDEFormInst) throws Exception {
        ArrayList<PSDynaAppVCInst> arrayList = this.selectByPSDynaDEForm(pSDynaDEFormInst, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDYNADEFORMINST");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDynaDEFormInst);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDYNAAPPVCINST_PSDYNADEFORMINST_PSDYNADEFORMINSTID", "", iDataEntityModel.getName(), "PSDYNAAPPVCINST", iDataEntityModel.getDataInfo(pSDynaDEFormInst), arrayList.get(0)));
        }
    }

    public void resetPSDynaDEForm(PSDynaDEFormInst pSDynaDEFormInst) throws Exception {
        ArrayList<PSDynaAppVCInst> arrayList = this.selectByPSDynaDEForm(pSDynaDEFormInst);
        for (PSDynaAppVCInst pSDynaAppVCInst : arrayList) {
            PSDynaAppVCInst pSDynaAppVCInst2 = (PSDynaAppVCInst)this.getDEModel().createEntity();
            pSDynaAppVCInst2.setPSDynaAppVCInstId(pSDynaAppVCInst.getPSDynaAppVCInstId());
            pSDynaAppVCInst2.setPSDynaDEFormInstId(null);
            this.update(pSDynaAppVCInst2);
        }
    }

    public void removeByPSDynaDEForm(PSDynaDEFormInst pSDynaDEFormInst) throws Exception {
        final PSDynaDEFormInst pSDynaDEFormInst2 = pSDynaDEFormInst;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDynaAppVCInstServiceBase.this.onBeforeRemoveByPSDynaDEForm(pSDynaDEFormInst2);
                PSDynaAppVCInstServiceBase.this.internalRemoveByPSDynaDEForm(pSDynaDEFormInst2);
                PSDynaAppVCInstServiceBase.this.onAfterRemoveByPSDynaDEForm(pSDynaDEFormInst2);
            }
        });
    }

    protected void onBeforeRemoveByPSDynaDEForm(PSDynaDEFormInst pSDynaDEFormInst) throws Exception {
    }

    protected void internalRemoveByPSDynaDEForm(PSDynaDEFormInst pSDynaDEFormInst) throws Exception {
        ArrayList<PSDynaAppVCInst> arrayList = this.selectByPSDynaDEForm(pSDynaDEFormInst);
        this.onBeforeRemoveByPSDynaDEForm(pSDynaDEFormInst, arrayList);
        for (PSDynaAppVCInst pSDynaAppVCInst : arrayList) {
            this.remove(pSDynaAppVCInst);
        }
        this.onAfterRemoveByPSDynaDEForm(pSDynaDEFormInst, arrayList);
    }

    protected void onAfterRemoveByPSDynaDEForm(PSDynaDEFormInst pSDynaDEFormInst) throws Exception {
    }

    protected void onBeforeRemoveByPSDynaDEForm(PSDynaDEFormInst pSDynaDEFormInst, ArrayList<PSDynaAppVCInst> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDynaDEForm(PSDynaDEFormInst pSDynaDEFormInst, ArrayList<PSDynaAppVCInst> arrayList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(PSDynaAppVCInst pSDynaAppVCInst) throws Exception {
        super.onBeforeRemove(pSDynaAppVCInst);
    }

    protected void replaceParentInfo(PSDynaAppVCInst pSDynaAppVCInst, CloneSession cloneSession) throws Exception {
        IEntity iEntity;
        super.replaceParentInfo(pSDynaAppVCInst, cloneSession);
        if (pSDynaAppVCInst.getPSDynaAppViewCtrlId() != null && (iEntity = cloneSession.getEntity("PSDYNAAPPVIEWCTRL", (Object)pSDynaAppVCInst.getPSDynaAppViewCtrlId())) != null) {
            this.onFillParentInfo_PSDynaAppViewCtrl(pSDynaAppVCInst, (PSDynaAppViewCtrl)iEntity);
        }
        if (pSDynaAppVCInst.getPSDynaAppViewInstId() != null && (iEntity = cloneSession.getEntity("PSDYNAAPPVIEWINST", (Object)pSDynaAppVCInst.getPSDynaAppViewInstId())) != null) {
            this.onFillParentInfo_PSDynaAppViewInst(pSDynaAppVCInst, (PSDynaAppViewInst)iEntity);
        }
        if (pSDynaAppVCInst.getPSDynaDEFormInstId() != null && (iEntity = cloneSession.getEntity("PSDYNADEFORMINST", (Object)pSDynaAppVCInst.getPSDynaDEFormInstId())) != null) {
            this.onFillParentInfo_PSDynaDEForm(pSDynaAppVCInst, (PSDynaDEFormInst)iEntity);
        }
    }

    protected void onRemoveEntityUncopyValues(PSDynaAppVCInst pSDynaAppVCInst, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues(pSDynaAppVCInst, bl);
    }

    protected void onCheckEntity(boolean bl, PSDynaAppVCInst pSDynaAppVCInst, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_CtrlType(bl, pSDynaAppVCInst, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Memo(bl, pSDynaAppVCInst, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDynaAppVCInstId(bl, pSDynaAppVCInst, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDynaAppVCInstName(bl, pSDynaAppVCInst, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDynaAppViewCtrlId(bl, pSDynaAppVCInst, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDynaAppViewCtrlName(bl, pSDynaAppVCInst, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDynaAppViewInstId(bl, pSDynaAppVCInst, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDynaAppViewInstName(bl, pSDynaAppVCInst, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDynaDEFormInstId(bl, pSDynaAppVCInst, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDynaDEFormInstName(bl, pSDynaAppVCInst, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, pSDynaAppVCInst, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_CtrlType(boolean bl, PSDynaAppVCInst pSDynaAppVCInst, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDynaAppVCInst.isCtrlTypeDirty() && !bl2 : !pSDynaAppVCInst.isCtrlTypeDirty()) {
            return null;
        }
        String string = pSDynaAppVCInst.getCtrlType();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CTRLTYPE");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_CtrlType_Default(pSDynaAppVCInst, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CTRLTYPE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Memo(boolean bl, PSDynaAppVCInst pSDynaAppVCInst, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDynaAppVCInst.isMemoDirty() : !pSDynaAppVCInst.isMemoDirty()) {
            return null;
        }
        String string = pSDynaAppVCInst.getMemo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Memo_Default(pSDynaAppVCInst, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDynaAppVCInstId(boolean bl, PSDynaAppVCInst pSDynaAppVCInst, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDynaAppVCInst.isPSDynaAppVCInstIdDirty() && !bl2 : !pSDynaAppVCInst.isPSDynaAppVCInstIdDirty()) {
            return null;
        }
        String string = pSDynaAppVCInst.getPSDynaAppVCInstId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDYNAAPPVCINSTID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDynaAppVCInstId_Default(pSDynaAppVCInst, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDYNAAPPVCINSTID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDynaAppVCInstName(boolean bl, PSDynaAppVCInst pSDynaAppVCInst, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDynaAppVCInst.isPSDynaAppVCInstNameDirty() && !bl2 : !pSDynaAppVCInst.isPSDynaAppVCInstNameDirty()) {
            return null;
        }
        String string = pSDynaAppVCInst.getPSDynaAppVCInstName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDYNAAPPVCINSTNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDynaAppVCInstName_Default(pSDynaAppVCInst, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDYNAAPPVCINSTNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDynaAppViewCtrlId(boolean bl, PSDynaAppVCInst pSDynaAppVCInst, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDynaAppVCInst.isPSDynaAppViewCtrlIdDirty() && !bl2 : !pSDynaAppVCInst.isPSDynaAppViewCtrlIdDirty()) {
            return null;
        }
        String string = pSDynaAppVCInst.getPSDynaAppViewCtrlId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDYNAAPPVIEWCTRLID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDynaAppViewCtrlId_Default(pSDynaAppVCInst, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDYNAAPPVIEWCTRLID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDynaAppViewCtrlName(boolean bl, PSDynaAppVCInst pSDynaAppVCInst, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDynaAppVCInst.isPSDynaAppViewCtrlNameDirty() && !bl2 : !pSDynaAppVCInst.isPSDynaAppViewCtrlNameDirty()) {
            return null;
        }
        String string = pSDynaAppVCInst.getPSDynaAppViewCtrlName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDYNAAPPVIEWCTRLNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDynaAppViewCtrlName_Default(pSDynaAppVCInst, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDYNAAPPVIEWCTRLNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDynaAppViewInstId(boolean bl, PSDynaAppVCInst pSDynaAppVCInst, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDynaAppVCInst.isPSDynaAppViewInstIdDirty() && !bl2 : !pSDynaAppVCInst.isPSDynaAppViewInstIdDirty()) {
            return null;
        }
        String string = pSDynaAppVCInst.getPSDynaAppViewInstId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDYNAAPPVIEWINSTID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDynaAppViewInstId_Default(pSDynaAppVCInst, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDYNAAPPVIEWINSTID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDynaAppViewInstName(boolean bl, PSDynaAppVCInst pSDynaAppVCInst, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDynaAppVCInst.isPSDynaAppViewInstNameDirty() && !bl2 : !pSDynaAppVCInst.isPSDynaAppViewInstNameDirty()) {
            return null;
        }
        String string = pSDynaAppVCInst.getPSDynaAppViewInstName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDYNAAPPVIEWINSTNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDynaAppViewInstName_Default(pSDynaAppVCInst, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDYNAAPPVIEWINSTNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDynaDEFormInstId(boolean bl, PSDynaAppVCInst pSDynaAppVCInst, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDynaAppVCInst.isPSDynaDEFormInstIdDirty() : !pSDynaAppVCInst.isPSDynaDEFormInstIdDirty()) {
            return null;
        }
        String string = pSDynaAppVCInst.getPSDynaDEFormInstId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDynaDEFormInstId_Default(pSDynaAppVCInst, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDYNADEFORMINSTID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDynaDEFormInstName(boolean bl, PSDynaAppVCInst pSDynaAppVCInst, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDynaAppVCInst.isPSDynaDEFormInstNameDirty() : !pSDynaAppVCInst.isPSDynaDEFormInstNameDirty()) {
            return null;
        }
        String string = pSDynaAppVCInst.getPSDynaDEFormInstName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDynaDEFormInstName_Default(pSDynaAppVCInst, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDYNADEFORMINSTNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected void onSyncEntity(PSDynaAppVCInst pSDynaAppVCInst, boolean bl) throws Exception {
        super.onSyncEntity(pSDynaAppVCInst, bl);
    }

    protected void onSyncIndexEntities(PSDynaAppVCInst pSDynaAppVCInst, boolean bl) throws Exception {
        super.onSyncIndexEntities(pSDynaAppVCInst, bl);
    }

    public Object getDataContextValue(PSDynaAppVCInst pSDynaAppVCInst, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null) {
            // empty if block
        }
        if ((object = super.getDataContextValue(pSDynaAppVCInst, string, iDataContextParam)) != null) {
            return object;
        }
        PSDynaAppViewInst pSDynaAppViewInst = pSDynaAppVCInst.getPSDynaAppViewInst();
        if (pSDynaAppViewInst != null && pSDynaAppViewInst.contains(string)) {
            return pSDynaAppViewInst.get(string);
        }
        return null;
    }

    protected void onExportMajorModel(PSDynaAppVCInst pSDynaAppVCInst, ArrayList<JSONObject> arrayList, int n) throws Exception {
        super.onExportMajorModel(pSDynaAppVCInst, arrayList, n);
    }

    protected String onTestValueRule(String string, String string2, IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        if (StringHelper.compare((String)string, (String)"CREATEDATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateDate_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATEMAN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateMan_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CTRLTYPE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CtrlType_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MEMO", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Memo_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDYNAAPPVCINSTID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDynaAppVCInstId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDYNAAPPVCINSTNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDynaAppVCInstName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDYNAAPPVIEWCTRLID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDynaAppViewCtrlId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDYNAAPPVIEWCTRLNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDynaAppViewCtrlName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDYNAAPPVIEWINSTID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDynaAppViewInstId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDYNAAPPVIEWINSTNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDynaAppViewInstName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDYNADEFORMINSTID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDynaDEFormInstId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDYNADEFORMINSTNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDynaDEFormInstName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UPDATEDATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UpdateDate_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UPDATEMAN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
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

    protected String onTestValueRule_CtrlType_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("CTRLTYPE", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
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

    protected String onTestValueRule_PSDynaAppVCInstId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDYNAAPPVCINSTID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDynaAppVCInstName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDYNAAPPVCINSTNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDynaAppViewCtrlId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDYNAAPPVIEWCTRLID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDynaAppViewCtrlName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDYNAAPPVIEWCTRLNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDynaAppViewInstId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDYNAAPPVIEWINSTID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDynaAppViewInstName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDYNAAPPVIEWINSTNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDynaDEFormInstId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDYNADEFORMINSTID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDynaDEFormInstName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDYNADEFORMINSTNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
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

    protected boolean onMergeChild(String string, String string2, PSDynaAppVCInst pSDynaAppVCInst) throws Exception {
        boolean bl = false;
        if (super.onMergeChild(string, string2, pSDynaAppVCInst)) {
            bl = true;
        }
        return bl;
    }

    protected void onUpdateParent(PSDynaAppVCInst pSDynaAppVCInst) throws Exception {
        super.onUpdateParent(pSDynaAppVCInst);
    }

    @Override
    protected void exportCurXmlModel(PSDynaAppVCInst pSDynaAppVCInst, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSDYNAAPPVCINST");
        if (!bl) {
            pSDynaAppVCInst.setCreateDate(null);
            pSDynaAppVCInst.setCreateMan(null);
            pSDynaAppVCInst.setCtrlType(null);
            pSDynaAppVCInst.setPSDynaAppVCInstId(null);
            pSDynaAppVCInst.setPSDynaAppViewCtrlId(null);
            pSDynaAppVCInst.setPSDynaAppViewCtrlName(null);
            pSDynaAppVCInst.setUpdateDate(null);
            pSDynaAppVCInst.setUpdateMan(null);
            super.exportCurXmlModel(pSDynaAppVCInst, xmlNode, bl);
        }
    }

    @Override
    public Object getDataType(PSDynaAppVCInst pSDynaAppVCInst) throws Exception {
        return pSDynaAppVCInst.getCtrlType();
    }
}

