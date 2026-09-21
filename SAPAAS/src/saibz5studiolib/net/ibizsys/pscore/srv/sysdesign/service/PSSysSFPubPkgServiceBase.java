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
import net.ibizsys.pscore.srv.config.entity.PSSFPkg;
import net.ibizsys.pscore.srv.config.entity.PSSFPkgBase;
import net.ibizsys.pscore.srv.config.entity.PSSFPkgVer;
import net.ibizsys.pscore.srv.config.entity.PSSFPkgVerBase;
import net.ibizsys.pscore.srv.core.IPSDataEntityModel;
import net.ibizsys.pscore.srv.sysdesign.dao.PSSysSFPubPkgDAO;
import net.ibizsys.pscore.srv.sysdesign.demodel.PSSysSFPubPkgDEModel;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysSFPub;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysSFPubBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysSFPubPkg;
import net.ibizsys.pscore.srv.sysdevstudio.entity.PSMOSFile;
import net.ibizsys.pscore.srv.util.IPSMOSFileFilter;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSSysSFPubPkgServiceBase
extends PSCoreSysServiceBase<PSSysSFPubPkg> {
    private static final Log log = LogFactory.getLog(PSSysSFPubPkgServiceBase.class);
    public static final String DATASET_DEFAULT = "DEFAULT";
    private PSSysSFPubPkgDEModel pSSysSFPubPkgDEModel;
    private PSSysSFPubPkgDAO pSSysSFPubPkgDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.sysdesign.service.PSSysSFPubPkgService";
    }

    public PSSysSFPubPkgDEModel getPSSysSFPubPkgDEModel() {
        if (this.pSSysSFPubPkgDEModel == null) {
            try {
                this.pSSysSFPubPkgDEModel = (PSSysSFPubPkgDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.sysdesign.demodel.PSSysSFPubPkgDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSSysSFPubPkgDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSSysSFPubPkgDEModel();
    }

    public PSSysSFPubPkgDAO getPSSysSFPubPkgDAO() {
        if (this.pSSysSFPubPkgDAO == null) {
            try {
                this.pSSysSFPubPkgDAO = (PSSysSFPubPkgDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.sysdesign.dao.PSSysSFPubPkgDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSSysSFPubPkgDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSSysSFPubPkgDAO();
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

    protected void onFillParentInfo(PSSysSFPubPkg pSSysSFPubPkg, String string, String string2, String string3) throws Exception {
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSSFPUBPKG_PSSFPKGVER_PSSFPKGVERID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.config.service.PSSFPkgVerService", (SessionFactory)this.getSessionFactory());
            PSSFPkgVer pSSFPkgVer = (PSSFPkgVer)iService.getDEModel().createEntity();
            pSSFPkgVer.set("PSSFPKGVERID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSSFPkgVer);
            } else {
                iService.get((IEntity)pSSFPkgVer);
            }
            this.onFillParentInfo_PSSFPkgVer(pSSysSFPubPkg, pSSFPkgVer);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSSFPUBPKG_PSSFPKG_PSSFPKGID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.config.service.PSSFPkgService", (SessionFactory)this.getSessionFactory());
            PSSFPkg pSSFPkg = (PSSFPkg)iService.getDEModel().createEntity();
            pSSFPkg.set("PSSFPKGID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSSFPkg);
            } else {
                iService.get((IEntity)pSSFPkg);
            }
            this.onFillParentInfo_PSSFPkg(pSSysSFPubPkg, pSSFPkg);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSSFPUBPKG_PSSYSSFPUB_PSSYSSFPUBID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysSFPubService", (SessionFactory)this.getSessionFactory());
            PSSysSFPub pSSysSFPub = (PSSysSFPub)iService.getDEModel().createEntity();
            pSSysSFPub.set("PSSYSSFPUBID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSSysSFPub);
            } else {
                iService.get((IEntity)pSSysSFPub);
            }
            this.onFillParentInfo_PSSysSFPub(pSSysSFPubPkg, pSSysSFPub);
            return;
        }
        super.onFillParentInfo((IEntity)pSSysSFPubPkg, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillParentInfo_PSSFPkgVer(PSSysSFPubPkg pSSysSFPubPkg, PSSFPkgVer pSSFPkgVer) throws Exception {
        pSSysSFPubPkg.setPSSFPkgVerId(pSSFPkgVer.getPSSFPkgVerId());
        pSSysSFPubPkg.setPSSFPkgVerName(pSSFPkgVer.getPSSFPkgVerName());
    }

    protected void onFillParentInfo_PSSFPkg(PSSysSFPubPkg pSSysSFPubPkg, PSSFPkg pSSFPkg) throws Exception {
        pSSysSFPubPkg.setPSSFPkgId(pSSFPkg.getPSSFPkgId());
        pSSysSFPubPkg.setPSSFPkgName(pSSFPkg.getPSSFPkgName());
    }

    protected void onFillParentInfo_PSSysSFPub(PSSysSFPubPkg pSSysSFPubPkg, PSSysSFPub pSSysSFPub) throws Exception {
        pSSysSFPubPkg.setPSSysSFPubId(pSSysSFPub.getPSSysSFPubId());
        pSSysSFPubPkg.setPSSysSFPubName(pSSysSFPub.getPSSysSFPubName());
    }

    protected void onFillEntityFullInfo(PSSysSFPubPkg pSSysSFPubPkg, boolean bl) throws Exception {
        if (bl) {
            // empty if block
        }
        super.onFillEntityFullInfo((IEntity)pSSysSFPubPkg, bl);
        this.onFillEntityFullInfo_PSSFPkgVer(pSSysSFPubPkg, bl);
        this.onFillEntityFullInfo_PSSFPkg(pSSysSFPubPkg, bl);
        this.onFillEntityFullInfo_PSSysSFPub(pSSysSFPubPkg, bl);
    }

    protected void onFillEntityFullInfo_PSSFPkgVer(PSSysSFPubPkg pSSysSFPubPkg, boolean bl) throws Exception {
        if (pSSysSFPubPkg.isPSSFPkgVerIdDirty()) {
            if (pSSysSFPubPkg.getPSSFPkgVerId() != null) {
                if (pSSysSFPubPkg.getPSSFPkgVerId() == null || pSSysSFPubPkg.getPSSFPkgVerName() == null) {
                    PSSFPkgVer pSSFPkgVer = pSSysSFPubPkg.getPSSFPkgVer();
                    pSSysSFPubPkg.setPSSFPkgVerName(pSSFPkgVer.getPSSFPkgVerName());
                }
            } else {
                pSSysSFPubPkg.setPSSFPkgVerName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_PSSFPkg(PSSysSFPubPkg pSSysSFPubPkg, boolean bl) throws Exception {
        if (pSSysSFPubPkg.isPSSFPkgIdDirty()) {
            if (pSSysSFPubPkg.getPSSFPkgId() != null) {
                if (pSSysSFPubPkg.getPSSFPkgId() == null || pSSysSFPubPkg.getPSSFPkgName() == null) {
                    PSSFPkg pSSFPkg = pSSysSFPubPkg.getPSSFPkg();
                    pSSysSFPubPkg.setPSSFPkgName(pSSFPkg.getPSSFPkgName());
                }
            } else {
                pSSysSFPubPkg.setPSSFPkgName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_PSSysSFPub(PSSysSFPubPkg pSSysSFPubPkg, boolean bl) throws Exception {
    }

    protected void onWriteBackParent(PSSysSFPubPkg pSSysSFPubPkg, boolean bl) throws Exception {
        super.onWriteBackParent((IEntity)pSSysSFPubPkg, bl);
    }

    public ArrayList<PSSysSFPubPkg> selectByPSSFPkgVer(PSSFPkgVerBase pSSFPkgVerBase) throws Exception {
        return this.selectByPSSFPkgVer(pSSFPkgVerBase, "", -1);
    }

    public ArrayList<PSSysSFPubPkg> selectByPSSFPkgVer(PSSFPkgVerBase pSSFPkgVerBase, String string) throws Exception {
        return this.selectByPSSFPkgVer(pSSFPkgVerBase, string, -1);
    }

    public ArrayList<PSSysSFPubPkg> selectByPSSFPkgVer(PSSFPkgVerBase pSSFPkgVerBase, String string, int n) throws Exception {
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

    public ArrayList<PSSysSFPubPkg> selectByPSSFPkg(PSSFPkgBase pSSFPkgBase) throws Exception {
        return this.selectByPSSFPkg(pSSFPkgBase, "", -1);
    }

    public ArrayList<PSSysSFPubPkg> selectByPSSFPkg(PSSFPkgBase pSSFPkgBase, String string) throws Exception {
        return this.selectByPSSFPkg(pSSFPkgBase, string, -1);
    }

    public ArrayList<PSSysSFPubPkg> selectByPSSFPkg(PSSFPkgBase pSSFPkgBase, String string, int n) throws Exception {
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

    public ArrayList<PSSysSFPubPkg> selectByPSSysSFPub(PSSysSFPubBase pSSysSFPubBase) throws Exception {
        return this.selectByPSSysSFPub(pSSysSFPubBase, "", -1);
    }

    public ArrayList<PSSysSFPubPkg> selectByPSSysSFPub(PSSysSFPubBase pSSysSFPubBase, String string) throws Exception {
        return this.selectByPSSysSFPub(pSSysSFPubBase, string, -1);
    }

    public ArrayList<PSSysSFPubPkg> selectByPSSysSFPub(PSSysSFPubBase pSSysSFPubBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSSYSSFPUBID", (Object)pSSysSFPubBase.getPSSysSFPubId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSSysSFPubCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSSysSFPubCond(SelectCond selectCond) throws Exception {
    }

    public void testRemoveByPSSFPkgVer(PSSFPkgVer pSSFPkgVer) throws Exception {
    }

    public void resetPSSFPkgVer(PSSFPkgVer pSSFPkgVer) throws Exception {
        ArrayList<PSSysSFPubPkg> arrayList = this.selectByPSSFPkgVer(pSSFPkgVer);
        for (PSSysSFPubPkg pSSysSFPubPkg : arrayList) {
            PSSysSFPubPkg pSSysSFPubPkg2 = (PSSysSFPubPkg)this.getDEModel().createEntity();
            pSSysSFPubPkg2.setPSSysSFPubPkgId(pSSysSFPubPkg.getPSSysSFPubPkgId());
            pSSysSFPubPkg2.setPSSFPkgVerId(null);
            this.update(pSSysSFPubPkg2);
        }
    }

    public void removeByPSSFPkgVer(PSSFPkgVer pSSFPkgVer) throws Exception {
        final PSSFPkgVer pSSFPkgVer2 = pSSFPkgVer;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysSFPubPkgServiceBase.this.onBeforeRemoveByPSSFPkgVer(pSSFPkgVer2);
                PSSysSFPubPkgServiceBase.this.internalRemoveByPSSFPkgVer(pSSFPkgVer2);
                PSSysSFPubPkgServiceBase.this.onAfterRemoveByPSSFPkgVer(pSSFPkgVer2);
            }
        });
    }

    protected void onBeforeRemoveByPSSFPkgVer(PSSFPkgVer pSSFPkgVer) throws Exception {
    }

    protected void internalRemoveByPSSFPkgVer(PSSFPkgVer pSSFPkgVer) throws Exception {
        ArrayList<PSSysSFPubPkg> arrayList = this.selectByPSSFPkgVer(pSSFPkgVer);
        this.onBeforeRemoveByPSSFPkgVer(pSSFPkgVer, arrayList);
        for (PSSysSFPubPkg pSSysSFPubPkg : arrayList) {
            this.remove((IEntity)pSSysSFPubPkg);
        }
        this.onAfterRemoveByPSSFPkgVer(pSSFPkgVer, arrayList);
    }

    protected void onAfterRemoveByPSSFPkgVer(PSSFPkgVer pSSFPkgVer) throws Exception {
    }

    protected void onBeforeRemoveByPSSFPkgVer(PSSFPkgVer pSSFPkgVer, ArrayList<PSSysSFPubPkg> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSFPkgVer(PSSFPkgVer pSSFPkgVer, ArrayList<PSSysSFPubPkg> arrayList) throws Exception {
    }

    public void testRemoveByPSSFPkg(PSSFPkg pSSFPkg) throws Exception {
    }

    public void resetPSSFPkg(PSSFPkg pSSFPkg) throws Exception {
        ArrayList<PSSysSFPubPkg> arrayList = this.selectByPSSFPkg(pSSFPkg);
        for (PSSysSFPubPkg pSSysSFPubPkg : arrayList) {
            PSSysSFPubPkg pSSysSFPubPkg2 = (PSSysSFPubPkg)this.getDEModel().createEntity();
            pSSysSFPubPkg2.setPSSysSFPubPkgId(pSSysSFPubPkg.getPSSysSFPubPkgId());
            pSSysSFPubPkg2.setPSSFPkgId(null);
            this.update(pSSysSFPubPkg2);
        }
    }

    public void removeByPSSFPkg(PSSFPkg pSSFPkg) throws Exception {
        final PSSFPkg pSSFPkg2 = pSSFPkg;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysSFPubPkgServiceBase.this.onBeforeRemoveByPSSFPkg(pSSFPkg2);
                PSSysSFPubPkgServiceBase.this.internalRemoveByPSSFPkg(pSSFPkg2);
                PSSysSFPubPkgServiceBase.this.onAfterRemoveByPSSFPkg(pSSFPkg2);
            }
        });
    }

    protected void onBeforeRemoveByPSSFPkg(PSSFPkg pSSFPkg) throws Exception {
    }

    protected void internalRemoveByPSSFPkg(PSSFPkg pSSFPkg) throws Exception {
        ArrayList<PSSysSFPubPkg> arrayList = this.selectByPSSFPkg(pSSFPkg);
        this.onBeforeRemoveByPSSFPkg(pSSFPkg, arrayList);
        for (PSSysSFPubPkg pSSysSFPubPkg : arrayList) {
            this.remove((IEntity)pSSysSFPubPkg);
        }
        this.onAfterRemoveByPSSFPkg(pSSFPkg, arrayList);
    }

    protected void onAfterRemoveByPSSFPkg(PSSFPkg pSSFPkg) throws Exception {
    }

    protected void onBeforeRemoveByPSSFPkg(PSSFPkg pSSFPkg, ArrayList<PSSysSFPubPkg> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSFPkg(PSSFPkg pSSFPkg, ArrayList<PSSysSFPubPkg> arrayList) throws Exception {
    }

    public void testRemoveByPSSysSFPub(PSSysSFPub pSSysSFPub) throws Exception {
    }

    public void resetPSSysSFPub(PSSysSFPub pSSysSFPub) throws Exception {
        ArrayList<PSSysSFPubPkg> arrayList = this.selectByPSSysSFPub(pSSysSFPub);
        for (PSSysSFPubPkg pSSysSFPubPkg : arrayList) {
            PSSysSFPubPkg pSSysSFPubPkg2 = (PSSysSFPubPkg)this.getDEModel().createEntity();
            pSSysSFPubPkg2.setPSSysSFPubPkgId(pSSysSFPubPkg.getPSSysSFPubPkgId());
            pSSysSFPubPkg2.setPSSysSFPubId(null);
            this.update(pSSysSFPubPkg2);
        }
    }

    public void removeByPSSysSFPub(PSSysSFPub pSSysSFPub) throws Exception {
        final PSSysSFPub pSSysSFPub2 = pSSysSFPub;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysSFPubPkgServiceBase.this.onBeforeRemoveByPSSysSFPub(pSSysSFPub2);
                PSSysSFPubPkgServiceBase.this.internalRemoveByPSSysSFPub(pSSysSFPub2);
                PSSysSFPubPkgServiceBase.this.onAfterRemoveByPSSysSFPub(pSSysSFPub2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysSFPub(PSSysSFPub pSSysSFPub) throws Exception {
    }

    protected void internalRemoveByPSSysSFPub(PSSysSFPub pSSysSFPub) throws Exception {
        ArrayList<PSSysSFPubPkg> arrayList = this.selectByPSSysSFPub(pSSysSFPub);
        this.onBeforeRemoveByPSSysSFPub(pSSysSFPub, arrayList);
        for (PSSysSFPubPkg pSSysSFPubPkg : arrayList) {
            this.remove((IEntity)pSSysSFPubPkg);
        }
        this.onAfterRemoveByPSSysSFPub(pSSysSFPub, arrayList);
    }

    protected void onAfterRemoveByPSSysSFPub(PSSysSFPub pSSysSFPub) throws Exception {
    }

    protected void onBeforeRemoveByPSSysSFPub(PSSysSFPub pSSysSFPub, ArrayList<PSSysSFPubPkg> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysSFPub(PSSysSFPub pSSysSFPub, ArrayList<PSSysSFPubPkg> arrayList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(PSSysSFPubPkg pSSysSFPubPkg) throws Exception {
        super.onBeforeRemove(pSSysSFPubPkg);
    }

    protected void replaceParentInfo(PSSysSFPubPkg pSSysSFPubPkg, CloneSession cloneSession) throws Exception {
        IEntity iEntity;
        super.replaceParentInfo((IEntity)pSSysSFPubPkg, cloneSession);
        if (pSSysSFPubPkg.getPSSFPkgVerId() != null && (iEntity = cloneSession.getEntity("PSSFPKGVER", (Object)pSSysSFPubPkg.getPSSFPkgVerId())) != null) {
            this.onFillParentInfo_PSSFPkgVer(pSSysSFPubPkg, (PSSFPkgVer)iEntity);
        }
        if (pSSysSFPubPkg.getPSSFPkgId() != null && (iEntity = cloneSession.getEntity("PSSFPKG", (Object)pSSysSFPubPkg.getPSSFPkgId())) != null) {
            this.onFillParentInfo_PSSFPkg(pSSysSFPubPkg, (PSSFPkg)iEntity);
        }
        if (pSSysSFPubPkg.getPSSysSFPubId() != null && (iEntity = cloneSession.getEntity("PSSYSSFPUB", (Object)pSSysSFPubPkg.getPSSysSFPubId())) != null) {
            this.onFillParentInfo_PSSysSFPub(pSSysSFPubPkg, (PSSysSFPub)iEntity);
        }
    }

    protected void onRemoveEntityUncopyValues(PSSysSFPubPkg pSSysSFPubPkg, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues((IEntity)pSSysSFPubPkg, bl);
    }

    protected void onCheckEntity(boolean bl, PSSysSFPubPkg pSSysSFPubPkg, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_Memo(bl, pSSysSFPubPkg, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_OrderValue(bl, pSSysSFPubPkg, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PkgParam(bl, pSSysSFPubPkg, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PkgParam2(bl, pSSysSFPubPkg, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PkgParam3(bl, pSSysSFPubPkg, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PkgParam4(bl, pSSysSFPubPkg, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSFPkgId(bl, pSSysSFPubPkg, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSFPkgName(bl, pSSysSFPubPkg, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSFPkgVerId(bl, pSSysSFPubPkg, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSFPkgVerName(bl, pSSysSFPubPkg, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysSFPubId(bl, pSSysSFPubPkg, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysSFPubPkgId(bl, pSSysSFPubPkg, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysSFPubPkgName(bl, pSSysSFPubPkg, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserCat(bl, pSSysSFPubPkg, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag(bl, pSSysSFPubPkg, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag2(bl, pSSysSFPubPkg, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag3(bl, pSSysSFPubPkg, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag4(bl, pSSysSFPubPkg, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, (IEntity)pSSysSFPubPkg, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_Memo(boolean bl, PSSysSFPubPkg pSSysSFPubPkg, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysSFPubPkg.isMemoDirty() : !pSSysSFPubPkg.isMemoDirty()) {
            return null;
        }
        String string = pSSysSFPubPkg.getMemo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Memo_Default((IEntity)pSSysSFPubPkg, bl2, bl3);
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

    protected EntityFieldError onCheckField_OrderValue(boolean bl, PSSysSFPubPkg pSSysSFPubPkg, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysSFPubPkg.isOrderValueDirty() : !pSSysSFPubPkg.isOrderValueDirty()) {
            return null;
        }
        Integer n = pSSysSFPubPkg.getOrderValue();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_OrderValue_Default((IEntity)pSSysSFPubPkg, bl2, bl3);
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

    protected EntityFieldError onCheckField_PkgParam(boolean bl, PSSysSFPubPkg pSSysSFPubPkg, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysSFPubPkg.isPkgParamDirty() : !pSSysSFPubPkg.isPkgParamDirty()) {
            return null;
        }
        String string = pSSysSFPubPkg.getPkgParam();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PkgParam_Default((IEntity)pSSysSFPubPkg, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PKGPARAM");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PkgParam2(boolean bl, PSSysSFPubPkg pSSysSFPubPkg, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysSFPubPkg.isPkgParam2Dirty() : !pSSysSFPubPkg.isPkgParam2Dirty()) {
            return null;
        }
        String string = pSSysSFPubPkg.getPkgParam2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PkgParam2_Default((IEntity)pSSysSFPubPkg, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PKGPARAM2");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PkgParam3(boolean bl, PSSysSFPubPkg pSSysSFPubPkg, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysSFPubPkg.isPkgParam3Dirty() : !pSSysSFPubPkg.isPkgParam3Dirty()) {
            return null;
        }
        String string = pSSysSFPubPkg.getPkgParam3();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PkgParam3_Default((IEntity)pSSysSFPubPkg, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PKGPARAM3");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PkgParam4(boolean bl, PSSysSFPubPkg pSSysSFPubPkg, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysSFPubPkg.isPkgParam4Dirty() : !pSSysSFPubPkg.isPkgParam4Dirty()) {
            return null;
        }
        String string = pSSysSFPubPkg.getPkgParam4();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PkgParam4_Default((IEntity)pSSysSFPubPkg, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PKGPARAM4");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSFPkgId(boolean bl, PSSysSFPubPkg pSSysSFPubPkg, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysSFPubPkg.isPSSFPkgIdDirty() : !pSSysSFPubPkg.isPSSFPkgIdDirty()) {
            return null;
        }
        String string = pSSysSFPubPkg.getPSSFPkgId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSFPkgId_Default((IEntity)pSSysSFPubPkg, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSFPKGID");
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
                string3 = "PSSYSSFPUBID";
                String string4 = this.checkFieldDupRule(this.getPSSysSFPubPkgDEModel(), "PSSFPKGID", string3, pSSysSFPubPkg, bl2, bl3);
                if (!StringHelper.isNullOrEmpty((String)string4)) {
                    EntityFieldError entityFieldError = new EntityFieldError();
                    entityFieldError.setFieldName("PSSFPKGID");
                    entityFieldError.setErrorType(3);
                    entityFieldError.setErrorInfo(string4);
                    return entityFieldError;
                }
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSFPkgName(boolean bl, PSSysSFPubPkg pSSysSFPubPkg, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysSFPubPkg.isPSSFPkgNameDirty() : !pSSysSFPubPkg.isPSSFPkgNameDirty()) {
            return null;
        }
        String string = pSSysSFPubPkg.getPSSFPkgName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSFPkgName_Default((IEntity)pSSysSFPubPkg, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSFPKGNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSFPkgVerId(boolean bl, PSSysSFPubPkg pSSysSFPubPkg, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysSFPubPkg.isPSSFPkgVerIdDirty() : !pSSysSFPubPkg.isPSSFPkgVerIdDirty()) {
            return null;
        }
        String string = pSSysSFPubPkg.getPSSFPkgVerId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSFPkgVerId_Default((IEntity)pSSysSFPubPkg, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSSFPkgVerName(boolean bl, PSSysSFPubPkg pSSysSFPubPkg, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysSFPubPkg.isPSSFPkgVerNameDirty() : !pSSysSFPubPkg.isPSSFPkgVerNameDirty()) {
            return null;
        }
        String string = pSSysSFPubPkg.getPSSFPkgVerName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSFPkgVerName_Default((IEntity)pSSysSFPubPkg, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSFPKGVERNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSysSFPubId(boolean bl, PSSysSFPubPkg pSSysSFPubPkg, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysSFPubPkg.isPSSysSFPubIdDirty() && !bl2 : !pSSysSFPubPkg.isPSSysSFPubIdDirty()) {
            return null;
        }
        String string = pSSysSFPubPkg.getPSSysSFPubId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSSFPUBID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysSFPubId_Default((IEntity)pSSysSFPubPkg, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSSFPUBID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSysSFPubPkgId(boolean bl, PSSysSFPubPkg pSSysSFPubPkg, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysSFPubPkg.isPSSysSFPubPkgIdDirty() && !bl2 : !pSSysSFPubPkg.isPSSysSFPubPkgIdDirty()) {
            return null;
        }
        String string = pSSysSFPubPkg.getPSSysSFPubPkgId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSSFPUBPKGID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysSFPubPkgId_Default((IEntity)pSSysSFPubPkg, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSSFPUBPKGID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSysSFPubPkgName(boolean bl, PSSysSFPubPkg pSSysSFPubPkg, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysSFPubPkg.isPSSysSFPubPkgNameDirty() && !bl2 : !pSSysSFPubPkg.isPSSysSFPubPkgNameDirty()) {
            return null;
        }
        String string = pSSysSFPubPkg.getPSSysSFPubPkgName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSSFPUBPKGNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysSFPubPkgName_Default((IEntity)pSSysSFPubPkg, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSSFPUBPKGNAME");
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
                string3 = "PSSYSSFPUBID";
                String string4 = this.checkFieldDupRule(this.getPSSysSFPubPkgDEModel(), "PSSYSSFPUBPKGNAME", string3, pSSysSFPubPkg, bl2, bl3);
                if (!StringHelper.isNullOrEmpty((String)string4)) {
                    EntityFieldError entityFieldError = new EntityFieldError();
                    entityFieldError.setFieldName("PSSYSSFPUBPKGNAME");
                    entityFieldError.setErrorType(3);
                    entityFieldError.setErrorInfo(string4);
                    return entityFieldError;
                }
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_UserCat(boolean bl, PSSysSFPubPkg pSSysSFPubPkg, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysSFPubPkg.isUserCatDirty() : !pSSysSFPubPkg.isUserCatDirty()) {
            return null;
        }
        String string = pSSysSFPubPkg.getUserCat();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserCat_Default((IEntity)pSSysSFPubPkg, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag(boolean bl, PSSysSFPubPkg pSSysSFPubPkg, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysSFPubPkg.isUserTagDirty() : !pSSysSFPubPkg.isUserTagDirty()) {
            return null;
        }
        String string = pSSysSFPubPkg.getUserTag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag_Default((IEntity)pSSysSFPubPkg, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag2(boolean bl, PSSysSFPubPkg pSSysSFPubPkg, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysSFPubPkg.isUserTag2Dirty() : !pSSysSFPubPkg.isUserTag2Dirty()) {
            return null;
        }
        String string = pSSysSFPubPkg.getUserTag2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag2_Default((IEntity)pSSysSFPubPkg, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag3(boolean bl, PSSysSFPubPkg pSSysSFPubPkg, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysSFPubPkg.isUserTag3Dirty() : !pSSysSFPubPkg.isUserTag3Dirty()) {
            return null;
        }
        String string = pSSysSFPubPkg.getUserTag3();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag3_Default((IEntity)pSSysSFPubPkg, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag4(boolean bl, PSSysSFPubPkg pSSysSFPubPkg, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysSFPubPkg.isUserTag4Dirty() : !pSSysSFPubPkg.isUserTag4Dirty()) {
            return null;
        }
        String string = pSSysSFPubPkg.getUserTag4();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag4_Default((IEntity)pSSysSFPubPkg, bl2, bl3);
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

    protected void onSyncEntity(PSSysSFPubPkg pSSysSFPubPkg, boolean bl) throws Exception {
        super.onSyncEntity((IEntity)pSSysSFPubPkg, bl);
    }

    protected void onSyncIndexEntities(PSSysSFPubPkg pSSysSFPubPkg, boolean bl) throws Exception {
        super.onSyncIndexEntities((IEntity)pSSysSFPubPkg, bl);
    }

    public Object getDataContextValue(PSSysSFPubPkg pSSysSFPubPkg, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null) {
            // empty if block
        }
        if ((object = super.getDataContextValue((IEntity)pSSysSFPubPkg, string, iDataContextParam)) != null) {
            return object;
        }
        return null;
    }

    protected void onExportMajorModel(PSSysSFPubPkg pSSysSFPubPkg, ArrayList<JSONObject> arrayList, int n) throws Exception {
        super.onExportMajorModel((IEntity)pSSysSFPubPkg, arrayList, n);
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
        if (StringHelper.compare((String)string, (String)"PKGPARAM", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PkgParam_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PKGPARAM2", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PkgParam2_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PKGPARAM3", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PkgParam3_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PKGPARAM4", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PkgParam4_Default(iEntity, bl, bl2);
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
        if (StringHelper.compare((String)string, (String)"PSSYSSFPUBID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysSFPubId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSSFPUBNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysSFPubName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSSFPUBPKGID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysSFPubPkgId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSSFPUBPKGNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysSFPubPkgName_Default(iEntity, bl, bl2);
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
            if (this.checkFieldStringLengthRule("MEMO", iEntity, bl2, null, false, 4000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[4000]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[4000]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_OrderValue_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_PkgParam_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PKGPARAM", iEntity, bl2, null, false, 4000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[4000]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[4000]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PkgParam2_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PKGPARAM2", iEntity, bl2, null, false, 1000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1000]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1000]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PkgParam3_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PKGPARAM3", iEntity, bl2, null, false, 1000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1000]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1000]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PkgParam4_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PKGPARAM4", iEntity, bl2, null, false, 1000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1000]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1000]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
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

    protected String onTestValueRule_PSSysSFPubId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSSFPUBID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysSFPubName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSSFPUBNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysSFPubPkgId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSSFPUBPKGID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysSFPubPkgName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSSFPUBPKGNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
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

    @Override
    protected boolean isPrepareLastForUpdate() {
        return true;
    }

    protected boolean onMergeChild(String string, String string2, PSSysSFPubPkg pSSysSFPubPkg) throws Exception {
        boolean bl = false;
        if (super.onMergeChild(string, string2, (IEntity)pSSysSFPubPkg)) {
            bl = true;
        }
        return bl;
    }

    protected void onUpdateParent(PSSysSFPubPkg pSSysSFPubPkg) throws Exception {
        Object object = pSSysSFPubPkg.get("PSSYSSFPUBID");
        if (object != null) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysSFPubService", (SessionFactory)this.getSessionFactory());
            iService.mergeChild("DER1N", "DER1N_PSSYSSFPUBPKG_PSSYSSFPUB_PSSYSSFPUBID", object);
        }
        super.onUpdateParent((IEntity)pSSysSFPubPkg);
    }

    protected boolean isNeedUpdateParent() {
        return true;
    }

    @Override
    protected void exportCurXmlModel(PSSysSFPubPkg pSSysSFPubPkg, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSSYSSFPUBPKG");
        if (!bl) {
            pSSysSFPubPkg.setCreateDate(null);
            pSSysSFPubPkg.setCreateMan(null);
            pSSysSFPubPkg.setPSSysSFPubPkgId(null);
            pSSysSFPubPkg.setUpdateDate(null);
            pSSysSFPubPkg.setUpdateMan(null);
            super.exportCurXmlModel(pSSysSFPubPkg, xmlNode, bl);
        }
    }

    @Override
    public ObjectNode fillModelV2(ObjectNode objectNode, PSSysSFPubPkg pSSysSFPubPkg, String string) throws Exception {
        objectNode = super.fillModelV2(objectNode, pSSysSFPubPkg, string);
        return objectNode;
    }

    @Override
    public String getModelV2ResScope(IEntity iEntity) throws Exception {
        String string = null;
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSSYSSFPUBID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return StringHelper.format((String)"PSSYSSFPUB#%1$s", (Object)string);
        }
        return super.getModelV2ResScope(iEntity);
    }

    @Override
    public String getModelV2ResScopeDER(IEntity iEntity) throws Exception {
        String string = null;
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSSYSSFPUBID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return "DER1N_PSSYSSFPUBPKG_PSSYSSFPUB_PSSYSSFPUBID";
        }
        return super.getModelV2ResScopeDER(iEntity);
    }

    @Override
    public String getModelV2ResScopeText(IEntity iEntity) throws Exception {
        String string = null;
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSSYSSFPUBID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return DataObject.getStringValue((IDataObject)iEntity, (String)"PSSYSSFPUBNAME", null);
        }
        return super.getModelV2ResScopeText(iEntity);
    }

    @Override
    public boolean setModelV2ResScope(IEntity iEntity, String string, String string2) throws Exception {
        if (StringHelper.compare((String)string, (String)"PSSYSSFPUB", (boolean)true) == 0) {
            iEntity.set("PSSYSSFPUBID", (Object)string2);
            return true;
        }
        return super.setModelV2ResScope(iEntity, string, string2);
    }

    @Override
    public String[] getModelV2ResScopeFields() throws Exception {
        return new String[]{"PSSYSSFPUBID"};
    }

    @Override
    public String getModelV2Tag(PSSysSFPubPkg pSSysSFPubPkg) {
        if (!StringHelper.isNullOrEmpty((String)pSSysSFPubPkg.getPSSysSFPubPkgName())) {
            return pSSysSFPubPkg.getPSSysSFPubPkgName();
        }
        return super.getModelV2Tag(pSSysSFPubPkg);
    }

    @Override
    public boolean setModelV2Tag(PSSysSFPubPkg pSSysSFPubPkg, String string) {
        pSSysSFPubPkg.setPSSysSFPubPkgName(string);
        return true;
    }

    @Override
    public Map<String, String> getListDRDataFolderFields(Map<String, String> map, PSMOSFile pSMOSFile, IPSMOSFileFilter iPSMOSFileFilter) throws Exception {
        if (map == null) {
            map = new HashMap<String, String>();
        }
        map.put("PSSYSSFPUBPKGNAME", "");
        map.put("PSSYSSFPUBID", "");
        return super.getListDRDataFolderFields(map, pSMOSFile, iPSMOSFileFilter);
    }

    @Override
    public boolean getModelV2Entity(PSSysSFPubPkg pSSysSFPubPkg, String string) throws Exception {
        SimpleEntity simpleEntity = new SimpleEntity();
        pSSysSFPubPkg.copyTo((IDataObject)simpleEntity, false);
        simpleEntity.copyTo((IDataObject)pSSysSFPubPkg, true);
        pSSysSFPubPkg.set("PSSYSSFPUBPKGNAME", string);
        if (this.select(pSSysSFPubPkg, true)) {
            return true;
        }
        simpleEntity.copyTo((IDataObject)pSSysSFPubPkg, true);
        return super.getModelV2Entity(pSSysSFPubPkg, string);
    }

    @Override
    protected boolean testCompileCurModelV2(PSSysSFPubPkg pSSysSFPubPkg, ObjectNode objectNode, String string, String string2, int n) throws Exception {
        if (n == 1) {
            return false;
        }
        return super.testCompileCurModelV2(pSSysSFPubPkg, objectNode, string, string2, n);
    }
}

