/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.fasterxml.jackson.databind.node.ObjectNode
 *  net.ibizsys.model.dataentity.ac.IPSDEACMode
 *  net.ibizsys.model.dataentity.ds.IPSDEDataSet
 *  net.ibizsys.model.dataentity.field.IPSDEField
 *  net.ibizsys.model.dataentity.field.IPSPickupDEField
 *  net.ibizsys.model.der.IPSDER1NDEFieldMap
 *  net.ibizsys.paas.util.KeyValueHelper
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package net.ibizsys.model.der;

import com.fasterxml.jackson.databind.node.ObjectNode;
import java.util.ArrayList;
import java.util.HashMap;
import net.ibizsys.model.PSModelRTMeta;
import net.ibizsys.model.dataentity.IPSDataEntityRuntime;
import net.ibizsys.model.dataentity.ac.IPSDEACMode;
import net.ibizsys.model.dataentity.ds.IPSDEDataSet;
import net.ibizsys.model.dataentity.field.IPSDEField;
import net.ibizsys.model.dataentity.field.IPSPickupDEField;
import net.ibizsys.model.der.IPSDER1NDEFieldMap;
import net.ibizsys.model.der.IPSDER1NRuntime;
import net.ibizsys.model.der.PSDERBaseImpl;
import net.ibizsys.model.entity.PSDEACMode;
import net.ibizsys.model.entity.PSDEViewBase;
import net.ibizsys.paas.util.KeyValueHelper;
import net.ibizsys.paas.util.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSDER1NImpl
extends PSDERBaseImpl
implements IPSDER1NRuntime {
    private static final Log log = LogFactory.getLog(PSDER1NImpl.class);
    private boolean bCloneRS = false;
    private int nMasterRS = 0;
    private boolean bExtRestrict = false;
    private int nRemoveOrder = 0;
    private int nRemoveActionType = -1;
    private int nCloneOrder = -1;
    private int nTempDataOrder = -1;
    private String strRefPickupPSDEViewId = "";
    private String strRefPickupPSDEViewName = "";
    private String strRefMPickupPSDEViewId = "";
    private String strRefMPickupPSDEViewName = "";
    private String strRefLinkPSDEViewId = "";
    private String strRefLinkPSDEViewName = "";
    private String strRefDEACModeId = "";
    private boolean bEnablePDEREQ = false;
    private IPSPickupDEField iPSPickupDEField = null;
    private int nExportModelOrder = -1;
    private int nSyncExportModelMode = 0;
    private boolean bEnableFKey = true;
    private String strFKeyName = "";
    private String strMinorXmlTagName = null;
    private ArrayList<IPSDER1NDEFieldMap> psDER1NDEFieldMapList = null;
    private HashMap<String, String> psDER1NDEFieldMapQueryMap = null;
    private IPSDER1NDEFieldMap countPSDER1NDEFieldMap = null;
    private String strPickupDEFName = null;
    private IPSDEDataSet refPSDEDataSet = null;
    private IPSDEACMode refPSDEACMode = null;
    private IPSDEField erMinorPSDEF = null;
    private IPSDEField erMajorPSDEF = null;
    private String strERMajorPSDEFId = null;
    private String strERMinorPSDEFId = null;
    private int nExportMajorModel = -1;

    @Override
    protected void onInit() throws Exception {
        PSDEACMode psDEACMode;
        PSDEViewBase pickupPSDEViewBase;
        this.strPickupDEFName = this.psDER.getDERFIELDNAME().toUpperCase();
        this.strCodeName = this.psDER.getCODENAME();
        if (StringHelper.isNullOrEmpty((String)this.strCodeName)) {
            this.strCodeName = this.getPickupDEFName().toLowerCase();
            this.strCodeName = this.strCodeName.substring(0, this.strCodeName.length() - 2);
        }
        if (!StringHelper.isNullOrEmpty((String)this.strCodeName)) {
            String strHeader = this.strCodeName.substring(0, 1).toUpperCase();
            this.strCodeName = String.valueOf(strHeader) + this.strCodeName.substring(1);
        }
        if (!this.psDER.isMASTERRSNull()) {
            this.nMasterRS = this.psDER.getMASTERRS();
            if ((this.nMasterRS & 2) > 0) {
                this.nMasterRS |= 1;
            }
        }
        if (!this.psDER.isENABLECLONENull()) {
            this.bCloneRS = this.psDER.getENABLECLONE();
        }
        if (!this.psDER.isENAEXTRANGENull()) {
            this.bExtRestrict = this.psDER.getENAEXTRANGE();
        }
        if (!this.psDER.isREMOVEORDERNull()) {
            this.nRemoveOrder = this.psDER.getREMOVEORDER();
        }
        if (!this.psDER.isREMOVEACTIONTYPENull()) {
            this.nRemoveActionType = this.psDER.getREMOVEACTIONTYPE();
        }
        if (!this.psDER.isCLONEORDERVALUENull()) {
            this.nCloneOrder = this.psDER.getCLONEORDERVALUE();
        }
        if (!this.psDER.isTEMPORDERVALUENull()) {
            this.nTempDataOrder = this.psDER.getTEMPORDERVALUE();
        }
        if (!this.psDER.isEXPORTMAJORMODELNull()) {
            this.nExportMajorModel = this.psDER.getEXPORTMAJORMODEL();
        }
        if (!this.psDER.isEXPORTMODELNull()) {
            this.nExportModelOrder = this.psDER.getEXPORTMODEL();
        }
        if (!this.psDER.isSYNCEXPORTMODELNull()) {
            this.nSyncExportModelMode = this.psDER.getSYNCEXPORTMODEL();
        }
        if (!this.psDER.isFOREIGNKEYNull()) {
            this.bEnableFKey = this.psDER.getFOREIGNKEY();
        }
        this.strRefPickupPSDEViewId = this.psDER.getSDPSDEVIEWID();
        this.strRefPickupPSDEViewName = this.psDER.getSDPSDEVIEWNAME();
        if (StringHelper.isNullOrEmpty((String)this.strRefPickupPSDEViewId) && (pickupPSDEViewBase = ((IPSDataEntityRuntime)this.getMajorPSDataEntity()).getPSDEViewDataByPDT("PICKUPVIEW", true)) != null) {
            this.strRefPickupPSDEViewId = pickupPSDEViewBase.getPSDEVIEWBASEID();
            this.strRefPickupPSDEViewName = pickupPSDEViewBase.getPSDEVIEWBASENAME();
        }
        this.strRefMPickupPSDEViewId = this.psDER.getMDPSDEVIEWID();
        this.strRefMPickupPSDEViewName = this.psDER.getMDPSDEVIEWNAME();
        if (StringHelper.isNullOrEmpty((String)this.strRefMPickupPSDEViewId) && (pickupPSDEViewBase = ((IPSDataEntityRuntime)this.getMajorPSDataEntity()).getPSDEViewDataByPDT("MPICKUPVIEW", true)) != null) {
            this.strRefMPickupPSDEViewId = pickupPSDEViewBase.getPSDEVIEWBASEID();
            this.strRefMPickupPSDEViewName = pickupPSDEViewBase.getPSDEVIEWBASENAME();
        }
        this.strRefLinkPSDEViewId = this.psDER.getLINKPSDEVIEWID();
        this.strRefLinkPSDEViewName = this.psDER.getLINKPSDEVIEWNAME();
        if (StringHelper.isNullOrEmpty((String)this.strRefLinkPSDEViewId)) {
            PSDEViewBase linkPSDEViewBase = ((IPSDataEntityRuntime)this.getMajorPSDataEntity()).getPSDEViewDataByPDT("REDIRECTVIEW", true);
            if (linkPSDEViewBase == null) {
                linkPSDEViewBase = ((IPSDataEntityRuntime)this.getMajorPSDataEntity()).getPSDEViewDataByPDT("EDITVIEW", true);
            }
            if (linkPSDEViewBase != null) {
                this.strRefLinkPSDEViewId = linkPSDEViewBase.getPSDEVIEWBASEID();
                this.strRefLinkPSDEViewName = linkPSDEViewBase.getPSDEVIEWBASENAME();
            }
        }
        this.strRefDEACModeId = this.psDER.getPSDEACMODEID();
        if (StringHelper.isNullOrEmpty((String)this.strRefDEACModeId) && (psDEACMode = ((IPSDataEntityRuntime)this.getMajorPSDataEntity()).getDefaultPSDEACModeData()) != null) {
            this.strRefDEACModeId = psDEACMode.getPSDEACMODEID();
        }
        this.strMinorCodeName = this.psDER.getMINORCODENAME();
        if (!StringHelper.isNullOrEmpty((String)this.strMinorCodeName)) {
            this.strMinorXmlTagName = this.strMinorCodeName.toUpperCase();
        }
        if (!this.psDER.isENAPDEREQNull()) {
            this.bEnablePDEREQ = this.psDER.getENAPDEREQ();
        }
        this.strFKeyName = this.psDER.getFKEYNAME();
        if (StringHelper.isNullOrEmpty((String)this.strFKeyName)) {
            this.strFKeyName = StringHelper.format((String)"%1$s_%2$s", (Object)this.getMinorPSDataEntity().getName(), (Object)this.getPickupDEFName()).toUpperCase();
            this.strFKeyName = "F" + KeyValueHelper.genUniqueId((String)this.strFKeyName).toUpperCase();
        }
        if (StringHelper.length((String)this.strFKeyName) >= 18) {
            this.strFKeyName = this.strFKeyName.substring(0, 18);
        }
        this.strERMajorPSDEFId = this.psDER.getEXTMAJORPSDEFID();
        this.strERMinorPSDEFId = this.psDER.getEXTMINORPSDEFID();
        this.onPreparePSDER1NDEFieldMaps();
        super.onInit();
    }

    protected void onPreparePSDER1NDEFieldMaps() throws Exception {
        if (this.psDER1NDEFieldMapList != null) {
            this.psDER1NDEFieldMapList.clear();
        }
        if (this.psDER1NDEFieldMapQueryMap != null) {
            this.psDER1NDEFieldMapQueryMap.clear();
        }
        this.countPSDER1NDEFieldMap = null;
    }

    public String getPickupDEFName() {
        return this.strPickupDEFName;
    }

    @PSModelRTMeta(description="\u652f\u6301\u514b\u9686")
    public boolean isCloneRS() {
        return this.bCloneRS;
    }

    @PSModelRTMeta(description="\u4e3b\u4ece\u5173\u7cfb\u7c7b\u578b", codelist="DER1NMasterRS")
    public int getMasterRS() {
        return this.nMasterRS;
    }

    @PSModelRTMeta(description="\u5220\u9664\u6b21\u5e8f")
    public int getRemoveOrder() {
        return this.nRemoveOrder;
    }

    @PSModelRTMeta(description="\u5220\u9664\u65b9\u5f0f", codelist="RemoveActionType")
    public int getRemoveActionType() {
        return this.nRemoveActionType;
    }

    @Override
    public String getRefPSDEDataSetId() {
        return this.psDER.getPSDEDATASETID();
    }

    @Override
    public String getRefPSDEDataSetName() throws Exception {
        if (this.getRefPSDEDataSet() == null) {
            return "";
        }
        return this.getRefPSDEDataSet().getName();
    }

    @Override
    @PSModelRTMeta(description="\u5f15\u7528\u5b9e\u4f53\u6570\u636e\u96c6", hideempty=true)
    public IPSDEDataSet getRefPSDEDataSet() throws Exception {
        if (StringHelper.isNullOrEmpty((String)this.getRefPSDEDataSetId())) {
            return null;
        }
        if (this.refPSDEDataSet == null) {
            this.refPSDEDataSet = this.getMajorPSDataEntity().getPSDEDataSet(this.getRefPSDEDataSetId());
        }
        return this.refPSDEDataSet;
    }

    @PSModelRTMeta(description="\u514b\u9686\u6b21\u5e8f")
    public int getCloneOrder() {
        return this.nCloneOrder;
    }

    @Override
    public String getRefPickupPSDEViewId() {
        return this.strRefPickupPSDEViewId;
    }

    @Override
    public String getRefPickupPSDEViewName() {
        return this.strRefPickupPSDEViewName;
    }

    @Override
    public String getRefMPickupPSDEViewId() {
        return this.strRefMPickupPSDEViewId;
    }

    @Override
    public String getRefMPickupPSDEViewName() {
        return this.strRefMPickupPSDEViewName;
    }

    @Override
    public String getRefLinkPSDEViewId() {
        return this.strRefLinkPSDEViewId;
    }

    @Override
    public String getRefLinkPSDEViewName() {
        return this.strRefLinkPSDEViewName;
    }

    @Override
    public String getRefPSDEACModeId() {
        return this.strRefDEACModeId;
    }

    @Override
    public String getRefPSDEACModeName() throws Exception {
        if (this.getRefPSDEACMode() == null) {
            return "";
        }
        return this.getRefPSDEACMode().getName();
    }

    @Override
    @PSModelRTMeta(description="\u5f15\u7528\u5b9e\u4f53\u81ea\u586b\u6a21\u5f0f", hideempty=true)
    public IPSDEACMode getRefPSDEACMode() throws Exception {
        if (StringHelper.isNullOrEmpty((String)this.getRefPSDEACModeId())) {
            return null;
        }
        if (this.refPSDEACMode == null) {
            this.refPSDEACMode = this.getMajorPSDataEntity().getPSDEACMode(this.getRefPSDEACModeId());
        }
        return this.refPSDEACMode;
    }

    @PSModelRTMeta(description="\u5916\u952e\u5c5e\u6027")
    public IPSPickupDEField getPSPickupDEField() throws Exception {
        if (this.iPSPickupDEField == null) {
            this.iPSPickupDEField = this.getMinorPSDataEntity().getPSPickupDEField(this.getId());
        }
        return this.iPSPickupDEField;
    }

    @Override
    protected void onFillViewParentModeJO(ObjectNode jo) {
        super.onFillViewParentModeJO(jo);
        if (!jo.has("SRFDER1NID".toLowerCase())) {
            jo.put("SRFDER1NID".toLowerCase(), this.getName());
        }
    }
}

