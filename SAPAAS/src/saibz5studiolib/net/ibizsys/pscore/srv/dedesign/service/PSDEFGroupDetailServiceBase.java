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
 *  net.ibizsys.paas.util.KeyValueHelper
 *  net.ibizsys.paas.util.StringBuilderEx
 *  net.ibizsys.paas.util.StringHelper
 *  net.ibizsys.paas.xml.XmlNode
 *  net.sf.json.JSONObject
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 *  org.hibernate.SessionFactory
 */
package net.ibizsys.pscore.srv.dedesign.service;

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
import net.ibizsys.paas.util.KeyValueHelper;
import net.ibizsys.paas.util.StringBuilderEx;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.xml.XmlNode;
import net.ibizsys.pscore.srv.PSCoreSysServiceBase;
import net.ibizsys.pscore.srv.core.IPSDataEntityModel;
import net.ibizsys.pscore.srv.dedesign.dao.PSDEFGroupDetailDAO;
import net.ibizsys.pscore.srv.dedesign.demodel.PSDEFGroupDetailDEModel;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEFGroup;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEFGroupBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEFGroupDetail;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEFUIMode;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEFUIModeBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEField;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEFieldBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSCodeList;
import net.ibizsys.pscore.srv.sysdesign.entity.PSCodeListBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSLanguageRes;
import net.ibizsys.pscore.srv.sysdesign.entity.PSLanguageResBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysValueRule;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysValueRuleBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSystem;
import net.ibizsys.pscore.srv.sysdevstudio.entity.PSMOSFile;
import net.ibizsys.pscore.srv.util.IPSMOSFileFilter;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDEFGroupDetailServiceBase
extends PSCoreSysServiceBase<PSDEFGroupDetail> {
    private static final Log log = LogFactory.getLog(PSDEFGroupDetailServiceBase.class);
    public static final String DATASET_DEFAULT = "DEFAULT";
    private PSDEFGroupDetailDEModel pSDEFGroupDetailDEModel;
    private PSDEFGroupDetailDAO pSDEFGroupDetailDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.dedesign.service.PSDEFGroupDetailService";
    }

    public PSDEFGroupDetailDEModel getPSDEFGroupDetailDEModel() {
        if (this.pSDEFGroupDetailDEModel == null) {
            try {
                this.pSDEFGroupDetailDEModel = (PSDEFGroupDetailDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.dedesign.demodel.PSDEFGroupDetailDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDEFGroupDetailDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSDEFGroupDetailDEModel();
    }

    public PSDEFGroupDetailDAO getPSDEFGroupDetailDAO() {
        if (this.pSDEFGroupDetailDAO == null) {
            try {
                this.pSDEFGroupDetailDAO = (PSDEFGroupDetailDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.dedesign.dao.PSDEFGroupDetailDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDEFGroupDetailDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSDEFGroupDetailDAO();
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

    protected void onFillParentInfo(PSDEFGroupDetail pSDEFGroupDetail, String string, String string2, String string3) throws Exception {
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEFGROUPDETAIL_PSCODELIST_PSCODELISTID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSCodeListService", (SessionFactory)this.getSessionFactory());
            PSCodeList pSCodeList = (PSCodeList)iService.getDEModel().createEntity();
            pSCodeList.set("PSCODELISTID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSCodeList);
            } else {
                iService.get(pSCodeList);
            }
            this.onFillParentInfo_PSCodeList(pSDEFGroupDetail, pSCodeList);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEFGROUPDETAIL_PSDEFFORMITEM_PSDEFUIMODEID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEFUIModeService", (SessionFactory)this.getSessionFactory());
            PSDEFUIMode pSDEFUIMode = (PSDEFUIMode)iService.getDEModel().createEntity();
            pSDEFUIMode.set("PSDEFFORMITEMID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDEFUIMode);
            } else {
                iService.get(pSDEFUIMode);
            }
            this.onFillParentInfo_PSDEFUIMode(pSDEFGroupDetail, pSDEFUIMode);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEFGROUPDETAIL_PSDEFGROUP_PSDEFGROUPID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEFGroupService", (SessionFactory)this.getSessionFactory());
            PSDEFGroup pSDEFGroup = (PSDEFGroup)iService.getDEModel().createEntity();
            pSDEFGroup.set("PSDEFGROUPID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDEFGroup);
            } else {
                iService.get(pSDEFGroup);
            }
            this.onFillParentInfo_PSDEFGroup(pSDEFGroupDetail, pSDEFGroup);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEFGROUPDETAIL_PSDEFIELD_PSDEFID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEFieldService", (SessionFactory)this.getSessionFactory());
            PSDEField pSDEField = (PSDEField)iService.getDEModel().createEntity();
            pSDEField.set("PSDEFIELDID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDEField);
            } else {
                iService.get(pSDEField);
            }
            this.onFillParentInfo_PSDEF(pSDEFGroupDetail, pSDEField);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEFGROUPDETAIL_PSLANGUAGERES_LNPSLANRESID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSLanguageResService", (SessionFactory)this.getSessionFactory());
            PSLanguageRes pSLanguageRes = (PSLanguageRes)iService.getDEModel().createEntity();
            pSLanguageRes.set("PSLANGUAGERESID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSLanguageRes);
            } else {
                iService.get(pSLanguageRes);
            }
            this.onFillParentInfo_LNPSLanRes(pSDEFGroupDetail, pSLanguageRes);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEFGROUPDETAIL_PSSYSVALUERULE_PSSYSVALUERULEID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysValueRuleService", (SessionFactory)this.getSessionFactory());
            PSSysValueRule pSSysValueRule = (PSSysValueRule)iService.getDEModel().createEntity();
            pSSysValueRule.set("PSSYSVALUERULEID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSSysValueRule);
            } else {
                iService.get(pSSysValueRule);
            }
            this.onFillParentInfo_PSSysValueRule(pSDEFGroupDetail, pSSysValueRule);
            return;
        }
        super.onFillParentInfo(pSDEFGroupDetail, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillParentInfo_PSCodeList(PSDEFGroupDetail pSDEFGroupDetail, PSCodeList pSCodeList) throws Exception {
        pSDEFGroupDetail.setPSCodeListId(pSCodeList.getPSCodeListId());
        pSDEFGroupDetail.setPSCodeListName(pSCodeList.getPSCodeListName());
    }

    protected void onFillParentInfo_PSDEFUIMode(PSDEFGroupDetail pSDEFGroupDetail, PSDEFUIMode pSDEFUIMode) throws Exception {
        pSDEFGroupDetail.setPSDEFUIModeId(pSDEFUIMode.getPSDEFUIModeId());
        pSDEFGroupDetail.setPSDEFUIModeName(pSDEFUIMode.getPSDEFUIModeName());
    }

    protected void onFillParentInfo_PSDEFGroup(PSDEFGroupDetail pSDEFGroupDetail, PSDEFGroup pSDEFGroup) throws Exception {
        pSDEFGroupDetail.setPSDEFGroupId(pSDEFGroup.getPSDEFGroupId());
        pSDEFGroupDetail.setPSDEFGroupName(pSDEFGroup.getPSDEFGroupName());
        pSDEFGroupDetail.setPSDEId(pSDEFGroup.getPSDEId());
    }

    protected void onFillParentInfo_PSDEF(PSDEFGroupDetail pSDEFGroupDetail, PSDEField pSDEField) throws Exception {
        pSDEFGroupDetail.setPSDEFId(pSDEField.getPSDEFieldId());
        pSDEFGroupDetail.setPSDEFName(pSDEField.getPSDEFieldName());
    }

    protected void onFillParentInfo_LNPSLanRes(PSDEFGroupDetail pSDEFGroupDetail, PSLanguageRes pSLanguageRes) throws Exception {
        pSDEFGroupDetail.setLNPSLanResId(pSLanguageRes.getPSLanguageResId());
        pSDEFGroupDetail.setLNPSLanResName(pSLanguageRes.getPSLanguageResName());
    }

    protected void onFillParentInfo_PSSysValueRule(PSDEFGroupDetail pSDEFGroupDetail, PSSysValueRule pSSysValueRule) throws Exception {
        pSDEFGroupDetail.setPSSysValueRuleId(pSSysValueRule.getPSSysValueRuleId());
        pSDEFGroupDetail.setPSSysValueRuleName(pSSysValueRule.getPSSysValueRuleName());
    }

    protected boolean onFillEntityKeyValue(PSDEFGroupDetail pSDEFGroupDetail, boolean bl) throws Exception {
        StringBuilderEx stringBuilderEx = new StringBuilderEx();
        Object object = pSDEFGroupDetail.get("PSDEFGROUPID");
        if (object == null) {
            object = "__EMTPY__";
        }
        stringBuilderEx.append("%1$s", object);
        stringBuilderEx.append("||");
        Object object2 = pSDEFGroupDetail.get("PSDEFID");
        if (object2 == null) {
            object2 = "__EMTPY__";
        }
        stringBuilderEx.append("%1$s", object2);
        String string = stringBuilderEx.toString();
        pSDEFGroupDetail.set(this.getPSDEFGroupDetailDEModel().getKeyDEField().getName(), KeyValueHelper.genUniqueId((String)string));
        return true;
    }

    protected void onFillEntityFullInfo(PSDEFGroupDetail pSDEFGroupDetail, boolean bl) throws Exception {
        if (bl) {
            if (pSDEFGroupDetail.getModifyUserInput() == null) {
                pSDEFGroupDetail.setModifyUserInput((Integer)this.getDefaultValue(this.getWebContext(), "", "0", 9));
            }
            if (pSDEFGroupDetail.getValidFlag() == null) {
                pSDEFGroupDetail.setValidFlag((Integer)this.getDefaultValue(this.getWebContext(), "", "1", 9));
            }
        }
        super.onFillEntityFullInfo(pSDEFGroupDetail, bl);
        this.onFillEntityFullInfo_PSCodeList(pSDEFGroupDetail, bl);
        this.onFillEntityFullInfo_PSDEFUIMode(pSDEFGroupDetail, bl);
        this.onFillEntityFullInfo_PSDEFGroup(pSDEFGroupDetail, bl);
        this.onFillEntityFullInfo_PSDEF(pSDEFGroupDetail, bl);
        this.onFillEntityFullInfo_LNPSLanRes(pSDEFGroupDetail, bl);
        this.onFillEntityFullInfo_PSSysValueRule(pSDEFGroupDetail, bl);
    }

    protected void onFillEntityFullInfo_PSCodeList(PSDEFGroupDetail pSDEFGroupDetail, boolean bl) throws Exception {
        if (pSDEFGroupDetail.isPSCodeListIdDirty()) {
            if (pSDEFGroupDetail.getPSCodeListId() != null) {
                if (pSDEFGroupDetail.getPSCodeListId() == null || pSDEFGroupDetail.getPSCodeListName() == null) {
                    PSCodeList pSCodeList = pSDEFGroupDetail.getPSCodeList();
                    pSDEFGroupDetail.setPSCodeListName(pSCodeList.getPSCodeListName());
                }
            } else {
                pSDEFGroupDetail.setPSCodeListName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_PSDEFUIMode(PSDEFGroupDetail pSDEFGroupDetail, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSDEFGroup(PSDEFGroupDetail pSDEFGroupDetail, boolean bl) throws Exception {
        if (pSDEFGroupDetail.isPSDEFGroupIdDirty()) {
            if (pSDEFGroupDetail.getPSDEFGroupId() != null) {
                if (pSDEFGroupDetail.getPSDEFGroupId() == null || pSDEFGroupDetail.getPSDEFGroupName() == null) {
                    PSDEFGroup pSDEFGroup = pSDEFGroupDetail.getPSDEFGroup();
                    pSDEFGroupDetail.setPSDEFGroupName(pSDEFGroup.getPSDEFGroupName());
                    pSDEFGroupDetail.setPSDEId(pSDEFGroup.getPSDEId());
                }
            } else {
                pSDEFGroupDetail.setPSDEFGroupName(null);
                pSDEFGroupDetail.setPSDEId(null);
            }
        }
    }

    protected void onFillEntityFullInfo_PSDEF(PSDEFGroupDetail pSDEFGroupDetail, boolean bl) throws Exception {
        if (pSDEFGroupDetail.isPSDEFIdDirty()) {
            if (pSDEFGroupDetail.getPSDEFId() != null) {
                if (pSDEFGroupDetail.getPSDEFId() == null || pSDEFGroupDetail.getPSDEFName() == null) {
                    PSDEField pSDEField = pSDEFGroupDetail.getPSDEF();
                    pSDEFGroupDetail.setPSDEFName(pSDEField.getPSDEFieldName());
                }
            } else {
                pSDEFGroupDetail.setPSDEFName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_LNPSLanRes(PSDEFGroupDetail pSDEFGroupDetail, boolean bl) throws Exception {
        if (pSDEFGroupDetail.isLNPSLanResIdDirty()) {
            if (pSDEFGroupDetail.getLNPSLanResId() != null) {
                if (pSDEFGroupDetail.getLNPSLanResId() == null || pSDEFGroupDetail.getLNPSLanResName() == null) {
                    PSLanguageRes pSLanguageRes = pSDEFGroupDetail.getLNPSLanRes();
                    pSDEFGroupDetail.setLNPSLanResName(pSLanguageRes.getPSLanguageResName());
                }
            } else {
                pSDEFGroupDetail.setLNPSLanResName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_PSSysValueRule(PSDEFGroupDetail pSDEFGroupDetail, boolean bl) throws Exception {
    }

    protected void onWriteBackParent(PSDEFGroupDetail pSDEFGroupDetail, boolean bl) throws Exception {
        super.onWriteBackParent(pSDEFGroupDetail, bl);
    }

    public ArrayList<PSDEFGroupDetail> selectByPSCodeList(PSCodeListBase pSCodeListBase) throws Exception {
        return this.selectByPSCodeList(pSCodeListBase, "", -1);
    }

    public ArrayList<PSDEFGroupDetail> selectByPSCodeList(PSCodeListBase pSCodeListBase, String string) throws Exception {
        return this.selectByPSCodeList(pSCodeListBase, string, -1);
    }

    public ArrayList<PSDEFGroupDetail> selectByPSCodeList(PSCodeListBase pSCodeListBase, String string, int n) throws Exception {
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

    public ArrayList<PSDEFGroupDetail> selectByPSDEFUIMode(PSDEFUIModeBase pSDEFUIModeBase) throws Exception {
        return this.selectByPSDEFUIMode(pSDEFUIModeBase, "", -1);
    }

    public ArrayList<PSDEFGroupDetail> selectByPSDEFUIMode(PSDEFUIModeBase pSDEFUIModeBase, String string) throws Exception {
        return this.selectByPSDEFUIMode(pSDEFUIModeBase, string, -1);
    }

    public ArrayList<PSDEFGroupDetail> selectByPSDEFUIMode(PSDEFUIModeBase pSDEFUIModeBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDEFUIMODEID", (Object)pSDEFUIModeBase.getPSDEFUIModeId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSDEFUIModeCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSDEFUIModeCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDEFGroupDetail> selectByPSDEFGroup(PSDEFGroupBase pSDEFGroupBase) throws Exception {
        return this.selectByPSDEFGroup(pSDEFGroupBase, "", -1);
    }

    public ArrayList<PSDEFGroupDetail> selectByPSDEFGroup(PSDEFGroupBase pSDEFGroupBase, String string) throws Exception {
        return this.selectByPSDEFGroup(pSDEFGroupBase, string, -1);
    }

    public ArrayList<PSDEFGroupDetail> selectByPSDEFGroup(PSDEFGroupBase pSDEFGroupBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDEFGROUPID", (Object)pSDEFGroupBase.getPSDEFGroupId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSDEFGroupCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSDEFGroupCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDEFGroupDetail> selectTempByPSDEFGroup(PSDEFGroupBase pSDEFGroupBase) throws Exception {
        return this.selectTempByPSDEFGroup(pSDEFGroupBase, "");
    }

    public ArrayList<PSDEFGroupDetail> selectTempByPSDEFGroup(PSDEFGroupBase pSDEFGroupBase, String string) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDEFGROUPID", (Object)pSDEFGroupBase.getPSDEFGroupId());
        selectCond.setOrderInfo(string);
        this.onFillSelectTempByPSDEFGroupCond(selectCond);
        return this.selectTemp((ISelectCond)selectCond);
    }

    protected void onFillSelectTempByPSDEFGroupCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDEFGroupDetail> selectByPSDEF(PSDEFieldBase pSDEFieldBase) throws Exception {
        return this.selectByPSDEF(pSDEFieldBase, "", -1);
    }

    public ArrayList<PSDEFGroupDetail> selectByPSDEF(PSDEFieldBase pSDEFieldBase, String string) throws Exception {
        return this.selectByPSDEF(pSDEFieldBase, string, -1);
    }

    public ArrayList<PSDEFGroupDetail> selectByPSDEF(PSDEFieldBase pSDEFieldBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDEFID", (Object)pSDEFieldBase.getPSDEFieldId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSDEFCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSDEFCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDEFGroupDetail> selectByLNPSLanRes(PSLanguageResBase pSLanguageResBase) throws Exception {
        return this.selectByLNPSLanRes(pSLanguageResBase, "", -1);
    }

    public ArrayList<PSDEFGroupDetail> selectByLNPSLanRes(PSLanguageResBase pSLanguageResBase, String string) throws Exception {
        return this.selectByLNPSLanRes(pSLanguageResBase, string, -1);
    }

    public ArrayList<PSDEFGroupDetail> selectByLNPSLanRes(PSLanguageResBase pSLanguageResBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("LNPSLANRESID", (Object)pSLanguageResBase.getPSLanguageResId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByLNPSLanResCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByLNPSLanResCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDEFGroupDetail> selectByPSSysValueRule(PSSysValueRuleBase pSSysValueRuleBase) throws Exception {
        return this.selectByPSSysValueRule(pSSysValueRuleBase, "", -1);
    }

    public ArrayList<PSDEFGroupDetail> selectByPSSysValueRule(PSSysValueRuleBase pSSysValueRuleBase, String string) throws Exception {
        return this.selectByPSSysValueRule(pSSysValueRuleBase, string, -1);
    }

    public ArrayList<PSDEFGroupDetail> selectByPSSysValueRule(PSSysValueRuleBase pSSysValueRuleBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSSYSVALUERULEID", (Object)pSSysValueRuleBase.getPSSysValueRuleId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSSysValueRuleCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSSysValueRuleCond(SelectCond selectCond) throws Exception {
    }

    public void testRemoveByPSCodeList(PSCodeList pSCodeList) throws Exception {
        ArrayList<PSDEFGroupDetail> arrayList = this.selectByPSCodeList(pSCodeList, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSCODELIST");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSCodeList);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEFGROUPDETAIL_PSCODELIST_PSCODELISTID", "", iDataEntityModel.getName(), "PSDEFGROUPDETAIL", iDataEntityModel.getDataInfo(pSCodeList), arrayList.get(0)));
        }
    }

    public void resetPSCodeList(PSCodeList pSCodeList) throws Exception {
        ArrayList<PSDEFGroupDetail> arrayList = this.selectByPSCodeList(pSCodeList);
        for (PSDEFGroupDetail pSDEFGroupDetail : arrayList) {
            PSDEFGroupDetail pSDEFGroupDetail2 = (PSDEFGroupDetail)this.getDEModel().createEntity();
            pSDEFGroupDetail2.setPSDEFGroupDetailId(pSDEFGroupDetail.getPSDEFGroupDetailId());
            pSDEFGroupDetail2.setPSCodeListId(null);
            this.update(pSDEFGroupDetail2);
        }
    }

    public void removeByPSCodeList(PSCodeList pSCodeList) throws Exception {
        final PSCodeList pSCodeList2 = pSCodeList;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEFGroupDetailServiceBase.this.onBeforeRemoveByPSCodeList(pSCodeList2);
                PSDEFGroupDetailServiceBase.this.internalRemoveByPSCodeList(pSCodeList2);
                PSDEFGroupDetailServiceBase.this.onAfterRemoveByPSCodeList(pSCodeList2);
            }
        });
    }

    protected void onBeforeRemoveByPSCodeList(PSCodeList pSCodeList) throws Exception {
    }

    protected void internalRemoveByPSCodeList(PSCodeList pSCodeList) throws Exception {
        ArrayList<PSDEFGroupDetail> arrayList = this.selectByPSCodeList(pSCodeList);
        this.onBeforeRemoveByPSCodeList(pSCodeList, arrayList);
        for (PSDEFGroupDetail pSDEFGroupDetail : arrayList) {
            this.remove(pSDEFGroupDetail);
        }
        this.onAfterRemoveByPSCodeList(pSCodeList, arrayList);
    }

    protected void onAfterRemoveByPSCodeList(PSCodeList pSCodeList) throws Exception {
    }

    protected void onBeforeRemoveByPSCodeList(PSCodeList pSCodeList, ArrayList<PSDEFGroupDetail> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSCodeList(PSCodeList pSCodeList, ArrayList<PSDEFGroupDetail> arrayList) throws Exception {
    }

    public void testRemoveByPSDEFUIMode(PSDEFUIMode pSDEFUIMode) throws Exception {
        ArrayList<PSDEFGroupDetail> arrayList = this.selectByPSDEFUIMode(pSDEFUIMode, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEFUIMODE");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDEFUIMode);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEFGROUPDETAIL_PSDEFFORMITEM_PSDEFUIMODEID", "", iDataEntityModel.getName(), "PSDEFGROUPDETAIL", iDataEntityModel.getDataInfo(pSDEFUIMode), arrayList.get(0)));
        }
    }

    public void resetPSDEFUIMode(PSDEFUIMode pSDEFUIMode) throws Exception {
        ArrayList<PSDEFGroupDetail> arrayList = this.selectByPSDEFUIMode(pSDEFUIMode);
        for (PSDEFGroupDetail pSDEFGroupDetail : arrayList) {
            PSDEFGroupDetail pSDEFGroupDetail2 = (PSDEFGroupDetail)this.getDEModel().createEntity();
            pSDEFGroupDetail2.setPSDEFGroupDetailId(pSDEFGroupDetail.getPSDEFGroupDetailId());
            pSDEFGroupDetail2.setPSDEFUIModeId(null);
            this.update(pSDEFGroupDetail2);
        }
    }

    public void removeByPSDEFUIMode(PSDEFUIMode pSDEFUIMode) throws Exception {
        final PSDEFUIMode pSDEFUIMode2 = pSDEFUIMode;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEFGroupDetailServiceBase.this.onBeforeRemoveByPSDEFUIMode(pSDEFUIMode2);
                PSDEFGroupDetailServiceBase.this.internalRemoveByPSDEFUIMode(pSDEFUIMode2);
                PSDEFGroupDetailServiceBase.this.onAfterRemoveByPSDEFUIMode(pSDEFUIMode2);
            }
        });
    }

    protected void onBeforeRemoveByPSDEFUIMode(PSDEFUIMode pSDEFUIMode) throws Exception {
    }

    protected void internalRemoveByPSDEFUIMode(PSDEFUIMode pSDEFUIMode) throws Exception {
        ArrayList<PSDEFGroupDetail> arrayList = this.selectByPSDEFUIMode(pSDEFUIMode);
        this.onBeforeRemoveByPSDEFUIMode(pSDEFUIMode, arrayList);
        for (PSDEFGroupDetail pSDEFGroupDetail : arrayList) {
            this.remove(pSDEFGroupDetail);
        }
        this.onAfterRemoveByPSDEFUIMode(pSDEFUIMode, arrayList);
    }

    protected void onAfterRemoveByPSDEFUIMode(PSDEFUIMode pSDEFUIMode) throws Exception {
    }

    protected void onBeforeRemoveByPSDEFUIMode(PSDEFUIMode pSDEFUIMode, ArrayList<PSDEFGroupDetail> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDEFUIMode(PSDEFUIMode pSDEFUIMode, ArrayList<PSDEFGroupDetail> arrayList) throws Exception {
    }

    public void testRemoveByPSDEFGroup(PSDEFGroup pSDEFGroup) throws Exception {
    }

    public void resetPSDEFGroup(PSDEFGroup pSDEFGroup) throws Exception {
        ArrayList<PSDEFGroupDetail> arrayList = this.selectByPSDEFGroup(pSDEFGroup);
        for (PSDEFGroupDetail pSDEFGroupDetail : arrayList) {
            PSDEFGroupDetail pSDEFGroupDetail2 = (PSDEFGroupDetail)this.getDEModel().createEntity();
            pSDEFGroupDetail2.setPSDEFGroupDetailId(pSDEFGroupDetail.getPSDEFGroupDetailId());
            pSDEFGroupDetail2.setPSDEFGroupId(null);
            this.update(pSDEFGroupDetail2);
        }
    }

    public void resetTempPSDEFGroup(PSDEFGroup pSDEFGroup) throws Exception {
        ArrayList<PSDEFGroupDetail> arrayList = this.selectTempByPSDEFGroup(pSDEFGroup);
        for (PSDEFGroupDetail pSDEFGroupDetail : arrayList) {
            PSDEFGroupDetail pSDEFGroupDetail2 = (PSDEFGroupDetail)this.getDEModel().createEntity();
            pSDEFGroupDetail2.setPSDEFGroupDetailId(pSDEFGroupDetail.getPSDEFGroupDetailId());
            pSDEFGroupDetail2.setPSDEFGroupId(null);
            this.updateTemp(pSDEFGroupDetail2);
        }
    }

    public void removeByPSDEFGroup(PSDEFGroup pSDEFGroup) throws Exception {
        final PSDEFGroup pSDEFGroup2 = pSDEFGroup;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEFGroupDetailServiceBase.this.onBeforeRemoveByPSDEFGroup(pSDEFGroup2);
                PSDEFGroupDetailServiceBase.this.internalRemoveByPSDEFGroup(pSDEFGroup2);
                PSDEFGroupDetailServiceBase.this.onAfterRemoveByPSDEFGroup(pSDEFGroup2);
            }
        });
    }

    protected void onBeforeRemoveByPSDEFGroup(PSDEFGroup pSDEFGroup) throws Exception {
    }

    protected void internalRemoveByPSDEFGroup(PSDEFGroup pSDEFGroup) throws Exception {
        ArrayList<PSDEFGroupDetail> arrayList = this.selectByPSDEFGroup(pSDEFGroup);
        this.onBeforeRemoveByPSDEFGroup(pSDEFGroup, arrayList);
        for (PSDEFGroupDetail pSDEFGroupDetail : arrayList) {
            this.remove(pSDEFGroupDetail);
        }
        this.onAfterRemoveByPSDEFGroup(pSDEFGroup, arrayList);
    }

    protected void onAfterRemoveByPSDEFGroup(PSDEFGroup pSDEFGroup) throws Exception {
    }

    protected void onBeforeRemoveByPSDEFGroup(PSDEFGroup pSDEFGroup, ArrayList<PSDEFGroupDetail> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDEFGroup(PSDEFGroup pSDEFGroup, ArrayList<PSDEFGroupDetail> arrayList) throws Exception {
    }

    public void testRemoveByPSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSDEFGroupDetail> arrayList = this.selectByPSDEF(pSDEField, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEFIELD");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDEField);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEFGROUPDETAIL_PSDEFIELD_PSDEFID", "", iDataEntityModel.getName(), "PSDEFGROUPDETAIL", iDataEntityModel.getDataInfo(pSDEField), arrayList.get(0)));
        }
    }

    public void resetPSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSDEFGroupDetail> arrayList = this.selectByPSDEF(pSDEField);
        for (PSDEFGroupDetail pSDEFGroupDetail : arrayList) {
            PSDEFGroupDetail pSDEFGroupDetail2 = (PSDEFGroupDetail)this.getDEModel().createEntity();
            pSDEFGroupDetail2.setPSDEFGroupDetailId(pSDEFGroupDetail.getPSDEFGroupDetailId());
            pSDEFGroupDetail2.setPSDEFId(null);
            this.update(pSDEFGroupDetail2);
        }
    }

    public void removeByPSDEF(PSDEField pSDEField) throws Exception {
        final PSDEField pSDEField2 = pSDEField;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEFGroupDetailServiceBase.this.onBeforeRemoveByPSDEF(pSDEField2);
                PSDEFGroupDetailServiceBase.this.internalRemoveByPSDEF(pSDEField2);
                PSDEFGroupDetailServiceBase.this.onAfterRemoveByPSDEF(pSDEField2);
            }
        });
    }

    protected void onBeforeRemoveByPSDEF(PSDEField pSDEField) throws Exception {
    }

    protected void internalRemoveByPSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSDEFGroupDetail> arrayList = this.selectByPSDEF(pSDEField);
        this.onBeforeRemoveByPSDEF(pSDEField, arrayList);
        for (PSDEFGroupDetail pSDEFGroupDetail : arrayList) {
            this.remove(pSDEFGroupDetail);
        }
        this.onAfterRemoveByPSDEF(pSDEField, arrayList);
    }

    protected void onAfterRemoveByPSDEF(PSDEField pSDEField) throws Exception {
    }

    protected void onBeforeRemoveByPSDEF(PSDEField pSDEField, ArrayList<PSDEFGroupDetail> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDEF(PSDEField pSDEField, ArrayList<PSDEFGroupDetail> arrayList) throws Exception {
    }

    public void testRemoveByLNPSLanRes(PSLanguageRes pSLanguageRes) throws Exception {
        ArrayList<PSDEFGroupDetail> arrayList = this.selectByLNPSLanRes(pSLanguageRes, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSLANGUAGERES");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSLanguageRes);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEFGROUPDETAIL_PSLANGUAGERES_LNPSLANRESID", "", iDataEntityModel.getName(), "PSDEFGROUPDETAIL", iDataEntityModel.getDataInfo(pSLanguageRes), arrayList.get(0)));
        }
    }

    public void resetLNPSLanRes(PSLanguageRes pSLanguageRes) throws Exception {
        ArrayList<PSDEFGroupDetail> arrayList = this.selectByLNPSLanRes(pSLanguageRes);
        for (PSDEFGroupDetail pSDEFGroupDetail : arrayList) {
            PSDEFGroupDetail pSDEFGroupDetail2 = (PSDEFGroupDetail)this.getDEModel().createEntity();
            pSDEFGroupDetail2.setPSDEFGroupDetailId(pSDEFGroupDetail.getPSDEFGroupDetailId());
            pSDEFGroupDetail2.setLNPSLanResId(null);
            this.update(pSDEFGroupDetail2);
        }
    }

    public void removeByLNPSLanRes(PSLanguageRes pSLanguageRes) throws Exception {
        final PSLanguageRes pSLanguageRes2 = pSLanguageRes;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEFGroupDetailServiceBase.this.onBeforeRemoveByLNPSLanRes(pSLanguageRes2);
                PSDEFGroupDetailServiceBase.this.internalRemoveByLNPSLanRes(pSLanguageRes2);
                PSDEFGroupDetailServiceBase.this.onAfterRemoveByLNPSLanRes(pSLanguageRes2);
            }
        });
    }

    protected void onBeforeRemoveByLNPSLanRes(PSLanguageRes pSLanguageRes) throws Exception {
    }

    protected void internalRemoveByLNPSLanRes(PSLanguageRes pSLanguageRes) throws Exception {
        ArrayList<PSDEFGroupDetail> arrayList = this.selectByLNPSLanRes(pSLanguageRes);
        this.onBeforeRemoveByLNPSLanRes(pSLanguageRes, arrayList);
        for (PSDEFGroupDetail pSDEFGroupDetail : arrayList) {
            this.remove(pSDEFGroupDetail);
        }
        this.onAfterRemoveByLNPSLanRes(pSLanguageRes, arrayList);
    }

    protected void onAfterRemoveByLNPSLanRes(PSLanguageRes pSLanguageRes) throws Exception {
    }

    protected void onBeforeRemoveByLNPSLanRes(PSLanguageRes pSLanguageRes, ArrayList<PSDEFGroupDetail> arrayList) throws Exception {
    }

    protected void onAfterRemoveByLNPSLanRes(PSLanguageRes pSLanguageRes, ArrayList<PSDEFGroupDetail> arrayList) throws Exception {
    }

    public void testRemoveByPSSysValueRule(PSSysValueRule pSSysValueRule) throws Exception {
        ArrayList<PSDEFGroupDetail> arrayList = this.selectByPSSysValueRule(pSSysValueRule, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSVALUERULE");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSSysValueRule);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEFGROUPDETAIL_PSSYSVALUERULE_PSSYSVALUERULEID", "", iDataEntityModel.getName(), "PSDEFGROUPDETAIL", iDataEntityModel.getDataInfo(pSSysValueRule), arrayList.get(0)));
        }
    }

    public void resetPSSysValueRule(PSSysValueRule pSSysValueRule) throws Exception {
        ArrayList<PSDEFGroupDetail> arrayList = this.selectByPSSysValueRule(pSSysValueRule);
        for (PSDEFGroupDetail pSDEFGroupDetail : arrayList) {
            PSDEFGroupDetail pSDEFGroupDetail2 = (PSDEFGroupDetail)this.getDEModel().createEntity();
            pSDEFGroupDetail2.setPSDEFGroupDetailId(pSDEFGroupDetail.getPSDEFGroupDetailId());
            pSDEFGroupDetail2.setPSSysValueRuleId(null);
            this.update(pSDEFGroupDetail2);
        }
    }

    public void removeByPSSysValueRule(PSSysValueRule pSSysValueRule) throws Exception {
        final PSSysValueRule pSSysValueRule2 = pSSysValueRule;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEFGroupDetailServiceBase.this.onBeforeRemoveByPSSysValueRule(pSSysValueRule2);
                PSDEFGroupDetailServiceBase.this.internalRemoveByPSSysValueRule(pSSysValueRule2);
                PSDEFGroupDetailServiceBase.this.onAfterRemoveByPSSysValueRule(pSSysValueRule2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysValueRule(PSSysValueRule pSSysValueRule) throws Exception {
    }

    protected void internalRemoveByPSSysValueRule(PSSysValueRule pSSysValueRule) throws Exception {
        ArrayList<PSDEFGroupDetail> arrayList = this.selectByPSSysValueRule(pSSysValueRule);
        this.onBeforeRemoveByPSSysValueRule(pSSysValueRule, arrayList);
        for (PSDEFGroupDetail pSDEFGroupDetail : arrayList) {
            this.remove(pSDEFGroupDetail);
        }
        this.onAfterRemoveByPSSysValueRule(pSSysValueRule, arrayList);
    }

    protected void onAfterRemoveByPSSysValueRule(PSSysValueRule pSSysValueRule) throws Exception {
    }

    protected void onBeforeRemoveByPSSysValueRule(PSSysValueRule pSSysValueRule, ArrayList<PSDEFGroupDetail> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysValueRule(PSSysValueRule pSSysValueRule, ArrayList<PSDEFGroupDetail> arrayList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(PSDEFGroupDetail pSDEFGroupDetail) throws Exception {
        super.onBeforeRemove(pSDEFGroupDetail);
    }

    public void removeTempByPSDEFGroup(PSDEFGroup pSDEFGroup) throws Exception {
        final PSDEFGroup pSDEFGroup2 = pSDEFGroup;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEFGroupDetailServiceBase.this.onBeforeRemoveTempByPSDEFGroup(pSDEFGroup2);
                PSDEFGroupDetailServiceBase.this.internalRemoveTempByPSDEFGroup(pSDEFGroup2);
                PSDEFGroupDetailServiceBase.this.onAfterRemoveTempByPSDEFGroup(pSDEFGroup2);
            }
        });
    }

    protected void onBeforeRemoveTempByPSDEFGroup(PSDEFGroup pSDEFGroup) throws Exception {
    }

    protected void internalRemoveTempByPSDEFGroup(PSDEFGroup pSDEFGroup) throws Exception {
        ArrayList<PSDEFGroupDetail> arrayList = this.selectTempByPSDEFGroup(pSDEFGroup);
        this.onBeforeRemoveTempByPSDEFGroup(pSDEFGroup, arrayList);
        for (PSDEFGroupDetail pSDEFGroupDetail : arrayList) {
            this.removeTemp(pSDEFGroupDetail);
        }
        this.onAfterRemoveTempByPSDEFGroup(pSDEFGroup, arrayList);
    }

    protected void onAfterRemoveTempByPSDEFGroup(PSDEFGroup pSDEFGroup) throws Exception {
    }

    protected void onBeforeRemoveTempByPSDEFGroup(PSDEFGroup pSDEFGroup, ArrayList<PSDEFGroupDetail> arrayList) throws Exception {
    }

    protected void onAfterRemoveTempByPSDEFGroup(PSDEFGroup pSDEFGroup, ArrayList<PSDEFGroupDetail> arrayList) throws Exception {
    }

    protected void replaceParentInfo(PSDEFGroupDetail pSDEFGroupDetail, CloneSession cloneSession) throws Exception {
        IEntity iEntity;
        super.replaceParentInfo(pSDEFGroupDetail, cloneSession);
        if (pSDEFGroupDetail.getPSCodeListId() != null && (iEntity = cloneSession.getEntity("PSCODELIST", (Object)pSDEFGroupDetail.getPSCodeListId())) != null) {
            this.onFillParentInfo_PSCodeList(pSDEFGroupDetail, (PSCodeList)iEntity);
        }
        if (pSDEFGroupDetail.getPSDEFUIModeId() != null && (iEntity = cloneSession.getEntity("PSDEFFORMITEM", (Object)pSDEFGroupDetail.getPSDEFUIModeId())) != null) {
            this.onFillParentInfo_PSDEFUIMode(pSDEFGroupDetail, (PSDEFUIMode)iEntity);
        }
        if (pSDEFGroupDetail.getPSDEFGroupId() != null && (iEntity = cloneSession.getEntity("PSDEFGROUP", (Object)pSDEFGroupDetail.getPSDEFGroupId())) != null) {
            this.onFillParentInfo_PSDEFGroup(pSDEFGroupDetail, (PSDEFGroup)iEntity);
        }
        if (pSDEFGroupDetail.getPSDEFId() != null && (iEntity = cloneSession.getEntity("PSDEFIELD", (Object)pSDEFGroupDetail.getPSDEFId())) != null) {
            this.onFillParentInfo_PSDEF(pSDEFGroupDetail, (PSDEField)iEntity);
        }
        if (pSDEFGroupDetail.getLNPSLanResId() != null && (iEntity = cloneSession.getEntity("PSLANGUAGERES", (Object)pSDEFGroupDetail.getLNPSLanResId())) != null) {
            this.onFillParentInfo_LNPSLanRes(pSDEFGroupDetail, (PSLanguageRes)iEntity);
        }
        if (pSDEFGroupDetail.getPSSysValueRuleId() != null && (iEntity = cloneSession.getEntity("PSSYSVALUERULE", (Object)pSDEFGroupDetail.getPSSysValueRuleId())) != null) {
            this.onFillParentInfo_PSSysValueRule(pSDEFGroupDetail, (PSSysValueRule)iEntity);
        }
    }

    protected void onRemoveEntityUncopyValues(PSDEFGroupDetail pSDEFGroupDetail, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues(pSDEFGroupDetail, bl);
    }

    protected void onCheckEntity(boolean bl, PSDEFGroupDetail pSDEFGroupDetail, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_AllowEmpty(bl, pSDEFGroupDetail, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_CodeName(bl, pSDEFGroupDetail, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_CodeName2(bl, pSDEFGroupDetail, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_DefaultValue(bl, pSDEFGroupDetail, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_DetailParam(bl, pSDEFGroupDetail, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_DetailParam2(bl, pSDEFGroupDetail, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_DefaultValueType(bl, pSDEFGroupDetail, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_EnableUserInput(bl, pSDEFGroupDetail, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_JsonFormat(bl, pSDEFGroupDetail, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_LNPSLanResId(bl, pSDEFGroupDetail, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_LNPSLanResName(bl, pSDEFGroupDetail, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_MaxValue(bl, pSDEFGroupDetail, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Memo(bl, pSDEFGroupDetail, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_MinStrLength(bl, pSDEFGroupDetail, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_MinValue(bl, pSDEFGroupDetail, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ModifyUserInput(bl, pSDEFGroupDetail, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_OrderValue(bl, pSDEFGroupDetail, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Precision2(bl, pSDEFGroupDetail, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSCodeListId(bl, pSDEFGroupDetail, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSCodeListName(bl, pSDEFGroupDetail, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEFGroupDetailId(bl, pSDEFGroupDetail, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEFGroupDetailName(bl, pSDEFGroupDetail, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEFGroupId(bl, pSDEFGroupDetail, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEFGroupName(bl, pSDEFGroupDetail, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEFId(bl, pSDEFGroupDetail, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEFName(bl, pSDEFGroupDetail, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEFUIModeId(bl, pSDEFGroupDetail, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysValueRuleId(bl, pSDEFGroupDetail, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_SearchModes(bl, pSDEFGroupDetail, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ServiceCodeName(bl, pSDEFGroupDetail, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_StrLength(bl, pSDEFGroupDetail, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserCat(bl, pSDEFGroupDetail, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag(bl, pSDEFGroupDetail, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag2(bl, pSDEFGroupDetail, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag3(bl, pSDEFGroupDetail, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag4(bl, pSDEFGroupDetail, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ValidFlag(bl, pSDEFGroupDetail, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, pSDEFGroupDetail, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_AllowEmpty(boolean bl, PSDEFGroupDetail pSDEFGroupDetail, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFGroupDetail.isAllowEmptyDirty() : !pSDEFGroupDetail.isAllowEmptyDirty()) {
            return null;
        }
        Integer n = pSDEFGroupDetail.getAllowEmpty();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_AllowEmpty_Default(pSDEFGroupDetail, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ALLOWEMPTY");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_CodeName(boolean bl, PSDEFGroupDetail pSDEFGroupDetail, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFGroupDetail.isCodeNameDirty() : !pSDEFGroupDetail.isCodeNameDirty()) {
            return null;
        }
        String string = pSDEFGroupDetail.getCodeName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_CodeName_Default(pSDEFGroupDetail, bl2, bl3);
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
                string3 = "PSDEFGROUPID";
                String string4 = this.checkFieldDupRule(this.getPSDEFGroupDetailDEModel(), "CODENAME", string3, pSDEFGroupDetail, bl2, bl3);
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

    protected EntityFieldError onCheckField_CodeName2(boolean bl, PSDEFGroupDetail pSDEFGroupDetail, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFGroupDetail.isCodeName2Dirty() : !pSDEFGroupDetail.isCodeName2Dirty()) {
            return null;
        }
        String string = pSDEFGroupDetail.getCodeName2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_CodeName2_Default(pSDEFGroupDetail, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CODENAME2");
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
                string3 = "PSDEFGROUPID";
                String string4 = this.checkFieldDupRule(this.getPSDEFGroupDetailDEModel(), "CODENAME2", string3, pSDEFGroupDetail, bl2, bl3);
                if (!StringHelper.isNullOrEmpty((String)string4)) {
                    EntityFieldError entityFieldError = new EntityFieldError();
                    entityFieldError.setFieldName("CODENAME2");
                    entityFieldError.setErrorType(3);
                    entityFieldError.setErrorInfo(string4);
                    return entityFieldError;
                }
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_DefaultValue(boolean bl, PSDEFGroupDetail pSDEFGroupDetail, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFGroupDetail.isDefaultValueDirty() : !pSDEFGroupDetail.isDefaultValueDirty()) {
            return null;
        }
        String string = pSDEFGroupDetail.getDefaultValue();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_DefaultValue_Default(pSDEFGroupDetail, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DEFAULTVALUE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_DetailParam(boolean bl, PSDEFGroupDetail pSDEFGroupDetail, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFGroupDetail.isDetailParamDirty() : !pSDEFGroupDetail.isDetailParamDirty()) {
            return null;
        }
        String string = pSDEFGroupDetail.getDetailParam();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_DetailParam_Default(pSDEFGroupDetail, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DETAILPARAM");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_DetailParam2(boolean bl, PSDEFGroupDetail pSDEFGroupDetail, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFGroupDetail.isDetailParam2Dirty() : !pSDEFGroupDetail.isDetailParam2Dirty()) {
            return null;
        }
        String string = pSDEFGroupDetail.getDetailParam2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_DetailParam2_Default(pSDEFGroupDetail, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DETAILPARAM2");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_DefaultValueType(boolean bl, PSDEFGroupDetail pSDEFGroupDetail, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFGroupDetail.isDefaultValueTypeDirty() : !pSDEFGroupDetail.isDefaultValueTypeDirty()) {
            return null;
        }
        String string = pSDEFGroupDetail.getDefaultValueType();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_DefaultValueType_Default(pSDEFGroupDetail, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DVT");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_EnableUserInput(boolean bl, PSDEFGroupDetail pSDEFGroupDetail, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFGroupDetail.isEnableUserInputDirty() : !pSDEFGroupDetail.isEnableUserInputDirty()) {
            return null;
        }
        Integer n = pSDEFGroupDetail.getEnableUserInput();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_EnableUserInput_Default(pSDEFGroupDetail, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ENABLEUSERINPUT");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_JsonFormat(boolean bl, PSDEFGroupDetail pSDEFGroupDetail, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFGroupDetail.isJsonFormatDirty() : !pSDEFGroupDetail.isJsonFormatDirty()) {
            return null;
        }
        String string = pSDEFGroupDetail.getJsonFormat();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_JsonFormat_Default(pSDEFGroupDetail, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("JSONFORMAT");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_LNPSLanResId(boolean bl, PSDEFGroupDetail pSDEFGroupDetail, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFGroupDetail.isLNPSLanResIdDirty() : !pSDEFGroupDetail.isLNPSLanResIdDirty()) {
            return null;
        }
        String string = pSDEFGroupDetail.getLNPSLanResId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_LNPSLanResId_Default(pSDEFGroupDetail, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("LNPSLANRESID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_LNPSLanResName(boolean bl, PSDEFGroupDetail pSDEFGroupDetail, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFGroupDetail.isLNPSLanResNameDirty() : !pSDEFGroupDetail.isLNPSLanResNameDirty()) {
            return null;
        }
        String string = pSDEFGroupDetail.getLNPSLanResName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_LNPSLanResName_Default(pSDEFGroupDetail, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("LNPSLANRESNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_MaxValue(boolean bl, PSDEFGroupDetail pSDEFGroupDetail, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFGroupDetail.isMaxValueDirty() : !pSDEFGroupDetail.isMaxValueDirty()) {
            return null;
        }
        String string = pSDEFGroupDetail.getMaxValue();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_MaxValue_Default(pSDEFGroupDetail, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("MAXVALUE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Memo(boolean bl, PSDEFGroupDetail pSDEFGroupDetail, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFGroupDetail.isMemoDirty() : !pSDEFGroupDetail.isMemoDirty()) {
            return null;
        }
        String string = pSDEFGroupDetail.getMemo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Memo_Default(pSDEFGroupDetail, bl2, bl3);
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

    protected EntityFieldError onCheckField_MinStrLength(boolean bl, PSDEFGroupDetail pSDEFGroupDetail, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFGroupDetail.isMinStrLengthDirty() : !pSDEFGroupDetail.isMinStrLengthDirty()) {
            return null;
        }
        Integer n = pSDEFGroupDetail.getMinStrLength();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_MinStrLength_Default(pSDEFGroupDetail, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("MINSTRLENGTH");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_MinValue(boolean bl, PSDEFGroupDetail pSDEFGroupDetail, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFGroupDetail.isMinValueDirty() : !pSDEFGroupDetail.isMinValueDirty()) {
            return null;
        }
        String string = pSDEFGroupDetail.getMinValue();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_MinValue_Default(pSDEFGroupDetail, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("MINVALUE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ModifyUserInput(boolean bl, PSDEFGroupDetail pSDEFGroupDetail, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFGroupDetail.isModifyUserInputDirty() : !pSDEFGroupDetail.isModifyUserInputDirty()) {
            return null;
        }
        Integer n = pSDEFGroupDetail.getModifyUserInput();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_ModifyUserInput_Default(pSDEFGroupDetail, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("MODIFYUSERINPUT");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_OrderValue(boolean bl, PSDEFGroupDetail pSDEFGroupDetail, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFGroupDetail.isOrderValueDirty() : !pSDEFGroupDetail.isOrderValueDirty()) {
            return null;
        }
        Integer n = pSDEFGroupDetail.getOrderValue();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_OrderValue_Default(pSDEFGroupDetail, bl2, bl3);
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

    protected EntityFieldError onCheckField_Precision2(boolean bl, PSDEFGroupDetail pSDEFGroupDetail, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFGroupDetail.isPrecision2Dirty() : !pSDEFGroupDetail.isPrecision2Dirty()) {
            return null;
        }
        Integer n = pSDEFGroupDetail.getPrecision2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_Precision2_Default(pSDEFGroupDetail, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PRECISION2");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSCodeListId(boolean bl, PSDEFGroupDetail pSDEFGroupDetail, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFGroupDetail.isPSCodeListIdDirty() : !pSDEFGroupDetail.isPSCodeListIdDirty()) {
            return null;
        }
        String string = pSDEFGroupDetail.getPSCodeListId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSCodeListId_Default(pSDEFGroupDetail, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSCodeListName(boolean bl, PSDEFGroupDetail pSDEFGroupDetail, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFGroupDetail.isPSCodeListNameDirty() : !pSDEFGroupDetail.isPSCodeListNameDirty()) {
            return null;
        }
        String string = pSDEFGroupDetail.getPSCodeListName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSCodeListName_Default(pSDEFGroupDetail, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSCODELISTNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDEFGroupDetailId(boolean bl, PSDEFGroupDetail pSDEFGroupDetail, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFGroupDetail.isPSDEFGroupDetailIdDirty() && !bl2 : !pSDEFGroupDetail.isPSDEFGroupDetailIdDirty()) {
            return null;
        }
        String string = pSDEFGroupDetail.getPSDEFGroupDetailId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEFGROUPDETAILID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEFGroupDetailId_Default(pSDEFGroupDetail, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEFGROUPDETAILID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDEFGroupDetailName(boolean bl, PSDEFGroupDetail pSDEFGroupDetail, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFGroupDetail.isPSDEFGroupDetailNameDirty() && !bl2 : !pSDEFGroupDetail.isPSDEFGroupDetailNameDirty()) {
            return null;
        }
        String string = pSDEFGroupDetail.getPSDEFGroupDetailName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEFGROUPDETAILNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEFGroupDetailName_Default(pSDEFGroupDetail, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEFGROUPDETAILNAME");
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
                string3 = "PSDEFGROUPID";
                String string4 = this.checkFieldDupRule(this.getPSDEFGroupDetailDEModel(), "PSDEFGROUPDETAILNAME", string3, pSDEFGroupDetail, bl2, bl3);
                if (!StringHelper.isNullOrEmpty((String)string4)) {
                    EntityFieldError entityFieldError = new EntityFieldError();
                    entityFieldError.setFieldName("PSDEFGROUPDETAILNAME");
                    entityFieldError.setErrorType(3);
                    entityFieldError.setErrorInfo(string4);
                    return entityFieldError;
                }
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDEFGroupId(boolean bl, PSDEFGroupDetail pSDEFGroupDetail, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFGroupDetail.isPSDEFGroupIdDirty() && !bl2 : !pSDEFGroupDetail.isPSDEFGroupIdDirty()) {
            return null;
        }
        String string = pSDEFGroupDetail.getPSDEFGroupId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEFGROUPID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEFGroupId_Default(pSDEFGroupDetail, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEFGROUPID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDEFGroupName(boolean bl, PSDEFGroupDetail pSDEFGroupDetail, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFGroupDetail.isPSDEFGroupNameDirty() : !pSDEFGroupDetail.isPSDEFGroupNameDirty()) {
            return null;
        }
        String string = pSDEFGroupDetail.getPSDEFGroupName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEFGroupName_Default(pSDEFGroupDetail, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEFGROUPNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDEFId(boolean bl, PSDEFGroupDetail pSDEFGroupDetail, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFGroupDetail.isPSDEFIdDirty() && !bl2 : !pSDEFGroupDetail.isPSDEFIdDirty()) {
            return null;
        }
        String string = pSDEFGroupDetail.getPSDEFId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEFID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEFId_Default(pSDEFGroupDetail, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEFID");
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
                string3 = "PSDEFGROUPID";
                String string4 = this.checkFieldDupRule(this.getPSDEFGroupDetailDEModel(), "PSDEFID", string3, pSDEFGroupDetail, bl2, bl3);
                if (!StringHelper.isNullOrEmpty((String)string4)) {
                    EntityFieldError entityFieldError = new EntityFieldError();
                    entityFieldError.setFieldName("PSDEFID");
                    entityFieldError.setErrorType(3);
                    entityFieldError.setErrorInfo(string4);
                    return entityFieldError;
                }
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDEFName(boolean bl, PSDEFGroupDetail pSDEFGroupDetail, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFGroupDetail.isPSDEFNameDirty() && !bl2 : !pSDEFGroupDetail.isPSDEFNameDirty()) {
            return null;
        }
        String string = pSDEFGroupDetail.getPSDEFName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEFNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEFName_Default(pSDEFGroupDetail, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEFNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDEFUIModeId(boolean bl, PSDEFGroupDetail pSDEFGroupDetail, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFGroupDetail.isPSDEFUIModeIdDirty() : !pSDEFGroupDetail.isPSDEFUIModeIdDirty()) {
            return null;
        }
        String string = pSDEFGroupDetail.getPSDEFUIModeId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEFUIModeId_Default(pSDEFGroupDetail, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEFUIMODEID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSysValueRuleId(boolean bl, PSDEFGroupDetail pSDEFGroupDetail, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFGroupDetail.isPSSysValueRuleIdDirty() : !pSDEFGroupDetail.isPSSysValueRuleIdDirty()) {
            return null;
        }
        String string = pSDEFGroupDetail.getPSSysValueRuleId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysValueRuleId_Default(pSDEFGroupDetail, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSVALUERULEID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_SearchModes(boolean bl, PSDEFGroupDetail pSDEFGroupDetail, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFGroupDetail.isSearchModesDirty() : !pSDEFGroupDetail.isSearchModesDirty()) {
            return null;
        }
        String string = pSDEFGroupDetail.getSearchModes();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_SearchModes_Default(pSDEFGroupDetail, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("SEARCHMODES");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ServiceCodeName(boolean bl, PSDEFGroupDetail pSDEFGroupDetail, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFGroupDetail.isServiceCodeNameDirty() : !pSDEFGroupDetail.isServiceCodeNameDirty()) {
            return null;
        }
        String string = pSDEFGroupDetail.getServiceCodeName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_ServiceCodeName_Default(pSDEFGroupDetail, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("SERVICECODENAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_StrLength(boolean bl, PSDEFGroupDetail pSDEFGroupDetail, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFGroupDetail.isStrLengthDirty() : !pSDEFGroupDetail.isStrLengthDirty()) {
            return null;
        }
        Integer n = pSDEFGroupDetail.getStrLength();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_StrLength_Default(pSDEFGroupDetail, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("STRLENGTH");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_UserCat(boolean bl, PSDEFGroupDetail pSDEFGroupDetail, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFGroupDetail.isUserCatDirty() : !pSDEFGroupDetail.isUserCatDirty()) {
            return null;
        }
        String string = pSDEFGroupDetail.getUserCat();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserCat_Default(pSDEFGroupDetail, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag(boolean bl, PSDEFGroupDetail pSDEFGroupDetail, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFGroupDetail.isUserTagDirty() : !pSDEFGroupDetail.isUserTagDirty()) {
            return null;
        }
        String string = pSDEFGroupDetail.getUserTag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag_Default(pSDEFGroupDetail, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag2(boolean bl, PSDEFGroupDetail pSDEFGroupDetail, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFGroupDetail.isUserTag2Dirty() : !pSDEFGroupDetail.isUserTag2Dirty()) {
            return null;
        }
        String string = pSDEFGroupDetail.getUserTag2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag2_Default(pSDEFGroupDetail, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag3(boolean bl, PSDEFGroupDetail pSDEFGroupDetail, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFGroupDetail.isUserTag3Dirty() : !pSDEFGroupDetail.isUserTag3Dirty()) {
            return null;
        }
        String string = pSDEFGroupDetail.getUserTag3();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag3_Default(pSDEFGroupDetail, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag4(boolean bl, PSDEFGroupDetail pSDEFGroupDetail, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFGroupDetail.isUserTag4Dirty() : !pSDEFGroupDetail.isUserTag4Dirty()) {
            return null;
        }
        String string = pSDEFGroupDetail.getUserTag4();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag4_Default(pSDEFGroupDetail, bl2, bl3);
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

    protected EntityFieldError onCheckField_ValidFlag(boolean bl, PSDEFGroupDetail pSDEFGroupDetail, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFGroupDetail.isValidFlagDirty() && !bl2 : !pSDEFGroupDetail.isValidFlagDirty()) {
            return null;
        }
        Integer n = pSDEFGroupDetail.getValidFlag();
        if (bl) {
            if (bl2 && n == null) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("VALIDFLAG");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string = null;
            string = this.onTestValueRule_ValidFlag_Default(pSDEFGroupDetail, bl2, bl3);
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

    protected void onSyncEntity(PSDEFGroupDetail pSDEFGroupDetail, boolean bl) throws Exception {
        super.onSyncEntity(pSDEFGroupDetail, bl);
    }

    protected void onSyncIndexEntities(PSDEFGroupDetail pSDEFGroupDetail, boolean bl) throws Exception {
        super.onSyncIndexEntities(pSDEFGroupDetail, bl);
    }

    public Object getDataContextValue(PSDEFGroupDetail pSDEFGroupDetail, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null) {
            // empty if block
        }
        if ((object = super.getDataContextValue(pSDEFGroupDetail, string, iDataContextParam)) != null) {
            return object;
        }
        PSDEFGroup pSDEFGroup = pSDEFGroupDetail.getPSDEFGroup();
        if (pSDEFGroup != null && pSDEFGroup.contains(string)) {
            return pSDEFGroup.get(string);
        }
        PSDEField pSDEField = pSDEFGroupDetail.getPSDEF();
        if (pSDEField != null && pSDEField.contains(string)) {
            return pSDEField.get(string);
        }
        return null;
    }

    protected void onExportMajorModel(PSDEFGroupDetail pSDEFGroupDetail, ArrayList<JSONObject> arrayList, int n) throws Exception {
        super.onExportMajorModel(pSDEFGroupDetail, arrayList, n);
    }

    protected String onTestValueRule(String string, String string2, IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        if (StringHelper.compare((String)string, (String)"ALLOWEMPTY", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_AllowEmpty_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CODENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CodeName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CODENAME2", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CodeName2_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATEDATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateDate_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATEMAN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateMan_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DEFAULTVALUE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DefaultValue_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DETAILPARAM", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DetailParam_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DETAILPARAM2", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DetailParam2_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DVT", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DefaultValueType_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ENABLEUSERINPUT", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_EnableUserInput_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"JSONFORMAT", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_JsonFormat_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"LNPSLANRESID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_LNPSLanResId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"LNPSLANRESNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_LNPSLanResName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MAXVALUE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_MaxValue_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MEMO", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Memo_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MINSTRLENGTH", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_MinStrLength_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MINVALUE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_MinValue_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MODIFYUSERINPUT", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ModifyUserInput_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ORDERVALUE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_OrderValue_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PRECISION2", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Precision2_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSCODELISTID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSCodeListId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSCODELISTNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSCodeListName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEFGROUPDETAILID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEFGroupDetailId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEFGROUPDETAILNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEFGroupDetailName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEFGROUPID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEFGroupId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEFGROUPNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEFGroupName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEFID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEFId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEFNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEFName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEFUIMODEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEFUIModeId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEFUIMODENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEFUIModeName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSVALUERULEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysValueRuleId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSVALUERULENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysValueRuleName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"SEARCHMODES", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_SearchModes_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"SERVICECODENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ServiceCodeName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"STRLENGTH", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_StrLength_Default(iEntity, bl, bl2);
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

    protected String onTestValueRule_AllowEmpty_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
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

    protected String onTestValueRule_CodeName2_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("CODENAME2", iEntity, bl2, null, false, 50, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]", false) && this.checkFieldRegExRule("CODENAME2", iEntity, bl2, "[a-zA-Z_$][a-zA-Z0-9_$]*", "\u5185\u5bb9\u53ea\u80fd\u7531\u5b57\u6bcd\u3001\u6570\u5b57\u3001\u4e0b\u5212\u7ebf\u7ec4\u6210\uff0c\u4e14\u5f00\u59cb\u5fc5\u987b\u4e3a\u5b57\u6bcd", false)) {
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

    protected String onTestValueRule_DefaultValue_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("DEFAULTVALUE", iEntity, bl2, null, false, 2000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[2000]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[2000]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_DetailParam_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("DETAILPARAM", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_DetailParam2_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("DETAILPARAM2", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_DefaultValueType_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("DVT", iEntity, bl2, null, false, 50, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_EnableUserInput_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_JsonFormat_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("JSONFORMAT", iEntity, bl2, null, false, 50, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_LNPSLanResId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("LNPSLANRESID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_LNPSLanResName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("LNPSLANRESNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_MaxValue_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("MAXVALUE", iEntity, bl2, null, false, 50, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]";
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

    protected String onTestValueRule_MinStrLength_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_MinValue_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("MINVALUE", iEntity, bl2, null, false, 50, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_ModifyUserInput_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_OrderValue_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_Precision2_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
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

    protected String onTestValueRule_PSDEFGroupDetailId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEFGROUPDETAILID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDEFGroupDetailName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEFGROUPDETAILNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDEFGroupId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEFGROUPID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDEFGroupName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEFGROUPNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDEFId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEFID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDEFName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEFNAME", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDEFUIModeId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEFUIMODEID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDEFUIModeName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEFUIMODENAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDEId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysValueRuleId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSVALUERULEID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysValueRuleName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSVALUERULENAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_SearchModes_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("SEARCHMODES", iEntity, bl2, null, false, 0x100000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_ServiceCodeName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("SERVICECODENAME", iEntity, bl2, null, false, 50, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_StrLength_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
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

    protected boolean onMergeChild(String string, String string2, PSDEFGroupDetail pSDEFGroupDetail) throws Exception {
        boolean bl = false;
        if (super.onMergeChild(string, string2, pSDEFGroupDetail)) {
            bl = true;
        }
        return bl;
    }

    protected void onUpdateParent(PSDEFGroupDetail pSDEFGroupDetail) throws Exception {
        super.onUpdateParent(pSDEFGroupDetail);
    }

    @Override
    protected void exportCurXmlModel(PSDEFGroupDetail pSDEFGroupDetail, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSDEFGROUPDETAIL");
        if (!bl) {
            pSDEFGroupDetail.setCreateDate(null);
            pSDEFGroupDetail.setCreateMan(null);
            pSDEFGroupDetail.setPSDEFGroupDetailId(null);
            pSDEFGroupDetail.setUpdateDate(null);
            pSDEFGroupDetail.setUpdateMan(null);
            pSDEFGroupDetail.setPSDEFGroupId(null);
            pSDEFGroupDetail.setPSDEFGroupName(null);
            pSDEFGroupDetail.setPSDEId(null);
            super.exportCurXmlModel(pSDEFGroupDetail, xmlNode, bl);
        }
    }

    @Override
    protected String getEntityFolderKeyValue(PSDEFGroupDetail pSDEFGroupDetail, PSSystem pSSystem) throws Exception {
        PSDEFGroupDetail pSDEFGroupDetail2 = new PSDEFGroupDetail();
        pSDEFGroupDetail2.setPSDEFGroupId(pSDEFGroupDetail.getPSDEFGroupId());
        pSDEFGroupDetail2.setPSDEFId(pSDEFGroupDetail.getPSDEFId());
        if (this.selectOne(pSDEFGroupDetail2, true)) {
            return pSDEFGroupDetail2.getPSDEFGroupDetailId();
        }
        return super.getEntityFolderKeyValue(pSDEFGroupDetail, pSSystem);
    }

    @Override
    public ObjectNode fillModelV2(ObjectNode objectNode, PSDEFGroupDetail pSDEFGroupDetail, String string) throws Exception {
        objectNode = super.fillModelV2(objectNode, pSDEFGroupDetail, string);
        return objectNode;
    }

    @Override
    public String getModelV2ResScope(IEntity iEntity) throws Exception {
        String string = null;
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSDEFGROUPID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return StringHelper.format((String)"PSDEFGROUP#%1$s", (Object)string);
        }
        return super.getModelV2ResScope(iEntity);
    }

    @Override
    public String getModelV2ResScopeDER(IEntity iEntity) throws Exception {
        String string = null;
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSDEFGROUPID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return "DER1N_PSDEFGROUPDETAIL_PSDEFGROUP_PSDEFGROUPID";
        }
        return super.getModelV2ResScopeDER(iEntity);
    }

    @Override
    public String getModelV2ResScopeText(IEntity iEntity) throws Exception {
        String string = null;
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSDEFGROUPID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return DataObject.getStringValue((IDataObject)iEntity, (String)"PSDEFGROUPNAME", null);
        }
        return super.getModelV2ResScopeText(iEntity);
    }

    @Override
    public boolean setModelV2ResScope(IEntity iEntity, String string, String string2) throws Exception {
        if (StringHelper.compare((String)string, (String)"PSDEFGROUP", (boolean)true) == 0) {
            iEntity.set("PSDEFGROUPID", (Object)string2);
            return true;
        }
        return super.setModelV2ResScope(iEntity, string, string2);
    }

    @Override
    public String[] getModelV2ResScopeFields() throws Exception {
        return new String[]{"PSDEFGROUPID"};
    }

    @Override
    public String getModelV2Tag(PSDEFGroupDetail pSDEFGroupDetail) {
        if (!StringHelper.isNullOrEmpty((String)pSDEFGroupDetail.getPSDEFGroupDetailName())) {
            return pSDEFGroupDetail.getPSDEFGroupDetailName();
        }
        if (!StringHelper.isNullOrEmpty((String)pSDEFGroupDetail.getCodeName())) {
            return pSDEFGroupDetail.getCodeName();
        }
        return super.getModelV2Tag(pSDEFGroupDetail);
    }

    @Override
    public boolean setModelV2Tag(PSDEFGroupDetail pSDEFGroupDetail, String string) {
        pSDEFGroupDetail.setPSDEFGroupDetailName(string);
        return true;
    }

    @Override
    public Map<String, String> getListDRDataFolderFields(Map<String, String> map, PSMOSFile pSMOSFile, IPSMOSFileFilter iPSMOSFileFilter) throws Exception {
        if (map == null) {
            map = new HashMap<String, String>();
        }
        map.put("PSDEFGROUPDETAILNAME", "");
        map.put("CODENAME", "");
        map.put("PSDEFGROUPID", "");
        return super.getListDRDataFolderFields(map, pSMOSFile, iPSMOSFileFilter);
    }

    @Override
    public boolean getModelV2Entity(PSDEFGroupDetail pSDEFGroupDetail, String string) throws Exception {
        SimpleEntity simpleEntity = new SimpleEntity();
        pSDEFGroupDetail.copyTo((IDataObject)simpleEntity, false);
        simpleEntity.copyTo((IDataObject)pSDEFGroupDetail, true);
        pSDEFGroupDetail.set("PSDEFGROUPDETAILNAME", string);
        if (this.select(pSDEFGroupDetail, true)) {
            return true;
        }
        simpleEntity.copyTo((IDataObject)pSDEFGroupDetail, true);
        return super.getModelV2Entity(pSDEFGroupDetail, string);
    }

    @Override
    protected boolean testCompileCurModelV2(PSDEFGroupDetail pSDEFGroupDetail, ObjectNode objectNode, String string, String string2, int n) throws Exception {
        if (n == 1) {
            return false;
        }
        return super.testCompileCurModelV2(pSDEFGroupDetail, objectNode, string, string2, n);
    }
}

