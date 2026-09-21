/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.model.codelist.IPSCodeList
 *  net.ibizsys.model.control.list.IPSDEList
 *  net.ibizsys.model.control.list.IPSDEListItem
 *  net.ibizsys.model.control.list.IPSList
 *  net.ibizsys.model.dataentity.field.IPSDEField
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package net.ibizsys.model.control.list;

import net.ibizsys.model.IPSModelObjectRuntime;
import net.ibizsys.model.IPSModelStorageContext;
import net.ibizsys.model.PSModelRTMeta;
import net.ibizsys.model.PSModels;
import net.ibizsys.model.codelist.IPSCodeList;
import net.ibizsys.model.control.list.IPSDEList;
import net.ibizsys.model.control.list.IPSDEListItem;
import net.ibizsys.model.control.list.IPSDEListItemRuntime;
import net.ibizsys.model.control.list.IPSList;
import net.ibizsys.model.control.list.PSListItemImpl;
import net.ibizsys.model.dataentity.field.IPSDEField;
import net.ibizsys.model.entity.PSDEListItem;
import net.ibizsys.paas.util.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSDEListItemImpl
extends PSListItemImpl
implements IPSDEListItem,
IPSDEListItemRuntime {
    private static final Log log = LogFactory.getLog(PSDEListItemImpl.class);
    private IPSDEList iPSDEList;
    private PSDEListItem psDEListItem;
    private String[] fields = null;
    private int nWidth = 150;
    private IPSCodeList iPSCodeList = null;
    private boolean bEnableSort = true;
    private String strWidthString = "";
    private boolean bHiddenDataItem = false;
    private String strAlign = "LEFT";
    private String strValueFormat = "";
    private String strCLConvertMode = null;
    private boolean bEnableItemPriv = false;
    private String strItemPrivId = null;

    @Override
    public void init(IPSModelStorageContext iPSModelStorageContext, IPSDEList iPSDEList, PSDEListItem psDEListItem) throws Exception {
        try {
            this.setPSModelStorageContext(iPSModelStorageContext);
            this.iPSDEList = iPSDEList;
            this.psDEListItem = psDEListItem;
            this.setId(this.psDEListItem.getPSDELISTITEMID());
            this.setName(this.psDEListItem.getPSDELISTITEMNAME());
            IPSDEField iPSDEField = iPSDEList.getPSDataEntity().getPSDEField(this.getName(), true);
            String strDataItems = this.psDEListItem.getDATAITEMS();
            if (!StringHelper.isNullOrEmpty((String)strDataItems)) {
                strDataItems = strDataItems.toLowerCase();
                this.fields = StringHelper.splitEx((String)strDataItems);
            }
            if (this.psDEListItem.getWIDTH() > 0) {
                this.nWidth = this.psDEListItem.getWIDTH();
            }
            if (!this.psDEListItem.isNOSORTNull()) {
                boolean bl = this.bEnableSort = !this.psDEListItem.getNOSORT();
            }
            if (!StringHelper.isNullOrEmpty((String)psDEListItem.getPSCODELISTID())) {
                this.iPSCodeList = iPSDEList.getPSDataEntity().getPSSystem().getPSCodeList(psDEListItem.getPSCODELISTID());
            } else if (iPSDEField != null) {
                this.iPSCodeList = iPSDEField.getPSCodeList();
            }
            if (this.iPSCodeList != null) {
                this.strCLConvertMode = psDEListItem.getCLCONVERTMODE();
                if (StringHelper.isNullOrEmpty((String)this.strCLConvertMode)) {
                    this.strCLConvertMode = "FRONT";
                } else if (StringHelper.compare((String)this.strCLConvertMode, (String)"NONE", (boolean)true) == 0) {
                    this.iPSCodeList = null;
                }
            }
            if (!StringHelper.isNullOrEmpty((String)this.psDEListItem.getVALUEFORMAT())) {
                this.strValueFormat = this.psDEListItem.getVALUEFORMAT();
            } else if (iPSDEField != null) {
                this.strValueFormat = iPSDEField.getValueFormat();
            }
            this.strWidthString = StringHelper.compare((String)this.psDEListItem.getWIDTHUNIT(), (String)"PX", (boolean)true) == 0 || StringHelper.isNullOrEmpty((String)this.psDEListItem.getWIDTHUNIT()) ? (psDEListItem.getWIDTH() > 0 ? StringHelper.format((String)"%1$spx", (Object)psDEListItem.getWIDTH()) : "0px") : (psDEListItem.getWIDTH() > 1 ? StringHelper.format((String)"%1$s*", (Object)psDEListItem.getWIDTH()) : "*");
            if (StringHelper.compare((String)psDEListItem.getITEMTYPE(), (String)"DATAITEM", (boolean)true) == 0) {
                this.bHiddenDataItem = true;
            }
            if (!StringHelper.isNullOrEmpty((String)psDEListItem.getALIGN())) {
                this.setAlign(psDEListItem.getALIGN());
            }
            if (iPSDEField != null) {
                this.bEnableItemPriv = iPSDEField.isEnablePrivilege();
            }
            if (!this.psDEListItem.isENABLEITEMPRIVNull()) {
                this.bEnableItemPriv = this.psDEListItem.getENABLEITEMPRIV();
            }
            if (this.bEnableItemPriv && iPSDEField != null) {
                this.strItemPrivId = StringHelper.format((String)"%1$s|%2$s", (Object)iPSDEField.getPSDataEntity().getName(), (Object)iPSDEField.getName());
            }
            this.onInit();
        }
        catch (Exception ex) {
            String strLogName = StringHelper.format((String)"%1$s[%2$s]", (Object)PSModels.getModelName(this.getModelType()), (Object)this.getFullModelName());
            String strExInfo = StringHelper.format((String)"\u521d\u59cb\u5316\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)ex.getMessage());
            log.error((Object)StringHelper.format((String)"%1$s%2$s", (Object)strLogName, (Object)strExInfo), (Throwable)ex);
            throw ex;
        }
    }

    @PSModelRTMeta(description="\u6807\u9898")
    public String getCaption() {
        return this.psDEListItem.getCAPTION();
    }

    public String getItemType() {
        return this.psDEListItem.getITEMTYPE();
    }

    public int getItemPos() {
        return this.psDEListItem.getORDERVALUE();
    }

    public IPSList getPSList() {
        return this.iPSDEList;
    }

    public IPSDEList getPSDEList() {
        return this.iPSDEList;
    }

    public String[] getFields() {
        return this.fields;
    }

    public int getWidth() {
        return this.nWidth;
    }

    public String getDataItemName() {
        return this.getName().toLowerCase();
    }

    @Override
    public String getPSSysModelInstId() {
        return ((IPSModelObjectRuntime)this.iPSDEList).getPSSysModelInstId();
    }

    public boolean isEnableSort() {
        return this.bEnableSort;
    }

    public IPSCodeList getPSCodeList() {
        return this.iPSCodeList;
    }

    public String getAlign() {
        return this.strAlign;
    }

    protected void setAlign(String strAlign) {
        this.strAlign = strAlign;
    }

    public boolean isHiddenDataItem() {
        return this.bHiddenDataItem;
    }

    public String getWidthString() {
        return this.strWidthString;
    }

    @PSModelRTMeta(description="\u503c\u683c\u5f0f\u5316")
    public String getValueFormat() {
        return this.strValueFormat;
    }

    @PSModelRTMeta(description="\u4ee3\u7801\u8868\u8f93\u51fa\u6a21\u5f0f", codelist="CLConvertModes", hideempty2=true)
    public String getCLConvertMode() {
        return this.strCLConvertMode;
    }

    public boolean isEnableItemPriv() {
        return this.bEnableItemPriv;
    }

    protected void setEnableItemPriv(boolean bEnableItemPriv) {
        this.bEnableItemPriv = bEnableItemPriv;
    }

    public String getItemPrivId() {
        return this.strItemPrivId;
    }

    protected void setItemPrivId(String strItemPrivId) {
        this.strItemPrivId = strItemPrivId;
    }

    @Override
    public String getModelType() {
        return "PSDELISTITEM";
    }
}

