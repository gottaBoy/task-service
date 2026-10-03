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
package net.ibizsys.pscore.srv.bdscheme.service;

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
import net.ibizsys.pscore.srv.bdscheme.dao.PSSysBDTableRSDAO;
import net.ibizsys.pscore.srv.bdscheme.demodel.PSSysBDTableRSDEModel;
import net.ibizsys.pscore.srv.bdscheme.entity.PSSysBDScheme;
import net.ibizsys.pscore.srv.bdscheme.entity.PSSysBDSchemeBase;
import net.ibizsys.pscore.srv.bdscheme.entity.PSSysBDTable;
import net.ibizsys.pscore.srv.bdscheme.entity.PSSysBDTableBase;
import net.ibizsys.pscore.srv.bdscheme.entity.PSSysBDTableRS;
import net.ibizsys.pscore.srv.core.IPSDataEntityModel;
import net.ibizsys.pscore.srv.dedesign.entity.PSDER;
import net.ibizsys.pscore.srv.dedesign.entity.PSDERBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSystem;
import net.ibizsys.pscore.srv.sysdevstudio.entity.PSMOSFile;
import net.ibizsys.pscore.srv.util.IPSMOSFileFilter;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSSysBDTableRSServiceBase
extends PSCoreSysServiceBase<PSSysBDTableRS> {
    private static final Log log = LogFactory.getLog(PSSysBDTableRSServiceBase.class);
    public static final String DATASET_DEFAULT = "DEFAULT";
    private PSSysBDTableRSDEModel pSSysBDTableRSDEModel;
    private PSSysBDTableRSDAO pSSysBDTableRSDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.bdscheme.service.PSSysBDTableRSService";
    }

    public PSSysBDTableRSDEModel getPSSysBDTableRSDEModel() {
        if (this.pSSysBDTableRSDEModel == null) {
            try {
                this.pSSysBDTableRSDEModel = (PSSysBDTableRSDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.bdscheme.demodel.PSSysBDTableRSDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSSysBDTableRSDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSSysBDTableRSDEModel();
    }

    public PSSysBDTableRSDAO getPSSysBDTableRSDAO() {
        if (this.pSSysBDTableRSDAO == null) {
            try {
                this.pSSysBDTableRSDAO = (PSSysBDTableRSDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.bdscheme.dao.PSSysBDTableRSDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSSysBDTableRSDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSSysBDTableRSDAO();
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

    protected void onFillParentInfo(PSSysBDTableRS pSSysBDTableRS, String string, String string2, String string3) throws Exception {
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSBDTABLERS_PSDER_PSDERID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDERService", (SessionFactory)this.getSessionFactory());
            PSDER pSDER = (PSDER)iService.getDEModel().createEntity();
            pSDER.set("PSDERID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDER);
            } else {
                iService.get(pSDER);
            }
            this.onFillParentInfo_PSDER(pSSysBDTableRS, pSDER);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSBDTABLERS_PSSYSBDSCHEME_PSSYSBDSCHEMEID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.bdscheme.service.PSSysBDSchemeService", (SessionFactory)this.getSessionFactory());
            PSSysBDScheme pSSysBDScheme = (PSSysBDScheme)iService.getDEModel().createEntity();
            pSSysBDScheme.set("PSSYSBDSCHEMEID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSSysBDScheme);
            } else {
                iService.get(pSSysBDScheme);
            }
            this.onFillParentInfo_PSSysBDScheme(pSSysBDTableRS, pSSysBDScheme);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSBDTABLERS_PSSYSBDTABLE_MAJORPSSYSBDTABLEID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.bdscheme.service.PSSysBDTableService", (SessionFactory)this.getSessionFactory());
            PSSysBDTable pSSysBDTable = (PSSysBDTable)iService.getDEModel().createEntity();
            pSSysBDTable.set("PSSYSBDTABLEID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSSysBDTable);
            } else {
                iService.get(pSSysBDTable);
            }
            this.onFillParentInfo_MajorPSSysBDTable(pSSysBDTableRS, pSSysBDTable);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSBDTABLERS_PSSYSBDTABLE_MINORPSSYSBDTABLEID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.bdscheme.service.PSSysBDTableService", (SessionFactory)this.getSessionFactory());
            PSSysBDTable pSSysBDTable = (PSSysBDTable)iService.getDEModel().createEntity();
            pSSysBDTable.set("PSSYSBDTABLEID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSSysBDTable);
            } else {
                iService.get(pSSysBDTable);
            }
            this.onFillParentInfo_MinorPSSysBDTable(pSSysBDTableRS, pSSysBDTable);
            return;
        }
        super.onFillParentInfo(pSSysBDTableRS, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillParentInfo_PSDER(PSSysBDTableRS pSSysBDTableRS, PSDER pSDER) throws Exception {
        pSSysBDTableRS.setPSDERId(pSDER.getPSDERId());
        pSSysBDTableRS.setPSDERName(pSDER.getPSDERName());
    }

    protected void onFillParentInfo_PSSysBDScheme(PSSysBDTableRS pSSysBDTableRS, PSSysBDScheme pSSysBDScheme) throws Exception {
        pSSysBDTableRS.setPSSysBDSchemeId(pSSysBDScheme.getPSSysBDSchemeId());
        pSSysBDTableRS.setPSSysBDSchemeName(pSSysBDScheme.getPSSysBDSchemeName());
    }

    protected void onFillParentInfo_MajorPSSysBDTable(PSSysBDTableRS pSSysBDTableRS, PSSysBDTable pSSysBDTable) throws Exception {
        pSSysBDTableRS.setMajorPSSysBDTableId(pSSysBDTable.getPSSysBDTableId());
        pSSysBDTableRS.setMajorPSSysBDTableName(pSSysBDTable.getPSSysBDTableName());
        if (pSSysBDTable.getPSSysBDScheme() != null) {
            this.onFillParentInfo_PSSysBDScheme(pSSysBDTableRS, pSSysBDTable.getPSSysBDScheme());
        }
    }

    protected void onFillParentInfo_MinorPSSysBDTable(PSSysBDTableRS pSSysBDTableRS, PSSysBDTable pSSysBDTable) throws Exception {
        pSSysBDTableRS.setMinorPSSysBDTableId(pSSysBDTable.getPSSysBDTableId());
        pSSysBDTableRS.setMinorPSSysBDTableName(pSSysBDTable.getPSSysBDTableName());
        if (pSSysBDTable.getPSSysBDScheme() != null) {
            this.onFillParentInfo_PSSysBDScheme(pSSysBDTableRS, pSSysBDTable.getPSSysBDScheme());
        }
    }

    protected boolean onFillEntityKeyValue(PSSysBDTableRS pSSysBDTableRS, boolean bl) throws Exception {
        StringBuilderEx stringBuilderEx = new StringBuilderEx();
        Object object = pSSysBDTableRS.get("PSSYSBDSCHEMEID");
        if (object == null) {
            object = "__EMTPY__";
        }
        stringBuilderEx.append("%1$s", object);
        stringBuilderEx.append("||");
        Object object2 = pSSysBDTableRS.get("MAJORPSSYSBDTABLEID");
        if (object2 == null) {
            object2 = "__EMTPY__";
        }
        stringBuilderEx.append("%1$s", object2);
        stringBuilderEx.append("||");
        Object object3 = pSSysBDTableRS.get("MINORPSSYSBDTABLEID");
        if (object3 == null) {
            object3 = "__EMTPY__";
        }
        stringBuilderEx.append("%1$s", object3);
        String string = stringBuilderEx.toString();
        pSSysBDTableRS.set(this.getPSSysBDTableRSDEModel().getKeyDEField().getName(), KeyValueHelper.genUniqueId((String)string));
        return true;
    }

    protected void onFillEntityFullInfo(PSSysBDTableRS pSSysBDTableRS, boolean bl) throws Exception {
        if (bl && pSSysBDTableRS.getValidFlag() == null) {
            pSSysBDTableRS.setValidFlag((Integer)this.getDefaultValue(this.getWebContext(), "", "1", 9));
        }
        super.onFillEntityFullInfo(pSSysBDTableRS, bl);
        this.onFillEntityFullInfo_PSDER(pSSysBDTableRS, bl);
        this.onFillEntityFullInfo_PSSysBDScheme(pSSysBDTableRS, bl);
        this.onFillEntityFullInfo_MajorPSSysBDTable(pSSysBDTableRS, bl);
        this.onFillEntityFullInfo_MinorPSSysBDTable(pSSysBDTableRS, bl);
    }

    protected void onFillEntityFullInfo_PSDER(PSSysBDTableRS pSSysBDTableRS, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSSysBDScheme(PSSysBDTableRS pSSysBDTableRS, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_MajorPSSysBDTable(PSSysBDTableRS pSSysBDTableRS, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_MinorPSSysBDTable(PSSysBDTableRS pSSysBDTableRS, boolean bl) throws Exception {
    }

    protected void onWriteBackParent(PSSysBDTableRS pSSysBDTableRS, boolean bl) throws Exception {
        super.onWriteBackParent(pSSysBDTableRS, bl);
    }

    public ArrayList<PSSysBDTableRS> selectByPSDER(PSDERBase pSDERBase) throws Exception {
        return this.selectByPSDER(pSDERBase, "", -1);
    }

    public ArrayList<PSSysBDTableRS> selectByPSDER(PSDERBase pSDERBase, String string) throws Exception {
        return this.selectByPSDER(pSDERBase, string, -1);
    }

    public ArrayList<PSSysBDTableRS> selectByPSDER(PSDERBase pSDERBase, String string, int n) throws Exception {
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

    public ArrayList<PSSysBDTableRS> selectByPSSysBDScheme(PSSysBDSchemeBase pSSysBDSchemeBase) throws Exception {
        return this.selectByPSSysBDScheme(pSSysBDSchemeBase, "", -1);
    }

    public ArrayList<PSSysBDTableRS> selectByPSSysBDScheme(PSSysBDSchemeBase pSSysBDSchemeBase, String string) throws Exception {
        return this.selectByPSSysBDScheme(pSSysBDSchemeBase, string, -1);
    }

    public ArrayList<PSSysBDTableRS> selectByPSSysBDScheme(PSSysBDSchemeBase pSSysBDSchemeBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSSYSBDSCHEMEID", (Object)pSSysBDSchemeBase.getPSSysBDSchemeId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSSysBDSchemeCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSSysBDSchemeCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSSysBDTableRS> selectByMajorPSSysBDTable(PSSysBDTableBase pSSysBDTableBase) throws Exception {
        return this.selectByMajorPSSysBDTable(pSSysBDTableBase, "", -1);
    }

    public ArrayList<PSSysBDTableRS> selectByMajorPSSysBDTable(PSSysBDTableBase pSSysBDTableBase, String string) throws Exception {
        return this.selectByMajorPSSysBDTable(pSSysBDTableBase, string, -1);
    }

    public ArrayList<PSSysBDTableRS> selectByMajorPSSysBDTable(PSSysBDTableBase pSSysBDTableBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("MAJORPSSYSBDTABLEID", (Object)pSSysBDTableBase.getPSSysBDTableId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByMajorPSSysBDTableCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByMajorPSSysBDTableCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSSysBDTableRS> selectByMinorPSSysBDTable(PSSysBDTableBase pSSysBDTableBase) throws Exception {
        return this.selectByMinorPSSysBDTable(pSSysBDTableBase, "", -1);
    }

    public ArrayList<PSSysBDTableRS> selectByMinorPSSysBDTable(PSSysBDTableBase pSSysBDTableBase, String string) throws Exception {
        return this.selectByMinorPSSysBDTable(pSSysBDTableBase, string, -1);
    }

    public ArrayList<PSSysBDTableRS> selectByMinorPSSysBDTable(PSSysBDTableBase pSSysBDTableBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("MINORPSSYSBDTABLEID", (Object)pSSysBDTableBase.getPSSysBDTableId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByMinorPSSysBDTableCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByMinorPSSysBDTableCond(SelectCond selectCond) throws Exception {
    }

    public void testRemoveByPSDER(PSDER pSDER) throws Exception {
        ArrayList<PSSysBDTableRS> arrayList = this.selectByPSDER(pSDER, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDER");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDER);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSBDTABLERS_PSDER_PSDERID", "", iDataEntityModel.getName(), "PSSYSBDTABLERS", iDataEntityModel.getDataInfo(pSDER), arrayList.get(0)));
        }
    }

    public void resetPSDER(PSDER pSDER) throws Exception {
        ArrayList<PSSysBDTableRS> arrayList = this.selectByPSDER(pSDER);
        for (PSSysBDTableRS pSSysBDTableRS : arrayList) {
            PSSysBDTableRS pSSysBDTableRS2 = (PSSysBDTableRS)this.getDEModel().createEntity();
            pSSysBDTableRS2.setPSSysBDTableRSId(pSSysBDTableRS.getPSSysBDTableRSId());
            pSSysBDTableRS2.setPSDERId(null);
            this.update(pSSysBDTableRS2);
        }
    }

    public void removeByPSDER(PSDER pSDER) throws Exception {
        final PSDER pSDER2 = pSDER;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysBDTableRSServiceBase.this.onBeforeRemoveByPSDER(pSDER2);
                PSSysBDTableRSServiceBase.this.internalRemoveByPSDER(pSDER2);
                PSSysBDTableRSServiceBase.this.onAfterRemoveByPSDER(pSDER2);
            }
        });
    }

    protected void onBeforeRemoveByPSDER(PSDER pSDER) throws Exception {
    }

    protected void internalRemoveByPSDER(PSDER pSDER) throws Exception {
        ArrayList<PSSysBDTableRS> arrayList = this.selectByPSDER(pSDER);
        this.onBeforeRemoveByPSDER(pSDER, arrayList);
        for (PSSysBDTableRS pSSysBDTableRS : arrayList) {
            this.remove(pSSysBDTableRS);
        }
        this.onAfterRemoveByPSDER(pSDER, arrayList);
    }

    protected void onAfterRemoveByPSDER(PSDER pSDER) throws Exception {
    }

    protected void onBeforeRemoveByPSDER(PSDER pSDER, ArrayList<PSSysBDTableRS> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDER(PSDER pSDER, ArrayList<PSSysBDTableRS> arrayList) throws Exception {
    }

    public void testRemoveByPSSysBDScheme(PSSysBDScheme pSSysBDScheme) throws Exception {
        ArrayList<PSSysBDTableRS> arrayList = this.selectByPSSysBDScheme(pSSysBDScheme, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSBDSCHEME");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSSysBDScheme);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSBDTABLERS_PSSYSBDSCHEME_PSSYSBDSCHEMEID", "", iDataEntityModel.getName(), "PSSYSBDTABLERS", iDataEntityModel.getDataInfo(pSSysBDScheme), arrayList.get(0)));
        }
    }

    public void resetPSSysBDScheme(PSSysBDScheme pSSysBDScheme) throws Exception {
        ArrayList<PSSysBDTableRS> arrayList = this.selectByPSSysBDScheme(pSSysBDScheme);
        for (PSSysBDTableRS pSSysBDTableRS : arrayList) {
            PSSysBDTableRS pSSysBDTableRS2 = (PSSysBDTableRS)this.getDEModel().createEntity();
            pSSysBDTableRS2.setPSSysBDTableRSId(pSSysBDTableRS.getPSSysBDTableRSId());
            pSSysBDTableRS2.setPSSysBDSchemeId(null);
            this.update(pSSysBDTableRS2);
        }
    }

    public void removeByPSSysBDScheme(PSSysBDScheme pSSysBDScheme) throws Exception {
        final PSSysBDScheme pSSysBDScheme2 = pSSysBDScheme;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysBDTableRSServiceBase.this.onBeforeRemoveByPSSysBDScheme(pSSysBDScheme2);
                PSSysBDTableRSServiceBase.this.internalRemoveByPSSysBDScheme(pSSysBDScheme2);
                PSSysBDTableRSServiceBase.this.onAfterRemoveByPSSysBDScheme(pSSysBDScheme2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysBDScheme(PSSysBDScheme pSSysBDScheme) throws Exception {
    }

    protected void internalRemoveByPSSysBDScheme(PSSysBDScheme pSSysBDScheme) throws Exception {
        ArrayList<PSSysBDTableRS> arrayList = this.selectByPSSysBDScheme(pSSysBDScheme);
        this.onBeforeRemoveByPSSysBDScheme(pSSysBDScheme, arrayList);
        for (PSSysBDTableRS pSSysBDTableRS : arrayList) {
            this.remove(pSSysBDTableRS);
        }
        this.onAfterRemoveByPSSysBDScheme(pSSysBDScheme, arrayList);
    }

    protected void onAfterRemoveByPSSysBDScheme(PSSysBDScheme pSSysBDScheme) throws Exception {
    }

    protected void onBeforeRemoveByPSSysBDScheme(PSSysBDScheme pSSysBDScheme, ArrayList<PSSysBDTableRS> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysBDScheme(PSSysBDScheme pSSysBDScheme, ArrayList<PSSysBDTableRS> arrayList) throws Exception {
    }

    public void testRemoveByMajorPSSysBDTable(PSSysBDTable pSSysBDTable) throws Exception {
        ArrayList<PSSysBDTableRS> arrayList = this.selectByMajorPSSysBDTable(pSSysBDTable, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSBDTABLE");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSSysBDTable);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSBDTABLERS_PSSYSBDTABLE_MAJORPSSYSBDTABLEID", "", iDataEntityModel.getName(), "PSSYSBDTABLERS", iDataEntityModel.getDataInfo(pSSysBDTable), arrayList.get(0)));
        }
    }

    public void resetMajorPSSysBDTable(PSSysBDTable pSSysBDTable) throws Exception {
        ArrayList<PSSysBDTableRS> arrayList = this.selectByMajorPSSysBDTable(pSSysBDTable);
        for (PSSysBDTableRS pSSysBDTableRS : arrayList) {
            PSSysBDTableRS pSSysBDTableRS2 = (PSSysBDTableRS)this.getDEModel().createEntity();
            pSSysBDTableRS2.setPSSysBDTableRSId(pSSysBDTableRS.getPSSysBDTableRSId());
            pSSysBDTableRS2.setMajorPSSysBDTableId(null);
            this.update(pSSysBDTableRS2);
        }
    }

    public void removeByMajorPSSysBDTable(PSSysBDTable pSSysBDTable) throws Exception {
        final PSSysBDTable pSSysBDTable2 = pSSysBDTable;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysBDTableRSServiceBase.this.onBeforeRemoveByMajorPSSysBDTable(pSSysBDTable2);
                PSSysBDTableRSServiceBase.this.internalRemoveByMajorPSSysBDTable(pSSysBDTable2);
                PSSysBDTableRSServiceBase.this.onAfterRemoveByMajorPSSysBDTable(pSSysBDTable2);
            }
        });
    }

    protected void onBeforeRemoveByMajorPSSysBDTable(PSSysBDTable pSSysBDTable) throws Exception {
    }

    protected void internalRemoveByMajorPSSysBDTable(PSSysBDTable pSSysBDTable) throws Exception {
        ArrayList<PSSysBDTableRS> arrayList = this.selectByMajorPSSysBDTable(pSSysBDTable);
        this.onBeforeRemoveByMajorPSSysBDTable(pSSysBDTable, arrayList);
        for (PSSysBDTableRS pSSysBDTableRS : arrayList) {
            this.remove(pSSysBDTableRS);
        }
        this.onAfterRemoveByMajorPSSysBDTable(pSSysBDTable, arrayList);
    }

    protected void onAfterRemoveByMajorPSSysBDTable(PSSysBDTable pSSysBDTable) throws Exception {
    }

    protected void onBeforeRemoveByMajorPSSysBDTable(PSSysBDTable pSSysBDTable, ArrayList<PSSysBDTableRS> arrayList) throws Exception {
    }

    protected void onAfterRemoveByMajorPSSysBDTable(PSSysBDTable pSSysBDTable, ArrayList<PSSysBDTableRS> arrayList) throws Exception {
    }

    public void testRemoveByMinorPSSysBDTable(PSSysBDTable pSSysBDTable) throws Exception {
        ArrayList<PSSysBDTableRS> arrayList = this.selectByMinorPSSysBDTable(pSSysBDTable, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSBDTABLE");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSSysBDTable);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSBDTABLERS_PSSYSBDTABLE_MINORPSSYSBDTABLEID", "", iDataEntityModel.getName(), "PSSYSBDTABLERS", iDataEntityModel.getDataInfo(pSSysBDTable), arrayList.get(0)));
        }
    }

    public void resetMinorPSSysBDTable(PSSysBDTable pSSysBDTable) throws Exception {
        ArrayList<PSSysBDTableRS> arrayList = this.selectByMinorPSSysBDTable(pSSysBDTable);
        for (PSSysBDTableRS pSSysBDTableRS : arrayList) {
            PSSysBDTableRS pSSysBDTableRS2 = (PSSysBDTableRS)this.getDEModel().createEntity();
            pSSysBDTableRS2.setPSSysBDTableRSId(pSSysBDTableRS.getPSSysBDTableRSId());
            pSSysBDTableRS2.setMinorPSSysBDTableId(null);
            this.update(pSSysBDTableRS2);
        }
    }

    public void removeByMinorPSSysBDTable(PSSysBDTable pSSysBDTable) throws Exception {
        final PSSysBDTable pSSysBDTable2 = pSSysBDTable;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysBDTableRSServiceBase.this.onBeforeRemoveByMinorPSSysBDTable(pSSysBDTable2);
                PSSysBDTableRSServiceBase.this.internalRemoveByMinorPSSysBDTable(pSSysBDTable2);
                PSSysBDTableRSServiceBase.this.onAfterRemoveByMinorPSSysBDTable(pSSysBDTable2);
            }
        });
    }

    protected void onBeforeRemoveByMinorPSSysBDTable(PSSysBDTable pSSysBDTable) throws Exception {
    }

    protected void internalRemoveByMinorPSSysBDTable(PSSysBDTable pSSysBDTable) throws Exception {
        ArrayList<PSSysBDTableRS> arrayList = this.selectByMinorPSSysBDTable(pSSysBDTable);
        this.onBeforeRemoveByMinorPSSysBDTable(pSSysBDTable, arrayList);
        for (PSSysBDTableRS pSSysBDTableRS : arrayList) {
            this.remove(pSSysBDTableRS);
        }
        this.onAfterRemoveByMinorPSSysBDTable(pSSysBDTable, arrayList);
    }

    protected void onAfterRemoveByMinorPSSysBDTable(PSSysBDTable pSSysBDTable) throws Exception {
    }

    protected void onBeforeRemoveByMinorPSSysBDTable(PSSysBDTable pSSysBDTable, ArrayList<PSSysBDTableRS> arrayList) throws Exception {
    }

    protected void onAfterRemoveByMinorPSSysBDTable(PSSysBDTable pSSysBDTable, ArrayList<PSSysBDTableRS> arrayList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(PSSysBDTableRS pSSysBDTableRS) throws Exception {
        super.onBeforeRemove(pSSysBDTableRS);
    }

    protected void replaceParentInfo(PSSysBDTableRS pSSysBDTableRS, CloneSession cloneSession) throws Exception {
        IEntity iEntity;
        super.replaceParentInfo(pSSysBDTableRS, cloneSession);
        if (pSSysBDTableRS.getPSDERId() != null && (iEntity = cloneSession.getEntity("PSDER", (Object)pSSysBDTableRS.getPSDERId())) != null) {
            this.onFillParentInfo_PSDER(pSSysBDTableRS, (PSDER)iEntity);
        }
        if (pSSysBDTableRS.getPSSysBDSchemeId() != null && (iEntity = cloneSession.getEntity("PSSYSBDSCHEME", (Object)pSSysBDTableRS.getPSSysBDSchemeId())) != null) {
            this.onFillParentInfo_PSSysBDScheme(pSSysBDTableRS, (PSSysBDScheme)iEntity);
        }
        if (pSSysBDTableRS.getMajorPSSysBDTableId() != null && (iEntity = cloneSession.getEntity("PSSYSBDTABLE", (Object)pSSysBDTableRS.getMajorPSSysBDTableId())) != null) {
            this.onFillParentInfo_MajorPSSysBDTable(pSSysBDTableRS, (PSSysBDTable)iEntity);
        }
        if (pSSysBDTableRS.getMinorPSSysBDTableId() != null && (iEntity = cloneSession.getEntity("PSSYSBDTABLE", (Object)pSSysBDTableRS.getMinorPSSysBDTableId())) != null) {
            this.onFillParentInfo_MinorPSSysBDTable(pSSysBDTableRS, (PSSysBDTable)iEntity);
        }
    }

    protected void onRemoveEntityUncopyValues(PSSysBDTableRS pSSysBDTableRS, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues(pSSysBDTableRS, bl);
    }

    protected void onCheckEntity(boolean bl, PSSysBDTableRS pSSysBDTableRS, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_CodeName(bl, pSSysBDTableRS, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_MajorPSSysBDTableId(bl, pSSysBDTableRS, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Memo(bl, pSSysBDTableRS, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_MinorCodeName(bl, pSSysBDTableRS, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_MinorPSSysBDTableId(bl, pSSysBDTableRS, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_OrderValue(bl, pSSysBDTableRS, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDERId(bl, pSSysBDTableRS, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysBDSchemeId(bl, pSSysBDTableRS, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysBDTableRSId(bl, pSSysBDTableRS, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysBDTableRSName(bl, pSSysBDTableRS, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserCat(bl, pSSysBDTableRS, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag(bl, pSSysBDTableRS, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag2(bl, pSSysBDTableRS, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag3(bl, pSSysBDTableRS, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag4(bl, pSSysBDTableRS, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ValidFlag(bl, pSSysBDTableRS, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, pSSysBDTableRS, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_CodeName(boolean bl, PSSysBDTableRS pSSysBDTableRS, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysBDTableRS.isCodeNameDirty() : !pSSysBDTableRS.isCodeNameDirty()) {
            return null;
        }
        String string = pSSysBDTableRS.getCodeName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_CodeName_Default(pSSysBDTableRS, bl2, bl3);
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
                string3 = "MINORPSSYSBDTABLEID";
                String string4 = this.checkFieldDupRule(this.getPSSysBDTableRSDEModel(), "CODENAME", string3, pSSysBDTableRS, bl2, bl3);
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

    protected EntityFieldError onCheckField_MajorPSSysBDTableId(boolean bl, PSSysBDTableRS pSSysBDTableRS, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysBDTableRS.isMajorPSSysBDTableIdDirty() && !bl2 : !pSSysBDTableRS.isMajorPSSysBDTableIdDirty()) {
            return null;
        }
        String string = pSSysBDTableRS.getMajorPSSysBDTableId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("MAJORPSSYSBDTABLEID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_MajorPSSysBDTableId_Default(pSSysBDTableRS, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("MAJORPSSYSBDTABLEID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Memo(boolean bl, PSSysBDTableRS pSSysBDTableRS, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysBDTableRS.isMemoDirty() : !pSSysBDTableRS.isMemoDirty()) {
            return null;
        }
        String string = pSSysBDTableRS.getMemo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Memo_Default(pSSysBDTableRS, bl2, bl3);
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

    protected EntityFieldError onCheckField_MinorCodeName(boolean bl, PSSysBDTableRS pSSysBDTableRS, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysBDTableRS.isMinorCodeNameDirty() : !pSSysBDTableRS.isMinorCodeNameDirty()) {
            return null;
        }
        String string = pSSysBDTableRS.getMinorCodeName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_MinorCodeName_Default(pSSysBDTableRS, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("MINORCODENAME");
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
                string3 = "MAJORPSSYSBDTABLEID";
                String string4 = this.checkFieldDupRule(this.getPSSysBDTableRSDEModel(), "MINORCODENAME", string3, pSSysBDTableRS, bl2, bl3);
                if (!StringHelper.isNullOrEmpty((String)string4)) {
                    EntityFieldError entityFieldError = new EntityFieldError();
                    entityFieldError.setFieldName("MINORCODENAME");
                    entityFieldError.setErrorType(3);
                    entityFieldError.setErrorInfo(string4);
                    return entityFieldError;
                }
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_MinorPSSysBDTableId(boolean bl, PSSysBDTableRS pSSysBDTableRS, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysBDTableRS.isMinorPSSysBDTableIdDirty() && !bl2 : !pSSysBDTableRS.isMinorPSSysBDTableIdDirty()) {
            return null;
        }
        String string = pSSysBDTableRS.getMinorPSSysBDTableId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("MINORPSSYSBDTABLEID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_MinorPSSysBDTableId_Default(pSSysBDTableRS, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("MINORPSSYSBDTABLEID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_OrderValue(boolean bl, PSSysBDTableRS pSSysBDTableRS, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysBDTableRS.isOrderValueDirty() : !pSSysBDTableRS.isOrderValueDirty()) {
            return null;
        }
        Integer n = pSSysBDTableRS.getOrderValue();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_OrderValue_Default(pSSysBDTableRS, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDERId(boolean bl, PSSysBDTableRS pSSysBDTableRS, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysBDTableRS.isPSDERIdDirty() : !pSSysBDTableRS.isPSDERIdDirty()) {
            return null;
        }
        String string = pSSysBDTableRS.getPSDERId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDERId_Default(pSSysBDTableRS, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSSysBDSchemeId(boolean bl, PSSysBDTableRS pSSysBDTableRS, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysBDTableRS.isPSSysBDSchemeIdDirty() && !bl2 : !pSSysBDTableRS.isPSSysBDSchemeIdDirty()) {
            return null;
        }
        String string = pSSysBDTableRS.getPSSysBDSchemeId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSBDSCHEMEID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysBDSchemeId_Default(pSSysBDTableRS, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSBDSCHEMEID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSysBDTableRSId(boolean bl, PSSysBDTableRS pSSysBDTableRS, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysBDTableRS.isPSSysBDTableRSIdDirty() && !bl2 : !pSSysBDTableRS.isPSSysBDTableRSIdDirty()) {
            return null;
        }
        String string = pSSysBDTableRS.getPSSysBDTableRSId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSBDTABLERSID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysBDTableRSId_Default(pSSysBDTableRS, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSBDTABLERSID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSysBDTableRSName(boolean bl, PSSysBDTableRS pSSysBDTableRS, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysBDTableRS.isPSSysBDTableRSNameDirty() : !pSSysBDTableRS.isPSSysBDTableRSNameDirty()) {
            return null;
        }
        String string = pSSysBDTableRS.getPSSysBDTableRSName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysBDTableRSName_Default(pSSysBDTableRS, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSBDTABLERSNAME");
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
                string3 = "PSSYSBDSCHEMEID";
                String string4 = this.checkFieldDupRule(this.getPSSysBDTableRSDEModel(), "PSSYSBDTABLERSNAME", string3, pSSysBDTableRS, bl2, bl3);
                if (!StringHelper.isNullOrEmpty((String)string4)) {
                    EntityFieldError entityFieldError = new EntityFieldError();
                    entityFieldError.setFieldName("PSSYSBDTABLERSNAME");
                    entityFieldError.setErrorType(3);
                    entityFieldError.setErrorInfo(string4);
                    return entityFieldError;
                }
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_UserCat(boolean bl, PSSysBDTableRS pSSysBDTableRS, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysBDTableRS.isUserCatDirty() : !pSSysBDTableRS.isUserCatDirty()) {
            return null;
        }
        String string = pSSysBDTableRS.getUserCat();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserCat_Default(pSSysBDTableRS, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag(boolean bl, PSSysBDTableRS pSSysBDTableRS, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysBDTableRS.isUserTagDirty() : !pSSysBDTableRS.isUserTagDirty()) {
            return null;
        }
        String string = pSSysBDTableRS.getUserTag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag_Default(pSSysBDTableRS, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag2(boolean bl, PSSysBDTableRS pSSysBDTableRS, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysBDTableRS.isUserTag2Dirty() : !pSSysBDTableRS.isUserTag2Dirty()) {
            return null;
        }
        String string = pSSysBDTableRS.getUserTag2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag2_Default(pSSysBDTableRS, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag3(boolean bl, PSSysBDTableRS pSSysBDTableRS, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysBDTableRS.isUserTag3Dirty() : !pSSysBDTableRS.isUserTag3Dirty()) {
            return null;
        }
        String string = pSSysBDTableRS.getUserTag3();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag3_Default(pSSysBDTableRS, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag4(boolean bl, PSSysBDTableRS pSSysBDTableRS, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysBDTableRS.isUserTag4Dirty() : !pSSysBDTableRS.isUserTag4Dirty()) {
            return null;
        }
        String string = pSSysBDTableRS.getUserTag4();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag4_Default(pSSysBDTableRS, bl2, bl3);
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

    protected EntityFieldError onCheckField_ValidFlag(boolean bl, PSSysBDTableRS pSSysBDTableRS, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysBDTableRS.isValidFlagDirty() : !pSSysBDTableRS.isValidFlagDirty()) {
            return null;
        }
        Integer n = pSSysBDTableRS.getValidFlag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_ValidFlag_Default(pSSysBDTableRS, bl2, bl3);
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

    protected void onSyncEntity(PSSysBDTableRS pSSysBDTableRS, boolean bl) throws Exception {
        super.onSyncEntity(pSSysBDTableRS, bl);
    }

    protected void onSyncIndexEntities(PSSysBDTableRS pSSysBDTableRS, boolean bl) throws Exception {
        super.onSyncIndexEntities(pSSysBDTableRS, bl);
    }

    public Object getDataContextValue(PSSysBDTableRS pSSysBDTableRS, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null) {
            // empty if block
        }
        if ((object = super.getDataContextValue(pSSysBDTableRS, string, iDataContextParam)) != null) {
            return object;
        }
        PSSysBDScheme pSSysBDScheme = pSSysBDTableRS.getPSSysBDScheme();
        if (pSSysBDScheme != null && pSSysBDScheme.contains(string)) {
            return pSSysBDScheme.get(string);
        }
        return null;
    }

    protected void onExportMajorModel(PSSysBDTableRS pSSysBDTableRS, ArrayList<JSONObject> arrayList, int n) throws Exception {
        super.onExportMajorModel(pSSysBDTableRS, arrayList, n);
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
        if (StringHelper.compare((String)string, (String)"MAJORPSSYSBDTABLEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_MajorPSSysBDTableId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MAJORPSSYSBDTABLENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_MajorPSSysBDTableName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MEMO", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Memo_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MINORCODENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_MinorCodeName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MINORPSSYSBDTABLEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_MinorPSSysBDTableId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MINORPSSYSBDTABLENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_MinorPSSysBDTableName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ORDERVALUE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_OrderValue_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDERID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDERId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDERNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDERName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSBDSCHEMEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysBDSchemeId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSBDSCHEMENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysBDSchemeName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSBDTABLERSID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysBDTableRSId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSBDTABLERSNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysBDTableRSName_Default(iEntity, bl, bl2);
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

    protected String onTestValueRule_MajorPSSysBDTableId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("MAJORPSSYSBDTABLEID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_MajorPSSysBDTableName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("MAJORPSSYSBDTABLENAME", iEntity, bl2, null, false, 50, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]";
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

    protected String onTestValueRule_MinorCodeName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("MINORCODENAME", iEntity, bl2, null, false, 60, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]", false) && this.checkFieldRegExRule("MINORCODENAME", iEntity, bl2, "[a-zA-Z_$][a-zA-Z0-9_$]*", "\u5185\u5bb9\u53ea\u80fd\u7531\u5b57\u6bcd\u3001\u6570\u5b57\u3001\u4e0b\u5212\u7ebf\u7ec4\u6210\uff0c\u4e14\u5f00\u59cb\u5fc5\u987b\u4e3a\u5b57\u6bcd", false)) {
                return null;
            }
            return "(\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60] \u5e76\u4e14 \u5185\u5bb9\u53ea\u80fd\u7531\u5b57\u6bcd\u3001\u6570\u5b57\u3001\u4e0b\u5212\u7ebf\u7ec4\u6210\uff0c\u4e14\u5f00\u59cb\u5fc5\u987b\u4e3a\u5b57\u6bcd)";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_MinorPSSysBDTableId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldSimpleRule("MINORPSSYSBDTABLEID", iEntity, bl2, "NOTEQ", "ENTITYFIELD", "MAJORPSSYSBDTABLEID", "\u4ece\u6570\u636e\u8868\u4e0d\u80fd\u4e0e\u4e3b\u6570\u636e\u8868\u76f8\u540c", true) && this.checkFieldStringLengthRule("MINORPSSYSBDTABLEID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "(\u4ece\u6570\u636e\u8868\u4e0d\u80fd\u4e0e\u4e3b\u6570\u636e\u8868\u76f8\u540c \u5e76\u4e14 \u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100])";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_MinorPSSysBDTableName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("MINORPSSYSBDTABLENAME", iEntity, bl2, null, false, 50, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_OrderValue_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
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

    protected String onTestValueRule_PSSysBDSchemeId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSBDSCHEMEID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysBDSchemeName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSBDSCHEMENAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysBDTableRSId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSBDTABLERSID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysBDTableRSName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSBDTABLERSNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
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

    protected boolean onMergeChild(String string, String string2, PSSysBDTableRS pSSysBDTableRS) throws Exception {
        boolean bl = false;
        if (super.onMergeChild(string, string2, pSSysBDTableRS)) {
            bl = true;
        }
        return bl;
    }

    protected void onUpdateParent(PSSysBDTableRS pSSysBDTableRS) throws Exception {
        super.onUpdateParent(pSSysBDTableRS);
    }

    @Override
    protected void exportCurXmlModel(PSSysBDTableRS pSSysBDTableRS, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSSYSBDTABLERS");
        if (!bl) {
            pSSysBDTableRS.setCreateDate(null);
            pSSysBDTableRS.setCreateMan(null);
            pSSysBDTableRS.setPSSysBDTableRSId(null);
            pSSysBDTableRS.setPSSysBDTableRSName(null);
            pSSysBDTableRS.setUpdateDate(null);
            pSSysBDTableRS.setUpdateMan(null);
            super.exportCurXmlModel(pSSysBDTableRS, xmlNode, bl);
        }
    }

    @Override
    protected String getEntityFolderKeyValue(PSSysBDTableRS pSSysBDTableRS, PSSystem pSSystem) throws Exception {
        PSSysBDTableRS pSSysBDTableRS2 = new PSSysBDTableRS();
        pSSysBDTableRS2.setPSSysBDSchemeId(pSSysBDTableRS.getPSSysBDSchemeId());
        pSSysBDTableRS2.setMajorPSSysBDTableId(pSSysBDTableRS.getMajorPSSysBDTableId());
        pSSysBDTableRS2.setMinorPSSysBDTableId(pSSysBDTableRS.getMinorPSSysBDTableId());
        if (this.selectOne(pSSysBDTableRS2, true)) {
            return pSSysBDTableRS2.getPSSysBDTableRSId();
        }
        return super.getEntityFolderKeyValue(pSSysBDTableRS, pSSystem);
    }

    @Override
    public ObjectNode fillModelV2(ObjectNode objectNode, PSSysBDTableRS pSSysBDTableRS, String string) throws Exception {
        objectNode = super.fillModelV2(objectNode, pSSysBDTableRS, string);
        return objectNode;
    }

    @Override
    public String getModelV2ResScope(IEntity iEntity) throws Exception {
        String string = null;
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSSYSBDSCHEMEID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return StringHelper.format((String)"PSSYSBDSCHEME#%1$s", (Object)string);
        }
        return super.getModelV2ResScope(iEntity);
    }

    @Override
    public String getModelV2ResScopeDER(IEntity iEntity) throws Exception {
        String string = null;
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSSYSBDSCHEMEID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return "DER1N_PSSYSBDTABLERS_PSSYSBDSCHEME_PSSYSBDSCHEMEID";
        }
        return super.getModelV2ResScopeDER(iEntity);
    }

    @Override
    public String getModelV2ResScopeText(IEntity iEntity) throws Exception {
        String string = null;
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSSYSBDSCHEMEID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return DataObject.getStringValue((IDataObject)iEntity, (String)"PSSYSBDSCHEMENAME", null);
        }
        return super.getModelV2ResScopeText(iEntity);
    }

    @Override
    public boolean setModelV2ResScope(IEntity iEntity, String string, String string2) throws Exception {
        if (StringHelper.compare((String)string, (String)"PSSYSBDSCHEME", (boolean)true) == 0) {
            iEntity.set("PSSYSBDSCHEMEID", (Object)string2);
            return true;
        }
        return super.setModelV2ResScope(iEntity, string, string2);
    }

    @Override
    public String[] getModelV2ResScopeFields() throws Exception {
        return new String[]{"PSSYSBDSCHEMEID"};
    }

    @Override
    public String getModelV2Tag(PSSysBDTableRS pSSysBDTableRS) {
        if (!StringHelper.isNullOrEmpty((String)pSSysBDTableRS.getPSSysBDTableRSName())) {
            return pSSysBDTableRS.getPSSysBDTableRSName();
        }
        if (!StringHelper.isNullOrEmpty((String)pSSysBDTableRS.getCodeName())) {
            return pSSysBDTableRS.getCodeName();
        }
        return super.getModelV2Tag(pSSysBDTableRS);
    }

    @Override
    public boolean setModelV2Tag(PSSysBDTableRS pSSysBDTableRS, String string) {
        pSSysBDTableRS.setPSSysBDTableRSName(string);
        return true;
    }

    @Override
    public Map<String, String> getListDRDataFolderFields(Map<String, String> map, PSMOSFile pSMOSFile, IPSMOSFileFilter iPSMOSFileFilter) throws Exception {
        if (map == null) {
            map = new HashMap<String, String>();
        }
        map.put("PSSYSBDTABLERSNAME", "");
        map.put("CODENAME", "");
        map.put("PSSYSBDSCHEMEID", "");
        return super.getListDRDataFolderFields(map, pSMOSFile, iPSMOSFileFilter);
    }

    @Override
    public boolean getModelV2Entity(PSSysBDTableRS pSSysBDTableRS, String string) throws Exception {
        SimpleEntity simpleEntity = new SimpleEntity();
        pSSysBDTableRS.copyTo((IDataObject)simpleEntity, false);
        simpleEntity.copyTo((IDataObject)pSSysBDTableRS, true);
        pSSysBDTableRS.set("PSSYSBDTABLERSNAME", string);
        if (this.select(pSSysBDTableRS, true)) {
            return true;
        }
        simpleEntity.copyTo((IDataObject)pSSysBDTableRS, true);
        return super.getModelV2Entity(pSSysBDTableRS, string);
    }

    @Override
    protected boolean testCompileCurModelV2(PSSysBDTableRS pSSysBDTableRS, ObjectNode objectNode, String string, String string2, int n) throws Exception {
        if (n == 1) {
            return false;
        }
        return super.testCompileCurModelV2(pSSysBDTableRS, objectNode, string, string2, n);
    }
}

