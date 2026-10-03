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
import net.ibizsys.pscore.srv.core.IPSDataEntityModel;
import net.ibizsys.pscore.srv.dedesign.entity.PSDataEntity;
import net.ibizsys.pscore.srv.dedesign.entity.PSDataEntityBase;
import net.ibizsys.pscore.srv.sysdesign.dao.PSSysDMItemDAO;
import net.ibizsys.pscore.srv.sysdesign.demodel.PSSysDMItemDEModel;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysDMItem;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysDMVer;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysDMVerBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSystem;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSystemDBCfg;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSystemDBCfgBase;
import net.ibizsys.pscore.srv.sysdevstudio.entity.PSMOSFile;
import net.ibizsys.pscore.srv.util.IPSMOSFileFilter;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSSysDMItemServiceBase
extends PSCoreSysServiceBase<PSSysDMItem> {
    private static final Log log = LogFactory.getLog(PSSysDMItemServiceBase.class);
    public static final String DATASET_CURSYS = "CurSys";
    public static final String DATASET_DEFAULT = "DEFAULT";
    private PSSysDMItemDEModel pSSysDMItemDEModel;
    private PSSysDMItemDAO pSSysDMItemDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.sysdesign.service.PSSysDMItemService";
    }

    public PSSysDMItemDEModel getPSSysDMItemDEModel() {
        if (this.pSSysDMItemDEModel == null) {
            try {
                this.pSSysDMItemDEModel = (PSSysDMItemDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.sysdesign.demodel.PSSysDMItemDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSSysDMItemDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSSysDMItemDEModel();
    }

    public PSSysDMItemDAO getPSSysDMItemDAO() {
        if (this.pSSysDMItemDAO == null) {
            try {
                this.pSSysDMItemDAO = (PSSysDMItemDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.sysdesign.dao.PSSysDMItemDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSSysDMItemDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSSysDMItemDAO();
    }

    protected DBFetchResult onfetchDataSet(String string, IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        if (StringHelper.compare((String)string, (String)DATASET_CURSYS, (boolean)true) == 0) {
            return this.fetchCurSys(iDEDataSetFetchContext);
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

    public DBFetchResult fetchCurSys(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CURSYS, false);
        return dBFetchResult;
    }

    public DBFetchResult fetchDefault(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_DEFAULT, false);
        return dBFetchResult;
    }

    protected void onFillParentInfo(PSSysDMItem pSSysDMItem, String string, String string2, String string3) throws Exception {
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSDMITEM_PSDATAENTITY_PSDEID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDataEntityService", (SessionFactory)this.getSessionFactory());
            PSDataEntity pSDataEntity = (PSDataEntity)iService.getDEModel().createEntity();
            pSDataEntity.set("PSDATAENTITYID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDataEntity);
            } else {
                iService.get(pSDataEntity);
            }
            this.onFillParentInfo_PSDE(pSSysDMItem, pSDataEntity);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSDMITEM_PSSYSDMVER_PSSYSDMVERID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysDMVerService", (SessionFactory)this.getSessionFactory());
            PSSysDMVer pSSysDMVer = (PSSysDMVer)iService.getDEModel().createEntity();
            pSSysDMVer.set("PSSYSDMVERID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSSysDMVer);
            } else {
                iService.get(pSSysDMVer);
            }
            this.onFillParentInfo_PSSysDMVer(pSSysDMItem, pSSysDMVer);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSDMITEM_PSSYSTEMDBCFG_PSSYSTEMDBCFGID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSystemDBCfgService", (SessionFactory)this.getSessionFactory());
            PSSystemDBCfg pSSystemDBCfg = (PSSystemDBCfg)iService.getDEModel().createEntity();
            pSSystemDBCfg.set("PSSYSTEMDBCFGID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSSystemDBCfg);
            } else {
                iService.get(pSSystemDBCfg);
            }
            this.onFillParentInfo_PSSystemDBCfg(pSSysDMItem, pSSystemDBCfg);
            return;
        }
        super.onFillParentInfo(pSSysDMItem, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillParentInfo_PSDE(PSSysDMItem pSSysDMItem, PSDataEntity pSDataEntity) throws Exception {
        pSSysDMItem.setPSDEId(pSDataEntity.getPSDataEntityId());
        pSSysDMItem.setPSDEName(pSDataEntity.getPSDataEntityName());
    }

    protected void onFillParentInfo_PSSysDMVer(PSSysDMItem pSSysDMItem, PSSysDMVer pSSysDMVer) throws Exception {
        pSSysDMItem.setPSSysDMVerId(pSSysDMVer.getPSSysDMVerId());
        pSSysDMItem.setPSSysDMVerName(pSSysDMVer.getPSSysDMVerName());
    }

    protected void onFillParentInfo_PSSystemDBCfg(PSSysDMItem pSSysDMItem, PSSystemDBCfg pSSystemDBCfg) throws Exception {
        pSSysDMItem.setPSSystemDBCfgId(pSSystemDBCfg.getPSSystemDBCfgId());
        pSSysDMItem.setPSSystemDBCfgName(pSSystemDBCfg.getPSSystemDBCfgName());
    }

    protected boolean onFillEntityKeyValue(PSSysDMItem pSSysDMItem, boolean bl) throws Exception {
        StringBuilderEx stringBuilderEx = new StringBuilderEx();
        Object object = pSSysDMItem.get("PSSYSTEMDBCFGID");
        if (object == null) {
            object = "__EMTPY__";
        }
        stringBuilderEx.append("%1$s", object);
        stringBuilderEx.append("||");
        Object object2 = pSSysDMItem.get("DBOBJTYPE");
        if (object2 == null) {
            object2 = "__EMTPY__";
        }
        stringBuilderEx.append("%1$s", object2);
        stringBuilderEx.append("||");
        Object object3 = pSSysDMItem.get("PSOBJID");
        if (object3 == null) {
            object3 = "__EMTPY__";
        }
        stringBuilderEx.append("%1$s", object3);
        stringBuilderEx.append("||");
        Object object4 = pSSysDMItem.get("PSSYSDMITEMNAME");
        if (object4 == null) {
            object4 = "__EMTPY__";
        }
        stringBuilderEx.append("%1$s", object4);
        String string = stringBuilderEx.toString();
        pSSysDMItem.set(this.getPSSysDMItemDEModel().getKeyDEField().getName(), KeyValueHelper.genUniqueId((String)string));
        return true;
    }

    protected void onFillEntityFullInfo(PSSysDMItem pSSysDMItem, boolean bl) throws Exception {
        if (bl) {
            // empty if block
        }
        super.onFillEntityFullInfo(pSSysDMItem, bl);
        this.onFillEntityFullInfo_PSDE(pSSysDMItem, bl);
        this.onFillEntityFullInfo_PSSysDMVer(pSSysDMItem, bl);
        this.onFillEntityFullInfo_PSSystemDBCfg(pSSysDMItem, bl);
    }

    protected void onFillEntityFullInfo_PSDE(PSSysDMItem pSSysDMItem, boolean bl) throws Exception {
        if (pSSysDMItem.isPSDEIdDirty()) {
            if (pSSysDMItem.getPSDEId() != null) {
                if (pSSysDMItem.getPSDEId() == null || pSSysDMItem.getPSDEName() == null) {
                    PSDataEntity pSDataEntity = pSSysDMItem.getPSDE();
                    pSSysDMItem.setPSDEName(pSDataEntity.getPSDataEntityName());
                }
            } else {
                pSSysDMItem.setPSDEName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_PSSysDMVer(PSSysDMItem pSSysDMItem, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSSystemDBCfg(PSSysDMItem pSSysDMItem, boolean bl) throws Exception {
        if (pSSysDMItem.isPSSystemDBCfgIdDirty()) {
            if (pSSysDMItem.getPSSystemDBCfgId() != null) {
                if (pSSysDMItem.getPSSystemDBCfgId() == null || pSSysDMItem.getPSSystemDBCfgName() == null) {
                    PSSystemDBCfg pSSystemDBCfg = pSSysDMItem.getPSSystemDBCfg();
                    pSSysDMItem.setPSSystemDBCfgName(pSSystemDBCfg.getPSSystemDBCfgName());
                }
            } else {
                pSSysDMItem.setPSSystemDBCfgName(null);
            }
        }
    }

    protected void onWriteBackParent(PSSysDMItem pSSysDMItem, boolean bl) throws Exception {
        super.onWriteBackParent(pSSysDMItem, bl);
    }

    public ArrayList<PSSysDMItem> selectByPSDE(PSDataEntityBase pSDataEntityBase) throws Exception {
        return this.selectByPSDE(pSDataEntityBase, "", -1);
    }

    public ArrayList<PSSysDMItem> selectByPSDE(PSDataEntityBase pSDataEntityBase, String string) throws Exception {
        return this.selectByPSDE(pSDataEntityBase, string, -1);
    }

    public ArrayList<PSSysDMItem> selectByPSDE(PSDataEntityBase pSDataEntityBase, String string, int n) throws Exception {
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

    public ArrayList<PSSysDMItem> selectByPSSysDMVer(PSSysDMVerBase pSSysDMVerBase) throws Exception {
        return this.selectByPSSysDMVer(pSSysDMVerBase, "", -1);
    }

    public ArrayList<PSSysDMItem> selectByPSSysDMVer(PSSysDMVerBase pSSysDMVerBase, String string) throws Exception {
        return this.selectByPSSysDMVer(pSSysDMVerBase, string, -1);
    }

    public ArrayList<PSSysDMItem> selectByPSSysDMVer(PSSysDMVerBase pSSysDMVerBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSSYSDMVERID", (Object)pSSysDMVerBase.getPSSysDMVerId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSSysDMVerCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSSysDMVerCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSSysDMItem> selectByPSSystemDBCfg(PSSystemDBCfgBase pSSystemDBCfgBase) throws Exception {
        return this.selectByPSSystemDBCfg(pSSystemDBCfgBase, "", -1);
    }

    public ArrayList<PSSysDMItem> selectByPSSystemDBCfg(PSSystemDBCfgBase pSSystemDBCfgBase, String string) throws Exception {
        return this.selectByPSSystemDBCfg(pSSystemDBCfgBase, string, -1);
    }

    public ArrayList<PSSysDMItem> selectByPSSystemDBCfg(PSSystemDBCfgBase pSSystemDBCfgBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSSYSTEMDBCFGID", (Object)pSSystemDBCfgBase.getPSSystemDBCfgId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSSystemDBCfgCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSSystemDBCfgCond(SelectCond selectCond) throws Exception {
    }

    public void testRemoveByPSDE(PSDataEntity pSDataEntity) throws Exception {
    }

    public void resetPSDE(PSDataEntity pSDataEntity) throws Exception {
        ArrayList<PSSysDMItem> arrayList = this.selectByPSDE(pSDataEntity);
        for (PSSysDMItem pSSysDMItem : arrayList) {
            PSSysDMItem pSSysDMItem2 = (PSSysDMItem)this.getDEModel().createEntity();
            pSSysDMItem2.setPSSysDMItemId(pSSysDMItem.getPSSysDMItemId());
            pSSysDMItem2.setPSDEId(null);
            this.update(pSSysDMItem2);
        }
    }

    public void removeByPSDE(PSDataEntity pSDataEntity) throws Exception {
        final PSDataEntity pSDataEntity2 = pSDataEntity;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysDMItemServiceBase.this.onBeforeRemoveByPSDE(pSDataEntity2);
                PSSysDMItemServiceBase.this.internalRemoveByPSDE(pSDataEntity2);
                PSSysDMItemServiceBase.this.onAfterRemoveByPSDE(pSDataEntity2);
            }
        });
    }

    protected void onBeforeRemoveByPSDE(PSDataEntity pSDataEntity) throws Exception {
    }

    protected void internalRemoveByPSDE(PSDataEntity pSDataEntity) throws Exception {
        ArrayList<PSSysDMItem> arrayList = this.selectByPSDE(pSDataEntity);
        this.onBeforeRemoveByPSDE(pSDataEntity, arrayList);
        for (PSSysDMItem pSSysDMItem : arrayList) {
            this.remove(pSSysDMItem);
        }
        this.onAfterRemoveByPSDE(pSDataEntity, arrayList);
    }

    protected void onAfterRemoveByPSDE(PSDataEntity pSDataEntity) throws Exception {
    }

    protected void onBeforeRemoveByPSDE(PSDataEntity pSDataEntity, ArrayList<PSSysDMItem> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDE(PSDataEntity pSDataEntity, ArrayList<PSSysDMItem> arrayList) throws Exception {
    }

    public void testRemoveByPSSysDMVer(PSSysDMVer pSSysDMVer) throws Exception {
        ArrayList<PSSysDMItem> arrayList = this.selectByPSSysDMVer(pSSysDMVer, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSDMVER");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSSysDMVer);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSDMITEM_PSSYSDMVER_PSSYSDMVERID", "", iDataEntityModel.getName(), "PSSYSDMITEM", iDataEntityModel.getDataInfo(pSSysDMVer), arrayList.get(0)));
        }
    }

    public void resetPSSysDMVer(PSSysDMVer pSSysDMVer) throws Exception {
        ArrayList<PSSysDMItem> arrayList = this.selectByPSSysDMVer(pSSysDMVer);
        for (PSSysDMItem pSSysDMItem : arrayList) {
            PSSysDMItem pSSysDMItem2 = (PSSysDMItem)this.getDEModel().createEntity();
            pSSysDMItem2.setPSSysDMItemId(pSSysDMItem.getPSSysDMItemId());
            pSSysDMItem2.setPSSysDMVerId(null);
            this.update(pSSysDMItem2);
        }
    }

    public void removeByPSSysDMVer(PSSysDMVer pSSysDMVer) throws Exception {
        final PSSysDMVer pSSysDMVer2 = pSSysDMVer;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysDMItemServiceBase.this.onBeforeRemoveByPSSysDMVer(pSSysDMVer2);
                PSSysDMItemServiceBase.this.internalRemoveByPSSysDMVer(pSSysDMVer2);
                PSSysDMItemServiceBase.this.onAfterRemoveByPSSysDMVer(pSSysDMVer2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysDMVer(PSSysDMVer pSSysDMVer) throws Exception {
    }

    protected void internalRemoveByPSSysDMVer(PSSysDMVer pSSysDMVer) throws Exception {
        ArrayList<PSSysDMItem> arrayList = this.selectByPSSysDMVer(pSSysDMVer);
        this.onBeforeRemoveByPSSysDMVer(pSSysDMVer, arrayList);
        for (PSSysDMItem pSSysDMItem : arrayList) {
            this.remove(pSSysDMItem);
        }
        this.onAfterRemoveByPSSysDMVer(pSSysDMVer, arrayList);
    }

    protected void onAfterRemoveByPSSysDMVer(PSSysDMVer pSSysDMVer) throws Exception {
    }

    protected void onBeforeRemoveByPSSysDMVer(PSSysDMVer pSSysDMVer, ArrayList<PSSysDMItem> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysDMVer(PSSysDMVer pSSysDMVer, ArrayList<PSSysDMItem> arrayList) throws Exception {
    }

    public void testRemoveByPSSystemDBCfg(PSSystemDBCfg pSSystemDBCfg) throws Exception {
    }

    public void resetPSSystemDBCfg(PSSystemDBCfg pSSystemDBCfg) throws Exception {
        ArrayList<PSSysDMItem> arrayList = this.selectByPSSystemDBCfg(pSSystemDBCfg);
        for (PSSysDMItem pSSysDMItem : arrayList) {
            PSSysDMItem pSSysDMItem2 = (PSSysDMItem)this.getDEModel().createEntity();
            pSSysDMItem2.setPSSysDMItemId(pSSysDMItem.getPSSysDMItemId());
            pSSysDMItem2.setPSSystemDBCfgId(null);
            this.update(pSSysDMItem2);
        }
    }

    public void removeByPSSystemDBCfg(PSSystemDBCfg pSSystemDBCfg) throws Exception {
        final PSSystemDBCfg pSSystemDBCfg2 = pSSystemDBCfg;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysDMItemServiceBase.this.onBeforeRemoveByPSSystemDBCfg(pSSystemDBCfg2);
                PSSysDMItemServiceBase.this.internalRemoveByPSSystemDBCfg(pSSystemDBCfg2);
                PSSysDMItemServiceBase.this.onAfterRemoveByPSSystemDBCfg(pSSystemDBCfg2);
            }
        });
    }

    protected void onBeforeRemoveByPSSystemDBCfg(PSSystemDBCfg pSSystemDBCfg) throws Exception {
    }

    protected void internalRemoveByPSSystemDBCfg(PSSystemDBCfg pSSystemDBCfg) throws Exception {
        ArrayList<PSSysDMItem> arrayList = this.selectByPSSystemDBCfg(pSSystemDBCfg);
        this.onBeforeRemoveByPSSystemDBCfg(pSSystemDBCfg, arrayList);
        for (PSSysDMItem pSSysDMItem : arrayList) {
            this.remove(pSSysDMItem);
        }
        this.onAfterRemoveByPSSystemDBCfg(pSSystemDBCfg, arrayList);
    }

    protected void onAfterRemoveByPSSystemDBCfg(PSSystemDBCfg pSSystemDBCfg) throws Exception {
    }

    protected void onBeforeRemoveByPSSystemDBCfg(PSSystemDBCfg pSSystemDBCfg, ArrayList<PSSysDMItem> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSystemDBCfg(PSSystemDBCfg pSSystemDBCfg, ArrayList<PSSysDMItem> arrayList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(PSSysDMItem pSSysDMItem) throws Exception {
        super.onBeforeRemove(pSSysDMItem);
    }

    protected void replaceParentInfo(PSSysDMItem pSSysDMItem, CloneSession cloneSession) throws Exception {
        IEntity iEntity;
        super.replaceParentInfo(pSSysDMItem, cloneSession);
        if (pSSysDMItem.getPSDEId() != null && (iEntity = cloneSession.getEntity("PSDATAENTITY", (Object)pSSysDMItem.getPSDEId())) != null) {
            this.onFillParentInfo_PSDE(pSSysDMItem, (PSDataEntity)iEntity);
        }
        if (pSSysDMItem.getPSSysDMVerId() != null && (iEntity = cloneSession.getEntity("PSSYSDMVER", (Object)pSSysDMItem.getPSSysDMVerId())) != null) {
            this.onFillParentInfo_PSSysDMVer(pSSysDMItem, (PSSysDMVer)iEntity);
        }
        if (pSSysDMItem.getPSSystemDBCfgId() != null && (iEntity = cloneSession.getEntity("PSSYSTEMDBCFG", (Object)pSSysDMItem.getPSSystemDBCfgId())) != null) {
            this.onFillParentInfo_PSSystemDBCfg(pSSysDMItem, (PSSystemDBCfg)iEntity);
        }
    }

    protected void onRemoveEntityUncopyValues(PSSysDMItem pSSysDMItem, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues(pSSysDMItem, bl);
    }

    protected void onCheckEntity(boolean bl, PSSysDMItem pSSysDMItem, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_CreateSql(bl, pSSysDMItem, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_CreateSql2(bl, pSSysDMItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_CreateSql3(bl, pSSysDMItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_CreateSql4(bl, pSSysDMItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_CreateSql5(bl, pSSysDMItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_CreateSql6(bl, pSSysDMItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_CreateSql7(bl, pSSysDMItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_DBObjType(bl, pSSysDMItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_DropSql(bl, pSSysDMItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Memo(bl, pSSysDMItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEId(bl, pSSysDMItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEName(bl, pSSysDMItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSObjId(bl, pSSysDMItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSObjName(bl, pSSysDMItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysDMItemId(bl, pSSysDMItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysDMItemName(bl, pSSysDMItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysDMVerId(bl, pSSysDMItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSystemDBCfgId(bl, pSSysDMItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSystemDBCfgName(bl, pSSysDMItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_SysDBVer(bl, pSSysDMItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_TestSql(bl, pSSysDMItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserFlag(bl, pSSysDMItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, pSSysDMItem, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_CreateSql(boolean bl, PSSysDMItem pSSysDMItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysDMItem.isCreateSqlDirty() : !pSSysDMItem.isCreateSqlDirty()) {
            return null;
        }
        String string = pSSysDMItem.getCreateSql();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_CreateSql_Default(pSSysDMItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CREATESQL");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_CreateSql2(boolean bl, PSSysDMItem pSSysDMItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysDMItem.isCreateSql2Dirty() : !pSSysDMItem.isCreateSql2Dirty()) {
            return null;
        }
        String string = pSSysDMItem.getCreateSql2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_CreateSql2_Default(pSSysDMItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CREATESQL2");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_CreateSql3(boolean bl, PSSysDMItem pSSysDMItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysDMItem.isCreateSql3Dirty() : !pSSysDMItem.isCreateSql3Dirty()) {
            return null;
        }
        String string = pSSysDMItem.getCreateSql3();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_CreateSql3_Default(pSSysDMItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CREATESQL3");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_CreateSql4(boolean bl, PSSysDMItem pSSysDMItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysDMItem.isCreateSql4Dirty() : !pSSysDMItem.isCreateSql4Dirty()) {
            return null;
        }
        String string = pSSysDMItem.getCreateSql4();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_CreateSql4_Default(pSSysDMItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CREATESQL4");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_CreateSql5(boolean bl, PSSysDMItem pSSysDMItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysDMItem.isCreateSql5Dirty() : !pSSysDMItem.isCreateSql5Dirty()) {
            return null;
        }
        String string = pSSysDMItem.getCreateSql5();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_CreateSql5_Default(pSSysDMItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CREATESQL5");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_CreateSql6(boolean bl, PSSysDMItem pSSysDMItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysDMItem.isCreateSql6Dirty() : !pSSysDMItem.isCreateSql6Dirty()) {
            return null;
        }
        String string = pSSysDMItem.getCreateSql6();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_CreateSql6_Default(pSSysDMItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CREATESQL6");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_CreateSql7(boolean bl, PSSysDMItem pSSysDMItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysDMItem.isCreateSql7Dirty() : !pSSysDMItem.isCreateSql7Dirty()) {
            return null;
        }
        String string = pSSysDMItem.getCreateSql7();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_CreateSql7_Default(pSSysDMItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CREATESQL7");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_DBObjType(boolean bl, PSSysDMItem pSSysDMItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysDMItem.isDBObjTypeDirty() && !bl2 : !pSSysDMItem.isDBObjTypeDirty()) {
            return null;
        }
        String string = pSSysDMItem.getDBObjType();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DBOBJTYPE");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_DBObjType_Default(pSSysDMItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DBOBJTYPE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_DropSql(boolean bl, PSSysDMItem pSSysDMItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysDMItem.isDropSqlDirty() : !pSSysDMItem.isDropSqlDirty()) {
            return null;
        }
        String string = pSSysDMItem.getDropSql();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_DropSql_Default(pSSysDMItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DROPSQL");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Memo(boolean bl, PSSysDMItem pSSysDMItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysDMItem.isMemoDirty() : !pSSysDMItem.isMemoDirty()) {
            return null;
        }
        String string = pSSysDMItem.getMemo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Memo_Default(pSSysDMItem, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDEId(boolean bl, PSSysDMItem pSSysDMItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysDMItem.isPSDEIdDirty() : !pSSysDMItem.isPSDEIdDirty()) {
            return null;
        }
        String string = pSSysDMItem.getPSDEId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEId_Default(pSSysDMItem, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDEName(boolean bl, PSSysDMItem pSSysDMItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysDMItem.isPSDENameDirty() : !pSSysDMItem.isPSDENameDirty()) {
            return null;
        }
        String string = pSSysDMItem.getPSDEName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEName_Default(pSSysDMItem, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSObjId(boolean bl, PSSysDMItem pSSysDMItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysDMItem.isPSObjIdDirty() && !bl2 : !pSSysDMItem.isPSObjIdDirty()) {
            return null;
        }
        String string = pSSysDMItem.getPSObjId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSOBJID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSObjId_Default(pSSysDMItem, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSObjName(boolean bl, PSSysDMItem pSSysDMItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysDMItem.isPSObjNameDirty() : !pSSysDMItem.isPSObjNameDirty()) {
            return null;
        }
        String string = pSSysDMItem.getPSObjName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSObjName_Default(pSSysDMItem, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSSysDMItemId(boolean bl, PSSysDMItem pSSysDMItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysDMItem.isPSSysDMItemIdDirty() && !bl2 : !pSSysDMItem.isPSSysDMItemIdDirty()) {
            return null;
        }
        String string = pSSysDMItem.getPSSysDMItemId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSDMITEMID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysDMItemId_Default(pSSysDMItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSDMITEMID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSysDMItemName(boolean bl, PSSysDMItem pSSysDMItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysDMItem.isPSSysDMItemNameDirty() && !bl2 : !pSSysDMItem.isPSSysDMItemNameDirty()) {
            return null;
        }
        String string = pSSysDMItem.getPSSysDMItemName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSDMITEMNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysDMItemName_Default(pSSysDMItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSDMITEMNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSysDMVerId(boolean bl, PSSysDMItem pSSysDMItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysDMItem.isPSSysDMVerIdDirty() : !pSSysDMItem.isPSSysDMVerIdDirty()) {
            return null;
        }
        String string = pSSysDMItem.getPSSysDMVerId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysDMVerId_Default(pSSysDMItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSDMVERID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSystemDBCfgId(boolean bl, PSSysDMItem pSSysDMItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysDMItem.isPSSystemDBCfgIdDirty() && !bl2 : !pSSysDMItem.isPSSystemDBCfgIdDirty()) {
            return null;
        }
        String string = pSSysDMItem.getPSSystemDBCfgId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSTEMDBCFGID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSystemDBCfgId_Default(pSSysDMItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSTEMDBCFGID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSystemDBCfgName(boolean bl, PSSysDMItem pSSysDMItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysDMItem.isPSSystemDBCfgNameDirty() && !bl2 : !pSSysDMItem.isPSSystemDBCfgNameDirty()) {
            return null;
        }
        String string = pSSysDMItem.getPSSystemDBCfgName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSTEMDBCFGNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSystemDBCfgName_Default(pSSysDMItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSTEMDBCFGNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_SysDBVer(boolean bl, PSSysDMItem pSSysDMItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysDMItem.isSysDBVerDirty() : !pSSysDMItem.isSysDBVerDirty()) {
            return null;
        }
        Integer n = pSSysDMItem.getSysDBVer();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_SysDBVer_Default(pSSysDMItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("SYSDBVER");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_TestSql(boolean bl, PSSysDMItem pSSysDMItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysDMItem.isTestSqlDirty() : !pSSysDMItem.isTestSqlDirty()) {
            return null;
        }
        String string = pSSysDMItem.getTestSql();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_TestSql_Default(pSSysDMItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("TESTSQL");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_UserFlag(boolean bl, PSSysDMItem pSSysDMItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysDMItem.isUserFlagDirty() && !bl2 : !pSSysDMItem.isUserFlagDirty()) {
            return null;
        }
        Integer n = pSSysDMItem.getUserFlag();
        if (bl) {
            if (bl2 && n == null) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("USERFLAG");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string = null;
            string = this.onTestValueRule_UserFlag_Default(pSSysDMItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("USERFLAG");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected void onSyncEntity(PSSysDMItem pSSysDMItem, boolean bl) throws Exception {
        super.onSyncEntity(pSSysDMItem, bl);
    }

    protected void onSyncIndexEntities(PSSysDMItem pSSysDMItem, boolean bl) throws Exception {
        super.onSyncIndexEntities(pSSysDMItem, bl);
    }

    public Object getDataContextValue(PSSysDMItem pSSysDMItem, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null) {
            // empty if block
        }
        if ((object = super.getDataContextValue(pSSysDMItem, string, iDataContextParam)) != null) {
            return object;
        }
        PSDataEntity pSDataEntity = pSSysDMItem.getPSDE();
        if (pSDataEntity != null && pSDataEntity.contains(string)) {
            return pSDataEntity.get(string);
        }
        PSSystemDBCfg pSSystemDBCfg = pSSysDMItem.getPSSystemDBCfg();
        if (pSSystemDBCfg != null && pSSystemDBCfg.contains(string)) {
            return pSSystemDBCfg.get(string);
        }
        return null;
    }

    protected void onExportMajorModel(PSSysDMItem pSSysDMItem, ArrayList<JSONObject> arrayList, int n) throws Exception {
        super.onExportMajorModel(pSSysDMItem, arrayList, n);
    }

    protected String onTestValueRule(String string, String string2, IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        if (StringHelper.compare((String)string, (String)"CREATEDATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateDate_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATEMAN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateMan_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATESQL", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateSql_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATESQL2", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateSql2_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATESQL3", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateSql3_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATESQL4", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateSql4_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATESQL5", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateSql5_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATESQL6", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateSql6_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATESQL7", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateSql7_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DBOBJTYPE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DBObjType_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DROPSQL", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DropSql_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MEMO", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Memo_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSOBJID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSObjId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSOBJNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSObjName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSDMITEMID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysDMItemId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSDMITEMNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysDMItemName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSDMVERID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysDMVerId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSDMVERNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysDMVerName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSTEMDBCFGID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSystemDBCfgId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSTEMDBCFGNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSystemDBCfgName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"SYSDBVER", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_SysDBVer_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"TESTSQL", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_TestSql_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UPDATEDATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UpdateDate_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UPDATEMAN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UpdateMan_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"USERFLAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UserFlag_Default(iEntity, bl, bl2);
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

    protected String onTestValueRule_CreateSql_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("CREATESQL", iEntity, bl2, null, false, 0x100000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_CreateSql2_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("CREATESQL2", iEntity, bl2, null, false, 2000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[2000]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[2000]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_CreateSql3_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("CREATESQL3", iEntity, bl2, null, false, 2000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[2000]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[2000]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_CreateSql4_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("CREATESQL4", iEntity, bl2, null, false, 4000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[4000]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[4000]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_CreateSql5_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("CREATESQL5", iEntity, bl2, null, false, 2000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[2000]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[2000]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_CreateSql6_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("CREATESQL6", iEntity, bl2, null, false, 2000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[2000]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[2000]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_CreateSql7_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("CREATESQL7", iEntity, bl2, null, false, 2000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[2000]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[2000]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_DBObjType_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("DBOBJTYPE", iEntity, bl2, null, false, 30, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_DropSql_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("DROPSQL", iEntity, bl2, null, false, 1000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1000]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1000]";
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

    protected String onTestValueRule_PSSysDMItemId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSDMITEMID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysDMItemName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSDMITEMNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysDMVerId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSDMVERID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysDMVerName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSDMVERNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSystemDBCfgId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSTEMDBCFGID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSystemDBCfgName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSTEMDBCFGNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_SysDBVer_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_TestSql_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("TESTSQL", iEntity, bl2, null, false, 1000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1000]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1000]";
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

    protected String onTestValueRule_UserFlag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected boolean onMergeChild(String string, String string2, PSSysDMItem pSSysDMItem) throws Exception {
        boolean bl = false;
        if (super.onMergeChild(string, string2, pSSysDMItem)) {
            bl = true;
        }
        return bl;
    }

    protected void onUpdateParent(PSSysDMItem pSSysDMItem) throws Exception {
        super.onUpdateParent(pSSysDMItem);
    }

    @Override
    protected void exportCurXmlModel(PSSysDMItem pSSysDMItem, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSSYSDMITEM");
        if (!bl) {
            pSSysDMItem.setPSSysDMVerId(null);
            pSSysDMItem.setPSSysDMVerName(null);
            pSSysDMItem.setSysDBVer(null);
            super.exportCurXmlModel(pSSysDMItem, xmlNode, bl);
        }
    }

    @Override
    protected String getEntityFolderKeyValue(PSSysDMItem pSSysDMItem, PSSystem pSSystem) throws Exception {
        PSSysDMItem pSSysDMItem2 = new PSSysDMItem();
        pSSysDMItem2.setPSSystemDBCfgId(pSSysDMItem.getPSSystemDBCfgId());
        pSSysDMItem2.setDBObjType(pSSysDMItem.getDBObjType());
        pSSysDMItem2.setPSObjId(pSSysDMItem.getPSObjId());
        pSSysDMItem2.setPSSysDMItemName(pSSysDMItem.getPSSysDMItemName());
        if (this.selectOne(pSSysDMItem2, true)) {
            return pSSysDMItem2.getPSSysDMItemId();
        }
        return super.getEntityFolderKeyValue(pSSysDMItem, pSSystem);
    }

    @Override
    public ObjectNode fillModelV2(ObjectNode objectNode, PSSysDMItem pSSysDMItem, String string) throws Exception {
        objectNode = super.fillModelV2(objectNode, pSSysDMItem, string);
        return objectNode;
    }

    @Override
    public String getModelV2ResScope(IEntity iEntity) throws Exception {
        String string = null;
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSDEID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return StringHelper.format((String)"PSDATAENTITY#%1$s", (Object)string);
        }
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSSYSTEMDBCFGID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return StringHelper.format((String)"PSSYSTEMDBCFG#%1$s", (Object)string);
        }
        return super.getModelV2ResScope(iEntity);
    }

    @Override
    public String getModelV2ResScopeDER(IEntity iEntity) throws Exception {
        String string = null;
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSDEID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return "DER1N_PSSYSDMITEM_PSDATAENTITY_PSDEID";
        }
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSSYSTEMDBCFGID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return "DER1N_PSSYSDMITEM_PSSYSTEMDBCFG_PSSYSTEMDBCFGID";
        }
        return super.getModelV2ResScopeDER(iEntity);
    }

    @Override
    public String getModelV2ResScopeText(IEntity iEntity) throws Exception {
        String string = null;
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSDEID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return DataObject.getStringValue((IDataObject)iEntity, (String)"PSDENAME", null);
        }
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSSYSTEMDBCFGID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return DataObject.getStringValue((IDataObject)iEntity, (String)"PSSYSTEMDBCFGNAME", null);
        }
        return super.getModelV2ResScopeText(iEntity);
    }

    @Override
    public boolean setModelV2ResScope(IEntity iEntity, String string, String string2) throws Exception {
        if (StringHelper.compare((String)string, (String)"PSDATAENTITY", (boolean)true) == 0) {
            iEntity.set("PSDEID", (Object)string2);
            return true;
        }
        if (StringHelper.compare((String)string, (String)"PSSYSTEMDBCFG", (boolean)true) == 0) {
            iEntity.set("PSSYSTEMDBCFGID", (Object)string2);
            return true;
        }
        return super.setModelV2ResScope(iEntity, string, string2);
    }

    @Override
    public String[] getModelV2ResScopeFields() throws Exception {
        return new String[]{"PSDEID", "PSSYSTEMDBCFGID"};
    }

    @Override
    public String getModelV2Tag(PSSysDMItem pSSysDMItem) {
        if (!StringHelper.isNullOrEmpty((String)pSSysDMItem.getPSSysDMItemName())) {
            return pSSysDMItem.getPSSysDMItemName();
        }
        return super.getModelV2Tag(pSSysDMItem);
    }

    @Override
    public boolean setModelV2Tag(PSSysDMItem pSSysDMItem, String string) {
        pSSysDMItem.setPSSysDMItemName(string);
        return true;
    }

    @Override
    public Map<String, String> getListDRDataFolderFields(Map<String, String> map, PSMOSFile pSMOSFile, IPSMOSFileFilter iPSMOSFileFilter) throws Exception {
        if (map == null) {
            map = new HashMap<String, String>();
        }
        map.put("PSSYSDMITEMNAME", "");
        map.put("PSDEID", "");
        map.put("PSSYSTEMDBCFGID", "");
        return super.getListDRDataFolderFields(map, pSMOSFile, iPSMOSFileFilter);
    }

    @Override
    public boolean getModelV2Entity(PSSysDMItem pSSysDMItem, String string) throws Exception {
        SimpleEntity simpleEntity = new SimpleEntity();
        pSSysDMItem.copyTo((IDataObject)simpleEntity, false);
        simpleEntity.copyTo((IDataObject)pSSysDMItem, true);
        pSSysDMItem.set("PSSYSDMITEMNAME", string);
        if (this.select(pSSysDMItem, true)) {
            return true;
        }
        simpleEntity.copyTo((IDataObject)pSSysDMItem, true);
        return super.getModelV2Entity(pSSysDMItem, string);
    }

    @Override
    protected boolean testCompileCurModelV2(PSSysDMItem pSSysDMItem, ObjectNode objectNode, String string, String string2, int n) throws Exception {
        if (n == 1) {
            return true;
        }
        return super.testCompileCurModelV2(pSSysDMItem, objectNode, string, string2, n);
    }
}

