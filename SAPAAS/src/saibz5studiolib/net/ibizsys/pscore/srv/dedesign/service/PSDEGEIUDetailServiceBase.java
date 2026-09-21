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
import net.ibizsys.pscore.srv.dedesign.dao.PSDEGEIUDetailDAO;
import net.ibizsys.pscore.srv.dedesign.demodel.PSDEGEIUDetailDEModel;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEGEIUDetail;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEGEIUpdate;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEGEIUpdateBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEGrid;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEGridBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEGridCol;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEGridColBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSystem;
import net.ibizsys.pscore.srv.sysdevstudio.entity.PSMOSFile;
import net.ibizsys.pscore.srv.util.IPSMOSFileFilter;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDEGEIUDetailServiceBase
extends PSCoreSysServiceBase<PSDEGEIUDetail> {
    private static final Log log = LogFactory.getLog(PSDEGEIUDetailServiceBase.class);
    public static final String DATASET_DEFAULT = "DEFAULT";
    private PSDEGEIUDetailDEModel pSDEGEIUDetailDEModel;
    private PSDEGEIUDetailDAO pSDEGEIUDetailDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.dedesign.service.PSDEGEIUDetailService";
    }

    public PSDEGEIUDetailDEModel getPSDEGEIUDetailDEModel() {
        if (this.pSDEGEIUDetailDEModel == null) {
            try {
                this.pSDEGEIUDetailDEModel = (PSDEGEIUDetailDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.dedesign.demodel.PSDEGEIUDetailDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDEGEIUDetailDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSDEGEIUDetailDEModel();
    }

    public PSDEGEIUDetailDAO getPSDEGEIUDetailDAO() {
        if (this.pSDEGEIUDetailDAO == null) {
            try {
                this.pSDEGEIUDetailDAO = (PSDEGEIUDetailDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.dedesign.dao.PSDEGEIUDetailDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDEGEIUDetailDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSDEGEIUDetailDAO();
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

    protected void onFillParentInfo(PSDEGEIUDetail pSDEGEIUDetail, String string, String string2, String string3) throws Exception {
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEGEIUDETAIL_PSDEGEIUPDATE_PSDEGEIUPDATEID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEGEIUpdateService", (SessionFactory)this.getSessionFactory());
            PSDEGEIUpdate pSDEGEIUpdate = (PSDEGEIUpdate)iService.getDEModel().createEntity();
            pSDEGEIUpdate.set("PSDEGEIUPDATEID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDEGEIUpdate);
            } else {
                iService.get((IEntity)pSDEGEIUpdate);
            }
            this.onFillParentInfo_PSDEGEIUpdate(pSDEGEIUDetail, pSDEGEIUpdate);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEGEIUDETAIL_PSDEGRIDCOL_PSDEGRIDCOLID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEGridColService", (SessionFactory)this.getSessionFactory());
            PSDEGridCol pSDEGridCol = (PSDEGridCol)iService.getDEModel().createEntity();
            pSDEGridCol.set("PSDEGRIDCOLID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDEGridCol);
            } else {
                iService.get((IEntity)pSDEGridCol);
            }
            this.onFillParentInfo_PSDEGridCol(pSDEGEIUDetail, pSDEGridCol);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEGEIUDETAIL_PSDEGRID_PSDEGRIDID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEGridService", (SessionFactory)this.getSessionFactory());
            PSDEGrid pSDEGrid = (PSDEGrid)iService.getDEModel().createEntity();
            pSDEGrid.set("PSDEGRIDID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDEGrid);
            } else {
                iService.get((IEntity)pSDEGrid);
            }
            this.onFillParentInfo_PSDEGrid(pSDEGEIUDetail, pSDEGrid);
            return;
        }
        super.onFillParentInfo((IEntity)pSDEGEIUDetail, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        if (StringHelper.compare((String)string, (String)"DER1N_PSDEGEIUDETAIL_PSDEGRID_PSDEGRIDID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEGridService", (SessionFactory)this.getSessionFactory());
            PSDEGrid pSDEGrid = (PSDEGrid)iService.getDEModel().createEntity();
            pSDEGrid.set("PSDEGRIDID", string2);
            return this.onSyncDER1NData_PSDEGrid(pSDEGrid, string3);
        }
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillParentInfo_PSDEGEIUpdate(PSDEGEIUDetail pSDEGEIUDetail, PSDEGEIUpdate pSDEGEIUpdate) throws Exception {
        pSDEGEIUDetail.setPSDEGEIUpdateId(pSDEGEIUpdate.getPSDEGEIUpdateId());
        pSDEGEIUDetail.setPSDEGEIUpdateName(pSDEGEIUpdate.getPSDEGEIUpdateName());
        if (pSDEGEIUpdate.getPSDEGrid() != null) {
            this.onFillParentInfo_PSDEGrid(pSDEGEIUDetail, pSDEGEIUpdate.getPSDEGrid());
        }
    }

    protected void onFillParentInfo_PSDEGridCol(PSDEGEIUDetail pSDEGEIUDetail, PSDEGridCol pSDEGridCol) throws Exception {
        pSDEGEIUDetail.setPSDEGridColId(pSDEGridCol.getPSDEGridColId());
        pSDEGEIUDetail.setPSDEGridColName(pSDEGridCol.getPSDEGridColName());
        if (pSDEGridCol.getPSDEGrid() != null) {
            this.onFillParentInfo_PSDEGrid(pSDEGEIUDetail, pSDEGridCol.getPSDEGrid());
        }
    }

    protected void onFillParentInfo_PSDEGrid(PSDEGEIUDetail pSDEGEIUDetail, PSDEGrid pSDEGrid) throws Exception {
        pSDEGEIUDetail.setPSDEGridId(pSDEGrid.getPSDEGridId());
        pSDEGEIUDetail.setPSDEGridName(pSDEGrid.getPSDEGridName());
    }

    protected String onSyncDER1NData_PSDEGrid(PSDEGrid pSDEGrid, String string) throws Exception {
        if (StringHelper.isNullOrEmpty((String)string)) {
            this.removeByPSDEGrid(pSDEGrid);
        } else {
            HashMap<String, String> hashMap = new HashMap<String, String>();
            String[] stringArray = StringHelper.splitEx((String)string);
            if (stringArray != null) {
                for (int i = 0; i < stringArray.length; ++i) {
                    if (StringHelper.isNullOrEmpty((String)stringArray[i])) continue;
                    hashMap.put(stringArray[i], "");
                }
            }
            ArrayList<PSDEGEIUDetail> arrayList = this.selectByPSDEGrid(pSDEGrid);
            for (PSDEGEIUDetail pSDEGEIUDetail : arrayList) {
                if (hashMap.containsKey(DataObject.getStringValue((IDataObject)pSDEGEIUDetail, (String)"PSDEGEIUDETAILID", (String)""))) continue;
                this.remove((IEntity)pSDEGEIUDetail);
            }
        }
        return null;
    }

    protected boolean onFillEntityKeyValue(PSDEGEIUDetail pSDEGEIUDetail, boolean bl) throws Exception {
        StringBuilderEx stringBuilderEx = new StringBuilderEx();
        Object object = pSDEGEIUDetail.get("PSDEGEIUPDATEID");
        if (object == null) {
            object = "__EMTPY__";
        }
        stringBuilderEx.append("%1$s", object);
        stringBuilderEx.append("||");
        Object object2 = pSDEGEIUDetail.get("PSDEGRIDCOLID");
        if (object2 == null) {
            object2 = "__EMTPY__";
        }
        stringBuilderEx.append("%1$s", object2);
        String string = stringBuilderEx.toString();
        pSDEGEIUDetail.set(this.getPSDEGEIUDetailDEModel().getKeyDEField().getName(), KeyValueHelper.genUniqueId((String)string));
        return true;
    }

    protected void onFillEntityFullInfo(PSDEGEIUDetail pSDEGEIUDetail, boolean bl) throws Exception {
        if (bl) {
            // empty if block
        }
        super.onFillEntityFullInfo((IEntity)pSDEGEIUDetail, bl);
        this.onFillEntityFullInfo_PSDEGEIUpdate(pSDEGEIUDetail, bl);
        this.onFillEntityFullInfo_PSDEGridCol(pSDEGEIUDetail, bl);
        this.onFillEntityFullInfo_PSDEGrid(pSDEGEIUDetail, bl);
    }

    protected void onFillEntityFullInfo_PSDEGEIUpdate(PSDEGEIUDetail pSDEGEIUDetail, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSDEGridCol(PSDEGEIUDetail pSDEGEIUDetail, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSDEGrid(PSDEGEIUDetail pSDEGEIUDetail, boolean bl) throws Exception {
    }

    protected void onWriteBackParent(PSDEGEIUDetail pSDEGEIUDetail, boolean bl) throws Exception {
        super.onWriteBackParent((IEntity)pSDEGEIUDetail, bl);
    }

    public ArrayList<PSDEGEIUDetail> selectByPSDEGEIUpdate(PSDEGEIUpdateBase pSDEGEIUpdateBase) throws Exception {
        return this.selectByPSDEGEIUpdate(pSDEGEIUpdateBase, "", -1);
    }

    public ArrayList<PSDEGEIUDetail> selectByPSDEGEIUpdate(PSDEGEIUpdateBase pSDEGEIUpdateBase, String string) throws Exception {
        return this.selectByPSDEGEIUpdate(pSDEGEIUpdateBase, string, -1);
    }

    public ArrayList<PSDEGEIUDetail> selectByPSDEGEIUpdate(PSDEGEIUpdateBase pSDEGEIUpdateBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDEGEIUPDATEID", (Object)pSDEGEIUpdateBase.getPSDEGEIUpdateId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSDEGEIUpdateCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSDEGEIUpdateCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDEGEIUDetail> selectTempByPSDEGEIUpdate(PSDEGEIUpdateBase pSDEGEIUpdateBase) throws Exception {
        return this.selectTempByPSDEGEIUpdate(pSDEGEIUpdateBase, "");
    }

    public ArrayList<PSDEGEIUDetail> selectTempByPSDEGEIUpdate(PSDEGEIUpdateBase pSDEGEIUpdateBase, String string) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDEGEIUPDATEID", (Object)pSDEGEIUpdateBase.getPSDEGEIUpdateId());
        selectCond.setOrderInfo(string);
        this.onFillSelectTempByPSDEGEIUpdateCond(selectCond);
        return this.selectTemp((ISelectCond)selectCond);
    }

    protected void onFillSelectTempByPSDEGEIUpdateCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDEGEIUDetail> selectByPSDEGridCol(PSDEGridColBase pSDEGridColBase) throws Exception {
        return this.selectByPSDEGridCol(pSDEGridColBase, "", -1);
    }

    public ArrayList<PSDEGEIUDetail> selectByPSDEGridCol(PSDEGridColBase pSDEGridColBase, String string) throws Exception {
        return this.selectByPSDEGridCol(pSDEGridColBase, string, -1);
    }

    public ArrayList<PSDEGEIUDetail> selectByPSDEGridCol(PSDEGridColBase pSDEGridColBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDEGRIDCOLID", (Object)pSDEGridColBase.getPSDEGridColId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSDEGridColCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSDEGridColCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDEGEIUDetail> selectTempByPSDEGridCol(PSDEGridColBase pSDEGridColBase) throws Exception {
        return this.selectTempByPSDEGridCol(pSDEGridColBase, "");
    }

    public ArrayList<PSDEGEIUDetail> selectTempByPSDEGridCol(PSDEGridColBase pSDEGridColBase, String string) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDEGRIDCOLID", (Object)pSDEGridColBase.getPSDEGridColId());
        selectCond.setOrderInfo(string);
        this.onFillSelectTempByPSDEGridColCond(selectCond);
        return this.selectTemp((ISelectCond)selectCond);
    }

    protected void onFillSelectTempByPSDEGridColCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDEGEIUDetail> selectByPSDEGrid(PSDEGridBase pSDEGridBase) throws Exception {
        return this.selectByPSDEGrid(pSDEGridBase, "", -1);
    }

    public ArrayList<PSDEGEIUDetail> selectByPSDEGrid(PSDEGridBase pSDEGridBase, String string) throws Exception {
        return this.selectByPSDEGrid(pSDEGridBase, string, -1);
    }

    public ArrayList<PSDEGEIUDetail> selectByPSDEGrid(PSDEGridBase pSDEGridBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDEGRIDID", (Object)pSDEGridBase.getPSDEGridId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSDEGridCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSDEGridCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDEGEIUDetail> selectTempByPSDEGrid(PSDEGridBase pSDEGridBase) throws Exception {
        return this.selectTempByPSDEGrid(pSDEGridBase, "");
    }

    public ArrayList<PSDEGEIUDetail> selectTempByPSDEGrid(PSDEGridBase pSDEGridBase, String string) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDEGRIDID", (Object)pSDEGridBase.getPSDEGridId());
        selectCond.setOrderInfo(string);
        this.onFillSelectTempByPSDEGridCond(selectCond);
        return this.selectTemp((ISelectCond)selectCond);
    }

    protected void onFillSelectTempByPSDEGridCond(SelectCond selectCond) throws Exception {
    }

    public void testRemoveByPSDEGEIUpdate(PSDEGEIUpdate pSDEGEIUpdate) throws Exception {
    }

    public void resetPSDEGEIUpdate(PSDEGEIUpdate pSDEGEIUpdate) throws Exception {
        ArrayList<PSDEGEIUDetail> arrayList = this.selectByPSDEGEIUpdate(pSDEGEIUpdate);
        for (PSDEGEIUDetail pSDEGEIUDetail : arrayList) {
            PSDEGEIUDetail pSDEGEIUDetail2 = (PSDEGEIUDetail)this.getDEModel().createEntity();
            pSDEGEIUDetail2.setPSDEGEIUDetailId(pSDEGEIUDetail.getPSDEGEIUDetailId());
            pSDEGEIUDetail2.setPSDEGEIUpdateId(null);
            this.update(pSDEGEIUDetail2);
        }
    }

    public void resetTempPSDEGEIUpdate(PSDEGEIUpdate pSDEGEIUpdate) throws Exception {
        ArrayList<PSDEGEIUDetail> arrayList = this.selectTempByPSDEGEIUpdate(pSDEGEIUpdate);
        for (PSDEGEIUDetail pSDEGEIUDetail : arrayList) {
            PSDEGEIUDetail pSDEGEIUDetail2 = (PSDEGEIUDetail)this.getDEModel().createEntity();
            pSDEGEIUDetail2.setPSDEGEIUDetailId(pSDEGEIUDetail.getPSDEGEIUDetailId());
            pSDEGEIUDetail2.setPSDEGEIUpdateId(null);
            this.updateTemp((IEntity)pSDEGEIUDetail2);
        }
    }

    public void removeByPSDEGEIUpdate(PSDEGEIUpdate pSDEGEIUpdate) throws Exception {
        final PSDEGEIUpdate pSDEGEIUpdate2 = pSDEGEIUpdate;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEGEIUDetailServiceBase.this.onBeforeRemoveByPSDEGEIUpdate(pSDEGEIUpdate2);
                PSDEGEIUDetailServiceBase.this.internalRemoveByPSDEGEIUpdate(pSDEGEIUpdate2);
                PSDEGEIUDetailServiceBase.this.onAfterRemoveByPSDEGEIUpdate(pSDEGEIUpdate2);
            }
        });
    }

    protected void onBeforeRemoveByPSDEGEIUpdate(PSDEGEIUpdate pSDEGEIUpdate) throws Exception {
    }

    protected void internalRemoveByPSDEGEIUpdate(PSDEGEIUpdate pSDEGEIUpdate) throws Exception {
        ArrayList<PSDEGEIUDetail> arrayList = this.selectByPSDEGEIUpdate(pSDEGEIUpdate);
        this.onBeforeRemoveByPSDEGEIUpdate(pSDEGEIUpdate, arrayList);
        for (PSDEGEIUDetail pSDEGEIUDetail : arrayList) {
            this.remove((IEntity)pSDEGEIUDetail);
        }
        this.onAfterRemoveByPSDEGEIUpdate(pSDEGEIUpdate, arrayList);
    }

    protected void onAfterRemoveByPSDEGEIUpdate(PSDEGEIUpdate pSDEGEIUpdate) throws Exception {
    }

    protected void onBeforeRemoveByPSDEGEIUpdate(PSDEGEIUpdate pSDEGEIUpdate, ArrayList<PSDEGEIUDetail> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDEGEIUpdate(PSDEGEIUpdate pSDEGEIUpdate, ArrayList<PSDEGEIUDetail> arrayList) throws Exception {
    }

    public void testRemoveByPSDEGridCol(PSDEGridCol pSDEGridCol) throws Exception {
        ArrayList<PSDEGEIUDetail> arrayList = this.selectByPSDEGridCol(pSDEGridCol, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEGRIDCOL");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDEGridCol);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEGEIUDETAIL_PSDEGRIDCOL_PSDEGRIDCOLID", "", iDataEntityModel.getName(), "PSDEGEIUDETAIL", iDataEntityModel.getDataInfo((IEntity)pSDEGridCol), arrayList.get(0)));
        }
    }

    public void resetPSDEGridCol(PSDEGridCol pSDEGridCol) throws Exception {
        ArrayList<PSDEGEIUDetail> arrayList = this.selectByPSDEGridCol(pSDEGridCol);
        for (PSDEGEIUDetail pSDEGEIUDetail : arrayList) {
            PSDEGEIUDetail pSDEGEIUDetail2 = (PSDEGEIUDetail)this.getDEModel().createEntity();
            pSDEGEIUDetail2.setPSDEGEIUDetailId(pSDEGEIUDetail.getPSDEGEIUDetailId());
            pSDEGEIUDetail2.setPSDEGridColId(null);
            this.update(pSDEGEIUDetail2);
        }
    }

    public void resetTempPSDEGridCol(PSDEGridCol pSDEGridCol) throws Exception {
        ArrayList<PSDEGEIUDetail> arrayList = this.selectTempByPSDEGridCol(pSDEGridCol);
        for (PSDEGEIUDetail pSDEGEIUDetail : arrayList) {
            PSDEGEIUDetail pSDEGEIUDetail2 = (PSDEGEIUDetail)this.getDEModel().createEntity();
            pSDEGEIUDetail2.setPSDEGEIUDetailId(pSDEGEIUDetail.getPSDEGEIUDetailId());
            pSDEGEIUDetail2.setPSDEGridColId(null);
            this.updateTemp((IEntity)pSDEGEIUDetail2);
        }
    }

    public void removeByPSDEGridCol(PSDEGridCol pSDEGridCol) throws Exception {
        final PSDEGridCol pSDEGridCol2 = pSDEGridCol;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEGEIUDetailServiceBase.this.onBeforeRemoveByPSDEGridCol(pSDEGridCol2);
                PSDEGEIUDetailServiceBase.this.internalRemoveByPSDEGridCol(pSDEGridCol2);
                PSDEGEIUDetailServiceBase.this.onAfterRemoveByPSDEGridCol(pSDEGridCol2);
            }
        });
    }

    protected void onBeforeRemoveByPSDEGridCol(PSDEGridCol pSDEGridCol) throws Exception {
    }

    protected void internalRemoveByPSDEGridCol(PSDEGridCol pSDEGridCol) throws Exception {
        ArrayList<PSDEGEIUDetail> arrayList = this.selectByPSDEGridCol(pSDEGridCol);
        this.onBeforeRemoveByPSDEGridCol(pSDEGridCol, arrayList);
        for (PSDEGEIUDetail pSDEGEIUDetail : arrayList) {
            this.remove((IEntity)pSDEGEIUDetail);
        }
        this.onAfterRemoveByPSDEGridCol(pSDEGridCol, arrayList);
    }

    protected void onAfterRemoveByPSDEGridCol(PSDEGridCol pSDEGridCol) throws Exception {
    }

    protected void onBeforeRemoveByPSDEGridCol(PSDEGridCol pSDEGridCol, ArrayList<PSDEGEIUDetail> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDEGridCol(PSDEGridCol pSDEGridCol, ArrayList<PSDEGEIUDetail> arrayList) throws Exception {
    }

    public void testRemoveByPSDEGrid(PSDEGrid pSDEGrid) throws Exception {
    }

    public void resetPSDEGrid(PSDEGrid pSDEGrid) throws Exception {
        ArrayList<PSDEGEIUDetail> arrayList = this.selectByPSDEGrid(pSDEGrid);
        for (PSDEGEIUDetail pSDEGEIUDetail : arrayList) {
            PSDEGEIUDetail pSDEGEIUDetail2 = (PSDEGEIUDetail)this.getDEModel().createEntity();
            pSDEGEIUDetail2.setPSDEGEIUDetailId(pSDEGEIUDetail.getPSDEGEIUDetailId());
            pSDEGEIUDetail2.setPSDEGridId(null);
            this.update(pSDEGEIUDetail2);
        }
    }

    public void resetTempPSDEGrid(PSDEGrid pSDEGrid) throws Exception {
        ArrayList<PSDEGEIUDetail> arrayList = this.selectTempByPSDEGrid(pSDEGrid);
        for (PSDEGEIUDetail pSDEGEIUDetail : arrayList) {
            PSDEGEIUDetail pSDEGEIUDetail2 = (PSDEGEIUDetail)this.getDEModel().createEntity();
            pSDEGEIUDetail2.setPSDEGEIUDetailId(pSDEGEIUDetail.getPSDEGEIUDetailId());
            pSDEGEIUDetail2.setPSDEGridId(null);
            this.updateTemp((IEntity)pSDEGEIUDetail2);
        }
    }

    public void removeByPSDEGrid(PSDEGrid pSDEGrid) throws Exception {
        final PSDEGrid pSDEGrid2 = pSDEGrid;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEGEIUDetailServiceBase.this.onBeforeRemoveByPSDEGrid(pSDEGrid2);
                PSDEGEIUDetailServiceBase.this.internalRemoveByPSDEGrid(pSDEGrid2);
                PSDEGEIUDetailServiceBase.this.onAfterRemoveByPSDEGrid(pSDEGrid2);
            }
        });
    }

    protected void onBeforeRemoveByPSDEGrid(PSDEGrid pSDEGrid) throws Exception {
    }

    protected void internalRemoveByPSDEGrid(PSDEGrid pSDEGrid) throws Exception {
        ArrayList<PSDEGEIUDetail> arrayList = this.selectByPSDEGrid(pSDEGrid);
        this.onBeforeRemoveByPSDEGrid(pSDEGrid, arrayList);
        for (PSDEGEIUDetail pSDEGEIUDetail : arrayList) {
            this.remove((IEntity)pSDEGEIUDetail);
        }
        this.onAfterRemoveByPSDEGrid(pSDEGrid, arrayList);
    }

    protected void onAfterRemoveByPSDEGrid(PSDEGrid pSDEGrid) throws Exception {
    }

    protected void onBeforeRemoveByPSDEGrid(PSDEGrid pSDEGrid, ArrayList<PSDEGEIUDetail> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDEGrid(PSDEGrid pSDEGrid, ArrayList<PSDEGEIUDetail> arrayList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(PSDEGEIUDetail pSDEGEIUDetail) throws Exception {
        super.onBeforeRemove(pSDEGEIUDetail);
    }

    public void removeTempByPSDEGridCol(PSDEGridCol pSDEGridCol) throws Exception {
        final PSDEGridCol pSDEGridCol2 = pSDEGridCol;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEGEIUDetailServiceBase.this.onBeforeRemoveTempByPSDEGridCol(pSDEGridCol2);
                PSDEGEIUDetailServiceBase.this.internalRemoveTempByPSDEGridCol(pSDEGridCol2);
                PSDEGEIUDetailServiceBase.this.onAfterRemoveTempByPSDEGridCol(pSDEGridCol2);
            }
        });
    }

    protected void onBeforeRemoveTempByPSDEGridCol(PSDEGridCol pSDEGridCol) throws Exception {
    }

    protected void internalRemoveTempByPSDEGridCol(PSDEGridCol pSDEGridCol) throws Exception {
        ArrayList<PSDEGEIUDetail> arrayList = this.selectTempByPSDEGridCol(pSDEGridCol);
        this.onBeforeRemoveTempByPSDEGridCol(pSDEGridCol, arrayList);
        for (PSDEGEIUDetail pSDEGEIUDetail : arrayList) {
            this.removeTemp((IEntity)pSDEGEIUDetail);
        }
        this.onAfterRemoveTempByPSDEGridCol(pSDEGridCol, arrayList);
    }

    protected void onAfterRemoveTempByPSDEGridCol(PSDEGridCol pSDEGridCol) throws Exception {
    }

    protected void onBeforeRemoveTempByPSDEGridCol(PSDEGridCol pSDEGridCol, ArrayList<PSDEGEIUDetail> arrayList) throws Exception {
    }

    protected void onAfterRemoveTempByPSDEGridCol(PSDEGridCol pSDEGridCol, ArrayList<PSDEGEIUDetail> arrayList) throws Exception {
    }

    public void removeTempByPSDEGEIUpdate(PSDEGEIUpdate pSDEGEIUpdate) throws Exception {
        final PSDEGEIUpdate pSDEGEIUpdate2 = pSDEGEIUpdate;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEGEIUDetailServiceBase.this.onBeforeRemoveTempByPSDEGEIUpdate(pSDEGEIUpdate2);
                PSDEGEIUDetailServiceBase.this.internalRemoveTempByPSDEGEIUpdate(pSDEGEIUpdate2);
                PSDEGEIUDetailServiceBase.this.onAfterRemoveTempByPSDEGEIUpdate(pSDEGEIUpdate2);
            }
        });
    }

    protected void onBeforeRemoveTempByPSDEGEIUpdate(PSDEGEIUpdate pSDEGEIUpdate) throws Exception {
    }

    protected void internalRemoveTempByPSDEGEIUpdate(PSDEGEIUpdate pSDEGEIUpdate) throws Exception {
        ArrayList<PSDEGEIUDetail> arrayList = this.selectTempByPSDEGEIUpdate(pSDEGEIUpdate);
        this.onBeforeRemoveTempByPSDEGEIUpdate(pSDEGEIUpdate, arrayList);
        for (PSDEGEIUDetail pSDEGEIUDetail : arrayList) {
            this.removeTemp((IEntity)pSDEGEIUDetail);
        }
        this.onAfterRemoveTempByPSDEGEIUpdate(pSDEGEIUpdate, arrayList);
    }

    protected void onAfterRemoveTempByPSDEGEIUpdate(PSDEGEIUpdate pSDEGEIUpdate) throws Exception {
    }

    protected void onBeforeRemoveTempByPSDEGEIUpdate(PSDEGEIUpdate pSDEGEIUpdate, ArrayList<PSDEGEIUDetail> arrayList) throws Exception {
    }

    protected void onAfterRemoveTempByPSDEGEIUpdate(PSDEGEIUpdate pSDEGEIUpdate, ArrayList<PSDEGEIUDetail> arrayList) throws Exception {
    }

    public void removeTempByPSDEGrid(PSDEGrid pSDEGrid) throws Exception {
        final PSDEGrid pSDEGrid2 = pSDEGrid;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEGEIUDetailServiceBase.this.onBeforeRemoveTempByPSDEGrid(pSDEGrid2);
                PSDEGEIUDetailServiceBase.this.internalRemoveTempByPSDEGrid(pSDEGrid2);
                PSDEGEIUDetailServiceBase.this.onAfterRemoveTempByPSDEGrid(pSDEGrid2);
            }
        });
    }

    protected void onBeforeRemoveTempByPSDEGrid(PSDEGrid pSDEGrid) throws Exception {
    }

    protected void internalRemoveTempByPSDEGrid(PSDEGrid pSDEGrid) throws Exception {
        ArrayList<PSDEGEIUDetail> arrayList = this.selectTempByPSDEGrid(pSDEGrid);
        this.onBeforeRemoveTempByPSDEGrid(pSDEGrid, arrayList);
        for (PSDEGEIUDetail pSDEGEIUDetail : arrayList) {
            this.removeTemp((IEntity)pSDEGEIUDetail);
        }
        this.onAfterRemoveTempByPSDEGrid(pSDEGrid, arrayList);
    }

    protected void onAfterRemoveTempByPSDEGrid(PSDEGrid pSDEGrid) throws Exception {
    }

    protected void onBeforeRemoveTempByPSDEGrid(PSDEGrid pSDEGrid, ArrayList<PSDEGEIUDetail> arrayList) throws Exception {
    }

    protected void onAfterRemoveTempByPSDEGrid(PSDEGrid pSDEGrid, ArrayList<PSDEGEIUDetail> arrayList) throws Exception {
    }

    protected void replaceParentInfo(PSDEGEIUDetail pSDEGEIUDetail, CloneSession cloneSession) throws Exception {
        IEntity iEntity;
        super.replaceParentInfo((IEntity)pSDEGEIUDetail, cloneSession);
        if (pSDEGEIUDetail.getPSDEGEIUpdateId() != null && (iEntity = cloneSession.getEntity("PSDEGEIUPDATE", (Object)pSDEGEIUDetail.getPSDEGEIUpdateId())) != null) {
            this.onFillParentInfo_PSDEGEIUpdate(pSDEGEIUDetail, (PSDEGEIUpdate)iEntity);
        }
        if (pSDEGEIUDetail.getPSDEGridColId() != null && (iEntity = cloneSession.getEntity("PSDEGRIDCOL", (Object)pSDEGEIUDetail.getPSDEGridColId())) != null) {
            this.onFillParentInfo_PSDEGridCol(pSDEGEIUDetail, (PSDEGridCol)iEntity);
        }
        if (pSDEGEIUDetail.getPSDEGridId() != null && (iEntity = cloneSession.getEntity("PSDEGRID", (Object)pSDEGEIUDetail.getPSDEGridId())) != null) {
            this.onFillParentInfo_PSDEGrid(pSDEGEIUDetail, (PSDEGrid)iEntity);
        }
    }

    protected void onRemoveEntityUncopyValues(PSDEGEIUDetail pSDEGEIUDetail, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues((IEntity)pSDEGEIUDetail, bl);
    }

    protected void onCheckEntity(boolean bl, PSDEGEIUDetail pSDEGEIUDetail, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_PSDEGEIUDetailId(bl, pSDEGEIUDetail, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEGEIUDetailName(bl, pSDEGEIUDetail, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEGEIUpdateId(bl, pSDEGEIUDetail, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEGridColId(bl, pSDEGEIUDetail, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEGridId(bl, pSDEGEIUDetail, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, (IEntity)pSDEGEIUDetail, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_PSDEGEIUDetailId(boolean bl, PSDEGEIUDetail pSDEGEIUDetail, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEGEIUDetail.isPSDEGEIUDetailIdDirty() && !bl2 : !pSDEGEIUDetail.isPSDEGEIUDetailIdDirty()) {
            return null;
        }
        String string = pSDEGEIUDetail.getPSDEGEIUDetailId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEGEIUDETAILID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEGEIUDetailId_Default((IEntity)pSDEGEIUDetail, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEGEIUDETAILID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDEGEIUDetailName(boolean bl, PSDEGEIUDetail pSDEGEIUDetail, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEGEIUDetail.isPSDEGEIUDetailNameDirty() : !pSDEGEIUDetail.isPSDEGEIUDetailNameDirty()) {
            return null;
        }
        String string = pSDEGEIUDetail.getPSDEGEIUDetailName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEGEIUDetailName_Default((IEntity)pSDEGEIUDetail, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEGEIUDETAILNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDEGEIUpdateId(boolean bl, PSDEGEIUDetail pSDEGEIUDetail, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEGEIUDetail.isPSDEGEIUpdateIdDirty() && !bl2 : !pSDEGEIUDetail.isPSDEGEIUpdateIdDirty()) {
            return null;
        }
        String string = pSDEGEIUDetail.getPSDEGEIUpdateId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEGEIUPDATEID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEGEIUpdateId_Default((IEntity)pSDEGEIUDetail, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEGEIUPDATEID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDEGridColId(boolean bl, PSDEGEIUDetail pSDEGEIUDetail, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEGEIUDetail.isPSDEGridColIdDirty() && !bl2 : !pSDEGEIUDetail.isPSDEGridColIdDirty()) {
            return null;
        }
        String string = pSDEGEIUDetail.getPSDEGridColId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEGRIDCOLID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEGridColId_Default((IEntity)pSDEGEIUDetail, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEGRIDCOLID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDEGridId(boolean bl, PSDEGEIUDetail pSDEGEIUDetail, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEGEIUDetail.isPSDEGridIdDirty() : !pSDEGEIUDetail.isPSDEGridIdDirty()) {
            return null;
        }
        String string = pSDEGEIUDetail.getPSDEGridId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEGridId_Default((IEntity)pSDEGEIUDetail, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEGRIDID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected void onSyncEntity(PSDEGEIUDetail pSDEGEIUDetail, boolean bl) throws Exception {
        super.onSyncEntity((IEntity)pSDEGEIUDetail, bl);
    }

    protected void onSyncIndexEntities(PSDEGEIUDetail pSDEGEIUDetail, boolean bl) throws Exception {
        super.onSyncIndexEntities((IEntity)pSDEGEIUDetail, bl);
    }

    public Object getDataContextValue(PSDEGEIUDetail pSDEGEIUDetail, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null) {
            // empty if block
        }
        if ((object = super.getDataContextValue((IEntity)pSDEGEIUDetail, string, iDataContextParam)) != null) {
            return object;
        }
        PSDEGEIUpdate pSDEGEIUpdate = pSDEGEIUDetail.getPSDEGEIUpdate();
        if (pSDEGEIUpdate != null && pSDEGEIUpdate.contains(string)) {
            return pSDEGEIUpdate.get(string);
        }
        PSDEGridCol pSDEGridCol = pSDEGEIUDetail.getPSDEGridCol();
        if (pSDEGridCol != null && pSDEGridCol.contains(string)) {
            return pSDEGridCol.get(string);
        }
        return null;
    }

    protected void onExportMajorModel(PSDEGEIUDetail pSDEGEIUDetail, ArrayList<JSONObject> arrayList, int n) throws Exception {
        super.onExportMajorModel((IEntity)pSDEGEIUDetail, arrayList, n);
    }

    protected String onTestValueRule(String string, String string2, IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        if (StringHelper.compare((String)string, (String)"CREATEDATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateDate_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATEMAN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateMan_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEGEIUDETAILID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEGEIUDetailId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEGEIUDETAILNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEGEIUDetailName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEGEIUPDATEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEGEIUpdateId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEGEIUPDATENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEGEIUpdateName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEGRIDCOLID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEGridColId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEGRIDCOLNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEGridColName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEGRIDID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEGridId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEGRIDNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEGridName_Default(iEntity, bl, bl2);
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

    protected String onTestValueRule_PSDEGEIUDetailId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEGEIUDETAILID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDEGEIUDetailName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEGEIUDETAILNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDEGEIUpdateId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEGEIUPDATEID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDEGEIUpdateName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEGEIUPDATENAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDEGridColId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEGRIDCOLID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDEGridColName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEGRIDCOLNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDEGridId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEGRIDID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDEGridName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEGRIDNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
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

    protected boolean onMergeChild(String string, String string2, PSDEGEIUDetail pSDEGEIUDetail) throws Exception {
        boolean bl = false;
        if (super.onMergeChild(string, string2, (IEntity)pSDEGEIUDetail)) {
            bl = true;
        }
        return bl;
    }

    protected void onUpdateParent(PSDEGEIUDetail pSDEGEIUDetail) throws Exception {
        super.onUpdateParent((IEntity)pSDEGEIUDetail);
    }

    @Override
    protected void exportCurXmlModel(PSDEGEIUDetail pSDEGEIUDetail, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSDEGEIUDETAIL");
        if (!bl) {
            pSDEGEIUDetail.setCreateDate(null);
            pSDEGEIUDetail.setCreateMan(null);
            pSDEGEIUDetail.setPSDEGEIUDetailId(null);
            pSDEGEIUDetail.setPSDEGridName(null);
            pSDEGEIUDetail.setUpdateMan(null);
            pSDEGEIUDetail.setPSDEGridColId(null);
            pSDEGEIUDetail.setPSDEGEIUpdateId(null);
            pSDEGEIUDetail.setPSDEGEIUpdateName(null);
            pSDEGEIUDetail.setPSDEGridId(null);
            pSDEGEIUDetail.setPSDEGridName(null);
            super.exportCurXmlModel(pSDEGEIUDetail, xmlNode, bl);
        }
    }

    @Override
    protected String getEntityFolderKeyValue(PSDEGEIUDetail pSDEGEIUDetail, PSSystem pSSystem) throws Exception {
        PSDEGEIUDetail pSDEGEIUDetail2 = new PSDEGEIUDetail();
        pSDEGEIUDetail2.setPSDEGEIUpdateId(pSDEGEIUDetail.getPSDEGEIUpdateId());
        pSDEGEIUDetail2.setPSDEGridColId(pSDEGEIUDetail.getPSDEGridColId());
        if (this.selectOne((IEntity)pSDEGEIUDetail2, true)) {
            return pSDEGEIUDetail2.getPSDEGEIUDetailId();
        }
        return super.getEntityFolderKeyValue(pSDEGEIUDetail, pSSystem);
    }

    @Override
    public ObjectNode fillModelV2(ObjectNode objectNode, PSDEGEIUDetail pSDEGEIUDetail, String string) throws Exception {
        objectNode = super.fillModelV2(objectNode, pSDEGEIUDetail, string);
        return objectNode;
    }

    @Override
    public String getModelV2ResScope(IEntity iEntity) throws Exception {
        String string = null;
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSDEGEIUPDATEID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return StringHelper.format((String)"PSDEGEIUPDATE#%1$s", (Object)string);
        }
        return super.getModelV2ResScope(iEntity);
    }

    @Override
    public String getModelV2ResScopeDER(IEntity iEntity) throws Exception {
        String string = null;
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSDEGEIUPDATEID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return "DER1N_PSDEGEIUDETAIL_PSDEGEIUPDATE_PSDEGEIUPDATEID";
        }
        return super.getModelV2ResScopeDER(iEntity);
    }

    @Override
    public String getModelV2ResScopeText(IEntity iEntity) throws Exception {
        String string = null;
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSDEGEIUPDATEID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return DataObject.getStringValue((IDataObject)iEntity, (String)"PSDEGEIUPDATENAME", null);
        }
        return super.getModelV2ResScopeText(iEntity);
    }

    @Override
    public boolean setModelV2ResScope(IEntity iEntity, String string, String string2) throws Exception {
        if (StringHelper.compare((String)string, (String)"PSDEGEIUPDATE", (boolean)true) == 0) {
            iEntity.set("PSDEGEIUPDATEID", (Object)string2);
            return true;
        }
        return super.setModelV2ResScope(iEntity, string, string2);
    }

    @Override
    public String[] getModelV2ResScopeFields() throws Exception {
        return new String[]{"PSDEGEIUPDATEID"};
    }

    @Override
    public String getModelV2Tag(PSDEGEIUDetail pSDEGEIUDetail) {
        return super.getModelV2Tag(pSDEGEIUDetail);
    }

    @Override
    public boolean setModelV2Tag(PSDEGEIUDetail pSDEGEIUDetail, String string) {
        return super.setModelV2Tag(pSDEGEIUDetail, string);
    }

    @Override
    public Map<String, String> getListDRDataFolderFields(Map<String, String> map, PSMOSFile pSMOSFile, IPSMOSFileFilter iPSMOSFileFilter) throws Exception {
        if (map == null) {
            map = new HashMap<String, String>();
        }
        map.put("PSDEGEIUPDATEID", "");
        return super.getListDRDataFolderFields(map, pSMOSFile, iPSMOSFileFilter);
    }

    @Override
    public boolean getModelV2Entity(PSDEGEIUDetail pSDEGEIUDetail, String string) throws Exception {
        SimpleEntity simpleEntity = new SimpleEntity();
        pSDEGEIUDetail.copyTo((IDataObject)simpleEntity, false);
        simpleEntity.copyTo((IDataObject)pSDEGEIUDetail, true);
        return super.getModelV2Entity(pSDEGEIUDetail, string);
    }

    @Override
    protected boolean testCompileCurModelV2(PSDEGEIUDetail pSDEGEIUDetail, ObjectNode objectNode, String string, String string2, int n) throws Exception {
        if (n == 1) {
            return false;
        }
        return super.testCompileCurModelV2(pSDEGEIUDetail, objectNode, string, string2, n);
    }
}

