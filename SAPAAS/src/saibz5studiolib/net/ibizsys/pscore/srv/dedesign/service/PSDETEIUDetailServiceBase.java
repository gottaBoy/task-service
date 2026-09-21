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
import net.ibizsys.pscore.srv.dedesign.dao.PSDETEIUDetailDAO;
import net.ibizsys.pscore.srv.dedesign.demodel.PSDETEIUDetailDEModel;
import net.ibizsys.pscore.srv.dedesign.entity.PSDETEIUDetail;
import net.ibizsys.pscore.srv.dedesign.entity.PSDETEIUpdate;
import net.ibizsys.pscore.srv.dedesign.entity.PSDETEIUpdateBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDETreeNodeCol;
import net.ibizsys.pscore.srv.dedesign.entity.PSDETreeNodeColBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDETreeView;
import net.ibizsys.pscore.srv.dedesign.entity.PSDETreeViewBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSystem;
import net.ibizsys.pscore.srv.sysdevstudio.entity.PSMOSFile;
import net.ibizsys.pscore.srv.util.IPSMOSFileFilter;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDETEIUDetailServiceBase
extends PSCoreSysServiceBase<PSDETEIUDetail> {
    private static final Log log = LogFactory.getLog(PSDETEIUDetailServiceBase.class);
    public static final String DATASET_DEFAULT = "DEFAULT";
    private PSDETEIUDetailDEModel pSDETEIUDetailDEModel;
    private PSDETEIUDetailDAO pSDETEIUDetailDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.dedesign.service.PSDETEIUDetailService";
    }

    public PSDETEIUDetailDEModel getPSDETEIUDetailDEModel() {
        if (this.pSDETEIUDetailDEModel == null) {
            try {
                this.pSDETEIUDetailDEModel = (PSDETEIUDetailDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.dedesign.demodel.PSDETEIUDetailDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDETEIUDetailDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSDETEIUDetailDEModel();
    }

    public PSDETEIUDetailDAO getPSDETEIUDetailDAO() {
        if (this.pSDETEIUDetailDAO == null) {
            try {
                this.pSDETEIUDetailDAO = (PSDETEIUDetailDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.dedesign.dao.PSDETEIUDetailDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDETEIUDetailDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSDETEIUDetailDAO();
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

    protected void onFillParentInfo(PSDETEIUDetail pSDETEIUDetail, String string, String string2, String string3) throws Exception {
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDETEIUDETAIL_PSDETEIUPDATE_PSDETEIUPDATEID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDETEIUpdateService", (SessionFactory)this.getSessionFactory());
            PSDETEIUpdate pSDETEIUpdate = (PSDETEIUpdate)iService.getDEModel().createEntity();
            pSDETEIUpdate.set("PSDETEIUPDATEID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDETEIUpdate);
            } else {
                iService.get((IEntity)pSDETEIUpdate);
            }
            this.onFillParentInfo_PSDETEIUpdate(pSDETEIUDetail, pSDETEIUpdate);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDETEIUDETAIL_PSDETREENODECOL_PSDETREENODECOLID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDETreeNodeColService", (SessionFactory)this.getSessionFactory());
            PSDETreeNodeCol pSDETreeNodeCol = (PSDETreeNodeCol)iService.getDEModel().createEntity();
            pSDETreeNodeCol.set("PSDETREENODECOLID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDETreeNodeCol);
            } else {
                iService.get((IEntity)pSDETreeNodeCol);
            }
            this.onFillParentInfo_PSDETreeNodeCol(pSDETEIUDetail, pSDETreeNodeCol);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDETEIUDETAIL_PSDETREEVIEW_PSDETREEVIEWID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDETreeViewService", (SessionFactory)this.getSessionFactory());
            PSDETreeView pSDETreeView = (PSDETreeView)iService.getDEModel().createEntity();
            pSDETreeView.set("PSDETREEVIEWID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDETreeView);
            } else {
                iService.get((IEntity)pSDETreeView);
            }
            this.onFillParentInfo_PSDETreeView(pSDETEIUDetail, pSDETreeView);
            return;
        }
        super.onFillParentInfo((IEntity)pSDETEIUDetail, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        if (StringHelper.compare((String)string, (String)"DER1N_PSDETEIUDETAIL_PSDETREEVIEW_PSDETREEVIEWID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDETreeViewService", (SessionFactory)this.getSessionFactory());
            PSDETreeView pSDETreeView = (PSDETreeView)iService.getDEModel().createEntity();
            pSDETreeView.set("PSDETREEVIEWID", string2);
            return this.onSyncDER1NData_PSDETreeView(pSDETreeView, string3);
        }
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillParentInfo_PSDETEIUpdate(PSDETEIUDetail pSDETEIUDetail, PSDETEIUpdate pSDETEIUpdate) throws Exception {
        pSDETEIUDetail.setPSDETEIUpdateId(pSDETEIUpdate.getPSDETEIUpdateId());
        pSDETEIUDetail.setPSDETEIUpdateName(pSDETEIUpdate.getPSDETEIUpdateName());
        pSDETEIUDetail.setPSDETreeNodeId(pSDETEIUpdate.getPSDETreeNodeId());
        if (pSDETEIUpdate.getPSDETreeView() != null) {
            this.onFillParentInfo_PSDETreeView(pSDETEIUDetail, pSDETEIUpdate.getPSDETreeView());
        }
    }

    protected void onFillParentInfo_PSDETreeNodeCol(PSDETEIUDetail pSDETEIUDetail, PSDETreeNodeCol pSDETreeNodeCol) throws Exception {
        pSDETEIUDetail.setPSDETreeNodeColId(pSDETreeNodeCol.getPSDETreeNodeColId());
        pSDETEIUDetail.setPSDETreeNodeColName(pSDETreeNodeCol.getPSDETreeNodeColName());
        if (pSDETreeNodeCol.getPSDETreeView() != null) {
            this.onFillParentInfo_PSDETreeView(pSDETEIUDetail, pSDETreeNodeCol.getPSDETreeView());
        }
    }

    protected void onFillParentInfo_PSDETreeView(PSDETEIUDetail pSDETEIUDetail, PSDETreeView pSDETreeView) throws Exception {
        pSDETEIUDetail.setPSDETreeViewId(pSDETreeView.getPSDETreeViewId());
        pSDETEIUDetail.setPSDETreeViewName(pSDETreeView.getPSDETreeViewName());
    }

    protected String onSyncDER1NData_PSDETreeView(PSDETreeView pSDETreeView, String string) throws Exception {
        if (StringHelper.isNullOrEmpty((String)string)) {
            this.removeByPSDETreeView(pSDETreeView);
        } else {
            HashMap<String, String> hashMap = new HashMap<String, String>();
            String[] stringArray = StringHelper.splitEx((String)string);
            if (stringArray != null) {
                for (int i = 0; i < stringArray.length; ++i) {
                    if (StringHelper.isNullOrEmpty((String)stringArray[i])) continue;
                    hashMap.put(stringArray[i], "");
                }
            }
            ArrayList<PSDETEIUDetail> arrayList = this.selectByPSDETreeView(pSDETreeView);
            for (PSDETEIUDetail pSDETEIUDetail : arrayList) {
                if (hashMap.containsKey(DataObject.getStringValue((IDataObject)pSDETEIUDetail, (String)"PSDETEIUDETAILID", (String)""))) continue;
                this.remove((IEntity)pSDETEIUDetail);
            }
        }
        return null;
    }

    protected boolean onFillEntityKeyValue(PSDETEIUDetail pSDETEIUDetail, boolean bl) throws Exception {
        StringBuilderEx stringBuilderEx = new StringBuilderEx();
        Object object = pSDETEIUDetail.get("PSDETEIUPDATEID");
        if (object == null) {
            object = "__EMTPY__";
        }
        stringBuilderEx.append("%1$s", object);
        stringBuilderEx.append("||");
        Object object2 = pSDETEIUDetail.get("PSDETREENODECOLID");
        if (object2 == null) {
            object2 = "__EMTPY__";
        }
        stringBuilderEx.append("%1$s", object2);
        String string = stringBuilderEx.toString();
        pSDETEIUDetail.set(this.getPSDETEIUDetailDEModel().getKeyDEField().getName(), KeyValueHelper.genUniqueId((String)string));
        return true;
    }

    protected void onFillEntityFullInfo(PSDETEIUDetail pSDETEIUDetail, boolean bl) throws Exception {
        if (bl) {
            // empty if block
        }
        super.onFillEntityFullInfo((IEntity)pSDETEIUDetail, bl);
        this.onFillEntityFullInfo_PSDETEIUpdate(pSDETEIUDetail, bl);
        this.onFillEntityFullInfo_PSDETreeNodeCol(pSDETEIUDetail, bl);
        this.onFillEntityFullInfo_PSDETreeView(pSDETEIUDetail, bl);
    }

    protected void onFillEntityFullInfo_PSDETEIUpdate(PSDETEIUDetail pSDETEIUDetail, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSDETreeNodeCol(PSDETEIUDetail pSDETEIUDetail, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSDETreeView(PSDETEIUDetail pSDETEIUDetail, boolean bl) throws Exception {
    }

    protected void onWriteBackParent(PSDETEIUDetail pSDETEIUDetail, boolean bl) throws Exception {
        super.onWriteBackParent((IEntity)pSDETEIUDetail, bl);
    }

    public ArrayList<PSDETEIUDetail> selectByPSDETEIUpdate(PSDETEIUpdateBase pSDETEIUpdateBase) throws Exception {
        return this.selectByPSDETEIUpdate(pSDETEIUpdateBase, "", -1);
    }

    public ArrayList<PSDETEIUDetail> selectByPSDETEIUpdate(PSDETEIUpdateBase pSDETEIUpdateBase, String string) throws Exception {
        return this.selectByPSDETEIUpdate(pSDETEIUpdateBase, string, -1);
    }

    public ArrayList<PSDETEIUDetail> selectByPSDETEIUpdate(PSDETEIUpdateBase pSDETEIUpdateBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDETEIUPDATEID", (Object)pSDETEIUpdateBase.getPSDETEIUpdateId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSDETEIUpdateCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSDETEIUpdateCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDETEIUDetail> selectTempByPSDETEIUpdate(PSDETEIUpdateBase pSDETEIUpdateBase) throws Exception {
        return this.selectTempByPSDETEIUpdate(pSDETEIUpdateBase, "");
    }

    public ArrayList<PSDETEIUDetail> selectTempByPSDETEIUpdate(PSDETEIUpdateBase pSDETEIUpdateBase, String string) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDETEIUPDATEID", (Object)pSDETEIUpdateBase.getPSDETEIUpdateId());
        selectCond.setOrderInfo(string);
        this.onFillSelectTempByPSDETEIUpdateCond(selectCond);
        return this.selectTemp((ISelectCond)selectCond);
    }

    protected void onFillSelectTempByPSDETEIUpdateCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDETEIUDetail> selectByPSDETreeNodeCol(PSDETreeNodeColBase pSDETreeNodeColBase) throws Exception {
        return this.selectByPSDETreeNodeCol(pSDETreeNodeColBase, "", -1);
    }

    public ArrayList<PSDETEIUDetail> selectByPSDETreeNodeCol(PSDETreeNodeColBase pSDETreeNodeColBase, String string) throws Exception {
        return this.selectByPSDETreeNodeCol(pSDETreeNodeColBase, string, -1);
    }

    public ArrayList<PSDETEIUDetail> selectByPSDETreeNodeCol(PSDETreeNodeColBase pSDETreeNodeColBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDETREENODECOLID", (Object)pSDETreeNodeColBase.getPSDETreeNodeColId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSDETreeNodeColCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSDETreeNodeColCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDETEIUDetail> selectTempByPSDETreeNodeCol(PSDETreeNodeColBase pSDETreeNodeColBase) throws Exception {
        return this.selectTempByPSDETreeNodeCol(pSDETreeNodeColBase, "");
    }

    public ArrayList<PSDETEIUDetail> selectTempByPSDETreeNodeCol(PSDETreeNodeColBase pSDETreeNodeColBase, String string) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDETREENODECOLID", (Object)pSDETreeNodeColBase.getPSDETreeNodeColId());
        selectCond.setOrderInfo(string);
        this.onFillSelectTempByPSDETreeNodeColCond(selectCond);
        return this.selectTemp((ISelectCond)selectCond);
    }

    protected void onFillSelectTempByPSDETreeNodeColCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDETEIUDetail> selectByPSDETreeView(PSDETreeViewBase pSDETreeViewBase) throws Exception {
        return this.selectByPSDETreeView(pSDETreeViewBase, "", -1);
    }

    public ArrayList<PSDETEIUDetail> selectByPSDETreeView(PSDETreeViewBase pSDETreeViewBase, String string) throws Exception {
        return this.selectByPSDETreeView(pSDETreeViewBase, string, -1);
    }

    public ArrayList<PSDETEIUDetail> selectByPSDETreeView(PSDETreeViewBase pSDETreeViewBase, String string, int n) throws Exception {
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

    public ArrayList<PSDETEIUDetail> selectTempByPSDETreeView(PSDETreeViewBase pSDETreeViewBase) throws Exception {
        return this.selectTempByPSDETreeView(pSDETreeViewBase, "");
    }

    public ArrayList<PSDETEIUDetail> selectTempByPSDETreeView(PSDETreeViewBase pSDETreeViewBase, String string) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDETREEVIEWID", (Object)pSDETreeViewBase.getPSDETreeViewId());
        selectCond.setOrderInfo(string);
        this.onFillSelectTempByPSDETreeViewCond(selectCond);
        return this.selectTemp((ISelectCond)selectCond);
    }

    protected void onFillSelectTempByPSDETreeViewCond(SelectCond selectCond) throws Exception {
    }

    public void testRemoveByPSDETEIUpdate(PSDETEIUpdate pSDETEIUpdate) throws Exception {
    }

    public void resetPSDETEIUpdate(PSDETEIUpdate pSDETEIUpdate) throws Exception {
        ArrayList<PSDETEIUDetail> arrayList = this.selectByPSDETEIUpdate(pSDETEIUpdate);
        for (PSDETEIUDetail pSDETEIUDetail : arrayList) {
            PSDETEIUDetail pSDETEIUDetail2 = (PSDETEIUDetail)this.getDEModel().createEntity();
            pSDETEIUDetail2.setPSDETEIUDetailId(pSDETEIUDetail.getPSDETEIUDetailId());
            pSDETEIUDetail2.setPSDETEIUpdateId(null);
            this.update(pSDETEIUDetail2);
        }
    }

    public void resetTempPSDETEIUpdate(PSDETEIUpdate pSDETEIUpdate) throws Exception {
        ArrayList<PSDETEIUDetail> arrayList = this.selectTempByPSDETEIUpdate(pSDETEIUpdate);
        for (PSDETEIUDetail pSDETEIUDetail : arrayList) {
            PSDETEIUDetail pSDETEIUDetail2 = (PSDETEIUDetail)this.getDEModel().createEntity();
            pSDETEIUDetail2.setPSDETEIUDetailId(pSDETEIUDetail.getPSDETEIUDetailId());
            pSDETEIUDetail2.setPSDETEIUpdateId(null);
            this.updateTemp((IEntity)pSDETEIUDetail2);
        }
    }

    public void removeByPSDETEIUpdate(PSDETEIUpdate pSDETEIUpdate) throws Exception {
        final PSDETEIUpdate pSDETEIUpdate2 = pSDETEIUpdate;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDETEIUDetailServiceBase.this.onBeforeRemoveByPSDETEIUpdate(pSDETEIUpdate2);
                PSDETEIUDetailServiceBase.this.internalRemoveByPSDETEIUpdate(pSDETEIUpdate2);
                PSDETEIUDetailServiceBase.this.onAfterRemoveByPSDETEIUpdate(pSDETEIUpdate2);
            }
        });
    }

    protected void onBeforeRemoveByPSDETEIUpdate(PSDETEIUpdate pSDETEIUpdate) throws Exception {
    }

    protected void internalRemoveByPSDETEIUpdate(PSDETEIUpdate pSDETEIUpdate) throws Exception {
        ArrayList<PSDETEIUDetail> arrayList = this.selectByPSDETEIUpdate(pSDETEIUpdate);
        this.onBeforeRemoveByPSDETEIUpdate(pSDETEIUpdate, arrayList);
        for (PSDETEIUDetail pSDETEIUDetail : arrayList) {
            this.remove((IEntity)pSDETEIUDetail);
        }
        this.onAfterRemoveByPSDETEIUpdate(pSDETEIUpdate, arrayList);
    }

    protected void onAfterRemoveByPSDETEIUpdate(PSDETEIUpdate pSDETEIUpdate) throws Exception {
    }

    protected void onBeforeRemoveByPSDETEIUpdate(PSDETEIUpdate pSDETEIUpdate, ArrayList<PSDETEIUDetail> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDETEIUpdate(PSDETEIUpdate pSDETEIUpdate, ArrayList<PSDETEIUDetail> arrayList) throws Exception {
    }

    public void testRemoveByPSDETreeNodeCol(PSDETreeNodeCol pSDETreeNodeCol) throws Exception {
        ArrayList<PSDETEIUDetail> arrayList = this.selectByPSDETreeNodeCol(pSDETreeNodeCol, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDETREENODECOL");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDETreeNodeCol);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDETEIUDETAIL_PSDETREENODECOL_PSDETREENODECOLID", "", iDataEntityModel.getName(), "PSDETEIUDETAIL", iDataEntityModel.getDataInfo((IEntity)pSDETreeNodeCol), arrayList.get(0)));
        }
    }

    public void resetPSDETreeNodeCol(PSDETreeNodeCol pSDETreeNodeCol) throws Exception {
        ArrayList<PSDETEIUDetail> arrayList = this.selectByPSDETreeNodeCol(pSDETreeNodeCol);
        for (PSDETEIUDetail pSDETEIUDetail : arrayList) {
            PSDETEIUDetail pSDETEIUDetail2 = (PSDETEIUDetail)this.getDEModel().createEntity();
            pSDETEIUDetail2.setPSDETEIUDetailId(pSDETEIUDetail.getPSDETEIUDetailId());
            pSDETEIUDetail2.setPSDETreeNodeColId(null);
            this.update(pSDETEIUDetail2);
        }
    }

    public void resetTempPSDETreeNodeCol(PSDETreeNodeCol pSDETreeNodeCol) throws Exception {
        ArrayList<PSDETEIUDetail> arrayList = this.selectTempByPSDETreeNodeCol(pSDETreeNodeCol);
        for (PSDETEIUDetail pSDETEIUDetail : arrayList) {
            PSDETEIUDetail pSDETEIUDetail2 = (PSDETEIUDetail)this.getDEModel().createEntity();
            pSDETEIUDetail2.setPSDETEIUDetailId(pSDETEIUDetail.getPSDETEIUDetailId());
            pSDETEIUDetail2.setPSDETreeNodeColId(null);
            this.updateTemp((IEntity)pSDETEIUDetail2);
        }
    }

    public void removeByPSDETreeNodeCol(PSDETreeNodeCol pSDETreeNodeCol) throws Exception {
        final PSDETreeNodeCol pSDETreeNodeCol2 = pSDETreeNodeCol;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDETEIUDetailServiceBase.this.onBeforeRemoveByPSDETreeNodeCol(pSDETreeNodeCol2);
                PSDETEIUDetailServiceBase.this.internalRemoveByPSDETreeNodeCol(pSDETreeNodeCol2);
                PSDETEIUDetailServiceBase.this.onAfterRemoveByPSDETreeNodeCol(pSDETreeNodeCol2);
            }
        });
    }

    protected void onBeforeRemoveByPSDETreeNodeCol(PSDETreeNodeCol pSDETreeNodeCol) throws Exception {
    }

    protected void internalRemoveByPSDETreeNodeCol(PSDETreeNodeCol pSDETreeNodeCol) throws Exception {
        ArrayList<PSDETEIUDetail> arrayList = this.selectByPSDETreeNodeCol(pSDETreeNodeCol);
        this.onBeforeRemoveByPSDETreeNodeCol(pSDETreeNodeCol, arrayList);
        for (PSDETEIUDetail pSDETEIUDetail : arrayList) {
            this.remove((IEntity)pSDETEIUDetail);
        }
        this.onAfterRemoveByPSDETreeNodeCol(pSDETreeNodeCol, arrayList);
    }

    protected void onAfterRemoveByPSDETreeNodeCol(PSDETreeNodeCol pSDETreeNodeCol) throws Exception {
    }

    protected void onBeforeRemoveByPSDETreeNodeCol(PSDETreeNodeCol pSDETreeNodeCol, ArrayList<PSDETEIUDetail> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDETreeNodeCol(PSDETreeNodeCol pSDETreeNodeCol, ArrayList<PSDETEIUDetail> arrayList) throws Exception {
    }

    public void testRemoveByPSDETreeView(PSDETreeView pSDETreeView) throws Exception {
    }

    public void resetPSDETreeView(PSDETreeView pSDETreeView) throws Exception {
        ArrayList<PSDETEIUDetail> arrayList = this.selectByPSDETreeView(pSDETreeView);
        for (PSDETEIUDetail pSDETEIUDetail : arrayList) {
            PSDETEIUDetail pSDETEIUDetail2 = (PSDETEIUDetail)this.getDEModel().createEntity();
            pSDETEIUDetail2.setPSDETEIUDetailId(pSDETEIUDetail.getPSDETEIUDetailId());
            pSDETEIUDetail2.setPSDETreeViewId(null);
            this.update(pSDETEIUDetail2);
        }
    }

    public void resetTempPSDETreeView(PSDETreeView pSDETreeView) throws Exception {
        ArrayList<PSDETEIUDetail> arrayList = this.selectTempByPSDETreeView(pSDETreeView);
        for (PSDETEIUDetail pSDETEIUDetail : arrayList) {
            PSDETEIUDetail pSDETEIUDetail2 = (PSDETEIUDetail)this.getDEModel().createEntity();
            pSDETEIUDetail2.setPSDETEIUDetailId(pSDETEIUDetail.getPSDETEIUDetailId());
            pSDETEIUDetail2.setPSDETreeViewId(null);
            this.updateTemp((IEntity)pSDETEIUDetail2);
        }
    }

    public void removeByPSDETreeView(PSDETreeView pSDETreeView) throws Exception {
        final PSDETreeView pSDETreeView2 = pSDETreeView;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDETEIUDetailServiceBase.this.onBeforeRemoveByPSDETreeView(pSDETreeView2);
                PSDETEIUDetailServiceBase.this.internalRemoveByPSDETreeView(pSDETreeView2);
                PSDETEIUDetailServiceBase.this.onAfterRemoveByPSDETreeView(pSDETreeView2);
            }
        });
    }

    protected void onBeforeRemoveByPSDETreeView(PSDETreeView pSDETreeView) throws Exception {
    }

    protected void internalRemoveByPSDETreeView(PSDETreeView pSDETreeView) throws Exception {
        ArrayList<PSDETEIUDetail> arrayList = this.selectByPSDETreeView(pSDETreeView);
        this.onBeforeRemoveByPSDETreeView(pSDETreeView, arrayList);
        for (PSDETEIUDetail pSDETEIUDetail : arrayList) {
            this.remove((IEntity)pSDETEIUDetail);
        }
        this.onAfterRemoveByPSDETreeView(pSDETreeView, arrayList);
    }

    protected void onAfterRemoveByPSDETreeView(PSDETreeView pSDETreeView) throws Exception {
    }

    protected void onBeforeRemoveByPSDETreeView(PSDETreeView pSDETreeView, ArrayList<PSDETEIUDetail> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDETreeView(PSDETreeView pSDETreeView, ArrayList<PSDETEIUDetail> arrayList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(PSDETEIUDetail pSDETEIUDetail) throws Exception {
        super.onBeforeRemove(pSDETEIUDetail);
    }

    public void removeTempByPSDETreeNodeCol(PSDETreeNodeCol pSDETreeNodeCol) throws Exception {
        final PSDETreeNodeCol pSDETreeNodeCol2 = pSDETreeNodeCol;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDETEIUDetailServiceBase.this.onBeforeRemoveTempByPSDETreeNodeCol(pSDETreeNodeCol2);
                PSDETEIUDetailServiceBase.this.internalRemoveTempByPSDETreeNodeCol(pSDETreeNodeCol2);
                PSDETEIUDetailServiceBase.this.onAfterRemoveTempByPSDETreeNodeCol(pSDETreeNodeCol2);
            }
        });
    }

    protected void onBeforeRemoveTempByPSDETreeNodeCol(PSDETreeNodeCol pSDETreeNodeCol) throws Exception {
    }

    protected void internalRemoveTempByPSDETreeNodeCol(PSDETreeNodeCol pSDETreeNodeCol) throws Exception {
        ArrayList<PSDETEIUDetail> arrayList = this.selectTempByPSDETreeNodeCol(pSDETreeNodeCol);
        this.onBeforeRemoveTempByPSDETreeNodeCol(pSDETreeNodeCol, arrayList);
        for (PSDETEIUDetail pSDETEIUDetail : arrayList) {
            this.removeTemp((IEntity)pSDETEIUDetail);
        }
        this.onAfterRemoveTempByPSDETreeNodeCol(pSDETreeNodeCol, arrayList);
    }

    protected void onAfterRemoveTempByPSDETreeNodeCol(PSDETreeNodeCol pSDETreeNodeCol) throws Exception {
    }

    protected void onBeforeRemoveTempByPSDETreeNodeCol(PSDETreeNodeCol pSDETreeNodeCol, ArrayList<PSDETEIUDetail> arrayList) throws Exception {
    }

    protected void onAfterRemoveTempByPSDETreeNodeCol(PSDETreeNodeCol pSDETreeNodeCol, ArrayList<PSDETEIUDetail> arrayList) throws Exception {
    }

    public void removeTempByPSDETEIUpdate(PSDETEIUpdate pSDETEIUpdate) throws Exception {
        final PSDETEIUpdate pSDETEIUpdate2 = pSDETEIUpdate;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDETEIUDetailServiceBase.this.onBeforeRemoveTempByPSDETEIUpdate(pSDETEIUpdate2);
                PSDETEIUDetailServiceBase.this.internalRemoveTempByPSDETEIUpdate(pSDETEIUpdate2);
                PSDETEIUDetailServiceBase.this.onAfterRemoveTempByPSDETEIUpdate(pSDETEIUpdate2);
            }
        });
    }

    protected void onBeforeRemoveTempByPSDETEIUpdate(PSDETEIUpdate pSDETEIUpdate) throws Exception {
    }

    protected void internalRemoveTempByPSDETEIUpdate(PSDETEIUpdate pSDETEIUpdate) throws Exception {
        ArrayList<PSDETEIUDetail> arrayList = this.selectTempByPSDETEIUpdate(pSDETEIUpdate);
        this.onBeforeRemoveTempByPSDETEIUpdate(pSDETEIUpdate, arrayList);
        for (PSDETEIUDetail pSDETEIUDetail : arrayList) {
            this.removeTemp((IEntity)pSDETEIUDetail);
        }
        this.onAfterRemoveTempByPSDETEIUpdate(pSDETEIUpdate, arrayList);
    }

    protected void onAfterRemoveTempByPSDETEIUpdate(PSDETEIUpdate pSDETEIUpdate) throws Exception {
    }

    protected void onBeforeRemoveTempByPSDETEIUpdate(PSDETEIUpdate pSDETEIUpdate, ArrayList<PSDETEIUDetail> arrayList) throws Exception {
    }

    protected void onAfterRemoveTempByPSDETEIUpdate(PSDETEIUpdate pSDETEIUpdate, ArrayList<PSDETEIUDetail> arrayList) throws Exception {
    }

    public void removeTempByPSDETreeView(PSDETreeView pSDETreeView) throws Exception {
        final PSDETreeView pSDETreeView2 = pSDETreeView;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDETEIUDetailServiceBase.this.onBeforeRemoveTempByPSDETreeView(pSDETreeView2);
                PSDETEIUDetailServiceBase.this.internalRemoveTempByPSDETreeView(pSDETreeView2);
                PSDETEIUDetailServiceBase.this.onAfterRemoveTempByPSDETreeView(pSDETreeView2);
            }
        });
    }

    protected void onBeforeRemoveTempByPSDETreeView(PSDETreeView pSDETreeView) throws Exception {
    }

    protected void internalRemoveTempByPSDETreeView(PSDETreeView pSDETreeView) throws Exception {
        ArrayList<PSDETEIUDetail> arrayList = this.selectTempByPSDETreeView(pSDETreeView);
        this.onBeforeRemoveTempByPSDETreeView(pSDETreeView, arrayList);
        for (PSDETEIUDetail pSDETEIUDetail : arrayList) {
            this.removeTemp((IEntity)pSDETEIUDetail);
        }
        this.onAfterRemoveTempByPSDETreeView(pSDETreeView, arrayList);
    }

    protected void onAfterRemoveTempByPSDETreeView(PSDETreeView pSDETreeView) throws Exception {
    }

    protected void onBeforeRemoveTempByPSDETreeView(PSDETreeView pSDETreeView, ArrayList<PSDETEIUDetail> arrayList) throws Exception {
    }

    protected void onAfterRemoveTempByPSDETreeView(PSDETreeView pSDETreeView, ArrayList<PSDETEIUDetail> arrayList) throws Exception {
    }

    protected void replaceParentInfo(PSDETEIUDetail pSDETEIUDetail, CloneSession cloneSession) throws Exception {
        IEntity iEntity;
        super.replaceParentInfo((IEntity)pSDETEIUDetail, cloneSession);
        if (pSDETEIUDetail.getPSDETEIUpdateId() != null && (iEntity = cloneSession.getEntity("PSDETEIUPDATE", (Object)pSDETEIUDetail.getPSDETEIUpdateId())) != null) {
            this.onFillParentInfo_PSDETEIUpdate(pSDETEIUDetail, (PSDETEIUpdate)iEntity);
        }
        if (pSDETEIUDetail.getPSDETreeNodeColId() != null && (iEntity = cloneSession.getEntity("PSDETREENODECOL", (Object)pSDETEIUDetail.getPSDETreeNodeColId())) != null) {
            this.onFillParentInfo_PSDETreeNodeCol(pSDETEIUDetail, (PSDETreeNodeCol)iEntity);
        }
        if (pSDETEIUDetail.getPSDETreeViewId() != null && (iEntity = cloneSession.getEntity("PSDETREEVIEW", (Object)pSDETEIUDetail.getPSDETreeViewId())) != null) {
            this.onFillParentInfo_PSDETreeView(pSDETEIUDetail, (PSDETreeView)iEntity);
        }
    }

    protected void onRemoveEntityUncopyValues(PSDETEIUDetail pSDETEIUDetail, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues((IEntity)pSDETEIUDetail, bl);
    }

    protected void onCheckEntity(boolean bl, PSDETEIUDetail pSDETEIUDetail, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_PSDETEIUDetailId(bl, pSDETEIUDetail, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDETEIUDetailName(bl, pSDETEIUDetail, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDETEIUpdateId(bl, pSDETEIUDetail, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDETreeNodeColId(bl, pSDETEIUDetail, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDETreeViewId(bl, pSDETEIUDetail, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, (IEntity)pSDETEIUDetail, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_PSDETEIUDetailId(boolean bl, PSDETEIUDetail pSDETEIUDetail, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDETEIUDetail.isPSDETEIUDetailIdDirty() && !bl2 : !pSDETEIUDetail.isPSDETEIUDetailIdDirty()) {
            return null;
        }
        String string = pSDETEIUDetail.getPSDETEIUDetailId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDETEIUDETAILID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDETEIUDetailId_Default((IEntity)pSDETEIUDetail, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDETEIUDETAILID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDETEIUDetailName(boolean bl, PSDETEIUDetail pSDETEIUDetail, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDETEIUDetail.isPSDETEIUDetailNameDirty() : !pSDETEIUDetail.isPSDETEIUDetailNameDirty()) {
            return null;
        }
        String string = pSDETEIUDetail.getPSDETEIUDetailName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDETEIUDetailName_Default((IEntity)pSDETEIUDetail, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDETEIUDETAILNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDETEIUpdateId(boolean bl, PSDETEIUDetail pSDETEIUDetail, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDETEIUDetail.isPSDETEIUpdateIdDirty() && !bl2 : !pSDETEIUDetail.isPSDETEIUpdateIdDirty()) {
            return null;
        }
        String string = pSDETEIUDetail.getPSDETEIUpdateId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDETEIUPDATEID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDETEIUpdateId_Default((IEntity)pSDETEIUDetail, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDETEIUPDATEID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDETreeNodeColId(boolean bl, PSDETEIUDetail pSDETEIUDetail, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDETEIUDetail.isPSDETreeNodeColIdDirty() && !bl2 : !pSDETEIUDetail.isPSDETreeNodeColIdDirty()) {
            return null;
        }
        String string = pSDETEIUDetail.getPSDETreeNodeColId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDETREENODECOLID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDETreeNodeColId_Default((IEntity)pSDETEIUDetail, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDETREENODECOLID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDETreeViewId(boolean bl, PSDETEIUDetail pSDETEIUDetail, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDETEIUDetail.isPSDETreeViewIdDirty() : !pSDETEIUDetail.isPSDETreeViewIdDirty()) {
            return null;
        }
        String string = pSDETEIUDetail.getPSDETreeViewId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDETreeViewId_Default((IEntity)pSDETEIUDetail, bl2, bl3);
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

    protected void onSyncEntity(PSDETEIUDetail pSDETEIUDetail, boolean bl) throws Exception {
        super.onSyncEntity((IEntity)pSDETEIUDetail, bl);
    }

    protected void onSyncIndexEntities(PSDETEIUDetail pSDETEIUDetail, boolean bl) throws Exception {
        super.onSyncIndexEntities((IEntity)pSDETEIUDetail, bl);
    }

    public Object getDataContextValue(PSDETEIUDetail pSDETEIUDetail, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null) {
            // empty if block
        }
        if ((object = super.getDataContextValue((IEntity)pSDETEIUDetail, string, iDataContextParam)) != null) {
            return object;
        }
        PSDETEIUpdate pSDETEIUpdate = pSDETEIUDetail.getPSDETEIUpdate();
        if (pSDETEIUpdate != null && pSDETEIUpdate.contains(string)) {
            return pSDETEIUpdate.get(string);
        }
        PSDETreeNodeCol pSDETreeNodeCol = pSDETEIUDetail.getPSDETreeNodeCol();
        if (pSDETreeNodeCol != null && pSDETreeNodeCol.contains(string)) {
            return pSDETreeNodeCol.get(string);
        }
        return null;
    }

    protected void onExportMajorModel(PSDETEIUDetail pSDETEIUDetail, ArrayList<JSONObject> arrayList, int n) throws Exception {
        super.onExportMajorModel((IEntity)pSDETEIUDetail, arrayList, n);
    }

    protected String onTestValueRule(String string, String string2, IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        if (StringHelper.compare((String)string, (String)"CREATEDATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateDate_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATEMAN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateMan_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDETEIUDETAILID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDETEIUDetailId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDETEIUDETAILNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDETEIUDetailName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDETEIUPDATEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDETEIUpdateId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDETEIUPDATENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDETEIUpdateName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDETREENODECOLID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDETreeNodeColId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDETREENODECOLNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDETreeNodeColName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDETREENODEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDETreeNodeId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDETREEVIEWID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDETreeViewId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDETREEVIEWNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDETreeViewName_Default(iEntity, bl, bl2);
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

    protected String onTestValueRule_PSDETEIUDetailId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDETEIUDETAILID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDETEIUDetailName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDETEIUDETAILNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDETEIUpdateId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDETEIUPDATEID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDETEIUpdateName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDETEIUPDATENAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDETreeNodeColId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDETREENODECOLID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDETreeNodeColName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDETREENODECOLNAME", iEntity, bl2, null, false, 20, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[20]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[20]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDETreeNodeId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDETREENODEID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
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

    protected boolean onMergeChild(String string, String string2, PSDETEIUDetail pSDETEIUDetail) throws Exception {
        boolean bl = false;
        if (super.onMergeChild(string, string2, (IEntity)pSDETEIUDetail)) {
            bl = true;
        }
        return bl;
    }

    protected void onUpdateParent(PSDETEIUDetail pSDETEIUDetail) throws Exception {
        super.onUpdateParent((IEntity)pSDETEIUDetail);
    }

    @Override
    protected void exportCurXmlModel(PSDETEIUDetail pSDETEIUDetail, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSDETEIUDETAIL");
        if (!bl) {
            pSDETEIUDetail.setCreateDate(null);
            pSDETEIUDetail.setCreateMan(null);
            pSDETEIUDetail.setPSDETEIUDetailId(null);
            pSDETEIUDetail.setUpdateDate(null);
            pSDETEIUDetail.setUpdateMan(null);
            pSDETEIUDetail.setPSDETreeNodeColId(null);
            pSDETEIUDetail.setPSDETEIUpdateId(null);
            pSDETEIUDetail.setPSDETEIUpdateName(null);
            pSDETEIUDetail.setPSDETreeNodeId(null);
            pSDETEIUDetail.setPSDETreeViewId(null);
            pSDETEIUDetail.setPSDETreeViewName(null);
            super.exportCurXmlModel(pSDETEIUDetail, xmlNode, bl);
        }
    }

    @Override
    protected String getEntityFolderKeyValue(PSDETEIUDetail pSDETEIUDetail, PSSystem pSSystem) throws Exception {
        PSDETEIUDetail pSDETEIUDetail2 = new PSDETEIUDetail();
        pSDETEIUDetail2.setPSDETEIUpdateId(pSDETEIUDetail.getPSDETEIUpdateId());
        pSDETEIUDetail2.setPSDETreeNodeColId(pSDETEIUDetail.getPSDETreeNodeColId());
        if (this.selectOne((IEntity)pSDETEIUDetail2, true)) {
            return pSDETEIUDetail2.getPSDETEIUDetailId();
        }
        return super.getEntityFolderKeyValue(pSDETEIUDetail, pSSystem);
    }

    @Override
    public ObjectNode fillModelV2(ObjectNode objectNode, PSDETEIUDetail pSDETEIUDetail, String string) throws Exception {
        objectNode = super.fillModelV2(objectNode, pSDETEIUDetail, string);
        return objectNode;
    }

    @Override
    public String getModelV2ResScope(IEntity iEntity) throws Exception {
        String string = null;
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSDETEIUPDATEID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return StringHelper.format((String)"PSDETEIUPDATE#%1$s", (Object)string);
        }
        return super.getModelV2ResScope(iEntity);
    }

    @Override
    public String getModelV2ResScopeDER(IEntity iEntity) throws Exception {
        String string = null;
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSDETEIUPDATEID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return "DER1N_PSDETEIUDETAIL_PSDETEIUPDATE_PSDETEIUPDATEID";
        }
        return super.getModelV2ResScopeDER(iEntity);
    }

    @Override
    public String getModelV2ResScopeText(IEntity iEntity) throws Exception {
        String string = null;
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSDETEIUPDATEID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return DataObject.getStringValue((IDataObject)iEntity, (String)"PSDETEIUPDATENAME", null);
        }
        return super.getModelV2ResScopeText(iEntity);
    }

    @Override
    public boolean setModelV2ResScope(IEntity iEntity, String string, String string2) throws Exception {
        if (StringHelper.compare((String)string, (String)"PSDETEIUPDATE", (boolean)true) == 0) {
            iEntity.set("PSDETEIUPDATEID", (Object)string2);
            return true;
        }
        return super.setModelV2ResScope(iEntity, string, string2);
    }

    @Override
    public String[] getModelV2ResScopeFields() throws Exception {
        return new String[]{"PSDETEIUPDATEID"};
    }

    @Override
    public String getModelV2Tag(PSDETEIUDetail pSDETEIUDetail) {
        return super.getModelV2Tag(pSDETEIUDetail);
    }

    @Override
    public boolean setModelV2Tag(PSDETEIUDetail pSDETEIUDetail, String string) {
        return super.setModelV2Tag(pSDETEIUDetail, string);
    }

    @Override
    public Map<String, String> getListDRDataFolderFields(Map<String, String> map, PSMOSFile pSMOSFile, IPSMOSFileFilter iPSMOSFileFilter) throws Exception {
        if (map == null) {
            map = new HashMap<String, String>();
        }
        map.put("PSDETEIUPDATEID", "");
        return super.getListDRDataFolderFields(map, pSMOSFile, iPSMOSFileFilter);
    }

    @Override
    public boolean getModelV2Entity(PSDETEIUDetail pSDETEIUDetail, String string) throws Exception {
        SimpleEntity simpleEntity = new SimpleEntity();
        pSDETEIUDetail.copyTo((IDataObject)simpleEntity, false);
        simpleEntity.copyTo((IDataObject)pSDETEIUDetail, true);
        return super.getModelV2Entity(pSDETEIUDetail, string);
    }

    @Override
    protected boolean testCompileCurModelV2(PSDETEIUDetail pSDETEIUDetail, ObjectNode objectNode, String string, String string2, int n) throws Exception {
        if (n == 1) {
            return false;
        }
        return super.testCompileCurModelV2(pSDETEIUDetail, objectNode, string, string2, n);
    }
}

