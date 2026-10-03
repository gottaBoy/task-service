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
package net.ibizsys.pscore.srv.eaidesign.service;

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
import net.ibizsys.pscore.srv.dedesign.entity.PSDER;
import net.ibizsys.pscore.srv.dedesign.entity.PSDERBase;
import net.ibizsys.pscore.srv.eaidesign.dao.PSSysEAIDERDAO;
import net.ibizsys.pscore.srv.eaidesign.demodel.PSSysEAIDERDEModel;
import net.ibizsys.pscore.srv.eaidesign.entity.PSSysEAIDE;
import net.ibizsys.pscore.srv.eaidesign.entity.PSSysEAIDEBase;
import net.ibizsys.pscore.srv.eaidesign.entity.PSSysEAIDER;
import net.ibizsys.pscore.srv.eaidesign.entity.PSSysEAIElementRE;
import net.ibizsys.pscore.srv.eaidesign.entity.PSSysEAIElementREBase;
import net.ibizsys.pscore.srv.sysdevstudio.entity.PSMOSFile;
import net.ibizsys.pscore.srv.util.IPSMOSFileFilter;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSSysEAIDERServiceBase
extends PSCoreSysServiceBase<PSSysEAIDER> {
    private static final Log log = LogFactory.getLog(PSSysEAIDERServiceBase.class);
    public static final String DATASET_DEFAULT = "DEFAULT";
    private static Map<String, String> defaultValueMap = new HashMap<String, String>();
    private PSSysEAIDERDEModel pSSysEAIDERDEModel;
    private PSSysEAIDERDAO pSSysEAIDERDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.eaidesign.service.PSSysEAIDERService";
    }

    public PSSysEAIDERDEModel getPSSysEAIDERDEModel() {
        if (this.pSSysEAIDERDEModel == null) {
            try {
                this.pSSysEAIDERDEModel = (PSSysEAIDERDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.eaidesign.demodel.PSSysEAIDERDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSSysEAIDERDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSSysEAIDERDEModel();
    }

    public PSSysEAIDERDAO getPSSysEAIDERDAO() {
        if (this.pSSysEAIDERDAO == null) {
            try {
                this.pSSysEAIDERDAO = (PSSysEAIDERDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.eaidesign.dao.PSSysEAIDERDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSSysEAIDERDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSSysEAIDERDAO();
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

    protected void onFillParentInfo(PSSysEAIDER pSSysEAIDER, String string, String string2, String string3) throws Exception {
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSEAIDER_PSDER_PSDERID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDERService", (SessionFactory)this.getSessionFactory());
            PSDER pSDER = (PSDER)iService.getDEModel().createEntity();
            pSDER.set("PSDERID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDER);
            } else {
                iService.get(pSDER);
            }
            this.onFillParentInfo_PSDER(pSSysEAIDER, pSDER);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSEAIDER_PSSYSEAIDE_PSSYSEAIDEID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.eaidesign.service.PSSysEAIDEService", (SessionFactory)this.getSessionFactory());
            PSSysEAIDE pSSysEAIDE = (PSSysEAIDE)iService.getDEModel().createEntity();
            pSSysEAIDE.set("PSSYSEAIDEID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSSysEAIDE);
            } else {
                iService.get(pSSysEAIDE);
            }
            this.onFillParentInfo_PSSysEAIDE(pSSysEAIDER, pSSysEAIDE);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSEAIDER_PSSYSEAIELEMENTRE_PSSYSEAIELEMENTREID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.eaidesign.service.PSSysEAIElementREService", (SessionFactory)this.getSessionFactory());
            PSSysEAIElementRE pSSysEAIElementRE = (PSSysEAIElementRE)iService.getDEModel().createEntity();
            pSSysEAIElementRE.set("PSSYSEAIELEMENTREID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSSysEAIElementRE);
            } else {
                iService.get(pSSysEAIElementRE);
            }
            this.onFillParentInfo_PSSysEAIElementRE(pSSysEAIDER, pSSysEAIElementRE);
            return;
        }
        super.onFillParentInfo(pSSysEAIDER, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillParentInfo_PSDER(PSSysEAIDER pSSysEAIDER, PSDER pSDER) throws Exception {
        pSSysEAIDER.setPSDERId(pSDER.getPSDERId());
        pSSysEAIDER.setPSDERName(pSDER.getPSDERName());
    }

    protected void onFillParentInfo_PSSysEAIDE(PSSysEAIDER pSSysEAIDER, PSSysEAIDE pSSysEAIDE) throws Exception {
        pSSysEAIDER.setPSDEId(pSSysEAIDE.getPSDEId());
        pSSysEAIDER.setPSSysEAIDEId(pSSysEAIDE.getPSSysEAIDEId());
        pSSysEAIDER.setPSSysEAIDEName(pSSysEAIDE.getPSSysEAIDEName());
        pSSysEAIDER.setPSSysEAIElementId(pSSysEAIDE.getPSSysEAIElementId());
    }

    protected void onFillParentInfo_PSSysEAIElementRE(PSSysEAIDER pSSysEAIDER, PSSysEAIElementRE pSSysEAIElementRE) throws Exception {
        pSSysEAIDER.setPSSysEAIElementREId(pSSysEAIElementRE.getPSSysEAIElementREId());
        pSSysEAIDER.setPSSysEAIElementREName(pSSysEAIElementRE.getPSSysEAIElementREName());
    }

    protected void onFillEntityFullInfo(PSSysEAIDER pSSysEAIDER, boolean bl) throws Exception {
        if (bl) {
            if (pSSysEAIDER.getCodeName() == null) {
                pSSysEAIDER.setCodeName((String)this.getDefaultValue(this.getWebContext(), "USER", "EAIDER", 25));
            }
            if (pSSysEAIDER.getPSSysEAIDERName() == null) {
                pSSysEAIDER.setPSSysEAIDERName((String)this.getDefaultValue(this.getWebContext(), "USER", "\u5173\u7cfb\u6620\u5c04", 25));
            }
            if (pSSysEAIDER.getValidFlag() == null) {
                pSSysEAIDER.setValidFlag((Integer)this.getDefaultValue(this.getWebContext(), "", "1", 9));
            }
        }
        super.onFillEntityFullInfo(pSSysEAIDER, bl);
        this.onFillEntityFullInfo_PSDER(pSSysEAIDER, bl);
        this.onFillEntityFullInfo_PSSysEAIDE(pSSysEAIDER, bl);
        this.onFillEntityFullInfo_PSSysEAIElementRE(pSSysEAIDER, bl);
    }

    protected void onFillEntityFullInfo_PSDER(PSSysEAIDER pSSysEAIDER, boolean bl) throws Exception {
        if (pSSysEAIDER.isPSDERIdDirty()) {
            if (pSSysEAIDER.getPSDERId() != null) {
                if (pSSysEAIDER.getPSDERId() == null || pSSysEAIDER.getPSDERName() == null) {
                    PSDER pSDER = pSSysEAIDER.getPSDER();
                    pSSysEAIDER.setPSDERName(pSDER.getPSDERName());
                }
            } else {
                pSSysEAIDER.setPSDERName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_PSSysEAIDE(PSSysEAIDER pSSysEAIDER, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSSysEAIElementRE(PSSysEAIDER pSSysEAIDER, boolean bl) throws Exception {
    }

    protected void onWriteBackParent(PSSysEAIDER pSSysEAIDER, boolean bl) throws Exception {
        super.onWriteBackParent(pSSysEAIDER, bl);
    }

    public ArrayList<PSSysEAIDER> selectByPSDER(PSDERBase pSDERBase) throws Exception {
        return this.selectByPSDER(pSDERBase, "", -1);
    }

    public ArrayList<PSSysEAIDER> selectByPSDER(PSDERBase pSDERBase, String string) throws Exception {
        return this.selectByPSDER(pSDERBase, string, -1);
    }

    public ArrayList<PSSysEAIDER> selectByPSDER(PSDERBase pSDERBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDERID", (Object)pSDERBase.getPSDERId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSDERCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSDERCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSSysEAIDER> selectByPSSysEAIDE(PSSysEAIDEBase pSSysEAIDEBase) throws Exception {
        return this.selectByPSSysEAIDE(pSSysEAIDEBase, "", -1);
    }

    public ArrayList<PSSysEAIDER> selectByPSSysEAIDE(PSSysEAIDEBase pSSysEAIDEBase, String string) throws Exception {
        return this.selectByPSSysEAIDE(pSSysEAIDEBase, string, -1);
    }

    public ArrayList<PSSysEAIDER> selectByPSSysEAIDE(PSSysEAIDEBase pSSysEAIDEBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSSYSEAIDEID", (Object)pSSysEAIDEBase.getPSSysEAIDEId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSSysEAIDECond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSSysEAIDECond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSSysEAIDER> selectTempByPSSysEAIDE(PSSysEAIDEBase pSSysEAIDEBase) throws Exception {
        return this.selectTempByPSSysEAIDE(pSSysEAIDEBase, "");
    }

    public ArrayList<PSSysEAIDER> selectTempByPSSysEAIDE(PSSysEAIDEBase pSSysEAIDEBase, String string) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSSYSEAIDEID", (Object)pSSysEAIDEBase.getPSSysEAIDEId());
        selectCond.setOrderInfo(string);
        this.onFillSelectTempByPSSysEAIDECond(selectCond);
        return this.selectTemp((ISelectCond)selectCond);
    }

    protected void onFillSelectTempByPSSysEAIDECond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSSysEAIDER> selectByPSSysEAIElementRE(PSSysEAIElementREBase pSSysEAIElementREBase) throws Exception {
        return this.selectByPSSysEAIElementRE(pSSysEAIElementREBase, "", -1);
    }

    public ArrayList<PSSysEAIDER> selectByPSSysEAIElementRE(PSSysEAIElementREBase pSSysEAIElementREBase, String string) throws Exception {
        return this.selectByPSSysEAIElementRE(pSSysEAIElementREBase, string, -1);
    }

    public ArrayList<PSSysEAIDER> selectByPSSysEAIElementRE(PSSysEAIElementREBase pSSysEAIElementREBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSSYSEAIELEMENTREID", (Object)pSSysEAIElementREBase.getPSSysEAIElementREId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSSysEAIElementRECond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSSysEAIElementRECond(SelectCond selectCond) throws Exception {
    }

    public void testRemoveByPSDER(PSDER pSDER) throws Exception {
        ArrayList<PSSysEAIDER> arrayList = this.selectByPSDER(pSDER, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDER");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDER);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSEAIDER_PSDER_PSDERID", "", iDataEntityModel.getName(), "PSSYSEAIDER", iDataEntityModel.getDataInfo(pSDER), arrayList.get(0)));
        }
    }

    public void resetPSDER(PSDER pSDER) throws Exception {
        ArrayList<PSSysEAIDER> arrayList = this.selectByPSDER(pSDER);
        for (PSSysEAIDER pSSysEAIDER : arrayList) {
            PSSysEAIDER pSSysEAIDER2 = (PSSysEAIDER)this.getDEModel().createEntity();
            pSSysEAIDER2.setPSSysEAIDERId(pSSysEAIDER.getPSSysEAIDERId());
            pSSysEAIDER2.setPSDERId(null);
            this.update(pSSysEAIDER2);
        }
    }

    public void removeByPSDER(PSDER pSDER) throws Exception {
        final PSDER pSDER2 = pSDER;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysEAIDERServiceBase.this.onBeforeRemoveByPSDER(pSDER2);
                PSSysEAIDERServiceBase.this.internalRemoveByPSDER(pSDER2);
                PSSysEAIDERServiceBase.this.onAfterRemoveByPSDER(pSDER2);
            }
        });
    }

    protected void onBeforeRemoveByPSDER(PSDER pSDER) throws Exception {
    }

    protected void internalRemoveByPSDER(PSDER pSDER) throws Exception {
        ArrayList<PSSysEAIDER> arrayList = this.selectByPSDER(pSDER);
        this.onBeforeRemoveByPSDER(pSDER, arrayList);
        for (PSSysEAIDER pSSysEAIDER : arrayList) {
            this.remove(pSSysEAIDER);
        }
        this.onAfterRemoveByPSDER(pSDER, arrayList);
    }

    protected void onAfterRemoveByPSDER(PSDER pSDER) throws Exception {
    }

    protected void onBeforeRemoveByPSDER(PSDER pSDER, ArrayList<PSSysEAIDER> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDER(PSDER pSDER, ArrayList<PSSysEAIDER> arrayList) throws Exception {
    }

    public void testRemoveByPSSysEAIDE(PSSysEAIDE pSSysEAIDE) throws Exception {
    }

    public void resetPSSysEAIDE(PSSysEAIDE pSSysEAIDE) throws Exception {
        ArrayList<PSSysEAIDER> arrayList = this.selectByPSSysEAIDE(pSSysEAIDE);
        for (PSSysEAIDER pSSysEAIDER : arrayList) {
            PSSysEAIDER pSSysEAIDER2 = (PSSysEAIDER)this.getDEModel().createEntity();
            pSSysEAIDER2.setPSSysEAIDERId(pSSysEAIDER.getPSSysEAIDERId());
            pSSysEAIDER2.setPSSysEAIDEId(null);
            this.update(pSSysEAIDER2);
        }
    }

    public void resetTempPSSysEAIDE(PSSysEAIDE pSSysEAIDE) throws Exception {
        ArrayList<PSSysEAIDER> arrayList = this.selectTempByPSSysEAIDE(pSSysEAIDE);
        for (PSSysEAIDER pSSysEAIDER : arrayList) {
            PSSysEAIDER pSSysEAIDER2 = (PSSysEAIDER)this.getDEModel().createEntity();
            pSSysEAIDER2.setPSSysEAIDERId(pSSysEAIDER.getPSSysEAIDERId());
            pSSysEAIDER2.setPSSysEAIDEId(null);
            this.updateTemp(pSSysEAIDER2);
        }
    }

    public void removeByPSSysEAIDE(PSSysEAIDE pSSysEAIDE) throws Exception {
        final PSSysEAIDE pSSysEAIDE2 = pSSysEAIDE;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysEAIDERServiceBase.this.onBeforeRemoveByPSSysEAIDE(pSSysEAIDE2);
                PSSysEAIDERServiceBase.this.internalRemoveByPSSysEAIDE(pSSysEAIDE2);
                PSSysEAIDERServiceBase.this.onAfterRemoveByPSSysEAIDE(pSSysEAIDE2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysEAIDE(PSSysEAIDE pSSysEAIDE) throws Exception {
    }

    protected void internalRemoveByPSSysEAIDE(PSSysEAIDE pSSysEAIDE) throws Exception {
        ArrayList<PSSysEAIDER> arrayList = this.selectByPSSysEAIDE(pSSysEAIDE);
        this.onBeforeRemoveByPSSysEAIDE(pSSysEAIDE, arrayList);
        for (PSSysEAIDER pSSysEAIDER : arrayList) {
            this.remove(pSSysEAIDER);
        }
        this.onAfterRemoveByPSSysEAIDE(pSSysEAIDE, arrayList);
    }

    protected void onAfterRemoveByPSSysEAIDE(PSSysEAIDE pSSysEAIDE) throws Exception {
    }

    protected void onBeforeRemoveByPSSysEAIDE(PSSysEAIDE pSSysEAIDE, ArrayList<PSSysEAIDER> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysEAIDE(PSSysEAIDE pSSysEAIDE, ArrayList<PSSysEAIDER> arrayList) throws Exception {
    }

    public void testRemoveByPSSysEAIElementRE(PSSysEAIElementRE pSSysEAIElementRE) throws Exception {
        ArrayList<PSSysEAIDER> arrayList = this.selectByPSSysEAIElementRE(pSSysEAIElementRE, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSEAIELEMENTRE");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSSysEAIElementRE);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSEAIDER_PSSYSEAIELEMENTRE_PSSYSEAIELEMENTREID", "", iDataEntityModel.getName(), "PSSYSEAIDER", iDataEntityModel.getDataInfo(pSSysEAIElementRE), arrayList.get(0)));
        }
    }

    public void resetPSSysEAIElementRE(PSSysEAIElementRE pSSysEAIElementRE) throws Exception {
        ArrayList<PSSysEAIDER> arrayList = this.selectByPSSysEAIElementRE(pSSysEAIElementRE);
        for (PSSysEAIDER pSSysEAIDER : arrayList) {
            PSSysEAIDER pSSysEAIDER2 = (PSSysEAIDER)this.getDEModel().createEntity();
            pSSysEAIDER2.setPSSysEAIDERId(pSSysEAIDER.getPSSysEAIDERId());
            pSSysEAIDER2.setPSSysEAIElementREId(null);
            this.update(pSSysEAIDER2);
        }
    }

    public void removeByPSSysEAIElementRE(PSSysEAIElementRE pSSysEAIElementRE) throws Exception {
        final PSSysEAIElementRE pSSysEAIElementRE2 = pSSysEAIElementRE;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysEAIDERServiceBase.this.onBeforeRemoveByPSSysEAIElementRE(pSSysEAIElementRE2);
                PSSysEAIDERServiceBase.this.internalRemoveByPSSysEAIElementRE(pSSysEAIElementRE2);
                PSSysEAIDERServiceBase.this.onAfterRemoveByPSSysEAIElementRE(pSSysEAIElementRE2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysEAIElementRE(PSSysEAIElementRE pSSysEAIElementRE) throws Exception {
    }

    protected void internalRemoveByPSSysEAIElementRE(PSSysEAIElementRE pSSysEAIElementRE) throws Exception {
        ArrayList<PSSysEAIDER> arrayList = this.selectByPSSysEAIElementRE(pSSysEAIElementRE);
        this.onBeforeRemoveByPSSysEAIElementRE(pSSysEAIElementRE, arrayList);
        for (PSSysEAIDER pSSysEAIDER : arrayList) {
            this.remove(pSSysEAIDER);
        }
        this.onAfterRemoveByPSSysEAIElementRE(pSSysEAIElementRE, arrayList);
    }

    protected void onAfterRemoveByPSSysEAIElementRE(PSSysEAIElementRE pSSysEAIElementRE) throws Exception {
    }

    protected void onBeforeRemoveByPSSysEAIElementRE(PSSysEAIElementRE pSSysEAIElementRE, ArrayList<PSSysEAIDER> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysEAIElementRE(PSSysEAIElementRE pSSysEAIElementRE, ArrayList<PSSysEAIDER> arrayList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(PSSysEAIDER pSSysEAIDER) throws Exception {
        super.onBeforeRemove(pSSysEAIDER);
    }

    public void removeTempByPSSysEAIDE(PSSysEAIDE pSSysEAIDE) throws Exception {
        final PSSysEAIDE pSSysEAIDE2 = pSSysEAIDE;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysEAIDERServiceBase.this.onBeforeRemoveTempByPSSysEAIDE(pSSysEAIDE2);
                PSSysEAIDERServiceBase.this.internalRemoveTempByPSSysEAIDE(pSSysEAIDE2);
                PSSysEAIDERServiceBase.this.onAfterRemoveTempByPSSysEAIDE(pSSysEAIDE2);
            }
        });
    }

    protected void onBeforeRemoveTempByPSSysEAIDE(PSSysEAIDE pSSysEAIDE) throws Exception {
    }

    protected void internalRemoveTempByPSSysEAIDE(PSSysEAIDE pSSysEAIDE) throws Exception {
        ArrayList<PSSysEAIDER> arrayList = this.selectTempByPSSysEAIDE(pSSysEAIDE);
        this.onBeforeRemoveTempByPSSysEAIDE(pSSysEAIDE, arrayList);
        for (PSSysEAIDER pSSysEAIDER : arrayList) {
            this.removeTemp(pSSysEAIDER);
        }
        this.onAfterRemoveTempByPSSysEAIDE(pSSysEAIDE, arrayList);
    }

    protected void onAfterRemoveTempByPSSysEAIDE(PSSysEAIDE pSSysEAIDE) throws Exception {
    }

    protected void onBeforeRemoveTempByPSSysEAIDE(PSSysEAIDE pSSysEAIDE, ArrayList<PSSysEAIDER> arrayList) throws Exception {
    }

    protected void onAfterRemoveTempByPSSysEAIDE(PSSysEAIDE pSSysEAIDE, ArrayList<PSSysEAIDER> arrayList) throws Exception {
    }

    protected void replaceParentInfo(PSSysEAIDER pSSysEAIDER, CloneSession cloneSession) throws Exception {
        IEntity iEntity;
        super.replaceParentInfo(pSSysEAIDER, cloneSession);
        if (pSSysEAIDER.getPSDERId() != null && (iEntity = cloneSession.getEntity("PSDER", (Object)pSSysEAIDER.getPSDERId())) != null) {
            this.onFillParentInfo_PSDER(pSSysEAIDER, (PSDER)iEntity);
        }
        if (pSSysEAIDER.getPSSysEAIDEId() != null && (iEntity = cloneSession.getEntity("PSSYSEAIDE", (Object)pSSysEAIDER.getPSSysEAIDEId())) != null) {
            this.onFillParentInfo_PSSysEAIDE(pSSysEAIDER, (PSSysEAIDE)iEntity);
        }
        if (pSSysEAIDER.getPSSysEAIElementREId() != null && (iEntity = cloneSession.getEntity("PSSYSEAIELEMENTRE", (Object)pSSysEAIDER.getPSSysEAIElementREId())) != null) {
            this.onFillParentInfo_PSSysEAIElementRE(pSSysEAIDER, (PSSysEAIElementRE)iEntity);
        }
    }

    protected void onRemoveEntityUncopyValues(PSSysEAIDER pSSysEAIDER, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues(pSSysEAIDER, bl);
    }

    protected void onCheckEntity(boolean bl, PSSysEAIDER pSSysEAIDER, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_CodeName(bl, pSSysEAIDER, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_EAIDERTag(bl, pSSysEAIDER, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_EAIDERTag2(bl, pSSysEAIDER, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Memo(bl, pSSysEAIDER, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDERId(bl, pSSysEAIDER, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDERName(bl, pSSysEAIDER, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysEAIDEId(bl, pSSysEAIDER, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysEAIDERId(bl, pSSysEAIDER, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysEAIDERName(bl, pSSysEAIDER, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysEAIElementREId(bl, pSSysEAIDER, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserCat(bl, pSSysEAIDER, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag(bl, pSSysEAIDER, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag2(bl, pSSysEAIDER, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag3(bl, pSSysEAIDER, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag4(bl, pSSysEAIDER, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ValidFlag(bl, pSSysEAIDER, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, pSSysEAIDER, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_CodeName(boolean bl, PSSysEAIDER pSSysEAIDER, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysEAIDER.isCodeNameDirty() && !bl2 : !pSSysEAIDER.isCodeNameDirty()) {
            return null;
        }
        String string = pSSysEAIDER.getCodeName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CODENAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_CodeName_Default(pSSysEAIDER, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CODENAME");
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
                string3 = "PSSYSEAIDEID";
                String string4 = this.checkFieldDupRule(this.getPSSysEAIDERDEModel(), "CODENAME", string3, pSSysEAIDER, bl2, bl3);
                if (!StringHelper.isNullOrEmpty((String)string4)) {
                    EntityFieldError entityFieldError = new EntityFieldError();
                    entityFieldError.setFieldName("CODENAME");
                    entityFieldError.setErrorType(3);
                    entityFieldError.setErrorInfo(string4);
                    return entityFieldError;
                }
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_EAIDERTag(boolean bl, PSSysEAIDER pSSysEAIDER, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysEAIDER.isEAIDERTagDirty() : !pSSysEAIDER.isEAIDERTagDirty()) {
            return null;
        }
        String string = pSSysEAIDER.getEAIDERTag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_EAIDERTag_Default(pSSysEAIDER, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("EAIDERTAG");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_EAIDERTag2(boolean bl, PSSysEAIDER pSSysEAIDER, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysEAIDER.isEAIDERTag2Dirty() : !pSSysEAIDER.isEAIDERTag2Dirty()) {
            return null;
        }
        String string = pSSysEAIDER.getEAIDERTag2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_EAIDERTag2_Default(pSSysEAIDER, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("EAIDERTAG2");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Memo(boolean bl, PSSysEAIDER pSSysEAIDER, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysEAIDER.isMemoDirty() : !pSSysEAIDER.isMemoDirty()) {
            return null;
        }
        String string = pSSysEAIDER.getMemo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Memo_Default(pSSysEAIDER, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDERId(boolean bl, PSSysEAIDER pSSysEAIDER, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysEAIDER.isPSDERIdDirty() && !bl2 : !pSSysEAIDER.isPSDERIdDirty()) {
            return null;
        }
        String string = pSSysEAIDER.getPSDERId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDERID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDERId_Default(pSSysEAIDER, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDERID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDERName(boolean bl, PSSysEAIDER pSSysEAIDER, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysEAIDER.isPSDERNameDirty() : !pSSysEAIDER.isPSDERNameDirty()) {
            return null;
        }
        String string = pSSysEAIDER.getPSDERName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDERName_Default(pSSysEAIDER, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDERNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSysEAIDEId(boolean bl, PSSysEAIDER pSSysEAIDER, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysEAIDER.isPSSysEAIDEIdDirty() && !bl2 : !pSSysEAIDER.isPSSysEAIDEIdDirty()) {
            return null;
        }
        String string = pSSysEAIDER.getPSSysEAIDEId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSEAIDEID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysEAIDEId_Default(pSSysEAIDER, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSEAIDEID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSysEAIDERId(boolean bl, PSSysEAIDER pSSysEAIDER, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysEAIDER.isPSSysEAIDERIdDirty() && !bl2 : !pSSysEAIDER.isPSSysEAIDERIdDirty()) {
            return null;
        }
        String string = pSSysEAIDER.getPSSysEAIDERId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSEAIDERID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysEAIDERId_Default(pSSysEAIDER, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSEAIDERID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSysEAIDERName(boolean bl, PSSysEAIDER pSSysEAIDER, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysEAIDER.isPSSysEAIDERNameDirty() && !bl2 : !pSSysEAIDER.isPSSysEAIDERNameDirty()) {
            return null;
        }
        String string = pSSysEAIDER.getPSSysEAIDERName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSEAIDERNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysEAIDERName_Default(pSSysEAIDER, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSEAIDERNAME");
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
                string3 = "PSSYSEAIDEID";
                String string4 = this.checkFieldDupRule(this.getPSSysEAIDERDEModel(), "PSSYSEAIDERNAME", string3, pSSysEAIDER, bl2, bl3);
                if (!StringHelper.isNullOrEmpty((String)string4)) {
                    EntityFieldError entityFieldError = new EntityFieldError();
                    entityFieldError.setFieldName("PSSYSEAIDERNAME");
                    entityFieldError.setErrorType(3);
                    entityFieldError.setErrorInfo(string4);
                    return entityFieldError;
                }
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSysEAIElementREId(boolean bl, PSSysEAIDER pSSysEAIDER, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysEAIDER.isPSSysEAIElementREIdDirty() : !pSSysEAIDER.isPSSysEAIElementREIdDirty()) {
            return null;
        }
        String string = pSSysEAIDER.getPSSysEAIElementREId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysEAIElementREId_Default(pSSysEAIDER, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSEAIELEMENTREID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_UserCat(boolean bl, PSSysEAIDER pSSysEAIDER, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysEAIDER.isUserCatDirty() : !pSSysEAIDER.isUserCatDirty()) {
            return null;
        }
        String string = pSSysEAIDER.getUserCat();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserCat_Default(pSSysEAIDER, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag(boolean bl, PSSysEAIDER pSSysEAIDER, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysEAIDER.isUserTagDirty() : !pSSysEAIDER.isUserTagDirty()) {
            return null;
        }
        String string = pSSysEAIDER.getUserTag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag_Default(pSSysEAIDER, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag2(boolean bl, PSSysEAIDER pSSysEAIDER, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysEAIDER.isUserTag2Dirty() : !pSSysEAIDER.isUserTag2Dirty()) {
            return null;
        }
        String string = pSSysEAIDER.getUserTag2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag2_Default(pSSysEAIDER, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag3(boolean bl, PSSysEAIDER pSSysEAIDER, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysEAIDER.isUserTag3Dirty() : !pSSysEAIDER.isUserTag3Dirty()) {
            return null;
        }
        String string = pSSysEAIDER.getUserTag3();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag3_Default(pSSysEAIDER, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag4(boolean bl, PSSysEAIDER pSSysEAIDER, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysEAIDER.isUserTag4Dirty() : !pSSysEAIDER.isUserTag4Dirty()) {
            return null;
        }
        String string = pSSysEAIDER.getUserTag4();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag4_Default(pSSysEAIDER, bl2, bl3);
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

    protected EntityFieldError onCheckField_ValidFlag(boolean bl, PSSysEAIDER pSSysEAIDER, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysEAIDER.isValidFlagDirty() && !bl2 : !pSSysEAIDER.isValidFlagDirty()) {
            return null;
        }
        Integer n = pSSysEAIDER.getValidFlag();
        if (bl) {
            if (bl2 && n == null) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("VALIDFLAG");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string = null;
            string = this.onTestValueRule_ValidFlag_Default(pSSysEAIDER, bl2, bl3);
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

    protected void onSyncEntity(PSSysEAIDER pSSysEAIDER, boolean bl) throws Exception {
        super.onSyncEntity(pSSysEAIDER, bl);
    }

    protected void onSyncIndexEntities(PSSysEAIDER pSSysEAIDER, boolean bl) throws Exception {
        super.onSyncIndexEntities(pSSysEAIDER, bl);
    }

    public Object getDataContextValue(PSSysEAIDER pSSysEAIDER, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null) {
            // empty if block
        }
        if ((object = super.getDataContextValue(pSSysEAIDER, string, iDataContextParam)) != null) {
            return object;
        }
        PSSysEAIDE pSSysEAIDE = pSSysEAIDER.getPSSysEAIDE();
        if (pSSysEAIDE != null && pSSysEAIDE.contains(string)) {
            return pSSysEAIDE.get(string);
        }
        return null;
    }

    protected void onExportMajorModel(PSSysEAIDER pSSysEAIDER, ArrayList<JSONObject> arrayList, int n) throws Exception {
        super.onExportMajorModel(pSSysEAIDER, arrayList, n);
    }

    protected String onTestValueRule(String string, String string2, IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        if (StringHelper.compare((String)string, (String)"CODENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CodeName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATEDATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateDate_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATEMAN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateMan_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"EAIDERTAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_EAIDERTag_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"EAIDERTAG2", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_EAIDERTag2_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MEMO", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Memo_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDERID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDERId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDERNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDERName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSEAIDEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysEAIDEId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSEAIDENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysEAIDEName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSEAIDERID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysEAIDERId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSEAIDERNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysEAIDERName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSEAIELEMENTID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysEAIElementId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSEAIELEMENTREID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysEAIElementREId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSEAIELEMENTRENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysEAIElementREName_Default(iEntity, bl, bl2);
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
        if (StringHelper.compare((String)string, (String)"VALIDFLAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ValidFlag_Default(iEntity, bl, bl2);
        }
        return super.onTestValueRule(string, string2, iEntity, bl, bl2);
    }

    protected String onTestValueRule_CodeName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("CODENAME", iEntity, bl2, null, false, 60, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]", false) && this.checkFieldRegExRule("CODENAME", iEntity, bl2, "[a-zA-Z_$][a-zA-Z0-9_$]*", "\u5185\u5bb9\u53ea\u80fd\u7531\u5b57\u6bcd\u3001\u6570\u5b57\u3001\u4e0b\u5212\u7ebf\u7ec4\u6210\uff0c\u4e14\u5f00\u59cb\u5fc5\u987b\u4e3a\u5b57\u6bcd", false)) {
                return null;
            }
            return "(\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60] \u5e76\u4e14 \u5185\u5bb9\u53ea\u80fd\u7531\u5b57\u6bcd\u3001\u6570\u5b57\u3001\u4e0b\u5212\u7ebf\u7ec4\u6210\uff0c\u4e14\u5f00\u59cb\u5fc5\u987b\u4e3a\u5b57\u6bcd)";
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

    protected String onTestValueRule_EAIDERTag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("EAIDERTAG", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_EAIDERTag2_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("EAIDERTAG2", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
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

    protected String onTestValueRule_PSDERId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDERID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDERName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDERNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysEAIDEId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSEAIDEID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysEAIDEName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSEAIDENAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysEAIDERId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSEAIDERID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysEAIDERName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSEAIDERNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysEAIElementId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSEAIELEMENTID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysEAIElementREId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSEAIELEMENTREID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysEAIElementREName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSEAIELEMENTRENAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
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

    protected String onTestValueRule_ValidFlag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    @Override
    protected boolean isPrepareLastForUpdate() {
        return true;
    }

    protected boolean onMergeChild(String string, String string2, PSSysEAIDER pSSysEAIDER) throws Exception {
        boolean bl = false;
        if (super.onMergeChild(string, string2, pSSysEAIDER)) {
            bl = true;
        }
        return bl;
    }

    protected void onUpdateParent(PSSysEAIDER pSSysEAIDER) throws Exception {
        super.onUpdateParent(pSSysEAIDER);
    }

    @Override
    protected void exportCurXmlModel(PSSysEAIDER pSSysEAIDER, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSSYSEAIDER");
        if (!bl) {
            pSSysEAIDER.setCreateDate(null);
            pSSysEAIDER.setCreateMan(null);
            pSSysEAIDER.setPSSysEAIDERId(null);
            pSSysEAIDER.setUpdateDate(null);
            pSSysEAIDER.setUpdateMan(null);
            pSSysEAIDER.setPSDEId(null);
            pSSysEAIDER.setPSSysEAIDEId(null);
            pSSysEAIDER.setPSSysEAIDEName(null);
            pSSysEAIDER.setPSSysEAIElementId(null);
            super.exportCurXmlModel(pSSysEAIDER, xmlNode, bl);
        }
    }

    @Override
    public ObjectNode fillModelV2(ObjectNode objectNode, PSSysEAIDER pSSysEAIDER, String string) throws Exception {
        objectNode = super.fillModelV2(objectNode, pSSysEAIDER, string);
        return objectNode;
    }

    @Override
    public String getModelV2ResScope(IEntity iEntity) throws Exception {
        String string = null;
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSSYSEAIDEID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return StringHelper.format((String)"PSSYSEAIDE#%1$s", (Object)string);
        }
        return super.getModelV2ResScope(iEntity);
    }

    @Override
    public String getModelV2ResScopeDER(IEntity iEntity) throws Exception {
        String string = null;
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSSYSEAIDEID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return "DER1N_PSSYSEAIDER_PSSYSEAIDE_PSSYSEAIDEID";
        }
        return super.getModelV2ResScopeDER(iEntity);
    }

    @Override
    public String getModelV2ResScopeText(IEntity iEntity) throws Exception {
        String string = null;
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSSYSEAIDEID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return DataObject.getStringValue((IDataObject)iEntity, (String)"PSSYSEAIDENAME", null);
        }
        return super.getModelV2ResScopeText(iEntity);
    }

    @Override
    public boolean setModelV2ResScope(IEntity iEntity, String string, String string2) throws Exception {
        if (StringHelper.compare((String)string, (String)"PSSYSEAIDE", (boolean)true) == 0) {
            iEntity.set("PSSYSEAIDEID", (Object)string2);
            return true;
        }
        return super.setModelV2ResScope(iEntity, string, string2);
    }

    @Override
    public String[] getModelV2ResScopeFields() throws Exception {
        return new String[]{"PSSYSEAIDEID"};
    }

    @Override
    public String getModelV2Tag(PSSysEAIDER pSSysEAIDER) {
        if (!StringHelper.isNullOrEmpty((String)pSSysEAIDER.getCodeName())) {
            return pSSysEAIDER.getCodeName();
        }
        if (!StringHelper.isNullOrEmpty((String)pSSysEAIDER.getPSSysEAIDERName())) {
            return pSSysEAIDER.getPSSysEAIDERName();
        }
        if (!StringHelper.isNullOrEmpty((String)pSSysEAIDER.getCodeName())) {
            return pSSysEAIDER.getCodeName();
        }
        return super.getModelV2Tag(pSSysEAIDER);
    }

    @Override
    public boolean setModelV2Tag(PSSysEAIDER pSSysEAIDER, String string) {
        pSSysEAIDER.setCodeName(string);
        return true;
    }

    @Override
    public Map<String, String> getListDRDataFolderFields(Map<String, String> map, PSMOSFile pSMOSFile, IPSMOSFileFilter iPSMOSFileFilter) throws Exception {
        if (map == null) {
            map = new HashMap<String, String>();
        }
        map.put("CODENAME", "");
        map.put("PSSYSEAIDERNAME", "");
        map.put("CODENAME", "");
        map.put("PSSYSEAIDEID", "");
        return super.getListDRDataFolderFields(map, pSMOSFile, iPSMOSFileFilter);
    }

    @Override
    public boolean getModelV2Entity(PSSysEAIDER pSSysEAIDER, String string) throws Exception {
        SimpleEntity simpleEntity = new SimpleEntity();
        pSSysEAIDER.copyTo((IDataObject)simpleEntity, false);
        simpleEntity.copyTo((IDataObject)pSSysEAIDER, true);
        pSSysEAIDER.set("CODENAME", string);
        if (this.select(pSSysEAIDER, true)) {
            return true;
        }
        simpleEntity.copyTo((IDataObject)pSSysEAIDER, true);
        return super.getModelV2Entity(pSSysEAIDER, string);
    }

    @Override
    protected boolean testCompileCurModelV2(PSSysEAIDER pSSysEAIDER, ObjectNode objectNode, String string, String string2, int n) throws Exception {
        if (n == 1) {
            return false;
        }
        return super.testCompileCurModelV2(pSSysEAIDER, objectNode, string, string2, n);
    }

    @Override
    protected Map<String, String> getGetDraftDefaultValueMap(PSSysEAIDER pSSysEAIDER, boolean bl) {
        return defaultValueMap;
    }

    static {
        defaultValueMap.put("CODENAME", "EAIDER");
        defaultValueMap.put("PSSYSEAIDERNAME", "\u5173\u7cfb\u6620\u5c04");
    }
}

