/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.api.FetchResult
 *  net.ibizsys.paas.api.IServiceAPIClientModel
 *  net.ibizsys.paas.core.DEDataSetFetchContext
 *  net.ibizsys.paas.core.IDEDataSetFetchContext
 *  net.ibizsys.paas.data.DataObject
 *  net.ibizsys.paas.data.IDataObject
 *  net.ibizsys.paas.data.ISimpleDataObject
 *  net.ibizsys.paas.db.IDataRow
 *  net.ibizsys.paas.entity.IEntity
 *  net.ibizsys.paas.util.StringHelper
 *  net.ibizsys.paas.web.WebConfig
 *  net.ibizsys.psrt.srv.dynasys.entity.DSDynaCodeList
 *  net.ibizsys.psrt.srv.dynasys.entity.DSDynaView
 *  net.ibizsys.psrt.srv.dynasys.entity.DSDynaViewInst
 *  net.ibizsys.psrt.srv.dynasys.entity.DSDynaWF
 *  net.ibizsys.psrt.srv.dynasys.entity.DSDynaWFVer
 */
package net.ibizsys.paas.sysmodel;

import java.util.ArrayList;
import net.ibizsys.paas.api.FetchResult;
import net.ibizsys.paas.api.IServiceAPIClientModel;
import net.ibizsys.paas.core.DEDataSetFetchContext;
import net.ibizsys.paas.core.IDEDataSetFetchContext;
import net.ibizsys.paas.data.DataObject;
import net.ibizsys.paas.data.IDataObject;
import net.ibizsys.paas.data.ISimpleDataObject;
import net.ibizsys.paas.db.IDataRow;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.sysmodel.DynaSystemStorageBase;
import net.ibizsys.paas.sysmodel.util.dynaclient.DefaultDynaAPIClientModel;
import net.ibizsys.paas.sysmodel.util.dynaclient.entity.PSDynaAppView;
import net.ibizsys.paas.sysmodel.util.dynaclient.entity.PSDynaAppViewInst;
import net.ibizsys.paas.sysmodel.util.dynaclient.entity.PSDynaCodeListInst;
import net.ibizsys.paas.sysmodel.util.dynaclient.entity.PSDynaWFVer;
import net.ibizsys.paas.sysmodel.util.dynaclient.entity.PSDynaWFVerInst;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.web.WebConfig;
import net.ibizsys.psrt.srv.dynasys.entity.DSDynaCodeList;
import net.ibizsys.psrt.srv.dynasys.entity.DSDynaView;
import net.ibizsys.psrt.srv.dynasys.entity.DSDynaViewInst;
import net.ibizsys.psrt.srv.dynasys.entity.DSDynaWF;
import net.ibizsys.psrt.srv.dynasys.entity.DSDynaWFVer;

