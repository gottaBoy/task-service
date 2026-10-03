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
 *  net.ibizsys.paas.service.IServicePlugin
 *  net.ibizsys.paas.service.IServiceWork
 *  net.ibizsys.paas.service.ITransaction
 *  net.ibizsys.paas.service.ServiceGlobal
 *  net.ibizsys.paas.service.SessionFactoryManager
 *  net.ibizsys.paas.util.DataTypeHelper
 *  net.ibizsys.paas.util.JsonNodeHelper
 *  net.ibizsys.paas.util.StringHelper
 *  net.ibizsys.paas.xml.XmlNode
 *  net.sf.json.JSONObject
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 *  org.hibernate.SessionFactory
 */
package net.ibizsys.pscore.srv.sysdesign.service;

import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
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
import net.ibizsys.paas.service.IServicePlugin;
import net.ibizsys.paas.service.IServiceWork;
import net.ibizsys.paas.service.ITransaction;
import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.paas.service.SessionFactoryManager;
import net.ibizsys.paas.util.DataTypeHelper;
import net.ibizsys.paas.util.JsonNodeHelper;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.xml.XmlNode;
import net.ibizsys.pscore.srv.PSCoreSysServiceBase;
import net.ibizsys.pscore.srv.core.IPSDataEntityModel;
import net.ibizsys.pscore.srv.helpdesign.entity.PSHelpSection;
import net.ibizsys.pscore.srv.sysdesign.dao.PSCodeItemDAO;
import net.ibizsys.pscore.srv.sysdesign.demodel.PSCodeItemDEModel;
import net.ibizsys.pscore.srv.sysdesign.entity.PSCodeItem;
import net.ibizsys.pscore.srv.sysdesign.entity.PSCodeItemBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSCodeList;
import net.ibizsys.pscore.srv.sysdesign.entity.PSCodeListBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSLanguageRes;
import net.ibizsys.pscore.srv.sysdesign.entity.PSLanguageResBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysCss;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysCssBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysImage;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysImageBase;
import net.ibizsys.pscore.srv.sysdesign.service.PSCodeItemService;
import net.ibizsys.pscore.srv.sysdevstudio.entity.PSMOSFile;
import net.ibizsys.pscore.srv.util.IPSMOSFileAction;
import net.ibizsys.pscore.srv.util.IPSMOSFileFilter;
import net.ibizsys.pscore.srv.util.PSModelV2Helper;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSCodeItemServiceBase
extends PSCoreSysServiceBase<PSCodeItem> {
    private static final Log log = LogFactory.getLog(PSCodeItemServiceBase.class);
    public static final String DATASET_CURCL = "CurCL";
    public static final String DATASET_DEFAULT = "DEFAULT";
    public static final String ACTION_INITPSSYSIMAGE = "InitPSSysImage";
    private PSCodeItemDEModel pSCodeItemDEModel;
    private PSCodeItemDAO pSCodeItemDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.sysdesign.service.PSCodeItemService";
    }

    public PSCodeItemDEModel getPSCodeItemDEModel() {
        if (this.pSCodeItemDEModel == null) {
            try {
                this.pSCodeItemDEModel = (PSCodeItemDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.sysdesign.demodel.PSCodeItemDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSCodeItemDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSCodeItemDEModel();
    }

    public PSCodeItemDAO getPSCodeItemDAO() {
        if (this.pSCodeItemDAO == null) {
            try {
                this.pSCodeItemDAO = (PSCodeItemDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.sysdesign.dao.PSCodeItemDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSCodeItemDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSCodeItemDAO();
    }

    protected DBFetchResult onfetchDataSet(String string, IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        if (StringHelper.compare((String)string, (String)DATASET_CURCL, (boolean)true) == 0) {
            return this.fetchCurCL(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.fetchDefault(iDEDataSetFetchContext);
        }
        return super.onfetchDataSet(string, iDEDataSetFetchContext);
    }

    protected DBFetchResult onfetchDataSetTemp(String string, IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        if (StringHelper.compare((String)string, (String)DATASET_CURCL, (boolean)true) == 0) {
            return this.fetchTempCurCL(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.fetchTempDefault(iDEDataSetFetchContext);
        }
        return super.onfetchDataSetTemp(string, iDEDataSetFetchContext);
    }

    @Override
    protected void onExecuteAction(String string, IEntity iEntity) throws Exception {
        if (StringHelper.compare((String)string, (String)ACTION_INITPSSYSIMAGE, (boolean)true) == 0) {
            this.initPSSysImage((PSCodeItem)iEntity);
            return;
        }
        super.onExecuteAction(string, iEntity);
    }

    public DBFetchResult fetchCurCL(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CURCL, false);
        return dBFetchResult;
    }

    public DBFetchResult fetchTempCurCL(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CURCL, true);
        return dBFetchResult;
    }

    public DBFetchResult fetchDefault(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_DEFAULT, false);
        return dBFetchResult;
    }

    public DBFetchResult fetchTempDefault(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_DEFAULT, true);
        return dBFetchResult;
    }

    public void initPSSysImage(PSCodeItem pSCodeItem) throws Exception {
        final IServicePlugin iServicePlugin = this.getPlugin();
        if (iServicePlugin != null && iServicePlugin.doCustomAction((IService)this, ACTION_INITPSSYSIMAGE, 0, pSCodeItem, null).getResult() == 1) {
            return;
        }
        this.testDEMainStateAction(pSCodeItem, ACTION_INITPSSYSIMAGE);
        final PSCodeItem pSCodeItem2 = pSCodeItem;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                if (iServicePlugin == null || iServicePlugin.doCustomAction(PSCodeItemServiceBase.this.getService(), PSCodeItemServiceBase.ACTION_INITPSSYSIMAGE, 40, pSCodeItem2, null).getResult() != 1) {
                    PSCodeItemServiceBase.this.onInitPSSysImage(pSCodeItem2);
                }
            }
        });
        if (iServicePlugin != null) {
            iServicePlugin.doCustomAction((IService)this, ACTION_INITPSSYSIMAGE, 99, pSCodeItem, null);
        }
    }

    protected void onInitPSSysImage(PSCodeItem pSCodeItem) throws Exception {
        throw new Exception("\u6ca1\u6709\u5b9e\u73b0\u81ea\u5b9a\u4e49\u884c\u4e3a[InitPSSysImage]");
    }

    protected void onFillParentInfo(PSCodeItem pSCodeItem, String string, String string2, String string3) throws Exception {
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSCODEITEM_PSCODEITEM_PPSCODEITEMID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSCodeItemService", (SessionFactory)this.getSessionFactory());
            PSCodeItem pSCodeItem2 = (PSCodeItem)iService.getDEModel().createEntity();
            pSCodeItem2.set("PSCODEITEMID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSCodeItem2);
            } else {
                iService.get(pSCodeItem2);
            }
            this.onFillParentInfo_PPSCodeItem(pSCodeItem, pSCodeItem2);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSCODEITEM_PSCODELIST_PSCODELISTID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSCodeListService", (SessionFactory)this.getSessionFactory());
            PSCodeList pSCodeList = (PSCodeList)iService.getDEModel().createEntity();
            pSCodeList.set("PSCODELISTID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSCodeList);
            } else {
                iService.get(pSCodeList);
            }
            this.onFillParentInfo_PSCodeList(pSCodeItem, pSCodeList);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSCODEITEM_PSLANGUAGERES_TEXTPSLANRESID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSLanguageResService", (SessionFactory)this.getSessionFactory());
            PSLanguageRes pSLanguageRes = (PSLanguageRes)iService.getDEModel().createEntity();
            pSLanguageRes.set("PSLANGUAGERESID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSLanguageRes);
            } else {
                iService.get(pSLanguageRes);
            }
            this.onFillParentInfo_TextPSLanRes(pSCodeItem, pSLanguageRes);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSCODEITEM_PSLANGUAGERES_TIPPSLANRESID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSLanguageResService", (SessionFactory)this.getSessionFactory());
            PSLanguageRes pSLanguageRes = (PSLanguageRes)iService.getDEModel().createEntity();
            pSLanguageRes.set("PSLANGUAGERESID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSLanguageRes);
            } else {
                iService.get(pSLanguageRes);
            }
            this.onFillParentInfo_TipPSLanRes(pSCodeItem, pSLanguageRes);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSCODEITEM_PSSYSCSS_PSSYSCSSID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysCssService", (SessionFactory)this.getSessionFactory());
            PSSysCss pSSysCss = (PSSysCss)iService.getDEModel().createEntity();
            pSSysCss.set("PSSYSCSSID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSSysCss);
            } else {
                iService.get(pSSysCss);
            }
            this.onFillParentInfo_PSSysCss(pSCodeItem, pSSysCss);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSCODEITEM_PSSYSIMAGE_PSSYSIMAGEID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysImageService", (SessionFactory)this.getSessionFactory());
            PSSysImage pSSysImage = (PSSysImage)iService.getDEModel().createEntity();
            pSSysImage.set("PSSYSIMAGEID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSSysImage);
            } else {
                iService.get(pSSysImage);
            }
            this.onFillParentInfo_PSSysImage(pSCodeItem, pSSysImage);
            return;
        }
        super.onFillParentInfo(pSCodeItem, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        if (StringHelper.compare((String)string, (String)"DER1N_PSCODEITEM_PSCODELIST_PSCODELISTID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSCodeListService", (SessionFactory)this.getSessionFactory());
            PSCodeList pSCodeList = (PSCodeList)iService.getDEModel().createEntity();
            pSCodeList.set("PSCODELISTID", string2);
            return this.onSyncDER1NData_PSCodeList(pSCodeList, string3);
        }
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillParentInfo_PPSCodeItem(PSCodeItem pSCodeItem, PSCodeItem pSCodeItem2) throws Exception {
        pSCodeItem.setPPSCodeItemId(pSCodeItem2.getPSCodeItemId());
        pSCodeItem.setPPSCodeItemName(pSCodeItem2.getPSCodeItemName());
        if (pSCodeItem2.getPSCodeList() != null) {
            this.onFillParentInfo_PSCodeList(pSCodeItem, pSCodeItem2.getPSCodeList());
        }
    }

    protected void onFillParentInfo_PSCodeList(PSCodeItem pSCodeItem, PSCodeList pSCodeList) throws Exception {
        pSCodeItem.setPSCodeListId(pSCodeList.getPSCodeListId());
        pSCodeItem.setPSCodeListName(pSCodeList.getPSCodeListName());
        pSCodeItem.setThresholdGroupFlag(pSCodeList.getThresholdGroupFlag());
    }

    protected String onSyncDER1NData_PSCodeList(PSCodeList pSCodeList, String string) throws Exception {
        if (StringHelper.isNullOrEmpty((String)string)) {
            this.removeByPSCodeList(pSCodeList);
        } else {
            HashMap<String, String> hashMap = new HashMap<String, String>();
            String[] stringArray = StringHelper.splitEx((String)string);
            if (stringArray != null) {
                for (int i = 0; i < stringArray.length; ++i) {
                    if (StringHelper.isNullOrEmpty((String)stringArray[i])) continue;
                    hashMap.put(stringArray[i], "");
                }
            }
            ArrayList<PSCodeItem> arrayList = this.selectByPSCodeList(pSCodeList);
            for (PSCodeItem pSCodeItem : arrayList) {
                if (hashMap.containsKey(DataObject.getStringValue((IDataObject)pSCodeItem, (String)"PSCODEITEMID", (String)""))) continue;
                this.remove(pSCodeItem);
            }
        }
        return null;
    }

    protected void onFillParentInfo_TextPSLanRes(PSCodeItem pSCodeItem, PSLanguageRes pSLanguageRes) throws Exception {
        pSCodeItem.setTextPSLanResId(pSLanguageRes.getPSLanguageResId());
        pSCodeItem.setTextPSLanResName(pSLanguageRes.getPSLanguageResName());
    }

    protected void onFillParentInfo_TipPSLanRes(PSCodeItem pSCodeItem, PSLanguageRes pSLanguageRes) throws Exception {
        pSCodeItem.setTipPSLanResId(pSLanguageRes.getPSLanguageResId());
        pSCodeItem.setTipPSLanResName(pSLanguageRes.getPSLanguageResName());
    }

    protected void onFillParentInfo_PSSysCss(PSCodeItem pSCodeItem, PSSysCss pSSysCss) throws Exception {
        pSCodeItem.setPSSysCssId(pSSysCss.getPSSysCssId());
        pSCodeItem.setPSSysCssName(pSSysCss.getPSSysCssName());
    }

    protected void onFillParentInfo_PSSysImage(PSCodeItem pSCodeItem, PSSysImage pSSysImage) throws Exception {
        pSCodeItem.setPSSysImageId(pSSysImage.getPSSysImageId());
        pSCodeItem.setPSSysImageName(pSSysImage.getPSSysImageName());
    }

    protected void onFillEntityFullInfo(PSCodeItem pSCodeItem, boolean bl) throws Exception {
        if (bl) {
            if (pSCodeItem.getDefaultFlag() == null) {
                pSCodeItem.setDefaultFlag((Integer)this.getDefaultValue(this.getWebContext(), "", "0", 9));
            }
            if (pSCodeItem.getValidFlag() == null) {
                pSCodeItem.setValidFlag((Integer)this.getDefaultValue(this.getWebContext(), "", "1", 9));
            }
        }
        super.onFillEntityFullInfo(pSCodeItem, bl);
        this.onFillEntityFullInfo_PPSCodeItem(pSCodeItem, bl);
        this.onFillEntityFullInfo_PSCodeList(pSCodeItem, bl);
        this.onFillEntityFullInfo_TextPSLanRes(pSCodeItem, bl);
        this.onFillEntityFullInfo_TipPSLanRes(pSCodeItem, bl);
        this.onFillEntityFullInfo_PSSysCss(pSCodeItem, bl);
        this.onFillEntityFullInfo_PSSysImage(pSCodeItem, bl);
    }

    protected void onFillEntityFullInfo_PPSCodeItem(PSCodeItem pSCodeItem, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSCodeList(PSCodeItem pSCodeItem, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_TextPSLanRes(PSCodeItem pSCodeItem, boolean bl) throws Exception {
        if (pSCodeItem.isTextPSLanResIdDirty()) {
            if (pSCodeItem.getTextPSLanResId() != null) {
                if (pSCodeItem.getTextPSLanResId() == null || pSCodeItem.getTextPSLanResName() == null) {
                    PSLanguageRes pSLanguageRes = pSCodeItem.getTextPSLanRes();
                    pSCodeItem.setTextPSLanResName(pSLanguageRes.getPSLanguageResName());
                }
            } else {
                pSCodeItem.setTextPSLanResName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_TipPSLanRes(PSCodeItem pSCodeItem, boolean bl) throws Exception {
        if (pSCodeItem.isTipPSLanResIdDirty()) {
            if (pSCodeItem.getTipPSLanResId() != null) {
                if (pSCodeItem.getTipPSLanResId() == null || pSCodeItem.getTipPSLanResName() == null) {
                    PSLanguageRes pSLanguageRes = pSCodeItem.getTipPSLanRes();
                    pSCodeItem.setTipPSLanResName(pSLanguageRes.getPSLanguageResName());
                }
            } else {
                pSCodeItem.setTipPSLanResName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_PSSysCss(PSCodeItem pSCodeItem, boolean bl) throws Exception {
        if (pSCodeItem.isPSSysCssIdDirty()) {
            if (pSCodeItem.getPSSysCssId() != null) {
                if (pSCodeItem.getPSSysCssId() == null || pSCodeItem.getPSSysCssName() == null) {
                    PSSysCss pSSysCss = pSCodeItem.getPSSysCss();
                    pSCodeItem.setPSSysCssName(pSSysCss.getPSSysCssName());
                }
            } else {
                pSCodeItem.setPSSysCssName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_PSSysImage(PSCodeItem pSCodeItem, boolean bl) throws Exception {
    }

    protected void onWriteBackParent(PSCodeItem pSCodeItem, boolean bl) throws Exception {
        super.onWriteBackParent(pSCodeItem, bl);
    }

    public ArrayList<PSCodeItem> selectByPPSCodeItem(PSCodeItemBase pSCodeItemBase) throws Exception {
        return this.selectByPPSCodeItem(pSCodeItemBase, "", -1);
    }

    public ArrayList<PSCodeItem> selectByPPSCodeItem(PSCodeItemBase pSCodeItemBase, String string) throws Exception {
        return this.selectByPPSCodeItem(pSCodeItemBase, string, -1);
    }

    public ArrayList<PSCodeItem> selectByPPSCodeItem(PSCodeItemBase pSCodeItemBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PPSCODEITEMID", (Object)pSCodeItemBase.getPSCodeItemId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPPSCodeItemCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPPSCodeItemCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSCodeItem> selectTempByPPSCodeItem(PSCodeItemBase pSCodeItemBase) throws Exception {
        return this.selectTempByPPSCodeItem(pSCodeItemBase, "");
    }

    public ArrayList<PSCodeItem> selectTempByPPSCodeItem(PSCodeItemBase pSCodeItemBase, String string) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PPSCODEITEMID", (Object)pSCodeItemBase.getPSCodeItemId());
        selectCond.setOrderInfo(string);
        this.onFillSelectTempByPPSCodeItemCond(selectCond);
        return this.selectTemp((ISelectCond)selectCond);
    }

    protected void onFillSelectTempByPPSCodeItemCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSCodeItem> selectByPSCodeList(PSCodeListBase pSCodeListBase) throws Exception {
        return this.selectByPSCodeList(pSCodeListBase, "", -1);
    }

    public ArrayList<PSCodeItem> selectByPSCodeList(PSCodeListBase pSCodeListBase, String string) throws Exception {
        return this.selectByPSCodeList(pSCodeListBase, string, -1);
    }

    public ArrayList<PSCodeItem> selectByPSCodeList(PSCodeListBase pSCodeListBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSCODELISTID", (Object)pSCodeListBase.getPSCodeListId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSCodeListCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSCodeListCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSCodeItem> selectTempByPSCodeList(PSCodeListBase pSCodeListBase) throws Exception {
        return this.selectTempByPSCodeList(pSCodeListBase, "");
    }

    public ArrayList<PSCodeItem> selectTempByPSCodeList(PSCodeListBase pSCodeListBase, String string) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSCODELISTID", (Object)pSCodeListBase.getPSCodeListId());
        selectCond.setOrderInfo(string);
        this.onFillSelectTempByPSCodeListCond(selectCond);
        return this.selectTemp((ISelectCond)selectCond);
    }

    protected void onFillSelectTempByPSCodeListCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSCodeItem> selectByTextPSLanRes(PSLanguageResBase pSLanguageResBase) throws Exception {
        return this.selectByTextPSLanRes(pSLanguageResBase, "", -1);
    }

    public ArrayList<PSCodeItem> selectByTextPSLanRes(PSLanguageResBase pSLanguageResBase, String string) throws Exception {
        return this.selectByTextPSLanRes(pSLanguageResBase, string, -1);
    }

    public ArrayList<PSCodeItem> selectByTextPSLanRes(PSLanguageResBase pSLanguageResBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("TEXTPSLANRESID", (Object)pSLanguageResBase.getPSLanguageResId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByTextPSLanResCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByTextPSLanResCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSCodeItem> selectByTipPSLanRes(PSLanguageResBase pSLanguageResBase) throws Exception {
        return this.selectByTipPSLanRes(pSLanguageResBase, "", -1);
    }

    public ArrayList<PSCodeItem> selectByTipPSLanRes(PSLanguageResBase pSLanguageResBase, String string) throws Exception {
        return this.selectByTipPSLanRes(pSLanguageResBase, string, -1);
    }

    public ArrayList<PSCodeItem> selectByTipPSLanRes(PSLanguageResBase pSLanguageResBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("TIPPSLANRESID", (Object)pSLanguageResBase.getPSLanguageResId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByTipPSLanResCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByTipPSLanResCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSCodeItem> selectByPSSysCss(PSSysCssBase pSSysCssBase) throws Exception {
        return this.selectByPSSysCss(pSSysCssBase, "", -1);
    }

    public ArrayList<PSCodeItem> selectByPSSysCss(PSSysCssBase pSSysCssBase, String string) throws Exception {
        return this.selectByPSSysCss(pSSysCssBase, string, -1);
    }

    public ArrayList<PSCodeItem> selectByPSSysCss(PSSysCssBase pSSysCssBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSSYSCSSID", (Object)pSSysCssBase.getPSSysCssId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSSysCssCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSSysCssCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSCodeItem> selectByPSSysImage(PSSysImageBase pSSysImageBase) throws Exception {
        return this.selectByPSSysImage(pSSysImageBase, "", -1);
    }

    public ArrayList<PSCodeItem> selectByPSSysImage(PSSysImageBase pSSysImageBase, String string) throws Exception {
        return this.selectByPSSysImage(pSSysImageBase, string, -1);
    }

    public ArrayList<PSCodeItem> selectByPSSysImage(PSSysImageBase pSSysImageBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSSYSIMAGEID", (Object)pSSysImageBase.getPSSysImageId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSSysImageCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSSysImageCond(SelectCond selectCond) throws Exception {
    }

    public void testRemoveByPPSCodeItem(PSCodeItem pSCodeItem) throws Exception {
    }

    public void resetPPSCodeItem(PSCodeItem pSCodeItem) throws Exception {
        ArrayList<PSCodeItem> arrayList = this.selectByPPSCodeItem(pSCodeItem);
        for (PSCodeItem pSCodeItem2 : arrayList) {
            PSCodeItem pSCodeItem3 = (PSCodeItem)this.getDEModel().createEntity();
            pSCodeItem3.setPSCodeItemId(pSCodeItem2.getPSCodeItemId());
            pSCodeItem3.setPPSCodeItemId(null);
            this.update(pSCodeItem3);
        }
    }

    public void resetTempPPSCodeItem(PSCodeItem pSCodeItem) throws Exception {
        ArrayList<PSCodeItem> arrayList = this.selectTempByPPSCodeItem(pSCodeItem);
        for (PSCodeItem pSCodeItem2 : arrayList) {
            PSCodeItem pSCodeItem3 = (PSCodeItem)this.getDEModel().createEntity();
            pSCodeItem3.setPSCodeItemId(pSCodeItem2.getPSCodeItemId());
            pSCodeItem3.setPPSCodeItemId(null);
            this.updateTemp(pSCodeItem3);
        }
    }

    public void removeByPPSCodeItem(PSCodeItem pSCodeItem) throws Exception {
        final PSCodeItem pSCodeItem2 = pSCodeItem;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSCodeItemServiceBase.this.onBeforeRemoveByPPSCodeItem(pSCodeItem2);
                PSCodeItemServiceBase.this.internalRemoveByPPSCodeItem(pSCodeItem2);
                PSCodeItemServiceBase.this.onAfterRemoveByPPSCodeItem(pSCodeItem2);
            }
        });
    }

    protected void onBeforeRemoveByPPSCodeItem(PSCodeItem pSCodeItem) throws Exception {
    }

    protected void internalRemoveByPPSCodeItem(PSCodeItem pSCodeItem) throws Exception {
        ArrayList<PSCodeItem> arrayList = this.selectByPPSCodeItem(pSCodeItem);
        this.onBeforeRemoveByPPSCodeItem(pSCodeItem, arrayList);
        for (PSCodeItem pSCodeItem2 : arrayList) {
            this.remove(pSCodeItem2);
        }
        this.onAfterRemoveByPPSCodeItem(pSCodeItem, arrayList);
    }

    protected void onAfterRemoveByPPSCodeItem(PSCodeItem pSCodeItem) throws Exception {
    }

    protected void onBeforeRemoveByPPSCodeItem(PSCodeItem pSCodeItem, ArrayList<PSCodeItem> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPPSCodeItem(PSCodeItem pSCodeItem, ArrayList<PSCodeItem> arrayList) throws Exception {
    }

    public void testRemoveByPSCodeList(PSCodeList pSCodeList) throws Exception {
    }

    public void resetPSCodeList(PSCodeList pSCodeList) throws Exception {
        ArrayList<PSCodeItem> arrayList = this.selectByPSCodeList(pSCodeList);
        for (PSCodeItem pSCodeItem : arrayList) {
            PSCodeItem pSCodeItem2 = (PSCodeItem)this.getDEModel().createEntity();
            pSCodeItem2.setPSCodeItemId(pSCodeItem.getPSCodeItemId());
            pSCodeItem2.setPSCodeListId(null);
            this.update(pSCodeItem2);
        }
    }

    public void resetTempPSCodeList(PSCodeList pSCodeList) throws Exception {
        ArrayList<PSCodeItem> arrayList = this.selectTempByPSCodeList(pSCodeList);
        for (PSCodeItem pSCodeItem : arrayList) {
            PSCodeItem pSCodeItem2 = (PSCodeItem)this.getDEModel().createEntity();
            pSCodeItem2.setPSCodeItemId(pSCodeItem.getPSCodeItemId());
            pSCodeItem2.setPSCodeListId(null);
            this.updateTemp(pSCodeItem2);
        }
    }

    public void removeByPSCodeList(PSCodeList pSCodeList) throws Exception {
        final PSCodeList pSCodeList2 = pSCodeList;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSCodeItemServiceBase.this.onBeforeRemoveByPSCodeList(pSCodeList2);
                PSCodeItemServiceBase.this.internalRemoveByPSCodeList(pSCodeList2);
                PSCodeItemServiceBase.this.onAfterRemoveByPSCodeList(pSCodeList2);
            }
        });
    }

    protected void onBeforeRemoveByPSCodeList(PSCodeList pSCodeList) throws Exception {
    }

    protected void internalRemoveByPSCodeList(PSCodeList pSCodeList) throws Exception {
        ArrayList<PSCodeItem> arrayList = this.selectByPSCodeList(pSCodeList);
        this.onBeforeRemoveByPSCodeList(pSCodeList, arrayList);
        for (PSCodeItem pSCodeItem : arrayList) {
            this.remove(pSCodeItem);
        }
        this.onAfterRemoveByPSCodeList(pSCodeList, arrayList);
    }

    protected void onAfterRemoveByPSCodeList(PSCodeList pSCodeList) throws Exception {
    }

    protected void onBeforeRemoveByPSCodeList(PSCodeList pSCodeList, ArrayList<PSCodeItem> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSCodeList(PSCodeList pSCodeList, ArrayList<PSCodeItem> arrayList) throws Exception {
    }

    public void testRemoveByTextPSLanRes(PSLanguageRes pSLanguageRes) throws Exception {
        ArrayList<PSCodeItem> arrayList = this.selectByTextPSLanRes(pSLanguageRes, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSLANGUAGERES");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSLanguageRes);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSCODEITEM_PSLANGUAGERES_TEXTPSLANRESID", "", iDataEntityModel.getName(), "PSCODEITEM", iDataEntityModel.getDataInfo(pSLanguageRes), arrayList.get(0)));
        }
    }

    public void resetTextPSLanRes(PSLanguageRes pSLanguageRes) throws Exception {
        ArrayList<PSCodeItem> arrayList = this.selectByTextPSLanRes(pSLanguageRes);
        for (PSCodeItem pSCodeItem : arrayList) {
            PSCodeItem pSCodeItem2 = (PSCodeItem)this.getDEModel().createEntity();
            pSCodeItem2.setPSCodeItemId(pSCodeItem.getPSCodeItemId());
            pSCodeItem2.setTextPSLanResId(null);
            this.update(pSCodeItem2);
        }
    }

    public void removeByTextPSLanRes(PSLanguageRes pSLanguageRes) throws Exception {
        final PSLanguageRes pSLanguageRes2 = pSLanguageRes;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSCodeItemServiceBase.this.onBeforeRemoveByTextPSLanRes(pSLanguageRes2);
                PSCodeItemServiceBase.this.internalRemoveByTextPSLanRes(pSLanguageRes2);
                PSCodeItemServiceBase.this.onAfterRemoveByTextPSLanRes(pSLanguageRes2);
            }
        });
    }

    protected void onBeforeRemoveByTextPSLanRes(PSLanguageRes pSLanguageRes) throws Exception {
    }

    protected void internalRemoveByTextPSLanRes(PSLanguageRes pSLanguageRes) throws Exception {
        ArrayList<PSCodeItem> arrayList = this.selectByTextPSLanRes(pSLanguageRes);
        this.onBeforeRemoveByTextPSLanRes(pSLanguageRes, arrayList);
        for (PSCodeItem pSCodeItem : arrayList) {
            this.remove(pSCodeItem);
        }
        this.onAfterRemoveByTextPSLanRes(pSLanguageRes, arrayList);
    }

    protected void onAfterRemoveByTextPSLanRes(PSLanguageRes pSLanguageRes) throws Exception {
    }

    protected void onBeforeRemoveByTextPSLanRes(PSLanguageRes pSLanguageRes, ArrayList<PSCodeItem> arrayList) throws Exception {
    }

    protected void onAfterRemoveByTextPSLanRes(PSLanguageRes pSLanguageRes, ArrayList<PSCodeItem> arrayList) throws Exception {
    }

    public void testRemoveByTipPSLanRes(PSLanguageRes pSLanguageRes) throws Exception {
        ArrayList<PSCodeItem> arrayList = this.selectByTipPSLanRes(pSLanguageRes, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSLANGUAGERES");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSLanguageRes);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSCODEITEM_PSLANGUAGERES_TIPPSLANRESID", "", iDataEntityModel.getName(), "PSCODEITEM", iDataEntityModel.getDataInfo(pSLanguageRes), arrayList.get(0)));
        }
    }

    public void resetTipPSLanRes(PSLanguageRes pSLanguageRes) throws Exception {
        ArrayList<PSCodeItem> arrayList = this.selectByTipPSLanRes(pSLanguageRes);
        for (PSCodeItem pSCodeItem : arrayList) {
            PSCodeItem pSCodeItem2 = (PSCodeItem)this.getDEModel().createEntity();
            pSCodeItem2.setPSCodeItemId(pSCodeItem.getPSCodeItemId());
            pSCodeItem2.setTipPSLanResId(null);
            this.update(pSCodeItem2);
        }
    }

    public void removeByTipPSLanRes(PSLanguageRes pSLanguageRes) throws Exception {
        final PSLanguageRes pSLanguageRes2 = pSLanguageRes;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSCodeItemServiceBase.this.onBeforeRemoveByTipPSLanRes(pSLanguageRes2);
                PSCodeItemServiceBase.this.internalRemoveByTipPSLanRes(pSLanguageRes2);
                PSCodeItemServiceBase.this.onAfterRemoveByTipPSLanRes(pSLanguageRes2);
            }
        });
    }

    protected void onBeforeRemoveByTipPSLanRes(PSLanguageRes pSLanguageRes) throws Exception {
    }

    protected void internalRemoveByTipPSLanRes(PSLanguageRes pSLanguageRes) throws Exception {
        ArrayList<PSCodeItem> arrayList = this.selectByTipPSLanRes(pSLanguageRes);
        this.onBeforeRemoveByTipPSLanRes(pSLanguageRes, arrayList);
        for (PSCodeItem pSCodeItem : arrayList) {
            this.remove(pSCodeItem);
        }
        this.onAfterRemoveByTipPSLanRes(pSLanguageRes, arrayList);
    }

    protected void onAfterRemoveByTipPSLanRes(PSLanguageRes pSLanguageRes) throws Exception {
    }

    protected void onBeforeRemoveByTipPSLanRes(PSLanguageRes pSLanguageRes, ArrayList<PSCodeItem> arrayList) throws Exception {
    }

    protected void onAfterRemoveByTipPSLanRes(PSLanguageRes pSLanguageRes, ArrayList<PSCodeItem> arrayList) throws Exception {
    }

    public void testRemoveByPSSysCss(PSSysCss pSSysCss) throws Exception {
        ArrayList<PSCodeItem> arrayList = this.selectByPSSysCss(pSSysCss, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSCSS");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSSysCss);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSCODEITEM_PSSYSCSS_PSSYSCSSID", "", iDataEntityModel.getName(), "PSCODEITEM", iDataEntityModel.getDataInfo(pSSysCss), arrayList.get(0)));
        }
    }

    public void resetPSSysCss(PSSysCss pSSysCss) throws Exception {
        ArrayList<PSCodeItem> arrayList = this.selectByPSSysCss(pSSysCss);
        for (PSCodeItem pSCodeItem : arrayList) {
            PSCodeItem pSCodeItem2 = (PSCodeItem)this.getDEModel().createEntity();
            pSCodeItem2.setPSCodeItemId(pSCodeItem.getPSCodeItemId());
            pSCodeItem2.setPSSysCssId(null);
            this.update(pSCodeItem2);
        }
    }

    public void removeByPSSysCss(PSSysCss pSSysCss) throws Exception {
        final PSSysCss pSSysCss2 = pSSysCss;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSCodeItemServiceBase.this.onBeforeRemoveByPSSysCss(pSSysCss2);
                PSCodeItemServiceBase.this.internalRemoveByPSSysCss(pSSysCss2);
                PSCodeItemServiceBase.this.onAfterRemoveByPSSysCss(pSSysCss2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysCss(PSSysCss pSSysCss) throws Exception {
    }

    protected void internalRemoveByPSSysCss(PSSysCss pSSysCss) throws Exception {
        ArrayList<PSCodeItem> arrayList = this.selectByPSSysCss(pSSysCss);
        this.onBeforeRemoveByPSSysCss(pSSysCss, arrayList);
        for (PSCodeItem pSCodeItem : arrayList) {
            this.remove(pSCodeItem);
        }
        this.onAfterRemoveByPSSysCss(pSSysCss, arrayList);
    }

    protected void onAfterRemoveByPSSysCss(PSSysCss pSSysCss) throws Exception {
    }

    protected void onBeforeRemoveByPSSysCss(PSSysCss pSSysCss, ArrayList<PSCodeItem> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysCss(PSSysCss pSSysCss, ArrayList<PSCodeItem> arrayList) throws Exception {
    }

    public void testRemoveByPSSysImage(PSSysImage pSSysImage) throws Exception {
        ArrayList<PSCodeItem> arrayList = this.selectByPSSysImage(pSSysImage, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSIMAGE");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSSysImage);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSCODEITEM_PSSYSIMAGE_PSSYSIMAGEID", "", iDataEntityModel.getName(), "PSCODEITEM", iDataEntityModel.getDataInfo(pSSysImage), arrayList.get(0)));
        }
    }

    public void resetPSSysImage(PSSysImage pSSysImage) throws Exception {
        ArrayList<PSCodeItem> arrayList = this.selectByPSSysImage(pSSysImage);
        for (PSCodeItem pSCodeItem : arrayList) {
            PSCodeItem pSCodeItem2 = (PSCodeItem)this.getDEModel().createEntity();
            pSCodeItem2.setPSCodeItemId(pSCodeItem.getPSCodeItemId());
            pSCodeItem2.setPSSysImageId(null);
            this.update(pSCodeItem2);
        }
    }

    public void removeByPSSysImage(PSSysImage pSSysImage) throws Exception {
        final PSSysImage pSSysImage2 = pSSysImage;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSCodeItemServiceBase.this.onBeforeRemoveByPSSysImage(pSSysImage2);
                PSCodeItemServiceBase.this.internalRemoveByPSSysImage(pSSysImage2);
                PSCodeItemServiceBase.this.onAfterRemoveByPSSysImage(pSSysImage2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysImage(PSSysImage pSSysImage) throws Exception {
    }

    protected void internalRemoveByPSSysImage(PSSysImage pSSysImage) throws Exception {
        ArrayList<PSCodeItem> arrayList = this.selectByPSSysImage(pSSysImage);
        this.onBeforeRemoveByPSSysImage(pSSysImage, arrayList);
        for (PSCodeItem pSCodeItem : arrayList) {
            this.remove(pSCodeItem);
        }
        this.onAfterRemoveByPSSysImage(pSSysImage, arrayList);
    }

    protected void onAfterRemoveByPSSysImage(PSSysImage pSSysImage) throws Exception {
    }

    protected void onBeforeRemoveByPSSysImage(PSSysImage pSSysImage, ArrayList<PSCodeItem> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysImage(PSSysImage pSSysImage, ArrayList<PSCodeItem> arrayList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(PSCodeItem pSCodeItem) throws Exception {
        PSCodeItemService pSCodeItemService = (PSCodeItemService)ServiceGlobal.getService(PSCodeItemService.class, (SessionFactory)this.getSessionFactory());
        pSCodeItemService.testRemoveByPPSCodeItem(pSCodeItem);
        pSCodeItemService.removeByPPSCodeItem(pSCodeItem);
        super.onBeforeRemove(pSCodeItem);
    }

    protected void onBeforeRemoveTemp(PSCodeItem pSCodeItem) throws Exception {
        PSCodeItemService pSCodeItemService = (PSCodeItemService)ServiceGlobal.getService(PSCodeItemService.class, (SessionFactory)this.getSessionFactory());
        pSCodeItemService.resetTempPPSCodeItem(pSCodeItem);
        super.onBeforeRemoveTemp(pSCodeItem);
    }

    public void removeTempByPPSCodeItem(PSCodeItem pSCodeItem) throws Exception {
        final PSCodeItem pSCodeItem2 = pSCodeItem;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSCodeItemServiceBase.this.onBeforeRemoveTempByPPSCodeItem(pSCodeItem2);
                PSCodeItemServiceBase.this.internalRemoveTempByPPSCodeItem(pSCodeItem2);
                PSCodeItemServiceBase.this.onAfterRemoveTempByPPSCodeItem(pSCodeItem2);
            }
        });
    }

    protected void onBeforeRemoveTempByPPSCodeItem(PSCodeItem pSCodeItem) throws Exception {
    }

    protected void internalRemoveTempByPPSCodeItem(PSCodeItem pSCodeItem) throws Exception {
        ArrayList<PSCodeItem> arrayList = this.selectTempByPPSCodeItem(pSCodeItem);
        this.onBeforeRemoveTempByPPSCodeItem(pSCodeItem, arrayList);
        for (PSCodeItem pSCodeItem2 : arrayList) {
            this.removeTemp(pSCodeItem2);
        }
        this.onAfterRemoveTempByPPSCodeItem(pSCodeItem, arrayList);
    }

    protected void onAfterRemoveTempByPPSCodeItem(PSCodeItem pSCodeItem) throws Exception {
    }

    protected void onBeforeRemoveTempByPPSCodeItem(PSCodeItem pSCodeItem, ArrayList<PSCodeItem> arrayList) throws Exception {
    }

    protected void onAfterRemoveTempByPPSCodeItem(PSCodeItem pSCodeItem, ArrayList<PSCodeItem> arrayList) throws Exception {
    }

    public void removeTempByPSCodeList(PSCodeList pSCodeList) throws Exception {
        final PSCodeList pSCodeList2 = pSCodeList;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSCodeItemServiceBase.this.onBeforeRemoveTempByPSCodeList(pSCodeList2);
                PSCodeItemServiceBase.this.internalRemoveTempByPSCodeList(pSCodeList2);
                PSCodeItemServiceBase.this.onAfterRemoveTempByPSCodeList(pSCodeList2);
            }
        });
    }

    protected void onBeforeRemoveTempByPSCodeList(PSCodeList pSCodeList) throws Exception {
    }

    protected void internalRemoveTempByPSCodeList(PSCodeList pSCodeList) throws Exception {
        ArrayList<PSCodeItem> arrayList = this.selectTempByPSCodeList(pSCodeList);
        this.onBeforeRemoveTempByPSCodeList(pSCodeList, arrayList);
        for (PSCodeItem pSCodeItem : arrayList) {
            this.removeTemp(pSCodeItem);
        }
        this.onAfterRemoveTempByPSCodeList(pSCodeList, arrayList);
    }

    protected void onAfterRemoveTempByPSCodeList(PSCodeList pSCodeList) throws Exception {
    }

    protected void onBeforeRemoveTempByPSCodeList(PSCodeList pSCodeList, ArrayList<PSCodeItem> arrayList) throws Exception {
    }

    protected void onAfterRemoveTempByPSCodeList(PSCodeList pSCodeList, ArrayList<PSCodeItem> arrayList) throws Exception {
    }

    protected void getRelatedDataTempMajor(PSCodeItem pSCodeItem) throws Exception {
        super.getRelatedDataTempMajor(pSCodeItem);
    }

    protected void updateRelatedDataTempMajor(PSCodeItem pSCodeItem, PSCodeItem pSCodeItem2) throws Exception {
        super.updateRelatedDataTempMajor(pSCodeItem, pSCodeItem2);
    }

    protected void replaceParentInfo(PSCodeItem pSCodeItem, CloneSession cloneSession) throws Exception {
        IEntity iEntity;
        super.replaceParentInfo(pSCodeItem, cloneSession);
        if (pSCodeItem.getPPSCodeItemId() != null && (iEntity = cloneSession.getEntity("PSCODEITEM", (Object)pSCodeItem.getPPSCodeItemId())) != null) {
            this.onFillParentInfo_PPSCodeItem(pSCodeItem, (PSCodeItem)iEntity);
        }
        if (pSCodeItem.getPSCodeListId() != null && (iEntity = cloneSession.getEntity("PSCODELIST", (Object)pSCodeItem.getPSCodeListId())) != null) {
            this.onFillParentInfo_PSCodeList(pSCodeItem, (PSCodeList)iEntity);
        }
        if (pSCodeItem.getTextPSLanResId() != null && (iEntity = cloneSession.getEntity("PSLANGUAGERES", (Object)pSCodeItem.getTextPSLanResId())) != null) {
            this.onFillParentInfo_TextPSLanRes(pSCodeItem, (PSLanguageRes)iEntity);
        }
        if (pSCodeItem.getTipPSLanResId() != null && (iEntity = cloneSession.getEntity("PSLANGUAGERES", (Object)pSCodeItem.getTipPSLanResId())) != null) {
            this.onFillParentInfo_TipPSLanRes(pSCodeItem, (PSLanguageRes)iEntity);
        }
        if (pSCodeItem.getPSSysCssId() != null && (iEntity = cloneSession.getEntity("PSSYSCSS", (Object)pSCodeItem.getPSSysCssId())) != null) {
            this.onFillParentInfo_PSSysCss(pSCodeItem, (PSSysCss)iEntity);
        }
        if (pSCodeItem.getPSSysImageId() != null && (iEntity = cloneSession.getEntity("PSSYSIMAGE", (Object)pSCodeItem.getPSSysImageId())) != null) {
            this.onFillParentInfo_PSSysImage(pSCodeItem, (PSSysImage)iEntity);
        }
    }

    protected void onRemoveEntityUncopyValues(PSCodeItem pSCodeItem, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues(pSCodeItem, bl);
    }

    protected void onCheckEntity(boolean bl, PSCodeItem pSCodeItem, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_BeginValue(bl, pSCodeItem, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_BKColor(bl, pSCodeItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_CodeItemValue(bl, pSCodeItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_CodeName(bl, pSCodeItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Color(bl, pSCodeItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_CssClass(bl, pSCodeItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Data(bl, pSCodeItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_DefaultFlag(bl, pSCodeItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_DisableSelect(bl, pSCodeItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_DynaModelFlag(bl, pSCodeItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_EndValue(bl, pSCodeItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_IconCls(bl, pSCodeItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_IncBeginValue(bl, pSCodeItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_IncEndValue(bl, pSCodeItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_LevelTag(bl, pSCodeItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_LevelValue(bl, pSCodeItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Memo(bl, pSCodeItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_OrderValue(bl, pSCodeItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PPSCodeItemId(bl, pSCodeItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSCodeItemId(bl, pSCodeItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSCodeItemName(bl, pSCodeItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSCodeListId(bl, pSCodeItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDynaInstId(bl, pSCodeItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysCssId(bl, pSCodeItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysCssName(bl, pSCodeItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysImageId(bl, pSCodeItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ShortKey(bl, pSCodeItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ShowAsAll(bl, pSCodeItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ShowAsEmpty(bl, pSCodeItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_TextPSLanResId(bl, pSCodeItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_TextPSLanResName(bl, pSCodeItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_TipPSLanResId(bl, pSCodeItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_TipPSLanResName(bl, pSCodeItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_TooltipInfo(bl, pSCodeItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserCat(bl, pSCodeItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserData(bl, pSCodeItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserData2(bl, pSCodeItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserParams(bl, pSCodeItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag(bl, pSCodeItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag2(bl, pSCodeItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag3(bl, pSCodeItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag4(bl, pSCodeItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ValidFlag(bl, pSCodeItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, pSCodeItem, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_BeginValue(boolean bl, PSCodeItem pSCodeItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSCodeItem.isBeginValueDirty() : !pSCodeItem.isBeginValueDirty()) {
            return null;
        }
        Double d = pSCodeItem.getBeginValue();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_BeginValue_Default(pSCodeItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("BEGINVALUE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_BKColor(boolean bl, PSCodeItem pSCodeItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSCodeItem.isBKColorDirty() : !pSCodeItem.isBKColorDirty()) {
            return null;
        }
        String string = pSCodeItem.getBKColor();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_BKColor_Default(pSCodeItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("BKCOLOR");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_CodeItemValue(boolean bl, PSCodeItem pSCodeItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSCodeItem.isCodeItemValueDirty() && !bl2 : !pSCodeItem.isCodeItemValueDirty()) {
            return null;
        }
        String string = pSCodeItem.getCodeItemValue();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CODEITEMVALUE");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_CodeItemValue_Default(pSCodeItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CODEITEMVALUE");
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
                string3 = "PSCODELISTID";
                String string4 = this.checkFieldDupRule(this.getPSCodeItemDEModel(), "CODEITEMVALUE", string3, pSCodeItem, bl2, bl3);
                if (!StringHelper.isNullOrEmpty((String)string4)) {
                    EntityFieldError entityFieldError = new EntityFieldError();
                    entityFieldError.setFieldName("CODEITEMVALUE");
                    entityFieldError.setErrorType(3);
                    entityFieldError.setErrorInfo(string4);
                    return entityFieldError;
                }
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_CodeName(boolean bl, PSCodeItem pSCodeItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSCodeItem.isCodeNameDirty() : !pSCodeItem.isCodeNameDirty()) {
            return null;
        }
        String string = pSCodeItem.getCodeName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_CodeName_Default(pSCodeItem, bl2, bl3);
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
                string3 = "PSCODELISTID";
                String string4 = this.checkFieldDupRule(this.getPSCodeItemDEModel(), "CODENAME", string3, pSCodeItem, bl2, bl3);
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

    protected EntityFieldError onCheckField_Color(boolean bl, PSCodeItem pSCodeItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSCodeItem.isColorDirty() : !pSCodeItem.isColorDirty()) {
            return null;
        }
        String string = pSCodeItem.getColor();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Color_Default(pSCodeItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("COLOR");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_CssClass(boolean bl, PSCodeItem pSCodeItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSCodeItem.isCssClassDirty() : !pSCodeItem.isCssClassDirty()) {
            return null;
        }
        String string = pSCodeItem.getCssClass();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_CssClass_Default(pSCodeItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CSSCLASS");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Data(boolean bl, PSCodeItem pSCodeItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSCodeItem.isDataDirty() : !pSCodeItem.isDataDirty()) {
            return null;
        }
        String string = pSCodeItem.getData();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Data_Default(pSCodeItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DATA");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_DefaultFlag(boolean bl, PSCodeItem pSCodeItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSCodeItem.isDefaultFlagDirty() : !pSCodeItem.isDefaultFlagDirty()) {
            return null;
        }
        Integer n = pSCodeItem.getDefaultFlag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_DefaultFlag_Default(pSCodeItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DEFAULTFLAG");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        } else {
            boolean bl4 = true;
            bl4 = DataTypeHelper.compare((int)9, (Object)n, (Object)"1") == 0L;
            if (bl4) {
                String string = "";
                string = "PSCODELISTID";
                String string2 = this.checkFieldDupRule(this.getPSCodeItemDEModel(), "DEFAULTFLAG", string, pSCodeItem, bl2, bl3);
                if (!StringHelper.isNullOrEmpty((String)string2)) {
                    EntityFieldError entityFieldError = new EntityFieldError();
                    entityFieldError.setFieldName("DEFAULTFLAG");
                    entityFieldError.setErrorType(3);
                    entityFieldError.setErrorInfo(string2);
                    return entityFieldError;
                }
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_DisableSelect(boolean bl, PSCodeItem pSCodeItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSCodeItem.isDisableSelectDirty() : !pSCodeItem.isDisableSelectDirty()) {
            return null;
        }
        Integer n = pSCodeItem.getDisableSelect();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_DisableSelect_Default(pSCodeItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DISABLESELECT");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_DynaModelFlag(boolean bl, PSCodeItem pSCodeItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSCodeItem.isDynaModelFlagDirty() : !pSCodeItem.isDynaModelFlagDirty()) {
            return null;
        }
        Integer n = pSCodeItem.getDynaModelFlag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_DynaModelFlag_Default(pSCodeItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DYNAMODELFLAG");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_EndValue(boolean bl, PSCodeItem pSCodeItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSCodeItem.isEndValueDirty() : !pSCodeItem.isEndValueDirty()) {
            return null;
        }
        Double d = pSCodeItem.getEndValue();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_EndValue_Default(pSCodeItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ENDVALUE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_IconCls(boolean bl, PSCodeItem pSCodeItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSCodeItem.isIconClsDirty() : !pSCodeItem.isIconClsDirty()) {
            return null;
        }
        String string = pSCodeItem.getIconCls();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_IconCls_Default(pSCodeItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ICONCLS");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_IncBeginValue(boolean bl, PSCodeItem pSCodeItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSCodeItem.isIncBeginValueDirty() : !pSCodeItem.isIncBeginValueDirty()) {
            return null;
        }
        Integer n = pSCodeItem.getIncBeginValue();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_IncBeginValue_Default(pSCodeItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("INCBEGINVALUE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_IncEndValue(boolean bl, PSCodeItem pSCodeItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSCodeItem.isIncEndValueDirty() : !pSCodeItem.isIncEndValueDirty()) {
            return null;
        }
        Integer n = pSCodeItem.getIncEndValue();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_IncEndValue_Default(pSCodeItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("INCENDVALUE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_LevelTag(boolean bl, PSCodeItem pSCodeItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSCodeItem.isLevelTagDirty() : !pSCodeItem.isLevelTagDirty()) {
            return null;
        }
        String string = pSCodeItem.getLevelTag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_LevelTag_Default(pSCodeItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("LEVELTAG");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_LevelValue(boolean bl, PSCodeItem pSCodeItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSCodeItem.isLevelValueDirty() : !pSCodeItem.isLevelValueDirty()) {
            return null;
        }
        Integer n = pSCodeItem.getLevelValue();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_LevelValue_Default(pSCodeItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("LEVELVALUE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Memo(boolean bl, PSCodeItem pSCodeItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSCodeItem.isMemoDirty() : !pSCodeItem.isMemoDirty()) {
            return null;
        }
        String string = pSCodeItem.getMemo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Memo_Default(pSCodeItem, bl2, bl3);
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

    protected EntityFieldError onCheckField_OrderValue(boolean bl, PSCodeItem pSCodeItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSCodeItem.isOrderValueDirty() : !pSCodeItem.isOrderValueDirty()) {
            return null;
        }
        Integer n = pSCodeItem.getOrderValue();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_OrderValue_Default(pSCodeItem, bl2, bl3);
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

    protected EntityFieldError onCheckField_PPSCodeItemId(boolean bl, PSCodeItem pSCodeItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSCodeItem.isPPSCodeItemIdDirty() : !pSCodeItem.isPPSCodeItemIdDirty()) {
            return null;
        }
        String string = pSCodeItem.getPPSCodeItemId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PPSCodeItemId_Default(pSCodeItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PPSCODEITEMID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSCodeItemId(boolean bl, PSCodeItem pSCodeItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSCodeItem.isPSCodeItemIdDirty() && !bl2 : !pSCodeItem.isPSCodeItemIdDirty()) {
            return null;
        }
        String string = pSCodeItem.getPSCodeItemId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSCODEITEMID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSCodeItemId_Default(pSCodeItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSCODEITEMID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSCodeItemName(boolean bl, PSCodeItem pSCodeItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSCodeItem.isPSCodeItemNameDirty() && !bl2 : !pSCodeItem.isPSCodeItemNameDirty()) {
            return null;
        }
        String string = pSCodeItem.getPSCodeItemName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSCODEITEMNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSCodeItemName_Default(pSCodeItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSCODEITEMNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSCodeListId(boolean bl, PSCodeItem pSCodeItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSCodeItem.isPSCodeListIdDirty() && !bl2 : !pSCodeItem.isPSCodeListIdDirty()) {
            return null;
        }
        String string = pSCodeItem.getPSCodeListId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSCODELISTID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSCodeListId_Default(pSCodeItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSCODELISTID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDynaInstId(boolean bl, PSCodeItem pSCodeItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSCodeItem.isPSDynaInstIdDirty() : !pSCodeItem.isPSDynaInstIdDirty()) {
            return null;
        }
        String string = pSCodeItem.getPSDynaInstId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDynaInstId_Default(pSCodeItem, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSSysCssId(boolean bl, PSCodeItem pSCodeItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSCodeItem.isPSSysCssIdDirty() : !pSCodeItem.isPSSysCssIdDirty()) {
            return null;
        }
        String string = pSCodeItem.getPSSysCssId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysCssId_Default(pSCodeItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSCSSID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSysCssName(boolean bl, PSCodeItem pSCodeItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSCodeItem.isPSSysCssNameDirty() : !pSCodeItem.isPSSysCssNameDirty()) {
            return null;
        }
        String string = pSCodeItem.getPSSysCssName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysCssName_Default(pSCodeItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSCSSNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSysImageId(boolean bl, PSCodeItem pSCodeItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSCodeItem.isPSSysImageIdDirty() : !pSCodeItem.isPSSysImageIdDirty()) {
            return null;
        }
        String string = pSCodeItem.getPSSysImageId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysImageId_Default(pSCodeItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSIMAGEID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ShortKey(boolean bl, PSCodeItem pSCodeItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSCodeItem.isShortKeyDirty() : !pSCodeItem.isShortKeyDirty()) {
            return null;
        }
        String string = pSCodeItem.getShortKey();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_ShortKey_Default(pSCodeItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("SHORTKEY");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ShowAsAll(boolean bl, PSCodeItem pSCodeItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSCodeItem.isShowAsAllDirty() : !pSCodeItem.isShowAsAllDirty()) {
            return null;
        }
        Integer n = pSCodeItem.getShowAsAll();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_ShowAsAll_Default(pSCodeItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("SHOWASALL");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ShowAsEmpty(boolean bl, PSCodeItem pSCodeItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSCodeItem.isShowAsEmptyDirty() : !pSCodeItem.isShowAsEmptyDirty()) {
            return null;
        }
        Integer n = pSCodeItem.getShowAsEmpty();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_ShowAsEmpty_Default(pSCodeItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("SHOWASEMPTY");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        } else {
            boolean bl4 = true;
            bl4 = DataTypeHelper.compare((int)9, (Object)n, (Object)"1") == 0L;
            if (bl4) {
                String string = "";
                string = "PSCODELISTID";
                String string2 = this.checkFieldDupRule(this.getPSCodeItemDEModel(), "SHOWASEMPTY", string, pSCodeItem, bl2, bl3);
                if (!StringHelper.isNullOrEmpty((String)string2)) {
                    EntityFieldError entityFieldError = new EntityFieldError();
                    entityFieldError.setFieldName("SHOWASEMPTY");
                    entityFieldError.setErrorType(3);
                    entityFieldError.setErrorInfo(string2);
                    return entityFieldError;
                }
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_TextPSLanResId(boolean bl, PSCodeItem pSCodeItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSCodeItem.isTextPSLanResIdDirty() : !pSCodeItem.isTextPSLanResIdDirty()) {
            return null;
        }
        String string = pSCodeItem.getTextPSLanResId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_TextPSLanResId_Default(pSCodeItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("TEXTPSLANRESID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_TextPSLanResName(boolean bl, PSCodeItem pSCodeItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSCodeItem.isTextPSLanResNameDirty() : !pSCodeItem.isTextPSLanResNameDirty()) {
            return null;
        }
        String string = pSCodeItem.getTextPSLanResName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_TextPSLanResName_Default(pSCodeItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("TEXTPSLANRESNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_TipPSLanResId(boolean bl, PSCodeItem pSCodeItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSCodeItem.isTipPSLanResIdDirty() : !pSCodeItem.isTipPSLanResIdDirty()) {
            return null;
        }
        String string = pSCodeItem.getTipPSLanResId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_TipPSLanResId_Default(pSCodeItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("TIPPSLANRESID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_TipPSLanResName(boolean bl, PSCodeItem pSCodeItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSCodeItem.isTipPSLanResNameDirty() : !pSCodeItem.isTipPSLanResNameDirty()) {
            return null;
        }
        String string = pSCodeItem.getTipPSLanResName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_TipPSLanResName_Default(pSCodeItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("TIPPSLANRESNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_TooltipInfo(boolean bl, PSCodeItem pSCodeItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSCodeItem.isTooltipInfoDirty() : !pSCodeItem.isTooltipInfoDirty()) {
            return null;
        }
        String string = pSCodeItem.getTooltipInfo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_TooltipInfo_Default(pSCodeItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("TOOLTIPINFO");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_UserCat(boolean bl, PSCodeItem pSCodeItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSCodeItem.isUserCatDirty() : !pSCodeItem.isUserCatDirty()) {
            return null;
        }
        String string = pSCodeItem.getUserCat();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserCat_Default(pSCodeItem, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserData(boolean bl, PSCodeItem pSCodeItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSCodeItem.isUserDataDirty() : !pSCodeItem.isUserDataDirty()) {
            return null;
        }
        String string = pSCodeItem.getUserData();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserData_Default(pSCodeItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("USERDATA");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_UserData2(boolean bl, PSCodeItem pSCodeItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSCodeItem.isUserData2Dirty() : !pSCodeItem.isUserData2Dirty()) {
            return null;
        }
        String string = pSCodeItem.getUserData2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserData2_Default(pSCodeItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("USERDATA2");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_UserParams(boolean bl, PSCodeItem pSCodeItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSCodeItem.isUserParamsDirty() : !pSCodeItem.isUserParamsDirty()) {
            return null;
        }
        String string = pSCodeItem.getUserParams();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserParams_Default(pSCodeItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("USERPARAMS");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_UserTag(boolean bl, PSCodeItem pSCodeItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSCodeItem.isUserTagDirty() : !pSCodeItem.isUserTagDirty()) {
            return null;
        }
        String string = pSCodeItem.getUserTag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag_Default(pSCodeItem, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag2(boolean bl, PSCodeItem pSCodeItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSCodeItem.isUserTag2Dirty() : !pSCodeItem.isUserTag2Dirty()) {
            return null;
        }
        String string = pSCodeItem.getUserTag2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag2_Default(pSCodeItem, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag3(boolean bl, PSCodeItem pSCodeItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSCodeItem.isUserTag3Dirty() : !pSCodeItem.isUserTag3Dirty()) {
            return null;
        }
        String string = pSCodeItem.getUserTag3();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag3_Default(pSCodeItem, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag4(boolean bl, PSCodeItem pSCodeItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSCodeItem.isUserTag4Dirty() : !pSCodeItem.isUserTag4Dirty()) {
            return null;
        }
        String string = pSCodeItem.getUserTag4();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag4_Default(pSCodeItem, bl2, bl3);
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

    protected EntityFieldError onCheckField_ValidFlag(boolean bl, PSCodeItem pSCodeItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSCodeItem.isValidFlagDirty() : !pSCodeItem.isValidFlagDirty()) {
            return null;
        }
        Integer n = pSCodeItem.getValidFlag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_ValidFlag_Default(pSCodeItem, bl2, bl3);
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

    protected void onSyncEntity(PSCodeItem pSCodeItem, boolean bl) throws Exception {
        super.onSyncEntity(pSCodeItem, bl);
    }

    protected void onSyncIndexEntities(PSCodeItem pSCodeItem, boolean bl) throws Exception {
        super.onSyncIndexEntities(pSCodeItem, bl);
    }

    public Object getDataContextValue(PSCodeItem pSCodeItem, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null) {
            // empty if block
        }
        if ((object = super.getDataContextValue(pSCodeItem, string, iDataContextParam)) != null) {
            return object;
        }
        PSCodeList pSCodeList = pSCodeItem.getPSCodeList();
        if (pSCodeList != null && pSCodeList.contains(string)) {
            return pSCodeList.get(string);
        }
        return null;
    }

    protected void onExportMajorModel(PSCodeItem pSCodeItem, ArrayList<JSONObject> arrayList, int n) throws Exception {
        this.onExportMajorModel_TextPSLanRes(pSCodeItem, arrayList, n);
        this.onExportMajorModel_PSSysCss(pSCodeItem, arrayList, n);
        this.onExportMajorModel_PSSysImage(pSCodeItem, arrayList, n);
        super.onExportMajorModel(pSCodeItem, arrayList, n);
    }

    protected void onExportMajorModel_TextPSLanRes(PSCodeItem pSCodeItem, ArrayList<JSONObject> arrayList, int n) throws Exception {
        if (pSCodeItem.getTextPSLanRes() != null) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSLanguageResService", (SessionFactory)this.getSessionFactory());
            iService.exportModel(pSCodeItem.getTextPSLanRes(), arrayList, n);
        }
    }

    protected void onExportMajorModel_PSSysCss(PSCodeItem pSCodeItem, ArrayList<JSONObject> arrayList, int n) throws Exception {
        if (pSCodeItem.getPSSysCss() != null) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysCssService", (SessionFactory)this.getSessionFactory());
            iService.exportModel(pSCodeItem.getPSSysCss(), arrayList, n);
        }
    }

    protected void onExportMajorModel_PSSysImage(PSCodeItem pSCodeItem, ArrayList<JSONObject> arrayList, int n) throws Exception {
        if (pSCodeItem.getPSSysImage() != null) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysImageService", (SessionFactory)this.getSessionFactory());
            iService.exportModel(pSCodeItem.getPSSysImage(), arrayList, n);
        }
    }

    protected String onTestValueRule(String string, String string2, IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        if (StringHelper.compare((String)string, (String)"BEGINVALUE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_BeginValue_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"BKCOLOR", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_BKColor_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CODEITEMVALUE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CodeItemValue_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CODENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CodeName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"COLOR", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Color_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATEDATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateDate_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATEMAN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateMan_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CSSCLASS", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CssClass_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DATA", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Data_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DEFAULTFLAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DefaultFlag_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DISABLESELECT", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DisableSelect_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DYNAMODELFLAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DynaModelFlag_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ENDVALUE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_EndValue_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ICONCLS", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_IconCls_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"INCBEGINVALUE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_IncBeginValue_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"INCENDVALUE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_IncEndValue_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"LEVELTAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_LevelTag_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"LEVELVALUE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_LevelValue_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MEMO", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Memo_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ORDERVALUE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_OrderValue_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PPSCODEITEMID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PPSCodeItemId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PPSCODEITEMNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PPSCodeItemName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSCODEITEMID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSCodeItemId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSCODEITEMNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSCodeItemName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSCODELISTID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSCodeListId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSCODELISTNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSCodeListName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDYNAINSTID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDynaInstId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSCSSID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysCssId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSCSSNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysCssName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSIMAGEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysImageId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSIMAGENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysImageName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"SHORTKEY", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ShortKey_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"SHOWASALL", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ShowAsAll_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"SHOWASEMPTY", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ShowAsEmpty_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"TEXTPSLANRESID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_TextPSLanResId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"TEXTPSLANRESNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_TextPSLanResName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"THRESHOLDGROUPFLAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ThresholdGroupFlag_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"TIPPSLANRESID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_TipPSLanResId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"TIPPSLANRESNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_TipPSLanResName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"TOOLTIPINFO", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_TooltipInfo_Default(iEntity, bl, bl2);
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
        if (StringHelper.compare((String)string, (String)"USERDATA", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UserData_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"USERDATA2", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UserData2_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"USERPARAMS", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UserParams_Default(iEntity, bl, bl2);
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

    protected String onTestValueRule_BeginValue_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_BKColor_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("BKCOLOR", iEntity, bl2, null, false, 30, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_CodeItemValue_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("CODEITEMVALUE", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_CodeName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("CODENAME", iEntity, bl2, null, false, 60, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]", false) && this.checkFieldRegExRule("CODENAME", iEntity, bl2, "[a-zA-Z_$][a-zA-Z0-9_$]*", "\u5185\u5bb9\u53ea\u80fd\u7531\u5b57\u6bcd\u3001\u6570\u5b57\u3001\u4e0b\u5212\u7ebf\u7ec4\u6210\uff0c\u4e14\u5f00\u59cb\u5fc5\u987b\u4e3a\u5b57\u6bcd", false)) {
                return null;
            }
            return "(\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60] \u5e76\u4e14 \u5185\u5bb9\u53ea\u80fd\u7531\u5b57\u6bcd\u3001\u6570\u5b57\u3001\u4e0b\u5212\u7ebf\u7ec4\u6210\uff0c\u4e14\u5f00\u59cb\u5fc5\u987b\u4e3a\u5b57\u6bcd)";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_Color_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("COLOR", iEntity, bl2, null, false, 30, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]";
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

    protected String onTestValueRule_CssClass_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("CSSCLASS", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_Data_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("DATA", iEntity, bl2, null, false, 4000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[4000]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[4000]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_DefaultFlag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_DisableSelect_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_DynaModelFlag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_EndValue_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_IconCls_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("ICONCLS", iEntity, bl2, null, false, 50, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_IncBeginValue_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_IncEndValue_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_LevelTag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("LEVELTAG", iEntity, bl2, null, false, 40, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[40]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[40]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_LevelValue_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
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

    protected String onTestValueRule_OrderValue_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_PPSCodeItemId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PPSCODEITEMID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false) && this.checkFieldRecursionRule("PPSCODEITEMID", "PSCODEITEM", iEntity, bl2, "")) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PPSCodeItemName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PPSCODEITEMNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSCodeItemId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSCODEITEMID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSCodeItemName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSCODEITEMNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSCodeListId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSCODELISTID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSCodeListName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSCODELISTNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
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
            if (this.checkFieldStringLengthRule("PSDYNAINSTID", iEntity, bl2, null, false, 60, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysCssId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSCSSID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysCssName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSCSSNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysImageId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSIMAGEID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysImageName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSIMAGENAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_ShortKey_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("SHORTKEY", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_ShowAsAll_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_ShowAsEmpty_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_TextPSLanResId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("TEXTPSLANRESID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_TextPSLanResName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("TEXTPSLANRESNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_ThresholdGroupFlag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_TipPSLanResId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("TIPPSLANRESID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_TipPSLanResName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("TIPPSLANRESNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_TooltipInfo_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("TOOLTIPINFO", iEntity, bl2, null, false, 500, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[500]", false)) {
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

    protected String onTestValueRule_UserData_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("USERDATA", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_UserData2_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("USERDATA2", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_UserParams_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("USERPARAMS", iEntity, bl2, null, false, 2000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[2000]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[2000]";
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

    @Override
    protected boolean isPrepareLastForUpdate() {
        return true;
    }

    protected boolean onMergeChild(String string, String string2, PSCodeItem pSCodeItem) throws Exception {
        boolean bl = false;
        if (super.onMergeChild(string, string2, pSCodeItem)) {
            bl = true;
        }
        return bl;
    }

    protected void onUpdateParent(PSCodeItem pSCodeItem) throws Exception {
        Object object = pSCodeItem.get("PSCODELISTID");
        if (object != null) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSCodeListService", (SessionFactory)this.getSessionFactory());
            iService.mergeChild("DER1N", "DER1N_PSCODEITEM_PSCODELIST_PSCODELISTID", object);
        }
        super.onUpdateParent(pSCodeItem);
    }

    protected boolean isNeedUpdateParent() {
        return true;
    }

    @Override
    protected void exportCurXmlModel(PSCodeItem pSCodeItem, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSCODEITEM");
        if (!bl) {
            pSCodeItem.setCreateDate(null);
            pSCodeItem.setCreateMan(null);
            pSCodeItem.setLevelTag(null);
            pSCodeItem.setLevelValue(null);
            pSCodeItem.setPSCodeItemId(null);
            pSCodeItem.setUpdateDate(null);
            pSCodeItem.setUpdateMan(null);
            pSCodeItem.setPPSCodeItemId(null);
            pSCodeItem.setPSCodeListId(null);
            pSCodeItem.setPSCodeListName(null);
            pSCodeItem.setThresholdGroupFlag(null);
            super.exportCurXmlModel(pSCodeItem, xmlNode, bl);
        }
    }

    @Override
    protected void onExportRelatedXmlModel(PSCodeItem pSCodeItem, XmlNode xmlNode) throws Exception {
        this.exportRelatedXmlModel_PSCodeItem(pSCodeItem, xmlNode);
        super.onExportRelatedXmlModel(pSCodeItem, xmlNode);
    }

    protected void exportRelatedXmlModel_PSCodeItem(PSCodeItem pSCodeItem, XmlNode xmlNode) throws Exception {
        PSCodeItemService pSCodeItemService = (PSCodeItemService)ServiceGlobal.getService(PSCodeItemService.class, (SessionFactory)this.getSessionFactory());
        ArrayList<PSCodeItem> arrayList = null;
        String string = pSCodeItem.getPSCodeItemId();
        arrayList = string.indexOf("SRFTEMPKEY:") != 0 ? pSCodeItemService.selectByPPSCodeItem(pSCodeItem, "ORDER BY ORDERVALUE ASC") : pSCodeItemService.selectTempByPPSCodeItem(pSCodeItem, "ORDER BY ORDERVALUE ASC");
        if (arrayList.size() > 0) {
            XmlNode xmlNode2 = new XmlNode();
            xmlNode2.setNodeName("PSCODEITEMS");
            xmlNode.addNode(xmlNode2);
            for (PSCodeItem pSCodeItem2 : arrayList) {
                pSCodeItem2.set("ORDERVALUE", null);
                pSCodeItemService.exportXmlModel(pSCodeItem2, xmlNode2);
            }
        }
    }

    @Override
    protected void onImportRelatedXmlModel(PSCodeItem pSCodeItem, XmlNode xmlNode) throws Exception {
        XmlNode xmlNode2 = xmlNode.getChildNodeByNodeName("PSCODEITEMS");
        this.importRelatedXmlModel_PSCodeItem(pSCodeItem, xmlNode2);
        super.onImportRelatedXmlModel(pSCodeItem, xmlNode);
    }

    protected void importRelatedXmlModel_PSCodeItem(PSCodeItem pSCodeItem, XmlNode xmlNode) throws Exception {
        int n = 100;
        PSCodeItemService pSCodeItemService = (PSCodeItemService)ServiceGlobal.getService(PSCodeItemService.class, (SessionFactory)this.getSessionFactory());
        String string = pSCodeItem.getPSCodeItemId();
        if (string.indexOf("SRFTEMPKEY:") != 0) {
            pSCodeItemService.removeByPPSCodeItem(pSCodeItem);
        } else {
            pSCodeItemService.removeTempByPPSCodeItem(pSCodeItem);
        }
        if (xmlNode == null) {
            return;
        }
        Iterator iterator = xmlNode.getChildNodes();
        if (iterator != null) {
            while (iterator.hasNext()) {
                XmlNode xmlNode2 = (XmlNode)iterator.next();
                PSCodeItem pSCodeItem2 = new PSCodeItem();
                pSCodeItem2.setOrderValue(n);
                n += 100;
                pSCodeItemService.fillParentInfo(pSCodeItem2, "DER1N", "DER1N_PSCODEITEM_PSCODEITEM_PPSCODEITEMID", pSCodeItem.getPSCodeItemId());
                pSCodeItemService.importXmlModel(pSCodeItem2, xmlNode2);
            }
        }
    }

    @Override
    public ObjectNode fillModelV2(ObjectNode objectNode, PSCodeItem pSCodeItem, String string) throws Exception {
        objectNode = super.fillModelV2(objectNode, pSCodeItem, string);
        return objectNode;
    }

    @Override
    public String getModelV2ResScope(IEntity iEntity) throws Exception {
        String string = null;
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PPSCODEITEMID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return StringHelper.format((String)"PSCODEITEM#%1$s", (Object)string);
        }
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSCODELISTID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return StringHelper.format((String)"PSCODELIST#%1$s", (Object)string);
        }
        return super.getModelV2ResScope(iEntity);
    }

    @Override
    public String getModelV2ResScopeDER(IEntity iEntity) throws Exception {
        String string = null;
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PPSCODEITEMID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return "DER1N_PSCODEITEM_PSCODEITEM_PPSCODEITEMID";
        }
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSCODELISTID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return "DER1N_PSCODEITEM_PSCODELIST_PSCODELISTID";
        }
        return super.getModelV2ResScopeDER(iEntity);
    }

    @Override
    public String getModelV2ResScopeText(IEntity iEntity) throws Exception {
        String string = null;
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PPSCODEITEMID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return DataObject.getStringValue((IDataObject)iEntity, (String)"PPSCODEITEMNAME", null);
        }
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSCODELISTID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return DataObject.getStringValue((IDataObject)iEntity, (String)"PSCODELISTNAME", null);
        }
        return super.getModelV2ResScopeText(iEntity);
    }

    @Override
    public boolean setModelV2ResScope(IEntity iEntity, String string, String string2) throws Exception {
        if (StringHelper.compare((String)string, (String)"PSCODEITEM", (boolean)true) == 0) {
            iEntity.set("PPSCODEITEMID", (Object)string2);
            return true;
        }
        if (StringHelper.compare((String)string, (String)"PSCODELIST", (boolean)true) == 0) {
            iEntity.set("PSCODELISTID", (Object)string2);
            return true;
        }
        return super.setModelV2ResScope(iEntity, string, string2);
    }

    @Override
    public String[] getModelV2ResScopeFields() throws Exception {
        return new String[]{"PPSCODEITEMID", "PSCODELISTID"};
    }

    @Override
    public String getModelV2Tag(PSCodeItem pSCodeItem) {
        if (!StringHelper.isNullOrEmpty((String)pSCodeItem.getCodeName())) {
            return pSCodeItem.getCodeName();
        }
        return super.getModelV2Tag(pSCodeItem);
    }

    @Override
    public boolean setModelV2Tag(PSCodeItem pSCodeItem, String string) {
        pSCodeItem.setCodeName(string);
        return true;
    }

    @Override
    public Map<String, String> getListDRDataFolderFields(Map<String, String> map, PSMOSFile pSMOSFile, IPSMOSFileFilter iPSMOSFileFilter) throws Exception {
        if (map == null) {
            map = new HashMap<String, String>();
        }
        map.put("CODENAME", "");
        map.put("PPSCODEITEMID", "");
        map.put("PSCODELISTID", "");
        return super.getListDRDataFolderFields(map, pSMOSFile, iPSMOSFileFilter);
    }

    @Override
    public boolean getModelV2Entity(PSCodeItem pSCodeItem, String string) throws Exception {
        SimpleEntity simpleEntity = new SimpleEntity();
        pSCodeItem.copyTo((IDataObject)simpleEntity, false);
        simpleEntity.copyTo((IDataObject)pSCodeItem, true);
        pSCodeItem.set("CODENAME", string);
        if (this.select(pSCodeItem, true)) {
            return true;
        }
        simpleEntity.copyTo((IDataObject)pSCodeItem, true);
        return super.getModelV2Entity(pSCodeItem, string);
    }

    @Override
    protected boolean testCompileCurModelV2(PSCodeItem pSCodeItem, ObjectNode objectNode, String string, String string2, int n) throws Exception {
        if (n == 1) {
            return true;
        }
        boolean bl = false;
        if (!StringHelper.isNullOrEmpty((String)pSCodeItem.getPPSCodeItemId())) {
            bl = true;
        }
        if (!StringHelper.isNullOrEmpty((String)pSCodeItem.getPSCodeListId())) {
            bl = true;
        } else if (bl && !objectNode.has("pscodelistid")) {
            objectNode.put("pscodelistid", "<PSCODELIST>");
        }
        return super.testCompileCurModelV2(pSCodeItem, objectNode, string, string2, n);
    }

    @Override
    protected ObjectNode onFillModelV2(ObjectNode objectNode, PSCodeItem pSCodeItem, String string, Map<String, String> map) throws Exception {
        if (PSCodeItemServiceBase.isSimpleImportExportMode()) {
            map.put("PPSCODEITEMID", "");
            map.put("PSCODELISTID", "");
        }
        return super.onFillModelV2(objectNode, pSCodeItem, string, map);
    }

    protected boolean isExportRelatedModelV2(String string) {
        return StringHelper.compare((String)"DER1N_PSCODEITEM_PSCODEITEM_PPSCODEITEMID", (String)string, (boolean)true) != 0;
    }

    @Override
    protected void onExportRelatedModelV2(PSCodeItem pSCodeItem, String string, String string2) throws Exception {
        Object var4_4 = null;
        super.onExportRelatedModelV2(pSCodeItem, string, string2);
    }

    @Override
    protected void onExportCurModelV2(PSCodeItem pSCodeItem, ObjectNode objectNode, String string, boolean bl) throws Exception {
        File file = null;
        if (bl || !this.isExportRelatedModelV2("DER1N_PSCODEITEM_PSCODEITEM_PPSCODEITEMID")) {
            PSCodeItemService pSCodeItemService = (PSCodeItemService)ServiceGlobal.getService(PSCodeItemService.class, (SessionFactory)this.getSessionFactory());
            ArrayList<ObjectNode> modelNodes = null;
            if (!StringHelper.isNullOrEmpty((String)string)) {
                file = new File(StringHelper.format((String)"%1$s%2$s%3$s%2$sPSCODEITEM#%4$s#ALL.txt", (Object)string, (Object)File.separator, (Object)"PSCODEITEM", (Object)pSCodeItem.getPSCodeItemId()));
                if (file.exists()) {
                    modelNodes = new ArrayList<ObjectNode>();
                    for (String line : PSModelV2Helper.readFile2(file)) {
                        if (StringHelper.isNullOrEmpty(line)) continue;
                        modelNodes.add((ObjectNode)JsonNodeHelper.fromString(line));
                    }
                }
            } else {
                modelNodes = new ArrayList<ObjectNode>();
                String scope = StringHelper.format((String)"PSCODEITEM#%1$s", (Object)pSCodeItem.getPSCodeItemId());
                for (PSCodeItem model : pSCodeItemService.selectByPPSCodeItem(pSCodeItem)) {
                    String modelScope = pSCodeItemService.getModelV2ResScope(model);
                    if (StringHelper.compare(scope, modelScope, false) != 0) continue;
                    modelNodes.add(PSModelV2Helper.toJSONObject(model, false));
                }
            }
            if (modelNodes != null && modelNodes.size() > 0) {
                ArrayNode childNodes = objectNode.putArray(pSCodeItemService.getModelV2Name(false).toLowerCase());
                Collections.sort(modelNodes, new Comparator<ObjectNode>(){

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
                        if (objectNode.has("pscodeitemname")) {
                            string = objectNode.get("pscodeitemname").asText();
                        }
                        if (objectNode2.has("pscodeitemname")) {
                            string2 = objectNode2.get("pscodeitemname").asText();
                        }
                        return StringHelper.compare((String)string, string2, (boolean)false);
                    }
                });
                for (ObjectNode modelNode : modelNodes) {
                    PSCodeItem model = new PSCodeItem();
                    PSModelV2Helper.fromJSONObject(model, modelNode, false);
                    childNodes.add(pSCodeItemService.exportModelV2(model, string));
                }
            }
        }
        super.onExportCurModelV2(pSCodeItem, objectNode, string, bl);
    }

    @Override
    protected void onEmptyModelV2(PSCodeItem pSCodeItem) throws Exception {
        PSCodeItemService pSCodeItemService = (PSCodeItemService)ServiceGlobal.getService(PSCodeItemService.class, (SessionFactory)this.getSessionFactory());
        ArrayList<PSCodeItem> arrayList = pSCodeItemService.selectByPPSCodeItem(pSCodeItem);
        String string = StringHelper.format((String)"PSCODEITEM#%1$s", (Object)pSCodeItem.getPSCodeItemId());
        for (PSCodeItem pSCodeItem2 : arrayList) {
            String string2 = pSCodeItemService.getModelV2ResScope(pSCodeItem2);
            if (StringHelper.compare((String)string, (String)string2, (boolean)false) != 0) continue;
            pSCodeItemService.emptyModelV2(pSCodeItem2);
        }
        SqlParamList sqlParamList = new SqlParamList();
        sqlParamList.addString(pSCodeItem.getPSCodeItemId());
        pSCodeItemService.getDAO().executeRawSql(null, "SET FOREIGN_KEY_CHECKS=0;", null);
        pSCodeItemService.getDAO().executeRawSql(null, "DELETE FROM T_SRFPSCODEITEM WHERE PPSCODEITEMID = ?", sqlParamList);
        super.onEmptyModelV2(pSCodeItem);
    }

    @Override
    protected boolean onContainsRelatedModelV2Entity(String string, int n) throws Exception {
        PSCodeItemService pSCodeItemService = (PSCodeItemService)ServiceGlobal.getService(PSCodeItemService.class, (SessionFactory)this.getSessionFactory());
        if (pSCodeItemService.containsModelV2Entity(string, n)) {
            return true;
        }
        return super.onContainsRelatedModelV2Entity(string, n);
    }

    @Override
    protected IEntity onGetRelatedModelV2Entity(PSCodeItem pSCodeItem, String string, String string2) throws Exception {
        IEntity iEntity = null;
        PSCodeItem pSCodeItem2 = new PSCodeItem();
        pSCodeItem2.set("PPSCODEITEMID", pSCodeItem.getPSCodeItemId());
        PSCodeItemService pSCodeItemService = (PSCodeItemService)ServiceGlobal.getService(PSCodeItemService.class, (SessionFactory)this.getSessionFactory());
        iEntity = pSCodeItemService.getModelV2Entity(pSCodeItem2, string, string2);
        if (iEntity != null) {
            return iEntity;
        }
        return super.onGetRelatedModelV2Entity(pSCodeItem, string, string2);
    }

    @Override
    protected void onCompileRelatedModelV2(PSCodeItem pSCodeItem, ObjectNode objectNode, String string, String string2, int n) throws Exception {
        PSCodeItemService pSCodeItemService = (PSCodeItemService)ServiceGlobal.getService(PSCodeItemService.class, (SessionFactory)this.getSessionFactory());
        ArrayNode arrayNode = null;
        String string3 = pSCodeItemService.getModelV2Name(null, false);
        if (objectNode != null) {
            arrayNode = JsonNodeHelper.getArray((ObjectNode)objectNode, (String)string3.toLowerCase());
        }
        if (arrayNode != null) {
            for (int i = 0; i < arrayNode.size(); ++i) {
                ObjectNode objectNode2 = (ObjectNode)arrayNode.get(i);
                PSCodeItem pSCodeItem2 = new PSCodeItem();
                pSCodeItem2.setPPSCodeItemId(pSCodeItem.getPSCodeItemId());
                pSCodeItem2.setPPSCodeItemName(pSCodeItem.getPSCodeItemName());
                pSCodeItemService.compileModelV2(pSCodeItem2, objectNode2, string, null, n);
            }
        } else {
            String string4 = StringHelper.format((String)"%1$s%2$s%3$s", (Object)string2, (Object)File.separator, (Object)string3);
            File file = new File(string4);
            if (file.exists()) {
                File[] fileArray;
                for (File file2 : fileArray = file.listFiles()) {
                    if (!file2.isDirectory()) continue;
                    PSCodeItem pSCodeItem3 = new PSCodeItem();
                    pSCodeItem3.setPPSCodeItemId(pSCodeItem.getPSCodeItemId());
                    pSCodeItem3.setPPSCodeItemName(pSCodeItem.getPSCodeItemName());
                    pSCodeItemService.compileModelV2(pSCodeItem3, null, string, file2.getCanonicalPath(), n);
                }
            }
        }
        super.onCompileRelatedModelV2(pSCodeItem, objectNode, string, string2, n);
    }

    @Override
    protected PSMOSFile onPasteFile(PSCodeItem pSCodeItem, PSMOSFile pSMOSFile, String string, IPSMOSFileAction iPSMOSFileAction) throws Exception {
        PSMOSFile pSMOSFile2 = null;
        if ((StringHelper.isNullOrEmpty((String)string) || StringHelper.compare((String)string, (String)"DER1N_PSCODEITEM_PSCODEITEM_PPSCODEITEMID", (boolean)true) == 0) && (pSMOSFile2 = this.onPasteFile_PSCodeItems(pSCodeItem, pSMOSFile, iPSMOSFileAction)) != null) {
            return pSMOSFile2;
        }
        return super.onPasteFile(pSCodeItem, pSMOSFile, string, iPSMOSFileAction);
    }

    protected PSMOSFile onPasteFile_PSCodeItems(PSCodeItem pSCodeItem, PSMOSFile pSMOSFile, IPSMOSFileAction iPSMOSFileAction) throws Exception {
        if (StringHelper.compare((String)pSMOSFile.getPSModelType(), (String)PSModelV2Helper.getModelV2Name("PSCODEITEM", true), (boolean)false) == 0) {
            PSCodeItemService pSCodeItemService = (PSCodeItemService)ServiceGlobal.getService(PSCodeItemService.class, (SessionFactory)this.getSessionFactory());
            PSCodeItem pSCodeItem2 = new PSCodeItem();
            pSCodeItem2.setPSCodeItemId(pSMOSFile.getPSModelId());
            if (!pSCodeItemService.get(pSCodeItem2, true)) {
                throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u83b7\u53d6\u6a21\u578b[%1$s|%2$s]", (Object)pSMOSFile.getPSMOSFileId(), (Object)pSMOSFile.getPSModelId()));
            }
            if (StringHelper.compare((String)pSCodeItem2.getPPSCodeItemId(), (String)pSCodeItem.getPSCodeItemId(), (boolean)false) == 0) {
                throw new Exception(StringHelper.format((String)"\u76ee\u6807\u8def\u5f84\u4e0e\u6e90\u8def\u5f84\u4e00\u81f4"));
            }
            ObjectNode objectNode = pSCodeItemService.exportModelV2(pSCodeItem2);
            pSCodeItem2.reset();
            if (!pSCodeItemService.setModelV2ResScope(pSCodeItem2, "PSCODEITEM", pSCodeItem.getPSCodeItemId())) {
                throw new Exception("\u65e0\u6cd5\u8bbe\u7f6e\u6a21\u578b\u57df");
            }
            pSCodeItemService.importModelV2(pSCodeItem2, objectNode);
            SessionFactoryManager.commit();
            return pSCodeItemService.getFile(pSCodeItem2);
        }
        return null;
    }

    @Override
    protected void onFillPasteHelps(PSCodeItem pSCodeItem, List<PSHelpSection> list) throws Exception {
        this.onFillPasteHelps_PSCodeItems(pSCodeItem, list);
        super.onFillPasteHelps(pSCodeItem, list);
    }

    protected void onFillPasteHelps_PSCodeItems(PSCodeItem pSCodeItem, List<PSHelpSection> list) throws Exception {
        PSHelpSection pSHelpSection = new PSHelpSection();
        pSHelpSection.setSectionType("USER");
        pSHelpSection.setSectionParam("PSCODEITEM");
        pSHelpSection.setSectionParam2("DER1N_PSCODEITEM_PSCODEITEM_PPSCODEITEMID");
        pSHelpSection.setContent("\u7c98\u8d34\u5176\u5b83[\u4ee3\u7801\u8868\u9879]\u7684[\u4ee3\u7801\u8868\u9879]");
        list.add(pSHelpSection);
    }
}
