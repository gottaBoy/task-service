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

import java.util.ArrayList;
import javax.annotation.PostConstruct;
import net.ibizsys.paas.core.IDEDataSetFetchContext;
import net.ibizsys.paas.dao.DAOGlobal;
import net.ibizsys.paas.dao.IDAO;
import net.ibizsys.paas.db.DBFetchResult;
import net.ibizsys.paas.db.ISelectCond;
import net.ibizsys.paas.db.SelectCond;
import net.ibizsys.paas.demodel.DEModelGlobal;
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
import net.ibizsys.paas.util.KeyValueHelper;
import net.ibizsys.paas.util.StringBuilderEx;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.xml.XmlNode;
import net.ibizsys.pscore.srv.PSCoreSysServiceBase;
import net.ibizsys.pscore.srv.core.IPSDataEntityModel;
import net.ibizsys.pscore.srv.dedesign.entity.PSDataEntity;
import net.ibizsys.pscore.srv.dedesign.entity.PSDataEntityBase;
import net.ibizsys.pscore.srv.sysdesign.dao.PSSysDMVerItemDAO;
import net.ibizsys.pscore.srv.sysdesign.demodel.PSSysDMVerItemDEModel;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysDMItem;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysDMItemBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysDMVer;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysDMVerBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysDMVerItem;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSystem;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSystemDBCfg;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSystemDBCfgBase;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSSysDMVerItemServiceBase
extends PSCoreSysServiceBase<PSSysDMVerItem> {
    private static final Log log = LogFactory.getLog(PSSysDMVerItemServiceBase.class);
    public static final String DATASET_DEFAULT = "DEFAULT";
    private PSSysDMVerItemDEModel pSSysDMVerItemDEModel;
    private PSSysDMVerItemDAO pSSysDMVerItemDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.sysdesign.service.PSSysDMVerItemService";
    }

    public PSSysDMVerItemDEModel getPSSysDMVerItemDEModel() {
        if (this.pSSysDMVerItemDEModel == null) {
            try {
                this.pSSysDMVerItemDEModel = (PSSysDMVerItemDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.sysdesign.demodel.PSSysDMVerItemDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSSysDMVerItemDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSSysDMVerItemDEModel();
    }

    public PSSysDMVerItemDAO getPSSysDMVerItemDAO() {
        if (this.pSSysDMVerItemDAO == null) {
            try {
                this.pSSysDMVerItemDAO = (PSSysDMVerItemDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.sysdesign.dao.PSSysDMVerItemDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSSysDMVerItemDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSSysDMVerItemDAO();
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

    protected void onFillParentInfo(PSSysDMVerItem pSSysDMVerItem, String string, String string2, String string3) throws Exception {
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSDMVERITEM_PSDATAENTITY_PSDEID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDataEntityService", (SessionFactory)this.getSessionFactory());
            PSDataEntity pSDataEntity = (PSDataEntity)iService.getDEModel().createEntity();
            pSDataEntity.set("PSDATAENTITYID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDataEntity);
            } else {
                iService.get((IEntity)pSDataEntity);
            }
            this.onFillParentInfo_PSDE(pSSysDMVerItem, pSDataEntity);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSDMVERITEM_PSSYSDMITEM_PSSYSDMITEMID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysDMItemService", (SessionFactory)this.getSessionFactory());
            PSSysDMItem pSSysDMItem = (PSSysDMItem)iService.getDEModel().createEntity();
            pSSysDMItem.set("PSSYSDMITEMID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSSysDMItem);
            } else {
                iService.get((IEntity)pSSysDMItem);
            }
            this.onFillParentInfo_PSSysDMItem(pSSysDMVerItem, pSSysDMItem);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSDMVERITEM_PSSYSDMVER_PSSYSDMVERID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysDMVerService", (SessionFactory)this.getSessionFactory());
            PSSysDMVer pSSysDMVer = (PSSysDMVer)iService.getDEModel().createEntity();
            pSSysDMVer.set("PSSYSDMVERID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSSysDMVer);
            } else {
                iService.get((IEntity)pSSysDMVer);
            }
            this.onFillParentInfo_PSSysDMVer(pSSysDMVerItem, pSSysDMVer);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSDMVERITEM_PSSYSTEMDBCFG_PSSYSTEMDBCFGID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSystemDBCfgService", (SessionFactory)this.getSessionFactory());
            PSSystemDBCfg pSSystemDBCfg = (PSSystemDBCfg)iService.getDEModel().createEntity();
            pSSystemDBCfg.set("PSSYSTEMDBCFGID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSSystemDBCfg);
            } else {
                iService.get((IEntity)pSSystemDBCfg);
            }
            this.onFillParentInfo_PSSystemDBCfg(pSSysDMVerItem, pSSystemDBCfg);
            return;
        }
        super.onFillParentInfo((IEntity)pSSysDMVerItem, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillParentInfo_PSDE(PSSysDMVerItem pSSysDMVerItem, PSDataEntity pSDataEntity) throws Exception {
        pSSysDMVerItem.setPSDEId(pSDataEntity.getPSDataEntityId());
        pSSysDMVerItem.setPSDEName(pSDataEntity.getPSDataEntityName());
    }

    protected void onFillParentInfo_PSSysDMItem(PSSysDMVerItem pSSysDMVerItem, PSSysDMItem pSSysDMItem) throws Exception {
        pSSysDMVerItem.setPSSysDMItemId(pSSysDMItem.getPSSysDMItemId());
        pSSysDMVerItem.setPSSysDMItemName(pSSysDMItem.getPSSysDMItemName());
    }

    protected void onFillParentInfo_PSSysDMVer(PSSysDMVerItem pSSysDMVerItem, PSSysDMVer pSSysDMVer) throws Exception {
        pSSysDMVerItem.setPSSysDMVerId(pSSysDMVer.getPSSysDMVerId());
        pSSysDMVerItem.setPSSysDMVerName(pSSysDMVer.getPSSysDMVerName());
    }

    protected void onFillParentInfo_PSSystemDBCfg(PSSysDMVerItem pSSysDMVerItem, PSSystemDBCfg pSSystemDBCfg) throws Exception {
        pSSysDMVerItem.setPSSystemDBCfgId(pSSystemDBCfg.getPSSystemDBCfgId());
        pSSysDMVerItem.setPSSystemDBCfgName(pSSystemDBCfg.getPSSystemDBCfgName());
    }

    protected boolean onFillEntityKeyValue(PSSysDMVerItem pSSysDMVerItem, boolean bl) throws Exception {
        StringBuilderEx stringBuilderEx = new StringBuilderEx();
        Object object = pSSysDMVerItem.get("PSSYSDMVERID");
        if (object == null) {
            object = "__EMTPY__";
        }
        stringBuilderEx.append("%1$s", object);
        stringBuilderEx.append("||");
        Object object2 = pSSysDMVerItem.get("PSSYSDMITEMID");
        if (object2 == null) {
            object2 = "__EMTPY__";
        }
        stringBuilderEx.append("%1$s", object2);
        String string = stringBuilderEx.toString();
        pSSysDMVerItem.set(this.getPSSysDMVerItemDEModel().getKeyDEField().getName(), KeyValueHelper.genUniqueId((String)string));
        return true;
    }

    protected void onFillEntityFullInfo(PSSysDMVerItem pSSysDMVerItem, boolean bl) throws Exception {
        if (bl) {
            // empty if block
        }
        super.onFillEntityFullInfo((IEntity)pSSysDMVerItem, bl);
        this.onFillEntityFullInfo_PSDE(pSSysDMVerItem, bl);
        this.onFillEntityFullInfo_PSSysDMItem(pSSysDMVerItem, bl);
        this.onFillEntityFullInfo_PSSysDMVer(pSSysDMVerItem, bl);
        this.onFillEntityFullInfo_PSSystemDBCfg(pSSysDMVerItem, bl);
    }

    protected void onFillEntityFullInfo_PSDE(PSSysDMVerItem pSSysDMVerItem, boolean bl) throws Exception {
        if (pSSysDMVerItem.isPSDEIdDirty()) {
            if (pSSysDMVerItem.getPSDEId() != null) {
                if (pSSysDMVerItem.getPSDEId() == null || pSSysDMVerItem.getPSDEName() == null) {
                    PSDataEntity pSDataEntity = pSSysDMVerItem.getPSDE();
                    pSSysDMVerItem.setPSDEName(pSDataEntity.getPSDataEntityName());
                }
            } else {
                pSSysDMVerItem.setPSDEName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_PSSysDMItem(PSSysDMVerItem pSSysDMVerItem, boolean bl) throws Exception {
        if (pSSysDMVerItem.isPSSysDMItemIdDirty()) {
            if (pSSysDMVerItem.getPSSysDMItemId() != null) {
                if (pSSysDMVerItem.getPSSysDMItemId() == null || pSSysDMVerItem.getPSSysDMItemName() == null) {
                    PSSysDMItem pSSysDMItem = pSSysDMVerItem.getPSSysDMItem();
                    pSSysDMVerItem.setPSSysDMItemName(pSSysDMItem.getPSSysDMItemName());
                }
            } else {
                pSSysDMVerItem.setPSSysDMItemName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_PSSysDMVer(PSSysDMVerItem pSSysDMVerItem, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSSystemDBCfg(PSSysDMVerItem pSSysDMVerItem, boolean bl) throws Exception {
        if (pSSysDMVerItem.isPSSystemDBCfgIdDirty()) {
            if (pSSysDMVerItem.getPSSystemDBCfgId() != null) {
                if (pSSysDMVerItem.getPSSystemDBCfgId() == null || pSSysDMVerItem.getPSSystemDBCfgName() == null) {
                    PSSystemDBCfg pSSystemDBCfg = pSSysDMVerItem.getPSSystemDBCfg();
                    pSSysDMVerItem.setPSSystemDBCfgName(pSSystemDBCfg.getPSSystemDBCfgName());
                }
            } else {
                pSSysDMVerItem.setPSSystemDBCfgName(null);
            }
        }
    }

    protected void onWriteBackParent(PSSysDMVerItem pSSysDMVerItem, boolean bl) throws Exception {
        super.onWriteBackParent((IEntity)pSSysDMVerItem, bl);
    }

    public ArrayList<PSSysDMVerItem> selectByPSDE(PSDataEntityBase pSDataEntityBase) throws Exception {
        return this.selectByPSDE(pSDataEntityBase, "", -1);
    }

    public ArrayList<PSSysDMVerItem> selectByPSDE(PSDataEntityBase pSDataEntityBase, String string) throws Exception {
        return this.selectByPSDE(pSDataEntityBase, string, -1);
    }

    public ArrayList<PSSysDMVerItem> selectByPSDE(PSDataEntityBase pSDataEntityBase, String string, int n) throws Exception {
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

    public ArrayList<PSSysDMVerItem> selectByPSSysDMItem(PSSysDMItemBase pSSysDMItemBase) throws Exception {
        return this.selectByPSSysDMItem(pSSysDMItemBase, "", -1);
    }

    public ArrayList<PSSysDMVerItem> selectByPSSysDMItem(PSSysDMItemBase pSSysDMItemBase, String string) throws Exception {
        return this.selectByPSSysDMItem(pSSysDMItemBase, string, -1);
    }

    public ArrayList<PSSysDMVerItem> selectByPSSysDMItem(PSSysDMItemBase pSSysDMItemBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSSYSDMITEMID", (Object)pSSysDMItemBase.getPSSysDMItemId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSSysDMItemCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSSysDMItemCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSSysDMVerItem> selectByPSSysDMVer(PSSysDMVerBase pSSysDMVerBase) throws Exception {
        return this.selectByPSSysDMVer(pSSysDMVerBase, "", -1);
    }

    public ArrayList<PSSysDMVerItem> selectByPSSysDMVer(PSSysDMVerBase pSSysDMVerBase, String string) throws Exception {
        return this.selectByPSSysDMVer(pSSysDMVerBase, string, -1);
    }

    public ArrayList<PSSysDMVerItem> selectByPSSysDMVer(PSSysDMVerBase pSSysDMVerBase, String string, int n) throws Exception {
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

    public ArrayList<PSSysDMVerItem> selectByPSSystemDBCfg(PSSystemDBCfgBase pSSystemDBCfgBase) throws Exception {
        return this.selectByPSSystemDBCfg(pSSystemDBCfgBase, "", -1);
    }

    public ArrayList<PSSysDMVerItem> selectByPSSystemDBCfg(PSSystemDBCfgBase pSSystemDBCfgBase, String string) throws Exception {
        return this.selectByPSSystemDBCfg(pSSystemDBCfgBase, string, -1);
    }

    public ArrayList<PSSysDMVerItem> selectByPSSystemDBCfg(PSSystemDBCfgBase pSSystemDBCfgBase, String string, int n) throws Exception {
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
        ArrayList<PSSysDMVerItem> arrayList = this.selectByPSDE(pSDataEntity);
        for (PSSysDMVerItem pSSysDMVerItem : arrayList) {
            PSSysDMVerItem pSSysDMVerItem2 = (PSSysDMVerItem)this.getDEModel().createEntity();
            pSSysDMVerItem2.setPSSysDMVerItemId(pSSysDMVerItem.getPSSysDMVerItemId());
            pSSysDMVerItem2.setPSDEId(null);
            this.update(pSSysDMVerItem2);
        }
    }

    public void removeByPSDE(PSDataEntity pSDataEntity) throws Exception {
        final PSDataEntity pSDataEntity2 = pSDataEntity;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysDMVerItemServiceBase.this.onBeforeRemoveByPSDE(pSDataEntity2);
                PSSysDMVerItemServiceBase.this.internalRemoveByPSDE(pSDataEntity2);
                PSSysDMVerItemServiceBase.this.onAfterRemoveByPSDE(pSDataEntity2);
            }
        });
    }

    protected void onBeforeRemoveByPSDE(PSDataEntity pSDataEntity) throws Exception {
    }

    protected void internalRemoveByPSDE(PSDataEntity pSDataEntity) throws Exception {
        ArrayList<PSSysDMVerItem> arrayList = this.selectByPSDE(pSDataEntity);
        this.onBeforeRemoveByPSDE(pSDataEntity, arrayList);
        for (PSSysDMVerItem pSSysDMVerItem : arrayList) {
            this.remove((IEntity)pSSysDMVerItem);
        }
        this.onAfterRemoveByPSDE(pSDataEntity, arrayList);
    }

    protected void onAfterRemoveByPSDE(PSDataEntity pSDataEntity) throws Exception {
    }

    protected void onBeforeRemoveByPSDE(PSDataEntity pSDataEntity, ArrayList<PSSysDMVerItem> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDE(PSDataEntity pSDataEntity, ArrayList<PSSysDMVerItem> arrayList) throws Exception {
    }

    public void testRemoveByPSSysDMItem(PSSysDMItem pSSysDMItem) throws Exception {
    }

    public void resetPSSysDMItem(PSSysDMItem pSSysDMItem) throws Exception {
        ArrayList<PSSysDMVerItem> arrayList = this.selectByPSSysDMItem(pSSysDMItem);
        for (PSSysDMVerItem pSSysDMVerItem : arrayList) {
            PSSysDMVerItem pSSysDMVerItem2 = (PSSysDMVerItem)this.getDEModel().createEntity();
            pSSysDMVerItem2.setPSSysDMVerItemId(pSSysDMVerItem.getPSSysDMVerItemId());
            pSSysDMVerItem2.setPSSysDMItemId(null);
            this.update(pSSysDMVerItem2);
        }
    }

    public void removeByPSSysDMItem(PSSysDMItem pSSysDMItem) throws Exception {
        final PSSysDMItem pSSysDMItem2 = pSSysDMItem;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysDMVerItemServiceBase.this.onBeforeRemoveByPSSysDMItem(pSSysDMItem2);
                PSSysDMVerItemServiceBase.this.internalRemoveByPSSysDMItem(pSSysDMItem2);
                PSSysDMVerItemServiceBase.this.onAfterRemoveByPSSysDMItem(pSSysDMItem2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysDMItem(PSSysDMItem pSSysDMItem) throws Exception {
    }

    protected void internalRemoveByPSSysDMItem(PSSysDMItem pSSysDMItem) throws Exception {
        ArrayList<PSSysDMVerItem> arrayList = this.selectByPSSysDMItem(pSSysDMItem);
        this.onBeforeRemoveByPSSysDMItem(pSSysDMItem, arrayList);
        for (PSSysDMVerItem pSSysDMVerItem : arrayList) {
            this.remove((IEntity)pSSysDMVerItem);
        }
        this.onAfterRemoveByPSSysDMItem(pSSysDMItem, arrayList);
    }

    protected void onAfterRemoveByPSSysDMItem(PSSysDMItem pSSysDMItem) throws Exception {
    }

    protected void onBeforeRemoveByPSSysDMItem(PSSysDMItem pSSysDMItem, ArrayList<PSSysDMVerItem> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysDMItem(PSSysDMItem pSSysDMItem, ArrayList<PSSysDMVerItem> arrayList) throws Exception {
    }

    public void testRemoveByPSSysDMVer(PSSysDMVer pSSysDMVer) throws Exception {
    }

    public void resetPSSysDMVer(PSSysDMVer pSSysDMVer) throws Exception {
        ArrayList<PSSysDMVerItem> arrayList = this.selectByPSSysDMVer(pSSysDMVer);
        for (PSSysDMVerItem pSSysDMVerItem : arrayList) {
            PSSysDMVerItem pSSysDMVerItem2 = (PSSysDMVerItem)this.getDEModel().createEntity();
            pSSysDMVerItem2.setPSSysDMVerItemId(pSSysDMVerItem.getPSSysDMVerItemId());
            pSSysDMVerItem2.setPSSysDMVerId(null);
            this.update(pSSysDMVerItem2);
        }
    }

    public void removeByPSSysDMVer(PSSysDMVer pSSysDMVer) throws Exception {
        final PSSysDMVer pSSysDMVer2 = pSSysDMVer;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysDMVerItemServiceBase.this.onBeforeRemoveByPSSysDMVer(pSSysDMVer2);
                PSSysDMVerItemServiceBase.this.internalRemoveByPSSysDMVer(pSSysDMVer2);
                PSSysDMVerItemServiceBase.this.onAfterRemoveByPSSysDMVer(pSSysDMVer2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysDMVer(PSSysDMVer pSSysDMVer) throws Exception {
    }

    protected void internalRemoveByPSSysDMVer(PSSysDMVer pSSysDMVer) throws Exception {
        ArrayList<PSSysDMVerItem> arrayList = this.selectByPSSysDMVer(pSSysDMVer);
        this.onBeforeRemoveByPSSysDMVer(pSSysDMVer, arrayList);
        for (PSSysDMVerItem pSSysDMVerItem : arrayList) {
            this.remove((IEntity)pSSysDMVerItem);
        }
        this.onAfterRemoveByPSSysDMVer(pSSysDMVer, arrayList);
    }

    protected void onAfterRemoveByPSSysDMVer(PSSysDMVer pSSysDMVer) throws Exception {
    }

    protected void onBeforeRemoveByPSSysDMVer(PSSysDMVer pSSysDMVer, ArrayList<PSSysDMVerItem> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysDMVer(PSSysDMVer pSSysDMVer, ArrayList<PSSysDMVerItem> arrayList) throws Exception {
    }

    public void testRemoveByPSSystemDBCfg(PSSystemDBCfg pSSystemDBCfg) throws Exception {
    }

    public void resetPSSystemDBCfg(PSSystemDBCfg pSSystemDBCfg) throws Exception {
        ArrayList<PSSysDMVerItem> arrayList = this.selectByPSSystemDBCfg(pSSystemDBCfg);
        for (PSSysDMVerItem pSSysDMVerItem : arrayList) {
            PSSysDMVerItem pSSysDMVerItem2 = (PSSysDMVerItem)this.getDEModel().createEntity();
            pSSysDMVerItem2.setPSSysDMVerItemId(pSSysDMVerItem.getPSSysDMVerItemId());
            pSSysDMVerItem2.setPSSystemDBCfgId(null);
            this.update(pSSysDMVerItem2);
        }
    }

    public void removeByPSSystemDBCfg(PSSystemDBCfg pSSystemDBCfg) throws Exception {
        final PSSystemDBCfg pSSystemDBCfg2 = pSSystemDBCfg;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysDMVerItemServiceBase.this.onBeforeRemoveByPSSystemDBCfg(pSSystemDBCfg2);
                PSSysDMVerItemServiceBase.this.internalRemoveByPSSystemDBCfg(pSSystemDBCfg2);
                PSSysDMVerItemServiceBase.this.onAfterRemoveByPSSystemDBCfg(pSSystemDBCfg2);
            }
        });
    }

    protected void onBeforeRemoveByPSSystemDBCfg(PSSystemDBCfg pSSystemDBCfg) throws Exception {
    }

    protected void internalRemoveByPSSystemDBCfg(PSSystemDBCfg pSSystemDBCfg) throws Exception {
        ArrayList<PSSysDMVerItem> arrayList = this.selectByPSSystemDBCfg(pSSystemDBCfg);
        this.onBeforeRemoveByPSSystemDBCfg(pSSystemDBCfg, arrayList);
        for (PSSysDMVerItem pSSysDMVerItem : arrayList) {
            this.remove((IEntity)pSSysDMVerItem);
        }
        this.onAfterRemoveByPSSystemDBCfg(pSSystemDBCfg, arrayList);
    }

    protected void onAfterRemoveByPSSystemDBCfg(PSSystemDBCfg pSSystemDBCfg) throws Exception {
    }

    protected void onBeforeRemoveByPSSystemDBCfg(PSSystemDBCfg pSSystemDBCfg, ArrayList<PSSysDMVerItem> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSystemDBCfg(PSSystemDBCfg pSSystemDBCfg, ArrayList<PSSysDMVerItem> arrayList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(PSSysDMVerItem pSSysDMVerItem) throws Exception {
        super.onBeforeRemove(pSSysDMVerItem);
    }

    protected void replaceParentInfo(PSSysDMVerItem pSSysDMVerItem, CloneSession cloneSession) throws Exception {
        IEntity iEntity;
        super.replaceParentInfo((IEntity)pSSysDMVerItem, cloneSession);
        if (pSSysDMVerItem.getPSDEId() != null && (iEntity = cloneSession.getEntity("PSDATAENTITY", (Object)pSSysDMVerItem.getPSDEId())) != null) {
            this.onFillParentInfo_PSDE(pSSysDMVerItem, (PSDataEntity)iEntity);
        }
        if (pSSysDMVerItem.getPSSysDMItemId() != null && (iEntity = cloneSession.getEntity("PSSYSDMITEM", (Object)pSSysDMVerItem.getPSSysDMItemId())) != null) {
            this.onFillParentInfo_PSSysDMItem(pSSysDMVerItem, (PSSysDMItem)iEntity);
        }
        if (pSSysDMVerItem.getPSSysDMVerId() != null && (iEntity = cloneSession.getEntity("PSSYSDMVER", (Object)pSSysDMVerItem.getPSSysDMVerId())) != null) {
            this.onFillParentInfo_PSSysDMVer(pSSysDMVerItem, (PSSysDMVer)iEntity);
        }
        if (pSSysDMVerItem.getPSSystemDBCfgId() != null && (iEntity = cloneSession.getEntity("PSSYSTEMDBCFG", (Object)pSSysDMVerItem.getPSSystemDBCfgId())) != null) {
            this.onFillParentInfo_PSSystemDBCfg(pSSysDMVerItem, (PSSystemDBCfg)iEntity);
        }
    }

    protected void onRemoveEntityUncopyValues(PSSysDMVerItem pSSysDMVerItem, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues((IEntity)pSSysDMVerItem, bl);
    }

    protected void onCheckEntity(boolean bl, PSSysDMVerItem pSSysDMVerItem, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_CreateSql(bl, pSSysDMVerItem, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_CreateSql2(bl, pSSysDMVerItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_CreateSql3(bl, pSSysDMVerItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_CreateSql4(bl, pSSysDMVerItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_CreateSql5(bl, pSSysDMVerItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_CreateSql6(bl, pSSysDMVerItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_CreateSql7(bl, pSSysDMVerItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_DBObjType(bl, pSSysDMVerItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_DropSql(bl, pSSysDMVerItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Memo(bl, pSSysDMVerItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEId(bl, pSSysDMVerItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEName(bl, pSSysDMVerItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSObjId(bl, pSSysDMVerItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSObjName(bl, pSSysDMVerItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysDMItemId(bl, pSSysDMVerItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysDMItemName(bl, pSSysDMVerItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysDMVerId(bl, pSSysDMVerItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysDMVerItemId(bl, pSSysDMVerItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysDMVerItemName(bl, pSSysDMVerItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSystemDBCfgId(bl, pSSysDMVerItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSystemDBCfgName(bl, pSSysDMVerItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_SysDBVer(bl, pSSysDMVerItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_TestSql(bl, pSSysDMVerItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserFlag(bl, pSSysDMVerItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, (IEntity)pSSysDMVerItem, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_CreateSql(boolean bl, PSSysDMVerItem pSSysDMVerItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysDMVerItem.isCreateSqlDirty() : !pSSysDMVerItem.isCreateSqlDirty()) {
            return null;
        }
        String string = pSSysDMVerItem.getCreateSql();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_CreateSql_Default((IEntity)pSSysDMVerItem, bl2, bl3);
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

    protected EntityFieldError onCheckField_CreateSql2(boolean bl, PSSysDMVerItem pSSysDMVerItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysDMVerItem.isCreateSql2Dirty() : !pSSysDMVerItem.isCreateSql2Dirty()) {
            return null;
        }
        String string = pSSysDMVerItem.getCreateSql2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_CreateSql2_Default((IEntity)pSSysDMVerItem, bl2, bl3);
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

    protected EntityFieldError onCheckField_CreateSql3(boolean bl, PSSysDMVerItem pSSysDMVerItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysDMVerItem.isCreateSql3Dirty() : !pSSysDMVerItem.isCreateSql3Dirty()) {
            return null;
        }
        String string = pSSysDMVerItem.getCreateSql3();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_CreateSql3_Default((IEntity)pSSysDMVerItem, bl2, bl3);
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

    protected EntityFieldError onCheckField_CreateSql4(boolean bl, PSSysDMVerItem pSSysDMVerItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysDMVerItem.isCreateSql4Dirty() : !pSSysDMVerItem.isCreateSql4Dirty()) {
            return null;
        }
        String string = pSSysDMVerItem.getCreateSql4();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_CreateSql4_Default((IEntity)pSSysDMVerItem, bl2, bl3);
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

    protected EntityFieldError onCheckField_CreateSql5(boolean bl, PSSysDMVerItem pSSysDMVerItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysDMVerItem.isCreateSql5Dirty() : !pSSysDMVerItem.isCreateSql5Dirty()) {
            return null;
        }
        String string = pSSysDMVerItem.getCreateSql5();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_CreateSql5_Default((IEntity)pSSysDMVerItem, bl2, bl3);
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

    protected EntityFieldError onCheckField_CreateSql6(boolean bl, PSSysDMVerItem pSSysDMVerItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysDMVerItem.isCreateSql6Dirty() : !pSSysDMVerItem.isCreateSql6Dirty()) {
            return null;
        }
        String string = pSSysDMVerItem.getCreateSql6();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_CreateSql6_Default((IEntity)pSSysDMVerItem, bl2, bl3);
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

    protected EntityFieldError onCheckField_CreateSql7(boolean bl, PSSysDMVerItem pSSysDMVerItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysDMVerItem.isCreateSql7Dirty() : !pSSysDMVerItem.isCreateSql7Dirty()) {
            return null;
        }
        String string = pSSysDMVerItem.getCreateSql7();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_CreateSql7_Default((IEntity)pSSysDMVerItem, bl2, bl3);
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

    protected EntityFieldError onCheckField_DBObjType(boolean bl, PSSysDMVerItem pSSysDMVerItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysDMVerItem.isDBObjTypeDirty() && !bl2 : !pSSysDMVerItem.isDBObjTypeDirty()) {
            return null;
        }
        String string = pSSysDMVerItem.getDBObjType();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DBOBJTYPE");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_DBObjType_Default((IEntity)pSSysDMVerItem, bl2, bl3);
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

    protected EntityFieldError onCheckField_DropSql(boolean bl, PSSysDMVerItem pSSysDMVerItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysDMVerItem.isDropSqlDirty() : !pSSysDMVerItem.isDropSqlDirty()) {
            return null;
        }
        String string = pSSysDMVerItem.getDropSql();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_DropSql_Default((IEntity)pSSysDMVerItem, bl2, bl3);
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

    protected EntityFieldError onCheckField_Memo(boolean bl, PSSysDMVerItem pSSysDMVerItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysDMVerItem.isMemoDirty() : !pSSysDMVerItem.isMemoDirty()) {
            return null;
        }
        String string = pSSysDMVerItem.getMemo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Memo_Default((IEntity)pSSysDMVerItem, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDEId(boolean bl, PSSysDMVerItem pSSysDMVerItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysDMVerItem.isPSDEIdDirty() : !pSSysDMVerItem.isPSDEIdDirty()) {
            return null;
        }
        String string = pSSysDMVerItem.getPSDEId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEId_Default((IEntity)pSSysDMVerItem, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDEName(boolean bl, PSSysDMVerItem pSSysDMVerItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysDMVerItem.isPSDENameDirty() : !pSSysDMVerItem.isPSDENameDirty()) {
            return null;
        }
        String string = pSSysDMVerItem.getPSDEName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEName_Default((IEntity)pSSysDMVerItem, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSObjId(boolean bl, PSSysDMVerItem pSSysDMVerItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysDMVerItem.isPSObjIdDirty() && !bl2 : !pSSysDMVerItem.isPSObjIdDirty()) {
            return null;
        }
        String string = pSSysDMVerItem.getPSObjId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSOBJID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSObjId_Default((IEntity)pSSysDMVerItem, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSObjName(boolean bl, PSSysDMVerItem pSSysDMVerItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysDMVerItem.isPSObjNameDirty() : !pSSysDMVerItem.isPSObjNameDirty()) {
            return null;
        }
        String string = pSSysDMVerItem.getPSObjName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSObjName_Default((IEntity)pSSysDMVerItem, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSSysDMItemId(boolean bl, PSSysDMVerItem pSSysDMVerItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysDMVerItem.isPSSysDMItemIdDirty() && !bl2 : !pSSysDMVerItem.isPSSysDMItemIdDirty()) {
            return null;
        }
        String string = pSSysDMVerItem.getPSSysDMItemId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSDMITEMID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysDMItemId_Default((IEntity)pSSysDMVerItem, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSSysDMItemName(boolean bl, PSSysDMVerItem pSSysDMVerItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysDMVerItem.isPSSysDMItemNameDirty() && !bl2 : !pSSysDMVerItem.isPSSysDMItemNameDirty()) {
            return null;
        }
        String string = pSSysDMVerItem.getPSSysDMItemName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSDMITEMNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysDMItemName_Default((IEntity)pSSysDMVerItem, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSSysDMVerId(boolean bl, PSSysDMVerItem pSSysDMVerItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysDMVerItem.isPSSysDMVerIdDirty() && !bl2 : !pSSysDMVerItem.isPSSysDMVerIdDirty()) {
            return null;
        }
        String string = pSSysDMVerItem.getPSSysDMVerId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSDMVERID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysDMVerId_Default((IEntity)pSSysDMVerItem, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSSysDMVerItemId(boolean bl, PSSysDMVerItem pSSysDMVerItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysDMVerItem.isPSSysDMVerItemIdDirty() && !bl2 : !pSSysDMVerItem.isPSSysDMVerItemIdDirty()) {
            return null;
        }
        String string = pSSysDMVerItem.getPSSysDMVerItemId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSDMVERITEMID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysDMVerItemId_Default((IEntity)pSSysDMVerItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSDMVERITEMID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSysDMVerItemName(boolean bl, PSSysDMVerItem pSSysDMVerItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysDMVerItem.isPSSysDMVerItemNameDirty() && !bl2 : !pSSysDMVerItem.isPSSysDMVerItemNameDirty()) {
            return null;
        }
        String string = pSSysDMVerItem.getPSSysDMVerItemName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSDMVERITEMNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysDMVerItemName_Default((IEntity)pSSysDMVerItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSDMVERITEMNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSystemDBCfgId(boolean bl, PSSysDMVerItem pSSysDMVerItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysDMVerItem.isPSSystemDBCfgIdDirty() && !bl2 : !pSSysDMVerItem.isPSSystemDBCfgIdDirty()) {
            return null;
        }
        String string = pSSysDMVerItem.getPSSystemDBCfgId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSTEMDBCFGID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSystemDBCfgId_Default((IEntity)pSSysDMVerItem, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSSystemDBCfgName(boolean bl, PSSysDMVerItem pSSysDMVerItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysDMVerItem.isPSSystemDBCfgNameDirty() && !bl2 : !pSSysDMVerItem.isPSSystemDBCfgNameDirty()) {
            return null;
        }
        String string = pSSysDMVerItem.getPSSystemDBCfgName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSTEMDBCFGNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSystemDBCfgName_Default((IEntity)pSSysDMVerItem, bl2, bl3);
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

    protected EntityFieldError onCheckField_SysDBVer(boolean bl, PSSysDMVerItem pSSysDMVerItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysDMVerItem.isSysDBVerDirty() : !pSSysDMVerItem.isSysDBVerDirty()) {
            return null;
        }
        Integer n = pSSysDMVerItem.getSysDBVer();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_SysDBVer_Default((IEntity)pSSysDMVerItem, bl2, bl3);
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

    protected EntityFieldError onCheckField_TestSql(boolean bl, PSSysDMVerItem pSSysDMVerItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysDMVerItem.isTestSqlDirty() : !pSSysDMVerItem.isTestSqlDirty()) {
            return null;
        }
        String string = pSSysDMVerItem.getTestSql();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_TestSql_Default((IEntity)pSSysDMVerItem, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserFlag(boolean bl, PSSysDMVerItem pSSysDMVerItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysDMVerItem.isUserFlagDirty() && !bl2 : !pSSysDMVerItem.isUserFlagDirty()) {
            return null;
        }
        Integer n = pSSysDMVerItem.getUserFlag();
        if (bl) {
            if (bl2 && n == null) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("USERFLAG");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string = null;
            string = this.onTestValueRule_UserFlag_Default((IEntity)pSSysDMVerItem, bl2, bl3);
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

    protected void onSyncEntity(PSSysDMVerItem pSSysDMVerItem, boolean bl) throws Exception {
        super.onSyncEntity((IEntity)pSSysDMVerItem, bl);
    }

    protected void onSyncIndexEntities(PSSysDMVerItem pSSysDMVerItem, boolean bl) throws Exception {
        super.onSyncIndexEntities((IEntity)pSSysDMVerItem, bl);
    }

    public Object getDataContextValue(PSSysDMVerItem pSSysDMVerItem, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null) {
            // empty if block
        }
        if ((object = super.getDataContextValue((IEntity)pSSysDMVerItem, string, iDataContextParam)) != null) {
            return object;
        }
        return null;
    }

    protected void onExportMajorModel(PSSysDMVerItem pSSysDMVerItem, ArrayList<JSONObject> arrayList, int n) throws Exception {
        super.onExportMajorModel((IEntity)pSSysDMVerItem, arrayList, n);
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
        if (StringHelper.compare((String)string, (String)"PSSYSDMVERITEMID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysDMVerItemId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSDMVERITEMNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysDMVerItemName_Default(iEntity, bl, bl2);
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
            if (this.checkFieldStringLengthRule("CREATESQL6", iEntity, bl2, null, false, 0x100000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_CreateSql7_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("CREATESQL7", iEntity, bl2, null, false, 0x100000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]";
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
            if (this.checkFieldStringLengthRule("PSOBJNAME", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
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

    protected String onTestValueRule_PSSysDMVerItemId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSDMVERITEMID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysDMVerItemName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSDMVERITEMNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
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

    protected boolean onMergeChild(String string, String string2, PSSysDMVerItem pSSysDMVerItem) throws Exception {
        boolean bl = false;
        if (super.onMergeChild(string, string2, (IEntity)pSSysDMVerItem)) {
            bl = true;
        }
        return bl;
    }

    protected void onUpdateParent(PSSysDMVerItem pSSysDMVerItem) throws Exception {
        super.onUpdateParent((IEntity)pSSysDMVerItem);
    }

    @Override
    protected void exportCurXmlModel(PSSysDMVerItem pSSysDMVerItem, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSSYSDMVERITEM");
        if (!bl) {
            pSSysDMVerItem.setCreateDate(null);
            pSSysDMVerItem.setCreateMan(null);
            pSSysDMVerItem.setPSSysDMVerItemId(null);
            pSSysDMVerItem.setSysDBVer(null);
            pSSysDMVerItem.setUpdateDate(null);
            pSSysDMVerItem.setUpdateMan(null);
            super.exportCurXmlModel(pSSysDMVerItem, xmlNode, bl);
        }
    }

    @Override
    protected String getEntityFolderKeyValue(PSSysDMVerItem pSSysDMVerItem, PSSystem pSSystem) throws Exception {
        PSSysDMVerItem pSSysDMVerItem2 = new PSSysDMVerItem();
        pSSysDMVerItem2.setPSSysDMVerId(pSSysDMVerItem.getPSSysDMVerId());
        pSSysDMVerItem2.setPSSysDMItemId(pSSysDMVerItem.getPSSysDMItemId());
        if (this.selectOne((IEntity)pSSysDMVerItem2, true)) {
            return pSSysDMVerItem2.getPSSysDMVerItemId();
        }
        return super.getEntityFolderKeyValue(pSSysDMVerItem, pSSystem);
    }
}

