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
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.xml.XmlNode;
import net.ibizsys.pscore.srv.PSCoreSysServiceBase;
import net.ibizsys.pscore.srv.config.entity.PSSysPFPlugin;
import net.ibizsys.pscore.srv.config.entity.PSSysPFPluginBase;
import net.ibizsys.pscore.srv.config.entity.PSSysResource;
import net.ibizsys.pscore.srv.config.entity.PSSysResourceBase;
import net.ibizsys.pscore.srv.core.IPSDataEntityModel;
import net.ibizsys.pscore.srv.dedesign.dao.PSDEUAGroupDetailDAO;
import net.ibizsys.pscore.srv.dedesign.demodel.PSDEUAGroupDetailDEModel;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEUAGroup;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEUAGroupBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEUAGroupDetail;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEUIAction;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEUIActionBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysCss;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysCssBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysImage;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysImageBase;
import net.ibizsys.pscore.srv.sysdevstudio.entity.PSMOSFile;
import net.ibizsys.pscore.srv.util.IPSMOSFileFilter;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDEUAGroupDetailServiceBase
extends PSCoreSysServiceBase<PSDEUAGroupDetail> {
    private static final Log log = LogFactory.getLog(PSDEUAGroupDetailServiceBase.class);
    public static final String DATASET_DEFAULT = "DEFAULT";
    private PSDEUAGroupDetailDEModel pSDEUAGroupDetailDEModel;
    private PSDEUAGroupDetailDAO pSDEUAGroupDetailDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.dedesign.service.PSDEUAGroupDetailService";
    }

    public PSDEUAGroupDetailDEModel getPSDEUAGroupDetailDEModel() {
        if (this.pSDEUAGroupDetailDEModel == null) {
            try {
                this.pSDEUAGroupDetailDEModel = (PSDEUAGroupDetailDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.dedesign.demodel.PSDEUAGroupDetailDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDEUAGroupDetailDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSDEUAGroupDetailDEModel();
    }

    public PSDEUAGroupDetailDAO getPSDEUAGroupDetailDAO() {
        if (this.pSDEUAGroupDetailDAO == null) {
            try {
                this.pSDEUAGroupDetailDAO = (PSDEUAGroupDetailDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.dedesign.dao.PSDEUAGroupDetailDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDEUAGroupDetailDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSDEUAGroupDetailDAO();
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

    protected void onFillParentInfo(PSDEUAGroupDetail pSDEUAGroupDetail, String string, String string2, String string3) throws Exception {
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEUAGRPDETAIL_PSDEUAGROUP_PSDEUAGROUPID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEUAGroupService", (SessionFactory)this.getSessionFactory());
            PSDEUAGroup pSDEUAGroup = (PSDEUAGroup)iService.getDEModel().createEntity();
            pSDEUAGroup.set("PSDEUAGROUPID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDEUAGroup);
            } else {
                iService.get(pSDEUAGroup);
            }
            this.onFillParentInfo_PSDEUAGroup(pSDEUAGroupDetail, pSDEUAGroup);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEUAGRPDETAIL_PSDEUAGROUP_REFPSDEUAGROUPID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEUAGroupService", (SessionFactory)this.getSessionFactory());
            PSDEUAGroup pSDEUAGroup = (PSDEUAGroup)iService.getDEModel().createEntity();
            pSDEUAGroup.set("PSDEUAGROUPID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDEUAGroup);
            } else {
                iService.get(pSDEUAGroup);
            }
            this.onFillParentInfo_RefPSDEUAGroup(pSDEUAGroupDetail, pSDEUAGroup);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEUAGRPDETAIL_PSDEUIACTION_PSDEUIACTIONID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEUIActionService", (SessionFactory)this.getSessionFactory());
            PSDEUIAction pSDEUIAction = (PSDEUIAction)iService.getDEModel().createEntity();
            pSDEUIAction.set("PSDEUIACTIONID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDEUIAction);
            } else {
                iService.get(pSDEUIAction);
            }
            this.onFillParentInfo_PSDEUAAction(pSDEUAGroupDetail, pSDEUIAction);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEUAGRPDETAIL_PSSYSCSS_AFTERPSSYSCSSID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysCssService", (SessionFactory)this.getSessionFactory());
            PSSysCss pSSysCss = (PSSysCss)iService.getDEModel().createEntity();
            pSSysCss.set("PSSYSCSSID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSSysCss);
            } else {
                iService.get(pSSysCss);
            }
            this.onFillParentInfo_AfterPSSysCss(pSDEUAGroupDetail, pSSysCss);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEUAGRPDETAIL_PSSYSCSS_BEFOREPSSYSCSSID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysCssService", (SessionFactory)this.getSessionFactory());
            PSSysCss pSSysCss = (PSSysCss)iService.getDEModel().createEntity();
            pSSysCss.set("PSSYSCSSID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSSysCss);
            } else {
                iService.get(pSSysCss);
            }
            this.onFillParentInfo_BeforePSSysCss(pSDEUAGroupDetail, pSSysCss);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEUAGRPDETAIL_PSSYSCSS_PSSYSCSSID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysCssService", (SessionFactory)this.getSessionFactory());
            PSSysCss pSSysCss = (PSSysCss)iService.getDEModel().createEntity();
            pSSysCss.set("PSSYSCSSID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSSysCss);
            } else {
                iService.get(pSSysCss);
            }
            this.onFillParentInfo_PSSysCss(pSDEUAGroupDetail, pSSysCss);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEUAGRPDETAIL_PSSYSIMAGE_PSSYSIMAGEID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysImageService", (SessionFactory)this.getSessionFactory());
            PSSysImage pSSysImage = (PSSysImage)iService.getDEModel().createEntity();
            pSSysImage.set("PSSYSIMAGEID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSSysImage);
            } else {
                iService.get(pSSysImage);
            }
            this.onFillParentInfo_PSSysImage(pSDEUAGroupDetail, pSSysImage);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEUAGRPDETAIL_PSSYSPFPLUGIN_PSSYSPFPLUGINID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.config.service.PSSysPFPluginService", (SessionFactory)this.getSessionFactory());
            PSSysPFPlugin pSSysPFPlugin = (PSSysPFPlugin)iService.getDEModel().createEntity();
            pSSysPFPlugin.set("PSSYSPFPLUGINID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSSysPFPlugin);
            } else {
                iService.get(pSSysPFPlugin);
            }
            this.onFillParentInfo_PSSysPFPlugin(pSDEUAGroupDetail, pSSysPFPlugin);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEUAGRPDETAIL_PSSYSRESOURCE_AFTERPSSYSRESOURCEID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.config.service.PSSysResourceService", (SessionFactory)this.getSessionFactory());
            PSSysResource pSSysResource = (PSSysResource)iService.getDEModel().createEntity();
            pSSysResource.set("PSSYSRESOURCEID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSSysResource);
            } else {
                iService.get(pSSysResource);
            }
            this.onFillParentInfo_AfterPSSysResource(pSDEUAGroupDetail, pSSysResource);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEUAGRPDETAIL_PSSYSRESOURCE_BEFOREPSSYSRESOURCEID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.config.service.PSSysResourceService", (SessionFactory)this.getSessionFactory());
            PSSysResource pSSysResource = (PSSysResource)iService.getDEModel().createEntity();
            pSSysResource.set("PSSYSRESOURCEID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSSysResource);
            } else {
                iService.get(pSSysResource);
            }
            this.onFillParentInfo_BeforePSSysResource(pSDEUAGroupDetail, pSSysResource);
            return;
        }
        super.onFillParentInfo(pSDEUAGroupDetail, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        if (StringHelper.compare((String)string, (String)"DER1N_PSDEUAGRPDETAIL_PSDEUAGROUP_PSDEUAGROUPID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEUAGroupService", (SessionFactory)this.getSessionFactory());
            PSDEUAGroup pSDEUAGroup = (PSDEUAGroup)iService.getDEModel().createEntity();
            pSDEUAGroup.set("PSDEUAGROUPID", string2);
            return this.onSyncDER1NData_PSDEUAGroup(pSDEUAGroup, string3);
        }
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillParentInfo_PSDEUAGroup(PSDEUAGroupDetail pSDEUAGroupDetail, PSDEUAGroup pSDEUAGroup) throws Exception {
        pSDEUAGroupDetail.setPSDEId(pSDEUAGroup.getPSDEId());
        pSDEUAGroupDetail.setPSDEUAGroupId(pSDEUAGroup.getPSDEUAGroupId());
        pSDEUAGroupDetail.setPSDEUAGroupName(pSDEUAGroup.getPSDEUAGroupName());
    }

    protected String onSyncDER1NData_PSDEUAGroup(PSDEUAGroup pSDEUAGroup, String string) throws Exception {
        if (StringHelper.isNullOrEmpty((String)string)) {
            this.removeByPSDEUAGroup(pSDEUAGroup);
        } else {
            HashMap<String, String> hashMap = new HashMap<String, String>();
            String[] stringArray = StringHelper.splitEx((String)string);
            if (stringArray != null) {
                for (int i = 0; i < stringArray.length; ++i) {
                    if (StringHelper.isNullOrEmpty((String)stringArray[i])) continue;
                    hashMap.put(stringArray[i], "");
                }
            }
            ArrayList<PSDEUAGroupDetail> arrayList = this.selectByPSDEUAGroup(pSDEUAGroup);
            for (PSDEUAGroupDetail pSDEUAGroupDetail : arrayList) {
                if (hashMap.containsKey(DataObject.getStringValue((IDataObject)pSDEUAGroupDetail, (String)"PSDEUAGRPDETAILID", (String)""))) continue;
                this.remove(pSDEUAGroupDetail);
            }
        }
        return null;
    }

    protected void onFillParentInfo_RefPSDEUAGroup(PSDEUAGroupDetail pSDEUAGroupDetail, PSDEUAGroup pSDEUAGroup) throws Exception {
        pSDEUAGroupDetail.setRefPSDEUAGroupId(pSDEUAGroup.getPSDEUAGroupId());
        pSDEUAGroupDetail.setRefPSDEUAGroupName(pSDEUAGroup.getPSDEUAGroupName());
    }

    protected void onFillParentInfo_PSDEUAAction(PSDEUAGroupDetail pSDEUAGroupDetail, PSDEUIAction pSDEUIAction) throws Exception {
        pSDEUAGroupDetail.setPSDEUIActionId(pSDEUIAction.getPSDEUIActionId());
        pSDEUAGroupDetail.setPSDEUIActionName(pSDEUIAction.getPSDEUIActionName());
        pSDEUAGroupDetail.setUACaption(pSDEUIAction.getCaption());
    }

    protected void onFillParentInfo_AfterPSSysCss(PSDEUAGroupDetail pSDEUAGroupDetail, PSSysCss pSSysCss) throws Exception {
        pSDEUAGroupDetail.setAfterPSSysCssId(pSSysCss.getPSSysCssId());
        pSDEUAGroupDetail.setAfterPSSysCssName(pSSysCss.getPSSysCssName());
    }

    protected void onFillParentInfo_BeforePSSysCss(PSDEUAGroupDetail pSDEUAGroupDetail, PSSysCss pSSysCss) throws Exception {
        pSDEUAGroupDetail.setBeforePSSysCssId(pSSysCss.getPSSysCssId());
        pSDEUAGroupDetail.setBeforePSSysCssName(pSSysCss.getPSSysCssName());
    }

    protected void onFillParentInfo_PSSysCss(PSDEUAGroupDetail pSDEUAGroupDetail, PSSysCss pSSysCss) throws Exception {
        pSDEUAGroupDetail.setPSSysCssId(pSSysCss.getPSSysCssId());
        pSDEUAGroupDetail.setPSSysCssName(pSSysCss.getPSSysCssName());
    }

    protected void onFillParentInfo_PSSysImage(PSDEUAGroupDetail pSDEUAGroupDetail, PSSysImage pSSysImage) throws Exception {
        pSDEUAGroupDetail.setPSSysImageId(pSSysImage.getPSSysImageId());
        pSDEUAGroupDetail.setPSSysImageName(pSSysImage.getPSSysImageName());
    }

    protected void onFillParentInfo_PSSysPFPlugin(PSDEUAGroupDetail pSDEUAGroupDetail, PSSysPFPlugin pSSysPFPlugin) throws Exception {
        pSDEUAGroupDetail.setPSSysPFPluginId(pSSysPFPlugin.getPSSysPFPluginId());
        pSDEUAGroupDetail.setPSSysPFPluginName(pSSysPFPlugin.getPSSysPFPluginName());
    }

    protected void onFillParentInfo_AfterPSSysResource(PSDEUAGroupDetail pSDEUAGroupDetail, PSSysResource pSSysResource) throws Exception {
        pSDEUAGroupDetail.setAfterPSSysResourceId(pSSysResource.getPSSysResourceId());
        pSDEUAGroupDetail.setAfterPSSysResourceName(pSSysResource.getPSSysResourceName());
    }

    protected void onFillParentInfo_BeforePSSysResource(PSDEUAGroupDetail pSDEUAGroupDetail, PSSysResource pSSysResource) throws Exception {
        pSDEUAGroupDetail.setBeforePSSysResourceId(pSSysResource.getPSSysResourceId());
        pSDEUAGroupDetail.setBeforePSSysResourceName(pSSysResource.getPSSysResourceName());
    }

    protected void onFillEntityFullInfo(PSDEUAGroupDetail pSDEUAGroupDetail, boolean bl) throws Exception {
        if (bl) {
            if (pSDEUAGroupDetail.getDetailType() == null) {
                pSDEUAGroupDetail.setDetailType((String)this.getDefaultValue(this.getWebContext(), "", "DEUIACTION", 25));
            }
            if (pSDEUAGroupDetail.getValidFlag() == null) {
                pSDEUAGroupDetail.setValidFlag((Integer)this.getDefaultValue(this.getWebContext(), "", "1", 9));
            }
        }
        super.onFillEntityFullInfo(pSDEUAGroupDetail, bl);
        this.onFillEntityFullInfo_PSDEUAGroup(pSDEUAGroupDetail, bl);
        this.onFillEntityFullInfo_RefPSDEUAGroup(pSDEUAGroupDetail, bl);
        this.onFillEntityFullInfo_PSDEUAAction(pSDEUAGroupDetail, bl);
        this.onFillEntityFullInfo_AfterPSSysCss(pSDEUAGroupDetail, bl);
        this.onFillEntityFullInfo_BeforePSSysCss(pSDEUAGroupDetail, bl);
        this.onFillEntityFullInfo_PSSysCss(pSDEUAGroupDetail, bl);
        this.onFillEntityFullInfo_PSSysImage(pSDEUAGroupDetail, bl);
        this.onFillEntityFullInfo_PSSysPFPlugin(pSDEUAGroupDetail, bl);
        this.onFillEntityFullInfo_AfterPSSysResource(pSDEUAGroupDetail, bl);
        this.onFillEntityFullInfo_BeforePSSysResource(pSDEUAGroupDetail, bl);
    }

    protected void onFillEntityFullInfo_PSDEUAGroup(PSDEUAGroupDetail pSDEUAGroupDetail, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_RefPSDEUAGroup(PSDEUAGroupDetail pSDEUAGroupDetail, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSDEUAAction(PSDEUAGroupDetail pSDEUAGroupDetail, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_AfterPSSysCss(PSDEUAGroupDetail pSDEUAGroupDetail, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_BeforePSSysCss(PSDEUAGroupDetail pSDEUAGroupDetail, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSSysCss(PSDEUAGroupDetail pSDEUAGroupDetail, boolean bl) throws Exception {
        if (pSDEUAGroupDetail.isPSSysCssIdDirty()) {
            if (pSDEUAGroupDetail.getPSSysCssId() != null) {
                if (pSDEUAGroupDetail.getPSSysCssId() == null || pSDEUAGroupDetail.getPSSysCssName() == null) {
                    PSSysCss pSSysCss = pSDEUAGroupDetail.getPSSysCss();
                    pSDEUAGroupDetail.setPSSysCssName(pSSysCss.getPSSysCssName());
                }
            } else {
                pSDEUAGroupDetail.setPSSysCssName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_PSSysImage(PSDEUAGroupDetail pSDEUAGroupDetail, boolean bl) throws Exception {
        if (pSDEUAGroupDetail.isPSSysImageIdDirty()) {
            if (pSDEUAGroupDetail.getPSSysImageId() != null) {
                if (pSDEUAGroupDetail.getPSSysImageId() == null || pSDEUAGroupDetail.getPSSysImageName() == null) {
                    PSSysImage pSSysImage = pSDEUAGroupDetail.getPSSysImage();
                    pSDEUAGroupDetail.setPSSysImageName(pSSysImage.getPSSysImageName());
                }
            } else {
                pSDEUAGroupDetail.setPSSysImageName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_PSSysPFPlugin(PSDEUAGroupDetail pSDEUAGroupDetail, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_AfterPSSysResource(PSDEUAGroupDetail pSDEUAGroupDetail, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_BeforePSSysResource(PSDEUAGroupDetail pSDEUAGroupDetail, boolean bl) throws Exception {
    }

    protected void onWriteBackParent(PSDEUAGroupDetail pSDEUAGroupDetail, boolean bl) throws Exception {
        super.onWriteBackParent(pSDEUAGroupDetail, bl);
    }

    public ArrayList<PSDEUAGroupDetail> selectByPSDEUAGroup(PSDEUAGroupBase pSDEUAGroupBase) throws Exception {
        return this.selectByPSDEUAGroup(pSDEUAGroupBase, "", -1);
    }

    public ArrayList<PSDEUAGroupDetail> selectByPSDEUAGroup(PSDEUAGroupBase pSDEUAGroupBase, String string) throws Exception {
        return this.selectByPSDEUAGroup(pSDEUAGroupBase, string, -1);
    }

    public ArrayList<PSDEUAGroupDetail> selectByPSDEUAGroup(PSDEUAGroupBase pSDEUAGroupBase, String string, int n) throws Exception {
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

    public ArrayList<PSDEUAGroupDetail> selectTempByPSDEUAGroup(PSDEUAGroupBase pSDEUAGroupBase) throws Exception {
        return this.selectTempByPSDEUAGroup(pSDEUAGroupBase, "");
    }

    public ArrayList<PSDEUAGroupDetail> selectTempByPSDEUAGroup(PSDEUAGroupBase pSDEUAGroupBase, String string) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDEUAGROUPID", (Object)pSDEUAGroupBase.getPSDEUAGroupId());
        selectCond.setOrderInfo(string);
        this.onFillSelectTempByPSDEUAGroupCond(selectCond);
        return this.selectTemp((ISelectCond)selectCond);
    }

    protected void onFillSelectTempByPSDEUAGroupCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDEUAGroupDetail> selectByRefPSDEUAGroup(PSDEUAGroupBase pSDEUAGroupBase) throws Exception {
        return this.selectByRefPSDEUAGroup(pSDEUAGroupBase, "", -1);
    }

    public ArrayList<PSDEUAGroupDetail> selectByRefPSDEUAGroup(PSDEUAGroupBase pSDEUAGroupBase, String string) throws Exception {
        return this.selectByRefPSDEUAGroup(pSDEUAGroupBase, string, -1);
    }

    public ArrayList<PSDEUAGroupDetail> selectByRefPSDEUAGroup(PSDEUAGroupBase pSDEUAGroupBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("REFPSDEUAGROUPID", (Object)pSDEUAGroupBase.getPSDEUAGroupId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByRefPSDEUAGroupCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByRefPSDEUAGroupCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDEUAGroupDetail> selectByPSDEUAAction(PSDEUIActionBase pSDEUIActionBase) throws Exception {
        return this.selectByPSDEUAAction(pSDEUIActionBase, "", -1);
    }

    public ArrayList<PSDEUAGroupDetail> selectByPSDEUAAction(PSDEUIActionBase pSDEUIActionBase, String string) throws Exception {
        return this.selectByPSDEUAAction(pSDEUIActionBase, string, -1);
    }

    public ArrayList<PSDEUAGroupDetail> selectByPSDEUAAction(PSDEUIActionBase pSDEUIActionBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDEUIACTIONID", (Object)pSDEUIActionBase.getPSDEUIActionId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSDEUAActionCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSDEUAActionCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDEUAGroupDetail> selectByAfterPSSysCss(PSSysCssBase pSSysCssBase) throws Exception {
        return this.selectByAfterPSSysCss(pSSysCssBase, "", -1);
    }

    public ArrayList<PSDEUAGroupDetail> selectByAfterPSSysCss(PSSysCssBase pSSysCssBase, String string) throws Exception {
        return this.selectByAfterPSSysCss(pSSysCssBase, string, -1);
    }

    public ArrayList<PSDEUAGroupDetail> selectByAfterPSSysCss(PSSysCssBase pSSysCssBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("AFTERPSSYSCSSID", (Object)pSSysCssBase.getPSSysCssId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByAfterPSSysCssCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByAfterPSSysCssCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDEUAGroupDetail> selectByBeforePSSysCss(PSSysCssBase pSSysCssBase) throws Exception {
        return this.selectByBeforePSSysCss(pSSysCssBase, "", -1);
    }

    public ArrayList<PSDEUAGroupDetail> selectByBeforePSSysCss(PSSysCssBase pSSysCssBase, String string) throws Exception {
        return this.selectByBeforePSSysCss(pSSysCssBase, string, -1);
    }

    public ArrayList<PSDEUAGroupDetail> selectByBeforePSSysCss(PSSysCssBase pSSysCssBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("BEFOREPSSYSCSSID", (Object)pSSysCssBase.getPSSysCssId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByBeforePSSysCssCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByBeforePSSysCssCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDEUAGroupDetail> selectByPSSysCss(PSSysCssBase pSSysCssBase) throws Exception {
        return this.selectByPSSysCss(pSSysCssBase, "", -1);
    }

    public ArrayList<PSDEUAGroupDetail> selectByPSSysCss(PSSysCssBase pSSysCssBase, String string) throws Exception {
        return this.selectByPSSysCss(pSSysCssBase, string, -1);
    }

    public ArrayList<PSDEUAGroupDetail> selectByPSSysCss(PSSysCssBase pSSysCssBase, String string, int n) throws Exception {
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

    public ArrayList<PSDEUAGroupDetail> selectByPSSysImage(PSSysImageBase pSSysImageBase) throws Exception {
        return this.selectByPSSysImage(pSSysImageBase, "", -1);
    }

    public ArrayList<PSDEUAGroupDetail> selectByPSSysImage(PSSysImageBase pSSysImageBase, String string) throws Exception {
        return this.selectByPSSysImage(pSSysImageBase, string, -1);
    }

    public ArrayList<PSDEUAGroupDetail> selectByPSSysImage(PSSysImageBase pSSysImageBase, String string, int n) throws Exception {
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

    public ArrayList<PSDEUAGroupDetail> selectByPSSysPFPlugin(PSSysPFPluginBase pSSysPFPluginBase) throws Exception {
        return this.selectByPSSysPFPlugin(pSSysPFPluginBase, "", -1);
    }

    public ArrayList<PSDEUAGroupDetail> selectByPSSysPFPlugin(PSSysPFPluginBase pSSysPFPluginBase, String string) throws Exception {
        return this.selectByPSSysPFPlugin(pSSysPFPluginBase, string, -1);
    }

    public ArrayList<PSDEUAGroupDetail> selectByPSSysPFPlugin(PSSysPFPluginBase pSSysPFPluginBase, String string, int n) throws Exception {
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

    public ArrayList<PSDEUAGroupDetail> selectByAfterPSSysResource(PSSysResourceBase pSSysResourceBase) throws Exception {
        return this.selectByAfterPSSysResource(pSSysResourceBase, "", -1);
    }

    public ArrayList<PSDEUAGroupDetail> selectByAfterPSSysResource(PSSysResourceBase pSSysResourceBase, String string) throws Exception {
        return this.selectByAfterPSSysResource(pSSysResourceBase, string, -1);
    }

    public ArrayList<PSDEUAGroupDetail> selectByAfterPSSysResource(PSSysResourceBase pSSysResourceBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("AFTERPSSYSRESOURCEID", (Object)pSSysResourceBase.getPSSysResourceId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByAfterPSSysResourceCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByAfterPSSysResourceCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDEUAGroupDetail> selectByBeforePSSysResource(PSSysResourceBase pSSysResourceBase) throws Exception {
        return this.selectByBeforePSSysResource(pSSysResourceBase, "", -1);
    }

    public ArrayList<PSDEUAGroupDetail> selectByBeforePSSysResource(PSSysResourceBase pSSysResourceBase, String string) throws Exception {
        return this.selectByBeforePSSysResource(pSSysResourceBase, string, -1);
    }

    public ArrayList<PSDEUAGroupDetail> selectByBeforePSSysResource(PSSysResourceBase pSSysResourceBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("BEFOREPSSYSRESOURCEID", (Object)pSSysResourceBase.getPSSysResourceId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByBeforePSSysResourceCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByBeforePSSysResourceCond(SelectCond selectCond) throws Exception {
    }

    public void testRemoveByPSDEUAGroup(PSDEUAGroup pSDEUAGroup) throws Exception {
    }

    public void resetPSDEUAGroup(PSDEUAGroup pSDEUAGroup) throws Exception {
        ArrayList<PSDEUAGroupDetail> arrayList = this.selectByPSDEUAGroup(pSDEUAGroup);
        for (PSDEUAGroupDetail pSDEUAGroupDetail : arrayList) {
            PSDEUAGroupDetail pSDEUAGroupDetail2 = (PSDEUAGroupDetail)this.getDEModel().createEntity();
            pSDEUAGroupDetail2.setPSDEUAGRPDetailId(pSDEUAGroupDetail.getPSDEUAGRPDetailId());
            pSDEUAGroupDetail2.setPSDEUAGroupId(null);
            this.update(pSDEUAGroupDetail2);
        }
    }

    public void resetTempPSDEUAGroup(PSDEUAGroup pSDEUAGroup) throws Exception {
        ArrayList<PSDEUAGroupDetail> arrayList = this.selectTempByPSDEUAGroup(pSDEUAGroup);
        for (PSDEUAGroupDetail pSDEUAGroupDetail : arrayList) {
            PSDEUAGroupDetail pSDEUAGroupDetail2 = (PSDEUAGroupDetail)this.getDEModel().createEntity();
            pSDEUAGroupDetail2.setPSDEUAGRPDetailId(pSDEUAGroupDetail.getPSDEUAGRPDetailId());
            pSDEUAGroupDetail2.setPSDEUAGroupId(null);
            this.updateTemp(pSDEUAGroupDetail2);
        }
    }

    public void removeByPSDEUAGroup(PSDEUAGroup pSDEUAGroup) throws Exception {
        final PSDEUAGroup pSDEUAGroup2 = pSDEUAGroup;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEUAGroupDetailServiceBase.this.onBeforeRemoveByPSDEUAGroup(pSDEUAGroup2);
                PSDEUAGroupDetailServiceBase.this.internalRemoveByPSDEUAGroup(pSDEUAGroup2);
                PSDEUAGroupDetailServiceBase.this.onAfterRemoveByPSDEUAGroup(pSDEUAGroup2);
            }
        });
    }

    protected void onBeforeRemoveByPSDEUAGroup(PSDEUAGroup pSDEUAGroup) throws Exception {
    }

    protected void internalRemoveByPSDEUAGroup(PSDEUAGroup pSDEUAGroup) throws Exception {
        ArrayList<PSDEUAGroupDetail> arrayList = this.selectByPSDEUAGroup(pSDEUAGroup);
        this.onBeforeRemoveByPSDEUAGroup(pSDEUAGroup, arrayList);
        for (PSDEUAGroupDetail pSDEUAGroupDetail : arrayList) {
            this.remove(pSDEUAGroupDetail);
        }
        this.onAfterRemoveByPSDEUAGroup(pSDEUAGroup, arrayList);
    }

    protected void onAfterRemoveByPSDEUAGroup(PSDEUAGroup pSDEUAGroup) throws Exception {
    }

    protected void onBeforeRemoveByPSDEUAGroup(PSDEUAGroup pSDEUAGroup, ArrayList<PSDEUAGroupDetail> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDEUAGroup(PSDEUAGroup pSDEUAGroup, ArrayList<PSDEUAGroupDetail> arrayList) throws Exception {
    }

    public void testRemoveByRefPSDEUAGroup(PSDEUAGroup pSDEUAGroup) throws Exception {
        ArrayList<PSDEUAGroupDetail> arrayList = this.selectByRefPSDEUAGroup(pSDEUAGroup, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEUAGROUP");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDEUAGroup);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEUAGRPDETAIL_PSDEUAGROUP_REFPSDEUAGROUPID", "", iDataEntityModel.getName(), "PSDEUAGRPDETAIL", iDataEntityModel.getDataInfo(pSDEUAGroup), arrayList.get(0)));
        }
    }

    public void resetRefPSDEUAGroup(PSDEUAGroup pSDEUAGroup) throws Exception {
        ArrayList<PSDEUAGroupDetail> arrayList = this.selectByRefPSDEUAGroup(pSDEUAGroup);
        for (PSDEUAGroupDetail pSDEUAGroupDetail : arrayList) {
            PSDEUAGroupDetail pSDEUAGroupDetail2 = (PSDEUAGroupDetail)this.getDEModel().createEntity();
            pSDEUAGroupDetail2.setPSDEUAGRPDetailId(pSDEUAGroupDetail.getPSDEUAGRPDetailId());
            pSDEUAGroupDetail2.setRefPSDEUAGroupId(null);
            this.update(pSDEUAGroupDetail2);
        }
    }

    public void removeByRefPSDEUAGroup(PSDEUAGroup pSDEUAGroup) throws Exception {
        final PSDEUAGroup pSDEUAGroup2 = pSDEUAGroup;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEUAGroupDetailServiceBase.this.onBeforeRemoveByRefPSDEUAGroup(pSDEUAGroup2);
                PSDEUAGroupDetailServiceBase.this.internalRemoveByRefPSDEUAGroup(pSDEUAGroup2);
                PSDEUAGroupDetailServiceBase.this.onAfterRemoveByRefPSDEUAGroup(pSDEUAGroup2);
            }
        });
    }

    protected void onBeforeRemoveByRefPSDEUAGroup(PSDEUAGroup pSDEUAGroup) throws Exception {
    }

    protected void internalRemoveByRefPSDEUAGroup(PSDEUAGroup pSDEUAGroup) throws Exception {
        ArrayList<PSDEUAGroupDetail> arrayList = this.selectByRefPSDEUAGroup(pSDEUAGroup);
        this.onBeforeRemoveByRefPSDEUAGroup(pSDEUAGroup, arrayList);
        for (PSDEUAGroupDetail pSDEUAGroupDetail : arrayList) {
            this.remove(pSDEUAGroupDetail);
        }
        this.onAfterRemoveByRefPSDEUAGroup(pSDEUAGroup, arrayList);
    }

    protected void onAfterRemoveByRefPSDEUAGroup(PSDEUAGroup pSDEUAGroup) throws Exception {
    }

    protected void onBeforeRemoveByRefPSDEUAGroup(PSDEUAGroup pSDEUAGroup, ArrayList<PSDEUAGroupDetail> arrayList) throws Exception {
    }

    protected void onAfterRemoveByRefPSDEUAGroup(PSDEUAGroup pSDEUAGroup, ArrayList<PSDEUAGroupDetail> arrayList) throws Exception {
    }

    public void testRemoveByPSDEUAAction(PSDEUIAction pSDEUIAction) throws Exception {
        ArrayList<PSDEUAGroupDetail> arrayList = this.selectByPSDEUAAction(pSDEUIAction, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEUIACTION");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDEUIAction);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEUAGRPDETAIL_PSDEUIACTION_PSDEUIACTIONID", "", iDataEntityModel.getName(), "PSDEUAGRPDETAIL", iDataEntityModel.getDataInfo(pSDEUIAction), arrayList.get(0)));
        }
    }

    public void resetPSDEUAAction(PSDEUIAction pSDEUIAction) throws Exception {
        ArrayList<PSDEUAGroupDetail> arrayList = this.selectByPSDEUAAction(pSDEUIAction);
        for (PSDEUAGroupDetail pSDEUAGroupDetail : arrayList) {
            PSDEUAGroupDetail pSDEUAGroupDetail2 = (PSDEUAGroupDetail)this.getDEModel().createEntity();
            pSDEUAGroupDetail2.setPSDEUAGRPDetailId(pSDEUAGroupDetail.getPSDEUAGRPDetailId());
            pSDEUAGroupDetail2.setPSDEUIActionId(null);
            this.update(pSDEUAGroupDetail2);
        }
    }

    public void removeByPSDEUAAction(PSDEUIAction pSDEUIAction) throws Exception {
        final PSDEUIAction pSDEUIAction2 = pSDEUIAction;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEUAGroupDetailServiceBase.this.onBeforeRemoveByPSDEUAAction(pSDEUIAction2);
                PSDEUAGroupDetailServiceBase.this.internalRemoveByPSDEUAAction(pSDEUIAction2);
                PSDEUAGroupDetailServiceBase.this.onAfterRemoveByPSDEUAAction(pSDEUIAction2);
            }
        });
    }

    protected void onBeforeRemoveByPSDEUAAction(PSDEUIAction pSDEUIAction) throws Exception {
    }

    protected void internalRemoveByPSDEUAAction(PSDEUIAction pSDEUIAction) throws Exception {
        ArrayList<PSDEUAGroupDetail> arrayList = this.selectByPSDEUAAction(pSDEUIAction);
        this.onBeforeRemoveByPSDEUAAction(pSDEUIAction, arrayList);
        for (PSDEUAGroupDetail pSDEUAGroupDetail : arrayList) {
            this.remove(pSDEUAGroupDetail);
        }
        this.onAfterRemoveByPSDEUAAction(pSDEUIAction, arrayList);
    }

    protected void onAfterRemoveByPSDEUAAction(PSDEUIAction pSDEUIAction) throws Exception {
    }

    protected void onBeforeRemoveByPSDEUAAction(PSDEUIAction pSDEUIAction, ArrayList<PSDEUAGroupDetail> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDEUAAction(PSDEUIAction pSDEUIAction, ArrayList<PSDEUAGroupDetail> arrayList) throws Exception {
    }

    public void testRemoveByAfterPSSysCss(PSSysCss pSSysCss) throws Exception {
        ArrayList<PSDEUAGroupDetail> arrayList = this.selectByAfterPSSysCss(pSSysCss, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSCSS");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSSysCss);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEUAGRPDETAIL_PSSYSCSS_AFTERPSSYSCSSID", "", iDataEntityModel.getName(), "PSDEUAGRPDETAIL", iDataEntityModel.getDataInfo(pSSysCss), arrayList.get(0)));
        }
    }

    public void resetAfterPSSysCss(PSSysCss pSSysCss) throws Exception {
        ArrayList<PSDEUAGroupDetail> arrayList = this.selectByAfterPSSysCss(pSSysCss);
        for (PSDEUAGroupDetail pSDEUAGroupDetail : arrayList) {
            PSDEUAGroupDetail pSDEUAGroupDetail2 = (PSDEUAGroupDetail)this.getDEModel().createEntity();
            pSDEUAGroupDetail2.setPSDEUAGRPDetailId(pSDEUAGroupDetail.getPSDEUAGRPDetailId());
            pSDEUAGroupDetail2.setAfterPSSysCssId(null);
            this.update(pSDEUAGroupDetail2);
        }
    }

    public void removeByAfterPSSysCss(PSSysCss pSSysCss) throws Exception {
        final PSSysCss pSSysCss2 = pSSysCss;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEUAGroupDetailServiceBase.this.onBeforeRemoveByAfterPSSysCss(pSSysCss2);
                PSDEUAGroupDetailServiceBase.this.internalRemoveByAfterPSSysCss(pSSysCss2);
                PSDEUAGroupDetailServiceBase.this.onAfterRemoveByAfterPSSysCss(pSSysCss2);
            }
        });
    }

    protected void onBeforeRemoveByAfterPSSysCss(PSSysCss pSSysCss) throws Exception {
    }

    protected void internalRemoveByAfterPSSysCss(PSSysCss pSSysCss) throws Exception {
        ArrayList<PSDEUAGroupDetail> arrayList = this.selectByAfterPSSysCss(pSSysCss);
        this.onBeforeRemoveByAfterPSSysCss(pSSysCss, arrayList);
        for (PSDEUAGroupDetail pSDEUAGroupDetail : arrayList) {
            this.remove(pSDEUAGroupDetail);
        }
        this.onAfterRemoveByAfterPSSysCss(pSSysCss, arrayList);
    }

    protected void onAfterRemoveByAfterPSSysCss(PSSysCss pSSysCss) throws Exception {
    }

    protected void onBeforeRemoveByAfterPSSysCss(PSSysCss pSSysCss, ArrayList<PSDEUAGroupDetail> arrayList) throws Exception {
    }

    protected void onAfterRemoveByAfterPSSysCss(PSSysCss pSSysCss, ArrayList<PSDEUAGroupDetail> arrayList) throws Exception {
    }

    public void testRemoveByBeforePSSysCss(PSSysCss pSSysCss) throws Exception {
        ArrayList<PSDEUAGroupDetail> arrayList = this.selectByBeforePSSysCss(pSSysCss, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSCSS");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSSysCss);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEUAGRPDETAIL_PSSYSCSS_BEFOREPSSYSCSSID", "", iDataEntityModel.getName(), "PSDEUAGRPDETAIL", iDataEntityModel.getDataInfo(pSSysCss), arrayList.get(0)));
        }
    }

    public void resetBeforePSSysCss(PSSysCss pSSysCss) throws Exception {
        ArrayList<PSDEUAGroupDetail> arrayList = this.selectByBeforePSSysCss(pSSysCss);
        for (PSDEUAGroupDetail pSDEUAGroupDetail : arrayList) {
            PSDEUAGroupDetail pSDEUAGroupDetail2 = (PSDEUAGroupDetail)this.getDEModel().createEntity();
            pSDEUAGroupDetail2.setPSDEUAGRPDetailId(pSDEUAGroupDetail.getPSDEUAGRPDetailId());
            pSDEUAGroupDetail2.setBeforePSSysCssId(null);
            this.update(pSDEUAGroupDetail2);
        }
    }

    public void removeByBeforePSSysCss(PSSysCss pSSysCss) throws Exception {
        final PSSysCss pSSysCss2 = pSSysCss;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEUAGroupDetailServiceBase.this.onBeforeRemoveByBeforePSSysCss(pSSysCss2);
                PSDEUAGroupDetailServiceBase.this.internalRemoveByBeforePSSysCss(pSSysCss2);
                PSDEUAGroupDetailServiceBase.this.onAfterRemoveByBeforePSSysCss(pSSysCss2);
            }
        });
    }

    protected void onBeforeRemoveByBeforePSSysCss(PSSysCss pSSysCss) throws Exception {
    }

    protected void internalRemoveByBeforePSSysCss(PSSysCss pSSysCss) throws Exception {
        ArrayList<PSDEUAGroupDetail> arrayList = this.selectByBeforePSSysCss(pSSysCss);
        this.onBeforeRemoveByBeforePSSysCss(pSSysCss, arrayList);
        for (PSDEUAGroupDetail pSDEUAGroupDetail : arrayList) {
            this.remove(pSDEUAGroupDetail);
        }
        this.onAfterRemoveByBeforePSSysCss(pSSysCss, arrayList);
    }

    protected void onAfterRemoveByBeforePSSysCss(PSSysCss pSSysCss) throws Exception {
    }

    protected void onBeforeRemoveByBeforePSSysCss(PSSysCss pSSysCss, ArrayList<PSDEUAGroupDetail> arrayList) throws Exception {
    }

    protected void onAfterRemoveByBeforePSSysCss(PSSysCss pSSysCss, ArrayList<PSDEUAGroupDetail> arrayList) throws Exception {
    }

    public void testRemoveByPSSysCss(PSSysCss pSSysCss) throws Exception {
        ArrayList<PSDEUAGroupDetail> arrayList = this.selectByPSSysCss(pSSysCss, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSCSS");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSSysCss);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEUAGRPDETAIL_PSSYSCSS_PSSYSCSSID", "", iDataEntityModel.getName(), "PSDEUAGRPDETAIL", iDataEntityModel.getDataInfo(pSSysCss), arrayList.get(0)));
        }
    }

    public void resetPSSysCss(PSSysCss pSSysCss) throws Exception {
        ArrayList<PSDEUAGroupDetail> arrayList = this.selectByPSSysCss(pSSysCss);
        for (PSDEUAGroupDetail pSDEUAGroupDetail : arrayList) {
            PSDEUAGroupDetail pSDEUAGroupDetail2 = (PSDEUAGroupDetail)this.getDEModel().createEntity();
            pSDEUAGroupDetail2.setPSDEUAGRPDetailId(pSDEUAGroupDetail.getPSDEUAGRPDetailId());
            pSDEUAGroupDetail2.setPSSysCssId(null);
            this.update(pSDEUAGroupDetail2);
        }
    }

    public void removeByPSSysCss(PSSysCss pSSysCss) throws Exception {
        final PSSysCss pSSysCss2 = pSSysCss;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEUAGroupDetailServiceBase.this.onBeforeRemoveByPSSysCss(pSSysCss2);
                PSDEUAGroupDetailServiceBase.this.internalRemoveByPSSysCss(pSSysCss2);
                PSDEUAGroupDetailServiceBase.this.onAfterRemoveByPSSysCss(pSSysCss2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysCss(PSSysCss pSSysCss) throws Exception {
    }

    protected void internalRemoveByPSSysCss(PSSysCss pSSysCss) throws Exception {
        ArrayList<PSDEUAGroupDetail> arrayList = this.selectByPSSysCss(pSSysCss);
        this.onBeforeRemoveByPSSysCss(pSSysCss, arrayList);
        for (PSDEUAGroupDetail pSDEUAGroupDetail : arrayList) {
            this.remove(pSDEUAGroupDetail);
        }
        this.onAfterRemoveByPSSysCss(pSSysCss, arrayList);
    }

    protected void onAfterRemoveByPSSysCss(PSSysCss pSSysCss) throws Exception {
    }

    protected void onBeforeRemoveByPSSysCss(PSSysCss pSSysCss, ArrayList<PSDEUAGroupDetail> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysCss(PSSysCss pSSysCss, ArrayList<PSDEUAGroupDetail> arrayList) throws Exception {
    }

    public void testRemoveByPSSysImage(PSSysImage pSSysImage) throws Exception {
        ArrayList<PSDEUAGroupDetail> arrayList = this.selectByPSSysImage(pSSysImage, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSIMAGE");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSSysImage);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEUAGRPDETAIL_PSSYSIMAGE_PSSYSIMAGEID", "", iDataEntityModel.getName(), "PSDEUAGRPDETAIL", iDataEntityModel.getDataInfo(pSSysImage), arrayList.get(0)));
        }
    }

    public void resetPSSysImage(PSSysImage pSSysImage) throws Exception {
        ArrayList<PSDEUAGroupDetail> arrayList = this.selectByPSSysImage(pSSysImage);
        for (PSDEUAGroupDetail pSDEUAGroupDetail : arrayList) {
            PSDEUAGroupDetail pSDEUAGroupDetail2 = (PSDEUAGroupDetail)this.getDEModel().createEntity();
            pSDEUAGroupDetail2.setPSDEUAGRPDetailId(pSDEUAGroupDetail.getPSDEUAGRPDetailId());
            pSDEUAGroupDetail2.setPSSysImageId(null);
            this.update(pSDEUAGroupDetail2);
        }
    }

    public void removeByPSSysImage(PSSysImage pSSysImage) throws Exception {
        final PSSysImage pSSysImage2 = pSSysImage;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEUAGroupDetailServiceBase.this.onBeforeRemoveByPSSysImage(pSSysImage2);
                PSDEUAGroupDetailServiceBase.this.internalRemoveByPSSysImage(pSSysImage2);
                PSDEUAGroupDetailServiceBase.this.onAfterRemoveByPSSysImage(pSSysImage2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysImage(PSSysImage pSSysImage) throws Exception {
    }

    protected void internalRemoveByPSSysImage(PSSysImage pSSysImage) throws Exception {
        ArrayList<PSDEUAGroupDetail> arrayList = this.selectByPSSysImage(pSSysImage);
        this.onBeforeRemoveByPSSysImage(pSSysImage, arrayList);
        for (PSDEUAGroupDetail pSDEUAGroupDetail : arrayList) {
            this.remove(pSDEUAGroupDetail);
        }
        this.onAfterRemoveByPSSysImage(pSSysImage, arrayList);
    }

    protected void onAfterRemoveByPSSysImage(PSSysImage pSSysImage) throws Exception {
    }

    protected void onBeforeRemoveByPSSysImage(PSSysImage pSSysImage, ArrayList<PSDEUAGroupDetail> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysImage(PSSysImage pSSysImage, ArrayList<PSDEUAGroupDetail> arrayList) throws Exception {
    }

    public void testRemoveByPSSysPFPlugin(PSSysPFPlugin pSSysPFPlugin) throws Exception {
        ArrayList<PSDEUAGroupDetail> arrayList = this.selectByPSSysPFPlugin(pSSysPFPlugin, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSPFPLUGIN");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSSysPFPlugin);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEUAGRPDETAIL_PSSYSPFPLUGIN_PSSYSPFPLUGINID", "", iDataEntityModel.getName(), "PSDEUAGRPDETAIL", iDataEntityModel.getDataInfo(pSSysPFPlugin), arrayList.get(0)));
        }
    }

    public void resetPSSysPFPlugin(PSSysPFPlugin pSSysPFPlugin) throws Exception {
        ArrayList<PSDEUAGroupDetail> arrayList = this.selectByPSSysPFPlugin(pSSysPFPlugin);
        for (PSDEUAGroupDetail pSDEUAGroupDetail : arrayList) {
            PSDEUAGroupDetail pSDEUAGroupDetail2 = (PSDEUAGroupDetail)this.getDEModel().createEntity();
            pSDEUAGroupDetail2.setPSDEUAGRPDetailId(pSDEUAGroupDetail.getPSDEUAGRPDetailId());
            pSDEUAGroupDetail2.setPSSysPFPluginId(null);
            this.update(pSDEUAGroupDetail2);
        }
    }

    public void removeByPSSysPFPlugin(PSSysPFPlugin pSSysPFPlugin) throws Exception {
        final PSSysPFPlugin pSSysPFPlugin2 = pSSysPFPlugin;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEUAGroupDetailServiceBase.this.onBeforeRemoveByPSSysPFPlugin(pSSysPFPlugin2);
                PSDEUAGroupDetailServiceBase.this.internalRemoveByPSSysPFPlugin(pSSysPFPlugin2);
                PSDEUAGroupDetailServiceBase.this.onAfterRemoveByPSSysPFPlugin(pSSysPFPlugin2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysPFPlugin(PSSysPFPlugin pSSysPFPlugin) throws Exception {
    }

    protected void internalRemoveByPSSysPFPlugin(PSSysPFPlugin pSSysPFPlugin) throws Exception {
        ArrayList<PSDEUAGroupDetail> arrayList = this.selectByPSSysPFPlugin(pSSysPFPlugin);
        this.onBeforeRemoveByPSSysPFPlugin(pSSysPFPlugin, arrayList);
        for (PSDEUAGroupDetail pSDEUAGroupDetail : arrayList) {
            this.remove(pSDEUAGroupDetail);
        }
        this.onAfterRemoveByPSSysPFPlugin(pSSysPFPlugin, arrayList);
    }

    protected void onAfterRemoveByPSSysPFPlugin(PSSysPFPlugin pSSysPFPlugin) throws Exception {
    }

    protected void onBeforeRemoveByPSSysPFPlugin(PSSysPFPlugin pSSysPFPlugin, ArrayList<PSDEUAGroupDetail> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysPFPlugin(PSSysPFPlugin pSSysPFPlugin, ArrayList<PSDEUAGroupDetail> arrayList) throws Exception {
    }

    public void testRemoveByAfterPSSysResource(PSSysResource pSSysResource) throws Exception {
        ArrayList<PSDEUAGroupDetail> arrayList = this.selectByAfterPSSysResource(pSSysResource, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSRESOURCE");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSSysResource);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEUAGRPDETAIL_PSSYSRESOURCE_AFTERPSSYSRESOURCEID", "", iDataEntityModel.getName(), "PSDEUAGRPDETAIL", iDataEntityModel.getDataInfo(pSSysResource), arrayList.get(0)));
        }
    }

    public void resetAfterPSSysResource(PSSysResource pSSysResource) throws Exception {
        ArrayList<PSDEUAGroupDetail> arrayList = this.selectByAfterPSSysResource(pSSysResource);
        for (PSDEUAGroupDetail pSDEUAGroupDetail : arrayList) {
            PSDEUAGroupDetail pSDEUAGroupDetail2 = (PSDEUAGroupDetail)this.getDEModel().createEntity();
            pSDEUAGroupDetail2.setPSDEUAGRPDetailId(pSDEUAGroupDetail.getPSDEUAGRPDetailId());
            pSDEUAGroupDetail2.setAfterPSSysResourceId(null);
            this.update(pSDEUAGroupDetail2);
        }
    }

    public void removeByAfterPSSysResource(PSSysResource pSSysResource) throws Exception {
        final PSSysResource pSSysResource2 = pSSysResource;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEUAGroupDetailServiceBase.this.onBeforeRemoveByAfterPSSysResource(pSSysResource2);
                PSDEUAGroupDetailServiceBase.this.internalRemoveByAfterPSSysResource(pSSysResource2);
                PSDEUAGroupDetailServiceBase.this.onAfterRemoveByAfterPSSysResource(pSSysResource2);
            }
        });
    }

    protected void onBeforeRemoveByAfterPSSysResource(PSSysResource pSSysResource) throws Exception {
    }

    protected void internalRemoveByAfterPSSysResource(PSSysResource pSSysResource) throws Exception {
        ArrayList<PSDEUAGroupDetail> arrayList = this.selectByAfterPSSysResource(pSSysResource);
        this.onBeforeRemoveByAfterPSSysResource(pSSysResource, arrayList);
        for (PSDEUAGroupDetail pSDEUAGroupDetail : arrayList) {
            this.remove(pSDEUAGroupDetail);
        }
        this.onAfterRemoveByAfterPSSysResource(pSSysResource, arrayList);
    }

    protected void onAfterRemoveByAfterPSSysResource(PSSysResource pSSysResource) throws Exception {
    }

    protected void onBeforeRemoveByAfterPSSysResource(PSSysResource pSSysResource, ArrayList<PSDEUAGroupDetail> arrayList) throws Exception {
    }

    protected void onAfterRemoveByAfterPSSysResource(PSSysResource pSSysResource, ArrayList<PSDEUAGroupDetail> arrayList) throws Exception {
    }

    public void testRemoveByBeforePSSysResource(PSSysResource pSSysResource) throws Exception {
        ArrayList<PSDEUAGroupDetail> arrayList = this.selectByBeforePSSysResource(pSSysResource, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSRESOURCE");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSSysResource);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEUAGRPDETAIL_PSSYSRESOURCE_BEFOREPSSYSRESOURCEID", "", iDataEntityModel.getName(), "PSDEUAGRPDETAIL", iDataEntityModel.getDataInfo(pSSysResource), arrayList.get(0)));
        }
    }

    public void resetBeforePSSysResource(PSSysResource pSSysResource) throws Exception {
        ArrayList<PSDEUAGroupDetail> arrayList = this.selectByBeforePSSysResource(pSSysResource);
        for (PSDEUAGroupDetail pSDEUAGroupDetail : arrayList) {
            PSDEUAGroupDetail pSDEUAGroupDetail2 = (PSDEUAGroupDetail)this.getDEModel().createEntity();
            pSDEUAGroupDetail2.setPSDEUAGRPDetailId(pSDEUAGroupDetail.getPSDEUAGRPDetailId());
            pSDEUAGroupDetail2.setBeforePSSysResourceId(null);
            this.update(pSDEUAGroupDetail2);
        }
    }

    public void removeByBeforePSSysResource(PSSysResource pSSysResource) throws Exception {
        final PSSysResource pSSysResource2 = pSSysResource;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEUAGroupDetailServiceBase.this.onBeforeRemoveByBeforePSSysResource(pSSysResource2);
                PSDEUAGroupDetailServiceBase.this.internalRemoveByBeforePSSysResource(pSSysResource2);
                PSDEUAGroupDetailServiceBase.this.onAfterRemoveByBeforePSSysResource(pSSysResource2);
            }
        });
    }

    protected void onBeforeRemoveByBeforePSSysResource(PSSysResource pSSysResource) throws Exception {
    }

    protected void internalRemoveByBeforePSSysResource(PSSysResource pSSysResource) throws Exception {
        ArrayList<PSDEUAGroupDetail> arrayList = this.selectByBeforePSSysResource(pSSysResource);
        this.onBeforeRemoveByBeforePSSysResource(pSSysResource, arrayList);
        for (PSDEUAGroupDetail pSDEUAGroupDetail : arrayList) {
            this.remove(pSDEUAGroupDetail);
        }
        this.onAfterRemoveByBeforePSSysResource(pSSysResource, arrayList);
    }

    protected void onAfterRemoveByBeforePSSysResource(PSSysResource pSSysResource) throws Exception {
    }

    protected void onBeforeRemoveByBeforePSSysResource(PSSysResource pSSysResource, ArrayList<PSDEUAGroupDetail> arrayList) throws Exception {
    }

    protected void onAfterRemoveByBeforePSSysResource(PSSysResource pSSysResource, ArrayList<PSDEUAGroupDetail> arrayList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(PSDEUAGroupDetail pSDEUAGroupDetail) throws Exception {
        super.onBeforeRemove(pSDEUAGroupDetail);
    }

    public void removeTempByPSDEUAGroup(PSDEUAGroup pSDEUAGroup) throws Exception {
        final PSDEUAGroup pSDEUAGroup2 = pSDEUAGroup;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEUAGroupDetailServiceBase.this.onBeforeRemoveTempByPSDEUAGroup(pSDEUAGroup2);
                PSDEUAGroupDetailServiceBase.this.internalRemoveTempByPSDEUAGroup(pSDEUAGroup2);
                PSDEUAGroupDetailServiceBase.this.onAfterRemoveTempByPSDEUAGroup(pSDEUAGroup2);
            }
        });
    }

    protected void onBeforeRemoveTempByPSDEUAGroup(PSDEUAGroup pSDEUAGroup) throws Exception {
    }

    protected void internalRemoveTempByPSDEUAGroup(PSDEUAGroup pSDEUAGroup) throws Exception {
        ArrayList<PSDEUAGroupDetail> arrayList = this.selectTempByPSDEUAGroup(pSDEUAGroup);
        this.onBeforeRemoveTempByPSDEUAGroup(pSDEUAGroup, arrayList);
        for (PSDEUAGroupDetail pSDEUAGroupDetail : arrayList) {
            this.removeTemp(pSDEUAGroupDetail);
        }
        this.onAfterRemoveTempByPSDEUAGroup(pSDEUAGroup, arrayList);
    }

    protected void onAfterRemoveTempByPSDEUAGroup(PSDEUAGroup pSDEUAGroup) throws Exception {
    }

    protected void onBeforeRemoveTempByPSDEUAGroup(PSDEUAGroup pSDEUAGroup, ArrayList<PSDEUAGroupDetail> arrayList) throws Exception {
    }

    protected void onAfterRemoveTempByPSDEUAGroup(PSDEUAGroup pSDEUAGroup, ArrayList<PSDEUAGroupDetail> arrayList) throws Exception {
    }

    protected void replaceParentInfo(PSDEUAGroupDetail pSDEUAGroupDetail, CloneSession cloneSession) throws Exception {
        IEntity iEntity;
        super.replaceParentInfo(pSDEUAGroupDetail, cloneSession);
        if (pSDEUAGroupDetail.getPSDEUAGroupId() != null && (iEntity = cloneSession.getEntity("PSDEUAGROUP", (Object)pSDEUAGroupDetail.getPSDEUAGroupId())) != null) {
            this.onFillParentInfo_PSDEUAGroup(pSDEUAGroupDetail, (PSDEUAGroup)iEntity);
        }
        if (pSDEUAGroupDetail.getRefPSDEUAGroupId() != null && (iEntity = cloneSession.getEntity("PSDEUAGROUP", (Object)pSDEUAGroupDetail.getRefPSDEUAGroupId())) != null) {
            this.onFillParentInfo_RefPSDEUAGroup(pSDEUAGroupDetail, (PSDEUAGroup)iEntity);
        }
        if (pSDEUAGroupDetail.getPSDEUIActionId() != null && (iEntity = cloneSession.getEntity("PSDEUIACTION", (Object)pSDEUAGroupDetail.getPSDEUIActionId())) != null) {
            this.onFillParentInfo_PSDEUAAction(pSDEUAGroupDetail, (PSDEUIAction)iEntity);
        }
        if (pSDEUAGroupDetail.getAfterPSSysCssId() != null && (iEntity = cloneSession.getEntity("PSSYSCSS", (Object)pSDEUAGroupDetail.getAfterPSSysCssId())) != null) {
            this.onFillParentInfo_AfterPSSysCss(pSDEUAGroupDetail, (PSSysCss)iEntity);
        }
        if (pSDEUAGroupDetail.getBeforePSSysCssId() != null && (iEntity = cloneSession.getEntity("PSSYSCSS", (Object)pSDEUAGroupDetail.getBeforePSSysCssId())) != null) {
            this.onFillParentInfo_BeforePSSysCss(pSDEUAGroupDetail, (PSSysCss)iEntity);
        }
        if (pSDEUAGroupDetail.getPSSysCssId() != null && (iEntity = cloneSession.getEntity("PSSYSCSS", (Object)pSDEUAGroupDetail.getPSSysCssId())) != null) {
            this.onFillParentInfo_PSSysCss(pSDEUAGroupDetail, (PSSysCss)iEntity);
        }
        if (pSDEUAGroupDetail.getPSSysImageId() != null && (iEntity = cloneSession.getEntity("PSSYSIMAGE", (Object)pSDEUAGroupDetail.getPSSysImageId())) != null) {
            this.onFillParentInfo_PSSysImage(pSDEUAGroupDetail, (PSSysImage)iEntity);
        }
        if (pSDEUAGroupDetail.getPSSysPFPluginId() != null && (iEntity = cloneSession.getEntity("PSSYSPFPLUGIN", (Object)pSDEUAGroupDetail.getPSSysPFPluginId())) != null) {
            this.onFillParentInfo_PSSysPFPlugin(pSDEUAGroupDetail, (PSSysPFPlugin)iEntity);
        }
        if (pSDEUAGroupDetail.getAfterPSSysResourceId() != null && (iEntity = cloneSession.getEntity("PSSYSRESOURCE", (Object)pSDEUAGroupDetail.getAfterPSSysResourceId())) != null) {
            this.onFillParentInfo_AfterPSSysResource(pSDEUAGroupDetail, (PSSysResource)iEntity);
        }
        if (pSDEUAGroupDetail.getBeforePSSysResourceId() != null && (iEntity = cloneSession.getEntity("PSSYSRESOURCE", (Object)pSDEUAGroupDetail.getBeforePSSysResourceId())) != null) {
            this.onFillParentInfo_BeforePSSysResource(pSDEUAGroupDetail, (PSSysResource)iEntity);
        }
    }

    protected void onRemoveEntityUncopyValues(PSDEUAGroupDetail pSDEUAGroupDetail, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues(pSDEUAGroupDetail, bl);
    }

    protected void onCheckEntity(boolean bl, PSDEUAGroupDetail pSDEUAGroupDetail, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_ActionLevel(bl, pSDEUAGroupDetail, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_AddSeparator(bl, pSDEUAGroupDetail, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_AfterContent(bl, pSDEUAGroupDetail, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_AfterItemType(bl, pSDEUAGroupDetail, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_AfterPSSysCssId(bl, pSDEUAGroupDetail, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_AfterPSSysResourceId(bl, pSDEUAGroupDetail, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_BeforeContent(bl, pSDEUAGroupDetail, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_BeforeItemType(bl, pSDEUAGroupDetail, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_BeforePSSysCssId(bl, pSDEUAGroupDetail, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_BeforePSSysResourceId(bl, pSDEUAGroupDetail, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ButtonStyle(bl, pSDEUAGroupDetail, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_CodeName(bl, pSDEUAGroupDetail, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_DetailTag(bl, pSDEUAGroupDetail, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_DetailTag2(bl, pSDEUAGroupDetail, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_DetailType(bl, pSDEUAGroupDetail, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_DynaModelFlag(bl, pSDEUAGroupDetail, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_EnableLogic(bl, pSDEUAGroupDetail, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Memo(bl, pSDEUAGroupDetail, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_OrderValue(bl, pSDEUAGroupDetail, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEUAGroupId(bl, pSDEUAGroupDetail, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEUAGRPDetailId(bl, pSDEUAGroupDetail, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEUAGRPDetailName(bl, pSDEUAGroupDetail, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEUIActionId(bl, pSDEUAGroupDetail, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDynaInstId(bl, pSDEUAGroupDetail, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysCssId(bl, pSDEUAGroupDetail, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysCssName(bl, pSDEUAGroupDetail, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysImageId(bl, pSDEUAGroupDetail, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysImageName(bl, pSDEUAGroupDetail, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysPFPluginId(bl, pSDEUAGroupDetail, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_RefPSDEUAGroupId(bl, pSDEUAGroupDetail, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ShowMode(bl, pSDEUAGroupDetail, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UIActionParams(bl, pSDEUAGroupDetail, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserCat(bl, pSDEUAGroupDetail, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag(bl, pSDEUAGroupDetail, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag2(bl, pSDEUAGroupDetail, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag3(bl, pSDEUAGroupDetail, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag4(bl, pSDEUAGroupDetail, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ValidFlag(bl, pSDEUAGroupDetail, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_VisibleLogic(bl, pSDEUAGroupDetail, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, pSDEUAGroupDetail, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_ActionLevel(boolean bl, PSDEUAGroupDetail pSDEUAGroupDetail, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEUAGroupDetail.isActionLevelDirty() : !pSDEUAGroupDetail.isActionLevelDirty()) {
            return null;
        }
        Integer n = pSDEUAGroupDetail.getActionLevel();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_ActionLevel_Default(pSDEUAGroupDetail, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ACTIONLEVEL");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_AddSeparator(boolean bl, PSDEUAGroupDetail pSDEUAGroupDetail, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEUAGroupDetail.isAddSeparatorDirty() : !pSDEUAGroupDetail.isAddSeparatorDirty()) {
            return null;
        }
        Integer n = pSDEUAGroupDetail.getAddSeparator();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_AddSeparator_Default(pSDEUAGroupDetail, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ADDSEPARATOR");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_AfterContent(boolean bl, PSDEUAGroupDetail pSDEUAGroupDetail, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEUAGroupDetail.isAfterContentDirty() : !pSDEUAGroupDetail.isAfterContentDirty()) {
            return null;
        }
        String string = pSDEUAGroupDetail.getAfterContent();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_AfterContent_Default(pSDEUAGroupDetail, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("AFTERCONTENT");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_AfterItemType(boolean bl, PSDEUAGroupDetail pSDEUAGroupDetail, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEUAGroupDetail.isAfterItemTypeDirty() : !pSDEUAGroupDetail.isAfterItemTypeDirty()) {
            return null;
        }
        String string = pSDEUAGroupDetail.getAfterItemType();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_AfterItemType_Default(pSDEUAGroupDetail, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("AFTERITEMTYPE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_AfterPSSysCssId(boolean bl, PSDEUAGroupDetail pSDEUAGroupDetail, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEUAGroupDetail.isAfterPSSysCssIdDirty() : !pSDEUAGroupDetail.isAfterPSSysCssIdDirty()) {
            return null;
        }
        String string = pSDEUAGroupDetail.getAfterPSSysCssId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_AfterPSSysCssId_Default(pSDEUAGroupDetail, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("AFTERPSSYSCSSID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_AfterPSSysResourceId(boolean bl, PSDEUAGroupDetail pSDEUAGroupDetail, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEUAGroupDetail.isAfterPSSysResourceIdDirty() : !pSDEUAGroupDetail.isAfterPSSysResourceIdDirty()) {
            return null;
        }
        String string = pSDEUAGroupDetail.getAfterPSSysResourceId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_AfterPSSysResourceId_Default(pSDEUAGroupDetail, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("AFTERPSSYSRESOURCEID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_BeforeContent(boolean bl, PSDEUAGroupDetail pSDEUAGroupDetail, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEUAGroupDetail.isBeforeContentDirty() : !pSDEUAGroupDetail.isBeforeContentDirty()) {
            return null;
        }
        String string = pSDEUAGroupDetail.getBeforeContent();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_BeforeContent_Default(pSDEUAGroupDetail, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("BEFORECONTENT");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_BeforeItemType(boolean bl, PSDEUAGroupDetail pSDEUAGroupDetail, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEUAGroupDetail.isBeforeItemTypeDirty() : !pSDEUAGroupDetail.isBeforeItemTypeDirty()) {
            return null;
        }
        String string = pSDEUAGroupDetail.getBeforeItemType();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_BeforeItemType_Default(pSDEUAGroupDetail, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("BEFOREITEMTYPE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_BeforePSSysCssId(boolean bl, PSDEUAGroupDetail pSDEUAGroupDetail, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEUAGroupDetail.isBeforePSSysCssIdDirty() : !pSDEUAGroupDetail.isBeforePSSysCssIdDirty()) {
            return null;
        }
        String string = pSDEUAGroupDetail.getBeforePSSysCssId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_BeforePSSysCssId_Default(pSDEUAGroupDetail, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("BEFOREPSSYSCSSID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_BeforePSSysResourceId(boolean bl, PSDEUAGroupDetail pSDEUAGroupDetail, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEUAGroupDetail.isBeforePSSysResourceIdDirty() : !pSDEUAGroupDetail.isBeforePSSysResourceIdDirty()) {
            return null;
        }
        String string = pSDEUAGroupDetail.getBeforePSSysResourceId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_BeforePSSysResourceId_Default(pSDEUAGroupDetail, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("BEFOREPSSYSRESOURCEID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ButtonStyle(boolean bl, PSDEUAGroupDetail pSDEUAGroupDetail, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEUAGroupDetail.isButtonStyleDirty() : !pSDEUAGroupDetail.isButtonStyleDirty()) {
            return null;
        }
        String string = pSDEUAGroupDetail.getButtonStyle();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_ButtonStyle_Default(pSDEUAGroupDetail, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("BUTTONSTYLE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_CodeName(boolean bl, PSDEUAGroupDetail pSDEUAGroupDetail, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEUAGroupDetail.isCodeNameDirty() : !pSDEUAGroupDetail.isCodeNameDirty()) {
            return null;
        }
        String string = pSDEUAGroupDetail.getCodeName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_CodeName_Default(pSDEUAGroupDetail, bl2, bl3);
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
                string3 = "PSDEUAGROUPID";
                String string4 = this.checkFieldDupRule(this.getPSDEUAGroupDetailDEModel(), "CODENAME", string3, pSDEUAGroupDetail, bl2, bl3);
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

    protected EntityFieldError onCheckField_DetailTag(boolean bl, PSDEUAGroupDetail pSDEUAGroupDetail, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEUAGroupDetail.isDetailTagDirty() : !pSDEUAGroupDetail.isDetailTagDirty()) {
            return null;
        }
        String string = pSDEUAGroupDetail.getDetailTag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_DetailTag_Default(pSDEUAGroupDetail, bl2, bl3);
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

    protected EntityFieldError onCheckField_DetailTag2(boolean bl, PSDEUAGroupDetail pSDEUAGroupDetail, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEUAGroupDetail.isDetailTag2Dirty() : !pSDEUAGroupDetail.isDetailTag2Dirty()) {
            return null;
        }
        String string = pSDEUAGroupDetail.getDetailTag2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_DetailTag2_Default(pSDEUAGroupDetail, bl2, bl3);
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

    protected EntityFieldError onCheckField_DetailType(boolean bl, PSDEUAGroupDetail pSDEUAGroupDetail, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEUAGroupDetail.isDetailTypeDirty() && !bl2 : !pSDEUAGroupDetail.isDetailTypeDirty()) {
            return null;
        }
        String string = pSDEUAGroupDetail.getDetailType();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DETAILTYPE");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_DetailType_Default(pSDEUAGroupDetail, bl2, bl3);
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

    protected EntityFieldError onCheckField_DynaModelFlag(boolean bl, PSDEUAGroupDetail pSDEUAGroupDetail, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEUAGroupDetail.isDynaModelFlagDirty() : !pSDEUAGroupDetail.isDynaModelFlagDirty()) {
            return null;
        }
        Integer n = pSDEUAGroupDetail.getDynaModelFlag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_DynaModelFlag_Default(pSDEUAGroupDetail, bl2, bl3);
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

    protected EntityFieldError onCheckField_EnableLogic(boolean bl, PSDEUAGroupDetail pSDEUAGroupDetail, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEUAGroupDetail.isEnableLogicDirty() : !pSDEUAGroupDetail.isEnableLogicDirty()) {
            return null;
        }
        String string = pSDEUAGroupDetail.getEnableLogic();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_EnableLogic_Default(pSDEUAGroupDetail, bl2, bl3);
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

    protected EntityFieldError onCheckField_Memo(boolean bl, PSDEUAGroupDetail pSDEUAGroupDetail, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEUAGroupDetail.isMemoDirty() : !pSDEUAGroupDetail.isMemoDirty()) {
            return null;
        }
        String string = pSDEUAGroupDetail.getMemo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Memo_Default(pSDEUAGroupDetail, bl2, bl3);
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

    protected EntityFieldError onCheckField_OrderValue(boolean bl, PSDEUAGroupDetail pSDEUAGroupDetail, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEUAGroupDetail.isOrderValueDirty() : !pSDEUAGroupDetail.isOrderValueDirty()) {
            return null;
        }
        Integer n = pSDEUAGroupDetail.getOrderValue();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_OrderValue_Default(pSDEUAGroupDetail, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDEUAGroupId(boolean bl, PSDEUAGroupDetail pSDEUAGroupDetail, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEUAGroupDetail.isPSDEUAGroupIdDirty() && !bl2 : !pSDEUAGroupDetail.isPSDEUAGroupIdDirty()) {
            return null;
        }
        String string = pSDEUAGroupDetail.getPSDEUAGroupId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEUAGROUPID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEUAGroupId_Default(pSDEUAGroupDetail, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDEUAGRPDetailId(boolean bl, PSDEUAGroupDetail pSDEUAGroupDetail, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEUAGroupDetail.isPSDEUAGRPDetailIdDirty() && !bl2 : !pSDEUAGroupDetail.isPSDEUAGRPDetailIdDirty()) {
            return null;
        }
        String string = pSDEUAGroupDetail.getPSDEUAGRPDetailId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEUAGRPDETAILID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEUAGRPDetailId_Default(pSDEUAGroupDetail, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEUAGRPDETAILID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDEUAGRPDetailName(boolean bl, PSDEUAGroupDetail pSDEUAGroupDetail, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEUAGroupDetail.isPSDEUAGRPDetailNameDirty() : !pSDEUAGroupDetail.isPSDEUAGRPDetailNameDirty()) {
            return null;
        }
        String string = pSDEUAGroupDetail.getPSDEUAGRPDetailName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEUAGRPDetailName_Default(pSDEUAGroupDetail, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEUAGRPDETAILNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDEUIActionId(boolean bl, PSDEUAGroupDetail pSDEUAGroupDetail, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEUAGroupDetail.isPSDEUIActionIdDirty() && !bl2 : !pSDEUAGroupDetail.isPSDEUIActionIdDirty()) {
            return null;
        }
        String string = pSDEUAGroupDetail.getPSDEUIActionId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEUIACTIONID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEUIActionId_Default(pSDEUAGroupDetail, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDynaInstId(boolean bl, PSDEUAGroupDetail pSDEUAGroupDetail, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEUAGroupDetail.isPSDynaInstIdDirty() : !pSDEUAGroupDetail.isPSDynaInstIdDirty()) {
            return null;
        }
        String string = pSDEUAGroupDetail.getPSDynaInstId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDynaInstId_Default(pSDEUAGroupDetail, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSSysCssId(boolean bl, PSDEUAGroupDetail pSDEUAGroupDetail, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEUAGroupDetail.isPSSysCssIdDirty() : !pSDEUAGroupDetail.isPSSysCssIdDirty()) {
            return null;
        }
        String string = pSDEUAGroupDetail.getPSSysCssId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysCssId_Default(pSDEUAGroupDetail, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSSysCssName(boolean bl, PSDEUAGroupDetail pSDEUAGroupDetail, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEUAGroupDetail.isPSSysCssNameDirty() : !pSDEUAGroupDetail.isPSSysCssNameDirty()) {
            return null;
        }
        String string = pSDEUAGroupDetail.getPSSysCssName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysCssName_Default(pSDEUAGroupDetail, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSSysImageId(boolean bl, PSDEUAGroupDetail pSDEUAGroupDetail, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEUAGroupDetail.isPSSysImageIdDirty() : !pSDEUAGroupDetail.isPSSysImageIdDirty()) {
            return null;
        }
        String string = pSDEUAGroupDetail.getPSSysImageId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysImageId_Default(pSDEUAGroupDetail, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSSysImageName(boolean bl, PSDEUAGroupDetail pSDEUAGroupDetail, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEUAGroupDetail.isPSSysImageNameDirty() : !pSDEUAGroupDetail.isPSSysImageNameDirty()) {
            return null;
        }
        String string = pSDEUAGroupDetail.getPSSysImageName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysImageName_Default(pSDEUAGroupDetail, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSIMAGENAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSysPFPluginId(boolean bl, PSDEUAGroupDetail pSDEUAGroupDetail, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEUAGroupDetail.isPSSysPFPluginIdDirty() : !pSDEUAGroupDetail.isPSSysPFPluginIdDirty()) {
            return null;
        }
        String string = pSDEUAGroupDetail.getPSSysPFPluginId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysPFPluginId_Default(pSDEUAGroupDetail, bl2, bl3);
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

    protected EntityFieldError onCheckField_RefPSDEUAGroupId(boolean bl, PSDEUAGroupDetail pSDEUAGroupDetail, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEUAGroupDetail.isRefPSDEUAGroupIdDirty() : !pSDEUAGroupDetail.isRefPSDEUAGroupIdDirty()) {
            return null;
        }
        String string = pSDEUAGroupDetail.getRefPSDEUAGroupId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_RefPSDEUAGroupId_Default(pSDEUAGroupDetail, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("REFPSDEUAGROUPID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ShowMode(boolean bl, PSDEUAGroupDetail pSDEUAGroupDetail, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEUAGroupDetail.isShowModeDirty() : !pSDEUAGroupDetail.isShowModeDirty()) {
            return null;
        }
        String string = pSDEUAGroupDetail.getShowMode();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_ShowMode_Default(pSDEUAGroupDetail, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("SHOWMODE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_UIActionParams(boolean bl, PSDEUAGroupDetail pSDEUAGroupDetail, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEUAGroupDetail.isUIActionParamsDirty() : !pSDEUAGroupDetail.isUIActionParamsDirty()) {
            return null;
        }
        String string = pSDEUAGroupDetail.getUIActionParams();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UIActionParams_Default(pSDEUAGroupDetail, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("UIACTIONPARAMS");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_UserCat(boolean bl, PSDEUAGroupDetail pSDEUAGroupDetail, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEUAGroupDetail.isUserCatDirty() : !pSDEUAGroupDetail.isUserCatDirty()) {
            return null;
        }
        String string = pSDEUAGroupDetail.getUserCat();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserCat_Default(pSDEUAGroupDetail, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag(boolean bl, PSDEUAGroupDetail pSDEUAGroupDetail, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEUAGroupDetail.isUserTagDirty() : !pSDEUAGroupDetail.isUserTagDirty()) {
            return null;
        }
        String string = pSDEUAGroupDetail.getUserTag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag_Default(pSDEUAGroupDetail, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag2(boolean bl, PSDEUAGroupDetail pSDEUAGroupDetail, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEUAGroupDetail.isUserTag2Dirty() : !pSDEUAGroupDetail.isUserTag2Dirty()) {
            return null;
        }
        String string = pSDEUAGroupDetail.getUserTag2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag2_Default(pSDEUAGroupDetail, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag3(boolean bl, PSDEUAGroupDetail pSDEUAGroupDetail, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEUAGroupDetail.isUserTag3Dirty() : !pSDEUAGroupDetail.isUserTag3Dirty()) {
            return null;
        }
        String string = pSDEUAGroupDetail.getUserTag3();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag3_Default(pSDEUAGroupDetail, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag4(boolean bl, PSDEUAGroupDetail pSDEUAGroupDetail, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEUAGroupDetail.isUserTag4Dirty() : !pSDEUAGroupDetail.isUserTag4Dirty()) {
            return null;
        }
        String string = pSDEUAGroupDetail.getUserTag4();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag4_Default(pSDEUAGroupDetail, bl2, bl3);
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

    protected EntityFieldError onCheckField_ValidFlag(boolean bl, PSDEUAGroupDetail pSDEUAGroupDetail, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEUAGroupDetail.isValidFlagDirty() : !pSDEUAGroupDetail.isValidFlagDirty()) {
            return null;
        }
        Integer n = pSDEUAGroupDetail.getValidFlag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_ValidFlag_Default(pSDEUAGroupDetail, bl2, bl3);
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

    protected EntityFieldError onCheckField_VisibleLogic(boolean bl, PSDEUAGroupDetail pSDEUAGroupDetail, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEUAGroupDetail.isVisibleLogicDirty() : !pSDEUAGroupDetail.isVisibleLogicDirty()) {
            return null;
        }
        String string = pSDEUAGroupDetail.getVisibleLogic();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_VisibleLogic_Default(pSDEUAGroupDetail, bl2, bl3);
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

    protected void onSyncEntity(PSDEUAGroupDetail pSDEUAGroupDetail, boolean bl) throws Exception {
        super.onSyncEntity(pSDEUAGroupDetail, bl);
    }

    protected void onSyncIndexEntities(PSDEUAGroupDetail pSDEUAGroupDetail, boolean bl) throws Exception {
        super.onSyncIndexEntities(pSDEUAGroupDetail, bl);
    }

    public Object getDataContextValue(PSDEUAGroupDetail pSDEUAGroupDetail, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null) {
            // empty if block
        }
        if ((object = super.getDataContextValue(pSDEUAGroupDetail, string, iDataContextParam)) != null) {
            return object;
        }
        PSDEUAGroup pSDEUAGroup = pSDEUAGroupDetail.getPSDEUAGroup();
        if (pSDEUAGroup != null && pSDEUAGroup.contains(string)) {
            return pSDEUAGroup.get(string);
        }
        PSDEUIAction pSDEUIAction = pSDEUAGroupDetail.getPSDEUAAction();
        if (pSDEUIAction != null && pSDEUIAction.contains(string)) {
            return pSDEUIAction.get(string);
        }
        return null;
    }

    protected void onExportMajorModel(PSDEUAGroupDetail pSDEUAGroupDetail, ArrayList<JSONObject> arrayList, int n) throws Exception {
        super.onExportMajorModel(pSDEUAGroupDetail, arrayList, n);
    }

    protected String onTestValueRule(String string, String string2, IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        if (StringHelper.compare((String)string, (String)"ACTIONLEVEL", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ActionLevel_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ADDSEPARATOR", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_AddSeparator_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"AFTERCONTENT", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_AfterContent_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"AFTERITEMTYPE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_AfterItemType_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"AFTERPSSYSCSSID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_AfterPSSysCssId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"AFTERPSSYSCSSNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_AfterPSSysCssName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"AFTERPSSYSRESOURCEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_AfterPSSysResourceId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"AFTERPSSYSRESOURCENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_AfterPSSysResourceName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"BEFORECONTENT", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_BeforeContent_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"BEFOREITEMTYPE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_BeforeItemType_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"BEFOREPSSYSCSSID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_BeforePSSysCssId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"BEFOREPSSYSCSSNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_BeforePSSysCssName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"BEFOREPSSYSRESOURCEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_BeforePSSysResourceId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"BEFOREPSSYSRESOURCENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_BeforePSSysResourceName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"BUTTONSTYLE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ButtonStyle_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CODENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CodeName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATEDATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateDate_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATEMAN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateMan_Default(iEntity, bl, bl2);
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
        if (StringHelper.compare((String)string, (String)"ENABLELOGIC", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_EnableLogic_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MEMO", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Memo_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ORDERVALUE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_OrderValue_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEUAGROUPID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEUAGroupId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEUAGROUPNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEUAGroupName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEUAGRPDETAILID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEUAGRPDetailId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEUAGRPDETAILNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEUAGRPDetailName_Default(iEntity, bl, bl2);
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
        if (StringHelper.compare((String)string, (String)"PSSYSPFPLUGINID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysPFPluginId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSPFPLUGINNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysPFPluginName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"REFPSDEUAGROUPID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_RefPSDEUAGroupId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"REFPSDEUAGROUPNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_RefPSDEUAGroupName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"SHOWMODE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ShowMode_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UACAPTION", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UACaption_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UIACTIONPARAMS", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UIActionParams_Default(iEntity, bl, bl2);
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
        if (StringHelper.compare((String)string, (String)"VISIBLELOGIC", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_VisibleLogic_Default(iEntity, bl, bl2);
        }
        return super.onTestValueRule(string, string2, iEntity, bl, bl2);
    }

    protected String onTestValueRule_ActionLevel_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_AddSeparator_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_AfterContent_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("AFTERCONTENT", iEntity, bl2, null, false, 0x100000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_AfterItemType_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("AFTERITEMTYPE", iEntity, bl2, null, false, 20, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[20]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[20]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_AfterPSSysCssId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("AFTERPSSYSCSSID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_AfterPSSysCssName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("AFTERPSSYSCSSNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_AfterPSSysResourceId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("AFTERPSSYSRESOURCEID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_AfterPSSysResourceName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("AFTERPSSYSRESOURCENAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_BeforeContent_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("BEFORECONTENT", iEntity, bl2, null, false, 0x100000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_BeforeItemType_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("BEFOREITEMTYPE", iEntity, bl2, null, false, 20, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[20]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[20]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_BeforePSSysCssId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("BEFOREPSSYSCSSID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_BeforePSSysCssName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("BEFOREPSSYSCSSNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_BeforePSSysResourceId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("BEFOREPSSYSRESOURCEID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_BeforePSSysResourceName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("BEFOREPSSYSRESOURCENAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_ButtonStyle_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("BUTTONSTYLE", iEntity, bl2, null, false, 30, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
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

    protected String onTestValueRule_DynaModelFlag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
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

    protected String onTestValueRule_PSDEUAGRPDetailId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEUAGRPDETAILID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDEUAGRPDetailName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEUAGRPDETAILNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
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

    protected String onTestValueRule_RefPSDEUAGroupId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("REFPSDEUAGROUPID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_RefPSDEUAGroupName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("REFPSDEUAGROUPNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_ShowMode_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("SHOWMODE", iEntity, bl2, null, false, 30, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_UACaption_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("UACAPTION", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_UIActionParams_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("UIACTIONPARAMS", iEntity, bl2, null, false, 2000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[2000]", false)) {
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

    @Override
    protected boolean isPrepareLastForUpdate() {
        return true;
    }

    protected boolean onMergeChild(String string, String string2, PSDEUAGroupDetail pSDEUAGroupDetail) throws Exception {
        boolean bl = false;
        if (super.onMergeChild(string, string2, pSDEUAGroupDetail)) {
            bl = true;
        }
        return bl;
    }

    protected void onUpdateParent(PSDEUAGroupDetail pSDEUAGroupDetail) throws Exception {
        super.onUpdateParent(pSDEUAGroupDetail);
    }

    @Override
    protected void exportCurXmlModel(PSDEUAGroupDetail pSDEUAGroupDetail, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSDEUAGROUPDETAIL");
        if (!bl) {
            pSDEUAGroupDetail.setPSDEId(null);
            pSDEUAGroupDetail.setPSDEUAGroupId(null);
            pSDEUAGroupDetail.setPSDEUAGroupName(null);
            super.exportCurXmlModel(pSDEUAGroupDetail, xmlNode, bl);
        }
    }

    @Override
    public ObjectNode fillModelV2(ObjectNode objectNode, PSDEUAGroupDetail pSDEUAGroupDetail, String string) throws Exception {
        objectNode = super.fillModelV2(objectNode, pSDEUAGroupDetail, string);
        return objectNode;
    }

    @Override
    public String getModelV2ResScope(IEntity iEntity) throws Exception {
        String string = null;
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSDEUAGROUPID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return StringHelper.format((String)"PSDEUAGROUP#%1$s", (Object)string);
        }
        return super.getModelV2ResScope(iEntity);
    }

    @Override
    public String getModelV2ResScopeDER(IEntity iEntity) throws Exception {
        String string = null;
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSDEUAGROUPID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return "DER1N_PSDEUAGRPDETAIL_PSDEUAGROUP_PSDEUAGROUPID";
        }
        return super.getModelV2ResScopeDER(iEntity);
    }

    @Override
    public String getModelV2ResScopeText(IEntity iEntity) throws Exception {
        String string = null;
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSDEUAGROUPID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return DataObject.getStringValue((IDataObject)iEntity, (String)"PSDEUAGROUPNAME", null);
        }
        return super.getModelV2ResScopeText(iEntity);
    }

    @Override
    public boolean setModelV2ResScope(IEntity iEntity, String string, String string2) throws Exception {
        if (StringHelper.compare((String)string, (String)"PSDEUAGROUP", (boolean)true) == 0) {
            iEntity.set("PSDEUAGROUPID", (Object)string2);
            return true;
        }
        return super.setModelV2ResScope(iEntity, string, string2);
    }

    @Override
    public String[] getModelV2ResScopeFields() throws Exception {
        return new String[]{"PSDEUAGROUPID"};
    }

    @Override
    public String getModelV2Tag(PSDEUAGroupDetail pSDEUAGroupDetail) {
        if (!StringHelper.isNullOrEmpty((String)pSDEUAGroupDetail.getCodeName())) {
            return pSDEUAGroupDetail.getCodeName();
        }
        if (!StringHelper.isNullOrEmpty((String)pSDEUAGroupDetail.getCodeName())) {
            return pSDEUAGroupDetail.getCodeName();
        }
        return super.getModelV2Tag(pSDEUAGroupDetail);
    }

    @Override
    public boolean setModelV2Tag(PSDEUAGroupDetail pSDEUAGroupDetail, String string) {
        pSDEUAGroupDetail.setCodeName(string);
        return true;
    }

    @Override
    public Map<String, String> getListDRDataFolderFields(Map<String, String> map, PSMOSFile pSMOSFile, IPSMOSFileFilter iPSMOSFileFilter) throws Exception {
        if (map == null) {
            map = new HashMap<String, String>();
        }
        map.put("CODENAME", "");
        map.put("CODENAME", "");
        map.put("PSDEUAGROUPID", "");
        return super.getListDRDataFolderFields(map, pSMOSFile, iPSMOSFileFilter);
    }

    @Override
    public boolean getModelV2Entity(PSDEUAGroupDetail pSDEUAGroupDetail, String string) throws Exception {
        SimpleEntity simpleEntity = new SimpleEntity();
        pSDEUAGroupDetail.copyTo((IDataObject)simpleEntity, false);
        simpleEntity.copyTo((IDataObject)pSDEUAGroupDetail, true);
        pSDEUAGroupDetail.set("CODENAME", string);
        if (this.select(pSDEUAGroupDetail, true)) {
            return true;
        }
        simpleEntity.copyTo((IDataObject)pSDEUAGroupDetail, true);
        return super.getModelV2Entity(pSDEUAGroupDetail, string);
    }

    @Override
    protected boolean testCompileCurModelV2(PSDEUAGroupDetail pSDEUAGroupDetail, ObjectNode objectNode, String string, String string2, int n) throws Exception {
        if (n == 1) {
            return false;
        }
        return super.testCompileCurModelV2(pSDEUAGroupDetail, objectNode, string, string2, n);
    }
}

