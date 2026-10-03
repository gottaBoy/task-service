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
 *  net.ibizsys.paas.service.IServicePlugin
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
import net.ibizsys.paas.service.IServicePlugin;
import net.ibizsys.paas.service.IServiceWork;
import net.ibizsys.paas.service.ITransaction;
import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.paas.util.DataTypeHelper;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.xml.XmlNode;
import net.ibizsys.pscore.srv.PSCoreSysServiceBase;
import net.ibizsys.pscore.srv.core.IPSDataEntityModel;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEForm;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEFormBase;
import net.ibizsys.pscore.srv.dynasys.dao.PSDynaDEFormInstDAO;
import net.ibizsys.pscore.srv.dynasys.demodel.PSDynaDEFormInstDEModel;
import net.ibizsys.pscore.srv.dynasys.entity.PSDynaDEForm;
import net.ibizsys.pscore.srv.dynasys.entity.PSDynaDEFormBase;
import net.ibizsys.pscore.srv.dynasys.entity.PSDynaDEFormInst;
import net.ibizsys.pscore.srv.dynasys.entity.PSDynaInst;
import net.ibizsys.pscore.srv.dynasys.entity.PSDynaInstBase;
import net.ibizsys.pscore.srv.dynasys.service.PSDynaAppVCInstService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDynaDEFormInstServiceBase
extends PSCoreSysServiceBase<PSDynaDEFormInst> {
    private static final Log log = LogFactory.getLog(PSDynaDEFormInstServiceBase.class);
    public static final String DATASET_DEFAULT = "DEFAULT";
    public static final String ACTION_UPDATEDYNAMODEL = "UpdateDynaModel";
    private PSDynaDEFormInstDEModel pSDynaDEFormInstDEModel;
    private PSDynaDEFormInstDAO pSDynaDEFormInstDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.dynasys.service.PSDynaDEFormInstService";
    }

    public PSDynaDEFormInstDEModel getPSDynaDEFormInstDEModel() {
        if (this.pSDynaDEFormInstDEModel == null) {
            try {
                this.pSDynaDEFormInstDEModel = (PSDynaDEFormInstDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.dynasys.demodel.PSDynaDEFormInstDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDynaDEFormInstDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSDynaDEFormInstDEModel();
    }

    public PSDynaDEFormInstDAO getPSDynaDEFormInstDAO() {
        if (this.pSDynaDEFormInstDAO == null) {
            try {
                this.pSDynaDEFormInstDAO = (PSDynaDEFormInstDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.dynasys.dao.PSDynaDEFormInstDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDynaDEFormInstDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSDynaDEFormInstDAO();
    }

    protected DBFetchResult onfetchDataSet(String string, IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        if (StringHelper.compare((String)string, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.fetchDefault(iDEDataSetFetchContext);
        }
        return super.onfetchDataSet(string, iDEDataSetFetchContext);
    }

    @Override
    protected void onExecuteAction(String string, IEntity iEntity) throws Exception {
        if (StringHelper.compare((String)string, (String)ACTION_UPDATEDYNAMODEL, (boolean)true) == 0) {
            this.updateDynaModel((PSDynaDEFormInst)iEntity);
            return;
        }
        super.onExecuteAction(string, iEntity);
    }

    public DBFetchResult fetchDefault(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_DEFAULT, false);
        return dBFetchResult;
    }

    public void updateDynaModel(PSDynaDEFormInst pSDynaDEFormInst) throws Exception {
        final IServicePlugin iServicePlugin = this.getPlugin();
        if (iServicePlugin != null && iServicePlugin.doCustomAction((IService)this, ACTION_UPDATEDYNAMODEL, 0, pSDynaDEFormInst, null).getResult() == 1) {
            return;
        }
        this.testDEMainStateAction(pSDynaDEFormInst, ACTION_UPDATEDYNAMODEL);
        final PSDynaDEFormInst pSDynaDEFormInst2 = pSDynaDEFormInst;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                if (iServicePlugin == null || iServicePlugin.doCustomAction(PSDynaDEFormInstServiceBase.this.getService(), PSDynaDEFormInstServiceBase.ACTION_UPDATEDYNAMODEL, 40, pSDynaDEFormInst2, null).getResult() != 1) {
                    PSDynaDEFormInstServiceBase.this.onUpdateDynaModel(pSDynaDEFormInst2);
                }
            }
        });
        if (iServicePlugin != null) {
            iServicePlugin.doCustomAction((IService)this, ACTION_UPDATEDYNAMODEL, 99, pSDynaDEFormInst, null);
        }
    }

    protected void onUpdateDynaModel(PSDynaDEFormInst pSDynaDEFormInst) throws Exception {
        throw new Exception("\u6ca1\u6709\u5b9e\u73b0\u81ea\u5b9a\u4e49\u884c\u4e3a[UpdateDynaModel]");
    }

    protected void onFillParentInfo(PSDynaDEFormInst pSDynaDEFormInst, String string, String string2, String string3) throws Exception {
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDYNADEFORMINST_PSDEFORM_PSDEFORMID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEFormService", (SessionFactory)this.getSessionFactory());
            PSDEForm pSDEForm = (PSDEForm)iService.getDEModel().createEntity();
            pSDEForm.set("PSDEFORMID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDEForm);
            } else {
                iService.get(pSDEForm);
            }
            this.onFillParentInfo_PSDEForm(pSDynaDEFormInst, pSDEForm);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDYNADEFORMINST_PSDYNADEFORM_PSDYNADEFORMID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dynasys.service.PSDynaDEFormService", (SessionFactory)this.getSessionFactory());
            PSDynaDEForm pSDynaDEForm = (PSDynaDEForm)iService.getDEModel().createEntity();
            pSDynaDEForm.set("PSDYNADEFORMID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDynaDEForm);
            } else {
                iService.get(pSDynaDEForm);
            }
            this.onFillParentInfo_PSDynaDEForm(pSDynaDEFormInst, pSDynaDEForm);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDYNADEFORMINST_PSDYNAINST_PSDYNAINSTID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dynasys.service.PSDynaInstService", (SessionFactory)this.getSessionFactory());
            PSDynaInst pSDynaInst = (PSDynaInst)iService.getDEModel().createEntity();
            pSDynaInst.set("PSDYNAINSTID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDynaInst);
            } else {
                iService.get(pSDynaInst);
            }
            this.onFillParentInfo_PSDynaInst(pSDynaDEFormInst, pSDynaInst);
            return;
        }
        super.onFillParentInfo(pSDynaDEFormInst, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillParentInfo_PSDEForm(PSDynaDEFormInst pSDynaDEFormInst, PSDEForm pSDEForm) throws Exception {
        pSDynaDEFormInst.setPSDEFormId(pSDEForm.getPSDEFormId());
        pSDynaDEFormInst.setPSDEFormName(pSDEForm.getPSDEFormName());
    }

    protected void onFillParentInfo_PSDynaDEForm(PSDynaDEFormInst pSDynaDEFormInst, PSDynaDEForm pSDynaDEForm) throws Exception {
        pSDynaDEFormInst.setPSDynaDEFormId(pSDynaDEForm.getPSDynaDEFormId());
        pSDynaDEFormInst.setPSDynaDEFormName(pSDynaDEForm.getPSDynaDEFormName());
    }

    protected void onFillParentInfo_PSDynaInst(PSDynaDEFormInst pSDynaDEFormInst, PSDynaInst pSDynaInst) throws Exception {
        pSDynaDEFormInst.setPSDynaInstId(pSDynaInst.getPSDynaInstId());
        pSDynaDEFormInst.setPSDynaInstName(pSDynaInst.getPSDynaInstName());
    }

    protected void onFillEntityFullInfo(PSDynaDEFormInst pSDynaDEFormInst, boolean bl) throws Exception {
        if (bl) {
            // empty if block
        }
        super.onFillEntityFullInfo(pSDynaDEFormInst, bl);
        this.onFillEntityFullInfo_PSDEForm(pSDynaDEFormInst, bl);
        this.onFillEntityFullInfo_PSDynaDEForm(pSDynaDEFormInst, bl);
        this.onFillEntityFullInfo_PSDynaInst(pSDynaDEFormInst, bl);
    }

    protected void onFillEntityFullInfo_PSDEForm(PSDynaDEFormInst pSDynaDEFormInst, boolean bl) throws Exception {
        if (pSDynaDEFormInst.isPSDEFormIdDirty()) {
            if (pSDynaDEFormInst.getPSDEFormId() != null) {
                if (pSDynaDEFormInst.getPSDEFormId() == null || pSDynaDEFormInst.getPSDEFormName() == null) {
                    PSDEForm pSDEForm = pSDynaDEFormInst.getPSDEForm();
                    pSDynaDEFormInst.setPSDEFormName(pSDEForm.getPSDEFormName());
                }
            } else {
                pSDynaDEFormInst.setPSDEFormName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_PSDynaDEForm(PSDynaDEFormInst pSDynaDEFormInst, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSDynaInst(PSDynaDEFormInst pSDynaDEFormInst, boolean bl) throws Exception {
        if (pSDynaDEFormInst.isPSDynaInstIdDirty()) {
            if (pSDynaDEFormInst.getPSDynaInstId() != null) {
                if (pSDynaDEFormInst.getPSDynaInstId() == null || pSDynaDEFormInst.getPSDynaInstName() == null) {
                    PSDynaInst pSDynaInst = pSDynaDEFormInst.getPSDynaInst();
                    pSDynaDEFormInst.setPSDynaInstName(pSDynaInst.getPSDynaInstName());
                }
            } else {
                pSDynaDEFormInst.setPSDynaInstName(null);
            }
        }
    }

    protected void onWriteBackParent(PSDynaDEFormInst pSDynaDEFormInst, boolean bl) throws Exception {
        super.onWriteBackParent(pSDynaDEFormInst, bl);
    }

    public ArrayList<PSDynaDEFormInst> selectByPSDEForm(PSDEFormBase pSDEFormBase) throws Exception {
        return this.selectByPSDEForm(pSDEFormBase, "", -1);
    }

    public ArrayList<PSDynaDEFormInst> selectByPSDEForm(PSDEFormBase pSDEFormBase, String string) throws Exception {
        return this.selectByPSDEForm(pSDEFormBase, string, -1);
    }

    public ArrayList<PSDynaDEFormInst> selectByPSDEForm(PSDEFormBase pSDEFormBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDEFORMID", (Object)pSDEFormBase.getPSDEFormId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSDEFormCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSDEFormCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDynaDEFormInst> selectByPSDynaDEForm(PSDynaDEFormBase pSDynaDEFormBase) throws Exception {
        return this.selectByPSDynaDEForm(pSDynaDEFormBase, "", -1);
    }

    public ArrayList<PSDynaDEFormInst> selectByPSDynaDEForm(PSDynaDEFormBase pSDynaDEFormBase, String string) throws Exception {
        return this.selectByPSDynaDEForm(pSDynaDEFormBase, string, -1);
    }

    public ArrayList<PSDynaDEFormInst> selectByPSDynaDEForm(PSDynaDEFormBase pSDynaDEFormBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDYNADEFORMID", (Object)pSDynaDEFormBase.getPSDynaDEFormId());
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

    public ArrayList<PSDynaDEFormInst> selectByPSDynaInst(PSDynaInstBase pSDynaInstBase) throws Exception {
        return this.selectByPSDynaInst(pSDynaInstBase, "", -1);
    }

    public ArrayList<PSDynaDEFormInst> selectByPSDynaInst(PSDynaInstBase pSDynaInstBase, String string) throws Exception {
        return this.selectByPSDynaInst(pSDynaInstBase, string, -1);
    }

    public ArrayList<PSDynaDEFormInst> selectByPSDynaInst(PSDynaInstBase pSDynaInstBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDYNAINSTID", (Object)pSDynaInstBase.getPSDynaInstId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSDynaInstCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSDynaInstCond(SelectCond selectCond) throws Exception {
    }

    public void testRemoveByPSDEForm(PSDEForm pSDEForm) throws Exception {
        ArrayList<PSDynaDEFormInst> arrayList = this.selectByPSDEForm(pSDEForm, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEFORM");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDEForm);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDYNADEFORMINST_PSDEFORM_PSDEFORMID", "", iDataEntityModel.getName(), "PSDYNADEFORMINST", iDataEntityModel.getDataInfo(pSDEForm), arrayList.get(0)));
        }
    }

    public void resetPSDEForm(PSDEForm pSDEForm) throws Exception {
        ArrayList<PSDynaDEFormInst> arrayList = this.selectByPSDEForm(pSDEForm);
        for (PSDynaDEFormInst pSDynaDEFormInst : arrayList) {
            PSDynaDEFormInst pSDynaDEFormInst2 = (PSDynaDEFormInst)this.getDEModel().createEntity();
            pSDynaDEFormInst2.setPSDynaDEFormInstId(pSDynaDEFormInst.getPSDynaDEFormInstId());
            pSDynaDEFormInst2.setPSDEFormId(null);
            this.update(pSDynaDEFormInst2);
        }
    }

    public void removeByPSDEForm(PSDEForm pSDEForm) throws Exception {
        final PSDEForm pSDEForm2 = pSDEForm;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDynaDEFormInstServiceBase.this.onBeforeRemoveByPSDEForm(pSDEForm2);
                PSDynaDEFormInstServiceBase.this.internalRemoveByPSDEForm(pSDEForm2);
                PSDynaDEFormInstServiceBase.this.onAfterRemoveByPSDEForm(pSDEForm2);
            }
        });
    }

    protected void onBeforeRemoveByPSDEForm(PSDEForm pSDEForm) throws Exception {
    }

    protected void internalRemoveByPSDEForm(PSDEForm pSDEForm) throws Exception {
        ArrayList<PSDynaDEFormInst> arrayList = this.selectByPSDEForm(pSDEForm);
        this.onBeforeRemoveByPSDEForm(pSDEForm, arrayList);
        for (PSDynaDEFormInst pSDynaDEFormInst : arrayList) {
            this.remove(pSDynaDEFormInst);
        }
        this.onAfterRemoveByPSDEForm(pSDEForm, arrayList);
    }

    protected void onAfterRemoveByPSDEForm(PSDEForm pSDEForm) throws Exception {
    }

    protected void onBeforeRemoveByPSDEForm(PSDEForm pSDEForm, ArrayList<PSDynaDEFormInst> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDEForm(PSDEForm pSDEForm, ArrayList<PSDynaDEFormInst> arrayList) throws Exception {
    }

    public void testRemoveByPSDynaDEForm(PSDynaDEForm pSDynaDEForm) throws Exception {
        ArrayList<PSDynaDEFormInst> arrayList = this.selectByPSDynaDEForm(pSDynaDEForm, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDYNADEFORM");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDynaDEForm);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDYNADEFORMINST_PSDYNADEFORM_PSDYNADEFORMID", "", iDataEntityModel.getName(), "PSDYNADEFORMINST", iDataEntityModel.getDataInfo(pSDynaDEForm), arrayList.get(0)));
        }
    }

    public void resetPSDynaDEForm(PSDynaDEForm pSDynaDEForm) throws Exception {
        ArrayList<PSDynaDEFormInst> arrayList = this.selectByPSDynaDEForm(pSDynaDEForm);
        for (PSDynaDEFormInst pSDynaDEFormInst : arrayList) {
            PSDynaDEFormInst pSDynaDEFormInst2 = (PSDynaDEFormInst)this.getDEModel().createEntity();
            pSDynaDEFormInst2.setPSDynaDEFormInstId(pSDynaDEFormInst.getPSDynaDEFormInstId());
            pSDynaDEFormInst2.setPSDynaDEFormId(null);
            this.update(pSDynaDEFormInst2);
        }
    }

    public void removeByPSDynaDEForm(PSDynaDEForm pSDynaDEForm) throws Exception {
        final PSDynaDEForm pSDynaDEForm2 = pSDynaDEForm;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDynaDEFormInstServiceBase.this.onBeforeRemoveByPSDynaDEForm(pSDynaDEForm2);
                PSDynaDEFormInstServiceBase.this.internalRemoveByPSDynaDEForm(pSDynaDEForm2);
                PSDynaDEFormInstServiceBase.this.onAfterRemoveByPSDynaDEForm(pSDynaDEForm2);
            }
        });
    }

    protected void onBeforeRemoveByPSDynaDEForm(PSDynaDEForm pSDynaDEForm) throws Exception {
    }

    protected void internalRemoveByPSDynaDEForm(PSDynaDEForm pSDynaDEForm) throws Exception {
        ArrayList<PSDynaDEFormInst> arrayList = this.selectByPSDynaDEForm(pSDynaDEForm);
        this.onBeforeRemoveByPSDynaDEForm(pSDynaDEForm, arrayList);
        for (PSDynaDEFormInst pSDynaDEFormInst : arrayList) {
            this.remove(pSDynaDEFormInst);
        }
        this.onAfterRemoveByPSDynaDEForm(pSDynaDEForm, arrayList);
    }

    protected void onAfterRemoveByPSDynaDEForm(PSDynaDEForm pSDynaDEForm) throws Exception {
    }

    protected void onBeforeRemoveByPSDynaDEForm(PSDynaDEForm pSDynaDEForm, ArrayList<PSDynaDEFormInst> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDynaDEForm(PSDynaDEForm pSDynaDEForm, ArrayList<PSDynaDEFormInst> arrayList) throws Exception {
    }

    public void testRemoveByPSDynaInst(PSDynaInst pSDynaInst) throws Exception {
    }

    public void resetPSDynaInst(PSDynaInst pSDynaInst) throws Exception {
        ArrayList<PSDynaDEFormInst> arrayList = this.selectByPSDynaInst(pSDynaInst);
        for (PSDynaDEFormInst pSDynaDEFormInst : arrayList) {
            PSDynaDEFormInst pSDynaDEFormInst2 = (PSDynaDEFormInst)this.getDEModel().createEntity();
            pSDynaDEFormInst2.setPSDynaDEFormInstId(pSDynaDEFormInst.getPSDynaDEFormInstId());
            pSDynaDEFormInst2.setPSDynaInstId(null);
            this.update(pSDynaDEFormInst2);
        }
    }

    public void removeByPSDynaInst(PSDynaInst pSDynaInst) throws Exception {
        final PSDynaInst pSDynaInst2 = pSDynaInst;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDynaDEFormInstServiceBase.this.onBeforeRemoveByPSDynaInst(pSDynaInst2);
                PSDynaDEFormInstServiceBase.this.internalRemoveByPSDynaInst(pSDynaInst2);
                PSDynaDEFormInstServiceBase.this.onAfterRemoveByPSDynaInst(pSDynaInst2);
            }
        });
    }

    protected void onBeforeRemoveByPSDynaInst(PSDynaInst pSDynaInst) throws Exception {
    }

    protected void internalRemoveByPSDynaInst(PSDynaInst pSDynaInst) throws Exception {
        ArrayList<PSDynaDEFormInst> arrayList = this.selectByPSDynaInst(pSDynaInst);
        this.onBeforeRemoveByPSDynaInst(pSDynaInst, arrayList);
        for (PSDynaDEFormInst pSDynaDEFormInst : arrayList) {
            this.remove(pSDynaDEFormInst);
        }
        this.onAfterRemoveByPSDynaInst(pSDynaInst, arrayList);
    }

    protected void onAfterRemoveByPSDynaInst(PSDynaInst pSDynaInst) throws Exception {
    }

    protected void onBeforeRemoveByPSDynaInst(PSDynaInst pSDynaInst, ArrayList<PSDynaDEFormInst> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDynaInst(PSDynaInst pSDynaInst, ArrayList<PSDynaDEFormInst> arrayList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(PSDynaDEFormInst pSDynaDEFormInst) throws Exception {
        PSDynaAppVCInstService pSDynaAppVCInstService = (PSDynaAppVCInstService)ServiceGlobal.getService(PSDynaAppVCInstService.class, (SessionFactory)this.getSessionFactory());
        pSDynaAppVCInstService.testRemoveByPSDynaDEForm(pSDynaDEFormInst);
        super.onBeforeRemove(pSDynaDEFormInst);
    }

    protected void replaceParentInfo(PSDynaDEFormInst pSDynaDEFormInst, CloneSession cloneSession) throws Exception {
        IEntity iEntity;
        super.replaceParentInfo(pSDynaDEFormInst, cloneSession);
        if (pSDynaDEFormInst.getPSDEFormId() != null && (iEntity = cloneSession.getEntity("PSDEFORM", (Object)pSDynaDEFormInst.getPSDEFormId())) != null) {
            this.onFillParentInfo_PSDEForm(pSDynaDEFormInst, (PSDEForm)iEntity);
        }
        if (pSDynaDEFormInst.getPSDynaDEFormId() != null && (iEntity = cloneSession.getEntity("PSDYNADEFORM", (Object)pSDynaDEFormInst.getPSDynaDEFormId())) != null) {
            this.onFillParentInfo_PSDynaDEForm(pSDynaDEFormInst, (PSDynaDEForm)iEntity);
        }
        if (pSDynaDEFormInst.getPSDynaInstId() != null && (iEntity = cloneSession.getEntity("PSDYNAINST", (Object)pSDynaDEFormInst.getPSDynaInstId())) != null) {
            this.onFillParentInfo_PSDynaInst(pSDynaDEFormInst, (PSDynaInst)iEntity);
        }
    }

    protected void onRemoveEntityUncopyValues(PSDynaDEFormInst pSDynaDEFormInst, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues(pSDynaDEFormInst, bl);
    }

    protected void onCheckEntity(boolean bl, PSDynaDEFormInst pSDynaDEFormInst, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_Memo(bl, pSDynaDEFormInst, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEFormId(bl, pSDynaDEFormInst, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEFormName(bl, pSDynaDEFormInst, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDynaDEFormId(bl, pSDynaDEFormInst, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDynaDEFormInstId(bl, pSDynaDEFormInst, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDynaDEFormInstName(bl, pSDynaDEFormInst, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDynaInstId(bl, pSDynaDEFormInst, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDynaInstName(bl, pSDynaDEFormInst, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, pSDynaDEFormInst, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_Memo(boolean bl, PSDynaDEFormInst pSDynaDEFormInst, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDynaDEFormInst.isMemoDirty() : !pSDynaDEFormInst.isMemoDirty()) {
            return null;
        }
        String string = pSDynaDEFormInst.getMemo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Memo_Default(pSDynaDEFormInst, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDEFormId(boolean bl, PSDynaDEFormInst pSDynaDEFormInst, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDynaDEFormInst.isPSDEFormIdDirty() : !pSDynaDEFormInst.isPSDEFormIdDirty()) {
            return null;
        }
        String string = pSDynaDEFormInst.getPSDEFormId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEFormId_Default(pSDynaDEFormInst, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEFORMID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDEFormName(boolean bl, PSDynaDEFormInst pSDynaDEFormInst, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDynaDEFormInst.isPSDEFormNameDirty() : !pSDynaDEFormInst.isPSDEFormNameDirty()) {
            return null;
        }
        String string = pSDynaDEFormInst.getPSDEFormName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEFormName_Default(pSDynaDEFormInst, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEFORMNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDynaDEFormId(boolean bl, PSDynaDEFormInst pSDynaDEFormInst, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDynaDEFormInst.isPSDynaDEFormIdDirty() && !bl2 : !pSDynaDEFormInst.isPSDynaDEFormIdDirty()) {
            return null;
        }
        String string = pSDynaDEFormInst.getPSDynaDEFormId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDYNADEFORMID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDynaDEFormId_Default(pSDynaDEFormInst, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDYNADEFORMID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDynaDEFormInstId(boolean bl, PSDynaDEFormInst pSDynaDEFormInst, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDynaDEFormInst.isPSDynaDEFormInstIdDirty() && !bl2 : !pSDynaDEFormInst.isPSDynaDEFormInstIdDirty()) {
            return null;
        }
        String string = pSDynaDEFormInst.getPSDynaDEFormInstId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDYNADEFORMINSTID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDynaDEFormInstId_Default(pSDynaDEFormInst, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDynaDEFormInstName(boolean bl, PSDynaDEFormInst pSDynaDEFormInst, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDynaDEFormInst.isPSDynaDEFormInstNameDirty() && !bl2 : !pSDynaDEFormInst.isPSDynaDEFormInstNameDirty()) {
            return null;
        }
        String string = pSDynaDEFormInst.getPSDynaDEFormInstName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDYNADEFORMINSTNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDynaDEFormInstName_Default(pSDynaDEFormInst, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDynaInstId(boolean bl, PSDynaDEFormInst pSDynaDEFormInst, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDynaDEFormInst.isPSDynaInstIdDirty() && !bl2 : !pSDynaDEFormInst.isPSDynaInstIdDirty()) {
            return null;
        }
        String string = pSDynaDEFormInst.getPSDynaInstId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDYNAINSTID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDynaInstId_Default(pSDynaDEFormInst, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDynaInstName(boolean bl, PSDynaDEFormInst pSDynaDEFormInst, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDynaDEFormInst.isPSDynaInstNameDirty() && !bl2 : !pSDynaDEFormInst.isPSDynaInstNameDirty()) {
            return null;
        }
        String string = pSDynaDEFormInst.getPSDynaInstName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDYNAINSTNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDynaInstName_Default(pSDynaDEFormInst, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDYNAINSTNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected void onSyncEntity(PSDynaDEFormInst pSDynaDEFormInst, boolean bl) throws Exception {
        super.onSyncEntity(pSDynaDEFormInst, bl);
    }

    protected void onSyncIndexEntities(PSDynaDEFormInst pSDynaDEFormInst, boolean bl) throws Exception {
        super.onSyncIndexEntities(pSDynaDEFormInst, bl);
    }

    public Object getDataContextValue(PSDynaDEFormInst pSDynaDEFormInst, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null) {
            // empty if block
        }
        if ((object = super.getDataContextValue(pSDynaDEFormInst, string, iDataContextParam)) != null) {
            return object;
        }
        PSDynaInst pSDynaInst = pSDynaDEFormInst.getPSDynaInst();
        if (pSDynaInst != null && pSDynaInst.contains(string)) {
            return pSDynaInst.get(string);
        }
        return null;
    }

    protected void onExportMajorModel(PSDynaDEFormInst pSDynaDEFormInst, ArrayList<JSONObject> arrayList, int n) throws Exception {
        super.onExportMajorModel(pSDynaDEFormInst, arrayList, n);
    }

    protected String onTestValueRule(String string, String string2, IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        if (StringHelper.compare((String)string, (String)"CREATEDATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateDate_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATEMAN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateMan_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MEMO", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Memo_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEFORMID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEFormId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEFORMNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEFormName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDYNADEFORMID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDynaDEFormId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDYNADEFORMINSTID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDynaDEFormInstId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDYNADEFORMINSTNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDynaDEFormInstName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDYNADEFORMNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDynaDEFormName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDYNAINSTID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDynaInstId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDYNAINSTNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDynaInstName_Default(iEntity, bl, bl2);
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

    protected String onTestValueRule_PSDEFormId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEFORMID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDEFormName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEFORMNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDynaDEFormId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDYNADEFORMID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
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

    protected String onTestValueRule_PSDynaDEFormName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDYNADEFORMNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDynaInstId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDYNAINSTID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDynaInstName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDYNAINSTNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
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

    protected boolean onMergeChild(String string, String string2, PSDynaDEFormInst pSDynaDEFormInst) throws Exception {
        boolean bl = false;
        if (super.onMergeChild(string, string2, pSDynaDEFormInst)) {
            bl = true;
        }
        return bl;
    }

    protected void onUpdateParent(PSDynaDEFormInst pSDynaDEFormInst) throws Exception {
        super.onUpdateParent(pSDynaDEFormInst);
    }

    @Override
    protected void exportCurXmlModel(PSDynaDEFormInst pSDynaDEFormInst, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSDYNADEFORMINST");
        if (!bl) {
            pSDynaDEFormInst.setCreateDate(null);
            pSDynaDEFormInst.setCreateMan(null);
            pSDynaDEFormInst.setPSDynaDEFormInstId(null);
            pSDynaDEFormInst.setPSDynaDEFormName(null);
            pSDynaDEFormInst.setPSDynaInstId(null);
            pSDynaDEFormInst.setPSDynaInstName(null);
            pSDynaDEFormInst.setUpdateDate(null);
            pSDynaDEFormInst.setUpdateMan(null);
            super.exportCurXmlModel(pSDynaDEFormInst, xmlNode, bl);
        }
    }
}