public class DefaultDynaSystemStorage
extends DynaSystemStorageBase {
    public static final String ATTR_DYNASYSINSTID = "DYNASYSINSTID";
    private String strDynaInstId = null;
    IServiceAPIClientModel clientModel = null;

    protected void onInit() throws Exception {
        this.strDynaInstId = WebConfig.getCurrent().getAttribute(ATTR_DYNASYSINSTID, this.strDynaInstId);
        if (StringHelper.isNullOrEmpty((String)this.strDynaInstId)) {
            throw new Exception("\u6ca1\u6709\u914d\u7f6e\u52a8\u6001\u7cfb\u7edf\u5b9e\u4f8b\u3002");
        }
        this.clientModel = this.createDynaSystemAPIModel();
        super.onInit();
    }

    public IServiceAPIClientModel createDynaSystemAPIModel() {
        DefaultDynaAPIClientModel clientModel = null;
        try {
            clientModel = new DefaultDynaAPIClientModel();
            clientModel.init(null);
            return clientModel;
        }
        catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public ArrayList<DSDynaViewInst> listDynaViewInsts() throws Exception {
        ArrayList<DSDynaViewInst> dsDynaViewInstList = new ArrayList<DSDynaViewInst>();
        DEDataSetFetchContext iDEDataSetFetchContext = new DEDataSetFetchContext();
        PSDynaAppViewInst cond = new PSDynaAppViewInst();
        cond.setPSDynaInstId(this.strDynaInstId);
        iDEDataSetFetchContext.setActiveDataObject((ISimpleDataObject)cond);
        iDEDataSetFetchContext.setPageSize(99999);
        FetchResult fetchResult = this.clientModel.fetch("INT_PSDYNAAPPVIEWINST__FETCH__BYINST", (IDEDataSetFetchContext)iDEDataSetFetchContext);
        for (IDataRow row : fetchResult.getDataRows()) {
            PSDynaAppViewInst psDynaAppViewInst = new PSDynaAppViewInst();
            DataObject.fromDataRow((IDataObject)psDynaAppViewInst, (IDataRow)row);
            psDynaAppViewInst.set("PREDEFINEDVIEWTYPE", row.get("PREDEFINEVIEWTYPE"));
            DSDynaViewInst dsDynaViewInst = new DSDynaViewInst();
            dsDynaViewInst.setDSDynaViewInstId(psDynaAppViewInst.getPSDynaAppViewInstId());
            dsDynaViewInst.setDSDynaViewInstName(psDynaAppViewInst.getPSDynaAppViewInstName());
            dsDynaViewInst.setDynaSysInstId(psDynaAppViewInst.getPSDynaInstId());
            dsDynaViewInst.setDynaModel(psDynaAppViewInst.getDynaModel());
            dsDynaViewInst.setDSDynaViewId(psDynaAppViewInst.getPSDynaAppViewId());
            dsDynaViewInst.setInstVer(psDynaAppViewInst.getInstVer());
            dsDynaViewInst.setPDVTParam(psDynaAppViewInst.getPDVTParam());
            dsDynaViewInst.setPredefinedViewType(psDynaAppViewInst.getPredefinedViewType());
            dsDynaViewInst.setViewType(psDynaAppViewInst.getPredefinedViewType());
            dsDynaViewInstList.add(dsDynaViewInst);
        }
        return dsDynaViewInstList;
    }

    @Override
    public DSDynaView getDynaView(String strDynaViewId) throws Exception {
        DSDynaView dsDynaView = new DSDynaView();
        PSDynaAppView psDynaAppView = new PSDynaAppView();
        psDynaAppView.setPSDynaAppViewId(strDynaViewId);
        this.clientModel.execute("INT_PSDYNAAPPVIEW__DEACTION__GET", (IEntity)psDynaAppView);
        dsDynaView.setDSDynaViewId(psDynaAppView.getPSDynaAppViewId());
        dsDynaView.setDSDynaViewName(psDynaAppView.getPSDynaAppViewName());
        dsDynaView.setDEId(psDynaAppView.getPSDynaDEId());
        dsDynaView.setDEWFId(psDynaAppView.getPSWFDEId());
        dsDynaView.setPDVTParam(psDynaAppView.getPDVTParam());
        dsDynaView.setPredefinedViewType(psDynaAppView.getPredefinedViewType());
        dsDynaView.setViewType(psDynaAppView.getViewType());
        return dsDynaView;
    }

    @Override
    public DSDynaViewInst getDynaViewInst(String strDynaViewInstId) throws Exception {
        DSDynaViewInst dsDynaViewInst = new DSDynaViewInst();
        PSDynaAppViewInst psDynaAppViewInst = new PSDynaAppViewInst();
        psDynaAppViewInst.setPSDynaAppViewInstId(strDynaViewInstId);
        this.clientModel.execute("INT_PSDYNAAPPVIEWINST__DEACTION__GET", (IEntity)psDynaAppViewInst);
        dsDynaViewInst.setDSDynaViewInstId(psDynaAppViewInst.getPSDynaAppViewInstId());
        dsDynaViewInst.setDSDynaViewInstName(psDynaAppViewInst.getPSDynaAppViewInstName());
        dsDynaViewInst.setDynaSysInstId(psDynaAppViewInst.getPSDynaInstId());
        dsDynaViewInst.setDynaModel(psDynaAppViewInst.getDynaModel());
        dsDynaViewInst.setDSDynaViewId(psDynaAppViewInst.getPSDynaAppViewId());
        dsDynaViewInst.setInstVer(psDynaAppViewInst.getInstVer());
        dsDynaViewInst.setPDVTParam(psDynaAppViewInst.getPDVTParam());
        dsDynaViewInst.set("PREDEFINEDVIEWTYPE", psDynaAppViewInst.get("PREDEFINEVIEWTYPE"));
        dsDynaViewInst.setViewType(psDynaAppViewInst.getPredefinedViewType());
        return dsDynaViewInst;
    }

    @Override
    public ArrayList<DSDynaWFVer> listDynaWFVers() throws Exception {
        ArrayList<DSDynaWFVer> dsDynaWFVerList = new ArrayList<DSDynaWFVer>();
        DEDataSetFetchContext iDEDataSetFetchContext = new DEDataSetFetchContext();
        PSDynaWFVerInst cond = new PSDynaWFVerInst();
        cond.setPSDynaInstId(this.strDynaInstId);
        iDEDataSetFetchContext.setActiveDataObject((ISimpleDataObject)cond);
        iDEDataSetFetchContext.setPageSize(99999);
        FetchResult fetchResult = this.clientModel.fetch("INT_PSDYNAWFVERINST__FETCH__BYINST", (IDEDataSetFetchContext)iDEDataSetFetchContext);
        for (IDataRow row : fetchResult.getDataRows()) {
            PSDynaWFVerInst dynaWFVerInst = new PSDynaWFVerInst();
            DataObject.fromDataRow((IDataObject)dynaWFVerInst, (IDataRow)row);
            DSDynaWFVer dsDynaWFVer = new DSDynaWFVer();
            dsDynaWFVer.setDSDynaWFVerId(dynaWFVerInst.getPSDynaWFVerInstId());
            dsDynaWFVer.setDSDynaWFVerName(dynaWFVerInst.getPSDynaWFVerInstName());
            dsDynaWFVer.setDSDynaWFId(dynaWFVerInst.getPSDynaWFVerId());
            dsDynaWFVer.setDynaModel(dynaWFVerInst.getDynaModel());
            dsDynaWFVer.setWFVersion(dynaWFVerInst.getWFVersion());
            dsDynaWFVer.setDynaSysInstId(dynaWFVerInst.getPSDynaInstId());
            dsDynaWFVerList.add(dsDynaWFVer);
        }
        return dsDynaWFVerList;
    }

    @Override
    public DSDynaWF getDynaWF(String strDynaWFId) throws Exception {
        PSDynaWFVer psDynaWFVer = new PSDynaWFVer();
        psDynaWFVer.setPSDynaWFVerId(strDynaWFId);
        this.clientModel.execute("INT_PSDYNAWFVER__DEACTION__GET", (IEntity)psDynaWFVer);
        DSDynaWF dsDynaWF = new DSDynaWF();
        dsDynaWF.setDSDynaWFId(psDynaWFVer.getPSDynaWFVerId());
        dsDynaWF.setDSDynaWFName(psDynaWFVer.getPSDynaWFVerName());
        dsDynaWF.setWFWorkflowId(psDynaWFVer.getPSDynaWFId());
        dsDynaWF.setWFWorkflowName(psDynaWFVer.getPSDynaWFName());
        return dsDynaWF;
    }

    @Override
    public DSDynaWFVer getDynaWFVer(String strDynaWFVerId) throws Exception {
        DSDynaWFVer dsDynaWFVer = new DSDynaWFVer();
        PSDynaWFVerInst dynaWFVerInst = new PSDynaWFVerInst();
        dynaWFVerInst.setPSDynaWFVerInstId(strDynaWFVerId);
        this.clientModel.execute("INT_PSDYNAWFVERINST__DEACTION__GET", (IEntity)dynaWFVerInst);
        dsDynaWFVer.setDSDynaWFVerId(dynaWFVerInst.getPSDynaWFVerInstId());
        dsDynaWFVer.setDSDynaWFVerName(dynaWFVerInst.getPSDynaWFVerInstName());
        dsDynaWFVer.setDSDynaWFId(dynaWFVerInst.getPSDynaWFVerId());
        dsDynaWFVer.setDynaModel(dynaWFVerInst.getDynaModel());
        dsDynaWFVer.setWFVersion(dynaWFVerInst.getWFVersion());
        dsDynaWFVer.setDynaSysInstId(dynaWFVerInst.getPSDynaInstId());
        return dsDynaWFVer;
    }

    @Override
    public ArrayList<DSDynaCodeList> listDynaCodeLists() throws Exception {
        ArrayList<DSDynaCodeList> dsDynaCodeListList = new ArrayList<DSDynaCodeList>();
        DEDataSetFetchContext iDEDataSetFetchContext = new DEDataSetFetchContext();
        PSDynaCodeListInst cond = new PSDynaCodeListInst();
        cond.setPSDynaInstId(this.strDynaInstId);
        iDEDataSetFetchContext.setActiveDataObject((ISimpleDataObject)cond);
        iDEDataSetFetchContext.setPageSize(99999);
        FetchResult fetchResult = this.clientModel.fetch("INT_PSDYNACODELISTINST__FETCH__BYINST", (IDEDataSetFetchContext)iDEDataSetFetchContext);
        for (IDataRow row : fetchResult.getDataRows()) {
            PSDynaCodeListInst psDynaCodeListInst = new PSDynaCodeListInst();
            DataObject.fromDataRow((IDataObject)psDynaCodeListInst, (IDataRow)row);
            DSDynaCodeList dsDynaCodeList = new DSDynaCodeList();
            dsDynaCodeList.setDSDynaCodeListId(psDynaCodeListInst.getPSDynaCodeListInstId());
            dsDynaCodeList.setDSDynaCodeListName(psDynaCodeListInst.getPSDynaCodeListInstName());
            dsDynaCodeList.setCodeListId(psDynaCodeListInst.getPSDynaCodeListId());
            dsDynaCodeList.setDynaModel(psDynaCodeListInst.getDynaModel());
            dsDynaCodeList.setDynaSysInstId(psDynaCodeListInst.getPSDynaInstId());
            dsDynaCodeList.setInstVer(psDynaCodeListInst.getInstVer());
            dsDynaCodeListList.add(dsDynaCodeList);
        }
        return dsDynaCodeListList;
    }

    @Override
    public DSDynaCodeList getDynaCodeList(String strDynaCodeListId) throws Exception {
        DSDynaCodeList dsDynaCodeList = new DSDynaCodeList();
        PSDynaCodeListInst psDynaCodeListInst = new PSDynaCodeListInst();
        psDynaCodeListInst.setPSDynaCodeListInstId(strDynaCodeListId);
        this.clientModel.execute("INT_PSDYNACODELISTINST__DEACTION__GET", (IEntity)psDynaCodeListInst);
        dsDynaCodeList.setDSDynaCodeListId(psDynaCodeListInst.getPSDynaCodeListInstId());
        dsDynaCodeList.setDSDynaCodeListName(psDynaCodeListInst.getPSDynaCodeListInstName());
        dsDynaCodeList.setCodeListId(psDynaCodeListInst.getPSDynaCodeListId());
        dsDynaCodeList.setDynaModel(psDynaCodeListInst.getDynaModel());
        dsDynaCodeList.setDynaSysInstId(psDynaCodeListInst.getPSDynaInstId());
        dsDynaCodeList.setInstVer(psDynaCodeListInst.getInstVer());
        return dsDynaCodeList;
    }
}

