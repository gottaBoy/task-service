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
import net.ibizsys.pscore.srv.config.entity.PSSysPFPlugin;
import net.ibizsys.pscore.srv.config.entity.PSSysPFPluginBase;
import net.ibizsys.pscore.srv.core.IPSDataEntityModel;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEToolbar;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEToolbarBase;
import net.ibizsys.pscore.srv.sysdesign.dao.PSSysTitleBarDAO;
import net.ibizsys.pscore.srv.sysdesign.demodel.PSSysTitleBarDEModel;
import net.ibizsys.pscore.srv.sysdesign.entity.PSLanguageRes;
import net.ibizsys.pscore.srv.sysdesign.entity.PSLanguageResBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysTitleBar;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSystem;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSystemBase;
import net.ibizsys.pscore.srv.sysdevstudio.entity.PSMOSFile;
import net.ibizsys.pscore.srv.util.IPSMOSFileFilter;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSSysTitleBarServiceBase
extends PSCoreSysServiceBase<PSSysTitleBar> {
    private static final Log log = LogFactory.getLog(PSSysTitleBarServiceBase.class);
    public static final String DATASET_DEFAULT = "DEFAULT";
    private PSSysTitleBarDEModel pSSysTitleBarDEModel;
    private PSSysTitleBarDAO pSSysTitleBarDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.sysdesign.service.PSSysTitleBarService";
    }

    public PSSysTitleBarDEModel getPSSysTitleBarDEModel() {
        if (this.pSSysTitleBarDEModel == null) {
            try {
                this.pSSysTitleBarDEModel = (PSSysTitleBarDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.sysdesign.demodel.PSSysTitleBarDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSSysTitleBarDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSSysTitleBarDEModel();
    }

    public PSSysTitleBarDAO getPSSysTitleBarDAO() {
        if (this.pSSysTitleBarDAO == null) {
            try {
                this.pSSysTitleBarDAO = (PSSysTitleBarDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.sysdesign.dao.PSSysTitleBarDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSSysTitleBarDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSSysTitleBarDAO();
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

    protected void onFillParentInfo(PSSysTitleBar pSSysTitleBar, String string, String string2, String string3) throws Exception {
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSTITLEBAR_PSDETOOLBAR_LEFTPSDETOOLBARID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEToolbarService", (SessionFactory)this.getSessionFactory());
            PSDEToolbar pSDEToolbar = (PSDEToolbar)iService.getDEModel().createEntity();
            pSDEToolbar.set("PSDETOOLBARID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDEToolbar);
            } else {
                iService.get(pSDEToolbar);
            }
            this.onFillParentInfo_LeftPSDEToolbar(pSSysTitleBar, pSDEToolbar);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSTITLEBAR_PSDETOOLBAR_RIGHTPSDETOOLBARID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEToolbarService", (SessionFactory)this.getSessionFactory());
            PSDEToolbar pSDEToolbar = (PSDEToolbar)iService.getDEModel().createEntity();
            pSDEToolbar.set("PSDETOOLBARID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDEToolbar);
            } else {
                iService.get(pSDEToolbar);
            }
            this.onFillParentInfo_RightPSDEToolbar(pSSysTitleBar, pSDEToolbar);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSTITLEBAR_PSLANGUAGERES_CAPPSLANRESID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSLanguageResService", (SessionFactory)this.getSessionFactory());
            PSLanguageRes pSLanguageRes = (PSLanguageRes)iService.getDEModel().createEntity();
            pSLanguageRes.set("PSLANGUAGERESID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSLanguageRes);
            } else {
                iService.get(pSLanguageRes);
            }
            this.onFillParentInfo_CapPSLanRes(pSSysTitleBar, pSLanguageRes);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSTITLEBAR_PSSYSPFPLUGIN_PSSYSPFPLUGINID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.config.service.PSSysPFPluginService", (SessionFactory)this.getSessionFactory());
            PSSysPFPlugin pSSysPFPlugin = (PSSysPFPlugin)iService.getDEModel().createEntity();
            pSSysPFPlugin.set("PSSYSPFPLUGINID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSSysPFPlugin);
            } else {
                iService.get(pSSysPFPlugin);
            }
            this.onFillParentInfo_PSSysPFPlugin(pSSysTitleBar, pSSysPFPlugin);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSTITLEBAR_PSSYSTEM_PSSYSTEMID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSystemService", (SessionFactory)this.getSessionFactory());
            PSSystem pSSystem = (PSSystem)iService.getDEModel().createEntity();
            pSSystem.set("PSSYSTEMID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSSystem);
            } else {
                iService.get(pSSystem);
            }
            this.onFillParentInfo_PSSystem(pSSysTitleBar, pSSystem);
            return;
        }
        super.onFillParentInfo(pSSysTitleBar, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillParentInfo_LeftPSDEToolbar(PSSysTitleBar pSSysTitleBar, PSDEToolbar pSDEToolbar) throws Exception {
        pSSysTitleBar.setLeftPSDEToolbarId(pSDEToolbar.getPSDEToolbarId());
        pSSysTitleBar.setLeftPSDEToolbarName(pSDEToolbar.getPSDEToolbarName());
    }

    protected void onFillParentInfo_RightPSDEToolbar(PSSysTitleBar pSSysTitleBar, PSDEToolbar pSDEToolbar) throws Exception {
        pSSysTitleBar.setRightPSDEToolbarId(pSDEToolbar.getPSDEToolbarId());
        pSSysTitleBar.setRightPSDEToolbarName(pSDEToolbar.getPSDEToolbarName());
    }

    protected void onFillParentInfo_CapPSLanRes(PSSysTitleBar pSSysTitleBar, PSLanguageRes pSLanguageRes) throws Exception {
        pSSysTitleBar.setCapPSLanResId(pSLanguageRes.getPSLanguageResId());
        pSSysTitleBar.setCapPSLanResName(pSLanguageRes.getPSLanguageResName());
    }

    protected void onFillParentInfo_PSSysPFPlugin(PSSysTitleBar pSSysTitleBar, PSSysPFPlugin pSSysPFPlugin) throws Exception {
        pSSysTitleBar.setPSSysPFPluginId(pSSysPFPlugin.getPSSysPFPluginId());
        pSSysTitleBar.setPSSysPFPluginName(pSSysPFPlugin.getPSSysPFPluginName());
    }

    protected void onFillParentInfo_PSSystem(PSSysTitleBar pSSysTitleBar, PSSystem pSSystem) throws Exception {
        pSSysTitleBar.setPSSystemId(pSSystem.getPSSystemId());
        pSSysTitleBar.setPSSystemName(pSSystem.getPSSystemName());
    }

    protected void onFillEntityFullInfo(PSSysTitleBar pSSysTitleBar, boolean bl) throws Exception {
        if (bl) {
            // empty if block
        }
        super.onFillEntityFullInfo(pSSysTitleBar, bl);
        this.onFillEntityFullInfo_LeftPSDEToolbar(pSSysTitleBar, bl);
        this.onFillEntityFullInfo_RightPSDEToolbar(pSSysTitleBar, bl);
        this.onFillEntityFullInfo_CapPSLanRes(pSSysTitleBar, bl);
        this.onFillEntityFullInfo_PSSysPFPlugin(pSSysTitleBar, bl);
        this.onFillEntityFullInfo_PSSystem(pSSysTitleBar, bl);
    }

    protected void onFillEntityFullInfo_LeftPSDEToolbar(PSSysTitleBar pSSysTitleBar, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_RightPSDEToolbar(PSSysTitleBar pSSysTitleBar, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_CapPSLanRes(PSSysTitleBar pSSysTitleBar, boolean bl) throws Exception {
        if (pSSysTitleBar.isCapPSLanResIdDirty()) {
            if (pSSysTitleBar.getCapPSLanResId() != null) {
                if (pSSysTitleBar.getCapPSLanResId() == null || pSSysTitleBar.getCapPSLanResName() == null) {
                    PSLanguageRes pSLanguageRes = pSSysTitleBar.getCapPSLanRes();
                    pSSysTitleBar.setCapPSLanResName(pSLanguageRes.getPSLanguageResName());
                }
            } else {
                pSSysTitleBar.setCapPSLanResName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_PSSysPFPlugin(PSSysTitleBar pSSysTitleBar, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSSystem(PSSysTitleBar pSSysTitleBar, boolean bl) throws Exception {
        if (pSSysTitleBar.isPSSystemIdDirty()) {
            if (pSSysTitleBar.getPSSystemId() != null) {
                if (pSSysTitleBar.getPSSystemId() == null || pSSysTitleBar.getPSSystemName() == null) {
                    PSSystem pSSystem = pSSysTitleBar.getPSSystem();
                    pSSysTitleBar.setPSSystemName(pSSystem.getPSSystemName());
                }
            } else {
                pSSysTitleBar.setPSSystemName(null);
            }
        }
    }

    protected void onWriteBackParent(PSSysTitleBar pSSysTitleBar, boolean bl) throws Exception {
        super.onWriteBackParent(pSSysTitleBar, bl);
    }

    public ArrayList<PSSysTitleBar> selectByLeftPSDEToolbar(PSDEToolbarBase pSDEToolbarBase) throws Exception {
        return this.selectByLeftPSDEToolbar(pSDEToolbarBase, "", -1);
    }

    public ArrayList<PSSysTitleBar> selectByLeftPSDEToolbar(PSDEToolbarBase pSDEToolbarBase, String string) throws Exception {
        return this.selectByLeftPSDEToolbar(pSDEToolbarBase, string, -1);
    }

    public ArrayList<PSSysTitleBar> selectByLeftPSDEToolbar(PSDEToolbarBase pSDEToolbarBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("LEFTPSDETOOLBARID", (Object)pSDEToolbarBase.getPSDEToolbarId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByLeftPSDEToolbarCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByLeftPSDEToolbarCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSSysTitleBar> selectByRightPSDEToolbar(PSDEToolbarBase pSDEToolbarBase) throws Exception {
        return this.selectByRightPSDEToolbar(pSDEToolbarBase, "", -1);
    }

    public ArrayList<PSSysTitleBar> selectByRightPSDEToolbar(PSDEToolbarBase pSDEToolbarBase, String string) throws Exception {
        return this.selectByRightPSDEToolbar(pSDEToolbarBase, string, -1);
    }

    public ArrayList<PSSysTitleBar> selectByRightPSDEToolbar(PSDEToolbarBase pSDEToolbarBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("RIGHTPSDETOOLBARID", (Object)pSDEToolbarBase.getPSDEToolbarId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByRightPSDEToolbarCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByRightPSDEToolbarCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSSysTitleBar> selectByCapPSLanRes(PSLanguageResBase pSLanguageResBase) throws Exception {
        return this.selectByCapPSLanRes(pSLanguageResBase, "", -1);
    }

    public ArrayList<PSSysTitleBar> selectByCapPSLanRes(PSLanguageResBase pSLanguageResBase, String string) throws Exception {
        return this.selectByCapPSLanRes(pSLanguageResBase, string, -1);
    }

    public ArrayList<PSSysTitleBar> selectByCapPSLanRes(PSLanguageResBase pSLanguageResBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("CAPPSLANRESID", (Object)pSLanguageResBase.getPSLanguageResId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByCapPSLanResCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByCapPSLanResCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSSysTitleBar> selectByPSSysPFPlugin(PSSysPFPluginBase pSSysPFPluginBase) throws Exception {
        return this.selectByPSSysPFPlugin(pSSysPFPluginBase, "", -1);
    }

    public ArrayList<PSSysTitleBar> selectByPSSysPFPlugin(PSSysPFPluginBase pSSysPFPluginBase, String string) throws Exception {
        return this.selectByPSSysPFPlugin(pSSysPFPluginBase, string, -1);
    }

    public ArrayList<PSSysTitleBar> selectByPSSysPFPlugin(PSSysPFPluginBase pSSysPFPluginBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSSYSPFPLUGINID", (Object)pSSysPFPluginBase.getPSSysPFPluginId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSSysPFPluginCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSSysPFPluginCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSSysTitleBar> selectByPSSystem(PSSystemBase pSSystemBase) throws Exception {
        return this.selectByPSSystem(pSSystemBase, "", -1);
    }

    public ArrayList<PSSysTitleBar> selectByPSSystem(PSSystemBase pSSystemBase, String string) throws Exception {
        return this.selectByPSSystem(pSSystemBase, string, -1);
    }

    public ArrayList<PSSysTitleBar> selectByPSSystem(PSSystemBase pSSystemBase, String string, int n) throws Exception {
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

    public void testRemoveByLeftPSDEToolbar(PSDEToolbar pSDEToolbar) throws Exception {
        ArrayList<PSSysTitleBar> arrayList = this.selectByLeftPSDEToolbar(pSDEToolbar, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDETOOLBAR");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDEToolbar);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSTITLEBAR_PSDETOOLBAR_LEFTPSDETOOLBARID", "", iDataEntityModel.getName(), "PSSYSTITLEBAR", iDataEntityModel.getDataInfo(pSDEToolbar), arrayList.get(0)));
        }
    }

    public void resetLeftPSDEToolbar(PSDEToolbar pSDEToolbar) throws Exception {
        ArrayList<PSSysTitleBar> arrayList = this.selectByLeftPSDEToolbar(pSDEToolbar);
        for (PSSysTitleBar pSSysTitleBar : arrayList) {
            PSSysTitleBar pSSysTitleBar2 = (PSSysTitleBar)this.getDEModel().createEntity();
            pSSysTitleBar2.setPSSysTitleBarId(pSSysTitleBar.getPSSysTitleBarId());
            pSSysTitleBar2.setLeftPSDEToolbarId(null);
            this.update(pSSysTitleBar2);
        }
    }

    public void removeByLeftPSDEToolbar(PSDEToolbar pSDEToolbar) throws Exception {
        final PSDEToolbar pSDEToolbar2 = pSDEToolbar;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysTitleBarServiceBase.this.onBeforeRemoveByLeftPSDEToolbar(pSDEToolbar2);
                PSSysTitleBarServiceBase.this.internalRemoveByLeftPSDEToolbar(pSDEToolbar2);
                PSSysTitleBarServiceBase.this.onAfterRemoveByLeftPSDEToolbar(pSDEToolbar2);
            }
        });
    }

    protected void onBeforeRemoveByLeftPSDEToolbar(PSDEToolbar pSDEToolbar) throws Exception {
    }

    protected void internalRemoveByLeftPSDEToolbar(PSDEToolbar pSDEToolbar) throws Exception {
        ArrayList<PSSysTitleBar> arrayList = this.selectByLeftPSDEToolbar(pSDEToolbar);
        this.onBeforeRemoveByLeftPSDEToolbar(pSDEToolbar, arrayList);
        for (PSSysTitleBar pSSysTitleBar : arrayList) {
            this.remove(pSSysTitleBar);
        }
        this.onAfterRemoveByLeftPSDEToolbar(pSDEToolbar, arrayList);
    }

    protected void onAfterRemoveByLeftPSDEToolbar(PSDEToolbar pSDEToolbar) throws Exception {
    }

    protected void onBeforeRemoveByLeftPSDEToolbar(PSDEToolbar pSDEToolbar, ArrayList<PSSysTitleBar> arrayList) throws Exception {
    }

    protected void onAfterRemoveByLeftPSDEToolbar(PSDEToolbar pSDEToolbar, ArrayList<PSSysTitleBar> arrayList) throws Exception {
    }

    public void testRemoveByRightPSDEToolbar(PSDEToolbar pSDEToolbar) throws Exception {
        ArrayList<PSSysTitleBar> arrayList = this.selectByRightPSDEToolbar(pSDEToolbar, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDETOOLBAR");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDEToolbar);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSTITLEBAR_PSDETOOLBAR_RIGHTPSDETOOLBARID", "", iDataEntityModel.getName(), "PSSYSTITLEBAR", iDataEntityModel.getDataInfo(pSDEToolbar), arrayList.get(0)));
        }
    }

    public void resetRightPSDEToolbar(PSDEToolbar pSDEToolbar) throws Exception {
        ArrayList<PSSysTitleBar> arrayList = this.selectByRightPSDEToolbar(pSDEToolbar);
        for (PSSysTitleBar pSSysTitleBar : arrayList) {
            PSSysTitleBar pSSysTitleBar2 = (PSSysTitleBar)this.getDEModel().createEntity();
            pSSysTitleBar2.setPSSysTitleBarId(pSSysTitleBar.getPSSysTitleBarId());
            pSSysTitleBar2.setRightPSDEToolbarId(null);
            this.update(pSSysTitleBar2);
        }
    }

    public void removeByRightPSDEToolbar(PSDEToolbar pSDEToolbar) throws Exception {
        final PSDEToolbar pSDEToolbar2 = pSDEToolbar;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysTitleBarServiceBase.this.onBeforeRemoveByRightPSDEToolbar(pSDEToolbar2);
                PSSysTitleBarServiceBase.this.internalRemoveByRightPSDEToolbar(pSDEToolbar2);
                PSSysTitleBarServiceBase.this.onAfterRemoveByRightPSDEToolbar(pSDEToolbar2);
            }
        });
    }

    protected void onBeforeRemoveByRightPSDEToolbar(PSDEToolbar pSDEToolbar) throws Exception {
    }

    protected void internalRemoveByRightPSDEToolbar(PSDEToolbar pSDEToolbar) throws Exception {
        ArrayList<PSSysTitleBar> arrayList = this.selectByRightPSDEToolbar(pSDEToolbar);
        this.onBeforeRemoveByRightPSDEToolbar(pSDEToolbar, arrayList);
        for (PSSysTitleBar pSSysTitleBar : arrayList) {
            this.remove(pSSysTitleBar);
        }
        this.onAfterRemoveByRightPSDEToolbar(pSDEToolbar, arrayList);
    }

    protected void onAfterRemoveByRightPSDEToolbar(PSDEToolbar pSDEToolbar) throws Exception {
    }

    protected void onBeforeRemoveByRightPSDEToolbar(PSDEToolbar pSDEToolbar, ArrayList<PSSysTitleBar> arrayList) throws Exception {
    }

    protected void onAfterRemoveByRightPSDEToolbar(PSDEToolbar pSDEToolbar, ArrayList<PSSysTitleBar> arrayList) throws Exception {
    }

    public void testRemoveByCapPSLanRes(PSLanguageRes pSLanguageRes) throws Exception {
        ArrayList<PSSysTitleBar> arrayList = this.selectByCapPSLanRes(pSLanguageRes, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSLANGUAGERES");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSLanguageRes);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSTITLEBAR_PSLANGUAGERES_CAPPSLANRESID", "", iDataEntityModel.getName(), "PSSYSTITLEBAR", iDataEntityModel.getDataInfo(pSLanguageRes), arrayList.get(0)));
        }
    }

    public void resetCapPSLanRes(PSLanguageRes pSLanguageRes) throws Exception {
        ArrayList<PSSysTitleBar> arrayList = this.selectByCapPSLanRes(pSLanguageRes);
        for (PSSysTitleBar pSSysTitleBar : arrayList) {
            PSSysTitleBar pSSysTitleBar2 = (PSSysTitleBar)this.getDEModel().createEntity();
            pSSysTitleBar2.setPSSysTitleBarId(pSSysTitleBar.getPSSysTitleBarId());
            pSSysTitleBar2.setCapPSLanResId(null);
            this.update(pSSysTitleBar2);
        }
    }

    public void removeByCapPSLanRes(PSLanguageRes pSLanguageRes) throws Exception {
        final PSLanguageRes pSLanguageRes2 = pSLanguageRes;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysTitleBarServiceBase.this.onBeforeRemoveByCapPSLanRes(pSLanguageRes2);
                PSSysTitleBarServiceBase.this.internalRemoveByCapPSLanRes(pSLanguageRes2);
                PSSysTitleBarServiceBase.this.onAfterRemoveByCapPSLanRes(pSLanguageRes2);
            }
        });
    }

    protected void onBeforeRemoveByCapPSLanRes(PSLanguageRes pSLanguageRes) throws Exception {
    }

    protected void internalRemoveByCapPSLanRes(PSLanguageRes pSLanguageRes) throws Exception {
        ArrayList<PSSysTitleBar> arrayList = this.selectByCapPSLanRes(pSLanguageRes);
        this.onBeforeRemoveByCapPSLanRes(pSLanguageRes, arrayList);
        for (PSSysTitleBar pSSysTitleBar : arrayList) {
            this.remove(pSSysTitleBar);
        }
        this.onAfterRemoveByCapPSLanRes(pSLanguageRes, arrayList);
    }

    protected void onAfterRemoveByCapPSLanRes(PSLanguageRes pSLanguageRes) throws Exception {
    }

    protected void onBeforeRemoveByCapPSLanRes(PSLanguageRes pSLanguageRes, ArrayList<PSSysTitleBar> arrayList) throws Exception {
    }

    protected void onAfterRemoveByCapPSLanRes(PSLanguageRes pSLanguageRes, ArrayList<PSSysTitleBar> arrayList) throws Exception {
    }

    public void testRemoveByPSSysPFPlugin(PSSysPFPlugin pSSysPFPlugin) throws Exception {
        ArrayList<PSSysTitleBar> arrayList = this.selectByPSSysPFPlugin(pSSysPFPlugin, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSPFPLUGIN");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSSysPFPlugin);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSTITLEBAR_PSSYSPFPLUGIN_PSSYSPFPLUGINID", "", iDataEntityModel.getName(), "PSSYSTITLEBAR", iDataEntityModel.getDataInfo(pSSysPFPlugin), arrayList.get(0)));
        }
    }

    public void resetPSSysPFPlugin(PSSysPFPlugin pSSysPFPlugin) throws Exception {
        ArrayList<PSSysTitleBar> arrayList = this.selectByPSSysPFPlugin(pSSysPFPlugin);
        for (PSSysTitleBar pSSysTitleBar : arrayList) {
            PSSysTitleBar pSSysTitleBar2 = (PSSysTitleBar)this.getDEModel().createEntity();
            pSSysTitleBar2.setPSSysTitleBarId(pSSysTitleBar.getPSSysTitleBarId());
            pSSysTitleBar2.setPSSysPFPluginId(null);
            this.update(pSSysTitleBar2);
        }
    }

    public void removeByPSSysPFPlugin(PSSysPFPlugin pSSysPFPlugin) throws Exception {
        final PSSysPFPlugin pSSysPFPlugin2 = pSSysPFPlugin;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysTitleBarServiceBase.this.onBeforeRemoveByPSSysPFPlugin(pSSysPFPlugin2);
                PSSysTitleBarServiceBase.this.internalRemoveByPSSysPFPlugin(pSSysPFPlugin2);
                PSSysTitleBarServiceBase.this.onAfterRemoveByPSSysPFPlugin(pSSysPFPlugin2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysPFPlugin(PSSysPFPlugin pSSysPFPlugin) throws Exception {
    }

    protected void internalRemoveByPSSysPFPlugin(PSSysPFPlugin pSSysPFPlugin) throws Exception {
        ArrayList<PSSysTitleBar> arrayList = this.selectByPSSysPFPlugin(pSSysPFPlugin);
        this.onBeforeRemoveByPSSysPFPlugin(pSSysPFPlugin, arrayList);
        for (PSSysTitleBar pSSysTitleBar : arrayList) {
            this.remove(pSSysTitleBar);
        }
        this.onAfterRemoveByPSSysPFPlugin(pSSysPFPlugin, arrayList);
    }

    protected void onAfterRemoveByPSSysPFPlugin(PSSysPFPlugin pSSysPFPlugin) throws Exception {
    }

    protected void onBeforeRemoveByPSSysPFPlugin(PSSysPFPlugin pSSysPFPlugin, ArrayList<PSSysTitleBar> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysPFPlugin(PSSysPFPlugin pSSysPFPlugin, ArrayList<PSSysTitleBar> arrayList) throws Exception {
    }

    public void testRemoveByPSSystem(PSSystem pSSystem) throws Exception {
    }

    public void resetPSSystem(PSSystem pSSystem) throws Exception {
        ArrayList<PSSysTitleBar> arrayList = this.selectByPSSystem(pSSystem);
        for (PSSysTitleBar pSSysTitleBar : arrayList) {
            PSSysTitleBar pSSysTitleBar2 = (PSSysTitleBar)this.getDEModel().createEntity();
            pSSysTitleBar2.setPSSysTitleBarId(pSSysTitleBar.getPSSysTitleBarId());
            pSSysTitleBar2.setPSSystemId(null);
            this.update(pSSysTitleBar2);
        }
    }

    public void removeByPSSystem(PSSystem pSSystem) throws Exception {
        final PSSystem pSSystem2 = pSSystem;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysTitleBarServiceBase.this.onBeforeRemoveByPSSystem(pSSystem2);
                PSSysTitleBarServiceBase.this.internalRemoveByPSSystem(pSSystem2);
                PSSysTitleBarServiceBase.this.onAfterRemoveByPSSystem(pSSystem2);
            }
        });
    }

    protected void onBeforeRemoveByPSSystem(PSSystem pSSystem) throws Exception {
    }

    protected void internalRemoveByPSSystem(PSSystem pSSystem) throws Exception {
        ArrayList<PSSysTitleBar> arrayList = this.selectByPSSystem(pSSystem);
        this.onBeforeRemoveByPSSystem(pSSystem, arrayList);
        for (PSSysTitleBar pSSysTitleBar : arrayList) {
            this.remove(pSSysTitleBar);
        }
        this.onAfterRemoveByPSSystem(pSSystem, arrayList);
    }

    protected void onAfterRemoveByPSSystem(PSSystem pSSystem) throws Exception {
    }

    protected void onBeforeRemoveByPSSystem(PSSystem pSSystem, ArrayList<PSSysTitleBar> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSystem(PSSystem pSSystem, ArrayList<PSSysTitleBar> arrayList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(PSSysTitleBar pSSysTitleBar) throws Exception {
        super.onBeforeRemove(pSSysTitleBar);
    }

    protected void replaceParentInfo(PSSysTitleBar pSSysTitleBar, CloneSession cloneSession) throws Exception {
        IEntity iEntity;
        super.replaceParentInfo(pSSysTitleBar, cloneSession);
        if (pSSysTitleBar.getLeftPSDEToolbarId() != null && (iEntity = cloneSession.getEntity("PSDETOOLBAR", (Object)pSSysTitleBar.getLeftPSDEToolbarId())) != null) {
            this.onFillParentInfo_LeftPSDEToolbar(pSSysTitleBar, (PSDEToolbar)iEntity);
        }
        if (pSSysTitleBar.getRightPSDEToolbarId() != null && (iEntity = cloneSession.getEntity("PSDETOOLBAR", (Object)pSSysTitleBar.getRightPSDEToolbarId())) != null) {
            this.onFillParentInfo_RightPSDEToolbar(pSSysTitleBar, (PSDEToolbar)iEntity);
        }
        if (pSSysTitleBar.getCapPSLanResId() != null && (iEntity = cloneSession.getEntity("PSLANGUAGERES", (Object)pSSysTitleBar.getCapPSLanResId())) != null) {
            this.onFillParentInfo_CapPSLanRes(pSSysTitleBar, (PSLanguageRes)iEntity);
        }
        if (pSSysTitleBar.getPSSysPFPluginId() != null && (iEntity = cloneSession.getEntity("PSSYSPFPLUGIN", (Object)pSSysTitleBar.getPSSysPFPluginId())) != null) {
            this.onFillParentInfo_PSSysPFPlugin(pSSysTitleBar, (PSSysPFPlugin)iEntity);
        }
        if (pSSysTitleBar.getPSSystemId() != null && (iEntity = cloneSession.getEntity("PSSYSTEM", (Object)pSSysTitleBar.getPSSystemId())) != null) {
            this.onFillParentInfo_PSSystem(pSSysTitleBar, (PSSystem)iEntity);
        }
    }

    protected void onRemoveEntityUncopyValues(PSSysTitleBar pSSysTitleBar, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues(pSSysTitleBar, bl);
    }

    protected void onCheckEntity(boolean bl, PSSysTitleBar pSSysTitleBar, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_CapPSLanResId(bl, pSSysTitleBar, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_CapPSLanResName(bl, pSSysTitleBar, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Caption(bl, pSSysTitleBar, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_LeftPSDEToolbarId(bl, pSSysTitleBar, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Memo(bl, pSSysTitleBar, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysPFPluginId(bl, pSSysTitleBar, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSystemId(bl, pSSysTitleBar, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSystemName(bl, pSSysTitleBar, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysTitleBarId(bl, pSSysTitleBar, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysTitleBarName(bl, pSSysTitleBar, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_RightPSDEToolbarId(bl, pSSysTitleBar, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_TitleBarStyle(bl, pSSysTitleBar, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, pSSysTitleBar, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_CapPSLanResId(boolean bl, PSSysTitleBar pSSysTitleBar, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysTitleBar.isCapPSLanResIdDirty() : !pSSysTitleBar.isCapPSLanResIdDirty()) {
            return null;
        }
        String string = pSSysTitleBar.getCapPSLanResId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_CapPSLanResId_Default(pSSysTitleBar, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CAPPSLANRESID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_CapPSLanResName(boolean bl, PSSysTitleBar pSSysTitleBar, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysTitleBar.isCapPSLanResNameDirty() : !pSSysTitleBar.isCapPSLanResNameDirty()) {
            return null;
        }
        String string = pSSysTitleBar.getCapPSLanResName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_CapPSLanResName_Default(pSSysTitleBar, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CAPPSLANRESNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Caption(boolean bl, PSSysTitleBar pSSysTitleBar, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysTitleBar.isCaptionDirty() : !pSSysTitleBar.isCaptionDirty()) {
            return null;
        }
        String string = pSSysTitleBar.getCaption();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Caption_Default(pSSysTitleBar, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CAPTION");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_LeftPSDEToolbarId(boolean bl, PSSysTitleBar pSSysTitleBar, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysTitleBar.isLeftPSDEToolbarIdDirty() : !pSSysTitleBar.isLeftPSDEToolbarIdDirty()) {
            return null;
        }
        String string = pSSysTitleBar.getLeftPSDEToolbarId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_LeftPSDEToolbarId_Default(pSSysTitleBar, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("LEFTPSDETOOLBARID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Memo(boolean bl, PSSysTitleBar pSSysTitleBar, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysTitleBar.isMemoDirty() : !pSSysTitleBar.isMemoDirty()) {
            return null;
        }
        String string = pSSysTitleBar.getMemo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Memo_Default(pSSysTitleBar, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSSysPFPluginId(boolean bl, PSSysTitleBar pSSysTitleBar, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysTitleBar.isPSSysPFPluginIdDirty() : !pSSysTitleBar.isPSSysPFPluginIdDirty()) {
            return null;
        }
        String string = pSSysTitleBar.getPSSysPFPluginId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysPFPluginId_Default(pSSysTitleBar, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSPFPLUGINID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSystemId(boolean bl, PSSysTitleBar pSSysTitleBar, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysTitleBar.isPSSystemIdDirty() : !pSSysTitleBar.isPSSystemIdDirty()) {
            return null;
        }
        String string = pSSysTitleBar.getPSSystemId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSystemId_Default(pSSysTitleBar, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSSystemName(boolean bl, PSSysTitleBar pSSysTitleBar, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysTitleBar.isPSSystemNameDirty() : !pSSysTitleBar.isPSSystemNameDirty()) {
            return null;
        }
        String string = pSSysTitleBar.getPSSystemName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSystemName_Default(pSSysTitleBar, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSSysTitleBarId(boolean bl, PSSysTitleBar pSSysTitleBar, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysTitleBar.isPSSysTitleBarIdDirty() && !bl2 : !pSSysTitleBar.isPSSysTitleBarIdDirty()) {
            return null;
        }
        String string = pSSysTitleBar.getPSSysTitleBarId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSTITLEBARID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysTitleBarId_Default(pSSysTitleBar, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSTITLEBARID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSysTitleBarName(boolean bl, PSSysTitleBar pSSysTitleBar, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysTitleBar.isPSSysTitleBarNameDirty() && !bl2 : !pSSysTitleBar.isPSSysTitleBarNameDirty()) {
            return null;
        }
        String string = pSSysTitleBar.getPSSysTitleBarName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSTITLEBARNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysTitleBarName_Default(pSSysTitleBar, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSTITLEBARNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_RightPSDEToolbarId(boolean bl, PSSysTitleBar pSSysTitleBar, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysTitleBar.isRightPSDEToolbarIdDirty() : !pSSysTitleBar.isRightPSDEToolbarIdDirty()) {
            return null;
        }
        String string = pSSysTitleBar.getRightPSDEToolbarId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_RightPSDEToolbarId_Default(pSSysTitleBar, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("RIGHTPSDETOOLBARID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_TitleBarStyle(boolean bl, PSSysTitleBar pSSysTitleBar, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysTitleBar.isTitleBarStyleDirty() : !pSSysTitleBar.isTitleBarStyleDirty()) {
            return null;
        }
        String string = pSSysTitleBar.getTitleBarStyle();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_TitleBarStyle_Default(pSSysTitleBar, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("TITLEBARSTYLE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected void onSyncEntity(PSSysTitleBar pSSysTitleBar, boolean bl) throws Exception {
        super.onSyncEntity(pSSysTitleBar, bl);
    }

    protected void onSyncIndexEntities(PSSysTitleBar pSSysTitleBar, boolean bl) throws Exception {
        super.onSyncIndexEntities(pSSysTitleBar, bl);
    }

    public Object getDataContextValue(PSSysTitleBar pSSysTitleBar, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null) {
            // empty if block
        }
        if ((object = super.getDataContextValue(pSSysTitleBar, string, iDataContextParam)) != null) {
            return object;
        }
        PSSystem pSSystem = pSSysTitleBar.getPSSystem();
        if (pSSystem != null && pSSystem.contains(string)) {
            return pSSystem.get(string);
        }
        return null;
    }

    protected void onExportMajorModel(PSSysTitleBar pSSysTitleBar, ArrayList<JSONObject> arrayList, int n) throws Exception {
        this.onExportMajorModel_CapPSLanRes(pSSysTitleBar, arrayList, n);
        super.onExportMajorModel(pSSysTitleBar, arrayList, n);
    }

    protected void onExportMajorModel_CapPSLanRes(PSSysTitleBar pSSysTitleBar, ArrayList<JSONObject> arrayList, int n) throws Exception {
        if (pSSysTitleBar.getCapPSLanRes() != null) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSLanguageResService", (SessionFactory)this.getSessionFactory());
            iService.exportModel(pSSysTitleBar.getCapPSLanRes(), arrayList, n);
        }
    }

    protected String onTestValueRule(String string, String string2, IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        if (StringHelper.compare((String)string, (String)"CAPPSLANRESID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CapPSLanResId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CAPPSLANRESNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CapPSLanResName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CAPTION", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Caption_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATEDATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateDate_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATEMAN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateMan_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"LEFTPSDETOOLBARID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_LeftPSDEToolbarId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"LEFTPSDETOOLBARNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_LeftPSDEToolbarName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MEMO", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Memo_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSPFPLUGINID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysPFPluginId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSPFPLUGINNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysPFPluginName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSTEMID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSystemId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSTEMNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSystemName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSTITLEBARID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysTitleBarId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSTITLEBARNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysTitleBarName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"RIGHTPSDETOOLBARID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_RightPSDEToolbarId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"RIGHTPSDETOOLBARNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_RightPSDEToolbarName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"TITLEBARSTYLE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_TitleBarStyle_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UPDATEDATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UpdateDate_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UPDATEMAN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UpdateMan_Default(iEntity, bl, bl2);
        }
        return super.onTestValueRule(string, string2, iEntity, bl, bl2);
    }

    protected String onTestValueRule_CapPSLanResId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("CAPPSLANRESID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_CapPSLanResName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("CAPPSLANRESNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_Caption_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("CAPTION", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
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

    protected String onTestValueRule_LeftPSDEToolbarId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("LEFTPSDETOOLBARID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_LeftPSDEToolbarName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("LEFTPSDETOOLBARNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
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

    protected String onTestValueRule_PSSysPFPluginId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSPFPLUGINID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysPFPluginName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSPFPLUGINNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
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

    protected String onTestValueRule_PSSysTitleBarId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSTITLEBARID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysTitleBarName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSTITLEBARNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_RightPSDEToolbarId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("RIGHTPSDETOOLBARID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_RightPSDEToolbarName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("RIGHTPSDETOOLBARNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_TitleBarStyle_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("TITLEBARSTYLE", iEntity, bl2, null, false, 50, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]";
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

    protected boolean onMergeChild(String string, String string2, PSSysTitleBar pSSysTitleBar) throws Exception {
        boolean bl = false;
        if (super.onMergeChild(string, string2, pSSysTitleBar)) {
            bl = true;
        }
        return bl;
    }

    protected void onUpdateParent(PSSysTitleBar pSSysTitleBar) throws Exception {
        super.onUpdateParent(pSSysTitleBar);
    }

    @Override
    protected void exportCurXmlModel(PSSysTitleBar pSSysTitleBar, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSSYSTITLEBAR");
        if (!bl) {
            pSSysTitleBar.setCreateDate(null);
            pSSysTitleBar.setCreateMan(null);
            pSSysTitleBar.setLeftPSDEToolbarName(null);
            pSSysTitleBar.setPSSysTitleBarId(null);
            pSSysTitleBar.setRightPSDEToolbarName(null);
            pSSysTitleBar.setUpdateDate(null);
            pSSysTitleBar.setUpdateMan(null);
            super.exportCurXmlModel(pSSysTitleBar, xmlNode, bl);
        }
    }

    @Override
    public ObjectNode fillModelV2(ObjectNode objectNode, PSSysTitleBar pSSysTitleBar, String string) throws Exception {
        objectNode = super.fillModelV2(objectNode, pSSysTitleBar, string);
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
            return "DER1N_PSSYSTITLEBAR_PSSYSTEM_PSSYSTEMID";
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
    public String getModelV2Tag(PSSysTitleBar pSSysTitleBar) {
        return super.getModelV2Tag(pSSysTitleBar);
    }

    @Override
    public boolean setModelV2Tag(PSSysTitleBar pSSysTitleBar, String string) {
        return super.setModelV2Tag(pSSysTitleBar, string);
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
    public boolean getModelV2Entity(PSSysTitleBar pSSysTitleBar, String string) throws Exception {
        SimpleEntity simpleEntity = new SimpleEntity();
        pSSysTitleBar.copyTo((IDataObject)simpleEntity, false);
        simpleEntity.copyTo((IDataObject)pSSysTitleBar, true);
        return super.getModelV2Entity(pSSysTitleBar, string);
    }

    @Override
    protected boolean testCompileCurModelV2(PSSysTitleBar pSSysTitleBar, ObjectNode objectNode, String string, String string2, int n) throws Exception {
        if (n == 1) {
            return false;
        }
        return super.testCompileCurModelV2(pSSysTitleBar, objectNode, string, string2, n);
    }
}

