/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.model.app.view.IPSAppDEWFView
 *  net.ibizsys.model.control.IPSAjaxControlParam
 *  net.ibizsys.model.control.IPSControlContainer
 *  net.ibizsys.model.control.IPSControlParam
 *  net.ibizsys.model.control.list.IPSDEList
 *  net.ibizsys.model.control.list.IPSDEListItem
 *  net.ibizsys.model.control.list.IPSDEListParam
 *  net.ibizsys.model.dataentity.IPSDataEntity
 *  net.ibizsys.model.dataentity.ds.IPSDEDataSet
 *  net.ibizsys.model.dataentity.field.IPSDEField
 *  net.ibizsys.model.dataentity.logic.IPSDELogic
 *  net.ibizsys.model.dataentity.wf.IPSDEWF
 *  net.ibizsys.paas.core.CallResult
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package net.ibizsys.model.control.list;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Vector;
import net.ibizsys.model.IPSModelStorageContext;
import net.ibizsys.model.PSModelRTMeta;
import net.ibizsys.model.PSModels;
import net.ibizsys.model.app.view.IPSAppDEWFView;
import net.ibizsys.model.control.IPSAjaxControlParam;
import net.ibizsys.model.control.IPSControlContainer;
import net.ibizsys.model.control.IPSControlParam;
import net.ibizsys.model.control.list.IPSDEList;
import net.ibizsys.model.control.list.IPSDEListItem;
import net.ibizsys.model.control.list.IPSDEListItemRuntime;
import net.ibizsys.model.control.list.IPSDEListParam;
import net.ibizsys.model.control.list.PSDEListDataItemImpl;
import net.ibizsys.model.control.list.PSDEListItemImpl;
import net.ibizsys.model.control.list.PSDEListParamImpl;
import net.ibizsys.model.control.list.PSListImpl;
import net.ibizsys.model.data.PSDataItemParamImpl;
import net.ibizsys.model.dataentity.IPSDataEntity;
import net.ibizsys.model.dataentity.ds.IPSDEDataSet;
import net.ibizsys.model.dataentity.field.IPSDEField;
import net.ibizsys.model.dataentity.logic.IPSDELogic;
import net.ibizsys.model.dataentity.wf.IPSDEWF;
import net.ibizsys.model.entity.PSDEList;
import net.ibizsys.model.entity.PSDEListItem;
import net.ibizsys.paas.core.CallResult;
import net.ibizsys.paas.util.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSDEListImpl
extends PSListImpl
implements IPSDEList {
    private static final Log log = LogFactory.getLog(PSDEListImpl.class);
    protected PSDEList psDEList;
    protected ArrayList<IPSDEListItem> psDEListItemList = new ArrayList();
    protected ArrayList<IPSDEListItem> psDEListItemList2 = new ArrayList();
    protected PSDEListParamImpl psDEListParamImpl = null;
    protected String strCodeName = "";
    protected IPSDEDataSet iPSDEDataSet = null;
    protected String strPSDEDataSetId = null;
    private String strActiveDataPSDELogicId = null;
    private IPSDELogic activeDataPSDELogic = null;
    private IPSDataEntity iPSDataEntity = null;
    private int nPagingSize = 1000;
    protected IPSDEField minorPSDEField = null;
    protected String strMinorSortDir = "";
    private boolean bHideHeader = false;
    protected boolean bNoSort = false;
    private boolean bAppendDEItems = false;
    private String strMobListStyle = null;
    private String strEmptyText = null;
    private boolean bHasWFDataItems = false;

    @Override
    public void init(IPSModelStorageContext iPSModelStorageContext, IPSControlContainer iPSControlContainer, String strName, IPSControlParam iPSControlParam) throws Exception {
        try {
            this.setPSModelStorageContext(iPSModelStorageContext);
            this.setPSControlContainer(iPSControlContainer);
            IPSDEListParam iPSDEListParam = (IPSDEListParam)iPSControlParam;
            this.psDEList = new PSDEList();
            CallResult callResult = this.getPSModelQueryHelper().getPSDEList(iPSDEListParam.getPSDEListId(), this.psDEList);
            if (callResult.isError()) {
                throw new Exception(StringHelper.format((String)"\u83b7\u53d6\u5b9e\u4f53\u5217\u8868\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
            }
            this.setId(this.psDEList.getPSDELISTID());
            this.setName(strName);
            this.setLogicName(this.psDEList.getPSDELISTNAME());
            this.psDEListParamImpl = this.createPSDEListParam();
            this.psDEListParamImpl.merge(iPSControlParam);
            this.strCodeName = this.psDEList.getCODENAME();
            if (StringHelper.isNullOrEmpty((String)this.strCodeName)) {
                this.strCodeName = this.getName();
            }
            if (!StringHelper.isNullOrEmpty((String)this.strCodeName)) {
                String strHeader = this.strCodeName.substring(0, 1).toUpperCase();
                this.strCodeName = String.valueOf(strHeader) + this.strCodeName.substring(1);
            }
            if (!this.psDEList.isPAGESIZENull() && this.psDEList.getPAGESIZE() > 0) {
                this.nPagingSize = this.psDEList.getPAGESIZE();
            }
            if (!this.psDEList.isSHOWHEADERNull()) {
                boolean bl = this.bHideHeader = !this.psDEList.getSHOWHEADER();
            }
            if (!this.psDEList.isNOSORTNull()) {
                this.bNoSort = this.psDEList.getNOSORT();
            }
            if (!this.psDEList.isAPPENDDEITEMSNull()) {
                this.bAppendDEItems = this.psDEList.getAPPENDDEITEMS();
            }
            if (!this.psDEList.isMOBLISTSTYLENull()) {
                this.strMobListStyle = this.psDEList.getMOBLISTSTYLE();
            }
            this.strEmptyText = this.psDEList.getEMPTYTEXT();
            super.init(iPSModelStorageContext, iPSControlContainer, strName, iPSControlParam);
            this.setCheckControlDataSet(true);
            this.setCheckControlHandler(false);
        }
        catch (Exception ex) {
            String strLogName = StringHelper.format((String)"%1$s[%2$s]", (Object)PSModels.getModelName(this.getModelType()), (Object)this.getFullModelName());
            String strExInfo = StringHelper.format((String)"\u521d\u59cb\u5316\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)ex.getMessage());
            log.error((Object)StringHelper.format((String)"%1$s%2$s", (Object)strLogName, (Object)strExInfo), (Throwable)ex);
            throw ex;
        }
    }

    protected PSDEListParamImpl createPSDEListParam() {
        PSDEListParamImpl psDEListParamImpl = new PSDEListParamImpl();
        psDEListParamImpl.setPSAjaxControlHandlerId(this.psDEList.getPSACHANDLERID());
        return psDEListParamImpl;
    }

    @Override
    protected void onInit() throws Exception {
        this.iPSDataEntity = this.getPSAppView().getPSApplication().getPSSystem().getPSDataEntity(this.psDEList.getPSDEID());
        String strMinorSortPSDEFName = this.psDEList.getMINORSORTPSDEFNAME();
        if (!StringHelper.isNullOrEmpty((String)strMinorSortPSDEFName)) {
            this.minorPSDEField = this.getPSDataEntity().getPSDEField(strMinorSortPSDEFName);
            this.strMinorSortDir = this.psDEList.getMINORSORTDIR();
            if (StringHelper.isNullOrEmpty((String)this.strMinorSortDir)) {
                this.strMinorSortDir = "ASC";
            }
        }
        super.onInit();
        this.onPreparePSDEDataSet();
        this.onPreparePSDEListItems();
        this.onPreparePSDEListDataItems();
    }

    protected void onPreparePSDEDataSet() throws Exception {
        this.strPSDEDataSetId = this.psDEListParamImpl.getPSDEDataSetId();
        if (StringHelper.isNullOrEmpty((String)this.strPSDEDataSetId)) {
            this.strPSDEDataSetId = this.psDEList.getPSDEDSID();
        }
        if (!StringHelper.isNullOrEmpty((String)this.strPSDEDataSetId)) {
            this.iPSDEDataSet = this.getPSDataEntity().getPSDEDataSet(this.strPSDEDataSetId);
        }
        this.strActiveDataPSDELogicId = this.psDEListParamImpl.getActiveDataPSDELogicId();
        if (StringHelper.isNullOrEmpty((String)this.strActiveDataPSDELogicId)) {
            this.strActiveDataPSDELogicId = this.psDEList.getADPSDELOGICID();
        }
        if (!StringHelper.isNullOrEmpty((String)this.strActiveDataPSDELogicId)) {
            this.activeDataPSDELogic = this.getPSDataEntity().getPSDELogic(this.strActiveDataPSDELogicId);
        }
    }

    protected void onPreparePSDEListItems() throws Exception {
        this.psDEListItemList.clear();
        Vector<PSDEListItem> psDEListItemList = new Vector<PSDEListItem>();
        CallResult callResult = this.getPSModelQueryHelper().getPSDEListItems(this.getId(), psDEListItemList);
        if (callResult.isError()) {
            throw new Exception(StringHelper.format((String)"\u67e5\u8be2\u5217\u8868\u9879\u96c6\u5408\u53d1\u751f\u9519\u8bef, %1$s", (Object)callResult.getErrorInfo()));
        }
        for (PSDEListItem psDEListItem : psDEListItemList) {
            PSDEListItemImpl iPSDEListItem = new PSDEListItemImpl();
            ((IPSDEListItemRuntime)iPSDEListItem).init(this.getPSModelStorageContext(), this, psDEListItem);
            this.psDEListItemList2.add(iPSDEListItem);
            if (iPSDEListItem.isHiddenDataItem()) continue;
            this.psDEListItemList.add(iPSDEListItem);
            this.addPSListItem(iPSDEListItem);
        }
    }

    protected void onPreparePSDEListDataItems() throws Exception {
        HashMap<String, PSDEListDataItemImpl> psListDataItemMap = new HashMap<String, PSDEListDataItemImpl>();
        for (IPSDEListItem iPSDEListItem : this.psDEListItemList2) {
            String[] fields;
            if (StringHelper.compare((String)iPSDEListItem.getItemType(), (String)"ACTIONITEM", (boolean)true) == 0) continue;
            String strName = iPSDEListItem.getName().toLowerCase();
            int nStdDataType = -1;
            if (psListDataItemMap.containsKey(strName)) continue;
            nStdDataType = this.calcFieldStdDataType(strName);
            PSDEListDataItemImpl psListDataItemImpl = new PSDEListDataItemImpl();
            psListDataItemImpl.setName(strName);
            psListDataItemImpl.setDataType(nStdDataType);
            if (this.getPSSystemSetting() != null) {
                psListDataItemImpl.setFormat(this.getPSSystemSetting().getValueFormat());
            }
            if (!StringHelper.isNullOrEmpty((String)iPSDEListItem.getItemPrivId())) {
                psListDataItemImpl.setPrivilegeId(iPSDEListItem.getItemPrivId());
            }
            psListDataItemMap.put(strName, psListDataItemImpl);
            if (!StringHelper.isNullOrEmpty((String)iPSDEListItem.getValueFormat())) {
                psListDataItemImpl.setFormat(iPSDEListItem.getValueFormat());
            }
            if ((fields = iPSDEListItem.getFields()) != null) {
                String[] stringArray = fields;
                int n = fields.length;
                int n2 = 0;
                while (n2 < n) {
                    String strField = stringArray[n2];
                    strName = strField.toLowerCase();
                    PSDataItemParamImpl dataItemParamImpl = new PSDataItemParamImpl();
                    dataItemParamImpl.setName(strName);
                    psListDataItemImpl.addDataItemParam(dataItemParamImpl);
                    ++n2;
                }
            }
            if (StringHelper.compare((String)iPSDEListItem.getCLConvertMode(), (String)"BACKEND", (boolean)true) == 0) {
                psListDataItemImpl.setPSCodeList(iPSDEListItem.getPSCodeList());
            } else if (StringHelper.compare((String)iPSDEListItem.getCLConvertMode(), (String)"FRONT", (boolean)true) == 0) {
                psListDataItemImpl.setFrontPSCodeList(iPSDEListItem.getPSCodeList());
            }
            psListDataItemImpl.init(this);
            this.addPSListDataItem(psListDataItemImpl);
        }
        if (this.isAppendDEItems()) {
            IPSDEWF iPSDEWF;
            PSDataItemParamImpl psItemParamImpl;
            PSDEListDataItemImpl psListDataItemImpl;
            if (!psListDataItemMap.containsKey("srfkey")) {
                psListDataItemImpl = new PSDEListDataItemImpl();
                psListDataItemImpl.setName("srfkey");
                psListDataItemImpl.setFormat("%1$s");
                if (this.getPSSystemSetting() != null) {
                    psListDataItemImpl.setFormat(this.getPSSystemSetting().getValueFormat());
                }
                psItemParamImpl = new PSDataItemParamImpl();
                psItemParamImpl.setName(this.getPSDataEntity().getKeyPSDEField().getName());
                psListDataItemImpl.addDataItemParam(psItemParamImpl);
                psListDataItemMap.put(psListDataItemImpl.getName(), psListDataItemImpl);
                psListDataItemImpl.init(this);
                this.addPSListDataItem(psListDataItemImpl);
            }
            if (this.getPSDataEntity().getMajorPSDEField() != null && !psListDataItemMap.containsKey("srfmajortext")) {
                psListDataItemImpl = new PSDEListDataItemImpl();
                psListDataItemImpl.setName("srfmajortext");
                psListDataItemImpl.setFormat("%1$s");
                if (this.getPSSystemSetting() != null) {
                    psListDataItemImpl.setFormat(this.getPSSystemSetting().getValueFormat());
                }
                psItemParamImpl = new PSDataItemParamImpl();
                psItemParamImpl.setName(this.getPSDataEntity().getMajorPSDEField().getName());
                psListDataItemImpl.addDataItemParam(psItemParamImpl);
                psListDataItemMap.put(psListDataItemImpl.getName(), psListDataItemImpl);
                psListDataItemImpl.init(this);
                this.addPSListDataItem(psListDataItemImpl);
            }
            boolean bEditModeItem = false;
            Iterator psDEFields = this.getPSDataEntity().getPSDEFields();
            while (psDEFields.hasNext()) {
                PSDataItemParamImpl psItemParamImpl2;
                IPSDEField iPSDEField = (IPSDEField)psDEFields.next();
                if (iPSDEField.isIndexTypeDEField() || iPSDEField.isMultiFormDEField()) {
                    if (!bEditModeItem && !psListDataItemMap.containsKey("srfdatatype")) {
                        bEditModeItem = true;
                        PSDEListDataItemImpl psListDataItemImpl2 = new PSDEListDataItemImpl();
                        psListDataItemImpl2.setName("srfdatatype");
                        psListDataItemImpl2.setFormat("%1$s");
                        if (this.getPSSystemSetting() != null) {
                            psListDataItemImpl2.setFormat(this.getPSSystemSetting().getValueFormat());
                        }
                        psListDataItemImpl2.setFrontPSCodeList(iPSDEField.getPSCodeList());
                        psItemParamImpl2 = new PSDataItemParamImpl();
                        psItemParamImpl2.setName(iPSDEField.getName());
                        psItemParamImpl2.setFormat(iPSDEField.getValueFormat());
                        psListDataItemImpl2.addDataItemParam(psItemParamImpl2);
                        psListDataItemMap.put(psListDataItemImpl2.getName(), psListDataItemImpl2);
                        psListDataItemImpl2.init(this);
                        this.addPSListDataItem(psListDataItemImpl2);
                    }
                    if (!psListDataItemMap.containsKey(iPSDEField.getName().toLowerCase())) {
                        PSDEListDataItemImpl psListDataItemImpl3 = new PSDEListDataItemImpl();
                        psListDataItemImpl3.setName(iPSDEField.getName().toLowerCase());
                        psListDataItemImpl3.setFormat("%1$s");
                        if (this.getPSSystemSetting() != null) {
                            psListDataItemImpl3.setFormat(this.getPSSystemSetting().getValueFormat());
                        }
                        psListDataItemImpl3.setFrontPSCodeList(iPSDEField.getPSCodeList());
                        psItemParamImpl2 = new PSDataItemParamImpl();
                        psItemParamImpl2.setName(iPSDEField.getName());
                        psItemParamImpl2.setFormat(iPSDEField.getValueFormat());
                        psListDataItemImpl3.addDataItemParam(psItemParamImpl2);
                        psListDataItemMap.put(psListDataItemImpl3.getName(), psListDataItemImpl3);
                        psListDataItemImpl3.init(this);
                        this.addPSListDataItem(psListDataItemImpl3);
                        continue;
                    }
                }
                if (StringHelper.compare((String)iPSDEField.getDataType(), (String)"PICKUP", (boolean)true) != 0 || psListDataItemMap.containsKey(iPSDEField.getName().toLowerCase())) continue;
                PSDEListDataItemImpl psListDataItemImpl4 = new PSDEListDataItemImpl();
                psListDataItemImpl4.setName(iPSDEField.getName().toLowerCase());
                psListDataItemImpl4.setFormat("%1$s");
                if (this.getPSSystemSetting() != null) {
                    psListDataItemImpl4.setFormat(this.getPSSystemSetting().getValueFormat());
                }
                psItemParamImpl2 = new PSDataItemParamImpl();
                psItemParamImpl2.setName(iPSDEField.getName());
                psItemParamImpl2.setFormat(iPSDEField.getValueFormat());
                psListDataItemImpl4.addDataItemParam(psItemParamImpl2);
                psListDataItemMap.put(psListDataItemImpl4.getName(), psListDataItemImpl4);
                psListDataItemImpl4.init(this);
                this.addPSListDataItem(psListDataItemImpl4);
            }
            boolean bOutputMSTag = true;
            if (this.getPSDataEntity().getAllPSDEWFs() != null) {
                Iterator psDEWFs = this.getPSDataEntity().getAllPSDEWFs();
                while (psDEWFs.hasNext()) {
                    PSDEListDataItemImpl psListDataItemImpl5;
                    IPSDEField iPSDEField;
                    IPSDEWF iPSDEWF2 = (IPSDEWF)psDEWFs.next();
                    if (iPSDEWF2.getWFStepField() != null && !psListDataItemMap.containsKey((iPSDEField = iPSDEWF2.getWFStepPSDEField()).getName().toLowerCase())) {
                        psListDataItemImpl5 = new PSDEListDataItemImpl();
                        psListDataItemImpl5.setName(iPSDEField.getName().toLowerCase());
                        psListDataItemImpl5.setFormat("%1$s");
                        if (this.getPSSystemSetting() != null) {
                            psListDataItemImpl5.setFormat(this.getPSSystemSetting().getValueFormat());
                        }
                        psListDataItemImpl5.setFrontPSCodeList(iPSDEField.getPSCodeList());
                        PSDataItemParamImpl psItemParamImpl3 = new PSDataItemParamImpl();
                        psItemParamImpl3.setName(iPSDEField.getName());
                        psItemParamImpl3.setFormat(iPSDEField.getValueFormat());
                        psListDataItemImpl5.addDataItemParam(psItemParamImpl3);
                        psListDataItemMap.put(psListDataItemImpl5.getName(), psListDataItemImpl5);
                        psListDataItemImpl5.init(this);
                        this.addPSListDataItem(psListDataItemImpl5);
                    }
                    if (iPSDEWF2.getUDStatePSDEField() != null && !psListDataItemMap.containsKey((iPSDEField = iPSDEWF2.getUDStatePSDEField()).getName().toLowerCase())) {
                        psListDataItemImpl5 = new PSDEListDataItemImpl();
                        psListDataItemImpl5.setName(iPSDEField.getName().toLowerCase());
                        psListDataItemImpl5.setFormat("%1$s");
                        if (this.getPSSystemSetting() != null) {
                            psListDataItemImpl5.setFormat(this.getPSSystemSetting().getValueFormat());
                        }
                        psListDataItemImpl5.setFrontPSCodeList(iPSDEField.getPSCodeList());
                        PSDataItemParamImpl psItemParamImpl4 = new PSDataItemParamImpl();
                        psItemParamImpl4.setName(iPSDEField.getName());
                        psItemParamImpl4.setFormat(iPSDEField.getValueFormat());
                        psListDataItemImpl5.addDataItemParam(psItemParamImpl4);
                        psListDataItemMap.put(psListDataItemImpl5.getName(), psListDataItemImpl5);
                        psListDataItemImpl5.init(this);
                        this.addPSListDataItem(psListDataItemImpl5);
                    }
                    if (iPSDEWF2.getWFVerPSDEField() == null || psListDataItemMap.containsKey((iPSDEField = iPSDEWF2.getWFVerPSDEField()).getName().toLowerCase())) continue;
                    psListDataItemImpl5 = new PSDEListDataItemImpl();
                    psListDataItemImpl5.setName(iPSDEField.getName().toLowerCase());
                    psListDataItemImpl5.setFormat("%1$s");
                    if (this.getPSSystemSetting() != null) {
                        psListDataItemImpl5.setFormat(this.getPSSystemSetting().getValueFormat());
                    }
                    PSDataItemParamImpl psItemParamImpl5 = new PSDataItemParamImpl();
                    psItemParamImpl5.setName(iPSDEField.getName());
                    psItemParamImpl5.setFormat(iPSDEField.getValueFormat());
                    psListDataItemImpl5.addDataItemParam(psItemParamImpl5);
                    psListDataItemMap.put(psListDataItemImpl5.getName(), psListDataItemImpl5);
                    psListDataItemImpl5.init(this);
                    this.addPSListDataItem(psListDataItemImpl5);
                }
            }
            if (this.isFixWFDataItemsBug() && this.getPSAppView() != null && this.getPSAppView() instanceof IPSAppDEWFView && (iPSDEWF = ((IPSAppDEWFView)this.getPSAppView()).getPSDEWF()) != null) {
                PSDataItemParamImpl psItemParamImpl6;
                PSDEListDataItemImpl psListDataItemImpl6;
                IPSDEField iPSDEField;
                this.bHasWFDataItems = true;
                if (iPSDEWF.getWFStepField() != null) {
                    iPSDEField = iPSDEWF.getWFStepPSDEField();
                    if (!psListDataItemMap.containsKey("srfwfstep")) {
                        psListDataItemImpl6 = new PSDEListDataItemImpl();
                        psListDataItemImpl6.setName("srfwfstep");
                        psListDataItemImpl6.setFormat("%1$s");
                        if (this.getPSSystemSetting() != null) {
                            psListDataItemImpl6.setFormat(this.getPSSystemSetting().getValueFormat());
                        }
                        psItemParamImpl6 = new PSDataItemParamImpl();
                        psItemParamImpl6.setName(iPSDEField.getName());
                        psItemParamImpl6.setFormat(iPSDEField.getValueFormat());
                        psListDataItemImpl6.addDataItemParam(psItemParamImpl6);
                        psListDataItemMap.put(psListDataItemImpl6.getName(), psListDataItemImpl6);
                        psListDataItemImpl6.init(this);
                        this.addPSListDataItem(psListDataItemImpl6);
                    }
                }
                if (iPSDEWF.getWFVerPSDEField() != null) {
                    iPSDEField = iPSDEWF.getWFVerPSDEField();
                    if (!psListDataItemMap.containsKey("srfwfver")) {
                        psListDataItemImpl6 = new PSDEListDataItemImpl();
                        psListDataItemImpl6.setName("srfwfver");
                        psListDataItemImpl6.setFormat("%1$s");
                        if (this.getPSSystemSetting() != null) {
                            psListDataItemImpl6.setFormat(this.getPSSystemSetting().getValueFormat());
                        }
                        psListDataItemImpl6.setFrontPSCodeList(iPSDEField.getPSCodeList());
                        psItemParamImpl6 = new PSDataItemParamImpl();
                        psItemParamImpl6.setName(iPSDEField.getName());
                        psItemParamImpl6.setFormat(iPSDEField.getValueFormat());
                        psListDataItemImpl6.addDataItemParam(psItemParamImpl6);
                        psListDataItemMap.put(psListDataItemImpl6.getName(), psListDataItemImpl6);
                        psListDataItemImpl6.init(this);
                        this.addPSListDataItem(psListDataItemImpl6);
                    }
                }
            }
            if (this.getPSDataEntity().isEnableDEMainState() && !psListDataItemMap.containsKey("srfmstag")) {
                PSDEListDataItemImpl psListDataItemImpl7 = new PSDEListDataItemImpl();
                psListDataItemImpl7.setName("srfmstag");
                psListDataItemImpl7.setFormat("%1$s");
                if (this.getPSSystemSetting() != null) {
                    psListDataItemImpl7.setFormat(this.getPSSystemSetting().getValueFormat());
                }
                psListDataItemMap.put(psListDataItemImpl7.getName(), psListDataItemImpl7);
                psListDataItemImpl7.init(this);
                this.addPSListDataItem(psListDataItemImpl7);
            }
        }
    }

    protected int calcFieldStdDataType(String strFieldName) throws Exception {
        this.getPSDEDataSet();
        IPSDEField iPSDEField = this.getPSDataEntity().getPSDEField(strFieldName, true);
        if (iPSDEField != null) {
            return iPSDEField.getStdDataType();
        }
        log.warn((Object)StringHelper.format((String)"\u65e0\u6cd5\u8ba1\u7b97\u5c5e\u6027[%1$s]\u6570\u636e\u7c7b\u578b", (Object)strFieldName));
        return 25;
    }

    public String getControlType() {
        return "LIST";
    }

    @PSModelRTMeta(description="\u5b9e\u4f53\u5217\u8868\u9879\u96c6\u5408")
    public Iterator<IPSDEListItem> getPSDEListItems() {
        return this.psDEListItemList.iterator();
    }

    @Override
    public IPSAjaxControlParam getPSAjaxControlParam() {
        return this.psDEListParamImpl;
    }

    @PSModelRTMeta(description="\u5b9e\u4f53\u6570\u636e\u96c6\u5bf9\u8c61", hideempty2=true)
    public IPSDEDataSet getPSDEDataSet() {
        return this.iPSDEDataSet;
    }

    @Override
    @PSModelRTMeta(description="\u5b9e\u4f53\u5bf9\u8c61", hideempty2=true)
    public IPSDataEntity getPSDataEntity() {
        return this.iPSDataEntity;
    }

    @PSModelRTMeta(description="\u663e\u793a\u5934\u90e8")
    public boolean isShowHeader() {
        return !this.bHideHeader;
    }

    public boolean isForceFit() {
        return true;
    }

    @PSModelRTMeta(description="\u5206\u9875\u5927\u5c0f")
    public int getPagingSize() {
        return this.nPagingSize;
    }

    @PSModelRTMeta(description="\u9ed8\u8ba4\u6392\u5e8f\u5c5e\u6027")
    public IPSDEField getMinorSortPSDEF() {
        return this.minorPSDEField;
    }

    @PSModelRTMeta(description="\u9ed8\u8ba4\u6392\u5e8f\u65b9\u5411")
    public String getMinorSortDir() {
        return this.strMinorSortDir;
    }

    @PSModelRTMeta(description="\u7981\u7528\u6392\u5e8f")
    public boolean isNoSort() {
        return this.bNoSort;
    }

    @PSModelRTMeta(description="\u9644\u52a0\u5b9e\u4f53\u9ed8\u8ba4\u6570\u636e\u9879")
    public boolean isAppendDEItems() {
        return this.bAppendDEItems;
    }

    @PSModelRTMeta(description="\u79fb\u52a8\u7aef\u5217\u8868\u6837\u5f0f", codelist="MobMDCtrlTypes")
    public String getMobListStyle() {
        return this.strMobListStyle;
    }

    @Override
    public String getControlSubType() {
        return this.getMobListStyle();
    }

    @PSModelRTMeta(description="\u65e0\u503c\u663e\u793a\u5185\u5bb9")
    public String getEmptyText() {
        return this.strEmptyText;
    }

    @Override
    public String getModelType() {
        return "PSDELIST";
    }

    protected boolean isFixWFDataItemsBug() {
        return (this.getPSSystemSetting().getEngineBugFixs() & 4) == 4;
    }

    @PSModelRTMeta(description="\u8f93\u51fa\u9884\u7f6e\u6d41\u7a0b\u6570\u636e\u9879")
    public boolean hasWFDataItems() {
        return this.bHasWFDataItems;
    }

    @PSModelRTMeta(description="\u6570\u636e\u96c6\u5408\u4e0a\u4e0b\u6587\u6570\u636e\u8f6c\u6362\u903b\u8f91")
    public IPSDELogic getActiveDataPSDELogic() {
        return this.activeDataPSDELogic;
    }
}

