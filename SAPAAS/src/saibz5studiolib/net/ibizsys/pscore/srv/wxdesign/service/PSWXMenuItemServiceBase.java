/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.fasterxml.jackson.databind.JsonNode
 *  com.fasterxml.jackson.databind.node.ArrayNode
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
 *  net.ibizsys.paas.db.SqlParamList
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
 *  net.ibizsys.paas.util.JsonNodeHelper
 *  net.ibizsys.paas.util.StringHelper
 *  net.ibizsys.paas.xml.XmlNode
 *  net.sf.json.JSONObject
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 *  org.hibernate.SessionFactory
 */
package net.ibizsys.pscore.srv.wxdesign.service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
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
import net.ibizsys.paas.db.SqlParamList;
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
import net.ibizsys.paas.util.JsonNodeHelper;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.xml.XmlNode;
import net.ibizsys.pscore.srv.PSCoreSysServiceBase;
import net.ibizsys.pscore.srv.core.IPSDataEntityModel;
import net.ibizsys.pscore.srv.helpdesign.entity.PSHelpSection;
import net.ibizsys.pscore.srv.sysdevstudio.entity.PSMOSFile;
import net.ibizsys.pscore.srv.util.IPSMOSFileAction;
import net.ibizsys.pscore.srv.util.IPSMOSFileFilter;
import net.ibizsys.pscore.srv.util.PSModelV2Helper;
import net.ibizsys.pscore.srv.wxdesign.dao.PSWXMenuItemDAO;
import net.ibizsys.pscore.srv.wxdesign.demodel.PSWXMenuItemDEModel;
import net.ibizsys.pscore.srv.wxdesign.entity.PSWXMenu;
import net.ibizsys.pscore.srv.wxdesign.entity.PSWXMenuBase;
import net.ibizsys.pscore.srv.wxdesign.entity.PSWXMenuFunc;
import net.ibizsys.pscore.srv.wxdesign.entity.PSWXMenuFuncBase;
import net.ibizsys.pscore.srv.wxdesign.entity.PSWXMenuItem;
import net.ibizsys.pscore.srv.wxdesign.entity.PSWXMenuItemBase;
import net.ibizsys.pscore.srv.wxdesign.service.PSWXMenuItemService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSWXMenuItemServiceBase
extends PSCoreSysServiceBase<PSWXMenuItem> {
    private static final Log log = LogFactory.getLog(PSWXMenuItemServiceBase.class);
    public static final String DATASET_DEFAULT = "DEFAULT";
    private PSWXMenuItemDEModel pSWXMenuItemDEModel;
    private PSWXMenuItemDAO pSWXMenuItemDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.wxdesign.service.PSWXMenuItemService";
    }

    public PSWXMenuItemDEModel getPSWXMenuItemDEModel() {
        if (this.pSWXMenuItemDEModel == null) {
            try {
                this.pSWXMenuItemDEModel = (PSWXMenuItemDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.wxdesign.demodel.PSWXMenuItemDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSWXMenuItemDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSWXMenuItemDEModel();
    }

    public PSWXMenuItemDAO getPSWXMenuItemDAO() {
        if (this.pSWXMenuItemDAO == null) {
            try {
                this.pSWXMenuItemDAO = (PSWXMenuItemDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.wxdesign.dao.PSWXMenuItemDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSWXMenuItemDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSWXMenuItemDAO();
    }

    protected DBFetchResult onfetchDataSet(String string, IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        if (StringHelper.compare((String)string, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.fetchDefault(iDEDataSetFetchContext);
        }
        return super.onfetchDataSet(string, iDEDataSetFetchContext);
    }

    protected DBFetchResult onfetchDataSetTemp(String string, IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        if (StringHelper.compare((String)string, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.fetchTempDefault(iDEDataSetFetchContext);
        }
        return super.onfetchDataSetTemp(string, iDEDataSetFetchContext);
    }

    @Override
    protected void onExecuteAction(String string, IEntity iEntity) throws Exception {
        super.onExecuteAction(string, iEntity);
    }

    public DBFetchResult fetchDefault(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_DEFAULT, false);
        return dBFetchResult;
    }

    public DBFetchResult fetchTempDefault(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_DEFAULT, true);
        return dBFetchResult;
    }

    protected void onFillParentInfo(PSWXMenuItem pSWXMenuItem, String string, String string2, String string3) throws Exception {
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSWXMENUITEM_PSWXMENUFUNC_PSWXMENUFUNCID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.wxdesign.service.PSWXMenuFuncService", (SessionFactory)this.getSessionFactory());
            PSWXMenuFunc pSWXMenuFunc = (PSWXMenuFunc)iService.getDEModel().createEntity();
            pSWXMenuFunc.set("PSWXMENUFUNCID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSWXMenuFunc);
            } else {
                iService.get(pSWXMenuFunc);
            }
            this.onFillParentInfo_PSWXMenuFunc(pSWXMenuItem, pSWXMenuFunc);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSWXMENUITEM_PSWXMENUITEM_PPSWXMENUITEMID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.wxdesign.service.PSWXMenuItemService", (SessionFactory)this.getSessionFactory());
            PSWXMenuItem pSWXMenuItem2 = (PSWXMenuItem)iService.getDEModel().createEntity();
            pSWXMenuItem2.set("PSWXMENUITEMID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSWXMenuItem2);
            } else {
                iService.get(pSWXMenuItem2);
            }
            this.onFillParentInfo_PPSWXMenuItem(pSWXMenuItem, pSWXMenuItem2);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSWXMENUITEM_PSWXMENU_PSWXMENUID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.wxdesign.service.PSWXMenuService", (SessionFactory)this.getSessionFactory());
            PSWXMenu pSWXMenu = (PSWXMenu)iService.getDEModel().createEntity();
            pSWXMenu.set("PSWXMENUID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSWXMenu);
            } else {
                iService.get(pSWXMenu);
            }
            this.onFillParentInfo_PSWXMenu(pSWXMenuItem, pSWXMenu);
            return;
        }
        super.onFillParentInfo(pSWXMenuItem, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillParentInfo_PSWXMenuFunc(PSWXMenuItem pSWXMenuItem, PSWXMenuFunc pSWXMenuFunc) throws Exception {
        pSWXMenuItem.setPSWXMenuFuncId(pSWXMenuFunc.getPSWXMenuFuncId());
        pSWXMenuItem.setPSWXMenuFuncName(pSWXMenuFunc.getPSWXMenuFuncName());
    }

    protected void onFillParentInfo_PPSWXMenuItem(PSWXMenuItem pSWXMenuItem, PSWXMenuItem pSWXMenuItem2) throws Exception {
        pSWXMenuItem.setPPSWXMenuItemId(pSWXMenuItem2.getPSWXMenuItemId());
        pSWXMenuItem.setPPSWXMenuItemName(pSWXMenuItem2.getPSWXMenuItemName());
        if (pSWXMenuItem2.getPSWXMenu() != null) {
            this.onFillParentInfo_PSWXMenu(pSWXMenuItem, pSWXMenuItem2.getPSWXMenu());
        }
    }

    protected void onFillParentInfo_PSWXMenu(PSWXMenuItem pSWXMenuItem, PSWXMenu pSWXMenu) throws Exception {
        pSWXMenuItem.setPSWXMenuId(pSWXMenu.getPSWXMenuId());
        pSWXMenuItem.setPSWXMenuName(pSWXMenu.getPSWXMenuName());
    }

    protected void onFillEntityFullInfo(PSWXMenuItem pSWXMenuItem, boolean bl) throws Exception {
        if (bl) {
            // empty if block
        }
        super.onFillEntityFullInfo(pSWXMenuItem, bl);
        this.onFillEntityFullInfo_PSWXMenuFunc(pSWXMenuItem, bl);
        this.onFillEntityFullInfo_PPSWXMenuItem(pSWXMenuItem, bl);
        this.onFillEntityFullInfo_PSWXMenu(pSWXMenuItem, bl);
    }

    protected void onFillEntityFullInfo_PSWXMenuFunc(PSWXMenuItem pSWXMenuItem, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PPSWXMenuItem(PSWXMenuItem pSWXMenuItem, boolean bl) throws Exception {
        if (pSWXMenuItem.isPPSWXMenuItemIdDirty()) {
            if (pSWXMenuItem.getPPSWXMenuItemId() != null) {
                PSWXMenuItem pSWXMenuItem2;
                if (pSWXMenuItem.getPPSWXMenuItemId() == null || pSWXMenuItem.getPPSWXMenuItemName() == null) {
                    pSWXMenuItem2 = pSWXMenuItem.getPPSWXMenuItem();
                    pSWXMenuItem.setPPSWXMenuItemName(pSWXMenuItem2.getPSWXMenuItemName());
                }
                if (DataTypeHelper.compare((int)25, (Object)(pSWXMenuItem2 = pSWXMenuItem.getPPSWXMenuItem()).getPSWXMenuId(), (Object)pSWXMenuItem.getPSWXMenuId()) != 0L) {
                    pSWXMenuItem.setPSWXMenuId(pSWXMenuItem2.getPSWXMenuId());
                    this.onFillEntityFullInfo_PSWXMenu(pSWXMenuItem, bl);
                }
            } else {
                pSWXMenuItem.setPPSWXMenuItemName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_PSWXMenu(PSWXMenuItem pSWXMenuItem, boolean bl) throws Exception {
        if (pSWXMenuItem.isPSWXMenuIdDirty()) {
            if (pSWXMenuItem.getPSWXMenuId() != null) {
                if (pSWXMenuItem.getPSWXMenuId() == null || pSWXMenuItem.getPSWXMenuName() == null) {
                    PSWXMenu pSWXMenu = pSWXMenuItem.getPSWXMenu();
                    pSWXMenuItem.setPSWXMenuName(pSWXMenu.getPSWXMenuName());
                }
            } else {
                pSWXMenuItem.setPSWXMenuName(null);
            }
        }
    }

    protected void onWriteBackParent(PSWXMenuItem pSWXMenuItem, boolean bl) throws Exception {
        super.onWriteBackParent(pSWXMenuItem, bl);
    }

    public ArrayList<PSWXMenuItem> selectByPSWXMenuFunc(PSWXMenuFuncBase pSWXMenuFuncBase) throws Exception {
        return this.selectByPSWXMenuFunc(pSWXMenuFuncBase, "", -1);
    }

    public ArrayList<PSWXMenuItem> selectByPSWXMenuFunc(PSWXMenuFuncBase pSWXMenuFuncBase, String string) throws Exception {
        return this.selectByPSWXMenuFunc(pSWXMenuFuncBase, string, -1);
    }

    public ArrayList<PSWXMenuItem> selectByPSWXMenuFunc(PSWXMenuFuncBase pSWXMenuFuncBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSWXMENUFUNCID", (Object)pSWXMenuFuncBase.getPSWXMenuFuncId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSWXMenuFuncCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSWXMenuFuncCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSWXMenuItem> selectByPPSWXMenuItem(PSWXMenuItemBase pSWXMenuItemBase) throws Exception {
        return this.selectByPPSWXMenuItem(pSWXMenuItemBase, "", -1);
    }

    public ArrayList<PSWXMenuItem> selectByPPSWXMenuItem(PSWXMenuItemBase pSWXMenuItemBase, String string) throws Exception {
        return this.selectByPPSWXMenuItem(pSWXMenuItemBase, string, -1);
    }

    public ArrayList<PSWXMenuItem> selectByPPSWXMenuItem(PSWXMenuItemBase pSWXMenuItemBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PPSWXMENUITEMID", (Object)pSWXMenuItemBase.getPSWXMenuItemId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPPSWXMenuItemCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPPSWXMenuItemCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSWXMenuItem> selectTempByPPSWXMenuItem(PSWXMenuItemBase pSWXMenuItemBase) throws Exception {
        return this.selectTempByPPSWXMenuItem(pSWXMenuItemBase, "");
    }

    public ArrayList<PSWXMenuItem> selectTempByPPSWXMenuItem(PSWXMenuItemBase pSWXMenuItemBase, String string) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PPSWXMENUITEMID", (Object)pSWXMenuItemBase.getPSWXMenuItemId());
        selectCond.setOrderInfo(string);
        this.onFillSelectTempByPPSWXMenuItemCond(selectCond);
        return this.selectTemp((ISelectCond)selectCond);
    }

    protected void onFillSelectTempByPPSWXMenuItemCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSWXMenuItem> selectByPSWXMenu(PSWXMenuBase pSWXMenuBase) throws Exception {
        return this.selectByPSWXMenu(pSWXMenuBase, "", -1);
    }

    public ArrayList<PSWXMenuItem> selectByPSWXMenu(PSWXMenuBase pSWXMenuBase, String string) throws Exception {
        return this.selectByPSWXMenu(pSWXMenuBase, string, -1);
    }

    public ArrayList<PSWXMenuItem> selectByPSWXMenu(PSWXMenuBase pSWXMenuBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSWXMENUID", (Object)pSWXMenuBase.getPSWXMenuId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSWXMenuCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSWXMenuCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSWXMenuItem> selectTempByPSWXMenu(PSWXMenuBase pSWXMenuBase) throws Exception {
        return this.selectTempByPSWXMenu(pSWXMenuBase, "");
    }

    public ArrayList<PSWXMenuItem> selectTempByPSWXMenu(PSWXMenuBase pSWXMenuBase, String string) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSWXMENUID", (Object)pSWXMenuBase.getPSWXMenuId());
        selectCond.setOrderInfo(string);
        this.onFillSelectTempByPSWXMenuCond(selectCond);
        return this.selectTemp((ISelectCond)selectCond);
    }

    protected void onFillSelectTempByPSWXMenuCond(SelectCond selectCond) throws Exception {
    }

    public void testRemoveByPSWXMenuFunc(PSWXMenuFunc pSWXMenuFunc) throws Exception {
        ArrayList<PSWXMenuItem> arrayList = this.selectByPSWXMenuFunc(pSWXMenuFunc, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSWXMENUFUNC");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSWXMenuFunc);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSWXMENUITEM_PSWXMENUFUNC_PSWXMENUFUNCID", "", iDataEntityModel.getName(), "PSWXMENUITEM", iDataEntityModel.getDataInfo(pSWXMenuFunc), arrayList.get(0)));
        }
    }

    public void resetPSWXMenuFunc(PSWXMenuFunc pSWXMenuFunc) throws Exception {
        ArrayList<PSWXMenuItem> arrayList = this.selectByPSWXMenuFunc(pSWXMenuFunc);
        for (PSWXMenuItem pSWXMenuItem : arrayList) {
            PSWXMenuItem pSWXMenuItem2 = (PSWXMenuItem)this.getDEModel().createEntity();
            pSWXMenuItem2.setPSWXMenuItemId(pSWXMenuItem.getPSWXMenuItemId());
            pSWXMenuItem2.setPSWXMenuFuncId(null);
            this.update(pSWXMenuItem2);
        }
    }

    public void removeByPSWXMenuFunc(PSWXMenuFunc pSWXMenuFunc) throws Exception {
        final PSWXMenuFunc pSWXMenuFunc2 = pSWXMenuFunc;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSWXMenuItemServiceBase.this.onBeforeRemoveByPSWXMenuFunc(pSWXMenuFunc2);
                PSWXMenuItemServiceBase.this.internalRemoveByPSWXMenuFunc(pSWXMenuFunc2);
                PSWXMenuItemServiceBase.this.onAfterRemoveByPSWXMenuFunc(pSWXMenuFunc2);
            }
        });
    }

    protected void onBeforeRemoveByPSWXMenuFunc(PSWXMenuFunc pSWXMenuFunc) throws Exception {
    }

    protected void internalRemoveByPSWXMenuFunc(PSWXMenuFunc pSWXMenuFunc) throws Exception {
        ArrayList<PSWXMenuItem> arrayList = this.selectByPSWXMenuFunc(pSWXMenuFunc);
        this.onBeforeRemoveByPSWXMenuFunc(pSWXMenuFunc, arrayList);
        for (PSWXMenuItem pSWXMenuItem : arrayList) {
            this.remove(pSWXMenuItem);
        }
        this.onAfterRemoveByPSWXMenuFunc(pSWXMenuFunc, arrayList);
    }

    protected void onAfterRemoveByPSWXMenuFunc(PSWXMenuFunc pSWXMenuFunc) throws Exception {
    }

    protected void onBeforeRemoveByPSWXMenuFunc(PSWXMenuFunc pSWXMenuFunc, ArrayList<PSWXMenuItem> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSWXMenuFunc(PSWXMenuFunc pSWXMenuFunc, ArrayList<PSWXMenuItem> arrayList) throws Exception {
    }

    public void testRemoveByPPSWXMenuItem(PSWXMenuItem pSWXMenuItem) throws Exception {
    }

    public void resetPPSWXMenuItem(PSWXMenuItem pSWXMenuItem) throws Exception {
        ArrayList<PSWXMenuItem> arrayList = this.selectByPPSWXMenuItem(pSWXMenuItem);
        for (PSWXMenuItem pSWXMenuItem2 : arrayList) {
            PSWXMenuItem pSWXMenuItem3 = (PSWXMenuItem)this.getDEModel().createEntity();
            pSWXMenuItem3.setPSWXMenuItemId(pSWXMenuItem2.getPSWXMenuItemId());
            pSWXMenuItem3.setPPSWXMenuItemId(null);
            this.update(pSWXMenuItem3);
        }
    }

    public void resetTempPPSWXMenuItem(PSWXMenuItem pSWXMenuItem) throws Exception {
        ArrayList<PSWXMenuItem> arrayList = this.selectTempByPPSWXMenuItem(pSWXMenuItem);
        for (PSWXMenuItem pSWXMenuItem2 : arrayList) {
            PSWXMenuItem pSWXMenuItem3 = (PSWXMenuItem)this.getDEModel().createEntity();
            pSWXMenuItem3.setPSWXMenuItemId(pSWXMenuItem2.getPSWXMenuItemId());
            pSWXMenuItem3.setPPSWXMenuItemId(null);
            this.updateTemp(pSWXMenuItem3);
        }
    }

    public void removeByPPSWXMenuItem(PSWXMenuItem pSWXMenuItem) throws Exception {
        final PSWXMenuItem pSWXMenuItem2 = pSWXMenuItem;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSWXMenuItemServiceBase.this.onBeforeRemoveByPPSWXMenuItem(pSWXMenuItem2);
                PSWXMenuItemServiceBase.this.internalRemoveByPPSWXMenuItem(pSWXMenuItem2);
                PSWXMenuItemServiceBase.this.onAfterRemoveByPPSWXMenuItem(pSWXMenuItem2);
            }
        });
    }

    protected void onBeforeRemoveByPPSWXMenuItem(PSWXMenuItem pSWXMenuItem) throws Exception {
    }

    protected void internalRemoveByPPSWXMenuItem(PSWXMenuItem pSWXMenuItem) throws Exception {
        ArrayList<PSWXMenuItem> arrayList = this.selectByPPSWXMenuItem(pSWXMenuItem);
        this.onBeforeRemoveByPPSWXMenuItem(pSWXMenuItem, arrayList);
        for (PSWXMenuItem pSWXMenuItem2 : arrayList) {
            this.remove(pSWXMenuItem2);
        }
        this.onAfterRemoveByPPSWXMenuItem(pSWXMenuItem, arrayList);
    }

    protected void onAfterRemoveByPPSWXMenuItem(PSWXMenuItem pSWXMenuItem) throws Exception {
    }

    protected void onBeforeRemoveByPPSWXMenuItem(PSWXMenuItem pSWXMenuItem, ArrayList<PSWXMenuItem> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPPSWXMenuItem(PSWXMenuItem pSWXMenuItem, ArrayList<PSWXMenuItem> arrayList) throws Exception {
    }

    public void testRemoveByPSWXMenu(PSWXMenu pSWXMenu) throws Exception {
    }

    public void resetPSWXMenu(PSWXMenu pSWXMenu) throws Exception {
        ArrayList<PSWXMenuItem> arrayList = this.selectByPSWXMenu(pSWXMenu);
        for (PSWXMenuItem pSWXMenuItem : arrayList) {
            PSWXMenuItem pSWXMenuItem2 = (PSWXMenuItem)this.getDEModel().createEntity();
            pSWXMenuItem2.setPSWXMenuItemId(pSWXMenuItem.getPSWXMenuItemId());
            pSWXMenuItem2.setPSWXMenuId(null);
            this.update(pSWXMenuItem2);
        }
    }

    public void resetTempPSWXMenu(PSWXMenu pSWXMenu) throws Exception {
        ArrayList<PSWXMenuItem> arrayList = this.selectTempByPSWXMenu(pSWXMenu);
        for (PSWXMenuItem pSWXMenuItem : arrayList) {
            PSWXMenuItem pSWXMenuItem2 = (PSWXMenuItem)this.getDEModel().createEntity();
            pSWXMenuItem2.setPSWXMenuItemId(pSWXMenuItem.getPSWXMenuItemId());
            pSWXMenuItem2.setPSWXMenuId(null);
            this.updateTemp(pSWXMenuItem2);
        }
    }

    public void removeByPSWXMenu(PSWXMenu pSWXMenu) throws Exception {
        final PSWXMenu pSWXMenu2 = pSWXMenu;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSWXMenuItemServiceBase.this.onBeforeRemoveByPSWXMenu(pSWXMenu2);
                PSWXMenuItemServiceBase.this.internalRemoveByPSWXMenu(pSWXMenu2);
                PSWXMenuItemServiceBase.this.onAfterRemoveByPSWXMenu(pSWXMenu2);
            }
        });
    }

    protected void onBeforeRemoveByPSWXMenu(PSWXMenu pSWXMenu) throws Exception {
    }

    protected void internalRemoveByPSWXMenu(PSWXMenu pSWXMenu) throws Exception {
        ArrayList<PSWXMenuItem> arrayList = this.selectByPSWXMenu(pSWXMenu);
        this.onBeforeRemoveByPSWXMenu(pSWXMenu, arrayList);
        for (PSWXMenuItem pSWXMenuItem : arrayList) {
            this.remove(pSWXMenuItem);
        }
        this.onAfterRemoveByPSWXMenu(pSWXMenu, arrayList);
    }

    protected void onAfterRemoveByPSWXMenu(PSWXMenu pSWXMenu) throws Exception {
    }

    protected void onBeforeRemoveByPSWXMenu(PSWXMenu pSWXMenu, ArrayList<PSWXMenuItem> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSWXMenu(PSWXMenu pSWXMenu, ArrayList<PSWXMenuItem> arrayList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(PSWXMenuItem pSWXMenuItem) throws Exception {
        PSWXMenuItemService pSWXMenuItemService = (PSWXMenuItemService)ServiceGlobal.getService(PSWXMenuItemService.class, (SessionFactory)this.getSessionFactory());
        pSWXMenuItemService.testRemoveByPPSWXMenuItem(pSWXMenuItem);
        pSWXMenuItemService.resetPPSWXMenuItem(pSWXMenuItem);
        super.onBeforeRemove(pSWXMenuItem);
    }

    protected void onBeforeRemoveTemp(PSWXMenuItem pSWXMenuItem) throws Exception {
        PSWXMenuItemService pSWXMenuItemService = (PSWXMenuItemService)ServiceGlobal.getService(PSWXMenuItemService.class, (SessionFactory)this.getSessionFactory());
        pSWXMenuItemService.resetTempPPSWXMenuItem(pSWXMenuItem);
        super.onBeforeRemoveTemp(pSWXMenuItem);
    }

    public void removeTempByPPSWXMenuItem(PSWXMenuItem pSWXMenuItem) throws Exception {
        final PSWXMenuItem pSWXMenuItem2 = pSWXMenuItem;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSWXMenuItemServiceBase.this.onBeforeRemoveTempByPPSWXMenuItem(pSWXMenuItem2);
                PSWXMenuItemServiceBase.this.internalRemoveTempByPPSWXMenuItem(pSWXMenuItem2);
                PSWXMenuItemServiceBase.this.onAfterRemoveTempByPPSWXMenuItem(pSWXMenuItem2);
            }
        });
    }

    protected void onBeforeRemoveTempByPPSWXMenuItem(PSWXMenuItem pSWXMenuItem) throws Exception {
    }

    protected void internalRemoveTempByPPSWXMenuItem(PSWXMenuItem pSWXMenuItem) throws Exception {
        ArrayList<PSWXMenuItem> arrayList = this.selectTempByPPSWXMenuItem(pSWXMenuItem);
        this.onBeforeRemoveTempByPPSWXMenuItem(pSWXMenuItem, arrayList);
        for (PSWXMenuItem pSWXMenuItem2 : arrayList) {
            this.removeTemp(pSWXMenuItem2);
        }
        this.onAfterRemoveTempByPPSWXMenuItem(pSWXMenuItem, arrayList);
    }

    protected void onAfterRemoveTempByPPSWXMenuItem(PSWXMenuItem pSWXMenuItem) throws Exception {
    }

    protected void onBeforeRemoveTempByPPSWXMenuItem(PSWXMenuItem pSWXMenuItem, ArrayList<PSWXMenuItem> arrayList) throws Exception {
    }

    protected void onAfterRemoveTempByPPSWXMenuItem(PSWXMenuItem pSWXMenuItem, ArrayList<PSWXMenuItem> arrayList) throws Exception {
    }

    public void removeTempByPSWXMenu(PSWXMenu pSWXMenu) throws Exception {
        final PSWXMenu pSWXMenu2 = pSWXMenu;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSWXMenuItemServiceBase.this.onBeforeRemoveTempByPSWXMenu(pSWXMenu2);
                PSWXMenuItemServiceBase.this.internalRemoveTempByPSWXMenu(pSWXMenu2);
                PSWXMenuItemServiceBase.this.onAfterRemoveTempByPSWXMenu(pSWXMenu2);
            }
        });
    }

    protected void onBeforeRemoveTempByPSWXMenu(PSWXMenu pSWXMenu) throws Exception {
    }

    protected void internalRemoveTempByPSWXMenu(PSWXMenu pSWXMenu) throws Exception {
        ArrayList<PSWXMenuItem> arrayList = this.selectTempByPSWXMenu(pSWXMenu);
        this.onBeforeRemoveTempByPSWXMenu(pSWXMenu, arrayList);
        for (PSWXMenuItem pSWXMenuItem : arrayList) {
            this.removeTemp(pSWXMenuItem);
        }
        this.onAfterRemoveTempByPSWXMenu(pSWXMenu, arrayList);
    }

    protected void onAfterRemoveTempByPSWXMenu(PSWXMenu pSWXMenu) throws Exception {
    }

    protected void onBeforeRemoveTempByPSWXMenu(PSWXMenu pSWXMenu, ArrayList<PSWXMenuItem> arrayList) throws Exception {
    }

    protected void onAfterRemoveTempByPSWXMenu(PSWXMenu pSWXMenu, ArrayList<PSWXMenuItem> arrayList) throws Exception {
    }

    protected void getRelatedDataTempMajor(PSWXMenuItem pSWXMenuItem) throws Exception {
        super.getRelatedDataTempMajor(pSWXMenuItem);
    }

    protected void updateRelatedDataTempMajor(PSWXMenuItem pSWXMenuItem, PSWXMenuItem pSWXMenuItem2) throws Exception {
        super.updateRelatedDataTempMajor(pSWXMenuItem, pSWXMenuItem2);
    }

    protected void replaceParentInfo(PSWXMenuItem pSWXMenuItem, CloneSession cloneSession) throws Exception {
        IEntity iEntity;
        super.replaceParentInfo(pSWXMenuItem, cloneSession);
        if (pSWXMenuItem.getPSWXMenuFuncId() != null && (iEntity = cloneSession.getEntity("PSWXMENUFUNC", (Object)pSWXMenuItem.getPSWXMenuFuncId())) != null) {
            this.onFillParentInfo_PSWXMenuFunc(pSWXMenuItem, (PSWXMenuFunc)iEntity);
        }
        if (pSWXMenuItem.getPPSWXMenuItemId() != null && (iEntity = cloneSession.getEntity("PSWXMENUITEM", (Object)pSWXMenuItem.getPPSWXMenuItemId())) != null) {
            this.onFillParentInfo_PPSWXMenuItem(pSWXMenuItem, (PSWXMenuItem)iEntity);
        }
        if (pSWXMenuItem.getPSWXMenuId() != null && (iEntity = cloneSession.getEntity("PSWXMENU", (Object)pSWXMenuItem.getPSWXMenuId())) != null) {
            this.onFillParentInfo_PSWXMenu(pSWXMenuItem, (PSWXMenu)iEntity);
        }
    }

    protected void onRemoveEntityUncopyValues(PSWXMenuItem pSWXMenuItem, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues(pSWXMenuItem, bl);
    }

    protected void onCheckEntity(boolean bl, PSWXMenuItem pSWXMenuItem, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_Caption(bl, pSWXMenuItem, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Memo(bl, pSWXMenuItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_OrderValue(bl, pSWXMenuItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PPSWXMenuItemId(bl, pSWXMenuItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PPSWXMenuItemName(bl, pSWXMenuItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSWXMenuFuncId(bl, pSWXMenuItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSWXMenuId(bl, pSWXMenuItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSWXMenuItemId(bl, pSWXMenuItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSWXMenuItemName(bl, pSWXMenuItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSWXMenuName(bl, pSWXMenuItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserCat(bl, pSWXMenuItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag(bl, pSWXMenuItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag2(bl, pSWXMenuItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag3(bl, pSWXMenuItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag4(bl, pSWXMenuItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, pSWXMenuItem, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_Caption(boolean bl, PSWXMenuItem pSWXMenuItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWXMenuItem.isCaptionDirty() : !pSWXMenuItem.isCaptionDirty()) {
            return null;
        }
        String string = pSWXMenuItem.getCaption();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Caption_Default(pSWXMenuItem, bl2, bl3);
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

    protected EntityFieldError onCheckField_Memo(boolean bl, PSWXMenuItem pSWXMenuItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWXMenuItem.isMemoDirty() : !pSWXMenuItem.isMemoDirty()) {
            return null;
        }
        String string = pSWXMenuItem.getMemo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Memo_Default(pSWXMenuItem, bl2, bl3);
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

    protected EntityFieldError onCheckField_OrderValue(boolean bl, PSWXMenuItem pSWXMenuItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWXMenuItem.isOrderValueDirty() : !pSWXMenuItem.isOrderValueDirty()) {
            return null;
        }
        Integer n = pSWXMenuItem.getOrderValue();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_OrderValue_Default(pSWXMenuItem, bl2, bl3);
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

    protected EntityFieldError onCheckField_PPSWXMenuItemId(boolean bl, PSWXMenuItem pSWXMenuItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWXMenuItem.isPPSWXMenuItemIdDirty() : !pSWXMenuItem.isPPSWXMenuItemIdDirty()) {
            return null;
        }
        String string = pSWXMenuItem.getPPSWXMenuItemId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PPSWXMenuItemId_Default(pSWXMenuItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PPSWXMENUITEMID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PPSWXMenuItemName(boolean bl, PSWXMenuItem pSWXMenuItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWXMenuItem.isPPSWXMenuItemNameDirty() : !pSWXMenuItem.isPPSWXMenuItemNameDirty()) {
            return null;
        }
        String string = pSWXMenuItem.getPPSWXMenuItemName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PPSWXMenuItemName_Default(pSWXMenuItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PPSWXMENUITEMNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSWXMenuFuncId(boolean bl, PSWXMenuItem pSWXMenuItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWXMenuItem.isPSWXMenuFuncIdDirty() : !pSWXMenuItem.isPSWXMenuFuncIdDirty()) {
            return null;
        }
        String string = pSWXMenuItem.getPSWXMenuFuncId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSWXMenuFuncId_Default(pSWXMenuItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSWXMENUFUNCID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSWXMenuId(boolean bl, PSWXMenuItem pSWXMenuItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWXMenuItem.isPSWXMenuIdDirty() && !bl2 : !pSWXMenuItem.isPSWXMenuIdDirty()) {
            return null;
        }
        String string = pSWXMenuItem.getPSWXMenuId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSWXMENUID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSWXMenuId_Default(pSWXMenuItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSWXMENUID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSWXMenuItemId(boolean bl, PSWXMenuItem pSWXMenuItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWXMenuItem.isPSWXMenuItemIdDirty() && !bl2 : !pSWXMenuItem.isPSWXMenuItemIdDirty()) {
            return null;
        }
        String string = pSWXMenuItem.getPSWXMenuItemId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSWXMENUITEMID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSWXMenuItemId_Default(pSWXMenuItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSWXMENUITEMID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSWXMenuItemName(boolean bl, PSWXMenuItem pSWXMenuItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWXMenuItem.isPSWXMenuItemNameDirty() && !bl2 : !pSWXMenuItem.isPSWXMenuItemNameDirty()) {
            return null;
        }
        String string = pSWXMenuItem.getPSWXMenuItemName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSWXMENUITEMNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSWXMenuItemName_Default(pSWXMenuItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSWXMENUITEMNAME");
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
                string3 = "PSWXMENUID";
                String string4 = this.checkFieldDupRule(this.getPSWXMenuItemDEModel(), "PSWXMENUITEMNAME", string3, pSWXMenuItem, bl2, bl3);
                if (!StringHelper.isNullOrEmpty((String)string4)) {
                    EntityFieldError entityFieldError = new EntityFieldError();
                    entityFieldError.setFieldName("PSWXMENUITEMNAME");
                    entityFieldError.setErrorType(3);
                    entityFieldError.setErrorInfo(string4);
                    return entityFieldError;
                }
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSWXMenuName(boolean bl, PSWXMenuItem pSWXMenuItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWXMenuItem.isPSWXMenuNameDirty() : !pSWXMenuItem.isPSWXMenuNameDirty()) {
            return null;
        }
        String string = pSWXMenuItem.getPSWXMenuName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSWXMenuName_Default(pSWXMenuItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSWXMENUNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_UserCat(boolean bl, PSWXMenuItem pSWXMenuItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWXMenuItem.isUserCatDirty() : !pSWXMenuItem.isUserCatDirty()) {
            return null;
        }
        String string = pSWXMenuItem.getUserCat();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserCat_Default(pSWXMenuItem, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag(boolean bl, PSWXMenuItem pSWXMenuItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWXMenuItem.isUserTagDirty() : !pSWXMenuItem.isUserTagDirty()) {
            return null;
        }
        String string = pSWXMenuItem.getUserTag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag_Default(pSWXMenuItem, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag2(boolean bl, PSWXMenuItem pSWXMenuItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWXMenuItem.isUserTag2Dirty() : !pSWXMenuItem.isUserTag2Dirty()) {
            return null;
        }
        String string = pSWXMenuItem.getUserTag2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag2_Default(pSWXMenuItem, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag3(boolean bl, PSWXMenuItem pSWXMenuItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWXMenuItem.isUserTag3Dirty() : !pSWXMenuItem.isUserTag3Dirty()) {
            return null;
        }
        String string = pSWXMenuItem.getUserTag3();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag3_Default(pSWXMenuItem, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag4(boolean bl, PSWXMenuItem pSWXMenuItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWXMenuItem.isUserTag4Dirty() : !pSWXMenuItem.isUserTag4Dirty()) {
            return null;
        }
        String string = pSWXMenuItem.getUserTag4();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag4_Default(pSWXMenuItem, bl2, bl3);
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

    protected void onSyncEntity(PSWXMenuItem pSWXMenuItem, boolean bl) throws Exception {
        super.onSyncEntity(pSWXMenuItem, bl);
    }

    protected void onSyncIndexEntities(PSWXMenuItem pSWXMenuItem, boolean bl) throws Exception {
        super.onSyncIndexEntities(pSWXMenuItem, bl);
    }

    public Object getDataContextValue(PSWXMenuItem pSWXMenuItem, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null) {
            // empty if block
        }
        if ((object = super.getDataContextValue(pSWXMenuItem, string, iDataContextParam)) != null) {
            return object;
        }
        PSWXMenu pSWXMenu = pSWXMenuItem.getPSWXMenu();
        if (pSWXMenu != null && pSWXMenu.contains(string)) {
            return pSWXMenu.get(string);
        }
        return null;
    }

    protected void onExportMajorModel(PSWXMenuItem pSWXMenuItem, ArrayList<JSONObject> arrayList, int n) throws Exception {
        super.onExportMajorModel(pSWXMenuItem, arrayList, n);
    }

    protected String onTestValueRule(String string, String string2, IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        if (StringHelper.compare((String)string, (String)"CAPTION", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Caption_Default(iEntity, bl, bl2);
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
        if (StringHelper.compare((String)string, (String)"ORDERVALUE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_OrderValue_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PPSWXMENUITEMID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PPSWXMenuItemId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PPSWXMENUITEMNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PPSWXMenuItemName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSWXMENUFUNCID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSWXMenuFuncId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSWXMENUFUNCNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSWXMenuFuncName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSWXMENUID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSWXMenuId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSWXMENUITEMID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSWXMenuItemId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSWXMENUITEMNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSWXMenuItemName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSWXMENUNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSWXMenuName_Default(iEntity, bl, bl2);
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

    protected String onTestValueRule_Caption_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("CAPTION", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
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

    protected String onTestValueRule_PPSWXMenuItemId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PPSWXMENUITEMID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PPSWXMenuItemName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PPSWXMENUITEMNAME", iEntity, bl2, null, false, 30, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSWXMenuFuncId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSWXMENUFUNCID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSWXMenuFuncName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSWXMENUFUNCNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSWXMenuId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSWXMENUID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSWXMenuItemId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSWXMENUITEMID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSWXMenuItemName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSWXMENUITEMNAME", iEntity, bl2, null, false, 30, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]", false) && this.checkFieldRegExRule("PSWXMENUITEMNAME", iEntity, bl2, "[a-zA-Z_$][a-zA-Z0-9_$]*", "\u5185\u5bb9\u53ea\u80fd\u7531\u5b57\u6bcd\u3001\u6570\u5b57\u3001\u4e0b\u5212\u7ebf\u7ec4\u6210\uff0c\u4e14\u5f00\u59cb\u5fc5\u987b\u4e3a\u5b57\u6bcd", false)) {
                return null;
            }
            return "(\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30] \u5e76\u4e14 \u5185\u5bb9\u53ea\u80fd\u7531\u5b57\u6bcd\u3001\u6570\u5b57\u3001\u4e0b\u5212\u7ebf\u7ec4\u6210\uff0c\u4e14\u5f00\u59cb\u5fc5\u987b\u4e3a\u5b57\u6bcd)";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSWXMenuName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSWXMENUNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
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
            if (this.checkFieldStringLengthRule("USERTAG", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_UserTag2_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("USERTAG2", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
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

    protected boolean onMergeChild(String string, String string2, PSWXMenuItem pSWXMenuItem) throws Exception {
        boolean bl = false;
        if (super.onMergeChild(string, string2, pSWXMenuItem)) {
            bl = true;
        }
        return bl;
    }

    protected void onUpdateParent(PSWXMenuItem pSWXMenuItem) throws Exception {
        super.onUpdateParent(pSWXMenuItem);
    }

    @Override
    protected void exportCurXmlModel(PSWXMenuItem pSWXMenuItem, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSWXMENUITEM");
        if (!bl) {
            pSWXMenuItem.setCreateDate(null);
            pSWXMenuItem.setCreateMan(null);
            pSWXMenuItem.setPSWXMenuItemId(null);
            pSWXMenuItem.setUpdateDate(null);
            pSWXMenuItem.setUpdateMan(null);
            pSWXMenuItem.setPPSWXMenuItemId(null);
            pSWXMenuItem.setPSWXMenuId(null);
            pSWXMenuItem.setPSWXMenuName(null);
            super.exportCurXmlModel(pSWXMenuItem, xmlNode, bl);
        }
    }

    @Override
    protected void onExportRelatedXmlModel(PSWXMenuItem pSWXMenuItem, XmlNode xmlNode) throws Exception {
        super.onExportRelatedXmlModel(pSWXMenuItem, xmlNode);
    }

    @Override
    protected void onImportRelatedXmlModel(PSWXMenuItem pSWXMenuItem, XmlNode xmlNode) throws Exception {
        super.onImportRelatedXmlModel(pSWXMenuItem, xmlNode);
    }

    @Override
    public ObjectNode fillModelV2(ObjectNode objectNode, PSWXMenuItem pSWXMenuItem, String string) throws Exception {
        objectNode = super.fillModelV2(objectNode, pSWXMenuItem, string);
        return objectNode;
    }

    @Override
    public String getModelV2ResScope(IEntity iEntity) throws Exception {
        String string = null;
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PPSWXMENUITEMID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return StringHelper.format((String)"PSWXMENUITEM#%1$s", (Object)string);
        }
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSWXMENUID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return StringHelper.format((String)"PSWXMENU#%1$s", (Object)string);
        }
        return super.getModelV2ResScope(iEntity);
    }

    @Override
    public String getModelV2ResScopeDER(IEntity iEntity) throws Exception {
        String string = null;
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PPSWXMENUITEMID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return "DER1N_PSWXMENUITEM_PSWXMENUITEM_PPSWXMENUITEMID";
        }
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSWXMENUID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return "DER1N_PSWXMENUITEM_PSWXMENU_PSWXMENUID";
        }
        return super.getModelV2ResScopeDER(iEntity);
    }

    @Override
    public String getModelV2ResScopeText(IEntity iEntity) throws Exception {
        String string = null;
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PPSWXMENUITEMID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return DataObject.getStringValue((IDataObject)iEntity, (String)"PPSWXMENUITEMNAME", null);
        }
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSWXMENUID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return DataObject.getStringValue((IDataObject)iEntity, (String)"PSWXMENUNAME", null);
        }
        return super.getModelV2ResScopeText(iEntity);
    }

    @Override
    public boolean setModelV2ResScope(IEntity iEntity, String string, String string2) throws Exception {
        if (StringHelper.compare((String)string, (String)"PSWXMENUITEM", (boolean)true) == 0) {
            iEntity.set("PPSWXMENUITEMID", (Object)string2);
            return true;
        }
        if (StringHelper.compare((String)string, (String)"PSWXMENU", (boolean)true) == 0) {
            iEntity.set("PSWXMENUID", (Object)string2);
            return true;
        }
        return super.setModelV2ResScope(iEntity, string, string2);
    }

    @Override
    public String[] getModelV2ResScopeFields() throws Exception {
        return new String[]{"PPSWXMENUITEMID", "PSWXMENUID"};
    }

    @Override
    public String getModelV2Tag(PSWXMenuItem pSWXMenuItem) {
        if (!StringHelper.isNullOrEmpty((String)pSWXMenuItem.getPSWXMenuItemName())) {
            return pSWXMenuItem.getPSWXMenuItemName();
        }
        return super.getModelV2Tag(pSWXMenuItem);
    }

    @Override
    public boolean setModelV2Tag(PSWXMenuItem pSWXMenuItem, String string) {
        pSWXMenuItem.setPSWXMenuItemName(string);
        return true;
    }

    @Override
    public Map<String, String> getListDRDataFolderFields(Map<String, String> map, PSMOSFile pSMOSFile, IPSMOSFileFilter iPSMOSFileFilter) throws Exception {
        if (map == null) {
            map = new HashMap<String, String>();
        }
        map.put("PSWXMENUITEMNAME", "");
        map.put("PPSWXMENUITEMID", "");
        map.put("PSWXMENUID", "");
        return super.getListDRDataFolderFields(map, pSMOSFile, iPSMOSFileFilter);
    }

    @Override
    public boolean getModelV2Entity(PSWXMenuItem pSWXMenuItem, String string) throws Exception {
        SimpleEntity simpleEntity = new SimpleEntity();
        pSWXMenuItem.copyTo((IDataObject)simpleEntity, false);
        simpleEntity.copyTo((IDataObject)pSWXMenuItem, true);
        pSWXMenuItem.set("PSWXMENUITEMNAME", string);
        if (this.select(pSWXMenuItem, true)) {
            return true;
        }
        simpleEntity.copyTo((IDataObject)pSWXMenuItem, true);
        return super.getModelV2Entity(pSWXMenuItem, string);
    }

    @Override
    protected boolean testCompileCurModelV2(PSWXMenuItem pSWXMenuItem, ObjectNode objectNode, String string, String string2, int n) throws Exception {
        if (n == 1) {
            return true;
        }
        boolean bl = false;
        if (!StringHelper.isNullOrEmpty((String)pSWXMenuItem.getPPSWXMenuItemId())) {
            bl = true;
        }
        if (!StringHelper.isNullOrEmpty((String)pSWXMenuItem.getPSWXMenuId())) {
            bl = true;
        } else if (bl && !objectNode.has("pswxmenuid")) {
            objectNode.put("pswxmenuid", "<PSWXMENU>");
        }
        return super.testCompileCurModelV2(pSWXMenuItem, objectNode, string, string2, n);
    }

    @Override
    protected ObjectNode onFillModelV2(ObjectNode objectNode, PSWXMenuItem pSWXMenuItem, String string, Map<String, String> map) throws Exception {
        if (PSWXMenuItemServiceBase.isSimpleImportExportMode()) {
            map.put("PPSWXMENUITEMID", "");
            map.put("PSWXMENUID", "");
        }
        return super.onFillModelV2(objectNode, pSWXMenuItem, string, map);
    }

    protected boolean isExportRelatedModelV2(String string) {
        return StringHelper.compare((String)"DER1N_PSWXMENUITEM_PSWXMENUITEM_PPSWXMENUITEMID", (String)string, (boolean)true) != 0;
    }

    @Override
    protected void onExportRelatedModelV2(PSWXMenuItem pSWXMenuItem, String string, String string2) throws Exception {
        Object var4_4 = null;
        super.onExportRelatedModelV2(pSWXMenuItem, string, string2);
    }

    @Override
    protected void onExportCurModelV2(PSWXMenuItem pSWXMenuItem, ObjectNode objectNode, String string, boolean bl) throws Exception {
        File file = null;
        if (bl || !this.isExportRelatedModelV2("DER1N_PSWXMENUITEM_PSWXMENUITEM_PPSWXMENUITEMID")) {
            PSWXMenuItemService pSWXMenuItemService = (PSWXMenuItemService)ServiceGlobal.getService(PSWXMenuItemService.class, (SessionFactory)this.getSessionFactory());
            ArrayList<ObjectNode> arrayList = null;
            if (!StringHelper.isNullOrEmpty((String)string)) {
                file = new File(StringHelper.format((String)"%1$s%2$s%3$s%2$sPSWXMENUITEM#%4$s#ALL.txt", (Object)string, (Object)File.separator, (Object)"PSWXMENUITEM", (Object)pSWXMenuItem.getPSWXMenuItemId()));
                if (file.exists()) {
                    arrayList = new ArrayList<ObjectNode>();
                    for (String menuItemJson : PSModelV2Helper.readFile2(file)) {
                        if (StringHelper.isNullOrEmpty((String)menuItemJson)) continue;
                        arrayList.add((ObjectNode)JsonNodeHelper.fromString((String)menuItemJson));
                    }
                }
            } else {
                arrayList = new ArrayList<ObjectNode>();
                String resScope = StringHelper.format((String)"PSWXMENUITEM#%1$s", (Object)pSWXMenuItem.getPSWXMenuItemId());
                for (PSWXMenuItem childMenuItem : pSWXMenuItemService.selectByPPSWXMenuItem(pSWXMenuItem)) {
                    String childScope = pSWXMenuItemService.getModelV2ResScope(childMenuItem);
                    if (StringHelper.compare((String)resScope, (String)childScope, (boolean)false) != 0) continue;
                    arrayList.add(PSModelV2Helper.toJSONObject(childMenuItem, false));
                }
            }
            if (arrayList != null && arrayList.size() > 0) {
                String menuItemName = pSWXMenuItemService.getModelV2Name(false);
                ArrayNode menuItemArray = objectNode.putArray(menuItemName.toLowerCase());
                Collections.sort(arrayList, new Comparator<ObjectNode>(){

                    @Override
                    public int compare(ObjectNode objectNode, ObjectNode objectNode2) {
                        int n;
                        int n2 = 1000;
                        int n3 = 1000;
                        if (objectNode.has("ordervalue")) {
                            n2 = objectNode.get("ordervalue").asInt();
                        }
                        if (objectNode2.has("ordervalue")) {
                            n3 = objectNode2.get("ordervalue").asInt();
                        }
                        if ((n = n2 - n3) != 0) {
                            return n;
                        }
                        String string = null;
                        String string2 = null;
                        if (objectNode.has("pswxmenuitemname")) {
                            string = objectNode.get("pswxmenuitemname").asText();
                        }
                        if (objectNode2.has("pswxmenuitemname")) {
                            string2 = objectNode2.get("pswxmenuitemname").asText();
                        }
                        return StringHelper.compare((String)string, string2, (boolean)false);
                    }
                });
                for (ObjectNode menuItemNode : arrayList) {
                    PSWXMenuItem childMenuItem = new PSWXMenuItem();
                    PSModelV2Helper.fromJSONObject((IDataObject)childMenuItem, menuItemNode, false);
                    childMenuItem.remove("ordervalue");
                    menuItemArray.add((JsonNode)pSWXMenuItemService.exportModelV2(childMenuItem, string));
                }
            }
        }
        super.onExportCurModelV2(pSWXMenuItem, objectNode, string, bl);
    }

    @Override
    protected void onEmptyModelV2(PSWXMenuItem pSWXMenuItem) throws Exception {
        PSWXMenuItemService pSWXMenuItemService = (PSWXMenuItemService)ServiceGlobal.getService(PSWXMenuItemService.class, (SessionFactory)this.getSessionFactory());
        ArrayList<PSWXMenuItem> arrayList = pSWXMenuItemService.selectByPPSWXMenuItem(pSWXMenuItem);
        String string = StringHelper.format((String)"PSWXMENUITEM#%1$s", (Object)pSWXMenuItem.getPSWXMenuItemId());
        for (PSWXMenuItem pSWXMenuItem2 : arrayList) {
            String string2 = pSWXMenuItemService.getModelV2ResScope(pSWXMenuItem2);
            if (StringHelper.compare((String)string, (String)string2, (boolean)false) != 0) continue;
            pSWXMenuItemService.emptyModelV2(pSWXMenuItem2);
        }
        SqlParamList sqlParamList = new SqlParamList();
        sqlParamList.addString(pSWXMenuItem.getPSWXMenuItemId());
        pSWXMenuItemService.getDAO().executeRawSql(null, "SET FOREIGN_KEY_CHECKS=0;", null);
        pSWXMenuItemService.getDAO().executeRawSql(null, "DELETE FROM T_SRFPSWXMENUITEM WHERE PPSWXMENUITEMID = ?", sqlParamList);
        super.onEmptyModelV2(pSWXMenuItem);
    }

    @Override
    protected boolean onContainsRelatedModelV2Entity(String string, int n) throws Exception {
        PSWXMenuItemService pSWXMenuItemService = (PSWXMenuItemService)ServiceGlobal.getService(PSWXMenuItemService.class, (SessionFactory)this.getSessionFactory());
        if (pSWXMenuItemService.containsModelV2Entity(string, n)) {
            return true;
        }
        return super.onContainsRelatedModelV2Entity(string, n);
    }

    @Override
    protected IEntity onGetRelatedModelV2Entity(PSWXMenuItem pSWXMenuItem, String string, String string2) throws Exception {
        IEntity iEntity = null;
        PSWXMenuItem pSWXMenuItem2 = new PSWXMenuItem();
        pSWXMenuItem2.set("PPSWXMENUITEMID", pSWXMenuItem.getPSWXMenuItemId());
        PSWXMenuItemService pSWXMenuItemService = (PSWXMenuItemService)ServiceGlobal.getService(PSWXMenuItemService.class, (SessionFactory)this.getSessionFactory());
        iEntity = pSWXMenuItemService.getModelV2Entity(pSWXMenuItem2, string, string2);
        if (iEntity != null) {
            return iEntity;
        }
        return super.onGetRelatedModelV2Entity(pSWXMenuItem, string, string2);
    }

    @Override
    protected void onCompileRelatedModelV2(PSWXMenuItem pSWXMenuItem, ObjectNode objectNode, String string, String string2, int n) throws Exception {
        PSWXMenuItemService pSWXMenuItemService = (PSWXMenuItemService)ServiceGlobal.getService(PSWXMenuItemService.class, (SessionFactory)this.getSessionFactory());
        ArrayNode arrayNode = null;
        String string3 = pSWXMenuItemService.getModelV2Name(null, false);
        int n2 = 0;
        if (objectNode != null) {
            arrayNode = JsonNodeHelper.getArray((ObjectNode)objectNode, (String)string3.toLowerCase());
        }
        if (arrayNode != null) {
            for (int i = 0; i < arrayNode.size(); ++i) {
                ObjectNode objectNode2 = (ObjectNode)arrayNode.get(i);
                PSWXMenuItem pSWXMenuItem2 = new PSWXMenuItem();
                pSWXMenuItem2.setPPSWXMenuItemId(pSWXMenuItem.getPSWXMenuItemId());
                pSWXMenuItem2.setPPSWXMenuItemName(pSWXMenuItem.getPSWXMenuItemName());
                pSWXMenuItem2.setOrderValue(n2 += 10);
                pSWXMenuItemService.compileModelV2(pSWXMenuItem2, objectNode2, string, null, n);
            }
        } else {
            String string4 = StringHelper.format((String)"%1$s%2$s%3$s", (Object)string2, (Object)File.separator, (Object)string3);
            File file = new File(string4);
            if (file.exists()) {
                File[] fileArray;
                for (File file2 : fileArray = file.listFiles()) {
                    if (!file2.isDirectory()) continue;
                    PSWXMenuItem pSWXMenuItem3 = new PSWXMenuItem();
                    pSWXMenuItem3.setPPSWXMenuItemId(pSWXMenuItem.getPSWXMenuItemId());
                    pSWXMenuItem3.setPPSWXMenuItemName(pSWXMenuItem.getPSWXMenuItemName());
                    pSWXMenuItemService.compileModelV2(pSWXMenuItem3, null, string, file2.getCanonicalPath(), n);
                }
            }
        }
        super.onCompileRelatedModelV2(pSWXMenuItem, objectNode, string, string2, n);
    }

    @Override
    protected PSMOSFile onPasteFile(PSWXMenuItem pSWXMenuItem, PSMOSFile pSMOSFile, String string, IPSMOSFileAction iPSMOSFileAction) throws Exception {
        Object var5_5 = null;
        return super.onPasteFile(pSWXMenuItem, pSMOSFile, string, iPSMOSFileAction);
    }

    @Override
    protected void onFillPasteHelps(PSWXMenuItem pSWXMenuItem, List<PSHelpSection> list) throws Exception {
        super.onFillPasteHelps(pSWXMenuItem, list);
    }
}
