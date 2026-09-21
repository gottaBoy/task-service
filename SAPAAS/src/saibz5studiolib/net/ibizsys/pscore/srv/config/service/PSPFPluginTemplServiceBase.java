/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
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
package net.ibizsys.pscore.srv.config.service;

import java.util.ArrayList;
import java.util.HashMap;
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
import net.ibizsys.pscore.srv.config.dao.PSPFPluginTemplDAO;
import net.ibizsys.pscore.srv.config.demodel.PSPFPluginTemplDEModel;
import net.ibizsys.pscore.srv.config.entity.PSPF;
import net.ibizsys.pscore.srv.config.entity.PSPFBase;
import net.ibizsys.pscore.srv.config.entity.PSPFPlugin;
import net.ibizsys.pscore.srv.config.entity.PSPFPluginBase;
import net.ibizsys.pscore.srv.config.entity.PSPFPluginTempl;
import net.ibizsys.pscore.srv.config.entity.PSPFPubCode;
import net.ibizsys.pscore.srv.config.entity.PSPFPubCodeBase;
import net.ibizsys.pscore.srv.core.IPSDataEntityModel;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSystem;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSPFPluginTemplServiceBase
extends PSCoreSysServiceBase<PSPFPluginTempl> {
    private static final Log log = LogFactory.getLog(PSPFPluginTemplServiceBase.class);
    public static final String DATASET_DEFAULT = "DEFAULT";
    private PSPFPluginTemplDEModel pSPFPluginTemplDEModel;
    private PSPFPluginTemplDAO pSPFPluginTemplDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.config.service.PSPFPluginTemplService";
    }

    public PSPFPluginTemplDEModel getPSPFPluginTemplDEModel() {
        if (this.pSPFPluginTemplDEModel == null) {
            try {
                this.pSPFPluginTemplDEModel = (PSPFPluginTemplDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.config.demodel.PSPFPluginTemplDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSPFPluginTemplDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSPFPluginTemplDEModel();
    }

    public PSPFPluginTemplDAO getPSPFPluginTemplDAO() {
        if (this.pSPFPluginTemplDAO == null) {
            try {
                this.pSPFPluginTemplDAO = (PSPFPluginTemplDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.config.dao.PSPFPluginTemplDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSPFPluginTemplDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSPFPluginTemplDAO();
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

    protected void onFillParentInfo(PSPFPluginTempl pSPFPluginTempl, String string, String string2, String string3) throws Exception {
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSPFPLUGINTEMPL_PSPFPLUGIN_PSPFPLUGINID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.config.service.PSPFPluginService", (SessionFactory)this.getSessionFactory());
            PSPFPlugin pSPFPlugin = (PSPFPlugin)iService.getDEModel().createEntity();
            pSPFPlugin.set("PSPFPLUGINID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSPFPlugin);
            } else {
                iService.get((IEntity)pSPFPlugin);
            }
            this.onFillParentInfo_PSPFPlugin(pSPFPluginTempl, pSPFPlugin);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSPFPLUGINTEMPL_PSPFPUBCODE_PSPFPUBCODEID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.config.service.PSPFPubCodeService", (SessionFactory)this.getSessionFactory());
            PSPFPubCode pSPFPubCode = (PSPFPubCode)iService.getDEModel().createEntity();
            pSPFPubCode.set("PSPFPUBCODEID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSPFPubCode);
            } else {
                iService.get((IEntity)pSPFPubCode);
            }
            this.onFillParentInfo_PSPFPubCode(pSPFPluginTempl, pSPFPubCode);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSPFPLUGINTEMPL_PSPF_PSPFID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.config.service.PSPFService", (SessionFactory)this.getSessionFactory());
            PSPF pSPF = (PSPF)iService.getDEModel().createEntity();
            pSPF.set("PSPFID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSPF);
            } else {
                iService.get((IEntity)pSPF);
            }
            this.onFillParentInfo_PSPF(pSPFPluginTempl, pSPF);
            return;
        }
        super.onFillParentInfo((IEntity)pSPFPluginTempl, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        if (StringHelper.compare((String)string, (String)"DER1N_PSPFPLUGINTEMPL_PSPFPLUGIN_PSPFPLUGINID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.config.service.PSPFPluginService", (SessionFactory)this.getSessionFactory());
            PSPFPlugin pSPFPlugin = (PSPFPlugin)iService.getDEModel().createEntity();
            pSPFPlugin.set("PSPFPLUGINID", string2);
            return this.onSyncDER1NData_PSPFPlugin(pSPFPlugin, string3);
        }
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillParentInfo_PSPFPlugin(PSPFPluginTempl pSPFPluginTempl, PSPFPlugin pSPFPlugin) throws Exception {
        pSPFPluginTempl.setPSPFPluginId(pSPFPlugin.getPSPFPluginId());
        pSPFPluginTempl.setPSPFPluginName(pSPFPlugin.getPSPFPluginName());
    }

    protected String onSyncDER1NData_PSPFPlugin(PSPFPlugin pSPFPlugin, String string) throws Exception {
        if (StringHelper.isNullOrEmpty((String)string)) {
            this.removeByPSPFPlugin(pSPFPlugin);
        } else {
            HashMap<String, String> hashMap = new HashMap<String, String>();
            String[] stringArray = StringHelper.splitEx((String)string);
            if (stringArray != null) {
                for (int i = 0; i < stringArray.length; ++i) {
                    if (StringHelper.isNullOrEmpty((String)stringArray[i])) continue;
                    hashMap.put(stringArray[i], "");
                }
            }
            ArrayList<PSPFPluginTempl> arrayList = this.selectByPSPFPlugin(pSPFPlugin);
            for (PSPFPluginTempl pSPFPluginTempl : arrayList) {
                if (hashMap.containsKey(DataObject.getStringValue((IDataObject)pSPFPluginTempl, (String)"PSPFPLUGINTEMPLID", (String)""))) continue;
                this.remove((IEntity)pSPFPluginTempl);
            }
        }
        return null;
    }

    protected void onFillParentInfo_PSPFPubCode(PSPFPluginTempl pSPFPluginTempl, PSPFPubCode pSPFPubCode) throws Exception {
        pSPFPluginTempl.setPSPFPubCodeId(pSPFPubCode.getPSPFPubCodeId());
        pSPFPluginTempl.setPSPFPubCodeName(pSPFPubCode.getPSPFPubCodeName());
    }

    protected void onFillParentInfo_PSPF(PSPFPluginTempl pSPFPluginTempl, PSPF pSPF) throws Exception {
        pSPFPluginTempl.setPSPFId(pSPF.getPSPFId());
        pSPFPluginTempl.setPSPFName(pSPF.getPSPFName());
    }

    protected boolean onFillEntityKeyValue(PSPFPluginTempl pSPFPluginTempl, boolean bl) throws Exception {
        StringBuilderEx stringBuilderEx = new StringBuilderEx();
        Object object = pSPFPluginTempl.get("PSPFPLUGINID");
        if (object == null) {
            object = "__EMTPY__";
        }
        stringBuilderEx.append("%1$s", object);
        stringBuilderEx.append("||");
        Object object2 = pSPFPluginTempl.get("PSPFID");
        if (object2 == null) {
            object2 = "__EMTPY__";
        }
        stringBuilderEx.append("%1$s", object2);
        String string = stringBuilderEx.toString();
        pSPFPluginTempl.set(this.getPSPFPluginTemplDEModel().getKeyDEField().getName(), KeyValueHelper.genUniqueId((String)string));
        return true;
    }

    protected void onFillEntityFullInfo(PSPFPluginTempl pSPFPluginTempl, boolean bl) throws Exception {
        if (bl) {
            // empty if block
        }
        super.onFillEntityFullInfo((IEntity)pSPFPluginTempl, bl);
        this.onFillEntityFullInfo_PSPFPlugin(pSPFPluginTempl, bl);
        this.onFillEntityFullInfo_PSPFPubCode(pSPFPluginTempl, bl);
        this.onFillEntityFullInfo_PSPF(pSPFPluginTempl, bl);
    }

    protected void onFillEntityFullInfo_PSPFPlugin(PSPFPluginTempl pSPFPluginTempl, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSPFPubCode(PSPFPluginTempl pSPFPluginTempl, boolean bl) throws Exception {
        if (pSPFPluginTempl.isPSPFPubCodeIdDirty()) {
            if (pSPFPluginTempl.getPSPFPubCodeId() != null) {
                if (pSPFPluginTempl.getPSPFPubCodeId() == null || pSPFPluginTempl.getPSPFPubCodeName() == null) {
                    PSPFPubCode pSPFPubCode = pSPFPluginTempl.getPSPFPubCode();
                    pSPFPluginTempl.setPSPFPubCodeName(pSPFPubCode.getPSPFPubCodeName());
                }
            } else {
                pSPFPluginTempl.setPSPFPubCodeName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_PSPF(PSPFPluginTempl pSPFPluginTempl, boolean bl) throws Exception {
        if (pSPFPluginTempl.isPSPFIdDirty()) {
            if (pSPFPluginTempl.getPSPFId() != null) {
                if (pSPFPluginTempl.getPSPFId() == null || pSPFPluginTempl.getPSPFName() == null) {
                    PSPF pSPF = pSPFPluginTempl.getPSPF();
                    pSPFPluginTempl.setPSPFName(pSPF.getPSPFName());
                }
            } else {
                pSPFPluginTempl.setPSPFName(null);
            }
        }
    }

    protected void onWriteBackParent(PSPFPluginTempl pSPFPluginTempl, boolean bl) throws Exception {
        super.onWriteBackParent((IEntity)pSPFPluginTempl, bl);
    }

    public ArrayList<PSPFPluginTempl> selectByPSPFPlugin(PSPFPluginBase pSPFPluginBase) throws Exception {
        return this.selectByPSPFPlugin(pSPFPluginBase, "", -1);
    }

    public ArrayList<PSPFPluginTempl> selectByPSPFPlugin(PSPFPluginBase pSPFPluginBase, String string) throws Exception {
        return this.selectByPSPFPlugin(pSPFPluginBase, string, -1);
    }

    public ArrayList<PSPFPluginTempl> selectByPSPFPlugin(PSPFPluginBase pSPFPluginBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSPFPLUGINID", (Object)pSPFPluginBase.getPSPFPluginId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSPFPluginCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSPFPluginCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSPFPluginTempl> selectByPSPFPubCode(PSPFPubCodeBase pSPFPubCodeBase) throws Exception {
        return this.selectByPSPFPubCode(pSPFPubCodeBase, "", -1);
    }

    public ArrayList<PSPFPluginTempl> selectByPSPFPubCode(PSPFPubCodeBase pSPFPubCodeBase, String string) throws Exception {
        return this.selectByPSPFPubCode(pSPFPubCodeBase, string, -1);
    }

    public ArrayList<PSPFPluginTempl> selectByPSPFPubCode(PSPFPubCodeBase pSPFPubCodeBase, String string, int n) throws Exception {
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

    public ArrayList<PSPFPluginTempl> selectByPSPF(PSPFBase pSPFBase) throws Exception {
        return this.selectByPSPF(pSPFBase, "", -1);
    }

    public ArrayList<PSPFPluginTempl> selectByPSPF(PSPFBase pSPFBase, String string) throws Exception {
        return this.selectByPSPF(pSPFBase, string, -1);
    }

    public ArrayList<PSPFPluginTempl> selectByPSPF(PSPFBase pSPFBase, String string, int n) throws Exception {
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

    public void testRemoveByPSPFPlugin(PSPFPlugin pSPFPlugin) throws Exception {
    }

    public void resetPSPFPlugin(PSPFPlugin pSPFPlugin) throws Exception {
        ArrayList<PSPFPluginTempl> arrayList = this.selectByPSPFPlugin(pSPFPlugin);
        for (PSPFPluginTempl pSPFPluginTempl : arrayList) {
            PSPFPluginTempl pSPFPluginTempl2 = (PSPFPluginTempl)this.getDEModel().createEntity();
            pSPFPluginTempl2.setPSPFPluginTemplId(pSPFPluginTempl.getPSPFPluginTemplId());
            pSPFPluginTempl2.setPSPFPluginId(null);
            this.update(pSPFPluginTempl2);
        }
    }

    public void removeByPSPFPlugin(PSPFPlugin pSPFPlugin) throws Exception {
        final PSPFPlugin pSPFPlugin2 = pSPFPlugin;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSPFPluginTemplServiceBase.this.onBeforeRemoveByPSPFPlugin(pSPFPlugin2);
                PSPFPluginTemplServiceBase.this.internalRemoveByPSPFPlugin(pSPFPlugin2);
                PSPFPluginTemplServiceBase.this.onAfterRemoveByPSPFPlugin(pSPFPlugin2);
            }
        });
    }

    protected void onBeforeRemoveByPSPFPlugin(PSPFPlugin pSPFPlugin) throws Exception {
    }

    protected void internalRemoveByPSPFPlugin(PSPFPlugin pSPFPlugin) throws Exception {
        ArrayList<PSPFPluginTempl> arrayList = this.selectByPSPFPlugin(pSPFPlugin);
        this.onBeforeRemoveByPSPFPlugin(pSPFPlugin, arrayList);
        for (PSPFPluginTempl pSPFPluginTempl : arrayList) {
            this.remove((IEntity)pSPFPluginTempl);
        }
        this.onAfterRemoveByPSPFPlugin(pSPFPlugin, arrayList);
    }

    protected void onAfterRemoveByPSPFPlugin(PSPFPlugin pSPFPlugin) throws Exception {
    }

    protected void onBeforeRemoveByPSPFPlugin(PSPFPlugin pSPFPlugin, ArrayList<PSPFPluginTempl> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSPFPlugin(PSPFPlugin pSPFPlugin, ArrayList<PSPFPluginTempl> arrayList) throws Exception {
    }

    public void testRemoveByPSPFPubCode(PSPFPubCode pSPFPubCode) throws Exception {
    }

    public void resetPSPFPubCode(PSPFPubCode pSPFPubCode) throws Exception {
        ArrayList<PSPFPluginTempl> arrayList = this.selectByPSPFPubCode(pSPFPubCode);
        for (PSPFPluginTempl pSPFPluginTempl : arrayList) {
            PSPFPluginTempl pSPFPluginTempl2 = (PSPFPluginTempl)this.getDEModel().createEntity();
            pSPFPluginTempl2.setPSPFPluginTemplId(pSPFPluginTempl.getPSPFPluginTemplId());
            pSPFPluginTempl2.setPSPFPubCodeId(null);
            this.update(pSPFPluginTempl2);
        }
    }

    public void removeByPSPFPubCode(PSPFPubCode pSPFPubCode) throws Exception {
        final PSPFPubCode pSPFPubCode2 = pSPFPubCode;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSPFPluginTemplServiceBase.this.onBeforeRemoveByPSPFPubCode(pSPFPubCode2);
                PSPFPluginTemplServiceBase.this.internalRemoveByPSPFPubCode(pSPFPubCode2);
                PSPFPluginTemplServiceBase.this.onAfterRemoveByPSPFPubCode(pSPFPubCode2);
            }
        });
    }

    protected void onBeforeRemoveByPSPFPubCode(PSPFPubCode pSPFPubCode) throws Exception {
    }

    protected void internalRemoveByPSPFPubCode(PSPFPubCode pSPFPubCode) throws Exception {
        ArrayList<PSPFPluginTempl> arrayList = this.selectByPSPFPubCode(pSPFPubCode);
        this.onBeforeRemoveByPSPFPubCode(pSPFPubCode, arrayList);
        for (PSPFPluginTempl pSPFPluginTempl : arrayList) {
            this.remove((IEntity)pSPFPluginTempl);
        }
        this.onAfterRemoveByPSPFPubCode(pSPFPubCode, arrayList);
    }

    protected void onAfterRemoveByPSPFPubCode(PSPFPubCode pSPFPubCode) throws Exception {
    }

    protected void onBeforeRemoveByPSPFPubCode(PSPFPubCode pSPFPubCode, ArrayList<PSPFPluginTempl> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSPFPubCode(PSPFPubCode pSPFPubCode, ArrayList<PSPFPluginTempl> arrayList) throws Exception {
    }

    public void testRemoveByPSPF(PSPF pSPF) throws Exception {
        ArrayList<PSPFPluginTempl> arrayList = this.selectByPSPF(pSPF, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSPF");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSPF);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSPFPLUGINTEMPL_PSPF_PSPFID", "", iDataEntityModel.getName(), "PSPFPLUGINTEMPL", iDataEntityModel.getDataInfo((IEntity)pSPF), arrayList.get(0)));
        }
    }

    public void resetPSPF(PSPF pSPF) throws Exception {
        ArrayList<PSPFPluginTempl> arrayList = this.selectByPSPF(pSPF);
        for (PSPFPluginTempl pSPFPluginTempl : arrayList) {
            PSPFPluginTempl pSPFPluginTempl2 = (PSPFPluginTempl)this.getDEModel().createEntity();
            pSPFPluginTempl2.setPSPFPluginTemplId(pSPFPluginTempl.getPSPFPluginTemplId());
            pSPFPluginTempl2.setPSPFId(null);
            this.update(pSPFPluginTempl2);
        }
    }

    public void removeByPSPF(PSPF pSPF) throws Exception {
        final PSPF pSPF2 = pSPF;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSPFPluginTemplServiceBase.this.onBeforeRemoveByPSPF(pSPF2);
                PSPFPluginTemplServiceBase.this.internalRemoveByPSPF(pSPF2);
                PSPFPluginTemplServiceBase.this.onAfterRemoveByPSPF(pSPF2);
            }
        });
    }

    protected void onBeforeRemoveByPSPF(PSPF pSPF) throws Exception {
    }

    protected void internalRemoveByPSPF(PSPF pSPF) throws Exception {
        ArrayList<PSPFPluginTempl> arrayList = this.selectByPSPF(pSPF);
        this.onBeforeRemoveByPSPF(pSPF, arrayList);
        for (PSPFPluginTempl pSPFPluginTempl : arrayList) {
            this.remove((IEntity)pSPFPluginTempl);
        }
        this.onAfterRemoveByPSPF(pSPF, arrayList);
    }

    protected void onAfterRemoveByPSPF(PSPF pSPF) throws Exception {
    }

    protected void onBeforeRemoveByPSPF(PSPF pSPF, ArrayList<PSPFPluginTempl> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSPF(PSPF pSPF, ArrayList<PSPFPluginTempl> arrayList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(PSPFPluginTempl pSPFPluginTempl) throws Exception {
        super.onBeforeRemove(pSPFPluginTempl);
    }

    protected void replaceParentInfo(PSPFPluginTempl pSPFPluginTempl, CloneSession cloneSession) throws Exception {
        IEntity iEntity;
        super.replaceParentInfo((IEntity)pSPFPluginTempl, cloneSession);
        if (pSPFPluginTempl.getPSPFPluginId() != null && (iEntity = cloneSession.getEntity("PSPFPLUGIN", (Object)pSPFPluginTempl.getPSPFPluginId())) != null) {
            this.onFillParentInfo_PSPFPlugin(pSPFPluginTempl, (PSPFPlugin)iEntity);
        }
        if (pSPFPluginTempl.getPSPFPubCodeId() != null && (iEntity = cloneSession.getEntity("PSPFPUBCODE", (Object)pSPFPluginTempl.getPSPFPubCodeId())) != null) {
            this.onFillParentInfo_PSPFPubCode(pSPFPluginTempl, (PSPFPubCode)iEntity);
        }
        if (pSPFPluginTempl.getPSPFId() != null && (iEntity = cloneSession.getEntity("PSPF", (Object)pSPFPluginTempl.getPSPFId())) != null) {
            this.onFillParentInfo_PSPF(pSPFPluginTempl, (PSPF)iEntity);
        }
    }

    protected void onRemoveEntityUncopyValues(PSPFPluginTempl pSPFPluginTempl, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues((IEntity)pSPFPluginTempl, bl);
    }

    protected void onCheckEntity(boolean bl, PSPFPluginTempl pSPFPluginTempl, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_Memo(bl, pSPFPluginTempl, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSPFId(bl, pSPFPluginTempl, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSPFName(bl, pSPFPluginTempl, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSPFPluginId(bl, pSPFPluginTempl, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSPFPluginTemplId(bl, pSPFPluginTempl, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSPFPluginTemplName(bl, pSPFPluginTempl, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSPFPubCodeId(bl, pSPFPluginTempl, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSPFPubCodeName(bl, pSPFPluginTempl, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_TemplCode(bl, pSPFPluginTempl, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_TemplCode2(bl, pSPFPluginTempl, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_TemplCode3(bl, pSPFPluginTempl, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_TemplCode4(bl, pSPFPluginTempl, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_TemplDesc(bl, pSPFPluginTempl, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, (IEntity)pSPFPluginTempl, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_Memo(boolean bl, PSPFPluginTempl pSPFPluginTempl, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSPFPluginTempl.isMemoDirty() : !pSPFPluginTempl.isMemoDirty()) {
            return null;
        }
        String string = pSPFPluginTempl.getMemo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Memo_Default((IEntity)pSPFPluginTempl, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSPFId(boolean bl, PSPFPluginTempl pSPFPluginTempl, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSPFPluginTempl.isPSPFIdDirty() && !bl2 : !pSPFPluginTempl.isPSPFIdDirty()) {
            return null;
        }
        String string = pSPFPluginTempl.getPSPFId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSPFID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSPFId_Default((IEntity)pSPFPluginTempl, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSPFName(boolean bl, PSPFPluginTempl pSPFPluginTempl, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSPFPluginTempl.isPSPFNameDirty() && !bl2 : !pSPFPluginTempl.isPSPFNameDirty()) {
            return null;
        }
        String string = pSPFPluginTempl.getPSPFName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSPFNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSPFName_Default((IEntity)pSPFPluginTempl, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSPFPluginId(boolean bl, PSPFPluginTempl pSPFPluginTempl, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSPFPluginTempl.isPSPFPluginIdDirty() && !bl2 : !pSPFPluginTempl.isPSPFPluginIdDirty()) {
            return null;
        }
        String string = pSPFPluginTempl.getPSPFPluginId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSPFPLUGINID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSPFPluginId_Default((IEntity)pSPFPluginTempl, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSPFPLUGINID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSPFPluginTemplId(boolean bl, PSPFPluginTempl pSPFPluginTempl, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSPFPluginTempl.isPSPFPluginTemplIdDirty() && !bl2 : !pSPFPluginTempl.isPSPFPluginTemplIdDirty()) {
            return null;
        }
        String string = pSPFPluginTempl.getPSPFPluginTemplId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSPFPLUGINTEMPLID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSPFPluginTemplId_Default((IEntity)pSPFPluginTempl, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSPFPLUGINTEMPLID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSPFPluginTemplName(boolean bl, PSPFPluginTempl pSPFPluginTempl, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSPFPluginTempl.isPSPFPluginTemplNameDirty() && !bl2 : !pSPFPluginTempl.isPSPFPluginTemplNameDirty()) {
            return null;
        }
        String string = pSPFPluginTempl.getPSPFPluginTemplName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSPFPLUGINTEMPLNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSPFPluginTemplName_Default((IEntity)pSPFPluginTempl, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSPFPLUGINTEMPLNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSPFPubCodeId(boolean bl, PSPFPluginTempl pSPFPluginTempl, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSPFPluginTempl.isPSPFPubCodeIdDirty() : !pSPFPluginTempl.isPSPFPubCodeIdDirty()) {
            return null;
        }
        String string = pSPFPluginTempl.getPSPFPubCodeId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSPFPubCodeId_Default((IEntity)pSPFPluginTempl, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSPFPubCodeName(boolean bl, PSPFPluginTempl pSPFPluginTempl, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSPFPluginTempl.isPSPFPubCodeNameDirty() : !pSPFPluginTempl.isPSPFPubCodeNameDirty()) {
            return null;
        }
        String string = pSPFPluginTempl.getPSPFPubCodeName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSPFPubCodeName_Default((IEntity)pSPFPluginTempl, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSPFPUBCODENAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_TemplCode(boolean bl, PSPFPluginTempl pSPFPluginTempl, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSPFPluginTempl.isTemplCodeDirty() : !pSPFPluginTempl.isTemplCodeDirty()) {
            return null;
        }
        String string = pSPFPluginTempl.getTemplCode();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_TemplCode_Default((IEntity)pSPFPluginTempl, bl2, bl3);
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

    protected EntityFieldError onCheckField_TemplCode2(boolean bl, PSPFPluginTempl pSPFPluginTempl, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSPFPluginTempl.isTemplCode2Dirty() : !pSPFPluginTempl.isTemplCode2Dirty()) {
            return null;
        }
        String string = pSPFPluginTempl.getTemplCode2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_TemplCode2_Default((IEntity)pSPFPluginTempl, bl2, bl3);
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

    protected EntityFieldError onCheckField_TemplCode3(boolean bl, PSPFPluginTempl pSPFPluginTempl, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSPFPluginTempl.isTemplCode3Dirty() : !pSPFPluginTempl.isTemplCode3Dirty()) {
            return null;
        }
        String string = pSPFPluginTempl.getTemplCode3();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_TemplCode3_Default((IEntity)pSPFPluginTempl, bl2, bl3);
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

    protected EntityFieldError onCheckField_TemplCode4(boolean bl, PSPFPluginTempl pSPFPluginTempl, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSPFPluginTempl.isTemplCode4Dirty() : !pSPFPluginTempl.isTemplCode4Dirty()) {
            return null;
        }
        String string = pSPFPluginTempl.getTemplCode4();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_TemplCode4_Default((IEntity)pSPFPluginTempl, bl2, bl3);
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

    protected EntityFieldError onCheckField_TemplDesc(boolean bl, PSPFPluginTempl pSPFPluginTempl, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSPFPluginTempl.isTemplDescDirty() : !pSPFPluginTempl.isTemplDescDirty()) {
            return null;
        }
        String string = pSPFPluginTempl.getTemplDesc();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_TemplDesc_Default((IEntity)pSPFPluginTempl, bl2, bl3);
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

    protected void onSyncEntity(PSPFPluginTempl pSPFPluginTempl, boolean bl) throws Exception {
        super.onSyncEntity((IEntity)pSPFPluginTempl, bl);
    }

    protected void onSyncIndexEntities(PSPFPluginTempl pSPFPluginTempl, boolean bl) throws Exception {
        super.onSyncIndexEntities((IEntity)pSPFPluginTempl, bl);
    }

    public Object getDataContextValue(PSPFPluginTempl pSPFPluginTempl, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null) {
            // empty if block
        }
        if ((object = super.getDataContextValue((IEntity)pSPFPluginTempl, string, iDataContextParam)) != null) {
            return object;
        }
        return null;
    }

    protected void onExportMajorModel(PSPFPluginTempl pSPFPluginTempl, ArrayList<JSONObject> arrayList, int n) throws Exception {
        super.onExportMajorModel((IEntity)pSPFPluginTempl, arrayList, n);
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
        if (StringHelper.compare((String)string, (String)"PSPFID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSPFId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSPFNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSPFName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSPFPLUGINID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSPFPluginId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSPFPLUGINNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSPFPluginName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSPFPLUGINTEMPLID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSPFPluginTemplId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSPFPLUGINTEMPLNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSPFPluginTemplName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSPFPUBCODEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSPFPubCodeId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSPFPUBCODENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSPFPubCodeName_Default(iEntity, bl, bl2);
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
        if (StringHelper.compare((String)string, (String)"TEMPLDESC", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_TemplDesc_Default(iEntity, bl, bl2);
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

    protected String onTestValueRule_PSPFPluginId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSPFPLUGINID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSPFPluginName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSPFPLUGINNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSPFPluginTemplId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSPFPLUGINTEMPLID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSPFPluginTemplName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSPFPLUGINTEMPLNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
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

    protected boolean onMergeChild(String string, String string2, PSPFPluginTempl pSPFPluginTempl) throws Exception {
        boolean bl = false;
        if (super.onMergeChild(string, string2, (IEntity)pSPFPluginTempl)) {
            bl = true;
        }
        return bl;
    }

    protected void onUpdateParent(PSPFPluginTempl pSPFPluginTempl) throws Exception {
        super.onUpdateParent((IEntity)pSPFPluginTempl);
    }

    @Override
    protected void exportCurXmlModel(PSPFPluginTempl pSPFPluginTempl, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSPFPLUGINTEMPL");
        if (!bl) {
            super.exportCurXmlModel(pSPFPluginTempl, xmlNode, bl);
        }
    }

    @Override
    protected String getEntityFolderKeyValue(PSPFPluginTempl pSPFPluginTempl, PSSystem pSSystem) throws Exception {
        PSPFPluginTempl pSPFPluginTempl2 = new PSPFPluginTempl();
        pSPFPluginTempl2.setPSPFPluginId(pSPFPluginTempl.getPSPFPluginId());
        pSPFPluginTempl2.setPSPFId(pSPFPluginTempl.getPSPFId());
        if (this.selectOne((IEntity)pSPFPluginTempl2, true)) {
            return pSPFPluginTempl2.getPSPFPluginTemplId();
        }
        return super.getEntityFolderKeyValue(pSPFPluginTempl, pSSystem);
    }
}

