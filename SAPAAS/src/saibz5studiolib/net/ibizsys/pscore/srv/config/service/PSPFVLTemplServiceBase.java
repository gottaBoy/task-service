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
import net.ibizsys.pscore.srv.config.dao.PSPFVLTemplDAO;
import net.ibizsys.pscore.srv.config.demodel.PSPFVLTemplDEModel;
import net.ibizsys.pscore.srv.config.entity.PSPF;
import net.ibizsys.pscore.srv.config.entity.PSPFBase;
import net.ibizsys.pscore.srv.config.entity.PSPFPubCode;
import net.ibizsys.pscore.srv.config.entity.PSPFPubCodeBase;
import net.ibizsys.pscore.srv.config.entity.PSPFStyle;
import net.ibizsys.pscore.srv.config.entity.PSPFStyleBase;
import net.ibizsys.pscore.srv.config.entity.PSPFVLTempl;
import net.ibizsys.pscore.srv.config.entity.PSViewLogicType;
import net.ibizsys.pscore.srv.config.entity.PSViewLogicTypeBase;
import net.ibizsys.pscore.srv.core.IPSDataEntityModel;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSPFVLTemplServiceBase
extends PSCoreSysServiceBase<PSPFVLTempl> {
    private static final Log log = LogFactory.getLog(PSPFVLTemplServiceBase.class);
    public static final String DATASET_DEFAULT = "DEFAULT";
    private PSPFVLTemplDEModel pSPFVLTemplDEModel;
    private PSPFVLTemplDAO pSPFVLTemplDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.config.service.PSPFVLTemplService";
    }

    public PSPFVLTemplDEModel getPSPFVLTemplDEModel() {
        if (this.pSPFVLTemplDEModel == null) {
            try {
                this.pSPFVLTemplDEModel = (PSPFVLTemplDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.config.demodel.PSPFVLTemplDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSPFVLTemplDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSPFVLTemplDEModel();
    }

    public PSPFVLTemplDAO getPSPFVLTemplDAO() {
        if (this.pSPFVLTemplDAO == null) {
            try {
                this.pSPFVLTemplDAO = (PSPFVLTemplDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.config.dao.PSPFVLTemplDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSPFVLTemplDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSPFVLTemplDAO();
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

    protected void onFillParentInfo(PSPFVLTempl pSPFVLTempl, String string, String string2, String string3) throws Exception {
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSPFVLTEMPL_PSPFPUBCODE_PSPFPUBCODEID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.config.service.PSPFPubCodeService", (SessionFactory)this.getSessionFactory());
            PSPFPubCode pSPFPubCode = (PSPFPubCode)iService.getDEModel().createEntity();
            pSPFPubCode.set("PSPFPUBCODEID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSPFPubCode);
            } else {
                iService.get(pSPFPubCode);
            }
            this.onFillParentInfo_PSPFPubCode(pSPFVLTempl, pSPFPubCode);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSPFVLTEMPL_PSPFSTYLE_PSPFSTYLEID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.config.service.PSPFStyleService", (SessionFactory)this.getSessionFactory());
            PSPFStyle pSPFStyle = (PSPFStyle)iService.getDEModel().createEntity();
            pSPFStyle.set("PSPFSTYLEID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSPFStyle);
            } else {
                iService.get(pSPFStyle);
            }
            this.onFillParentInfo_PSPFStyle(pSPFVLTempl, pSPFStyle);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSPFVLTEMPL_PSPF_PSPFID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.config.service.PSPFService", (SessionFactory)this.getSessionFactory());
            PSPF pSPF = (PSPF)iService.getDEModel().createEntity();
            pSPF.set("PSPFID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSPF);
            } else {
                iService.get(pSPF);
            }
            this.onFillParentInfo_Pspf(pSPFVLTempl, pSPF);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSPFVLTEMPL_PSVIEWLOGICTYPE_PSVIEWLOGICTYPEID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.config.service.PSViewLogicTypeService", (SessionFactory)this.getSessionFactory());
            PSViewLogicType pSViewLogicType = (PSViewLogicType)iService.getDEModel().createEntity();
            pSViewLogicType.set("PSVIEWLOGICTYPEID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSViewLogicType);
            } else {
                iService.get(pSViewLogicType);
            }
            this.onFillParentInfo_PSViewLogicType(pSPFVLTempl, pSViewLogicType);
            return;
        }
        super.onFillParentInfo(pSPFVLTempl, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillParentInfo_PSPFPubCode(PSPFVLTempl pSPFVLTempl, PSPFPubCode pSPFPubCode) throws Exception {
        pSPFVLTempl.setPSPFPubCodeId(pSPFPubCode.getPSPFPubCodeId());
        pSPFVLTempl.setPSPFPubCodeName(pSPFPubCode.getPSPFPubCodeName());
    }

    protected void onFillParentInfo_PSPFStyle(PSPFVLTempl pSPFVLTempl, PSPFStyle pSPFStyle) throws Exception {
        pSPFVLTempl.setPSPFStyleId(pSPFStyle.getPSPFStyleId());
        pSPFVLTempl.setPSPFStyleName(pSPFStyle.getPSPFStyleName());
    }

    protected void onFillParentInfo_Pspf(PSPFVLTempl pSPFVLTempl, PSPF pSPF) throws Exception {
        pSPFVLTempl.setPSPFId(pSPF.getPSPFId());
        pSPFVLTempl.setPSPFName(pSPF.getPSPFName());
    }

    protected void onFillParentInfo_PSViewLogicType(PSPFVLTempl pSPFVLTempl, PSViewLogicType pSViewLogicType) throws Exception {
        pSPFVLTempl.setPSViewLogicTypeId(pSViewLogicType.getPSViewLogicTypeId());
        pSPFVLTempl.setPSViewLogicTypeName(pSViewLogicType.getPSViewLogicTypeName());
    }

    protected void onFillEntityFullInfo(PSPFVLTempl pSPFVLTempl, boolean bl) throws Exception {
        if (bl) {
            // empty if block
        }
        super.onFillEntityFullInfo(pSPFVLTempl, bl);
        this.onFillEntityFullInfo_PSPFPubCode(pSPFVLTempl, bl);
        this.onFillEntityFullInfo_PSPFStyle(pSPFVLTempl, bl);
        this.onFillEntityFullInfo_Pspf(pSPFVLTempl, bl);
        this.onFillEntityFullInfo_PSViewLogicType(pSPFVLTempl, bl);
    }

    protected void onFillEntityFullInfo_PSPFPubCode(PSPFVLTempl pSPFVLTempl, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSPFStyle(PSPFVLTempl pSPFVLTempl, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_Pspf(PSPFVLTempl pSPFVLTempl, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSViewLogicType(PSPFVLTempl pSPFVLTempl, boolean bl) throws Exception {
    }

    protected void onWriteBackParent(PSPFVLTempl pSPFVLTempl, boolean bl) throws Exception {
        super.onWriteBackParent(pSPFVLTempl, bl);
    }

    public ArrayList<PSPFVLTempl> selectByPSPFPubCode(PSPFPubCodeBase pSPFPubCodeBase) throws Exception {
        return this.selectByPSPFPubCode(pSPFPubCodeBase, "", -1);
    }

    public ArrayList<PSPFVLTempl> selectByPSPFPubCode(PSPFPubCodeBase pSPFPubCodeBase, String string) throws Exception {
        return this.selectByPSPFPubCode(pSPFPubCodeBase, string, -1);
    }

    public ArrayList<PSPFVLTempl> selectByPSPFPubCode(PSPFPubCodeBase pSPFPubCodeBase, String string, int n) throws Exception {
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

    public ArrayList<PSPFVLTempl> selectByPSPFStyle(PSPFStyleBase pSPFStyleBase) throws Exception {
        return this.selectByPSPFStyle(pSPFStyleBase, "", -1);
    }

    public ArrayList<PSPFVLTempl> selectByPSPFStyle(PSPFStyleBase pSPFStyleBase, String string) throws Exception {
        return this.selectByPSPFStyle(pSPFStyleBase, string, -1);
    }

    public ArrayList<PSPFVLTempl> selectByPSPFStyle(PSPFStyleBase pSPFStyleBase, String string, int n) throws Exception {
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

    public ArrayList<PSPFVLTempl> selectByPspf(PSPFBase pSPFBase) throws Exception {
        return this.selectByPspf(pSPFBase, "", -1);
    }

    public ArrayList<PSPFVLTempl> selectByPspf(PSPFBase pSPFBase, String string) throws Exception {
        return this.selectByPspf(pSPFBase, string, -1);
    }

    public ArrayList<PSPFVLTempl> selectByPspf(PSPFBase pSPFBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSPFID", (Object)pSPFBase.getPSPFId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPspfCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPspfCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSPFVLTempl> selectByPSViewLogicType(PSViewLogicTypeBase pSViewLogicTypeBase) throws Exception {
        return this.selectByPSViewLogicType(pSViewLogicTypeBase, "", -1);
    }

    public ArrayList<PSPFVLTempl> selectByPSViewLogicType(PSViewLogicTypeBase pSViewLogicTypeBase, String string) throws Exception {
        return this.selectByPSViewLogicType(pSViewLogicTypeBase, string, -1);
    }

    public ArrayList<PSPFVLTempl> selectByPSViewLogicType(PSViewLogicTypeBase pSViewLogicTypeBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSVIEWLOGICTYPEID", (Object)pSViewLogicTypeBase.getPSViewLogicTypeId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSViewLogicTypeCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSViewLogicTypeCond(SelectCond selectCond) throws Exception {
    }

    public void testRemoveByPSPFPubCode(PSPFPubCode pSPFPubCode) throws Exception {
        ArrayList<PSPFVLTempl> arrayList = this.selectByPSPFPubCode(pSPFPubCode, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSPFPUBCODE");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSPFPubCode);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSPFVLTEMPL_PSPFPUBCODE_PSPFPUBCODEID", "", iDataEntityModel.getName(), "PSPFVLTEMPL", iDataEntityModel.getDataInfo(pSPFPubCode), arrayList.get(0)));
        }
    }

    public void resetPSPFPubCode(PSPFPubCode pSPFPubCode) throws Exception {
        ArrayList<PSPFVLTempl> arrayList = this.selectByPSPFPubCode(pSPFPubCode);
        for (PSPFVLTempl pSPFVLTempl : arrayList) {
            PSPFVLTempl pSPFVLTempl2 = (PSPFVLTempl)this.getDEModel().createEntity();
            pSPFVLTempl2.setPSPFVLTemplId(pSPFVLTempl.getPSPFVLTemplId());
            pSPFVLTempl2.setPSPFPubCodeId(null);
            this.update(pSPFVLTempl2);
        }
    }

    public void removeByPSPFPubCode(PSPFPubCode pSPFPubCode) throws Exception {
        final PSPFPubCode pSPFPubCode2 = pSPFPubCode;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSPFVLTemplServiceBase.this.onBeforeRemoveByPSPFPubCode(pSPFPubCode2);
                PSPFVLTemplServiceBase.this.internalRemoveByPSPFPubCode(pSPFPubCode2);
                PSPFVLTemplServiceBase.this.onAfterRemoveByPSPFPubCode(pSPFPubCode2);
            }
        });
    }

    protected void onBeforeRemoveByPSPFPubCode(PSPFPubCode pSPFPubCode) throws Exception {
    }

    protected void internalRemoveByPSPFPubCode(PSPFPubCode pSPFPubCode) throws Exception {
        ArrayList<PSPFVLTempl> arrayList = this.selectByPSPFPubCode(pSPFPubCode);
        this.onBeforeRemoveByPSPFPubCode(pSPFPubCode, arrayList);
        for (PSPFVLTempl pSPFVLTempl : arrayList) {
            this.remove(pSPFVLTempl);
        }
        this.onAfterRemoveByPSPFPubCode(pSPFPubCode, arrayList);
    }

    protected void onAfterRemoveByPSPFPubCode(PSPFPubCode pSPFPubCode) throws Exception {
    }

    protected void onBeforeRemoveByPSPFPubCode(PSPFPubCode pSPFPubCode, ArrayList<PSPFVLTempl> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSPFPubCode(PSPFPubCode pSPFPubCode, ArrayList<PSPFVLTempl> arrayList) throws Exception {
    }

    public void testRemoveByPSPFStyle(PSPFStyle pSPFStyle) throws Exception {
    }

    public void resetPSPFStyle(PSPFStyle pSPFStyle) throws Exception {
        ArrayList<PSPFVLTempl> arrayList = this.selectByPSPFStyle(pSPFStyle);
        for (PSPFVLTempl pSPFVLTempl : arrayList) {
            PSPFVLTempl pSPFVLTempl2 = (PSPFVLTempl)this.getDEModel().createEntity();
            pSPFVLTempl2.setPSPFVLTemplId(pSPFVLTempl.getPSPFVLTemplId());
            pSPFVLTempl2.setPSPFStyleId(null);
            this.update(pSPFVLTempl2);
        }
    }

    public void removeByPSPFStyle(PSPFStyle pSPFStyle) throws Exception {
        final PSPFStyle pSPFStyle2 = pSPFStyle;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSPFVLTemplServiceBase.this.onBeforeRemoveByPSPFStyle(pSPFStyle2);
                PSPFVLTemplServiceBase.this.internalRemoveByPSPFStyle(pSPFStyle2);
                PSPFVLTemplServiceBase.this.onAfterRemoveByPSPFStyle(pSPFStyle2);
            }
        });
    }

    protected void onBeforeRemoveByPSPFStyle(PSPFStyle pSPFStyle) throws Exception {
    }

    protected void internalRemoveByPSPFStyle(PSPFStyle pSPFStyle) throws Exception {
        ArrayList<PSPFVLTempl> arrayList = this.selectByPSPFStyle(pSPFStyle);
        this.onBeforeRemoveByPSPFStyle(pSPFStyle, arrayList);
        for (PSPFVLTempl pSPFVLTempl : arrayList) {
            this.remove(pSPFVLTempl);
        }
        this.onAfterRemoveByPSPFStyle(pSPFStyle, arrayList);
    }

    protected void onAfterRemoveByPSPFStyle(PSPFStyle pSPFStyle) throws Exception {
    }

    protected void onBeforeRemoveByPSPFStyle(PSPFStyle pSPFStyle, ArrayList<PSPFVLTempl> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSPFStyle(PSPFStyle pSPFStyle, ArrayList<PSPFVLTempl> arrayList) throws Exception {
    }

    public void testRemoveByPspf(PSPF pSPF) throws Exception {
        ArrayList<PSPFVLTempl> arrayList = this.selectByPspf(pSPF, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSPF");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSPF);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSPFVLTEMPL_PSPF_PSPFID", "", iDataEntityModel.getName(), "PSPFVLTEMPL", iDataEntityModel.getDataInfo(pSPF), arrayList.get(0)));
        }
    }

    public void resetPspf(PSPF pSPF) throws Exception {
        ArrayList<PSPFVLTempl> arrayList = this.selectByPspf(pSPF);
        for (PSPFVLTempl pSPFVLTempl : arrayList) {
            PSPFVLTempl pSPFVLTempl2 = (PSPFVLTempl)this.getDEModel().createEntity();
            pSPFVLTempl2.setPSPFVLTemplId(pSPFVLTempl.getPSPFVLTemplId());
            pSPFVLTempl2.setPSPFId(null);
            this.update(pSPFVLTempl2);
        }
    }

    public void removeByPspf(PSPF pSPF) throws Exception {
        final PSPF pSPF2 = pSPF;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSPFVLTemplServiceBase.this.onBeforeRemoveByPspf(pSPF2);
                PSPFVLTemplServiceBase.this.internalRemoveByPspf(pSPF2);
                PSPFVLTemplServiceBase.this.onAfterRemoveByPspf(pSPF2);
            }
        });
    }

    protected void onBeforeRemoveByPspf(PSPF pSPF) throws Exception {
    }

    protected void internalRemoveByPspf(PSPF pSPF) throws Exception {
        ArrayList<PSPFVLTempl> arrayList = this.selectByPspf(pSPF);
        this.onBeforeRemoveByPspf(pSPF, arrayList);
        for (PSPFVLTempl pSPFVLTempl : arrayList) {
            this.remove(pSPFVLTempl);
        }
        this.onAfterRemoveByPspf(pSPF, arrayList);
    }

    protected void onAfterRemoveByPspf(PSPF pSPF) throws Exception {
    }

    protected void onBeforeRemoveByPspf(PSPF pSPF, ArrayList<PSPFVLTempl> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPspf(PSPF pSPF, ArrayList<PSPFVLTempl> arrayList) throws Exception {
    }

    public void testRemoveByPSViewLogicType(PSViewLogicType pSViewLogicType) throws Exception {
        ArrayList<PSPFVLTempl> arrayList = this.selectByPSViewLogicType(pSViewLogicType, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSVIEWLOGICTYPE");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSViewLogicType);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSPFVLTEMPL_PSVIEWLOGICTYPE_PSVIEWLOGICTYPEID", "", iDataEntityModel.getName(), "PSPFVLTEMPL", iDataEntityModel.getDataInfo(pSViewLogicType), arrayList.get(0)));
        }
    }

    public void resetPSViewLogicType(PSViewLogicType pSViewLogicType) throws Exception {
        ArrayList<PSPFVLTempl> arrayList = this.selectByPSViewLogicType(pSViewLogicType);
        for (PSPFVLTempl pSPFVLTempl : arrayList) {
            PSPFVLTempl pSPFVLTempl2 = (PSPFVLTempl)this.getDEModel().createEntity();
            pSPFVLTempl2.setPSPFVLTemplId(pSPFVLTempl.getPSPFVLTemplId());
            pSPFVLTempl2.setPSViewLogicTypeId(null);
            this.update(pSPFVLTempl2);
        }
    }

    public void removeByPSViewLogicType(PSViewLogicType pSViewLogicType) throws Exception {
        final PSViewLogicType pSViewLogicType2 = pSViewLogicType;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSPFVLTemplServiceBase.this.onBeforeRemoveByPSViewLogicType(pSViewLogicType2);
                PSPFVLTemplServiceBase.this.internalRemoveByPSViewLogicType(pSViewLogicType2);
                PSPFVLTemplServiceBase.this.onAfterRemoveByPSViewLogicType(pSViewLogicType2);
            }
        });
    }

    protected void onBeforeRemoveByPSViewLogicType(PSViewLogicType pSViewLogicType) throws Exception {
    }

    protected void internalRemoveByPSViewLogicType(PSViewLogicType pSViewLogicType) throws Exception {
        ArrayList<PSPFVLTempl> arrayList = this.selectByPSViewLogicType(pSViewLogicType);
        this.onBeforeRemoveByPSViewLogicType(pSViewLogicType, arrayList);
        for (PSPFVLTempl pSPFVLTempl : arrayList) {
            this.remove(pSPFVLTempl);
        }
        this.onAfterRemoveByPSViewLogicType(pSViewLogicType, arrayList);
    }

    protected void onAfterRemoveByPSViewLogicType(PSViewLogicType pSViewLogicType) throws Exception {
    }

    protected void onBeforeRemoveByPSViewLogicType(PSViewLogicType pSViewLogicType, ArrayList<PSPFVLTempl> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSViewLogicType(PSViewLogicType pSViewLogicType, ArrayList<PSPFVLTempl> arrayList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(PSPFVLTempl pSPFVLTempl) throws Exception {
        super.onBeforeRemove(pSPFVLTempl);
    }

    protected void replaceParentInfo(PSPFVLTempl pSPFVLTempl, CloneSession cloneSession) throws Exception {
        IEntity iEntity;
        super.replaceParentInfo(pSPFVLTempl, cloneSession);
        if (pSPFVLTempl.getPSPFPubCodeId() != null && (iEntity = cloneSession.getEntity("PSPFPUBCODE", (Object)pSPFVLTempl.getPSPFPubCodeId())) != null) {
            this.onFillParentInfo_PSPFPubCode(pSPFVLTempl, (PSPFPubCode)iEntity);
        }
        if (pSPFVLTempl.getPSPFStyleId() != null && (iEntity = cloneSession.getEntity("PSPFSTYLE", (Object)pSPFVLTempl.getPSPFStyleId())) != null) {
            this.onFillParentInfo_PSPFStyle(pSPFVLTempl, (PSPFStyle)iEntity);
        }
        if (pSPFVLTempl.getPSPFId() != null && (iEntity = cloneSession.getEntity("PSPF", (Object)pSPFVLTempl.getPSPFId())) != null) {
            this.onFillParentInfo_Pspf(pSPFVLTempl, (PSPF)iEntity);
        }
        if (pSPFVLTempl.getPSViewLogicTypeId() != null && (iEntity = cloneSession.getEntity("PSVIEWLOGICTYPE", (Object)pSPFVLTempl.getPSViewLogicTypeId())) != null) {
            this.onFillParentInfo_PSViewLogicType(pSPFVLTempl, (PSViewLogicType)iEntity);
        }
    }

    protected void onRemoveEntityUncopyValues(PSPFVLTempl pSPFVLTempl, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues(pSPFVLTempl, bl);
    }

    protected void onCheckEntity(boolean bl, PSPFVLTempl pSPFVLTempl, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_Memo(bl, pSPFVLTempl, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ProcessName(bl, pSPFVLTempl, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSPFId(bl, pSPFVLTempl, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSPFPubCodeId(bl, pSPFVLTempl, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSPFStyleId(bl, pSPFVLTempl, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSPFVLTemplId(bl, pSPFVLTempl, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSPFVLTemplName(bl, pSPFVLTempl, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSViewLogicTypeId(bl, pSPFVLTempl, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PubObj(bl, pSPFVLTempl, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_TemplCode(bl, pSPFVLTempl, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_TemplCode2(bl, pSPFVLTempl, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_TemplCode3(bl, pSPFVLTempl, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_TemplCode4(bl, pSPFVLTempl, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, pSPFVLTempl, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_Memo(boolean bl, PSPFVLTempl pSPFVLTempl, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSPFVLTempl.isMemoDirty() : !pSPFVLTempl.isMemoDirty()) {
            return null;
        }
        String string = pSPFVLTempl.getMemo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Memo_Default(pSPFVLTempl, bl2, bl3);
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

    protected EntityFieldError onCheckField_ProcessName(boolean bl, PSPFVLTempl pSPFVLTempl, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSPFVLTempl.isProcessNameDirty() && !bl2 : !pSPFVLTempl.isProcessNameDirty()) {
            return null;
        }
        String string = pSPFVLTempl.getProcessName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PROCESSNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_ProcessName_Default(pSPFVLTempl, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PROCESSNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSPFId(boolean bl, PSPFVLTempl pSPFVLTempl, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSPFVLTempl.isPSPFIdDirty() && !bl2 : !pSPFVLTempl.isPSPFIdDirty()) {
            return null;
        }
        String string = pSPFVLTempl.getPSPFId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSPFID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSPFId_Default(pSPFVLTempl, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSPFPubCodeId(boolean bl, PSPFVLTempl pSPFVLTempl, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSPFVLTempl.isPSPFPubCodeIdDirty() && !bl2 : !pSPFVLTempl.isPSPFPubCodeIdDirty()) {
            return null;
        }
        String string = pSPFVLTempl.getPSPFPubCodeId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSPFPUBCODEID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSPFPubCodeId_Default(pSPFVLTempl, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSPFStyleId(boolean bl, PSPFVLTempl pSPFVLTempl, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSPFVLTempl.isPSPFStyleIdDirty() && !bl2 : !pSPFVLTempl.isPSPFStyleIdDirty()) {
            return null;
        }
        String string = pSPFVLTempl.getPSPFStyleId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSPFSTYLEID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSPFStyleId_Default(pSPFVLTempl, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSPFVLTemplId(boolean bl, PSPFVLTempl pSPFVLTempl, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSPFVLTempl.isPSPFVLTemplIdDirty() && !bl2 : !pSPFVLTempl.isPSPFVLTemplIdDirty()) {
            return null;
        }
        String string = pSPFVLTempl.getPSPFVLTemplId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSPFVLTEMPLID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSPFVLTemplId_Default(pSPFVLTempl, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSPFVLTEMPLID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSPFVLTemplName(boolean bl, PSPFVLTempl pSPFVLTempl, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSPFVLTempl.isPSPFVLTemplNameDirty() && !bl2 : !pSPFVLTempl.isPSPFVLTemplNameDirty()) {
            return null;
        }
        String string = pSPFVLTempl.getPSPFVLTemplName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSPFVLTEMPLNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSPFVLTemplName_Default(pSPFVLTempl, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSPFVLTEMPLNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSViewLogicTypeId(boolean bl, PSPFVLTempl pSPFVLTempl, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSPFVLTempl.isPSViewLogicTypeIdDirty() && !bl2 : !pSPFVLTempl.isPSViewLogicTypeIdDirty()) {
            return null;
        }
        String string = pSPFVLTempl.getPSViewLogicTypeId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSVIEWLOGICTYPEID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSViewLogicTypeId_Default(pSPFVLTempl, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSVIEWLOGICTYPEID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PubObj(boolean bl, PSPFVLTempl pSPFVLTempl, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSPFVLTempl.isPubObjDirty() : !pSPFVLTempl.isPubObjDirty()) {
            return null;
        }
        String string = pSPFVLTempl.getPubObj();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PubObj_Default(pSPFVLTempl, bl2, bl3);
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

    protected EntityFieldError onCheckField_TemplCode(boolean bl, PSPFVLTempl pSPFVLTempl, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSPFVLTempl.isTemplCodeDirty() && !bl2 : !pSPFVLTempl.isTemplCodeDirty()) {
            return null;
        }
        String string = pSPFVLTempl.getTemplCode();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("TEMPLCODE");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_TemplCode_Default(pSPFVLTempl, bl2, bl3);
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

    protected EntityFieldError onCheckField_TemplCode2(boolean bl, PSPFVLTempl pSPFVLTempl, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSPFVLTempl.isTemplCode2Dirty() : !pSPFVLTempl.isTemplCode2Dirty()) {
            return null;
        }
        String string = pSPFVLTempl.getTemplCode2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_TemplCode2_Default(pSPFVLTempl, bl2, bl3);
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

    protected EntityFieldError onCheckField_TemplCode3(boolean bl, PSPFVLTempl pSPFVLTempl, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSPFVLTempl.isTemplCode3Dirty() : !pSPFVLTempl.isTemplCode3Dirty()) {
            return null;
        }
        String string = pSPFVLTempl.getTemplCode3();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_TemplCode3_Default(pSPFVLTempl, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("TEMPLCODE3");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_TemplCode4(boolean bl, PSPFVLTempl pSPFVLTempl, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSPFVLTempl.isTemplCode4Dirty() : !pSPFVLTempl.isTemplCode4Dirty()) {
            return null;
        }
        String string = pSPFVLTempl.getTemplCode4();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_TemplCode4_Default(pSPFVLTempl, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("TEMPLCODE4");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected void onSyncEntity(PSPFVLTempl pSPFVLTempl, boolean bl) throws Exception {
        super.onSyncEntity(pSPFVLTempl, bl);
    }

    protected void onSyncIndexEntities(PSPFVLTempl pSPFVLTempl, boolean bl) throws Exception {
        super.onSyncIndexEntities(pSPFVLTempl, bl);
    }

    public Object getDataContextValue(PSPFVLTempl pSPFVLTempl, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null) {
            // empty if block
        }
        if ((object = super.getDataContextValue(pSPFVLTempl, string, iDataContextParam)) != null) {
            return object;
        }
        return null;
    }

    protected void onExportMajorModel(PSPFVLTempl pSPFVLTempl, ArrayList<JSONObject> arrayList, int n) throws Exception {
        super.onExportMajorModel(pSPFVLTempl, arrayList, n);
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
        if (StringHelper.compare((String)string, (String)"PROCESSNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ProcessName_Default(iEntity, bl, bl2);
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
        if (StringHelper.compare((String)string, (String)"PSPFVLTEMPLID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSPFVLTemplId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSPFVLTEMPLNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSPFVLTemplName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSVIEWLOGICTYPEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSViewLogicTypeId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSVIEWLOGICTYPENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSViewLogicTypeName_Default(iEntity, bl, bl2);
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
        if (StringHelper.compare((String)string, (String)"TEMPLCODE3", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_TemplCode3_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"TEMPLCODE4", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_TemplCode4_Default(iEntity, bl, bl2);
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

    protected String onTestValueRule_ProcessName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PROCESSNAME", iEntity, bl2, null, false, 60, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]";
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

    protected String onTestValueRule_PSPFVLTemplId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSPFVLTEMPLID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSPFVLTemplName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSPFVLTEMPLNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSViewLogicTypeId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSVIEWLOGICTYPEID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSViewLogicTypeName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSVIEWLOGICTYPENAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
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
            if (this.checkFieldStringLengthRule("TEMPLCODE2", iEntity, bl2, null, false, 4000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[4000]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[4000]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_TemplCode3_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("TEMPLCODE3", iEntity, bl2, null, false, 4000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[4000]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[4000]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_TemplCode4_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("TEMPLCODE4", iEntity, bl2, null, false, 4000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[4000]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[4000]";
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

    protected boolean onMergeChild(String string, String string2, PSPFVLTempl pSPFVLTempl) throws Exception {
        boolean bl = false;
        if (super.onMergeChild(string, string2, pSPFVLTempl)) {
            bl = true;
        }
        return bl;
    }

    protected void onUpdateParent(PSPFVLTempl pSPFVLTempl) throws Exception {
        super.onUpdateParent(pSPFVLTempl);
    }

    @Override
    protected void exportCurXmlModel(PSPFVLTempl pSPFVLTempl, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSPFVLTEMPL");
        if (!bl) {
            pSPFVLTempl.setCreateDate(null);
            pSPFVLTempl.setCreateMan(null);
            pSPFVLTempl.setPSPFVLTemplId(null);
            pSPFVLTempl.setUpdateDate(null);
            pSPFVLTempl.setUpdateMan(null);
            super.exportCurXmlModel(pSPFVLTempl, xmlNode, bl);
        }
    }
}

