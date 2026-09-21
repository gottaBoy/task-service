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
 *  net.ibizsys.paas.service.IServicePlugin
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
import net.ibizsys.paas.service.IServicePlugin;
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
import net.ibizsys.pscore.srv.dedesign.dao.PSDEDRDetailDAO;
import net.ibizsys.pscore.srv.dedesign.demodel.PSDEDRDetailDEModel;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEAction;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEActionBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEDRDetail;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEDRGroup;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEDRGroupBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEDRItem;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEDRItemBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEDataRelation;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEDataRelationBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDELogic;
import net.ibizsys.pscore.srv.dedesign.entity.PSDELogicBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEOPPriv;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEOPPrivBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDETreeView;
import net.ibizsys.pscore.srv.dedesign.entity.PSDETreeViewBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDEDRLogicService;
import net.ibizsys.pscore.srv.sysdesign.entity.PSLanguageRes;
import net.ibizsys.pscore.srv.sysdesign.entity.PSLanguageResBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysCss;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysCssBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysImage;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysImageBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysPDTView;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysPDTViewBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysUniRes;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysUniResBase;
import net.ibizsys.pscore.srv.sysdevstudio.entity.PSMOSFile;
import net.ibizsys.pscore.srv.util.IPSMOSFileFilter;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDEDRDetailServiceBase
extends PSCoreSysServiceBase<PSDEDRDetail> {
    private static final Log log = LogFactory.getLog(PSDEDRDetailServiceBase.class);
    public static final String DATASET_DEFAULT = "DEFAULT";
    public static final String ACTION_CHANGEDRITEM = "ChangeDRItem";
    private PSDEDRDetailDEModel pSDEDRDetailDEModel;
    private PSDEDRDetailDAO pSDEDRDetailDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.dedesign.service.PSDEDRDetailService";
    }

    public PSDEDRDetailDEModel getPSDEDRDetailDEModel() {
        if (this.pSDEDRDetailDEModel == null) {
            try {
                this.pSDEDRDetailDEModel = (PSDEDRDetailDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.dedesign.demodel.PSDEDRDetailDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDEDRDetailDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSDEDRDetailDEModel();
    }

    public PSDEDRDetailDAO getPSDEDRDetailDAO() {
        if (this.pSDEDRDetailDAO == null) {
            try {
                this.pSDEDRDetailDAO = (PSDEDRDetailDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.dedesign.dao.PSDEDRDetailDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDEDRDetailDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSDEDRDetailDAO();
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
        if (StringHelper.compare((String)string, (String)ACTION_CHANGEDRITEM, (boolean)true) == 0) {
            this.changeDRItem((PSDEDRDetail)iEntity);
            return;
        }
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

    public void changeDRItem(PSDEDRDetail pSDEDRDetail) throws Exception {
        final IServicePlugin iServicePlugin = this.getPlugin();
        if (iServicePlugin != null && iServicePlugin.doCustomAction((IService)this, ACTION_CHANGEDRITEM, 0, (IEntity)pSDEDRDetail, null).getResult() == 1) {
            return;
        }
        this.testDEMainStateAction((IEntity)pSDEDRDetail, ACTION_CHANGEDRITEM);
        final PSDEDRDetail pSDEDRDetail2 = pSDEDRDetail;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                if (iServicePlugin == null || iServicePlugin.doCustomAction(PSDEDRDetailServiceBase.this.getService(), PSDEDRDetailServiceBase.ACTION_CHANGEDRITEM, 40, (IEntity)pSDEDRDetail2, null).getResult() != 1) {
                    PSDEDRDetailServiceBase.this.onChangeDRItem(pSDEDRDetail2);
                }
            }
        });
        if (iServicePlugin != null) {
            iServicePlugin.doCustomAction((IService)this, ACTION_CHANGEDRITEM, 99, (IEntity)pSDEDRDetail, null);
        }
    }

    protected void onChangeDRItem(PSDEDRDetail pSDEDRDetail) throws Exception {
        throw new Exception("\u6ca1\u6709\u5b9e\u73b0\u81ea\u5b9a\u4e49\u884c\u4e3a[ChangeDRItem]");
    }

    protected void onFillParentInfo(PSDEDRDetail pSDEDRDetail, String string, String string2, String string3) throws Exception {
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEDRDETAIL_PSDEACTION_TESTPSDEACTIONID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEActionService", (SessionFactory)this.getSessionFactory());
            PSDEAction pSDEAction = (PSDEAction)iService.getDEModel().createEntity();
            pSDEAction.set("PSDEACTIONID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDEAction);
            } else {
                iService.get((IEntity)pSDEAction);
            }
            this.onFillParentInfo_TestPSDEAction(pSDEDRDetail, pSDEAction);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEDRDETAIL_PSDEDATARELATION_PSDEDRID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEDataRelationService", (SessionFactory)this.getSessionFactory());
            PSDEDataRelation pSDEDataRelation = (PSDEDataRelation)iService.getDEModel().createEntity();
            pSDEDataRelation.set("PSDEDATARELATIONID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDEDataRelation);
            } else {
                iService.get((IEntity)pSDEDataRelation);
            }
            this.onFillParentInfo_PSDEDR(pSDEDRDetail, pSDEDataRelation);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEDRDETAIL_PSDEDRGROUP_PSDEDRGROUPID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEDRGroupService", (SessionFactory)this.getSessionFactory());
            PSDEDRGroup pSDEDRGroup = (PSDEDRGroup)iService.getDEModel().createEntity();
            pSDEDRGroup.set("PSDEDRGROUPID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDEDRGroup);
            } else {
                iService.get((IEntity)pSDEDRGroup);
            }
            this.onFillParentInfo_PSDEDRGroup(pSDEDRDetail, pSDEDRGroup);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEDRDETAIL_PSDEDRITEM_PSDEDRITEMID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEDRItemService", (SessionFactory)this.getSessionFactory());
            PSDEDRItem pSDEDRItem = (PSDEDRItem)iService.getDEModel().createEntity();
            pSDEDRItem.set("PSDEDRITEMID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDEDRItem);
            } else {
                iService.get((IEntity)pSDEDRItem);
            }
            this.onFillParentInfo_PSDEDRItem(pSDEDRDetail, pSDEDRItem);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEDRDETAIL_PSDELOGIC_TESTPSDELOGICID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDELogicService", (SessionFactory)this.getSessionFactory());
            PSDELogic pSDELogic = (PSDELogic)iService.getDEModel().createEntity();
            pSDELogic.set("PSDELOGICID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDELogic);
            } else {
                iService.get((IEntity)pSDELogic);
            }
            this.onFillParentInfo_TestPSDELogic(pSDEDRDetail, pSDELogic);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEDRDETAIL_PSDEOPPRIV_PSDEOPPRIVID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEOPPrivService", (SessionFactory)this.getSessionFactory());
            PSDEOPPriv pSDEOPPriv = (PSDEOPPriv)iService.getDEModel().createEntity();
            pSDEOPPriv.set("PSDEOPPRIVID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDEOPPriv);
            } else {
                iService.get((IEntity)pSDEOPPriv);
            }
            this.onFillParentInfo_PSDEOPPriv(pSDEDRDetail, pSDEOPPriv);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEDRDETAIL_PSDETREEVIEW_PSDETREEVIEWID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDETreeViewService", (SessionFactory)this.getSessionFactory());
            PSDETreeView pSDETreeView = (PSDETreeView)iService.getDEModel().createEntity();
            pSDETreeView.set("PSDETREEVIEWID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDETreeView);
            } else {
                iService.get((IEntity)pSDETreeView);
            }
            this.onFillParentInfo_PSDETreeView(pSDEDRDetail, pSDETreeView);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEDRDETAIL_PSLANGUAGERES_CAPPSLANRESID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSLanguageResService", (SessionFactory)this.getSessionFactory());
            PSLanguageRes pSLanguageRes = (PSLanguageRes)iService.getDEModel().createEntity();
            pSLanguageRes.set("PSLANGUAGERESID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSLanguageRes);
            } else {
                iService.get((IEntity)pSLanguageRes);
            }
            this.onFillParentInfo_CapPSLanRes(pSDEDRDetail, pSLanguageRes);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEDRDETAIL_PSLANGUAGERES_TIPPSLANRESID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSLanguageResService", (SessionFactory)this.getSessionFactory());
            PSLanguageRes pSLanguageRes = (PSLanguageRes)iService.getDEModel().createEntity();
            pSLanguageRes.set("PSLANGUAGERESID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSLanguageRes);
            } else {
                iService.get((IEntity)pSLanguageRes);
            }
            this.onFillParentInfo_TipPSLanRes(pSDEDRDetail, pSLanguageRes);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEDRDETAIL_PSSYSCSS_PSSYSCSSID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysCssService", (SessionFactory)this.getSessionFactory());
            PSSysCss pSSysCss = (PSSysCss)iService.getDEModel().createEntity();
            pSSysCss.set("PSSYSCSSID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSSysCss);
            } else {
                iService.get((IEntity)pSSysCss);
            }
            this.onFillParentInfo_PSSysCss(pSDEDRDetail, pSSysCss);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEDRDETAIL_PSSYSIMAGE_PSSYSIMAGEID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysImageService", (SessionFactory)this.getSessionFactory());
            PSSysImage pSSysImage = (PSSysImage)iService.getDEModel().createEntity();
            pSSysImage.set("PSSYSIMAGEID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSSysImage);
            } else {
                iService.get((IEntity)pSSysImage);
            }
            this.onFillParentInfo_PSSysImage(pSDEDRDetail, pSSysImage);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEDRDETAIL_PSSYSPDTVIEW_PSSYSPDTVIEWID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysPDTViewService", (SessionFactory)this.getSessionFactory());
            PSSysPDTView pSSysPDTView = (PSSysPDTView)iService.getDEModel().createEntity();
            pSSysPDTView.set("PSSYSPDTVIEWID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSSysPDTView);
            } else {
                iService.get((IEntity)pSSysPDTView);
            }
            this.onFillParentInfo_PSSysPDTView(pSDEDRDetail, pSSysPDTView);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEDRDETAIL_PSSYSPFPLUGIN_HEADERPSSYSPFPLUGINID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.config.service.PSSysPFPluginService", (SessionFactory)this.getSessionFactory());
            PSSysPFPlugin pSSysPFPlugin = (PSSysPFPlugin)iService.getDEModel().createEntity();
            pSSysPFPlugin.set("PSSYSPFPLUGINID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSSysPFPlugin);
            } else {
                iService.get((IEntity)pSSysPFPlugin);
            }
            this.onFillParentInfo_HeaderPSSysPFPlugin(pSDEDRDetail, pSSysPFPlugin);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEDRDETAIL_PSSYSUNIRES_PSSYSUNIRESID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysUniResService", (SessionFactory)this.getSessionFactory());
            PSSysUniRes pSSysUniRes = (PSSysUniRes)iService.getDEModel().createEntity();
            pSSysUniRes.set("PSSYSUNIRESID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSSysUniRes);
            } else {
                iService.get((IEntity)pSSysUniRes);
            }
            this.onFillParentInfo_PSSysUniRes(pSDEDRDetail, pSSysUniRes);
            return;
        }
        super.onFillParentInfo((IEntity)pSDEDRDetail, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        if (StringHelper.compare((String)string, (String)"DER1N_PSDEDRDETAIL_PSDEDATARELATION_PSDEDRID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEDataRelationService", (SessionFactory)this.getSessionFactory());
            PSDEDataRelation pSDEDataRelation = (PSDEDataRelation)iService.getDEModel().createEntity();
            pSDEDataRelation.set("PSDEDATARELATIONID", string2);
            return this.onSyncDER1NData_PSDEDR(pSDEDataRelation, string3);
        }
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillParentInfo_TestPSDEAction(PSDEDRDetail pSDEDRDetail, PSDEAction pSDEAction) throws Exception {
        pSDEDRDetail.setTestPSDEActionId(pSDEAction.getPSDEActionId());
        pSDEDRDetail.setTestPSDEActionName(pSDEAction.getPSDEActionName());
    }

    protected void onFillParentInfo_PSDEDR(PSDEDRDetail pSDEDRDetail, PSDEDataRelation pSDEDataRelation) throws Exception {
        pSDEDRDetail.setPSDEDRId(pSDEDataRelation.getPSDEDataRelationId());
        pSDEDRDetail.setPSDEDRName(pSDEDataRelation.getPSDEDataRelationName());
        pSDEDRDetail.setPSDEId(pSDEDataRelation.getPSDEId());
    }

    protected String onSyncDER1NData_PSDEDR(PSDEDataRelation pSDEDataRelation, String string) throws Exception {
        if (StringHelper.isNullOrEmpty((String)string)) {
            this.removeByPSDEDR(pSDEDataRelation);
        } else {
            HashMap<String, String> hashMap = new HashMap<String, String>();
            String[] stringArray = StringHelper.splitEx((String)string);
            if (stringArray != null) {
                for (int i = 0; i < stringArray.length; ++i) {
                    if (StringHelper.isNullOrEmpty((String)stringArray[i])) continue;
                    hashMap.put(stringArray[i], "");
                }
            }
            ArrayList<PSDEDRDetail> arrayList = this.selectByPSDEDR(pSDEDataRelation);
            for (PSDEDRDetail pSDEDRDetail : arrayList) {
                if (hashMap.containsKey(DataObject.getStringValue((IDataObject)pSDEDRDetail, (String)"PSDEDRDETAILID", (String)""))) continue;
                this.remove((IEntity)pSDEDRDetail);
            }
        }
        return null;
    }

    protected void onFillParentInfo_PSDEDRGroup(PSDEDRDetail pSDEDRDetail, PSDEDRGroup pSDEDRGroup) throws Exception {
        pSDEDRDetail.setGroupOrderValue(pSDEDRGroup.getOrderValue());
        pSDEDRDetail.setPSDEDRGroupId(pSDEDRGroup.getPSDEDRGroupId());
        pSDEDRDetail.setPSDEDRGroupName(pSDEDRGroup.getPSDEDRGroupName());
    }

    protected void onFillParentInfo_PSDEDRItem(PSDEDRDetail pSDEDRDetail, PSDEDRItem pSDEDRItem) throws Exception {
        pSDEDRDetail.setPSDEDRItemId(pSDEDRItem.getPSDEDRItemId());
        pSDEDRDetail.setPSDEDRItemName(pSDEDRItem.getPSDEDRItemName());
    }

    protected void onFillParentInfo_TestPSDELogic(PSDEDRDetail pSDEDRDetail, PSDELogic pSDELogic) throws Exception {
        pSDEDRDetail.setTestPSDELogicId(pSDELogic.getPSDELogicId());
        pSDEDRDetail.setTestPSDELogicName(pSDELogic.getPSDELogicName());
    }

    protected void onFillParentInfo_PSDEOPPriv(PSDEDRDetail pSDEDRDetail, PSDEOPPriv pSDEOPPriv) throws Exception {
        pSDEDRDetail.setPSDEOPPrivId(pSDEOPPriv.getPSDEOPPrivId());
        pSDEDRDetail.setPSDEOPPrivName(pSDEOPPriv.getPSDEOPPrivName());
    }

    protected void onFillParentInfo_PSDETreeView(PSDEDRDetail pSDEDRDetail, PSDETreeView pSDETreeView) throws Exception {
        pSDEDRDetail.setPSDETreeViewId(pSDETreeView.getPSDETreeViewId());
        pSDEDRDetail.setPSDETreeViewName(pSDETreeView.getPSDETreeViewName());
    }

    protected void onFillParentInfo_CapPSLanRes(PSDEDRDetail pSDEDRDetail, PSLanguageRes pSLanguageRes) throws Exception {
        pSDEDRDetail.setCapPSLanResId(pSLanguageRes.getPSLanguageResId());
        pSDEDRDetail.setCapPSLanResName(pSLanguageRes.getPSLanguageResName());
    }

    protected void onFillParentInfo_TipPSLanRes(PSDEDRDetail pSDEDRDetail, PSLanguageRes pSLanguageRes) throws Exception {
        pSDEDRDetail.setTipPSLanResId(pSLanguageRes.getPSLanguageResId());
        pSDEDRDetail.setTipPSLanResName(pSLanguageRes.getPSLanguageResName());
    }

    protected void onFillParentInfo_PSSysCss(PSDEDRDetail pSDEDRDetail, PSSysCss pSSysCss) throws Exception {
        pSDEDRDetail.setPSSysCssId(pSSysCss.getPSSysCssId());
        pSDEDRDetail.setPSSysCssName(pSSysCss.getPSSysCssName());
    }

    protected void onFillParentInfo_PSSysImage(PSDEDRDetail pSDEDRDetail, PSSysImage pSSysImage) throws Exception {
        pSDEDRDetail.setPSSysImageId(pSSysImage.getPSSysImageId());
        pSDEDRDetail.setPSSysImageName(pSSysImage.getPSSysImageName());
    }

    protected void onFillParentInfo_PSSysPDTView(PSDEDRDetail pSDEDRDetail, PSSysPDTView pSSysPDTView) throws Exception {
        pSDEDRDetail.setPSSysPDTViewId(pSSysPDTView.getPSSysPDTViewId());
        pSDEDRDetail.setPSSysPDTViewName(pSSysPDTView.getPSSysPDTViewName());
    }

    protected void onFillParentInfo_HeaderPSSysPFPlugin(PSDEDRDetail pSDEDRDetail, PSSysPFPlugin pSSysPFPlugin) throws Exception {
        pSDEDRDetail.setHeaderPSSysPFPluginId(pSSysPFPlugin.getPSSysPFPluginId());
        pSDEDRDetail.setHeaderPSSysPFPluginName(pSSysPFPlugin.getPSSysPFPluginName());
    }

    protected void onFillParentInfo_PSSysUniRes(PSDEDRDetail pSDEDRDetail, PSSysUniRes pSSysUniRes) throws Exception {
        pSDEDRDetail.setPSSysUniResId(pSSysUniRes.getPSSysUniResId());
        pSDEDRDetail.setPSSysUniResName(pSSysUniRes.getPSSysUniResName());
    }

    protected void onFillEntityFullInfo(PSDEDRDetail pSDEDRDetail, boolean bl) throws Exception {
        if (bl) {
            if (pSDEDRDetail.getDetailType() == null) {
                pSDEDRDetail.setDetailType((String)this.getDefaultValue(this.getWebContext(), "", "DRITEM", 25));
            }
            if (pSDEDRDetail.getTestCustomMode() == null) {
                pSDEDRDetail.setTestCustomMode((Integer)this.getDefaultValue(this.getWebContext(), "", "0", 9));
            }
            if (pSDEDRDetail.getValidFlag() == null) {
                pSDEDRDetail.setValidFlag((Integer)this.getDefaultValue(this.getWebContext(), "", "1", 9));
            }
        }
        super.onFillEntityFullInfo((IEntity)pSDEDRDetail, bl);
        this.onFillEntityFullInfo_TestPSDEAction(pSDEDRDetail, bl);
        this.onFillEntityFullInfo_PSDEDR(pSDEDRDetail, bl);
        this.onFillEntityFullInfo_PSDEDRGroup(pSDEDRDetail, bl);
        this.onFillEntityFullInfo_PSDEDRItem(pSDEDRDetail, bl);
        this.onFillEntityFullInfo_TestPSDELogic(pSDEDRDetail, bl);
        this.onFillEntityFullInfo_PSDEOPPriv(pSDEDRDetail, bl);
        this.onFillEntityFullInfo_PSDETreeView(pSDEDRDetail, bl);
        this.onFillEntityFullInfo_CapPSLanRes(pSDEDRDetail, bl);
        this.onFillEntityFullInfo_TipPSLanRes(pSDEDRDetail, bl);
        this.onFillEntityFullInfo_PSSysCss(pSDEDRDetail, bl);
        this.onFillEntityFullInfo_PSSysImage(pSDEDRDetail, bl);
        this.onFillEntityFullInfo_PSSysPDTView(pSDEDRDetail, bl);
        this.onFillEntityFullInfo_HeaderPSSysPFPlugin(pSDEDRDetail, bl);
        this.onFillEntityFullInfo_PSSysUniRes(pSDEDRDetail, bl);
    }

    protected void onFillEntityFullInfo_TestPSDEAction(PSDEDRDetail pSDEDRDetail, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSDEDR(PSDEDRDetail pSDEDRDetail, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSDEDRGroup(PSDEDRDetail pSDEDRDetail, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSDEDRItem(PSDEDRDetail pSDEDRDetail, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_TestPSDELogic(PSDEDRDetail pSDEDRDetail, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSDEOPPriv(PSDEDRDetail pSDEDRDetail, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSDETreeView(PSDEDRDetail pSDEDRDetail, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_CapPSLanRes(PSDEDRDetail pSDEDRDetail, boolean bl) throws Exception {
        if (pSDEDRDetail.isCapPSLanResIdDirty()) {
            if (pSDEDRDetail.getCapPSLanResId() != null) {
                if (pSDEDRDetail.getCapPSLanResId() == null || pSDEDRDetail.getCapPSLanResName() == null) {
                    PSLanguageRes pSLanguageRes = pSDEDRDetail.getCapPSLanRes();
                    pSDEDRDetail.setCapPSLanResName(pSLanguageRes.getPSLanguageResName());
                }
            } else {
                pSDEDRDetail.setCapPSLanResName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_TipPSLanRes(PSDEDRDetail pSDEDRDetail, boolean bl) throws Exception {
        if (pSDEDRDetail.isTipPSLanResIdDirty()) {
            if (pSDEDRDetail.getTipPSLanResId() != null) {
                if (pSDEDRDetail.getTipPSLanResId() == null || pSDEDRDetail.getTipPSLanResName() == null) {
                    PSLanguageRes pSLanguageRes = pSDEDRDetail.getTipPSLanRes();
                    pSDEDRDetail.setTipPSLanResName(pSLanguageRes.getPSLanguageResName());
                }
            } else {
                pSDEDRDetail.setTipPSLanResName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_PSSysCss(PSDEDRDetail pSDEDRDetail, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSSysImage(PSDEDRDetail pSDEDRDetail, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSSysPDTView(PSDEDRDetail pSDEDRDetail, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_HeaderPSSysPFPlugin(PSDEDRDetail pSDEDRDetail, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSSysUniRes(PSDEDRDetail pSDEDRDetail, boolean bl) throws Exception {
    }

    protected void onWriteBackParent(PSDEDRDetail pSDEDRDetail, boolean bl) throws Exception {
        super.onWriteBackParent((IEntity)pSDEDRDetail, bl);
    }

    public ArrayList<PSDEDRDetail> selectByTestPSDEAction(PSDEActionBase pSDEActionBase) throws Exception {
        return this.selectByTestPSDEAction(pSDEActionBase, "", -1);
    }

    public ArrayList<PSDEDRDetail> selectByTestPSDEAction(PSDEActionBase pSDEActionBase, String string) throws Exception {
        return this.selectByTestPSDEAction(pSDEActionBase, string, -1);
    }

    public ArrayList<PSDEDRDetail> selectByTestPSDEAction(PSDEActionBase pSDEActionBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("TESTPSDEACTIONID", (Object)pSDEActionBase.getPSDEActionId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByTestPSDEActionCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByTestPSDEActionCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDEDRDetail> selectByPSDEDR(PSDEDataRelationBase pSDEDataRelationBase) throws Exception {
        return this.selectByPSDEDR(pSDEDataRelationBase, "", -1);
    }

    public ArrayList<PSDEDRDetail> selectByPSDEDR(PSDEDataRelationBase pSDEDataRelationBase, String string) throws Exception {
        return this.selectByPSDEDR(pSDEDataRelationBase, string, -1);
    }

    public ArrayList<PSDEDRDetail> selectByPSDEDR(PSDEDataRelationBase pSDEDataRelationBase, String string, int n) throws Exception {
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

    public ArrayList<PSDEDRDetail> selectTempByPSDEDR(PSDEDataRelationBase pSDEDataRelationBase) throws Exception {
        return this.selectTempByPSDEDR(pSDEDataRelationBase, "");
    }

    public ArrayList<PSDEDRDetail> selectTempByPSDEDR(PSDEDataRelationBase pSDEDataRelationBase, String string) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDEDRID", (Object)pSDEDataRelationBase.getPSDEDataRelationId());
        selectCond.setOrderInfo(string);
        this.onFillSelectTempByPSDEDRCond(selectCond);
        return this.selectTemp((ISelectCond)selectCond);
    }

    protected void onFillSelectTempByPSDEDRCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDEDRDetail> selectByPSDEDRGroup(PSDEDRGroupBase pSDEDRGroupBase) throws Exception {
        return this.selectByPSDEDRGroup(pSDEDRGroupBase, "", -1);
    }

    public ArrayList<PSDEDRDetail> selectByPSDEDRGroup(PSDEDRGroupBase pSDEDRGroupBase, String string) throws Exception {
        return this.selectByPSDEDRGroup(pSDEDRGroupBase, string, -1);
    }

    public ArrayList<PSDEDRDetail> selectByPSDEDRGroup(PSDEDRGroupBase pSDEDRGroupBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDEDRGROUPID", (Object)pSDEDRGroupBase.getPSDEDRGroupId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSDEDRGroupCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSDEDRGroupCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDEDRDetail> selectByPSDEDRItem(PSDEDRItemBase pSDEDRItemBase) throws Exception {
        return this.selectByPSDEDRItem(pSDEDRItemBase, "", -1);
    }

    public ArrayList<PSDEDRDetail> selectByPSDEDRItem(PSDEDRItemBase pSDEDRItemBase, String string) throws Exception {
        return this.selectByPSDEDRItem(pSDEDRItemBase, string, -1);
    }

    public ArrayList<PSDEDRDetail> selectByPSDEDRItem(PSDEDRItemBase pSDEDRItemBase, String string, int n) throws Exception {
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

    public ArrayList<PSDEDRDetail> selectByTestPSDELogic(PSDELogicBase pSDELogicBase) throws Exception {
        return this.selectByTestPSDELogic(pSDELogicBase, "", -1);
    }

    public ArrayList<PSDEDRDetail> selectByTestPSDELogic(PSDELogicBase pSDELogicBase, String string) throws Exception {
        return this.selectByTestPSDELogic(pSDELogicBase, string, -1);
    }

    public ArrayList<PSDEDRDetail> selectByTestPSDELogic(PSDELogicBase pSDELogicBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("TESTPSDELOGICID", (Object)pSDELogicBase.getPSDELogicId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByTestPSDELogicCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByTestPSDELogicCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDEDRDetail> selectByPSDEOPPriv(PSDEOPPrivBase pSDEOPPrivBase) throws Exception {
        return this.selectByPSDEOPPriv(pSDEOPPrivBase, "", -1);
    }

    public ArrayList<PSDEDRDetail> selectByPSDEOPPriv(PSDEOPPrivBase pSDEOPPrivBase, String string) throws Exception {
        return this.selectByPSDEOPPriv(pSDEOPPrivBase, string, -1);
    }

    public ArrayList<PSDEDRDetail> selectByPSDEOPPriv(PSDEOPPrivBase pSDEOPPrivBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDEOPPRIVID", (Object)pSDEOPPrivBase.getPSDEOPPrivId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSDEOPPrivCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSDEOPPrivCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDEDRDetail> selectByPSDETreeView(PSDETreeViewBase pSDETreeViewBase) throws Exception {
        return this.selectByPSDETreeView(pSDETreeViewBase, "", -1);
    }

    public ArrayList<PSDEDRDetail> selectByPSDETreeView(PSDETreeViewBase pSDETreeViewBase, String string) throws Exception {
        return this.selectByPSDETreeView(pSDETreeViewBase, string, -1);
    }

    public ArrayList<PSDEDRDetail> selectByPSDETreeView(PSDETreeViewBase pSDETreeViewBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDETREEVIEWID", (Object)pSDETreeViewBase.getPSDETreeViewId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSDETreeViewCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSDETreeViewCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDEDRDetail> selectByCapPSLanRes(PSLanguageResBase pSLanguageResBase) throws Exception {
        return this.selectByCapPSLanRes(pSLanguageResBase, "", -1);
    }

    public ArrayList<PSDEDRDetail> selectByCapPSLanRes(PSLanguageResBase pSLanguageResBase, String string) throws Exception {
        return this.selectByCapPSLanRes(pSLanguageResBase, string, -1);
    }

    public ArrayList<PSDEDRDetail> selectByCapPSLanRes(PSLanguageResBase pSLanguageResBase, String string, int n) throws Exception {
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

    public ArrayList<PSDEDRDetail> selectByTipPSLanRes(PSLanguageResBase pSLanguageResBase) throws Exception {
        return this.selectByTipPSLanRes(pSLanguageResBase, "", -1);
    }

    public ArrayList<PSDEDRDetail> selectByTipPSLanRes(PSLanguageResBase pSLanguageResBase, String string) throws Exception {
        return this.selectByTipPSLanRes(pSLanguageResBase, string, -1);
    }

    public ArrayList<PSDEDRDetail> selectByTipPSLanRes(PSLanguageResBase pSLanguageResBase, String string, int n) throws Exception {
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

    public ArrayList<PSDEDRDetail> selectByPSSysCss(PSSysCssBase pSSysCssBase) throws Exception {
        return this.selectByPSSysCss(pSSysCssBase, "", -1);
    }

    public ArrayList<PSDEDRDetail> selectByPSSysCss(PSSysCssBase pSSysCssBase, String string) throws Exception {
        return this.selectByPSSysCss(pSSysCssBase, string, -1);
    }

    public ArrayList<PSDEDRDetail> selectByPSSysCss(PSSysCssBase pSSysCssBase, String string, int n) throws Exception {
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

    public ArrayList<PSDEDRDetail> selectByPSSysImage(PSSysImageBase pSSysImageBase) throws Exception {
        return this.selectByPSSysImage(pSSysImageBase, "", -1);
    }

    public ArrayList<PSDEDRDetail> selectByPSSysImage(PSSysImageBase pSSysImageBase, String string) throws Exception {
        return this.selectByPSSysImage(pSSysImageBase, string, -1);
    }

    public ArrayList<PSDEDRDetail> selectByPSSysImage(PSSysImageBase pSSysImageBase, String string, int n) throws Exception {
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

    public ArrayList<PSDEDRDetail> selectByPSSysPDTView(PSSysPDTViewBase pSSysPDTViewBase) throws Exception {
        return this.selectByPSSysPDTView(pSSysPDTViewBase, "", -1);
    }

    public ArrayList<PSDEDRDetail> selectByPSSysPDTView(PSSysPDTViewBase pSSysPDTViewBase, String string) throws Exception {
        return this.selectByPSSysPDTView(pSSysPDTViewBase, string, -1);
    }

    public ArrayList<PSDEDRDetail> selectByPSSysPDTView(PSSysPDTViewBase pSSysPDTViewBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSSYSPDTVIEWID", (Object)pSSysPDTViewBase.getPSSysPDTViewId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSSysPDTViewCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSSysPDTViewCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDEDRDetail> selectByHeaderPSSysPFPlugin(PSSysPFPluginBase pSSysPFPluginBase) throws Exception {
        return this.selectByHeaderPSSysPFPlugin(pSSysPFPluginBase, "", -1);
    }

    public ArrayList<PSDEDRDetail> selectByHeaderPSSysPFPlugin(PSSysPFPluginBase pSSysPFPluginBase, String string) throws Exception {
        return this.selectByHeaderPSSysPFPlugin(pSSysPFPluginBase, string, -1);
    }

    public ArrayList<PSDEDRDetail> selectByHeaderPSSysPFPlugin(PSSysPFPluginBase pSSysPFPluginBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("HEADERPSSYSPFPLUGINID", (Object)pSSysPFPluginBase.getPSSysPFPluginId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByHeaderPSSysPFPluginCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByHeaderPSSysPFPluginCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDEDRDetail> selectByPSSysUniRes(PSSysUniResBase pSSysUniResBase) throws Exception {
        return this.selectByPSSysUniRes(pSSysUniResBase, "", -1);
    }

    public ArrayList<PSDEDRDetail> selectByPSSysUniRes(PSSysUniResBase pSSysUniResBase, String string) throws Exception {
        return this.selectByPSSysUniRes(pSSysUniResBase, string, -1);
    }

    public ArrayList<PSDEDRDetail> selectByPSSysUniRes(PSSysUniResBase pSSysUniResBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSSYSUNIRESID", (Object)pSSysUniResBase.getPSSysUniResId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSSysUniResCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSSysUniResCond(SelectCond selectCond) throws Exception {
    }

    public void testRemoveByTestPSDEAction(PSDEAction pSDEAction) throws Exception {
        ArrayList<PSDEDRDetail> arrayList = this.selectByTestPSDEAction(pSDEAction, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEACTION");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDEAction);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEDRDETAIL_PSDEACTION_TESTPSDEACTIONID", "", iDataEntityModel.getName(), "PSDEDRDETAIL", iDataEntityModel.getDataInfo((IEntity)pSDEAction), arrayList.get(0)));
        }
    }

    public void resetTestPSDEAction(PSDEAction pSDEAction) throws Exception {
        ArrayList<PSDEDRDetail> arrayList = this.selectByTestPSDEAction(pSDEAction);
        for (PSDEDRDetail pSDEDRDetail : arrayList) {
            PSDEDRDetail pSDEDRDetail2 = (PSDEDRDetail)this.getDEModel().createEntity();
            pSDEDRDetail2.setPSDEDRDetailId(pSDEDRDetail.getPSDEDRDetailId());
            pSDEDRDetail2.setTestPSDEActionId(null);
            this.update(pSDEDRDetail2);
        }
    }

    public void removeByTestPSDEAction(PSDEAction pSDEAction) throws Exception {
        final PSDEAction pSDEAction2 = pSDEAction;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEDRDetailServiceBase.this.onBeforeRemoveByTestPSDEAction(pSDEAction2);
                PSDEDRDetailServiceBase.this.internalRemoveByTestPSDEAction(pSDEAction2);
                PSDEDRDetailServiceBase.this.onAfterRemoveByTestPSDEAction(pSDEAction2);
            }
        });
    }

    protected void onBeforeRemoveByTestPSDEAction(PSDEAction pSDEAction) throws Exception {
    }

    protected void internalRemoveByTestPSDEAction(PSDEAction pSDEAction) throws Exception {
        ArrayList<PSDEDRDetail> arrayList = this.selectByTestPSDEAction(pSDEAction);
        this.onBeforeRemoveByTestPSDEAction(pSDEAction, arrayList);
        for (PSDEDRDetail pSDEDRDetail : arrayList) {
            this.remove((IEntity)pSDEDRDetail);
        }
        this.onAfterRemoveByTestPSDEAction(pSDEAction, arrayList);
    }

    protected void onAfterRemoveByTestPSDEAction(PSDEAction pSDEAction) throws Exception {
    }

    protected void onBeforeRemoveByTestPSDEAction(PSDEAction pSDEAction, ArrayList<PSDEDRDetail> arrayList) throws Exception {
    }

    protected void onAfterRemoveByTestPSDEAction(PSDEAction pSDEAction, ArrayList<PSDEDRDetail> arrayList) throws Exception {
    }

    public void testRemoveByPSDEDR(PSDEDataRelation pSDEDataRelation) throws Exception {
    }

    public void resetPSDEDR(PSDEDataRelation pSDEDataRelation) throws Exception {
        ArrayList<PSDEDRDetail> arrayList = this.selectByPSDEDR(pSDEDataRelation);
        for (PSDEDRDetail pSDEDRDetail : arrayList) {
            PSDEDRDetail pSDEDRDetail2 = (PSDEDRDetail)this.getDEModel().createEntity();
            pSDEDRDetail2.setPSDEDRDetailId(pSDEDRDetail.getPSDEDRDetailId());
            pSDEDRDetail2.setPSDEDRId(null);
            this.update(pSDEDRDetail2);
        }
    }

    public void resetTempPSDEDR(PSDEDataRelation pSDEDataRelation) throws Exception {
        ArrayList<PSDEDRDetail> arrayList = this.selectTempByPSDEDR(pSDEDataRelation);
        for (PSDEDRDetail pSDEDRDetail : arrayList) {
            PSDEDRDetail pSDEDRDetail2 = (PSDEDRDetail)this.getDEModel().createEntity();
            pSDEDRDetail2.setPSDEDRDetailId(pSDEDRDetail.getPSDEDRDetailId());
            pSDEDRDetail2.setPSDEDRId(null);
            this.updateTemp((IEntity)pSDEDRDetail2);
        }
    }

    public void removeByPSDEDR(PSDEDataRelation pSDEDataRelation) throws Exception {
        final PSDEDataRelation pSDEDataRelation2 = pSDEDataRelation;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEDRDetailServiceBase.this.onBeforeRemoveByPSDEDR(pSDEDataRelation2);
                PSDEDRDetailServiceBase.this.internalRemoveByPSDEDR(pSDEDataRelation2);
                PSDEDRDetailServiceBase.this.onAfterRemoveByPSDEDR(pSDEDataRelation2);
            }
        });
    }

    protected void onBeforeRemoveByPSDEDR(PSDEDataRelation pSDEDataRelation) throws Exception {
    }

    protected void internalRemoveByPSDEDR(PSDEDataRelation pSDEDataRelation) throws Exception {
        ArrayList<PSDEDRDetail> arrayList = this.selectByPSDEDR(pSDEDataRelation);
        this.onBeforeRemoveByPSDEDR(pSDEDataRelation, arrayList);
        for (PSDEDRDetail pSDEDRDetail : arrayList) {
            this.remove((IEntity)pSDEDRDetail);
        }
        this.onAfterRemoveByPSDEDR(pSDEDataRelation, arrayList);
    }

    protected void onAfterRemoveByPSDEDR(PSDEDataRelation pSDEDataRelation) throws Exception {
    }

    protected void onBeforeRemoveByPSDEDR(PSDEDataRelation pSDEDataRelation, ArrayList<PSDEDRDetail> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDEDR(PSDEDataRelation pSDEDataRelation, ArrayList<PSDEDRDetail> arrayList) throws Exception {
    }

    public void testRemoveByPSDEDRGroup(PSDEDRGroup pSDEDRGroup) throws Exception {
        ArrayList<PSDEDRDetail> arrayList = this.selectByPSDEDRGroup(pSDEDRGroup, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEDRGROUP");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDEDRGroup);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEDRDETAIL_PSDEDRGROUP_PSDEDRGROUPID", "", iDataEntityModel.getName(), "PSDEDRDETAIL", iDataEntityModel.getDataInfo((IEntity)pSDEDRGroup), arrayList.get(0)));
        }
    }

    public void resetPSDEDRGroup(PSDEDRGroup pSDEDRGroup) throws Exception {
        ArrayList<PSDEDRDetail> arrayList = this.selectByPSDEDRGroup(pSDEDRGroup);
        for (PSDEDRDetail pSDEDRDetail : arrayList) {
            PSDEDRDetail pSDEDRDetail2 = (PSDEDRDetail)this.getDEModel().createEntity();
            pSDEDRDetail2.setPSDEDRDetailId(pSDEDRDetail.getPSDEDRDetailId());
            pSDEDRDetail2.setPSDEDRGroupId(null);
            this.update(pSDEDRDetail2);
        }
    }

    public void removeByPSDEDRGroup(PSDEDRGroup pSDEDRGroup) throws Exception {
        final PSDEDRGroup pSDEDRGroup2 = pSDEDRGroup;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEDRDetailServiceBase.this.onBeforeRemoveByPSDEDRGroup(pSDEDRGroup2);
                PSDEDRDetailServiceBase.this.internalRemoveByPSDEDRGroup(pSDEDRGroup2);
                PSDEDRDetailServiceBase.this.onAfterRemoveByPSDEDRGroup(pSDEDRGroup2);
            }
        });
    }

    protected void onBeforeRemoveByPSDEDRGroup(PSDEDRGroup pSDEDRGroup) throws Exception {
    }

    protected void internalRemoveByPSDEDRGroup(PSDEDRGroup pSDEDRGroup) throws Exception {
        ArrayList<PSDEDRDetail> arrayList = this.selectByPSDEDRGroup(pSDEDRGroup);
        this.onBeforeRemoveByPSDEDRGroup(pSDEDRGroup, arrayList);
        for (PSDEDRDetail pSDEDRDetail : arrayList) {
            this.remove((IEntity)pSDEDRDetail);
        }
        this.onAfterRemoveByPSDEDRGroup(pSDEDRGroup, arrayList);
    }

    protected void onAfterRemoveByPSDEDRGroup(PSDEDRGroup pSDEDRGroup) throws Exception {
    }

    protected void onBeforeRemoveByPSDEDRGroup(PSDEDRGroup pSDEDRGroup, ArrayList<PSDEDRDetail> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDEDRGroup(PSDEDRGroup pSDEDRGroup, ArrayList<PSDEDRDetail> arrayList) throws Exception {
    }

    public void testRemoveByPSDEDRItem(PSDEDRItem pSDEDRItem) throws Exception {
    }

    public void resetPSDEDRItem(PSDEDRItem pSDEDRItem) throws Exception {
        ArrayList<PSDEDRDetail> arrayList = this.selectByPSDEDRItem(pSDEDRItem);
        for (PSDEDRDetail pSDEDRDetail : arrayList) {
            PSDEDRDetail pSDEDRDetail2 = (PSDEDRDetail)this.getDEModel().createEntity();
            pSDEDRDetail2.setPSDEDRDetailId(pSDEDRDetail.getPSDEDRDetailId());
            pSDEDRDetail2.setPSDEDRItemId(null);
            this.update(pSDEDRDetail2);
        }
    }

    public void removeByPSDEDRItem(PSDEDRItem pSDEDRItem) throws Exception {
        final PSDEDRItem pSDEDRItem2 = pSDEDRItem;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEDRDetailServiceBase.this.onBeforeRemoveByPSDEDRItem(pSDEDRItem2);
                PSDEDRDetailServiceBase.this.internalRemoveByPSDEDRItem(pSDEDRItem2);
                PSDEDRDetailServiceBase.this.onAfterRemoveByPSDEDRItem(pSDEDRItem2);
            }
        });
    }

    protected void onBeforeRemoveByPSDEDRItem(PSDEDRItem pSDEDRItem) throws Exception {
    }

    protected void internalRemoveByPSDEDRItem(PSDEDRItem pSDEDRItem) throws Exception {
        ArrayList<PSDEDRDetail> arrayList = this.selectByPSDEDRItem(pSDEDRItem);
        this.onBeforeRemoveByPSDEDRItem(pSDEDRItem, arrayList);
        for (PSDEDRDetail pSDEDRDetail : arrayList) {
            this.remove((IEntity)pSDEDRDetail);
        }
        this.onAfterRemoveByPSDEDRItem(pSDEDRItem, arrayList);
    }

    protected void onAfterRemoveByPSDEDRItem(PSDEDRItem pSDEDRItem) throws Exception {
    }

    protected void onBeforeRemoveByPSDEDRItem(PSDEDRItem pSDEDRItem, ArrayList<PSDEDRDetail> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDEDRItem(PSDEDRItem pSDEDRItem, ArrayList<PSDEDRDetail> arrayList) throws Exception {
    }

    public void testRemoveByTestPSDELogic(PSDELogic pSDELogic) throws Exception {
        ArrayList<PSDEDRDetail> arrayList = this.selectByTestPSDELogic(pSDELogic, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDELOGIC");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDELogic);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEDRDETAIL_PSDELOGIC_TESTPSDELOGICID", "", iDataEntityModel.getName(), "PSDEDRDETAIL", iDataEntityModel.getDataInfo((IEntity)pSDELogic), arrayList.get(0)));
        }
    }

    public void resetTestPSDELogic(PSDELogic pSDELogic) throws Exception {
        ArrayList<PSDEDRDetail> arrayList = this.selectByTestPSDELogic(pSDELogic);
        for (PSDEDRDetail pSDEDRDetail : arrayList) {
            PSDEDRDetail pSDEDRDetail2 = (PSDEDRDetail)this.getDEModel().createEntity();
            pSDEDRDetail2.setPSDEDRDetailId(pSDEDRDetail.getPSDEDRDetailId());
            pSDEDRDetail2.setTestPSDELogicId(null);
            this.update(pSDEDRDetail2);
        }
    }

    public void removeByTestPSDELogic(PSDELogic pSDELogic) throws Exception {
        final PSDELogic pSDELogic2 = pSDELogic;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEDRDetailServiceBase.this.onBeforeRemoveByTestPSDELogic(pSDELogic2);
                PSDEDRDetailServiceBase.this.internalRemoveByTestPSDELogic(pSDELogic2);
                PSDEDRDetailServiceBase.this.onAfterRemoveByTestPSDELogic(pSDELogic2);
            }
        });
    }

    protected void onBeforeRemoveByTestPSDELogic(PSDELogic pSDELogic) throws Exception {
    }

    protected void internalRemoveByTestPSDELogic(PSDELogic pSDELogic) throws Exception {
        ArrayList<PSDEDRDetail> arrayList = this.selectByTestPSDELogic(pSDELogic);
        this.onBeforeRemoveByTestPSDELogic(pSDELogic, arrayList);
        for (PSDEDRDetail pSDEDRDetail : arrayList) {
            this.remove((IEntity)pSDEDRDetail);
        }
        this.onAfterRemoveByTestPSDELogic(pSDELogic, arrayList);
    }

    protected void onAfterRemoveByTestPSDELogic(PSDELogic pSDELogic) throws Exception {
    }

    protected void onBeforeRemoveByTestPSDELogic(PSDELogic pSDELogic, ArrayList<PSDEDRDetail> arrayList) throws Exception {
    }

    protected void onAfterRemoveByTestPSDELogic(PSDELogic pSDELogic, ArrayList<PSDEDRDetail> arrayList) throws Exception {
    }

    public void testRemoveByPSDEOPPriv(PSDEOPPriv pSDEOPPriv) throws Exception {
        ArrayList<PSDEDRDetail> arrayList = this.selectByPSDEOPPriv(pSDEOPPriv, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEOPPRIV");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDEOPPriv);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEDRDETAIL_PSDEOPPRIV_PSDEOPPRIVID", "", iDataEntityModel.getName(), "PSDEDRDETAIL", iDataEntityModel.getDataInfo((IEntity)pSDEOPPriv), arrayList.get(0)));
        }
    }

    public void resetPSDEOPPriv(PSDEOPPriv pSDEOPPriv) throws Exception {
        ArrayList<PSDEDRDetail> arrayList = this.selectByPSDEOPPriv(pSDEOPPriv);
        for (PSDEDRDetail pSDEDRDetail : arrayList) {
            PSDEDRDetail pSDEDRDetail2 = (PSDEDRDetail)this.getDEModel().createEntity();
            pSDEDRDetail2.setPSDEDRDetailId(pSDEDRDetail.getPSDEDRDetailId());
            pSDEDRDetail2.setPSDEOPPrivId(null);
            this.update(pSDEDRDetail2);
        }
    }

    public void removeByPSDEOPPriv(PSDEOPPriv pSDEOPPriv) throws Exception {
        final PSDEOPPriv pSDEOPPriv2 = pSDEOPPriv;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEDRDetailServiceBase.this.onBeforeRemoveByPSDEOPPriv(pSDEOPPriv2);
                PSDEDRDetailServiceBase.this.internalRemoveByPSDEOPPriv(pSDEOPPriv2);
                PSDEDRDetailServiceBase.this.onAfterRemoveByPSDEOPPriv(pSDEOPPriv2);
            }
        });
    }

    protected void onBeforeRemoveByPSDEOPPriv(PSDEOPPriv pSDEOPPriv) throws Exception {
    }

    protected void internalRemoveByPSDEOPPriv(PSDEOPPriv pSDEOPPriv) throws Exception {
        ArrayList<PSDEDRDetail> arrayList = this.selectByPSDEOPPriv(pSDEOPPriv);
        this.onBeforeRemoveByPSDEOPPriv(pSDEOPPriv, arrayList);
        for (PSDEDRDetail pSDEDRDetail : arrayList) {
            this.remove((IEntity)pSDEDRDetail);
        }
        this.onAfterRemoveByPSDEOPPriv(pSDEOPPriv, arrayList);
    }

    protected void onAfterRemoveByPSDEOPPriv(PSDEOPPriv pSDEOPPriv) throws Exception {
    }

    protected void onBeforeRemoveByPSDEOPPriv(PSDEOPPriv pSDEOPPriv, ArrayList<PSDEDRDetail> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDEOPPriv(PSDEOPPriv pSDEOPPriv, ArrayList<PSDEDRDetail> arrayList) throws Exception {
    }

    public void testRemoveByPSDETreeView(PSDETreeView pSDETreeView) throws Exception {
        ArrayList<PSDEDRDetail> arrayList = this.selectByPSDETreeView(pSDETreeView, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDETREEVIEW");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDETreeView);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEDRDETAIL_PSDETREEVIEW_PSDETREEVIEWID", "", iDataEntityModel.getName(), "PSDEDRDETAIL", iDataEntityModel.getDataInfo((IEntity)pSDETreeView), arrayList.get(0)));
        }
    }

    public void resetPSDETreeView(PSDETreeView pSDETreeView) throws Exception {
        ArrayList<PSDEDRDetail> arrayList = this.selectByPSDETreeView(pSDETreeView);
        for (PSDEDRDetail pSDEDRDetail : arrayList) {
            PSDEDRDetail pSDEDRDetail2 = (PSDEDRDetail)this.getDEModel().createEntity();
            pSDEDRDetail2.setPSDEDRDetailId(pSDEDRDetail.getPSDEDRDetailId());
            pSDEDRDetail2.setPSDETreeViewId(null);
            this.update(pSDEDRDetail2);
        }
    }

    public void removeByPSDETreeView(PSDETreeView pSDETreeView) throws Exception {
        final PSDETreeView pSDETreeView2 = pSDETreeView;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEDRDetailServiceBase.this.onBeforeRemoveByPSDETreeView(pSDETreeView2);
                PSDEDRDetailServiceBase.this.internalRemoveByPSDETreeView(pSDETreeView2);
                PSDEDRDetailServiceBase.this.onAfterRemoveByPSDETreeView(pSDETreeView2);
            }
        });
    }

    protected void onBeforeRemoveByPSDETreeView(PSDETreeView pSDETreeView) throws Exception {
    }

    protected void internalRemoveByPSDETreeView(PSDETreeView pSDETreeView) throws Exception {
        ArrayList<PSDEDRDetail> arrayList = this.selectByPSDETreeView(pSDETreeView);
        this.onBeforeRemoveByPSDETreeView(pSDETreeView, arrayList);
        for (PSDEDRDetail pSDEDRDetail : arrayList) {
            this.remove((IEntity)pSDEDRDetail);
        }
        this.onAfterRemoveByPSDETreeView(pSDETreeView, arrayList);
    }

    protected void onAfterRemoveByPSDETreeView(PSDETreeView pSDETreeView) throws Exception {
    }

    protected void onBeforeRemoveByPSDETreeView(PSDETreeView pSDETreeView, ArrayList<PSDEDRDetail> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDETreeView(PSDETreeView pSDETreeView, ArrayList<PSDEDRDetail> arrayList) throws Exception {
    }

    public void testRemoveByCapPSLanRes(PSLanguageRes pSLanguageRes) throws Exception {
        ArrayList<PSDEDRDetail> arrayList = this.selectByCapPSLanRes(pSLanguageRes, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSLANGUAGERES");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSLanguageRes);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEDRDETAIL_PSLANGUAGERES_CAPPSLANRESID", "", iDataEntityModel.getName(), "PSDEDRDETAIL", iDataEntityModel.getDataInfo((IEntity)pSLanguageRes), arrayList.get(0)));
        }
    }

    public void resetCapPSLanRes(PSLanguageRes pSLanguageRes) throws Exception {
        ArrayList<PSDEDRDetail> arrayList = this.selectByCapPSLanRes(pSLanguageRes);
        for (PSDEDRDetail pSDEDRDetail : arrayList) {
            PSDEDRDetail pSDEDRDetail2 = (PSDEDRDetail)this.getDEModel().createEntity();
            pSDEDRDetail2.setPSDEDRDetailId(pSDEDRDetail.getPSDEDRDetailId());
            pSDEDRDetail2.setCapPSLanResId(null);
            this.update(pSDEDRDetail2);
        }
    }

    public void removeByCapPSLanRes(PSLanguageRes pSLanguageRes) throws Exception {
        final PSLanguageRes pSLanguageRes2 = pSLanguageRes;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEDRDetailServiceBase.this.onBeforeRemoveByCapPSLanRes(pSLanguageRes2);
                PSDEDRDetailServiceBase.this.internalRemoveByCapPSLanRes(pSLanguageRes2);
                PSDEDRDetailServiceBase.this.onAfterRemoveByCapPSLanRes(pSLanguageRes2);
            }
        });
    }

    protected void onBeforeRemoveByCapPSLanRes(PSLanguageRes pSLanguageRes) throws Exception {
    }

    protected void internalRemoveByCapPSLanRes(PSLanguageRes pSLanguageRes) throws Exception {
        ArrayList<PSDEDRDetail> arrayList = this.selectByCapPSLanRes(pSLanguageRes);
        this.onBeforeRemoveByCapPSLanRes(pSLanguageRes, arrayList);
        for (PSDEDRDetail pSDEDRDetail : arrayList) {
            this.remove((IEntity)pSDEDRDetail);
        }
        this.onAfterRemoveByCapPSLanRes(pSLanguageRes, arrayList);
    }

    protected void onAfterRemoveByCapPSLanRes(PSLanguageRes pSLanguageRes) throws Exception {
    }

    protected void onBeforeRemoveByCapPSLanRes(PSLanguageRes pSLanguageRes, ArrayList<PSDEDRDetail> arrayList) throws Exception {
    }

    protected void onAfterRemoveByCapPSLanRes(PSLanguageRes pSLanguageRes, ArrayList<PSDEDRDetail> arrayList) throws Exception {
    }

    public void testRemoveByTipPSLanRes(PSLanguageRes pSLanguageRes) throws Exception {
        ArrayList<PSDEDRDetail> arrayList = this.selectByTipPSLanRes(pSLanguageRes, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSLANGUAGERES");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSLanguageRes);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEDRDETAIL_PSLANGUAGERES_TIPPSLANRESID", "", iDataEntityModel.getName(), "PSDEDRDETAIL", iDataEntityModel.getDataInfo((IEntity)pSLanguageRes), arrayList.get(0)));
        }
    }

    public void resetTipPSLanRes(PSLanguageRes pSLanguageRes) throws Exception {
        ArrayList<PSDEDRDetail> arrayList = this.selectByTipPSLanRes(pSLanguageRes);
        for (PSDEDRDetail pSDEDRDetail : arrayList) {
            PSDEDRDetail pSDEDRDetail2 = (PSDEDRDetail)this.getDEModel().createEntity();
            pSDEDRDetail2.setPSDEDRDetailId(pSDEDRDetail.getPSDEDRDetailId());
            pSDEDRDetail2.setTipPSLanResId(null);
            this.update(pSDEDRDetail2);
        }
    }

    public void removeByTipPSLanRes(PSLanguageRes pSLanguageRes) throws Exception {
        final PSLanguageRes pSLanguageRes2 = pSLanguageRes;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEDRDetailServiceBase.this.onBeforeRemoveByTipPSLanRes(pSLanguageRes2);
                PSDEDRDetailServiceBase.this.internalRemoveByTipPSLanRes(pSLanguageRes2);
                PSDEDRDetailServiceBase.this.onAfterRemoveByTipPSLanRes(pSLanguageRes2);
            }
        });
    }

    protected void onBeforeRemoveByTipPSLanRes(PSLanguageRes pSLanguageRes) throws Exception {
    }

    protected void internalRemoveByTipPSLanRes(PSLanguageRes pSLanguageRes) throws Exception {
        ArrayList<PSDEDRDetail> arrayList = this.selectByTipPSLanRes(pSLanguageRes);
        this.onBeforeRemoveByTipPSLanRes(pSLanguageRes, arrayList);
        for (PSDEDRDetail pSDEDRDetail : arrayList) {
            this.remove((IEntity)pSDEDRDetail);
        }
        this.onAfterRemoveByTipPSLanRes(pSLanguageRes, arrayList);
    }

    protected void onAfterRemoveByTipPSLanRes(PSLanguageRes pSLanguageRes) throws Exception {
    }

    protected void onBeforeRemoveByTipPSLanRes(PSLanguageRes pSLanguageRes, ArrayList<PSDEDRDetail> arrayList) throws Exception {
    }

    protected void onAfterRemoveByTipPSLanRes(PSLanguageRes pSLanguageRes, ArrayList<PSDEDRDetail> arrayList) throws Exception {
    }

    public void testRemoveByPSSysCss(PSSysCss pSSysCss) throws Exception {
        ArrayList<PSDEDRDetail> arrayList = this.selectByPSSysCss(pSSysCss, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSCSS");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSSysCss);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEDRDETAIL_PSSYSCSS_PSSYSCSSID", "", iDataEntityModel.getName(), "PSDEDRDETAIL", iDataEntityModel.getDataInfo((IEntity)pSSysCss), arrayList.get(0)));
        }
    }

    public void resetPSSysCss(PSSysCss pSSysCss) throws Exception {
        ArrayList<PSDEDRDetail> arrayList = this.selectByPSSysCss(pSSysCss);
        for (PSDEDRDetail pSDEDRDetail : arrayList) {
            PSDEDRDetail pSDEDRDetail2 = (PSDEDRDetail)this.getDEModel().createEntity();
            pSDEDRDetail2.setPSDEDRDetailId(pSDEDRDetail.getPSDEDRDetailId());
            pSDEDRDetail2.setPSSysCssId(null);
            this.update(pSDEDRDetail2);
        }
    }

    public void removeByPSSysCss(PSSysCss pSSysCss) throws Exception {
        final PSSysCss pSSysCss2 = pSSysCss;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEDRDetailServiceBase.this.onBeforeRemoveByPSSysCss(pSSysCss2);
                PSDEDRDetailServiceBase.this.internalRemoveByPSSysCss(pSSysCss2);
                PSDEDRDetailServiceBase.this.onAfterRemoveByPSSysCss(pSSysCss2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysCss(PSSysCss pSSysCss) throws Exception {
    }

    protected void internalRemoveByPSSysCss(PSSysCss pSSysCss) throws Exception {
        ArrayList<PSDEDRDetail> arrayList = this.selectByPSSysCss(pSSysCss);
        this.onBeforeRemoveByPSSysCss(pSSysCss, arrayList);
        for (PSDEDRDetail pSDEDRDetail : arrayList) {
            this.remove((IEntity)pSDEDRDetail);
        }
        this.onAfterRemoveByPSSysCss(pSSysCss, arrayList);
    }

    protected void onAfterRemoveByPSSysCss(PSSysCss pSSysCss) throws Exception {
    }

    protected void onBeforeRemoveByPSSysCss(PSSysCss pSSysCss, ArrayList<PSDEDRDetail> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysCss(PSSysCss pSSysCss, ArrayList<PSDEDRDetail> arrayList) throws Exception {
    }

    public void testRemoveByPSSysImage(PSSysImage pSSysImage) throws Exception {
        ArrayList<PSDEDRDetail> arrayList = this.selectByPSSysImage(pSSysImage, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSIMAGE");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSSysImage);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEDRDETAIL_PSSYSIMAGE_PSSYSIMAGEID", "", iDataEntityModel.getName(), "PSDEDRDETAIL", iDataEntityModel.getDataInfo((IEntity)pSSysImage), arrayList.get(0)));
        }
    }

    public void resetPSSysImage(PSSysImage pSSysImage) throws Exception {
        ArrayList<PSDEDRDetail> arrayList = this.selectByPSSysImage(pSSysImage);
        for (PSDEDRDetail pSDEDRDetail : arrayList) {
            PSDEDRDetail pSDEDRDetail2 = (PSDEDRDetail)this.getDEModel().createEntity();
            pSDEDRDetail2.setPSDEDRDetailId(pSDEDRDetail.getPSDEDRDetailId());
            pSDEDRDetail2.setPSSysImageId(null);
            this.update(pSDEDRDetail2);
        }
    }

    public void removeByPSSysImage(PSSysImage pSSysImage) throws Exception {
        final PSSysImage pSSysImage2 = pSSysImage;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEDRDetailServiceBase.this.onBeforeRemoveByPSSysImage(pSSysImage2);
                PSDEDRDetailServiceBase.this.internalRemoveByPSSysImage(pSSysImage2);
                PSDEDRDetailServiceBase.this.onAfterRemoveByPSSysImage(pSSysImage2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysImage(PSSysImage pSSysImage) throws Exception {
    }

    protected void internalRemoveByPSSysImage(PSSysImage pSSysImage) throws Exception {
        ArrayList<PSDEDRDetail> arrayList = this.selectByPSSysImage(pSSysImage);
        this.onBeforeRemoveByPSSysImage(pSSysImage, arrayList);
        for (PSDEDRDetail pSDEDRDetail : arrayList) {
            this.remove((IEntity)pSDEDRDetail);
        }
        this.onAfterRemoveByPSSysImage(pSSysImage, arrayList);
    }

    protected void onAfterRemoveByPSSysImage(PSSysImage pSSysImage) throws Exception {
    }

    protected void onBeforeRemoveByPSSysImage(PSSysImage pSSysImage, ArrayList<PSDEDRDetail> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysImage(PSSysImage pSSysImage, ArrayList<PSDEDRDetail> arrayList) throws Exception {
    }

    public void testRemoveByPSSysPDTView(PSSysPDTView pSSysPDTView) throws Exception {
        ArrayList<PSDEDRDetail> arrayList = this.selectByPSSysPDTView(pSSysPDTView, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSPDTVIEW");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSSysPDTView);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEDRDETAIL_PSSYSPDTVIEW_PSSYSPDTVIEWID", "", iDataEntityModel.getName(), "PSDEDRDETAIL", iDataEntityModel.getDataInfo((IEntity)pSSysPDTView), arrayList.get(0)));
        }
    }

    public void resetPSSysPDTView(PSSysPDTView pSSysPDTView) throws Exception {
        ArrayList<PSDEDRDetail> arrayList = this.selectByPSSysPDTView(pSSysPDTView);
        for (PSDEDRDetail pSDEDRDetail : arrayList) {
            PSDEDRDetail pSDEDRDetail2 = (PSDEDRDetail)this.getDEModel().createEntity();
            pSDEDRDetail2.setPSDEDRDetailId(pSDEDRDetail.getPSDEDRDetailId());
            pSDEDRDetail2.setPSSysPDTViewId(null);
            this.update(pSDEDRDetail2);
        }
    }

    public void removeByPSSysPDTView(PSSysPDTView pSSysPDTView) throws Exception {
        final PSSysPDTView pSSysPDTView2 = pSSysPDTView;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEDRDetailServiceBase.this.onBeforeRemoveByPSSysPDTView(pSSysPDTView2);
                PSDEDRDetailServiceBase.this.internalRemoveByPSSysPDTView(pSSysPDTView2);
                PSDEDRDetailServiceBase.this.onAfterRemoveByPSSysPDTView(pSSysPDTView2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysPDTView(PSSysPDTView pSSysPDTView) throws Exception {
    }

    protected void internalRemoveByPSSysPDTView(PSSysPDTView pSSysPDTView) throws Exception {
        ArrayList<PSDEDRDetail> arrayList = this.selectByPSSysPDTView(pSSysPDTView);
        this.onBeforeRemoveByPSSysPDTView(pSSysPDTView, arrayList);
        for (PSDEDRDetail pSDEDRDetail : arrayList) {
            this.remove((IEntity)pSDEDRDetail);
        }
        this.onAfterRemoveByPSSysPDTView(pSSysPDTView, arrayList);
    }

    protected void onAfterRemoveByPSSysPDTView(PSSysPDTView pSSysPDTView) throws Exception {
    }

    protected void onBeforeRemoveByPSSysPDTView(PSSysPDTView pSSysPDTView, ArrayList<PSDEDRDetail> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysPDTView(PSSysPDTView pSSysPDTView, ArrayList<PSDEDRDetail> arrayList) throws Exception {
    }

    public void testRemoveByHeaderPSSysPFPlugin(PSSysPFPlugin pSSysPFPlugin) throws Exception {
        ArrayList<PSDEDRDetail> arrayList = this.selectByHeaderPSSysPFPlugin(pSSysPFPlugin, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSPFPLUGIN");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSSysPFPlugin);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEDRDETAIL_PSSYSPFPLUGIN_HEADERPSSYSPFPLUGINID", "", iDataEntityModel.getName(), "PSDEDRDETAIL", iDataEntityModel.getDataInfo((IEntity)pSSysPFPlugin), arrayList.get(0)));
        }
    }

    public void resetHeaderPSSysPFPlugin(PSSysPFPlugin pSSysPFPlugin) throws Exception {
        ArrayList<PSDEDRDetail> arrayList = this.selectByHeaderPSSysPFPlugin(pSSysPFPlugin);
        for (PSDEDRDetail pSDEDRDetail : arrayList) {
            PSDEDRDetail pSDEDRDetail2 = (PSDEDRDetail)this.getDEModel().createEntity();
            pSDEDRDetail2.setPSDEDRDetailId(pSDEDRDetail.getPSDEDRDetailId());
            pSDEDRDetail2.setHeaderPSSysPFPluginId(null);
            this.update(pSDEDRDetail2);
        }
    }

    public void removeByHeaderPSSysPFPlugin(PSSysPFPlugin pSSysPFPlugin) throws Exception {
        final PSSysPFPlugin pSSysPFPlugin2 = pSSysPFPlugin;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEDRDetailServiceBase.this.onBeforeRemoveByHeaderPSSysPFPlugin(pSSysPFPlugin2);
                PSDEDRDetailServiceBase.this.internalRemoveByHeaderPSSysPFPlugin(pSSysPFPlugin2);
                PSDEDRDetailServiceBase.this.onAfterRemoveByHeaderPSSysPFPlugin(pSSysPFPlugin2);
            }
        });
    }

    protected void onBeforeRemoveByHeaderPSSysPFPlugin(PSSysPFPlugin pSSysPFPlugin) throws Exception {
    }

    protected void internalRemoveByHeaderPSSysPFPlugin(PSSysPFPlugin pSSysPFPlugin) throws Exception {
        ArrayList<PSDEDRDetail> arrayList = this.selectByHeaderPSSysPFPlugin(pSSysPFPlugin);
        this.onBeforeRemoveByHeaderPSSysPFPlugin(pSSysPFPlugin, arrayList);
        for (PSDEDRDetail pSDEDRDetail : arrayList) {
            this.remove((IEntity)pSDEDRDetail);
        }
        this.onAfterRemoveByHeaderPSSysPFPlugin(pSSysPFPlugin, arrayList);
    }

    protected void onAfterRemoveByHeaderPSSysPFPlugin(PSSysPFPlugin pSSysPFPlugin) throws Exception {
    }

    protected void onBeforeRemoveByHeaderPSSysPFPlugin(PSSysPFPlugin pSSysPFPlugin, ArrayList<PSDEDRDetail> arrayList) throws Exception {
    }

    protected void onAfterRemoveByHeaderPSSysPFPlugin(PSSysPFPlugin pSSysPFPlugin, ArrayList<PSDEDRDetail> arrayList) throws Exception {
    }

    public void testRemoveByPSSysUniRes(PSSysUniRes pSSysUniRes) throws Exception {
        ArrayList<PSDEDRDetail> arrayList = this.selectByPSSysUniRes(pSSysUniRes, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSUNIRES");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSSysUniRes);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEDRDETAIL_PSSYSUNIRES_PSSYSUNIRESID", "", iDataEntityModel.getName(), "PSDEDRDETAIL", iDataEntityModel.getDataInfo((IEntity)pSSysUniRes), arrayList.get(0)));
        }
    }

    public void resetPSSysUniRes(PSSysUniRes pSSysUniRes) throws Exception {
        ArrayList<PSDEDRDetail> arrayList = this.selectByPSSysUniRes(pSSysUniRes);
        for (PSDEDRDetail pSDEDRDetail : arrayList) {
            PSDEDRDetail pSDEDRDetail2 = (PSDEDRDetail)this.getDEModel().createEntity();
            pSDEDRDetail2.setPSDEDRDetailId(pSDEDRDetail.getPSDEDRDetailId());
            pSDEDRDetail2.setPSSysUniResId(null);
            this.update(pSDEDRDetail2);
        }
    }

    public void removeByPSSysUniRes(PSSysUniRes pSSysUniRes) throws Exception {
        final PSSysUniRes pSSysUniRes2 = pSSysUniRes;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEDRDetailServiceBase.this.onBeforeRemoveByPSSysUniRes(pSSysUniRes2);
                PSDEDRDetailServiceBase.this.internalRemoveByPSSysUniRes(pSSysUniRes2);
                PSDEDRDetailServiceBase.this.onAfterRemoveByPSSysUniRes(pSSysUniRes2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysUniRes(PSSysUniRes pSSysUniRes) throws Exception {
    }

    protected void internalRemoveByPSSysUniRes(PSSysUniRes pSSysUniRes) throws Exception {
        ArrayList<PSDEDRDetail> arrayList = this.selectByPSSysUniRes(pSSysUniRes);
        this.onBeforeRemoveByPSSysUniRes(pSSysUniRes, arrayList);
        for (PSDEDRDetail pSDEDRDetail : arrayList) {
            this.remove((IEntity)pSDEDRDetail);
        }
        this.onAfterRemoveByPSSysUniRes(pSSysUniRes, arrayList);
    }

    protected void onAfterRemoveByPSSysUniRes(PSSysUniRes pSSysUniRes) throws Exception {
    }

    protected void onBeforeRemoveByPSSysUniRes(PSSysUniRes pSSysUniRes, ArrayList<PSDEDRDetail> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysUniRes(PSSysUniRes pSSysUniRes, ArrayList<PSDEDRDetail> arrayList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(PSDEDRDetail pSDEDRDetail) throws Exception {
        PSDEDRLogicService pSDEDRLogicService = (PSDEDRLogicService)ServiceGlobal.getService(PSDEDRLogicService.class, (SessionFactory)this.getSessionFactory());
        pSDEDRLogicService.testRemoveByPSDEDRDetail(pSDEDRDetail);
        super.onBeforeRemove(pSDEDRDetail);
    }

    protected void onBeforeRemoveTemp(PSDEDRDetail pSDEDRDetail) throws Exception {
        PSDEDRLogicService pSDEDRLogicService = (PSDEDRLogicService)ServiceGlobal.getService(PSDEDRLogicService.class, (SessionFactory)this.getSessionFactory());
        pSDEDRLogicService.resetTempPSDEDRDetail(pSDEDRDetail);
        super.onBeforeRemoveTemp((IEntity)pSDEDRDetail);
    }

    public void removeTempByPSDEDR(PSDEDataRelation pSDEDataRelation) throws Exception {
        final PSDEDataRelation pSDEDataRelation2 = pSDEDataRelation;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEDRDetailServiceBase.this.onBeforeRemoveTempByPSDEDR(pSDEDataRelation2);
                PSDEDRDetailServiceBase.this.internalRemoveTempByPSDEDR(pSDEDataRelation2);
                PSDEDRDetailServiceBase.this.onAfterRemoveTempByPSDEDR(pSDEDataRelation2);
            }
        });
    }

    protected void onBeforeRemoveTempByPSDEDR(PSDEDataRelation pSDEDataRelation) throws Exception {
    }

    protected void internalRemoveTempByPSDEDR(PSDEDataRelation pSDEDataRelation) throws Exception {
        ArrayList<PSDEDRDetail> arrayList = this.selectTempByPSDEDR(pSDEDataRelation);
        this.onBeforeRemoveTempByPSDEDR(pSDEDataRelation, arrayList);
        for (PSDEDRDetail pSDEDRDetail : arrayList) {
            this.removeTemp((IEntity)pSDEDRDetail);
        }
        this.onAfterRemoveTempByPSDEDR(pSDEDataRelation, arrayList);
    }

    protected void onAfterRemoveTempByPSDEDR(PSDEDataRelation pSDEDataRelation) throws Exception {
    }

    protected void onBeforeRemoveTempByPSDEDR(PSDEDataRelation pSDEDataRelation, ArrayList<PSDEDRDetail> arrayList) throws Exception {
    }

    protected void onAfterRemoveTempByPSDEDR(PSDEDataRelation pSDEDataRelation, ArrayList<PSDEDRDetail> arrayList) throws Exception {
    }

    protected void getRelatedDataTempMajor(PSDEDRDetail pSDEDRDetail) throws Exception {
        super.getRelatedDataTempMajor((IEntity)pSDEDRDetail);
    }

    protected void updateRelatedDataTempMajor(PSDEDRDetail pSDEDRDetail, PSDEDRDetail pSDEDRDetail2) throws Exception {
        super.updateRelatedDataTempMajor((IEntity)pSDEDRDetail, (IEntity)pSDEDRDetail2);
    }

    protected void replaceParentInfo(PSDEDRDetail pSDEDRDetail, CloneSession cloneSession) throws Exception {
        IEntity iEntity;
        super.replaceParentInfo((IEntity)pSDEDRDetail, cloneSession);
        if (pSDEDRDetail.getTestPSDEActionId() != null && (iEntity = cloneSession.getEntity("PSDEACTION", (Object)pSDEDRDetail.getTestPSDEActionId())) != null) {
            this.onFillParentInfo_TestPSDEAction(pSDEDRDetail, (PSDEAction)iEntity);
        }
        if (pSDEDRDetail.getPSDEDRId() != null && (iEntity = cloneSession.getEntity("PSDEDATARELATION", (Object)pSDEDRDetail.getPSDEDRId())) != null) {
            this.onFillParentInfo_PSDEDR(pSDEDRDetail, (PSDEDataRelation)iEntity);
        }
        if (pSDEDRDetail.getPSDEDRGroupId() != null && (iEntity = cloneSession.getEntity("PSDEDRGROUP", (Object)pSDEDRDetail.getPSDEDRGroupId())) != null) {
            this.onFillParentInfo_PSDEDRGroup(pSDEDRDetail, (PSDEDRGroup)iEntity);
        }
        if (pSDEDRDetail.getPSDEDRItemId() != null && (iEntity = cloneSession.getEntity("PSDEDRITEM", (Object)pSDEDRDetail.getPSDEDRItemId())) != null) {
            this.onFillParentInfo_PSDEDRItem(pSDEDRDetail, (PSDEDRItem)iEntity);
        }
        if (pSDEDRDetail.getTestPSDELogicId() != null && (iEntity = cloneSession.getEntity("PSDELOGIC", (Object)pSDEDRDetail.getTestPSDELogicId())) != null) {
            this.onFillParentInfo_TestPSDELogic(pSDEDRDetail, (PSDELogic)iEntity);
        }
        if (pSDEDRDetail.getPSDEOPPrivId() != null && (iEntity = cloneSession.getEntity("PSDEOPPRIV", (Object)pSDEDRDetail.getPSDEOPPrivId())) != null) {
            this.onFillParentInfo_PSDEOPPriv(pSDEDRDetail, (PSDEOPPriv)iEntity);
        }
        if (pSDEDRDetail.getPSDETreeViewId() != null && (iEntity = cloneSession.getEntity("PSDETREEVIEW", (Object)pSDEDRDetail.getPSDETreeViewId())) != null) {
            this.onFillParentInfo_PSDETreeView(pSDEDRDetail, (PSDETreeView)iEntity);
        }
        if (pSDEDRDetail.getCapPSLanResId() != null && (iEntity = cloneSession.getEntity("PSLANGUAGERES", (Object)pSDEDRDetail.getCapPSLanResId())) != null) {
            this.onFillParentInfo_CapPSLanRes(pSDEDRDetail, (PSLanguageRes)iEntity);
        }
        if (pSDEDRDetail.getTipPSLanResId() != null && (iEntity = cloneSession.getEntity("PSLANGUAGERES", (Object)pSDEDRDetail.getTipPSLanResId())) != null) {
            this.onFillParentInfo_TipPSLanRes(pSDEDRDetail, (PSLanguageRes)iEntity);
        }
        if (pSDEDRDetail.getPSSysCssId() != null && (iEntity = cloneSession.getEntity("PSSYSCSS", (Object)pSDEDRDetail.getPSSysCssId())) != null) {
            this.onFillParentInfo_PSSysCss(pSDEDRDetail, (PSSysCss)iEntity);
        }
        if (pSDEDRDetail.getPSSysImageId() != null && (iEntity = cloneSession.getEntity("PSSYSIMAGE", (Object)pSDEDRDetail.getPSSysImageId())) != null) {
            this.onFillParentInfo_PSSysImage(pSDEDRDetail, (PSSysImage)iEntity);
        }
        if (pSDEDRDetail.getPSSysPDTViewId() != null && (iEntity = cloneSession.getEntity("PSSYSPDTVIEW", (Object)pSDEDRDetail.getPSSysPDTViewId())) != null) {
            this.onFillParentInfo_PSSysPDTView(pSDEDRDetail, (PSSysPDTView)iEntity);
        }
        if (pSDEDRDetail.getHeaderPSSysPFPluginId() != null && (iEntity = cloneSession.getEntity("PSSYSPFPLUGIN", (Object)pSDEDRDetail.getHeaderPSSysPFPluginId())) != null) {
            this.onFillParentInfo_HeaderPSSysPFPlugin(pSDEDRDetail, (PSSysPFPlugin)iEntity);
        }
        if (pSDEDRDetail.getPSSysUniResId() != null && (iEntity = cloneSession.getEntity("PSSYSUNIRES", (Object)pSDEDRDetail.getPSSysUniResId())) != null) {
            this.onFillParentInfo_PSSysUniRes(pSDEDRDetail, (PSSysUniRes)iEntity);
        }
    }

    protected void onRemoveEntityUncopyValues(PSDEDRDetail pSDEDRDetail, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues((IEntity)pSDEDRDetail, bl);
        pSDEDRDetail.resetPSDEDRDetailName();
    }

    protected void onCheckEntity(boolean bl, PSDEDRDetail pSDEDRDetail, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_CapPSLanResId(bl, pSDEDRDetail, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_CapPSLanResName(bl, pSDEDRDetail, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Caption(bl, pSDEDRDetail, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_CounterId(bl, pSDEDRDetail, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_CounterMode(bl, pSDEDRDetail, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Data(bl, pSDEDRDetail, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_DetailTag(bl, pSDEDRDetail, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_DetailTag2(bl, pSDEDRDetail, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_DetailType(bl, pSDEDRDetail, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_DynaModelFlag(bl, pSDEDRDetail, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_EnableMode(bl, pSDEDRDetail, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_HeaderPSSysPFPluginId(bl, pSDEDRDetail, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Memo(bl, pSDEDRDetail, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_NavViewFilter(bl, pSDEDRDetail, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_OrderValue(bl, pSDEDRDetail, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEDRDetailId(bl, pSDEDRDetail, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEDRDetailName(bl, pSDEDRDetail, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEDRGroupId(bl, pSDEDRDetail, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEDRId(bl, pSDEDRDetail, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEDRItemId(bl, pSDEDRDetail, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEOPPrivId(bl, pSDEDRDetail, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDETreeViewId(bl, pSDEDRDetail, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDynaInstId(bl, pSDEDRDetail, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysCssId(bl, pSDEDRDetail, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysImageId(bl, pSDEDRDetail, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysPDTViewId(bl, pSDEDRDetail, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysUniResId(bl, pSDEDRDetail, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_TestCustomCode(bl, pSDEDRDetail, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_TestCustomMode(bl, pSDEDRDetail, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_TestPSDEActionId(bl, pSDEDRDetail, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_TestPSDELogicId(bl, pSDEDRDetail, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_TipPSLanResId(bl, pSDEDRDetail, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_TipPSLanResName(bl, pSDEDRDetail, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_TooltipInfo(bl, pSDEDRDetail, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserCat(bl, pSDEDRDetail, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag(bl, pSDEDRDetail, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag2(bl, pSDEDRDetail, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag3(bl, pSDEDRDetail, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag4(bl, pSDEDRDetail, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ValidFlag(bl, pSDEDRDetail, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ViewParams(bl, pSDEDRDetail, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, (IEntity)pSDEDRDetail, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_CapPSLanResId(boolean bl, PSDEDRDetail pSDEDRDetail, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEDRDetail.isCapPSLanResIdDirty() : !pSDEDRDetail.isCapPSLanResIdDirty()) {
            return null;
        }
        String string = pSDEDRDetail.getCapPSLanResId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_CapPSLanResId_Default((IEntity)pSDEDRDetail, bl2, bl3);
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

    protected EntityFieldError onCheckField_CapPSLanResName(boolean bl, PSDEDRDetail pSDEDRDetail, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEDRDetail.isCapPSLanResNameDirty() : !pSDEDRDetail.isCapPSLanResNameDirty()) {
            return null;
        }
        String string = pSDEDRDetail.getCapPSLanResName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_CapPSLanResName_Default((IEntity)pSDEDRDetail, bl2, bl3);
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

    protected EntityFieldError onCheckField_Caption(boolean bl, PSDEDRDetail pSDEDRDetail, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEDRDetail.isCaptionDirty() : !pSDEDRDetail.isCaptionDirty()) {
            return null;
        }
        String string = pSDEDRDetail.getCaption();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Caption_Default((IEntity)pSDEDRDetail, bl2, bl3);
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

    protected EntityFieldError onCheckField_CounterId(boolean bl, PSDEDRDetail pSDEDRDetail, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEDRDetail.isCounterIdDirty() : !pSDEDRDetail.isCounterIdDirty()) {
            return null;
        }
        String string = pSDEDRDetail.getCounterId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_CounterId_Default((IEntity)pSDEDRDetail, bl2, bl3);
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

    protected EntityFieldError onCheckField_CounterMode(boolean bl, PSDEDRDetail pSDEDRDetail, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEDRDetail.isCounterModeDirty() : !pSDEDRDetail.isCounterModeDirty()) {
            return null;
        }
        Integer n = pSDEDRDetail.getCounterMode();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_CounterMode_Default((IEntity)pSDEDRDetail, bl2, bl3);
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

    protected EntityFieldError onCheckField_Data(boolean bl, PSDEDRDetail pSDEDRDetail, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEDRDetail.isDataDirty() : !pSDEDRDetail.isDataDirty()) {
            return null;
        }
        String string = pSDEDRDetail.getData();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Data_Default((IEntity)pSDEDRDetail, bl2, bl3);
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

    protected EntityFieldError onCheckField_DetailTag(boolean bl, PSDEDRDetail pSDEDRDetail, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEDRDetail.isDetailTagDirty() : !pSDEDRDetail.isDetailTagDirty()) {
            return null;
        }
        String string = pSDEDRDetail.getDetailTag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_DetailTag_Default((IEntity)pSDEDRDetail, bl2, bl3);
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

    protected EntityFieldError onCheckField_DetailTag2(boolean bl, PSDEDRDetail pSDEDRDetail, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEDRDetail.isDetailTag2Dirty() : !pSDEDRDetail.isDetailTag2Dirty()) {
            return null;
        }
        String string = pSDEDRDetail.getDetailTag2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_DetailTag2_Default((IEntity)pSDEDRDetail, bl2, bl3);
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

    protected EntityFieldError onCheckField_DetailType(boolean bl, PSDEDRDetail pSDEDRDetail, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEDRDetail.isDetailTypeDirty() && !bl2 : !pSDEDRDetail.isDetailTypeDirty()) {
            return null;
        }
        String string = pSDEDRDetail.getDetailType();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DETAILTYPE");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_DetailType_Default((IEntity)pSDEDRDetail, bl2, bl3);
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

    protected EntityFieldError onCheckField_DynaModelFlag(boolean bl, PSDEDRDetail pSDEDRDetail, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEDRDetail.isDynaModelFlagDirty() : !pSDEDRDetail.isDynaModelFlagDirty()) {
            return null;
        }
        Integer n = pSDEDRDetail.getDynaModelFlag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_DynaModelFlag_Default((IEntity)pSDEDRDetail, bl2, bl3);
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

    protected EntityFieldError onCheckField_EnableMode(boolean bl, PSDEDRDetail pSDEDRDetail, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEDRDetail.isEnableModeDirty() : !pSDEDRDetail.isEnableModeDirty()) {
            return null;
        }
        String string = pSDEDRDetail.getEnableMode();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_EnableMode_Default((IEntity)pSDEDRDetail, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ENABLEMODE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_HeaderPSSysPFPluginId(boolean bl, PSDEDRDetail pSDEDRDetail, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEDRDetail.isHeaderPSSysPFPluginIdDirty() : !pSDEDRDetail.isHeaderPSSysPFPluginIdDirty()) {
            return null;
        }
        String string = pSDEDRDetail.getHeaderPSSysPFPluginId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_HeaderPSSysPFPluginId_Default((IEntity)pSDEDRDetail, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("HEADERPSSYSPFPLUGINID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Memo(boolean bl, PSDEDRDetail pSDEDRDetail, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEDRDetail.isMemoDirty() : !pSDEDRDetail.isMemoDirty()) {
            return null;
        }
        String string = pSDEDRDetail.getMemo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Memo_Default((IEntity)pSDEDRDetail, bl2, bl3);
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

    protected EntityFieldError onCheckField_NavViewFilter(boolean bl, PSDEDRDetail pSDEDRDetail, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEDRDetail.isNavViewFilterDirty() : !pSDEDRDetail.isNavViewFilterDirty()) {
            return null;
        }
        String string = pSDEDRDetail.getNavViewFilter();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_NavViewFilter_Default((IEntity)pSDEDRDetail, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("NAVVIEWFILTER");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_OrderValue(boolean bl, PSDEDRDetail pSDEDRDetail, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEDRDetail.isOrderValueDirty() : !pSDEDRDetail.isOrderValueDirty()) {
            return null;
        }
        Integer n = pSDEDRDetail.getOrderValue();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_OrderValue_Default((IEntity)pSDEDRDetail, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDEDRDetailId(boolean bl, PSDEDRDetail pSDEDRDetail, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEDRDetail.isPSDEDRDetailIdDirty() && !bl2 : !pSDEDRDetail.isPSDEDRDetailIdDirty()) {
            return null;
        }
        String string = pSDEDRDetail.getPSDEDRDetailId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEDRDETAILID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEDRDetailId_Default((IEntity)pSDEDRDetail, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEDRDETAILID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDEDRDetailName(boolean bl, PSDEDRDetail pSDEDRDetail, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEDRDetail.isPSDEDRDetailNameDirty() && !bl2 : !pSDEDRDetail.isPSDEDRDetailNameDirty()) {
            return null;
        }
        String string = pSDEDRDetail.getPSDEDRDetailName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEDRDETAILNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEDRDetailName_Default((IEntity)pSDEDRDetail, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEDRDETAILNAME");
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
                string3 = "PSDEDRID";
                String string4 = this.checkFieldDupRule(this.getPSDEDRDetailDEModel(), "PSDEDRDETAILNAME", string3, pSDEDRDetail, bl2, bl3);
                if (!StringHelper.isNullOrEmpty((String)string4)) {
                    EntityFieldError entityFieldError = new EntityFieldError();
                    entityFieldError.setFieldName("PSDEDRDETAILNAME");
                    entityFieldError.setErrorType(3);
                    entityFieldError.setErrorInfo(string4);
                    return entityFieldError;
                }
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDEDRGroupId(boolean bl, PSDEDRDetail pSDEDRDetail, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEDRDetail.isPSDEDRGroupIdDirty() : !pSDEDRDetail.isPSDEDRGroupIdDirty()) {
            return null;
        }
        String string = pSDEDRDetail.getPSDEDRGroupId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEDRGroupId_Default((IEntity)pSDEDRDetail, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEDRGROUPID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDEDRId(boolean bl, PSDEDRDetail pSDEDRDetail, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEDRDetail.isPSDEDRIdDirty() : !pSDEDRDetail.isPSDEDRIdDirty()) {
            return null;
        }
        String string = pSDEDRDetail.getPSDEDRId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEDRId_Default((IEntity)pSDEDRDetail, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDEDRItemId(boolean bl, PSDEDRDetail pSDEDRDetail, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEDRDetail.isPSDEDRItemIdDirty() : !pSDEDRDetail.isPSDEDRItemIdDirty()) {
            return null;
        }
        String string = pSDEDRDetail.getPSDEDRItemId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEDRItemId_Default((IEntity)pSDEDRDetail, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDEOPPrivId(boolean bl, PSDEDRDetail pSDEDRDetail, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEDRDetail.isPSDEOPPrivIdDirty() : !pSDEDRDetail.isPSDEOPPrivIdDirty()) {
            return null;
        }
        String string = pSDEDRDetail.getPSDEOPPrivId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEOPPrivId_Default((IEntity)pSDEDRDetail, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEOPPRIVID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDETreeViewId(boolean bl, PSDEDRDetail pSDEDRDetail, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEDRDetail.isPSDETreeViewIdDirty() : !pSDEDRDetail.isPSDETreeViewIdDirty()) {
            return null;
        }
        String string = pSDEDRDetail.getPSDETreeViewId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDETreeViewId_Default((IEntity)pSDEDRDetail, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDETREEVIEWID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDynaInstId(boolean bl, PSDEDRDetail pSDEDRDetail, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEDRDetail.isPSDynaInstIdDirty() : !pSDEDRDetail.isPSDynaInstIdDirty()) {
            return null;
        }
        String string = pSDEDRDetail.getPSDynaInstId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDynaInstId_Default((IEntity)pSDEDRDetail, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSSysCssId(boolean bl, PSDEDRDetail pSDEDRDetail, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEDRDetail.isPSSysCssIdDirty() : !pSDEDRDetail.isPSSysCssIdDirty()) {
            return null;
        }
        String string = pSDEDRDetail.getPSSysCssId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysCssId_Default((IEntity)pSDEDRDetail, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSSysImageId(boolean bl, PSDEDRDetail pSDEDRDetail, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEDRDetail.isPSSysImageIdDirty() : !pSDEDRDetail.isPSSysImageIdDirty()) {
            return null;
        }
        String string = pSDEDRDetail.getPSSysImageId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysImageId_Default((IEntity)pSDEDRDetail, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSSysPDTViewId(boolean bl, PSDEDRDetail pSDEDRDetail, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEDRDetail.isPSSysPDTViewIdDirty() : !pSDEDRDetail.isPSSysPDTViewIdDirty()) {
            return null;
        }
        String string = pSDEDRDetail.getPSSysPDTViewId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysPDTViewId_Default((IEntity)pSDEDRDetail, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSPDTVIEWID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSysUniResId(boolean bl, PSDEDRDetail pSDEDRDetail, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEDRDetail.isPSSysUniResIdDirty() : !pSDEDRDetail.isPSSysUniResIdDirty()) {
            return null;
        }
        String string = pSDEDRDetail.getPSSysUniResId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysUniResId_Default((IEntity)pSDEDRDetail, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSUNIRESID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_TestCustomCode(boolean bl, PSDEDRDetail pSDEDRDetail, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEDRDetail.isTestCustomCodeDirty() : !pSDEDRDetail.isTestCustomCodeDirty()) {
            return null;
        }
        String string = pSDEDRDetail.getTestCustomCode();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_TestCustomCode_Default((IEntity)pSDEDRDetail, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("TESTCUSTOMCODE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_TestCustomMode(boolean bl, PSDEDRDetail pSDEDRDetail, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEDRDetail.isTestCustomModeDirty() : !pSDEDRDetail.isTestCustomModeDirty()) {
            return null;
        }
        Integer n = pSDEDRDetail.getTestCustomMode();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_TestCustomMode_Default((IEntity)pSDEDRDetail, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("TESTCUSTOMMODE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_TestPSDEActionId(boolean bl, PSDEDRDetail pSDEDRDetail, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEDRDetail.isTestPSDEActionIdDirty() : !pSDEDRDetail.isTestPSDEActionIdDirty()) {
            return null;
        }
        String string = pSDEDRDetail.getTestPSDEActionId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_TestPSDEActionId_TestPSDEAction((IEntity)pSDEDRDetail, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("TESTPSDEACTIONID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
            string2 = this.onTestValueRule_TestPSDEActionId_Default((IEntity)pSDEDRDetail, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("TESTPSDEACTIONID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_TestPSDELogicId(boolean bl, PSDEDRDetail pSDEDRDetail, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEDRDetail.isTestPSDELogicIdDirty() : !pSDEDRDetail.isTestPSDELogicIdDirty()) {
            return null;
        }
        String string = pSDEDRDetail.getTestPSDELogicId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_TestPSDELogicId_Default((IEntity)pSDEDRDetail, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("TESTPSDELOGICID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_TipPSLanResId(boolean bl, PSDEDRDetail pSDEDRDetail, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEDRDetail.isTipPSLanResIdDirty() : !pSDEDRDetail.isTipPSLanResIdDirty()) {
            return null;
        }
        String string = pSDEDRDetail.getTipPSLanResId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_TipPSLanResId_Default((IEntity)pSDEDRDetail, bl2, bl3);
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

    protected EntityFieldError onCheckField_TipPSLanResName(boolean bl, PSDEDRDetail pSDEDRDetail, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEDRDetail.isTipPSLanResNameDirty() : !pSDEDRDetail.isTipPSLanResNameDirty()) {
            return null;
        }
        String string = pSDEDRDetail.getTipPSLanResName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_TipPSLanResName_Default((IEntity)pSDEDRDetail, bl2, bl3);
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

    protected EntityFieldError onCheckField_TooltipInfo(boolean bl, PSDEDRDetail pSDEDRDetail, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEDRDetail.isTooltipInfoDirty() : !pSDEDRDetail.isTooltipInfoDirty()) {
            return null;
        }
        String string = pSDEDRDetail.getTooltipInfo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_TooltipInfo_Default((IEntity)pSDEDRDetail, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserCat(boolean bl, PSDEDRDetail pSDEDRDetail, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEDRDetail.isUserCatDirty() : !pSDEDRDetail.isUserCatDirty()) {
            return null;
        }
        String string = pSDEDRDetail.getUserCat();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserCat_Default((IEntity)pSDEDRDetail, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag(boolean bl, PSDEDRDetail pSDEDRDetail, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEDRDetail.isUserTagDirty() : !pSDEDRDetail.isUserTagDirty()) {
            return null;
        }
        String string = pSDEDRDetail.getUserTag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag_Default((IEntity)pSDEDRDetail, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag2(boolean bl, PSDEDRDetail pSDEDRDetail, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEDRDetail.isUserTag2Dirty() : !pSDEDRDetail.isUserTag2Dirty()) {
            return null;
        }
        String string = pSDEDRDetail.getUserTag2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag2_Default((IEntity)pSDEDRDetail, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag3(boolean bl, PSDEDRDetail pSDEDRDetail, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEDRDetail.isUserTag3Dirty() : !pSDEDRDetail.isUserTag3Dirty()) {
            return null;
        }
        String string = pSDEDRDetail.getUserTag3();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag3_Default((IEntity)pSDEDRDetail, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag4(boolean bl, PSDEDRDetail pSDEDRDetail, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEDRDetail.isUserTag4Dirty() : !pSDEDRDetail.isUserTag4Dirty()) {
            return null;
        }
        String string = pSDEDRDetail.getUserTag4();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag4_Default((IEntity)pSDEDRDetail, bl2, bl3);
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

    protected EntityFieldError onCheckField_ValidFlag(boolean bl, PSDEDRDetail pSDEDRDetail, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEDRDetail.isValidFlagDirty() : !pSDEDRDetail.isValidFlagDirty()) {
            return null;
        }
        Integer n = pSDEDRDetail.getValidFlag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_ValidFlag_Default((IEntity)pSDEDRDetail, bl2, bl3);
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

    protected EntityFieldError onCheckField_ViewParams(boolean bl, PSDEDRDetail pSDEDRDetail, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEDRDetail.isViewParamsDirty() : !pSDEDRDetail.isViewParamsDirty()) {
            return null;
        }
        String string = pSDEDRDetail.getViewParams();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_ViewParams_Default((IEntity)pSDEDRDetail, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("VIEWPARAMS");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected void onSyncEntity(PSDEDRDetail pSDEDRDetail, boolean bl) throws Exception {
        super.onSyncEntity((IEntity)pSDEDRDetail, bl);
    }

    protected void onSyncIndexEntities(PSDEDRDetail pSDEDRDetail, boolean bl) throws Exception {
        super.onSyncIndexEntities((IEntity)pSDEDRDetail, bl);
    }

    public Object getDataContextValue(PSDEDRDetail pSDEDRDetail, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null) {
            // empty if block
        }
        if ((object = super.getDataContextValue((IEntity)pSDEDRDetail, string, iDataContextParam)) != null) {
            return object;
        }
        PSDEDataRelation pSDEDataRelation = pSDEDRDetail.getPSDEDR();
        if (pSDEDataRelation != null && pSDEDataRelation.contains(string)) {
            return pSDEDataRelation.get(string);
        }
        return null;
    }

    protected void onExportMajorModel(PSDEDRDetail pSDEDRDetail, ArrayList<JSONObject> arrayList, int n) throws Exception {
        this.onExportMajorModel_CapPSLanRes(pSDEDRDetail, arrayList, n);
        super.onExportMajorModel((IEntity)pSDEDRDetail, arrayList, n);
    }

    protected void onExportMajorModel_CapPSLanRes(PSDEDRDetail pSDEDRDetail, ArrayList<JSONObject> arrayList, int n) throws Exception {
        if (pSDEDRDetail.getCapPSLanRes() != null) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSLanguageResService", (SessionFactory)this.getSessionFactory());
            iService.exportModel((IEntity)pSDEDRDetail.getCapPSLanRes(), arrayList, n);
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
        if (StringHelper.compare((String)string, (String)"COUNTERID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CounterId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"COUNTERMODE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CounterMode_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATEDATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateDate_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATEMAN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateMan_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DATA", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Data_Default(iEntity, bl, bl2);
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
        if (StringHelper.compare((String)string, (String)"DYNAMODELFLAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DynaModelFlag_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ENABLEMODE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_EnableMode_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"GROUPORDERVALUE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_GroupOrderValue_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"HEADERPSSYSPFPLUGINID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_HeaderPSSysPFPluginId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"HEADERPSSYSPFPLUGINNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_HeaderPSSysPFPluginName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MEMO", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Memo_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"NAVVIEWFILTER", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_NavViewFilter_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ORDERVALUE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_OrderValue_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEDRDETAILID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEDRDetailId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEDRDETAILNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEDRDetailName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEDRGROUPID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEDRGroupId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEDRGROUPNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEDRGroupName_Default(iEntity, bl, bl2);
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
        if (StringHelper.compare((String)string, (String)"PSDEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEOPPRIVID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEOPPrivId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEOPPRIVNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEOPPrivName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDETREEVIEWID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDETreeViewId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDETREEVIEWNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDETreeViewName_Default(iEntity, bl, bl2);
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
        if (StringHelper.compare((String)string, (String)"PSSYSPDTVIEWID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysPDTViewId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSPDTVIEWNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysPDTViewName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSUNIRESID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysUniResId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSUNIRESNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysUniResName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"TESTCUSTOMCODE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_TestCustomCode_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"TESTCUSTOMMODE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_TestCustomMode_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"TESTPSDEACTIONID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)"TESTPSDEACTION", (boolean)true) == 0) {
            return this.onTestValueRule_TestPSDEActionId_TestPSDEAction(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"TESTPSDEACTIONID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_TestPSDEActionId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"TESTPSDEACTIONNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_TestPSDEActionName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"TESTPSDELOGICID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_TestPSDELogicId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"TESTPSDELOGICNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_TestPSDELogicName_Default(iEntity, bl, bl2);
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
        if (StringHelper.compare((String)string, (String)"VIEWPARAMS", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ViewParams_Default(iEntity, bl, bl2);
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
            if (this.checkFieldStringLengthRule("CAPTION", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
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

    protected String onTestValueRule_Data_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("DATA", iEntity, bl2, null, false, 0x100000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_DetailTag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("DETAILTAG", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_DetailTag2_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("DETAILTAG2", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_DetailType_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("DETAILTYPE", iEntity, bl2, null, false, 30, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_DynaModelFlag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_EnableMode_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("ENABLEMODE", iEntity, bl2, null, false, 20, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[20]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[20]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_GroupOrderValue_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_HeaderPSSysPFPluginId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("HEADERPSSYSPFPLUGINID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_HeaderPSSysPFPluginName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("HEADERPSSYSPFPLUGINNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
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

    protected String onTestValueRule_NavViewFilter_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("NAVVIEWFILTER", iEntity, bl2, null, false, 40, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[40]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[40]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_OrderValue_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_PSDEDRDetailId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEDRDETAILID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDEDRDetailName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEDRDETAILNAME", iEntity, bl2, null, false, 20, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[20]", false) && this.checkFieldRegExRule("PSDEDRDETAILNAME", iEntity, bl2, "[a-zA-Z_$][a-zA-Z0-9_$]*", "\u5185\u5bb9\u53ea\u80fd\u7531\u5b57\u6bcd\u3001\u6570\u5b57\u3001\u4e0b\u5212\u7ebf\u7ec4\u6210\uff0c\u4e14\u5f00\u59cb\u5fc5\u987b\u4e3a\u5b57\u6bcd", false)) {
                return null;
            }
            return "(\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[20] \u5e76\u4e14 \u5185\u5bb9\u53ea\u80fd\u7531\u5b57\u6bcd\u3001\u6570\u5b57\u3001\u4e0b\u5212\u7ebf\u7ec4\u6210\uff0c\u4e14\u5f00\u59cb\u5fc5\u987b\u4e3a\u5b57\u6bcd)";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDEDRGroupId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEDRGROUPID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDEDRGroupName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEDRGROUPNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
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

    protected String onTestValueRule_PSDEOPPrivId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEOPPRIVID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDEOPPrivName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEOPPRIVNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDETreeViewId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDETREEVIEWID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDETreeViewName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDETREEVIEWNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
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

    protected String onTestValueRule_PSSysPDTViewId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSPDTVIEWID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysPDTViewName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSPDTVIEWNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysUniResId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSUNIRESID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysUniResName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSUNIRESNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_TestCustomCode_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("TESTCUSTOMCODE", iEntity, bl2, null, false, 0x100000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_TestCustomMode_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_TestPSDEActionId_TestPSDEAction(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldDataSetRule("TESTPSDEACTIONID", "PSDEACTION", "CurDE", iEntity, bl2, null, null, "\u503c\u5fc5\u987b\u5728\u6570\u636e\u96c6\u5408\u4e2d", true)) {
                return null;
            }
            return "\u5224\u65ad\u542f\u7528\u5b9e\u4f53\u884c\u4e3a\u503c\u5fc5\u987b\u5728\u6570\u636e\u96c6\u5408\u4e2d";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_TestPSDEActionId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("TESTPSDEACTIONID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_TestPSDEActionName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("TESTPSDEACTIONNAME", iEntity, bl2, null, false, 50, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_TestPSDELogicId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("TESTPSDELOGICID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_TestPSDELogicName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("TESTPSDELOGICNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
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
            if (this.checkFieldStringLengthRule("TOOLTIPINFO", iEntity, bl2, null, false, 2000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[2000]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[2000]";
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

    protected String onTestValueRule_ViewParams_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("VIEWPARAMS", iEntity, bl2, null, false, 4000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[4000]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[4000]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    @Override
    protected boolean isPrepareLastForUpdate() {
        return true;
    }

    protected boolean onMergeChild(String string, String string2, PSDEDRDetail pSDEDRDetail) throws Exception {
        boolean bl = false;
        if (super.onMergeChild(string, string2, (IEntity)pSDEDRDetail)) {
            bl = true;
        }
        return bl;
    }

    protected void onUpdateParent(PSDEDRDetail pSDEDRDetail) throws Exception {
        super.onUpdateParent((IEntity)pSDEDRDetail);
    }

    @Override
    protected void exportCurXmlModel(PSDEDRDetail pSDEDRDetail, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSDEDRDETAIL");
        if (!bl) {
            pSDEDRDetail.setCreateDate(null);
            pSDEDRDetail.setCreateMan(null);
            pSDEDRDetail.setPSDEDRDetailId(null);
            pSDEDRDetail.setUpdateDate(null);
            pSDEDRDetail.setUpdateMan(null);
            pSDEDRDetail.setPSDEDRId(null);
            pSDEDRDetail.setPSDEDRName(null);
            pSDEDRDetail.setPSDEId(null);
            super.exportCurXmlModel(pSDEDRDetail, xmlNode, bl);
        }
    }

    @Override
    protected void onExportRelatedXmlModel(PSDEDRDetail pSDEDRDetail, XmlNode xmlNode) throws Exception {
        super.onExportRelatedXmlModel(pSDEDRDetail, xmlNode);
    }

    @Override
    protected void onImportRelatedXmlModel(PSDEDRDetail pSDEDRDetail, XmlNode xmlNode) throws Exception {
        super.onImportRelatedXmlModel(pSDEDRDetail, xmlNode);
    }

    @Override
    public ObjectNode fillModelV2(ObjectNode objectNode, PSDEDRDetail pSDEDRDetail, String string) throws Exception {
        objectNode = super.fillModelV2(objectNode, pSDEDRDetail, string);
        return objectNode;
    }

    @Override
    public String getModelV2ResScope(IEntity iEntity) throws Exception {
        String string = null;
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSDEDRID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return StringHelper.format((String)"PSDEDATARELATION#%1$s", (Object)string);
        }
        return super.getModelV2ResScope(iEntity);
    }

    @Override
    public String getModelV2ResScopeDER(IEntity iEntity) throws Exception {
        String string = null;
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSDEDRID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return "DER1N_PSDEDRDETAIL_PSDEDATARELATION_PSDEDRID";
        }
        return super.getModelV2ResScopeDER(iEntity);
    }

    @Override
    public String getModelV2ResScopeText(IEntity iEntity) throws Exception {
        String string = null;
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSDEDRID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return DataObject.getStringValue((IDataObject)iEntity, (String)"PSDEDRNAME", null);
        }
        return super.getModelV2ResScopeText(iEntity);
    }

    @Override
    public boolean setModelV2ResScope(IEntity iEntity, String string, String string2) throws Exception {
        if (StringHelper.compare((String)string, (String)"PSDEDATARELATION", (boolean)true) == 0) {
            iEntity.set("PSDEDRID", (Object)string2);
            return true;
        }
        return super.setModelV2ResScope(iEntity, string, string2);
    }

    @Override
    public String[] getModelV2ResScopeFields() throws Exception {
        return new String[]{"PSDEDRID"};
    }

    @Override
    public String getModelV2Tag(PSDEDRDetail pSDEDRDetail) {
        if (!StringHelper.isNullOrEmpty((String)pSDEDRDetail.getPSDEDRDetailName())) {
            return pSDEDRDetail.getPSDEDRDetailName();
        }
        return super.getModelV2Tag(pSDEDRDetail);
    }

    @Override
    public boolean setModelV2Tag(PSDEDRDetail pSDEDRDetail, String string) {
        pSDEDRDetail.setPSDEDRDetailName(string);
        return true;
    }

    @Override
    public Map<String, String> getListDRDataFolderFields(Map<String, String> map, PSMOSFile pSMOSFile, IPSMOSFileFilter iPSMOSFileFilter) throws Exception {
        if (map == null) {
            map = new HashMap<String, String>();
        }
        map.put("PSDEDRDETAILNAME", "");
        map.put("PSDEDRID", "");
        return super.getListDRDataFolderFields(map, pSMOSFile, iPSMOSFileFilter);
    }

    @Override
    public boolean getModelV2Entity(PSDEDRDetail pSDEDRDetail, String string) throws Exception {
        SimpleEntity simpleEntity = new SimpleEntity();
        pSDEDRDetail.copyTo((IDataObject)simpleEntity, false);
        simpleEntity.copyTo((IDataObject)pSDEDRDetail, true);
        pSDEDRDetail.set("PSDEDRDETAILNAME", string);
        if (this.select(pSDEDRDetail, true)) {
            return true;
        }
        simpleEntity.copyTo((IDataObject)pSDEDRDetail, true);
        return super.getModelV2Entity(pSDEDRDetail, string);
    }

    @Override
    protected boolean testCompileCurModelV2(PSDEDRDetail pSDEDRDetail, ObjectNode objectNode, String string, String string2, int n) throws Exception {
        if (n == 1) {
            return true;
        }
        return super.testCompileCurModelV2(pSDEDRDetail, objectNode, string, string2, n);
    }
}

