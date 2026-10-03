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
import net.ibizsys.pscore.srv.config.dao.PSPFViewTemplDAO;
import net.ibizsys.pscore.srv.config.demodel.PSPFViewTemplDEModel;
import net.ibizsys.pscore.srv.config.entity.PSPF;
import net.ibizsys.pscore.srv.config.entity.PSPFBase;
import net.ibizsys.pscore.srv.config.entity.PSPFPubCode;
import net.ibizsys.pscore.srv.config.entity.PSPFPubCodeBase;
import net.ibizsys.pscore.srv.config.entity.PSPFStyle;
import net.ibizsys.pscore.srv.config.entity.PSPFStyleBase;
import net.ibizsys.pscore.srv.config.entity.PSPFViewTempl;
import net.ibizsys.pscore.srv.config.entity.PSViewType;
import net.ibizsys.pscore.srv.config.entity.PSViewTypeBase;
import net.ibizsys.pscore.srv.core.IPSDataEntityModel;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSPFViewTemplServiceBase
extends PSCoreSysServiceBase<PSPFViewTempl> {
    private static final Log log = LogFactory.getLog(PSPFViewTemplServiceBase.class);
    public static final String DATASET_DEFAULT = "DEFAULT";
    private PSPFViewTemplDEModel pSPFViewTemplDEModel;
    private PSPFViewTemplDAO pSPFViewTemplDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.config.service.PSPFViewTemplService";
    }

    public PSPFViewTemplDEModel getPSPFViewTemplDEModel() {
        if (this.pSPFViewTemplDEModel == null) {
            try {
                this.pSPFViewTemplDEModel = (PSPFViewTemplDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.config.demodel.PSPFViewTemplDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSPFViewTemplDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSPFViewTemplDEModel();
    }

    public PSPFViewTemplDAO getPSPFViewTemplDAO() {
        if (this.pSPFViewTemplDAO == null) {
            try {
                this.pSPFViewTemplDAO = (PSPFViewTemplDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.config.dao.PSPFViewTemplDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSPFViewTemplDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSPFViewTemplDAO();
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

    protected void onFillParentInfo(PSPFViewTempl pSPFViewTempl, String string, String string2, String string3) throws Exception {
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSPFVIEWTEMPL_PSPFPUBCODE_PSPFPUBCODEID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.config.service.PSPFPubCodeService", (SessionFactory)this.getSessionFactory());
            PSPFPubCode pSPFPubCode = (PSPFPubCode)iService.getDEModel().createEntity();
            pSPFPubCode.set("PSPFPUBCODEID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSPFPubCode);
            } else {
                iService.get(pSPFPubCode);
            }
            this.onFillParentInfo_PSPFPubCode(pSPFViewTempl, pSPFPubCode);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSPFVIEWTEMPL_PSPFSTYLE_PSPFSTYLEID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.config.service.PSPFStyleService", (SessionFactory)this.getSessionFactory());
            PSPFStyle pSPFStyle = (PSPFStyle)iService.getDEModel().createEntity();
            pSPFStyle.set("PSPFSTYLEID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSPFStyle);
            } else {
                iService.get(pSPFStyle);
            }
            this.onFillParentInfo_PSPFStyle(pSPFViewTempl, pSPFStyle);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSPFVIEWTEMPL_PSPF_PSPFID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.config.service.PSPFService", (SessionFactory)this.getSessionFactory());
            PSPF pSPF = (PSPF)iService.getDEModel().createEntity();
            pSPF.set("PSPFID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSPF);
            } else {
                iService.get(pSPF);
            }
            this.onFillParentInfo_PSPF(pSPFViewTempl, pSPF);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSPFVIEWTEMPL_PSVIEWTYPE_PSVIEWTYPEID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.config.service.PSViewTypeService", (SessionFactory)this.getSessionFactory());
            PSViewType pSViewType = (PSViewType)iService.getDEModel().createEntity();
            pSViewType.set("PSVIEWTYPEID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSViewType);
            } else {
                iService.get(pSViewType);
            }
            this.onFillParentInfo_PSViewType(pSPFViewTempl, pSViewType);
            return;
        }
        super.onFillParentInfo(pSPFViewTempl, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillParentInfo_PSPFPubCode(PSPFViewTempl pSPFViewTempl, PSPFPubCode pSPFPubCode) throws Exception {
        pSPFViewTempl.setPITemplCode(pSPFPubCode.getPITemplCode());
        pSPFViewTempl.setPSPFPubCodeId(pSPFPubCode.getPSPFPubCodeId());
        pSPFViewTempl.setPSPFPubCodeName(pSPFPubCode.getPSPFPubCodeName());
    }

    protected void onFillParentInfo_PSPFStyle(PSPFViewTempl pSPFViewTempl, PSPFStyle pSPFStyle) throws Exception {
        pSPFViewTempl.setPSPFStyleId(pSPFStyle.getPSPFStyleId());
        pSPFViewTempl.setPSPFStyleName(pSPFStyle.getPSPFStyleName());
        if (pSPFStyle.getPSPF() != null) {
            this.onFillParentInfo_PSPF(pSPFViewTempl, pSPFStyle.getPSPF());
        }
    }

    protected void onFillParentInfo_PSPF(PSPFViewTempl pSPFViewTempl, PSPF pSPF) throws Exception {
        pSPFViewTempl.setPSPFId(pSPF.getPSPFId());
        pSPFViewTempl.setPSPFName(pSPF.getPSPFName());
    }

    protected void onFillParentInfo_PSViewType(PSPFViewTempl pSPFViewTempl, PSViewType pSViewType) throws Exception {
        pSPFViewTempl.setPSViewTypeId(pSViewType.getPSViewTypeId());
        pSPFViewTempl.setPSViewTypeName(pSViewType.getPSViewTypeName());
    }

    protected void onFillEntityFullInfo(PSPFViewTempl pSPFViewTempl, boolean bl) throws Exception {
        if (bl) {
            // empty if block
        }
        super.onFillEntityFullInfo(pSPFViewTempl, bl);
        this.onFillEntityFullInfo_PSPFPubCode(pSPFViewTempl, bl);
        this.onFillEntityFullInfo_PSPFStyle(pSPFViewTempl, bl);
        this.onFillEntityFullInfo_PSPF(pSPFViewTempl, bl);
        this.onFillEntityFullInfo_PSViewType(pSPFViewTempl, bl);
    }

    protected void onFillEntityFullInfo_PSPFPubCode(PSPFViewTempl pSPFViewTempl, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSPFStyle(PSPFViewTempl pSPFViewTempl, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSPF(PSPFViewTempl pSPFViewTempl, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSViewType(PSPFViewTempl pSPFViewTempl, boolean bl) throws Exception {
    }

    protected void onWriteBackParent(PSPFViewTempl pSPFViewTempl, boolean bl) throws Exception {
        super.onWriteBackParent(pSPFViewTempl, bl);
    }

    public ArrayList<PSPFViewTempl> selectByPSPFPubCode(PSPFPubCodeBase pSPFPubCodeBase) throws Exception {
        return this.selectByPSPFPubCode(pSPFPubCodeBase, "", -1);
    }

    public ArrayList<PSPFViewTempl> selectByPSPFPubCode(PSPFPubCodeBase pSPFPubCodeBase, String string) throws Exception {
        return this.selectByPSPFPubCode(pSPFPubCodeBase, string, -1);
    }

    public ArrayList<PSPFViewTempl> selectByPSPFPubCode(PSPFPubCodeBase pSPFPubCodeBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSPFPUBCODEID", (Object)pSPFPubCodeBase.getPSPFPubCodeId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSPFPubCodeCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSPFPubCodeCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSPFViewTempl> selectByPSPFStyle(PSPFStyleBase pSPFStyleBase) throws Exception {
        return this.selectByPSPFStyle(pSPFStyleBase, "", -1);
    }

    public ArrayList<PSPFViewTempl> selectByPSPFStyle(PSPFStyleBase pSPFStyleBase, String string) throws Exception {
        return this.selectByPSPFStyle(pSPFStyleBase, string, -1);
    }

    public ArrayList<PSPFViewTempl> selectByPSPFStyle(PSPFStyleBase pSPFStyleBase, String string, int n) throws Exception {
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

    public ArrayList<PSPFViewTempl> selectByPSPF(PSPFBase pSPFBase) throws Exception {
        return this.selectByPSPF(pSPFBase, "", -1);
    }

    public ArrayList<PSPFViewTempl> selectByPSPF(PSPFBase pSPFBase, String string) throws Exception {
        return this.selectByPSPF(pSPFBase, string, -1);
    }

    public ArrayList<PSPFViewTempl> selectByPSPF(PSPFBase pSPFBase, String string, int n) throws Exception {
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

    public ArrayList<PSPFViewTempl> selectByPSViewType(PSViewTypeBase pSViewTypeBase) throws Exception {
        return this.selectByPSViewType(pSViewTypeBase, "", -1);
    }

    public ArrayList<PSPFViewTempl> selectByPSViewType(PSViewTypeBase pSViewTypeBase, String string) throws Exception {
        return this.selectByPSViewType(pSViewTypeBase, string, -1);
    }

    public ArrayList<PSPFViewTempl> selectByPSViewType(PSViewTypeBase pSViewTypeBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSVIEWTYPEID", (Object)pSViewTypeBase.getPSViewTypeId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSViewTypeCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSViewTypeCond(SelectCond selectCond) throws Exception {
    }

    public void testRemoveByPSPFPubCode(PSPFPubCode pSPFPubCode) throws Exception {
        ArrayList<PSPFViewTempl> arrayList = this.selectByPSPFPubCode(pSPFPubCode, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSPFPUBCODE");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSPFPubCode);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSPFVIEWTEMPL_PSPFPUBCODE_PSPFPUBCODEID", "", iDataEntityModel.getName(), "PSPFVIEWTEMPL", iDataEntityModel.getDataInfo(pSPFPubCode), arrayList.get(0)));
        }
    }

    public void resetPSPFPubCode(PSPFPubCode pSPFPubCode) throws Exception {
        ArrayList<PSPFViewTempl> arrayList = this.selectByPSPFPubCode(pSPFPubCode);
        for (PSPFViewTempl pSPFViewTempl : arrayList) {
            PSPFViewTempl pSPFViewTempl2 = (PSPFViewTempl)this.getDEModel().createEntity();
            pSPFViewTempl2.setPSPFViewTemplId(pSPFViewTempl.getPSPFViewTemplId());
            pSPFViewTempl2.setPSPFPubCodeId(null);
            this.update(pSPFViewTempl2);
        }
    }

    public void removeByPSPFPubCode(PSPFPubCode pSPFPubCode) throws Exception {
        final PSPFPubCode pSPFPubCode2 = pSPFPubCode;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSPFViewTemplServiceBase.this.onBeforeRemoveByPSPFPubCode(pSPFPubCode2);
                PSPFViewTemplServiceBase.this.internalRemoveByPSPFPubCode(pSPFPubCode2);
                PSPFViewTemplServiceBase.this.onAfterRemoveByPSPFPubCode(pSPFPubCode2);
            }
        });
    }

    protected void onBeforeRemoveByPSPFPubCode(PSPFPubCode pSPFPubCode) throws Exception {
    }

    protected void internalRemoveByPSPFPubCode(PSPFPubCode pSPFPubCode) throws Exception {
        ArrayList<PSPFViewTempl> arrayList = this.selectByPSPFPubCode(pSPFPubCode);
        this.onBeforeRemoveByPSPFPubCode(pSPFPubCode, arrayList);
        for (PSPFViewTempl pSPFViewTempl : arrayList) {
            this.remove(pSPFViewTempl);
        }
        this.onAfterRemoveByPSPFPubCode(pSPFPubCode, arrayList);
    }

    protected void onAfterRemoveByPSPFPubCode(PSPFPubCode pSPFPubCode) throws Exception {
    }

    protected void onBeforeRemoveByPSPFPubCode(PSPFPubCode pSPFPubCode, ArrayList<PSPFViewTempl> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSPFPubCode(PSPFPubCode pSPFPubCode, ArrayList<PSPFViewTempl> arrayList) throws Exception {
    }

    public void testRemoveByPSPFStyle(PSPFStyle pSPFStyle) throws Exception {
        ArrayList<PSPFViewTempl> arrayList = this.selectByPSPFStyle(pSPFStyle, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSPFSTYLE");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSPFStyle);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSPFVIEWTEMPL_PSPFSTYLE_PSPFSTYLEID", "", iDataEntityModel.getName(), "PSPFVIEWTEMPL", iDataEntityModel.getDataInfo(pSPFStyle), arrayList.get(0)));
        }
    }

    public void resetPSPFStyle(PSPFStyle pSPFStyle) throws Exception {
        ArrayList<PSPFViewTempl> arrayList = this.selectByPSPFStyle(pSPFStyle);
        for (PSPFViewTempl pSPFViewTempl : arrayList) {
            PSPFViewTempl pSPFViewTempl2 = (PSPFViewTempl)this.getDEModel().createEntity();
            pSPFViewTempl2.setPSPFViewTemplId(pSPFViewTempl.getPSPFViewTemplId());
            pSPFViewTempl2.setPSPFStyleId(null);
            this.update(pSPFViewTempl2);
        }
    }

    public void removeByPSPFStyle(PSPFStyle pSPFStyle) throws Exception {
        final PSPFStyle pSPFStyle2 = pSPFStyle;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSPFViewTemplServiceBase.this.onBeforeRemoveByPSPFStyle(pSPFStyle2);
                PSPFViewTemplServiceBase.this.internalRemoveByPSPFStyle(pSPFStyle2);
                PSPFViewTemplServiceBase.this.onAfterRemoveByPSPFStyle(pSPFStyle2);
            }
        });
    }

    protected void onBeforeRemoveByPSPFStyle(PSPFStyle pSPFStyle) throws Exception {
    }

    protected void internalRemoveByPSPFStyle(PSPFStyle pSPFStyle) throws Exception {
        ArrayList<PSPFViewTempl> arrayList = this.selectByPSPFStyle(pSPFStyle);
        this.onBeforeRemoveByPSPFStyle(pSPFStyle, arrayList);
        for (PSPFViewTempl pSPFViewTempl : arrayList) {
            this.remove(pSPFViewTempl);
        }
        this.onAfterRemoveByPSPFStyle(pSPFStyle, arrayList);
    }

    protected void onAfterRemoveByPSPFStyle(PSPFStyle pSPFStyle) throws Exception {
    }

    protected void onBeforeRemoveByPSPFStyle(PSPFStyle pSPFStyle, ArrayList<PSPFViewTempl> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSPFStyle(PSPFStyle pSPFStyle, ArrayList<PSPFViewTempl> arrayList) throws Exception {
    }

    public void testRemoveByPSPF(PSPF pSPF) throws Exception {
    }

    public void resetPSPF(PSPF pSPF) throws Exception {
        ArrayList<PSPFViewTempl> arrayList = this.selectByPSPF(pSPF);
        for (PSPFViewTempl pSPFViewTempl : arrayList) {
            PSPFViewTempl pSPFViewTempl2 = (PSPFViewTempl)this.getDEModel().createEntity();
            pSPFViewTempl2.setPSPFViewTemplId(pSPFViewTempl.getPSPFViewTemplId());
            pSPFViewTempl2.setPSPFId(null);
            this.update(pSPFViewTempl2);
        }
    }

    public void removeByPSPF(PSPF pSPF) throws Exception {
        final PSPF pSPF2 = pSPF;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSPFViewTemplServiceBase.this.onBeforeRemoveByPSPF(pSPF2);
                PSPFViewTemplServiceBase.this.internalRemoveByPSPF(pSPF2);
                PSPFViewTemplServiceBase.this.onAfterRemoveByPSPF(pSPF2);
            }
        });
    }

    protected void onBeforeRemoveByPSPF(PSPF pSPF) throws Exception {
    }

    protected void internalRemoveByPSPF(PSPF pSPF) throws Exception {
        ArrayList<PSPFViewTempl> arrayList = this.selectByPSPF(pSPF);
        this.onBeforeRemoveByPSPF(pSPF, arrayList);
        for (PSPFViewTempl pSPFViewTempl : arrayList) {
            this.remove(pSPFViewTempl);
        }
        this.onAfterRemoveByPSPF(pSPF, arrayList);
    }

    protected void onAfterRemoveByPSPF(PSPF pSPF) throws Exception {
    }

    protected void onBeforeRemoveByPSPF(PSPF pSPF, ArrayList<PSPFViewTempl> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSPF(PSPF pSPF, ArrayList<PSPFViewTempl> arrayList) throws Exception {
    }

    public void testRemoveByPSViewType(PSViewType pSViewType) throws Exception {
        ArrayList<PSPFViewTempl> arrayList = this.selectByPSViewType(pSViewType, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSVIEWTYPE");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSViewType);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSPFVIEWTEMPL_PSVIEWTYPE_PSVIEWTYPEID", "", iDataEntityModel.getName(), "PSPFVIEWTEMPL", iDataEntityModel.getDataInfo(pSViewType), arrayList.get(0)));
        }
    }

    public void resetPSViewType(PSViewType pSViewType) throws Exception {
        ArrayList<PSPFViewTempl> arrayList = this.selectByPSViewType(pSViewType);
        for (PSPFViewTempl pSPFViewTempl : arrayList) {
            PSPFViewTempl pSPFViewTempl2 = (PSPFViewTempl)this.getDEModel().createEntity();
            pSPFViewTempl2.setPSPFViewTemplId(pSPFViewTempl.getPSPFViewTemplId());
            pSPFViewTempl2.setPSViewTypeId(null);
            this.update(pSPFViewTempl2);
        }
    }

    public void removeByPSViewType(PSViewType pSViewType) throws Exception {
        final PSViewType pSViewType2 = pSViewType;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSPFViewTemplServiceBase.this.onBeforeRemoveByPSViewType(pSViewType2);
                PSPFViewTemplServiceBase.this.internalRemoveByPSViewType(pSViewType2);
                PSPFViewTemplServiceBase.this.onAfterRemoveByPSViewType(pSViewType2);
            }
        });
    }

    protected void onBeforeRemoveByPSViewType(PSViewType pSViewType) throws Exception {
    }

    protected void internalRemoveByPSViewType(PSViewType pSViewType) throws Exception {
        ArrayList<PSPFViewTempl> arrayList = this.selectByPSViewType(pSViewType);
        this.onBeforeRemoveByPSViewType(pSViewType, arrayList);
        for (PSPFViewTempl pSPFViewTempl : arrayList) {
            this.remove(pSPFViewTempl);
        }
        this.onAfterRemoveByPSViewType(pSViewType, arrayList);
    }

    protected void onAfterRemoveByPSViewType(PSViewType pSViewType) throws Exception {
    }

    protected void onBeforeRemoveByPSViewType(PSViewType pSViewType, ArrayList<PSPFViewTempl> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSViewType(PSViewType pSViewType, ArrayList<PSPFViewTempl> arrayList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(PSPFViewTempl pSPFViewTempl) throws Exception {
        super.onBeforeRemove(pSPFViewTempl);
    }

    protected void replaceParentInfo(PSPFViewTempl pSPFViewTempl, CloneSession cloneSession) throws Exception {
        IEntity iEntity;
        super.replaceParentInfo(pSPFViewTempl, cloneSession);
        if (pSPFViewTempl.getPSPFPubCodeId() != null && (iEntity = cloneSession.getEntity("PSPFPUBCODE", (Object)pSPFViewTempl.getPSPFPubCodeId())) != null) {
            this.onFillParentInfo_PSPFPubCode(pSPFViewTempl, (PSPFPubCode)iEntity);
        }
        if (pSPFViewTempl.getPSPFStyleId() != null && (iEntity = cloneSession.getEntity("PSPFSTYLE", (Object)pSPFViewTempl.getPSPFStyleId())) != null) {
            this.onFillParentInfo_PSPFStyle(pSPFViewTempl, (PSPFStyle)iEntity);
        }
        if (pSPFViewTempl.getPSPFId() != null && (iEntity = cloneSession.getEntity("PSPF", (Object)pSPFViewTempl.getPSPFId())) != null) {
            this.onFillParentInfo_PSPF(pSPFViewTempl, (PSPF)iEntity);
        }
        if (pSPFViewTempl.getPSViewTypeId() != null && (iEntity = cloneSession.getEntity("PSVIEWTYPE", (Object)pSPFViewTempl.getPSViewTypeId())) != null) {
            this.onFillParentInfo_PSViewType(pSPFViewTempl, (PSViewType)iEntity);
        }
    }

    protected void onRemoveEntityUncopyValues(PSPFViewTempl pSPFViewTempl, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues(pSPFViewTempl, bl);
    }

    protected void onCheckEntity(boolean bl, PSPFViewTempl pSPFViewTempl, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_CodePath(bl, pSPFViewTempl, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_FileName(bl, pSPFViewTempl, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_LogicName(bl, pSPFViewTempl, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Memo(bl, pSPFViewTempl, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSPFId(bl, pSPFViewTempl, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSPFPubCodeId(bl, pSPFViewTempl, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSPFStyleId(bl, pSPFViewTempl, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSPFViewTemplId(bl, pSPFViewTempl, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSPFViewTemplName(bl, pSPFViewTempl, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSViewTypeId(bl, pSPFViewTempl, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PubObj(bl, pSPFViewTempl, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_TemplCode(bl, pSPFViewTempl, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_TemplCode2(bl, pSPFViewTempl, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_TemplDesc(bl, pSPFViewTempl, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_TypeCode(bl, pSPFViewTempl, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, pSPFViewTempl, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_CodePath(boolean bl, PSPFViewTempl pSPFViewTempl, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSPFViewTempl.isCodePathDirty() : !pSPFViewTempl.isCodePathDirty()) {
            return null;
        }
        String string = pSPFViewTempl.getCodePath();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_CodePath_Default(pSPFViewTempl, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CODEPATH");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_FileName(boolean bl, PSPFViewTempl pSPFViewTempl, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSPFViewTempl.isFileNameDirty() : !pSPFViewTempl.isFileNameDirty()) {
            return null;
        }
        String string = pSPFViewTempl.getFileName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_FileName_Default(pSPFViewTempl, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("FILENAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_LogicName(boolean bl, PSPFViewTempl pSPFViewTempl, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSPFViewTempl.isLogicNameDirty() : !pSPFViewTempl.isLogicNameDirty()) {
            return null;
        }
        String string = pSPFViewTempl.getLogicName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_LogicName_Default(pSPFViewTempl, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("LOGICNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Memo(boolean bl, PSPFViewTempl pSPFViewTempl, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSPFViewTempl.isMemoDirty() : !pSPFViewTempl.isMemoDirty()) {
            return null;
        }
        String string = pSPFViewTempl.getMemo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Memo_Default(pSPFViewTempl, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSPFId(boolean bl, PSPFViewTempl pSPFViewTempl, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSPFViewTempl.isPSPFIdDirty() && !bl2 : !pSPFViewTempl.isPSPFIdDirty()) {
            return null;
        }
        String string = pSPFViewTempl.getPSPFId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSPFID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSPFId_Default(pSPFViewTempl, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSPFPubCodeId(boolean bl, PSPFViewTempl pSPFViewTempl, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSPFViewTempl.isPSPFPubCodeIdDirty() && !bl2 : !pSPFViewTempl.isPSPFPubCodeIdDirty()) {
            return null;
        }
        String string = pSPFViewTempl.getPSPFPubCodeId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSPFPUBCODEID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSPFPubCodeId_Default(pSPFViewTempl, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSPFPUBCODEID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSPFStyleId(boolean bl, PSPFViewTempl pSPFViewTempl, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSPFViewTempl.isPSPFStyleIdDirty() && !bl2 : !pSPFViewTempl.isPSPFStyleIdDirty()) {
            return null;
        }
        String string = pSPFViewTempl.getPSPFStyleId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSPFSTYLEID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSPFStyleId_Default(pSPFViewTempl, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSPFViewTemplId(boolean bl, PSPFViewTempl pSPFViewTempl, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSPFViewTempl.isPSPFViewTemplIdDirty() && !bl2 : !pSPFViewTempl.isPSPFViewTemplIdDirty()) {
            return null;
        }
        String string = pSPFViewTempl.getPSPFViewTemplId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSPFVIEWTEMPLID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSPFViewTemplId_Default(pSPFViewTempl, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSPFVIEWTEMPLID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSPFViewTemplName(boolean bl, PSPFViewTempl pSPFViewTempl, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSPFViewTempl.isPSPFViewTemplNameDirty() && !bl2 : !pSPFViewTempl.isPSPFViewTemplNameDirty()) {
            return null;
        }
        String string = pSPFViewTempl.getPSPFViewTemplName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSPFVIEWTEMPLNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSPFViewTemplName_Default(pSPFViewTempl, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSPFVIEWTEMPLNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSViewTypeId(boolean bl, PSPFViewTempl pSPFViewTempl, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSPFViewTempl.isPSViewTypeIdDirty() && !bl2 : !pSPFViewTempl.isPSViewTypeIdDirty()) {
            return null;
        }
        String string = pSPFViewTempl.getPSViewTypeId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSVIEWTYPEID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSViewTypeId_Default(pSPFViewTempl, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSVIEWTYPEID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PubObj(boolean bl, PSPFViewTempl pSPFViewTempl, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSPFViewTempl.isPubObjDirty() : !pSPFViewTempl.isPubObjDirty()) {
            return null;
        }
        String string = pSPFViewTempl.getPubObj();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PubObj_Default(pSPFViewTempl, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PUBOBJ");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_TemplCode(boolean bl, PSPFViewTempl pSPFViewTempl, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSPFViewTempl.isTemplCodeDirty() : !pSPFViewTempl.isTemplCodeDirty()) {
            return null;
        }
        String string = pSPFViewTempl.getTemplCode();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_TemplCode_Default(pSPFViewTempl, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("TEMPLCODE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_TemplCode2(boolean bl, PSPFViewTempl pSPFViewTempl, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSPFViewTempl.isTemplCode2Dirty() : !pSPFViewTempl.isTemplCode2Dirty()) {
            return null;
        }
        String string = pSPFViewTempl.getTemplCode2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_TemplCode2_Default(pSPFViewTempl, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("TEMPLCODE2");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_TemplDesc(boolean bl, PSPFViewTempl pSPFViewTempl, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSPFViewTempl.isTemplDescDirty() : !pSPFViewTempl.isTemplDescDirty()) {
            return null;
        }
        String string = pSPFViewTempl.getTemplDesc();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_TemplDesc_Default(pSPFViewTempl, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("TEMPLDESC");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_TypeCode(boolean bl, PSPFViewTempl pSPFViewTempl, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSPFViewTempl.isTypeCodeDirty() : !pSPFViewTempl.isTypeCodeDirty()) {
            return null;
        }
        String string = pSPFViewTempl.getTypeCode();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_TypeCode_Default(pSPFViewTempl, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("TYPECODE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected void onSyncEntity(PSPFViewTempl pSPFViewTempl, boolean bl) throws Exception {
        super.onSyncEntity(pSPFViewTempl, bl);
    }

    protected void onSyncIndexEntities(PSPFViewTempl pSPFViewTempl, boolean bl) throws Exception {
        super.onSyncIndexEntities(pSPFViewTempl, bl);
    }

    public Object getDataContextValue(PSPFViewTempl pSPFViewTempl, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null) {
            // empty if block
        }
        if ((object = super.getDataContextValue(pSPFViewTempl, string, iDataContextParam)) != null) {
            return object;
        }
        PSPFStyle pSPFStyle = pSPFViewTempl.getPSPFStyle();
        if (pSPFStyle != null && pSPFStyle.contains(string)) {
            return pSPFStyle.get(string);
        }
        return null;
    }

    protected void onExportMajorModel(PSPFViewTempl pSPFViewTempl, ArrayList<JSONObject> arrayList, int n) throws Exception {
        super.onExportMajorModel(pSPFViewTempl, arrayList, n);
    }

    protected String onTestValueRule(String string, String string2, IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        if (StringHelper.compare((String)string, (String)"CODEPATH", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CodePath_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATEDATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateDate_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATEMAN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateMan_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"FILENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_FileName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"LOGICNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_LogicName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MEMO", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Memo_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PITEMPLCODE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PITemplCode_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSPFID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSPFId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSPFNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSPFName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSPFPUBCODEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSPFPubCodeId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSPFPUBCODENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSPFPubCodeName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSPFSTYLEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSPFStyleId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSPFSTYLENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSPFStyleName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSPFVIEWTEMPLID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSPFViewTemplId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSPFVIEWTEMPLNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSPFViewTemplName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSVIEWTYPEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSViewTypeId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSVIEWTYPENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSViewTypeName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PUBOBJ", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PubObj_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"TEMPLCODE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_TemplCode_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"TEMPLCODE2", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_TemplCode2_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"TEMPLDESC", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_TemplDesc_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"TYPECODE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_TypeCode_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UPDATEDATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UpdateDate_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UPDATEMAN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UpdateMan_Default(iEntity, bl, bl2);
        }
        return super.onTestValueRule(string, string2, iEntity, bl, bl2);
    }

    protected String onTestValueRule_CodePath_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("CODEPATH", iEntity, bl2, null, false, 500, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[500]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[500]";
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

    protected String onTestValueRule_FileName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("FILENAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_LogicName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("LOGICNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
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

    protected String onTestValueRule_PITemplCode_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PITEMPLCODE", iEntity, bl2, null, false, 30, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]";
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

    protected String onTestValueRule_PSPFPubCodeId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSPFPUBCODEID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSPFPubCodeName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSPFPUBCODENAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
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

    protected String onTestValueRule_PSPFViewTemplId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSPFVIEWTEMPLID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSPFViewTemplName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSPFVIEWTEMPLNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSViewTypeId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSVIEWTYPEID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSViewTypeName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSVIEWTYPENAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PubObj_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PUBOBJ", iEntity, bl2, null, false, 250, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[250]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[250]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_TemplCode_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("TEMPLCODE", iEntity, bl2, null, false, 0x100000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_TemplCode2_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("TEMPLCODE2", iEntity, bl2, null, false, 0x100000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_TemplDesc_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("TEMPLDESC", iEntity, bl2, null, false, 0x100000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_TypeCode_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("TYPECODE", iEntity, bl2, null, false, 500, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[500]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[500]";
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

    protected boolean onMergeChild(String string, String string2, PSPFViewTempl pSPFViewTempl) throws Exception {
        boolean bl = false;
        if (super.onMergeChild(string, string2, pSPFViewTempl)) {
            bl = true;
        }
        return bl;
    }

    protected void onUpdateParent(PSPFViewTempl pSPFViewTempl) throws Exception {
        super.onUpdateParent(pSPFViewTempl);
    }

    @Override
    protected void exportCurXmlModel(PSPFViewTempl pSPFViewTempl, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSPFVIEWTEMPL");
        if (!bl) {
            pSPFViewTempl.setCreateDate(null);
            pSPFViewTempl.setCreateMan(null);
            pSPFViewTempl.setPSPFViewTemplId(null);
            pSPFViewTempl.setTemplCode(null);
            pSPFViewTempl.setUpdateDate(null);
            pSPFViewTempl.setUpdateMan(null);
            super.exportCurXmlModel(pSPFViewTempl, xmlNode, bl);
        }
    }
}

