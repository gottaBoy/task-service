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
import net.ibizsys.pscore.srv.dedesign.dao.PSDEGEIVRDAO;
import net.ibizsys.pscore.srv.dedesign.demodel.PSDEGEIVRDEModel;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEFValueRule;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEFValueRuleBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEGEIVR;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEGrid;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEGridBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEGridCol;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEGridColBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysValueRule;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysValueRuleBase;
import net.ibizsys.pscore.srv.sysdevstudio.entity.PSMOSFile;
import net.ibizsys.pscore.srv.util.IPSMOSFileFilter;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDEGEIVRServiceBase
extends PSCoreSysServiceBase<PSDEGEIVR> {
    private static final Log log = LogFactory.getLog(PSDEGEIVRServiceBase.class);
    public static final String DATASET_DEFAULT = "DEFAULT";
    private PSDEGEIVRDEModel pSDEGEIVRDEModel;
    private PSDEGEIVRDAO pSDEGEIVRDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.dedesign.service.PSDEGEIVRService";
    }

    public PSDEGEIVRDEModel getPSDEGEIVRDEModel() {
        if (this.pSDEGEIVRDEModel == null) {
            try {
                this.pSDEGEIVRDEModel = (PSDEGEIVRDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.dedesign.demodel.PSDEGEIVRDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDEGEIVRDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSDEGEIVRDEModel();
    }

    public PSDEGEIVRDAO getPSDEGEIVRDAO() {
        if (this.pSDEGEIVRDAO == null) {
            try {
                this.pSDEGEIVRDAO = (PSDEGEIVRDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.dedesign.dao.PSDEGEIVRDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDEGEIVRDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSDEGEIVRDAO();
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

    protected void onFillParentInfo(PSDEGEIVR pSDEGEIVR, String string, String string2, String string3) throws Exception {
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEGEIVR_PSDEFVALUERULE_PSDEFVRID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEFValueRuleService", (SessionFactory)this.getSessionFactory());
            PSDEFValueRule pSDEFValueRule = (PSDEFValueRule)iService.getDEModel().createEntity();
            pSDEFValueRule.set("PSDEFVALUERULEID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDEFValueRule);
            } else {
                iService.get(pSDEFValueRule);
            }
            this.onFillParentInfo_PSDEFVR(pSDEGEIVR, pSDEFValueRule);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEGEIVR_PSDEGRIDCOL_PSDEGRIDCOLID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEGridColService", (SessionFactory)this.getSessionFactory());
            PSDEGridCol pSDEGridCol = (PSDEGridCol)iService.getDEModel().createEntity();
            pSDEGridCol.set("PSDEGRIDCOLID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDEGridCol);
            } else {
                iService.get(pSDEGridCol);
            }
            this.onFillParentInfo_PSDEGridCol(pSDEGEIVR, pSDEGridCol);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEGEIVR_PSDEGRID_PSDEGRIDID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEGridService", (SessionFactory)this.getSessionFactory());
            PSDEGrid pSDEGrid = (PSDEGrid)iService.getDEModel().createEntity();
            pSDEGrid.set("PSDEGRIDID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDEGrid);
            } else {
                iService.get(pSDEGrid);
            }
            this.onFillParentInfo_PSDEGrid(pSDEGEIVR, pSDEGrid);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEGEIVR_PSSYSVALUERULE_PSSYSVALUERULEID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysValueRuleService", (SessionFactory)this.getSessionFactory());
            PSSysValueRule pSSysValueRule = (PSSysValueRule)iService.getDEModel().createEntity();
            pSSysValueRule.set("PSSYSVALUERULEID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSSysValueRule);
            } else {
                iService.get(pSSysValueRule);
            }
            this.onFillParentInfo_PSSysValueRule(pSDEGEIVR, pSSysValueRule);
            return;
        }
        super.onFillParentInfo(pSDEGEIVR, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        if (StringHelper.compare((String)string, (String)"DER1N_PSDEGEIVR_PSDEGRID_PSDEGRIDID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEGridService", (SessionFactory)this.getSessionFactory());
            PSDEGrid pSDEGrid = (PSDEGrid)iService.getDEModel().createEntity();
            pSDEGrid.set("PSDEGRIDID", string2);
            return this.onSyncDER1NData_PSDEGrid(pSDEGrid, string3);
        }
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillParentInfo_PSDEFVR(PSDEGEIVR pSDEGEIVR, PSDEFValueRule pSDEFValueRule) throws Exception {
        pSDEGEIVR.setPSDEFVRId(pSDEFValueRule.getPSDEFValueRuleId());
        pSDEGEIVR.setPSDEFVRName(pSDEFValueRule.getPSDEFValueRuleName());
    }

    protected void onFillParentInfo_PSDEGridCol(PSDEGEIVR pSDEGEIVR, PSDEGridCol pSDEGridCol) throws Exception {
        pSDEGEIVR.setPSDEGridColId(pSDEGridCol.getPSDEGridColId());
        pSDEGEIVR.setPSDEGridColName(pSDEGridCol.getPSDEGridColName());
        if (pSDEGridCol.getPSDEGrid() != null) {
            this.onFillParentInfo_PSDEGrid(pSDEGEIVR, pSDEGridCol.getPSDEGrid());
        }
    }

    protected void onFillParentInfo_PSDEGrid(PSDEGEIVR pSDEGEIVR, PSDEGrid pSDEGrid) throws Exception {
        pSDEGEIVR.setPSDEGridId(pSDEGrid.getPSDEGridId());
        pSDEGEIVR.setPSDEGridName(pSDEGrid.getPSDEGridName());
    }

    protected String onSyncDER1NData_PSDEGrid(PSDEGrid pSDEGrid, String string) throws Exception {
        if (StringHelper.isNullOrEmpty((String)string)) {
            this.removeByPSDEGrid(pSDEGrid);
        } else {
            HashMap<String, String> hashMap = new HashMap<String, String>();
            String[] stringArray = StringHelper.splitEx((String)string);
            if (stringArray != null) {
                for (int i = 0; i < stringArray.length; ++i) {
                    if (StringHelper.isNullOrEmpty((String)stringArray[i])) continue;
                    hashMap.put(stringArray[i], "");
                }
            }
            ArrayList<PSDEGEIVR> arrayList = this.selectByPSDEGrid(pSDEGrid);
            for (PSDEGEIVR pSDEGEIVR : arrayList) {
                if (hashMap.containsKey(DataObject.getStringValue((IDataObject)pSDEGEIVR, (String)"PSDEGEIVRID", (String)""))) continue;
                this.remove(pSDEGEIVR);
            }
        }
        return null;
    }

    protected void onFillParentInfo_PSSysValueRule(PSDEGEIVR pSDEGEIVR, PSSysValueRule pSSysValueRule) throws Exception {
        pSDEGEIVR.setPSSysValueRuleId(pSSysValueRule.getPSSysValueRuleId());
        pSDEGEIVR.setPSSysValueRuleName(pSSysValueRule.getPSSysValueRuleName());
    }

    protected void onFillEntityFullInfo(PSDEGEIVR pSDEGEIVR, boolean bl) throws Exception {
        if (bl) {
            if (pSDEGEIVR.getPSDEGEIVRName() == null) {
                pSDEGEIVR.setPSDEGEIVRName((String)this.getDefaultValue(this.getWebContext(), "", "\u7f16\u8f91\u9879\u503c\u89c4\u5219", 25));
            }
            if (pSDEGEIVR.getVRType() == null) {
                pSDEGEIVR.setVRType((String)this.getDefaultValue(this.getWebContext(), "", "DEFVALUERULE", 25));
            }
        }
        super.onFillEntityFullInfo(pSDEGEIVR, bl);
        this.onFillEntityFullInfo_PSDEFVR(pSDEGEIVR, bl);
        this.onFillEntityFullInfo_PSDEGridCol(pSDEGEIVR, bl);
        this.onFillEntityFullInfo_PSDEGrid(pSDEGEIVR, bl);
        this.onFillEntityFullInfo_PSSysValueRule(pSDEGEIVR, bl);
    }

    protected void onFillEntityFullInfo_PSDEFVR(PSDEGEIVR pSDEGEIVR, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSDEGridCol(PSDEGEIVR pSDEGEIVR, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSDEGrid(PSDEGEIVR pSDEGEIVR, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSSysValueRule(PSDEGEIVR pSDEGEIVR, boolean bl) throws Exception {
    }

    protected void onWriteBackParent(PSDEGEIVR pSDEGEIVR, boolean bl) throws Exception {
        super.onWriteBackParent(pSDEGEIVR, bl);
    }

    public ArrayList<PSDEGEIVR> selectByPSDEFVR(PSDEFValueRuleBase pSDEFValueRuleBase) throws Exception {
        return this.selectByPSDEFVR(pSDEFValueRuleBase, "", -1);
    }

    public ArrayList<PSDEGEIVR> selectByPSDEFVR(PSDEFValueRuleBase pSDEFValueRuleBase, String string) throws Exception {
        return this.selectByPSDEFVR(pSDEFValueRuleBase, string, -1);
    }

    public ArrayList<PSDEGEIVR> selectByPSDEFVR(PSDEFValueRuleBase pSDEFValueRuleBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDEFVRID", (Object)pSDEFValueRuleBase.getPSDEFValueRuleId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSDEFVRCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSDEFVRCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDEGEIVR> selectByPSDEGridCol(PSDEGridColBase pSDEGridColBase) throws Exception {
        return this.selectByPSDEGridCol(pSDEGridColBase, "", -1);
    }

    public ArrayList<PSDEGEIVR> selectByPSDEGridCol(PSDEGridColBase pSDEGridColBase, String string) throws Exception {
        return this.selectByPSDEGridCol(pSDEGridColBase, string, -1);
    }

    public ArrayList<PSDEGEIVR> selectByPSDEGridCol(PSDEGridColBase pSDEGridColBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDEGRIDCOLID", (Object)pSDEGridColBase.getPSDEGridColId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSDEGridColCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSDEGridColCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDEGEIVR> selectTempByPSDEGridCol(PSDEGridColBase pSDEGridColBase) throws Exception {
        return this.selectTempByPSDEGridCol(pSDEGridColBase, "");
    }

    public ArrayList<PSDEGEIVR> selectTempByPSDEGridCol(PSDEGridColBase pSDEGridColBase, String string) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDEGRIDCOLID", (Object)pSDEGridColBase.getPSDEGridColId());
        selectCond.setOrderInfo(string);
        this.onFillSelectTempByPSDEGridColCond(selectCond);
        return this.selectTemp((ISelectCond)selectCond);
    }

    protected void onFillSelectTempByPSDEGridColCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDEGEIVR> selectByPSDEGrid(PSDEGridBase pSDEGridBase) throws Exception {
        return this.selectByPSDEGrid(pSDEGridBase, "", -1);
    }

    public ArrayList<PSDEGEIVR> selectByPSDEGrid(PSDEGridBase pSDEGridBase, String string) throws Exception {
        return this.selectByPSDEGrid(pSDEGridBase, string, -1);
    }

    public ArrayList<PSDEGEIVR> selectByPSDEGrid(PSDEGridBase pSDEGridBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDEGRIDID", (Object)pSDEGridBase.getPSDEGridId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSDEGridCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSDEGridCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDEGEIVR> selectTempByPSDEGrid(PSDEGridBase pSDEGridBase) throws Exception {
        return this.selectTempByPSDEGrid(pSDEGridBase, "");
    }

    public ArrayList<PSDEGEIVR> selectTempByPSDEGrid(PSDEGridBase pSDEGridBase, String string) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDEGRIDID", (Object)pSDEGridBase.getPSDEGridId());
        selectCond.setOrderInfo(string);
        this.onFillSelectTempByPSDEGridCond(selectCond);
        return this.selectTemp((ISelectCond)selectCond);
    }

    protected void onFillSelectTempByPSDEGridCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDEGEIVR> selectByPSSysValueRule(PSSysValueRuleBase pSSysValueRuleBase) throws Exception {
        return this.selectByPSSysValueRule(pSSysValueRuleBase, "", -1);
    }

    public ArrayList<PSDEGEIVR> selectByPSSysValueRule(PSSysValueRuleBase pSSysValueRuleBase, String string) throws Exception {
        return this.selectByPSSysValueRule(pSSysValueRuleBase, string, -1);
    }

    public ArrayList<PSDEGEIVR> selectByPSSysValueRule(PSSysValueRuleBase pSSysValueRuleBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSSYSVALUERULEID", (Object)pSSysValueRuleBase.getPSSysValueRuleId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSSysValueRuleCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSSysValueRuleCond(SelectCond selectCond) throws Exception {
    }

    public void testRemoveByPSDEFVR(PSDEFValueRule pSDEFValueRule) throws Exception {
        ArrayList<PSDEGEIVR> arrayList = this.selectByPSDEFVR(pSDEFValueRule, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEFVALUERULE");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDEFValueRule);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEGEIVR_PSDEFVALUERULE_PSDEFVRID", "", iDataEntityModel.getName(), "PSDEGEIVR", iDataEntityModel.getDataInfo(pSDEFValueRule), arrayList.get(0)));
        }
    }

    public void resetPSDEFVR(PSDEFValueRule pSDEFValueRule) throws Exception {
        ArrayList<PSDEGEIVR> arrayList = this.selectByPSDEFVR(pSDEFValueRule);
        for (PSDEGEIVR pSDEGEIVR : arrayList) {
            PSDEGEIVR pSDEGEIVR2 = (PSDEGEIVR)this.getDEModel().createEntity();
            pSDEGEIVR2.setPSDEGEIVRId(pSDEGEIVR.getPSDEGEIVRId());
            pSDEGEIVR2.setPSDEFVRId(null);
            this.update(pSDEGEIVR2);
        }
    }

    public void removeByPSDEFVR(PSDEFValueRule pSDEFValueRule) throws Exception {
        final PSDEFValueRule pSDEFValueRule2 = pSDEFValueRule;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEGEIVRServiceBase.this.onBeforeRemoveByPSDEFVR(pSDEFValueRule2);
                PSDEGEIVRServiceBase.this.internalRemoveByPSDEFVR(pSDEFValueRule2);
                PSDEGEIVRServiceBase.this.onAfterRemoveByPSDEFVR(pSDEFValueRule2);
            }
        });
    }

    protected void onBeforeRemoveByPSDEFVR(PSDEFValueRule pSDEFValueRule) throws Exception {
    }

    protected void internalRemoveByPSDEFVR(PSDEFValueRule pSDEFValueRule) throws Exception {
        ArrayList<PSDEGEIVR> arrayList = this.selectByPSDEFVR(pSDEFValueRule);
        this.onBeforeRemoveByPSDEFVR(pSDEFValueRule, arrayList);
        for (PSDEGEIVR pSDEGEIVR : arrayList) {
            this.remove(pSDEGEIVR);
        }
        this.onAfterRemoveByPSDEFVR(pSDEFValueRule, arrayList);
    }

    protected void onAfterRemoveByPSDEFVR(PSDEFValueRule pSDEFValueRule) throws Exception {
    }

    protected void onBeforeRemoveByPSDEFVR(PSDEFValueRule pSDEFValueRule, ArrayList<PSDEGEIVR> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDEFVR(PSDEFValueRule pSDEFValueRule, ArrayList<PSDEGEIVR> arrayList) throws Exception {
    }

    public void testRemoveByPSDEGridCol(PSDEGridCol pSDEGridCol) throws Exception {
    }

    public void resetPSDEGridCol(PSDEGridCol pSDEGridCol) throws Exception {
        ArrayList<PSDEGEIVR> arrayList = this.selectByPSDEGridCol(pSDEGridCol);
        for (PSDEGEIVR pSDEGEIVR : arrayList) {
            PSDEGEIVR pSDEGEIVR2 = (PSDEGEIVR)this.getDEModel().createEntity();
            pSDEGEIVR2.setPSDEGEIVRId(pSDEGEIVR.getPSDEGEIVRId());
            pSDEGEIVR2.setPSDEGridColId(null);
            this.update(pSDEGEIVR2);
        }
    }

    public void resetTempPSDEGridCol(PSDEGridCol pSDEGridCol) throws Exception {
        ArrayList<PSDEGEIVR> arrayList = this.selectTempByPSDEGridCol(pSDEGridCol);
        for (PSDEGEIVR pSDEGEIVR : arrayList) {
            PSDEGEIVR pSDEGEIVR2 = (PSDEGEIVR)this.getDEModel().createEntity();
            pSDEGEIVR2.setPSDEGEIVRId(pSDEGEIVR.getPSDEGEIVRId());
            pSDEGEIVR2.setPSDEGridColId(null);
            this.updateTemp(pSDEGEIVR2);
        }
    }

    public void removeByPSDEGridCol(PSDEGridCol pSDEGridCol) throws Exception {
        final PSDEGridCol pSDEGridCol2 = pSDEGridCol;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEGEIVRServiceBase.this.onBeforeRemoveByPSDEGridCol(pSDEGridCol2);
                PSDEGEIVRServiceBase.this.internalRemoveByPSDEGridCol(pSDEGridCol2);
                PSDEGEIVRServiceBase.this.onAfterRemoveByPSDEGridCol(pSDEGridCol2);
            }
        });
    }

    protected void onBeforeRemoveByPSDEGridCol(PSDEGridCol pSDEGridCol) throws Exception {
    }

    protected void internalRemoveByPSDEGridCol(PSDEGridCol pSDEGridCol) throws Exception {
        ArrayList<PSDEGEIVR> arrayList = this.selectByPSDEGridCol(pSDEGridCol);
        this.onBeforeRemoveByPSDEGridCol(pSDEGridCol, arrayList);
        for (PSDEGEIVR pSDEGEIVR : arrayList) {
            this.remove(pSDEGEIVR);
        }
        this.onAfterRemoveByPSDEGridCol(pSDEGridCol, arrayList);
    }

    protected void onAfterRemoveByPSDEGridCol(PSDEGridCol pSDEGridCol) throws Exception {
    }

    protected void onBeforeRemoveByPSDEGridCol(PSDEGridCol pSDEGridCol, ArrayList<PSDEGEIVR> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDEGridCol(PSDEGridCol pSDEGridCol, ArrayList<PSDEGEIVR> arrayList) throws Exception {
    }

    public void testRemoveByPSDEGrid(PSDEGrid pSDEGrid) throws Exception {
    }

    public void resetPSDEGrid(PSDEGrid pSDEGrid) throws Exception {
        ArrayList<PSDEGEIVR> arrayList = this.selectByPSDEGrid(pSDEGrid);
        for (PSDEGEIVR pSDEGEIVR : arrayList) {
            PSDEGEIVR pSDEGEIVR2 = (PSDEGEIVR)this.getDEModel().createEntity();
            pSDEGEIVR2.setPSDEGEIVRId(pSDEGEIVR.getPSDEGEIVRId());
            pSDEGEIVR2.setPSDEGridId(null);
            this.update(pSDEGEIVR2);
        }
    }

    public void resetTempPSDEGrid(PSDEGrid pSDEGrid) throws Exception {
        ArrayList<PSDEGEIVR> arrayList = this.selectTempByPSDEGrid(pSDEGrid);
        for (PSDEGEIVR pSDEGEIVR : arrayList) {
            PSDEGEIVR pSDEGEIVR2 = (PSDEGEIVR)this.getDEModel().createEntity();
            pSDEGEIVR2.setPSDEGEIVRId(pSDEGEIVR.getPSDEGEIVRId());
            pSDEGEIVR2.setPSDEGridId(null);
            this.updateTemp(pSDEGEIVR2);
        }
    }

    public void removeByPSDEGrid(PSDEGrid pSDEGrid) throws Exception {
        final PSDEGrid pSDEGrid2 = pSDEGrid;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEGEIVRServiceBase.this.onBeforeRemoveByPSDEGrid(pSDEGrid2);
                PSDEGEIVRServiceBase.this.internalRemoveByPSDEGrid(pSDEGrid2);
                PSDEGEIVRServiceBase.this.onAfterRemoveByPSDEGrid(pSDEGrid2);
            }
        });
    }

    protected void onBeforeRemoveByPSDEGrid(PSDEGrid pSDEGrid) throws Exception {
    }

    protected void internalRemoveByPSDEGrid(PSDEGrid pSDEGrid) throws Exception {
        ArrayList<PSDEGEIVR> arrayList = this.selectByPSDEGrid(pSDEGrid);
        this.onBeforeRemoveByPSDEGrid(pSDEGrid, arrayList);
        for (PSDEGEIVR pSDEGEIVR : arrayList) {
            this.remove(pSDEGEIVR);
        }
        this.onAfterRemoveByPSDEGrid(pSDEGrid, arrayList);
    }

    protected void onAfterRemoveByPSDEGrid(PSDEGrid pSDEGrid) throws Exception {
    }

    protected void onBeforeRemoveByPSDEGrid(PSDEGrid pSDEGrid, ArrayList<PSDEGEIVR> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDEGrid(PSDEGrid pSDEGrid, ArrayList<PSDEGEIVR> arrayList) throws Exception {
    }

    public void testRemoveByPSSysValueRule(PSSysValueRule pSSysValueRule) throws Exception {
        ArrayList<PSDEGEIVR> arrayList = this.selectByPSSysValueRule(pSSysValueRule, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSVALUERULE");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSSysValueRule);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEGEIVR_PSSYSVALUERULE_PSSYSVALUERULEID", "", iDataEntityModel.getName(), "PSDEGEIVR", iDataEntityModel.getDataInfo(pSSysValueRule), arrayList.get(0)));
        }
    }

    public void resetPSSysValueRule(PSSysValueRule pSSysValueRule) throws Exception {
        ArrayList<PSDEGEIVR> arrayList = this.selectByPSSysValueRule(pSSysValueRule);
        for (PSDEGEIVR pSDEGEIVR : arrayList) {
            PSDEGEIVR pSDEGEIVR2 = (PSDEGEIVR)this.getDEModel().createEntity();
            pSDEGEIVR2.setPSDEGEIVRId(pSDEGEIVR.getPSDEGEIVRId());
            pSDEGEIVR2.setPSSysValueRuleId(null);
            this.update(pSDEGEIVR2);
        }
    }

    public void removeByPSSysValueRule(PSSysValueRule pSSysValueRule) throws Exception {
        final PSSysValueRule pSSysValueRule2 = pSSysValueRule;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEGEIVRServiceBase.this.onBeforeRemoveByPSSysValueRule(pSSysValueRule2);
                PSDEGEIVRServiceBase.this.internalRemoveByPSSysValueRule(pSSysValueRule2);
                PSDEGEIVRServiceBase.this.onAfterRemoveByPSSysValueRule(pSSysValueRule2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysValueRule(PSSysValueRule pSSysValueRule) throws Exception {
    }

    protected void internalRemoveByPSSysValueRule(PSSysValueRule pSSysValueRule) throws Exception {
        ArrayList<PSDEGEIVR> arrayList = this.selectByPSSysValueRule(pSSysValueRule);
        this.onBeforeRemoveByPSSysValueRule(pSSysValueRule, arrayList);
        for (PSDEGEIVR pSDEGEIVR : arrayList) {
            this.remove(pSDEGEIVR);
        }
        this.onAfterRemoveByPSSysValueRule(pSSysValueRule, arrayList);
    }

    protected void onAfterRemoveByPSSysValueRule(PSSysValueRule pSSysValueRule) throws Exception {
    }

    protected void onBeforeRemoveByPSSysValueRule(PSSysValueRule pSSysValueRule, ArrayList<PSDEGEIVR> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysValueRule(PSSysValueRule pSSysValueRule, ArrayList<PSDEGEIVR> arrayList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(PSDEGEIVR pSDEGEIVR) throws Exception {
        super.onBeforeRemove(pSDEGEIVR);
    }

    public void removeTempByPSDEGridCol(PSDEGridCol pSDEGridCol) throws Exception {
        final PSDEGridCol pSDEGridCol2 = pSDEGridCol;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEGEIVRServiceBase.this.onBeforeRemoveTempByPSDEGridCol(pSDEGridCol2);
                PSDEGEIVRServiceBase.this.internalRemoveTempByPSDEGridCol(pSDEGridCol2);
                PSDEGEIVRServiceBase.this.onAfterRemoveTempByPSDEGridCol(pSDEGridCol2);
            }
        });
    }

    protected void onBeforeRemoveTempByPSDEGridCol(PSDEGridCol pSDEGridCol) throws Exception {
    }

    protected void internalRemoveTempByPSDEGridCol(PSDEGridCol pSDEGridCol) throws Exception {
        ArrayList<PSDEGEIVR> arrayList = this.selectTempByPSDEGridCol(pSDEGridCol);
        this.onBeforeRemoveTempByPSDEGridCol(pSDEGridCol, arrayList);
        for (PSDEGEIVR pSDEGEIVR : arrayList) {
            this.removeTemp(pSDEGEIVR);
        }
        this.onAfterRemoveTempByPSDEGridCol(pSDEGridCol, arrayList);
    }

    protected void onAfterRemoveTempByPSDEGridCol(PSDEGridCol pSDEGridCol) throws Exception {
    }

    protected void onBeforeRemoveTempByPSDEGridCol(PSDEGridCol pSDEGridCol, ArrayList<PSDEGEIVR> arrayList) throws Exception {
    }

    protected void onAfterRemoveTempByPSDEGridCol(PSDEGridCol pSDEGridCol, ArrayList<PSDEGEIVR> arrayList) throws Exception {
    }

    public void removeTempByPSDEGrid(PSDEGrid pSDEGrid) throws Exception {
        final PSDEGrid pSDEGrid2 = pSDEGrid;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEGEIVRServiceBase.this.onBeforeRemoveTempByPSDEGrid(pSDEGrid2);
                PSDEGEIVRServiceBase.this.internalRemoveTempByPSDEGrid(pSDEGrid2);
                PSDEGEIVRServiceBase.this.onAfterRemoveTempByPSDEGrid(pSDEGrid2);
            }
        });
    }

    protected void onBeforeRemoveTempByPSDEGrid(PSDEGrid pSDEGrid) throws Exception {
    }

    protected void internalRemoveTempByPSDEGrid(PSDEGrid pSDEGrid) throws Exception {
        ArrayList<PSDEGEIVR> arrayList = this.selectTempByPSDEGrid(pSDEGrid);
        this.onBeforeRemoveTempByPSDEGrid(pSDEGrid, arrayList);
        for (PSDEGEIVR pSDEGEIVR : arrayList) {
            this.removeTemp(pSDEGEIVR);
        }
        this.onAfterRemoveTempByPSDEGrid(pSDEGrid, arrayList);
    }

    protected void onAfterRemoveTempByPSDEGrid(PSDEGrid pSDEGrid) throws Exception {
    }

    protected void onBeforeRemoveTempByPSDEGrid(PSDEGrid pSDEGrid, ArrayList<PSDEGEIVR> arrayList) throws Exception {
    }

    protected void onAfterRemoveTempByPSDEGrid(PSDEGrid pSDEGrid, ArrayList<PSDEGEIVR> arrayList) throws Exception {
    }

    protected void replaceParentInfo(PSDEGEIVR pSDEGEIVR, CloneSession cloneSession) throws Exception {
        IEntity iEntity;
        super.replaceParentInfo(pSDEGEIVR, cloneSession);
        if (pSDEGEIVR.getPSDEFVRId() != null && (iEntity = cloneSession.getEntity("PSDEFVALUERULE", (Object)pSDEGEIVR.getPSDEFVRId())) != null) {
            this.onFillParentInfo_PSDEFVR(pSDEGEIVR, (PSDEFValueRule)iEntity);
        }
        if (pSDEGEIVR.getPSDEGridColId() != null && (iEntity = cloneSession.getEntity("PSDEGRIDCOL", (Object)pSDEGEIVR.getPSDEGridColId())) != null) {
            this.onFillParentInfo_PSDEGridCol(pSDEGEIVR, (PSDEGridCol)iEntity);
        }
        if (pSDEGEIVR.getPSDEGridId() != null && (iEntity = cloneSession.getEntity("PSDEGRID", (Object)pSDEGEIVR.getPSDEGridId())) != null) {
            this.onFillParentInfo_PSDEGrid(pSDEGEIVR, (PSDEGrid)iEntity);
        }
        if (pSDEGEIVR.getPSSysValueRuleId() != null && (iEntity = cloneSession.getEntity("PSSYSVALUERULE", (Object)pSDEGEIVR.getPSSysValueRuleId())) != null) {
            this.onFillParentInfo_PSSysValueRule(pSDEGEIVR, (PSSysValueRule)iEntity);
        }
    }

    protected void onRemoveEntityUncopyValues(PSDEGEIVR pSDEGEIVR, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues(pSDEGEIVR, bl);
    }

    protected void onCheckEntity(boolean bl, PSDEGEIVR pSDEGEIVR, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_CheckMode(bl, pSDEGEIVR, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Memo(bl, pSDEGEIVR, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ModelState(bl, pSDEGEIVR, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_OrderValue(bl, pSDEGEIVR, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEFVRId(bl, pSDEGEIVR, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEGEIVRId(bl, pSDEGEIVR, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEGEIVRName(bl, pSDEGEIVR, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEGridColId(bl, pSDEGEIVR, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEGridId(bl, pSDEGEIVR, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysValueRuleId(bl, pSDEGEIVR, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserCat(bl, pSDEGEIVR, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag(bl, pSDEGEIVR, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag2(bl, pSDEGEIVR, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag3(bl, pSDEGEIVR, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag4(bl, pSDEGEIVR, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_VRType(bl, pSDEGEIVR, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, pSDEGEIVR, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_CheckMode(boolean bl, PSDEGEIVR pSDEGEIVR, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEGEIVR.isCheckModeDirty() : !pSDEGEIVR.isCheckModeDirty()) {
            return null;
        }
        Integer n = pSDEGEIVR.getCheckMode();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_CheckMode_Default(pSDEGEIVR, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CHECKMODE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Memo(boolean bl, PSDEGEIVR pSDEGEIVR, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEGEIVR.isMemoDirty() : !pSDEGEIVR.isMemoDirty()) {
            return null;
        }
        String string = pSDEGEIVR.getMemo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Memo_Default(pSDEGEIVR, bl2, bl3);
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

    protected EntityFieldError onCheckField_ModelState(boolean bl, PSDEGEIVR pSDEGEIVR, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEGEIVR.isModelStateDirty() : !pSDEGEIVR.isModelStateDirty()) {
            return null;
        }
        Integer n = pSDEGEIVR.getModelState();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_ModelState_Default(pSDEGEIVR, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("MODELSTATE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_OrderValue(boolean bl, PSDEGEIVR pSDEGEIVR, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEGEIVR.isOrderValueDirty() : !pSDEGEIVR.isOrderValueDirty()) {
            return null;
        }
        Integer n = pSDEGEIVR.getOrderValue();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_OrderValue_Default(pSDEGEIVR, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDEFVRId(boolean bl, PSDEGEIVR pSDEGEIVR, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEGEIVR.isPSDEFVRIdDirty() : !pSDEGEIVR.isPSDEFVRIdDirty()) {
            return null;
        }
        String string = pSDEGEIVR.getPSDEFVRId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEFVRId_Default(pSDEGEIVR, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEFVRID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDEGEIVRId(boolean bl, PSDEGEIVR pSDEGEIVR, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEGEIVR.isPSDEGEIVRIdDirty() && !bl2 : !pSDEGEIVR.isPSDEGEIVRIdDirty()) {
            return null;
        }
        String string = pSDEGEIVR.getPSDEGEIVRId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEGEIVRID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEGEIVRId_Default(pSDEGEIVR, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEGEIVRID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDEGEIVRName(boolean bl, PSDEGEIVR pSDEGEIVR, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEGEIVR.isPSDEGEIVRNameDirty() && !bl2 : !pSDEGEIVR.isPSDEGEIVRNameDirty()) {
            return null;
        }
        String string = pSDEGEIVR.getPSDEGEIVRName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEGEIVRNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEGEIVRName_Default(pSDEGEIVR, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEGEIVRNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDEGridColId(boolean bl, PSDEGEIVR pSDEGEIVR, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEGEIVR.isPSDEGridColIdDirty() && !bl2 : !pSDEGEIVR.isPSDEGridColIdDirty()) {
            return null;
        }
        String string = pSDEGEIVR.getPSDEGridColId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEGRIDCOLID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEGridColId_Default(pSDEGEIVR, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEGRIDCOLID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDEGridId(boolean bl, PSDEGEIVR pSDEGEIVR, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEGEIVR.isPSDEGridIdDirty() && !bl2 : !pSDEGEIVR.isPSDEGridIdDirty()) {
            return null;
        }
        String string = pSDEGEIVR.getPSDEGridId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEGRIDID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEGridId_Default(pSDEGEIVR, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEGRIDID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSysValueRuleId(boolean bl, PSDEGEIVR pSDEGEIVR, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEGEIVR.isPSSysValueRuleIdDirty() : !pSDEGEIVR.isPSSysValueRuleIdDirty()) {
            return null;
        }
        String string = pSDEGEIVR.getPSSysValueRuleId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysValueRuleId_Default(pSDEGEIVR, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSVALUERULEID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_UserCat(boolean bl, PSDEGEIVR pSDEGEIVR, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEGEIVR.isUserCatDirty() : !pSDEGEIVR.isUserCatDirty()) {
            return null;
        }
        String string = pSDEGEIVR.getUserCat();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserCat_Default(pSDEGEIVR, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag(boolean bl, PSDEGEIVR pSDEGEIVR, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEGEIVR.isUserTagDirty() : !pSDEGEIVR.isUserTagDirty()) {
            return null;
        }
        String string = pSDEGEIVR.getUserTag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag_Default(pSDEGEIVR, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag2(boolean bl, PSDEGEIVR pSDEGEIVR, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEGEIVR.isUserTag2Dirty() : !pSDEGEIVR.isUserTag2Dirty()) {
            return null;
        }
        String string = pSDEGEIVR.getUserTag2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag2_Default(pSDEGEIVR, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag3(boolean bl, PSDEGEIVR pSDEGEIVR, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEGEIVR.isUserTag3Dirty() : !pSDEGEIVR.isUserTag3Dirty()) {
            return null;
        }
        String string = pSDEGEIVR.getUserTag3();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag3_Default(pSDEGEIVR, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag4(boolean bl, PSDEGEIVR pSDEGEIVR, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEGEIVR.isUserTag4Dirty() : !pSDEGEIVR.isUserTag4Dirty()) {
            return null;
        }
        String string = pSDEGEIVR.getUserTag4();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag4_Default(pSDEGEIVR, bl2, bl3);
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

    protected EntityFieldError onCheckField_VRType(boolean bl, PSDEGEIVR pSDEGEIVR, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEGEIVR.isVRTypeDirty() && !bl2 : !pSDEGEIVR.isVRTypeDirty()) {
            return null;
        }
        String string = pSDEGEIVR.getVRType();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("VRTYPE");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_VRType_Default(pSDEGEIVR, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("VRTYPE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected void onSyncEntity(PSDEGEIVR pSDEGEIVR, boolean bl) throws Exception {
        super.onSyncEntity(pSDEGEIVR, bl);
    }

    protected void onSyncIndexEntities(PSDEGEIVR pSDEGEIVR, boolean bl) throws Exception {
        super.onSyncIndexEntities(pSDEGEIVR, bl);
    }

    public Object getDataContextValue(PSDEGEIVR pSDEGEIVR, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null) {
            // empty if block
        }
        if ((object = super.getDataContextValue(pSDEGEIVR, string, iDataContextParam)) != null) {
            return object;
        }
        PSDEGridCol pSDEGridCol = pSDEGEIVR.getPSDEGridCol();
        if (pSDEGridCol != null && pSDEGridCol.contains(string)) {
            return pSDEGridCol.get(string);
        }
        return null;
    }

    protected void onExportMajorModel(PSDEGEIVR pSDEGEIVR, ArrayList<JSONObject> arrayList, int n) throws Exception {
        super.onExportMajorModel(pSDEGEIVR, arrayList, n);
    }

    protected String onTestValueRule(String string, String string2, IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        if (StringHelper.compare((String)string, (String)"CHECKMODE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CheckMode_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATEDATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateDate_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATEMAN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateMan_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MEMO", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Memo_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MODELSTATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ModelState_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ORDERVALUE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_OrderValue_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEFVRID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEFVRId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEFVRNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEFVRName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEGEIVRID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEGEIVRId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEGEIVRNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEGEIVRName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEGRIDCOLID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEGridColId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEGRIDCOLNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEGridColName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEGRIDID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEGridId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEGRIDNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEGridName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSVALUERULEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysValueRuleId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSVALUERULENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysValueRuleName_Default(iEntity, bl, bl2);
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
        if (StringHelper.compare((String)string, (String)"VRTYPE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_VRType_Default(iEntity, bl, bl2);
        }
        return super.onTestValueRule(string, string2, iEntity, bl, bl2);
    }

    protected String onTestValueRule_CheckMode_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
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

    protected String onTestValueRule_ModelState_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_OrderValue_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_PSDEFVRId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEFVRID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDEFVRName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEFVRNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDEGEIVRId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEGEIVRID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDEGEIVRName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEGEIVRNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDEGridColId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEGRIDCOLID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDEGridColName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEGRIDCOLNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDEGridId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEGRIDID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDEGridName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEGRIDNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysValueRuleId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSVALUERULEID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysValueRuleName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSVALUERULENAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
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

    protected String onTestValueRule_VRType_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("VRTYPE", iEntity, bl2, null, false, 20, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[20]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[20]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected boolean onMergeChild(String string, String string2, PSDEGEIVR pSDEGEIVR) throws Exception {
        boolean bl = false;
        if (super.onMergeChild(string, string2, pSDEGEIVR)) {
            bl = true;
        }
        return bl;
    }

    protected void onUpdateParent(PSDEGEIVR pSDEGEIVR) throws Exception {
        super.onUpdateParent(pSDEGEIVR);
    }

    @Override
    protected void exportCurXmlModel(PSDEGEIVR pSDEGEIVR, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSDEGEIVR");
        if (!bl) {
            pSDEGEIVR.setCreateDate(null);
            pSDEGEIVR.setCreateMan(null);
            pSDEGEIVR.setPSDEGEIVRId(null);
            pSDEGEIVR.setUpdateDate(null);
            pSDEGEIVR.setUpdateMan(null);
            pSDEGEIVR.setPSDEGridColId(null);
            pSDEGEIVR.setPSDEGridId(null);
            pSDEGEIVR.setPSDEGridName(null);
            super.exportCurXmlModel(pSDEGEIVR, xmlNode, bl);
        }
    }

    @Override
    public ObjectNode fillModelV2(ObjectNode objectNode, PSDEGEIVR pSDEGEIVR, String string) throws Exception {
        objectNode = super.fillModelV2(objectNode, pSDEGEIVR, string);
        return objectNode;
    }

    @Override
    public String getModelV2ResScope(IEntity iEntity) throws Exception {
        String string = null;
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSDEGRIDID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return StringHelper.format((String)"PSDEGRID#%1$s", (Object)string);
        }
        return super.getModelV2ResScope(iEntity);
    }

    @Override
    public String getModelV2ResScopeDER(IEntity iEntity) throws Exception {
        String string = null;
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSDEGRIDID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return "DER1N_PSDEGEIVR_PSDEGRID_PSDEGRIDID";
        }
        return super.getModelV2ResScopeDER(iEntity);
    }

    @Override
    public String getModelV2ResScopeText(IEntity iEntity) throws Exception {
        String string = null;
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSDEGRIDID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return DataObject.getStringValue((IDataObject)iEntity, (String)"PSDEGRIDNAME", null);
        }
        return super.getModelV2ResScopeText(iEntity);
    }

    @Override
    public boolean setModelV2ResScope(IEntity iEntity, String string, String string2) throws Exception {
        if (StringHelper.compare((String)string, (String)"PSDEGRID", (boolean)true) == 0) {
            iEntity.set("PSDEGRIDID", (Object)string2);
            return true;
        }
        return super.setModelV2ResScope(iEntity, string, string2);
    }

    @Override
    public String[] getModelV2ResScopeFields() throws Exception {
        return new String[]{"PSDEGRIDID"};
    }

    @Override
    public String getModelV2Tag(PSDEGEIVR pSDEGEIVR) {
        return super.getModelV2Tag(pSDEGEIVR);
    }

    @Override
    public boolean setModelV2Tag(PSDEGEIVR pSDEGEIVR, String string) {
        return super.setModelV2Tag(pSDEGEIVR, string);
    }

    @Override
    public Map<String, String> getListDRDataFolderFields(Map<String, String> map, PSMOSFile pSMOSFile, IPSMOSFileFilter iPSMOSFileFilter) throws Exception {
        if (map == null) {
            map = new HashMap<String, String>();
        }
        map.put("PSDEGRIDID", "");
        return super.getListDRDataFolderFields(map, pSMOSFile, iPSMOSFileFilter);
    }

    @Override
    public boolean getModelV2Entity(PSDEGEIVR pSDEGEIVR, String string) throws Exception {
        SimpleEntity simpleEntity = new SimpleEntity();
        pSDEGEIVR.copyTo((IDataObject)simpleEntity, false);
        simpleEntity.copyTo((IDataObject)pSDEGEIVR, true);
        return super.getModelV2Entity(pSDEGEIVR, string);
    }

    @Override
    protected boolean testCompileCurModelV2(PSDEGEIVR pSDEGEIVR, ObjectNode objectNode, String string, String string2, int n) throws Exception {
        if (n == 1) {
            return false;
        }
        return super.testCompileCurModelV2(pSDEGEIVR, objectNode, string, string2, n);
    }
}

