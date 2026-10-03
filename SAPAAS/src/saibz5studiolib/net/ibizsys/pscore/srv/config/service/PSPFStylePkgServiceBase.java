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
import net.ibizsys.pscore.srv.config.dao.PSPFStylePkgDAO;
import net.ibizsys.pscore.srv.config.demodel.PSPFStylePkgDEModel;
import net.ibizsys.pscore.srv.config.entity.PSPFPkg;
import net.ibizsys.pscore.srv.config.entity.PSPFPkgBase;
import net.ibizsys.pscore.srv.config.entity.PSPFPkgVer;
import net.ibizsys.pscore.srv.config.entity.PSPFPkgVerBase;
import net.ibizsys.pscore.srv.config.entity.PSPFStyle;
import net.ibizsys.pscore.srv.config.entity.PSPFStyleBase;
import net.ibizsys.pscore.srv.config.entity.PSPFStylePkg;
import net.ibizsys.pscore.srv.core.IPSDataEntityModel;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSPFStylePkgServiceBase
extends PSCoreSysServiceBase<PSPFStylePkg> {
    private static final Log log = LogFactory.getLog(PSPFStylePkgServiceBase.class);
    public static final String DATASET_DEFAULT = "DEFAULT";
    private PSPFStylePkgDEModel pSPFStylePkgDEModel;
    private PSPFStylePkgDAO pSPFStylePkgDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.config.service.PSPFStylePkgService";
    }

    public PSPFStylePkgDEModel getPSPFStylePkgDEModel() {
        if (this.pSPFStylePkgDEModel == null) {
            try {
                this.pSPFStylePkgDEModel = (PSPFStylePkgDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.config.demodel.PSPFStylePkgDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSPFStylePkgDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSPFStylePkgDEModel();
    }

    public PSPFStylePkgDAO getPSPFStylePkgDAO() {
        if (this.pSPFStylePkgDAO == null) {
            try {
                this.pSPFStylePkgDAO = (PSPFStylePkgDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.config.dao.PSPFStylePkgDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSPFStylePkgDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSPFStylePkgDAO();
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

    protected void onFillParentInfo(PSPFStylePkg pSPFStylePkg, String string, String string2, String string3) throws Exception {
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSPFSTYLEPKG_PSPFPKGVER_PSPFPKGVERID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.config.service.PSPFPkgVerService", (SessionFactory)this.getSessionFactory());
            PSPFPkgVer pSPFPkgVer = (PSPFPkgVer)iService.getDEModel().createEntity();
            pSPFPkgVer.set("PSPFPKGVERID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSPFPkgVer);
            } else {
                iService.get(pSPFPkgVer);
            }
            this.onFillParentInfo_PSPFPkgVer(pSPFStylePkg, pSPFPkgVer);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSPFSTYLEPKG_PSPFPKG_PSPFPKGID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.config.service.PSPFPkgService", (SessionFactory)this.getSessionFactory());
            PSPFPkg pSPFPkg = (PSPFPkg)iService.getDEModel().createEntity();
            pSPFPkg.set("PSPFPKGID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSPFPkg);
            } else {
                iService.get(pSPFPkg);
            }
            this.onFillParentInfo_PSPFPkg(pSPFStylePkg, pSPFPkg);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSPFSTYLEPKG_PSPFSTYLE_PSPFSTYLEID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.config.service.PSPFStyleService", (SessionFactory)this.getSessionFactory());
            PSPFStyle pSPFStyle = (PSPFStyle)iService.getDEModel().createEntity();
            pSPFStyle.set("PSPFSTYLEID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSPFStyle);
            } else {
                iService.get(pSPFStyle);
            }
            this.onFillParentInfo_PSPFStyle(pSPFStylePkg, pSPFStyle);
            return;
        }
        super.onFillParentInfo(pSPFStylePkg, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillParentInfo_PSPFPkgVer(PSPFStylePkg pSPFStylePkg, PSPFPkgVer pSPFPkgVer) throws Exception {
        pSPFStylePkg.setPSPFPkgVerId(pSPFPkgVer.getPSPFPkgVerId());
        pSPFStylePkg.setPSPFPkgVerName(pSPFPkgVer.getPSPFPkgVerName());
    }

    protected void onFillParentInfo_PSPFPkg(PSPFStylePkg pSPFStylePkg, PSPFPkg pSPFPkg) throws Exception {
        pSPFStylePkg.setPSPFPkgId(pSPFPkg.getPSPFPkgId());
        pSPFStylePkg.setPSPFPkgName(pSPFPkg.getPSPFPkgName());
    }

    protected void onFillParentInfo_PSPFStyle(PSPFStylePkg pSPFStylePkg, PSPFStyle pSPFStyle) throws Exception {
        pSPFStylePkg.setPSPFStyleId(pSPFStyle.getPSPFStyleId());
        pSPFStylePkg.setPSPFStyleName(pSPFStyle.getPSPFStyleName());
    }

    protected void onFillEntityFullInfo(PSPFStylePkg pSPFStylePkg, boolean bl) throws Exception {
        if (bl) {
            // empty if block
        }
        super.onFillEntityFullInfo(pSPFStylePkg, bl);
        this.onFillEntityFullInfo_PSPFPkgVer(pSPFStylePkg, bl);
        this.onFillEntityFullInfo_PSPFPkg(pSPFStylePkg, bl);
        this.onFillEntityFullInfo_PSPFStyle(pSPFStylePkg, bl);
    }

    protected void onFillEntityFullInfo_PSPFPkgVer(PSPFStylePkg pSPFStylePkg, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSPFPkg(PSPFStylePkg pSPFStylePkg, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSPFStyle(PSPFStylePkg pSPFStylePkg, boolean bl) throws Exception {
    }

    protected void onWriteBackParent(PSPFStylePkg pSPFStylePkg, boolean bl) throws Exception {
        super.onWriteBackParent(pSPFStylePkg, bl);
    }

    public ArrayList<PSPFStylePkg> selectByPSPFPkgVer(PSPFPkgVerBase pSPFPkgVerBase) throws Exception {
        return this.selectByPSPFPkgVer(pSPFPkgVerBase, "", -1);
    }

    public ArrayList<PSPFStylePkg> selectByPSPFPkgVer(PSPFPkgVerBase pSPFPkgVerBase, String string) throws Exception {
        return this.selectByPSPFPkgVer(pSPFPkgVerBase, string, -1);
    }

    public ArrayList<PSPFStylePkg> selectByPSPFPkgVer(PSPFPkgVerBase pSPFPkgVerBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSPFPKGVERID", (Object)pSPFPkgVerBase.getPSPFPkgVerId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSPFPkgVerCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSPFPkgVerCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSPFStylePkg> selectByPSPFPkg(PSPFPkgBase pSPFPkgBase) throws Exception {
        return this.selectByPSPFPkg(pSPFPkgBase, "", -1);
    }

    public ArrayList<PSPFStylePkg> selectByPSPFPkg(PSPFPkgBase pSPFPkgBase, String string) throws Exception {
        return this.selectByPSPFPkg(pSPFPkgBase, string, -1);
    }

    public ArrayList<PSPFStylePkg> selectByPSPFPkg(PSPFPkgBase pSPFPkgBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSPFPKGID", (Object)pSPFPkgBase.getPSPFPkgId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSPFPkgCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSPFPkgCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSPFStylePkg> selectByPSPFStyle(PSPFStyleBase pSPFStyleBase) throws Exception {
        return this.selectByPSPFStyle(pSPFStyleBase, "", -1);
    }

    public ArrayList<PSPFStylePkg> selectByPSPFStyle(PSPFStyleBase pSPFStyleBase, String string) throws Exception {
        return this.selectByPSPFStyle(pSPFStyleBase, string, -1);
    }

    public ArrayList<PSPFStylePkg> selectByPSPFStyle(PSPFStyleBase pSPFStyleBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSPFSTYLEID", (Object)pSPFStyleBase.getPSPFStyleId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSPFStyleCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSPFStyleCond(SelectCond selectCond) throws Exception {
    }

    public void testRemoveByPSPFPkgVer(PSPFPkgVer pSPFPkgVer) throws Exception {
        ArrayList<PSPFStylePkg> arrayList = this.selectByPSPFPkgVer(pSPFPkgVer, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSPFPKGVER");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSPFPkgVer);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSPFSTYLEPKG_PSPFPKGVER_PSPFPKGVERID", "", iDataEntityModel.getName(), "PSPFSTYLEPKG", iDataEntityModel.getDataInfo(pSPFPkgVer), arrayList.get(0)));
        }
    }

    public void resetPSPFPkgVer(PSPFPkgVer pSPFPkgVer) throws Exception {
        ArrayList<PSPFStylePkg> arrayList = this.selectByPSPFPkgVer(pSPFPkgVer);
        for (PSPFStylePkg pSPFStylePkg : arrayList) {
            PSPFStylePkg pSPFStylePkg2 = (PSPFStylePkg)this.getDEModel().createEntity();
            pSPFStylePkg2.setPSPFStylePkgId(pSPFStylePkg.getPSPFStylePkgId());
            pSPFStylePkg2.setPSPFPkgVerId(null);
            this.update(pSPFStylePkg2);
        }
    }

    public void removeByPSPFPkgVer(PSPFPkgVer pSPFPkgVer) throws Exception {
        final PSPFPkgVer pSPFPkgVer2 = pSPFPkgVer;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSPFStylePkgServiceBase.this.onBeforeRemoveByPSPFPkgVer(pSPFPkgVer2);
                PSPFStylePkgServiceBase.this.internalRemoveByPSPFPkgVer(pSPFPkgVer2);
                PSPFStylePkgServiceBase.this.onAfterRemoveByPSPFPkgVer(pSPFPkgVer2);
            }
        });
    }

    protected void onBeforeRemoveByPSPFPkgVer(PSPFPkgVer pSPFPkgVer) throws Exception {
    }

    protected void internalRemoveByPSPFPkgVer(PSPFPkgVer pSPFPkgVer) throws Exception {
        ArrayList<PSPFStylePkg> arrayList = this.selectByPSPFPkgVer(pSPFPkgVer);
        this.onBeforeRemoveByPSPFPkgVer(pSPFPkgVer, arrayList);
        for (PSPFStylePkg pSPFStylePkg : arrayList) {
            this.remove(pSPFStylePkg);
        }
        this.onAfterRemoveByPSPFPkgVer(pSPFPkgVer, arrayList);
    }

    protected void onAfterRemoveByPSPFPkgVer(PSPFPkgVer pSPFPkgVer) throws Exception {
    }

    protected void onBeforeRemoveByPSPFPkgVer(PSPFPkgVer pSPFPkgVer, ArrayList<PSPFStylePkg> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSPFPkgVer(PSPFPkgVer pSPFPkgVer, ArrayList<PSPFStylePkg> arrayList) throws Exception {
    }

    public void testRemoveByPSPFPkg(PSPFPkg pSPFPkg) throws Exception {
        ArrayList<PSPFStylePkg> arrayList = this.selectByPSPFPkg(pSPFPkg, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSPFPKG");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSPFPkg);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSPFSTYLEPKG_PSPFPKG_PSPFPKGID", "", iDataEntityModel.getName(), "PSPFSTYLEPKG", iDataEntityModel.getDataInfo(pSPFPkg), arrayList.get(0)));
        }
    }

    public void resetPSPFPkg(PSPFPkg pSPFPkg) throws Exception {
        ArrayList<PSPFStylePkg> arrayList = this.selectByPSPFPkg(pSPFPkg);
        for (PSPFStylePkg pSPFStylePkg : arrayList) {
            PSPFStylePkg pSPFStylePkg2 = (PSPFStylePkg)this.getDEModel().createEntity();
            pSPFStylePkg2.setPSPFStylePkgId(pSPFStylePkg.getPSPFStylePkgId());
            pSPFStylePkg2.setPSPFPkgId(null);
            this.update(pSPFStylePkg2);
        }
    }

    public void removeByPSPFPkg(PSPFPkg pSPFPkg) throws Exception {
        final PSPFPkg pSPFPkg2 = pSPFPkg;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSPFStylePkgServiceBase.this.onBeforeRemoveByPSPFPkg(pSPFPkg2);
                PSPFStylePkgServiceBase.this.internalRemoveByPSPFPkg(pSPFPkg2);
                PSPFStylePkgServiceBase.this.onAfterRemoveByPSPFPkg(pSPFPkg2);
            }
        });
    }

    protected void onBeforeRemoveByPSPFPkg(PSPFPkg pSPFPkg) throws Exception {
    }

    protected void internalRemoveByPSPFPkg(PSPFPkg pSPFPkg) throws Exception {
        ArrayList<PSPFStylePkg> arrayList = this.selectByPSPFPkg(pSPFPkg);
        this.onBeforeRemoveByPSPFPkg(pSPFPkg, arrayList);
        for (PSPFStylePkg pSPFStylePkg : arrayList) {
            this.remove(pSPFStylePkg);
        }
        this.onAfterRemoveByPSPFPkg(pSPFPkg, arrayList);
    }

    protected void onAfterRemoveByPSPFPkg(PSPFPkg pSPFPkg) throws Exception {
    }

    protected void onBeforeRemoveByPSPFPkg(PSPFPkg pSPFPkg, ArrayList<PSPFStylePkg> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSPFPkg(PSPFPkg pSPFPkg, ArrayList<PSPFStylePkg> arrayList) throws Exception {
    }

    public void testRemoveByPSPFStyle(PSPFStyle pSPFStyle) throws Exception {
    }

    public void resetPSPFStyle(PSPFStyle pSPFStyle) throws Exception {
        ArrayList<PSPFStylePkg> arrayList = this.selectByPSPFStyle(pSPFStyle);
        for (PSPFStylePkg pSPFStylePkg : arrayList) {
            PSPFStylePkg pSPFStylePkg2 = (PSPFStylePkg)this.getDEModel().createEntity();
            pSPFStylePkg2.setPSPFStylePkgId(pSPFStylePkg.getPSPFStylePkgId());
            pSPFStylePkg2.setPSPFStyleId(null);
            this.update(pSPFStylePkg2);
        }
    }

    public void removeByPSPFStyle(PSPFStyle pSPFStyle) throws Exception {
        final PSPFStyle pSPFStyle2 = pSPFStyle;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSPFStylePkgServiceBase.this.onBeforeRemoveByPSPFStyle(pSPFStyle2);
                PSPFStylePkgServiceBase.this.internalRemoveByPSPFStyle(pSPFStyle2);
                PSPFStylePkgServiceBase.this.onAfterRemoveByPSPFStyle(pSPFStyle2);
            }
        });
    }

    protected void onBeforeRemoveByPSPFStyle(PSPFStyle pSPFStyle) throws Exception {
    }

    protected void internalRemoveByPSPFStyle(PSPFStyle pSPFStyle) throws Exception {
        ArrayList<PSPFStylePkg> arrayList = this.selectByPSPFStyle(pSPFStyle);
        this.onBeforeRemoveByPSPFStyle(pSPFStyle, arrayList);
        for (PSPFStylePkg pSPFStylePkg : arrayList) {
            this.remove(pSPFStylePkg);
        }
        this.onAfterRemoveByPSPFStyle(pSPFStyle, arrayList);
    }

    protected void onAfterRemoveByPSPFStyle(PSPFStyle pSPFStyle) throws Exception {
    }

    protected void onBeforeRemoveByPSPFStyle(PSPFStyle pSPFStyle, ArrayList<PSPFStylePkg> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSPFStyle(PSPFStyle pSPFStyle, ArrayList<PSPFStylePkg> arrayList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(PSPFStylePkg pSPFStylePkg) throws Exception {
        super.onBeforeRemove(pSPFStylePkg);
    }

    protected void replaceParentInfo(PSPFStylePkg pSPFStylePkg, CloneSession cloneSession) throws Exception {
        IEntity iEntity;
        super.replaceParentInfo(pSPFStylePkg, cloneSession);
        if (pSPFStylePkg.getPSPFPkgVerId() != null && (iEntity = cloneSession.getEntity("PSPFPKGVER", (Object)pSPFStylePkg.getPSPFPkgVerId())) != null) {
            this.onFillParentInfo_PSPFPkgVer(pSPFStylePkg, (PSPFPkgVer)iEntity);
        }
        if (pSPFStylePkg.getPSPFPkgId() != null && (iEntity = cloneSession.getEntity("PSPFPKG", (Object)pSPFStylePkg.getPSPFPkgId())) != null) {
            this.onFillParentInfo_PSPFPkg(pSPFStylePkg, (PSPFPkg)iEntity);
        }
        if (pSPFStylePkg.getPSPFStyleId() != null && (iEntity = cloneSession.getEntity("PSPFSTYLE", (Object)pSPFStylePkg.getPSPFStyleId())) != null) {
            this.onFillParentInfo_PSPFStyle(pSPFStylePkg, (PSPFStyle)iEntity);
        }
    }

    protected void onRemoveEntityUncopyValues(PSPFStylePkg pSPFStylePkg, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues(pSPFStylePkg, bl);
    }

    protected void onCheckEntity(boolean bl, PSPFStylePkg pSPFStylePkg, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_Memo(bl, pSPFStylePkg, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_OrderValue(bl, pSPFStylePkg, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSPFPkgId(bl, pSPFStylePkg, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSPFPkgVerId(bl, pSPFStylePkg, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSPFStyleId(bl, pSPFStylePkg, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSPFStylePkgId(bl, pSPFStylePkg, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSPFStylePkgName(bl, pSPFStylePkg, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, pSPFStylePkg, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_Memo(boolean bl, PSPFStylePkg pSPFStylePkg, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSPFStylePkg.isMemoDirty() : !pSPFStylePkg.isMemoDirty()) {
            return null;
        }
        String string = pSPFStylePkg.getMemo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Memo_Default(pSPFStylePkg, bl2, bl3);
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

    protected EntityFieldError onCheckField_OrderValue(boolean bl, PSPFStylePkg pSPFStylePkg, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSPFStylePkg.isOrderValueDirty() : !pSPFStylePkg.isOrderValueDirty()) {
            return null;
        }
        Integer n = pSPFStylePkg.getOrderValue();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_OrderValue_Default(pSPFStylePkg, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSPFPkgId(boolean bl, PSPFStylePkg pSPFStylePkg, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSPFStylePkg.isPSPFPkgIdDirty() : !pSPFStylePkg.isPSPFPkgIdDirty()) {
            return null;
        }
        String string = pSPFStylePkg.getPSPFPkgId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSPFPkgId_Default(pSPFStylePkg, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSPFPKGID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSPFPkgVerId(boolean bl, PSPFStylePkg pSPFStylePkg, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSPFStylePkg.isPSPFPkgVerIdDirty() : !pSPFStylePkg.isPSPFPkgVerIdDirty()) {
            return null;
        }
        String string = pSPFStylePkg.getPSPFPkgVerId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSPFPkgVerId_Default(pSPFStylePkg, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSPFPKGVERID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSPFStyleId(boolean bl, PSPFStylePkg pSPFStylePkg, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSPFStylePkg.isPSPFStyleIdDirty() : !pSPFStylePkg.isPSPFStyleIdDirty()) {
            return null;
        }
        String string = pSPFStylePkg.getPSPFStyleId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSPFStyleId_Default(pSPFStylePkg, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSPFSTYLEID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSPFStylePkgId(boolean bl, PSPFStylePkg pSPFStylePkg, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSPFStylePkg.isPSPFStylePkgIdDirty() && !bl2 : !pSPFStylePkg.isPSPFStylePkgIdDirty()) {
            return null;
        }
        String string = pSPFStylePkg.getPSPFStylePkgId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSPFSTYLEPKGID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSPFStylePkgId_Default(pSPFStylePkg, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSPFSTYLEPKGID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSPFStylePkgName(boolean bl, PSPFStylePkg pSPFStylePkg, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSPFStylePkg.isPSPFStylePkgNameDirty() && !bl2 : !pSPFStylePkg.isPSPFStylePkgNameDirty()) {
            return null;
        }
        String string = pSPFStylePkg.getPSPFStylePkgName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSPFSTYLEPKGNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSPFStylePkgName_Default(pSPFStylePkg, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSPFSTYLEPKGNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected void onSyncEntity(PSPFStylePkg pSPFStylePkg, boolean bl) throws Exception {
        super.onSyncEntity(pSPFStylePkg, bl);
    }

    protected void onSyncIndexEntities(PSPFStylePkg pSPFStylePkg, boolean bl) throws Exception {
        super.onSyncIndexEntities(pSPFStylePkg, bl);
    }

    public Object getDataContextValue(PSPFStylePkg pSPFStylePkg, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null) {
            // empty if block
        }
        if ((object = super.getDataContextValue(pSPFStylePkg, string, iDataContextParam)) != null) {
            return object;
        }
        PSPFStyle pSPFStyle = pSPFStylePkg.getPSPFStyle();
        if (pSPFStyle != null && pSPFStyle.contains(string)) {
            return pSPFStyle.get(string);
        }
        return null;
    }

    protected void onExportMajorModel(PSPFStylePkg pSPFStylePkg, ArrayList<JSONObject> arrayList, int n) throws Exception {
        super.onExportMajorModel(pSPFStylePkg, arrayList, n);
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
        if (StringHelper.compare((String)string, (String)"PSPFPKGID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSPFPkgId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSPFPKGNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSPFPkgName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSPFPKGVERID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSPFPkgVerId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSPFPKGVERNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSPFPkgVerName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSPFSTYLEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSPFStyleId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSPFSTYLENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSPFStyleName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSPFSTYLEPKGID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSPFStylePkgId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSPFSTYLEPKGNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSPFStylePkgName_Default(iEntity, bl, bl2);
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

    protected String onTestValueRule_PSPFPkgId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSPFPKGID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSPFPkgName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSPFPKGNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSPFPkgVerId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSPFPKGVERID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSPFPkgVerName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSPFPKGVERNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSPFStyleId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSPFSTYLEID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSPFStyleName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSPFSTYLENAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSPFStylePkgId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSPFSTYLEPKGID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSPFStylePkgName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSPFSTYLEPKGNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
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

    protected boolean onMergeChild(String string, String string2, PSPFStylePkg pSPFStylePkg) throws Exception {
        boolean bl = false;
        if (super.onMergeChild(string, string2, pSPFStylePkg)) {
            bl = true;
        }
        return bl;
    }

    protected void onUpdateParent(PSPFStylePkg pSPFStylePkg) throws Exception {
        super.onUpdateParent(pSPFStylePkg);
    }

    @Override
    protected void exportCurXmlModel(PSPFStylePkg pSPFStylePkg, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSPFSTYLEPKG");
        if (!bl) {
            pSPFStylePkg.setCreateDate(null);
            pSPFStylePkg.setCreateMan(null);
            pSPFStylePkg.setPSPFPkgName(null);
            pSPFStylePkg.setPSPFPkgVerName(null);
            pSPFStylePkg.setPSPFStyleName(null);
            pSPFStylePkg.setPSPFStylePkgId(null);
            pSPFStylePkg.setUpdateDate(null);
            pSPFStylePkg.setUpdateMan(null);
            super.exportCurXmlModel(pSPFStylePkg, xmlNode, bl);
        }
    }
}

