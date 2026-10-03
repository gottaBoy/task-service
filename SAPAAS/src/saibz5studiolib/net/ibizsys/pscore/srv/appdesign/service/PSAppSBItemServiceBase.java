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
package net.ibizsys.pscore.srv.appdesign.service;

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
import net.ibizsys.pscore.srv.appdesign.dao.PSAppSBItemDAO;
import net.ibizsys.pscore.srv.appdesign.demodel.PSAppSBItemDEModel;
import net.ibizsys.pscore.srv.appdesign.entity.PSAppSBItem;
import net.ibizsys.pscore.srv.appdesign.entity.PSAppStoryBoard;
import net.ibizsys.pscore.srv.appdesign.entity.PSAppStoryBoardBase;
import net.ibizsys.pscore.srv.appdesign.entity.PSAppView;
import net.ibizsys.pscore.srv.appdesign.entity.PSAppViewBase;
import net.ibizsys.pscore.srv.appdesign.service.PSAppSBItemRSService;
import net.ibizsys.pscore.srv.core.IPSDataEntityModel;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysReqItem;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysReqItemBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysUserCase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysUserCaseBase;
import net.ibizsys.pscore.srv.sysdevstudio.entity.PSMOSFile;
import net.ibizsys.pscore.srv.util.IPSMOSFileFilter;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSAppSBItemServiceBase
extends PSCoreSysServiceBase<PSAppSBItem> {
    private static final Log log = LogFactory.getLog(PSAppSBItemServiceBase.class);
    public static final String DATASET_DEFAULT = "DEFAULT";
    private PSAppSBItemDEModel pSAppSBItemDEModel;
    private PSAppSBItemDAO pSAppSBItemDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.appdesign.service.PSAppSBItemService";
    }

    public PSAppSBItemDEModel getPSAppSBItemDEModel() {
        if (this.pSAppSBItemDEModel == null) {
            try {
                this.pSAppSBItemDEModel = (PSAppSBItemDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.appdesign.demodel.PSAppSBItemDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSAppSBItemDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSAppSBItemDEModel();
    }

    public PSAppSBItemDAO getPSAppSBItemDAO() {
        if (this.pSAppSBItemDAO == null) {
            try {
                this.pSAppSBItemDAO = (PSAppSBItemDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.appdesign.dao.PSAppSBItemDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSAppSBItemDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSAppSBItemDAO();
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

    protected void onFillParentInfo(PSAppSBItem pSAppSBItem, String string, String string2, String string3) throws Exception {
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSAPPSBITEM_PSAPPSTORYBOARD_PSAPPSTORYBOARDID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.appdesign.service.PSAppStoryBoardService", (SessionFactory)this.getSessionFactory());
            PSAppStoryBoard pSAppStoryBoard = (PSAppStoryBoard)iService.getDEModel().createEntity();
            pSAppStoryBoard.set("PSAPPSTORYBOARDID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSAppStoryBoard);
            } else {
                iService.get(pSAppStoryBoard);
            }
            this.onFillParentInfo_PSAppStoryBoard(pSAppSBItem, pSAppStoryBoard);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSAPPSBITEM_PSAPPVIEW_PSAPPVIEWID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.appdesign.service.PSAppViewService", (SessionFactory)this.getSessionFactory());
            PSAppView pSAppView = (PSAppView)iService.getDEModel().createEntity();
            pSAppView.set("PSAPPVIEWID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSAppView);
            } else {
                iService.get(pSAppView);
            }
            this.onFillParentInfo_PSAppView(pSAppSBItem, pSAppView);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSAPPSBITEM_PSSYSREQITEM_PSSYSREQITEMID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysReqItemService", (SessionFactory)this.getSessionFactory());
            PSSysReqItem pSSysReqItem = (PSSysReqItem)iService.getDEModel().createEntity();
            pSSysReqItem.set("PSSYSREQITEMID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSSysReqItem);
            } else {
                iService.get(pSSysReqItem);
            }
            this.onFillParentInfo_PSSysReqItem(pSAppSBItem, pSSysReqItem);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSAPPSBITEM_PSSYSUSERCASE_PSSYSUSERCASEID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysUserCaseService", (SessionFactory)this.getSessionFactory());
            PSSysUserCase pSSysUserCase = (PSSysUserCase)iService.getDEModel().createEntity();
            pSSysUserCase.set("PSSYSUSERCASEID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSSysUserCase);
            } else {
                iService.get(pSSysUserCase);
            }
            this.onFillParentInfo_PSSysUserCase(pSAppSBItem, pSSysUserCase);
            return;
        }
        super.onFillParentInfo(pSAppSBItem, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillParentInfo_PSAppStoryBoard(PSAppSBItem pSAppSBItem, PSAppStoryBoard pSAppStoryBoard) throws Exception {
        pSAppSBItem.setPSAppStoryBoardId(pSAppStoryBoard.getPSAppStoryBoardId());
        pSAppSBItem.setPSAppStoryBoardName(pSAppStoryBoard.getPSAppStoryBoardName());
        pSAppSBItem.setPSSysAppId(pSAppStoryBoard.getPSSysAppId());
    }

    protected void onFillParentInfo_PSAppView(PSAppSBItem pSAppSBItem, PSAppView pSAppView) throws Exception {
        pSAppSBItem.setPSAppViewId(pSAppView.getPSAppViewId());
        pSAppSBItem.setPSAppViewName(pSAppView.getPSAppViewName());
    }

    protected void onFillParentInfo_PSSysReqItem(PSAppSBItem pSAppSBItem, PSSysReqItem pSSysReqItem) throws Exception {
        pSAppSBItem.setPSSysReqItemId(pSSysReqItem.getPSSysReqItemId());
        pSAppSBItem.setPSSysReqItemName(pSSysReqItem.getPSSysReqItemName());
    }

    protected void onFillParentInfo_PSSysUserCase(PSAppSBItem pSAppSBItem, PSSysUserCase pSSysUserCase) throws Exception {
        pSAppSBItem.setPSSysUserCaseId(pSSysUserCase.getPSSysUserCaseId());
        pSAppSBItem.setPSSysUserCaseName(pSSysUserCase.getPSSysUserCaseName());
    }

    protected void onFillEntityFullInfo(PSAppSBItem pSAppSBItem, boolean bl) throws Exception {
        if (bl) {
            if (pSAppSBItem.getRootItem() == null) {
                pSAppSBItem.setRootItem((Integer)this.getDefaultValue(this.getWebContext(), "", "0", 9));
            }
            if (pSAppSBItem.getUserFlag() == null) {
                pSAppSBItem.setUserFlag((Integer)this.getDefaultValue(this.getWebContext(), "", "0", 9));
            }
            if (pSAppSBItem.getValidFlag() == null) {
                pSAppSBItem.setValidFlag((Integer)this.getDefaultValue(this.getWebContext(), "", "1", 9));
            }
        }
        super.onFillEntityFullInfo(pSAppSBItem, bl);
        this.onFillEntityFullInfo_PSAppStoryBoard(pSAppSBItem, bl);
        this.onFillEntityFullInfo_PSAppView(pSAppSBItem, bl);
        this.onFillEntityFullInfo_PSSysReqItem(pSAppSBItem, bl);
        this.onFillEntityFullInfo_PSSysUserCase(pSAppSBItem, bl);
    }

    protected void onFillEntityFullInfo_PSAppStoryBoard(PSAppSBItem pSAppSBItem, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSAppView(PSAppSBItem pSAppSBItem, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSSysReqItem(PSAppSBItem pSAppSBItem, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSSysUserCase(PSAppSBItem pSAppSBItem, boolean bl) throws Exception {
    }

    protected void onWriteBackParent(PSAppSBItem pSAppSBItem, boolean bl) throws Exception {
        super.onWriteBackParent(pSAppSBItem, bl);
    }

    public ArrayList<PSAppSBItem> selectByPSAppStoryBoard(PSAppStoryBoardBase pSAppStoryBoardBase) throws Exception {
        return this.selectByPSAppStoryBoard(pSAppStoryBoardBase, "", -1);
    }

    public ArrayList<PSAppSBItem> selectByPSAppStoryBoard(PSAppStoryBoardBase pSAppStoryBoardBase, String string) throws Exception {
        return this.selectByPSAppStoryBoard(pSAppStoryBoardBase, string, -1);
    }

    public ArrayList<PSAppSBItem> selectByPSAppStoryBoard(PSAppStoryBoardBase pSAppStoryBoardBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSAPPSTORYBOARDID", (Object)pSAppStoryBoardBase.getPSAppStoryBoardId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSAppStoryBoardCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSAppStoryBoardCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSAppSBItem> selectTempByPSAppStoryBoard(PSAppStoryBoardBase pSAppStoryBoardBase) throws Exception {
        return this.selectTempByPSAppStoryBoard(pSAppStoryBoardBase, "");
    }

    public ArrayList<PSAppSBItem> selectTempByPSAppStoryBoard(PSAppStoryBoardBase pSAppStoryBoardBase, String string) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSAPPSTORYBOARDID", (Object)pSAppStoryBoardBase.getPSAppStoryBoardId());
        selectCond.setOrderInfo(string);
        this.onFillSelectTempByPSAppStoryBoardCond(selectCond);
        return this.selectTemp((ISelectCond)selectCond);
    }

    protected void onFillSelectTempByPSAppStoryBoardCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSAppSBItem> selectByPSAppView(PSAppViewBase pSAppViewBase) throws Exception {
        return this.selectByPSAppView(pSAppViewBase, "", -1);
    }

    public ArrayList<PSAppSBItem> selectByPSAppView(PSAppViewBase pSAppViewBase, String string) throws Exception {
        return this.selectByPSAppView(pSAppViewBase, string, -1);
    }

    public ArrayList<PSAppSBItem> selectByPSAppView(PSAppViewBase pSAppViewBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSAPPVIEWID", (Object)pSAppViewBase.getPSAppViewId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSAppViewCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSAppViewCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSAppSBItem> selectByPSSysReqItem(PSSysReqItemBase pSSysReqItemBase) throws Exception {
        return this.selectByPSSysReqItem(pSSysReqItemBase, "", -1);
    }

    public ArrayList<PSAppSBItem> selectByPSSysReqItem(PSSysReqItemBase pSSysReqItemBase, String string) throws Exception {
        return this.selectByPSSysReqItem(pSSysReqItemBase, string, -1);
    }

    public ArrayList<PSAppSBItem> selectByPSSysReqItem(PSSysReqItemBase pSSysReqItemBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSSYSREQITEMID", (Object)pSSysReqItemBase.getPSSysReqItemId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSSysReqItemCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSSysReqItemCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSAppSBItem> selectByPSSysUserCase(PSSysUserCaseBase pSSysUserCaseBase) throws Exception {
        return this.selectByPSSysUserCase(pSSysUserCaseBase, "", -1);
    }

    public ArrayList<PSAppSBItem> selectByPSSysUserCase(PSSysUserCaseBase pSSysUserCaseBase, String string) throws Exception {
        return this.selectByPSSysUserCase(pSSysUserCaseBase, string, -1);
    }

    public ArrayList<PSAppSBItem> selectByPSSysUserCase(PSSysUserCaseBase pSSysUserCaseBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSSYSUSERCASEID", (Object)pSSysUserCaseBase.getPSSysUserCaseId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSSysUserCaseCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSSysUserCaseCond(SelectCond selectCond) throws Exception {
    }

    public void testRemoveByPSAppStoryBoard(PSAppStoryBoard pSAppStoryBoard) throws Exception {
    }

    public void resetPSAppStoryBoard(PSAppStoryBoard pSAppStoryBoard) throws Exception {
        ArrayList<PSAppSBItem> arrayList = this.selectByPSAppStoryBoard(pSAppStoryBoard);
        for (PSAppSBItem pSAppSBItem : arrayList) {
            PSAppSBItem pSAppSBItem2 = (PSAppSBItem)this.getDEModel().createEntity();
            pSAppSBItem2.setPSAppSBItemId(pSAppSBItem.getPSAppSBItemId());
            pSAppSBItem2.setPSAppStoryBoardId(null);
            this.update(pSAppSBItem2);
        }
    }

    public void resetTempPSAppStoryBoard(PSAppStoryBoard pSAppStoryBoard) throws Exception {
        ArrayList<PSAppSBItem> arrayList = this.selectTempByPSAppStoryBoard(pSAppStoryBoard);
        for (PSAppSBItem pSAppSBItem : arrayList) {
            PSAppSBItem pSAppSBItem2 = (PSAppSBItem)this.getDEModel().createEntity();
            pSAppSBItem2.setPSAppSBItemId(pSAppSBItem.getPSAppSBItemId());
            pSAppSBItem2.setPSAppStoryBoardId(null);
            this.updateTemp(pSAppSBItem2);
        }
    }

    public void removeByPSAppStoryBoard(PSAppStoryBoard pSAppStoryBoard) throws Exception {
        final PSAppStoryBoard pSAppStoryBoard2 = pSAppStoryBoard;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSAppSBItemServiceBase.this.onBeforeRemoveByPSAppStoryBoard(pSAppStoryBoard2);
                PSAppSBItemServiceBase.this.internalRemoveByPSAppStoryBoard(pSAppStoryBoard2);
                PSAppSBItemServiceBase.this.onAfterRemoveByPSAppStoryBoard(pSAppStoryBoard2);
            }
        });
    }

    protected void onBeforeRemoveByPSAppStoryBoard(PSAppStoryBoard pSAppStoryBoard) throws Exception {
    }

    protected void internalRemoveByPSAppStoryBoard(PSAppStoryBoard pSAppStoryBoard) throws Exception {
        ArrayList<PSAppSBItem> arrayList = this.selectByPSAppStoryBoard(pSAppStoryBoard);
        this.onBeforeRemoveByPSAppStoryBoard(pSAppStoryBoard, arrayList);
        for (PSAppSBItem pSAppSBItem : arrayList) {
            this.remove(pSAppSBItem);
        }
        this.onAfterRemoveByPSAppStoryBoard(pSAppStoryBoard, arrayList);
    }

    protected void onAfterRemoveByPSAppStoryBoard(PSAppStoryBoard pSAppStoryBoard) throws Exception {
    }

    protected void onBeforeRemoveByPSAppStoryBoard(PSAppStoryBoard pSAppStoryBoard, ArrayList<PSAppSBItem> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSAppStoryBoard(PSAppStoryBoard pSAppStoryBoard, ArrayList<PSAppSBItem> arrayList) throws Exception {
    }

    public void testRemoveByPSAppView(PSAppView pSAppView) throws Exception {
    }

    public void resetPSAppView(PSAppView pSAppView) throws Exception {
        ArrayList<PSAppSBItem> arrayList = this.selectByPSAppView(pSAppView);
        for (PSAppSBItem pSAppSBItem : arrayList) {
            PSAppSBItem pSAppSBItem2 = (PSAppSBItem)this.getDEModel().createEntity();
            pSAppSBItem2.setPSAppSBItemId(pSAppSBItem.getPSAppSBItemId());
            pSAppSBItem2.setPSAppViewId(null);
            this.update(pSAppSBItem2);
        }
    }

    public void removeByPSAppView(PSAppView pSAppView) throws Exception {
        final PSAppView pSAppView2 = pSAppView;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSAppSBItemServiceBase.this.onBeforeRemoveByPSAppView(pSAppView2);
                PSAppSBItemServiceBase.this.internalRemoveByPSAppView(pSAppView2);
                PSAppSBItemServiceBase.this.onAfterRemoveByPSAppView(pSAppView2);
            }
        });
    }

    protected void onBeforeRemoveByPSAppView(PSAppView pSAppView) throws Exception {
    }

    protected void internalRemoveByPSAppView(PSAppView pSAppView) throws Exception {
        ArrayList<PSAppSBItem> arrayList = this.selectByPSAppView(pSAppView);
        this.onBeforeRemoveByPSAppView(pSAppView, arrayList);
        for (PSAppSBItem pSAppSBItem : arrayList) {
            this.remove(pSAppSBItem);
        }
        this.onAfterRemoveByPSAppView(pSAppView, arrayList);
    }

    protected void onAfterRemoveByPSAppView(PSAppView pSAppView) throws Exception {
    }

    protected void onBeforeRemoveByPSAppView(PSAppView pSAppView, ArrayList<PSAppSBItem> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSAppView(PSAppView pSAppView, ArrayList<PSAppSBItem> arrayList) throws Exception {
    }

    public void testRemoveByPSSysReqItem(PSSysReqItem pSSysReqItem) throws Exception {
    }

    public void resetPSSysReqItem(PSSysReqItem pSSysReqItem) throws Exception {
        ArrayList<PSAppSBItem> arrayList = this.selectByPSSysReqItem(pSSysReqItem);
        for (PSAppSBItem pSAppSBItem : arrayList) {
            PSAppSBItem pSAppSBItem2 = (PSAppSBItem)this.getDEModel().createEntity();
            pSAppSBItem2.setPSAppSBItemId(pSAppSBItem.getPSAppSBItemId());
            pSAppSBItem2.setPSSysReqItemId(null);
            this.update(pSAppSBItem2);
        }
    }

    public void removeByPSSysReqItem(PSSysReqItem pSSysReqItem) throws Exception {
        final PSSysReqItem pSSysReqItem2 = pSSysReqItem;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSAppSBItemServiceBase.this.onBeforeRemoveByPSSysReqItem(pSSysReqItem2);
                PSAppSBItemServiceBase.this.internalRemoveByPSSysReqItem(pSSysReqItem2);
                PSAppSBItemServiceBase.this.onAfterRemoveByPSSysReqItem(pSSysReqItem2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysReqItem(PSSysReqItem pSSysReqItem) throws Exception {
    }

    protected void internalRemoveByPSSysReqItem(PSSysReqItem pSSysReqItem) throws Exception {
        ArrayList<PSAppSBItem> arrayList = this.selectByPSSysReqItem(pSSysReqItem);
        this.onBeforeRemoveByPSSysReqItem(pSSysReqItem, arrayList);
        for (PSAppSBItem pSAppSBItem : arrayList) {
            this.remove(pSAppSBItem);
        }
        this.onAfterRemoveByPSSysReqItem(pSSysReqItem, arrayList);
    }

    protected void onAfterRemoveByPSSysReqItem(PSSysReqItem pSSysReqItem) throws Exception {
    }

    protected void onBeforeRemoveByPSSysReqItem(PSSysReqItem pSSysReqItem, ArrayList<PSAppSBItem> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysReqItem(PSSysReqItem pSSysReqItem, ArrayList<PSAppSBItem> arrayList) throws Exception {
    }

    public void testRemoveByPSSysUserCase(PSSysUserCase pSSysUserCase) throws Exception {
    }

    public void resetPSSysUserCase(PSSysUserCase pSSysUserCase) throws Exception {
        ArrayList<PSAppSBItem> arrayList = this.selectByPSSysUserCase(pSSysUserCase);
        for (PSAppSBItem pSAppSBItem : arrayList) {
            PSAppSBItem pSAppSBItem2 = (PSAppSBItem)this.getDEModel().createEntity();
            pSAppSBItem2.setPSAppSBItemId(pSAppSBItem.getPSAppSBItemId());
            pSAppSBItem2.setPSSysUserCaseId(null);
            this.update(pSAppSBItem2);
        }
    }

    public void removeByPSSysUserCase(PSSysUserCase pSSysUserCase) throws Exception {
        final PSSysUserCase pSSysUserCase2 = pSSysUserCase;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSAppSBItemServiceBase.this.onBeforeRemoveByPSSysUserCase(pSSysUserCase2);
                PSAppSBItemServiceBase.this.internalRemoveByPSSysUserCase(pSSysUserCase2);
                PSAppSBItemServiceBase.this.onAfterRemoveByPSSysUserCase(pSSysUserCase2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysUserCase(PSSysUserCase pSSysUserCase) throws Exception {
    }

    protected void internalRemoveByPSSysUserCase(PSSysUserCase pSSysUserCase) throws Exception {
        ArrayList<PSAppSBItem> arrayList = this.selectByPSSysUserCase(pSSysUserCase);
        this.onBeforeRemoveByPSSysUserCase(pSSysUserCase, arrayList);
        for (PSAppSBItem pSAppSBItem : arrayList) {
            this.remove(pSAppSBItem);
        }
        this.onAfterRemoveByPSSysUserCase(pSSysUserCase, arrayList);
    }

    protected void onAfterRemoveByPSSysUserCase(PSSysUserCase pSSysUserCase) throws Exception {
    }

    protected void onBeforeRemoveByPSSysUserCase(PSSysUserCase pSSysUserCase, ArrayList<PSAppSBItem> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysUserCase(PSSysUserCase pSSysUserCase, ArrayList<PSAppSBItem> arrayList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(PSAppSBItem pSAppSBItem) throws Exception {
        PSAppSBItemRSService pSAppSBItemRSService = (PSAppSBItemRSService)ServiceGlobal.getService(PSAppSBItemRSService.class, (SessionFactory)this.getSessionFactory());
        pSAppSBItemRSService.testRemoveByCPSAppSBItem(pSAppSBItem);
        pSAppSBItemRSService.removeByCPSAppSBItem(pSAppSBItem);
        pSAppSBItemRSService = (PSAppSBItemRSService)ServiceGlobal.getService(PSAppSBItemRSService.class, (SessionFactory)this.getSessionFactory());
        pSAppSBItemRSService.testRemoveByPPSAppSBItem(pSAppSBItem);
        pSAppSBItemRSService.removeByPPSAppSBItem(pSAppSBItem);
        super.onBeforeRemove(pSAppSBItem);
    }

    protected void onBeforeRemoveTemp(PSAppSBItem pSAppSBItem) throws Exception {
        PSAppSBItemRSService pSAppSBItemRSService = (PSAppSBItemRSService)ServiceGlobal.getService(PSAppSBItemRSService.class, (SessionFactory)this.getSessionFactory());
        pSAppSBItemRSService.resetTempPPSAppSBItem(pSAppSBItem);
        pSAppSBItemRSService = (PSAppSBItemRSService)ServiceGlobal.getService(PSAppSBItemRSService.class, (SessionFactory)this.getSessionFactory());
        pSAppSBItemRSService.resetTempCPSAppSBItem(pSAppSBItem);
        super.onBeforeRemoveTemp(pSAppSBItem);
    }

    public void removeTempByPSAppStoryBoard(PSAppStoryBoard pSAppStoryBoard) throws Exception {
        final PSAppStoryBoard pSAppStoryBoard2 = pSAppStoryBoard;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSAppSBItemServiceBase.this.onBeforeRemoveTempByPSAppStoryBoard(pSAppStoryBoard2);
                PSAppSBItemServiceBase.this.internalRemoveTempByPSAppStoryBoard(pSAppStoryBoard2);
                PSAppSBItemServiceBase.this.onAfterRemoveTempByPSAppStoryBoard(pSAppStoryBoard2);
            }
        });
    }

    protected void onBeforeRemoveTempByPSAppStoryBoard(PSAppStoryBoard pSAppStoryBoard) throws Exception {
    }

    protected void internalRemoveTempByPSAppStoryBoard(PSAppStoryBoard pSAppStoryBoard) throws Exception {
        ArrayList<PSAppSBItem> arrayList = this.selectTempByPSAppStoryBoard(pSAppStoryBoard);
        this.onBeforeRemoveTempByPSAppStoryBoard(pSAppStoryBoard, arrayList);
        for (PSAppSBItem pSAppSBItem : arrayList) {
            this.removeTemp(pSAppSBItem);
        }
        this.onAfterRemoveTempByPSAppStoryBoard(pSAppStoryBoard, arrayList);
    }

    protected void onAfterRemoveTempByPSAppStoryBoard(PSAppStoryBoard pSAppStoryBoard) throws Exception {
    }

    protected void onBeforeRemoveTempByPSAppStoryBoard(PSAppStoryBoard pSAppStoryBoard, ArrayList<PSAppSBItem> arrayList) throws Exception {
    }

    protected void onAfterRemoveTempByPSAppStoryBoard(PSAppStoryBoard pSAppStoryBoard, ArrayList<PSAppSBItem> arrayList) throws Exception {
    }

    protected void getRelatedDataTempMajor(PSAppSBItem pSAppSBItem) throws Exception {
        super.getRelatedDataTempMajor(pSAppSBItem);
    }

    protected void updateRelatedDataTempMajor(PSAppSBItem pSAppSBItem, PSAppSBItem pSAppSBItem2) throws Exception {
        super.updateRelatedDataTempMajor(pSAppSBItem, pSAppSBItem2);
    }

    protected void replaceParentInfo(PSAppSBItem pSAppSBItem, CloneSession cloneSession) throws Exception {
        IEntity iEntity;
        super.replaceParentInfo(pSAppSBItem, cloneSession);
        if (pSAppSBItem.getPSAppStoryBoardId() != null && (iEntity = cloneSession.getEntity("PSAPPSTORYBOARD", (Object)pSAppSBItem.getPSAppStoryBoardId())) != null) {
            this.onFillParentInfo_PSAppStoryBoard(pSAppSBItem, (PSAppStoryBoard)iEntity);
        }
        if (pSAppSBItem.getPSAppViewId() != null && (iEntity = cloneSession.getEntity("PSAPPVIEW", (Object)pSAppSBItem.getPSAppViewId())) != null) {
            this.onFillParentInfo_PSAppView(pSAppSBItem, (PSAppView)iEntity);
        }
        if (pSAppSBItem.getPSSysReqItemId() != null && (iEntity = cloneSession.getEntity("PSSYSREQITEM", (Object)pSAppSBItem.getPSSysReqItemId())) != null) {
            this.onFillParentInfo_PSSysReqItem(pSAppSBItem, (PSSysReqItem)iEntity);
        }
        if (pSAppSBItem.getPSSysUserCaseId() != null && (iEntity = cloneSession.getEntity("PSSYSUSERCASE", (Object)pSAppSBItem.getPSSysUserCaseId())) != null) {
            this.onFillParentInfo_PSSysUserCase(pSAppSBItem, (PSSysUserCase)iEntity);
        }
    }

    protected void onRemoveEntityUncopyValues(PSAppSBItem pSAppSBItem, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues(pSAppSBItem, bl);
    }

    protected void onCheckEntity(boolean bl, PSAppSBItem pSAppSBItem, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_CodeName(bl, pSAppSBItem, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ItemTag(bl, pSAppSBItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ItemTag2(bl, pSAppSBItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ItemTag3(bl, pSAppSBItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ItemTag4(bl, pSAppSBItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ItemType(bl, pSAppSBItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_LeftPos(bl, pSAppSBItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Memo(bl, pSAppSBItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSAppSBItemId(bl, pSAppSBItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSAppSBItemName(bl, pSAppSBItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSAppStoryBoardId(bl, pSAppSBItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSAppViewId(bl, pSAppSBItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDynaInstId(bl, pSAppSBItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysReqItemId(bl, pSAppSBItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysUserCaseId(bl, pSAppSBItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_RootItem(bl, pSAppSBItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_TopPos(bl, pSAppSBItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserCat(bl, pSAppSBItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserFlag(bl, pSAppSBItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag(bl, pSAppSBItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag2(bl, pSAppSBItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag3(bl, pSAppSBItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag4(bl, pSAppSBItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ValidFlag(bl, pSAppSBItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, pSAppSBItem, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_CodeName(boolean bl, PSAppSBItem pSAppSBItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSAppSBItem.isCodeNameDirty() && !bl2 : !pSAppSBItem.isCodeNameDirty()) {
            return null;
        }
        String string = pSAppSBItem.getCodeName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CODENAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_CodeName_Default(pSAppSBItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CODENAME");
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
                string3 = "PSAPPSTORYBOARDID";
                String string4 = this.checkFieldDupRule(this.getPSAppSBItemDEModel(), "CODENAME", string3, pSAppSBItem, bl2, bl3);
                if (!StringHelper.isNullOrEmpty((String)string4)) {
                    EntityFieldError entityFieldError = new EntityFieldError();
                    entityFieldError.setFieldName("CODENAME");
                    entityFieldError.setErrorType(3);
                    entityFieldError.setErrorInfo(string4);
                    return entityFieldError;
                }
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ItemTag(boolean bl, PSAppSBItem pSAppSBItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSAppSBItem.isItemTagDirty() : !pSAppSBItem.isItemTagDirty()) {
            return null;
        }
        String string = pSAppSBItem.getItemTag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_ItemTag_Default(pSAppSBItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ITEMTAG");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ItemTag2(boolean bl, PSAppSBItem pSAppSBItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSAppSBItem.isItemTag2Dirty() : !pSAppSBItem.isItemTag2Dirty()) {
            return null;
        }
        String string = pSAppSBItem.getItemTag2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_ItemTag2_Default(pSAppSBItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ITEMTAG2");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ItemTag3(boolean bl, PSAppSBItem pSAppSBItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSAppSBItem.isItemTag3Dirty() : !pSAppSBItem.isItemTag3Dirty()) {
            return null;
        }
        String string = pSAppSBItem.getItemTag3();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_ItemTag3_Default(pSAppSBItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ITEMTAG3");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ItemTag4(boolean bl, PSAppSBItem pSAppSBItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSAppSBItem.isItemTag4Dirty() : !pSAppSBItem.isItemTag4Dirty()) {
            return null;
        }
        String string = pSAppSBItem.getItemTag4();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_ItemTag4_Default(pSAppSBItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ITEMTAG4");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ItemType(boolean bl, PSAppSBItem pSAppSBItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSAppSBItem.isItemTypeDirty() && !bl2 : !pSAppSBItem.isItemTypeDirty()) {
            return null;
        }
        String string = pSAppSBItem.getItemType();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ITEMTYPE");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_ItemType_Default(pSAppSBItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ITEMTYPE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_LeftPos(boolean bl, PSAppSBItem pSAppSBItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSAppSBItem.isLeftPosDirty() : !pSAppSBItem.isLeftPosDirty()) {
            return null;
        }
        Integer n = pSAppSBItem.getLeftPos();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_LeftPos_Default(pSAppSBItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("LEFTPOS");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Memo(boolean bl, PSAppSBItem pSAppSBItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSAppSBItem.isMemoDirty() : !pSAppSBItem.isMemoDirty()) {
            return null;
        }
        String string = pSAppSBItem.getMemo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Memo_Default(pSAppSBItem, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSAppSBItemId(boolean bl, PSAppSBItem pSAppSBItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSAppSBItem.isPSAppSBItemIdDirty() && !bl2 : !pSAppSBItem.isPSAppSBItemIdDirty()) {
            return null;
        }
        String string = pSAppSBItem.getPSAppSBItemId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSAPPSBITEMID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSAppSBItemId_Default(pSAppSBItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSAPPSBITEMID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSAppSBItemName(boolean bl, PSAppSBItem pSAppSBItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSAppSBItem.isPSAppSBItemNameDirty() && !bl2 : !pSAppSBItem.isPSAppSBItemNameDirty()) {
            return null;
        }
        String string = pSAppSBItem.getPSAppSBItemName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSAPPSBITEMNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSAppSBItemName_Default(pSAppSBItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSAPPSBITEMNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSAppStoryBoardId(boolean bl, PSAppSBItem pSAppSBItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSAppSBItem.isPSAppStoryBoardIdDirty() : !pSAppSBItem.isPSAppStoryBoardIdDirty()) {
            return null;
        }
        String string = pSAppSBItem.getPSAppStoryBoardId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSAppStoryBoardId_Default(pSAppSBItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSAPPSTORYBOARDID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSAppViewId(boolean bl, PSAppSBItem pSAppSBItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSAppSBItem.isPSAppViewIdDirty() : !pSAppSBItem.isPSAppViewIdDirty()) {
            return null;
        }
        String string = pSAppSBItem.getPSAppViewId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSAppViewId_Default(pSAppSBItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSAPPVIEWID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDynaInstId(boolean bl, PSAppSBItem pSAppSBItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSAppSBItem.isPSDynaInstIdDirty() : !pSAppSBItem.isPSDynaInstIdDirty()) {
            return null;
        }
        String string = pSAppSBItem.getPSDynaInstId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDynaInstId_Default(pSAppSBItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDYNAINSTID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSysReqItemId(boolean bl, PSAppSBItem pSAppSBItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSAppSBItem.isPSSysReqItemIdDirty() : !pSAppSBItem.isPSSysReqItemIdDirty()) {
            return null;
        }
        String string = pSAppSBItem.getPSSysReqItemId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysReqItemId_Default(pSAppSBItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSREQITEMID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSysUserCaseId(boolean bl, PSAppSBItem pSAppSBItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSAppSBItem.isPSSysUserCaseIdDirty() : !pSAppSBItem.isPSSysUserCaseIdDirty()) {
            return null;
        }
        String string = pSAppSBItem.getPSSysUserCaseId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysUserCaseId_Default(pSAppSBItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSUSERCASEID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_RootItem(boolean bl, PSAppSBItem pSAppSBItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSAppSBItem.isRootItemDirty() && !bl2 : !pSAppSBItem.isRootItemDirty()) {
            return null;
        }
        Integer n = pSAppSBItem.getRootItem();
        if (bl) {
            if (bl2 && n == null) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ROOTITEM");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string = null;
            string = this.onTestValueRule_RootItem_Default(pSAppSBItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ROOTITEM");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        } else {
            boolean bl4 = true;
            bl4 = DataTypeHelper.compare((int)9, (Object)n, (Object)"1") == 0L;
            if (bl4) {
                String string = "";
                string = "PSAPPSTORYBOARDID";
                String string2 = this.checkFieldDupRule(this.getPSAppSBItemDEModel(), "ROOTITEM", string, pSAppSBItem, bl2, bl3);
                if (!StringHelper.isNullOrEmpty((String)string2)) {
                    EntityFieldError entityFieldError = new EntityFieldError();
                    entityFieldError.setFieldName("ROOTITEM");
                    entityFieldError.setErrorType(3);
                    entityFieldError.setErrorInfo(string2);
                    return entityFieldError;
                }
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_TopPos(boolean bl, PSAppSBItem pSAppSBItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSAppSBItem.isTopPosDirty() : !pSAppSBItem.isTopPosDirty()) {
            return null;
        }
        Integer n = pSAppSBItem.getTopPos();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_TopPos_Default(pSAppSBItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("TOPPOS");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_UserCat(boolean bl, PSAppSBItem pSAppSBItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSAppSBItem.isUserCatDirty() : !pSAppSBItem.isUserCatDirty()) {
            return null;
        }
        String string = pSAppSBItem.getUserCat();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserCat_Default(pSAppSBItem, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserFlag(boolean bl, PSAppSBItem pSAppSBItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSAppSBItem.isUserFlagDirty() : !pSAppSBItem.isUserFlagDirty()) {
            return null;
        }
        Integer n = pSAppSBItem.getUserFlag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_UserFlag_Default(pSAppSBItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("USERFLAG");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_UserTag(boolean bl, PSAppSBItem pSAppSBItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSAppSBItem.isUserTagDirty() : !pSAppSBItem.isUserTagDirty()) {
            return null;
        }
        String string = pSAppSBItem.getUserTag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag_Default(pSAppSBItem, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag2(boolean bl, PSAppSBItem pSAppSBItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSAppSBItem.isUserTag2Dirty() : !pSAppSBItem.isUserTag2Dirty()) {
            return null;
        }
        String string = pSAppSBItem.getUserTag2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag2_Default(pSAppSBItem, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag3(boolean bl, PSAppSBItem pSAppSBItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSAppSBItem.isUserTag3Dirty() : !pSAppSBItem.isUserTag3Dirty()) {
            return null;
        }
        String string = pSAppSBItem.getUserTag3();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag3_Default(pSAppSBItem, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag4(boolean bl, PSAppSBItem pSAppSBItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSAppSBItem.isUserTag4Dirty() : !pSAppSBItem.isUserTag4Dirty()) {
            return null;
        }
        String string = pSAppSBItem.getUserTag4();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag4_Default(pSAppSBItem, bl2, bl3);
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

    protected EntityFieldError onCheckField_ValidFlag(boolean bl, PSAppSBItem pSAppSBItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSAppSBItem.isValidFlagDirty() && !bl2 : !pSAppSBItem.isValidFlagDirty()) {
            return null;
        }
        Integer n = pSAppSBItem.getValidFlag();
        if (bl) {
            if (bl2 && n == null) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("VALIDFLAG");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string = null;
            string = this.onTestValueRule_ValidFlag_Default(pSAppSBItem, bl2, bl3);
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

    protected void onSyncEntity(PSAppSBItem pSAppSBItem, boolean bl) throws Exception {
        super.onSyncEntity(pSAppSBItem, bl);
    }

    protected void onSyncIndexEntities(PSAppSBItem pSAppSBItem, boolean bl) throws Exception {
        super.onSyncIndexEntities(pSAppSBItem, bl);
    }

    public Object getDataContextValue(PSAppSBItem pSAppSBItem, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null) {
            // empty if block
        }
        if ((object = super.getDataContextValue(pSAppSBItem, string, iDataContextParam)) != null) {
            return object;
        }
        PSAppStoryBoard pSAppStoryBoard = pSAppSBItem.getPSAppStoryBoard();
        if (pSAppStoryBoard != null && pSAppStoryBoard.contains(string)) {
            return pSAppStoryBoard.get(string);
        }
        return null;
    }

    protected void onExportMajorModel(PSAppSBItem pSAppSBItem, ArrayList<JSONObject> arrayList, int n) throws Exception {
        super.onExportMajorModel(pSAppSBItem, arrayList, n);
    }

    protected String onTestValueRule(String string, String string2, IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        if (StringHelper.compare((String)string, (String)"CODENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CodeName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATEDATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateDate_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATEMAN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateMan_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ITEMTAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ItemTag_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ITEMTAG2", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ItemTag2_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ITEMTAG3", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ItemTag3_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ITEMTAG4", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ItemTag4_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ITEMTYPE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ItemType_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"LEFTPOS", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_LeftPos_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MEMO", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Memo_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSAPPSBITEMID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSAppSBItemId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSAPPSBITEMNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSAppSBItemName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSAPPSTORYBOARDID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSAppStoryBoardId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSAPPSTORYBOARDNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSAppStoryBoardName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSAPPVIEWID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSAppViewId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSAPPVIEWNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSAppViewName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDYNAINSTID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDynaInstId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSAPPID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysAppId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSREQITEMID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysReqItemId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSREQITEMNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysReqItemName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSUSERCASEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysUserCaseId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSUSERCASENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysUserCaseName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ROOTITEM", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_RootItem_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"TOPPOS", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_TopPos_Default(iEntity, bl, bl2);
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
        if (StringHelper.compare((String)string, (String)"USERFLAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UserFlag_Default(iEntity, bl, bl2);
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
            if (this.checkFieldStringLengthRule("CODENAME", iEntity, bl2, null, false, 50, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]", false) && this.checkFieldRegExRule("CODENAME", iEntity, bl2, "[a-zA-Z_$][a-zA-Z0-9_$]*", "\u5185\u5bb9\u53ea\u80fd\u7531\u5b57\u6bcd\u3001\u6570\u5b57\u3001\u4e0b\u5212\u7ebf\u7ec4\u6210\uff0c\u4e14\u5f00\u59cb\u5fc5\u987b\u4e3a\u5b57\u6bcd", false)) {
                return null;
            }
            return "(\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50] \u5e76\u4e14 \u5185\u5bb9\u53ea\u80fd\u7531\u5b57\u6bcd\u3001\u6570\u5b57\u3001\u4e0b\u5212\u7ebf\u7ec4\u6210\uff0c\u4e14\u5f00\u59cb\u5fc5\u987b\u4e3a\u5b57\u6bcd)";
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

    protected String onTestValueRule_ItemTag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("ITEMTAG", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_ItemTag2_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("ITEMTAG2", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_ItemTag3_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("ITEMTAG3", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_ItemTag4_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("ITEMTAG4", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_ItemType_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("ITEMTYPE", iEntity, bl2, null, false, 20, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[20]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[20]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_LeftPos_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
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

    protected String onTestValueRule_PSAppSBItemId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSAPPSBITEMID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSAppSBItemName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSAPPSBITEMNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSAppStoryBoardId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSAPPSTORYBOARDID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSAppStoryBoardName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSAPPSTORYBOARDNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSAppViewId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSAPPVIEWID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSAppViewName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSAPPVIEWNAME", iEntity, bl2, null, false, 80, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[80]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[80]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDynaInstId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDYNAINSTID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysAppId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSAPPID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysReqItemId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSREQITEMID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysReqItemName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSREQITEMNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysUserCaseId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSUSERCASEID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysUserCaseName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSUSERCASENAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_RootItem_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_TopPos_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
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

    protected String onTestValueRule_UserFlag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
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

    @Override
    protected boolean isPrepareLastForUpdate() {
        return true;
    }

    protected boolean onMergeChild(String string, String string2, PSAppSBItem pSAppSBItem) throws Exception {
        boolean bl = false;
        if (super.onMergeChild(string, string2, pSAppSBItem)) {
            bl = true;
        }
        return bl;
    }

    protected void onUpdateParent(PSAppSBItem pSAppSBItem) throws Exception {
        super.onUpdateParent(pSAppSBItem);
    }

    @Override
    protected void exportCurXmlModel(PSAppSBItem pSAppSBItem, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSAPPSBITEM");
        if (!bl) {
            pSAppSBItem.setCreateDate(null);
            pSAppSBItem.setCreateMan(null);
            pSAppSBItem.setPSAppSBItemId(null);
            pSAppSBItem.setPSAppStoryBoardName(null);
            pSAppSBItem.setUpdateDate(null);
            pSAppSBItem.setUpdateMan(null);
            pSAppSBItem.setPSAppStoryBoardId(null);
            pSAppSBItem.setPSAppStoryBoardName(null);
            pSAppSBItem.setPSSysAppId(null);
            super.exportCurXmlModel(pSAppSBItem, xmlNode, bl);
        }
    }

    @Override
    protected void onExportRelatedXmlModel(PSAppSBItem pSAppSBItem, XmlNode xmlNode) throws Exception {
        super.onExportRelatedXmlModel(pSAppSBItem, xmlNode);
    }

    @Override
    protected void onImportRelatedXmlModel(PSAppSBItem pSAppSBItem, XmlNode xmlNode) throws Exception {
        super.onImportRelatedXmlModel(pSAppSBItem, xmlNode);
    }

    @Override
    public ObjectNode fillModelV2(ObjectNode objectNode, PSAppSBItem pSAppSBItem, String string) throws Exception {
        objectNode = super.fillModelV2(objectNode, pSAppSBItem, string);
        return objectNode;
    }

    @Override
    public String getModelV2ResScope(IEntity iEntity) throws Exception {
        String string = null;
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSAPPSTORYBOARDID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return StringHelper.format((String)"PSAPPSTORYBOARD#%1$s", (Object)string);
        }
        return super.getModelV2ResScope(iEntity);
    }

    @Override
    public String getModelV2ResScopeDER(IEntity iEntity) throws Exception {
        String string = null;
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSAPPSTORYBOARDID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return "DER1N_PSAPPSBITEM_PSAPPSTORYBOARD_PSAPPSTORYBOARDID";
        }
        return super.getModelV2ResScopeDER(iEntity);
    }

    @Override
    public String getModelV2ResScopeText(IEntity iEntity) throws Exception {
        String string = null;
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSAPPSTORYBOARDID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return DataObject.getStringValue((IDataObject)iEntity, (String)"PSAPPSTORYBOARDNAME", null);
        }
        return super.getModelV2ResScopeText(iEntity);
    }

    @Override
    public boolean setModelV2ResScope(IEntity iEntity, String string, String string2) throws Exception {
        if (StringHelper.compare((String)string, (String)"PSAPPSTORYBOARD", (boolean)true) == 0) {
            iEntity.set("PSAPPSTORYBOARDID", (Object)string2);
            return true;
        }
        return super.setModelV2ResScope(iEntity, string, string2);
    }

    @Override
    public String[] getModelV2ResScopeFields() throws Exception {
        return new String[]{"PSAPPSTORYBOARDID"};
    }

    @Override
    public String getModelV2Tag(PSAppSBItem pSAppSBItem) {
        if (!StringHelper.isNullOrEmpty((String)pSAppSBItem.getCodeName())) {
            return pSAppSBItem.getCodeName();
        }
        return super.getModelV2Tag(pSAppSBItem);
    }

    @Override
    public boolean setModelV2Tag(PSAppSBItem pSAppSBItem, String string) {
        pSAppSBItem.setCodeName(string);
        return true;
    }

    @Override
    public Map<String, String> getListDRDataFolderFields(Map<String, String> map, PSMOSFile pSMOSFile, IPSMOSFileFilter iPSMOSFileFilter) throws Exception {
        if (map == null) {
            map = new HashMap<String, String>();
        }
        map.put("CODENAME", "");
        map.put("PSAPPSTORYBOARDID", "");
        return super.getListDRDataFolderFields(map, pSMOSFile, iPSMOSFileFilter);
    }

    @Override
    public boolean getModelV2Entity(PSAppSBItem pSAppSBItem, String string) throws Exception {
        SimpleEntity simpleEntity = new SimpleEntity();
        pSAppSBItem.copyTo((IDataObject)simpleEntity, false);
        simpleEntity.copyTo((IDataObject)pSAppSBItem, true);
        pSAppSBItem.set("CODENAME", string);
        if (this.select(pSAppSBItem, true)) {
            return true;
        }
        simpleEntity.copyTo((IDataObject)pSAppSBItem, true);
        return super.getModelV2Entity(pSAppSBItem, string);
    }

    @Override
    protected boolean testCompileCurModelV2(PSAppSBItem pSAppSBItem, ObjectNode objectNode, String string, String string2, int n) throws Exception {
        if (n == 1) {
            return true;
        }
        return super.testCompileCurModelV2(pSAppSBItem, objectNode, string, string2, n);
    }
}

