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
 *  net.ibizsys.paas.service.IServicePlugin
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
package net.ibizsys.pscore.srv.devcenter.service;

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
import net.ibizsys.paas.service.IServicePlugin;
import net.ibizsys.paas.service.IServiceWork;
import net.ibizsys.paas.service.ITransaction;
import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.paas.util.DataTypeHelper;
import net.ibizsys.paas.util.KeyValueHelper;
import net.ibizsys.paas.util.StringBuilderEx;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.xml.XmlNode;
import net.ibizsys.pscore.srv.PSCoreSysServiceBase;
import net.ibizsys.pscore.srv.config.entity.PSPF;
import net.ibizsys.pscore.srv.config.entity.PSPFBase;
import net.ibizsys.pscore.srv.core.IPSDataEntityModel;
import net.ibizsys.pscore.srv.devcenter.dao.PSDCPFPITemplDAO;
import net.ibizsys.pscore.srv.devcenter.demodel.PSDCPFPITemplDEModel;
import net.ibizsys.pscore.srv.devcenter.entity.PSDCPFPITempl;
import net.ibizsys.pscore.srv.devcenter.entity.PSDCPFPlugin;
import net.ibizsys.pscore.srv.devcenter.entity.PSDCPFPluginBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSystem;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDCPFPITemplServiceBase
extends PSCoreSysServiceBase<PSDCPFPITempl> {
    private static final Log log = LogFactory.getLog(PSDCPFPITemplServiceBase.class);
    public static final String DATASET_DEFAULT = "DEFAULT";
    public static final String ACTION_CALCTEMPLCODEINFO = "CalcTemplCodeInfo";
    public static final String ACTION_CREATEWITHTIPS = "CreateWithTips";
    public static final String ACTION_GETDRAFTWITHTIPS = "GetDraftWithTips";
    public static final String ACTION_GETWITHTIPS = "GetWithTips";
    public static final String ACTION_UPDATEWITHTIPS = "UpdateWithTips";
    private PSDCPFPITemplDEModel pSDCPFPITemplDEModel;
    private PSDCPFPITemplDAO pSDCPFPITemplDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.devcenter.service.PSDCPFPITemplService";
    }

    public PSDCPFPITemplDEModel getPSDCPFPITemplDEModel() {
        if (this.pSDCPFPITemplDEModel == null) {
            try {
                this.pSDCPFPITemplDEModel = (PSDCPFPITemplDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.devcenter.demodel.PSDCPFPITemplDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDCPFPITemplDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSDCPFPITemplDEModel();
    }

    public PSDCPFPITemplDAO getPSDCPFPITemplDAO() {
        if (this.pSDCPFPITemplDAO == null) {
            try {
                this.pSDCPFPITemplDAO = (PSDCPFPITemplDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.devcenter.dao.PSDCPFPITemplDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDCPFPITemplDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSDCPFPITemplDAO();
    }

    protected DBFetchResult onfetchDataSet(String string, IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        if (StringHelper.compare((String)string, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.fetchDefault(iDEDataSetFetchContext);
        }
        return super.onfetchDataSet(string, iDEDataSetFetchContext);
    }

    @Override
    protected void onExecuteAction(String string, IEntity iEntity) throws Exception {
        if (StringHelper.compare((String)string, (String)ACTION_CALCTEMPLCODEINFO, (boolean)true) == 0) {
            this.calcTemplCodeInfo((PSDCPFPITempl)iEntity);
            return;
        }
        if (StringHelper.compare((String)string, (String)ACTION_CREATEWITHTIPS, (boolean)true) == 0) {
            this.createWithTips((PSDCPFPITempl)iEntity);
            return;
        }
        if (StringHelper.compare((String)string, (String)ACTION_GETDRAFTWITHTIPS, (boolean)true) == 0) {
            this.getDraftWithTips((PSDCPFPITempl)iEntity);
            return;
        }
        if (StringHelper.compare((String)string, (String)ACTION_GETWITHTIPS, (boolean)true) == 0) {
            this.getWithTips((PSDCPFPITempl)iEntity);
            return;
        }
        if (StringHelper.compare((String)string, (String)ACTION_UPDATEWITHTIPS, (boolean)true) == 0) {
            this.updateWithTips((PSDCPFPITempl)iEntity);
            return;
        }
        super.onExecuteAction(string, iEntity);
    }

    public DBFetchResult fetchDefault(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_DEFAULT, false);
        return dBFetchResult;
    }

    public void calcTemplCodeInfo(PSDCPFPITempl pSDCPFPITempl) throws Exception {
        final IServicePlugin iServicePlugin = this.getPlugin();
        if (iServicePlugin != null && iServicePlugin.doCustomAction((IService)this, ACTION_CALCTEMPLCODEINFO, 0, pSDCPFPITempl, null).getResult() == 1) {
            return;
        }
        this.testDEMainStateAction(pSDCPFPITempl, ACTION_CALCTEMPLCODEINFO);
        final PSDCPFPITempl pSDCPFPITempl2 = pSDCPFPITempl;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                if (iServicePlugin == null || iServicePlugin.doCustomAction(PSDCPFPITemplServiceBase.this.getService(), PSDCPFPITemplServiceBase.ACTION_CALCTEMPLCODEINFO, 40, pSDCPFPITempl2, null).getResult() != 1) {
                    PSDCPFPITemplServiceBase.this.onCalcTemplCodeInfo(pSDCPFPITempl2);
                }
            }
        });
        if (iServicePlugin != null) {
            iServicePlugin.doCustomAction((IService)this, ACTION_CALCTEMPLCODEINFO, 99, pSDCPFPITempl, null);
        }
    }

    protected void onCalcTemplCodeInfo(PSDCPFPITempl pSDCPFPITempl) throws Exception {
        throw new Exception("\u6ca1\u6709\u5b9e\u73b0\u81ea\u5b9a\u4e49\u884c\u4e3a[CalcTemplCodeInfo]");
    }

    public void createWithTips(PSDCPFPITempl pSDCPFPITempl) throws Exception {
        final IServicePlugin iServicePlugin = this.getPlugin();
        if (iServicePlugin != null && iServicePlugin.doCustomAction((IService)this, ACTION_CREATEWITHTIPS, 0, pSDCPFPITempl, null).getResult() == 1) {
            return;
        }
        this.testDEMainStateAction(pSDCPFPITempl, ACTION_CREATEWITHTIPS);
        final PSDCPFPITempl pSDCPFPITempl2 = pSDCPFPITempl;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                if (iServicePlugin == null || iServicePlugin.doCustomAction(PSDCPFPITemplServiceBase.this.getService(), PSDCPFPITemplServiceBase.ACTION_CREATEWITHTIPS, 40, pSDCPFPITempl2, null).getResult() != 1) {
                    PSDCPFPITemplServiceBase.this.onCreateWithTips(pSDCPFPITempl2);
                }
            }
        });
        if (iServicePlugin != null) {
            iServicePlugin.doCustomAction((IService)this, ACTION_CREATEWITHTIPS, 99, pSDCPFPITempl, null);
        }
    }

    protected void onCreateWithTips(PSDCPFPITempl pSDCPFPITempl) throws Exception {
        throw new Exception("\u6ca1\u6709\u5b9e\u73b0\u81ea\u5b9a\u4e49\u884c\u4e3a[CreateWithTips]");
    }

    public void getDraftWithTips(PSDCPFPITempl pSDCPFPITempl) throws Exception {
        final IServicePlugin iServicePlugin = this.getPlugin();
        if (iServicePlugin != null && iServicePlugin.doCustomAction((IService)this, ACTION_GETDRAFTWITHTIPS, 0, pSDCPFPITempl, null).getResult() == 1) {
            return;
        }
        this.testDEMainStateAction(pSDCPFPITempl, ACTION_GETDRAFTWITHTIPS);
        final PSDCPFPITempl pSDCPFPITempl2 = pSDCPFPITempl;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                if (iServicePlugin == null || iServicePlugin.doCustomAction(PSDCPFPITemplServiceBase.this.getService(), PSDCPFPITemplServiceBase.ACTION_GETDRAFTWITHTIPS, 40, pSDCPFPITempl2, null).getResult() != 1) {
                    PSDCPFPITemplServiceBase.this.onGetDraftWithTips(pSDCPFPITempl2);
                }
            }
        });
        if (iServicePlugin != null) {
            iServicePlugin.doCustomAction((IService)this, ACTION_GETDRAFTWITHTIPS, 99, pSDCPFPITempl, null);
        }
    }

    protected void onGetDraftWithTips(PSDCPFPITempl pSDCPFPITempl) throws Exception {
        throw new Exception("\u6ca1\u6709\u5b9e\u73b0\u81ea\u5b9a\u4e49\u884c\u4e3a[GetDraftWithTips]");
    }

    public void getWithTips(PSDCPFPITempl pSDCPFPITempl) throws Exception {
        final IServicePlugin iServicePlugin = this.getPlugin();
        if (iServicePlugin != null && iServicePlugin.doCustomAction((IService)this, ACTION_GETWITHTIPS, 0, pSDCPFPITempl, null).getResult() == 1) {
            return;
        }
        this.testDEMainStateAction(pSDCPFPITempl, ACTION_GETWITHTIPS);
        final PSDCPFPITempl pSDCPFPITempl2 = pSDCPFPITempl;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                if (iServicePlugin == null || iServicePlugin.doCustomAction(PSDCPFPITemplServiceBase.this.getService(), PSDCPFPITemplServiceBase.ACTION_GETWITHTIPS, 40, pSDCPFPITempl2, null).getResult() != 1) {
                    PSDCPFPITemplServiceBase.this.onGetWithTips(pSDCPFPITempl2);
                }
            }
        });
        if (iServicePlugin != null) {
            iServicePlugin.doCustomAction((IService)this, ACTION_GETWITHTIPS, 99, pSDCPFPITempl, null);
        }
    }

    protected void onGetWithTips(PSDCPFPITempl pSDCPFPITempl) throws Exception {
        throw new Exception("\u6ca1\u6709\u5b9e\u73b0\u81ea\u5b9a\u4e49\u884c\u4e3a[GetWithTips]");
    }

    public void updateWithTips(PSDCPFPITempl pSDCPFPITempl) throws Exception {
        final IServicePlugin iServicePlugin = this.getPlugin();
        if (iServicePlugin != null && iServicePlugin.doCustomAction((IService)this, ACTION_UPDATEWITHTIPS, 0, pSDCPFPITempl, null).getResult() == 1) {
            return;
        }
        this.testDEMainStateAction(pSDCPFPITempl, ACTION_UPDATEWITHTIPS);
        final PSDCPFPITempl pSDCPFPITempl2 = pSDCPFPITempl;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                if (iServicePlugin == null || iServicePlugin.doCustomAction(PSDCPFPITemplServiceBase.this.getService(), PSDCPFPITemplServiceBase.ACTION_UPDATEWITHTIPS, 40, pSDCPFPITempl2, null).getResult() != 1) {
                    PSDCPFPITemplServiceBase.this.onUpdateWithTips(pSDCPFPITempl2);
                }
            }
        });
        if (iServicePlugin != null) {
            iServicePlugin.doCustomAction((IService)this, ACTION_UPDATEWITHTIPS, 99, pSDCPFPITempl, null);
        }
    }

    protected void onUpdateWithTips(PSDCPFPITempl pSDCPFPITempl) throws Exception {
        throw new Exception("\u6ca1\u6709\u5b9e\u73b0\u81ea\u5b9a\u4e49\u884c\u4e3a[UpdateWithTips]");
    }

    protected void onFillParentInfo(PSDCPFPITempl pSDCPFPITempl, String string, String string2, String string3) throws Exception {
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDCPFPITEMPL_PSDCPFPLUGIN_PSDCPFPLUGINID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.devcenter.service.PSDCPFPluginService", (SessionFactory)this.getSessionFactory());
            PSDCPFPlugin pSDCPFPlugin = (PSDCPFPlugin)iService.getDEModel().createEntity();
            pSDCPFPlugin.set("PSDCPFPLUGINID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDCPFPlugin);
            } else {
                iService.get(pSDCPFPlugin);
            }
            this.onFillParentInfo_PSDCPFPlugin(pSDCPFPITempl, pSDCPFPlugin);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDCPFPITEMPL_PSPF_PSPFID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.config.service.PSPFService", (SessionFactory)this.getSessionFactory());
            PSPF pSPF = (PSPF)iService.getDEModel().createEntity();
            pSPF.set("PSPFID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSPF);
            } else {
                iService.get(pSPF);
            }
            this.onFillParentInfo_PSPF(pSDCPFPITempl, pSPF);
            return;
        }
        super.onFillParentInfo(pSDCPFPITempl, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillParentInfo_PSDCPFPlugin(PSDCPFPITempl pSDCPFPITempl, PSDCPFPlugin pSDCPFPlugin) throws Exception {
        pSDCPFPITempl.setPSDCPFPluginId(pSDCPFPlugin.getPSDCPFPluginId());
        pSDCPFPITempl.setPSDCPFPluginName(pSDCPFPlugin.getPSDCPFPluginName());
    }

    protected void onFillParentInfo_PSPF(PSDCPFPITempl pSDCPFPITempl, PSPF pSPF) throws Exception {
        pSDCPFPITempl.setPSPFId(pSPF.getPSPFId());
        pSDCPFPITempl.setPSPFName(pSPF.getPSPFName());
    }

    protected boolean onFillEntityKeyValue(PSDCPFPITempl pSDCPFPITempl, boolean bl) throws Exception {
        StringBuilderEx stringBuilderEx = new StringBuilderEx();
        Object object = pSDCPFPITempl.get("PSDCPFPLUGINID");
        if (object == null) {
            object = "__EMTPY__";
        }
        stringBuilderEx.append("%1$s", object);
        stringBuilderEx.append("||");
        Object object2 = pSDCPFPITempl.get("PSPFID");
        if (object2 == null) {
            object2 = "__EMTPY__";
        }
        stringBuilderEx.append("%1$s", object2);
        String string = stringBuilderEx.toString();
        pSDCPFPITempl.set(this.getPSDCPFPITemplDEModel().getKeyDEField().getName(), KeyValueHelper.genUniqueId((String)string));
        return true;
    }

    protected void onFillEntityFullInfo(PSDCPFPITempl pSDCPFPITempl, boolean bl) throws Exception {
        if (bl) {
            if (pSDCPFPITempl.getTemplCode2Flag() == null) {
                pSDCPFPITempl.setTemplCode2Flag((Integer)this.getDefaultValue(this.getWebContext(), "", "1", 9));
            }
            if (pSDCPFPITempl.getTemplCode3Flag() == null) {
                pSDCPFPITempl.setTemplCode3Flag((Integer)this.getDefaultValue(this.getWebContext(), "", "1", 9));
            }
            if (pSDCPFPITempl.getTemplCode4Flag() == null) {
                pSDCPFPITempl.setTemplCode4Flag((Integer)this.getDefaultValue(this.getWebContext(), "", "1", 9));
            }
            if (pSDCPFPITempl.getTemplCodeFlag() == null) {
                pSDCPFPITempl.setTemplCodeFlag((Integer)this.getDefaultValue(this.getWebContext(), "", "1", 9));
            }
        }
        super.onFillEntityFullInfo(pSDCPFPITempl, bl);
        this.onFillEntityFullInfo_PSDCPFPlugin(pSDCPFPITempl, bl);
        this.onFillEntityFullInfo_PSPF(pSDCPFPITempl, bl);
    }

    protected void onFillEntityFullInfo_PSDCPFPlugin(PSDCPFPITempl pSDCPFPITempl, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSPF(PSDCPFPITempl pSDCPFPITempl, boolean bl) throws Exception {
        if (pSDCPFPITempl.isPSPFIdDirty()) {
            if (pSDCPFPITempl.getPSPFId() != null) {
                if (pSDCPFPITempl.getPSPFId() == null || pSDCPFPITempl.getPSPFName() == null) {
                    PSPF pSPF = pSDCPFPITempl.getPSPF();
                    pSDCPFPITempl.setPSPFName(pSPF.getPSPFName());
                }
            } else {
                pSDCPFPITempl.setPSPFName(null);
            }
        }
    }

    protected void onWriteBackParent(PSDCPFPITempl pSDCPFPITempl, boolean bl) throws Exception {
        super.onWriteBackParent(pSDCPFPITempl, bl);
    }

    public ArrayList<PSDCPFPITempl> selectByPSDCPFPlugin(PSDCPFPluginBase pSDCPFPluginBase) throws Exception {
        return this.selectByPSDCPFPlugin(pSDCPFPluginBase, "", -1);
    }

    public ArrayList<PSDCPFPITempl> selectByPSDCPFPlugin(PSDCPFPluginBase pSDCPFPluginBase, String string) throws Exception {
        return this.selectByPSDCPFPlugin(pSDCPFPluginBase, string, -1);
    }

    public ArrayList<PSDCPFPITempl> selectByPSDCPFPlugin(PSDCPFPluginBase pSDCPFPluginBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDCPFPLUGINID", (Object)pSDCPFPluginBase.getPSDCPFPluginId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSDCPFPluginCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSDCPFPluginCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDCPFPITempl> selectByPSPF(PSPFBase pSPFBase) throws Exception {
        return this.selectByPSPF(pSPFBase, "", -1);
    }

    public ArrayList<PSDCPFPITempl> selectByPSPF(PSPFBase pSPFBase, String string) throws Exception {
        return this.selectByPSPF(pSPFBase, string, -1);
    }

    public ArrayList<PSDCPFPITempl> selectByPSPF(PSPFBase pSPFBase, String string, int n) throws Exception {
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

    public void testRemoveByPSDCPFPlugin(PSDCPFPlugin pSDCPFPlugin) throws Exception {
    }

    public void resetPSDCPFPlugin(PSDCPFPlugin pSDCPFPlugin) throws Exception {
        ArrayList<PSDCPFPITempl> arrayList = this.selectByPSDCPFPlugin(pSDCPFPlugin);
        for (PSDCPFPITempl pSDCPFPITempl : arrayList) {
            PSDCPFPITempl pSDCPFPITempl2 = (PSDCPFPITempl)this.getDEModel().createEntity();
            pSDCPFPITempl2.setPSDCPFPITemplId(pSDCPFPITempl.getPSDCPFPITemplId());
            pSDCPFPITempl2.setPSDCPFPluginId(null);
            this.update(pSDCPFPITempl2);
        }
    }

    public void removeByPSDCPFPlugin(PSDCPFPlugin pSDCPFPlugin) throws Exception {
        final PSDCPFPlugin pSDCPFPlugin2 = pSDCPFPlugin;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDCPFPITemplServiceBase.this.onBeforeRemoveByPSDCPFPlugin(pSDCPFPlugin2);
                PSDCPFPITemplServiceBase.this.internalRemoveByPSDCPFPlugin(pSDCPFPlugin2);
                PSDCPFPITemplServiceBase.this.onAfterRemoveByPSDCPFPlugin(pSDCPFPlugin2);
            }
        });
    }

    protected void onBeforeRemoveByPSDCPFPlugin(PSDCPFPlugin pSDCPFPlugin) throws Exception {
    }

    protected void internalRemoveByPSDCPFPlugin(PSDCPFPlugin pSDCPFPlugin) throws Exception {
        ArrayList<PSDCPFPITempl> arrayList = this.selectByPSDCPFPlugin(pSDCPFPlugin);
        this.onBeforeRemoveByPSDCPFPlugin(pSDCPFPlugin, arrayList);
        for (PSDCPFPITempl pSDCPFPITempl : arrayList) {
            this.remove(pSDCPFPITempl);
        }
        this.onAfterRemoveByPSDCPFPlugin(pSDCPFPlugin, arrayList);
    }

    protected void onAfterRemoveByPSDCPFPlugin(PSDCPFPlugin pSDCPFPlugin) throws Exception {
    }

    protected void onBeforeRemoveByPSDCPFPlugin(PSDCPFPlugin pSDCPFPlugin, ArrayList<PSDCPFPITempl> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDCPFPlugin(PSDCPFPlugin pSDCPFPlugin, ArrayList<PSDCPFPITempl> arrayList) throws Exception {
    }

    public void testRemoveByPSPF(PSPF pSPF) throws Exception {
    }

    public void resetPSPF(PSPF pSPF) throws Exception {
        ArrayList<PSDCPFPITempl> arrayList = this.selectByPSPF(pSPF);
        for (PSDCPFPITempl pSDCPFPITempl : arrayList) {
            PSDCPFPITempl pSDCPFPITempl2 = (PSDCPFPITempl)this.getDEModel().createEntity();
            pSDCPFPITempl2.setPSDCPFPITemplId(pSDCPFPITempl.getPSDCPFPITemplId());
            pSDCPFPITempl2.setPSPFId(null);
            this.update(pSDCPFPITempl2);
        }
    }

    public void removeByPSPF(PSPF pSPF) throws Exception {
        final PSPF pSPF2 = pSPF;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDCPFPITemplServiceBase.this.onBeforeRemoveByPSPF(pSPF2);
                PSDCPFPITemplServiceBase.this.internalRemoveByPSPF(pSPF2);
                PSDCPFPITemplServiceBase.this.onAfterRemoveByPSPF(pSPF2);
            }
        });
    }

    protected void onBeforeRemoveByPSPF(PSPF pSPF) throws Exception {
    }

    protected void internalRemoveByPSPF(PSPF pSPF) throws Exception {
        ArrayList<PSDCPFPITempl> arrayList = this.selectByPSPF(pSPF);
        this.onBeforeRemoveByPSPF(pSPF, arrayList);
        for (PSDCPFPITempl pSDCPFPITempl : arrayList) {
            this.remove(pSDCPFPITempl);
        }
        this.onAfterRemoveByPSPF(pSPF, arrayList);
    }

    protected void onAfterRemoveByPSPF(PSPF pSPF) throws Exception {
    }

    protected void onBeforeRemoveByPSPF(PSPF pSPF, ArrayList<PSDCPFPITempl> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSPF(PSPF pSPF, ArrayList<PSDCPFPITempl> arrayList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(PSDCPFPITempl pSDCPFPITempl) throws Exception {
        super.onBeforeRemove(pSDCPFPITempl);
    }

    protected void replaceParentInfo(PSDCPFPITempl pSDCPFPITempl, CloneSession cloneSession) throws Exception {
        IEntity iEntity;
        super.replaceParentInfo(pSDCPFPITempl, cloneSession);
        if (pSDCPFPITempl.getPSDCPFPluginId() != null && (iEntity = cloneSession.getEntity("PSDCPFPLUGIN", (Object)pSDCPFPITempl.getPSDCPFPluginId())) != null) {
            this.onFillParentInfo_PSDCPFPlugin(pSDCPFPITempl, (PSDCPFPlugin)iEntity);
        }
        if (pSDCPFPITempl.getPSPFId() != null && (iEntity = cloneSession.getEntity("PSPF", (Object)pSDCPFPITempl.getPSPFId())) != null) {
            this.onFillParentInfo_PSPF(pSDCPFPITempl, (PSPF)iEntity);
        }
    }

    protected void onRemoveEntityUncopyValues(PSDCPFPITempl pSDCPFPITempl, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues(pSDCPFPITempl, bl);
    }

    protected void onCheckEntity(boolean bl, PSDCPFPITempl pSDCPFPITempl, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_Memo(bl, pSDCPFPITempl, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDCPFPITemplId(bl, pSDCPFPITempl, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDCPFPITemplName(bl, pSDCPFPITempl, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDCPFPluginId(bl, pSDCPFPITempl, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSPFId(bl, pSDCPFPITempl, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSPFName(bl, pSDCPFPITempl, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_TemplCode(bl, pSDCPFPITempl, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_TemplCode2(bl, pSDCPFPITempl, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_TemplCode2Ex(bl, pSDCPFPITempl, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_TemplCode2Flag(bl, pSDCPFPITempl, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_TemplCode2Info(bl, pSDCPFPITempl, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_TemplCode3(bl, pSDCPFPITempl, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_TemplCode3Flag(bl, pSDCPFPITempl, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_TemplCode3Info(bl, pSDCPFPITempl, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_TemplCode4(bl, pSDCPFPITempl, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_TemplCode4Flag(bl, pSDCPFPITempl, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_TemplCode4Info(bl, pSDCPFPITempl, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_TemplCode5(bl, pSDCPFPITempl, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_TemplCode6(bl, pSDCPFPITempl, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_TemplCodeFlag(bl, pSDCPFPITempl, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_TemplCodeInfo(bl, pSDCPFPITempl, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, pSDCPFPITempl, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_Memo(boolean bl, PSDCPFPITempl pSDCPFPITempl, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCPFPITempl.isMemoDirty() : !pSDCPFPITempl.isMemoDirty()) {
            return null;
        }
        String string = pSDCPFPITempl.getMemo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Memo_Default(pSDCPFPITempl, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDCPFPITemplId(boolean bl, PSDCPFPITempl pSDCPFPITempl, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCPFPITempl.isPSDCPFPITemplIdDirty() && !bl2 : !pSDCPFPITempl.isPSDCPFPITemplIdDirty()) {
            return null;
        }
        String string = pSDCPFPITempl.getPSDCPFPITemplId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDCPFPITEMPLID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDCPFPITemplId_Default(pSDCPFPITempl, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDCPFPITEMPLID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDCPFPITemplName(boolean bl, PSDCPFPITempl pSDCPFPITempl, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCPFPITempl.isPSDCPFPITemplNameDirty() && !bl2 : !pSDCPFPITempl.isPSDCPFPITemplNameDirty()) {
            return null;
        }
        String string = pSDCPFPITempl.getPSDCPFPITemplName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDCPFPITEMPLNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDCPFPITemplName_Default(pSDCPFPITempl, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDCPFPITEMPLNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDCPFPluginId(boolean bl, PSDCPFPITempl pSDCPFPITempl, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCPFPITempl.isPSDCPFPluginIdDirty() && !bl2 : !pSDCPFPITempl.isPSDCPFPluginIdDirty()) {
            return null;
        }
        String string = pSDCPFPITempl.getPSDCPFPluginId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDCPFPLUGINID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDCPFPluginId_Default(pSDCPFPITempl, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDCPFPLUGINID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSPFId(boolean bl, PSDCPFPITempl pSDCPFPITempl, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCPFPITempl.isPSPFIdDirty() && !bl2 : !pSDCPFPITempl.isPSPFIdDirty()) {
            return null;
        }
        String string = pSDCPFPITempl.getPSPFId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSPFID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSPFId_Default(pSDCPFPITempl, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSPFName(boolean bl, PSDCPFPITempl pSDCPFPITempl, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCPFPITempl.isPSPFNameDirty() && !bl2 : !pSDCPFPITempl.isPSPFNameDirty()) {
            return null;
        }
        String string = pSDCPFPITempl.getPSPFName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSPFNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSPFName_Default(pSDCPFPITempl, bl2, bl3);
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

    protected EntityFieldError onCheckField_TemplCode(boolean bl, PSDCPFPITempl pSDCPFPITempl, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCPFPITempl.isTemplCodeDirty() : !pSDCPFPITempl.isTemplCodeDirty()) {
            return null;
        }
        String string = pSDCPFPITempl.getTemplCode();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_TemplCode_Default(pSDCPFPITempl, bl2, bl3);
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

    protected EntityFieldError onCheckField_TemplCode2(boolean bl, PSDCPFPITempl pSDCPFPITempl, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCPFPITempl.isTemplCode2Dirty() : !pSDCPFPITempl.isTemplCode2Dirty()) {
            return null;
        }
        String string = pSDCPFPITempl.getTemplCode2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_TemplCode2_Default(pSDCPFPITempl, bl2, bl3);
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

    protected EntityFieldError onCheckField_TemplCode2Ex(boolean bl, PSDCPFPITempl pSDCPFPITempl, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCPFPITempl.isTemplCode2ExDirty() : !pSDCPFPITempl.isTemplCode2ExDirty()) {
            return null;
        }
        String string = pSDCPFPITempl.getTemplCode2Ex();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_TemplCode2Ex_Default(pSDCPFPITempl, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("TEMPLCODE2EX");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_TemplCode2Flag(boolean bl, PSDCPFPITempl pSDCPFPITempl, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCPFPITempl.isTemplCode2FlagDirty() : !pSDCPFPITempl.isTemplCode2FlagDirty()) {
            return null;
        }
        Integer n = pSDCPFPITempl.getTemplCode2Flag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_TemplCode2Flag_Default(pSDCPFPITempl, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("TEMPLCODE2FLAG");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_TemplCode2Info(boolean bl, PSDCPFPITempl pSDCPFPITempl, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCPFPITempl.isTemplCode2InfoDirty() : !pSDCPFPITempl.isTemplCode2InfoDirty()) {
            return null;
        }
        String string = pSDCPFPITempl.getTemplCode2Info();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_TemplCode2Info_Default(pSDCPFPITempl, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("TEMPLCODE2INFO");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_TemplCode3(boolean bl, PSDCPFPITempl pSDCPFPITempl, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCPFPITempl.isTemplCode3Dirty() : !pSDCPFPITempl.isTemplCode3Dirty()) {
            return null;
        }
        String string = pSDCPFPITempl.getTemplCode3();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_TemplCode3_Default(pSDCPFPITempl, bl2, bl3);
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

    protected EntityFieldError onCheckField_TemplCode3Flag(boolean bl, PSDCPFPITempl pSDCPFPITempl, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCPFPITempl.isTemplCode3FlagDirty() : !pSDCPFPITempl.isTemplCode3FlagDirty()) {
            return null;
        }
        Integer n = pSDCPFPITempl.getTemplCode3Flag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_TemplCode3Flag_Default(pSDCPFPITempl, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("TEMPLCODE3FLAG");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_TemplCode3Info(boolean bl, PSDCPFPITempl pSDCPFPITempl, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCPFPITempl.isTemplCode3InfoDirty() : !pSDCPFPITempl.isTemplCode3InfoDirty()) {
            return null;
        }
        String string = pSDCPFPITempl.getTemplCode3Info();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_TemplCode3Info_Default(pSDCPFPITempl, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("TEMPLCODE3INFO");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_TemplCode4(boolean bl, PSDCPFPITempl pSDCPFPITempl, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCPFPITempl.isTemplCode4Dirty() : !pSDCPFPITempl.isTemplCode4Dirty()) {
            return null;
        }
        String string = pSDCPFPITempl.getTemplCode4();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_TemplCode4_Default(pSDCPFPITempl, bl2, bl3);
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

    protected EntityFieldError onCheckField_TemplCode4Flag(boolean bl, PSDCPFPITempl pSDCPFPITempl, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCPFPITempl.isTemplCode4FlagDirty() : !pSDCPFPITempl.isTemplCode4FlagDirty()) {
            return null;
        }
        Integer n = pSDCPFPITempl.getTemplCode4Flag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_TemplCode4Flag_Default(pSDCPFPITempl, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("TEMPLCODE4FLAG");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_TemplCode4Info(boolean bl, PSDCPFPITempl pSDCPFPITempl, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCPFPITempl.isTemplCode4InfoDirty() : !pSDCPFPITempl.isTemplCode4InfoDirty()) {
            return null;
        }
        String string = pSDCPFPITempl.getTemplCode4Info();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_TemplCode4Info_Default(pSDCPFPITempl, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("TEMPLCODE4INFO");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_TemplCode5(boolean bl, PSDCPFPITempl pSDCPFPITempl, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCPFPITempl.isTemplCode5Dirty() : !pSDCPFPITempl.isTemplCode5Dirty()) {
            return null;
        }
        String string = pSDCPFPITempl.getTemplCode5();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_TemplCode5_Default(pSDCPFPITempl, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("TEMPLCODE5");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_TemplCode6(boolean bl, PSDCPFPITempl pSDCPFPITempl, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCPFPITempl.isTemplCode6Dirty() : !pSDCPFPITempl.isTemplCode6Dirty()) {
            return null;
        }
        String string = pSDCPFPITempl.getTemplCode6();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_TemplCode6_Default(pSDCPFPITempl, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("TEMPLCODE6");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_TemplCodeFlag(boolean bl, PSDCPFPITempl pSDCPFPITempl, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCPFPITempl.isTemplCodeFlagDirty() : !pSDCPFPITempl.isTemplCodeFlagDirty()) {
            return null;
        }
        Integer n = pSDCPFPITempl.getTemplCodeFlag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_TemplCodeFlag_Default(pSDCPFPITempl, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("TEMPLCODEFLAG");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_TemplCodeInfo(boolean bl, PSDCPFPITempl pSDCPFPITempl, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCPFPITempl.isTemplCodeInfoDirty() : !pSDCPFPITempl.isTemplCodeInfoDirty()) {
            return null;
        }
        String string = pSDCPFPITempl.getTemplCodeInfo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_TemplCodeInfo_Default(pSDCPFPITempl, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("TEMPLCODEINFO");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected void onSyncEntity(PSDCPFPITempl pSDCPFPITempl, boolean bl) throws Exception {
        super.onSyncEntity(pSDCPFPITempl, bl);
    }

    protected void onSyncIndexEntities(PSDCPFPITempl pSDCPFPITempl, boolean bl) throws Exception {
        super.onSyncIndexEntities(pSDCPFPITempl, bl);
    }

    public Object getDataContextValue(PSDCPFPITempl pSDCPFPITempl, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null) {
            // empty if block
        }
        if ((object = super.getDataContextValue(pSDCPFPITempl, string, iDataContextParam)) != null) {
            return object;
        }
        PSDCPFPlugin pSDCPFPlugin = pSDCPFPITempl.getPSDCPFPlugin();
        if (pSDCPFPlugin != null && pSDCPFPlugin.contains(string)) {
            return pSDCPFPlugin.get(string);
        }
        return null;
    }

    protected void onExportMajorModel(PSDCPFPITempl pSDCPFPITempl, ArrayList<JSONObject> arrayList, int n) throws Exception {
        super.onExportMajorModel(pSDCPFPITempl, arrayList, n);
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
        if (StringHelper.compare((String)string, (String)"PSDCPFPITEMPLID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDCPFPITemplId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDCPFPITEMPLNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDCPFPITemplName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDCPFPLUGINID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDCPFPluginId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDCPFPLUGINNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDCPFPluginName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSPFID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSPFId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSPFNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSPFName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"TEMPLCODE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_TemplCode_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"TEMPLCODE2", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_TemplCode2_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"TEMPLCODE2EX", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_TemplCode2Ex_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"TEMPLCODE2FLAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_TemplCode2Flag_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"TEMPLCODE2INFO", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_TemplCode2Info_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"TEMPLCODE3", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_TemplCode3_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"TEMPLCODE3FLAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_TemplCode3Flag_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"TEMPLCODE3INFO", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_TemplCode3Info_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"TEMPLCODE4", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_TemplCode4_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"TEMPLCODE4FLAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_TemplCode4Flag_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"TEMPLCODE4INFO", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_TemplCode4Info_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"TEMPLCODE5", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_TemplCode5_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"TEMPLCODE6", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_TemplCode6_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"TEMPLCODEFLAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_TemplCodeFlag_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"TEMPLCODEINFO", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_TemplCodeInfo_Default(iEntity, bl, bl2);
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

    protected String onTestValueRule_PSDCPFPITemplId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDCPFPITEMPLID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDCPFPITemplName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDCPFPITEMPLNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDCPFPluginId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDCPFPLUGINID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDCPFPluginName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDCPFPLUGINNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
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

    protected String onTestValueRule_TemplCode2Ex_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("TEMPLCODE2EX", iEntity, bl2, null, false, 0x100000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_TemplCode2Flag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_TemplCode2Info_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("TEMPLCODE2INFO", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
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

    protected String onTestValueRule_TemplCode3Flag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_TemplCode3Info_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("TEMPLCODE3INFO", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
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

    protected String onTestValueRule_TemplCode4Flag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_TemplCode4Info_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("TEMPLCODE4INFO", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_TemplCode5_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("TEMPLCODE5", iEntity, bl2, null, false, 250, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[250]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[250]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_TemplCode6_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("TEMPLCODE6", iEntity, bl2, null, false, 250, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[250]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[250]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_TemplCodeFlag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_TemplCodeInfo_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("TEMPLCODEINFO", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
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

    protected boolean onMergeChild(String string, String string2, PSDCPFPITempl pSDCPFPITempl) throws Exception {
        boolean bl = false;
        if (super.onMergeChild(string, string2, pSDCPFPITempl)) {
            bl = true;
        }
        return bl;
    }

    protected void onUpdateParent(PSDCPFPITempl pSDCPFPITempl) throws Exception {
        super.onUpdateParent(pSDCPFPITempl);
    }

    @Override
    protected void exportCurXmlModel(PSDCPFPITempl pSDCPFPITempl, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSDCPFPITEMPL");
        if (!bl) {
            pSDCPFPITempl.setCreateDate(null);
            pSDCPFPITempl.setCreateMan(null);
            pSDCPFPITempl.setPSDCPFPITemplId(null);
            pSDCPFPITempl.setUpdateDate(null);
            pSDCPFPITempl.setUpdateMan(null);
            super.exportCurXmlModel(pSDCPFPITempl, xmlNode, bl);
        }
    }

    @Override
    protected String getEntityFolderKeyValue(PSDCPFPITempl pSDCPFPITempl, PSSystem pSSystem) throws Exception {
        PSDCPFPITempl pSDCPFPITempl2 = new PSDCPFPITempl();
        pSDCPFPITempl2.setPSDCPFPluginId(pSDCPFPITempl.getPSDCPFPluginId());
        pSDCPFPITempl2.setPSPFId(pSDCPFPITempl.getPSPFId());
        if (this.selectOne(pSDCPFPITempl2, true)) {
            return pSDCPFPITempl2.getPSDCPFPITemplId();
        }
        return super.getEntityFolderKeyValue(pSDCPFPITempl, pSSystem);
    }
}

