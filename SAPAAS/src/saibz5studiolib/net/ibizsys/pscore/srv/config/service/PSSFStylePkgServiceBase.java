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
import net.ibizsys.pscore.srv.config.dao.PSSFStylePkgDAO;
import net.ibizsys.pscore.srv.config.demodel.PSSFStylePkgDEModel;
import net.ibizsys.pscore.srv.config.entity.PSSFPkg;
import net.ibizsys.pscore.srv.config.entity.PSSFPkgBase;
import net.ibizsys.pscore.srv.config.entity.PSSFPkgVer;
import net.ibizsys.pscore.srv.config.entity.PSSFPkgVerBase;
import net.ibizsys.pscore.srv.config.entity.PSSFStyle;
import net.ibizsys.pscore.srv.config.entity.PSSFStyleBase;
import net.ibizsys.pscore.srv.config.entity.PSSFStylePkg;
import net.ibizsys.pscore.srv.core.IPSDataEntityModel;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSSFStylePkgServiceBase
extends PSCoreSysServiceBase<PSSFStylePkg> {
    private static final Log log = LogFactory.getLog(PSSFStylePkgServiceBase.class);
    public static final String DATASET_DEFAULT = "DEFAULT";
    private PSSFStylePkgDEModel pSSFStylePkgDEModel;
    private PSSFStylePkgDAO pSSFStylePkgDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.config.service.PSSFStylePkgService";
    }

    public PSSFStylePkgDEModel getPSSFStylePkgDEModel() {
        if (this.pSSFStylePkgDEModel == null) {
            try {
                this.pSSFStylePkgDEModel = (PSSFStylePkgDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.config.demodel.PSSFStylePkgDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSSFStylePkgDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSSFStylePkgDEModel();
    }

    public PSSFStylePkgDAO getPSSFStylePkgDAO() {
        if (this.pSSFStylePkgDAO == null) {
            try {
                this.pSSFStylePkgDAO = (PSSFStylePkgDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.config.dao.PSSFStylePkgDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSSFStylePkgDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSSFStylePkgDAO();
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

    protected void onFillParentInfo(PSSFStylePkg pSSFStylePkg, String string, String string2, String string3) throws Exception {
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSFSTYLEPKG_PSSFPKGVER_PSSFPKGVERID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.config.service.PSSFPkgVerService", (SessionFactory)this.getSessionFactory());
            PSSFPkgVer pSSFPkgVer = (PSSFPkgVer)iService.getDEModel().createEntity();
            pSSFPkgVer.set("PSSFPKGVERID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSSFPkgVer);
            } else {
                iService.get((IEntity)pSSFPkgVer);
            }
            this.onFillParentInfo_PSSFPkgVer(pSSFStylePkg, pSSFPkgVer);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSFSTYLEPKG_PSSFPKG_PSSFPKGID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.config.service.PSSFPkgService", (SessionFactory)this.getSessionFactory());
            PSSFPkg pSSFPkg = (PSSFPkg)iService.getDEModel().createEntity();
            pSSFPkg.set("PSSFPKGID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSSFPkg);
            } else {
                iService.get((IEntity)pSSFPkg);
            }
            this.onFillParentInfo_PSSFPkg(pSSFStylePkg, pSSFPkg);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSFSTYLEPKG_PSSFSTYLE_PSSFSTYLEID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.config.service.PSSFStyleService", (SessionFactory)this.getSessionFactory());
            PSSFStyle pSSFStyle = (PSSFStyle)iService.getDEModel().createEntity();
            pSSFStyle.set("PSSFSTYLEID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSSFStyle);
            } else {
                iService.get((IEntity)pSSFStyle);
            }
            this.onFillParentInfo_PSSFStyle(pSSFStylePkg, pSSFStyle);
            return;
        }
        super.onFillParentInfo((IEntity)pSSFStylePkg, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillParentInfo_PSSFPkgVer(PSSFStylePkg pSSFStylePkg, PSSFPkgVer pSSFPkgVer) throws Exception {
        pSSFStylePkg.setPSSFPkgVerId(pSSFPkgVer.getPSSFPkgVerId());
        pSSFStylePkg.setPSSFPkgVerName(pSSFPkgVer.getPSSFPkgVerName());
    }

    protected void onFillParentInfo_PSSFPkg(PSSFStylePkg pSSFStylePkg, PSSFPkg pSSFPkg) throws Exception {
        pSSFStylePkg.setPSSFPkgId(pSSFPkg.getPSSFPkgId());
        pSSFStylePkg.setPSSFPkgName(pSSFPkg.getPSSFPkgName());
    }

    protected void onFillParentInfo_PSSFStyle(PSSFStylePkg pSSFStylePkg, PSSFStyle pSSFStyle) throws Exception {
        pSSFStylePkg.setPSSFStyleId(pSSFStyle.getPSSFStyleId());
        pSSFStylePkg.setPSSFStyleName(pSSFStyle.getPSSFStyleName());
    }

    protected void onFillEntityFullInfo(PSSFStylePkg pSSFStylePkg, boolean bl) throws Exception {
        if (bl) {
            // empty if block
        }
        super.onFillEntityFullInfo((IEntity)pSSFStylePkg, bl);
        this.onFillEntityFullInfo_PSSFPkgVer(pSSFStylePkg, bl);
        this.onFillEntityFullInfo_PSSFPkg(pSSFStylePkg, bl);
        this.onFillEntityFullInfo_PSSFStyle(pSSFStylePkg, bl);
    }

    protected void onFillEntityFullInfo_PSSFPkgVer(PSSFStylePkg pSSFStylePkg, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSSFPkg(PSSFStylePkg pSSFStylePkg, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSSFStyle(PSSFStylePkg pSSFStylePkg, boolean bl) throws Exception {
        if (pSSFStylePkg.isPSSFStyleIdDirty()) {
            if (pSSFStylePkg.getPSSFStyleId() != null) {
                if (pSSFStylePkg.getPSSFStyleId() == null || pSSFStylePkg.getPSSFStyleName() == null) {
                    PSSFStyle pSSFStyle = pSSFStylePkg.getPSSFStyle();
                    pSSFStylePkg.setPSSFStyleName(pSSFStyle.getPSSFStyleName());
                }
            } else {
                pSSFStylePkg.setPSSFStyleName(null);
            }
        }
    }

    protected void onWriteBackParent(PSSFStylePkg pSSFStylePkg, boolean bl) throws Exception {
        super.onWriteBackParent((IEntity)pSSFStylePkg, bl);
    }

    public ArrayList<PSSFStylePkg> selectByPSSFPkgVer(PSSFPkgVerBase pSSFPkgVerBase) throws Exception {
        return this.selectByPSSFPkgVer(pSSFPkgVerBase, "", -1);
    }

    public ArrayList<PSSFStylePkg> selectByPSSFPkgVer(PSSFPkgVerBase pSSFPkgVerBase, String string) throws Exception {
        return this.selectByPSSFPkgVer(pSSFPkgVerBase, string, -1);
    }

    public ArrayList<PSSFStylePkg> selectByPSSFPkgVer(PSSFPkgVerBase pSSFPkgVerBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSSFPKGVERID", (Object)pSSFPkgVerBase.getPSSFPkgVerId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSSFPkgVerCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSSFPkgVerCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSSFStylePkg> selectByPSSFPkg(PSSFPkgBase pSSFPkgBase) throws Exception {
        return this.selectByPSSFPkg(pSSFPkgBase, "", -1);
    }

    public ArrayList<PSSFStylePkg> selectByPSSFPkg(PSSFPkgBase pSSFPkgBase, String string) throws Exception {
        return this.selectByPSSFPkg(pSSFPkgBase, string, -1);
    }

    public ArrayList<PSSFStylePkg> selectByPSSFPkg(PSSFPkgBase pSSFPkgBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSSFPKGID", (Object)pSSFPkgBase.getPSSFPkgId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSSFPkgCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSSFPkgCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSSFStylePkg> selectByPSSFStyle(PSSFStyleBase pSSFStyleBase) throws Exception {
        return this.selectByPSSFStyle(pSSFStyleBase, "", -1);
    }

    public ArrayList<PSSFStylePkg> selectByPSSFStyle(PSSFStyleBase pSSFStyleBase, String string) throws Exception {
        return this.selectByPSSFStyle(pSSFStyleBase, string, -1);
    }

    public ArrayList<PSSFStylePkg> selectByPSSFStyle(PSSFStyleBase pSSFStyleBase, String string, int n) throws Exception {
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

    public void testRemoveByPSSFPkgVer(PSSFPkgVer pSSFPkgVer) throws Exception {
        ArrayList<PSSFStylePkg> arrayList = this.selectByPSSFPkgVer(pSSFPkgVer, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSFPKGVER");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSSFPkgVer);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSFSTYLEPKG_PSSFPKGVER_PSSFPKGVERID", "", iDataEntityModel.getName(), "PSSFSTYLEPKG", iDataEntityModel.getDataInfo((IEntity)pSSFPkgVer), arrayList.get(0)));
        }
    }

    public void resetPSSFPkgVer(PSSFPkgVer pSSFPkgVer) throws Exception {
        ArrayList<PSSFStylePkg> arrayList = this.selectByPSSFPkgVer(pSSFPkgVer);
        for (PSSFStylePkg pSSFStylePkg : arrayList) {
            PSSFStylePkg pSSFStylePkg2 = (PSSFStylePkg)this.getDEModel().createEntity();
            pSSFStylePkg2.setPSSFStylePkgId(pSSFStylePkg.getPSSFStylePkgId());
            pSSFStylePkg2.setPSSFPkgVerId(null);
            this.update(pSSFStylePkg2);
        }
    }

    public void removeByPSSFPkgVer(PSSFPkgVer pSSFPkgVer) throws Exception {
        final PSSFPkgVer pSSFPkgVer2 = pSSFPkgVer;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSFStylePkgServiceBase.this.onBeforeRemoveByPSSFPkgVer(pSSFPkgVer2);
                PSSFStylePkgServiceBase.this.internalRemoveByPSSFPkgVer(pSSFPkgVer2);
                PSSFStylePkgServiceBase.this.onAfterRemoveByPSSFPkgVer(pSSFPkgVer2);
            }
        });
    }

    protected void onBeforeRemoveByPSSFPkgVer(PSSFPkgVer pSSFPkgVer) throws Exception {
    }

    protected void internalRemoveByPSSFPkgVer(PSSFPkgVer pSSFPkgVer) throws Exception {
        ArrayList<PSSFStylePkg> arrayList = this.selectByPSSFPkgVer(pSSFPkgVer);
        this.onBeforeRemoveByPSSFPkgVer(pSSFPkgVer, arrayList);
        for (PSSFStylePkg pSSFStylePkg : arrayList) {
            this.remove((IEntity)pSSFStylePkg);
        }
        this.onAfterRemoveByPSSFPkgVer(pSSFPkgVer, arrayList);
    }

    protected void onAfterRemoveByPSSFPkgVer(PSSFPkgVer pSSFPkgVer) throws Exception {
    }

    protected void onBeforeRemoveByPSSFPkgVer(PSSFPkgVer pSSFPkgVer, ArrayList<PSSFStylePkg> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSFPkgVer(PSSFPkgVer pSSFPkgVer, ArrayList<PSSFStylePkg> arrayList) throws Exception {
    }

    public void testRemoveByPSSFPkg(PSSFPkg pSSFPkg) throws Exception {
        ArrayList<PSSFStylePkg> arrayList = this.selectByPSSFPkg(pSSFPkg, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSFPKG");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSSFPkg);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSFSTYLEPKG_PSSFPKG_PSSFPKGID", "", iDataEntityModel.getName(), "PSSFSTYLEPKG", iDataEntityModel.getDataInfo((IEntity)pSSFPkg), arrayList.get(0)));
        }
    }

    public void resetPSSFPkg(PSSFPkg pSSFPkg) throws Exception {
        ArrayList<PSSFStylePkg> arrayList = this.selectByPSSFPkg(pSSFPkg);
        for (PSSFStylePkg pSSFStylePkg : arrayList) {
            PSSFStylePkg pSSFStylePkg2 = (PSSFStylePkg)this.getDEModel().createEntity();
            pSSFStylePkg2.setPSSFStylePkgId(pSSFStylePkg.getPSSFStylePkgId());
            pSSFStylePkg2.setPSSFPkgId(null);
            this.update(pSSFStylePkg2);
        }
    }

    public void removeByPSSFPkg(PSSFPkg pSSFPkg) throws Exception {
        final PSSFPkg pSSFPkg2 = pSSFPkg;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSFStylePkgServiceBase.this.onBeforeRemoveByPSSFPkg(pSSFPkg2);
                PSSFStylePkgServiceBase.this.internalRemoveByPSSFPkg(pSSFPkg2);
                PSSFStylePkgServiceBase.this.onAfterRemoveByPSSFPkg(pSSFPkg2);
            }
        });
    }

    protected void onBeforeRemoveByPSSFPkg(PSSFPkg pSSFPkg) throws Exception {
    }

    protected void internalRemoveByPSSFPkg(PSSFPkg pSSFPkg) throws Exception {
        ArrayList<PSSFStylePkg> arrayList = this.selectByPSSFPkg(pSSFPkg);
        this.onBeforeRemoveByPSSFPkg(pSSFPkg, arrayList);
        for (PSSFStylePkg pSSFStylePkg : arrayList) {
            this.remove((IEntity)pSSFStylePkg);
        }
        this.onAfterRemoveByPSSFPkg(pSSFPkg, arrayList);
    }

    protected void onAfterRemoveByPSSFPkg(PSSFPkg pSSFPkg) throws Exception {
    }

    protected void onBeforeRemoveByPSSFPkg(PSSFPkg pSSFPkg, ArrayList<PSSFStylePkg> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSFPkg(PSSFPkg pSSFPkg, ArrayList<PSSFStylePkg> arrayList) throws Exception {
    }

    public void testRemoveByPSSFStyle(PSSFStyle pSSFStyle) throws Exception {
    }

    public void resetPSSFStyle(PSSFStyle pSSFStyle) throws Exception {
        ArrayList<PSSFStylePkg> arrayList = this.selectByPSSFStyle(pSSFStyle);
        for (PSSFStylePkg pSSFStylePkg : arrayList) {
            PSSFStylePkg pSSFStylePkg2 = (PSSFStylePkg)this.getDEModel().createEntity();
            pSSFStylePkg2.setPSSFStylePkgId(pSSFStylePkg.getPSSFStylePkgId());
            pSSFStylePkg2.setPSSFStyleId(null);
            this.update(pSSFStylePkg2);
        }
    }

    public void removeByPSSFStyle(PSSFStyle pSSFStyle) throws Exception {
        final PSSFStyle pSSFStyle2 = pSSFStyle;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSFStylePkgServiceBase.this.onBeforeRemoveByPSSFStyle(pSSFStyle2);
                PSSFStylePkgServiceBase.this.internalRemoveByPSSFStyle(pSSFStyle2);
                PSSFStylePkgServiceBase.this.onAfterRemoveByPSSFStyle(pSSFStyle2);
            }
        });
    }

    protected void onBeforeRemoveByPSSFStyle(PSSFStyle pSSFStyle) throws Exception {
    }

    protected void internalRemoveByPSSFStyle(PSSFStyle pSSFStyle) throws Exception {
        ArrayList<PSSFStylePkg> arrayList = this.selectByPSSFStyle(pSSFStyle);
        this.onBeforeRemoveByPSSFStyle(pSSFStyle, arrayList);
        for (PSSFStylePkg pSSFStylePkg : arrayList) {
            this.remove((IEntity)pSSFStylePkg);
        }
        this.onAfterRemoveByPSSFStyle(pSSFStyle, arrayList);
    }

    protected void onAfterRemoveByPSSFStyle(PSSFStyle pSSFStyle) throws Exception {
    }

    protected void onBeforeRemoveByPSSFStyle(PSSFStyle pSSFStyle, ArrayList<PSSFStylePkg> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSFStyle(PSSFStyle pSSFStyle, ArrayList<PSSFStylePkg> arrayList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(PSSFStylePkg pSSFStylePkg) throws Exception {
        super.onBeforeRemove(pSSFStylePkg);
    }

    protected void replaceParentInfo(PSSFStylePkg pSSFStylePkg, CloneSession cloneSession) throws Exception {
        IEntity iEntity;
        super.replaceParentInfo((IEntity)pSSFStylePkg, cloneSession);
        if (pSSFStylePkg.getPSSFPkgVerId() != null && (iEntity = cloneSession.getEntity("PSSFPKGVER", (Object)pSSFStylePkg.getPSSFPkgVerId())) != null) {
            this.onFillParentInfo_PSSFPkgVer(pSSFStylePkg, (PSSFPkgVer)iEntity);
        }
        if (pSSFStylePkg.getPSSFPkgId() != null && (iEntity = cloneSession.getEntity("PSSFPKG", (Object)pSSFStylePkg.getPSSFPkgId())) != null) {
            this.onFillParentInfo_PSSFPkg(pSSFStylePkg, (PSSFPkg)iEntity);
        }
        if (pSSFStylePkg.getPSSFStyleId() != null && (iEntity = cloneSession.getEntity("PSSFSTYLE", (Object)pSSFStylePkg.getPSSFStyleId())) != null) {
            this.onFillParentInfo_PSSFStyle(pSSFStylePkg, (PSSFStyle)iEntity);
        }
    }

    protected void onRemoveEntityUncopyValues(PSSFStylePkg pSSFStylePkg, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues((IEntity)pSSFStylePkg, bl);
    }

    protected void onCheckEntity(boolean bl, PSSFStylePkg pSSFStylePkg, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_Memo(bl, pSSFStylePkg, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_OrderValue(bl, pSSFStylePkg, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSFPkgId(bl, pSSFStylePkg, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSFPkgVerId(bl, pSSFStylePkg, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSFStyleId(bl, pSSFStylePkg, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSFStyleName(bl, pSSFStylePkg, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSFStylePkgId(bl, pSSFStylePkg, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSFStylePkgName(bl, pSSFStylePkg, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, (IEntity)pSSFStylePkg, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_Memo(boolean bl, PSSFStylePkg pSSFStylePkg, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSFStylePkg.isMemoDirty() : !pSSFStylePkg.isMemoDirty()) {
            return null;
        }
        String string = pSSFStylePkg.getMemo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Memo_Default((IEntity)pSSFStylePkg, bl2, bl3);
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

    protected EntityFieldError onCheckField_OrderValue(boolean bl, PSSFStylePkg pSSFStylePkg, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSFStylePkg.isOrderValueDirty() : !pSSFStylePkg.isOrderValueDirty()) {
            return null;
        }
        Integer n = pSSFStylePkg.getOrderValue();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_OrderValue_Default((IEntity)pSSFStylePkg, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSSFPkgId(boolean bl, PSSFStylePkg pSSFStylePkg, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSFStylePkg.isPSSFPkgIdDirty() : !pSSFStylePkg.isPSSFPkgIdDirty()) {
            return null;
        }
        String string = pSSFStylePkg.getPSSFPkgId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSFPkgId_Default((IEntity)pSSFStylePkg, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSFPKGID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSFPkgVerId(boolean bl, PSSFStylePkg pSSFStylePkg, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSFStylePkg.isPSSFPkgVerIdDirty() : !pSSFStylePkg.isPSSFPkgVerIdDirty()) {
            return null;
        }
        String string = pSSFStylePkg.getPSSFPkgVerId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSFPkgVerId_Default((IEntity)pSSFStylePkg, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSFPKGVERID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSFStyleId(boolean bl, PSSFStylePkg pSSFStylePkg, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSFStylePkg.isPSSFStyleIdDirty() : !pSSFStylePkg.isPSSFStyleIdDirty()) {
            return null;
        }
        String string = pSSFStylePkg.getPSSFStyleId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSFStyleId_Default((IEntity)pSSFStylePkg, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSSFStyleName(boolean bl, PSSFStylePkg pSSFStylePkg, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSFStylePkg.isPSSFStyleNameDirty() : !pSSFStylePkg.isPSSFStyleNameDirty()) {
            return null;
        }
        String string = pSSFStylePkg.getPSSFStyleName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSFStyleName_Default((IEntity)pSSFStylePkg, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSSFStylePkgId(boolean bl, PSSFStylePkg pSSFStylePkg, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSFStylePkg.isPSSFStylePkgIdDirty() && !bl2 : !pSSFStylePkg.isPSSFStylePkgIdDirty()) {
            return null;
        }
        String string = pSSFStylePkg.getPSSFStylePkgId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSFSTYLEPKGID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSFStylePkgId_Default((IEntity)pSSFStylePkg, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSFSTYLEPKGID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSFStylePkgName(boolean bl, PSSFStylePkg pSSFStylePkg, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSFStylePkg.isPSSFStylePkgNameDirty() && !bl2 : !pSSFStylePkg.isPSSFStylePkgNameDirty()) {
            return null;
        }
        String string = pSSFStylePkg.getPSSFStylePkgName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSFSTYLEPKGNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSFStylePkgName_Default((IEntity)pSSFStylePkg, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSFSTYLEPKGNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected void onSyncEntity(PSSFStylePkg pSSFStylePkg, boolean bl) throws Exception {
        super.onSyncEntity((IEntity)pSSFStylePkg, bl);
    }

    protected void onSyncIndexEntities(PSSFStylePkg pSSFStylePkg, boolean bl) throws Exception {
        super.onSyncIndexEntities((IEntity)pSSFStylePkg, bl);
    }

    public Object getDataContextValue(PSSFStylePkg pSSFStylePkg, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null) {
            // empty if block
        }
        if ((object = super.getDataContextValue((IEntity)pSSFStylePkg, string, iDataContextParam)) != null) {
            return object;
        }
        PSSFStyle pSSFStyle = pSSFStylePkg.getPSSFStyle();
        if (pSSFStyle != null && pSSFStyle.contains(string)) {
            return pSSFStyle.get(string);
        }
        return null;
    }

    protected void onExportMajorModel(PSSFStylePkg pSSFStylePkg, ArrayList<JSONObject> arrayList, int n) throws Exception {
        super.onExportMajorModel((IEntity)pSSFStylePkg, arrayList, n);
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
        if (StringHelper.compare((String)string, (String)"ORDERVALUE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_OrderValue_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSFPKGID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSFPkgId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSFPKGNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSFPkgName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSFPKGVERID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSFPkgVerId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSFPKGVERNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSFPkgVerName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSFSTYLEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSFStyleId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSFSTYLENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSFStyleName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSFSTYLEPKGID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSFStylePkgId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSFSTYLEPKGNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSFStylePkgName_Default(iEntity, bl, bl2);
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

    protected String onTestValueRule_OrderValue_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_PSSFPkgId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSFPKGID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSFPkgName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSFPKGNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSFPkgVerId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSFPKGVERID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSFPkgVerName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSFPKGVERNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
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

    protected String onTestValueRule_PSSFStylePkgId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSFSTYLEPKGID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSFStylePkgName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSFSTYLEPKGNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
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

    protected boolean onMergeChild(String string, String string2, PSSFStylePkg pSSFStylePkg) throws Exception {
        boolean bl = false;
        if (super.onMergeChild(string, string2, (IEntity)pSSFStylePkg)) {
            bl = true;
        }
        return bl;
    }

    protected void onUpdateParent(PSSFStylePkg pSSFStylePkg) throws Exception {
        super.onUpdateParent((IEntity)pSSFStylePkg);
    }

    @Override
    protected void exportCurXmlModel(PSSFStylePkg pSSFStylePkg, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSSFSTYLEPKG");
        if (!bl) {
            pSSFStylePkg.setCreateDate(null);
            pSSFStylePkg.setCreateMan(null);
            pSSFStylePkg.setPSSFPkgName(null);
            pSSFStylePkg.setPSSFPkgVerName(null);
            pSSFStylePkg.setPSSFStylePkgId(null);
            pSSFStylePkg.setUpdateDate(null);
            pSSFStylePkg.setUpdateMan(null);
            super.exportCurXmlModel(pSSFStylePkg, xmlNode, bl);
        }
    }
}

