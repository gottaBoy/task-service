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
import net.ibizsys.pscore.srv.appdesign.dao.PSAppSBItemRSDAO;
import net.ibizsys.pscore.srv.appdesign.demodel.PSAppSBItemRSDEModel;
import net.ibizsys.pscore.srv.appdesign.entity.PSAppSBItem;
import net.ibizsys.pscore.srv.appdesign.entity.PSAppSBItemBase;
import net.ibizsys.pscore.srv.appdesign.entity.PSAppSBItemRS;
import net.ibizsys.pscore.srv.appdesign.entity.PSAppStoryBoard;
import net.ibizsys.pscore.srv.appdesign.entity.PSAppStoryBoardBase;
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

public abstract class PSAppSBItemRSServiceBase
extends PSCoreSysServiceBase<PSAppSBItemRS> {
    private static final Log log = LogFactory.getLog(PSAppSBItemRSServiceBase.class);
    public static final String DATASET_DEFAULT = "DEFAULT";
    private PSAppSBItemRSDEModel pSAppSBItemRSDEModel;
    private PSAppSBItemRSDAO pSAppSBItemRSDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.appdesign.service.PSAppSBItemRSService";
    }

    public PSAppSBItemRSDEModel getPSAppSBItemRSDEModel() {
        if (this.pSAppSBItemRSDEModel == null) {
            try {
                this.pSAppSBItemRSDEModel = (PSAppSBItemRSDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.appdesign.demodel.PSAppSBItemRSDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSAppSBItemRSDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSAppSBItemRSDEModel();
    }

    public PSAppSBItemRSDAO getPSAppSBItemRSDAO() {
        if (this.pSAppSBItemRSDAO == null) {
            try {
                this.pSAppSBItemRSDAO = (PSAppSBItemRSDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.appdesign.dao.PSAppSBItemRSDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSAppSBItemRSDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSAppSBItemRSDAO();
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

    protected void onFillParentInfo(PSAppSBItemRS pSAppSBItemRS, String string, String string2, String string3) throws Exception {
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSAPPSBITEMRS_PSAPPSBITEM_CPSAPPSBITEMID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.appdesign.service.PSAppSBItemService", (SessionFactory)this.getSessionFactory());
            PSAppSBItem pSAppSBItem = (PSAppSBItem)iService.getDEModel().createEntity();
            pSAppSBItem.set("PSAPPSBITEMID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSAppSBItem);
            } else {
                iService.get(pSAppSBItem);
            }
            this.onFillParentInfo_CPSAppSBItem(pSAppSBItemRS, pSAppSBItem);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSAPPSBITEMRS_PSAPPSBITEM_PPSAPPSBITEMID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.appdesign.service.PSAppSBItemService", (SessionFactory)this.getSessionFactory());
            PSAppSBItem pSAppSBItem = (PSAppSBItem)iService.getDEModel().createEntity();
            pSAppSBItem.set("PSAPPSBITEMID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSAppSBItem);
            } else {
                iService.get(pSAppSBItem);
            }
            this.onFillParentInfo_PPSAppSBItem(pSAppSBItemRS, pSAppSBItem);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSAPPSBITEMRS_PSAPPSTORYBOARD_PSAPPSTORYBOARDID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.appdesign.service.PSAppStoryBoardService", (SessionFactory)this.getSessionFactory());
            PSAppStoryBoard pSAppStoryBoard = (PSAppStoryBoard)iService.getDEModel().createEntity();
            pSAppStoryBoard.set("PSAPPSTORYBOARDID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSAppStoryBoard);
            } else {
                iService.get(pSAppStoryBoard);
            }
            this.onFillParentInfo_PSAppStoryBoard(pSAppSBItemRS, pSAppStoryBoard);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSAPPSBITEMRS_PSSYSREQITEM_PSSYSREQITEMID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysReqItemService", (SessionFactory)this.getSessionFactory());
            PSSysReqItem pSSysReqItem = (PSSysReqItem)iService.getDEModel().createEntity();
            pSSysReqItem.set("PSSYSREQITEMID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSSysReqItem);
            } else {
                iService.get(pSSysReqItem);
            }
            this.onFillParentInfo_PSSysReqItem(pSAppSBItemRS, pSSysReqItem);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSAPPSBITEMRS_PSSYSUSERCASE_PSSYSUSERCASEID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysUserCaseService", (SessionFactory)this.getSessionFactory());
            PSSysUserCase pSSysUserCase = (PSSysUserCase)iService.getDEModel().createEntity();
            pSSysUserCase.set("PSSYSUSERCASEID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSSysUserCase);
            } else {
                iService.get(pSSysUserCase);
            }
            this.onFillParentInfo_PSSysUserCase(pSAppSBItemRS, pSSysUserCase);
            return;
        }
        super.onFillParentInfo(pSAppSBItemRS, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillParentInfo_CPSAppSBItem(PSAppSBItemRS pSAppSBItemRS, PSAppSBItem pSAppSBItem) throws Exception {
        pSAppSBItemRS.setCPSAppSBItemId(pSAppSBItem.getPSAppSBItemId());
        pSAppSBItemRS.setCPSAppSBItemName(pSAppSBItem.getPSAppSBItemName());
    }

    protected void onFillParentInfo_PPSAppSBItem(PSAppSBItemRS pSAppSBItemRS, PSAppSBItem pSAppSBItem) throws Exception {
        pSAppSBItemRS.setPPSAppSBItemId(pSAppSBItem.getPSAppSBItemId());
        pSAppSBItemRS.setPPSAppSBItemName(pSAppSBItem.getPSAppSBItemName());
    }

    protected void onFillParentInfo_PSAppStoryBoard(PSAppSBItemRS pSAppSBItemRS, PSAppStoryBoard pSAppStoryBoard) throws Exception {
        pSAppSBItemRS.setPSAppStoryBoardId(pSAppStoryBoard.getPSAppStoryBoardId());
        pSAppSBItemRS.setPSAppStoryBoardName(pSAppStoryBoard.getPSAppStoryBoardName());
        pSAppSBItemRS.setPSSysAppId(pSAppStoryBoard.getPSSysAppId());
    }

    protected void onFillParentInfo_PSSysReqItem(PSAppSBItemRS pSAppSBItemRS, PSSysReqItem pSSysReqItem) throws Exception {
        pSAppSBItemRS.setPSSysReqItemId(pSSysReqItem.getPSSysReqItemId());
        pSAppSBItemRS.setPSSysReqItemName(pSSysReqItem.getPSSysReqItemName());
    }

    protected void onFillParentInfo_PSSysUserCase(PSAppSBItemRS pSAppSBItemRS, PSSysUserCase pSSysUserCase) throws Exception {
        pSAppSBItemRS.setPSSysUserCaseId(pSSysUserCase.getPSSysUserCaseId());
        pSAppSBItemRS.setPSSysUserCaseName(pSSysUserCase.getPSSysUserCaseName());
    }

    protected void onFillEntityFullInfo(PSAppSBItemRS pSAppSBItemRS, boolean bl) throws Exception {
        if (bl) {
            if (pSAppSBItemRS.getOrderValue() == null) {
                pSAppSBItemRS.setOrderValue((Integer)this.getDefaultValue(this.getWebContext(), "", "100", 9));
            }
            if (pSAppSBItemRS.getUserFlag() == null) {
                pSAppSBItemRS.setUserFlag((Integer)this.getDefaultValue(this.getWebContext(), "", "0", 9));
            }
            if (pSAppSBItemRS.getValidFlag() == null) {
                pSAppSBItemRS.setValidFlag((Integer)this.getDefaultValue(this.getWebContext(), "", "1", 9));
            }
        }
        super.onFillEntityFullInfo(pSAppSBItemRS, bl);
        this.onFillEntityFullInfo_CPSAppSBItem(pSAppSBItemRS, bl);
        this.onFillEntityFullInfo_PPSAppSBItem(pSAppSBItemRS, bl);
        this.onFillEntityFullInfo_PSAppStoryBoard(pSAppSBItemRS, bl);
        this.onFillEntityFullInfo_PSSysReqItem(pSAppSBItemRS, bl);
        this.onFillEntityFullInfo_PSSysUserCase(pSAppSBItemRS, bl);
    }

    protected void onFillEntityFullInfo_CPSAppSBItem(PSAppSBItemRS pSAppSBItemRS, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PPSAppSBItem(PSAppSBItemRS pSAppSBItemRS, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSAppStoryBoard(PSAppSBItemRS pSAppSBItemRS, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSSysReqItem(PSAppSBItemRS pSAppSBItemRS, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSSysUserCase(PSAppSBItemRS pSAppSBItemRS, boolean bl) throws Exception {
    }

    protected void onWriteBackParent(PSAppSBItemRS pSAppSBItemRS, boolean bl) throws Exception {
        super.onWriteBackParent(pSAppSBItemRS, bl);
    }

    public ArrayList<PSAppSBItemRS> selectByCPSAppSBItem(PSAppSBItemBase pSAppSBItemBase) throws Exception {
        return this.selectByCPSAppSBItem(pSAppSBItemBase, "", -1);
    }

    public ArrayList<PSAppSBItemRS> selectByCPSAppSBItem(PSAppSBItemBase pSAppSBItemBase, String string) throws Exception {
        return this.selectByCPSAppSBItem(pSAppSBItemBase, string, -1);
    }

    public ArrayList<PSAppSBItemRS> selectByCPSAppSBItem(PSAppSBItemBase pSAppSBItemBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("CPSAPPSBITEMID", (Object)pSAppSBItemBase.getPSAppSBItemId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByCPSAppSBItemCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByCPSAppSBItemCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSAppSBItemRS> selectTempByCPSAppSBItem(PSAppSBItemBase pSAppSBItemBase) throws Exception {
        return this.selectTempByCPSAppSBItem(pSAppSBItemBase, "");
    }

    public ArrayList<PSAppSBItemRS> selectTempByCPSAppSBItem(PSAppSBItemBase pSAppSBItemBase, String string) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("CPSAPPSBITEMID", (Object)pSAppSBItemBase.getPSAppSBItemId());
        selectCond.setOrderInfo(string);
        this.onFillSelectTempByCPSAppSBItemCond(selectCond);
        return this.selectTemp((ISelectCond)selectCond);
    }

    protected void onFillSelectTempByCPSAppSBItemCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSAppSBItemRS> selectByPPSAppSBItem(PSAppSBItemBase pSAppSBItemBase) throws Exception {
        return this.selectByPPSAppSBItem(pSAppSBItemBase, "", -1);
    }

    public ArrayList<PSAppSBItemRS> selectByPPSAppSBItem(PSAppSBItemBase pSAppSBItemBase, String string) throws Exception {
        return this.selectByPPSAppSBItem(pSAppSBItemBase, string, -1);
    }

    public ArrayList<PSAppSBItemRS> selectByPPSAppSBItem(PSAppSBItemBase pSAppSBItemBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PPSAPPSBITEMID", (Object)pSAppSBItemBase.getPSAppSBItemId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPPSAppSBItemCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPPSAppSBItemCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSAppSBItemRS> selectTempByPPSAppSBItem(PSAppSBItemBase pSAppSBItemBase) throws Exception {
        return this.selectTempByPPSAppSBItem(pSAppSBItemBase, "");
    }

    public ArrayList<PSAppSBItemRS> selectTempByPPSAppSBItem(PSAppSBItemBase pSAppSBItemBase, String string) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PPSAPPSBITEMID", (Object)pSAppSBItemBase.getPSAppSBItemId());
        selectCond.setOrderInfo(string);
        this.onFillSelectTempByPPSAppSBItemCond(selectCond);
        return this.selectTemp((ISelectCond)selectCond);
    }

    protected void onFillSelectTempByPPSAppSBItemCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSAppSBItemRS> selectByPSAppStoryBoard(PSAppStoryBoardBase pSAppStoryBoardBase) throws Exception {
        return this.selectByPSAppStoryBoard(pSAppStoryBoardBase, "", -1);
    }

    public ArrayList<PSAppSBItemRS> selectByPSAppStoryBoard(PSAppStoryBoardBase pSAppStoryBoardBase, String string) throws Exception {
        return this.selectByPSAppStoryBoard(pSAppStoryBoardBase, string, -1);
    }

    public ArrayList<PSAppSBItemRS> selectByPSAppStoryBoard(PSAppStoryBoardBase pSAppStoryBoardBase, String string, int n) throws Exception {
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

    public ArrayList<PSAppSBItemRS> selectTempByPSAppStoryBoard(PSAppStoryBoardBase pSAppStoryBoardBase) throws Exception {
        return this.selectTempByPSAppStoryBoard(pSAppStoryBoardBase, "");
    }

    public ArrayList<PSAppSBItemRS> selectTempByPSAppStoryBoard(PSAppStoryBoardBase pSAppStoryBoardBase, String string) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSAPPSTORYBOARDID", (Object)pSAppStoryBoardBase.getPSAppStoryBoardId());
        selectCond.setOrderInfo(string);
        this.onFillSelectTempByPSAppStoryBoardCond(selectCond);
        return this.selectTemp((ISelectCond)selectCond);
    }

    protected void onFillSelectTempByPSAppStoryBoardCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSAppSBItemRS> selectByPSSysReqItem(PSSysReqItemBase pSSysReqItemBase) throws Exception {
        return this.selectByPSSysReqItem(pSSysReqItemBase, "", -1);
    }

    public ArrayList<PSAppSBItemRS> selectByPSSysReqItem(PSSysReqItemBase pSSysReqItemBase, String string) throws Exception {
        return this.selectByPSSysReqItem(pSSysReqItemBase, string, -1);
    }

    public ArrayList<PSAppSBItemRS> selectByPSSysReqItem(PSSysReqItemBase pSSysReqItemBase, String string, int n) throws Exception {
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

    public ArrayList<PSAppSBItemRS> selectByPSSysUserCase(PSSysUserCaseBase pSSysUserCaseBase) throws Exception {
        return this.selectByPSSysUserCase(pSSysUserCaseBase, "", -1);
    }

    public ArrayList<PSAppSBItemRS> selectByPSSysUserCase(PSSysUserCaseBase pSSysUserCaseBase, String string) throws Exception {
        return this.selectByPSSysUserCase(pSSysUserCaseBase, string, -1);
    }

    public ArrayList<PSAppSBItemRS> selectByPSSysUserCase(PSSysUserCaseBase pSSysUserCaseBase, String string, int n) throws Exception {
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

    public void testRemoveByCPSAppSBItem(PSAppSBItem pSAppSBItem) throws Exception {
    }

    public void resetCPSAppSBItem(PSAppSBItem pSAppSBItem) throws Exception {
        ArrayList<PSAppSBItemRS> arrayList = this.selectByCPSAppSBItem(pSAppSBItem);
        for (PSAppSBItemRS pSAppSBItemRS : arrayList) {
            PSAppSBItemRS pSAppSBItemRS2 = (PSAppSBItemRS)this.getDEModel().createEntity();
            pSAppSBItemRS2.setPSAppSBItemRSId(pSAppSBItemRS.getPSAppSBItemRSId());
            pSAppSBItemRS2.setCPSAppSBItemId(null);
            this.update(pSAppSBItemRS2);
        }
    }

    public void resetTempCPSAppSBItem(PSAppSBItem pSAppSBItem) throws Exception {
        ArrayList<PSAppSBItemRS> arrayList = this.selectTempByCPSAppSBItem(pSAppSBItem);
        for (PSAppSBItemRS pSAppSBItemRS : arrayList) {
            PSAppSBItemRS pSAppSBItemRS2 = (PSAppSBItemRS)this.getDEModel().createEntity();
            pSAppSBItemRS2.setPSAppSBItemRSId(pSAppSBItemRS.getPSAppSBItemRSId());
            pSAppSBItemRS2.setCPSAppSBItemId(null);
            this.updateTemp(pSAppSBItemRS2);
        }
    }

    public void removeByCPSAppSBItem(PSAppSBItem pSAppSBItem) throws Exception {
        final PSAppSBItem pSAppSBItem2 = pSAppSBItem;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSAppSBItemRSServiceBase.this.onBeforeRemoveByCPSAppSBItem(pSAppSBItem2);
                PSAppSBItemRSServiceBase.this.internalRemoveByCPSAppSBItem(pSAppSBItem2);
                PSAppSBItemRSServiceBase.this.onAfterRemoveByCPSAppSBItem(pSAppSBItem2);
            }
        });
    }

    protected void onBeforeRemoveByCPSAppSBItem(PSAppSBItem pSAppSBItem) throws Exception {
    }

    protected void internalRemoveByCPSAppSBItem(PSAppSBItem pSAppSBItem) throws Exception {
        ArrayList<PSAppSBItemRS> arrayList = this.selectByCPSAppSBItem(pSAppSBItem);
        this.onBeforeRemoveByCPSAppSBItem(pSAppSBItem, arrayList);
        for (PSAppSBItemRS pSAppSBItemRS : arrayList) {
            this.remove(pSAppSBItemRS);
        }
        this.onAfterRemoveByCPSAppSBItem(pSAppSBItem, arrayList);
    }

    protected void onAfterRemoveByCPSAppSBItem(PSAppSBItem pSAppSBItem) throws Exception {
    }

    protected void onBeforeRemoveByCPSAppSBItem(PSAppSBItem pSAppSBItem, ArrayList<PSAppSBItemRS> arrayList) throws Exception {
    }

    protected void onAfterRemoveByCPSAppSBItem(PSAppSBItem pSAppSBItem, ArrayList<PSAppSBItemRS> arrayList) throws Exception {
    }

    public void testRemoveByPPSAppSBItem(PSAppSBItem pSAppSBItem) throws Exception {
    }

    public void resetPPSAppSBItem(PSAppSBItem pSAppSBItem) throws Exception {
        ArrayList<PSAppSBItemRS> arrayList = this.selectByPPSAppSBItem(pSAppSBItem);
        for (PSAppSBItemRS pSAppSBItemRS : arrayList) {
            PSAppSBItemRS pSAppSBItemRS2 = (PSAppSBItemRS)this.getDEModel().createEntity();
            pSAppSBItemRS2.setPSAppSBItemRSId(pSAppSBItemRS.getPSAppSBItemRSId());
            pSAppSBItemRS2.setPPSAppSBItemId(null);
            this.update(pSAppSBItemRS2);
        }
    }

    public void resetTempPPSAppSBItem(PSAppSBItem pSAppSBItem) throws Exception {
        ArrayList<PSAppSBItemRS> arrayList = this.selectTempByPPSAppSBItem(pSAppSBItem);
        for (PSAppSBItemRS pSAppSBItemRS : arrayList) {
            PSAppSBItemRS pSAppSBItemRS2 = (PSAppSBItemRS)this.getDEModel().createEntity();
            pSAppSBItemRS2.setPSAppSBItemRSId(pSAppSBItemRS.getPSAppSBItemRSId());
            pSAppSBItemRS2.setPPSAppSBItemId(null);
            this.updateTemp(pSAppSBItemRS2);
        }
    }

    public void removeByPPSAppSBItem(PSAppSBItem pSAppSBItem) throws Exception {
        final PSAppSBItem pSAppSBItem2 = pSAppSBItem;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSAppSBItemRSServiceBase.this.onBeforeRemoveByPPSAppSBItem(pSAppSBItem2);
                PSAppSBItemRSServiceBase.this.internalRemoveByPPSAppSBItem(pSAppSBItem2);
                PSAppSBItemRSServiceBase.this.onAfterRemoveByPPSAppSBItem(pSAppSBItem2);
            }
        });
    }

    protected void onBeforeRemoveByPPSAppSBItem(PSAppSBItem pSAppSBItem) throws Exception {
    }

    protected void internalRemoveByPPSAppSBItem(PSAppSBItem pSAppSBItem) throws Exception {
        ArrayList<PSAppSBItemRS> arrayList = this.selectByPPSAppSBItem(pSAppSBItem);
        this.onBeforeRemoveByPPSAppSBItem(pSAppSBItem, arrayList);
        for (PSAppSBItemRS pSAppSBItemRS : arrayList) {
            this.remove(pSAppSBItemRS);
        }
        this.onAfterRemoveByPPSAppSBItem(pSAppSBItem, arrayList);
    }

    protected void onAfterRemoveByPPSAppSBItem(PSAppSBItem pSAppSBItem) throws Exception {
    }

    protected void onBeforeRemoveByPPSAppSBItem(PSAppSBItem pSAppSBItem, ArrayList<PSAppSBItemRS> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPPSAppSBItem(PSAppSBItem pSAppSBItem, ArrayList<PSAppSBItemRS> arrayList) throws Exception {
    }

    public void testRemoveByPSAppStoryBoard(PSAppStoryBoard pSAppStoryBoard) throws Exception {
    }

    public void resetPSAppStoryBoard(PSAppStoryBoard pSAppStoryBoard) throws Exception {
        ArrayList<PSAppSBItemRS> arrayList = this.selectByPSAppStoryBoard(pSAppStoryBoard);
        for (PSAppSBItemRS pSAppSBItemRS : arrayList) {
            PSAppSBItemRS pSAppSBItemRS2 = (PSAppSBItemRS)this.getDEModel().createEntity();
            pSAppSBItemRS2.setPSAppSBItemRSId(pSAppSBItemRS.getPSAppSBItemRSId());
            pSAppSBItemRS2.setPSAppStoryBoardId(null);
            this.update(pSAppSBItemRS2);
        }
    }

    public void resetTempPSAppStoryBoard(PSAppStoryBoard pSAppStoryBoard) throws Exception {
        ArrayList<PSAppSBItemRS> arrayList = this.selectTempByPSAppStoryBoard(pSAppStoryBoard);
        for (PSAppSBItemRS pSAppSBItemRS : arrayList) {
            PSAppSBItemRS pSAppSBItemRS2 = (PSAppSBItemRS)this.getDEModel().createEntity();
            pSAppSBItemRS2.setPSAppSBItemRSId(pSAppSBItemRS.getPSAppSBItemRSId());
            pSAppSBItemRS2.setPSAppStoryBoardId(null);
            this.updateTemp(pSAppSBItemRS2);
        }
    }

    public void removeByPSAppStoryBoard(PSAppStoryBoard pSAppStoryBoard) throws Exception {
        final PSAppStoryBoard pSAppStoryBoard2 = pSAppStoryBoard;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSAppSBItemRSServiceBase.this.onBeforeRemoveByPSAppStoryBoard(pSAppStoryBoard2);
                PSAppSBItemRSServiceBase.this.internalRemoveByPSAppStoryBoard(pSAppStoryBoard2);
                PSAppSBItemRSServiceBase.this.onAfterRemoveByPSAppStoryBoard(pSAppStoryBoard2);
            }
        });
    }

    protected void onBeforeRemoveByPSAppStoryBoard(PSAppStoryBoard pSAppStoryBoard) throws Exception {
    }

    protected void internalRemoveByPSAppStoryBoard(PSAppStoryBoard pSAppStoryBoard) throws Exception {
        ArrayList<PSAppSBItemRS> arrayList = this.selectByPSAppStoryBoard(pSAppStoryBoard);
        this.onBeforeRemoveByPSAppStoryBoard(pSAppStoryBoard, arrayList);
        for (PSAppSBItemRS pSAppSBItemRS : arrayList) {
            this.remove(pSAppSBItemRS);
        }
        this.onAfterRemoveByPSAppStoryBoard(pSAppStoryBoard, arrayList);
    }

    protected void onAfterRemoveByPSAppStoryBoard(PSAppStoryBoard pSAppStoryBoard) throws Exception {
    }

    protected void onBeforeRemoveByPSAppStoryBoard(PSAppStoryBoard pSAppStoryBoard, ArrayList<PSAppSBItemRS> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSAppStoryBoard(PSAppStoryBoard pSAppStoryBoard, ArrayList<PSAppSBItemRS> arrayList) throws Exception {
    }

    public void testRemoveByPSSysReqItem(PSSysReqItem pSSysReqItem) throws Exception {
    }

    public void resetPSSysReqItem(PSSysReqItem pSSysReqItem) throws Exception {
        ArrayList<PSAppSBItemRS> arrayList = this.selectByPSSysReqItem(pSSysReqItem);
        for (PSAppSBItemRS pSAppSBItemRS : arrayList) {
            PSAppSBItemRS pSAppSBItemRS2 = (PSAppSBItemRS)this.getDEModel().createEntity();
            pSAppSBItemRS2.setPSAppSBItemRSId(pSAppSBItemRS.getPSAppSBItemRSId());
            pSAppSBItemRS2.setPSSysReqItemId(null);
            this.update(pSAppSBItemRS2);
        }
    }

    public void removeByPSSysReqItem(PSSysReqItem pSSysReqItem) throws Exception {
        final PSSysReqItem pSSysReqItem2 = pSSysReqItem;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSAppSBItemRSServiceBase.this.onBeforeRemoveByPSSysReqItem(pSSysReqItem2);
                PSAppSBItemRSServiceBase.this.internalRemoveByPSSysReqItem(pSSysReqItem2);
                PSAppSBItemRSServiceBase.this.onAfterRemoveByPSSysReqItem(pSSysReqItem2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysReqItem(PSSysReqItem pSSysReqItem) throws Exception {
    }

    protected void internalRemoveByPSSysReqItem(PSSysReqItem pSSysReqItem) throws Exception {
        ArrayList<PSAppSBItemRS> arrayList = this.selectByPSSysReqItem(pSSysReqItem);
        this.onBeforeRemoveByPSSysReqItem(pSSysReqItem, arrayList);
        for (PSAppSBItemRS pSAppSBItemRS : arrayList) {
            this.remove(pSAppSBItemRS);
        }
        this.onAfterRemoveByPSSysReqItem(pSSysReqItem, arrayList);
    }

    protected void onAfterRemoveByPSSysReqItem(PSSysReqItem pSSysReqItem) throws Exception {
    }

    protected void onBeforeRemoveByPSSysReqItem(PSSysReqItem pSSysReqItem, ArrayList<PSAppSBItemRS> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysReqItem(PSSysReqItem pSSysReqItem, ArrayList<PSAppSBItemRS> arrayList) throws Exception {
    }

    public void testRemoveByPSSysUserCase(PSSysUserCase pSSysUserCase) throws Exception {
    }

    public void resetPSSysUserCase(PSSysUserCase pSSysUserCase) throws Exception {
        ArrayList<PSAppSBItemRS> arrayList = this.selectByPSSysUserCase(pSSysUserCase);
        for (PSAppSBItemRS pSAppSBItemRS : arrayList) {
            PSAppSBItemRS pSAppSBItemRS2 = (PSAppSBItemRS)this.getDEModel().createEntity();
            pSAppSBItemRS2.setPSAppSBItemRSId(pSAppSBItemRS.getPSAppSBItemRSId());
            pSAppSBItemRS2.setPSSysUserCaseId(null);
            this.update(pSAppSBItemRS2);
        }
    }

    public void removeByPSSysUserCase(PSSysUserCase pSSysUserCase) throws Exception {
        final PSSysUserCase pSSysUserCase2 = pSSysUserCase;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSAppSBItemRSServiceBase.this.onBeforeRemoveByPSSysUserCase(pSSysUserCase2);
                PSAppSBItemRSServiceBase.this.internalRemoveByPSSysUserCase(pSSysUserCase2);
                PSAppSBItemRSServiceBase.this.onAfterRemoveByPSSysUserCase(pSSysUserCase2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysUserCase(PSSysUserCase pSSysUserCase) throws Exception {
    }

    protected void internalRemoveByPSSysUserCase(PSSysUserCase pSSysUserCase) throws Exception {
        ArrayList<PSAppSBItemRS> arrayList = this.selectByPSSysUserCase(pSSysUserCase);
        this.onBeforeRemoveByPSSysUserCase(pSSysUserCase, arrayList);
        for (PSAppSBItemRS pSAppSBItemRS : arrayList) {
            this.remove(pSAppSBItemRS);
        }
        this.onAfterRemoveByPSSysUserCase(pSSysUserCase, arrayList);
    }

    protected void onAfterRemoveByPSSysUserCase(PSSysUserCase pSSysUserCase) throws Exception {
    }

    protected void onBeforeRemoveByPSSysUserCase(PSSysUserCase pSSysUserCase, ArrayList<PSAppSBItemRS> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysUserCase(PSSysUserCase pSSysUserCase, ArrayList<PSAppSBItemRS> arrayList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(PSAppSBItemRS pSAppSBItemRS) throws Exception {
        super.onBeforeRemove(pSAppSBItemRS);
    }

    public void removeTempByCPSAppSBItem(PSAppSBItem pSAppSBItem) throws Exception {
        final PSAppSBItem pSAppSBItem2 = pSAppSBItem;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSAppSBItemRSServiceBase.this.onBeforeRemoveTempByCPSAppSBItem(pSAppSBItem2);
                PSAppSBItemRSServiceBase.this.internalRemoveTempByCPSAppSBItem(pSAppSBItem2);
                PSAppSBItemRSServiceBase.this.onAfterRemoveTempByCPSAppSBItem(pSAppSBItem2);
            }
        });
    }

    protected void onBeforeRemoveTempByCPSAppSBItem(PSAppSBItem pSAppSBItem) throws Exception {
    }

    protected void internalRemoveTempByCPSAppSBItem(PSAppSBItem pSAppSBItem) throws Exception {
        ArrayList<PSAppSBItemRS> arrayList = this.selectTempByCPSAppSBItem(pSAppSBItem);
        this.onBeforeRemoveTempByCPSAppSBItem(pSAppSBItem, arrayList);
        for (PSAppSBItemRS pSAppSBItemRS : arrayList) {
            this.removeTemp(pSAppSBItemRS);
        }
        this.onAfterRemoveTempByCPSAppSBItem(pSAppSBItem, arrayList);
    }

    protected void onAfterRemoveTempByCPSAppSBItem(PSAppSBItem pSAppSBItem) throws Exception {
    }

    protected void onBeforeRemoveTempByCPSAppSBItem(PSAppSBItem pSAppSBItem, ArrayList<PSAppSBItemRS> arrayList) throws Exception {
    }

    protected void onAfterRemoveTempByCPSAppSBItem(PSAppSBItem pSAppSBItem, ArrayList<PSAppSBItemRS> arrayList) throws Exception {
    }

    public void removeTempByPPSAppSBItem(PSAppSBItem pSAppSBItem) throws Exception {
        final PSAppSBItem pSAppSBItem2 = pSAppSBItem;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSAppSBItemRSServiceBase.this.onBeforeRemoveTempByPPSAppSBItem(pSAppSBItem2);
                PSAppSBItemRSServiceBase.this.internalRemoveTempByPPSAppSBItem(pSAppSBItem2);
                PSAppSBItemRSServiceBase.this.onAfterRemoveTempByPPSAppSBItem(pSAppSBItem2);
            }
        });
    }

    protected void onBeforeRemoveTempByPPSAppSBItem(PSAppSBItem pSAppSBItem) throws Exception {
    }

    protected void internalRemoveTempByPPSAppSBItem(PSAppSBItem pSAppSBItem) throws Exception {
        ArrayList<PSAppSBItemRS> arrayList = this.selectTempByPPSAppSBItem(pSAppSBItem);
        this.onBeforeRemoveTempByPPSAppSBItem(pSAppSBItem, arrayList);
        for (PSAppSBItemRS pSAppSBItemRS : arrayList) {
            this.removeTemp(pSAppSBItemRS);
        }
        this.onAfterRemoveTempByPPSAppSBItem(pSAppSBItem, arrayList);
    }

    protected void onAfterRemoveTempByPPSAppSBItem(PSAppSBItem pSAppSBItem) throws Exception {
    }

    protected void onBeforeRemoveTempByPPSAppSBItem(PSAppSBItem pSAppSBItem, ArrayList<PSAppSBItemRS> arrayList) throws Exception {
    }

    protected void onAfterRemoveTempByPPSAppSBItem(PSAppSBItem pSAppSBItem, ArrayList<PSAppSBItemRS> arrayList) throws Exception {
    }

    public void removeTempByPSAppStoryBoard(PSAppStoryBoard pSAppStoryBoard) throws Exception {
        final PSAppStoryBoard pSAppStoryBoard2 = pSAppStoryBoard;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSAppSBItemRSServiceBase.this.onBeforeRemoveTempByPSAppStoryBoard(pSAppStoryBoard2);
                PSAppSBItemRSServiceBase.this.internalRemoveTempByPSAppStoryBoard(pSAppStoryBoard2);
                PSAppSBItemRSServiceBase.this.onAfterRemoveTempByPSAppStoryBoard(pSAppStoryBoard2);
            }
        });
    }

    protected void onBeforeRemoveTempByPSAppStoryBoard(PSAppStoryBoard pSAppStoryBoard) throws Exception {
    }

    protected void internalRemoveTempByPSAppStoryBoard(PSAppStoryBoard pSAppStoryBoard) throws Exception {
        ArrayList<PSAppSBItemRS> arrayList = this.selectTempByPSAppStoryBoard(pSAppStoryBoard);
        this.onBeforeRemoveTempByPSAppStoryBoard(pSAppStoryBoard, arrayList);
        for (PSAppSBItemRS pSAppSBItemRS : arrayList) {
            this.removeTemp(pSAppSBItemRS);
        }
        this.onAfterRemoveTempByPSAppStoryBoard(pSAppStoryBoard, arrayList);
    }

    protected void onAfterRemoveTempByPSAppStoryBoard(PSAppStoryBoard pSAppStoryBoard) throws Exception {
    }

    protected void onBeforeRemoveTempByPSAppStoryBoard(PSAppStoryBoard pSAppStoryBoard, ArrayList<PSAppSBItemRS> arrayList) throws Exception {
    }

    protected void onAfterRemoveTempByPSAppStoryBoard(PSAppStoryBoard pSAppStoryBoard, ArrayList<PSAppSBItemRS> arrayList) throws Exception {
    }

    protected void replaceParentInfo(PSAppSBItemRS pSAppSBItemRS, CloneSession cloneSession) throws Exception {
        IEntity iEntity;
        super.replaceParentInfo(pSAppSBItemRS, cloneSession);
        if (pSAppSBItemRS.getCPSAppSBItemId() != null && (iEntity = cloneSession.getEntity("PSAPPSBITEM", (Object)pSAppSBItemRS.getCPSAppSBItemId())) != null) {
            this.onFillParentInfo_CPSAppSBItem(pSAppSBItemRS, (PSAppSBItem)iEntity);
        }
        if (pSAppSBItemRS.getPPSAppSBItemId() != null && (iEntity = cloneSession.getEntity("PSAPPSBITEM", (Object)pSAppSBItemRS.getPPSAppSBItemId())) != null) {
            this.onFillParentInfo_PPSAppSBItem(pSAppSBItemRS, (PSAppSBItem)iEntity);
        }
        if (pSAppSBItemRS.getPSAppStoryBoardId() != null && (iEntity = cloneSession.getEntity("PSAPPSTORYBOARD", (Object)pSAppSBItemRS.getPSAppStoryBoardId())) != null) {
            this.onFillParentInfo_PSAppStoryBoard(pSAppSBItemRS, (PSAppStoryBoard)iEntity);
        }
        if (pSAppSBItemRS.getPSSysReqItemId() != null && (iEntity = cloneSession.getEntity("PSSYSREQITEM", (Object)pSAppSBItemRS.getPSSysReqItemId())) != null) {
            this.onFillParentInfo_PSSysReqItem(pSAppSBItemRS, (PSSysReqItem)iEntity);
        }
        if (pSAppSBItemRS.getPSSysUserCaseId() != null && (iEntity = cloneSession.getEntity("PSSYSUSERCASE", (Object)pSAppSBItemRS.getPSSysUserCaseId())) != null) {
            this.onFillParentInfo_PSSysUserCase(pSAppSBItemRS, (PSSysUserCase)iEntity);
        }
    }

    protected void onRemoveEntityUncopyValues(PSAppSBItemRS pSAppSBItemRS, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues(pSAppSBItemRS, bl);
    }

    protected void onCheckEntity(boolean bl, PSAppSBItemRS pSAppSBItemRS, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_CodeName(bl, pSAppSBItemRS, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_CPSAppSBItemId(bl, pSAppSBItemRS, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_DstEndPoint(bl, pSAppSBItemRS, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Memo(bl, pSAppSBItemRS, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_OrderValue(bl, pSAppSBItemRS, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PPSAppSBItemId(bl, pSAppSBItemRS, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSAppSBItemRSId(bl, pSAppSBItemRS, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSAppSBItemRSName(bl, pSAppSBItemRS, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSAppStoryBoardId(bl, pSAppSBItemRS, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDynaInstId(bl, pSAppSBItemRS, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysReqItemId(bl, pSAppSBItemRS, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysUserCaseId(bl, pSAppSBItemRS, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_RSTag(bl, pSAppSBItemRS, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_RSTag2(bl, pSAppSBItemRS, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_RSTag3(bl, pSAppSBItemRS, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_RSTag4(bl, pSAppSBItemRS, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_RSType(bl, pSAppSBItemRS, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_SrcEndPoint(bl, pSAppSBItemRS, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserCat(bl, pSAppSBItemRS, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserFlag(bl, pSAppSBItemRS, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag(bl, pSAppSBItemRS, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag2(bl, pSAppSBItemRS, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag3(bl, pSAppSBItemRS, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag4(bl, pSAppSBItemRS, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ValidFlag(bl, pSAppSBItemRS, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, pSAppSBItemRS, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_CodeName(boolean bl, PSAppSBItemRS pSAppSBItemRS, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSAppSBItemRS.isCodeNameDirty() && !bl2 : !pSAppSBItemRS.isCodeNameDirty()) {
            return null;
        }
        String string = pSAppSBItemRS.getCodeName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CODENAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_CodeName_Default(pSAppSBItemRS, bl2, bl3);
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
                String string4 = this.checkFieldDupRule(this.getPSAppSBItemRSDEModel(), "CODENAME", string3, pSAppSBItemRS, bl2, bl3);
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

    protected EntityFieldError onCheckField_CPSAppSBItemId(boolean bl, PSAppSBItemRS pSAppSBItemRS, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSAppSBItemRS.isCPSAppSBItemIdDirty() : !pSAppSBItemRS.isCPSAppSBItemIdDirty()) {
            return null;
        }
        String string = pSAppSBItemRS.getCPSAppSBItemId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_CPSAppSBItemId_Default(pSAppSBItemRS, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CPSAPPSBITEMID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_DstEndPoint(boolean bl, PSAppSBItemRS pSAppSBItemRS, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSAppSBItemRS.isDstEndPointDirty() : !pSAppSBItemRS.isDstEndPointDirty()) {
            return null;
        }
        String string = pSAppSBItemRS.getDstEndPoint();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_DstEndPoint_Default(pSAppSBItemRS, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DSTENDPOINT");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Memo(boolean bl, PSAppSBItemRS pSAppSBItemRS, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSAppSBItemRS.isMemoDirty() : !pSAppSBItemRS.isMemoDirty()) {
            return null;
        }
        String string = pSAppSBItemRS.getMemo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Memo_Default(pSAppSBItemRS, bl2, bl3);
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

    protected EntityFieldError onCheckField_OrderValue(boolean bl, PSAppSBItemRS pSAppSBItemRS, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSAppSBItemRS.isOrderValueDirty() : !pSAppSBItemRS.isOrderValueDirty()) {
            return null;
        }
        Integer n = pSAppSBItemRS.getOrderValue();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_OrderValue_Default(pSAppSBItemRS, bl2, bl3);
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

    protected EntityFieldError onCheckField_PPSAppSBItemId(boolean bl, PSAppSBItemRS pSAppSBItemRS, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSAppSBItemRS.isPPSAppSBItemIdDirty() && !bl2 : !pSAppSBItemRS.isPPSAppSBItemIdDirty()) {
            return null;
        }
        String string = pSAppSBItemRS.getPPSAppSBItemId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PPSAPPSBITEMID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PPSAppSBItemId_Default(pSAppSBItemRS, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PPSAPPSBITEMID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSAppSBItemRSId(boolean bl, PSAppSBItemRS pSAppSBItemRS, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSAppSBItemRS.isPSAppSBItemRSIdDirty() && !bl2 : !pSAppSBItemRS.isPSAppSBItemRSIdDirty()) {
            return null;
        }
        String string = pSAppSBItemRS.getPSAppSBItemRSId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSAPPSBITEMRSID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSAppSBItemRSId_Default(pSAppSBItemRS, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSAPPSBITEMRSID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSAppSBItemRSName(boolean bl, PSAppSBItemRS pSAppSBItemRS, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSAppSBItemRS.isPSAppSBItemRSNameDirty() && !bl2 : !pSAppSBItemRS.isPSAppSBItemRSNameDirty()) {
            return null;
        }
        String string = pSAppSBItemRS.getPSAppSBItemRSName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSAPPSBITEMRSNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSAppSBItemRSName_Default(pSAppSBItemRS, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSAPPSBITEMRSNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSAppStoryBoardId(boolean bl, PSAppSBItemRS pSAppSBItemRS, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSAppSBItemRS.isPSAppStoryBoardIdDirty() : !pSAppSBItemRS.isPSAppStoryBoardIdDirty()) {
            return null;
        }
        String string = pSAppSBItemRS.getPSAppStoryBoardId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSAppStoryBoardId_Default(pSAppSBItemRS, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDynaInstId(boolean bl, PSAppSBItemRS pSAppSBItemRS, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSAppSBItemRS.isPSDynaInstIdDirty() : !pSAppSBItemRS.isPSDynaInstIdDirty()) {
            return null;
        }
        String string = pSAppSBItemRS.getPSDynaInstId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDynaInstId_Default(pSAppSBItemRS, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSSysReqItemId(boolean bl, PSAppSBItemRS pSAppSBItemRS, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSAppSBItemRS.isPSSysReqItemIdDirty() : !pSAppSBItemRS.isPSSysReqItemIdDirty()) {
            return null;
        }
        String string = pSAppSBItemRS.getPSSysReqItemId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysReqItemId_Default(pSAppSBItemRS, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSSysUserCaseId(boolean bl, PSAppSBItemRS pSAppSBItemRS, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSAppSBItemRS.isPSSysUserCaseIdDirty() : !pSAppSBItemRS.isPSSysUserCaseIdDirty()) {
            return null;
        }
        String string = pSAppSBItemRS.getPSSysUserCaseId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysUserCaseId_Default(pSAppSBItemRS, bl2, bl3);
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

    protected EntityFieldError onCheckField_RSTag(boolean bl, PSAppSBItemRS pSAppSBItemRS, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSAppSBItemRS.isRSTagDirty() : !pSAppSBItemRS.isRSTagDirty()) {
            return null;
        }
        String string = pSAppSBItemRS.getRSTag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_RSTag_Default(pSAppSBItemRS, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("RSTAG");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_RSTag2(boolean bl, PSAppSBItemRS pSAppSBItemRS, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSAppSBItemRS.isRSTag2Dirty() : !pSAppSBItemRS.isRSTag2Dirty()) {
            return null;
        }
        String string = pSAppSBItemRS.getRSTag2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_RSTag2_Default(pSAppSBItemRS, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("RSTAG2");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_RSTag3(boolean bl, PSAppSBItemRS pSAppSBItemRS, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSAppSBItemRS.isRSTag3Dirty() : !pSAppSBItemRS.isRSTag3Dirty()) {
            return null;
        }
        String string = pSAppSBItemRS.getRSTag3();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_RSTag3_Default(pSAppSBItemRS, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("RSTAG3");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_RSTag4(boolean bl, PSAppSBItemRS pSAppSBItemRS, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSAppSBItemRS.isRSTag4Dirty() : !pSAppSBItemRS.isRSTag4Dirty()) {
            return null;
        }
        String string = pSAppSBItemRS.getRSTag4();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_RSTag4_Default(pSAppSBItemRS, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("RSTAG4");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_RSType(boolean bl, PSAppSBItemRS pSAppSBItemRS, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSAppSBItemRS.isRSTypeDirty() : !pSAppSBItemRS.isRSTypeDirty()) {
            return null;
        }
        String string = pSAppSBItemRS.getRSType();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_RSType_Default(pSAppSBItemRS, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("RSTYPE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_SrcEndPoint(boolean bl, PSAppSBItemRS pSAppSBItemRS, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSAppSBItemRS.isSrcEndPointDirty() : !pSAppSBItemRS.isSrcEndPointDirty()) {
            return null;
        }
        String string = pSAppSBItemRS.getSrcEndPoint();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_SrcEndPoint_Default(pSAppSBItemRS, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("SRCENDPOINT");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_UserCat(boolean bl, PSAppSBItemRS pSAppSBItemRS, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSAppSBItemRS.isUserCatDirty() : !pSAppSBItemRS.isUserCatDirty()) {
            return null;
        }
        String string = pSAppSBItemRS.getUserCat();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserCat_Default(pSAppSBItemRS, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserFlag(boolean bl, PSAppSBItemRS pSAppSBItemRS, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSAppSBItemRS.isUserFlagDirty() : !pSAppSBItemRS.isUserFlagDirty()) {
            return null;
        }
        Integer n = pSAppSBItemRS.getUserFlag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_UserFlag_Default(pSAppSBItemRS, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag(boolean bl, PSAppSBItemRS pSAppSBItemRS, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSAppSBItemRS.isUserTagDirty() : !pSAppSBItemRS.isUserTagDirty()) {
            return null;
        }
        String string = pSAppSBItemRS.getUserTag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag_Default(pSAppSBItemRS, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag2(boolean bl, PSAppSBItemRS pSAppSBItemRS, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSAppSBItemRS.isUserTag2Dirty() : !pSAppSBItemRS.isUserTag2Dirty()) {
            return null;
        }
        String string = pSAppSBItemRS.getUserTag2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag2_Default(pSAppSBItemRS, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag3(boolean bl, PSAppSBItemRS pSAppSBItemRS, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSAppSBItemRS.isUserTag3Dirty() : !pSAppSBItemRS.isUserTag3Dirty()) {
            return null;
        }
        String string = pSAppSBItemRS.getUserTag3();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag3_Default(pSAppSBItemRS, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag4(boolean bl, PSAppSBItemRS pSAppSBItemRS, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSAppSBItemRS.isUserTag4Dirty() : !pSAppSBItemRS.isUserTag4Dirty()) {
            return null;
        }
        String string = pSAppSBItemRS.getUserTag4();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag4_Default(pSAppSBItemRS, bl2, bl3);
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

    protected EntityFieldError onCheckField_ValidFlag(boolean bl, PSAppSBItemRS pSAppSBItemRS, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSAppSBItemRS.isValidFlagDirty() && !bl2 : !pSAppSBItemRS.isValidFlagDirty()) {
            return null;
        }
        Integer n = pSAppSBItemRS.getValidFlag();
        if (bl) {
            if (bl2 && n == null) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("VALIDFLAG");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string = null;
            string = this.onTestValueRule_ValidFlag_Default(pSAppSBItemRS, bl2, bl3);
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

    protected void onSyncEntity(PSAppSBItemRS pSAppSBItemRS, boolean bl) throws Exception {
        super.onSyncEntity(pSAppSBItemRS, bl);
    }

    protected void onSyncIndexEntities(PSAppSBItemRS pSAppSBItemRS, boolean bl) throws Exception {
        super.onSyncIndexEntities(pSAppSBItemRS, bl);
    }

    public Object getDataContextValue(PSAppSBItemRS pSAppSBItemRS, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null) {
            // empty if block
        }
        if ((object = super.getDataContextValue(pSAppSBItemRS, string, iDataContextParam)) != null) {
            return object;
        }
        PSAppStoryBoard pSAppStoryBoard = pSAppSBItemRS.getPSAppStoryBoard();
        if (pSAppStoryBoard != null && pSAppStoryBoard.contains(string)) {
            return pSAppStoryBoard.get(string);
        }
        return null;
    }

    protected void onExportMajorModel(PSAppSBItemRS pSAppSBItemRS, ArrayList<JSONObject> arrayList, int n) throws Exception {
        super.onExportMajorModel(pSAppSBItemRS, arrayList, n);
    }

    protected String onTestValueRule(String string, String string2, IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        if (StringHelper.compare((String)string, (String)"CODENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CodeName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CPSAPPSBITEMID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CPSAppSBItemId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CPSAPPSBITEMNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CPSAppSBItemName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATEDATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateDate_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATEMAN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateMan_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DSTENDPOINT", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DstEndPoint_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MEMO", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Memo_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ORDERVALUE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_OrderValue_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PPSAPPSBITEMID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PPSAppSBItemId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PPSAPPSBITEMNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PPSAppSBItemName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSAPPSBITEMRSID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSAppSBItemRSId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSAPPSBITEMRSNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSAppSBItemRSName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSAPPSTORYBOARDID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSAppStoryBoardId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSAPPSTORYBOARDNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSAppStoryBoardName_Default(iEntity, bl, bl2);
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
        if (StringHelper.compare((String)string, (String)"RSTAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_RSTag_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"RSTAG2", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_RSTag2_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"RSTAG3", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_RSTag3_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"RSTAG4", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_RSTag4_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"RSTYPE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_RSType_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"SRCENDPOINT", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_SrcEndPoint_Default(iEntity, bl, bl2);
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
            if (this.checkFieldStringLengthRule("CODENAME", iEntity, bl2, null, false, 30, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]", false) && this.checkFieldRegExRule("CODENAME", iEntity, bl2, "[a-zA-Z_$][a-zA-Z0-9_$]*", "\u5185\u5bb9\u53ea\u80fd\u7531\u5b57\u6bcd\u3001\u6570\u5b57\u3001\u4e0b\u5212\u7ebf\u7ec4\u6210\uff0c\u4e14\u5f00\u59cb\u5fc5\u987b\u4e3a\u5b57\u6bcd", false)) {
                return null;
            }
            return "(\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30] \u5e76\u4e14 \u5185\u5bb9\u53ea\u80fd\u7531\u5b57\u6bcd\u3001\u6570\u5b57\u3001\u4e0b\u5212\u7ebf\u7ec4\u6210\uff0c\u4e14\u5f00\u59cb\u5fc5\u987b\u4e3a\u5b57\u6bcd)";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_CPSAppSBItemId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("CPSAPPSBITEMID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_CPSAppSBItemName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("CPSAPPSBITEMNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
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

    protected String onTestValueRule_DstEndPoint_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("DSTENDPOINT", iEntity, bl2, null, false, 60, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]", false)) {
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

    protected String onTestValueRule_PPSAppSBItemId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PPSAPPSBITEMID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PPSAppSBItemName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PPSAPPSBITEMNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSAppSBItemRSId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSAPPSBITEMRSID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSAppSBItemRSName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSAPPSBITEMRSNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
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

    protected String onTestValueRule_RSTag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("RSTAG", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_RSTag2_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("RSTAG2", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_RSTag3_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("RSTAG3", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_RSTag4_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("RSTAG4", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_RSType_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("RSTYPE", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_SrcEndPoint_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("SRCENDPOINT", iEntity, bl2, null, false, 60, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]";
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

    protected boolean onMergeChild(String string, String string2, PSAppSBItemRS pSAppSBItemRS) throws Exception {
        boolean bl = false;
        if (super.onMergeChild(string, string2, pSAppSBItemRS)) {
            bl = true;
        }
        return bl;
    }

    protected void onUpdateParent(PSAppSBItemRS pSAppSBItemRS) throws Exception {
        super.onUpdateParent(pSAppSBItemRS);
    }

    @Override
    protected void exportCurXmlModel(PSAppSBItemRS pSAppSBItemRS, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSAPPSBITEMRS");
        if (!bl) {
            pSAppSBItemRS.setCreateDate(null);
            pSAppSBItemRS.setCreateMan(null);
            pSAppSBItemRS.setPSAppSBItemRSId(null);
            pSAppSBItemRS.setPSAppStoryBoardName(null);
            pSAppSBItemRS.setUpdateDate(null);
            pSAppSBItemRS.setUpdateMan(null);
            pSAppSBItemRS.setCPSAppSBItemId(null);
            pSAppSBItemRS.setPPSAppSBItemId(null);
            pSAppSBItemRS.setPSAppStoryBoardId(null);
            pSAppSBItemRS.setPSAppStoryBoardName(null);
            pSAppSBItemRS.setPSSysAppId(null);
            super.exportCurXmlModel(pSAppSBItemRS, xmlNode, bl);
        }
    }

    @Override
    public ObjectNode fillModelV2(ObjectNode objectNode, PSAppSBItemRS pSAppSBItemRS, String string) throws Exception {
        objectNode = super.fillModelV2(objectNode, pSAppSBItemRS, string);
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
            return "DER1N_PSAPPSBITEMRS_PSAPPSTORYBOARD_PSAPPSTORYBOARDID";
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
    public String getModelV2Tag(PSAppSBItemRS pSAppSBItemRS) {
        if (!StringHelper.isNullOrEmpty((String)pSAppSBItemRS.getCodeName())) {
            return pSAppSBItemRS.getCodeName();
        }
        return super.getModelV2Tag(pSAppSBItemRS);
    }

    @Override
    public boolean setModelV2Tag(PSAppSBItemRS pSAppSBItemRS, String string) {
        pSAppSBItemRS.setCodeName(string);
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
    public boolean getModelV2Entity(PSAppSBItemRS pSAppSBItemRS, String string) throws Exception {
        SimpleEntity simpleEntity = new SimpleEntity();
        pSAppSBItemRS.copyTo((IDataObject)simpleEntity, false);
        simpleEntity.copyTo((IDataObject)pSAppSBItemRS, true);
        pSAppSBItemRS.set("CODENAME", string);
        if (this.select(pSAppSBItemRS, true)) {
            return true;
        }
        simpleEntity.copyTo((IDataObject)pSAppSBItemRS, true);
        return super.getModelV2Entity(pSAppSBItemRS, string);
    }

    @Override
    protected boolean testCompileCurModelV2(PSAppSBItemRS pSAppSBItemRS, ObjectNode objectNode, String string, String string2, int n) throws Exception {
        if (n == 1) {
            return false;
        }
        return super.testCompileCurModelV2(pSAppSBItemRS, objectNode, string, string2, n);
    }
}

