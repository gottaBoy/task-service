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
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.xml.XmlNode;
import net.ibizsys.pscore.srv.PSCoreSysServiceBase;
import net.ibizsys.pscore.srv.config.entity.PSPF;
import net.ibizsys.pscore.srv.config.entity.PSPFBase;
import net.ibizsys.pscore.srv.config.entity.PSPFStyle;
import net.ibizsys.pscore.srv.config.entity.PSPFStyleBase;
import net.ibizsys.pscore.srv.config.entity.PSSF;
import net.ibizsys.pscore.srv.config.entity.PSSFBase;
import net.ibizsys.pscore.srv.config.entity.PSSFStyle;
import net.ibizsys.pscore.srv.config.entity.PSSFStyleBase;
import net.ibizsys.pscore.srv.core.IPSDataEntityModel;
import net.ibizsys.pscore.srv.devcenter.entity.PSDCCodeSnippet;
import net.ibizsys.pscore.srv.devcenter.entity.PSDCCodeSnippetBase;
import net.ibizsys.pscore.srv.sysdesign.dao.PSSysCodeSnippetDAO;
import net.ibizsys.pscore.srv.sysdesign.demodel.PSSysCodeSnippetDEModel;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysCodeSnippet;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSystem;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSystemBase;
import net.ibizsys.pscore.srv.sysdevstudio.entity.PSMOSFile;
import net.ibizsys.pscore.srv.util.IPSMOSFileFilter;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSSysCodeSnippetServiceBase
extends PSCoreSysServiceBase<PSSysCodeSnippet> {
    private static final Log log = LogFactory.getLog(PSSysCodeSnippetServiceBase.class);
    public static final String DATASET_DEFAULT = "DEFAULT";
    private PSSysCodeSnippetDEModel pSSysCodeSnippetDEModel;
    private PSSysCodeSnippetDAO pSSysCodeSnippetDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.sysdesign.service.PSSysCodeSnippetService";
    }

    public PSSysCodeSnippetDEModel getPSSysCodeSnippetDEModel() {
        if (this.pSSysCodeSnippetDEModel == null) {
            try {
                this.pSSysCodeSnippetDEModel = (PSSysCodeSnippetDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.sysdesign.demodel.PSSysCodeSnippetDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSSysCodeSnippetDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSSysCodeSnippetDEModel();
    }

    public PSSysCodeSnippetDAO getPSSysCodeSnippetDAO() {
        if (this.pSSysCodeSnippetDAO == null) {
            try {
                this.pSSysCodeSnippetDAO = (PSSysCodeSnippetDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.sysdesign.dao.PSSysCodeSnippetDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSSysCodeSnippetDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSSysCodeSnippetDAO();
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

    protected void onFillParentInfo(PSSysCodeSnippet pSSysCodeSnippet, String string, String string2, String string3) throws Exception {
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSCODESNIPPET_PSDCCODESNIPPET_PSDCCODESNIPPETID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.devcenter.service.PSDCCodeSnippetService", (SessionFactory)this.getSessionFactory());
            PSDCCodeSnippet pSDCCodeSnippet = (PSDCCodeSnippet)iService.getDEModel().createEntity();
            pSDCCodeSnippet.set("PSDCCODESNIPPETID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDCCodeSnippet);
            } else {
                iService.get(pSDCCodeSnippet);
            }
            this.onFillParentInfo_PSDCCodeSnippet(pSSysCodeSnippet, pSDCCodeSnippet);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSCODESNIPPET_PSPFSTYLE_PSPFSTYLEID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.config.service.PSPFStyleService", (SessionFactory)this.getSessionFactory());
            PSPFStyle pSPFStyle = (PSPFStyle)iService.getDEModel().createEntity();
            pSPFStyle.set("PSPFSTYLEID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSPFStyle);
            } else {
                iService.get(pSPFStyle);
            }
            this.onFillParentInfo_PSPFStyle(pSSysCodeSnippet, pSPFStyle);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSCODESNIPPET_PSPF_PSPFID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.config.service.PSPFService", (SessionFactory)this.getSessionFactory());
            PSPF pSPF = (PSPF)iService.getDEModel().createEntity();
            pSPF.set("PSPFID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSPF);
            } else {
                iService.get(pSPF);
            }
            this.onFillParentInfo_PSPF(pSSysCodeSnippet, pSPF);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSCODESNIPPET_PSSFSTYLE_PSSFSTYLEID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.config.service.PSSFStyleService", (SessionFactory)this.getSessionFactory());
            PSSFStyle pSSFStyle = (PSSFStyle)iService.getDEModel().createEntity();
            pSSFStyle.set("PSSFSTYLEID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSSFStyle);
            } else {
                iService.get(pSSFStyle);
            }
            this.onFillParentInfo_PSSFStyle(pSSysCodeSnippet, pSSFStyle);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSCODESNIPPET_PSSF_PSSFID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.config.service.PSSFService", (SessionFactory)this.getSessionFactory());
            PSSF pSSF = (PSSF)iService.getDEModel().createEntity();
            pSSF.set("PSSFID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSSF);
            } else {
                iService.get(pSSF);
            }
            this.onFillParentInfo_PSSF(pSSysCodeSnippet, pSSF);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSCODESNIPPET_PSSYSTEM_PSSYSTEMID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSystemService", (SessionFactory)this.getSessionFactory());
            PSSystem pSSystem = (PSSystem)iService.getDEModel().createEntity();
            pSSystem.set("PSSYSTEMID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSSystem);
            } else {
                iService.get(pSSystem);
            }
            this.onFillParentInfo_PSSystem(pSSysCodeSnippet, pSSystem);
            return;
        }
        super.onFillParentInfo(pSSysCodeSnippet, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillParentInfo_PSDCCodeSnippet(PSSysCodeSnippet pSSysCodeSnippet, PSDCCodeSnippet pSDCCodeSnippet) throws Exception {
        pSSysCodeSnippet.setPSDCCodeSnippetId(pSDCCodeSnippet.getPSDCCodeSnippetId());
        pSSysCodeSnippet.setPSDCCodeSnippetName(pSDCCodeSnippet.getPSDCCodeSnippetName());
    }

    protected void onFillParentInfo_PSPFStyle(PSSysCodeSnippet pSSysCodeSnippet, PSPFStyle pSPFStyle) throws Exception {
        pSSysCodeSnippet.setPSPFStyleId(pSPFStyle.getPSPFStyleId());
        pSSysCodeSnippet.setPSPFStyleName(pSPFStyle.getPSPFStyleName());
    }

    protected void onFillParentInfo_PSPF(PSSysCodeSnippet pSSysCodeSnippet, PSPF pSPF) throws Exception {
        pSSysCodeSnippet.setPSPFId(pSPF.getPSPFId());
        pSSysCodeSnippet.setPSPFName(pSPF.getPSPFName());
    }

    protected void onFillParentInfo_PSSFStyle(PSSysCodeSnippet pSSysCodeSnippet, PSSFStyle pSSFStyle) throws Exception {
        pSSysCodeSnippet.setPSSFStyleId(pSSFStyle.getPSSFStyleId());
        pSSysCodeSnippet.setPSSFStyleName(pSSFStyle.getPSSFStyleName());
    }

    protected void onFillParentInfo_PSSF(PSSysCodeSnippet pSSysCodeSnippet, PSSF pSSF) throws Exception {
        pSSysCodeSnippet.setPSSFId(pSSF.getPSSFId());
        pSSysCodeSnippet.setPSSFName(pSSF.getPSSFName());
    }

    protected void onFillParentInfo_PSSystem(PSSysCodeSnippet pSSysCodeSnippet, PSSystem pSSystem) throws Exception {
        pSSysCodeSnippet.setPSSystemId(pSSystem.getPSSystemId());
        pSSysCodeSnippet.setPSSystemName(pSSystem.getPSSystemName());
    }

    protected void onFillEntityFullInfo(PSSysCodeSnippet pSSysCodeSnippet, boolean bl) throws Exception {
        if (bl && pSSysCodeSnippet.getValidFlag() == null) {
            pSSysCodeSnippet.setValidFlag((Integer)this.getDefaultValue(this.getWebContext(), "", "1", 9));
        }
        super.onFillEntityFullInfo(pSSysCodeSnippet, bl);
        this.onFillEntityFullInfo_PSDCCodeSnippet(pSSysCodeSnippet, bl);
        this.onFillEntityFullInfo_PSPFStyle(pSSysCodeSnippet, bl);
        this.onFillEntityFullInfo_PSPF(pSSysCodeSnippet, bl);
        this.onFillEntityFullInfo_PSSFStyle(pSSysCodeSnippet, bl);
        this.onFillEntityFullInfo_PSSF(pSSysCodeSnippet, bl);
        this.onFillEntityFullInfo_PSSystem(pSSysCodeSnippet, bl);
    }

    protected void onFillEntityFullInfo_PSDCCodeSnippet(PSSysCodeSnippet pSSysCodeSnippet, boolean bl) throws Exception {
        if (pSSysCodeSnippet.isPSDCCodeSnippetIdDirty()) {
            if (pSSysCodeSnippet.getPSDCCodeSnippetId() != null) {
                if (pSSysCodeSnippet.getPSDCCodeSnippetId() == null || pSSysCodeSnippet.getPSDCCodeSnippetName() == null) {
                    PSDCCodeSnippet pSDCCodeSnippet = pSSysCodeSnippet.getPSDCCodeSnippet();
                    pSSysCodeSnippet.setPSDCCodeSnippetName(pSDCCodeSnippet.getPSDCCodeSnippetName());
                }
            } else {
                pSSysCodeSnippet.setPSDCCodeSnippetName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_PSPFStyle(PSSysCodeSnippet pSSysCodeSnippet, boolean bl) throws Exception {
        if (pSSysCodeSnippet.isPSPFStyleIdDirty()) {
            if (pSSysCodeSnippet.getPSPFStyleId() != null) {
                if (pSSysCodeSnippet.getPSPFStyleId() == null || pSSysCodeSnippet.getPSPFStyleName() == null) {
                    PSPFStyle pSPFStyle = pSSysCodeSnippet.getPSPFStyle();
                    pSSysCodeSnippet.setPSPFStyleName(pSPFStyle.getPSPFStyleName());
                }
            } else {
                pSSysCodeSnippet.setPSPFStyleName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_PSPF(PSSysCodeSnippet pSSysCodeSnippet, boolean bl) throws Exception {
        if (pSSysCodeSnippet.isPSPFIdDirty()) {
            if (pSSysCodeSnippet.getPSPFId() != null) {
                if (pSSysCodeSnippet.getPSPFId() == null || pSSysCodeSnippet.getPSPFName() == null) {
                    PSPF pSPF = pSSysCodeSnippet.getPSPF();
                    pSSysCodeSnippet.setPSPFName(pSPF.getPSPFName());
                }
            } else {
                pSSysCodeSnippet.setPSPFName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_PSSFStyle(PSSysCodeSnippet pSSysCodeSnippet, boolean bl) throws Exception {
        if (pSSysCodeSnippet.isPSSFStyleIdDirty()) {
            if (pSSysCodeSnippet.getPSSFStyleId() != null) {
                if (pSSysCodeSnippet.getPSSFStyleId() == null || pSSysCodeSnippet.getPSSFStyleName() == null) {
                    PSSFStyle pSSFStyle = pSSysCodeSnippet.getPSSFStyle();
                    pSSysCodeSnippet.setPSSFStyleName(pSSFStyle.getPSSFStyleName());
                }
            } else {
                pSSysCodeSnippet.setPSSFStyleName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_PSSF(PSSysCodeSnippet pSSysCodeSnippet, boolean bl) throws Exception {
        if (pSSysCodeSnippet.isPSSFIdDirty()) {
            if (pSSysCodeSnippet.getPSSFId() != null) {
                if (pSSysCodeSnippet.getPSSFId() == null || pSSysCodeSnippet.getPSSFName() == null) {
                    PSSF pSSF = pSSysCodeSnippet.getPSSF();
                    pSSysCodeSnippet.setPSSFName(pSSF.getPSSFName());
                }
            } else {
                pSSysCodeSnippet.setPSSFName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_PSSystem(PSSysCodeSnippet pSSysCodeSnippet, boolean bl) throws Exception {
        if (pSSysCodeSnippet.isPSSystemIdDirty()) {
            if (pSSysCodeSnippet.getPSSystemId() != null) {
                if (pSSysCodeSnippet.getPSSystemId() == null || pSSysCodeSnippet.getPSSystemName() == null) {
                    PSSystem pSSystem = pSSysCodeSnippet.getPSSystem();
                    pSSysCodeSnippet.setPSSystemName(pSSystem.getPSSystemName());
                }
            } else {
                pSSysCodeSnippet.setPSSystemName(null);
            }
        }
    }

    protected void onWriteBackParent(PSSysCodeSnippet pSSysCodeSnippet, boolean bl) throws Exception {
        super.onWriteBackParent(pSSysCodeSnippet, bl);
    }

    public ArrayList<PSSysCodeSnippet> selectByPSDCCodeSnippet(PSDCCodeSnippetBase pSDCCodeSnippetBase) throws Exception {
        return this.selectByPSDCCodeSnippet(pSDCCodeSnippetBase, "", -1);
    }

    public ArrayList<PSSysCodeSnippet> selectByPSDCCodeSnippet(PSDCCodeSnippetBase pSDCCodeSnippetBase, String string) throws Exception {
        return this.selectByPSDCCodeSnippet(pSDCCodeSnippetBase, string, -1);
    }

    public ArrayList<PSSysCodeSnippet> selectByPSDCCodeSnippet(PSDCCodeSnippetBase pSDCCodeSnippetBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDCCODESNIPPETID", (Object)pSDCCodeSnippetBase.getPSDCCodeSnippetId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSDCCodeSnippetCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSDCCodeSnippetCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSSysCodeSnippet> selectByPSPFStyle(PSPFStyleBase pSPFStyleBase) throws Exception {
        return this.selectByPSPFStyle(pSPFStyleBase, "", -1);
    }

    public ArrayList<PSSysCodeSnippet> selectByPSPFStyle(PSPFStyleBase pSPFStyleBase, String string) throws Exception {
        return this.selectByPSPFStyle(pSPFStyleBase, string, -1);
    }

    public ArrayList<PSSysCodeSnippet> selectByPSPFStyle(PSPFStyleBase pSPFStyleBase, String string, int n) throws Exception {
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

    public ArrayList<PSSysCodeSnippet> selectByPSPF(PSPFBase pSPFBase) throws Exception {
        return this.selectByPSPF(pSPFBase, "", -1);
    }

    public ArrayList<PSSysCodeSnippet> selectByPSPF(PSPFBase pSPFBase, String string) throws Exception {
        return this.selectByPSPF(pSPFBase, string, -1);
    }

    public ArrayList<PSSysCodeSnippet> selectByPSPF(PSPFBase pSPFBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSPFID", (Object)pSPFBase.getPSPFId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSPFCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSPFCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSSysCodeSnippet> selectByPSSFStyle(PSSFStyleBase pSSFStyleBase) throws Exception {
        return this.selectByPSSFStyle(pSSFStyleBase, "", -1);
    }

    public ArrayList<PSSysCodeSnippet> selectByPSSFStyle(PSSFStyleBase pSSFStyleBase, String string) throws Exception {
        return this.selectByPSSFStyle(pSSFStyleBase, string, -1);
    }

    public ArrayList<PSSysCodeSnippet> selectByPSSFStyle(PSSFStyleBase pSSFStyleBase, String string, int n) throws Exception {
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

    public ArrayList<PSSysCodeSnippet> selectByPSSF(PSSFBase pSSFBase) throws Exception {
        return this.selectByPSSF(pSSFBase, "", -1);
    }

    public ArrayList<PSSysCodeSnippet> selectByPSSF(PSSFBase pSSFBase, String string) throws Exception {
        return this.selectByPSSF(pSSFBase, string, -1);
    }

    public ArrayList<PSSysCodeSnippet> selectByPSSF(PSSFBase pSSFBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSSFID", (Object)pSSFBase.getPSSFId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSSFCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSSFCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSSysCodeSnippet> selectByPSSystem(PSSystemBase pSSystemBase) throws Exception {
        return this.selectByPSSystem(pSSystemBase, "", -1);
    }

    public ArrayList<PSSysCodeSnippet> selectByPSSystem(PSSystemBase pSSystemBase, String string) throws Exception {
        return this.selectByPSSystem(pSSystemBase, string, -1);
    }

    public ArrayList<PSSysCodeSnippet> selectByPSSystem(PSSystemBase pSSystemBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSSYSTEMID", (Object)pSSystemBase.getPSSystemId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSSystemCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSSystemCond(SelectCond selectCond) throws Exception {
    }

    public void testRemoveByPSDCCodeSnippet(PSDCCodeSnippet pSDCCodeSnippet) throws Exception {
    }

    public void resetPSDCCodeSnippet(PSDCCodeSnippet pSDCCodeSnippet) throws Exception {
        ArrayList<PSSysCodeSnippet> arrayList = this.selectByPSDCCodeSnippet(pSDCCodeSnippet);
        for (PSSysCodeSnippet pSSysCodeSnippet : arrayList) {
            PSSysCodeSnippet pSSysCodeSnippet2 = (PSSysCodeSnippet)this.getDEModel().createEntity();
            pSSysCodeSnippet2.setPSSysCodeSnippetId(pSSysCodeSnippet.getPSSysCodeSnippetId());
            pSSysCodeSnippet2.setPSDCCodeSnippetId(null);
            this.update(pSSysCodeSnippet2);
        }
    }

    public void removeByPSDCCodeSnippet(PSDCCodeSnippet pSDCCodeSnippet) throws Exception {
        final PSDCCodeSnippet pSDCCodeSnippet2 = pSDCCodeSnippet;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysCodeSnippetServiceBase.this.onBeforeRemoveByPSDCCodeSnippet(pSDCCodeSnippet2);
                PSSysCodeSnippetServiceBase.this.internalRemoveByPSDCCodeSnippet(pSDCCodeSnippet2);
                PSSysCodeSnippetServiceBase.this.onAfterRemoveByPSDCCodeSnippet(pSDCCodeSnippet2);
            }
        });
    }

    protected void onBeforeRemoveByPSDCCodeSnippet(PSDCCodeSnippet pSDCCodeSnippet) throws Exception {
    }

    protected void internalRemoveByPSDCCodeSnippet(PSDCCodeSnippet pSDCCodeSnippet) throws Exception {
        ArrayList<PSSysCodeSnippet> arrayList = this.selectByPSDCCodeSnippet(pSDCCodeSnippet);
        this.onBeforeRemoveByPSDCCodeSnippet(pSDCCodeSnippet, arrayList);
        for (PSSysCodeSnippet pSSysCodeSnippet : arrayList) {
            this.remove(pSSysCodeSnippet);
        }
        this.onAfterRemoveByPSDCCodeSnippet(pSDCCodeSnippet, arrayList);
    }

    protected void onAfterRemoveByPSDCCodeSnippet(PSDCCodeSnippet pSDCCodeSnippet) throws Exception {
    }

    protected void onBeforeRemoveByPSDCCodeSnippet(PSDCCodeSnippet pSDCCodeSnippet, ArrayList<PSSysCodeSnippet> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDCCodeSnippet(PSDCCodeSnippet pSDCCodeSnippet, ArrayList<PSSysCodeSnippet> arrayList) throws Exception {
    }

    public void testRemoveByPSPFStyle(PSPFStyle pSPFStyle) throws Exception {
    }

    public void resetPSPFStyle(PSPFStyle pSPFStyle) throws Exception {
        ArrayList<PSSysCodeSnippet> arrayList = this.selectByPSPFStyle(pSPFStyle);
        for (PSSysCodeSnippet pSSysCodeSnippet : arrayList) {
            PSSysCodeSnippet pSSysCodeSnippet2 = (PSSysCodeSnippet)this.getDEModel().createEntity();
            pSSysCodeSnippet2.setPSSysCodeSnippetId(pSSysCodeSnippet.getPSSysCodeSnippetId());
            pSSysCodeSnippet2.setPSPFStyleId(null);
            this.update(pSSysCodeSnippet2);
        }
    }

    public void removeByPSPFStyle(PSPFStyle pSPFStyle) throws Exception {
        final PSPFStyle pSPFStyle2 = pSPFStyle;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysCodeSnippetServiceBase.this.onBeforeRemoveByPSPFStyle(pSPFStyle2);
                PSSysCodeSnippetServiceBase.this.internalRemoveByPSPFStyle(pSPFStyle2);
                PSSysCodeSnippetServiceBase.this.onAfterRemoveByPSPFStyle(pSPFStyle2);
            }
        });
    }

    protected void onBeforeRemoveByPSPFStyle(PSPFStyle pSPFStyle) throws Exception {
    }

    protected void internalRemoveByPSPFStyle(PSPFStyle pSPFStyle) throws Exception {
        ArrayList<PSSysCodeSnippet> arrayList = this.selectByPSPFStyle(pSPFStyle);
        this.onBeforeRemoveByPSPFStyle(pSPFStyle, arrayList);
        for (PSSysCodeSnippet pSSysCodeSnippet : arrayList) {
            this.remove(pSSysCodeSnippet);
        }
        this.onAfterRemoveByPSPFStyle(pSPFStyle, arrayList);
    }

    protected void onAfterRemoveByPSPFStyle(PSPFStyle pSPFStyle) throws Exception {
    }

    protected void onBeforeRemoveByPSPFStyle(PSPFStyle pSPFStyle, ArrayList<PSSysCodeSnippet> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSPFStyle(PSPFStyle pSPFStyle, ArrayList<PSSysCodeSnippet> arrayList) throws Exception {
    }

    public void testRemoveByPSPF(PSPF pSPF) throws Exception {
    }

    public void resetPSPF(PSPF pSPF) throws Exception {
        ArrayList<PSSysCodeSnippet> arrayList = this.selectByPSPF(pSPF);
        for (PSSysCodeSnippet pSSysCodeSnippet : arrayList) {
            PSSysCodeSnippet pSSysCodeSnippet2 = (PSSysCodeSnippet)this.getDEModel().createEntity();
            pSSysCodeSnippet2.setPSSysCodeSnippetId(pSSysCodeSnippet.getPSSysCodeSnippetId());
            pSSysCodeSnippet2.setPSPFId(null);
            this.update(pSSysCodeSnippet2);
        }
    }

    public void removeByPSPF(PSPF pSPF) throws Exception {
        final PSPF pSPF2 = pSPF;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysCodeSnippetServiceBase.this.onBeforeRemoveByPSPF(pSPF2);
                PSSysCodeSnippetServiceBase.this.internalRemoveByPSPF(pSPF2);
                PSSysCodeSnippetServiceBase.this.onAfterRemoveByPSPF(pSPF2);
            }
        });
    }

    protected void onBeforeRemoveByPSPF(PSPF pSPF) throws Exception {
    }

    protected void internalRemoveByPSPF(PSPF pSPF) throws Exception {
        ArrayList<PSSysCodeSnippet> arrayList = this.selectByPSPF(pSPF);
        this.onBeforeRemoveByPSPF(pSPF, arrayList);
        for (PSSysCodeSnippet pSSysCodeSnippet : arrayList) {
            this.remove(pSSysCodeSnippet);
        }
        this.onAfterRemoveByPSPF(pSPF, arrayList);
    }

    protected void onAfterRemoveByPSPF(PSPF pSPF) throws Exception {
    }

    protected void onBeforeRemoveByPSPF(PSPF pSPF, ArrayList<PSSysCodeSnippet> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSPF(PSPF pSPF, ArrayList<PSSysCodeSnippet> arrayList) throws Exception {
    }

    public void testRemoveByPSSFStyle(PSSFStyle pSSFStyle) throws Exception {
    }

    public void resetPSSFStyle(PSSFStyle pSSFStyle) throws Exception {
        ArrayList<PSSysCodeSnippet> arrayList = this.selectByPSSFStyle(pSSFStyle);
        for (PSSysCodeSnippet pSSysCodeSnippet : arrayList) {
            PSSysCodeSnippet pSSysCodeSnippet2 = (PSSysCodeSnippet)this.getDEModel().createEntity();
            pSSysCodeSnippet2.setPSSysCodeSnippetId(pSSysCodeSnippet.getPSSysCodeSnippetId());
            pSSysCodeSnippet2.setPSSFStyleId(null);
            this.update(pSSysCodeSnippet2);
        }
    }

    public void removeByPSSFStyle(PSSFStyle pSSFStyle) throws Exception {
        final PSSFStyle pSSFStyle2 = pSSFStyle;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysCodeSnippetServiceBase.this.onBeforeRemoveByPSSFStyle(pSSFStyle2);
                PSSysCodeSnippetServiceBase.this.internalRemoveByPSSFStyle(pSSFStyle2);
                PSSysCodeSnippetServiceBase.this.onAfterRemoveByPSSFStyle(pSSFStyle2);
            }
        });
    }

    protected void onBeforeRemoveByPSSFStyle(PSSFStyle pSSFStyle) throws Exception {
    }

    protected void internalRemoveByPSSFStyle(PSSFStyle pSSFStyle) throws Exception {
        ArrayList<PSSysCodeSnippet> arrayList = this.selectByPSSFStyle(pSSFStyle);
        this.onBeforeRemoveByPSSFStyle(pSSFStyle, arrayList);
        for (PSSysCodeSnippet pSSysCodeSnippet : arrayList) {
            this.remove(pSSysCodeSnippet);
        }
        this.onAfterRemoveByPSSFStyle(pSSFStyle, arrayList);
    }

    protected void onAfterRemoveByPSSFStyle(PSSFStyle pSSFStyle) throws Exception {
    }

    protected void onBeforeRemoveByPSSFStyle(PSSFStyle pSSFStyle, ArrayList<PSSysCodeSnippet> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSFStyle(PSSFStyle pSSFStyle, ArrayList<PSSysCodeSnippet> arrayList) throws Exception {
    }

    public void testRemoveByPSSF(PSSF pSSF) throws Exception {
    }

    public void resetPSSF(PSSF pSSF) throws Exception {
        ArrayList<PSSysCodeSnippet> arrayList = this.selectByPSSF(pSSF);
        for (PSSysCodeSnippet pSSysCodeSnippet : arrayList) {
            PSSysCodeSnippet pSSysCodeSnippet2 = (PSSysCodeSnippet)this.getDEModel().createEntity();
            pSSysCodeSnippet2.setPSSysCodeSnippetId(pSSysCodeSnippet.getPSSysCodeSnippetId());
            pSSysCodeSnippet2.setPSSFId(null);
            this.update(pSSysCodeSnippet2);
        }
    }

    public void removeByPSSF(PSSF pSSF) throws Exception {
        final PSSF pSSF2 = pSSF;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysCodeSnippetServiceBase.this.onBeforeRemoveByPSSF(pSSF2);
                PSSysCodeSnippetServiceBase.this.internalRemoveByPSSF(pSSF2);
                PSSysCodeSnippetServiceBase.this.onAfterRemoveByPSSF(pSSF2);
            }
        });
    }

    protected void onBeforeRemoveByPSSF(PSSF pSSF) throws Exception {
    }

    protected void internalRemoveByPSSF(PSSF pSSF) throws Exception {
        ArrayList<PSSysCodeSnippet> arrayList = this.selectByPSSF(pSSF);
        this.onBeforeRemoveByPSSF(pSSF, arrayList);
        for (PSSysCodeSnippet pSSysCodeSnippet : arrayList) {
            this.remove(pSSysCodeSnippet);
        }
        this.onAfterRemoveByPSSF(pSSF, arrayList);
    }

    protected void onAfterRemoveByPSSF(PSSF pSSF) throws Exception {
    }

    protected void onBeforeRemoveByPSSF(PSSF pSSF, ArrayList<PSSysCodeSnippet> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSF(PSSF pSSF, ArrayList<PSSysCodeSnippet> arrayList) throws Exception {
    }

    public void testRemoveByPSSystem(PSSystem pSSystem) throws Exception {
        ArrayList<PSSysCodeSnippet> arrayList = this.selectByPSSystem(pSSystem, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSTEM");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSSystem);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSCODESNIPPET_PSSYSTEM_PSSYSTEMID", "", iDataEntityModel.getName(), "PSSYSCODESNIPPET", iDataEntityModel.getDataInfo(pSSystem), arrayList.get(0)));
        }
    }

    public void resetPSSystem(PSSystem pSSystem) throws Exception {
        ArrayList<PSSysCodeSnippet> arrayList = this.selectByPSSystem(pSSystem);
        for (PSSysCodeSnippet pSSysCodeSnippet : arrayList) {
            PSSysCodeSnippet pSSysCodeSnippet2 = (PSSysCodeSnippet)this.getDEModel().createEntity();
            pSSysCodeSnippet2.setPSSysCodeSnippetId(pSSysCodeSnippet.getPSSysCodeSnippetId());
            pSSysCodeSnippet2.setPSSystemId(null);
            this.update(pSSysCodeSnippet2);
        }
    }

    public void removeByPSSystem(PSSystem pSSystem) throws Exception {
        final PSSystem pSSystem2 = pSSystem;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysCodeSnippetServiceBase.this.onBeforeRemoveByPSSystem(pSSystem2);
                PSSysCodeSnippetServiceBase.this.internalRemoveByPSSystem(pSSystem2);
                PSSysCodeSnippetServiceBase.this.onAfterRemoveByPSSystem(pSSystem2);
            }
        });
    }

    protected void onBeforeRemoveByPSSystem(PSSystem pSSystem) throws Exception {
    }

    protected void internalRemoveByPSSystem(PSSystem pSSystem) throws Exception {
        ArrayList<PSSysCodeSnippet> arrayList = this.selectByPSSystem(pSSystem);
        this.onBeforeRemoveByPSSystem(pSSystem, arrayList);
        for (PSSysCodeSnippet pSSysCodeSnippet : arrayList) {
            this.remove(pSSysCodeSnippet);
        }
        this.onAfterRemoveByPSSystem(pSSystem, arrayList);
    }

    protected void onAfterRemoveByPSSystem(PSSystem pSSystem) throws Exception {
    }

    protected void onBeforeRemoveByPSSystem(PSSystem pSSystem, ArrayList<PSSysCodeSnippet> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSystem(PSSystem pSSystem, ArrayList<PSSysCodeSnippet> arrayList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(PSSysCodeSnippet pSSysCodeSnippet) throws Exception {
        super.onBeforeRemove(pSSysCodeSnippet);
    }

    protected void replaceParentInfo(PSSysCodeSnippet pSSysCodeSnippet, CloneSession cloneSession) throws Exception {
        IEntity iEntity;
        super.replaceParentInfo(pSSysCodeSnippet, cloneSession);
        if (pSSysCodeSnippet.getPSDCCodeSnippetId() != null && (iEntity = cloneSession.getEntity("PSDCCODESNIPPET", (Object)pSSysCodeSnippet.getPSDCCodeSnippetId())) != null) {
            this.onFillParentInfo_PSDCCodeSnippet(pSSysCodeSnippet, (PSDCCodeSnippet)iEntity);
        }
        if (pSSysCodeSnippet.getPSPFStyleId() != null && (iEntity = cloneSession.getEntity("PSPFSTYLE", (Object)pSSysCodeSnippet.getPSPFStyleId())) != null) {
            this.onFillParentInfo_PSPFStyle(pSSysCodeSnippet, (PSPFStyle)iEntity);
        }
        if (pSSysCodeSnippet.getPSPFId() != null && (iEntity = cloneSession.getEntity("PSPF", (Object)pSSysCodeSnippet.getPSPFId())) != null) {
            this.onFillParentInfo_PSPF(pSSysCodeSnippet, (PSPF)iEntity);
        }
        if (pSSysCodeSnippet.getPSSFStyleId() != null && (iEntity = cloneSession.getEntity("PSSFSTYLE", (Object)pSSysCodeSnippet.getPSSFStyleId())) != null) {
            this.onFillParentInfo_PSSFStyle(pSSysCodeSnippet, (PSSFStyle)iEntity);
        }
        if (pSSysCodeSnippet.getPSSFId() != null && (iEntity = cloneSession.getEntity("PSSF", (Object)pSSysCodeSnippet.getPSSFId())) != null) {
            this.onFillParentInfo_PSSF(pSSysCodeSnippet, (PSSF)iEntity);
        }
        if (pSSysCodeSnippet.getPSSystemId() != null && (iEntity = cloneSession.getEntity("PSSYSTEM", (Object)pSSysCodeSnippet.getPSSystemId())) != null) {
            this.onFillParentInfo_PSSystem(pSSysCodeSnippet, (PSSystem)iEntity);
        }
    }

    protected void onRemoveEntityUncopyValues(PSSysCodeSnippet pSSysCodeSnippet, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues(pSSysCodeSnippet, bl);
    }

    protected void onCheckEntity(boolean bl, PSSysCodeSnippet pSSysCodeSnippet, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_CodeName(bl, pSSysCodeSnippet, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_CodeRefMode(bl, pSSysCodeSnippet, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Memo(bl, pSSysCodeSnippet, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDCCodeSnippetId(bl, pSSysCodeSnippet, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDCCodeSnippetName(bl, pSSysCodeSnippet, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSPFId(bl, pSSysCodeSnippet, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSPFName(bl, pSSysCodeSnippet, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSPFStyleId(bl, pSSysCodeSnippet, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSPFStyleName(bl, pSSysCodeSnippet, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSFId(bl, pSSysCodeSnippet, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSFName(bl, pSSysCodeSnippet, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSFStyleId(bl, pSSysCodeSnippet, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSFStyleName(bl, pSSysCodeSnippet, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysCodeSnippetId(bl, pSSysCodeSnippet, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysCodeSnippetName(bl, pSSysCodeSnippet, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSystemId(bl, pSSysCodeSnippet, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSystemName(bl, pSSysCodeSnippet, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_TemplType(bl, pSSysCodeSnippet, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserCat(bl, pSSysCodeSnippet, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag(bl, pSSysCodeSnippet, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag2(bl, pSSysCodeSnippet, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag3(bl, pSSysCodeSnippet, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag4(bl, pSSysCodeSnippet, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ValidFlag(bl, pSSysCodeSnippet, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, pSSysCodeSnippet, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_CodeName(boolean bl, PSSysCodeSnippet pSSysCodeSnippet, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysCodeSnippet.isCodeNameDirty() : !pSSysCodeSnippet.isCodeNameDirty()) {
            return null;
        }
        String string = pSSysCodeSnippet.getCodeName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_CodeName_Default(pSSysCodeSnippet, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CODENAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_CodeRefMode(boolean bl, PSSysCodeSnippet pSSysCodeSnippet, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysCodeSnippet.isCodeRefModeDirty() && !bl2 : !pSSysCodeSnippet.isCodeRefModeDirty()) {
            return null;
        }
        String string = pSSysCodeSnippet.getCodeRefMode();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CODEREFMODE");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_CodeRefMode_Default(pSSysCodeSnippet, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CODEREFMODE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Memo(boolean bl, PSSysCodeSnippet pSSysCodeSnippet, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysCodeSnippet.isMemoDirty() : !pSSysCodeSnippet.isMemoDirty()) {
            return null;
        }
        String string = pSSysCodeSnippet.getMemo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Memo_Default(pSSysCodeSnippet, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDCCodeSnippetId(boolean bl, PSSysCodeSnippet pSSysCodeSnippet, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysCodeSnippet.isPSDCCodeSnippetIdDirty() : !pSSysCodeSnippet.isPSDCCodeSnippetIdDirty()) {
            return null;
        }
        String string = pSSysCodeSnippet.getPSDCCodeSnippetId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDCCodeSnippetId_Default(pSSysCodeSnippet, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDCCODESNIPPETID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDCCodeSnippetName(boolean bl, PSSysCodeSnippet pSSysCodeSnippet, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysCodeSnippet.isPSDCCodeSnippetNameDirty() : !pSSysCodeSnippet.isPSDCCodeSnippetNameDirty()) {
            return null;
        }
        String string = pSSysCodeSnippet.getPSDCCodeSnippetName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDCCodeSnippetName_Default(pSSysCodeSnippet, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDCCODESNIPPETNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSPFId(boolean bl, PSSysCodeSnippet pSSysCodeSnippet, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysCodeSnippet.isPSPFIdDirty() : !pSSysCodeSnippet.isPSPFIdDirty()) {
            return null;
        }
        String string = pSSysCodeSnippet.getPSPFId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSPFId_Default(pSSysCodeSnippet, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSPFID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSPFName(boolean bl, PSSysCodeSnippet pSSysCodeSnippet, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysCodeSnippet.isPSPFNameDirty() : !pSSysCodeSnippet.isPSPFNameDirty()) {
            return null;
        }
        String string = pSSysCodeSnippet.getPSPFName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSPFName_Default(pSSysCodeSnippet, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSPFNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSPFStyleId(boolean bl, PSSysCodeSnippet pSSysCodeSnippet, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysCodeSnippet.isPSPFStyleIdDirty() : !pSSysCodeSnippet.isPSPFStyleIdDirty()) {
            return null;
        }
        String string = pSSysCodeSnippet.getPSPFStyleId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSPFStyleId_Default(pSSysCodeSnippet, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSPFStyleName(boolean bl, PSSysCodeSnippet pSSysCodeSnippet, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysCodeSnippet.isPSPFStyleNameDirty() : !pSSysCodeSnippet.isPSPFStyleNameDirty()) {
            return null;
        }
        String string = pSSysCodeSnippet.getPSPFStyleName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSPFStyleName_Default(pSSysCodeSnippet, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSPFSTYLENAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSFId(boolean bl, PSSysCodeSnippet pSSysCodeSnippet, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysCodeSnippet.isPSSFIdDirty() : !pSSysCodeSnippet.isPSSFIdDirty()) {
            return null;
        }
        String string = pSSysCodeSnippet.getPSSFId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSFId_Default(pSSysCodeSnippet, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSFID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSFName(boolean bl, PSSysCodeSnippet pSSysCodeSnippet, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysCodeSnippet.isPSSFNameDirty() : !pSSysCodeSnippet.isPSSFNameDirty()) {
            return null;
        }
        String string = pSSysCodeSnippet.getPSSFName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSFName_Default(pSSysCodeSnippet, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSFNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSFStyleId(boolean bl, PSSysCodeSnippet pSSysCodeSnippet, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysCodeSnippet.isPSSFStyleIdDirty() : !pSSysCodeSnippet.isPSSFStyleIdDirty()) {
            return null;
        }
        String string = pSSysCodeSnippet.getPSSFStyleId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSFStyleId_Default(pSSysCodeSnippet, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSSFStyleName(boolean bl, PSSysCodeSnippet pSSysCodeSnippet, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysCodeSnippet.isPSSFStyleNameDirty() : !pSSysCodeSnippet.isPSSFStyleNameDirty()) {
            return null;
        }
        String string = pSSysCodeSnippet.getPSSFStyleName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSFStyleName_Default(pSSysCodeSnippet, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSSysCodeSnippetId(boolean bl, PSSysCodeSnippet pSSysCodeSnippet, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysCodeSnippet.isPSSysCodeSnippetIdDirty() && !bl2 : !pSSysCodeSnippet.isPSSysCodeSnippetIdDirty()) {
            return null;
        }
        String string = pSSysCodeSnippet.getPSSysCodeSnippetId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSCODESNIPPETID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysCodeSnippetId_Default(pSSysCodeSnippet, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSCODESNIPPETID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSysCodeSnippetName(boolean bl, PSSysCodeSnippet pSSysCodeSnippet, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysCodeSnippet.isPSSysCodeSnippetNameDirty() && !bl2 : !pSSysCodeSnippet.isPSSysCodeSnippetNameDirty()) {
            return null;
        }
        String string = pSSysCodeSnippet.getPSSysCodeSnippetName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSCODESNIPPETNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysCodeSnippetName_Default(pSSysCodeSnippet, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSCODESNIPPETNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSystemId(boolean bl, PSSysCodeSnippet pSSysCodeSnippet, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysCodeSnippet.isPSSystemIdDirty() : !pSSysCodeSnippet.isPSSystemIdDirty()) {
            return null;
        }
        String string = pSSysCodeSnippet.getPSSystemId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSystemId_Default(pSSysCodeSnippet, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSTEMID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSystemName(boolean bl, PSSysCodeSnippet pSSysCodeSnippet, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysCodeSnippet.isPSSystemNameDirty() : !pSSysCodeSnippet.isPSSystemNameDirty()) {
            return null;
        }
        String string = pSSysCodeSnippet.getPSSystemName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSystemName_Default(pSSysCodeSnippet, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSTEMNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_TemplType(boolean bl, PSSysCodeSnippet pSSysCodeSnippet, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysCodeSnippet.isTemplTypeDirty() && !bl2 : !pSSysCodeSnippet.isTemplTypeDirty()) {
            return null;
        }
        String string = pSSysCodeSnippet.getTemplType();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("TEMPLTYPE");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_TemplType_Default(pSSysCodeSnippet, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("TEMPLTYPE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_UserCat(boolean bl, PSSysCodeSnippet pSSysCodeSnippet, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysCodeSnippet.isUserCatDirty() : !pSSysCodeSnippet.isUserCatDirty()) {
            return null;
        }
        String string = pSSysCodeSnippet.getUserCat();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserCat_Default(pSSysCodeSnippet, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag(boolean bl, PSSysCodeSnippet pSSysCodeSnippet, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysCodeSnippet.isUserTagDirty() : !pSSysCodeSnippet.isUserTagDirty()) {
            return null;
        }
        String string = pSSysCodeSnippet.getUserTag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag_Default(pSSysCodeSnippet, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag2(boolean bl, PSSysCodeSnippet pSSysCodeSnippet, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysCodeSnippet.isUserTag2Dirty() : !pSSysCodeSnippet.isUserTag2Dirty()) {
            return null;
        }
        String string = pSSysCodeSnippet.getUserTag2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag2_Default(pSSysCodeSnippet, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag3(boolean bl, PSSysCodeSnippet pSSysCodeSnippet, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysCodeSnippet.isUserTag3Dirty() : !pSSysCodeSnippet.isUserTag3Dirty()) {
            return null;
        }
        String string = pSSysCodeSnippet.getUserTag3();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag3_Default(pSSysCodeSnippet, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag4(boolean bl, PSSysCodeSnippet pSSysCodeSnippet, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysCodeSnippet.isUserTag4Dirty() : !pSSysCodeSnippet.isUserTag4Dirty()) {
            return null;
        }
        String string = pSSysCodeSnippet.getUserTag4();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag4_Default(pSSysCodeSnippet, bl2, bl3);
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

    protected EntityFieldError onCheckField_ValidFlag(boolean bl, PSSysCodeSnippet pSSysCodeSnippet, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysCodeSnippet.isValidFlagDirty() && !bl2 : !pSSysCodeSnippet.isValidFlagDirty()) {
            return null;
        }
        Integer n = pSSysCodeSnippet.getValidFlag();
        if (bl) {
            if (bl2 && n == null) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("VALIDFLAG");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string = null;
            string = this.onTestValueRule_ValidFlag_Default(pSSysCodeSnippet, bl2, bl3);
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

    protected void onSyncEntity(PSSysCodeSnippet pSSysCodeSnippet, boolean bl) throws Exception {
        super.onSyncEntity(pSSysCodeSnippet, bl);
    }

    protected void onSyncIndexEntities(PSSysCodeSnippet pSSysCodeSnippet, boolean bl) throws Exception {
        super.onSyncIndexEntities(pSSysCodeSnippet, bl);
    }

    public Object getDataContextValue(PSSysCodeSnippet pSSysCodeSnippet, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null) {
            // empty if block
        }
        if ((object = super.getDataContextValue(pSSysCodeSnippet, string, iDataContextParam)) != null) {
            return object;
        }
        PSSystem pSSystem = pSSysCodeSnippet.getPSSystem();
        if (pSSystem != null && pSSystem.contains(string)) {
            return pSSystem.get(string);
        }
        return null;
    }

    protected void onExportMajorModel(PSSysCodeSnippet pSSysCodeSnippet, ArrayList<JSONObject> arrayList, int n) throws Exception {
        super.onExportMajorModel(pSSysCodeSnippet, arrayList, n);
    }

    protected String onTestValueRule(String string, String string2, IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        if (StringHelper.compare((String)string, (String)"CODENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CodeName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CODEREFMODE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CodeRefMode_Default(iEntity, bl, bl2);
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
        if (StringHelper.compare((String)string, (String)"PSDCCODESNIPPETID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDCCodeSnippetId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDCCODESNIPPETNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDCCodeSnippetName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSPFID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSPFId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSPFNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSPFName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSPFSTYLEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSPFStyleId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSPFSTYLENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSPFStyleName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSFID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSFId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSFNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSFName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSFSTYLEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSFStyleId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSFSTYLENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSFStyleName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSCODESNIPPETID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysCodeSnippetId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSCODESNIPPETNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysCodeSnippetName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSTEMID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSystemId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSTEMNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSystemName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"TEMPLTYPE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_TemplType_Default(iEntity, bl, bl2);
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
            if (this.checkFieldStringLengthRule("CODENAME", iEntity, bl2, null, false, 60, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_CodeRefMode_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("CODEREFMODE", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
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

    protected String onTestValueRule_PSDCCodeSnippetId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDCCODESNIPPETID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDCCodeSnippetName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDCCODESNIPPETNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSPFId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSPFID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSPFName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSPFNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
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

    protected String onTestValueRule_PSSFId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSFID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSFName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSFNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
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

    protected String onTestValueRule_PSSysCodeSnippetId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSCODESNIPPETID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysCodeSnippetName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSCODESNIPPETNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSystemId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSTEMID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSystemName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSTEMNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_TemplType_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("TEMPLTYPE", iEntity, bl2, null, false, 30, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]";
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

    protected String onTestValueRule_ValidFlag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected boolean onMergeChild(String string, String string2, PSSysCodeSnippet pSSysCodeSnippet) throws Exception {
        boolean bl = false;
        if (super.onMergeChild(string, string2, pSSysCodeSnippet)) {
            bl = true;
        }
        return bl;
    }

    protected void onUpdateParent(PSSysCodeSnippet pSSysCodeSnippet) throws Exception {
        super.onUpdateParent(pSSysCodeSnippet);
    }

    @Override
    protected void exportCurXmlModel(PSSysCodeSnippet pSSysCodeSnippet, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSSYSCODESNIPPET");
        if (!bl) {
            pSSysCodeSnippet.setCreateDate(null);
            pSSysCodeSnippet.setCreateMan(null);
            pSSysCodeSnippet.setPSSysCodeSnippetId(null);
            pSSysCodeSnippet.setUpdateDate(null);
            pSSysCodeSnippet.setUpdateMan(null);
            super.exportCurXmlModel(pSSysCodeSnippet, xmlNode, bl);
        }
    }

    @Override
    public ObjectNode fillModelV2(ObjectNode objectNode, PSSysCodeSnippet pSSysCodeSnippet, String string) throws Exception {
        objectNode = super.fillModelV2(objectNode, pSSysCodeSnippet, string);
        return objectNode;
    }

    @Override
    public String getModelV2ResScope(IEntity iEntity) throws Exception {
        String string = null;
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSSYSTEMID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return StringHelper.format((String)"PSSYSTEM#%1$s", (Object)string);
        }
        return super.getModelV2ResScope(iEntity);
    }

    @Override
    public String getModelV2ResScopeDER(IEntity iEntity) throws Exception {
        String string = null;
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSSYSTEMID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return "DER1N_PSSYSCODESNIPPET_PSSYSTEM_PSSYSTEMID";
        }
        return super.getModelV2ResScopeDER(iEntity);
    }

    @Override
    public String getModelV2ResScopeText(IEntity iEntity) throws Exception {
        String string = null;
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSSYSTEMID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return DataObject.getStringValue((IDataObject)iEntity, (String)"PSSYSTEMNAME", null);
        }
        return super.getModelV2ResScopeText(iEntity);
    }

    @Override
    public boolean setModelV2ResScope(IEntity iEntity, String string, String string2) throws Exception {
        if (StringHelper.compare((String)string, (String)"PSSYSTEM", (boolean)true) == 0) {
            iEntity.set("PSSYSTEMID", (Object)string2);
            return true;
        }
        return super.setModelV2ResScope(iEntity, string, string2);
    }

    @Override
    public String[] getModelV2ResScopeFields() throws Exception {
        return new String[]{"PSSYSTEMID"};
    }

    @Override
    public String getModelV2Tag(PSSysCodeSnippet pSSysCodeSnippet) {
        return super.getModelV2Tag(pSSysCodeSnippet);
    }

    @Override
    public boolean setModelV2Tag(PSSysCodeSnippet pSSysCodeSnippet, String string) {
        return super.setModelV2Tag(pSSysCodeSnippet, string);
    }

    @Override
    public Map<String, String> getListDRDataFolderFields(Map<String, String> map, PSMOSFile pSMOSFile, IPSMOSFileFilter iPSMOSFileFilter) throws Exception {
        if (map == null) {
            map = new HashMap<String, String>();
        }
        map.put("PSSYSTEMID", "");
        return super.getListDRDataFolderFields(map, pSMOSFile, iPSMOSFileFilter);
    }

    @Override
    public boolean getModelV2Entity(PSSysCodeSnippet pSSysCodeSnippet, String string) throws Exception {
        SimpleEntity simpleEntity = new SimpleEntity();
        pSSysCodeSnippet.copyTo((IDataObject)simpleEntity, false);
        simpleEntity.copyTo((IDataObject)pSSysCodeSnippet, true);
        return super.getModelV2Entity(pSSysCodeSnippet, string);
    }

    @Override
    protected boolean testCompileCurModelV2(PSSysCodeSnippet pSSysCodeSnippet, ObjectNode objectNode, String string, String string2, int n) throws Exception {
        if (n == 1) {
            return false;
        }
        return super.testCompileCurModelV2(pSSysCodeSnippet, objectNode, string, string2, n);
    }
}

