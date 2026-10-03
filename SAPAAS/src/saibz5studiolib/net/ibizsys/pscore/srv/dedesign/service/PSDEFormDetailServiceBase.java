/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.fasterxml.jackson.databind.JsonNode
 *  com.fasterxml.jackson.databind.node.ArrayNode
 *  com.fasterxml.jackson.databind.node.ObjectNode
 *  javax.annotation.PostConstruct
 *  net.ibizsys.paas.core.ActionContext
 *  net.ibizsys.paas.core.IActionContext
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
 *  net.ibizsys.paas.demodel.IDELogicModel
 *  net.ibizsys.paas.demodel.IDataEntityModel
 *  net.ibizsys.paas.entity.EntityBase
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
package net.ibizsys.pscore.srv.dedesign.service;

import com.fasterxml.jackson.databind.JsonNode;
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
import net.ibizsys.paas.core.ActionContext;
import net.ibizsys.paas.core.IActionContext;
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
import net.ibizsys.paas.demodel.IDELogicModel;
import net.ibizsys.paas.demodel.IDataEntityModel;
import net.ibizsys.paas.entity.EntityBase;
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
import net.ibizsys.pscore.srv.config.entity.PSSysPFPlugin;
import net.ibizsys.pscore.srv.config.entity.PSSysPFPluginBase;
import net.ibizsys.pscore.srv.config.entity.PSSysResource;
import net.ibizsys.pscore.srv.config.entity.PSSysResourceBase;
import net.ibizsys.pscore.srv.core.IPSDataEntityModel;
import net.ibizsys.pscore.srv.dedesign.dao.PSDEFormDetailDAO;
import net.ibizsys.pscore.srv.dedesign.demodel.PSDEFormDetailDEModel;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEACMode;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEACModeBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEDRItem;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEDRItemBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEDataRelation;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEDataRelationBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEDataSet;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEDataSetBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEDataView;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEDataViewBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEFDLogic;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEFDLogicBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEFIUpdate;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEFIUpdateBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEFSFItem;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEFSFItemBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEFUIMode;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEFUIModeBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEField;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEFieldBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEForm;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEFormBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEFormDetail;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEFormDetailBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEFormRF;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEFormRFBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEGrid;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEGridBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEList;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEListBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDELogic;
import net.ibizsys.pscore.srv.dedesign.entity.PSDELogicBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDER;
import net.ibizsys.pscore.srv.dedesign.entity.PSDERBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEUAGroup;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEUAGroupBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEUIAction;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEUIActionBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEViewBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEViewBaseBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDataEntity;
import net.ibizsys.pscore.srv.dedesign.entity.PSDataEntityBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDEFDLogicService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEFDLogicServiceBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDEFIUDetailService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEFIUDetailServiceBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDEFIVRService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEFIVRServiceBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDEFormDetailService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEFormLogicService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEFormLogicServiceBase;
import net.ibizsys.pscore.srv.helpdesign.entity.PSHelpSection;
import net.ibizsys.pscore.srv.sysdesign.entity.PSACHandler;
import net.ibizsys.pscore.srv.sysdesign.entity.PSACHandlerBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSCodeList;
import net.ibizsys.pscore.srv.sysdesign.entity.PSCodeListBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSLanguageRes;
import net.ibizsys.pscore.srv.sysdesign.entity.PSLanguageResBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysCounter;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysCounterBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysCss;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysCssBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysDictCat;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysDictCatBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysDynaModel;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysDynaModelBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysEditorStyle;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysEditorStyleBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysImage;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysImageBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysPDTView;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysPDTViewBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysViewPanel;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysViewPanelBase;
import net.ibizsys.pscore.srv.sysdevstudio.entity.PSMOSFile;
import net.ibizsys.pscore.srv.util.IPSMOSFileAction;
import net.ibizsys.pscore.srv.util.IPSMOSFileFilter;
import net.ibizsys.pscore.srv.util.PSModelV2Helper;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDEFormDetailServiceBase
extends PSCoreSysServiceBase<PSDEFormDetail> {
    private static final Log log = LogFactory.getLog(PSDEFormDetailServiceBase.class);
    public static final String DATASET_CURFORMFI = "CurFormFI";
    public static final String DATASET_DEFAULT = "DEFAULT";
    public static final String DATASET_FI = "FI";
    public static final String DATASET_FORMFI = "FormFI";
    public static final String ACTION_AJAXFILLCREATEDVT = "AjaxFillCreateDVT";
    public static final String ACTION_AJAXFILLUPDATEDVT = "AjaxFillUpdateDVT";
    public static final String ACTION_CALCREFPSDEFORMID = "CalcRefPSDEFormId";
    public static final String ACTION_CHANGEDRITEM = "ChangeDRItem";
    public static final String ACTION_CREATETEMPWITHPREVIEW = "CreateTempWithPreview";
    public static final String ACTION_CREATEWITHMODEL = "CreateWithModel";
    public static final String ACTION_GETTEMPWITHPREVIEW = "GetTempWithPreview";
    public static final String ACTION_GETWITHMODEL = "GetWithModel";
    public static final String ACTION_UPDATETEMPWITHPREVIEW = "UpdateTempWithPreview";
    public static final String ACTION_UPDATEWITHMODEL = "UpdateWithModel";
    private PSDEFormDetailDEModel pSDEFormDetailDEModel;
    private PSDEFormDetailDAO pSDEFormDetailDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.dedesign.service.PSDEFormDetailService";
    }

    public PSDEFormDetailDEModel getPSDEFormDetailDEModel() {
        if (this.pSDEFormDetailDEModel == null) {
            try {
                this.pSDEFormDetailDEModel = (PSDEFormDetailDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.dedesign.demodel.PSDEFormDetailDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDEFormDetailDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSDEFormDetailDEModel();
    }

    public PSDEFormDetailDAO getPSDEFormDetailDAO() {
        if (this.pSDEFormDetailDAO == null) {
            try {
                this.pSDEFormDetailDAO = (PSDEFormDetailDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.dedesign.dao.PSDEFormDetailDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDEFormDetailDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSDEFormDetailDAO();
    }

    protected DBFetchResult onfetchDataSet(String string, IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        if (StringHelper.compare((String)string, (String)DATASET_CURFORMFI, (boolean)true) == 0) {
            return this.fetchCurFormFI(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.fetchDefault(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_FI, (boolean)true) == 0) {
            return this.fetchFI(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_FORMFI, (boolean)true) == 0) {
            return this.fetchFormItem(iDEDataSetFetchContext);
        }
        return super.onfetchDataSet(string, iDEDataSetFetchContext);
    }

    protected DBFetchResult onfetchDataSetTemp(String string, IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        if (StringHelper.compare((String)string, (String)DATASET_CURFORMFI, (boolean)true) == 0) {
            return this.fetchTempCurFormFI(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.fetchTempDefault(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_FI, (boolean)true) == 0) {
            return this.fetchTempFI(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_FORMFI, (boolean)true) == 0) {
            return this.fetchTempFormItem(iDEDataSetFetchContext);
        }
        return super.onfetchDataSetTemp(string, iDEDataSetFetchContext);
    }

    @Override
    protected void onExecuteAction(String string, IEntity iEntity) throws Exception {
        if (StringHelper.compare((String)string, (String)ACTION_AJAXFILLCREATEDVT, (boolean)true) == 0) {
            this.ajaxFillCreateDVT((PSDEFormDetail)iEntity);
            return;
        }
        if (StringHelper.compare((String)string, (String)ACTION_AJAXFILLUPDATEDVT, (boolean)true) == 0) {
            this.ajaxFillUpdateDVT((PSDEFormDetail)iEntity);
            return;
        }
        if (StringHelper.compare((String)string, (String)ACTION_CALCREFPSDEFORMID, (boolean)true) == 0) {
            this.calcRefPSDEFormId((PSDEFormDetail)iEntity);
            return;
        }
        if (StringHelper.compare((String)string, (String)ACTION_CHANGEDRITEM, (boolean)true) == 0) {
            this.changeDRItem((PSDEFormDetail)iEntity);
            return;
        }
        if (StringHelper.compare((String)string, (String)ACTION_CREATETEMPWITHPREVIEW, (boolean)true) == 0) {
            this.createTempWithPreview((PSDEFormDetail)iEntity);
            return;
        }
        if (StringHelper.compare((String)string, (String)ACTION_CREATEWITHMODEL, (boolean)true) == 0) {
            this.createWithModel((PSDEFormDetail)iEntity);
            return;
        }
        if (StringHelper.compare((String)string, (String)ACTION_GETTEMPWITHPREVIEW, (boolean)true) == 0) {
            this.getTempWithPreview((PSDEFormDetail)iEntity);
            return;
        }
        if (StringHelper.compare((String)string, (String)ACTION_GETWITHMODEL, (boolean)true) == 0) {
            this.getWithModel((PSDEFormDetail)iEntity);
            return;
        }
        if (StringHelper.compare((String)string, (String)ACTION_UPDATETEMPWITHPREVIEW, (boolean)true) == 0) {
            this.updateTempWithPreview((PSDEFormDetail)iEntity);
            return;
        }
        if (StringHelper.compare((String)string, (String)ACTION_UPDATEWITHMODEL, (boolean)true) == 0) {
            this.updateWithModel((PSDEFormDetail)iEntity);
            return;
        }
        super.onExecuteAction(string, iEntity);
    }

    public DBFetchResult fetchCurFormFI(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CURFORMFI, false);
        return dBFetchResult;
    }

    public DBFetchResult fetchTempCurFormFI(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CURFORMFI, true);
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

    public DBFetchResult fetchFI(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_FI, false);
        return dBFetchResult;
    }

    public DBFetchResult fetchTempFI(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_FI, true);
        return dBFetchResult;
    }

    public DBFetchResult fetchFormItem(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_FORMFI, false);
        return dBFetchResult;
    }

    public DBFetchResult fetchTempFormItem(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_FORMFI, true);
        return dBFetchResult;
    }

    public void ajaxFillCreateDVT(PSDEFormDetail pSDEFormDetail) throws Exception {
        final IServicePlugin iServicePlugin = this.getPlugin();
        if (iServicePlugin != null && iServicePlugin.doCustomAction((IService)this, ACTION_AJAXFILLCREATEDVT, 0, pSDEFormDetail, null).getResult() == 1) {
            return;
        }
        this.testDEMainStateAction(pSDEFormDetail, ACTION_AJAXFILLCREATEDVT);
        final PSDEFormDetail pSDEFormDetail2 = pSDEFormDetail;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                if (iServicePlugin == null || iServicePlugin.doCustomAction(PSDEFormDetailServiceBase.this.getService(), PSDEFormDetailServiceBase.ACTION_AJAXFILLCREATEDVT, 40, pSDEFormDetail2, null).getResult() != 1) {
                    PSDEFormDetailServiceBase.this.onAjaxFillCreateDVT(pSDEFormDetail2);
                }
            }
        });
        if (iServicePlugin != null) {
            iServicePlugin.doCustomAction((IService)this, ACTION_AJAXFILLCREATEDVT, 99, pSDEFormDetail, null);
        }
    }

    protected void onAjaxFillCreateDVT(PSDEFormDetail pSDEFormDetail) throws Exception {
        throw new Exception("\u6ca1\u6709\u5b9e\u73b0\u81ea\u5b9a\u4e49\u884c\u4e3a[AjaxFillCreateDVT]");
    }

    public void ajaxFillUpdateDVT(PSDEFormDetail pSDEFormDetail) throws Exception {
        final IServicePlugin iServicePlugin = this.getPlugin();
        if (iServicePlugin != null && iServicePlugin.doCustomAction((IService)this, ACTION_AJAXFILLUPDATEDVT, 0, pSDEFormDetail, null).getResult() == 1) {
            return;
        }
        this.testDEMainStateAction(pSDEFormDetail, ACTION_AJAXFILLUPDATEDVT);
        final PSDEFormDetail pSDEFormDetail2 = pSDEFormDetail;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                if (iServicePlugin == null || iServicePlugin.doCustomAction(PSDEFormDetailServiceBase.this.getService(), PSDEFormDetailServiceBase.ACTION_AJAXFILLUPDATEDVT, 40, pSDEFormDetail2, null).getResult() != 1) {
                    PSDEFormDetailServiceBase.this.onAjaxFillUpdateDVT(pSDEFormDetail2);
                }
            }
        });
        if (iServicePlugin != null) {
            iServicePlugin.doCustomAction((IService)this, ACTION_AJAXFILLUPDATEDVT, 99, pSDEFormDetail, null);
        }
    }

    protected void onAjaxFillUpdateDVT(PSDEFormDetail pSDEFormDetail) throws Exception {
        throw new Exception("\u6ca1\u6709\u5b9e\u73b0\u81ea\u5b9a\u4e49\u884c\u4e3a[AjaxFillUpdateDVT]");
    }

    public void changeDRItem(PSDEFormDetail pSDEFormDetail) throws Exception {
        final IServicePlugin iServicePlugin = this.getPlugin();
        if (iServicePlugin != null && iServicePlugin.doCustomAction((IService)this, ACTION_CHANGEDRITEM, 0, pSDEFormDetail, null).getResult() == 1) {
            return;
        }
        this.testDEMainStateAction(pSDEFormDetail, ACTION_CHANGEDRITEM);
        final PSDEFormDetail pSDEFormDetail2 = pSDEFormDetail;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                if (iServicePlugin == null || iServicePlugin.doCustomAction(PSDEFormDetailServiceBase.this.getService(), PSDEFormDetailServiceBase.ACTION_CHANGEDRITEM, 40, pSDEFormDetail2, null).getResult() != 1) {
                    PSDEFormDetailServiceBase.this.onChangeDRItem(pSDEFormDetail2);
                }
            }
        });
        if (iServicePlugin != null) {
            iServicePlugin.doCustomAction((IService)this, ACTION_CHANGEDRITEM, 99, pSDEFormDetail, null);
        }
    }

    protected void onChangeDRItem(PSDEFormDetail pSDEFormDetail) throws Exception {
        throw new Exception("\u6ca1\u6709\u5b9e\u73b0\u81ea\u5b9a\u4e49\u884c\u4e3a[ChangeDRItem]");
    }

    public void createTempWithPreview(PSDEFormDetail pSDEFormDetail) throws Exception {
        final IServicePlugin iServicePlugin = this.getPlugin();
        if (iServicePlugin != null && iServicePlugin.doCustomAction((IService)this, ACTION_CREATETEMPWITHPREVIEW, 0, pSDEFormDetail, null).getResult() == 1) {
            return;
        }
        this.testDEMainStateAction(pSDEFormDetail, ACTION_CREATETEMPWITHPREVIEW);
        final PSDEFormDetail pSDEFormDetail2 = pSDEFormDetail;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                if (iServicePlugin == null || iServicePlugin.doCustomAction(PSDEFormDetailServiceBase.this.getService(), PSDEFormDetailServiceBase.ACTION_CREATETEMPWITHPREVIEW, 40, pSDEFormDetail2, null).getResult() != 1) {
                    PSDEFormDetailServiceBase.this.onCreateTempWithPreview(pSDEFormDetail2);
                }
            }
        });
        if (iServicePlugin != null) {
            iServicePlugin.doCustomAction((IService)this, ACTION_CREATETEMPWITHPREVIEW, 99, pSDEFormDetail, null);
        }
    }

    protected void onCreateTempWithPreview(PSDEFormDetail pSDEFormDetail) throws Exception {
        throw new Exception("\u6ca1\u6709\u5b9e\u73b0\u81ea\u5b9a\u4e49\u884c\u4e3a[CreateTempWithPreview]");
    }

    public void createWithModel(PSDEFormDetail pSDEFormDetail) throws Exception {
        final IServicePlugin iServicePlugin = this.getPlugin();
        if (iServicePlugin != null && iServicePlugin.doCustomAction((IService)this, ACTION_CREATEWITHMODEL, 0, pSDEFormDetail, null).getResult() == 1) {
            return;
        }
        this.testDEMainStateAction(pSDEFormDetail, ACTION_CREATEWITHMODEL);
        final PSDEFormDetail pSDEFormDetail2 = pSDEFormDetail;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                if (iServicePlugin == null || iServicePlugin.doCustomAction(PSDEFormDetailServiceBase.this.getService(), PSDEFormDetailServiceBase.ACTION_CREATEWITHMODEL, 40, pSDEFormDetail2, null).getResult() != 1) {
                    PSDEFormDetailServiceBase.this.onCreateWithModel(pSDEFormDetail2);
                }
            }
        });
        if (iServicePlugin != null) {
            iServicePlugin.doCustomAction((IService)this, ACTION_CREATEWITHMODEL, 99, pSDEFormDetail, null);
        }
    }

    protected void onCreateWithModel(PSDEFormDetail pSDEFormDetail) throws Exception {
        throw new Exception("\u6ca1\u6709\u5b9e\u73b0\u81ea\u5b9a\u4e49\u884c\u4e3a[CreateWithModel]");
    }

    public void getTempWithPreview(PSDEFormDetail pSDEFormDetail) throws Exception {
        final IServicePlugin iServicePlugin = this.getPlugin();
        if (iServicePlugin != null && iServicePlugin.doCustomAction((IService)this, ACTION_GETTEMPWITHPREVIEW, 0, pSDEFormDetail, null).getResult() == 1) {
            return;
        }
        this.testDEMainStateAction(pSDEFormDetail, ACTION_GETTEMPWITHPREVIEW);
        final PSDEFormDetail pSDEFormDetail2 = pSDEFormDetail;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                if (iServicePlugin == null || iServicePlugin.doCustomAction(PSDEFormDetailServiceBase.this.getService(), PSDEFormDetailServiceBase.ACTION_GETTEMPWITHPREVIEW, 40, pSDEFormDetail2, null).getResult() != 1) {
                    PSDEFormDetailServiceBase.this.onGetTempWithPreview(pSDEFormDetail2);
                }
            }
        });
        if (iServicePlugin != null) {
            iServicePlugin.doCustomAction((IService)this, ACTION_GETTEMPWITHPREVIEW, 99, pSDEFormDetail, null);
        }
    }

    protected void onGetTempWithPreview(PSDEFormDetail pSDEFormDetail) throws Exception {
        throw new Exception("\u6ca1\u6709\u5b9e\u73b0\u81ea\u5b9a\u4e49\u884c\u4e3a[GetTempWithPreview]");
    }

    public void getWithModel(PSDEFormDetail pSDEFormDetail) throws Exception {
        final IServicePlugin iServicePlugin = this.getPlugin();
        if (iServicePlugin != null && iServicePlugin.doCustomAction((IService)this, ACTION_GETWITHMODEL, 0, pSDEFormDetail, null).getResult() == 1) {
            return;
        }
        this.testDEMainStateAction(pSDEFormDetail, ACTION_GETWITHMODEL);
        final PSDEFormDetail pSDEFormDetail2 = pSDEFormDetail;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                if (iServicePlugin == null || iServicePlugin.doCustomAction(PSDEFormDetailServiceBase.this.getService(), PSDEFormDetailServiceBase.ACTION_GETWITHMODEL, 40, pSDEFormDetail2, null).getResult() != 1) {
                    PSDEFormDetailServiceBase.this.onGetWithModel(pSDEFormDetail2);
                }
            }
        });
        if (iServicePlugin != null) {
            iServicePlugin.doCustomAction((IService)this, ACTION_GETWITHMODEL, 99, pSDEFormDetail, null);
        }
    }

    protected void onGetWithModel(PSDEFormDetail pSDEFormDetail) throws Exception {
        throw new Exception("\u6ca1\u6709\u5b9e\u73b0\u81ea\u5b9a\u4e49\u884c\u4e3a[GetWithModel]");
    }

    public void updateTempWithPreview(PSDEFormDetail pSDEFormDetail) throws Exception {
        final IServicePlugin iServicePlugin = this.getPlugin();
        if (iServicePlugin != null && iServicePlugin.doCustomAction((IService)this, ACTION_UPDATETEMPWITHPREVIEW, 0, pSDEFormDetail, null).getResult() == 1) {
            return;
        }
        this.testDEMainStateAction(pSDEFormDetail, ACTION_UPDATETEMPWITHPREVIEW);
        final PSDEFormDetail pSDEFormDetail2 = pSDEFormDetail;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                if (iServicePlugin == null || iServicePlugin.doCustomAction(PSDEFormDetailServiceBase.this.getService(), PSDEFormDetailServiceBase.ACTION_UPDATETEMPWITHPREVIEW, 40, pSDEFormDetail2, null).getResult() != 1) {
                    PSDEFormDetailServiceBase.this.onUpdateTempWithPreview(pSDEFormDetail2);
                }
            }
        });
        if (iServicePlugin != null) {
            iServicePlugin.doCustomAction((IService)this, ACTION_UPDATETEMPWITHPREVIEW, 99, pSDEFormDetail, null);
        }
    }

    protected void onUpdateTempWithPreview(PSDEFormDetail pSDEFormDetail) throws Exception {
        throw new Exception("\u6ca1\u6709\u5b9e\u73b0\u81ea\u5b9a\u4e49\u884c\u4e3a[UpdateTempWithPreview]");
    }

    public void updateWithModel(PSDEFormDetail pSDEFormDetail) throws Exception {
        final IServicePlugin iServicePlugin = this.getPlugin();
        if (iServicePlugin != null && iServicePlugin.doCustomAction((IService)this, ACTION_UPDATEWITHMODEL, 0, pSDEFormDetail, null).getResult() == 1) {
            return;
        }
        this.testDEMainStateAction(pSDEFormDetail, ACTION_UPDATEWITHMODEL);
        final PSDEFormDetail pSDEFormDetail2 = pSDEFormDetail;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                if (iServicePlugin == null || iServicePlugin.doCustomAction(PSDEFormDetailServiceBase.this.getService(), PSDEFormDetailServiceBase.ACTION_UPDATEWITHMODEL, 40, pSDEFormDetail2, null).getResult() != 1) {
                    PSDEFormDetailServiceBase.this.onUpdateWithModel(pSDEFormDetail2);
                }
            }
        });
        if (iServicePlugin != null) {
            iServicePlugin.doCustomAction((IService)this, ACTION_UPDATEWITHMODEL, 99, pSDEFormDetail, null);
        }
    }

    protected void onUpdateWithModel(PSDEFormDetail pSDEFormDetail) throws Exception {
        throw new Exception("\u6ca1\u6709\u5b9e\u73b0\u81ea\u5b9a\u4e49\u884c\u4e3a[UpdateWithModel]");
    }

    public void calcRefPSDEFormId(PSDEFormDetail pSDEFormDetail) throws Exception {
        final PSDEFormDetail pSDEFormDetail2 = pSDEFormDetail;
        pSDEFormDetail2.setSessionFactory(this.getSessionFactory());
        this.testDEMainStateAction(pSDEFormDetail, ACTION_CALCREFPSDEFORMID);
        final IDELogicModel iDELogicModel = (IDELogicModel)this.getPSDEFormDetailDEModel().getDELogic(ACTION_CALCREFPSDEFORMID);
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                ActionContext actionContext = new ActionContext(null);
                actionContext.setParam(iDELogicModel.getDefaultParamName(), (Object)pSDEFormDetail2);
                actionContext.setSessionFactory(PSDEFormDetailServiceBase.this.getSessionFactory());
                iDELogicModel.execute((IActionContext)actionContext);
            }
        });
    }

    protected void onFillParentInfo(PSDEFormDetail pSDEFormDetail, String string, String string2, String string3) throws Exception {
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEFORMDETAIL_PSACHANDLER_ITEMPSACHANDLERID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSACHandlerService", (SessionFactory)this.getSessionFactory());
            PSACHandler pSACHandler = (PSACHandler)iService.getDEModel().createEntity();
            pSACHandler.set("PSACHANDLERID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSACHandler);
            } else {
                iService.get(pSACHandler);
            }
            this.onFillParentInfo_ItemPSACHandler(pSDEFormDetail, pSACHandler);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEFORMDETAIL_PSCODELIST_PSCODELISTID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSCodeListService", (SessionFactory)this.getSessionFactory());
            PSCodeList pSCodeList = (PSCodeList)iService.getDEModel().createEntity();
            pSCodeList.set("PSCODELISTID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSCodeList);
            } else {
                iService.get(pSCodeList);
            }
            this.onFillParentInfo_PSCodeList(pSDEFormDetail, pSCodeList);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEFORMDETAIL_PSDATAENTITY_REFPSDEID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDataEntityService", (SessionFactory)this.getSessionFactory());
            PSDataEntity pSDataEntity = (PSDataEntity)iService.getDEModel().createEntity();
            pSDataEntity.set("PSDATAENTITYID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDataEntity);
            } else {
                iService.get(pSDataEntity);
            }
            this.onFillParentInfo_RefPSDE(pSDEFormDetail, pSDataEntity);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEFORMDETAIL_PSDEACMODE_REFPSDEACMODEID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEACModeService", (SessionFactory)this.getSessionFactory());
            PSDEACMode pSDEACMode = (PSDEACMode)iService.getDEModel().createEntity();
            pSDEACMode.set("PSDEACMODEID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDEACMode);
            } else {
                iService.get(pSDEACMode);
            }
            this.onFillParentInfo_RefPSDEACMode(pSDEFormDetail, pSDEACMode);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEFORMDETAIL_PSDEDATARELATION_PSDEDRID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEDataRelationService", (SessionFactory)this.getSessionFactory());
            PSDEDataRelation pSDEDataRelation = (PSDEDataRelation)iService.getDEModel().createEntity();
            pSDEDataRelation.set("PSDEDATARELATIONID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDEDataRelation);
            } else {
                iService.get(pSDEDataRelation);
            }
            this.onFillParentInfo_PSDEDR(pSDEFormDetail, pSDEDataRelation);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEFORMDETAIL_PSDEDATASET_REFPSDEDATASETID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEDataSetService", (SessionFactory)this.getSessionFactory());
            PSDEDataSet pSDEDataSet = (PSDEDataSet)iService.getDEModel().createEntity();
            pSDEDataSet.set("PSDEDATASETID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDEDataSet);
            } else {
                iService.get(pSDEDataSet);
            }
            this.onFillParentInfo_RefPSDEDataSet(pSDEFormDetail, pSDEDataSet);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEFORMDETAIL_PSDEDATAVIEW_MDPSDEDATAVIEWID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEDataViewService", (SessionFactory)this.getSessionFactory());
            PSDEDataView pSDEDataView = (PSDEDataView)iService.getDEModel().createEntity();
            pSDEDataView.set("PSDEDATAVIEWID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDEDataView);
            } else {
                iService.get(pSDEDataView);
            }
            this.onFillParentInfo_MDPSDEDataView(pSDEFormDetail, pSDEDataView);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEFORMDETAIL_PSDEDRITEM_PSDEDRITEMID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEDRItemService", (SessionFactory)this.getSessionFactory());
            PSDEDRItem pSDEDRItem = (PSDEDRItem)iService.getDEModel().createEntity();
            pSDEDRItem.set("PSDEDRITEMID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDEDRItem);
            } else {
                iService.get(pSDEDRItem);
            }
            this.onFillParentInfo_PSDEDRItem(pSDEFormDetail, pSDEDRItem);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEFORMDETAIL_PSDEFFORMITEM_PSDEFFORMITEMID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEFUIModeService", (SessionFactory)this.getSessionFactory());
            PSDEFUIMode pSDEFUIMode = (PSDEFUIMode)iService.getDEModel().createEntity();
            pSDEFUIMode.set("PSDEFFORMITEMID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDEFUIMode);
            } else {
                iService.get(pSDEFUIMode);
            }
            this.onFillParentInfo_PSDEFUIMode(pSDEFormDetail, pSDEFUIMode);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEFORMDETAIL_PSDEFIELD_PSDEFID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEFieldService", (SessionFactory)this.getSessionFactory());
            PSDEField pSDEField = (PSDEField)iService.getDEModel().createEntity();
            pSDEField.set("PSDEFIELDID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDEField);
            } else {
                iService.get(pSDEField);
            }
            this.onFillParentInfo_PSDEF(pSDEFormDetail, pSDEField);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEFORMDETAIL_PSDEFIUPDATE_PSDEFIUPDATEID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEFIUpdateService", (SessionFactory)this.getSessionFactory());
            PSDEFIUpdate pSDEFIUpdate = (PSDEFIUpdate)iService.getDEModel().createEntity();
            pSDEFIUpdate.set("PSDEFIUPDATEID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDEFIUpdate);
            } else {
                iService.get(pSDEFIUpdate);
            }
            this.onFillParentInfo_PSDEFIUpdate(pSDEFormDetail, pSDEFIUpdate);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEFORMDETAIL_PSDEFORMDETAIL_PPSDEFORMDETAILID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEFormDetailService", (SessionFactory)this.getSessionFactory());
            PSDEFormDetail pSDEFormDetail2 = (PSDEFormDetail)iService.getDEModel().createEntity();
            pSDEFormDetail2.set("PSDEFORMDETAILID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDEFormDetail2);
            } else {
                iService.get(pSDEFormDetail2);
            }
            this.onFillParentInfo_PPSDEFormDetail(pSDEFormDetail, pSDEFormDetail2);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEFORMDETAIL_PSDEFORMDETAIL_REFPSDEFORMDETAILID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEFormDetailService", (SessionFactory)this.getSessionFactory());
            PSDEFormDetail pSDEFormDetail3 = (PSDEFormDetail)iService.getDEModel().createEntity();
            pSDEFormDetail3.set("PSDEFORMDETAILID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDEFormDetail3);
            } else {
                iService.get(pSDEFormDetail3);
            }
            this.onFillParentInfo_RefPSDEFormDetail(pSDEFormDetail, pSDEFormDetail3);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEFORMDETAIL_PSDEFORMRF_PSDEFORMRFID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEFormRFService", (SessionFactory)this.getSessionFactory());
            PSDEFormRF pSDEFormRF = (PSDEFormRF)iService.getDEModel().createEntity();
            pSDEFormRF.set("PSDEFORMRFID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDEFormRF);
            } else {
                iService.get(pSDEFormRF);
            }
            this.onFillParentInfo_PSDEFormRF(pSDEFormDetail, pSDEFormRF);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEFORMDETAIL_PSDEFORM_MDPSDEFORMID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEFormService", (SessionFactory)this.getSessionFactory());
            PSDEForm pSDEForm = (PSDEForm)iService.getDEModel().createEntity();
            pSDEForm.set("PSDEFORMID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDEForm);
            } else {
                iService.get(pSDEForm);
            }
            this.onFillParentInfo_MDPSDEForm(pSDEFormDetail, pSDEForm);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEFORMDETAIL_PSDEFORM_PSDEFORMID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEFormService", (SessionFactory)this.getSessionFactory());
            PSDEForm pSDEForm = (PSDEForm)iService.getDEModel().createEntity();
            pSDEForm.set("PSDEFORMID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDEForm);
            } else {
                iService.get(pSDEForm);
            }
            this.onFillParentInfo_PSDEForm(pSDEFormDetail, pSDEForm);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEFORMDETAIL_PSDEFSFITEM_PSDEFSFITEMID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEFSFItemService", (SessionFactory)this.getSessionFactory());
            PSDEFSFItem pSDEFSFItem = (PSDEFSFItem)iService.getDEModel().createEntity();
            pSDEFSFItem.set("PSDEFSFITEMID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDEFSFItem);
            } else {
                iService.get(pSDEFSFItem);
            }
            this.onFillParentInfo_PSDEFSFItem(pSDEFormDetail, pSDEFSFItem);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEFORMDETAIL_PSDEGRID_MDPSDEGRIDID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEGridService", (SessionFactory)this.getSessionFactory());
            PSDEGrid pSDEGrid = (PSDEGrid)iService.getDEModel().createEntity();
            pSDEGrid.set("PSDEGRIDID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDEGrid);
            } else {
                iService.get(pSDEGrid);
            }
            this.onFillParentInfo_MDPSDEGrid(pSDEFormDetail, pSDEGrid);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEFORMDETAIL_PSDELIST_MDPSDELISTID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEListService", (SessionFactory)this.getSessionFactory());
            PSDEList pSDEList = (PSDEList)iService.getDEModel().createEntity();
            pSDEList.set("PSDELISTID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDEList);
            } else {
                iService.get(pSDEList);
            }
            this.onFillParentInfo_MDPSDEList(pSDEFormDetail, pSDEList);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEFORMDETAIL_PSDELOGIC_PSDELOGICID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDELogicService", (SessionFactory)this.getSessionFactory());
            PSDELogic pSDELogic = (PSDELogic)iService.getDEModel().createEntity();
            pSDELogic.set("PSDELOGICID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDELogic);
            } else {
                iService.get(pSDELogic);
            }
            this.onFillParentInfo_PSDELogic(pSDEFormDetail, pSDELogic);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEFORMDETAIL_PSDER_REFPSDERID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDERService", (SessionFactory)this.getSessionFactory());
            PSDER pSDER = (PSDER)iService.getDEModel().createEntity();
            pSDER.set("PSDERID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDER);
            } else {
                iService.get(pSDER);
            }
            this.onFillParentInfo_RefPSDER(pSDEFormDetail, pSDER);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEFORMDETAIL_PSDEUAGROUP_PSDEUAGROUPID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEUAGroupService", (SessionFactory)this.getSessionFactory());
            PSDEUAGroup pSDEUAGroup = (PSDEUAGroup)iService.getDEModel().createEntity();
            pSDEUAGroup.set("PSDEUAGROUPID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDEUAGroup);
            } else {
                iService.get(pSDEUAGroup);
            }
            this.onFillParentInfo_PSDEUAGroup(pSDEFormDetail, pSDEUAGroup);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEFORMDETAIL_PSDEUIACTION_PSDEUIACTIONID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEUIActionService", (SessionFactory)this.getSessionFactory());
            PSDEUIAction pSDEUIAction = (PSDEUIAction)iService.getDEModel().createEntity();
            pSDEUIAction.set("PSDEUIACTIONID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDEUIAction);
            } else {
                iService.get(pSDEUIAction);
            }
            this.onFillParentInfo_PSDEUIAction(pSDEFormDetail, pSDEUIAction);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEFORMDETAIL_PSDEVIEWBASE_LINKPSDEVIEWID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEViewBaseService", (SessionFactory)this.getSessionFactory());
            PSDEViewBase pSDEViewBase = (PSDEViewBase)iService.getDEModel().createEntity();
            pSDEViewBase.set("PSDEVIEWBASEID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDEViewBase);
            } else {
                iService.get(pSDEViewBase);
            }
            this.onFillParentInfo_LinkPSDEView(pSDEFormDetail, pSDEViewBase);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEFORMDETAIL_PSDEVIEWBASE_OPENPSDEVIEWID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEViewBaseService", (SessionFactory)this.getSessionFactory());
            PSDEViewBase pSDEViewBase = (PSDEViewBase)iService.getDEModel().createEntity();
            pSDEViewBase.set("PSDEVIEWBASEID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDEViewBase);
            } else {
                iService.get(pSDEViewBase);
            }
            this.onFillParentInfo_OpenPSDEView(pSDEFormDetail, pSDEViewBase);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEFORMDETAIL_PSDEVIEWBASE_PICKUPPSDEVIEWID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEViewBaseService", (SessionFactory)this.getSessionFactory());
            PSDEViewBase pSDEViewBase = (PSDEViewBase)iService.getDEModel().createEntity();
            pSDEViewBase.set("PSDEVIEWBASEID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDEViewBase);
            } else {
                iService.get(pSDEViewBase);
            }
            this.onFillParentInfo_PickupPSDEView(pSDEFormDetail, pSDEViewBase);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEFORMDETAIL_PSLANGUAGERES_CAPPSLANRESID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSLanguageResService", (SessionFactory)this.getSessionFactory());
            PSLanguageRes pSLanguageRes = (PSLanguageRes)iService.getDEModel().createEntity();
            pSLanguageRes.set("PSLANGUAGERESID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSLanguageRes);
            } else {
                iService.get(pSLanguageRes);
            }
            this.onFillParentInfo_CapPSLanRes(pSDEFormDetail, pSLanguageRes);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEFORMDETAIL_PSLANGUAGERES_MASKPSLANRESID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSLanguageResService", (SessionFactory)this.getSessionFactory());
            PSLanguageRes pSLanguageRes = (PSLanguageRes)iService.getDEModel().createEntity();
            pSLanguageRes.set("PSLANGUAGERESID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSLanguageRes);
            } else {
                iService.get(pSLanguageRes);
            }
            this.onFillParentInfo_MaskPSLanRes(pSDEFormDetail, pSLanguageRes);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEFORMDETAIL_PSLANGUAGERES_PHPSLANRESID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSLanguageResService", (SessionFactory)this.getSessionFactory());
            PSLanguageRes pSLanguageRes = (PSLanguageRes)iService.getDEModel().createEntity();
            pSLanguageRes.set("PSLANGUAGERESID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSLanguageRes);
            } else {
                iService.get(pSLanguageRes);
            }
            this.onFillParentInfo_PHPSLanRes(pSDEFormDetail, pSLanguageRes);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEFORMDETAIL_PSLANGUAGERES_TIPPSLANRESID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSLanguageResService", (SessionFactory)this.getSessionFactory());
            PSLanguageRes pSLanguageRes = (PSLanguageRes)iService.getDEModel().createEntity();
            pSLanguageRes.set("PSLANGUAGERESID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSLanguageRes);
            } else {
                iService.get(pSLanguageRes);
            }
            this.onFillParentInfo_TipPSLanRes(pSDEFormDetail, pSLanguageRes);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEFORMDETAIL_PSSYSCOUNTER_PSSYSCOUNTERID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysCounterService", (SessionFactory)this.getSessionFactory());
            PSSysCounter pSSysCounter = (PSSysCounter)iService.getDEModel().createEntity();
            pSSysCounter.set("PSSYSCOUNTERID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSSysCounter);
            } else {
                iService.get(pSSysCounter);
            }
            this.onFillParentInfo_PSSysCounter(pSDEFormDetail, pSSysCounter);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEFORMDETAIL_PSSYSCSS_CTRLPSSYSCSSID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysCssService", (SessionFactory)this.getSessionFactory());
            PSSysCss pSSysCss = (PSSysCss)iService.getDEModel().createEntity();
            pSSysCss.set("PSSYSCSSID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSSysCss);
            } else {
                iService.get(pSSysCss);
            }
            this.onFillParentInfo_CtrlPSSysCss(pSDEFormDetail, pSSysCss);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEFORMDETAIL_PSSYSCSS_LABELPSSYSCSSID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysCssService", (SessionFactory)this.getSessionFactory());
            PSSysCss pSSysCss = (PSSysCss)iService.getDEModel().createEntity();
            pSSysCss.set("PSSYSCSSID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSSysCss);
            } else {
                iService.get(pSSysCss);
            }
            this.onFillParentInfo_LabelPSSysCss(pSDEFormDetail, pSSysCss);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEFORMDETAIL_PSSYSCSS_PSSYSCSSID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysCssService", (SessionFactory)this.getSessionFactory());
            PSSysCss pSSysCss = (PSSysCss)iService.getDEModel().createEntity();
            pSSysCss.set("PSSYSCSSID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSSysCss);
            } else {
                iService.get(pSSysCss);
            }
            this.onFillParentInfo_PSSysCss(pSDEFormDetail, pSSysCss);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEFORMDETAIL_PSSYSDICTCAT_PSSYSDICTCATID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysDictCatService", (SessionFactory)this.getSessionFactory());
            PSSysDictCat pSSysDictCat = (PSSysDictCat)iService.getDEModel().createEntity();
            pSSysDictCat.set("PSSYSDICTCATID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSSysDictCat);
            } else {
                iService.get(pSSysDictCat);
            }
            this.onFillParentInfo_PSSysDictCat(pSDEFormDetail, pSSysDictCat);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEFORMDETAIL_PSSYSDYNAMODEL_PSSYSDYNAMODELID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysDynaModelService", (SessionFactory)this.getSessionFactory());
            PSSysDynaModel pSSysDynaModel = (PSSysDynaModel)iService.getDEModel().createEntity();
            pSSysDynaModel.set("PSSYSDYNAMODELID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSSysDynaModel);
            } else {
                iService.get(pSSysDynaModel);
            }
            this.onFillParentInfo_PSSysDynaModel(pSDEFormDetail, pSSysDynaModel);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEFORMDETAIL_PSSYSEDITORSTYLE_PSSYSEDITORSTYLEID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysEditorStyleService", (SessionFactory)this.getSessionFactory());
            PSSysEditorStyle pSSysEditorStyle = (PSSysEditorStyle)iService.getDEModel().createEntity();
            pSSysEditorStyle.set("PSSYSEDITORSTYLEID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSSysEditorStyle);
            } else {
                iService.get(pSSysEditorStyle);
            }
            this.onFillParentInfo_PSSysEditorStyle(pSDEFormDetail, pSSysEditorStyle);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEFORMDETAIL_PSSYSIMAGE_PSSYSIMAGEID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysImageService", (SessionFactory)this.getSessionFactory());
            PSSysImage pSSysImage = (PSSysImage)iService.getDEModel().createEntity();
            pSSysImage.set("PSSYSIMAGEID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSSysImage);
            } else {
                iService.get(pSSysImage);
            }
            this.onFillParentInfo_PSSysImage(pSDEFormDetail, pSSysImage);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEFORMDETAIL_PSSYSPDTVIEW_OPENPSSYSPDTVIEWID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysPDTViewService", (SessionFactory)this.getSessionFactory());
            PSSysPDTView pSSysPDTView = (PSSysPDTView)iService.getDEModel().createEntity();
            pSSysPDTView.set("PSSYSPDTVIEWID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSSysPDTView);
            } else {
                iService.get(pSSysPDTView);
            }
            this.onFillParentInfo_OpenPSSysPDTView(pSDEFormDetail, pSSysPDTView);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEFORMDETAIL_PSSYSPFPLUGIN_UCPSSYSPFPLUGINID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.config.service.PSSysPFPluginService", (SessionFactory)this.getSessionFactory());
            PSSysPFPlugin pSSysPFPlugin = (PSSysPFPlugin)iService.getDEModel().createEntity();
            pSSysPFPlugin.set("PSSYSPFPLUGINID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSSysPFPlugin);
            } else {
                iService.get(pSSysPFPlugin);
            }
            this.onFillParentInfo_UCPSSysPFPlugin(pSDEFormDetail, pSSysPFPlugin);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEFORMDETAIL_PSSYSRESOURCE_PSSYSRESOURCEID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.config.service.PSSysResourceService", (SessionFactory)this.getSessionFactory());
            PSSysResource pSSysResource = (PSSysResource)iService.getDEModel().createEntity();
            pSSysResource.set("PSSYSRESOURCEID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSSysResource);
            } else {
                iService.get(pSSysResource);
            }
            this.onFillParentInfo_PSSysResource(pSDEFormDetail, pSSysResource);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEFORMDETAIL_PSSYSVIEWPANEL_MDPSSYSVIEWPANELID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysViewPanelService", (SessionFactory)this.getSessionFactory());
            PSSysViewPanel pSSysViewPanel = (PSSysViewPanel)iService.getDEModel().createEntity();
            pSSysViewPanel.set("PSSYSVIEWPANELID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSSysViewPanel);
            } else {
                iService.get(pSSysViewPanel);
            }
            this.onFillParentInfo_MDPSSysViewPanel(pSDEFormDetail, pSSysViewPanel);
            return;
        }
        super.onFillParentInfo(pSDEFormDetail, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        if (StringHelper.compare((String)string, (String)"DER1N_PSDEFORMDETAIL_PSDEFORM_PSDEFORMID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEFormService", (SessionFactory)this.getSessionFactory());
            PSDEForm pSDEForm = (PSDEForm)iService.getDEModel().createEntity();
            pSDEForm.set("PSDEFORMID", string2);
            return this.onSyncDER1NData_PSDEForm(pSDEForm, string3);
        }
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillParentInfo_ItemPSACHandler(PSDEFormDetail pSDEFormDetail, PSACHandler pSACHandler) throws Exception {
        pSDEFormDetail.setItemPSACHandlerId(pSACHandler.getPSACHandlerId());
        pSDEFormDetail.setItemPSACHandlerName(pSACHandler.getPSACHandlerName());
    }

    protected void onFillParentInfo_PSCodeList(PSDEFormDetail pSDEFormDetail, PSCodeList pSCodeList) throws Exception {
        pSDEFormDetail.setPSCodeListId(pSCodeList.getPSCodeListId());
        pSDEFormDetail.setPSCodeListName(pSCodeList.getPSCodeListName());
    }

    protected void onFillParentInfo_RefPSDE(PSDEFormDetail pSDEFormDetail, PSDataEntity pSDataEntity) throws Exception {
        pSDEFormDetail.setRefPSDEId(pSDataEntity.getPSDataEntityId());
        pSDEFormDetail.setRefPSDEName(pSDataEntity.getPSDataEntityName());
    }

    protected void onFillParentInfo_RefPSDEACMode(PSDEFormDetail pSDEFormDetail, PSDEACMode pSDEACMode) throws Exception {
        pSDEFormDetail.setRefPSDEACModeId(pSDEACMode.getPSDEACModeId());
        pSDEFormDetail.setRefPSDEACModeName(pSDEACMode.getPSDEACModeName());
    }

    protected void onFillParentInfo_PSDEDR(PSDEFormDetail pSDEFormDetail, PSDEDataRelation pSDEDataRelation) throws Exception {
        pSDEFormDetail.setPSDEDRId(pSDEDataRelation.getPSDEDataRelationId());
        pSDEFormDetail.setPSDEDRName(pSDEDataRelation.getPSDEDataRelationName());
    }

    protected void onFillParentInfo_RefPSDEDataSet(PSDEFormDetail pSDEFormDetail, PSDEDataSet pSDEDataSet) throws Exception {
        pSDEFormDetail.setRefPSDEDataSetId(pSDEDataSet.getPSDEDataSetId());
        pSDEFormDetail.setRefPSDEDataSetName(pSDEDataSet.getPSDEDataSetName());
    }

    protected void onFillParentInfo_MDPSDEDataView(PSDEFormDetail pSDEFormDetail, PSDEDataView pSDEDataView) throws Exception {
        pSDEFormDetail.setMDPSDEDataViewId(pSDEDataView.getPSDEDataViewId());
        pSDEFormDetail.setMDPSDEDataViewName(pSDEDataView.getPSDEDataViewName());
    }

    protected void onFillParentInfo_PSDEDRItem(PSDEFormDetail pSDEFormDetail, PSDEDRItem pSDEDRItem) throws Exception {
        pSDEFormDetail.setPSDEDRItemId(pSDEDRItem.getPSDEDRItemId());
        pSDEFormDetail.setPSDEDRItemName(pSDEDRItem.getPSDEDRItemName());
    }

    protected void onFillParentInfo_PSDEFUIMode(PSDEFormDetail pSDEFormDetail, PSDEFUIMode pSDEFUIMode) throws Exception {
        pSDEFormDetail.setPSDEFUIModeId(pSDEFUIMode.getPSDEFUIModeId());
        pSDEFormDetail.setPSDEFUIModeName(pSDEFUIMode.getPSDEFUIModeName());
    }

    protected void onFillParentInfo_PSDEF(PSDEFormDetail pSDEFormDetail, PSDEField pSDEField) throws Exception {
        pSDEFormDetail.setPSDEFId(pSDEField.getPSDEFieldId());
        pSDEFormDetail.setPSDEFName(pSDEField.getPSDEFieldName());
    }

    protected void onFillParentInfo_PSDEFIUpdate(PSDEFormDetail pSDEFormDetail, PSDEFIUpdate pSDEFIUpdate) throws Exception {
        pSDEFormDetail.setPSDEFIUpdateId(pSDEFIUpdate.getPSDEFIUpdateId());
        pSDEFormDetail.setPSDEFIUpdateName(pSDEFIUpdate.getPSDEFIUpdateName());
    }

    protected void onFillParentInfo_PPSDEFormDetail(PSDEFormDetail pSDEFormDetail, PSDEFormDetail pSDEFormDetail2) throws Exception {
        pSDEFormDetail.setPLayoutMode(pSDEFormDetail2.getLayoutMode());
        pSDEFormDetail.setPPSDEFormDetailId(pSDEFormDetail2.getPSDEFormDetailId());
        pSDEFormDetail.setPPSDEFormDetailName(pSDEFormDetail2.getPSDEFormDetailName());
        if (pSDEFormDetail2.getPSDEForm() != null) {
            this.onFillParentInfo_PSDEForm(pSDEFormDetail, pSDEFormDetail2.getPSDEForm());
        }
    }

    protected void onFillParentInfo_RefPSDEFormDetail(PSDEFormDetail pSDEFormDetail, PSDEFormDetail pSDEFormDetail2) throws Exception {
        pSDEFormDetail.setRefPSDEFormDetailId(pSDEFormDetail2.getPSDEFormDetailId());
        pSDEFormDetail.setRefPSDEFormDetailName(pSDEFormDetail2.getPSDEFormDetailName());
    }

    protected void onFillParentInfo_PSDEFormRF(PSDEFormDetail pSDEFormDetail, PSDEFormRF pSDEFormRF) throws Exception {
        pSDEFormDetail.setPSDEFormRFId(pSDEFormRF.getPSDEFormRFId());
        pSDEFormDetail.setPSDEFormRFName(pSDEFormRF.getPSDEFormRFName());
        pSDEFormDetail.setRefPSDEFormId(pSDEFormRF.getMinorPSDEFormId());
    }

    protected void onFillParentInfo_MDPSDEForm(PSDEFormDetail pSDEFormDetail, PSDEForm pSDEForm) throws Exception {
        pSDEFormDetail.setMDPSDEFormId(pSDEForm.getPSDEFormId());
        pSDEFormDetail.setMDPSDEFormName(pSDEForm.getPSDEFormName());
    }

    protected void onFillParentInfo_PSDEForm(PSDEFormDetail pSDEFormDetail, PSDEForm pSDEForm) throws Exception {
        pSDEFormDetail.setFormType(pSDEForm.getFormType());
        pSDEFormDetail.setMobFlag(pSDEForm.getMobFlag());
        pSDEFormDetail.setPSDEFormId(pSDEForm.getPSDEFormId());
        pSDEFormDetail.setPSDEFormName(pSDEForm.getPSDEFormName());
        pSDEFormDetail.setPSDEId(pSDEForm.getPSDEId());
    }

    protected String onSyncDER1NData_PSDEForm(PSDEForm pSDEForm, String string) throws Exception {
        if (StringHelper.isNullOrEmpty((String)string)) {
            this.removeByPSDEForm(pSDEForm);
        } else {
            HashMap<String, String> hashMap = new HashMap<String, String>();
            String[] stringArray = StringHelper.splitEx((String)string);
            if (stringArray != null) {
                for (int i = 0; i < stringArray.length; ++i) {
                    if (StringHelper.isNullOrEmpty((String)stringArray[i])) continue;
                    hashMap.put(stringArray[i], "");
                }
            }
            ArrayList<PSDEFormDetail> arrayList = this.selectByPSDEForm(pSDEForm);
            for (PSDEFormDetail pSDEFormDetail : arrayList) {
                if (hashMap.containsKey(DataObject.getStringValue((IDataObject)pSDEFormDetail, (String)"PSDEFORMDETAILID", (String)""))) continue;
                this.remove(pSDEFormDetail);
            }
        }
        return null;
    }

    protected void onFillParentInfo_PSDEFSFItem(PSDEFormDetail pSDEFormDetail, PSDEFSFItem pSDEFSFItem) throws Exception {
        pSDEFormDetail.setPSDEFSFItemId(pSDEFSFItem.getPSDEFSFItemId());
        pSDEFormDetail.setPSDEFSFItemName(pSDEFSFItem.getPSDEFSFItemName());
    }

    protected void onFillParentInfo_MDPSDEGrid(PSDEFormDetail pSDEFormDetail, PSDEGrid pSDEGrid) throws Exception {
        pSDEFormDetail.setMDPSDEGridId(pSDEGrid.getPSDEGridId());
        pSDEFormDetail.setMDPSDEGridName(pSDEGrid.getPSDEGridName());
    }

    protected void onFillParentInfo_MDPSDEList(PSDEFormDetail pSDEFormDetail, PSDEList pSDEList) throws Exception {
        pSDEFormDetail.setMDPSDEListId(pSDEList.getPSDEListId());
        pSDEFormDetail.setMDPSDEListName(pSDEList.getPSDEListName());
    }

    protected void onFillParentInfo_PSDELogic(PSDEFormDetail pSDEFormDetail, PSDELogic pSDELogic) throws Exception {
        pSDEFormDetail.setPSDELogicId(pSDELogic.getPSDELogicId());
        pSDEFormDetail.setPSDELogicName(pSDELogic.getPSDELogicName());
    }

    protected void onFillParentInfo_RefPSDER(PSDEFormDetail pSDEFormDetail, PSDER pSDER) throws Exception {
        pSDEFormDetail.setRefPSDERId(pSDER.getPSDERId());
        pSDEFormDetail.setRefPSDERName(pSDER.getPSDERName());
    }

    protected void onFillParentInfo_PSDEUAGroup(PSDEFormDetail pSDEFormDetail, PSDEUAGroup pSDEUAGroup) throws Exception {
        pSDEFormDetail.setPSDEUAGroupId(pSDEUAGroup.getPSDEUAGroupId());
        pSDEFormDetail.setPSDEUAGroupName(pSDEUAGroup.getPSDEUAGroupName());
    }

    protected void onFillParentInfo_PSDEUIAction(PSDEFormDetail pSDEFormDetail, PSDEUIAction pSDEUIAction) throws Exception {
        pSDEFormDetail.setPSDEUIActionId(pSDEUIAction.getPSDEUIActionId());
        pSDEFormDetail.setPSDEUIActionName(pSDEUIAction.getPSDEUIActionName());
    }

    protected void onFillParentInfo_LinkPSDEView(PSDEFormDetail pSDEFormDetail, PSDEViewBase pSDEViewBase) throws Exception {
        pSDEFormDetail.setLinkPSDEViewId(pSDEViewBase.getPSDEViewBaseId());
        pSDEFormDetail.setLinkPSDEViewName(pSDEViewBase.getPSDEViewBaseName());
    }

    protected void onFillParentInfo_OpenPSDEView(PSDEFormDetail pSDEFormDetail, PSDEViewBase pSDEViewBase) throws Exception {
        pSDEFormDetail.setOpenPSDEViewId(pSDEViewBase.getPSDEViewBaseId());
        pSDEFormDetail.setOpenPSDEViewName(pSDEViewBase.getPSDEViewBaseName());
    }

    protected void onFillParentInfo_PickupPSDEView(PSDEFormDetail pSDEFormDetail, PSDEViewBase pSDEViewBase) throws Exception {
        pSDEFormDetail.setPickupPSDEViewId(pSDEViewBase.getPSDEViewBaseId());
        pSDEFormDetail.setPickupPSDEViewName(pSDEViewBase.getPSDEViewBaseName());
    }

    protected void onFillParentInfo_CapPSLanRes(PSDEFormDetail pSDEFormDetail, PSLanguageRes pSLanguageRes) throws Exception {
        pSDEFormDetail.setCapPSLanResId(pSLanguageRes.getPSLanguageResId());
        pSDEFormDetail.setCapPSLanResName(pSLanguageRes.getPSLanguageResName());
    }

    protected void onFillParentInfo_MaskPSLanRes(PSDEFormDetail pSDEFormDetail, PSLanguageRes pSLanguageRes) throws Exception {
        pSDEFormDetail.setMaskPSLanResId(pSLanguageRes.getPSLanguageResId());
        pSDEFormDetail.setMaskPSLanResName(pSLanguageRes.getPSLanguageResName());
    }

    protected void onFillParentInfo_PHPSLanRes(PSDEFormDetail pSDEFormDetail, PSLanguageRes pSLanguageRes) throws Exception {
        pSDEFormDetail.setPHPSLanResId(pSLanguageRes.getPSLanguageResId());
        pSDEFormDetail.setPHPSLanResName(pSLanguageRes.getPSLanguageResName());
    }

    protected void onFillParentInfo_TipPSLanRes(PSDEFormDetail pSDEFormDetail, PSLanguageRes pSLanguageRes) throws Exception {
        pSDEFormDetail.setTipPSLanResId(pSLanguageRes.getPSLanguageResId());
        pSDEFormDetail.setTipPSLanResName(pSLanguageRes.getPSLanguageResName());
    }

    protected void onFillParentInfo_PSSysCounter(PSDEFormDetail pSDEFormDetail, PSSysCounter pSSysCounter) throws Exception {
        pSDEFormDetail.setPSSysCounterId(pSSysCounter.getPSSysCounterId());
        pSDEFormDetail.setPSSysCounterName(pSSysCounter.getPSSysCounterName());
    }

    protected void onFillParentInfo_CtrlPSSysCss(PSDEFormDetail pSDEFormDetail, PSSysCss pSSysCss) throws Exception {
        pSDEFormDetail.setCtrlPSSysCssId(pSSysCss.getPSSysCssId());
        pSDEFormDetail.setCtrlPSSysCssName(pSSysCss.getPSSysCssName());
    }

    protected void onFillParentInfo_LabelPSSysCss(PSDEFormDetail pSDEFormDetail, PSSysCss pSSysCss) throws Exception {
        pSDEFormDetail.setLabelPSSysCssId(pSSysCss.getPSSysCssId());
        pSDEFormDetail.setLabelPSSysCssName(pSSysCss.getPSSysCssName());
    }

    protected void onFillParentInfo_PSSysCss(PSDEFormDetail pSDEFormDetail, PSSysCss pSSysCss) throws Exception {
        pSDEFormDetail.setPSSysCssId(pSSysCss.getPSSysCssId());
        pSDEFormDetail.setPSSysCssName(pSSysCss.getPSSysCssName());
    }

    protected void onFillParentInfo_PSSysDictCat(PSDEFormDetail pSDEFormDetail, PSSysDictCat pSSysDictCat) throws Exception {
        pSDEFormDetail.setPSSysDictCatId(pSSysDictCat.getPSSysDictCatId());
        pSDEFormDetail.setPSSysDictCatName(pSSysDictCat.getPSSysDictCatName());
    }

    protected void onFillParentInfo_PSSysDynaModel(PSDEFormDetail pSDEFormDetail, PSSysDynaModel pSSysDynaModel) throws Exception {
        pSDEFormDetail.setPSSysDynaModelId(pSSysDynaModel.getPSSysDynaModelId());
        pSDEFormDetail.setPSSysDynaModelName(pSSysDynaModel.getPSSysDynaModelName());
    }

    protected void onFillParentInfo_PSSysEditorStyle(PSDEFormDetail pSDEFormDetail, PSSysEditorStyle pSSysEditorStyle) throws Exception {
        pSDEFormDetail.setPSSysEditorStyleId(pSSysEditorStyle.getPSSysEditorStyleId());
        pSDEFormDetail.setPSSysEditorStyleName(pSSysEditorStyle.getPSSysEditorStyleName());
    }

    protected void onFillParentInfo_PSSysImage(PSDEFormDetail pSDEFormDetail, PSSysImage pSSysImage) throws Exception {
        pSDEFormDetail.setPSSysImageId(pSSysImage.getPSSysImageId());
        pSDEFormDetail.setPSSysImageName(pSSysImage.getPSSysImageName());
    }

    protected void onFillParentInfo_OpenPSSysPDTView(PSDEFormDetail pSDEFormDetail, PSSysPDTView pSSysPDTView) throws Exception {
        pSDEFormDetail.setOpenPSSysPDTViewId(pSSysPDTView.getPSSysPDTViewId());
        pSDEFormDetail.setOpenPSSysPDTViewName(pSSysPDTView.getPSSysPDTViewName());
    }

    protected void onFillParentInfo_UCPSSysPFPlugin(PSDEFormDetail pSDEFormDetail, PSSysPFPlugin pSSysPFPlugin) throws Exception {
        pSDEFormDetail.setUCPSSysPFPluginId(pSSysPFPlugin.getPSSysPFPluginId());
        pSDEFormDetail.setUCPSSysPFPluginName(pSSysPFPlugin.getPSSysPFPluginName());
    }

    protected void onFillParentInfo_PSSysResource(PSDEFormDetail pSDEFormDetail, PSSysResource pSSysResource) throws Exception {
        pSDEFormDetail.setPSSysResourceId(pSSysResource.getPSSysResourceId());
        pSDEFormDetail.setPSSysResourceName(pSSysResource.getPSSysResourceName());
    }

    protected void onFillParentInfo_MDPSSysViewPanel(PSDEFormDetail pSDEFormDetail, PSSysViewPanel pSSysViewPanel) throws Exception {
        pSDEFormDetail.setMDPSSysViewPanelId(pSSysViewPanel.getPSSysViewPanelId());
        pSDEFormDetail.setMDPSSysViewPanelName(pSSysViewPanel.getPSSysViewPanelName());
    }

    protected void onFillEntityFullInfo(PSDEFormDetail pSDEFormDetail, boolean bl) throws Exception {
        if (bl && pSDEFormDetail.getModelState() == null) {
            pSDEFormDetail.setModelState((Integer)this.getDefaultValue(this.getWebContext(), "", "0", 9));
        }
        super.onFillEntityFullInfo(pSDEFormDetail, bl);
        this.onFillEntityFullInfo_ItemPSACHandler(pSDEFormDetail, bl);
        this.onFillEntityFullInfo_PSCodeList(pSDEFormDetail, bl);
        this.onFillEntityFullInfo_RefPSDE(pSDEFormDetail, bl);
        this.onFillEntityFullInfo_RefPSDEACMode(pSDEFormDetail, bl);
        this.onFillEntityFullInfo_PSDEDR(pSDEFormDetail, bl);
        this.onFillEntityFullInfo_RefPSDEDataSet(pSDEFormDetail, bl);
        this.onFillEntityFullInfo_MDPSDEDataView(pSDEFormDetail, bl);
        this.onFillEntityFullInfo_PSDEDRItem(pSDEFormDetail, bl);
        this.onFillEntityFullInfo_PSDEFUIMode(pSDEFormDetail, bl);
        this.onFillEntityFullInfo_PSDEF(pSDEFormDetail, bl);
        this.onFillEntityFullInfo_PSDEFIUpdate(pSDEFormDetail, bl);
        this.onFillEntityFullInfo_PPSDEFormDetail(pSDEFormDetail, bl);
        this.onFillEntityFullInfo_RefPSDEFormDetail(pSDEFormDetail, bl);
        this.onFillEntityFullInfo_PSDEFormRF(pSDEFormDetail, bl);
        this.onFillEntityFullInfo_MDPSDEForm(pSDEFormDetail, bl);
        this.onFillEntityFullInfo_PSDEForm(pSDEFormDetail, bl);
        this.onFillEntityFullInfo_PSDEFSFItem(pSDEFormDetail, bl);
        this.onFillEntityFullInfo_MDPSDEGrid(pSDEFormDetail, bl);
        this.onFillEntityFullInfo_MDPSDEList(pSDEFormDetail, bl);
        this.onFillEntityFullInfo_PSDELogic(pSDEFormDetail, bl);
        this.onFillEntityFullInfo_RefPSDER(pSDEFormDetail, bl);
        this.onFillEntityFullInfo_PSDEUAGroup(pSDEFormDetail, bl);
        this.onFillEntityFullInfo_PSDEUIAction(pSDEFormDetail, bl);
        this.onFillEntityFullInfo_LinkPSDEView(pSDEFormDetail, bl);
        this.onFillEntityFullInfo_OpenPSDEView(pSDEFormDetail, bl);
        this.onFillEntityFullInfo_PickupPSDEView(pSDEFormDetail, bl);
        this.onFillEntityFullInfo_CapPSLanRes(pSDEFormDetail, bl);
        this.onFillEntityFullInfo_MaskPSLanRes(pSDEFormDetail, bl);
        this.onFillEntityFullInfo_PHPSLanRes(pSDEFormDetail, bl);
        this.onFillEntityFullInfo_TipPSLanRes(pSDEFormDetail, bl);
        this.onFillEntityFullInfo_PSSysCounter(pSDEFormDetail, bl);
        this.onFillEntityFullInfo_CtrlPSSysCss(pSDEFormDetail, bl);
        this.onFillEntityFullInfo_LabelPSSysCss(pSDEFormDetail, bl);
        this.onFillEntityFullInfo_PSSysCss(pSDEFormDetail, bl);
        this.onFillEntityFullInfo_PSSysDictCat(pSDEFormDetail, bl);
        this.onFillEntityFullInfo_PSSysDynaModel(pSDEFormDetail, bl);
        this.onFillEntityFullInfo_PSSysEditorStyle(pSDEFormDetail, bl);
        this.onFillEntityFullInfo_PSSysImage(pSDEFormDetail, bl);
        this.onFillEntityFullInfo_OpenPSSysPDTView(pSDEFormDetail, bl);
        this.onFillEntityFullInfo_UCPSSysPFPlugin(pSDEFormDetail, bl);
        this.onFillEntityFullInfo_PSSysResource(pSDEFormDetail, bl);
        this.onFillEntityFullInfo_MDPSSysViewPanel(pSDEFormDetail, bl);
    }

    protected void onFillEntityFullInfo_ItemPSACHandler(PSDEFormDetail pSDEFormDetail, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSCodeList(PSDEFormDetail pSDEFormDetail, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_RefPSDE(PSDEFormDetail pSDEFormDetail, boolean bl) throws Exception {
        if (pSDEFormDetail.isRefPSDEIdDirty()) {
            if (pSDEFormDetail.getRefPSDEId() != null) {
                if (pSDEFormDetail.getRefPSDEId() == null || pSDEFormDetail.getRefPSDEName() == null) {
                    PSDataEntity pSDataEntity = pSDEFormDetail.getRefPSDE();
                    pSDEFormDetail.setRefPSDEName(pSDataEntity.getPSDataEntityName());
                }
            } else {
                pSDEFormDetail.setRefPSDEName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_RefPSDEACMode(PSDEFormDetail pSDEFormDetail, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSDEDR(PSDEFormDetail pSDEFormDetail, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_RefPSDEDataSet(PSDEFormDetail pSDEFormDetail, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_MDPSDEDataView(PSDEFormDetail pSDEFormDetail, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSDEDRItem(PSDEFormDetail pSDEFormDetail, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSDEFUIMode(PSDEFormDetail pSDEFormDetail, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSDEF(PSDEFormDetail pSDEFormDetail, boolean bl) throws Exception {
        if (pSDEFormDetail.isPSDEFIdDirty()) {
            if (pSDEFormDetail.getPSDEFId() != null) {
                if (pSDEFormDetail.getPSDEFId() == null || pSDEFormDetail.getPSDEFName() == null) {
                    PSDEField pSDEField = pSDEFormDetail.getPSDEF();
                    pSDEFormDetail.setPSDEFName(pSDEField.getPSDEFieldName());
                }
            } else {
                pSDEFormDetail.setPSDEFName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_PSDEFIUpdate(PSDEFormDetail pSDEFormDetail, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PPSDEFormDetail(PSDEFormDetail pSDEFormDetail, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_RefPSDEFormDetail(PSDEFormDetail pSDEFormDetail, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSDEFormRF(PSDEFormDetail pSDEFormDetail, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_MDPSDEForm(PSDEFormDetail pSDEFormDetail, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSDEForm(PSDEFormDetail pSDEFormDetail, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSDEFSFItem(PSDEFormDetail pSDEFormDetail, boolean bl) throws Exception {
        if (pSDEFormDetail.isPSDEFSFItemIdDirty()) {
            if (pSDEFormDetail.getPSDEFSFItemId() != null) {
                if (pSDEFormDetail.getPSDEFSFItemId() == null || pSDEFormDetail.getPSDEFSFItemName() == null) {
                    PSDEFSFItem pSDEFSFItem = pSDEFormDetail.getPSDEFSFItem();
                    pSDEFormDetail.setPSDEFSFItemName(pSDEFSFItem.getPSDEFSFItemName());
                }
            } else {
                pSDEFormDetail.setPSDEFSFItemName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_MDPSDEGrid(PSDEFormDetail pSDEFormDetail, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_MDPSDEList(PSDEFormDetail pSDEFormDetail, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSDELogic(PSDEFormDetail pSDEFormDetail, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_RefPSDER(PSDEFormDetail pSDEFormDetail, boolean bl) throws Exception {
        if (pSDEFormDetail.isRefPSDERIdDirty()) {
            if (pSDEFormDetail.getRefPSDERId() != null) {
                if (pSDEFormDetail.getRefPSDERId() == null || pSDEFormDetail.getRefPSDERName() == null) {
                    PSDER pSDER = pSDEFormDetail.getRefPSDER();
                    pSDEFormDetail.setRefPSDERName(pSDER.getPSDERName());
                }
            } else {
                pSDEFormDetail.setRefPSDERName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_PSDEUAGroup(PSDEFormDetail pSDEFormDetail, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSDEUIAction(PSDEFormDetail pSDEFormDetail, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_LinkPSDEView(PSDEFormDetail pSDEFormDetail, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_OpenPSDEView(PSDEFormDetail pSDEFormDetail, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PickupPSDEView(PSDEFormDetail pSDEFormDetail, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_CapPSLanRes(PSDEFormDetail pSDEFormDetail, boolean bl) throws Exception {
        if (pSDEFormDetail.isCapPSLanResIdDirty()) {
            if (pSDEFormDetail.getCapPSLanResId() != null) {
                if (pSDEFormDetail.getCapPSLanResId() == null || pSDEFormDetail.getCapPSLanResName() == null) {
                    PSLanguageRes pSLanguageRes = pSDEFormDetail.getCapPSLanRes();
                    pSDEFormDetail.setCapPSLanResName(pSLanguageRes.getPSLanguageResName());
                }
            } else {
                pSDEFormDetail.setCapPSLanResName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_MaskPSLanRes(PSDEFormDetail pSDEFormDetail, boolean bl) throws Exception {
        if (pSDEFormDetail.isMaskPSLanResIdDirty()) {
            if (pSDEFormDetail.getMaskPSLanResId() != null) {
                if (pSDEFormDetail.getMaskPSLanResId() == null || pSDEFormDetail.getMaskPSLanResName() == null) {
                    PSLanguageRes pSLanguageRes = pSDEFormDetail.getMaskPSLanRes();
                    pSDEFormDetail.setMaskPSLanResName(pSLanguageRes.getPSLanguageResName());
                }
            } else {
                pSDEFormDetail.setMaskPSLanResName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_PHPSLanRes(PSDEFormDetail pSDEFormDetail, boolean bl) throws Exception {
        if (pSDEFormDetail.isPHPSLanResIdDirty()) {
            if (pSDEFormDetail.getPHPSLanResId() != null) {
                if (pSDEFormDetail.getPHPSLanResId() == null || pSDEFormDetail.getPHPSLanResName() == null) {
                    PSLanguageRes pSLanguageRes = pSDEFormDetail.getPHPSLanRes();
                    pSDEFormDetail.setPHPSLanResName(pSLanguageRes.getPSLanguageResName());
                }
            } else {
                pSDEFormDetail.setPHPSLanResName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_TipPSLanRes(PSDEFormDetail pSDEFormDetail, boolean bl) throws Exception {
        if (pSDEFormDetail.isTipPSLanResIdDirty()) {
            if (pSDEFormDetail.getTipPSLanResId() != null) {
                if (pSDEFormDetail.getTipPSLanResId() == null || pSDEFormDetail.getTipPSLanResName() == null) {
                    PSLanguageRes pSLanguageRes = pSDEFormDetail.getTipPSLanRes();
                    pSDEFormDetail.setTipPSLanResName(pSLanguageRes.getPSLanguageResName());
                }
            } else {
                pSDEFormDetail.setTipPSLanResName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_PSSysCounter(PSDEFormDetail pSDEFormDetail, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_CtrlPSSysCss(PSDEFormDetail pSDEFormDetail, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_LabelPSSysCss(PSDEFormDetail pSDEFormDetail, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSSysCss(PSDEFormDetail pSDEFormDetail, boolean bl) throws Exception {
        if (pSDEFormDetail.isPSSysCssIdDirty()) {
            if (pSDEFormDetail.getPSSysCssId() != null) {
                if (pSDEFormDetail.getPSSysCssId() == null || pSDEFormDetail.getPSSysCssName() == null) {
                    PSSysCss pSSysCss = pSDEFormDetail.getPSSysCss();
                    pSDEFormDetail.setPSSysCssName(pSSysCss.getPSSysCssName());
                }
            } else {
                pSDEFormDetail.setPSSysCssName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_PSSysDictCat(PSDEFormDetail pSDEFormDetail, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSSysDynaModel(PSDEFormDetail pSDEFormDetail, boolean bl) throws Exception {
        if (pSDEFormDetail.isPSSysDynaModelIdDirty()) {
            if (pSDEFormDetail.getPSSysDynaModelId() != null) {
                if (pSDEFormDetail.getPSSysDynaModelId() == null || pSDEFormDetail.getPSSysDynaModelName() == null) {
                    PSSysDynaModel pSSysDynaModel = pSDEFormDetail.getPSSysDynaModel();
                    pSDEFormDetail.setPSSysDynaModelName(pSSysDynaModel.getPSSysDynaModelName());
                }
            } else {
                pSDEFormDetail.setPSSysDynaModelName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_PSSysEditorStyle(PSDEFormDetail pSDEFormDetail, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSSysImage(PSDEFormDetail pSDEFormDetail, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_OpenPSSysPDTView(PSDEFormDetail pSDEFormDetail, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_UCPSSysPFPlugin(PSDEFormDetail pSDEFormDetail, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSSysResource(PSDEFormDetail pSDEFormDetail, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_MDPSSysViewPanel(PSDEFormDetail pSDEFormDetail, boolean bl) throws Exception {
    }

    protected void onWriteBackParent(PSDEFormDetail pSDEFormDetail, boolean bl) throws Exception {
        super.onWriteBackParent(pSDEFormDetail, bl);
    }

    public ArrayList<PSDEFormDetail> selectByItemPSACHandler(PSACHandlerBase pSACHandlerBase) throws Exception {
        return this.selectByItemPSACHandler(pSACHandlerBase, "", -1);
    }

    public ArrayList<PSDEFormDetail> selectByItemPSACHandler(PSACHandlerBase pSACHandlerBase, String string) throws Exception {
        return this.selectByItemPSACHandler(pSACHandlerBase, string, -1);
    }

    public ArrayList<PSDEFormDetail> selectByItemPSACHandler(PSACHandlerBase pSACHandlerBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("ITEMPSACHANDLERID", (Object)pSACHandlerBase.getPSACHandlerId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByItemPSACHandlerCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByItemPSACHandlerCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDEFormDetail> selectByPSCodeList(PSCodeListBase pSCodeListBase) throws Exception {
        return this.selectByPSCodeList(pSCodeListBase, "", -1);
    }

    public ArrayList<PSDEFormDetail> selectByPSCodeList(PSCodeListBase pSCodeListBase, String string) throws Exception {
        return this.selectByPSCodeList(pSCodeListBase, string, -1);
    }

    public ArrayList<PSDEFormDetail> selectByPSCodeList(PSCodeListBase pSCodeListBase, String string, int n) throws Exception {
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

    public ArrayList<PSDEFormDetail> selectByRefPSDE(PSDataEntityBase pSDataEntityBase) throws Exception {
        return this.selectByRefPSDE(pSDataEntityBase, "", -1);
    }

    public ArrayList<PSDEFormDetail> selectByRefPSDE(PSDataEntityBase pSDataEntityBase, String string) throws Exception {
        return this.selectByRefPSDE(pSDataEntityBase, string, -1);
    }

    public ArrayList<PSDEFormDetail> selectByRefPSDE(PSDataEntityBase pSDataEntityBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("REFPSDEID", (Object)pSDataEntityBase.getPSDataEntityId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByRefPSDECond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByRefPSDECond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDEFormDetail> selectByRefPSDEACMode(PSDEACModeBase pSDEACModeBase) throws Exception {
        return this.selectByRefPSDEACMode(pSDEACModeBase, "", -1);
    }

    public ArrayList<PSDEFormDetail> selectByRefPSDEACMode(PSDEACModeBase pSDEACModeBase, String string) throws Exception {
        return this.selectByRefPSDEACMode(pSDEACModeBase, string, -1);
    }

    public ArrayList<PSDEFormDetail> selectByRefPSDEACMode(PSDEACModeBase pSDEACModeBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("REFPSDEACMODEID", (Object)pSDEACModeBase.getPSDEACModeId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByRefPSDEACModeCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByRefPSDEACModeCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDEFormDetail> selectByPSDEDR(PSDEDataRelationBase pSDEDataRelationBase) throws Exception {
        return this.selectByPSDEDR(pSDEDataRelationBase, "", -1);
    }

    public ArrayList<PSDEFormDetail> selectByPSDEDR(PSDEDataRelationBase pSDEDataRelationBase, String string) throws Exception {
        return this.selectByPSDEDR(pSDEDataRelationBase, string, -1);
    }

    public ArrayList<PSDEFormDetail> selectByPSDEDR(PSDEDataRelationBase pSDEDataRelationBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDEDRID", (Object)pSDEDataRelationBase.getPSDEDataRelationId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSDEDRCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSDEDRCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDEFormDetail> selectByRefPSDEDataSet(PSDEDataSetBase pSDEDataSetBase) throws Exception {
        return this.selectByRefPSDEDataSet(pSDEDataSetBase, "", -1);
    }

    public ArrayList<PSDEFormDetail> selectByRefPSDEDataSet(PSDEDataSetBase pSDEDataSetBase, String string) throws Exception {
        return this.selectByRefPSDEDataSet(pSDEDataSetBase, string, -1);
    }

    public ArrayList<PSDEFormDetail> selectByRefPSDEDataSet(PSDEDataSetBase pSDEDataSetBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("REFPSDEDATASETID", (Object)pSDEDataSetBase.getPSDEDataSetId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByRefPSDEDataSetCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByRefPSDEDataSetCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDEFormDetail> selectByMDPSDEDataView(PSDEDataViewBase pSDEDataViewBase) throws Exception {
        return this.selectByMDPSDEDataView(pSDEDataViewBase, "", -1);
    }

    public ArrayList<PSDEFormDetail> selectByMDPSDEDataView(PSDEDataViewBase pSDEDataViewBase, String string) throws Exception {
        return this.selectByMDPSDEDataView(pSDEDataViewBase, string, -1);
    }

    public ArrayList<PSDEFormDetail> selectByMDPSDEDataView(PSDEDataViewBase pSDEDataViewBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("MDPSDEDATAVIEWID", (Object)pSDEDataViewBase.getPSDEDataViewId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByMDPSDEDataViewCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByMDPSDEDataViewCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDEFormDetail> selectByPSDEDRItem(PSDEDRItemBase pSDEDRItemBase) throws Exception {
        return this.selectByPSDEDRItem(pSDEDRItemBase, "", -1);
    }

    public ArrayList<PSDEFormDetail> selectByPSDEDRItem(PSDEDRItemBase pSDEDRItemBase, String string) throws Exception {
        return this.selectByPSDEDRItem(pSDEDRItemBase, string, -1);
    }

    public ArrayList<PSDEFormDetail> selectByPSDEDRItem(PSDEDRItemBase pSDEDRItemBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDEDRITEMID", (Object)pSDEDRItemBase.getPSDEDRItemId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSDEDRItemCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSDEDRItemCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDEFormDetail> selectByPSDEFUIMode(PSDEFUIModeBase pSDEFUIModeBase) throws Exception {
        return this.selectByPSDEFUIMode(pSDEFUIModeBase, "", -1);
    }

    public ArrayList<PSDEFormDetail> selectByPSDEFUIMode(PSDEFUIModeBase pSDEFUIModeBase, String string) throws Exception {
        return this.selectByPSDEFUIMode(pSDEFUIModeBase, string, -1);
    }

    public ArrayList<PSDEFormDetail> selectByPSDEFUIMode(PSDEFUIModeBase pSDEFUIModeBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDEFFORMITEMID", (Object)pSDEFUIModeBase.getPSDEFUIModeId());
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

    public ArrayList<PSDEFormDetail> selectByPSDEF(PSDEFieldBase pSDEFieldBase) throws Exception {
        return this.selectByPSDEF(pSDEFieldBase, "", -1);
    }

    public ArrayList<PSDEFormDetail> selectByPSDEF(PSDEFieldBase pSDEFieldBase, String string) throws Exception {
        return this.selectByPSDEF(pSDEFieldBase, string, -1);
    }

    public ArrayList<PSDEFormDetail> selectByPSDEF(PSDEFieldBase pSDEFieldBase, String string, int n) throws Exception {
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

    public ArrayList<PSDEFormDetail> selectByPSDEFIUpdate(PSDEFIUpdateBase pSDEFIUpdateBase) throws Exception {
        return this.selectByPSDEFIUpdate(pSDEFIUpdateBase, "", -1);
    }

    public ArrayList<PSDEFormDetail> selectByPSDEFIUpdate(PSDEFIUpdateBase pSDEFIUpdateBase, String string) throws Exception {
        return this.selectByPSDEFIUpdate(pSDEFIUpdateBase, string, -1);
    }

    public ArrayList<PSDEFormDetail> selectByPSDEFIUpdate(PSDEFIUpdateBase pSDEFIUpdateBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDEFIUPDATEID", (Object)pSDEFIUpdateBase.getPSDEFIUpdateId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSDEFIUpdateCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSDEFIUpdateCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDEFormDetail> selectTempByPSDEFIUpdate(PSDEFIUpdateBase pSDEFIUpdateBase) throws Exception {
        return this.selectTempByPSDEFIUpdate(pSDEFIUpdateBase, "");
    }

    public ArrayList<PSDEFormDetail> selectTempByPSDEFIUpdate(PSDEFIUpdateBase pSDEFIUpdateBase, String string) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDEFIUPDATEID", (Object)pSDEFIUpdateBase.getPSDEFIUpdateId());
        selectCond.setOrderInfo(string);
        this.onFillSelectTempByPSDEFIUpdateCond(selectCond);
        return this.selectTemp((ISelectCond)selectCond);
    }

    protected void onFillSelectTempByPSDEFIUpdateCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDEFormDetail> selectByPPSDEFormDetail(PSDEFormDetailBase pSDEFormDetailBase) throws Exception {
        return this.selectByPPSDEFormDetail(pSDEFormDetailBase, "", -1);
    }

    public ArrayList<PSDEFormDetail> selectByPPSDEFormDetail(PSDEFormDetailBase pSDEFormDetailBase, String string) throws Exception {
        return this.selectByPPSDEFormDetail(pSDEFormDetailBase, string, -1);
    }

    public ArrayList<PSDEFormDetail> selectByPPSDEFormDetail(PSDEFormDetailBase pSDEFormDetailBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PPSDEFORMDETAILID", (Object)pSDEFormDetailBase.getPSDEFormDetailId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPPSDEFormDetailCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPPSDEFormDetailCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDEFormDetail> selectTempByPPSDEFormDetail(PSDEFormDetailBase pSDEFormDetailBase) throws Exception {
        return this.selectTempByPPSDEFormDetail(pSDEFormDetailBase, "");
    }

    public ArrayList<PSDEFormDetail> selectTempByPPSDEFormDetail(PSDEFormDetailBase pSDEFormDetailBase, String string) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PPSDEFORMDETAILID", (Object)pSDEFormDetailBase.getPSDEFormDetailId());
        selectCond.setOrderInfo(string);
        this.onFillSelectTempByPPSDEFormDetailCond(selectCond);
        return this.selectTemp((ISelectCond)selectCond);
    }

    protected void onFillSelectTempByPPSDEFormDetailCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDEFormDetail> selectByRefPSDEFormDetail(PSDEFormDetailBase pSDEFormDetailBase) throws Exception {
        return this.selectByRefPSDEFormDetail(pSDEFormDetailBase, "", -1);
    }

    public ArrayList<PSDEFormDetail> selectByRefPSDEFormDetail(PSDEFormDetailBase pSDEFormDetailBase, String string) throws Exception {
        return this.selectByRefPSDEFormDetail(pSDEFormDetailBase, string, -1);
    }

    public ArrayList<PSDEFormDetail> selectByRefPSDEFormDetail(PSDEFormDetailBase pSDEFormDetailBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("REFPSDEFORMDETAILID", (Object)pSDEFormDetailBase.getPSDEFormDetailId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByRefPSDEFormDetailCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByRefPSDEFormDetailCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDEFormDetail> selectTempByRefPSDEFormDetail(PSDEFormDetailBase pSDEFormDetailBase) throws Exception {
        return this.selectTempByRefPSDEFormDetail(pSDEFormDetailBase, "");
    }

    public ArrayList<PSDEFormDetail> selectTempByRefPSDEFormDetail(PSDEFormDetailBase pSDEFormDetailBase, String string) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("REFPSDEFORMDETAILID", (Object)pSDEFormDetailBase.getPSDEFormDetailId());
        selectCond.setOrderInfo(string);
        this.onFillSelectTempByRefPSDEFormDetailCond(selectCond);
        return this.selectTemp((ISelectCond)selectCond);
    }

    protected void onFillSelectTempByRefPSDEFormDetailCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDEFormDetail> selectByPSDEFormRF(PSDEFormRFBase pSDEFormRFBase) throws Exception {
        return this.selectByPSDEFormRF(pSDEFormRFBase, "", -1);
    }

    public ArrayList<PSDEFormDetail> selectByPSDEFormRF(PSDEFormRFBase pSDEFormRFBase, String string) throws Exception {
        return this.selectByPSDEFormRF(pSDEFormRFBase, string, -1);
    }

    public ArrayList<PSDEFormDetail> selectByPSDEFormRF(PSDEFormRFBase pSDEFormRFBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDEFORMRFID", (Object)pSDEFormRFBase.getPSDEFormRFId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSDEFormRFCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSDEFormRFCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDEFormDetail> selectTempByPSDEFormRF(PSDEFormRFBase pSDEFormRFBase) throws Exception {
        return this.selectTempByPSDEFormRF(pSDEFormRFBase, "");
    }

    public ArrayList<PSDEFormDetail> selectTempByPSDEFormRF(PSDEFormRFBase pSDEFormRFBase, String string) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDEFORMRFID", (Object)pSDEFormRFBase.getPSDEFormRFId());
        selectCond.setOrderInfo(string);
        this.onFillSelectTempByPSDEFormRFCond(selectCond);
        return this.selectTemp((ISelectCond)selectCond);
    }

    protected void onFillSelectTempByPSDEFormRFCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDEFormDetail> selectByMDPSDEForm(PSDEFormBase pSDEFormBase) throws Exception {
        return this.selectByMDPSDEForm(pSDEFormBase, "", -1);
    }

    public ArrayList<PSDEFormDetail> selectByMDPSDEForm(PSDEFormBase pSDEFormBase, String string) throws Exception {
        return this.selectByMDPSDEForm(pSDEFormBase, string, -1);
    }

    public ArrayList<PSDEFormDetail> selectByMDPSDEForm(PSDEFormBase pSDEFormBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("MDPSDEFORMID", (Object)pSDEFormBase.getPSDEFormId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByMDPSDEFormCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByMDPSDEFormCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDEFormDetail> selectByPSDEForm(PSDEFormBase pSDEFormBase) throws Exception {
        return this.selectByPSDEForm(pSDEFormBase, "", -1);
    }

    public ArrayList<PSDEFormDetail> selectByPSDEForm(PSDEFormBase pSDEFormBase, String string) throws Exception {
        return this.selectByPSDEForm(pSDEFormBase, string, -1);
    }

    public ArrayList<PSDEFormDetail> selectByPSDEForm(PSDEFormBase pSDEFormBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDEFORMID", (Object)pSDEFormBase.getPSDEFormId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSDEFormCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSDEFormCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDEFormDetail> selectTempByPSDEForm(PSDEFormBase pSDEFormBase) throws Exception {
        return this.selectTempByPSDEForm(pSDEFormBase, "");
    }

    public ArrayList<PSDEFormDetail> selectTempByPSDEForm(PSDEFormBase pSDEFormBase, String string) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDEFORMID", (Object)pSDEFormBase.getPSDEFormId());
        selectCond.setOrderInfo(string);
        this.onFillSelectTempByPSDEFormCond(selectCond);
        return this.selectTemp((ISelectCond)selectCond);
    }

    protected void onFillSelectTempByPSDEFormCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDEFormDetail> selectByPSDEFSFItem(PSDEFSFItemBase pSDEFSFItemBase) throws Exception {
        return this.selectByPSDEFSFItem(pSDEFSFItemBase, "", -1);
    }

    public ArrayList<PSDEFormDetail> selectByPSDEFSFItem(PSDEFSFItemBase pSDEFSFItemBase, String string) throws Exception {
        return this.selectByPSDEFSFItem(pSDEFSFItemBase, string, -1);
    }

    public ArrayList<PSDEFormDetail> selectByPSDEFSFItem(PSDEFSFItemBase pSDEFSFItemBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDEFSFITEMID", (Object)pSDEFSFItemBase.getPSDEFSFItemId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSDEFSFItemCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSDEFSFItemCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDEFormDetail> selectByMDPSDEGrid(PSDEGridBase pSDEGridBase) throws Exception {
        return this.selectByMDPSDEGrid(pSDEGridBase, "", -1);
    }

    public ArrayList<PSDEFormDetail> selectByMDPSDEGrid(PSDEGridBase pSDEGridBase, String string) throws Exception {
        return this.selectByMDPSDEGrid(pSDEGridBase, string, -1);
    }

    public ArrayList<PSDEFormDetail> selectByMDPSDEGrid(PSDEGridBase pSDEGridBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("MDPSDEGRIDID", (Object)pSDEGridBase.getPSDEGridId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByMDPSDEGridCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByMDPSDEGridCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDEFormDetail> selectByMDPSDEList(PSDEListBase pSDEListBase) throws Exception {
        return this.selectByMDPSDEList(pSDEListBase, "", -1);
    }

    public ArrayList<PSDEFormDetail> selectByMDPSDEList(PSDEListBase pSDEListBase, String string) throws Exception {
        return this.selectByMDPSDEList(pSDEListBase, string, -1);
    }

    public ArrayList<PSDEFormDetail> selectByMDPSDEList(PSDEListBase pSDEListBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("MDPSDELISTID", (Object)pSDEListBase.getPSDEListId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByMDPSDEListCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByMDPSDEListCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDEFormDetail> selectByPSDELogic(PSDELogicBase pSDELogicBase) throws Exception {
        return this.selectByPSDELogic(pSDELogicBase, "", -1);
    }

    public ArrayList<PSDEFormDetail> selectByPSDELogic(PSDELogicBase pSDELogicBase, String string) throws Exception {
        return this.selectByPSDELogic(pSDELogicBase, string, -1);
    }

    public ArrayList<PSDEFormDetail> selectByPSDELogic(PSDELogicBase pSDELogicBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDELOGICID", (Object)pSDELogicBase.getPSDELogicId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSDELogicCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSDELogicCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDEFormDetail> selectByRefPSDER(PSDERBase pSDERBase) throws Exception {
        return this.selectByRefPSDER(pSDERBase, "", -1);
    }

    public ArrayList<PSDEFormDetail> selectByRefPSDER(PSDERBase pSDERBase, String string) throws Exception {
        return this.selectByRefPSDER(pSDERBase, string, -1);
    }

    public ArrayList<PSDEFormDetail> selectByRefPSDER(PSDERBase pSDERBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("REFPSDERID", (Object)pSDERBase.getPSDERId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByRefPSDERCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByRefPSDERCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDEFormDetail> selectByPSDEUAGroup(PSDEUAGroupBase pSDEUAGroupBase) throws Exception {
        return this.selectByPSDEUAGroup(pSDEUAGroupBase, "", -1);
    }

    public ArrayList<PSDEFormDetail> selectByPSDEUAGroup(PSDEUAGroupBase pSDEUAGroupBase, String string) throws Exception {
        return this.selectByPSDEUAGroup(pSDEUAGroupBase, string, -1);
    }

    public ArrayList<PSDEFormDetail> selectByPSDEUAGroup(PSDEUAGroupBase pSDEUAGroupBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDEUAGROUPID", (Object)pSDEUAGroupBase.getPSDEUAGroupId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSDEUAGroupCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSDEUAGroupCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDEFormDetail> selectByPSDEUIAction(PSDEUIActionBase pSDEUIActionBase) throws Exception {
        return this.selectByPSDEUIAction(pSDEUIActionBase, "", -1);
    }

    public ArrayList<PSDEFormDetail> selectByPSDEUIAction(PSDEUIActionBase pSDEUIActionBase, String string) throws Exception {
        return this.selectByPSDEUIAction(pSDEUIActionBase, string, -1);
    }

    public ArrayList<PSDEFormDetail> selectByPSDEUIAction(PSDEUIActionBase pSDEUIActionBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDEUIACTIONID", (Object)pSDEUIActionBase.getPSDEUIActionId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSDEUIActionCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSDEUIActionCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDEFormDetail> selectByLinkPSDEView(PSDEViewBaseBase pSDEViewBaseBase) throws Exception {
        return this.selectByLinkPSDEView(pSDEViewBaseBase, "", -1);
    }

    public ArrayList<PSDEFormDetail> selectByLinkPSDEView(PSDEViewBaseBase pSDEViewBaseBase, String string) throws Exception {
        return this.selectByLinkPSDEView(pSDEViewBaseBase, string, -1);
    }

    public ArrayList<PSDEFormDetail> selectByLinkPSDEView(PSDEViewBaseBase pSDEViewBaseBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("LINKPSDEVIEWID", (Object)pSDEViewBaseBase.getPSDEViewBaseId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByLinkPSDEViewCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByLinkPSDEViewCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDEFormDetail> selectByOpenPSDEView(PSDEViewBaseBase pSDEViewBaseBase) throws Exception {
        return this.selectByOpenPSDEView(pSDEViewBaseBase, "", -1);
    }

    public ArrayList<PSDEFormDetail> selectByOpenPSDEView(PSDEViewBaseBase pSDEViewBaseBase, String string) throws Exception {
        return this.selectByOpenPSDEView(pSDEViewBaseBase, string, -1);
    }

    public ArrayList<PSDEFormDetail> selectByOpenPSDEView(PSDEViewBaseBase pSDEViewBaseBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("OPENPSDEVIEWID", (Object)pSDEViewBaseBase.getPSDEViewBaseId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByOpenPSDEViewCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByOpenPSDEViewCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDEFormDetail> selectByPickupPSDEView(PSDEViewBaseBase pSDEViewBaseBase) throws Exception {
        return this.selectByPickupPSDEView(pSDEViewBaseBase, "", -1);
    }

    public ArrayList<PSDEFormDetail> selectByPickupPSDEView(PSDEViewBaseBase pSDEViewBaseBase, String string) throws Exception {
        return this.selectByPickupPSDEView(pSDEViewBaseBase, string, -1);
    }

    public ArrayList<PSDEFormDetail> selectByPickupPSDEView(PSDEViewBaseBase pSDEViewBaseBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PICKUPPSDEVIEWID", (Object)pSDEViewBaseBase.getPSDEViewBaseId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPickupPSDEViewCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPickupPSDEViewCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDEFormDetail> selectByCapPSLanRes(PSLanguageResBase pSLanguageResBase) throws Exception {
        return this.selectByCapPSLanRes(pSLanguageResBase, "", -1);
    }

    public ArrayList<PSDEFormDetail> selectByCapPSLanRes(PSLanguageResBase pSLanguageResBase, String string) throws Exception {
        return this.selectByCapPSLanRes(pSLanguageResBase, string, -1);
    }

    public ArrayList<PSDEFormDetail> selectByCapPSLanRes(PSLanguageResBase pSLanguageResBase, String string, int n) throws Exception {
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

    public ArrayList<PSDEFormDetail> selectByMaskPSLanRes(PSLanguageResBase pSLanguageResBase) throws Exception {
        return this.selectByMaskPSLanRes(pSLanguageResBase, "", -1);
    }

    public ArrayList<PSDEFormDetail> selectByMaskPSLanRes(PSLanguageResBase pSLanguageResBase, String string) throws Exception {
        return this.selectByMaskPSLanRes(pSLanguageResBase, string, -1);
    }

    public ArrayList<PSDEFormDetail> selectByMaskPSLanRes(PSLanguageResBase pSLanguageResBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("MASKPSLANRESID", (Object)pSLanguageResBase.getPSLanguageResId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByMaskPSLanResCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByMaskPSLanResCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDEFormDetail> selectByPHPSLanRes(PSLanguageResBase pSLanguageResBase) throws Exception {
        return this.selectByPHPSLanRes(pSLanguageResBase, "", -1);
    }

    public ArrayList<PSDEFormDetail> selectByPHPSLanRes(PSLanguageResBase pSLanguageResBase, String string) throws Exception {
        return this.selectByPHPSLanRes(pSLanguageResBase, string, -1);
    }

    public ArrayList<PSDEFormDetail> selectByPHPSLanRes(PSLanguageResBase pSLanguageResBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PHPSLANRESID", (Object)pSLanguageResBase.getPSLanguageResId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPHPSLanResCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPHPSLanResCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDEFormDetail> selectByTipPSLanRes(PSLanguageResBase pSLanguageResBase) throws Exception {
        return this.selectByTipPSLanRes(pSLanguageResBase, "", -1);
    }

    public ArrayList<PSDEFormDetail> selectByTipPSLanRes(PSLanguageResBase pSLanguageResBase, String string) throws Exception {
        return this.selectByTipPSLanRes(pSLanguageResBase, string, -1);
    }

    public ArrayList<PSDEFormDetail> selectByTipPSLanRes(PSLanguageResBase pSLanguageResBase, String string, int n) throws Exception {
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

    public ArrayList<PSDEFormDetail> selectByPSSysCounter(PSSysCounterBase pSSysCounterBase) throws Exception {
        return this.selectByPSSysCounter(pSSysCounterBase, "", -1);
    }

    public ArrayList<PSDEFormDetail> selectByPSSysCounter(PSSysCounterBase pSSysCounterBase, String string) throws Exception {
        return this.selectByPSSysCounter(pSSysCounterBase, string, -1);
    }

    public ArrayList<PSDEFormDetail> selectByPSSysCounter(PSSysCounterBase pSSysCounterBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSSYSCOUNTERID", (Object)pSSysCounterBase.getPSSysCounterId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSSysCounterCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSSysCounterCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDEFormDetail> selectByCtrlPSSysCss(PSSysCssBase pSSysCssBase) throws Exception {
        return this.selectByCtrlPSSysCss(pSSysCssBase, "", -1);
    }

    public ArrayList<PSDEFormDetail> selectByCtrlPSSysCss(PSSysCssBase pSSysCssBase, String string) throws Exception {
        return this.selectByCtrlPSSysCss(pSSysCssBase, string, -1);
    }

    public ArrayList<PSDEFormDetail> selectByCtrlPSSysCss(PSSysCssBase pSSysCssBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("CTRLPSSYSCSSID", (Object)pSSysCssBase.getPSSysCssId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByCtrlPSSysCssCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByCtrlPSSysCssCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDEFormDetail> selectByLabelPSSysCss(PSSysCssBase pSSysCssBase) throws Exception {
        return this.selectByLabelPSSysCss(pSSysCssBase, "", -1);
    }

    public ArrayList<PSDEFormDetail> selectByLabelPSSysCss(PSSysCssBase pSSysCssBase, String string) throws Exception {
        return this.selectByLabelPSSysCss(pSSysCssBase, string, -1);
    }

    public ArrayList<PSDEFormDetail> selectByLabelPSSysCss(PSSysCssBase pSSysCssBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("LABELPSSYSCSSID", (Object)pSSysCssBase.getPSSysCssId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByLabelPSSysCssCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByLabelPSSysCssCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDEFormDetail> selectByPSSysCss(PSSysCssBase pSSysCssBase) throws Exception {
        return this.selectByPSSysCss(pSSysCssBase, "", -1);
    }

    public ArrayList<PSDEFormDetail> selectByPSSysCss(PSSysCssBase pSSysCssBase, String string) throws Exception {
        return this.selectByPSSysCss(pSSysCssBase, string, -1);
    }

    public ArrayList<PSDEFormDetail> selectByPSSysCss(PSSysCssBase pSSysCssBase, String string, int n) throws Exception {
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

    public ArrayList<PSDEFormDetail> selectByPSSysDictCat(PSSysDictCatBase pSSysDictCatBase) throws Exception {
        return this.selectByPSSysDictCat(pSSysDictCatBase, "", -1);
    }

    public ArrayList<PSDEFormDetail> selectByPSSysDictCat(PSSysDictCatBase pSSysDictCatBase, String string) throws Exception {
        return this.selectByPSSysDictCat(pSSysDictCatBase, string, -1);
    }

    public ArrayList<PSDEFormDetail> selectByPSSysDictCat(PSSysDictCatBase pSSysDictCatBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSSYSDICTCATID", (Object)pSSysDictCatBase.getPSSysDictCatId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSSysDictCatCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSSysDictCatCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDEFormDetail> selectByPSSysDynaModel(PSSysDynaModelBase pSSysDynaModelBase) throws Exception {
        return this.selectByPSSysDynaModel(pSSysDynaModelBase, "", -1);
    }

    public ArrayList<PSDEFormDetail> selectByPSSysDynaModel(PSSysDynaModelBase pSSysDynaModelBase, String string) throws Exception {
        return this.selectByPSSysDynaModel(pSSysDynaModelBase, string, -1);
    }

    public ArrayList<PSDEFormDetail> selectByPSSysDynaModel(PSSysDynaModelBase pSSysDynaModelBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSSYSDYNAMODELID", (Object)pSSysDynaModelBase.getPSSysDynaModelId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSSysDynaModelCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSSysDynaModelCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDEFormDetail> selectByPSSysEditorStyle(PSSysEditorStyleBase pSSysEditorStyleBase) throws Exception {
        return this.selectByPSSysEditorStyle(pSSysEditorStyleBase, "", -1);
    }

    public ArrayList<PSDEFormDetail> selectByPSSysEditorStyle(PSSysEditorStyleBase pSSysEditorStyleBase, String string) throws Exception {
        return this.selectByPSSysEditorStyle(pSSysEditorStyleBase, string, -1);
    }

    public ArrayList<PSDEFormDetail> selectByPSSysEditorStyle(PSSysEditorStyleBase pSSysEditorStyleBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSSYSEDITORSTYLEID", (Object)pSSysEditorStyleBase.getPSSysEditorStyleId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSSysEditorStyleCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSSysEditorStyleCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDEFormDetail> selectByPSSysImage(PSSysImageBase pSSysImageBase) throws Exception {
        return this.selectByPSSysImage(pSSysImageBase, "", -1);
    }

    public ArrayList<PSDEFormDetail> selectByPSSysImage(PSSysImageBase pSSysImageBase, String string) throws Exception {
        return this.selectByPSSysImage(pSSysImageBase, string, -1);
    }

    public ArrayList<PSDEFormDetail> selectByPSSysImage(PSSysImageBase pSSysImageBase, String string, int n) throws Exception {
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

    public ArrayList<PSDEFormDetail> selectByOpenPSSysPDTView(PSSysPDTViewBase pSSysPDTViewBase) throws Exception {
        return this.selectByOpenPSSysPDTView(pSSysPDTViewBase, "", -1);
    }

    public ArrayList<PSDEFormDetail> selectByOpenPSSysPDTView(PSSysPDTViewBase pSSysPDTViewBase, String string) throws Exception {
        return this.selectByOpenPSSysPDTView(pSSysPDTViewBase, string, -1);
    }

    public ArrayList<PSDEFormDetail> selectByOpenPSSysPDTView(PSSysPDTViewBase pSSysPDTViewBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("OPENPSSYSPDTVIEWID", (Object)pSSysPDTViewBase.getPSSysPDTViewId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByOpenPSSysPDTViewCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByOpenPSSysPDTViewCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDEFormDetail> selectByUCPSSysPFPlugin(PSSysPFPluginBase pSSysPFPluginBase) throws Exception {
        return this.selectByUCPSSysPFPlugin(pSSysPFPluginBase, "", -1);
    }

    public ArrayList<PSDEFormDetail> selectByUCPSSysPFPlugin(PSSysPFPluginBase pSSysPFPluginBase, String string) throws Exception {
        return this.selectByUCPSSysPFPlugin(pSSysPFPluginBase, string, -1);
    }

    public ArrayList<PSDEFormDetail> selectByUCPSSysPFPlugin(PSSysPFPluginBase pSSysPFPluginBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("UCPSSYSPFPLUGINID", (Object)pSSysPFPluginBase.getPSSysPFPluginId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByUCPSSysPFPluginCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByUCPSSysPFPluginCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDEFormDetail> selectByPSSysResource(PSSysResourceBase pSSysResourceBase) throws Exception {
        return this.selectByPSSysResource(pSSysResourceBase, "", -1);
    }

    public ArrayList<PSDEFormDetail> selectByPSSysResource(PSSysResourceBase pSSysResourceBase, String string) throws Exception {
        return this.selectByPSSysResource(pSSysResourceBase, string, -1);
    }

    public ArrayList<PSDEFormDetail> selectByPSSysResource(PSSysResourceBase pSSysResourceBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSSYSRESOURCEID", (Object)pSSysResourceBase.getPSSysResourceId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSSysResourceCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSSysResourceCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDEFormDetail> selectByMDPSSysViewPanel(PSSysViewPanelBase pSSysViewPanelBase) throws Exception {
        return this.selectByMDPSSysViewPanel(pSSysViewPanelBase, "", -1);
    }

    public ArrayList<PSDEFormDetail> selectByMDPSSysViewPanel(PSSysViewPanelBase pSSysViewPanelBase, String string) throws Exception {
        return this.selectByMDPSSysViewPanel(pSSysViewPanelBase, string, -1);
    }

    public ArrayList<PSDEFormDetail> selectByMDPSSysViewPanel(PSSysViewPanelBase pSSysViewPanelBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("MDPSSYSVIEWPANELID", (Object)pSSysViewPanelBase.getPSSysViewPanelId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByMDPSSysViewPanelCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByMDPSSysViewPanelCond(SelectCond selectCond) throws Exception {
    }

    public void testRemoveByItemPSACHandler(PSACHandler pSACHandler) throws Exception {
        ArrayList<PSDEFormDetail> arrayList = this.selectByItemPSACHandler(pSACHandler, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSACHANDLER");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSACHandler);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEFORMDETAIL_PSACHANDLER_ITEMPSACHANDLERID", "", iDataEntityModel.getName(), "PSDEFORMDETAIL", iDataEntityModel.getDataInfo(pSACHandler), arrayList.get(0)));
        }
    }

    public void resetItemPSACHandler(PSACHandler pSACHandler) throws Exception {
        ArrayList<PSDEFormDetail> arrayList = this.selectByItemPSACHandler(pSACHandler);
        for (PSDEFormDetail pSDEFormDetail : arrayList) {
            PSDEFormDetail pSDEFormDetail2 = (PSDEFormDetail)this.getDEModel().createEntity();
            pSDEFormDetail2.setPSDEFormDetailId(pSDEFormDetail.getPSDEFormDetailId());
            pSDEFormDetail2.setItemPSACHandlerId(null);
            this.update(pSDEFormDetail2);
        }
    }

    public void removeByItemPSACHandler(PSACHandler pSACHandler) throws Exception {
        final PSACHandler pSACHandler2 = pSACHandler;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEFormDetailServiceBase.this.onBeforeRemoveByItemPSACHandler(pSACHandler2);
                PSDEFormDetailServiceBase.this.internalRemoveByItemPSACHandler(pSACHandler2);
                PSDEFormDetailServiceBase.this.onAfterRemoveByItemPSACHandler(pSACHandler2);
            }
        });
    }

    protected void onBeforeRemoveByItemPSACHandler(PSACHandler pSACHandler) throws Exception {
    }

    protected void internalRemoveByItemPSACHandler(PSACHandler pSACHandler) throws Exception {
        ArrayList<PSDEFormDetail> arrayList = this.selectByItemPSACHandler(pSACHandler);
        this.onBeforeRemoveByItemPSACHandler(pSACHandler, arrayList);
        for (PSDEFormDetail pSDEFormDetail : arrayList) {
            this.remove(pSDEFormDetail);
        }
        this.onAfterRemoveByItemPSACHandler(pSACHandler, arrayList);
    }

    protected void onAfterRemoveByItemPSACHandler(PSACHandler pSACHandler) throws Exception {
    }

    protected void onBeforeRemoveByItemPSACHandler(PSACHandler pSACHandler, ArrayList<PSDEFormDetail> arrayList) throws Exception {
    }

    protected void onAfterRemoveByItemPSACHandler(PSACHandler pSACHandler, ArrayList<PSDEFormDetail> arrayList) throws Exception {
    }

    public void testRemoveByPSCodeList(PSCodeList pSCodeList) throws Exception {
        ArrayList<PSDEFormDetail> arrayList = this.selectByPSCodeList(pSCodeList, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSCODELIST");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSCodeList);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEFORMDETAIL_PSCODELIST_PSCODELISTID", "", iDataEntityModel.getName(), "PSDEFORMDETAIL", iDataEntityModel.getDataInfo(pSCodeList), arrayList.get(0)));
        }
    }

    public void resetPSCodeList(PSCodeList pSCodeList) throws Exception {
        ArrayList<PSDEFormDetail> arrayList = this.selectByPSCodeList(pSCodeList);
        for (PSDEFormDetail pSDEFormDetail : arrayList) {
            PSDEFormDetail pSDEFormDetail2 = (PSDEFormDetail)this.getDEModel().createEntity();
            pSDEFormDetail2.setPSDEFormDetailId(pSDEFormDetail.getPSDEFormDetailId());
            pSDEFormDetail2.setPSCodeListId(null);
            this.update(pSDEFormDetail2);
        }
    }

    public void removeByPSCodeList(PSCodeList pSCodeList) throws Exception {
        final PSCodeList pSCodeList2 = pSCodeList;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEFormDetailServiceBase.this.onBeforeRemoveByPSCodeList(pSCodeList2);
                PSDEFormDetailServiceBase.this.internalRemoveByPSCodeList(pSCodeList2);
                PSDEFormDetailServiceBase.this.onAfterRemoveByPSCodeList(pSCodeList2);
            }
        });
    }

    protected void onBeforeRemoveByPSCodeList(PSCodeList pSCodeList) throws Exception {
    }

    protected void internalRemoveByPSCodeList(PSCodeList pSCodeList) throws Exception {
        ArrayList<PSDEFormDetail> arrayList = this.selectByPSCodeList(pSCodeList);
        this.onBeforeRemoveByPSCodeList(pSCodeList, arrayList);
        for (PSDEFormDetail pSDEFormDetail : arrayList) {
            this.remove(pSDEFormDetail);
        }
        this.onAfterRemoveByPSCodeList(pSCodeList, arrayList);
    }

    protected void onAfterRemoveByPSCodeList(PSCodeList pSCodeList) throws Exception {
    }

    protected void onBeforeRemoveByPSCodeList(PSCodeList pSCodeList, ArrayList<PSDEFormDetail> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSCodeList(PSCodeList pSCodeList, ArrayList<PSDEFormDetail> arrayList) throws Exception {
    }

    public void testRemoveByRefPSDE(PSDataEntity pSDataEntity) throws Exception {
        ArrayList<PSDEFormDetail> arrayList = this.selectByRefPSDE(pSDataEntity, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDATAENTITY");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDataEntity);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEFORMDETAIL_PSDATAENTITY_REFPSDEID", "", iDataEntityModel.getName(), "PSDEFORMDETAIL", iDataEntityModel.getDataInfo(pSDataEntity), arrayList.get(0)));
        }
    }

    public void resetRefPSDE(PSDataEntity pSDataEntity) throws Exception {
        ArrayList<PSDEFormDetail> arrayList = this.selectByRefPSDE(pSDataEntity);
        for (PSDEFormDetail pSDEFormDetail : arrayList) {
            PSDEFormDetail pSDEFormDetail2 = (PSDEFormDetail)this.getDEModel().createEntity();
            pSDEFormDetail2.setPSDEFormDetailId(pSDEFormDetail.getPSDEFormDetailId());
            pSDEFormDetail2.setRefPSDEId(null);
            this.update(pSDEFormDetail2);
        }
    }

    public void removeByRefPSDE(PSDataEntity pSDataEntity) throws Exception {
        final PSDataEntity pSDataEntity2 = pSDataEntity;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEFormDetailServiceBase.this.onBeforeRemoveByRefPSDE(pSDataEntity2);
                PSDEFormDetailServiceBase.this.internalRemoveByRefPSDE(pSDataEntity2);
                PSDEFormDetailServiceBase.this.onAfterRemoveByRefPSDE(pSDataEntity2);
            }
        });
    }

    protected void onBeforeRemoveByRefPSDE(PSDataEntity pSDataEntity) throws Exception {
    }

    protected void internalRemoveByRefPSDE(PSDataEntity pSDataEntity) throws Exception {
        ArrayList<PSDEFormDetail> arrayList = this.selectByRefPSDE(pSDataEntity);
        this.onBeforeRemoveByRefPSDE(pSDataEntity, arrayList);
        for (PSDEFormDetail pSDEFormDetail : arrayList) {
            this.remove(pSDEFormDetail);
        }
        this.onAfterRemoveByRefPSDE(pSDataEntity, arrayList);
    }

    protected void onAfterRemoveByRefPSDE(PSDataEntity pSDataEntity) throws Exception {
    }

    protected void onBeforeRemoveByRefPSDE(PSDataEntity pSDataEntity, ArrayList<PSDEFormDetail> arrayList) throws Exception {
    }

    protected void onAfterRemoveByRefPSDE(PSDataEntity pSDataEntity, ArrayList<PSDEFormDetail> arrayList) throws Exception {
    }

    public void testRemoveByRefPSDEACMode(PSDEACMode pSDEACMode) throws Exception {
    }

    public void resetRefPSDEACMode(PSDEACMode pSDEACMode) throws Exception {
        ArrayList<PSDEFormDetail> arrayList = this.selectByRefPSDEACMode(pSDEACMode);
        for (PSDEFormDetail pSDEFormDetail : arrayList) {
            PSDEFormDetail pSDEFormDetail2 = (PSDEFormDetail)this.getDEModel().createEntity();
            pSDEFormDetail2.setPSDEFormDetailId(pSDEFormDetail.getPSDEFormDetailId());
            pSDEFormDetail2.setRefPSDEACModeId(null);
            this.update(pSDEFormDetail2);
        }
    }

    public void removeByRefPSDEACMode(PSDEACMode pSDEACMode) throws Exception {
        final PSDEACMode pSDEACMode2 = pSDEACMode;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEFormDetailServiceBase.this.onBeforeRemoveByRefPSDEACMode(pSDEACMode2);
                PSDEFormDetailServiceBase.this.internalRemoveByRefPSDEACMode(pSDEACMode2);
                PSDEFormDetailServiceBase.this.onAfterRemoveByRefPSDEACMode(pSDEACMode2);
            }
        });
    }

    protected void onBeforeRemoveByRefPSDEACMode(PSDEACMode pSDEACMode) throws Exception {
    }

    protected void internalRemoveByRefPSDEACMode(PSDEACMode pSDEACMode) throws Exception {
        ArrayList<PSDEFormDetail> arrayList = this.selectByRefPSDEACMode(pSDEACMode);
        this.onBeforeRemoveByRefPSDEACMode(pSDEACMode, arrayList);
        for (PSDEFormDetail pSDEFormDetail : arrayList) {
            this.remove(pSDEFormDetail);
        }
        this.onAfterRemoveByRefPSDEACMode(pSDEACMode, arrayList);
    }

    protected void onAfterRemoveByRefPSDEACMode(PSDEACMode pSDEACMode) throws Exception {
    }

    protected void onBeforeRemoveByRefPSDEACMode(PSDEACMode pSDEACMode, ArrayList<PSDEFormDetail> arrayList) throws Exception {
    }

    protected void onAfterRemoveByRefPSDEACMode(PSDEACMode pSDEACMode, ArrayList<PSDEFormDetail> arrayList) throws Exception {
    }

    public void testRemoveByPSDEDR(PSDEDataRelation pSDEDataRelation) throws Exception {
        ArrayList<PSDEFormDetail> arrayList = this.selectByPSDEDR(pSDEDataRelation, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEDATARELATION");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDEDataRelation);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEFORMDETAIL_PSDEDATARELATION_PSDEDRID", "", iDataEntityModel.getName(), "PSDEFORMDETAIL", iDataEntityModel.getDataInfo(pSDEDataRelation), arrayList.get(0)));
        }
    }

    public void resetPSDEDR(PSDEDataRelation pSDEDataRelation) throws Exception {
        ArrayList<PSDEFormDetail> arrayList = this.selectByPSDEDR(pSDEDataRelation);
        for (PSDEFormDetail pSDEFormDetail : arrayList) {
            PSDEFormDetail pSDEFormDetail2 = (PSDEFormDetail)this.getDEModel().createEntity();
            pSDEFormDetail2.setPSDEFormDetailId(pSDEFormDetail.getPSDEFormDetailId());
            pSDEFormDetail2.setPSDEDRId(null);
            this.update(pSDEFormDetail2);
        }
    }

    public void removeByPSDEDR(PSDEDataRelation pSDEDataRelation) throws Exception {
        final PSDEDataRelation pSDEDataRelation2 = pSDEDataRelation;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEFormDetailServiceBase.this.onBeforeRemoveByPSDEDR(pSDEDataRelation2);
                PSDEFormDetailServiceBase.this.internalRemoveByPSDEDR(pSDEDataRelation2);
                PSDEFormDetailServiceBase.this.onAfterRemoveByPSDEDR(pSDEDataRelation2);
            }
        });
    }

    protected void onBeforeRemoveByPSDEDR(PSDEDataRelation pSDEDataRelation) throws Exception {
    }

    protected void internalRemoveByPSDEDR(PSDEDataRelation pSDEDataRelation) throws Exception {
        ArrayList<PSDEFormDetail> arrayList = this.selectByPSDEDR(pSDEDataRelation);
        this.onBeforeRemoveByPSDEDR(pSDEDataRelation, arrayList);
        for (PSDEFormDetail pSDEFormDetail : arrayList) {
            this.remove(pSDEFormDetail);
        }
        this.onAfterRemoveByPSDEDR(pSDEDataRelation, arrayList);
    }

    protected void onAfterRemoveByPSDEDR(PSDEDataRelation pSDEDataRelation) throws Exception {
    }

    protected void onBeforeRemoveByPSDEDR(PSDEDataRelation pSDEDataRelation, ArrayList<PSDEFormDetail> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDEDR(PSDEDataRelation pSDEDataRelation, ArrayList<PSDEFormDetail> arrayList) throws Exception {
    }

    public void testRemoveByRefPSDEDataSet(PSDEDataSet pSDEDataSet) throws Exception {
        ArrayList<PSDEFormDetail> arrayList = this.selectByRefPSDEDataSet(pSDEDataSet, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEDATASET");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDEDataSet);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEFORMDETAIL_PSDEDATASET_REFPSDEDATASETID", "", iDataEntityModel.getName(), "PSDEFORMDETAIL", iDataEntityModel.getDataInfo(pSDEDataSet), arrayList.get(0)));
        }
    }

    public void resetRefPSDEDataSet(PSDEDataSet pSDEDataSet) throws Exception {
        ArrayList<PSDEFormDetail> arrayList = this.selectByRefPSDEDataSet(pSDEDataSet);
        for (PSDEFormDetail pSDEFormDetail : arrayList) {
            PSDEFormDetail pSDEFormDetail2 = (PSDEFormDetail)this.getDEModel().createEntity();
            pSDEFormDetail2.setPSDEFormDetailId(pSDEFormDetail.getPSDEFormDetailId());
            pSDEFormDetail2.setRefPSDEDataSetId(null);
            this.update(pSDEFormDetail2);
        }
    }

    public void removeByRefPSDEDataSet(PSDEDataSet pSDEDataSet) throws Exception {
        final PSDEDataSet pSDEDataSet2 = pSDEDataSet;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEFormDetailServiceBase.this.onBeforeRemoveByRefPSDEDataSet(pSDEDataSet2);
                PSDEFormDetailServiceBase.this.internalRemoveByRefPSDEDataSet(pSDEDataSet2);
                PSDEFormDetailServiceBase.this.onAfterRemoveByRefPSDEDataSet(pSDEDataSet2);
            }
        });
    }

    protected void onBeforeRemoveByRefPSDEDataSet(PSDEDataSet pSDEDataSet) throws Exception {
    }

    protected void internalRemoveByRefPSDEDataSet(PSDEDataSet pSDEDataSet) throws Exception {
        ArrayList<PSDEFormDetail> arrayList = this.selectByRefPSDEDataSet(pSDEDataSet);
        this.onBeforeRemoveByRefPSDEDataSet(pSDEDataSet, arrayList);
        for (PSDEFormDetail pSDEFormDetail : arrayList) {
            this.remove(pSDEFormDetail);
        }
        this.onAfterRemoveByRefPSDEDataSet(pSDEDataSet, arrayList);
    }

    protected void onAfterRemoveByRefPSDEDataSet(PSDEDataSet pSDEDataSet) throws Exception {
    }

    protected void onBeforeRemoveByRefPSDEDataSet(PSDEDataSet pSDEDataSet, ArrayList<PSDEFormDetail> arrayList) throws Exception {
    }

    protected void onAfterRemoveByRefPSDEDataSet(PSDEDataSet pSDEDataSet, ArrayList<PSDEFormDetail> arrayList) throws Exception {
    }

    public void testRemoveByMDPSDEDataView(PSDEDataView pSDEDataView) throws Exception {
        ArrayList<PSDEFormDetail> arrayList = this.selectByMDPSDEDataView(pSDEDataView, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEDATAVIEW");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDEDataView);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEFORMDETAIL_PSDEDATAVIEW_MDPSDEDATAVIEWID", "", iDataEntityModel.getName(), "PSDEFORMDETAIL", iDataEntityModel.getDataInfo(pSDEDataView), arrayList.get(0)));
        }
    }

    public void resetMDPSDEDataView(PSDEDataView pSDEDataView) throws Exception {
        ArrayList<PSDEFormDetail> arrayList = this.selectByMDPSDEDataView(pSDEDataView);
        for (PSDEFormDetail pSDEFormDetail : arrayList) {
            PSDEFormDetail pSDEFormDetail2 = (PSDEFormDetail)this.getDEModel().createEntity();
            pSDEFormDetail2.setPSDEFormDetailId(pSDEFormDetail.getPSDEFormDetailId());
            pSDEFormDetail2.setMDPSDEDataViewId(null);
            this.update(pSDEFormDetail2);
        }
    }

    public void removeByMDPSDEDataView(PSDEDataView pSDEDataView) throws Exception {
        final PSDEDataView pSDEDataView2 = pSDEDataView;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEFormDetailServiceBase.this.onBeforeRemoveByMDPSDEDataView(pSDEDataView2);
                PSDEFormDetailServiceBase.this.internalRemoveByMDPSDEDataView(pSDEDataView2);
                PSDEFormDetailServiceBase.this.onAfterRemoveByMDPSDEDataView(pSDEDataView2);
            }
        });
    }

    protected void onBeforeRemoveByMDPSDEDataView(PSDEDataView pSDEDataView) throws Exception {
    }

    protected void internalRemoveByMDPSDEDataView(PSDEDataView pSDEDataView) throws Exception {
        ArrayList<PSDEFormDetail> arrayList = this.selectByMDPSDEDataView(pSDEDataView);
        this.onBeforeRemoveByMDPSDEDataView(pSDEDataView, arrayList);
        for (PSDEFormDetail pSDEFormDetail : arrayList) {
            this.remove(pSDEFormDetail);
        }
        this.onAfterRemoveByMDPSDEDataView(pSDEDataView, arrayList);
    }

    protected void onAfterRemoveByMDPSDEDataView(PSDEDataView pSDEDataView) throws Exception {
    }

    protected void onBeforeRemoveByMDPSDEDataView(PSDEDataView pSDEDataView, ArrayList<PSDEFormDetail> arrayList) throws Exception {
    }

    protected void onAfterRemoveByMDPSDEDataView(PSDEDataView pSDEDataView, ArrayList<PSDEFormDetail> arrayList) throws Exception {
    }

    public void testRemoveByPSDEDRItem(PSDEDRItem pSDEDRItem) throws Exception {
        ArrayList<PSDEFormDetail> arrayList = this.selectByPSDEDRItem(pSDEDRItem, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEDRITEM");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDEDRItem);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEFORMDETAIL_PSDEDRITEM_PSDEDRITEMID", "", iDataEntityModel.getName(), "PSDEFORMDETAIL", iDataEntityModel.getDataInfo(pSDEDRItem), arrayList.get(0)));
        }
    }

    public void resetPSDEDRItem(PSDEDRItem pSDEDRItem) throws Exception {
        ArrayList<PSDEFormDetail> arrayList = this.selectByPSDEDRItem(pSDEDRItem);
        for (PSDEFormDetail pSDEFormDetail : arrayList) {
            PSDEFormDetail pSDEFormDetail2 = (PSDEFormDetail)this.getDEModel().createEntity();
            pSDEFormDetail2.setPSDEFormDetailId(pSDEFormDetail.getPSDEFormDetailId());
            pSDEFormDetail2.setPSDEDRItemId(null);
            this.update(pSDEFormDetail2);
        }
    }

    public void removeByPSDEDRItem(PSDEDRItem pSDEDRItem) throws Exception {
        final PSDEDRItem pSDEDRItem2 = pSDEDRItem;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEFormDetailServiceBase.this.onBeforeRemoveByPSDEDRItem(pSDEDRItem2);
                PSDEFormDetailServiceBase.this.internalRemoveByPSDEDRItem(pSDEDRItem2);
                PSDEFormDetailServiceBase.this.onAfterRemoveByPSDEDRItem(pSDEDRItem2);
            }
        });
    }

    protected void onBeforeRemoveByPSDEDRItem(PSDEDRItem pSDEDRItem) throws Exception {
    }

    protected void internalRemoveByPSDEDRItem(PSDEDRItem pSDEDRItem) throws Exception {
        ArrayList<PSDEFormDetail> arrayList = this.selectByPSDEDRItem(pSDEDRItem);
        this.onBeforeRemoveByPSDEDRItem(pSDEDRItem, arrayList);
        for (PSDEFormDetail pSDEFormDetail : arrayList) {
            this.remove(pSDEFormDetail);
        }
        this.onAfterRemoveByPSDEDRItem(pSDEDRItem, arrayList);
    }

    protected void onAfterRemoveByPSDEDRItem(PSDEDRItem pSDEDRItem) throws Exception {
    }

    protected void onBeforeRemoveByPSDEDRItem(PSDEDRItem pSDEDRItem, ArrayList<PSDEFormDetail> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDEDRItem(PSDEDRItem pSDEDRItem, ArrayList<PSDEFormDetail> arrayList) throws Exception {
    }

    public void testRemoveByPSDEFUIMode(PSDEFUIMode pSDEFUIMode) throws Exception {
        ArrayList<PSDEFormDetail> arrayList = this.selectByPSDEFUIMode(pSDEFUIMode, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEFUIMODE");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDEFUIMode);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEFORMDETAIL_PSDEFFORMITEM_PSDEFFORMITEMID", "", iDataEntityModel.getName(), "PSDEFORMDETAIL", iDataEntityModel.getDataInfo(pSDEFUIMode), arrayList.get(0)));
        }
    }

    public void resetPSDEFUIMode(PSDEFUIMode pSDEFUIMode) throws Exception {
        ArrayList<PSDEFormDetail> arrayList = this.selectByPSDEFUIMode(pSDEFUIMode);
        for (PSDEFormDetail pSDEFormDetail : arrayList) {
            PSDEFormDetail pSDEFormDetail2 = (PSDEFormDetail)this.getDEModel().createEntity();
            pSDEFormDetail2.setPSDEFormDetailId(pSDEFormDetail.getPSDEFormDetailId());
            pSDEFormDetail2.setPSDEFUIModeId(null);
            this.update(pSDEFormDetail2);
        }
    }

    public void removeByPSDEFUIMode(PSDEFUIMode pSDEFUIMode) throws Exception {
        final PSDEFUIMode pSDEFUIMode2 = pSDEFUIMode;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEFormDetailServiceBase.this.onBeforeRemoveByPSDEFUIMode(pSDEFUIMode2);
                PSDEFormDetailServiceBase.this.internalRemoveByPSDEFUIMode(pSDEFUIMode2);
                PSDEFormDetailServiceBase.this.onAfterRemoveByPSDEFUIMode(pSDEFUIMode2);
            }
        });
    }

    protected void onBeforeRemoveByPSDEFUIMode(PSDEFUIMode pSDEFUIMode) throws Exception {
    }

    protected void internalRemoveByPSDEFUIMode(PSDEFUIMode pSDEFUIMode) throws Exception {
        ArrayList<PSDEFormDetail> arrayList = this.selectByPSDEFUIMode(pSDEFUIMode);
        this.onBeforeRemoveByPSDEFUIMode(pSDEFUIMode, arrayList);
        for (PSDEFormDetail pSDEFormDetail : arrayList) {
            this.remove(pSDEFormDetail);
        }
        this.onAfterRemoveByPSDEFUIMode(pSDEFUIMode, arrayList);
    }

    protected void onAfterRemoveByPSDEFUIMode(PSDEFUIMode pSDEFUIMode) throws Exception {
    }

    protected void onBeforeRemoveByPSDEFUIMode(PSDEFUIMode pSDEFUIMode, ArrayList<PSDEFormDetail> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDEFUIMode(PSDEFUIMode pSDEFUIMode, ArrayList<PSDEFormDetail> arrayList) throws Exception {
    }

    public void testRemoveByPSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSDEFormDetail> arrayList = this.selectByPSDEF(pSDEField, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEFIELD");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDEField);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEFORMDETAIL_PSDEFIELD_PSDEFID", "", iDataEntityModel.getName(), "PSDEFORMDETAIL", iDataEntityModel.getDataInfo(pSDEField), arrayList.get(0)));
        }
    }

    public void resetPSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSDEFormDetail> arrayList = this.selectByPSDEF(pSDEField);
        for (PSDEFormDetail pSDEFormDetail : arrayList) {
            PSDEFormDetail pSDEFormDetail2 = (PSDEFormDetail)this.getDEModel().createEntity();
            pSDEFormDetail2.setPSDEFormDetailId(pSDEFormDetail.getPSDEFormDetailId());
            pSDEFormDetail2.setPSDEFId(null);
            this.update(pSDEFormDetail2);
        }
    }

    public void removeByPSDEF(PSDEField pSDEField) throws Exception {
        final PSDEField pSDEField2 = pSDEField;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEFormDetailServiceBase.this.onBeforeRemoveByPSDEF(pSDEField2);
                PSDEFormDetailServiceBase.this.internalRemoveByPSDEF(pSDEField2);
                PSDEFormDetailServiceBase.this.onAfterRemoveByPSDEF(pSDEField2);
            }
        });
    }

    protected void onBeforeRemoveByPSDEF(PSDEField pSDEField) throws Exception {
    }

    protected void internalRemoveByPSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSDEFormDetail> arrayList = this.selectByPSDEF(pSDEField);
        this.onBeforeRemoveByPSDEF(pSDEField, arrayList);
        for (PSDEFormDetail pSDEFormDetail : arrayList) {
            this.remove(pSDEFormDetail);
        }
        this.onAfterRemoveByPSDEF(pSDEField, arrayList);
    }

    protected void onAfterRemoveByPSDEF(PSDEField pSDEField) throws Exception {
    }

    protected void onBeforeRemoveByPSDEF(PSDEField pSDEField, ArrayList<PSDEFormDetail> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDEF(PSDEField pSDEField, ArrayList<PSDEFormDetail> arrayList) throws Exception {
    }

    public void testRemoveByPSDEFIUpdate(PSDEFIUpdate pSDEFIUpdate) throws Exception {
    }

    public void resetPSDEFIUpdate(PSDEFIUpdate pSDEFIUpdate) throws Exception {
        ArrayList<PSDEFormDetail> arrayList = this.selectByPSDEFIUpdate(pSDEFIUpdate);
        for (PSDEFormDetail pSDEFormDetail : arrayList) {
            PSDEFormDetail pSDEFormDetail2 = (PSDEFormDetail)this.getDEModel().createEntity();
            pSDEFormDetail2.setPSDEFormDetailId(pSDEFormDetail.getPSDEFormDetailId());
            pSDEFormDetail2.setPSDEFIUpdateId(null);
            this.update(pSDEFormDetail2);
        }
    }

    public void resetTempPSDEFIUpdate(PSDEFIUpdate pSDEFIUpdate) throws Exception {
        ArrayList<PSDEFormDetail> arrayList = this.selectTempByPSDEFIUpdate(pSDEFIUpdate);
        for (PSDEFormDetail pSDEFormDetail : arrayList) {
            PSDEFormDetail pSDEFormDetail2 = (PSDEFormDetail)this.getDEModel().createEntity();
            pSDEFormDetail2.setPSDEFormDetailId(pSDEFormDetail.getPSDEFormDetailId());
            pSDEFormDetail2.setPSDEFIUpdateId(null);
            this.updateTemp(pSDEFormDetail2);
        }
    }

    public void removeByPSDEFIUpdate(PSDEFIUpdate pSDEFIUpdate) throws Exception {
        final PSDEFIUpdate pSDEFIUpdate2 = pSDEFIUpdate;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEFormDetailServiceBase.this.onBeforeRemoveByPSDEFIUpdate(pSDEFIUpdate2);
                PSDEFormDetailServiceBase.this.internalRemoveByPSDEFIUpdate(pSDEFIUpdate2);
                PSDEFormDetailServiceBase.this.onAfterRemoveByPSDEFIUpdate(pSDEFIUpdate2);
            }
        });
    }

    protected void onBeforeRemoveByPSDEFIUpdate(PSDEFIUpdate pSDEFIUpdate) throws Exception {
    }

    protected void internalRemoveByPSDEFIUpdate(PSDEFIUpdate pSDEFIUpdate) throws Exception {
        ArrayList<PSDEFormDetail> arrayList = this.selectByPSDEFIUpdate(pSDEFIUpdate);
        this.onBeforeRemoveByPSDEFIUpdate(pSDEFIUpdate, arrayList);
        for (PSDEFormDetail pSDEFormDetail : arrayList) {
            this.remove(pSDEFormDetail);
        }
        this.onAfterRemoveByPSDEFIUpdate(pSDEFIUpdate, arrayList);
    }

    protected void onAfterRemoveByPSDEFIUpdate(PSDEFIUpdate pSDEFIUpdate) throws Exception {
    }

    protected void onBeforeRemoveByPSDEFIUpdate(PSDEFIUpdate pSDEFIUpdate, ArrayList<PSDEFormDetail> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDEFIUpdate(PSDEFIUpdate pSDEFIUpdate, ArrayList<PSDEFormDetail> arrayList) throws Exception {
    }

    public void testRemoveByPPSDEFormDetail(PSDEFormDetail pSDEFormDetail) throws Exception {
    }

    public void resetPPSDEFormDetail(PSDEFormDetail pSDEFormDetail) throws Exception {
        ArrayList<PSDEFormDetail> arrayList = this.selectByPPSDEFormDetail(pSDEFormDetail);
        for (PSDEFormDetail pSDEFormDetail2 : arrayList) {
            PSDEFormDetail pSDEFormDetail3 = (PSDEFormDetail)this.getDEModel().createEntity();
            pSDEFormDetail3.setPSDEFormDetailId(pSDEFormDetail2.getPSDEFormDetailId());
            pSDEFormDetail3.setPPSDEFormDetailId(null);
            this.update(pSDEFormDetail3);
        }
    }

    public void resetTempPPSDEFormDetail(PSDEFormDetail pSDEFormDetail) throws Exception {
        ArrayList<PSDEFormDetail> arrayList = this.selectTempByPPSDEFormDetail(pSDEFormDetail);
        for (PSDEFormDetail pSDEFormDetail2 : arrayList) {
            PSDEFormDetail pSDEFormDetail3 = (PSDEFormDetail)this.getDEModel().createEntity();
            pSDEFormDetail3.setPSDEFormDetailId(pSDEFormDetail2.getPSDEFormDetailId());
            pSDEFormDetail3.setPPSDEFormDetailId(null);
            this.updateTemp(pSDEFormDetail3);
        }
    }

    public void removeByPPSDEFormDetail(PSDEFormDetail pSDEFormDetail) throws Exception {
        final PSDEFormDetail pSDEFormDetail2 = pSDEFormDetail;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEFormDetailServiceBase.this.onBeforeRemoveByPPSDEFormDetail(pSDEFormDetail2);
                PSDEFormDetailServiceBase.this.internalRemoveByPPSDEFormDetail(pSDEFormDetail2);
                PSDEFormDetailServiceBase.this.onAfterRemoveByPPSDEFormDetail(pSDEFormDetail2);
            }
        });
    }

    protected void onBeforeRemoveByPPSDEFormDetail(PSDEFormDetail pSDEFormDetail) throws Exception {
    }

    protected void internalRemoveByPPSDEFormDetail(PSDEFormDetail pSDEFormDetail) throws Exception {
        ArrayList<PSDEFormDetail> arrayList = this.selectByPPSDEFormDetail(pSDEFormDetail);
        this.onBeforeRemoveByPPSDEFormDetail(pSDEFormDetail, arrayList);
        for (PSDEFormDetail pSDEFormDetail2 : arrayList) {
            this.remove(pSDEFormDetail2);
        }
        this.onAfterRemoveByPPSDEFormDetail(pSDEFormDetail, arrayList);
    }

    protected void onAfterRemoveByPPSDEFormDetail(PSDEFormDetail pSDEFormDetail) throws Exception {
    }

    protected void onBeforeRemoveByPPSDEFormDetail(PSDEFormDetail pSDEFormDetail, ArrayList<PSDEFormDetail> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPPSDEFormDetail(PSDEFormDetail pSDEFormDetail, ArrayList<PSDEFormDetail> arrayList) throws Exception {
    }

    public void testRemoveByRefPSDEFormDetail(PSDEFormDetail pSDEFormDetail) throws Exception {
        ArrayList<PSDEFormDetail> arrayList = this.selectByRefPSDEFormDetail(pSDEFormDetail, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEFORMDETAIL");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDEFormDetail);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEFORMDETAIL_PSDEFORMDETAIL_REFPSDEFORMDETAILID", "", iDataEntityModel.getName(), "PSDEFORMDETAIL", iDataEntityModel.getDataInfo(pSDEFormDetail), arrayList.get(0)));
        }
    }

    public void resetRefPSDEFormDetail(PSDEFormDetail pSDEFormDetail) throws Exception {
        ArrayList<PSDEFormDetail> arrayList = this.selectByRefPSDEFormDetail(pSDEFormDetail);
        for (PSDEFormDetail pSDEFormDetail2 : arrayList) {
            PSDEFormDetail pSDEFormDetail3 = (PSDEFormDetail)this.getDEModel().createEntity();
            pSDEFormDetail3.setPSDEFormDetailId(pSDEFormDetail2.getPSDEFormDetailId());
            pSDEFormDetail3.setRefPSDEFormDetailId(null);
            this.update(pSDEFormDetail3);
        }
    }

    public void resetTempRefPSDEFormDetail(PSDEFormDetail pSDEFormDetail) throws Exception {
        ArrayList<PSDEFormDetail> arrayList = this.selectTempByRefPSDEFormDetail(pSDEFormDetail);
        for (PSDEFormDetail pSDEFormDetail2 : arrayList) {
            PSDEFormDetail pSDEFormDetail3 = (PSDEFormDetail)this.getDEModel().createEntity();
            pSDEFormDetail3.setPSDEFormDetailId(pSDEFormDetail2.getPSDEFormDetailId());
            pSDEFormDetail3.setRefPSDEFormDetailId(null);
            this.updateTemp(pSDEFormDetail3);
        }
    }

    public void removeByRefPSDEFormDetail(PSDEFormDetail pSDEFormDetail) throws Exception {
        final PSDEFormDetail pSDEFormDetail2 = pSDEFormDetail;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEFormDetailServiceBase.this.onBeforeRemoveByRefPSDEFormDetail(pSDEFormDetail2);
                PSDEFormDetailServiceBase.this.internalRemoveByRefPSDEFormDetail(pSDEFormDetail2);
                PSDEFormDetailServiceBase.this.onAfterRemoveByRefPSDEFormDetail(pSDEFormDetail2);
            }
        });
    }

    protected void onBeforeRemoveByRefPSDEFormDetail(PSDEFormDetail pSDEFormDetail) throws Exception {
    }

    protected void internalRemoveByRefPSDEFormDetail(PSDEFormDetail pSDEFormDetail) throws Exception {
        ArrayList<PSDEFormDetail> arrayList = this.selectByRefPSDEFormDetail(pSDEFormDetail);
        this.onBeforeRemoveByRefPSDEFormDetail(pSDEFormDetail, arrayList);
        for (PSDEFormDetail pSDEFormDetail2 : arrayList) {
            this.remove(pSDEFormDetail2);
        }
        this.onAfterRemoveByRefPSDEFormDetail(pSDEFormDetail, arrayList);
    }

    protected void onAfterRemoveByRefPSDEFormDetail(PSDEFormDetail pSDEFormDetail) throws Exception {
    }

    protected void onBeforeRemoveByRefPSDEFormDetail(PSDEFormDetail pSDEFormDetail, ArrayList<PSDEFormDetail> arrayList) throws Exception {
    }

    protected void onAfterRemoveByRefPSDEFormDetail(PSDEFormDetail pSDEFormDetail, ArrayList<PSDEFormDetail> arrayList) throws Exception {
    }

    public void testRemoveByPSDEFormRF(PSDEFormRF pSDEFormRF) throws Exception {
    }

    public void resetPSDEFormRF(PSDEFormRF pSDEFormRF) throws Exception {
        ArrayList<PSDEFormDetail> arrayList = this.selectByPSDEFormRF(pSDEFormRF);
        for (PSDEFormDetail pSDEFormDetail : arrayList) {
            PSDEFormDetail pSDEFormDetail2 = (PSDEFormDetail)this.getDEModel().createEntity();
            pSDEFormDetail2.setPSDEFormDetailId(pSDEFormDetail.getPSDEFormDetailId());
            pSDEFormDetail2.setPSDEFormRFId(null);
            this.update(pSDEFormDetail2);
        }
    }

    public void resetTempPSDEFormRF(PSDEFormRF pSDEFormRF) throws Exception {
        ArrayList<PSDEFormDetail> arrayList = this.selectTempByPSDEFormRF(pSDEFormRF);
        for (PSDEFormDetail pSDEFormDetail : arrayList) {
            PSDEFormDetail pSDEFormDetail2 = (PSDEFormDetail)this.getDEModel().createEntity();
            pSDEFormDetail2.setPSDEFormDetailId(pSDEFormDetail.getPSDEFormDetailId());
            pSDEFormDetail2.setPSDEFormRFId(null);
            this.updateTemp(pSDEFormDetail2);
        }
    }

    public void removeByPSDEFormRF(PSDEFormRF pSDEFormRF) throws Exception {
        final PSDEFormRF pSDEFormRF2 = pSDEFormRF;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEFormDetailServiceBase.this.onBeforeRemoveByPSDEFormRF(pSDEFormRF2);
                PSDEFormDetailServiceBase.this.internalRemoveByPSDEFormRF(pSDEFormRF2);
                PSDEFormDetailServiceBase.this.onAfterRemoveByPSDEFormRF(pSDEFormRF2);
            }
        });
    }

    protected void onBeforeRemoveByPSDEFormRF(PSDEFormRF pSDEFormRF) throws Exception {
    }

    protected void internalRemoveByPSDEFormRF(PSDEFormRF pSDEFormRF) throws Exception {
        ArrayList<PSDEFormDetail> arrayList = this.selectByPSDEFormRF(pSDEFormRF);
        this.onBeforeRemoveByPSDEFormRF(pSDEFormRF, arrayList);
        for (PSDEFormDetail pSDEFormDetail : arrayList) {
            this.remove(pSDEFormDetail);
        }
        this.onAfterRemoveByPSDEFormRF(pSDEFormRF, arrayList);
    }

    protected void onAfterRemoveByPSDEFormRF(PSDEFormRF pSDEFormRF) throws Exception {
    }

    protected void onBeforeRemoveByPSDEFormRF(PSDEFormRF pSDEFormRF, ArrayList<PSDEFormDetail> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDEFormRF(PSDEFormRF pSDEFormRF, ArrayList<PSDEFormDetail> arrayList) throws Exception {
    }

    public void testRemoveByMDPSDEForm(PSDEForm pSDEForm) throws Exception {
        ArrayList<PSDEFormDetail> arrayList = this.selectByMDPSDEForm(pSDEForm, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEFORM");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDEForm);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEFORMDETAIL_PSDEFORM_MDPSDEFORMID", "", iDataEntityModel.getName(), "PSDEFORMDETAIL", iDataEntityModel.getDataInfo(pSDEForm), arrayList.get(0)));
        }
    }

    public void resetMDPSDEForm(PSDEForm pSDEForm) throws Exception {
        ArrayList<PSDEFormDetail> arrayList = this.selectByMDPSDEForm(pSDEForm);
        for (PSDEFormDetail pSDEFormDetail : arrayList) {
            PSDEFormDetail pSDEFormDetail2 = (PSDEFormDetail)this.getDEModel().createEntity();
            pSDEFormDetail2.setPSDEFormDetailId(pSDEFormDetail.getPSDEFormDetailId());
            pSDEFormDetail2.setMDPSDEFormId(null);
            this.update(pSDEFormDetail2);
        }
    }

    public void removeByMDPSDEForm(PSDEForm pSDEForm) throws Exception {
        final PSDEForm pSDEForm2 = pSDEForm;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEFormDetailServiceBase.this.onBeforeRemoveByMDPSDEForm(pSDEForm2);
                PSDEFormDetailServiceBase.this.internalRemoveByMDPSDEForm(pSDEForm2);
                PSDEFormDetailServiceBase.this.onAfterRemoveByMDPSDEForm(pSDEForm2);
            }
        });
    }

    protected void onBeforeRemoveByMDPSDEForm(PSDEForm pSDEForm) throws Exception {
    }

    protected void internalRemoveByMDPSDEForm(PSDEForm pSDEForm) throws Exception {
        ArrayList<PSDEFormDetail> arrayList = this.selectByMDPSDEForm(pSDEForm);
        this.onBeforeRemoveByMDPSDEForm(pSDEForm, arrayList);
        for (PSDEFormDetail pSDEFormDetail : arrayList) {
            this.remove(pSDEFormDetail);
        }
        this.onAfterRemoveByMDPSDEForm(pSDEForm, arrayList);
    }

    protected void onAfterRemoveByMDPSDEForm(PSDEForm pSDEForm) throws Exception {
    }

    protected void onBeforeRemoveByMDPSDEForm(PSDEForm pSDEForm, ArrayList<PSDEFormDetail> arrayList) throws Exception {
    }

    protected void onAfterRemoveByMDPSDEForm(PSDEForm pSDEForm, ArrayList<PSDEFormDetail> arrayList) throws Exception {
    }

    public void testRemoveByPSDEForm(PSDEForm pSDEForm) throws Exception {
    }

    public void resetPSDEForm(PSDEForm pSDEForm) throws Exception {
        ArrayList<PSDEFormDetail> arrayList = this.selectByPSDEForm(pSDEForm);
        for (PSDEFormDetail pSDEFormDetail : arrayList) {
            PSDEFormDetail pSDEFormDetail2 = (PSDEFormDetail)this.getDEModel().createEntity();
            pSDEFormDetail2.setPSDEFormDetailId(pSDEFormDetail.getPSDEFormDetailId());
            pSDEFormDetail2.setPSDEFormId(null);
            this.update(pSDEFormDetail2);
        }
    }

    public void resetTempPSDEForm(PSDEForm pSDEForm) throws Exception {
        ArrayList<PSDEFormDetail> arrayList = this.selectTempByPSDEForm(pSDEForm);
        for (PSDEFormDetail pSDEFormDetail : arrayList) {
            PSDEFormDetail pSDEFormDetail2 = (PSDEFormDetail)this.getDEModel().createEntity();
            pSDEFormDetail2.setPSDEFormDetailId(pSDEFormDetail.getPSDEFormDetailId());
            pSDEFormDetail2.setPSDEFormId(null);
            this.updateTemp(pSDEFormDetail2);
        }
    }

    public void removeByPSDEForm(PSDEForm pSDEForm) throws Exception {
        final PSDEForm pSDEForm2 = pSDEForm;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEFormDetailServiceBase.this.onBeforeRemoveByPSDEForm(pSDEForm2);
                PSDEFormDetailServiceBase.this.internalRemoveByPSDEForm(pSDEForm2);
                PSDEFormDetailServiceBase.this.onAfterRemoveByPSDEForm(pSDEForm2);
            }
        });
    }

    protected void onBeforeRemoveByPSDEForm(PSDEForm pSDEForm) throws Exception {
    }

    protected void internalRemoveByPSDEForm(PSDEForm pSDEForm) throws Exception {
        ArrayList<PSDEFormDetail> arrayList = this.selectByPSDEForm(pSDEForm);
        this.onBeforeRemoveByPSDEForm(pSDEForm, arrayList);
        for (PSDEFormDetail pSDEFormDetail : arrayList) {
            this.remove(pSDEFormDetail);
        }
        this.onAfterRemoveByPSDEForm(pSDEForm, arrayList);
    }

    protected void onAfterRemoveByPSDEForm(PSDEForm pSDEForm) throws Exception {
    }

    protected void onBeforeRemoveByPSDEForm(PSDEForm pSDEForm, ArrayList<PSDEFormDetail> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDEForm(PSDEForm pSDEForm, ArrayList<PSDEFormDetail> arrayList) throws Exception {
    }

    public void testRemoveByPSDEFSFItem(PSDEFSFItem pSDEFSFItem) throws Exception {
        ArrayList<PSDEFormDetail> arrayList = this.selectByPSDEFSFItem(pSDEFSFItem, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEFSFITEM");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDEFSFItem);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEFORMDETAIL_PSDEFSFITEM_PSDEFSFITEMID", "", iDataEntityModel.getName(), "PSDEFORMDETAIL", iDataEntityModel.getDataInfo(pSDEFSFItem), arrayList.get(0)));
        }
    }

    public void resetPSDEFSFItem(PSDEFSFItem pSDEFSFItem) throws Exception {
        ArrayList<PSDEFormDetail> arrayList = this.selectByPSDEFSFItem(pSDEFSFItem);
        for (PSDEFormDetail pSDEFormDetail : arrayList) {
            PSDEFormDetail pSDEFormDetail2 = (PSDEFormDetail)this.getDEModel().createEntity();
            pSDEFormDetail2.setPSDEFormDetailId(pSDEFormDetail.getPSDEFormDetailId());
            pSDEFormDetail2.setPSDEFSFItemId(null);
            this.update(pSDEFormDetail2);
        }
    }

    public void removeByPSDEFSFItem(PSDEFSFItem pSDEFSFItem) throws Exception {
        final PSDEFSFItem pSDEFSFItem2 = pSDEFSFItem;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEFormDetailServiceBase.this.onBeforeRemoveByPSDEFSFItem(pSDEFSFItem2);
                PSDEFormDetailServiceBase.this.internalRemoveByPSDEFSFItem(pSDEFSFItem2);
                PSDEFormDetailServiceBase.this.onAfterRemoveByPSDEFSFItem(pSDEFSFItem2);
            }
        });
    }

    protected void onBeforeRemoveByPSDEFSFItem(PSDEFSFItem pSDEFSFItem) throws Exception {
    }

    protected void internalRemoveByPSDEFSFItem(PSDEFSFItem pSDEFSFItem) throws Exception {
        ArrayList<PSDEFormDetail> arrayList = this.selectByPSDEFSFItem(pSDEFSFItem);
        this.onBeforeRemoveByPSDEFSFItem(pSDEFSFItem, arrayList);
        for (PSDEFormDetail pSDEFormDetail : arrayList) {
            this.remove(pSDEFormDetail);
        }
        this.onAfterRemoveByPSDEFSFItem(pSDEFSFItem, arrayList);
    }

    protected void onAfterRemoveByPSDEFSFItem(PSDEFSFItem pSDEFSFItem) throws Exception {
    }

    protected void onBeforeRemoveByPSDEFSFItem(PSDEFSFItem pSDEFSFItem, ArrayList<PSDEFormDetail> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDEFSFItem(PSDEFSFItem pSDEFSFItem, ArrayList<PSDEFormDetail> arrayList) throws Exception {
    }

    public void testRemoveByMDPSDEGrid(PSDEGrid pSDEGrid) throws Exception {
        ArrayList<PSDEFormDetail> arrayList = this.selectByMDPSDEGrid(pSDEGrid, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEGRID");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDEGrid);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEFORMDETAIL_PSDEGRID_MDPSDEGRIDID", "", iDataEntityModel.getName(), "PSDEFORMDETAIL", iDataEntityModel.getDataInfo(pSDEGrid), arrayList.get(0)));
        }
    }

    public void resetMDPSDEGrid(PSDEGrid pSDEGrid) throws Exception {
        ArrayList<PSDEFormDetail> arrayList = this.selectByMDPSDEGrid(pSDEGrid);
        for (PSDEFormDetail pSDEFormDetail : arrayList) {
            PSDEFormDetail pSDEFormDetail2 = (PSDEFormDetail)this.getDEModel().createEntity();
            pSDEFormDetail2.setPSDEFormDetailId(pSDEFormDetail.getPSDEFormDetailId());
            pSDEFormDetail2.setMDPSDEGridId(null);
            this.update(pSDEFormDetail2);
        }
    }

    public void removeByMDPSDEGrid(PSDEGrid pSDEGrid) throws Exception {
        final PSDEGrid pSDEGrid2 = pSDEGrid;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEFormDetailServiceBase.this.onBeforeRemoveByMDPSDEGrid(pSDEGrid2);
                PSDEFormDetailServiceBase.this.internalRemoveByMDPSDEGrid(pSDEGrid2);
                PSDEFormDetailServiceBase.this.onAfterRemoveByMDPSDEGrid(pSDEGrid2);
            }
        });
    }

    protected void onBeforeRemoveByMDPSDEGrid(PSDEGrid pSDEGrid) throws Exception {
    }

    protected void internalRemoveByMDPSDEGrid(PSDEGrid pSDEGrid) throws Exception {
        ArrayList<PSDEFormDetail> arrayList = this.selectByMDPSDEGrid(pSDEGrid);
        this.onBeforeRemoveByMDPSDEGrid(pSDEGrid, arrayList);
        for (PSDEFormDetail pSDEFormDetail : arrayList) {
            this.remove(pSDEFormDetail);
        }
        this.onAfterRemoveByMDPSDEGrid(pSDEGrid, arrayList);
    }

    protected void onAfterRemoveByMDPSDEGrid(PSDEGrid pSDEGrid) throws Exception {
    }

    protected void onBeforeRemoveByMDPSDEGrid(PSDEGrid pSDEGrid, ArrayList<PSDEFormDetail> arrayList) throws Exception {
    }

    protected void onAfterRemoveByMDPSDEGrid(PSDEGrid pSDEGrid, ArrayList<PSDEFormDetail> arrayList) throws Exception {
    }

    public void testRemoveByMDPSDEList(PSDEList pSDEList) throws Exception {
        ArrayList<PSDEFormDetail> arrayList = this.selectByMDPSDEList(pSDEList, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDELIST");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDEList);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEFORMDETAIL_PSDELIST_MDPSDELISTID", "", iDataEntityModel.getName(), "PSDEFORMDETAIL", iDataEntityModel.getDataInfo(pSDEList), arrayList.get(0)));
        }
    }

    public void resetMDPSDEList(PSDEList pSDEList) throws Exception {
        ArrayList<PSDEFormDetail> arrayList = this.selectByMDPSDEList(pSDEList);
        for (PSDEFormDetail pSDEFormDetail : arrayList) {
            PSDEFormDetail pSDEFormDetail2 = (PSDEFormDetail)this.getDEModel().createEntity();
            pSDEFormDetail2.setPSDEFormDetailId(pSDEFormDetail.getPSDEFormDetailId());
            pSDEFormDetail2.setMDPSDEListId(null);
            this.update(pSDEFormDetail2);
        }
    }

    public void removeByMDPSDEList(PSDEList pSDEList) throws Exception {
        final PSDEList pSDEList2 = pSDEList;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEFormDetailServiceBase.this.onBeforeRemoveByMDPSDEList(pSDEList2);
                PSDEFormDetailServiceBase.this.internalRemoveByMDPSDEList(pSDEList2);
                PSDEFormDetailServiceBase.this.onAfterRemoveByMDPSDEList(pSDEList2);
            }
        });
    }

    protected void onBeforeRemoveByMDPSDEList(PSDEList pSDEList) throws Exception {
    }

    protected void internalRemoveByMDPSDEList(PSDEList pSDEList) throws Exception {
        ArrayList<PSDEFormDetail> arrayList = this.selectByMDPSDEList(pSDEList);
        this.onBeforeRemoveByMDPSDEList(pSDEList, arrayList);
        for (PSDEFormDetail pSDEFormDetail : arrayList) {
            this.remove(pSDEFormDetail);
        }
        this.onAfterRemoveByMDPSDEList(pSDEList, arrayList);
    }

    protected void onAfterRemoveByMDPSDEList(PSDEList pSDEList) throws Exception {
    }

    protected void onBeforeRemoveByMDPSDEList(PSDEList pSDEList, ArrayList<PSDEFormDetail> arrayList) throws Exception {
    }

    protected void onAfterRemoveByMDPSDEList(PSDEList pSDEList, ArrayList<PSDEFormDetail> arrayList) throws Exception {
    }

    public void testRemoveByPSDELogic(PSDELogic pSDELogic) throws Exception {
        ArrayList<PSDEFormDetail> arrayList = this.selectByPSDELogic(pSDELogic, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDELOGIC");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDELogic);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEFORMDETAIL_PSDELOGIC_PSDELOGICID", "", iDataEntityModel.getName(), "PSDEFORMDETAIL", iDataEntityModel.getDataInfo(pSDELogic), arrayList.get(0)));
        }
    }

    public void resetPSDELogic(PSDELogic pSDELogic) throws Exception {
        ArrayList<PSDEFormDetail> arrayList = this.selectByPSDELogic(pSDELogic);
        for (PSDEFormDetail pSDEFormDetail : arrayList) {
            PSDEFormDetail pSDEFormDetail2 = (PSDEFormDetail)this.getDEModel().createEntity();
            pSDEFormDetail2.setPSDEFormDetailId(pSDEFormDetail.getPSDEFormDetailId());
            pSDEFormDetail2.setPSDELogicId(null);
            this.update(pSDEFormDetail2);
        }
    }

    public void removeByPSDELogic(PSDELogic pSDELogic) throws Exception {
        final PSDELogic pSDELogic2 = pSDELogic;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEFormDetailServiceBase.this.onBeforeRemoveByPSDELogic(pSDELogic2);
                PSDEFormDetailServiceBase.this.internalRemoveByPSDELogic(pSDELogic2);
                PSDEFormDetailServiceBase.this.onAfterRemoveByPSDELogic(pSDELogic2);
            }
        });
    }

    protected void onBeforeRemoveByPSDELogic(PSDELogic pSDELogic) throws Exception {
    }

    protected void internalRemoveByPSDELogic(PSDELogic pSDELogic) throws Exception {
        ArrayList<PSDEFormDetail> arrayList = this.selectByPSDELogic(pSDELogic);
        this.onBeforeRemoveByPSDELogic(pSDELogic, arrayList);
        for (PSDEFormDetail pSDEFormDetail : arrayList) {
            this.remove(pSDEFormDetail);
        }
        this.onAfterRemoveByPSDELogic(pSDELogic, arrayList);
    }

    protected void onAfterRemoveByPSDELogic(PSDELogic pSDELogic) throws Exception {
    }

    protected void onBeforeRemoveByPSDELogic(PSDELogic pSDELogic, ArrayList<PSDEFormDetail> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDELogic(PSDELogic pSDELogic, ArrayList<PSDEFormDetail> arrayList) throws Exception {
    }

    public void testRemoveByRefPSDER(PSDER pSDER) throws Exception {
        ArrayList<PSDEFormDetail> arrayList = this.selectByRefPSDER(pSDER, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDER");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDER);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEFORMDETAIL_PSDER_REFPSDERID", "", iDataEntityModel.getName(), "PSDEFORMDETAIL", iDataEntityModel.getDataInfo(pSDER), arrayList.get(0)));
        }
    }

    public void resetRefPSDER(PSDER pSDER) throws Exception {
        ArrayList<PSDEFormDetail> arrayList = this.selectByRefPSDER(pSDER);
        for (PSDEFormDetail pSDEFormDetail : arrayList) {
            PSDEFormDetail pSDEFormDetail2 = (PSDEFormDetail)this.getDEModel().createEntity();
            pSDEFormDetail2.setPSDEFormDetailId(pSDEFormDetail.getPSDEFormDetailId());
            pSDEFormDetail2.setRefPSDERId(null);
            this.update(pSDEFormDetail2);
        }
    }

    public void removeByRefPSDER(PSDER pSDER) throws Exception {
        final PSDER pSDER2 = pSDER;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEFormDetailServiceBase.this.onBeforeRemoveByRefPSDER(pSDER2);
                PSDEFormDetailServiceBase.this.internalRemoveByRefPSDER(pSDER2);
                PSDEFormDetailServiceBase.this.onAfterRemoveByRefPSDER(pSDER2);
            }
        });
    }

    protected void onBeforeRemoveByRefPSDER(PSDER pSDER) throws Exception {
    }

    protected void internalRemoveByRefPSDER(PSDER pSDER) throws Exception {
        ArrayList<PSDEFormDetail> arrayList = this.selectByRefPSDER(pSDER);
        this.onBeforeRemoveByRefPSDER(pSDER, arrayList);
        for (PSDEFormDetail pSDEFormDetail : arrayList) {
            this.remove(pSDEFormDetail);
        }
        this.onAfterRemoveByRefPSDER(pSDER, arrayList);
    }

    protected void onAfterRemoveByRefPSDER(PSDER pSDER) throws Exception {
    }

    protected void onBeforeRemoveByRefPSDER(PSDER pSDER, ArrayList<PSDEFormDetail> arrayList) throws Exception {
    }

    protected void onAfterRemoveByRefPSDER(PSDER pSDER, ArrayList<PSDEFormDetail> arrayList) throws Exception {
    }

    public void testRemoveByPSDEUAGroup(PSDEUAGroup pSDEUAGroup) throws Exception {
        ArrayList<PSDEFormDetail> arrayList = this.selectByPSDEUAGroup(pSDEUAGroup, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEUAGROUP");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDEUAGroup);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEFORMDETAIL_PSDEUAGROUP_PSDEUAGROUPID", "", iDataEntityModel.getName(), "PSDEFORMDETAIL", iDataEntityModel.getDataInfo(pSDEUAGroup), arrayList.get(0)));
        }
    }

    public void resetPSDEUAGroup(PSDEUAGroup pSDEUAGroup) throws Exception {
        ArrayList<PSDEFormDetail> arrayList = this.selectByPSDEUAGroup(pSDEUAGroup);
        for (PSDEFormDetail pSDEFormDetail : arrayList) {
            PSDEFormDetail pSDEFormDetail2 = (PSDEFormDetail)this.getDEModel().createEntity();
            pSDEFormDetail2.setPSDEFormDetailId(pSDEFormDetail.getPSDEFormDetailId());
            pSDEFormDetail2.setPSDEUAGroupId(null);
            this.update(pSDEFormDetail2);
        }
    }

    public void removeByPSDEUAGroup(PSDEUAGroup pSDEUAGroup) throws Exception {
        final PSDEUAGroup pSDEUAGroup2 = pSDEUAGroup;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEFormDetailServiceBase.this.onBeforeRemoveByPSDEUAGroup(pSDEUAGroup2);
                PSDEFormDetailServiceBase.this.internalRemoveByPSDEUAGroup(pSDEUAGroup2);
                PSDEFormDetailServiceBase.this.onAfterRemoveByPSDEUAGroup(pSDEUAGroup2);
            }
        });
    }

    protected void onBeforeRemoveByPSDEUAGroup(PSDEUAGroup pSDEUAGroup) throws Exception {
    }

    protected void internalRemoveByPSDEUAGroup(PSDEUAGroup pSDEUAGroup) throws Exception {
        ArrayList<PSDEFormDetail> arrayList = this.selectByPSDEUAGroup(pSDEUAGroup);
        this.onBeforeRemoveByPSDEUAGroup(pSDEUAGroup, arrayList);
        for (PSDEFormDetail pSDEFormDetail : arrayList) {
            this.remove(pSDEFormDetail);
        }
        this.onAfterRemoveByPSDEUAGroup(pSDEUAGroup, arrayList);
    }

    protected void onAfterRemoveByPSDEUAGroup(PSDEUAGroup pSDEUAGroup) throws Exception {
    }

    protected void onBeforeRemoveByPSDEUAGroup(PSDEUAGroup pSDEUAGroup, ArrayList<PSDEFormDetail> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDEUAGroup(PSDEUAGroup pSDEUAGroup, ArrayList<PSDEFormDetail> arrayList) throws Exception {
    }

    public void testRemoveByPSDEUIAction(PSDEUIAction pSDEUIAction) throws Exception {
        ArrayList<PSDEFormDetail> arrayList = this.selectByPSDEUIAction(pSDEUIAction, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEUIACTION");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDEUIAction);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEFORMDETAIL_PSDEUIACTION_PSDEUIACTIONID", "", iDataEntityModel.getName(), "PSDEFORMDETAIL", iDataEntityModel.getDataInfo(pSDEUIAction), arrayList.get(0)));
        }
    }

    public void resetPSDEUIAction(PSDEUIAction pSDEUIAction) throws Exception {
        ArrayList<PSDEFormDetail> arrayList = this.selectByPSDEUIAction(pSDEUIAction);
        for (PSDEFormDetail pSDEFormDetail : arrayList) {
            PSDEFormDetail pSDEFormDetail2 = (PSDEFormDetail)this.getDEModel().createEntity();
            pSDEFormDetail2.setPSDEFormDetailId(pSDEFormDetail.getPSDEFormDetailId());
            pSDEFormDetail2.setPSDEUIActionId(null);
            this.update(pSDEFormDetail2);
        }
    }

    public void removeByPSDEUIAction(PSDEUIAction pSDEUIAction) throws Exception {
        final PSDEUIAction pSDEUIAction2 = pSDEUIAction;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEFormDetailServiceBase.this.onBeforeRemoveByPSDEUIAction(pSDEUIAction2);
                PSDEFormDetailServiceBase.this.internalRemoveByPSDEUIAction(pSDEUIAction2);
                PSDEFormDetailServiceBase.this.onAfterRemoveByPSDEUIAction(pSDEUIAction2);
            }
        });
    }

    protected void onBeforeRemoveByPSDEUIAction(PSDEUIAction pSDEUIAction) throws Exception {
    }

    protected void internalRemoveByPSDEUIAction(PSDEUIAction pSDEUIAction) throws Exception {
        ArrayList<PSDEFormDetail> arrayList = this.selectByPSDEUIAction(pSDEUIAction);
        this.onBeforeRemoveByPSDEUIAction(pSDEUIAction, arrayList);
        for (PSDEFormDetail pSDEFormDetail : arrayList) {
            this.remove(pSDEFormDetail);
        }
        this.onAfterRemoveByPSDEUIAction(pSDEUIAction, arrayList);
    }

    protected void onAfterRemoveByPSDEUIAction(PSDEUIAction pSDEUIAction) throws Exception {
    }

    protected void onBeforeRemoveByPSDEUIAction(PSDEUIAction pSDEUIAction, ArrayList<PSDEFormDetail> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDEUIAction(PSDEUIAction pSDEUIAction, ArrayList<PSDEFormDetail> arrayList) throws Exception {
    }

    public void testRemoveByLinkPSDEView(PSDEViewBase pSDEViewBase) throws Exception {
        ArrayList<PSDEFormDetail> arrayList = this.selectByLinkPSDEView(pSDEViewBase, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEVIEWBASE");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDEViewBase);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEFORMDETAIL_PSDEVIEWBASE_LINKPSDEVIEWID", "", iDataEntityModel.getName(), "PSDEFORMDETAIL", iDataEntityModel.getDataInfo(pSDEViewBase), arrayList.get(0)));
        }
    }

    public void resetLinkPSDEView(PSDEViewBase pSDEViewBase) throws Exception {
        ArrayList<PSDEFormDetail> arrayList = this.selectByLinkPSDEView(pSDEViewBase);
        for (PSDEFormDetail pSDEFormDetail : arrayList) {
            PSDEFormDetail pSDEFormDetail2 = (PSDEFormDetail)this.getDEModel().createEntity();
            pSDEFormDetail2.setPSDEFormDetailId(pSDEFormDetail.getPSDEFormDetailId());
            pSDEFormDetail2.setLinkPSDEViewId(null);
            this.update(pSDEFormDetail2);
        }
    }

    public void removeByLinkPSDEView(PSDEViewBase pSDEViewBase) throws Exception {
        final PSDEViewBase pSDEViewBase2 = pSDEViewBase;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEFormDetailServiceBase.this.onBeforeRemoveByLinkPSDEView(pSDEViewBase2);
                PSDEFormDetailServiceBase.this.internalRemoveByLinkPSDEView(pSDEViewBase2);
                PSDEFormDetailServiceBase.this.onAfterRemoveByLinkPSDEView(pSDEViewBase2);
            }
        });
    }

    protected void onBeforeRemoveByLinkPSDEView(PSDEViewBase pSDEViewBase) throws Exception {
    }

    protected void internalRemoveByLinkPSDEView(PSDEViewBase pSDEViewBase) throws Exception {
        ArrayList<PSDEFormDetail> arrayList = this.selectByLinkPSDEView(pSDEViewBase);
        this.onBeforeRemoveByLinkPSDEView(pSDEViewBase, arrayList);
        for (PSDEFormDetail pSDEFormDetail : arrayList) {
            this.remove(pSDEFormDetail);
        }
        this.onAfterRemoveByLinkPSDEView(pSDEViewBase, arrayList);
    }

    protected void onAfterRemoveByLinkPSDEView(PSDEViewBase pSDEViewBase) throws Exception {
    }

    protected void onBeforeRemoveByLinkPSDEView(PSDEViewBase pSDEViewBase, ArrayList<PSDEFormDetail> arrayList) throws Exception {
    }

    protected void onAfterRemoveByLinkPSDEView(PSDEViewBase pSDEViewBase, ArrayList<PSDEFormDetail> arrayList) throws Exception {
    }

    public void testRemoveByOpenPSDEView(PSDEViewBase pSDEViewBase) throws Exception {
        ArrayList<PSDEFormDetail> arrayList = this.selectByOpenPSDEView(pSDEViewBase, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEVIEWBASE");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDEViewBase);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEFORMDETAIL_PSDEVIEWBASE_OPENPSDEVIEWID", "", iDataEntityModel.getName(), "PSDEFORMDETAIL", iDataEntityModel.getDataInfo(pSDEViewBase), arrayList.get(0)));
        }
    }

    public void resetOpenPSDEView(PSDEViewBase pSDEViewBase) throws Exception {
        ArrayList<PSDEFormDetail> arrayList = this.selectByOpenPSDEView(pSDEViewBase);
        for (PSDEFormDetail pSDEFormDetail : arrayList) {
            PSDEFormDetail pSDEFormDetail2 = (PSDEFormDetail)this.getDEModel().createEntity();
            pSDEFormDetail2.setPSDEFormDetailId(pSDEFormDetail.getPSDEFormDetailId());
            pSDEFormDetail2.setOpenPSDEViewId(null);
            this.update(pSDEFormDetail2);
        }
    }

    public void removeByOpenPSDEView(PSDEViewBase pSDEViewBase) throws Exception {
        final PSDEViewBase pSDEViewBase2 = pSDEViewBase;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEFormDetailServiceBase.this.onBeforeRemoveByOpenPSDEView(pSDEViewBase2);
                PSDEFormDetailServiceBase.this.internalRemoveByOpenPSDEView(pSDEViewBase2);
                PSDEFormDetailServiceBase.this.onAfterRemoveByOpenPSDEView(pSDEViewBase2);
            }
        });
    }

    protected void onBeforeRemoveByOpenPSDEView(PSDEViewBase pSDEViewBase) throws Exception {
    }

    protected void internalRemoveByOpenPSDEView(PSDEViewBase pSDEViewBase) throws Exception {
        ArrayList<PSDEFormDetail> arrayList = this.selectByOpenPSDEView(pSDEViewBase);
        this.onBeforeRemoveByOpenPSDEView(pSDEViewBase, arrayList);
        for (PSDEFormDetail pSDEFormDetail : arrayList) {
            this.remove(pSDEFormDetail);
        }
        this.onAfterRemoveByOpenPSDEView(pSDEViewBase, arrayList);
    }

    protected void onAfterRemoveByOpenPSDEView(PSDEViewBase pSDEViewBase) throws Exception {
    }

    protected void onBeforeRemoveByOpenPSDEView(PSDEViewBase pSDEViewBase, ArrayList<PSDEFormDetail> arrayList) throws Exception {
    }

    protected void onAfterRemoveByOpenPSDEView(PSDEViewBase pSDEViewBase, ArrayList<PSDEFormDetail> arrayList) throws Exception {
    }

    public void testRemoveByPickupPSDEView(PSDEViewBase pSDEViewBase) throws Exception {
        ArrayList<PSDEFormDetail> arrayList = this.selectByPickupPSDEView(pSDEViewBase, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEVIEWBASE");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDEViewBase);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEFORMDETAIL_PSDEVIEWBASE_PICKUPPSDEVIEWID", "", iDataEntityModel.getName(), "PSDEFORMDETAIL", iDataEntityModel.getDataInfo(pSDEViewBase), arrayList.get(0)));
        }
    }

    public void resetPickupPSDEView(PSDEViewBase pSDEViewBase) throws Exception {
        ArrayList<PSDEFormDetail> arrayList = this.selectByPickupPSDEView(pSDEViewBase);
        for (PSDEFormDetail pSDEFormDetail : arrayList) {
            PSDEFormDetail pSDEFormDetail2 = (PSDEFormDetail)this.getDEModel().createEntity();
            pSDEFormDetail2.setPSDEFormDetailId(pSDEFormDetail.getPSDEFormDetailId());
            pSDEFormDetail2.setPickupPSDEViewId(null);
            this.update(pSDEFormDetail2);
        }
    }

    public void removeByPickupPSDEView(PSDEViewBase pSDEViewBase) throws Exception {
        final PSDEViewBase pSDEViewBase2 = pSDEViewBase;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEFormDetailServiceBase.this.onBeforeRemoveByPickupPSDEView(pSDEViewBase2);
                PSDEFormDetailServiceBase.this.internalRemoveByPickupPSDEView(pSDEViewBase2);
                PSDEFormDetailServiceBase.this.onAfterRemoveByPickupPSDEView(pSDEViewBase2);
            }
        });
    }

    protected void onBeforeRemoveByPickupPSDEView(PSDEViewBase pSDEViewBase) throws Exception {
    }

    protected void internalRemoveByPickupPSDEView(PSDEViewBase pSDEViewBase) throws Exception {
        ArrayList<PSDEFormDetail> arrayList = this.selectByPickupPSDEView(pSDEViewBase);
        this.onBeforeRemoveByPickupPSDEView(pSDEViewBase, arrayList);
        for (PSDEFormDetail pSDEFormDetail : arrayList) {
            this.remove(pSDEFormDetail);
        }
        this.onAfterRemoveByPickupPSDEView(pSDEViewBase, arrayList);
    }

    protected void onAfterRemoveByPickupPSDEView(PSDEViewBase pSDEViewBase) throws Exception {
    }

    protected void onBeforeRemoveByPickupPSDEView(PSDEViewBase pSDEViewBase, ArrayList<PSDEFormDetail> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPickupPSDEView(PSDEViewBase pSDEViewBase, ArrayList<PSDEFormDetail> arrayList) throws Exception {
    }

    public void testRemoveByCapPSLanRes(PSLanguageRes pSLanguageRes) throws Exception {
        ArrayList<PSDEFormDetail> arrayList = this.selectByCapPSLanRes(pSLanguageRes, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSLANGUAGERES");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSLanguageRes);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEFORMDETAIL_PSLANGUAGERES_CAPPSLANRESID", "", iDataEntityModel.getName(), "PSDEFORMDETAIL", iDataEntityModel.getDataInfo(pSLanguageRes), arrayList.get(0)));
        }
    }

    public void resetCapPSLanRes(PSLanguageRes pSLanguageRes) throws Exception {
        ArrayList<PSDEFormDetail> arrayList = this.selectByCapPSLanRes(pSLanguageRes);
        for (PSDEFormDetail pSDEFormDetail : arrayList) {
            PSDEFormDetail pSDEFormDetail2 = (PSDEFormDetail)this.getDEModel().createEntity();
            pSDEFormDetail2.setPSDEFormDetailId(pSDEFormDetail.getPSDEFormDetailId());
            pSDEFormDetail2.setCapPSLanResId(null);
            this.update(pSDEFormDetail2);
        }
    }

    public void removeByCapPSLanRes(PSLanguageRes pSLanguageRes) throws Exception {
        final PSLanguageRes pSLanguageRes2 = pSLanguageRes;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEFormDetailServiceBase.this.onBeforeRemoveByCapPSLanRes(pSLanguageRes2);
                PSDEFormDetailServiceBase.this.internalRemoveByCapPSLanRes(pSLanguageRes2);
                PSDEFormDetailServiceBase.this.onAfterRemoveByCapPSLanRes(pSLanguageRes2);
            }
        });
    }

    protected void onBeforeRemoveByCapPSLanRes(PSLanguageRes pSLanguageRes) throws Exception {
    }

    protected void internalRemoveByCapPSLanRes(PSLanguageRes pSLanguageRes) throws Exception {
        ArrayList<PSDEFormDetail> arrayList = this.selectByCapPSLanRes(pSLanguageRes);
        this.onBeforeRemoveByCapPSLanRes(pSLanguageRes, arrayList);
        for (PSDEFormDetail pSDEFormDetail : arrayList) {
            this.remove(pSDEFormDetail);
        }
        this.onAfterRemoveByCapPSLanRes(pSLanguageRes, arrayList);
    }

    protected void onAfterRemoveByCapPSLanRes(PSLanguageRes pSLanguageRes) throws Exception {
    }

    protected void onBeforeRemoveByCapPSLanRes(PSLanguageRes pSLanguageRes, ArrayList<PSDEFormDetail> arrayList) throws Exception {
    }

    protected void onAfterRemoveByCapPSLanRes(PSLanguageRes pSLanguageRes, ArrayList<PSDEFormDetail> arrayList) throws Exception {
    }

    public void testRemoveByMaskPSLanRes(PSLanguageRes pSLanguageRes) throws Exception {
        ArrayList<PSDEFormDetail> arrayList = this.selectByMaskPSLanRes(pSLanguageRes, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSLANGUAGERES");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSLanguageRes);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEFORMDETAIL_PSLANGUAGERES_MASKPSLANRESID", "", iDataEntityModel.getName(), "PSDEFORMDETAIL", iDataEntityModel.getDataInfo(pSLanguageRes), arrayList.get(0)));
        }
    }

    public void resetMaskPSLanRes(PSLanguageRes pSLanguageRes) throws Exception {
        ArrayList<PSDEFormDetail> arrayList = this.selectByMaskPSLanRes(pSLanguageRes);
        for (PSDEFormDetail pSDEFormDetail : arrayList) {
            PSDEFormDetail pSDEFormDetail2 = (PSDEFormDetail)this.getDEModel().createEntity();
            pSDEFormDetail2.setPSDEFormDetailId(pSDEFormDetail.getPSDEFormDetailId());
            pSDEFormDetail2.setMaskPSLanResId(null);
            this.update(pSDEFormDetail2);
        }
    }

    public void removeByMaskPSLanRes(PSLanguageRes pSLanguageRes) throws Exception {
        final PSLanguageRes pSLanguageRes2 = pSLanguageRes;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEFormDetailServiceBase.this.onBeforeRemoveByMaskPSLanRes(pSLanguageRes2);
                PSDEFormDetailServiceBase.this.internalRemoveByMaskPSLanRes(pSLanguageRes2);
                PSDEFormDetailServiceBase.this.onAfterRemoveByMaskPSLanRes(pSLanguageRes2);
            }
        });
    }

    protected void onBeforeRemoveByMaskPSLanRes(PSLanguageRes pSLanguageRes) throws Exception {
    }

    protected void internalRemoveByMaskPSLanRes(PSLanguageRes pSLanguageRes) throws Exception {
        ArrayList<PSDEFormDetail> arrayList = this.selectByMaskPSLanRes(pSLanguageRes);
        this.onBeforeRemoveByMaskPSLanRes(pSLanguageRes, arrayList);
        for (PSDEFormDetail pSDEFormDetail : arrayList) {
            this.remove(pSDEFormDetail);
        }
        this.onAfterRemoveByMaskPSLanRes(pSLanguageRes, arrayList);
    }

    protected void onAfterRemoveByMaskPSLanRes(PSLanguageRes pSLanguageRes) throws Exception {
    }

    protected void onBeforeRemoveByMaskPSLanRes(PSLanguageRes pSLanguageRes, ArrayList<PSDEFormDetail> arrayList) throws Exception {
    }

    protected void onAfterRemoveByMaskPSLanRes(PSLanguageRes pSLanguageRes, ArrayList<PSDEFormDetail> arrayList) throws Exception {
    }

    public void testRemoveByPHPSLanRes(PSLanguageRes pSLanguageRes) throws Exception {
        ArrayList<PSDEFormDetail> arrayList = this.selectByPHPSLanRes(pSLanguageRes, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSLANGUAGERES");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSLanguageRes);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEFORMDETAIL_PSLANGUAGERES_PHPSLANRESID", "", iDataEntityModel.getName(), "PSDEFORMDETAIL", iDataEntityModel.getDataInfo(pSLanguageRes), arrayList.get(0)));
        }
    }

    public void resetPHPSLanRes(PSLanguageRes pSLanguageRes) throws Exception {
        ArrayList<PSDEFormDetail> arrayList = this.selectByPHPSLanRes(pSLanguageRes);
        for (PSDEFormDetail pSDEFormDetail : arrayList) {
            PSDEFormDetail pSDEFormDetail2 = (PSDEFormDetail)this.getDEModel().createEntity();
            pSDEFormDetail2.setPSDEFormDetailId(pSDEFormDetail.getPSDEFormDetailId());
            pSDEFormDetail2.setPHPSLanResId(null);
            this.update(pSDEFormDetail2);
        }
    }

    public void removeByPHPSLanRes(PSLanguageRes pSLanguageRes) throws Exception {
        final PSLanguageRes pSLanguageRes2 = pSLanguageRes;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEFormDetailServiceBase.this.onBeforeRemoveByPHPSLanRes(pSLanguageRes2);
                PSDEFormDetailServiceBase.this.internalRemoveByPHPSLanRes(pSLanguageRes2);
                PSDEFormDetailServiceBase.this.onAfterRemoveByPHPSLanRes(pSLanguageRes2);
            }
        });
    }

    protected void onBeforeRemoveByPHPSLanRes(PSLanguageRes pSLanguageRes) throws Exception {
    }

    protected void internalRemoveByPHPSLanRes(PSLanguageRes pSLanguageRes) throws Exception {
        ArrayList<PSDEFormDetail> arrayList = this.selectByPHPSLanRes(pSLanguageRes);
        this.onBeforeRemoveByPHPSLanRes(pSLanguageRes, arrayList);
        for (PSDEFormDetail pSDEFormDetail : arrayList) {
            this.remove(pSDEFormDetail);
        }
        this.onAfterRemoveByPHPSLanRes(pSLanguageRes, arrayList);
    }

    protected void onAfterRemoveByPHPSLanRes(PSLanguageRes pSLanguageRes) throws Exception {
    }

    protected void onBeforeRemoveByPHPSLanRes(PSLanguageRes pSLanguageRes, ArrayList<PSDEFormDetail> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPHPSLanRes(PSLanguageRes pSLanguageRes, ArrayList<PSDEFormDetail> arrayList) throws Exception {
    }

    public void testRemoveByTipPSLanRes(PSLanguageRes pSLanguageRes) throws Exception {
        ArrayList<PSDEFormDetail> arrayList = this.selectByTipPSLanRes(pSLanguageRes, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSLANGUAGERES");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSLanguageRes);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEFORMDETAIL_PSLANGUAGERES_TIPPSLANRESID", "", iDataEntityModel.getName(), "PSDEFORMDETAIL", iDataEntityModel.getDataInfo(pSLanguageRes), arrayList.get(0)));
        }
    }

    public void resetTipPSLanRes(PSLanguageRes pSLanguageRes) throws Exception {
        ArrayList<PSDEFormDetail> arrayList = this.selectByTipPSLanRes(pSLanguageRes);
        for (PSDEFormDetail pSDEFormDetail : arrayList) {
            PSDEFormDetail pSDEFormDetail2 = (PSDEFormDetail)this.getDEModel().createEntity();
            pSDEFormDetail2.setPSDEFormDetailId(pSDEFormDetail.getPSDEFormDetailId());
            pSDEFormDetail2.setTipPSLanResId(null);
            this.update(pSDEFormDetail2);
        }
    }

    public void removeByTipPSLanRes(PSLanguageRes pSLanguageRes) throws Exception {
        final PSLanguageRes pSLanguageRes2 = pSLanguageRes;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEFormDetailServiceBase.this.onBeforeRemoveByTipPSLanRes(pSLanguageRes2);
                PSDEFormDetailServiceBase.this.internalRemoveByTipPSLanRes(pSLanguageRes2);
                PSDEFormDetailServiceBase.this.onAfterRemoveByTipPSLanRes(pSLanguageRes2);
            }
        });
    }

    protected void onBeforeRemoveByTipPSLanRes(PSLanguageRes pSLanguageRes) throws Exception {
    }

    protected void internalRemoveByTipPSLanRes(PSLanguageRes pSLanguageRes) throws Exception {
        ArrayList<PSDEFormDetail> arrayList = this.selectByTipPSLanRes(pSLanguageRes);
        this.onBeforeRemoveByTipPSLanRes(pSLanguageRes, arrayList);
        for (PSDEFormDetail pSDEFormDetail : arrayList) {
            this.remove(pSDEFormDetail);
        }
        this.onAfterRemoveByTipPSLanRes(pSLanguageRes, arrayList);
    }

    protected void onAfterRemoveByTipPSLanRes(PSLanguageRes pSLanguageRes) throws Exception {
    }

    protected void onBeforeRemoveByTipPSLanRes(PSLanguageRes pSLanguageRes, ArrayList<PSDEFormDetail> arrayList) throws Exception {
    }

    protected void onAfterRemoveByTipPSLanRes(PSLanguageRes pSLanguageRes, ArrayList<PSDEFormDetail> arrayList) throws Exception {
    }

    public void testRemoveByPSSysCounter(PSSysCounter pSSysCounter) throws Exception {
        ArrayList<PSDEFormDetail> arrayList = this.selectByPSSysCounter(pSSysCounter, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSCOUNTER");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSSysCounter);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEFORMDETAIL_PSSYSCOUNTER_PSSYSCOUNTERID", "", iDataEntityModel.getName(), "PSDEFORMDETAIL", iDataEntityModel.getDataInfo(pSSysCounter), arrayList.get(0)));
        }
    }

    public void resetPSSysCounter(PSSysCounter pSSysCounter) throws Exception {
        ArrayList<PSDEFormDetail> arrayList = this.selectByPSSysCounter(pSSysCounter);
        for (PSDEFormDetail pSDEFormDetail : arrayList) {
            PSDEFormDetail pSDEFormDetail2 = (PSDEFormDetail)this.getDEModel().createEntity();
            pSDEFormDetail2.setPSDEFormDetailId(pSDEFormDetail.getPSDEFormDetailId());
            pSDEFormDetail2.setPSSysCounterId(null);
            this.update(pSDEFormDetail2);
        }
    }

    public void removeByPSSysCounter(PSSysCounter pSSysCounter) throws Exception {
        final PSSysCounter pSSysCounter2 = pSSysCounter;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEFormDetailServiceBase.this.onBeforeRemoveByPSSysCounter(pSSysCounter2);
                PSDEFormDetailServiceBase.this.internalRemoveByPSSysCounter(pSSysCounter2);
                PSDEFormDetailServiceBase.this.onAfterRemoveByPSSysCounter(pSSysCounter2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysCounter(PSSysCounter pSSysCounter) throws Exception {
    }

    protected void internalRemoveByPSSysCounter(PSSysCounter pSSysCounter) throws Exception {
        ArrayList<PSDEFormDetail> arrayList = this.selectByPSSysCounter(pSSysCounter);
        this.onBeforeRemoveByPSSysCounter(pSSysCounter, arrayList);
        for (PSDEFormDetail pSDEFormDetail : arrayList) {
            this.remove(pSDEFormDetail);
        }
        this.onAfterRemoveByPSSysCounter(pSSysCounter, arrayList);
    }

    protected void onAfterRemoveByPSSysCounter(PSSysCounter pSSysCounter) throws Exception {
    }

    protected void onBeforeRemoveByPSSysCounter(PSSysCounter pSSysCounter, ArrayList<PSDEFormDetail> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysCounter(PSSysCounter pSSysCounter, ArrayList<PSDEFormDetail> arrayList) throws Exception {
    }

    public void testRemoveByCtrlPSSysCss(PSSysCss pSSysCss) throws Exception {
        ArrayList<PSDEFormDetail> arrayList = this.selectByCtrlPSSysCss(pSSysCss, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSCSS");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSSysCss);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEFORMDETAIL_PSSYSCSS_CTRLPSSYSCSSID", "", iDataEntityModel.getName(), "PSDEFORMDETAIL", iDataEntityModel.getDataInfo(pSSysCss), arrayList.get(0)));
        }
    }

    public void resetCtrlPSSysCss(PSSysCss pSSysCss) throws Exception {
        ArrayList<PSDEFormDetail> arrayList = this.selectByCtrlPSSysCss(pSSysCss);
        for (PSDEFormDetail pSDEFormDetail : arrayList) {
            PSDEFormDetail pSDEFormDetail2 = (PSDEFormDetail)this.getDEModel().createEntity();
            pSDEFormDetail2.setPSDEFormDetailId(pSDEFormDetail.getPSDEFormDetailId());
            pSDEFormDetail2.setCtrlPSSysCssId(null);
            this.update(pSDEFormDetail2);
        }
    }

    public void removeByCtrlPSSysCss(PSSysCss pSSysCss) throws Exception {
        final PSSysCss pSSysCss2 = pSSysCss;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEFormDetailServiceBase.this.onBeforeRemoveByCtrlPSSysCss(pSSysCss2);
                PSDEFormDetailServiceBase.this.internalRemoveByCtrlPSSysCss(pSSysCss2);
                PSDEFormDetailServiceBase.this.onAfterRemoveByCtrlPSSysCss(pSSysCss2);
            }
        });
    }

    protected void onBeforeRemoveByCtrlPSSysCss(PSSysCss pSSysCss) throws Exception {
    }

    protected void internalRemoveByCtrlPSSysCss(PSSysCss pSSysCss) throws Exception {
        ArrayList<PSDEFormDetail> arrayList = this.selectByCtrlPSSysCss(pSSysCss);
        this.onBeforeRemoveByCtrlPSSysCss(pSSysCss, arrayList);
        for (PSDEFormDetail pSDEFormDetail : arrayList) {
            this.remove(pSDEFormDetail);
        }
        this.onAfterRemoveByCtrlPSSysCss(pSSysCss, arrayList);
    }

    protected void onAfterRemoveByCtrlPSSysCss(PSSysCss pSSysCss) throws Exception {
    }

    protected void onBeforeRemoveByCtrlPSSysCss(PSSysCss pSSysCss, ArrayList<PSDEFormDetail> arrayList) throws Exception {
    }

    protected void onAfterRemoveByCtrlPSSysCss(PSSysCss pSSysCss, ArrayList<PSDEFormDetail> arrayList) throws Exception {
    }

    public void testRemoveByLabelPSSysCss(PSSysCss pSSysCss) throws Exception {
        ArrayList<PSDEFormDetail> arrayList = this.selectByLabelPSSysCss(pSSysCss, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSCSS");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSSysCss);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEFORMDETAIL_PSSYSCSS_LABELPSSYSCSSID", "", iDataEntityModel.getName(), "PSDEFORMDETAIL", iDataEntityModel.getDataInfo(pSSysCss), arrayList.get(0)));
        }
    }

    public void resetLabelPSSysCss(PSSysCss pSSysCss) throws Exception {
        ArrayList<PSDEFormDetail> arrayList = this.selectByLabelPSSysCss(pSSysCss);
        for (PSDEFormDetail pSDEFormDetail : arrayList) {
            PSDEFormDetail pSDEFormDetail2 = (PSDEFormDetail)this.getDEModel().createEntity();
            pSDEFormDetail2.setPSDEFormDetailId(pSDEFormDetail.getPSDEFormDetailId());
            pSDEFormDetail2.setLabelPSSysCssId(null);
            this.update(pSDEFormDetail2);
        }
    }

    public void removeByLabelPSSysCss(PSSysCss pSSysCss) throws Exception {
        final PSSysCss pSSysCss2 = pSSysCss;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEFormDetailServiceBase.this.onBeforeRemoveByLabelPSSysCss(pSSysCss2);
                PSDEFormDetailServiceBase.this.internalRemoveByLabelPSSysCss(pSSysCss2);
                PSDEFormDetailServiceBase.this.onAfterRemoveByLabelPSSysCss(pSSysCss2);
            }
        });
    }

    protected void onBeforeRemoveByLabelPSSysCss(PSSysCss pSSysCss) throws Exception {
    }

    protected void internalRemoveByLabelPSSysCss(PSSysCss pSSysCss) throws Exception {
        ArrayList<PSDEFormDetail> arrayList = this.selectByLabelPSSysCss(pSSysCss);
        this.onBeforeRemoveByLabelPSSysCss(pSSysCss, arrayList);
        for (PSDEFormDetail pSDEFormDetail : arrayList) {
            this.remove(pSDEFormDetail);
        }
        this.onAfterRemoveByLabelPSSysCss(pSSysCss, arrayList);
    }

    protected void onAfterRemoveByLabelPSSysCss(PSSysCss pSSysCss) throws Exception {
    }

    protected void onBeforeRemoveByLabelPSSysCss(PSSysCss pSSysCss, ArrayList<PSDEFormDetail> arrayList) throws Exception {
    }

    protected void onAfterRemoveByLabelPSSysCss(PSSysCss pSSysCss, ArrayList<PSDEFormDetail> arrayList) throws Exception {
    }

    public void testRemoveByPSSysCss(PSSysCss pSSysCss) throws Exception {
        ArrayList<PSDEFormDetail> arrayList = this.selectByPSSysCss(pSSysCss, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSCSS");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSSysCss);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEFORMDETAIL_PSSYSCSS_PSSYSCSSID", "", iDataEntityModel.getName(), "PSDEFORMDETAIL", iDataEntityModel.getDataInfo(pSSysCss), arrayList.get(0)));
        }
    }

    public void resetPSSysCss(PSSysCss pSSysCss) throws Exception {
        ArrayList<PSDEFormDetail> arrayList = this.selectByPSSysCss(pSSysCss);
        for (PSDEFormDetail pSDEFormDetail : arrayList) {
            PSDEFormDetail pSDEFormDetail2 = (PSDEFormDetail)this.getDEModel().createEntity();
            pSDEFormDetail2.setPSDEFormDetailId(pSDEFormDetail.getPSDEFormDetailId());
            pSDEFormDetail2.setPSSysCssId(null);
            this.update(pSDEFormDetail2);
        }
    }

    public void removeByPSSysCss(PSSysCss pSSysCss) throws Exception {
        final PSSysCss pSSysCss2 = pSSysCss;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEFormDetailServiceBase.this.onBeforeRemoveByPSSysCss(pSSysCss2);
                PSDEFormDetailServiceBase.this.internalRemoveByPSSysCss(pSSysCss2);
                PSDEFormDetailServiceBase.this.onAfterRemoveByPSSysCss(pSSysCss2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysCss(PSSysCss pSSysCss) throws Exception {
    }

    protected void internalRemoveByPSSysCss(PSSysCss pSSysCss) throws Exception {
        ArrayList<PSDEFormDetail> arrayList = this.selectByPSSysCss(pSSysCss);
        this.onBeforeRemoveByPSSysCss(pSSysCss, arrayList);
        for (PSDEFormDetail pSDEFormDetail : arrayList) {
            this.remove(pSDEFormDetail);
        }
        this.onAfterRemoveByPSSysCss(pSSysCss, arrayList);
    }

    protected void onAfterRemoveByPSSysCss(PSSysCss pSSysCss) throws Exception {
    }

    protected void onBeforeRemoveByPSSysCss(PSSysCss pSSysCss, ArrayList<PSDEFormDetail> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysCss(PSSysCss pSSysCss, ArrayList<PSDEFormDetail> arrayList) throws Exception {
    }

    public void testRemoveByPSSysDictCat(PSSysDictCat pSSysDictCat) throws Exception {
        ArrayList<PSDEFormDetail> arrayList = this.selectByPSSysDictCat(pSSysDictCat, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSDICTCAT");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSSysDictCat);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEFORMDETAIL_PSSYSDICTCAT_PSSYSDICTCATID", "", iDataEntityModel.getName(), "PSDEFORMDETAIL", iDataEntityModel.getDataInfo(pSSysDictCat), arrayList.get(0)));
        }
    }

    public void resetPSSysDictCat(PSSysDictCat pSSysDictCat) throws Exception {
        ArrayList<PSDEFormDetail> arrayList = this.selectByPSSysDictCat(pSSysDictCat);
        for (PSDEFormDetail pSDEFormDetail : arrayList) {
            PSDEFormDetail pSDEFormDetail2 = (PSDEFormDetail)this.getDEModel().createEntity();
            pSDEFormDetail2.setPSDEFormDetailId(pSDEFormDetail.getPSDEFormDetailId());
            pSDEFormDetail2.setPSSysDictCatId(null);
            this.update(pSDEFormDetail2);
        }
    }

    public void removeByPSSysDictCat(PSSysDictCat pSSysDictCat) throws Exception {
        final PSSysDictCat pSSysDictCat2 = pSSysDictCat;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEFormDetailServiceBase.this.onBeforeRemoveByPSSysDictCat(pSSysDictCat2);
                PSDEFormDetailServiceBase.this.internalRemoveByPSSysDictCat(pSSysDictCat2);
                PSDEFormDetailServiceBase.this.onAfterRemoveByPSSysDictCat(pSSysDictCat2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysDictCat(PSSysDictCat pSSysDictCat) throws Exception {
    }

    protected void internalRemoveByPSSysDictCat(PSSysDictCat pSSysDictCat) throws Exception {
        ArrayList<PSDEFormDetail> arrayList = this.selectByPSSysDictCat(pSSysDictCat);
        this.onBeforeRemoveByPSSysDictCat(pSSysDictCat, arrayList);
        for (PSDEFormDetail pSDEFormDetail : arrayList) {
            this.remove(pSDEFormDetail);
        }
        this.onAfterRemoveByPSSysDictCat(pSSysDictCat, arrayList);
    }

    protected void onAfterRemoveByPSSysDictCat(PSSysDictCat pSSysDictCat) throws Exception {
    }

    protected void onBeforeRemoveByPSSysDictCat(PSSysDictCat pSSysDictCat, ArrayList<PSDEFormDetail> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysDictCat(PSSysDictCat pSSysDictCat, ArrayList<PSDEFormDetail> arrayList) throws Exception {
    }

    public void testRemoveByPSSysDynaModel(PSSysDynaModel pSSysDynaModel) throws Exception {
        ArrayList<PSDEFormDetail> arrayList = this.selectByPSSysDynaModel(pSSysDynaModel, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSDYNAMODEL");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSSysDynaModel);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEFORMDETAIL_PSSYSDYNAMODEL_PSSYSDYNAMODELID", "", iDataEntityModel.getName(), "PSDEFORMDETAIL", iDataEntityModel.getDataInfo(pSSysDynaModel), arrayList.get(0)));
        }
    }

    public void resetPSSysDynaModel(PSSysDynaModel pSSysDynaModel) throws Exception {
        ArrayList<PSDEFormDetail> arrayList = this.selectByPSSysDynaModel(pSSysDynaModel);
        for (PSDEFormDetail pSDEFormDetail : arrayList) {
            PSDEFormDetail pSDEFormDetail2 = (PSDEFormDetail)this.getDEModel().createEntity();
            pSDEFormDetail2.setPSDEFormDetailId(pSDEFormDetail.getPSDEFormDetailId());
            pSDEFormDetail2.setPSSysDynaModelId(null);
            this.update(pSDEFormDetail2);
        }
    }

    public void removeByPSSysDynaModel(PSSysDynaModel pSSysDynaModel) throws Exception {
        final PSSysDynaModel pSSysDynaModel2 = pSSysDynaModel;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEFormDetailServiceBase.this.onBeforeRemoveByPSSysDynaModel(pSSysDynaModel2);
                PSDEFormDetailServiceBase.this.internalRemoveByPSSysDynaModel(pSSysDynaModel2);
                PSDEFormDetailServiceBase.this.onAfterRemoveByPSSysDynaModel(pSSysDynaModel2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysDynaModel(PSSysDynaModel pSSysDynaModel) throws Exception {
    }

    protected void internalRemoveByPSSysDynaModel(PSSysDynaModel pSSysDynaModel) throws Exception {
        ArrayList<PSDEFormDetail> arrayList = this.selectByPSSysDynaModel(pSSysDynaModel);
        this.onBeforeRemoveByPSSysDynaModel(pSSysDynaModel, arrayList);
        for (PSDEFormDetail pSDEFormDetail : arrayList) {
            this.remove(pSDEFormDetail);
        }
        this.onAfterRemoveByPSSysDynaModel(pSSysDynaModel, arrayList);
    }

    protected void onAfterRemoveByPSSysDynaModel(PSSysDynaModel pSSysDynaModel) throws Exception {
    }

    protected void onBeforeRemoveByPSSysDynaModel(PSSysDynaModel pSSysDynaModel, ArrayList<PSDEFormDetail> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysDynaModel(PSSysDynaModel pSSysDynaModel, ArrayList<PSDEFormDetail> arrayList) throws Exception {
    }

    public void testRemoveByPSSysEditorStyle(PSSysEditorStyle pSSysEditorStyle) throws Exception {
        ArrayList<PSDEFormDetail> arrayList = this.selectByPSSysEditorStyle(pSSysEditorStyle, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSEDITORSTYLE");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSSysEditorStyle);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEFORMDETAIL_PSSYSEDITORSTYLE_PSSYSEDITORSTYLEID", "", iDataEntityModel.getName(), "PSDEFORMDETAIL", iDataEntityModel.getDataInfo(pSSysEditorStyle), arrayList.get(0)));
        }
    }

    public void resetPSSysEditorStyle(PSSysEditorStyle pSSysEditorStyle) throws Exception {
        ArrayList<PSDEFormDetail> arrayList = this.selectByPSSysEditorStyle(pSSysEditorStyle);
        for (PSDEFormDetail pSDEFormDetail : arrayList) {
            PSDEFormDetail pSDEFormDetail2 = (PSDEFormDetail)this.getDEModel().createEntity();
            pSDEFormDetail2.setPSDEFormDetailId(pSDEFormDetail.getPSDEFormDetailId());
            pSDEFormDetail2.setPSSysEditorStyleId(null);
            this.update(pSDEFormDetail2);
        }
    }

    public void removeByPSSysEditorStyle(PSSysEditorStyle pSSysEditorStyle) throws Exception {
        final PSSysEditorStyle pSSysEditorStyle2 = pSSysEditorStyle;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEFormDetailServiceBase.this.onBeforeRemoveByPSSysEditorStyle(pSSysEditorStyle2);
                PSDEFormDetailServiceBase.this.internalRemoveByPSSysEditorStyle(pSSysEditorStyle2);
                PSDEFormDetailServiceBase.this.onAfterRemoveByPSSysEditorStyle(pSSysEditorStyle2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysEditorStyle(PSSysEditorStyle pSSysEditorStyle) throws Exception {
    }

    protected void internalRemoveByPSSysEditorStyle(PSSysEditorStyle pSSysEditorStyle) throws Exception {
        ArrayList<PSDEFormDetail> arrayList = this.selectByPSSysEditorStyle(pSSysEditorStyle);
        this.onBeforeRemoveByPSSysEditorStyle(pSSysEditorStyle, arrayList);
        for (PSDEFormDetail pSDEFormDetail : arrayList) {
            this.remove(pSDEFormDetail);
        }
        this.onAfterRemoveByPSSysEditorStyle(pSSysEditorStyle, arrayList);
    }

    protected void onAfterRemoveByPSSysEditorStyle(PSSysEditorStyle pSSysEditorStyle) throws Exception {
    }

    protected void onBeforeRemoveByPSSysEditorStyle(PSSysEditorStyle pSSysEditorStyle, ArrayList<PSDEFormDetail> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysEditorStyle(PSSysEditorStyle pSSysEditorStyle, ArrayList<PSDEFormDetail> arrayList) throws Exception {
    }

    public void testRemoveByPSSysImage(PSSysImage pSSysImage) throws Exception {
        ArrayList<PSDEFormDetail> arrayList = this.selectByPSSysImage(pSSysImage, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSIMAGE");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSSysImage);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEFORMDETAIL_PSSYSIMAGE_PSSYSIMAGEID", "", iDataEntityModel.getName(), "PSDEFORMDETAIL", iDataEntityModel.getDataInfo(pSSysImage), arrayList.get(0)));
        }
    }

    public void resetPSSysImage(PSSysImage pSSysImage) throws Exception {
        ArrayList<PSDEFormDetail> arrayList = this.selectByPSSysImage(pSSysImage);
        for (PSDEFormDetail pSDEFormDetail : arrayList) {
            PSDEFormDetail pSDEFormDetail2 = (PSDEFormDetail)this.getDEModel().createEntity();
            pSDEFormDetail2.setPSDEFormDetailId(pSDEFormDetail.getPSDEFormDetailId());
            pSDEFormDetail2.setPSSysImageId(null);
            this.update(pSDEFormDetail2);
        }
    }

    public void removeByPSSysImage(PSSysImage pSSysImage) throws Exception {
        final PSSysImage pSSysImage2 = pSSysImage;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEFormDetailServiceBase.this.onBeforeRemoveByPSSysImage(pSSysImage2);
                PSDEFormDetailServiceBase.this.internalRemoveByPSSysImage(pSSysImage2);
                PSDEFormDetailServiceBase.this.onAfterRemoveByPSSysImage(pSSysImage2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysImage(PSSysImage pSSysImage) throws Exception {
    }

    protected void internalRemoveByPSSysImage(PSSysImage pSSysImage) throws Exception {
        ArrayList<PSDEFormDetail> arrayList = this.selectByPSSysImage(pSSysImage);
        this.onBeforeRemoveByPSSysImage(pSSysImage, arrayList);
        for (PSDEFormDetail pSDEFormDetail : arrayList) {
            this.remove(pSDEFormDetail);
        }
        this.onAfterRemoveByPSSysImage(pSSysImage, arrayList);
    }

    protected void onAfterRemoveByPSSysImage(PSSysImage pSSysImage) throws Exception {
    }

    protected void onBeforeRemoveByPSSysImage(PSSysImage pSSysImage, ArrayList<PSDEFormDetail> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysImage(PSSysImage pSSysImage, ArrayList<PSDEFormDetail> arrayList) throws Exception {
    }

    public void testRemoveByOpenPSSysPDTView(PSSysPDTView pSSysPDTView) throws Exception {
        ArrayList<PSDEFormDetail> arrayList = this.selectByOpenPSSysPDTView(pSSysPDTView, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSPDTVIEW");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSSysPDTView);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEFORMDETAIL_PSSYSPDTVIEW_OPENPSSYSPDTVIEWID", "", iDataEntityModel.getName(), "PSDEFORMDETAIL", iDataEntityModel.getDataInfo(pSSysPDTView), arrayList.get(0)));
        }
    }

    public void resetOpenPSSysPDTView(PSSysPDTView pSSysPDTView) throws Exception {
        ArrayList<PSDEFormDetail> arrayList = this.selectByOpenPSSysPDTView(pSSysPDTView);
        for (PSDEFormDetail pSDEFormDetail : arrayList) {
            PSDEFormDetail pSDEFormDetail2 = (PSDEFormDetail)this.getDEModel().createEntity();
            pSDEFormDetail2.setPSDEFormDetailId(pSDEFormDetail.getPSDEFormDetailId());
            pSDEFormDetail2.setOpenPSSysPDTViewId(null);
            this.update(pSDEFormDetail2);
        }
    }

    public void removeByOpenPSSysPDTView(PSSysPDTView pSSysPDTView) throws Exception {
        final PSSysPDTView pSSysPDTView2 = pSSysPDTView;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEFormDetailServiceBase.this.onBeforeRemoveByOpenPSSysPDTView(pSSysPDTView2);
                PSDEFormDetailServiceBase.this.internalRemoveByOpenPSSysPDTView(pSSysPDTView2);
                PSDEFormDetailServiceBase.this.onAfterRemoveByOpenPSSysPDTView(pSSysPDTView2);
            }
        });
    }

    protected void onBeforeRemoveByOpenPSSysPDTView(PSSysPDTView pSSysPDTView) throws Exception {
    }

    protected void internalRemoveByOpenPSSysPDTView(PSSysPDTView pSSysPDTView) throws Exception {
        ArrayList<PSDEFormDetail> arrayList = this.selectByOpenPSSysPDTView(pSSysPDTView);
        this.onBeforeRemoveByOpenPSSysPDTView(pSSysPDTView, arrayList);
        for (PSDEFormDetail pSDEFormDetail : arrayList) {
            this.remove(pSDEFormDetail);
        }
        this.onAfterRemoveByOpenPSSysPDTView(pSSysPDTView, arrayList);
    }

    protected void onAfterRemoveByOpenPSSysPDTView(PSSysPDTView pSSysPDTView) throws Exception {
    }

    protected void onBeforeRemoveByOpenPSSysPDTView(PSSysPDTView pSSysPDTView, ArrayList<PSDEFormDetail> arrayList) throws Exception {
    }

    protected void onAfterRemoveByOpenPSSysPDTView(PSSysPDTView pSSysPDTView, ArrayList<PSDEFormDetail> arrayList) throws Exception {
    }

    public void testRemoveByUCPSSysPFPlugin(PSSysPFPlugin pSSysPFPlugin) throws Exception {
        ArrayList<PSDEFormDetail> arrayList = this.selectByUCPSSysPFPlugin(pSSysPFPlugin, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSPFPLUGIN");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSSysPFPlugin);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEFORMDETAIL_PSSYSPFPLUGIN_UCPSSYSPFPLUGINID", "", iDataEntityModel.getName(), "PSDEFORMDETAIL", iDataEntityModel.getDataInfo(pSSysPFPlugin), arrayList.get(0)));
        }
    }

    public void resetUCPSSysPFPlugin(PSSysPFPlugin pSSysPFPlugin) throws Exception {
        ArrayList<PSDEFormDetail> arrayList = this.selectByUCPSSysPFPlugin(pSSysPFPlugin);
        for (PSDEFormDetail pSDEFormDetail : arrayList) {
            PSDEFormDetail pSDEFormDetail2 = (PSDEFormDetail)this.getDEModel().createEntity();
            pSDEFormDetail2.setPSDEFormDetailId(pSDEFormDetail.getPSDEFormDetailId());
            pSDEFormDetail2.setUCPSSysPFPluginId(null);
            this.update(pSDEFormDetail2);
        }
    }

    public void removeByUCPSSysPFPlugin(PSSysPFPlugin pSSysPFPlugin) throws Exception {
        final PSSysPFPlugin pSSysPFPlugin2 = pSSysPFPlugin;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEFormDetailServiceBase.this.onBeforeRemoveByUCPSSysPFPlugin(pSSysPFPlugin2);
                PSDEFormDetailServiceBase.this.internalRemoveByUCPSSysPFPlugin(pSSysPFPlugin2);
                PSDEFormDetailServiceBase.this.onAfterRemoveByUCPSSysPFPlugin(pSSysPFPlugin2);
            }
        });
    }

    protected void onBeforeRemoveByUCPSSysPFPlugin(PSSysPFPlugin pSSysPFPlugin) throws Exception {
    }

    protected void internalRemoveByUCPSSysPFPlugin(PSSysPFPlugin pSSysPFPlugin) throws Exception {
        ArrayList<PSDEFormDetail> arrayList = this.selectByUCPSSysPFPlugin(pSSysPFPlugin);
        this.onBeforeRemoveByUCPSSysPFPlugin(pSSysPFPlugin, arrayList);
        for (PSDEFormDetail pSDEFormDetail : arrayList) {
            this.remove(pSDEFormDetail);
        }
        this.onAfterRemoveByUCPSSysPFPlugin(pSSysPFPlugin, arrayList);
    }

    protected void onAfterRemoveByUCPSSysPFPlugin(PSSysPFPlugin pSSysPFPlugin) throws Exception {
    }

    protected void onBeforeRemoveByUCPSSysPFPlugin(PSSysPFPlugin pSSysPFPlugin, ArrayList<PSDEFormDetail> arrayList) throws Exception {
    }

    protected void onAfterRemoveByUCPSSysPFPlugin(PSSysPFPlugin pSSysPFPlugin, ArrayList<PSDEFormDetail> arrayList) throws Exception {
    }

    public void testRemoveByPSSysResource(PSSysResource pSSysResource) throws Exception {
        ArrayList<PSDEFormDetail> arrayList = this.selectByPSSysResource(pSSysResource, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSRESOURCE");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSSysResource);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEFORMDETAIL_PSSYSRESOURCE_PSSYSRESOURCEID", "", iDataEntityModel.getName(), "PSDEFORMDETAIL", iDataEntityModel.getDataInfo(pSSysResource), arrayList.get(0)));
        }
    }

    public void resetPSSysResource(PSSysResource pSSysResource) throws Exception {
        ArrayList<PSDEFormDetail> arrayList = this.selectByPSSysResource(pSSysResource);
        for (PSDEFormDetail pSDEFormDetail : arrayList) {
            PSDEFormDetail pSDEFormDetail2 = (PSDEFormDetail)this.getDEModel().createEntity();
            pSDEFormDetail2.setPSDEFormDetailId(pSDEFormDetail.getPSDEFormDetailId());
            pSDEFormDetail2.setPSSysResourceId(null);
            this.update(pSDEFormDetail2);
        }
    }

    public void removeByPSSysResource(PSSysResource pSSysResource) throws Exception {
        final PSSysResource pSSysResource2 = pSSysResource;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEFormDetailServiceBase.this.onBeforeRemoveByPSSysResource(pSSysResource2);
                PSDEFormDetailServiceBase.this.internalRemoveByPSSysResource(pSSysResource2);
                PSDEFormDetailServiceBase.this.onAfterRemoveByPSSysResource(pSSysResource2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysResource(PSSysResource pSSysResource) throws Exception {
    }

    protected void internalRemoveByPSSysResource(PSSysResource pSSysResource) throws Exception {
        ArrayList<PSDEFormDetail> arrayList = this.selectByPSSysResource(pSSysResource);
        this.onBeforeRemoveByPSSysResource(pSSysResource, arrayList);
        for (PSDEFormDetail pSDEFormDetail : arrayList) {
            this.remove(pSDEFormDetail);
        }
        this.onAfterRemoveByPSSysResource(pSSysResource, arrayList);
    }

    protected void onAfterRemoveByPSSysResource(PSSysResource pSSysResource) throws Exception {
    }

    protected void onBeforeRemoveByPSSysResource(PSSysResource pSSysResource, ArrayList<PSDEFormDetail> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysResource(PSSysResource pSSysResource, ArrayList<PSDEFormDetail> arrayList) throws Exception {
    }

    public void testRemoveByMDPSSysViewPanel(PSSysViewPanel pSSysViewPanel) throws Exception {
        ArrayList<PSDEFormDetail> arrayList = this.selectByMDPSSysViewPanel(pSSysViewPanel, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSVIEWPANEL");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSSysViewPanel);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEFORMDETAIL_PSSYSVIEWPANEL_MDPSSYSVIEWPANELID", "", iDataEntityModel.getName(), "PSDEFORMDETAIL", iDataEntityModel.getDataInfo(pSSysViewPanel), arrayList.get(0)));
        }
    }

    public void resetMDPSSysViewPanel(PSSysViewPanel pSSysViewPanel) throws Exception {
        ArrayList<PSDEFormDetail> arrayList = this.selectByMDPSSysViewPanel(pSSysViewPanel);
        for (PSDEFormDetail pSDEFormDetail : arrayList) {
            PSDEFormDetail pSDEFormDetail2 = (PSDEFormDetail)this.getDEModel().createEntity();
            pSDEFormDetail2.setPSDEFormDetailId(pSDEFormDetail.getPSDEFormDetailId());
            pSDEFormDetail2.setMDPSSysViewPanelId(null);
            this.update(pSDEFormDetail2);
        }
    }

    public void removeByMDPSSysViewPanel(PSSysViewPanel pSSysViewPanel) throws Exception {
        final PSSysViewPanel pSSysViewPanel2 = pSSysViewPanel;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEFormDetailServiceBase.this.onBeforeRemoveByMDPSSysViewPanel(pSSysViewPanel2);
                PSDEFormDetailServiceBase.this.internalRemoveByMDPSSysViewPanel(pSSysViewPanel2);
                PSDEFormDetailServiceBase.this.onAfterRemoveByMDPSSysViewPanel(pSSysViewPanel2);
            }
        });
    }

    protected void onBeforeRemoveByMDPSSysViewPanel(PSSysViewPanel pSSysViewPanel) throws Exception {
    }

    protected void internalRemoveByMDPSSysViewPanel(PSSysViewPanel pSSysViewPanel) throws Exception {
        ArrayList<PSDEFormDetail> arrayList = this.selectByMDPSSysViewPanel(pSSysViewPanel);
        this.onBeforeRemoveByMDPSSysViewPanel(pSSysViewPanel, arrayList);
        for (PSDEFormDetail pSDEFormDetail : arrayList) {
            this.remove(pSDEFormDetail);
        }
        this.onAfterRemoveByMDPSSysViewPanel(pSSysViewPanel, arrayList);
    }

    protected void onAfterRemoveByMDPSSysViewPanel(PSSysViewPanel pSSysViewPanel) throws Exception {
    }

    protected void onBeforeRemoveByMDPSSysViewPanel(PSSysViewPanel pSSysViewPanel, ArrayList<PSDEFormDetail> arrayList) throws Exception {
    }

    protected void onAfterRemoveByMDPSSysViewPanel(PSSysViewPanel pSSysViewPanel, ArrayList<PSDEFormDetail> arrayList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(PSDEFormDetail pSDEFormDetail) throws Exception {
        PSCoreSysServiceBase pSCoreSysServiceBase = (PSDEFDLogicService)ServiceGlobal.getService(PSDEFDLogicService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEFDLogicServiceBase)pSCoreSysServiceBase).testRemoveByPSDEFormDetail(pSDEFormDetail);
        ((PSDEFDLogicServiceBase)pSCoreSysServiceBase).removeByPSDEFormDetail(pSDEFormDetail);
        pSCoreSysServiceBase = (PSDEFIUDetailService)ServiceGlobal.getService(PSDEFIUDetailService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEFIUDetailServiceBase)pSCoreSysServiceBase).testRemoveByPSDEFormDetail(pSDEFormDetail);
        pSCoreSysServiceBase = (PSDEFIVRService)ServiceGlobal.getService(PSDEFIVRService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEFIVRServiceBase)pSCoreSysServiceBase).testRemoveByPSDEFI(pSDEFormDetail);
        ((PSDEFIVRServiceBase)pSCoreSysServiceBase).removeByPSDEFI(pSDEFormDetail);
        pSCoreSysServiceBase = (PSDEFormDetailService)ServiceGlobal.getService(PSDEFormDetailService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEFormDetailServiceBase)pSCoreSysServiceBase).testRemoveByPPSDEFormDetail(pSDEFormDetail);
        ((PSDEFormDetailServiceBase)pSCoreSysServiceBase).resetPPSDEFormDetail(pSDEFormDetail);
        pSCoreSysServiceBase = (PSDEFormDetailService)ServiceGlobal.getService(PSDEFormDetailService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEFormDetailServiceBase)pSCoreSysServiceBase).testRemoveByRefPSDEFormDetail(pSDEFormDetail);
        pSCoreSysServiceBase = (PSDEFormLogicService)ServiceGlobal.getService(PSDEFormLogicService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEFormLogicServiceBase)pSCoreSysServiceBase).testRemoveByPSDEFormDetail(pSDEFormDetail);
        super.onBeforeRemove(pSDEFormDetail);
    }

    protected void onBeforeRemoveTemp(PSDEFormDetail pSDEFormDetail) throws Exception {
        PSCoreSysServiceBase pSCoreSysServiceBase = (PSDEFormDetailService)ServiceGlobal.getService(PSDEFormDetailService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEFormDetailServiceBase)pSCoreSysServiceBase).removeTempByPPSDEFormDetail(pSDEFormDetail);
        pSCoreSysServiceBase = (PSDEFDLogicService)ServiceGlobal.getService(PSDEFDLogicService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEFDLogicServiceBase)pSCoreSysServiceBase).removeTempByPSDEFormDetail(pSDEFormDetail);
        pSCoreSysServiceBase = (PSDEFormLogicService)ServiceGlobal.getService(PSDEFormLogicService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEFormLogicServiceBase)pSCoreSysServiceBase).resetTempPSDEFormDetail(pSDEFormDetail);
        pSCoreSysServiceBase = (PSDEFormDetailService)ServiceGlobal.getService(PSDEFormDetailService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEFormDetailServiceBase)pSCoreSysServiceBase).resetTempRefPSDEFormDetail(pSDEFormDetail);
        pSCoreSysServiceBase = (PSDEFIVRService)ServiceGlobal.getService(PSDEFIVRService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEFIVRServiceBase)pSCoreSysServiceBase).resetTempPSDEFI(pSDEFormDetail);
        pSCoreSysServiceBase = (PSDEFIUDetailService)ServiceGlobal.getService(PSDEFIUDetailService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEFIUDetailServiceBase)pSCoreSysServiceBase).resetTempPSDEFormDetail(pSDEFormDetail);
        super.onBeforeRemoveTemp(pSDEFormDetail);
    }

    public void removeTempByPSDEFIUpdate(PSDEFIUpdate pSDEFIUpdate) throws Exception {
        final PSDEFIUpdate pSDEFIUpdate2 = pSDEFIUpdate;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEFormDetailServiceBase.this.onBeforeRemoveTempByPSDEFIUpdate(pSDEFIUpdate2);
                PSDEFormDetailServiceBase.this.internalRemoveTempByPSDEFIUpdate(pSDEFIUpdate2);
                PSDEFormDetailServiceBase.this.onAfterRemoveTempByPSDEFIUpdate(pSDEFIUpdate2);
            }
        });
    }

    protected void onBeforeRemoveTempByPSDEFIUpdate(PSDEFIUpdate pSDEFIUpdate) throws Exception {
    }

    protected void internalRemoveTempByPSDEFIUpdate(PSDEFIUpdate pSDEFIUpdate) throws Exception {
        ArrayList<PSDEFormDetail> arrayList = this.selectTempByPSDEFIUpdate(pSDEFIUpdate);
        this.onBeforeRemoveTempByPSDEFIUpdate(pSDEFIUpdate, arrayList);
        for (PSDEFormDetail pSDEFormDetail : arrayList) {
            this.removeTemp(pSDEFormDetail);
        }
        this.onAfterRemoveTempByPSDEFIUpdate(pSDEFIUpdate, arrayList);
    }

    protected void onAfterRemoveTempByPSDEFIUpdate(PSDEFIUpdate pSDEFIUpdate) throws Exception {
    }

    protected void onBeforeRemoveTempByPSDEFIUpdate(PSDEFIUpdate pSDEFIUpdate, ArrayList<PSDEFormDetail> arrayList) throws Exception {
    }

    protected void onAfterRemoveTempByPSDEFIUpdate(PSDEFIUpdate pSDEFIUpdate, ArrayList<PSDEFormDetail> arrayList) throws Exception {
    }

    public void removeTempByRefPSDEFormDetail(PSDEFormDetail pSDEFormDetail) throws Exception {
        final PSDEFormDetail pSDEFormDetail2 = pSDEFormDetail;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEFormDetailServiceBase.this.onBeforeRemoveTempByRefPSDEFormDetail(pSDEFormDetail2);
                PSDEFormDetailServiceBase.this.internalRemoveTempByRefPSDEFormDetail(pSDEFormDetail2);
                PSDEFormDetailServiceBase.this.onAfterRemoveTempByRefPSDEFormDetail(pSDEFormDetail2);
            }
        });
    }

    protected void onBeforeRemoveTempByRefPSDEFormDetail(PSDEFormDetail pSDEFormDetail) throws Exception {
    }

    protected void internalRemoveTempByRefPSDEFormDetail(PSDEFormDetail pSDEFormDetail) throws Exception {
        ArrayList<PSDEFormDetail> arrayList = this.selectTempByRefPSDEFormDetail(pSDEFormDetail);
        this.onBeforeRemoveTempByRefPSDEFormDetail(pSDEFormDetail, arrayList);
        for (PSDEFormDetail pSDEFormDetail2 : arrayList) {
            this.removeTemp(pSDEFormDetail2);
        }
        this.onAfterRemoveTempByRefPSDEFormDetail(pSDEFormDetail, arrayList);
    }

    protected void onAfterRemoveTempByRefPSDEFormDetail(PSDEFormDetail pSDEFormDetail) throws Exception {
    }

    protected void onBeforeRemoveTempByRefPSDEFormDetail(PSDEFormDetail pSDEFormDetail, ArrayList<PSDEFormDetail> arrayList) throws Exception {
    }

    protected void onAfterRemoveTempByRefPSDEFormDetail(PSDEFormDetail pSDEFormDetail, ArrayList<PSDEFormDetail> arrayList) throws Exception {
    }

    public void removeTempByPSDEFormRF(PSDEFormRF pSDEFormRF) throws Exception {
        final PSDEFormRF pSDEFormRF2 = pSDEFormRF;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEFormDetailServiceBase.this.onBeforeRemoveTempByPSDEFormRF(pSDEFormRF2);
                PSDEFormDetailServiceBase.this.internalRemoveTempByPSDEFormRF(pSDEFormRF2);
                PSDEFormDetailServiceBase.this.onAfterRemoveTempByPSDEFormRF(pSDEFormRF2);
            }
        });
    }

    protected void onBeforeRemoveTempByPSDEFormRF(PSDEFormRF pSDEFormRF) throws Exception {
    }

    protected void internalRemoveTempByPSDEFormRF(PSDEFormRF pSDEFormRF) throws Exception {
        ArrayList<PSDEFormDetail> arrayList = this.selectTempByPSDEFormRF(pSDEFormRF);
        this.onBeforeRemoveTempByPSDEFormRF(pSDEFormRF, arrayList);
        for (PSDEFormDetail pSDEFormDetail : arrayList) {
            this.removeTemp(pSDEFormDetail);
        }
        this.onAfterRemoveTempByPSDEFormRF(pSDEFormRF, arrayList);
    }

    protected void onAfterRemoveTempByPSDEFormRF(PSDEFormRF pSDEFormRF) throws Exception {
    }

    protected void onBeforeRemoveTempByPSDEFormRF(PSDEFormRF pSDEFormRF, ArrayList<PSDEFormDetail> arrayList) throws Exception {
    }

    protected void onAfterRemoveTempByPSDEFormRF(PSDEFormRF pSDEFormRF, ArrayList<PSDEFormDetail> arrayList) throws Exception {
    }

    public void removeTempByPPSDEFormDetail(PSDEFormDetail pSDEFormDetail) throws Exception {
        final PSDEFormDetail pSDEFormDetail2 = pSDEFormDetail;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEFormDetailServiceBase.this.onBeforeRemoveTempByPPSDEFormDetail(pSDEFormDetail2);
                PSDEFormDetailServiceBase.this.internalRemoveTempByPPSDEFormDetail(pSDEFormDetail2);
                PSDEFormDetailServiceBase.this.onAfterRemoveTempByPPSDEFormDetail(pSDEFormDetail2);
            }
        });
    }

    protected void onBeforeRemoveTempByPPSDEFormDetail(PSDEFormDetail pSDEFormDetail) throws Exception {
    }

    protected void internalRemoveTempByPPSDEFormDetail(PSDEFormDetail pSDEFormDetail) throws Exception {
        ArrayList<PSDEFormDetail> arrayList = this.selectTempByPPSDEFormDetail(pSDEFormDetail);
        this.onBeforeRemoveTempByPPSDEFormDetail(pSDEFormDetail, arrayList);
        for (PSDEFormDetail pSDEFormDetail2 : arrayList) {
            this.removeTemp(pSDEFormDetail2);
        }
        this.onAfterRemoveTempByPPSDEFormDetail(pSDEFormDetail, arrayList);
    }

    protected void onAfterRemoveTempByPPSDEFormDetail(PSDEFormDetail pSDEFormDetail) throws Exception {
    }

    protected void onBeforeRemoveTempByPPSDEFormDetail(PSDEFormDetail pSDEFormDetail, ArrayList<PSDEFormDetail> arrayList) throws Exception {
    }

    protected void onAfterRemoveTempByPPSDEFormDetail(PSDEFormDetail pSDEFormDetail, ArrayList<PSDEFormDetail> arrayList) throws Exception {
    }

    public void removeTempByPSDEForm(PSDEForm pSDEForm) throws Exception {
        final PSDEForm pSDEForm2 = pSDEForm;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEFormDetailServiceBase.this.onBeforeRemoveTempByPSDEForm(pSDEForm2);
                PSDEFormDetailServiceBase.this.internalRemoveTempByPSDEForm(pSDEForm2);
                PSDEFormDetailServiceBase.this.onAfterRemoveTempByPSDEForm(pSDEForm2);
            }
        });
    }

    protected void onBeforeRemoveTempByPSDEForm(PSDEForm pSDEForm) throws Exception {
    }

    protected void internalRemoveTempByPSDEForm(PSDEForm pSDEForm) throws Exception {
        ArrayList<PSDEFormDetail> arrayList = this.selectTempByPSDEForm(pSDEForm);
        this.onBeforeRemoveTempByPSDEForm(pSDEForm, arrayList);
        for (PSDEFormDetail pSDEFormDetail : arrayList) {
            this.removeTemp(pSDEFormDetail);
        }
        this.onAfterRemoveTempByPSDEForm(pSDEForm, arrayList);
    }

    protected void onAfterRemoveTempByPSDEForm(PSDEForm pSDEForm) throws Exception {
    }

    protected void onBeforeRemoveTempByPSDEForm(PSDEForm pSDEForm, ArrayList<PSDEFormDetail> arrayList) throws Exception {
    }

    protected void onAfterRemoveTempByPSDEForm(PSDEForm pSDEForm, ArrayList<PSDEFormDetail> arrayList) throws Exception {
    }

    protected void getRelatedDataTempMajor(PSDEFormDetail pSDEFormDetail) throws Exception {
        this.getRelatedDataTempMajor_PSDEFDLogic(pSDEFormDetail);
        this.getRelatedDataTempMajor_PSDEFormDetail(pSDEFormDetail);
        super.getRelatedDataTempMajor(pSDEFormDetail);
    }

    protected void getRelatedDataTempMajor_PSDEFDLogic(PSDEFormDetail pSDEFormDetail) throws Exception {
        PSDEFDLogicService pSDEFDLogicService = (PSDEFDLogicService)ServiceGlobal.getService(PSDEFDLogicService.class, (SessionFactory)this.getSessionFactory());
        ArrayList<PSDEFDLogic> arrayList = null;
        String string = pSDEFormDetail.getPSDEFormDetailId();
        arrayList = string.indexOf("SRFTEMPKEY:") != 0 ? pSDEFDLogicService.selectByPSDEFormDetail(pSDEFormDetail) : pSDEFDLogicService.selectTempByPSDEFormDetail(pSDEFormDetail);
        PSDEFormDetailServiceBase.sortHierarchyEntities(arrayList, (String)"PSDEFDLOGICID", (String)"PPSDEFDLOGICID");
        for (PSDEFDLogic pSDEFDLogic : arrayList) {
            pSDEFDLogicService.getTempMajor(pSDEFDLogic);
        }
    }

    protected void getRelatedDataTempMajor_PSDEFormDetail(PSDEFormDetail pSDEFormDetail) throws Exception {
        PSDEFormDetailService pSDEFormDetailService = (PSDEFormDetailService)ServiceGlobal.getService(PSDEFormDetailService.class, (SessionFactory)this.getSessionFactory());
        ArrayList<PSDEFormDetail> arrayList = null;
        String string = pSDEFormDetail.getPSDEFormDetailId();
        arrayList = string.indexOf("SRFTEMPKEY:") != 0 ? pSDEFormDetailService.selectByPPSDEFormDetail(pSDEFormDetail) : pSDEFormDetailService.selectTempByPPSDEFormDetail(pSDEFormDetail);
        PSDEFormDetailServiceBase.sortHierarchyEntities(arrayList, (String)"PSDEFORMDETAILID", (String)"PPSDEFORMDETAILID");
        for (PSDEFormDetail pSDEFormDetail2 : arrayList) {
            pSDEFormDetailService.getTempMajor(pSDEFormDetail2);
        }
    }

    protected void updateRelatedDataTempMajor(PSDEFormDetail pSDEFormDetail, PSDEFormDetail pSDEFormDetail2) throws Exception {
        ArrayList<PSDEFormDetail> arrayList = this.updateRelatedDataTempMajor_removePSDEFormDetail(pSDEFormDetail, pSDEFormDetail2);
        ArrayList<PSDEFDLogic> arrayList2 = this.updateRelatedDataTempMajor_removePSDEFDLogic(pSDEFormDetail, pSDEFormDetail2);
        this.updateRelatedDataTempMajor_updatePSDEFDLogic(pSDEFormDetail, pSDEFormDetail2, arrayList2);
        this.updateRelatedDataTempMajor_updatePSDEFormDetail(pSDEFormDetail, pSDEFormDetail2, arrayList);
        super.updateRelatedDataTempMajor(pSDEFormDetail, pSDEFormDetail2);
    }

    protected ArrayList<PSDEFDLogic> updateRelatedDataTempMajor_removePSDEFDLogic(PSDEFormDetail pSDEFormDetail, PSDEFormDetail pSDEFormDetail2) throws Exception {
        PSDEFDLogicService pSDEFDLogicService = (PSDEFDLogicService)ServiceGlobal.getService(PSDEFDLogicService.class, (SessionFactory)this.getSessionFactory());
        ArrayList<PSDEFDLogic> arrayList = pSDEFDLogicService.selectTempByPSDEFormDetail(pSDEFormDetail);
        ArrayList<PSDEFDLogic> arrayList2 = pSDEFDLogicService.selectByPSDEFormDetail(pSDEFormDetail2);
        HashMap<String, PSDEFDLogic> hashMap = new HashMap<String, PSDEFDLogic>();
        for (PSDEFDLogic pSDEFDLogic : arrayList2) {
            hashMap.put(pSDEFDLogic.getPSDEFDLogicId(), pSDEFDLogic);
        }
        PSDEFormDetailServiceBase.sortHierarchyEntities(arrayList, (String)"PSDEFDLOGICID", (String)"PPSDEFDLOGICID");
        for (PSDEFDLogic pSDEFDLogic : arrayList) {
            Object object = pSDEFDLogic.get("SRFORIKEY");
            hashMap.remove(object);
        }
        for (PSDEFDLogic pSDEFDLogic : hashMap.values()) {
            pSDEFDLogicService.remove(pSDEFDLogic);
        }
        return arrayList;
    }

    protected void updateRelatedDataTempMajor_updatePSDEFDLogic(PSDEFormDetail pSDEFormDetail, PSDEFormDetail pSDEFormDetail2, ArrayList<PSDEFDLogic> arrayList) throws Exception {
        if (arrayList == null) {
            return;
        }
        PSDEFDLogicService pSDEFDLogicService = (PSDEFDLogicService)ServiceGlobal.getService(PSDEFDLogicService.class, (SessionFactory)this.getSessionFactory());
        for (PSDEFDLogic pSDEFDLogic : arrayList) {
            pSDEFDLogicService.updateTempMajor(pSDEFDLogic);
        }
    }

    protected ArrayList<PSDEFormDetail> updateRelatedDataTempMajor_removePSDEFormDetail(PSDEFormDetail pSDEFormDetail, PSDEFormDetail pSDEFormDetail2) throws Exception {
        PSDEFormDetailService pSDEFormDetailService = (PSDEFormDetailService)ServiceGlobal.getService(PSDEFormDetailService.class, (SessionFactory)this.getSessionFactory());
        ArrayList<PSDEFormDetail> arrayList = pSDEFormDetailService.selectTempByPPSDEFormDetail(pSDEFormDetail);
        ArrayList<PSDEFormDetail> arrayList2 = pSDEFormDetailService.selectByPPSDEFormDetail(pSDEFormDetail2);
        HashMap<String, PSDEFormDetail> hashMap = new HashMap<String, PSDEFormDetail>();
        for (PSDEFormDetail pSDEFormDetail3 : arrayList2) {
            hashMap.put(pSDEFormDetail3.getPSDEFormDetailId(), pSDEFormDetail3);
        }
        PSDEFormDetailServiceBase.sortHierarchyEntities(arrayList, (String)"PSDEFORMDETAILID", (String)"PPSDEFORMDETAILID");
        for (PSDEFormDetail pSDEFormDetail3 : arrayList) {
            Object object = pSDEFormDetail3.get("SRFORIKEY");
            hashMap.remove(object);
        }
        for (PSDEFormDetail pSDEFormDetail3 : hashMap.values()) {
            pSDEFormDetailService.remove(pSDEFormDetail3);
        }
        return arrayList;
    }

    protected void updateRelatedDataTempMajor_updatePSDEFormDetail(PSDEFormDetail pSDEFormDetail, PSDEFormDetail pSDEFormDetail2, ArrayList<PSDEFormDetail> arrayList) throws Exception {
        if (arrayList == null) {
            return;
        }
        PSDEFormDetailService pSDEFormDetailService = (PSDEFormDetailService)ServiceGlobal.getService(PSDEFormDetailService.class, (SessionFactory)this.getSessionFactory());
        for (PSDEFormDetail pSDEFormDetail3 : arrayList) {
            pSDEFormDetailService.updateTempMajor(pSDEFormDetail3);
        }
    }

    protected void replaceParentInfo(PSDEFormDetail pSDEFormDetail, CloneSession cloneSession) throws Exception {
        IEntity iEntity;
        super.replaceParentInfo(pSDEFormDetail, cloneSession);
        if (pSDEFormDetail.getItemPSACHandlerId() != null && (iEntity = cloneSession.getEntity("PSACHANDLER", (Object)pSDEFormDetail.getItemPSACHandlerId())) != null) {
            this.onFillParentInfo_ItemPSACHandler(pSDEFormDetail, (PSACHandler)iEntity);
        }
        if (pSDEFormDetail.getPSCodeListId() != null && (iEntity = cloneSession.getEntity("PSCODELIST", (Object)pSDEFormDetail.getPSCodeListId())) != null) {
            this.onFillParentInfo_PSCodeList(pSDEFormDetail, (PSCodeList)iEntity);
        }
        if (pSDEFormDetail.getRefPSDEId() != null && (iEntity = cloneSession.getEntity("PSDATAENTITY", (Object)pSDEFormDetail.getRefPSDEId())) != null) {
            this.onFillParentInfo_RefPSDE(pSDEFormDetail, (PSDataEntity)iEntity);
        }
        if (pSDEFormDetail.getRefPSDEACModeId() != null && (iEntity = cloneSession.getEntity("PSDEACMODE", (Object)pSDEFormDetail.getRefPSDEACModeId())) != null) {
            this.onFillParentInfo_RefPSDEACMode(pSDEFormDetail, (PSDEACMode)iEntity);
        }
        if (pSDEFormDetail.getPSDEDRId() != null && (iEntity = cloneSession.getEntity("PSDEDATARELATION", (Object)pSDEFormDetail.getPSDEDRId())) != null) {
            this.onFillParentInfo_PSDEDR(pSDEFormDetail, (PSDEDataRelation)iEntity);
        }
        if (pSDEFormDetail.getRefPSDEDataSetId() != null && (iEntity = cloneSession.getEntity("PSDEDATASET", (Object)pSDEFormDetail.getRefPSDEDataSetId())) != null) {
            this.onFillParentInfo_RefPSDEDataSet(pSDEFormDetail, (PSDEDataSet)iEntity);
        }
        if (pSDEFormDetail.getMDPSDEDataViewId() != null && (iEntity = cloneSession.getEntity("PSDEDATAVIEW", (Object)pSDEFormDetail.getMDPSDEDataViewId())) != null) {
            this.onFillParentInfo_MDPSDEDataView(pSDEFormDetail, (PSDEDataView)iEntity);
        }
        if (pSDEFormDetail.getPSDEDRItemId() != null && (iEntity = cloneSession.getEntity("PSDEDRITEM", (Object)pSDEFormDetail.getPSDEDRItemId())) != null) {
            this.onFillParentInfo_PSDEDRItem(pSDEFormDetail, (PSDEDRItem)iEntity);
        }
        if (pSDEFormDetail.getPSDEFUIModeId() != null && (iEntity = cloneSession.getEntity("PSDEFFORMITEM", (Object)pSDEFormDetail.getPSDEFUIModeId())) != null) {
            this.onFillParentInfo_PSDEFUIMode(pSDEFormDetail, (PSDEFUIMode)iEntity);
        }
        if (pSDEFormDetail.getPSDEFId() != null && (iEntity = cloneSession.getEntity("PSDEFIELD", (Object)pSDEFormDetail.getPSDEFId())) != null) {
            this.onFillParentInfo_PSDEF(pSDEFormDetail, (PSDEField)iEntity);
        }
        if (pSDEFormDetail.getPSDEFIUpdateId() != null && (iEntity = cloneSession.getEntity("PSDEFIUPDATE", (Object)pSDEFormDetail.getPSDEFIUpdateId())) != null) {
            this.onFillParentInfo_PSDEFIUpdate(pSDEFormDetail, (PSDEFIUpdate)iEntity);
        }
        if (pSDEFormDetail.getPPSDEFormDetailId() != null && (iEntity = cloneSession.getEntity("PSDEFORMDETAIL", (Object)pSDEFormDetail.getPPSDEFormDetailId())) != null) {
            this.onFillParentInfo_PPSDEFormDetail(pSDEFormDetail, (PSDEFormDetail)iEntity);
        }
        if (pSDEFormDetail.getRefPSDEFormDetailId() != null && (iEntity = cloneSession.getEntity("PSDEFORMDETAIL", (Object)pSDEFormDetail.getRefPSDEFormDetailId())) != null) {
            this.onFillParentInfo_RefPSDEFormDetail(pSDEFormDetail, (PSDEFormDetail)iEntity);
        }
        if (pSDEFormDetail.getPSDEFormRFId() != null && (iEntity = cloneSession.getEntity("PSDEFORMRF", (Object)pSDEFormDetail.getPSDEFormRFId())) != null) {
            this.onFillParentInfo_PSDEFormRF(pSDEFormDetail, (PSDEFormRF)iEntity);
        }
        if (pSDEFormDetail.getMDPSDEFormId() != null && (iEntity = cloneSession.getEntity("PSDEFORM", (Object)pSDEFormDetail.getMDPSDEFormId())) != null) {
            this.onFillParentInfo_MDPSDEForm(pSDEFormDetail, (PSDEForm)iEntity);
        }
        if (pSDEFormDetail.getPSDEFormId() != null && (iEntity = cloneSession.getEntity("PSDEFORM", (Object)pSDEFormDetail.getPSDEFormId())) != null) {
            this.onFillParentInfo_PSDEForm(pSDEFormDetail, (PSDEForm)iEntity);
        }
        if (pSDEFormDetail.getPSDEFSFItemId() != null && (iEntity = cloneSession.getEntity("PSDEFSFITEM", (Object)pSDEFormDetail.getPSDEFSFItemId())) != null) {
            this.onFillParentInfo_PSDEFSFItem(pSDEFormDetail, (PSDEFSFItem)iEntity);
        }
        if (pSDEFormDetail.getMDPSDEGridId() != null && (iEntity = cloneSession.getEntity("PSDEGRID", (Object)pSDEFormDetail.getMDPSDEGridId())) != null) {
            this.onFillParentInfo_MDPSDEGrid(pSDEFormDetail, (PSDEGrid)iEntity);
        }
        if (pSDEFormDetail.getMDPSDEListId() != null && (iEntity = cloneSession.getEntity("PSDELIST", (Object)pSDEFormDetail.getMDPSDEListId())) != null) {
            this.onFillParentInfo_MDPSDEList(pSDEFormDetail, (PSDEList)iEntity);
        }
        if (pSDEFormDetail.getPSDELogicId() != null && (iEntity = cloneSession.getEntity("PSDELOGIC", (Object)pSDEFormDetail.getPSDELogicId())) != null) {
            this.onFillParentInfo_PSDELogic(pSDEFormDetail, (PSDELogic)iEntity);
        }
        if (pSDEFormDetail.getRefPSDERId() != null && (iEntity = cloneSession.getEntity("PSDER", (Object)pSDEFormDetail.getRefPSDERId())) != null) {
            this.onFillParentInfo_RefPSDER(pSDEFormDetail, (PSDER)iEntity);
        }
        if (pSDEFormDetail.getPSDEUAGroupId() != null && (iEntity = cloneSession.getEntity("PSDEUAGROUP", (Object)pSDEFormDetail.getPSDEUAGroupId())) != null) {
            this.onFillParentInfo_PSDEUAGroup(pSDEFormDetail, (PSDEUAGroup)iEntity);
        }
        if (pSDEFormDetail.getPSDEUIActionId() != null && (iEntity = cloneSession.getEntity("PSDEUIACTION", (Object)pSDEFormDetail.getPSDEUIActionId())) != null) {
            this.onFillParentInfo_PSDEUIAction(pSDEFormDetail, (PSDEUIAction)iEntity);
        }
        if (pSDEFormDetail.getLinkPSDEViewId() != null && (iEntity = cloneSession.getEntity("PSDEVIEWBASE", (Object)pSDEFormDetail.getLinkPSDEViewId())) != null) {
            this.onFillParentInfo_LinkPSDEView(pSDEFormDetail, (PSDEViewBase)iEntity);
        }
        if (pSDEFormDetail.getOpenPSDEViewId() != null && (iEntity = cloneSession.getEntity("PSDEVIEWBASE", (Object)pSDEFormDetail.getOpenPSDEViewId())) != null) {
            this.onFillParentInfo_OpenPSDEView(pSDEFormDetail, (PSDEViewBase)iEntity);
        }
        if (pSDEFormDetail.getPickupPSDEViewId() != null && (iEntity = cloneSession.getEntity("PSDEVIEWBASE", (Object)pSDEFormDetail.getPickupPSDEViewId())) != null) {
            this.onFillParentInfo_PickupPSDEView(pSDEFormDetail, (PSDEViewBase)iEntity);
        }
        if (pSDEFormDetail.getCapPSLanResId() != null && (iEntity = cloneSession.getEntity("PSLANGUAGERES", (Object)pSDEFormDetail.getCapPSLanResId())) != null) {
            this.onFillParentInfo_CapPSLanRes(pSDEFormDetail, (PSLanguageRes)iEntity);
        }
        if (pSDEFormDetail.getMaskPSLanResId() != null && (iEntity = cloneSession.getEntity("PSLANGUAGERES", (Object)pSDEFormDetail.getMaskPSLanResId())) != null) {
            this.onFillParentInfo_MaskPSLanRes(pSDEFormDetail, (PSLanguageRes)iEntity);
        }
        if (pSDEFormDetail.getPHPSLanResId() != null && (iEntity = cloneSession.getEntity("PSLANGUAGERES", (Object)pSDEFormDetail.getPHPSLanResId())) != null) {
            this.onFillParentInfo_PHPSLanRes(pSDEFormDetail, (PSLanguageRes)iEntity);
        }
        if (pSDEFormDetail.getTipPSLanResId() != null && (iEntity = cloneSession.getEntity("PSLANGUAGERES", (Object)pSDEFormDetail.getTipPSLanResId())) != null) {
            this.onFillParentInfo_TipPSLanRes(pSDEFormDetail, (PSLanguageRes)iEntity);
        }
        if (pSDEFormDetail.getPSSysCounterId() != null && (iEntity = cloneSession.getEntity("PSSYSCOUNTER", (Object)pSDEFormDetail.getPSSysCounterId())) != null) {
            this.onFillParentInfo_PSSysCounter(pSDEFormDetail, (PSSysCounter)iEntity);
        }
        if (pSDEFormDetail.getCtrlPSSysCssId() != null && (iEntity = cloneSession.getEntity("PSSYSCSS", (Object)pSDEFormDetail.getCtrlPSSysCssId())) != null) {
            this.onFillParentInfo_CtrlPSSysCss(pSDEFormDetail, (PSSysCss)iEntity);
        }
        if (pSDEFormDetail.getLabelPSSysCssId() != null && (iEntity = cloneSession.getEntity("PSSYSCSS", (Object)pSDEFormDetail.getLabelPSSysCssId())) != null) {
            this.onFillParentInfo_LabelPSSysCss(pSDEFormDetail, (PSSysCss)iEntity);
        }
        if (pSDEFormDetail.getPSSysCssId() != null && (iEntity = cloneSession.getEntity("PSSYSCSS", (Object)pSDEFormDetail.getPSSysCssId())) != null) {
            this.onFillParentInfo_PSSysCss(pSDEFormDetail, (PSSysCss)iEntity);
        }
        if (pSDEFormDetail.getPSSysDictCatId() != null && (iEntity = cloneSession.getEntity("PSSYSDICTCAT", (Object)pSDEFormDetail.getPSSysDictCatId())) != null) {
            this.onFillParentInfo_PSSysDictCat(pSDEFormDetail, (PSSysDictCat)iEntity);
        }
        if (pSDEFormDetail.getPSSysDynaModelId() != null && (iEntity = cloneSession.getEntity("PSSYSDYNAMODEL", (Object)pSDEFormDetail.getPSSysDynaModelId())) != null) {
            this.onFillParentInfo_PSSysDynaModel(pSDEFormDetail, (PSSysDynaModel)iEntity);
        }
        if (pSDEFormDetail.getPSSysEditorStyleId() != null && (iEntity = cloneSession.getEntity("PSSYSEDITORSTYLE", (Object)pSDEFormDetail.getPSSysEditorStyleId())) != null) {
            this.onFillParentInfo_PSSysEditorStyle(pSDEFormDetail, (PSSysEditorStyle)iEntity);
        }
        if (pSDEFormDetail.getPSSysImageId() != null && (iEntity = cloneSession.getEntity("PSSYSIMAGE", (Object)pSDEFormDetail.getPSSysImageId())) != null) {
            this.onFillParentInfo_PSSysImage(pSDEFormDetail, (PSSysImage)iEntity);
        }
        if (pSDEFormDetail.getOpenPSSysPDTViewId() != null && (iEntity = cloneSession.getEntity("PSSYSPDTVIEW", (Object)pSDEFormDetail.getOpenPSSysPDTViewId())) != null) {
            this.onFillParentInfo_OpenPSSysPDTView(pSDEFormDetail, (PSSysPDTView)iEntity);
        }
        if (pSDEFormDetail.getUCPSSysPFPluginId() != null && (iEntity = cloneSession.getEntity("PSSYSPFPLUGIN", (Object)pSDEFormDetail.getUCPSSysPFPluginId())) != null) {
            this.onFillParentInfo_UCPSSysPFPlugin(pSDEFormDetail, (PSSysPFPlugin)iEntity);
        }
        if (pSDEFormDetail.getPSSysResourceId() != null && (iEntity = cloneSession.getEntity("PSSYSRESOURCE", (Object)pSDEFormDetail.getPSSysResourceId())) != null) {
            this.onFillParentInfo_PSSysResource(pSDEFormDetail, (PSSysResource)iEntity);
        }
        if (pSDEFormDetail.getMDPSSysViewPanelId() != null && (iEntity = cloneSession.getEntity("PSSYSVIEWPANEL", (Object)pSDEFormDetail.getMDPSSysViewPanelId())) != null) {
            this.onFillParentInfo_MDPSSysViewPanel(pSDEFormDetail, (PSSysViewPanel)iEntity);
        }
    }

    protected void onRemoveEntityUncopyValues(PSDEFormDetail pSDEFormDetail, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues(pSDEFormDetail, bl);
        pSDEFormDetail.resetCssId();
        pSDEFormDetail.resetLabelCssId();
    }

    protected void onCheckEntity(boolean bl, PSDEFormDetail pSDEFormDetail, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_AllowEmpty(bl, pSDEFormDetail, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_BlankLogic(bl, pSDEFormDetail, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_BL_Pos(bl, pSDEFormDetail, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_BorderStyle(bl, pSDEFormDetail, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_BtnActionType(bl, pSDEFormDetail, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_BuildInAction(bl, pSDEFormDetail, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_CapPSLanResId(bl, pSDEFormDetail, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_CapPSLanResName(bl, pSDEFormDetail, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Caption(bl, pSDEFormDetail, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Child_Col_LG(bl, pSDEFormDetail, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Child_Col_MD(bl, pSDEFormDetail, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Child_Col_SM(bl, pSDEFormDetail, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Child_Col_XS(bl, pSDEFormDetail, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_CodeListConfigMode(bl, pSDEFormDetail, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ColAlign(bl, pSDEFormDetail, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ColId(bl, pSDEFormDetail, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ColModel(bl, pSDEFormDetail, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ColSpan(bl, pSDEFormDetail, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Col_LG(bl, pSDEFormDetail, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Col_LG_OS(bl, pSDEFormDetail, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Col_MD(bl, pSDEFormDetail, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Col_MD_OS(bl, pSDEFormDetail, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Col_SM(bl, pSDEFormDetail, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Col_SM_OS(bl, pSDEFormDetail, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Col_Width(bl, pSDEFormDetail, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Col_XS(bl, pSDEFormDetail, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Col_XS_OS(bl, pSDEFormDetail, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ContentType(bl, pSDEFormDetail, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ConvertCIText(bl, pSDEFormDetail, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_CounterId(bl, pSDEFormDetail, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_CounterMode(bl, pSDEFormDetail, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_CreateDV(bl, pSDEFormDetail, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_CreateDVT(bl, pSDEFormDetail, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_CssId(bl, pSDEFormDetail, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_CtrlColSpan(bl, pSDEFormDetail, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_CtrlDynaClass(bl, pSDEFormDetail, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_CtrlHeight(bl, pSDEFormDetail, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_CtrlPSSysCssId(bl, pSDEFormDetail, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_CtrlRawCssStyle(bl, pSDEFormDetail, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_CtrlWidth(bl, pSDEFormDetail, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_CustomCode(bl, pSDEFormDetail, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Data(bl, pSDEFormDetail, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_DefaultFlag(bl, pSDEFormDetail, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_DetailStyle(bl, pSDEFormDetail, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_DetailTag(bl, pSDEFormDetail, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_DetailTag2(bl, pSDEFormDetail, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_DetailType(bl, pSDEFormDetail, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_DynaClass(bl, pSDEFormDetail, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_DynaModelFlag(bl, pSDEFormDetail, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_EditorParams(bl, pSDEFormDetail, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_EditorType(bl, pSDEFormDetail, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_EditorTypeName(bl, pSDEFormDetail, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_EmptyCaption(bl, pSDEFormDetail, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_EnableAnchor(bl, pSDEFormDetail, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_EnableCond(bl, pSDEFormDetail, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_EnableInputTip(bl, pSDEFormDetail, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_EnableItemPriv(bl, pSDEFormDetail, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_EnableLogic(bl, pSDEFormDetail, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_FieldName(bl, pSDEFormDetail, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_FlexAlign(bl, pSDEFormDetail, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_FlexBasis(bl, pSDEFormDetail, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_FlexDir(bl, pSDEFormDetail, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_FlexGrow(bl, pSDEFormDetail, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_FlexShrink(bl, pSDEFormDetail, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_FlexVAlign(bl, pSDEFormDetail, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_GridRowId(bl, pSDEFormDetail, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_HAlign(bl, pSDEFormDetail, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_HAlignSelf(bl, pSDEFormDetail, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Height(bl, pSDEFormDetail, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_HeightMode(bl, pSDEFormDetail, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_HtmlContent(bl, pSDEFormDetail, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_HtmlPageUrl(bl, pSDEFormDetail, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_IconAlign(bl, pSDEFormDetail, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_IgnoreInput(bl, pSDEFormDetail, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_InsertPos(bl, pSDEFormDetail, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ItemPSACHandlerId(bl, pSDEFormDetail, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ItemStates(bl, pSDEFormDetail, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_LabelColSpan(bl, pSDEFormDetail, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_LabelColSpan2(bl, pSDEFormDetail, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_LabelCssId(bl, pSDEFormDetail, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_LabelDynaClass(bl, pSDEFormDetail, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_LabelPos(bl, pSDEFormDetail, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_LabelPSSysCssId(bl, pSDEFormDetail, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_LabelRawCssStyle(bl, pSDEFormDetail, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_LabelWidth(bl, pSDEFormDetail, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_LayoutMode(bl, pSDEFormDetail, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_LevelTag(bl, pSDEFormDetail, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_LevelValue(bl, pSDEFormDetail, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_LinkPSDEViewId(bl, pSDEFormDetail, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_LogicName(bl, pSDEFormDetail, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Margin(bl, pSDEFormDetail, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_MaskInfo(bl, pSDEFormDetail, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_MaskMode(bl, pSDEFormDetail, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_MaskPSLanResId(bl, pSDEFormDetail, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_MaskPSLanResName(bl, pSDEFormDetail, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_MDCtrlType(bl, pSDEFormDetail, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_MDPSDEDataViewId(bl, pSDEFormDetail, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_MDPSDEFormId(bl, pSDEFormDetail, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_MDPSDEGridId(bl, pSDEFormDetail, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_MDPSDEListId(bl, pSDEFormDetail, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_MDPSSysViewPanelId(bl, pSDEFormDetail, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Memo(bl, pSDEFormDetail, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ModelState(bl, pSDEFormDetail, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_NeedCodeListConfig(bl, pSDEFormDetail, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_NoPrivDM(bl, pSDEFormDetail, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_OpenPSDEViewId(bl, pSDEFormDetail, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_OpenPSSysPDTViewId(bl, pSDEFormDetail, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_OrderValue(bl, pSDEFormDetail, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Padding(bl, pSDEFormDetail, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PHPSLanResId(bl, pSDEFormDetail, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PHPSLanResName(bl, pSDEFormDetail, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PickupPSDEViewId(bl, pSDEFormDetail, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PlaceHolder(bl, pSDEFormDetail, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PPSDEFormDetailId(bl, pSDEFormDetail, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PredefinedType(bl, pSDEFormDetail, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PreventXSS(bl, pSDEFormDetail, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PreviewHtml(bl, pSDEFormDetail, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSCodeListId(bl, pSDEFormDetail, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEDRId(bl, pSDEFormDetail, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEDRItemId(bl, pSDEFormDetail, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEFUIModeId(bl, pSDEFormDetail, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEFId(bl, pSDEFormDetail, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEFIUpdateId(bl, pSDEFormDetail, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEFName(bl, pSDEFormDetail, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEFormDetailId(bl, pSDEFormDetail, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEFormDetailName(bl, pSDEFormDetail, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEFormId(bl, pSDEFormDetail, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEFormRFId(bl, pSDEFormDetail, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEFSFItemId(bl, pSDEFormDetail, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEFSFItemName(bl, pSDEFormDetail, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDELogicId(bl, pSDEFormDetail, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEUAGroupId(bl, pSDEFormDetail, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEUIActionId(bl, pSDEFormDetail, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDynaInstId(bl, pSDEFormDetail, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysCounterId(bl, pSDEFormDetail, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysCssId(bl, pSDEFormDetail, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysCssName(bl, pSDEFormDetail, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysDictCatId(bl, pSDEFormDetail, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysDynaModelId(bl, pSDEFormDetail, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysDynaModelName(bl, pSDEFormDetail, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysEditorStyleId(bl, pSDEFormDetail, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysImageId(bl, pSDEFormDetail, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysResourceId(bl, pSDEFormDetail, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_RawContent(bl, pSDEFormDetail, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_RawCssStyle(bl, pSDEFormDetail, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_RawServiceMethod(bl, pSDEFormDetail, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_RawServiceUrl(bl, pSDEFormDetail, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_RefPSDEACModeId(bl, pSDEFormDetail, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_RefPSDEDataSetId(bl, pSDEFormDetail, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_RefPSDEFormDetailId(bl, pSDEFormDetail, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_RefPSDEId(bl, pSDEFormDetail, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_RefPSDEName(bl, pSDEFormDetail, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_RefPSDERId(bl, pSDEFormDetail, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_RefPSDERName(bl, pSDEFormDetail, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_RenderMode(bl, pSDEFormDetail, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ResetItemName(bl, pSDEFormDetail, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_RowSpan(bl, pSDEFormDetail, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ShowCaption(bl, pSDEFormDetail, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ShowMoreMode(bl, pSDEFormDetail, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_SpacingBottom(bl, pSDEFormDetail, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_SpacingLeft(bl, pSDEFormDetail, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_SpacingRight(bl, pSDEFormDetail, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_SpacingTop(bl, pSDEFormDetail, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_SwapMode(bl, pSDEFormDetail, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_TemplateMode(bl, pSDEFormDetail, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_TipPSLanResId(bl, pSDEFormDetail, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_TipPSLanResName(bl, pSDEFormDetail, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_TitleBarCloseMode(bl, pSDEFormDetail, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ToggleMode(bl, pSDEFormDetail, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_TooltipInfo(bl, pSDEFormDetail, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UCPSSysPFPluginId(bl, pSDEFormDetail, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UpdateDV(bl, pSDEFormDetail, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UpdateDVT(bl, pSDEFormDetail, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag(bl, pSDEFormDetail, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag2(bl, pSDEFormDetail, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_VAlign(bl, pSDEFormDetail, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_VAlignSelf(bl, pSDEFormDetail, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ValueFormat(bl, pSDEFormDetail, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ValueItemName(bl, pSDEFormDetail, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_VisibleLogic(bl, pSDEFormDetail, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_WBDEFMode(bl, pSDEFormDetail, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Width(bl, pSDEFormDetail, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_WidthMode(bl, pSDEFormDetail, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, pSDEFormDetail, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_AllowEmpty(boolean bl, PSDEFormDetail pSDEFormDetail, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFormDetail.isAllowEmptyDirty() : !pSDEFormDetail.isAllowEmptyDirty()) {
            return null;
        }
        Integer n = pSDEFormDetail.getAllowEmpty();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_AllowEmpty_Default(pSDEFormDetail, bl2, bl3);
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

    protected EntityFieldError onCheckField_BlankLogic(boolean bl, PSDEFormDetail pSDEFormDetail, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFormDetail.isBlankLogicDirty() : !pSDEFormDetail.isBlankLogicDirty()) {
            return null;
        }
        String string = pSDEFormDetail.getBlankLogic();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_BlankLogic_Default(pSDEFormDetail, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("BLANKLOGIC");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_BL_Pos(boolean bl, PSDEFormDetail pSDEFormDetail, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFormDetail.isBL_PosDirty() : !pSDEFormDetail.isBL_PosDirty()) {
            return null;
        }
        String string = pSDEFormDetail.getBL_Pos();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_BL_Pos_Default(pSDEFormDetail, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("BL_POS");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_BorderStyle(boolean bl, PSDEFormDetail pSDEFormDetail, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFormDetail.isBorderStyleDirty() : !pSDEFormDetail.isBorderStyleDirty()) {
            return null;
        }
        String string = pSDEFormDetail.getBorderStyle();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_BorderStyle_Default(pSDEFormDetail, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("BORDERSTYLE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_BtnActionType(boolean bl, PSDEFormDetail pSDEFormDetail, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFormDetail.isBtnActionTypeDirty() : !pSDEFormDetail.isBtnActionTypeDirty()) {
            return null;
        }
        String string = pSDEFormDetail.getBtnActionType();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_BtnActionType_Default(pSDEFormDetail, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("BTNACTIONTYPE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_BuildInAction(boolean bl, PSDEFormDetail pSDEFormDetail, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFormDetail.isBuildInActionDirty() : !pSDEFormDetail.isBuildInActionDirty()) {
            return null;
        }
        Integer n = pSDEFormDetail.getBuildInAction();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_BuildInAction_Default(pSDEFormDetail, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("BUILDINACTION");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_CapPSLanResId(boolean bl, PSDEFormDetail pSDEFormDetail, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFormDetail.isCapPSLanResIdDirty() : !pSDEFormDetail.isCapPSLanResIdDirty()) {
            return null;
        }
        String string = pSDEFormDetail.getCapPSLanResId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_CapPSLanResId_Default(pSDEFormDetail, bl2, bl3);
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

    protected EntityFieldError onCheckField_CapPSLanResName(boolean bl, PSDEFormDetail pSDEFormDetail, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFormDetail.isCapPSLanResNameDirty() : !pSDEFormDetail.isCapPSLanResNameDirty()) {
            return null;
        }
        String string = pSDEFormDetail.getCapPSLanResName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_CapPSLanResName_Default(pSDEFormDetail, bl2, bl3);
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

    protected EntityFieldError onCheckField_Caption(boolean bl, PSDEFormDetail pSDEFormDetail, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFormDetail.isCaptionDirty() : !pSDEFormDetail.isCaptionDirty()) {
            return null;
        }
        String string = pSDEFormDetail.getCaption();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Caption_Default(pSDEFormDetail, bl2, bl3);
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

    protected EntityFieldError onCheckField_Child_Col_LG(boolean bl, PSDEFormDetail pSDEFormDetail, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFormDetail.isChild_Col_LGDirty() : !pSDEFormDetail.isChild_Col_LGDirty()) {
            return null;
        }
        Integer n = pSDEFormDetail.getChild_Col_LG();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_Child_Col_LG_Default(pSDEFormDetail, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CHILD_COL_LG");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Child_Col_MD(boolean bl, PSDEFormDetail pSDEFormDetail, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFormDetail.isChild_Col_MDDirty() : !pSDEFormDetail.isChild_Col_MDDirty()) {
            return null;
        }
        Integer n = pSDEFormDetail.getChild_Col_MD();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_Child_Col_MD_Default(pSDEFormDetail, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CHILD_COL_MD");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Child_Col_SM(boolean bl, PSDEFormDetail pSDEFormDetail, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFormDetail.isChild_Col_SMDirty() : !pSDEFormDetail.isChild_Col_SMDirty()) {
            return null;
        }
        Integer n = pSDEFormDetail.getChild_Col_SM();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_Child_Col_SM_Default(pSDEFormDetail, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CHILD_COL_SM");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Child_Col_XS(boolean bl, PSDEFormDetail pSDEFormDetail, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFormDetail.isChild_Col_XSDirty() : !pSDEFormDetail.isChild_Col_XSDirty()) {
            return null;
        }
        Integer n = pSDEFormDetail.getChild_Col_XS();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_Child_Col_XS_Default(pSDEFormDetail, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CHILD_COL_XS");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_CodeListConfigMode(boolean bl, PSDEFormDetail pSDEFormDetail, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFormDetail.isCodeListConfigModeDirty() : !pSDEFormDetail.isCodeListConfigModeDirty()) {
            return null;
        }
        Integer n = pSDEFormDetail.getCodeListConfigMode();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_CodeListConfigMode_Default(pSDEFormDetail, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CODELISTCONFIGMODE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ColAlign(boolean bl, PSDEFormDetail pSDEFormDetail, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFormDetail.isColAlignDirty() : !pSDEFormDetail.isColAlignDirty()) {
            return null;
        }
        String string = pSDEFormDetail.getColAlign();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_ColAlign_Default(pSDEFormDetail, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("COLALIGN");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ColId(boolean bl, PSDEFormDetail pSDEFormDetail, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFormDetail.isColIdDirty() : !pSDEFormDetail.isColIdDirty()) {
            return null;
        }
        Integer n = pSDEFormDetail.getColId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_ColId_Default(pSDEFormDetail, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("COLID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ColModel(boolean bl, PSDEFormDetail pSDEFormDetail, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFormDetail.isColModelDirty() : !pSDEFormDetail.isColModelDirty()) {
            return null;
        }
        String string = pSDEFormDetail.getColModel();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_ColModel_Default(pSDEFormDetail, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("COLMODEL");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ColSpan(boolean bl, PSDEFormDetail pSDEFormDetail, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFormDetail.isColSpanDirty() : !pSDEFormDetail.isColSpanDirty()) {
            return null;
        }
        Integer n = pSDEFormDetail.getColSpan();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_ColSpan_Default(pSDEFormDetail, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("COLSPAN");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Col_LG(boolean bl, PSDEFormDetail pSDEFormDetail, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFormDetail.isCol_LGDirty() : !pSDEFormDetail.isCol_LGDirty()) {
            return null;
        }
        Integer n = pSDEFormDetail.getCol_LG();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_Col_LG_Default(pSDEFormDetail, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("COL_LG");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Col_LG_OS(boolean bl, PSDEFormDetail pSDEFormDetail, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFormDetail.isCol_LG_OSDirty() : !pSDEFormDetail.isCol_LG_OSDirty()) {
            return null;
        }
        Integer n = pSDEFormDetail.getCol_LG_OS();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_Col_LG_OS_Default(pSDEFormDetail, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("COL_LG_OS");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Col_MD(boolean bl, PSDEFormDetail pSDEFormDetail, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFormDetail.isCol_MDDirty() : !pSDEFormDetail.isCol_MDDirty()) {
            return null;
        }
        Integer n = pSDEFormDetail.getCol_MD();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_Col_MD_Default(pSDEFormDetail, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("COL_MD");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Col_MD_OS(boolean bl, PSDEFormDetail pSDEFormDetail, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFormDetail.isCol_MD_OSDirty() : !pSDEFormDetail.isCol_MD_OSDirty()) {
            return null;
        }
        Integer n = pSDEFormDetail.getCol_MD_OS();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_Col_MD_OS_Default(pSDEFormDetail, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("COL_MD_OS");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Col_SM(boolean bl, PSDEFormDetail pSDEFormDetail, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFormDetail.isCol_SMDirty() : !pSDEFormDetail.isCol_SMDirty()) {
            return null;
        }
        Integer n = pSDEFormDetail.getCol_SM();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_Col_SM_Default(pSDEFormDetail, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("COL_SM");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Col_SM_OS(boolean bl, PSDEFormDetail pSDEFormDetail, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFormDetail.isCol_SM_OSDirty() : !pSDEFormDetail.isCol_SM_OSDirty()) {
            return null;
        }
        Integer n = pSDEFormDetail.getCol_SM_OS();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_Col_SM_OS_Default(pSDEFormDetail, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("COL_SM_OS");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Col_Width(boolean bl, PSDEFormDetail pSDEFormDetail, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFormDetail.isCol_WidthDirty() : !pSDEFormDetail.isCol_WidthDirty()) {
            return null;
        }
        Integer n = pSDEFormDetail.getCol_Width();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_Col_Width_Default(pSDEFormDetail, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("COL_WIDTH");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Col_XS(boolean bl, PSDEFormDetail pSDEFormDetail, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFormDetail.isCol_XSDirty() : !pSDEFormDetail.isCol_XSDirty()) {
            return null;
        }
        Integer n = pSDEFormDetail.getCol_XS();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_Col_XS_Default(pSDEFormDetail, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("COL_XS");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Col_XS_OS(boolean bl, PSDEFormDetail pSDEFormDetail, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFormDetail.isCol_XS_OSDirty() : !pSDEFormDetail.isCol_XS_OSDirty()) {
            return null;
        }
        Integer n = pSDEFormDetail.getCol_XS_OS();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_Col_XS_OS_Default(pSDEFormDetail, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("COL_XS_OS");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ContentType(boolean bl, PSDEFormDetail pSDEFormDetail, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFormDetail.isContentTypeDirty() : !pSDEFormDetail.isContentTypeDirty()) {
            return null;
        }
        String string = pSDEFormDetail.getContentType();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_ContentType_Default(pSDEFormDetail, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CONTENTTYPE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ConvertCIText(boolean bl, PSDEFormDetail pSDEFormDetail, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFormDetail.isConvertCITextDirty() : !pSDEFormDetail.isConvertCITextDirty()) {
            return null;
        }
        Integer n = pSDEFormDetail.getConvertCIText();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_ConvertCIText_Default(pSDEFormDetail, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CONVERTCITEXT");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_CounterId(boolean bl, PSDEFormDetail pSDEFormDetail, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFormDetail.isCounterIdDirty() : !pSDEFormDetail.isCounterIdDirty()) {
            return null;
        }
        String string = pSDEFormDetail.getCounterId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_CounterId_Default(pSDEFormDetail, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("COUNTERID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_CounterMode(boolean bl, PSDEFormDetail pSDEFormDetail, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFormDetail.isCounterModeDirty() : !pSDEFormDetail.isCounterModeDirty()) {
            return null;
        }
        Integer n = pSDEFormDetail.getCounterMode();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_CounterMode_Default(pSDEFormDetail, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("COUNTERMODE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_CreateDV(boolean bl, PSDEFormDetail pSDEFormDetail, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFormDetail.isCreateDVDirty() : !pSDEFormDetail.isCreateDVDirty()) {
            return null;
        }
        String string = pSDEFormDetail.getCreateDV();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_CreateDV_Default(pSDEFormDetail, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CREATEDV");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_CreateDVT(boolean bl, PSDEFormDetail pSDEFormDetail, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFormDetail.isCreateDVTDirty() : !pSDEFormDetail.isCreateDVTDirty()) {
            return null;
        }
        String string = pSDEFormDetail.getCreateDVT();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_CreateDVT_Default(pSDEFormDetail, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CREATEDVT");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_CssId(boolean bl, PSDEFormDetail pSDEFormDetail, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFormDetail.isCssIdDirty() : !pSDEFormDetail.isCssIdDirty()) {
            return null;
        }
        String string = pSDEFormDetail.getCssId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_CssId_Default(pSDEFormDetail, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CSSID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_CtrlColSpan(boolean bl, PSDEFormDetail pSDEFormDetail, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFormDetail.isCtrlColSpanDirty() : !pSDEFormDetail.isCtrlColSpanDirty()) {
            return null;
        }
        Integer n = pSDEFormDetail.getCtrlColSpan();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_CtrlColSpan_Default(pSDEFormDetail, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CTRLCOLSPAN");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_CtrlDynaClass(boolean bl, PSDEFormDetail pSDEFormDetail, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFormDetail.isCtrlDynaClassDirty() : !pSDEFormDetail.isCtrlDynaClassDirty()) {
            return null;
        }
        String string = pSDEFormDetail.getCtrlDynaClass();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_CtrlDynaClass_Default(pSDEFormDetail, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CTRLDYNACLASS");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_CtrlHeight(boolean bl, PSDEFormDetail pSDEFormDetail, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFormDetail.isCtrlHeightDirty() : !pSDEFormDetail.isCtrlHeightDirty()) {
            return null;
        }
        Integer n = pSDEFormDetail.getCtrlHeight();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_CtrlHeight_Default(pSDEFormDetail, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CTRLHEIGHT");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_CtrlPSSysCssId(boolean bl, PSDEFormDetail pSDEFormDetail, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFormDetail.isCtrlPSSysCssIdDirty() : !pSDEFormDetail.isCtrlPSSysCssIdDirty()) {
            return null;
        }
        String string = pSDEFormDetail.getCtrlPSSysCssId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_CtrlPSSysCssId_Default(pSDEFormDetail, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CTRLPSSYSCSSID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_CtrlRawCssStyle(boolean bl, PSDEFormDetail pSDEFormDetail, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFormDetail.isCtrlRawCssStyleDirty() : !pSDEFormDetail.isCtrlRawCssStyleDirty()) {
            return null;
        }
        String string = pSDEFormDetail.getCtrlRawCssStyle();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_CtrlRawCssStyle_Default(pSDEFormDetail, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CTRLRAWCSSSTYLE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_CtrlWidth(boolean bl, PSDEFormDetail pSDEFormDetail, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFormDetail.isCtrlWidthDirty() : !pSDEFormDetail.isCtrlWidthDirty()) {
            return null;
        }
        Integer n = pSDEFormDetail.getCtrlWidth();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_CtrlWidth_Default(pSDEFormDetail, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CTRLWIDTH");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_CustomCode(boolean bl, PSDEFormDetail pSDEFormDetail, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFormDetail.isCustomCodeDirty() : !pSDEFormDetail.isCustomCodeDirty()) {
            return null;
        }
        String string = pSDEFormDetail.getCustomCode();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_CustomCode_Default(pSDEFormDetail, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CUSTOMCODE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Data(boolean bl, PSDEFormDetail pSDEFormDetail, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFormDetail.isDataDirty() : !pSDEFormDetail.isDataDirty()) {
            return null;
        }
        String string = pSDEFormDetail.getData();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Data_Default(pSDEFormDetail, bl2, bl3);
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

    protected EntityFieldError onCheckField_DefaultFlag(boolean bl, PSDEFormDetail pSDEFormDetail, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFormDetail.isDefaultFlagDirty() : !pSDEFormDetail.isDefaultFlagDirty()) {
            return null;
        }
        Integer n = pSDEFormDetail.getDefaultFlag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_DefaultFlag_Default(pSDEFormDetail, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DEFAULTFLAG");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_DetailStyle(boolean bl, PSDEFormDetail pSDEFormDetail, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFormDetail.isDetailStyleDirty() : !pSDEFormDetail.isDetailStyleDirty()) {
            return null;
        }
        String string = pSDEFormDetail.getDetailStyle();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_DetailStyle_Default(pSDEFormDetail, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DETAILSTYLE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_DetailTag(boolean bl, PSDEFormDetail pSDEFormDetail, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFormDetail.isDetailTagDirty() : !pSDEFormDetail.isDetailTagDirty()) {
            return null;
        }
        String string = pSDEFormDetail.getDetailTag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_DetailTag_Default(pSDEFormDetail, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DETAILTAG");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_DetailTag2(boolean bl, PSDEFormDetail pSDEFormDetail, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFormDetail.isDetailTag2Dirty() : !pSDEFormDetail.isDetailTag2Dirty()) {
            return null;
        }
        String string = pSDEFormDetail.getDetailTag2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_DetailTag2_Default(pSDEFormDetail, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DETAILTAG2");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_DetailType(boolean bl, PSDEFormDetail pSDEFormDetail, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFormDetail.isDetailTypeDirty() && !bl2 : !pSDEFormDetail.isDetailTypeDirty()) {
            return null;
        }
        String string = pSDEFormDetail.getDetailType();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DETAILTYPE");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_DetailType_Default(pSDEFormDetail, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DETAILTYPE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_DynaClass(boolean bl, PSDEFormDetail pSDEFormDetail, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFormDetail.isDynaClassDirty() : !pSDEFormDetail.isDynaClassDirty()) {
            return null;
        }
        String string = pSDEFormDetail.getDynaClass();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_DynaClass_Default(pSDEFormDetail, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DYNACLASS");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_DynaModelFlag(boolean bl, PSDEFormDetail pSDEFormDetail, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFormDetail.isDynaModelFlagDirty() : !pSDEFormDetail.isDynaModelFlagDirty()) {
            return null;
        }
        Integer n = pSDEFormDetail.getDynaModelFlag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_DynaModelFlag_Default(pSDEFormDetail, bl2, bl3);
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

    protected EntityFieldError onCheckField_EditorParams(boolean bl, PSDEFormDetail pSDEFormDetail, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFormDetail.isEditorParamsDirty() : !pSDEFormDetail.isEditorParamsDirty()) {
            return null;
        }
        String string = pSDEFormDetail.getEditorParams();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_EditorParams_Default(pSDEFormDetail, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("EDITORPARAMS");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_EditorType(boolean bl, PSDEFormDetail pSDEFormDetail, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFormDetail.isEditorTypeDirty() : !pSDEFormDetail.isEditorTypeDirty()) {
            return null;
        }
        String string = pSDEFormDetail.getEditorType();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_EditorType_Default(pSDEFormDetail, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("EDITORTYPE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_EditorTypeName(boolean bl, PSDEFormDetail pSDEFormDetail, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFormDetail.isEditorTypeNameDirty() : !pSDEFormDetail.isEditorTypeNameDirty()) {
            return null;
        }
        String string = pSDEFormDetail.getEditorTypeName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_EditorTypeName_Default(pSDEFormDetail, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("EDITORTYPENAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_EmptyCaption(boolean bl, PSDEFormDetail pSDEFormDetail, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFormDetail.isEmptyCaptionDirty() : !pSDEFormDetail.isEmptyCaptionDirty()) {
            return null;
        }
        Integer n = pSDEFormDetail.getEmptyCaption();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_EmptyCaption_Default(pSDEFormDetail, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("EMPTYCAPTION");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_EnableAnchor(boolean bl, PSDEFormDetail pSDEFormDetail, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFormDetail.isEnableAnchorDirty() : !pSDEFormDetail.isEnableAnchorDirty()) {
            return null;
        }
        Integer n = pSDEFormDetail.getEnableAnchor();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_EnableAnchor_Default(pSDEFormDetail, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ENABLEANCHOR");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_EnableCond(boolean bl, PSDEFormDetail pSDEFormDetail, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFormDetail.isEnableCondDirty() : !pSDEFormDetail.isEnableCondDirty()) {
            return null;
        }
        Integer n = pSDEFormDetail.getEnableCond();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_EnableCond_Default(pSDEFormDetail, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ENABLECOND");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_EnableInputTip(boolean bl, PSDEFormDetail pSDEFormDetail, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFormDetail.isEnableInputTipDirty() : !pSDEFormDetail.isEnableInputTipDirty()) {
            return null;
        }
        Integer n = pSDEFormDetail.getEnableInputTip();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_EnableInputTip_Default(pSDEFormDetail, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ENABLEINPUTTIP");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_EnableItemPriv(boolean bl, PSDEFormDetail pSDEFormDetail, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFormDetail.isEnableItemPrivDirty() : !pSDEFormDetail.isEnableItemPrivDirty()) {
            return null;
        }
        Integer n = pSDEFormDetail.getEnableItemPriv();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_EnableItemPriv_Default(pSDEFormDetail, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ENABLEITEMPRIV");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_EnableLogic(boolean bl, PSDEFormDetail pSDEFormDetail, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFormDetail.isEnableLogicDirty() : !pSDEFormDetail.isEnableLogicDirty()) {
            return null;
        }
        String string = pSDEFormDetail.getEnableLogic();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_EnableLogic_Default(pSDEFormDetail, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ENABLELOGIC");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_FieldName(boolean bl, PSDEFormDetail pSDEFormDetail, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFormDetail.isFieldNameDirty() : !pSDEFormDetail.isFieldNameDirty()) {
            return null;
        }
        String string = pSDEFormDetail.getFieldName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_FieldName_Default(pSDEFormDetail, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("FIELDNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_FlexAlign(boolean bl, PSDEFormDetail pSDEFormDetail, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFormDetail.isFlexAlignDirty() : !pSDEFormDetail.isFlexAlignDirty()) {
            return null;
        }
        String string = pSDEFormDetail.getFlexAlign();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_FlexAlign_Default(pSDEFormDetail, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("FLEXALIGN");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_FlexBasis(boolean bl, PSDEFormDetail pSDEFormDetail, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFormDetail.isFlexBasisDirty() : !pSDEFormDetail.isFlexBasisDirty()) {
            return null;
        }
        Integer n = pSDEFormDetail.getFlexBasis();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_FlexBasis_Default(pSDEFormDetail, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("FLEXBASIS");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_FlexDir(boolean bl, PSDEFormDetail pSDEFormDetail, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFormDetail.isFlexDirDirty() : !pSDEFormDetail.isFlexDirDirty()) {
            return null;
        }
        String string = pSDEFormDetail.getFlexDir();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_FlexDir_Default(pSDEFormDetail, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("FLEXDIR");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_FlexGrow(boolean bl, PSDEFormDetail pSDEFormDetail, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFormDetail.isFlexGrowDirty() : !pSDEFormDetail.isFlexGrowDirty()) {
            return null;
        }
        Integer n = pSDEFormDetail.getFlexGrow();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_FlexGrow_Default(pSDEFormDetail, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("FLEXGROW");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_FlexShrink(boolean bl, PSDEFormDetail pSDEFormDetail, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFormDetail.isFlexShrinkDirty() : !pSDEFormDetail.isFlexShrinkDirty()) {
            return null;
        }
        Integer n = pSDEFormDetail.getFlexShrink();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_FlexShrink_Default(pSDEFormDetail, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("FLEXSHRINK");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_FlexVAlign(boolean bl, PSDEFormDetail pSDEFormDetail, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFormDetail.isFlexVAlignDirty() : !pSDEFormDetail.isFlexVAlignDirty()) {
            return null;
        }
        String string = pSDEFormDetail.getFlexVAlign();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_FlexVAlign_Default(pSDEFormDetail, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("FLEXVALIGN");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_GridRowId(boolean bl, PSDEFormDetail pSDEFormDetail, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFormDetail.isGridRowIdDirty() : !pSDEFormDetail.isGridRowIdDirty()) {
            return null;
        }
        Integer n = pSDEFormDetail.getGridRowId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_GridRowId_Default(pSDEFormDetail, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("GRIDROWID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_HAlign(boolean bl, PSDEFormDetail pSDEFormDetail, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFormDetail.isHAlignDirty() : !pSDEFormDetail.isHAlignDirty()) {
            return null;
        }
        String string = pSDEFormDetail.getHAlign();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_HAlign_Default(pSDEFormDetail, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("HALIGN");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_HAlignSelf(boolean bl, PSDEFormDetail pSDEFormDetail, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFormDetail.isHAlignSelfDirty() : !pSDEFormDetail.isHAlignSelfDirty()) {
            return null;
        }
        String string = pSDEFormDetail.getHAlignSelf();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_HAlignSelf_Default(pSDEFormDetail, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("HALIGNSELF");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Height(boolean bl, PSDEFormDetail pSDEFormDetail, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFormDetail.isHeightDirty() : !pSDEFormDetail.isHeightDirty()) {
            return null;
        }
        Integer n = pSDEFormDetail.getHeight();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_Height_Default(pSDEFormDetail, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("HEIGHT");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_HeightMode(boolean bl, PSDEFormDetail pSDEFormDetail, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFormDetail.isHeightModeDirty() : !pSDEFormDetail.isHeightModeDirty()) {
            return null;
        }
        String string = pSDEFormDetail.getHeightMode();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_HeightMode_Default(pSDEFormDetail, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("HEIGHTMODE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_HtmlContent(boolean bl, PSDEFormDetail pSDEFormDetail, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFormDetail.isHtmlContentDirty() : !pSDEFormDetail.isHtmlContentDirty()) {
            return null;
        }
        String string = pSDEFormDetail.getHtmlContent();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_HtmlContent_Default(pSDEFormDetail, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("HTMLCONTENT");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_HtmlPageUrl(boolean bl, PSDEFormDetail pSDEFormDetail, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFormDetail.isHtmlPageUrlDirty() : !pSDEFormDetail.isHtmlPageUrlDirty()) {
            return null;
        }
        String string = pSDEFormDetail.getHtmlPageUrl();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_HtmlPageUrl_Default(pSDEFormDetail, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("HTMLPAGEURL");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_IconAlign(boolean bl, PSDEFormDetail pSDEFormDetail, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFormDetail.isIconAlignDirty() : !pSDEFormDetail.isIconAlignDirty()) {
            return null;
        }
        String string = pSDEFormDetail.getIconAlign();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_IconAlign_Default(pSDEFormDetail, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ICONALIGN");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_IgnoreInput(boolean bl, PSDEFormDetail pSDEFormDetail, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFormDetail.isIgnoreInputDirty() : !pSDEFormDetail.isIgnoreInputDirty()) {
            return null;
        }
        Integer n = pSDEFormDetail.getIgnoreInput();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_IgnoreInput_Default(pSDEFormDetail, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("IGNOREINPUT");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_InsertPos(boolean bl, PSDEFormDetail pSDEFormDetail, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFormDetail.isInsertPosDirty() : !pSDEFormDetail.isInsertPosDirty()) {
            return null;
        }
        Integer n = pSDEFormDetail.getInsertPos();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_InsertPos_Default(pSDEFormDetail, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("INSERTPOS");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ItemPSACHandlerId(boolean bl, PSDEFormDetail pSDEFormDetail, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFormDetail.isItemPSACHandlerIdDirty() : !pSDEFormDetail.isItemPSACHandlerIdDirty()) {
            return null;
        }
        String string = pSDEFormDetail.getItemPSACHandlerId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_ItemPSACHandlerId_Default(pSDEFormDetail, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ITEMPSACHANDLERID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ItemStates(boolean bl, PSDEFormDetail pSDEFormDetail, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFormDetail.isItemStatesDirty() : !pSDEFormDetail.isItemStatesDirty()) {
            return null;
        }
        Integer n = pSDEFormDetail.getItemStates();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_ItemStates_Default(pSDEFormDetail, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ITEMSTATES");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_LabelColSpan(boolean bl, PSDEFormDetail pSDEFormDetail, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFormDetail.isLabelColSpanDirty() : !pSDEFormDetail.isLabelColSpanDirty()) {
            return null;
        }
        Integer n = pSDEFormDetail.getLabelColSpan();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_LabelColSpan_Default(pSDEFormDetail, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("LABELCOLSPAN");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_LabelColSpan2(boolean bl, PSDEFormDetail pSDEFormDetail, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFormDetail.isLabelColSpan2Dirty() : !pSDEFormDetail.isLabelColSpan2Dirty()) {
            return null;
        }
        Integer n = pSDEFormDetail.getLabelColSpan2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_LabelColSpan2_Default(pSDEFormDetail, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("LABELCOLSPAN2");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_LabelCssId(boolean bl, PSDEFormDetail pSDEFormDetail, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFormDetail.isLabelCssIdDirty() : !pSDEFormDetail.isLabelCssIdDirty()) {
            return null;
        }
        String string = pSDEFormDetail.getLabelCssId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_LabelCssId_Default(pSDEFormDetail, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("LABELCSSID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_LabelDynaClass(boolean bl, PSDEFormDetail pSDEFormDetail, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFormDetail.isLabelDynaClassDirty() : !pSDEFormDetail.isLabelDynaClassDirty()) {
            return null;
        }
        String string = pSDEFormDetail.getLabelDynaClass();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_LabelDynaClass_Default(pSDEFormDetail, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("LABELDYNACLASS");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_LabelPos(boolean bl, PSDEFormDetail pSDEFormDetail, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFormDetail.isLabelPosDirty() : !pSDEFormDetail.isLabelPosDirty()) {
            return null;
        }
        String string = pSDEFormDetail.getLabelPos();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_LabelPos_Default(pSDEFormDetail, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("LABELPOS");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_LabelPSSysCssId(boolean bl, PSDEFormDetail pSDEFormDetail, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFormDetail.isLabelPSSysCssIdDirty() : !pSDEFormDetail.isLabelPSSysCssIdDirty()) {
            return null;
        }
        String string = pSDEFormDetail.getLabelPSSysCssId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_LabelPSSysCssId_Default(pSDEFormDetail, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("LABELPSSYSCSSID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_LabelRawCssStyle(boolean bl, PSDEFormDetail pSDEFormDetail, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFormDetail.isLabelRawCssStyleDirty() : !pSDEFormDetail.isLabelRawCssStyleDirty()) {
            return null;
        }
        String string = pSDEFormDetail.getLabelRawCssStyle();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_LabelRawCssStyle_Default(pSDEFormDetail, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("LABELRAWCSSSTYLE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_LabelWidth(boolean bl, PSDEFormDetail pSDEFormDetail, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFormDetail.isLabelWidthDirty() : !pSDEFormDetail.isLabelWidthDirty()) {
            return null;
        }
        Integer n = pSDEFormDetail.getLabelWidth();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_LabelWidth_Default(pSDEFormDetail, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("LABELWIDTH");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_LayoutMode(boolean bl, PSDEFormDetail pSDEFormDetail, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFormDetail.isLayoutModeDirty() : !pSDEFormDetail.isLayoutModeDirty()) {
            return null;
        }
        String string = pSDEFormDetail.getLayoutMode();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_LayoutMode_Default(pSDEFormDetail, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("LAYOUTMODE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_LevelTag(boolean bl, PSDEFormDetail pSDEFormDetail, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFormDetail.isLevelTagDirty() : !pSDEFormDetail.isLevelTagDirty()) {
            return null;
        }
        String string = pSDEFormDetail.getLevelTag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_LevelTag_Default(pSDEFormDetail, bl2, bl3);
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

    protected EntityFieldError onCheckField_LevelValue(boolean bl, PSDEFormDetail pSDEFormDetail, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFormDetail.isLevelValueDirty() : !pSDEFormDetail.isLevelValueDirty()) {
            return null;
        }
        Integer n = pSDEFormDetail.getLevelValue();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_LevelValue_Default(pSDEFormDetail, bl2, bl3);
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

    protected EntityFieldError onCheckField_LinkPSDEViewId(boolean bl, PSDEFormDetail pSDEFormDetail, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFormDetail.isLinkPSDEViewIdDirty() : !pSDEFormDetail.isLinkPSDEViewIdDirty()) {
            return null;
        }
        String string = pSDEFormDetail.getLinkPSDEViewId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_LinkPSDEViewId_Default(pSDEFormDetail, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("LINKPSDEVIEWID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_LogicName(boolean bl, PSDEFormDetail pSDEFormDetail, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFormDetail.isLogicNameDirty() : !pSDEFormDetail.isLogicNameDirty()) {
            return null;
        }
        String string = pSDEFormDetail.getLogicName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_LogicName_Default(pSDEFormDetail, bl2, bl3);
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

    protected EntityFieldError onCheckField_Margin(boolean bl, PSDEFormDetail pSDEFormDetail, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFormDetail.isMarginDirty() : !pSDEFormDetail.isMarginDirty()) {
            return null;
        }
        String string = pSDEFormDetail.getMargin();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Margin_Default(pSDEFormDetail, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("MARGIN");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_MaskInfo(boolean bl, PSDEFormDetail pSDEFormDetail, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFormDetail.isMaskInfoDirty() : !pSDEFormDetail.isMaskInfoDirty()) {
            return null;
        }
        String string = pSDEFormDetail.getMaskInfo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_MaskInfo_Default(pSDEFormDetail, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("MASKINFO");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_MaskMode(boolean bl, PSDEFormDetail pSDEFormDetail, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFormDetail.isMaskModeDirty() : !pSDEFormDetail.isMaskModeDirty()) {
            return null;
        }
        Integer n = pSDEFormDetail.getMaskMode();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_MaskMode_Default(pSDEFormDetail, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("MASKMODE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_MaskPSLanResId(boolean bl, PSDEFormDetail pSDEFormDetail, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFormDetail.isMaskPSLanResIdDirty() : !pSDEFormDetail.isMaskPSLanResIdDirty()) {
            return null;
        }
        String string = pSDEFormDetail.getMaskPSLanResId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_MaskPSLanResId_Default(pSDEFormDetail, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("MASKPSLANRESID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_MaskPSLanResName(boolean bl, PSDEFormDetail pSDEFormDetail, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFormDetail.isMaskPSLanResNameDirty() : !pSDEFormDetail.isMaskPSLanResNameDirty()) {
            return null;
        }
        String string = pSDEFormDetail.getMaskPSLanResName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_MaskPSLanResName_Default(pSDEFormDetail, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("MASKPSLANRESNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_MDCtrlType(boolean bl, PSDEFormDetail pSDEFormDetail, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFormDetail.isMDCtrlTypeDirty() : !pSDEFormDetail.isMDCtrlTypeDirty()) {
            return null;
        }
        String string = pSDEFormDetail.getMDCtrlType();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_MDCtrlType_Default(pSDEFormDetail, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("MDCTRLTYPE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_MDPSDEDataViewId(boolean bl, PSDEFormDetail pSDEFormDetail, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFormDetail.isMDPSDEDataViewIdDirty() : !pSDEFormDetail.isMDPSDEDataViewIdDirty()) {
            return null;
        }
        String string = pSDEFormDetail.getMDPSDEDataViewId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_MDPSDEDataViewId_Default(pSDEFormDetail, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("MDPSDEDATAVIEWID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_MDPSDEFormId(boolean bl, PSDEFormDetail pSDEFormDetail, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFormDetail.isMDPSDEFormIdDirty() : !pSDEFormDetail.isMDPSDEFormIdDirty()) {
            return null;
        }
        String string = pSDEFormDetail.getMDPSDEFormId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_MDPSDEFormId_Default(pSDEFormDetail, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("MDPSDEFORMID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_MDPSDEGridId(boolean bl, PSDEFormDetail pSDEFormDetail, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFormDetail.isMDPSDEGridIdDirty() : !pSDEFormDetail.isMDPSDEGridIdDirty()) {
            return null;
        }
        String string = pSDEFormDetail.getMDPSDEGridId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_MDPSDEGridId_Default(pSDEFormDetail, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("MDPSDEGRIDID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_MDPSDEListId(boolean bl, PSDEFormDetail pSDEFormDetail, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFormDetail.isMDPSDEListIdDirty() : !pSDEFormDetail.isMDPSDEListIdDirty()) {
            return null;
        }
        String string = pSDEFormDetail.getMDPSDEListId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_MDPSDEListId_Default(pSDEFormDetail, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("MDPSDELISTID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_MDPSSysViewPanelId(boolean bl, PSDEFormDetail pSDEFormDetail, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFormDetail.isMDPSSysViewPanelIdDirty() : !pSDEFormDetail.isMDPSSysViewPanelIdDirty()) {
            return null;
        }
        String string = pSDEFormDetail.getMDPSSysViewPanelId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_MDPSSysViewPanelId_Default(pSDEFormDetail, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("MDPSSYSVIEWPANELID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Memo(boolean bl, PSDEFormDetail pSDEFormDetail, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFormDetail.isMemoDirty() : !pSDEFormDetail.isMemoDirty()) {
            return null;
        }
        String string = pSDEFormDetail.getMemo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Memo_Default(pSDEFormDetail, bl2, bl3);
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

    protected EntityFieldError onCheckField_ModelState(boolean bl, PSDEFormDetail pSDEFormDetail, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFormDetail.isModelStateDirty() : !pSDEFormDetail.isModelStateDirty()) {
            return null;
        }
        Integer n = pSDEFormDetail.getModelState();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_ModelState_Default(pSDEFormDetail, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("MODELSTATE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_NeedCodeListConfig(boolean bl, PSDEFormDetail pSDEFormDetail, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFormDetail.isNeedCodeListConfigDirty() : !pSDEFormDetail.isNeedCodeListConfigDirty()) {
            return null;
        }
        Integer n = pSDEFormDetail.getNeedCodeListConfig();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_NeedCodeListConfig_Default(pSDEFormDetail, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("NEEDCODELISTCONFIG");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_NoPrivDM(boolean bl, PSDEFormDetail pSDEFormDetail, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFormDetail.isNoPrivDMDirty() : !pSDEFormDetail.isNoPrivDMDirty()) {
            return null;
        }
        Integer n = pSDEFormDetail.getNoPrivDM();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_NoPrivDM_Default(pSDEFormDetail, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("NOPRIVDM");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_OpenPSDEViewId(boolean bl, PSDEFormDetail pSDEFormDetail, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFormDetail.isOpenPSDEViewIdDirty() : !pSDEFormDetail.isOpenPSDEViewIdDirty()) {
            return null;
        }
        String string = pSDEFormDetail.getOpenPSDEViewId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_OpenPSDEViewId_Default(pSDEFormDetail, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("OPENPSDEVIEWID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_OpenPSSysPDTViewId(boolean bl, PSDEFormDetail pSDEFormDetail, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFormDetail.isOpenPSSysPDTViewIdDirty() : !pSDEFormDetail.isOpenPSSysPDTViewIdDirty()) {
            return null;
        }
        String string = pSDEFormDetail.getOpenPSSysPDTViewId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_OpenPSSysPDTViewId_Default(pSDEFormDetail, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("OPENPSSYSPDTVIEWID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_OrderValue(boolean bl, PSDEFormDetail pSDEFormDetail, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFormDetail.isOrderValueDirty() : !pSDEFormDetail.isOrderValueDirty()) {
            return null;
        }
        Integer n = pSDEFormDetail.getOrderValue();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_OrderValue_Default(pSDEFormDetail, bl2, bl3);
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

    protected EntityFieldError onCheckField_Padding(boolean bl, PSDEFormDetail pSDEFormDetail, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFormDetail.isPaddingDirty() : !pSDEFormDetail.isPaddingDirty()) {
            return null;
        }
        String string = pSDEFormDetail.getPadding();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Padding_Default(pSDEFormDetail, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PADDING");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PHPSLanResId(boolean bl, PSDEFormDetail pSDEFormDetail, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFormDetail.isPHPSLanResIdDirty() : !pSDEFormDetail.isPHPSLanResIdDirty()) {
            return null;
        }
        String string = pSDEFormDetail.getPHPSLanResId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PHPSLanResId_Default(pSDEFormDetail, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PHPSLANRESID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PHPSLanResName(boolean bl, PSDEFormDetail pSDEFormDetail, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFormDetail.isPHPSLanResNameDirty() : !pSDEFormDetail.isPHPSLanResNameDirty()) {
            return null;
        }
        String string = pSDEFormDetail.getPHPSLanResName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PHPSLanResName_Default(pSDEFormDetail, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PHPSLANRESNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PickupPSDEViewId(boolean bl, PSDEFormDetail pSDEFormDetail, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFormDetail.isPickupPSDEViewIdDirty() : !pSDEFormDetail.isPickupPSDEViewIdDirty()) {
            return null;
        }
        String string = pSDEFormDetail.getPickupPSDEViewId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PickupPSDEViewId_Default(pSDEFormDetail, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PICKUPPSDEVIEWID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PlaceHolder(boolean bl, PSDEFormDetail pSDEFormDetail, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFormDetail.isPlaceHolderDirty() : !pSDEFormDetail.isPlaceHolderDirty()) {
            return null;
        }
        String string = pSDEFormDetail.getPlaceHolder();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PlaceHolder_Default(pSDEFormDetail, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PLACEHOLDER");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PPSDEFormDetailId(boolean bl, PSDEFormDetail pSDEFormDetail, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFormDetail.isPPSDEFormDetailIdDirty() : !pSDEFormDetail.isPPSDEFormDetailIdDirty()) {
            return null;
        }
        String string = pSDEFormDetail.getPPSDEFormDetailId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PPSDEFormDetailId_Default(pSDEFormDetail, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PPSDEFORMDETAILID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PredefinedType(boolean bl, PSDEFormDetail pSDEFormDetail, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFormDetail.isPredefinedTypeDirty() : !pSDEFormDetail.isPredefinedTypeDirty()) {
            return null;
        }
        String string = pSDEFormDetail.getPredefinedType();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PredefinedType_Default(pSDEFormDetail, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PREDEFINEDTYPE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PreventXSS(boolean bl, PSDEFormDetail pSDEFormDetail, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFormDetail.isPreventXSSDirty() : !pSDEFormDetail.isPreventXSSDirty()) {
            return null;
        }
        Integer n = pSDEFormDetail.getPreventXSS();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_PreventXSS_Default(pSDEFormDetail, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PREVENTXSS");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PreviewHtml(boolean bl, PSDEFormDetail pSDEFormDetail, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFormDetail.isPreviewHtmlDirty() : !pSDEFormDetail.isPreviewHtmlDirty()) {
            return null;
        }
        String string = pSDEFormDetail.getPreviewHtml();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PreviewHtml_Default(pSDEFormDetail, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PREVIEWHTML");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSCodeListId(boolean bl, PSDEFormDetail pSDEFormDetail, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFormDetail.isPSCodeListIdDirty() : !pSDEFormDetail.isPSCodeListIdDirty()) {
            return null;
        }
        String string = pSDEFormDetail.getPSCodeListId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSCodeListId_Default(pSDEFormDetail, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDEDRId(boolean bl, PSDEFormDetail pSDEFormDetail, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFormDetail.isPSDEDRIdDirty() : !pSDEFormDetail.isPSDEDRIdDirty()) {
            return null;
        }
        String string = pSDEFormDetail.getPSDEDRId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEDRId_Default(pSDEFormDetail, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEDRID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDEDRItemId(boolean bl, PSDEFormDetail pSDEFormDetail, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFormDetail.isPSDEDRItemIdDirty() : !pSDEFormDetail.isPSDEDRItemIdDirty()) {
            return null;
        }
        String string = pSDEFormDetail.getPSDEDRItemId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEDRItemId_Default(pSDEFormDetail, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEDRITEMID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDEFUIModeId(boolean bl, PSDEFormDetail pSDEFormDetail, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFormDetail.isPSDEFUIModeIdDirty() : !pSDEFormDetail.isPSDEFUIModeIdDirty()) {
            return null;
        }
        String string = pSDEFormDetail.getPSDEFUIModeId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEFUIModeId_Default(pSDEFormDetail, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEFFORMITEMID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDEFId(boolean bl, PSDEFormDetail pSDEFormDetail, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFormDetail.isPSDEFIdDirty() : !pSDEFormDetail.isPSDEFIdDirty()) {
            return null;
        }
        String string = pSDEFormDetail.getPSDEFId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEFId_Default(pSDEFormDetail, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEFID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDEFIUpdateId(boolean bl, PSDEFormDetail pSDEFormDetail, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFormDetail.isPSDEFIUpdateIdDirty() : !pSDEFormDetail.isPSDEFIUpdateIdDirty()) {
            return null;
        }
        String string = pSDEFormDetail.getPSDEFIUpdateId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEFIUpdateId_Default(pSDEFormDetail, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEFIUPDATEID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDEFName(boolean bl, PSDEFormDetail pSDEFormDetail, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFormDetail.isPSDEFNameDirty() : !pSDEFormDetail.isPSDEFNameDirty()) {
            return null;
        }
        String string = pSDEFormDetail.getPSDEFName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEFName_Default(pSDEFormDetail, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDEFormDetailId(boolean bl, PSDEFormDetail pSDEFormDetail, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFormDetail.isPSDEFormDetailIdDirty() && !bl2 : !pSDEFormDetail.isPSDEFormDetailIdDirty()) {
            return null;
        }
        String string = pSDEFormDetail.getPSDEFormDetailId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEFORMDETAILID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEFormDetailId_Default(pSDEFormDetail, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEFORMDETAILID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDEFormDetailName(boolean bl, PSDEFormDetail pSDEFormDetail, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFormDetail.isPSDEFormDetailNameDirty() && !bl2 : !pSDEFormDetail.isPSDEFormDetailNameDirty()) {
            return null;
        }
        String string = pSDEFormDetail.getPSDEFormDetailName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEFORMDETAILNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEFormDetailName_Default(pSDEFormDetail, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEFORMDETAILNAME");
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
                string3 = "PSDEFORMID";
                String string4 = this.checkFieldDupRule(this.getPSDEFormDetailDEModel(), "PSDEFORMDETAILNAME", string3, pSDEFormDetail, bl2, bl3);
                if (!StringHelper.isNullOrEmpty((String)string4)) {
                    EntityFieldError entityFieldError = new EntityFieldError();
                    entityFieldError.setFieldName("PSDEFORMDETAILNAME");
                    entityFieldError.setErrorType(3);
                    entityFieldError.setErrorInfo(string4);
                    return entityFieldError;
                }
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDEFormId(boolean bl, PSDEFormDetail pSDEFormDetail, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFormDetail.isPSDEFormIdDirty() && !bl2 : !pSDEFormDetail.isPSDEFormIdDirty()) {
            return null;
        }
        String string = pSDEFormDetail.getPSDEFormId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEFORMID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEFormId_Default(pSDEFormDetail, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEFORMID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDEFormRFId(boolean bl, PSDEFormDetail pSDEFormDetail, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFormDetail.isPSDEFormRFIdDirty() : !pSDEFormDetail.isPSDEFormRFIdDirty()) {
            return null;
        }
        String string = pSDEFormDetail.getPSDEFormRFId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEFormRFId_Default(pSDEFormDetail, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEFORMRFID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDEFSFItemId(boolean bl, PSDEFormDetail pSDEFormDetail, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFormDetail.isPSDEFSFItemIdDirty() : !pSDEFormDetail.isPSDEFSFItemIdDirty()) {
            return null;
        }
        String string = pSDEFormDetail.getPSDEFSFItemId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEFSFItemId_Default(pSDEFormDetail, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEFSFITEMID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDEFSFItemName(boolean bl, PSDEFormDetail pSDEFormDetail, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFormDetail.isPSDEFSFItemNameDirty() : !pSDEFormDetail.isPSDEFSFItemNameDirty()) {
            return null;
        }
        String string = pSDEFormDetail.getPSDEFSFItemName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEFSFItemName_Default(pSDEFormDetail, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEFSFITEMNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDELogicId(boolean bl, PSDEFormDetail pSDEFormDetail, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFormDetail.isPSDELogicIdDirty() : !pSDEFormDetail.isPSDELogicIdDirty()) {
            return null;
        }
        String string = pSDEFormDetail.getPSDELogicId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDELogicId_Default(pSDEFormDetail, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDELOGICID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDEUAGroupId(boolean bl, PSDEFormDetail pSDEFormDetail, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFormDetail.isPSDEUAGroupIdDirty() : !pSDEFormDetail.isPSDEUAGroupIdDirty()) {
            return null;
        }
        String string = pSDEFormDetail.getPSDEUAGroupId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEUAGroupId_Default(pSDEFormDetail, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEUAGROUPID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDEUIActionId(boolean bl, PSDEFormDetail pSDEFormDetail, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFormDetail.isPSDEUIActionIdDirty() : !pSDEFormDetail.isPSDEUIActionIdDirty()) {
            return null;
        }
        String string = pSDEFormDetail.getPSDEUIActionId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEUIActionId_Default(pSDEFormDetail, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEUIACTIONID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDynaInstId(boolean bl, PSDEFormDetail pSDEFormDetail, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFormDetail.isPSDynaInstIdDirty() : !pSDEFormDetail.isPSDynaInstIdDirty()) {
            return null;
        }
        String string = pSDEFormDetail.getPSDynaInstId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDynaInstId_Default(pSDEFormDetail, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSSysCounterId(boolean bl, PSDEFormDetail pSDEFormDetail, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFormDetail.isPSSysCounterIdDirty() : !pSDEFormDetail.isPSSysCounterIdDirty()) {
            return null;
        }
        String string = pSDEFormDetail.getPSSysCounterId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysCounterId_Default(pSDEFormDetail, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSCOUNTERID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSysCssId(boolean bl, PSDEFormDetail pSDEFormDetail, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFormDetail.isPSSysCssIdDirty() : !pSDEFormDetail.isPSSysCssIdDirty()) {
            return null;
        }
        String string = pSDEFormDetail.getPSSysCssId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysCssId_Default(pSDEFormDetail, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSSysCssName(boolean bl, PSDEFormDetail pSDEFormDetail, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFormDetail.isPSSysCssNameDirty() : !pSDEFormDetail.isPSSysCssNameDirty()) {
            return null;
        }
        String string = pSDEFormDetail.getPSSysCssName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysCssName_Default(pSDEFormDetail, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSSysDictCatId(boolean bl, PSDEFormDetail pSDEFormDetail, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFormDetail.isPSSysDictCatIdDirty() : !pSDEFormDetail.isPSSysDictCatIdDirty()) {
            return null;
        }
        String string = pSDEFormDetail.getPSSysDictCatId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysDictCatId_Default(pSDEFormDetail, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSDICTCATID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSysDynaModelId(boolean bl, PSDEFormDetail pSDEFormDetail, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFormDetail.isPSSysDynaModelIdDirty() : !pSDEFormDetail.isPSSysDynaModelIdDirty()) {
            return null;
        }
        String string = pSDEFormDetail.getPSSysDynaModelId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysDynaModelId_Default(pSDEFormDetail, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSDYNAMODELID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSysDynaModelName(boolean bl, PSDEFormDetail pSDEFormDetail, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFormDetail.isPSSysDynaModelNameDirty() : !pSDEFormDetail.isPSSysDynaModelNameDirty()) {
            return null;
        }
        String string = pSDEFormDetail.getPSSysDynaModelName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysDynaModelName_Default(pSDEFormDetail, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSDYNAMODELNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSysEditorStyleId(boolean bl, PSDEFormDetail pSDEFormDetail, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFormDetail.isPSSysEditorStyleIdDirty() : !pSDEFormDetail.isPSSysEditorStyleIdDirty()) {
            return null;
        }
        String string = pSDEFormDetail.getPSSysEditorStyleId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysEditorStyleId_Default(pSDEFormDetail, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSEDITORSTYLEID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSysImageId(boolean bl, PSDEFormDetail pSDEFormDetail, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFormDetail.isPSSysImageIdDirty() : !pSDEFormDetail.isPSSysImageIdDirty()) {
            return null;
        }
        String string = pSDEFormDetail.getPSSysImageId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysImageId_Default(pSDEFormDetail, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSSysResourceId(boolean bl, PSDEFormDetail pSDEFormDetail, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFormDetail.isPSSysResourceIdDirty() : !pSDEFormDetail.isPSSysResourceIdDirty()) {
            return null;
        }
        String string = pSDEFormDetail.getPSSysResourceId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysResourceId_Default(pSDEFormDetail, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSRESOURCEID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_RawContent(boolean bl, PSDEFormDetail pSDEFormDetail, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFormDetail.isRawContentDirty() : !pSDEFormDetail.isRawContentDirty()) {
            return null;
        }
        String string = pSDEFormDetail.getRawContent();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_RawContent_Default(pSDEFormDetail, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("RAWCONTENT");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_RawCssStyle(boolean bl, PSDEFormDetail pSDEFormDetail, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFormDetail.isRawCssStyleDirty() : !pSDEFormDetail.isRawCssStyleDirty()) {
            return null;
        }
        String string = pSDEFormDetail.getRawCssStyle();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_RawCssStyle_Default(pSDEFormDetail, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("RAWCSSSTYLE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_RawServiceMethod(boolean bl, PSDEFormDetail pSDEFormDetail, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFormDetail.isRawServiceMethodDirty() : !pSDEFormDetail.isRawServiceMethodDirty()) {
            return null;
        }
        String string = pSDEFormDetail.getRawServiceMethod();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_RawServiceMethod_Default(pSDEFormDetail, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("RAWSERVICEMETHOD");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_RawServiceUrl(boolean bl, PSDEFormDetail pSDEFormDetail, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFormDetail.isRawServiceUrlDirty() : !pSDEFormDetail.isRawServiceUrlDirty()) {
            return null;
        }
        String string = pSDEFormDetail.getRawServiceUrl();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_RawServiceUrl_Default(pSDEFormDetail, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("RAWSERVICEURL");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_RefPSDEACModeId(boolean bl, PSDEFormDetail pSDEFormDetail, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFormDetail.isRefPSDEACModeIdDirty() : !pSDEFormDetail.isRefPSDEACModeIdDirty()) {
            return null;
        }
        String string = pSDEFormDetail.getRefPSDEACModeId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_RefPSDEACModeId_Default(pSDEFormDetail, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("REFPSDEACMODEID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_RefPSDEDataSetId(boolean bl, PSDEFormDetail pSDEFormDetail, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFormDetail.isRefPSDEDataSetIdDirty() : !pSDEFormDetail.isRefPSDEDataSetIdDirty()) {
            return null;
        }
        String string = pSDEFormDetail.getRefPSDEDataSetId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_RefPSDEDataSetId_Default(pSDEFormDetail, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("REFPSDEDATASETID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_RefPSDEFormDetailId(boolean bl, PSDEFormDetail pSDEFormDetail, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFormDetail.isRefPSDEFormDetailIdDirty() : !pSDEFormDetail.isRefPSDEFormDetailIdDirty()) {
            return null;
        }
        String string = pSDEFormDetail.getRefPSDEFormDetailId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_RefPSDEFormDetailId_Default(pSDEFormDetail, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("REFPSDEFORMDETAILID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_RefPSDEId(boolean bl, PSDEFormDetail pSDEFormDetail, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFormDetail.isRefPSDEIdDirty() : !pSDEFormDetail.isRefPSDEIdDirty()) {
            return null;
        }
        String string = pSDEFormDetail.getRefPSDEId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_RefPSDEId_Default(pSDEFormDetail, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("REFPSDEID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_RefPSDEName(boolean bl, PSDEFormDetail pSDEFormDetail, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFormDetail.isRefPSDENameDirty() : !pSDEFormDetail.isRefPSDENameDirty()) {
            return null;
        }
        String string = pSDEFormDetail.getRefPSDEName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_RefPSDEName_Default(pSDEFormDetail, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("REFPSDENAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_RefPSDERId(boolean bl, PSDEFormDetail pSDEFormDetail, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFormDetail.isRefPSDERIdDirty() : !pSDEFormDetail.isRefPSDERIdDirty()) {
            return null;
        }
        String string = pSDEFormDetail.getRefPSDERId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_RefPSDERId_Default(pSDEFormDetail, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("REFPSDERID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_RefPSDERName(boolean bl, PSDEFormDetail pSDEFormDetail, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFormDetail.isRefPSDERNameDirty() : !pSDEFormDetail.isRefPSDERNameDirty()) {
            return null;
        }
        String string = pSDEFormDetail.getRefPSDERName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_RefPSDERName_Default(pSDEFormDetail, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("REFPSDERNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_RenderMode(boolean bl, PSDEFormDetail pSDEFormDetail, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFormDetail.isRenderModeDirty() : !pSDEFormDetail.isRenderModeDirty()) {
            return null;
        }
        String string = pSDEFormDetail.getRenderMode();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_RenderMode_Default(pSDEFormDetail, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("RENDERMODE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ResetItemName(boolean bl, PSDEFormDetail pSDEFormDetail, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFormDetail.isResetItemNameDirty() : !pSDEFormDetail.isResetItemNameDirty()) {
            return null;
        }
        String string = pSDEFormDetail.getResetItemName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_ResetItemName_Default(pSDEFormDetail, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("RESETITEMNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_RowSpan(boolean bl, PSDEFormDetail pSDEFormDetail, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFormDetail.isRowSpanDirty() : !pSDEFormDetail.isRowSpanDirty()) {
            return null;
        }
        Integer n = pSDEFormDetail.getRowSpan();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_RowSpan_Default(pSDEFormDetail, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ROWSPAN");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ShowCaption(boolean bl, PSDEFormDetail pSDEFormDetail, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFormDetail.isShowCaptionDirty() : !pSDEFormDetail.isShowCaptionDirty()) {
            return null;
        }
        Integer n = pSDEFormDetail.getShowCaption();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_ShowCaption_Default(pSDEFormDetail, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("SHOWCAPTION");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ShowMoreMode(boolean bl, PSDEFormDetail pSDEFormDetail, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFormDetail.isShowMoreModeDirty() : !pSDEFormDetail.isShowMoreModeDirty()) {
            return null;
        }
        Integer n = pSDEFormDetail.getShowMoreMode();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_ShowMoreMode_Default(pSDEFormDetail, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("SHOWMOREMODE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_SpacingBottom(boolean bl, PSDEFormDetail pSDEFormDetail, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFormDetail.isSpacingBottomDirty() : !pSDEFormDetail.isSpacingBottomDirty()) {
            return null;
        }
        String string = pSDEFormDetail.getSpacingBottom();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_SpacingBottom_Default(pSDEFormDetail, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("SPACINGBOTTOM");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_SpacingLeft(boolean bl, PSDEFormDetail pSDEFormDetail, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFormDetail.isSpacingLeftDirty() : !pSDEFormDetail.isSpacingLeftDirty()) {
            return null;
        }
        String string = pSDEFormDetail.getSpacingLeft();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_SpacingLeft_Default(pSDEFormDetail, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("SPACINGLEFT");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_SpacingRight(boolean bl, PSDEFormDetail pSDEFormDetail, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFormDetail.isSpacingRightDirty() : !pSDEFormDetail.isSpacingRightDirty()) {
            return null;
        }
        String string = pSDEFormDetail.getSpacingRight();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_SpacingRight_Default(pSDEFormDetail, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("SPACINGRIGHT");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_SpacingTop(boolean bl, PSDEFormDetail pSDEFormDetail, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFormDetail.isSpacingTopDirty() : !pSDEFormDetail.isSpacingTopDirty()) {
            return null;
        }
        String string = pSDEFormDetail.getSpacingTop();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_SpacingTop_Default(pSDEFormDetail, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("SPACINGTOP");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_SwapMode(boolean bl, PSDEFormDetail pSDEFormDetail, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFormDetail.isSwapModeDirty() : !pSDEFormDetail.isSwapModeDirty()) {
            return null;
        }
        String string = pSDEFormDetail.getSwapMode();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_SwapMode_Default(pSDEFormDetail, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("SWAPMODE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_TemplateMode(boolean bl, PSDEFormDetail pSDEFormDetail, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFormDetail.isTemplateModeDirty() : !pSDEFormDetail.isTemplateModeDirty()) {
            return null;
        }
        Integer n = pSDEFormDetail.getTemplateMode();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_TemplateMode_Default(pSDEFormDetail, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("TEMPLATEMODE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_TipPSLanResId(boolean bl, PSDEFormDetail pSDEFormDetail, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFormDetail.isTipPSLanResIdDirty() : !pSDEFormDetail.isTipPSLanResIdDirty()) {
            return null;
        }
        String string = pSDEFormDetail.getTipPSLanResId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_TipPSLanResId_Default(pSDEFormDetail, bl2, bl3);
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

    protected EntityFieldError onCheckField_TipPSLanResName(boolean bl, PSDEFormDetail pSDEFormDetail, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFormDetail.isTipPSLanResNameDirty() : !pSDEFormDetail.isTipPSLanResNameDirty()) {
            return null;
        }
        String string = pSDEFormDetail.getTipPSLanResName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_TipPSLanResName_Default(pSDEFormDetail, bl2, bl3);
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

    protected EntityFieldError onCheckField_TitleBarCloseMode(boolean bl, PSDEFormDetail pSDEFormDetail, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFormDetail.isTitleBarCloseModeDirty() : !pSDEFormDetail.isTitleBarCloseModeDirty()) {
            return null;
        }
        Integer n = pSDEFormDetail.getTitleBarCloseMode();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_TitleBarCloseMode_Default(pSDEFormDetail, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("TITLEBARCLOSEMODE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ToggleMode(boolean bl, PSDEFormDetail pSDEFormDetail, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFormDetail.isToggleModeDirty() : !pSDEFormDetail.isToggleModeDirty()) {
            return null;
        }
        String string = pSDEFormDetail.getToggleMode();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_ToggleMode_Default(pSDEFormDetail, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("TOGGLEMODE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_TooltipInfo(boolean bl, PSDEFormDetail pSDEFormDetail, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFormDetail.isTooltipInfoDirty() : !pSDEFormDetail.isTooltipInfoDirty()) {
            return null;
        }
        String string = pSDEFormDetail.getTooltipInfo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_TooltipInfo_Default(pSDEFormDetail, bl2, bl3);
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

    protected EntityFieldError onCheckField_UCPSSysPFPluginId(boolean bl, PSDEFormDetail pSDEFormDetail, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFormDetail.isUCPSSysPFPluginIdDirty() : !pSDEFormDetail.isUCPSSysPFPluginIdDirty()) {
            return null;
        }
        String string = pSDEFormDetail.getUCPSSysPFPluginId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UCPSSysPFPluginId_Default(pSDEFormDetail, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("UCPSSYSPFPLUGINID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_UpdateDV(boolean bl, PSDEFormDetail pSDEFormDetail, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFormDetail.isUpdateDVDirty() : !pSDEFormDetail.isUpdateDVDirty()) {
            return null;
        }
        String string = pSDEFormDetail.getUpdateDV();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UpdateDV_Default(pSDEFormDetail, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("UPDATEDV");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_UpdateDVT(boolean bl, PSDEFormDetail pSDEFormDetail, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFormDetail.isUpdateDVTDirty() : !pSDEFormDetail.isUpdateDVTDirty()) {
            return null;
        }
        String string = pSDEFormDetail.getUpdateDVT();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UpdateDVT_Default(pSDEFormDetail, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("UPDATEDVT");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_UserTag(boolean bl, PSDEFormDetail pSDEFormDetail, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFormDetail.isUserTagDirty() : !pSDEFormDetail.isUserTagDirty()) {
            return null;
        }
        String string = pSDEFormDetail.getUserTag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag_Default(pSDEFormDetail, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag2(boolean bl, PSDEFormDetail pSDEFormDetail, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFormDetail.isUserTag2Dirty() : !pSDEFormDetail.isUserTag2Dirty()) {
            return null;
        }
        String string = pSDEFormDetail.getUserTag2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag2_Default(pSDEFormDetail, bl2, bl3);
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

    protected EntityFieldError onCheckField_VAlign(boolean bl, PSDEFormDetail pSDEFormDetail, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFormDetail.isVAlignDirty() : !pSDEFormDetail.isVAlignDirty()) {
            return null;
        }
        String string = pSDEFormDetail.getVAlign();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_VAlign_Default(pSDEFormDetail, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("VALIGN");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_VAlignSelf(boolean bl, PSDEFormDetail pSDEFormDetail, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFormDetail.isVAlignSelfDirty() : !pSDEFormDetail.isVAlignSelfDirty()) {
            return null;
        }
        String string = pSDEFormDetail.getVAlignSelf();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_VAlignSelf_Default(pSDEFormDetail, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("VALIGNSELF");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ValueFormat(boolean bl, PSDEFormDetail pSDEFormDetail, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFormDetail.isValueFormatDirty() : !pSDEFormDetail.isValueFormatDirty()) {
            return null;
        }
        String string = pSDEFormDetail.getValueFormat();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_ValueFormat_Default(pSDEFormDetail, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("VALUEFORMAT");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ValueItemName(boolean bl, PSDEFormDetail pSDEFormDetail, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFormDetail.isValueItemNameDirty() : !pSDEFormDetail.isValueItemNameDirty()) {
            return null;
        }
        String string = pSDEFormDetail.getValueItemName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_ValueItemName_Default(pSDEFormDetail, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("VALUEITEMNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_VisibleLogic(boolean bl, PSDEFormDetail pSDEFormDetail, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFormDetail.isVisibleLogicDirty() : !pSDEFormDetail.isVisibleLogicDirty()) {
            return null;
        }
        String string = pSDEFormDetail.getVisibleLogic();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_VisibleLogic_Default(pSDEFormDetail, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("VISIBLELOGIC");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_WBDEFMode(boolean bl, PSDEFormDetail pSDEFormDetail, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFormDetail.isWBDEFModeDirty() : !pSDEFormDetail.isWBDEFModeDirty()) {
            return null;
        }
        Integer n = pSDEFormDetail.getWBDEFMode();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_WBDEFMode_Default(pSDEFormDetail, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("WBDEFMODE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Width(boolean bl, PSDEFormDetail pSDEFormDetail, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFormDetail.isWidthDirty() : !pSDEFormDetail.isWidthDirty()) {
            return null;
        }
        Integer n = pSDEFormDetail.getWidth();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_Width_Default(pSDEFormDetail, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("WIDTH");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_WidthMode(boolean bl, PSDEFormDetail pSDEFormDetail, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFormDetail.isWidthModeDirty() : !pSDEFormDetail.isWidthModeDirty()) {
            return null;
        }
        String string = pSDEFormDetail.getWidthMode();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_WidthMode_Default(pSDEFormDetail, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("WIDTHMODE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected void onSyncEntity(PSDEFormDetail pSDEFormDetail, boolean bl) throws Exception {
        super.onSyncEntity(pSDEFormDetail, bl);
    }

    protected void onSyncIndexEntities(PSDEFormDetail pSDEFormDetail, boolean bl) throws Exception {
        super.onSyncIndexEntities(pSDEFormDetail, bl);
    }

    public Object getDataContextValue(PSDEFormDetail pSDEFormDetail, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null) {
            if (StringHelper.compare((String)iDataContextParam.getDEName(), (String)"PSDEACMODE", (boolean)true) == 0 && StringHelper.compare((String)iDataContextParam.getDEFName(), (String)"PSDEID", (boolean)true) == 0 && (StringHelper.isNullOrEmpty((String)iDataContextParam.getReferItem()) || StringHelper.compare((String)iDataContextParam.getReferItem(), (String)"REFPSDEACMODEID", (boolean)true) == 0 || StringHelper.compare((String)iDataContextParam.getReferItem(), (String)"REFPSDEACMODENAME", (boolean)true) == 0) && (object = super.getDataContextValue(pSDEFormDetail, "refpsdeid", iDataContextParam)) != null) {
                return object;
            }
            if (StringHelper.compare((String)iDataContextParam.getDEName(), (String)"PSDEDATASET", (boolean)true) == 0 && StringHelper.compare((String)iDataContextParam.getDEFName(), (String)"PSDEID", (boolean)true) == 0 && (StringHelper.isNullOrEmpty((String)iDataContextParam.getReferItem()) || StringHelper.compare((String)iDataContextParam.getReferItem(), (String)"REFPSDEDATASETID", (boolean)true) == 0 || StringHelper.compare((String)iDataContextParam.getReferItem(), (String)"REFPSDEDATASETNAME", (boolean)true) == 0) && (object = super.getDataContextValue(pSDEFormDetail, "refpsdeid", iDataContextParam)) != null) {
                return object;
            }
            if (StringHelper.compare((String)iDataContextParam.getDEName(), (String)"PSDEDATAVIEW", (boolean)true) == 0 && StringHelper.compare((String)iDataContextParam.getDEFName(), (String)"PSDEID", (boolean)true) == 0 && (StringHelper.isNullOrEmpty((String)iDataContextParam.getReferItem()) || StringHelper.compare((String)iDataContextParam.getReferItem(), (String)"MDPSDEDATAVIEWID", (boolean)true) == 0 || StringHelper.compare((String)iDataContextParam.getReferItem(), (String)"MDPSDEDATAVIEWNAME", (boolean)true) == 0) && (object = super.getDataContextValue(pSDEFormDetail, "refpsdeid", iDataContextParam)) != null) {
                return object;
            }
            if (StringHelper.compare((String)iDataContextParam.getDEName(), (String)"PSDEFORMDETAIL", (boolean)true) == 0 && StringHelper.compare((String)iDataContextParam.getDEFName(), (String)"PSDEFORMID", (boolean)true) == 0 && (StringHelper.isNullOrEmpty((String)iDataContextParam.getReferItem()) || StringHelper.compare((String)iDataContextParam.getReferItem(), (String)"REFPSDEFORMDETAILID", (boolean)true) == 0 || StringHelper.compare((String)iDataContextParam.getReferItem(), (String)"REFPSDEFORMDETAILNAME", (boolean)true) == 0) && (object = super.getDataContextValue(pSDEFormDetail, "refpsdeformid", iDataContextParam)) != null) {
                return object;
            }
            if (StringHelper.compare((String)iDataContextParam.getDEName(), (String)"PSDEFORMRF", (boolean)true) == 0 && StringHelper.compare((String)iDataContextParam.getDEFName(), (String)"MAJORPSDEFORMID", (boolean)true) == 0 && (StringHelper.isNullOrEmpty((String)iDataContextParam.getReferItem()) || StringHelper.compare((String)iDataContextParam.getReferItem(), (String)"PSDEFORMRFID", (boolean)true) == 0 || StringHelper.compare((String)iDataContextParam.getReferItem(), (String)"PSDEFORMRFNAME", (boolean)true) == 0 || StringHelper.compare((String)iDataContextParam.getReferItem(), (String)"REFPSDEFORMID", (boolean)true) == 0) && (object = super.getDataContextValue(pSDEFormDetail, "psdeformid", iDataContextParam)) != null) {
                return object;
            }
            if (StringHelper.compare((String)iDataContextParam.getDEName(), (String)"PSDEFORM", (boolean)true) == 0 && StringHelper.compare((String)iDataContextParam.getDEFName(), (String)"PSDEID", (boolean)true) == 0 && (StringHelper.isNullOrEmpty((String)iDataContextParam.getReferItem()) || StringHelper.compare((String)iDataContextParam.getReferItem(), (String)"MDPSDEFORMID", (boolean)true) == 0 || StringHelper.compare((String)iDataContextParam.getReferItem(), (String)"MDPSDEFORMNAME", (boolean)true) == 0) && (object = super.getDataContextValue(pSDEFormDetail, "refpsdeid", iDataContextParam)) != null) {
                return object;
            }
            if (StringHelper.compare((String)iDataContextParam.getDEName(), (String)"PSDEGRID", (boolean)true) == 0 && StringHelper.compare((String)iDataContextParam.getDEFName(), (String)"PSDEID", (boolean)true) == 0 && (StringHelper.isNullOrEmpty((String)iDataContextParam.getReferItem()) || StringHelper.compare((String)iDataContextParam.getReferItem(), (String)"MDPSDEGRIDID", (boolean)true) == 0 || StringHelper.compare((String)iDataContextParam.getReferItem(), (String)"MDPSDEGRIDNAME", (boolean)true) == 0) && (object = super.getDataContextValue(pSDEFormDetail, "refpsdeid", iDataContextParam)) != null) {
                return object;
            }
            if (StringHelper.compare((String)iDataContextParam.getDEName(), (String)"PSDELIST", (boolean)true) == 0 && StringHelper.compare((String)iDataContextParam.getDEFName(), (String)"PSDEID", (boolean)true) == 0 && (StringHelper.isNullOrEmpty((String)iDataContextParam.getReferItem()) || StringHelper.compare((String)iDataContextParam.getReferItem(), (String)"MDPSDELISTID", (boolean)true) == 0 || StringHelper.compare((String)iDataContextParam.getReferItem(), (String)"MDPSDELISTNAME", (boolean)true) == 0) && (object = super.getDataContextValue(pSDEFormDetail, "refpsdeid", iDataContextParam)) != null) {
                return object;
            }
            if (StringHelper.compare((String)iDataContextParam.getDEName(), (String)"PSSYSEDITORSTYLE", (boolean)true) == 0 && StringHelper.compare((String)iDataContextParam.getDEFName(), (String)"PSEDITORTYPEID", (boolean)true) == 0 && (StringHelper.isNullOrEmpty((String)iDataContextParam.getReferItem()) || StringHelper.compare((String)iDataContextParam.getReferItem(), (String)"PSSYSEDITORSTYLEID", (boolean)true) == 0 || StringHelper.compare((String)iDataContextParam.getReferItem(), (String)"PSSYSEDITORSTYLENAME", (boolean)true) == 0) && (object = super.getDataContextValue(pSDEFormDetail, "editortype", iDataContextParam)) != null) {
                return object;
            }
        }
        if ((object = super.getDataContextValue(pSDEFormDetail, string, iDataContextParam)) != null) {
            return object;
        }
        PSDEForm pSDEForm = pSDEFormDetail.getPSDEForm();
        if (pSDEForm != null && pSDEForm.contains(string)) {
            return pSDEForm.get(string);
        }
        return null;
    }

    protected void onExportMajorModel(PSDEFormDetail pSDEFormDetail, ArrayList<JSONObject> arrayList, int n) throws Exception {
        this.onExportMajorModel_CapPSLanRes(pSDEFormDetail, arrayList, n);
        super.onExportMajorModel(pSDEFormDetail, arrayList, n);
    }

    protected void onExportMajorModel_CapPSLanRes(PSDEFormDetail pSDEFormDetail, ArrayList<JSONObject> arrayList, int n) throws Exception {
        if (pSDEFormDetail.getCapPSLanRes() != null) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSLanguageResService", (SessionFactory)this.getSessionFactory());
            iService.exportModel(pSDEFormDetail.getCapPSLanRes(), arrayList, n);
        }
    }

    protected String onTestValueRule(String string, String string2, IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        if (StringHelper.compare((String)string, (String)"ALLOWEMPTY", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_AllowEmpty_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"BLANKLOGIC", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_BlankLogic_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"BL_POS", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_BL_Pos_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"BORDERSTYLE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_BorderStyle_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"BTNACTIONTYPE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_BtnActionType_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"BUILDINACTION", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_BuildInAction_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CAPPSLANRESID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CapPSLanResId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CAPPSLANRESNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CapPSLanResName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CAPTION", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Caption_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CHILD_COL_LG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Child_Col_LG_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CHILD_COL_MD", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Child_Col_MD_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CHILD_COL_SM", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Child_Col_SM_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CHILD_COL_XS", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Child_Col_XS_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CODELISTCONFIGMODE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CodeListConfigMode_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"COLALIGN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ColAlign_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"COLID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ColId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"COLMODEL", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ColModel_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"COLSPAN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ColSpan_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"COL_LG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Col_LG_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"COL_LG_OS", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Col_LG_OS_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"COL_MD", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Col_MD_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"COL_MD_OS", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Col_MD_OS_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"COL_SM", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Col_SM_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"COL_SM_OS", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Col_SM_OS_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"COL_WIDTH", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Col_Width_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"COL_XS", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Col_XS_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"COL_XS_OS", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Col_XS_OS_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CONTENTTYPE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ContentType_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CONVERTCITEXT", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ConvertCIText_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"COUNTERID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CounterId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"COUNTERMODE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CounterMode_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATEDATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateDate_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATEDV", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateDV_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATEDVT", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateDVT_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATEMAN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateMan_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CSSID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CssId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CTRLCOLSPAN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CtrlColSpan_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CTRLDYNACLASS", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CtrlDynaClass_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CTRLHEIGHT", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CtrlHeight_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CTRLPSSYSCSSID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CtrlPSSysCssId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CTRLPSSYSCSSNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CtrlPSSysCssName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CTRLRAWCSSSTYLE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CtrlRawCssStyle_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CTRLWIDTH", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CtrlWidth_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CUSTOMCODE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CustomCode_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DATA", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Data_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DEFAULTFLAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DefaultFlag_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DETAILSTYLE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DetailStyle_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DETAILSTYLETEXT", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DetailStyleText_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DETAILTAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DetailTag_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DETAILTAG2", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DetailTag2_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DETAILTYPE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DetailType_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DYNACLASS", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DynaClass_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DYNAMODELFLAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DynaModelFlag_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"EDITORPARAMS", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_EditorParams_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"EDITORTYPE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_EditorType_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"EDITORTYPENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_EditorTypeName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"EMPTYCAPTION", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_EmptyCaption_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ENABLEANCHOR", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_EnableAnchor_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ENABLECOND", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_EnableCond_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ENABLEINPUTTIP", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_EnableInputTip_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ENABLEITEMPRIV", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_EnableItemPriv_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ENABLELOGIC", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_EnableLogic_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"FIELDNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_FieldName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"FLEXALIGN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_FlexAlign_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"FLEXBASIS", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_FlexBasis_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"FLEXDIR", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_FlexDir_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"FLEXGROW", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_FlexGrow_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"FLEXSHRINK", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_FlexShrink_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"FLEXVALIGN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_FlexVAlign_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"FORMTYPE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_FormType_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"GRIDROWID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_GridRowId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"HALIGN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_HAlign_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"HALIGNSELF", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_HAlignSelf_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"HEIGHT", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Height_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"HEIGHTMODE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_HeightMode_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"HTMLCONTENT", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_HtmlContent_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"HTMLPAGEURL", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_HtmlPageUrl_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ICONALIGN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_IconAlign_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"IGNOREINPUT", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_IgnoreInput_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"INSERTPOS", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_InsertPos_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ITEMPSACHANDLERID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ItemPSACHandlerId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ITEMPSACHANDLERNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ItemPSACHandlerName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ITEMSTATES", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ItemStates_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"LABELCOLSPAN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_LabelColSpan_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"LABELCOLSPAN2", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_LabelColSpan2_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"LABELCSSID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_LabelCssId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"LABELDYNACLASS", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_LabelDynaClass_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"LABELPOS", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_LabelPos_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"LABELPSSYSCSSID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_LabelPSSysCssId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"LABELPSSYSCSSNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_LabelPSSysCssName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"LABELRAWCSSSTYLE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_LabelRawCssStyle_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"LABELWIDTH", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_LabelWidth_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"LAYOUTMODE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_LayoutMode_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"LEVELTAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_LevelTag_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"LEVELVALUE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_LevelValue_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"LINKPSDEVIEWID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_LinkPSDEViewId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"LINKPSDEVIEWNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_LinkPSDEViewName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"LOGICNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_LogicName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MARGIN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Margin_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MASKINFO", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_MaskInfo_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MASKMODE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_MaskMode_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MASKPSLANRESID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_MaskPSLanResId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MASKPSLANRESNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_MaskPSLanResName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MDCTRLTYPE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_MDCtrlType_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MDPSDEDATAVIEWID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_MDPSDEDataViewId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MDPSDEDATAVIEWNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_MDPSDEDataViewName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MDPSDEFORMID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_MDPSDEFormId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MDPSDEFORMNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_MDPSDEFormName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MDPSDEGRIDID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_MDPSDEGridId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MDPSDEGRIDNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_MDPSDEGridName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MDPSDELISTID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_MDPSDEListId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MDPSDELISTNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_MDPSDEListName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MDPSSYSVIEWPANELID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_MDPSSysViewPanelId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MDPSSYSVIEWPANELNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_MDPSSysViewPanelName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MEMO", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Memo_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MOBFLAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_MobFlag_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MODELSTATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ModelState_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"NEEDCODELISTCONFIG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_NeedCodeListConfig_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"NOPRIVDM", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_NoPrivDM_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"OPENPSDEVIEWID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_OpenPSDEViewId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"OPENPSDEVIEWNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_OpenPSDEViewName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"OPENPSSYSPDTVIEWID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_OpenPSSysPDTViewId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"OPENPSSYSPDTVIEWNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_OpenPSSysPDTViewName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ORDERVALUE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_OrderValue_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PADDING", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Padding_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PHPSLANRESID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PHPSLanResId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PHPSLANRESNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PHPSLanResName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PICKUPPSDEVIEWID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PickupPSDEViewId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PICKUPPSDEVIEWNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PickupPSDEViewName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PLACEHOLDER", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PlaceHolder_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PLAYOUTMODE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PLayoutMode_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PPSDEFORMDETAILID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PPSDEFormDetailId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PPSDEFORMDETAILNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PPSDEFormDetailName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PREDEFINEDTYPE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PredefinedType_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PREDEFINEDTYPETEXT", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PredefinedTypeText_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PREVENTXSS", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PreventXSS_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PREVIEWHTML", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PreviewHtml_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSCODELISTID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSCodeListId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSCODELISTNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSCodeListName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEDRID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEDRId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEDRITEMID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEDRItemId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEDRITEMNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEDRItemName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEDRNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEDRName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEFFORMITEMID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEFUIModeId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEFFORMITEMNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEFUIModeName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEFID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEFId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEFIUPDATEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEFIUpdateId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEFIUPDATENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEFIUpdateName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEFNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEFName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEFORMDETAILID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEFormDetailId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEFORMDETAILNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEFormDetailName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEFORMID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEFormId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEFORMNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEFormName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEFORMRFID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEFormRFId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEFORMRFNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEFormRFName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEFSFITEMID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEFSFItemId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEFSFITEMNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEFSFItemName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDELOGICID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDELogicId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDELOGICNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDELogicName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEUAGROUPID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEUAGroupId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEUAGROUPNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEUAGroupName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEUIACTIONID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEUIActionId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEUIACTIONNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEUIActionName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDYNAINSTID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDynaInstId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSCOUNTERID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysCounterId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSCOUNTERNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysCounterName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSCSSID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysCssId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSCSSNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysCssName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSDICTCATID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysDictCatId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSDICTCATNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysDictCatName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSDYNAMODELID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysDynaModelId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSDYNAMODELNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysDynaModelName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSEDITORSTYLEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysEditorStyleId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSEDITORSTYLENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysEditorStyleName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSIMAGEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysImageId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSIMAGENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysImageName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSRESOURCEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysResourceId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSRESOURCENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysResourceName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"RAWCONTENT", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_RawContent_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"RAWCSSSTYLE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_RawCssStyle_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"RAWSERVICEMETHOD", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_RawServiceMethod_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"RAWSERVICEURL", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_RawServiceUrl_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"REFPSDEACMODEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_RefPSDEACModeId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"REFPSDEACMODENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_RefPSDEACModeName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"REFPSDEDATASETID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_RefPSDEDataSetId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"REFPSDEDATASETNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_RefPSDEDataSetName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"REFPSDEFORMDETAILID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_RefPSDEFormDetailId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"REFPSDEFORMDETAILNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_RefPSDEFormDetailName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"REFPSDEFORMID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_RefPSDEFormId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"REFPSDEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_RefPSDEId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"REFPSDENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_RefPSDEName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"REFPSDERID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_RefPSDERId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"REFPSDERNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_RefPSDERName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"RENDERMODE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_RenderMode_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"RENDERMODETEXT", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_RenderModeText_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"RESETITEMNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ResetItemName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ROWSPAN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_RowSpan_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"SHOWCAPTION", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ShowCaption_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"SHOWMOREMODE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ShowMoreMode_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"SPACINGBOTTOM", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_SpacingBottom_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"SPACINGLEFT", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_SpacingLeft_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"SPACINGRIGHT", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_SpacingRight_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"SPACINGTOP", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_SpacingTop_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"SWAPMODE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_SwapMode_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"TEMPLATEMODE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_TemplateMode_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"TIPPSLANRESID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_TipPSLanResId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"TIPPSLANRESNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_TipPSLanResName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"TITLEBARCLOSEMODE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_TitleBarCloseMode_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"TOGGLEMODE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ToggleMode_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"TOOLTIPINFO", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_TooltipInfo_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UCPSSYSPFPLUGINID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UCPSSysPFPluginId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UCPSSYSPFPLUGINNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UCPSSysPFPluginName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UPDATEDATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UpdateDate_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UPDATEDV", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UpdateDV_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UPDATEDVT", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UpdateDVT_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UPDATEMAN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UpdateMan_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"USERTAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UserTag_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"USERTAG2", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UserTag2_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"VALIGN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_VAlign_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"VALIGNSELF", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_VAlignSelf_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"VALUEFORMAT", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ValueFormat_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"VALUEITEMNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ValueItemName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"VISIBLELOGIC", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_VisibleLogic_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"WBDEFMODE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_WBDEFMode_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"WIDTH", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Width_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"WIDTHMODE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_WidthMode_Default(iEntity, bl, bl2);
        }
        return super.onTestValueRule(string, string2, iEntity, bl, bl2);
    }

    protected String onTestValueRule_AllowEmpty_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_BlankLogic_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("BLANKLOGIC", iEntity, bl2, null, false, 0x100000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_BL_Pos_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("BL_POS", iEntity, bl2, null, false, 10, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[10]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[10]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_BorderStyle_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("BORDERSTYLE", iEntity, bl2, null, false, 30, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_BtnActionType_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("BTNACTIONTYPE", iEntity, bl2, null, false, 20, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[20]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[20]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_BuildInAction_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
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
            if (this.checkFieldStringLengthRule("CAPTION", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_Child_Col_LG_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_Child_Col_MD_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_Child_Col_SM_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_Child_Col_XS_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_CodeListConfigMode_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_ColAlign_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("COLALIGN", iEntity, bl2, null, false, 20, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[20]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[20]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_ColId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_ColModel_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("COLMODEL", iEntity, bl2, null, false, 50, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_ColSpan_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_Col_LG_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_Col_LG_OS_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_Col_MD_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_Col_MD_OS_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_Col_SM_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_Col_SM_OS_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_Col_Width_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_Col_XS_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_Col_XS_OS_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_ContentType_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("CONTENTTYPE", iEntity, bl2, null, false, 20, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[20]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[20]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_ConvertCIText_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_CounterId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("COUNTERID", iEntity, bl2, null, false, 60, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_CounterMode_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_CreateDate_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_CreateDV_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("CREATEDV", iEntity, bl2, null, false, 500, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[500]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[500]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_CreateDVT_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("CREATEDVT", iEntity, bl2, null, false, 50, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
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

    protected String onTestValueRule_CssId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("CSSID", iEntity, bl2, null, false, 50, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_CtrlColSpan_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_CtrlDynaClass_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("CTRLDYNACLASS", iEntity, bl2, null, false, 0x100000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_CtrlHeight_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_CtrlPSSysCssId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("CTRLPSSYSCSSID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_CtrlPSSysCssName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("CTRLPSSYSCSSNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_CtrlRawCssStyle_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("CTRLRAWCSSSTYLE", iEntity, bl2, null, false, 0x100000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_CtrlWidth_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_CustomCode_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("CUSTOMCODE", iEntity, bl2, null, false, 0x100000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_Data_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("DATA", iEntity, bl2, null, false, 2000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[2000]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[2000]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_DefaultFlag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_DetailStyle_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("DETAILSTYLE", iEntity, bl2, null, false, 16, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[16]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[16]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_DetailStyleText_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("DETAILSTYLETEXT", iEntity, bl2, null, false, 50, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_DetailTag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("DETAILTAG", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_DetailTag2_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("DETAILTAG2", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_DetailType_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("DETAILTYPE", iEntity, bl2, null, false, 20, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[20]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[20]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_DynaClass_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("DYNACLASS", iEntity, bl2, null, false, 0x100000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_DynaModelFlag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_EditorParams_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("EDITORPARAMS", iEntity, bl2, null, false, 2000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[2000]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[2000]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_EditorType_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("EDITORTYPE", iEntity, bl2, null, false, 40, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[40]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[40]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_EditorTypeName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("EDITORTYPENAME", iEntity, bl2, null, false, 50, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_EmptyCaption_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_EnableAnchor_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_EnableCond_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_EnableInputTip_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_EnableItemPriv_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_EnableLogic_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("ENABLELOGIC", iEntity, bl2, null, false, 0x100000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_FieldName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("FIELDNAME", iEntity, bl2, null, false, 30, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_FlexAlign_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("FLEXALIGN", iEntity, bl2, null, false, 20, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[20]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[20]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_FlexBasis_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_FlexDir_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("FLEXDIR", iEntity, bl2, null, false, 30, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_FlexGrow_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_FlexShrink_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_FlexVAlign_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("FLEXVALIGN", iEntity, bl2, null, false, 20, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[20]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[20]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_FormType_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("FORMTYPE", iEntity, bl2, null, false, 20, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[20]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[20]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_GridRowId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_HAlign_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("HALIGN", iEntity, bl2, null, false, 30, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_HAlignSelf_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("HALIGNSELF", iEntity, bl2, null, false, 30, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_Height_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_HeightMode_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("HEIGHTMODE", iEntity, bl2, null, false, 30, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_HtmlContent_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("HTMLCONTENT", iEntity, bl2, null, false, 0x100000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_HtmlPageUrl_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("HTMLPAGEURL", iEntity, bl2, null, false, 300, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[300]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[300]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_IconAlign_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("ICONALIGN", iEntity, bl2, null, false, 20, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[20]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[20]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_IgnoreInput_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_InsertPos_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_ItemPSACHandlerId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("ITEMPSACHANDLERID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_ItemPSACHandlerName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("ITEMPSACHANDLERNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_ItemStates_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_LabelColSpan_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_LabelColSpan2_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_LabelCssId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("LABELCSSID", iEntity, bl2, null, false, 40, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[40]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[40]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_LabelDynaClass_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("LABELDYNACLASS", iEntity, bl2, null, false, 0x100000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_LabelPos_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("LABELPOS", iEntity, bl2, null, false, 10, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[10]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[10]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_LabelPSSysCssId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("LABELPSSYSCSSID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_LabelPSSysCssName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("LABELPSSYSCSSNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_LabelRawCssStyle_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("LABELRAWCSSSTYLE", iEntity, bl2, null, false, 0x100000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_LabelWidth_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_LayoutMode_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("LAYOUTMODE", iEntity, bl2, null, false, 20, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[20]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[20]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
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

    protected String onTestValueRule_LinkPSDEViewId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("LINKPSDEVIEWID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_LinkPSDEViewName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("LINKPSDEVIEWNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
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
            if (this.checkFieldStringLengthRule("LOGICNAME", iEntity, bl2, null, false, 50, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_Margin_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("MARGIN", iEntity, bl2, null, false, 50, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_MaskInfo_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("MASKINFO", iEntity, bl2, null, false, 500, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[500]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[500]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_MaskMode_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_MaskPSLanResId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("MASKPSLANRESID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_MaskPSLanResName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("MASKPSLANRESNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_MDCtrlType_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("MDCTRLTYPE", iEntity, bl2, null, false, 10, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[10]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[10]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_MDPSDEDataViewId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("MDPSDEDATAVIEWID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_MDPSDEDataViewName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("MDPSDEDATAVIEWNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_MDPSDEFormId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("MDPSDEFORMID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_MDPSDEFormName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("MDPSDEFORMNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_MDPSDEGridId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("MDPSDEGRIDID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_MDPSDEGridName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("MDPSDEGRIDNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_MDPSDEListId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("MDPSDELISTID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_MDPSDEListName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("MDPSDELISTNAME", iEntity, bl2, null, false, 30, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_MDPSSysViewPanelId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("MDPSSYSVIEWPANELID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_MDPSSysViewPanelName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("MDPSSYSVIEWPANELNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
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

    protected String onTestValueRule_MobFlag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_ModelState_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_NeedCodeListConfig_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_NoPrivDM_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_OpenPSDEViewId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("OPENPSDEVIEWID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_OpenPSDEViewName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("OPENPSDEVIEWNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_OpenPSSysPDTViewId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("OPENPSSYSPDTVIEWID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_OpenPSSysPDTViewName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("OPENPSSYSPDTVIEWNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_OrderValue_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_Padding_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PADDING", iEntity, bl2, null, false, 50, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PHPSLanResId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PHPSLANRESID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PHPSLanResName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PHPSLANRESNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PickupPSDEViewId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PICKUPPSDEVIEWID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PickupPSDEViewName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PICKUPPSDEVIEWNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PlaceHolder_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PLACEHOLDER", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PLayoutMode_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PLAYOUTMODE", iEntity, bl2, null, false, 20, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[20]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[20]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PPSDEFormDetailId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PPSDEFORMDETAILID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PPSDEFormDetailName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PPSDEFORMDETAILNAME", iEntity, bl2, null, false, 80, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[80]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[80]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PredefinedType_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PREDEFINEDTYPE", iEntity, bl2, null, false, 30, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PredefinedTypeText_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PREDEFINEDTYPETEXT", iEntity, bl2, null, false, 50, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PreventXSS_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_PreviewHtml_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PREVIEWHTML", iEntity, bl2, null, false, 10, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[10]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[10]";
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

    protected String onTestValueRule_PSDEDRId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEDRID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDEDRItemId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEDRITEMID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDEDRItemName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEDRITEMNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDEDRName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEDRNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDEFUIModeId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEFFORMITEMID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
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
            if (this.checkFieldStringLengthRule("PSDEFFORMITEMNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
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

    protected String onTestValueRule_PSDEFIUpdateId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEFIUPDATEID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDEFIUpdateName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEFIUPDATENAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
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

    protected String onTestValueRule_PSDEFormDetailId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEFORMDETAILID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDEFormDetailName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEFORMDETAILNAME", iEntity, bl2, null, false, 80, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[80]", false) && this.checkFieldRegExRule("PSDEFORMDETAILNAME", iEntity, bl2, "[A-Za-z_]+[\\w@]*", "\u5185\u5bb9\u53ea\u80fd\u7531\u5b57\u6bcd\u3001\u6570\u5b57\u3001\u4e0b\u5212\u7ebf\u53ca@\u7ec4\u6210\uff0c\u4e14\u5f00\u59cb\u5fc5\u987b\u4e3a\u5b57\u6bcd", false)) {
                return null;
            }
            return "(\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[80] \u5e76\u4e14 \u5185\u5bb9\u53ea\u80fd\u7531\u5b57\u6bcd\u3001\u6570\u5b57\u3001\u4e0b\u5212\u7ebf\u53ca@\u7ec4\u6210\uff0c\u4e14\u5f00\u59cb\u5fc5\u987b\u4e3a\u5b57\u6bcd)";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDEFormId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEFORMID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDEFormName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEFORMNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDEFormRFId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEFORMRFID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDEFormRFName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEFORMRFNAME", iEntity, bl2, null, false, 20, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[20]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[20]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDEFSFItemId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEFSFITEMID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDEFSFItemName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEFSFITEMNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
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

    protected String onTestValueRule_PSDELogicId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDELOGICID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDELogicName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDELOGICNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDEUAGroupId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEUAGROUPID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDEUAGroupName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEUAGROUPNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDEUIActionId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEUIACTIONID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDEUIActionName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEUIACTIONNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
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

    protected String onTestValueRule_PSSysCounterId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSCOUNTERID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysCounterName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSCOUNTERNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
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

    protected String onTestValueRule_PSSysDictCatId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSDICTCATID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysDictCatName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSDICTCATNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysDynaModelId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSDYNAMODELID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysDynaModelName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSDYNAMODELNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysEditorStyleId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSEDITORSTYLEID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysEditorStyleName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSEDITORSTYLENAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
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

    protected String onTestValueRule_PSSysResourceId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSRESOURCEID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysResourceName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSRESOURCENAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_RawContent_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("RAWCONTENT", iEntity, bl2, null, false, 0x100000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_RawCssStyle_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("RAWCSSSTYLE", iEntity, bl2, null, false, 0x100000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_RawServiceMethod_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("RAWSERVICEMETHOD", iEntity, bl2, null, false, 20, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[20]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[20]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_RawServiceUrl_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("RAWSERVICEURL", iEntity, bl2, null, false, 0x100000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_RefPSDEACModeId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("REFPSDEACMODEID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_RefPSDEACModeName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("REFPSDEACMODENAME", iEntity, bl2, null, false, 30, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_RefPSDEDataSetId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("REFPSDEDATASETID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_RefPSDEDataSetName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("REFPSDEDATASETNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_RefPSDEFormDetailId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("REFPSDEFORMDETAILID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_RefPSDEFormDetailName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("REFPSDEFORMDETAILNAME", iEntity, bl2, null, false, 80, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[80]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[80]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_RefPSDEFormId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("REFPSDEFORMID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_RefPSDEId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("REFPSDEID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_RefPSDEName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("REFPSDENAME", iEntity, bl2, null, false, 60, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_RefPSDERId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("REFPSDERID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_RefPSDERName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("REFPSDERNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_RenderMode_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("RENDERMODE", iEntity, bl2, null, false, 30, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_RenderModeText_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("RENDERMODETEXT", iEntity, bl2, null, false, 50, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_ResetItemName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("RESETITEMNAME", iEntity, bl2, null, false, 60, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_RowSpan_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_ShowCaption_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_ShowMoreMode_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_SpacingBottom_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("SPACINGBOTTOM", iEntity, bl2, null, false, 20, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[20]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[20]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_SpacingLeft_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("SPACINGLEFT", iEntity, bl2, null, false, 20, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[20]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[20]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_SpacingRight_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("SPACINGRIGHT", iEntity, bl2, null, false, 20, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[20]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[20]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_SpacingTop_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("SPACINGTOP", iEntity, bl2, null, false, 20, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[20]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[20]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_SwapMode_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("SWAPMODE", iEntity, bl2, null, false, 30, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_TemplateMode_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
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

    protected String onTestValueRule_TitleBarCloseMode_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_ToggleMode_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("TOGGLEMODE", iEntity, bl2, null, false, 30, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]";
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

    protected String onTestValueRule_UCPSSysPFPluginId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("UCPSSYSPFPLUGINID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_UCPSSysPFPluginName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("UCPSSYSPFPLUGINNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
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

    protected String onTestValueRule_UpdateDV_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("UPDATEDV", iEntity, bl2, null, false, 500, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[500]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[500]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_UpdateDVT_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("UPDATEDVT", iEntity, bl2, null, false, 50, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
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

    protected String onTestValueRule_VAlign_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("VALIGN", iEntity, bl2, null, false, 30, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_VAlignSelf_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("VALIGNSELF", iEntity, bl2, null, false, 30, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_ValueFormat_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("VALUEFORMAT", iEntity, bl2, null, false, 50, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_ValueItemName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("VALUEITEMNAME", iEntity, bl2, null, false, 60, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_VisibleLogic_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("VISIBLELOGIC", iEntity, bl2, null, false, 0x100000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_WBDEFMode_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_Width_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_WidthMode_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("WIDTHMODE", iEntity, bl2, null, false, 30, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    @Override
    protected boolean isPrepareLastForUpdate() {
        return true;
    }

    protected boolean onMergeChild(String string, String string2, PSDEFormDetail pSDEFormDetail) throws Exception {
        boolean bl = false;
        if (super.onMergeChild(string, string2, pSDEFormDetail)) {
            bl = true;
        }
        return bl;
    }

    protected void onUpdateParent(PSDEFormDetail pSDEFormDetail) throws Exception {
        super.onUpdateParent(pSDEFormDetail);
    }

    protected void onCopyDetails(PSDEFormDetail pSDEFormDetail, Object object) throws Exception {
        PSDEFormDetail pSDEFormDetail2 = new PSDEFormDetail();
        pSDEFormDetail2.set("PSDEFORMDETAILID", object);
        String string = DataObject.getStringValue((Object)pSDEFormDetail.get("PSDEFORMDETAILID"));
        super.onCopyDetails(pSDEFormDetail, object);
    }

    @Override
    protected void exportCurXmlModel(PSDEFormDetail pSDEFormDetail, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSDEFORMDETAIL");
        if (!bl) {
            pSDEFormDetail.setCreateDate(null);
            pSDEFormDetail.setCreateMan(null);
            pSDEFormDetail.setLevelValue(null);
            pSDEFormDetail.setPSDEFormDetailId(null);
            pSDEFormDetail.setUpdateDate(null);
            pSDEFormDetail.setUpdateMan(null);
            pSDEFormDetail.setPSDEFIUpdateId(null);
            pSDEFormDetail.setRefPSDEFormDetailId(null);
            pSDEFormDetail.setPSDEFormRFId(null);
            pSDEFormDetail.setRefPSDEFormId(null);
            pSDEFormDetail.setPLayoutMode(null);
            pSDEFormDetail.setPPSDEFormDetailId(null);
            pSDEFormDetail.setPPSDEFormDetailName(null);
            pSDEFormDetail.setFormType(null);
            pSDEFormDetail.setMobFlag(null);
            pSDEFormDetail.setPSDEFormId(null);
            pSDEFormDetail.setPSDEFormName(null);
            pSDEFormDetail.setPSDEId(null);
            super.exportCurXmlModel(pSDEFormDetail, xmlNode, bl);
        }
    }

    @Override
    protected void onExportRelatedXmlModel(PSDEFormDetail pSDEFormDetail, XmlNode xmlNode) throws Exception {
        this.exportRelatedXmlModel_PSDEFDLogic(pSDEFormDetail, xmlNode);
        this.exportRelatedXmlModel_PSDEFormDetail(pSDEFormDetail, xmlNode);
        super.onExportRelatedXmlModel(pSDEFormDetail, xmlNode);
    }

    protected void exportRelatedXmlModel_PSDEFDLogic(PSDEFormDetail pSDEFormDetail, XmlNode xmlNode) throws Exception {
        PSDEFDLogicService pSDEFDLogicService = (PSDEFDLogicService)ServiceGlobal.getService(PSDEFDLogicService.class, (SessionFactory)this.getSessionFactory());
        ArrayList<PSDEFDLogic> arrayList = null;
        String string = pSDEFormDetail.getPSDEFormDetailId();
        arrayList = string.indexOf("SRFTEMPKEY:") != 0 ? pSDEFDLogicService.selectByPSDEFormDetail(pSDEFormDetail, "ORDER BY ORDERVALUE ASC") : pSDEFDLogicService.selectTempByPSDEFormDetail(pSDEFormDetail, "ORDER BY ORDERVALUE ASC");
        if (arrayList.size() > 0) {
            XmlNode xmlNode2 = new XmlNode();
            xmlNode2.setNodeName("PSDEFDLOGICS");
            xmlNode.addNode(xmlNode2);
            for (PSDEFDLogic pSDEFDLogic : arrayList) {
                if (pSDEFDLogic.getPPSDEFDLogicId() != null) continue;
                pSDEFDLogic.set("ORDERVALUE", null);
                pSDEFDLogicService.exportXmlModel(pSDEFDLogic, xmlNode2);
            }
        }
    }

    protected void exportRelatedXmlModel_PSDEFormDetail(PSDEFormDetail pSDEFormDetail, XmlNode xmlNode) throws Exception {
        PSDEFormDetailService pSDEFormDetailService = (PSDEFormDetailService)ServiceGlobal.getService(PSDEFormDetailService.class, (SessionFactory)this.getSessionFactory());
        ArrayList<PSDEFormDetail> arrayList = null;
        String string = pSDEFormDetail.getPSDEFormDetailId();
        arrayList = string.indexOf("SRFTEMPKEY:") != 0 ? pSDEFormDetailService.selectByPPSDEFormDetail(pSDEFormDetail, "ORDER BY ORDERVALUE ASC") : pSDEFormDetailService.selectTempByPPSDEFormDetail(pSDEFormDetail, "ORDER BY ORDERVALUE ASC");
        if (arrayList.size() > 0) {
            XmlNode xmlNode2 = new XmlNode();
            xmlNode2.setNodeName("PSDEFORMDETAILS");
            xmlNode.addNode(xmlNode2);
            for (PSDEFormDetail pSDEFormDetail2 : arrayList) {
                pSDEFormDetail2.set("ORDERVALUE", null);
                pSDEFormDetailService.exportXmlModel(pSDEFormDetail2, xmlNode2);
            }
        }
    }

    @Override
    protected void onImportRelatedXmlModel(PSDEFormDetail pSDEFormDetail, XmlNode xmlNode) throws Exception {
        XmlNode xmlNode2 = xmlNode.getChildNodeByNodeName("PSDEFDLOGICS");
        this.importRelatedXmlModel_PSDEFDLogic(pSDEFormDetail, xmlNode2);
        XmlNode xmlNode3 = xmlNode.getChildNodeByNodeName("PSDEFORMDETAILS");
        this.importRelatedXmlModel_PSDEFormDetail(pSDEFormDetail, xmlNode3);
        super.onImportRelatedXmlModel(pSDEFormDetail, xmlNode);
    }

    protected void importRelatedXmlModel_PSDEFDLogic(PSDEFormDetail pSDEFormDetail, XmlNode xmlNode) throws Exception {
        int n = 100;
        PSDEFDLogicService pSDEFDLogicService = (PSDEFDLogicService)ServiceGlobal.getService(PSDEFDLogicService.class, (SessionFactory)this.getSessionFactory());
        String string = pSDEFormDetail.getPSDEFormDetailId();
        if (string.indexOf("SRFTEMPKEY:") != 0) {
            pSDEFDLogicService.removeByPSDEFormDetail(pSDEFormDetail);
        } else {
            pSDEFDLogicService.removeTempByPSDEFormDetail(pSDEFormDetail);
        }
        if (xmlNode == null) {
            return;
        }
        Iterator iterator = xmlNode.getChildNodes();
        if (iterator != null) {
            while (iterator.hasNext()) {
                XmlNode xmlNode2 = (XmlNode)iterator.next();
                PSDEFDLogic pSDEFDLogic = new PSDEFDLogic();
                pSDEFDLogic.setOrderValue(n);
                n += 100;
                pSDEFDLogicService.fillParentInfo(pSDEFDLogic, "DER1N", "DER1N_PSDEFDLOGIC_PSDEFORMDETAIL_PSDEFORMDETAILID", pSDEFormDetail.getPSDEFormDetailId());
                pSDEFDLogicService.importXmlModel(pSDEFDLogic, xmlNode2);
            }
        }
    }

    protected void importRelatedXmlModel_PSDEFormDetail(PSDEFormDetail pSDEFormDetail, XmlNode xmlNode) throws Exception {
        int n = 100;
        PSDEFormDetailService pSDEFormDetailService = (PSDEFormDetailService)ServiceGlobal.getService(PSDEFormDetailService.class, (SessionFactory)this.getSessionFactory());
        String string = pSDEFormDetail.getPSDEFormDetailId();
        if (string.indexOf("SRFTEMPKEY:") != 0) {
            pSDEFormDetailService.removeByPPSDEFormDetail(pSDEFormDetail);
        } else {
            pSDEFormDetailService.removeTempByPPSDEFormDetail(pSDEFormDetail);
        }
        if (xmlNode == null) {
            return;
        }
        Iterator iterator = xmlNode.getChildNodes();
        if (iterator != null) {
            while (iterator.hasNext()) {
                XmlNode xmlNode2 = (XmlNode)iterator.next();
                PSDEFormDetail pSDEFormDetail2 = new PSDEFormDetail();
                pSDEFormDetail2.setOrderValue(n);
                n += 100;
                pSDEFormDetailService.fillParentInfo(pSDEFormDetail2, "DER1N", "DER1N_PSDEFORMDETAIL_PSDEFORMDETAIL_PPSDEFORMDETAILID", pSDEFormDetail.getPSDEFormDetailId());
                pSDEFormDetailService.importXmlModel(pSDEFormDetail2, xmlNode2);
            }
        }
    }

    @Override
    public ObjectNode fillModelV2(ObjectNode objectNode, PSDEFormDetail pSDEFormDetail, String string) throws Exception {
        objectNode = super.fillModelV2(objectNode, pSDEFormDetail, string);
        return objectNode;
    }

    @Override
    public String getModelV2ResScope(IEntity iEntity) throws Exception {
        String string = null;
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PPSDEFORMDETAILID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return StringHelper.format((String)"PSDEFORMDETAIL#%1$s", (Object)string);
        }
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSDEFORMID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return StringHelper.format((String)"PSDEFORM#%1$s", (Object)string);
        }
        return super.getModelV2ResScope(iEntity);
    }

    @Override
    public String getModelV2ResScopeDER(IEntity iEntity) throws Exception {
        String string = null;
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PPSDEFORMDETAILID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return "DER1N_PSDEFORMDETAIL_PSDEFORMDETAIL_PPSDEFORMDETAILID";
        }
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSDEFORMID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return "DER1N_PSDEFORMDETAIL_PSDEFORM_PSDEFORMID";
        }
        return super.getModelV2ResScopeDER(iEntity);
    }

    @Override
    public String getModelV2ResScopeText(IEntity iEntity) throws Exception {
        String string = null;
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PPSDEFORMDETAILID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return DataObject.getStringValue((IDataObject)iEntity, (String)"PPSDEFORMDETAILNAME", null);
        }
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSDEFORMID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return DataObject.getStringValue((IDataObject)iEntity, (String)"PSDEFORMNAME", null);
        }
        return super.getModelV2ResScopeText(iEntity);
    }

    @Override
    public boolean setModelV2ResScope(IEntity iEntity, String string, String string2) throws Exception {
        if (StringHelper.compare((String)string, (String)"PSDEFORMDETAIL", (boolean)true) == 0) {
            iEntity.set("PPSDEFORMDETAILID", (Object)string2);
            return true;
        }
        if (StringHelper.compare((String)string, (String)"PSDEFORM", (boolean)true) == 0) {
            iEntity.set("PSDEFORMID", (Object)string2);
            return true;
        }
        return super.setModelV2ResScope(iEntity, string, string2);
    }

    @Override
    public String[] getModelV2ResScopeFields() throws Exception {
        return new String[]{"PPSDEFORMDETAILID", "PSDEFORMID"};
    }

    @Override
    public String getModelV2Tag(PSDEFormDetail pSDEFormDetail) {
        if (!StringHelper.isNullOrEmpty((String)pSDEFormDetail.getPSDEFormDetailName())) {
            return pSDEFormDetail.getPSDEFormDetailName();
        }
        return super.getModelV2Tag(pSDEFormDetail);
    }

    @Override
    public boolean setModelV2Tag(PSDEFormDetail pSDEFormDetail, String string) {
        pSDEFormDetail.setPSDEFormDetailName(string);
        return true;
    }

    @Override
    public Map<String, String> getListDRDataFolderFields(Map<String, String> map, PSMOSFile pSMOSFile, IPSMOSFileFilter iPSMOSFileFilter) throws Exception {
        if (map == null) {
            map = new HashMap<String, String>();
        }
        map.put("PSDEFORMDETAILNAME", "");
        map.put("PPSDEFORMDETAILID", "");
        map.put("PSDEFORMID", "");
        return super.getListDRDataFolderFields(map, pSMOSFile, iPSMOSFileFilter);
    }

    @Override
    public boolean getModelV2Entity(PSDEFormDetail pSDEFormDetail, String string) throws Exception {
        SimpleEntity simpleEntity = new SimpleEntity();
        pSDEFormDetail.copyTo((IDataObject)simpleEntity, false);
        simpleEntity.copyTo((IDataObject)pSDEFormDetail, true);
        pSDEFormDetail.set("PSDEFORMDETAILNAME", string);
        if (this.select(pSDEFormDetail, true)) {
            return true;
        }
        simpleEntity.copyTo((IDataObject)pSDEFormDetail, true);
        return super.getModelV2Entity(pSDEFormDetail, string);
    }

    @Override
    protected boolean testCompileCurModelV2(PSDEFormDetail pSDEFormDetail, ObjectNode objectNode, String string, String string2, int n) throws Exception {
        if (n == 1) {
            return true;
        }
        boolean bl = false;
        if (!StringHelper.isNullOrEmpty((String)pSDEFormDetail.getPPSDEFormDetailId())) {
            bl = true;
        }
        if (!StringHelper.isNullOrEmpty((String)pSDEFormDetail.getPSDEFormId())) {
            bl = true;
        } else if (bl && !objectNode.has("psdeformid")) {
            objectNode.put("psdeformid", "<PSDEFORM>");
        }
        return super.testCompileCurModelV2(pSDEFormDetail, objectNode, string, string2, n);
    }

    @Override
    protected ObjectNode onFillModelV2(ObjectNode objectNode, PSDEFormDetail pSDEFormDetail, String string, Map<String, String> map) throws Exception {
        if (PSDEFormDetailServiceBase.isSimpleImportExportMode()) {
            map.put("PPSDEFORMDETAILID", "");
            map.put("PSDEFORMID", "");
        }
        return super.onFillModelV2(objectNode, pSDEFormDetail, string, map);
    }

    protected boolean isExportRelatedModelV2(String string) {
        if (StringHelper.compare((String)"DER1N_PSDEFORMDETAIL_PSDEFORMDETAIL_PPSDEFORMDETAILID", (String)string, (boolean)true) == 0) {
            return false;
        }
        return StringHelper.compare((String)"DER1N_PSDEFDLOGIC_PSDEFORMDETAIL_PSDEFORMDETAILID", (String)string, (boolean)true) != 0;
    }

    @Override
    protected void onExportRelatedModelV2(PSDEFormDetail pSDEFormDetail, String string, String string2) throws Exception {
        Object var4_4 = null;
        super.onExportRelatedModelV2(pSDEFormDetail, string, string2);
    }

    @Override
    protected void onExportCurModelV2(PSDEFormDetail pSDEFormDetail, ObjectNode objectNode, String string, boolean bl) throws Exception {
        ArrayNode arrayNode;
        ArrayList<ObjectNode> arrayList;
        PSCoreSysServiceBase pSCoreSysServiceBase;
        File file = null;
        if (bl || !this.isExportRelatedModelV2("DER1N_PSDEFORMDETAIL_PSDEFORMDETAIL_PPSDEFORMDETAILID")) {
            pSCoreSysServiceBase = (PSDEFormDetailService)ServiceGlobal.getService(PSDEFormDetailService.class, (SessionFactory)this.getSessionFactory());
            arrayList = null;
            if (!StringHelper.isNullOrEmpty((String)string)) {
                file = new File(StringHelper.format((String)"%1$s%2$s%3$s%2$sPSDEFORMDETAIL#%4$s#ALL.txt", (Object)string, (Object)File.separator, (Object)"PSDEFORMDETAIL", (Object)pSDEFormDetail.getPSDEFormDetailId()));
                if (file.exists()) {
                    arrayList = new ArrayList<ObjectNode>();
                    for (String line : PSModelV2Helper.readFile2(file)) {
                        if (StringHelper.isNullOrEmpty(line)) continue;
                        arrayList.add((ObjectNode)JsonNodeHelper.fromString(line));
                    }
                }
            } else {
                arrayList = new ArrayList<ObjectNode>();
                String scope = StringHelper.format((String)"PSDEFORMDETAIL#%1$s", (Object)pSDEFormDetail.getPSDEFormDetailId());
                for (PSDEFormDetail model : ((PSDEFormDetailServiceBase)pSCoreSysServiceBase).selectByPPSDEFormDetail(pSDEFormDetail)) {
                    if (StringHelper.compare(scope, ((PSDEFormDetailServiceBase)pSCoreSysServiceBase).getModelV2ResScope(model), false) != 0) continue;
                    arrayList.add(PSModelV2Helper.toJSONObject(model, false));
                }
            }
            if (arrayList != null && arrayList.size() > 0) {
                arrayNode = objectNode.putArray(pSCoreSysServiceBase.getModelV2Name(false).toLowerCase());
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
                        if (objectNode.has("psdeformdetailname")) {
                            string = objectNode.get("psdeformdetailname").asText();
                        }
                        if (objectNode2.has("psdeformdetailname")) {
                            string2 = objectNode2.get("psdeformdetailname").asText();
                        }
                        return StringHelper.compare((String)string, string2, (boolean)false);
                    }
                });
                for (ObjectNode node : arrayList) {
                    PSDEFormDetail model = new PSDEFormDetail();
                    PSModelV2Helper.fromJSONObject(model, node, false);
                    model.remove("ordervalue");
                    arrayNode.add(pSCoreSysServiceBase.exportModelV2(model, string));
                }
            }
        }
        if (bl || !this.isExportRelatedModelV2("DER1N_PSDEFDLOGIC_PSDEFORMDETAIL_PSDEFORMDETAILID")) {
            pSCoreSysServiceBase = (PSDEFDLogicService)ServiceGlobal.getService(PSDEFDLogicService.class, (SessionFactory)this.getSessionFactory());
            arrayList = null;
            if (!StringHelper.isNullOrEmpty((String)string)) {
                file = new File(StringHelper.format((String)"%1$s%2$s%3$s%2$sPSDEFORMDETAIL#%4$s#ALL.txt", (Object)string, (Object)File.separator, (Object)"PSDEFDLOGIC", (Object)pSDEFormDetail.getPSDEFormDetailId()));
                if (file.exists()) {
                    arrayList = new ArrayList<ObjectNode>();
                    for (String line : PSModelV2Helper.readFile2(file)) {
                        if (StringHelper.isNullOrEmpty(line)) continue;
                        arrayList.add((ObjectNode)JsonNodeHelper.fromString(line));
                    }
                }
            } else {
                arrayList = new ArrayList<ObjectNode>();
                String scope = StringHelper.format((String)"PSDEFORMDETAIL#%1$s", (Object)pSDEFormDetail.getPSDEFormDetailId());
                for (PSDEFDLogic model : ((PSDEFDLogicServiceBase)pSCoreSysServiceBase).selectByPSDEFormDetail(pSDEFormDetail)) {
                    if (StringHelper.compare(scope, ((PSDEFDLogicServiceBase)pSCoreSysServiceBase).getModelV2ResScope(model), false) != 0) continue;
                    arrayList.add(PSModelV2Helper.toJSONObject(model, false));
                }
            }
            if (arrayList != null && arrayList.size() > 0) {
                arrayNode = objectNode.putArray(pSCoreSysServiceBase.getModelV2Name(false).toLowerCase());
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
                        if (objectNode.has("psdefdlogicname")) {
                            string = objectNode.get("psdefdlogicname").asText();
                        }
                        if (objectNode2.has("psdefdlogicname")) {
                            string2 = objectNode2.get("psdefdlogicname").asText();
                        }
                        return StringHelper.compare((String)string, string2, (boolean)false);
                    }
                });
                for (ObjectNode node : arrayList) {
                    PSDEFDLogic model = new PSDEFDLogic();
                    PSModelV2Helper.fromJSONObject(model, node, false);
                    model.remove("ordervalue");
                    arrayNode.add(pSCoreSysServiceBase.exportModelV2(model, string));
                }
            }
        }
        super.onExportCurModelV2(pSDEFormDetail, objectNode, string, bl);
    }

    @Override
    protected void onEmptyModelV2(PSDEFormDetail pSDEFormDetail) throws Exception {
        String string;
        PSCoreSysServiceBase pSCoreSysServiceBase = (PSDEFormDetailService)ServiceGlobal.getService(PSDEFormDetailService.class, (SessionFactory)this.getSessionFactory());
        ArrayList<PSDEFormDetail> formDetails = ((PSDEFormDetailServiceBase)pSCoreSysServiceBase).selectByPPSDEFormDetail(pSDEFormDetail);
        String string2 = StringHelper.format((String)"PSDEFORMDETAIL#%1$s", (Object)pSDEFormDetail.getPSDEFormDetailId());
        for (PSDEFormDetail entityBase : formDetails) {
            string = ((PSDEFormDetailServiceBase)pSCoreSysServiceBase).getModelV2ResScope(entityBase);
            if (StringHelper.compare((String)string2, (String)string, (boolean)false) != 0) continue;
            pSCoreSysServiceBase.emptyModelV2(entityBase);
        }
        SqlParamList params = new SqlParamList();
        params.addString(pSDEFormDetail.getPSDEFormDetailId());
        ((PSDEFormDetailServiceBase)pSCoreSysServiceBase).getDAO().executeRawSql(null, "SET FOREIGN_KEY_CHECKS=0;", null);
        ((PSDEFormDetailServiceBase)pSCoreSysServiceBase).getDAO().executeRawSql(null, "DELETE FROM T_SRFPSDEFORMDETAIL WHERE PPSDEFORMDETAILID = ?", params);
        pSCoreSysServiceBase = (PSDEFDLogicService)ServiceGlobal.getService(PSDEFDLogicService.class, (SessionFactory)this.getSessionFactory());
        ArrayList<PSDEFDLogic> logics = ((PSDEFDLogicServiceBase)pSCoreSysServiceBase).selectByPSDEFormDetail(pSDEFormDetail);
        string2 = StringHelper.format((String)"PSDEFORMDETAIL#%1$s", (Object)pSDEFormDetail.getPSDEFormDetailId());
        for (PSDEFDLogic pSDEFDLogic : logics) {
            string = ((PSDEFDLogicServiceBase)pSCoreSysServiceBase).getModelV2ResScope(pSDEFDLogic);
            if (StringHelper.compare((String)string2, (String)string, (boolean)false) != 0) continue;
            pSCoreSysServiceBase.emptyModelV2(pSDEFDLogic);
        }
        params = new SqlParamList();
        params.addString(pSDEFormDetail.getPSDEFormDetailId());
        ((PSDEFDLogicServiceBase)pSCoreSysServiceBase).getDAO().executeRawSql(null, "SET FOREIGN_KEY_CHECKS=0;", null);
        ((PSDEFDLogicServiceBase)pSCoreSysServiceBase).getDAO().executeRawSql(null, "DELETE FROM T_SRFPSDEFDLOGIC WHERE PSDEFORMDETAILID = ?", params);
        super.onEmptyModelV2(pSDEFormDetail);
    }

    @Override
    protected boolean onContainsRelatedModelV2Entity(String string, int n) throws Exception {
        PSCoreSysServiceBase pSCoreSysServiceBase = (PSDEFormDetailService)ServiceGlobal.getService(PSDEFormDetailService.class, (SessionFactory)this.getSessionFactory());
        if (pSCoreSysServiceBase.containsModelV2Entity(string, n)) {
            return true;
        }
        pSCoreSysServiceBase = (PSDEFDLogicService)ServiceGlobal.getService(PSDEFDLogicService.class, (SessionFactory)this.getSessionFactory());
        if (pSCoreSysServiceBase.containsModelV2Entity(string, n)) {
            return true;
        }
        return super.onContainsRelatedModelV2Entity(string, n);
    }

    @Override
    protected IEntity onGetRelatedModelV2Entity(PSDEFormDetail pSDEFormDetail, String string, String string2) throws Exception {
        IEntity iEntity = null;
        EntityBase entityBase = new PSDEFormDetail();
        entityBase.set("PPSDEFORMDETAILID", pSDEFormDetail.getPSDEFormDetailId());
        PSCoreSysServiceBase pSCoreSysServiceBase = (PSDEFormDetailService)ServiceGlobal.getService(PSDEFormDetailService.class, (SessionFactory)this.getSessionFactory());
        iEntity = pSCoreSysServiceBase.getModelV2Entity(entityBase, string, string2);
        if (iEntity != null) {
            return iEntity;
        }
        entityBase = new PSDEFDLogic();
        entityBase.set("PSDEFORMDETAILID", pSDEFormDetail.getPSDEFormDetailId());
        pSCoreSysServiceBase = (PSDEFDLogicService)ServiceGlobal.getService(PSDEFDLogicService.class, (SessionFactory)this.getSessionFactory());
        iEntity = pSCoreSysServiceBase.getModelV2Entity(entityBase, string, string2);
        if (iEntity != null) {
            return iEntity;
        }
        return super.onGetRelatedModelV2Entity(pSDEFormDetail, string, string2);
    }

    @Override
    protected void onCompileRelatedModelV2(PSDEFormDetail pSDEFormDetail, ObjectNode objectNode, String string, String string2, int n) throws Exception {
        PSCoreSysServiceBase pSCoreSysServiceBase = (PSDEFormDetailService)ServiceGlobal.getService(PSDEFormDetailService.class, (SessionFactory)this.getSessionFactory());
        ArrayNode arrayNode = null;
        String string3 = pSCoreSysServiceBase.getModelV2Name(null, false);
        int n3 = 0;
        if (objectNode != null) {
            arrayNode = JsonNodeHelper.getArray((ObjectNode)objectNode, (String)string3.toLowerCase());
        }
        if (arrayNode != null) {
            for (int i = 0; i < arrayNode.size(); ++i) {
                ObjectNode node = (ObjectNode)arrayNode.get(i);
                PSDEFormDetail model = new PSDEFormDetail();
                model.setPLayoutMode(pSDEFormDetail.getLayoutMode());
                model.setPPSDEFormDetailId(pSDEFormDetail.getPSDEFormDetailId());
                model.setPPSDEFormDetailName(pSDEFormDetail.getPSDEFormDetailName());
                model.setOrderValue(n3 += 10);
                pSCoreSysServiceBase.compileModelV2(model, node, string, null, n);
            }
        } else {
            String string4 = StringHelper.format((String)"%1$s%2$s%3$s", (Object)string2, (Object)File.separator, (Object)string3);
            File directory = new File(string4);
            if (directory.exists()) {
                for (File child : directory.listFiles()) {
                    if (!child.isDirectory()) continue;
                    PSDEFormDetail model = new PSDEFormDetail();
                    model.setPLayoutMode(pSDEFormDetail.getLayoutMode());
                    model.setPPSDEFormDetailId(pSDEFormDetail.getPSDEFormDetailId());
                    model.setPPSDEFormDetailName(pSDEFormDetail.getPSDEFormDetailName());
                    pSCoreSysServiceBase.compileModelV2(model, null, string, child.getCanonicalPath(), n);
                }
            }
        }
        pSCoreSysServiceBase = (PSDEFDLogicService)ServiceGlobal.getService(PSDEFDLogicService.class, (SessionFactory)this.getSessionFactory());
        arrayNode = null;
        string3 = pSCoreSysServiceBase.getModelV2Name(null, false);
        n3 = 0;
        if (objectNode != null) {
            arrayNode = JsonNodeHelper.getArray((ObjectNode)objectNode, (String)string3.toLowerCase());
        }
        if (arrayNode != null) {
            for (int i = 0; i < arrayNode.size(); ++i) {
                ObjectNode node = (ObjectNode)arrayNode.get(i);
                PSDEFDLogic model = new PSDEFDLogic();
                model.setPSDEFormDetailId(pSDEFormDetail.getPSDEFormDetailId());
                model.setPSDEFormDetailName(pSDEFormDetail.getPSDEFormDetailName());
                model.setOrderValue(n3 += 10);
                pSCoreSysServiceBase.compileModelV2(model, node, string, null, n);
            }
        } else {
            String string5 = StringHelper.format((String)"%1$s%2$s%3$s", (Object)string2, (Object)File.separator, (Object)string3);
            File directory = new File(string5);
            if (directory.exists()) {
                for (File child : directory.listFiles()) {
                    if (!child.isDirectory()) continue;
                    PSDEFDLogic model = new PSDEFDLogic();
                    model.setPSDEFormDetailId(pSDEFormDetail.getPSDEFormDetailId());
                    model.setPSDEFormDetailName(pSDEFormDetail.getPSDEFormDetailName());
                    pSCoreSysServiceBase.compileModelV2(model, null, string, child.getCanonicalPath(), n);
                }
            }
        }
        super.onCompileRelatedModelV2(pSDEFormDetail, objectNode, string, string2, n);
    }

    @Override
    protected PSMOSFile onPasteFile(PSDEFormDetail pSDEFormDetail, PSMOSFile pSMOSFile, String string, IPSMOSFileAction iPSMOSFileAction) throws Exception {
        PSMOSFile pSMOSFile2 = null;
        if ((StringHelper.isNullOrEmpty((String)string) || StringHelper.compare((String)string, (String)"DER1N_PSDEFORMDETAIL_PSDEFORMDETAIL_PPSDEFORMDETAILID", (boolean)true) == 0) && (pSMOSFile2 = this.onPasteFile_PSDEFormDetails(pSDEFormDetail, pSMOSFile, iPSMOSFileAction)) != null) {
            return pSMOSFile2;
        }
        if ((StringHelper.isNullOrEmpty((String)string) || StringHelper.compare((String)string, (String)"DER1N_PSDEFDLOGIC_PSDEFORMDETAIL_PSDEFORMDETAILID", (boolean)true) == 0) && (pSMOSFile2 = this.onPasteFile_PSDEFDLogics(pSDEFormDetail, pSMOSFile, iPSMOSFileAction)) != null) {
            return pSMOSFile2;
        }
        return super.onPasteFile(pSDEFormDetail, pSMOSFile, string, iPSMOSFileAction);
    }

    protected PSMOSFile onPasteFile_PSDEFormDetails(PSDEFormDetail pSDEFormDetail, PSMOSFile pSMOSFile, IPSMOSFileAction iPSMOSFileAction) throws Exception {
        if (StringHelper.compare((String)pSMOSFile.getPSModelType(), (String)PSModelV2Helper.getModelV2Name("PSDEFORMDETAIL", true), (boolean)false) == 0) {
            PSDEFormDetailService pSDEFormDetailService = (PSDEFormDetailService)ServiceGlobal.getService(PSDEFormDetailService.class, (SessionFactory)this.getSessionFactory());
            PSDEFormDetail pSDEFormDetail2 = new PSDEFormDetail();
            pSDEFormDetail2.setPSDEFormDetailId(pSMOSFile.getPSModelId());
            if (!pSDEFormDetailService.get(pSDEFormDetail2, true)) {
                throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u83b7\u53d6\u6a21\u578b[%1$s|%2$s]", (Object)pSMOSFile.getPSMOSFileId(), (Object)pSMOSFile.getPSModelId()));
            }
            if (StringHelper.compare((String)pSDEFormDetail2.getPPSDEFormDetailId(), (String)pSDEFormDetail.getPSDEFormDetailId(), (boolean)false) == 0) {
                throw new Exception(StringHelper.format((String)"\u76ee\u6807\u8def\u5f84\u4e0e\u6e90\u8def\u5f84\u4e00\u81f4"));
            }
            ObjectNode objectNode = pSDEFormDetailService.exportModelV2(pSDEFormDetail2);
            pSDEFormDetail2.reset();
            if (!pSDEFormDetailService.setModelV2ResScope(pSDEFormDetail2, "PSDEFORMDETAIL", pSDEFormDetail.getPSDEFormDetailId())) {
                throw new Exception("\u65e0\u6cd5\u8bbe\u7f6e\u6a21\u578b\u57df");
            }
            pSDEFormDetailService.importModelV2(pSDEFormDetail2, objectNode);
            SessionFactoryManager.commit();
            return pSDEFormDetailService.getFile(pSDEFormDetail2);
        }
        return null;
    }

    protected PSMOSFile onPasteFile_PSDEFDLogics(PSDEFormDetail pSDEFormDetail, PSMOSFile pSMOSFile, IPSMOSFileAction iPSMOSFileAction) throws Exception {
        if (StringHelper.compare((String)pSMOSFile.getPSModelType(), (String)PSModelV2Helper.getModelV2Name("PSDEFDLOGIC", true), (boolean)false) == 0) {
            PSDEFDLogicService pSDEFDLogicService = (PSDEFDLogicService)ServiceGlobal.getService(PSDEFDLogicService.class, (SessionFactory)this.getSessionFactory());
            PSDEFDLogic pSDEFDLogic = new PSDEFDLogic();
            pSDEFDLogic.setPSDEFDLogicId(pSMOSFile.getPSModelId());
            if (!pSDEFDLogicService.get(pSDEFDLogic, true)) {
                throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u83b7\u53d6\u6a21\u578b[%1$s|%2$s]", (Object)pSMOSFile.getPSMOSFileId(), (Object)pSMOSFile.getPSModelId()));
            }
            if (StringHelper.compare((String)pSDEFDLogic.getPSDEFormDetailId(), (String)pSDEFormDetail.getPSDEFormDetailId(), (boolean)false) == 0) {
                throw new Exception(StringHelper.format((String)"\u76ee\u6807\u8def\u5f84\u4e0e\u6e90\u8def\u5f84\u4e00\u81f4"));
            }
            ObjectNode objectNode = pSDEFDLogicService.exportModelV2(pSDEFDLogic);
            pSDEFDLogic.reset();
            if (!pSDEFDLogicService.setModelV2ResScope(pSDEFDLogic, "PSDEFORMDETAIL", pSDEFormDetail.getPSDEFormDetailId())) {
                throw new Exception("\u65e0\u6cd5\u8bbe\u7f6e\u6a21\u578b\u57df");
            }
            pSDEFDLogicService.importModelV2(pSDEFDLogic, objectNode);
            SessionFactoryManager.commit();
            return pSDEFDLogicService.getFile(pSDEFDLogic);
        }
        return null;
    }

    @Override
    protected void onFillPasteHelps(PSDEFormDetail pSDEFormDetail, List<PSHelpSection> list) throws Exception {
        this.onFillPasteHelps_PSDEFormDetails(pSDEFormDetail, list);
        this.onFillPasteHelps_PSDEFDLogics(pSDEFormDetail, list);
        super.onFillPasteHelps(pSDEFormDetail, list);
    }

    protected void onFillPasteHelps_PSDEFormDetails(PSDEFormDetail pSDEFormDetail, List<PSHelpSection> list) throws Exception {
        PSHelpSection pSHelpSection = new PSHelpSection();
        pSHelpSection.setSectionType("USER");
        pSHelpSection.setSectionParam("PSDEFORMDETAIL");
        pSHelpSection.setSectionParam2("DER1N_PSDEFORMDETAIL_PSDEFORMDETAIL_PPSDEFORMDETAILID");
        pSHelpSection.setContent("\u7c98\u8d34\u5176\u5b83[\u8868\u5355\u6210\u5458]\u7684[\u8868\u5355\u6210\u5458]");
        list.add(pSHelpSection);
    }

    protected void onFillPasteHelps_PSDEFDLogics(PSDEFormDetail pSDEFormDetail, List<PSHelpSection> list) throws Exception {
        PSHelpSection pSHelpSection = new PSHelpSection();
        pSHelpSection.setSectionType("USER");
        pSHelpSection.setSectionParam("PSDEFDLOGIC");
        pSHelpSection.setSectionParam2("DER1N_PSDEFDLOGIC_PSDEFORMDETAIL_PSDEFORMDETAILID");
        pSHelpSection.setContent("\u7c98\u8d34\u5176\u5b83[\u8868\u5355\u6210\u5458]\u7684[\u8868\u5355\u6210\u5458\u903b\u8f91]");
        list.add(pSHelpSection);
    }

    @Override
    public Object getDataType(PSDEFormDetail pSDEFormDetail) throws Exception {
        return pSDEFormDetail.getDetailType();
    }
}
