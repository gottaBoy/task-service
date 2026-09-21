/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.model.app.view.IPSAppDEWFView
 *  net.ibizsys.model.app.view.IPSAppView
 *  net.ibizsys.model.codelist.IPSCodeList
 *  net.ibizsys.model.control.IPSAjaxControlParam
 *  net.ibizsys.model.control.IPSControlContainer
 *  net.ibizsys.model.control.IPSControlParam
 *  net.ibizsys.model.control.grid.IPSDEGrid
 *  net.ibizsys.model.control.grid.IPSDEGridColumn
 *  net.ibizsys.model.control.grid.IPSDEGridDataItem
 *  net.ibizsys.model.control.grid.IPSDEGridEditItem
 *  net.ibizsys.model.control.grid.IPSDEGridEditItemUpdate
 *  net.ibizsys.model.control.grid.IPSDEGridFieldColumn
 *  net.ibizsys.model.control.grid.IPSDEGridGroupColumn
 *  net.ibizsys.model.control.grid.IPSDEGridParam
 *  net.ibizsys.model.dataentity.field.IPSDEField
 *  net.ibizsys.model.dataentity.wf.IPSDEWF
 *  net.ibizsys.paas.control.grid.IGridColumn
 *  net.ibizsys.paas.control.grid.IGridDataItem
 *  net.ibizsys.paas.control.grid.IGridEditItem
 *  net.ibizsys.paas.core.CallResult
 *  net.ibizsys.paas.data.IDataItemParam
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package net.ibizsys.model.control.grid;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Vector;
import net.ibizsys.model.IPSModelStorageContext;
import net.ibizsys.model.PSModelRTMeta;
import net.ibizsys.model.PSModels;
import net.ibizsys.model.app.view.IPSAppDEWFView;
import net.ibizsys.model.app.view.IPSAppView;
import net.ibizsys.model.codelist.IPSCodeList;
import net.ibizsys.model.control.IPSAjaxControlParam;
import net.ibizsys.model.control.IPSControlContainer;
import net.ibizsys.model.control.IPSControlParam;
import net.ibizsys.model.control.PSMDAjaxControlImpl;
import net.ibizsys.model.control.grid.HiddenPSDEGridEditItemImpl;
import net.ibizsys.model.control.grid.IPSDEGrid;
import net.ibizsys.model.control.grid.IPSDEGridColumn;
import net.ibizsys.model.control.grid.IPSDEGridColumnRuntime;
import net.ibizsys.model.control.grid.IPSDEGridDataItem;
import net.ibizsys.model.control.grid.IPSDEGridEditItem;
import net.ibizsys.model.control.grid.IPSDEGridEditItemUpdate;
import net.ibizsys.model.control.grid.IPSDEGridFieldColumn;
import net.ibizsys.model.control.grid.IPSDEGridGroupColumn;
import net.ibizsys.model.control.grid.IPSDEGridParam;
import net.ibizsys.model.control.grid.PSDEGridDataItemImpl;
import net.ibizsys.model.control.grid.PSDEGridEditItemUpdateImpl;
import net.ibizsys.model.control.grid.PSDEGridParamImpl;
import net.ibizsys.model.data.PSDataItemParamImpl;
import net.ibizsys.model.dataentity.field.IPSDEField;
import net.ibizsys.model.dataentity.wf.IPSDEWF;
import net.ibizsys.model.entity.PSDEGEIUDetail;
import net.ibizsys.model.entity.PSDEGEIUpdate;
import net.ibizsys.model.entity.PSDEGrid;
import net.ibizsys.model.entity.PSDEGridColumn;
import net.ibizsys.paas.control.grid.IGridColumn;
import net.ibizsys.paas.control.grid.IGridDataItem;
import net.ibizsys.paas.control.grid.IGridEditItem;
import net.ibizsys.paas.core.CallResult;
import net.ibizsys.paas.data.IDataItemParam;
import net.ibizsys.paas.util.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSDEGridImpl
extends PSMDAjaxControlImpl
implements IPSDEGrid {
    private static final Log log = LogFactory.getLog(PSDEGridImpl.class);
    protected PSDEGrid psDEGrid;
    protected ArrayList<IPSDEGridColumn> psDEGridColumnList = new ArrayList();
    protected ArrayList<IPSDEGridColumn> psDEGridColumnList2 = new ArrayList();
    protected ArrayList<IPSDEGridColumn> psDEGridColumnList3 = new ArrayList();
    protected ArrayList<IGridColumn> gridColumnList = new ArrayList();
    protected HashMap<String, IPSDEGridDataItem> psDEGridDataItemMap = new HashMap();
    protected ArrayList<IGridDataItem> gridDataItemList = new ArrayList();
    protected HashMap<String, IPSDEGridEditItem> psDEGridEditItemMap = new HashMap();
    protected ArrayList<IGridEditItem> gridEditItemList = new ArrayList();
    protected HashMap<String, IPSDEGridEditItemUpdate> psDEGridEditItemUpdateMap = new HashMap();
    protected PSDEGridParamImpl psDEGridParamImpl = new PSDEGridParamImpl();
    protected String strCodeName = "";
    protected boolean bForceFit = false;
    protected String strGridStyle = "";
    protected boolean bNoSort = false;
    protected IPSDEField minorPSDEField = null;
    protected String strMinorSortDir = "";
    private boolean bHideHeader = false;
    protected ArrayList<IPSDEGridDataItem> groupPSDEGridDataItemList = new ArrayList();
    private String strEmptyText = null;
    private boolean bHasWFDataItems = false;
    private String strSortMode = "REMOTE";

    @Override
    public void init(IPSModelStorageContext iPSModelStorageContext, IPSControlContainer iPSControlContainer, String strName, IPSControlParam iPSControlParam) throws Exception {
        try {
            this.setPSModelStorageContext(iPSModelStorageContext);
            this.setPSControlContainer(iPSControlContainer);
            IPSDEGridParam iPSDEGridParam = (IPSDEGridParam)iPSControlParam;
            this.psDEGrid = new PSDEGrid();
            CallResult callResult = this.getPSModelQueryHelper().getPSDEGrid(iPSDEGridParam.getPSDEGridId(), this.psDEGrid);
            if (callResult.isError()) {
                throw new Exception(StringHelper.format((String)"\u83b7\u53d6\u5b9e\u4f53\u8868\u683c\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
            }
            this.setId(this.psDEGrid.getPSDEGRIDID());
            this.setName(strName);
            this.setLogicName(this.psDEGrid.getPSDEGRIDNAME());
            this.setPSObjectData(this.psDEGrid);
            if (this.getPSDataEntity() != null) {
                if (StringHelper.compare((String)this.psDEGrid.getPSDEID(), (String)this.getPSDataEntity().getId(), (boolean)true) != 0) {
                    this.setPSDataEntity(this.getPSDataEntity().getPSSystem().getPSDataEntity(this.psDEGrid.getPSDEID()));
                }
            } else {
                this.setPSDataEntity(this.getPSAppView().getPSSystem().getPSDataEntity(this.psDEGrid.getPSDEID()));
            }
            this.psDEGridParamImpl.setPSAjaxControlHandlerId(this.psDEGrid.getPSACHANDLERID());
            this.psDEGridParamImpl.setPSDEDataSetId(this.psDEGrid.getPSDEDATASETID());
            this.psDEGridParamImpl.setSingleSelect(false);
            this.psDEGridParamImpl.setEnableRowEdit(false);
            this.psDEGridParamImpl.merge(iPSControlParam);
            this.strCodeName = this.psDEGrid.getCODENAME();
            if (StringHelper.isNullOrEmpty((String)this.strCodeName)) {
                this.strCodeName = this.getName();
            }
            if (!StringHelper.isNullOrEmpty((String)this.strCodeName)) {
                String strHeader = this.strCodeName.substring(0, 1).toUpperCase();
                this.strCodeName = String.valueOf(strHeader) + this.strCodeName.substring(1);
            }
            if (!this.psDEGrid.isFORCEFITNull()) {
                this.bForceFit = this.psDEGrid.getFORCEFIT();
            } else if (this.getPSAppView() != null) {
                this.bForceFit = this.getPSAppView().getPSApplication().getPSApplicationUI().isGridForceFit();
            }
            this.strGridStyle = this.psDEGrid.getGRIDSTYLE();
            if (!this.psDEGrid.isNOSORTNull()) {
                this.bNoSort = this.psDEGrid.getNOSORT();
            }
            if (!StringHelper.isNullOrEmpty((String)this.psDEGrid.getSORTMODE())) {
                this.strSortMode = this.psDEGrid.getSORTMODE();
            }
            if (!this.psDEGrid.isSHOWHEADERNull()) {
                this.bHideHeader = !this.psDEGrid.getSHOWHEADER();
            }
            this.strEmptyText = this.psDEGrid.getEMPTYTEXT();
            this.setCheckControlDataSet(true);
            super.init(iPSModelStorageContext, iPSControlContainer, strName, this.psDEGridParamImpl);
        }
        catch (Exception ex) {
            String strLogName = StringHelper.format((String)"%1$s[%2$s]", (Object)PSModels.getModelName(this.getModelType()), (Object)this.getFullModelName());
            String strExInfo = StringHelper.format((String)"\u521d\u59cb\u5316\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)ex.getMessage());
            log.error((Object)StringHelper.format((String)"%1$s%2$s", (Object)strLogName, (Object)strExInfo), (Throwable)ex);
            throw ex;
        }
    }

    public void initExpMode(IPSModelStorageContext iPSModelStorageContext, IPSControlContainer iPSControlContainer, String strGridId) throws Exception {
        this.setPSModelStorageContext(iPSModelStorageContext);
        this.setPSControlContainer(iPSControlContainer);
        this.psDEGrid = new PSDEGrid();
        CallResult callResult = this.getPSModelQueryHelper().getPSDEGrid(strGridId, this.psDEGrid);
        if (callResult.isError()) {
            throw new Exception(StringHelper.format((String)"\u83b7\u53d6\u5b9e\u4f53\u8868\u683c\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
        }
        this.setId(this.psDEGrid.getPSDEGRIDID());
        this.setName(strGridId);
        this.psDEGridParamImpl.setPSAjaxControlHandlerId(this.psDEGrid.getPSACHANDLERID());
        this.psDEGridParamImpl.setPSDEDataSetId(this.psDEGrid.getPSDEDATASETID());
        this.strCodeName = this.psDEGrid.getCODENAME();
        if (StringHelper.isNullOrEmpty((String)this.strCodeName)) {
            this.strCodeName = this.getName();
        }
        if (!StringHelper.isNullOrEmpty((String)this.strCodeName)) {
            String strHeader = this.strCodeName.substring(0, 1).toUpperCase();
            this.strCodeName = String.valueOf(strHeader) + this.strCodeName.substring(1);
        }
        this.setCheckControlDataSet(false);
        this.onInit();
    }

    @Override
    protected void onInit() throws Exception {
        String strMinorSortPSDEFName = this.psDEGrid.getMINORSORTPSDEFNAME();
        if (!StringHelper.isNullOrEmpty((String)strMinorSortPSDEFName)) {
            this.minorPSDEField = this.getPSDataEntity().getPSDEField(strMinorSortPSDEFName);
            this.strMinorSortDir = this.psDEGrid.getMINORSORTDIR();
            if (StringHelper.isNullOrEmpty((String)this.strMinorSortDir)) {
                this.strMinorSortDir = "ASC";
            }
        }
        super.onInit();
        this.onPreparePSDEGridColumns();
        this.onPreparePSDEGridDataItems();
        this.onPreparePSDEGridEditItemUpdates();
        this.onPreparePSDEGridEditItems();
    }

    protected void onPreparePSDEGridColumns() throws Exception {
        IPSDEGridFieldColumn iPSDEGridFieldColumn;
        Object iPSDEGridColumn;
        this.psDEGridColumnList.clear();
        this.gridColumnList.clear();
        this.psDEGridColumnList2.clear();
        this.groupPSDEGridDataItemList.clear();
        this.psDEGridColumnList3.clear();
        Vector<PSDEGridColumn> psDEGridColumnList = new Vector<PSDEGridColumn>();
        CallResult callResult = this.getPSModelQueryHelper().getPSDEGridColumns(this.getId(), psDEGridColumnList);
        if (callResult.isError()) {
            throw new Exception(StringHelper.format((String)"\u67e5\u8be2\u8868\u683c\u5217\u96c6\u5408\u53d1\u751f\u9519\u8bef, %1$s", (Object)callResult.getErrorInfo()));
        }
        boolean bKeyColumn = false;
        HashMap<String, PSDEGridColumn> psDEGridColumnMap = new HashMap<String, PSDEGridColumn>();
        for (PSDEGridColumn psDEGridColumn : psDEGridColumnList) {
            psDEGridColumnMap.put(psDEGridColumn.getPSDEGRIDCOLID(), psDEGridColumn);
            if (StringHelper.compare((String)psDEGridColumn.getPSDEGRIDCOLNAME(), (String)"srfkey", (boolean)true) != 0) continue;
            bKeyColumn = true;
            break;
        }
        for (PSDEGridColumn psDEGridColumn : psDEGridColumnList) {
            PSDEGridColumn parentPSDEGridColumn;
            if (StringHelper.isNullOrEmpty((String)psDEGridColumn.getPPSDEGRIDCOLID()) || !psDEGridColumn.isHIDDENDATAITEMNull() && psDEGridColumn.getHIDDENDATAITEM() || (parentPSDEGridColumn = (PSDEGridColumn)((Object)psDEGridColumnMap.get(psDEGridColumn.getPPSDEGRIDCOLID()))) == null) continue;
            parentPSDEGridColumn.getChildPSDEGridColumns(true).add(psDEGridColumn);
        }
        for (PSDEGridColumn psDEGridColumn : psDEGridColumnList) {
            if (!StringHelper.isNullOrEmpty((String)psDEGridColumn.getPPSDEGRIDCOLID()) && (psDEGridColumn.isHIDDENDATAITEMNull() || !psDEGridColumn.getHIDDENDATAITEM())) continue;
            iPSDEGridColumn = this.getPSModelStorageContext().createPSDEGridColumn(this, null, psDEGridColumn);
            if (iPSDEGridColumn.isHiddenDataItem()) {
                this.psDEGridColumnList2.add((IPSDEGridColumn)iPSDEGridColumn);
                continue;
            }
            this.psDEGridColumnList.add((IPSDEGridColumn)iPSDEGridColumn);
        }
        for (IPSDEGridColumn iPSDEGridColumn2 : this.psDEGridColumnList) {
            this.fillChildPSDEGridColumnList(iPSDEGridColumn2, this.psDEGridColumnList2);
        }
        HashMap<String, IPSDEGridFieldColumn> groupPSDEGridColumnMap = new HashMap<String, IPSDEGridFieldColumn>();
        for (IPSDEGridColumn iPSDEGridColumn3 : this.psDEGridColumnList) {
            if (!(iPSDEGridColumn3 instanceof IPSDEGridFieldColumn) || StringHelper.isNullOrEmpty((String)(iPSDEGridFieldColumn = (IPSDEGridFieldColumn)iPSDEGridColumn3).getGroupItem())) continue;
            groupPSDEGridColumnMap.put(iPSDEGridFieldColumn.getGroupItem(), iPSDEGridFieldColumn);
        }
        for (IPSDEGridColumn iPSDEGridColumn3 : this.psDEGridColumnList2) {
            if (!(iPSDEGridColumn3 instanceof IPSDEGridFieldColumn) || StringHelper.isNullOrEmpty((String)(iPSDEGridFieldColumn = (IPSDEGridFieldColumn)iPSDEGridColumn3).getGroupItem())) continue;
            groupPSDEGridColumnMap.put(iPSDEGridFieldColumn.getGroupItem(), iPSDEGridFieldColumn);
        }
        int i = 1;
        while (i <= 4) {
            Iterator psDEGridDataItems;
            String strGroupItem = StringHelper.format((String)"GROUP%1$s", (Object)i);
            iPSDEGridFieldColumn = (IPSDEGridFieldColumn)groupPSDEGridColumnMap.get(strGroupItem);
            if (iPSDEGridFieldColumn != null && (psDEGridDataItems = iPSDEGridFieldColumn.getPSDEGridDataItems()) != null) {
                while (psDEGridDataItems.hasNext()) {
                    this.groupPSDEGridDataItemList.add((IPSDEGridDataItem)psDEGridDataItems.next());
                }
            }
            ++i;
        }
        if (!bKeyColumn) {
            PSDEGridColumn psDEGridColumn = new PSDEGridColumn();
            psDEGridColumn.setPSDEID(this.getPSDataEntity().getId());
            psDEGridColumn.setENABLEROWEDIT(true);
            psDEGridColumn.setPSDEGRIDCOLID("srfkey");
            psDEGridColumn.setPSDEGRIDCOLNAME("srfkey");
            psDEGridColumn.setEDITORTYPE("HIDDEN");
            psDEGridColumn.setPSDEFID(this.getPSDataEntity().getKeyPSDEField().getId());
            psDEGridColumn.setPSDEFNAME(this.getPSDataEntity().getKeyPSDEField().getName());
            psDEGridColumn.setGRIDCOLTYPE("DEFGRIDCOLUMN");
            psDEGridColumn.setALLOWEMPTY(true);
            psDEGridColumn.setHIDDENDATAITEM(true);
            iPSDEGridColumn = this.getPSModelStorageContext().createPSDEGridColumn(this, null, psDEGridColumn);
            this.psDEGridColumnList2.add((IPSDEGridColumn)iPSDEGridColumn);
        }
        this.gridColumnList.addAll(this.psDEGridColumnList);
        for (IPSDEGridColumn iPSDEGridColumn4 : this.psDEGridColumnList) {
            this.fillAllPSDEGridColumnList(iPSDEGridColumn4, this.psDEGridColumnList3);
        }
    }

    protected void fillAllPSDEGridColumnList(IPSDEGridColumn iPSDEGridColumn, ArrayList<IPSDEGridColumn> psDEGridColumnList) {
        IPSDEGridGroupColumn iPSDEGridGroupColumn;
        Iterator psDEGridColumns;
        psDEGridColumnList.add(iPSDEGridColumn);
        if (iPSDEGridColumn instanceof IPSDEGridGroupColumn && (psDEGridColumns = (iPSDEGridGroupColumn = (IPSDEGridGroupColumn)iPSDEGridColumn).getPSDEGridColumns()) != null) {
            while (psDEGridColumns.hasNext()) {
                this.fillAllPSDEGridColumnList((IPSDEGridColumn)psDEGridColumns.next(), psDEGridColumnList);
            }
        }
    }

    /*
     * Unable to fully structure code
     */
    protected void onPreparePSDEGridDataItems() throws Exception {
        this.psDEGridDataItemMap.clear();
        this.gridDataItemList.clear();
        bAddFKey = true;
        bAddDataAccAction = true;
        bEditModeItem = false;
        nIgnoreDSItem = this.psDEGrid.getIGNOREDSITEM();
        if ((nIgnoreDSItem & 1) > 0) {
            bAddFKey = false;
        }
        if ((nIgnoreDSItem & 1024) > 0) {
            bAddDataAccAction = false;
        }
        for (IPSDEGridColumn iPSDEGridColumn : this.psDEGridColumnList) {
            psDEGridDataItems = iPSDEGridColumn.getPSDEGridDataItems();
            if (psDEGridDataItems != null) ** GOTO lbl19
            continue;
lbl-1000:
            // 1 sources

            {
                iPSDEGridDataItem = (IPSDEGridDataItem)psDEGridDataItems.next();
                if (this.psDEGridDataItemMap.containsKey(iPSDEGridDataItem.getName())) continue;
                this.psDEGridDataItemMap.put(iPSDEGridDataItem.getName(), iPSDEGridDataItem);
lbl19:
                // 3 sources

                ** while (psDEGridDataItems.hasNext())
            }
lbl20:
            // 1 sources

        }
        for (IPSDEGridColumn iPSDEGridColumn : this.psDEGridColumnList2) {
            psDEGridDataItems = iPSDEGridColumn.getPSDEGridDataItems();
            if (psDEGridDataItems != null) ** GOTO lbl29
            continue;
lbl-1000:
            // 1 sources

            {
                iPSDEGridDataItem = (IPSDEGridDataItem)psDEGridDataItems.next();
                if (this.psDEGridDataItemMap.containsKey(iPSDEGridDataItem.getName())) continue;
                this.psDEGridDataItemMap.put(iPSDEGridDataItem.getName(), iPSDEGridDataItem);
lbl29:
                // 3 sources

                ** while (psDEGridDataItems.hasNext())
            }
lbl30:
            // 1 sources

        }
        if (!this.psDEGridDataItemMap.containsKey("srfkey")) {
            psDEGridDataItemImpl = new PSDEGridDataItemImpl();
            psDEGridDataItemImpl.setName("srfkey");
            psDEGridDataItemImpl.setFormat("%1$s");
            if (this.getPSSystemSetting() != null) {
                psDEGridDataItemImpl.setFormat(this.getPSSystemSetting().getValueFormat());
            }
            psItemParamImpl = new PSDataItemParamImpl();
            psItemParamImpl.setName(this.getPSDataEntity().getKeyPSDEField().getName());
            psDEGridDataItemImpl.addDataItemParam(psItemParamImpl);
            psDEGridDataItemImpl.init(this);
            this.psDEGridDataItemMap.put(psDEGridDataItemImpl.getName(), psDEGridDataItemImpl);
        }
        if (bAddDataAccAction && !this.psDEGridDataItemMap.containsKey("srfdataaccaction")) {
            psDEGridDataItemImpl = new PSDEGridDataItemImpl();
            psDEGridDataItemImpl.setName("srfdataaccaction");
            psDEGridDataItemImpl.setDataAccessAction(true);
            psItemParamImpl = new PSDataItemParamImpl();
            psItemParamImpl.setName(this.getPSDataEntity().getKeyPSDEField().getName());
            psDEGridDataItemImpl.addDataItemParam(psItemParamImpl);
            psItemParamImpl = new PSDataItemParamImpl();
            psItemParamImpl.setName("NONE");
            psDEGridDataItemImpl.addDataItemParam(psItemParamImpl);
            psDEGridDataItemImpl.init(this);
            this.psDEGridDataItemMap.put(psDEGridDataItemImpl.getName(), psDEGridDataItemImpl);
        }
        psDEFields = this.getPSDataEntity().getPSDEFields();
        while (psDEFields.hasNext()) {
            iPSDEField = (IPSDEField)psDEFields.next();
            if (iPSDEField.isIndexTypeDEField() || iPSDEField.isMultiFormDEField()) {
                if (!bEditModeItem) {
                    bEditModeItem = true;
                    if (!this.psDEGridDataItemMap.containsKey("srfdatatype")) {
                        psDEGridDataItemImpl = new PSDEGridDataItemImpl();
                        psDEGridDataItemImpl.setName("srfdatatype");
                        psDEGridDataItemImpl.setFormat("%1$s");
                        if (this.getPSSystemSetting() != null) {
                            psDEGridDataItemImpl.setFormat(this.getPSSystemSetting().getValueFormat());
                        }
                        psItemParamImpl = new PSDataItemParamImpl();
                        psItemParamImpl.setName(iPSDEField.getName());
                        psItemParamImpl.setFormat(iPSDEField.getValueFormat());
                        psDEGridDataItemImpl.addDataItemParam(psItemParamImpl);
                        psDEGridDataItemImpl.init(this);
                        this.psDEGridDataItemMap.put(psDEGridDataItemImpl.getName(), psDEGridDataItemImpl);
                    }
                }
                if (!this.psDEGridDataItemMap.containsKey(iPSDEField.getName().toLowerCase())) {
                    psDEGridDataItemImpl = new PSDEGridDataItemImpl();
                    psDEGridDataItemImpl.setName(iPSDEField.getName().toLowerCase());
                    psDEGridDataItemImpl.setFormat("%1$s");
                    if (this.getPSSystemSetting() != null) {
                        psDEGridDataItemImpl.setFormat(this.getPSSystemSetting().getValueFormat());
                    }
                    psItemParamImpl = new PSDataItemParamImpl();
                    psItemParamImpl.setName(iPSDEField.getName());
                    psItemParamImpl.setFormat(iPSDEField.getValueFormat());
                    psDEGridDataItemImpl.addDataItemParam(psItemParamImpl);
                    psDEGridDataItemImpl.init(this);
                    this.psDEGridDataItemMap.put(psDEGridDataItemImpl.getName(), psDEGridDataItemImpl);
                    continue;
                }
            }
            if (!bAddFKey || StringHelper.compare((String)iPSDEField.getDataType(), (String)"PICKUP", (boolean)true) != 0 || this.psDEGridDataItemMap.containsKey(iPSDEField.getName().toLowerCase())) continue;
            psDEGridDataItemImpl = new PSDEGridDataItemImpl();
            psDEGridDataItemImpl.setName(iPSDEField.getName().toLowerCase());
            psDEGridDataItemImpl.setFormat("%1$s");
            if (this.getPSSystemSetting() != null) {
                psDEGridDataItemImpl.setFormat(this.getPSSystemSetting().getValueFormat());
            }
            psItemParamImpl = new PSDataItemParamImpl();
            psItemParamImpl.setName(iPSDEField.getName());
            psItemParamImpl.setFormat(iPSDEField.getValueFormat());
            psDEGridDataItemImpl.addDataItemParam(psItemParamImpl);
            psDEGridDataItemImpl.init(this);
            this.psDEGridDataItemMap.put(psDEGridDataItemImpl.getName(), psDEGridDataItemImpl);
        }
        if (!this.psDEGridDataItemMap.containsKey("srfmajortext") && this.getPSDataEntity().getMajorPSDEField() != null) {
            psDEGridDataItemImpl = new PSDEGridDataItemImpl();
            psDEGridDataItemImpl.setName("srfmajortext");
            psDEGridDataItemImpl.setFormat("%1$s");
            if (this.getPSSystemSetting() != null) {
                psDEGridDataItemImpl.setFormat(this.getPSSystemSetting().getValueFormat());
            }
            psItemParamImpl = new PSDataItemParamImpl();
            psItemParamImpl.setName(this.getPSDataEntity().getMajorPSDEField().getName());
            psDEGridDataItemImpl.addDataItemParam(psItemParamImpl);
            psDEGridDataItemImpl.init(this);
            this.psDEGridDataItemMap.put(psDEGridDataItemImpl.getName(), psDEGridDataItemImpl);
        }
        bOutputMSTag = true;
        if (this.getPSDataEntity().getAllPSDEWFs() != null) {
            psDEWFs = this.getPSDataEntity().getAllPSDEWFs();
            while (psDEWFs.hasNext()) {
                iPSDEWF = (IPSDEWF)psDEWFs.next();
                if (iPSDEWF.getWFStepField() != null && !this.psDEGridDataItemMap.containsKey((iPSDEField = iPSDEWF.getWFStepPSDEField()).getName().toLowerCase())) {
                    psDEGridDataItemImpl = new PSDEGridDataItemImpl();
                    psDEGridDataItemImpl.setName(iPSDEField.getName().toLowerCase());
                    psDEGridDataItemImpl.setFormat("%1$s");
                    if (this.getPSSystemSetting() != null) {
                        psDEGridDataItemImpl.setFormat(this.getPSSystemSetting().getValueFormat());
                    }
                    psItemParamImpl = new PSDataItemParamImpl();
                    psItemParamImpl.setName(iPSDEField.getName());
                    psItemParamImpl.setFormat(iPSDEField.getValueFormat());
                    psDEGridDataItemImpl.addDataItemParam(psItemParamImpl);
                    psDEGridDataItemImpl.init(this);
                    this.psDEGridDataItemMap.put(psDEGridDataItemImpl.getName(), psDEGridDataItemImpl);
                }
                if (iPSDEWF.getUDStatePSDEField() != null && !this.psDEGridDataItemMap.containsKey((iPSDEField = iPSDEWF.getUDStatePSDEField()).getName().toLowerCase())) {
                    psDEGridDataItemImpl = new PSDEGridDataItemImpl();
                    psDEGridDataItemImpl.setName(iPSDEField.getName().toLowerCase());
                    psDEGridDataItemImpl.setFormat("%1$s");
                    if (this.getPSSystemSetting() != null) {
                        psDEGridDataItemImpl.setFormat(this.getPSSystemSetting().getValueFormat());
                    }
                    psItemParamImpl = new PSDataItemParamImpl();
                    psItemParamImpl.setName(iPSDEField.getName());
                    psItemParamImpl.setFormat(iPSDEField.getValueFormat());
                    psDEGridDataItemImpl.addDataItemParam(psItemParamImpl);
                    psDEGridDataItemImpl.init(this);
                    this.psDEGridDataItemMap.put(psDEGridDataItemImpl.getName(), psDEGridDataItemImpl);
                }
                if (iPSDEWF.getWFVerPSDEField() == null || this.psDEGridDataItemMap.containsKey((iPSDEField = iPSDEWF.getWFVerPSDEField()).getName().toLowerCase())) continue;
                psDEGridDataItemImpl = new PSDEGridDataItemImpl();
                psDEGridDataItemImpl.setName(iPSDEField.getName().toLowerCase());
                psDEGridDataItemImpl.setFormat("%1$s");
                if (this.getPSSystemSetting() != null) {
                    psDEGridDataItemImpl.setFormat(this.getPSSystemSetting().getValueFormat());
                }
                psItemParamImpl = new PSDataItemParamImpl();
                psItemParamImpl.setName(iPSDEField.getName());
                psItemParamImpl.setFormat(iPSDEField.getValueFormat());
                psDEGridDataItemImpl.addDataItemParam(psItemParamImpl);
                psDEGridDataItemImpl.init(this);
                this.psDEGridDataItemMap.put(psDEGridDataItemImpl.getName(), psDEGridDataItemImpl);
            }
        }
        if (this.isFixWFDataItemsBug() && this.getPSAppView() != null && this.getPSAppView() instanceof IPSAppDEWFView && (iPSDEWF = ((IPSAppDEWFView)this.getPSAppView()).getPSDEWF()) != null) {
            this.bHasWFDataItems = true;
            if (iPSDEWF.getWFStepField() != null) {
                iPSDEField = iPSDEWF.getWFStepPSDEField();
                if (!this.psDEGridDataItemMap.containsKey("srfwfstep")) {
                    psDEGridDataItemImpl = new PSDEGridDataItemImpl();
                    psDEGridDataItemImpl.setName("srfwfstep");
                    psDEGridDataItemImpl.setFormat("%1$s");
                    if (this.getPSSystemSetting() != null) {
                        psDEGridDataItemImpl.setFormat(this.getPSSystemSetting().getValueFormat());
                    }
                    psItemParamImpl = new PSDataItemParamImpl();
                    psItemParamImpl.setName(iPSDEField.getName());
                    psItemParamImpl.setFormat(iPSDEField.getValueFormat());
                    psDEGridDataItemImpl.addDataItemParam(psItemParamImpl);
                    psDEGridDataItemImpl.init(this);
                    this.psDEGridDataItemMap.put(psDEGridDataItemImpl.getName(), psDEGridDataItemImpl);
                }
            }
            if (iPSDEWF.getWFVerPSDEField() != null) {
                iPSDEField = iPSDEWF.getWFVerPSDEField();
                if (!this.psDEGridDataItemMap.containsKey("srfwfver")) {
                    psDEGridDataItemImpl = new PSDEGridDataItemImpl();
                    psDEGridDataItemImpl.setName("srfwfver");
                    psDEGridDataItemImpl.setFormat("%1$s");
                    if (this.getPSSystemSetting() != null) {
                        psDEGridDataItemImpl.setFormat(this.getPSSystemSetting().getValueFormat());
                    }
                    psItemParamImpl = new PSDataItemParamImpl();
                    psItemParamImpl.setName(iPSDEField.getName());
                    psItemParamImpl.setFormat(iPSDEField.getValueFormat());
                    psDEGridDataItemImpl.addDataItemParam(psItemParamImpl);
                    psDEGridDataItemImpl.init(this);
                    this.psDEGridDataItemMap.put(psDEGridDataItemImpl.getName(), psDEGridDataItemImpl);
                }
            }
        }
        if (this.getPSDataEntity().isEnableDEMainState()) {
            psDEGridDataItemImpl = new PSDEGridDataItemImpl();
            psDEGridDataItemImpl.setName("srfmstag");
            psDEGridDataItemImpl.setFormat("%1$s");
            if (this.getPSSystemSetting() != null) {
                psDEGridDataItemImpl.setFormat(this.getPSSystemSetting().getValueFormat());
            }
            psDEGridDataItemImpl.init(this);
            this.psDEGridDataItemMap.put(psDEGridDataItemImpl.getName(), psDEGridDataItemImpl);
        }
        this.gridDataItemList.addAll(this.psDEGridDataItemMap.values());
    }

    protected void onPreparePSDEGridEditItems() throws Exception {
        this.psDEGridEditItemMap.clear();
        this.gridEditItemList.clear();
        ArrayList<String> valueItemList = new ArrayList<String>();
        for (IPSDEGridColumn iPSDEGridColumn : this.psDEGridColumnList) {
            if (!iPSDEGridColumn.isEnableRowEdit() || iPSDEGridColumn.getPSDEGridEditItem() == null) continue;
            this.psDEGridEditItemMap.put(iPSDEGridColumn.getPSDEGridEditItem().getName(), iPSDEGridColumn.getPSDEGridEditItem());
        }
        for (IPSDEGridColumn iPSDEGridColumn : this.psDEGridColumnList2) {
            if (!iPSDEGridColumn.isEnableRowEdit() || iPSDEGridColumn.getPSDEGridEditItem() == null) continue;
            this.psDEGridEditItemMap.put(iPSDEGridColumn.getPSDEGridEditItem().getName(), iPSDEGridColumn.getPSDEGridEditItem());
        }
        this.gridEditItemList.addAll(this.psDEGridEditItemMap.values());
        for (IGridEditItem iGridEditItem : this.gridEditItemList) {
            if (StringHelper.isNullOrEmpty((String)iGridEditItem.getValueItemName()) || valueItemList.contains(iGridEditItem.getValueItemName())) continue;
            valueItemList.add(iGridEditItem.getValueItemName());
        }
        for (String strValueItem : valueItemList) {
            if (this.psDEGridEditItemMap.containsKey(strValueItem)) continue;
            IPSDEField iPSDEField = this.getPSDataEntity().getPSDEField(strValueItem);
            HiddenPSDEGridEditItemImpl hiddenPSDEGridEditItemImpl = new HiddenPSDEGridEditItemImpl();
            hiddenPSDEGridEditItemImpl.init(this.getPSModelStorageContext(), this, iPSDEField);
            this.psDEGridEditItemMap.put(hiddenPSDEGridEditItemImpl.getName(), hiddenPSDEGridEditItemImpl);
            this.gridEditItemList.add((IGridEditItem)hiddenPSDEGridEditItemImpl);
        }
    }

    protected void onPreparePSDEGridEditItemUpdates() throws Exception {
        this.psDEGridEditItemUpdateMap.clear();
        Vector<PSDEGEIUpdate> psDEGEIUpdateList = new Vector<PSDEGEIUpdate>();
        CallResult callResult = this.getPSModelQueryHelper().getPSDEGEIUpdates(this.getId(), psDEGEIUpdateList);
        if (callResult.isError()) {
            throw new Exception(StringHelper.format((String)"\u67e5\u8be2\u8868\u683c\u7f16\u8f91\u9879\u66f4\u65b0\u903b\u8f91\u96c6\u5408\u53d1\u751f\u9519\u8bef, %1$s", (Object)callResult.getErrorInfo()));
        }
        if (psDEGEIUpdateList.size() == 0) {
            return;
        }
        HashMap<String, PSDEGEIUpdate> psDEGEIUpdateMap = new HashMap<String, PSDEGEIUpdate>();
        for (PSDEGEIUpdate psDEGEIUpdate : psDEGEIUpdateList) {
            psDEGEIUpdateMap.put(psDEGEIUpdate.getPSDEGEIUPDATEID(), psDEGEIUpdate);
        }
        Vector<PSDEGEIUDetail> psDEGEIUDetailList = new Vector<PSDEGEIUDetail>();
        callResult = this.getPSModelQueryHelper().getPSDEGEIUDetails(this.getId(), psDEGEIUDetailList);
        if (callResult.isError()) {
            throw new Exception(StringHelper.format((String)"\u67e5\u8be2\u8868\u683c\u7f16\u8f91\u9879\u66f4\u65b0\u6210\u5458\u96c6\u5408\u53d1\u751f\u9519\u8bef, %1$s", (Object)callResult.getErrorInfo()));
        }
        for (PSDEGEIUDetail psDEGEIUDetail : psDEGEIUDetailList) {
            PSDEGEIUpdate psDEGEIUpdate = (PSDEGEIUpdate)((Object)psDEGEIUpdateMap.get(psDEGEIUDetail.getPSDEGEIUPDATEID()));
            if (psDEGEIUpdate == null) continue;
            psDEGEIUpdate.getPSDEGEIUDetails(true).add(psDEGEIUDetail);
        }
        for (PSDEGEIUpdate psDEGEIUpdate : psDEGEIUpdateList) {
            PSDEGridEditItemUpdateImpl psDEGEIUpdateImpl = new PSDEGridEditItemUpdateImpl();
            psDEGEIUpdateImpl.init(this.getPSModelStorageContext(), this, psDEGEIUpdate);
            this.psDEGridEditItemUpdateMap.put(psDEGEIUpdateImpl.getId(), psDEGEIUpdateImpl);
        }
    }

    public String getControlType() {
        return "GRID";
    }

    public Iterator<IGridColumn> getGridColumns() {
        return this.gridColumnList.iterator();
    }

    @PSModelRTMeta(description="\u8868\u683c\u5217\u96c6\u5408", modeltype="PSDEGRIDCOL")
    public Iterator<IPSDEGridColumn> getPSDEGridColumns() {
        return this.psDEGridColumnList.iterator();
    }

    public Iterator<IGridDataItem> getGridDataItems() {
        return this.gridDataItemList.iterator();
    }

    @PSModelRTMeta(description="\u8868\u683c\u6570\u636e\u9879\u96c6\u5408")
    public Iterator<IPSDEGridDataItem> getPSDEGridDataItems() {
        return this.psDEGridDataItemMap.values().iterator();
    }

    @Override
    @PSModelRTMeta(description="\u540e\u53f0\u90e8\u4ef6\u53c2\u6570")
    public IPSAjaxControlParam getPSAjaxControlParam() {
        return this.psDEGridParamImpl;
    }

    @PSModelRTMeta(description="\u652f\u6301\u5206\u9875\u680f")
    public boolean isEnablePagingBar() {
        if (this.psDEGrid.isENABLEPAGINGBARNull()) {
            return false;
        }
        return this.psDEGrid.getENABLEPAGINGBAR();
    }

    @PSModelRTMeta(description="\u5206\u9875\u5927\u5c0f")
    public int getPagingSize() {
        if (this.psDEGrid.isPAGINGSIZENull()) {
            return 20;
        }
        return this.psDEGrid.getPAGINGSIZE();
    }

    @PSModelRTMeta(description="\u5355\u9879\u9009\u62e9")
    public boolean isSingleSelect() {
        return this.psDEGridParamImpl.isSingleSelect();
    }

    @PSModelRTMeta(description="\u652f\u6301\u884c\u7f16\u8f91")
    public boolean isEnableRowEdit() {
        return this.psDEGridParamImpl.isEnableRowEdit();
    }

    @PSModelRTMeta(description="\u9002\u5e94\u5c4f\u5e55\u5bbd\u5ea6")
    public boolean isForceFit() {
        return this.bForceFit;
    }

    @PSModelRTMeta(description="\u8868\u683c\u6837\u5f0f", codelist="DEGridStyle")
    public String getGridStyle() {
        return this.psDEGrid.getGRIDSTYLE();
    }

    @PSModelRTMeta(description="\u7981\u7528\u6392\u5e8f")
    public boolean isNoSort() {
        return this.bNoSort;
    }

    @PSModelRTMeta(description="\u9644\u52a0\u6392\u5e8f\u5c5e\u6027")
    public IPSDEField getMinorSortPSDEF() {
        return this.minorPSDEField;
    }

    @PSModelRTMeta(description="\u9644\u52a0\u6392\u5e8f\u65b9\u5411")
    public String getMinorSortDir() {
        return this.strMinorSortDir;
    }

    @Override
    public void fillRelatedPSCodeLists(ArrayList<IPSCodeList> relatedPSCodeListList) throws Exception {
        for (IPSDEGridDataItem iPSDEGridDataItem : this.psDEGridDataItemMap.values()) {
            if (!StringHelper.isNullOrEmpty((String)iPSDEGridDataItem.getCodeListId())) {
                relatedPSCodeListList.add(this.getPSDataEntity().getPSSystem().getPSCodeList(iPSDEGridDataItem.getCodeListId()));
            }
            if (iPSDEGridDataItem.getDataItemParams() == null) continue;
            IDataItemParam[] iDataItemParamArray = iPSDEGridDataItem.getDataItemParams();
            int n = iDataItemParamArray.length;
            int n2 = 0;
            while (n2 < n) {
                IDataItemParam iDataItemParam = iDataItemParamArray[n2];
                if (!StringHelper.isNullOrEmpty((String)iDataItemParam.getCodeListId())) {
                    relatedPSCodeListList.add(this.getPSDataEntity().getPSSystem().getPSCodeList(iDataItemParam.getCodeListId()));
                }
                ++n2;
            }
        }
    }

    @Override
    public void fillRelatedPSAppViews(ArrayList<IPSAppView> relatedAppViewList) throws Exception {
        super.fillRelatedPSAppViews(relatedAppViewList);
        for (IPSDEGridColumn iPSDEGridColumn : this.psDEGridColumnList) {
            ((IPSDEGridColumnRuntime)iPSDEGridColumn).fillRelatedPSAppViews(relatedAppViewList);
        }
    }

    @PSModelRTMeta(description="\u9690\u85cf\u8868\u683c\u5934\u90e8")
    public boolean isHideHeader() {
        return this.bHideHeader;
    }

    public boolean isStateful() {
        return true;
    }

    public Iterator<IGridEditItem> getGridEditItems() {
        return this.gridEditItemList.iterator();
    }

    @PSModelRTMeta(description="\u8868\u683c\u7f16\u8f91\u9879\u96c6\u5408", modeltype="PSDEGRIDEDITITEM")
    public Iterator<IPSDEGridEditItem> getPSDEGridEditItems() {
        return this.psDEGridEditItemMap.values().iterator();
    }

    public Iterator<IPSDEGridEditItemUpdate> getPSDEGridEditItemUpdates() {
        return this.psDEGridEditItemUpdateMap.values().iterator();
    }

    public IPSDEGridEditItemUpdate getPSDEGridEditItemUpdate(String strPSDEGridEditItemUpdateId) throws Exception {
        IPSDEGridEditItemUpdate iPSDEGridEditItemUpdate = this.psDEGridEditItemUpdateMap.get(strPSDEGridEditItemUpdateId);
        if (strPSDEGridEditItemUpdateId == null) {
            throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u8868\u683c\u7f16\u8f91\u9879\u66f4\u65b0[%1$s]", (Object)strPSDEGridEditItemUpdateId));
        }
        return iPSDEGridEditItemUpdate;
    }

    protected void fillChildPSDEGridColumnList(IPSDEGridColumn iPSDEGridColumn, ArrayList<IPSDEGridColumn> psDEGridColumnList) throws Exception {
        IPSDEGridGroupColumn iPSDEGridGroupColumn;
        Iterator psDEGridColumns;
        if (iPSDEGridColumn instanceof IPSDEGridGroupColumn && (psDEGridColumns = (iPSDEGridGroupColumn = (IPSDEGridGroupColumn)iPSDEGridColumn).getPSDEGridColumns()) != null) {
            while (psDEGridColumns.hasNext()) {
                IPSDEGridColumn childPSDEGridColumn = (IPSDEGridColumn)psDEGridColumns.next();
                psDEGridColumnList.add(childPSDEGridColumn);
                this.fillChildPSDEGridColumnList(childPSDEGridColumn, psDEGridColumnList);
            }
        }
    }

    public Iterator<IPSDEGridDataItem> getGroupPSDEGridDataItems() {
        if (this.groupPSDEGridDataItemList == null || this.groupPSDEGridDataItemList.size() == 0) {
            return null;
        }
        return this.groupPSDEGridDataItemList.iterator();
    }

    public Iterator<IPSDEGridColumn> getAllPSDEGridColumns() {
        return this.psDEGridColumnList3.iterator();
    }

    @PSModelRTMeta(description="\u65e0\u503c\u663e\u793a\u6587\u672c")
    public String getEmptyText() {
        return this.strEmptyText;
    }

    @Override
    public String getModelType() {
        return "PSDEGRID";
    }

    protected boolean isFixWFDataItemsBug() {
        return (this.getPSSystemSetting().getEngineBugFixs() & 4) == 4;
    }

    @PSModelRTMeta(description="\u8f93\u51fa\u9884\u7f6e\u6d41\u7a0b\u6570\u636e\u9879")
    public boolean hasWFDataItems() {
        return this.bHasWFDataItems;
    }

    @PSModelRTMeta(description="\u6392\u5e8f\u6a21\u5f0f", codelist="SortMode")
    public String getSortMode() {
        return this.strSortMode;
    }
}

