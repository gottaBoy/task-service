/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Utility.StringHelper
 */
package SA.SRFDA.PS.Core.DataEntity.DER;

import SA.SRFDA.PS.Core.DEField.IPSDEFGroup;
import SA.SRFDA.PS.Core.DEField.IPSDEField;
import SA.SRFDA.PS.Core.DEField.IPSOne2ManyDataDEField;
import SA.SRFDA.PS.Core.DEField.IPSOne2OneDataDEField;
import SA.SRFDA.PS.Core.DataEntity.DER.IPSDERCustom;
import SA.SRFDA.PS.Core.DataEntity.DER.PSDERBaseImpl;
import SA.SRFDA.PS.Core.DataEntity.DS.IPSDEDataSet;
import SA.SRFDA.PS.Core.PSModelPFIgnoreMeta;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Core.Res.IPSLanguageRes;
import SA.SRFDA.PS.Data.PSDEACMode;
import SA.SRFDA.PS.Data.PSDEViewBase;
import SA.SRFramework.Utility.StringHelper;
import java.util.Iterator;

@PSModelPFIgnoreMeta
public class PSDERCustomImpl
extends PSDERBaseImpl
implements IPSDERCustom {
    private int nRemoveOrder = -1;
    private int nRemoveActionType = 0;
    private String strPickupDEFName = null;
    private IPSLanguageRes removeRejectMsgPSLanguageRes = null;
    private IPSDEField pickupPSDEField = null;
    private IPSDEField pickupTextPSDEField = null;
    private IPSDEField one2XDataPSDEField = null;
    private boolean bCalcOne2XDataPSDEField = false;
    private int nMasterRS = 0;
    private int nCustomExportOrder = -1;
    private int nCustomExportOrder2 = -1;
    private IPSDEDataSet nestedPSDEDataSet = null;
    private int nMasterOrder = -1;
    private IPSDEDataSet refPSDEDataSet = null;
    private String strRefPickupPSDEViewId = "";
    private String strRefPickupPSDEViewName = "";
    private String strRefMPickupPSDEViewId = "";
    private String strRefMPickupPSDEViewName = "";
    private String strRefLinkPSDEViewId = "";
    private String strRefLinkPSDEViewName = "";
    private String strMobRefPickupPSDEViewId = "";
    private String strMobRefPickupPSDEViewName = "";
    private String strMobRefMPickupPSDEViewId = "";
    private String strMobRefMPickupPSDEViewName = "";
    private String strMobRefLinkPSDEViewId = "";
    private String strMobRefLinkPSDEViewName = "";
    private String strRefDEACModeId = "";
    private int nCloneOrder = -1;
    private boolean bCloneRS = false;
    private IPSDEFGroup refPSDEFGroup = null;

    @Override
    protected void onInit() throws Exception {
        IPSDEField iPSDEField;
        this.strCodeName = this.psDER.getCODENAME();
        this.strMinorCodeName = this.psDER.getMINORCODENAME();
        if (!this.psDER.isEXPORTSCOPENull()) {
            this.nCustomExportOrder = this.psDER.getEXPORTSCOPE();
        }
        if (!this.psDER.isEXPORTSCOPE2Null()) {
            this.nCustomExportOrder2 = this.psDER.getEXPORTSCOPE2();
        }
        this.strPickupDEFName = this.psDER.getDERFIELDNAME().toUpperCase();
        if (StringHelper.IsNullOrEmpty((String)this.strPickupDEFName) && this.getMinorPSDataEntity().getDEType() == 4 && (iPSDEField = this.getMinorPSDataEntity().getPSDEFieldByPDT("PARENTID", true)) != null) {
            this.strPickupDEFName = iPSDEField.getName();
        }
        if (!this.psDER.isREMOVEORDERNull()) {
            this.nRemoveOrder = this.psDER.getREMOVEORDER();
        }
        if (!this.psDER.isREMOVEACTIONTYPENull()) {
            this.nRemoveActionType = this.psDER.getREMOVEACTIONTYPE();
        }
        if (!StringHelper.IsNullOrEmpty((String)this.psDER.getREMOVEREJECTPSLANRESID())) {
            this.removeRejectMsgPSLanguageRes = this.getPSSystem().getPSLanguageRes(this.psDER.getREMOVEREJECTPSLANRESID());
        }
        if (!this.psDER.isMASTERRSNull()) {
            this.nMasterRS = this.psDER.getMASTERRS();
            if ((this.nMasterRS & 2) > 0) {
                this.nMasterRS |= 1;
            }
        }
        if (!this.psDER.isMASTERORDERVALUENull()) {
            this.nMasterOrder = this.psDER.getMASTERORDERVALUE();
            if (this.nMasterOrder >= 10) {
                this.nMasterRS |= 1;
            }
        } else if ((this.getMasterRS() & 1) == 1) {
            this.nMasterOrder = 100;
        }
        if (!this.psDER.isCLONEORDERVALUENull()) {
            this.nCloneOrder = this.psDER.getCLONEORDERVALUE();
        }
        if (!this.psDER.isENABLECLONENull()) {
            this.bCloneRS = this.psDER.getENABLECLONE();
        } else {
            boolean bl = this.bCloneRS = this.getCloneOrder() >= 0;
        }
        if ("DER1N".equals(this.getDERSubType())) {
            PSDEACMode psDEACMode;
            PSDEViewBase linkPSDEViewBase;
            PSDEViewBase pickupPSDEViewBase;
            this.strRefPickupPSDEViewId = this.psDER.getSDPSDEVIEWID();
            this.strRefPickupPSDEViewName = this.psDER.getSDPSDEVIEWNAME();
            if (StringHelper.IsNullOrEmpty((String)this.strRefPickupPSDEViewId) && (pickupPSDEViewBase = this.getMajorPSDataEntity().getPSDEViewDataByPDT("PICKUPVIEW", true)) != null) {
                this.strRefPickupPSDEViewId = pickupPSDEViewBase.getPSDEVIEWBASEID();
                this.strRefPickupPSDEViewName = pickupPSDEViewBase.getPSDEVIEWBASENAME();
            }
            this.strRefMPickupPSDEViewId = this.psDER.getMDPSDEVIEWID();
            this.strRefMPickupPSDEViewName = this.psDER.getMDPSDEVIEWNAME();
            if (StringHelper.IsNullOrEmpty((String)this.strRefMPickupPSDEViewId) && (pickupPSDEViewBase = this.getMajorPSDataEntity().getPSDEViewDataByPDT("MPICKUPVIEW", true)) != null) {
                this.strRefMPickupPSDEViewId = pickupPSDEViewBase.getPSDEVIEWBASEID();
                this.strRefMPickupPSDEViewName = pickupPSDEViewBase.getPSDEVIEWBASENAME();
            }
            this.strRefLinkPSDEViewId = this.psDER.getLINKPSDEVIEWID();
            this.strRefLinkPSDEViewName = this.psDER.getLINKPSDEVIEWNAME();
            if (StringHelper.IsNullOrEmpty((String)this.strRefLinkPSDEViewId)) {
                linkPSDEViewBase = this.getMajorPSDataEntity().getPSDEViewDataByPDT("REDIRECTVIEW", true);
                if (linkPSDEViewBase == null) {
                    linkPSDEViewBase = this.getMajorPSDataEntity().getPSDEViewDataByPDT("EDITVIEW", true);
                }
                if (linkPSDEViewBase != null) {
                    this.strRefLinkPSDEViewId = linkPSDEViewBase.getPSDEVIEWBASEID();
                    this.strRefLinkPSDEViewName = linkPSDEViewBase.getPSDEVIEWBASENAME();
                }
            }
            this.strMobRefPickupPSDEViewId = this.psDER.getMOBSDPSDEVIEWID();
            this.strMobRefPickupPSDEViewName = this.psDER.getMOBSDPSDEVIEWNAME();
            if (StringHelper.IsNullOrEmpty((String)this.strMobRefPickupPSDEViewId) && (pickupPSDEViewBase = this.getMajorPSDataEntity().getPSDEViewDataByPDT("MOBPICKUPVIEW", true)) != null) {
                this.strMobRefPickupPSDEViewId = pickupPSDEViewBase.getPSDEVIEWBASEID();
                this.strMobRefPickupPSDEViewName = pickupPSDEViewBase.getPSDEVIEWBASENAME();
            }
            this.strMobRefMPickupPSDEViewId = this.psDER.getMOBMDPSDEVIEWID();
            this.strMobRefMPickupPSDEViewName = this.psDER.getMOBMDPSDEVIEWNAME();
            if (StringHelper.IsNullOrEmpty((String)this.strMobRefMPickupPSDEViewId) && (pickupPSDEViewBase = this.getMajorPSDataEntity().getPSDEViewDataByPDT("MOBMPICKUPVIEW", true)) != null) {
                this.strMobRefMPickupPSDEViewId = pickupPSDEViewBase.getPSDEVIEWBASEID();
                this.strMobRefMPickupPSDEViewName = pickupPSDEViewBase.getPSDEVIEWBASENAME();
            }
            this.strMobRefLinkPSDEViewId = this.psDER.getMOBLINKPSDEVIEWID();
            this.strMobRefLinkPSDEViewName = this.psDER.getMOBLINKPSDEVIEWNAME();
            if (StringHelper.IsNullOrEmpty((String)this.strMobRefLinkPSDEViewId)) {
                linkPSDEViewBase = this.getMajorPSDataEntity().getPSDEViewDataByPDT("MOBREDIRECTVIEW", true);
                if (linkPSDEViewBase == null) {
                    linkPSDEViewBase = this.getMajorPSDataEntity().getPSDEViewDataByPDT("MOBEDITVIEW", true);
                }
                if (linkPSDEViewBase != null) {
                    this.strMobRefLinkPSDEViewId = linkPSDEViewBase.getPSDEVIEWBASEID();
                    this.strMobRefLinkPSDEViewName = linkPSDEViewBase.getPSDEVIEWBASENAME();
                }
            }
            this.strRefDEACModeId = this.psDER.getPSDEACMODEID();
            if (StringHelper.IsNullOrEmpty((String)this.strRefDEACModeId) && (psDEACMode = this.getMajorPSDataEntity().getDefaultPSDEACModeData()) != null) {
                this.strRefDEACModeId = psDEACMode.getPSDEACMODEID();
            }
        }
        super.onInit();
    }

    @Override
    protected int onCheck() throws Exception {
        this.getRefPSDEDataSet();
        return super.onCheck();
    }

    @Override
    @PSModelRTMeta(description="\u5173\u7cfb\u5c5e\u6027\u540d\u79f0", fields={"DERFIELDNAME"})
    public String getPickupDEFName() {
        return this.strPickupDEFName;
    }

    @Override
    @PSModelRTMeta(description="\u5173\u7cfb\u5c5e\u6027", dumpref=true, ignorepf=true, doc="\u4f7f\u7528\u5173\u7cfb\u5c5e\u6027{@link #getPickupDEFName}\u5728\u4ece\u5b9e\u4f53\u4e2d\u5c1d\u8bd5\u83b7\u53d6")
    public IPSDEField getPickupPSDEField() throws Exception {
        if (StringHelper.IsNullOrEmpty((String)this.getPickupDEFName())) {
            return null;
        }
        if (this.pickupPSDEField == null) {
            this.pickupPSDEField = this.getMinorPSDataEntity().getPSDEField(this.getPickupDEFName(), true);
        }
        return this.pickupPSDEField;
    }

    @Override
    @PSModelRTMeta(description="\u5173\u7cfb\u4e3b\u4fe1\u606f\u5c5e\u6027", dumpref=true, ignorepf=true)
    public IPSDEField getPickupTextPSDEField() throws Exception {
        if (this.getPickupPSDEField() == null) {
            return null;
        }
        if (StringHelper.IsNullOrEmpty((String)this.psDER.getDERFIELDLNAME())) {
            return null;
        }
        if (this.pickupTextPSDEField == null) {
            this.pickupTextPSDEField = this.getMinorPSDataEntity().getPSDEField(this.psDER.getDERFIELDLNAME().toUpperCase(), true);
        }
        return this.pickupTextPSDEField;
    }

    @Override
    @PSModelRTMeta(description="\u4e00\u5bf9\u591a\u5173\u7cfb\u6570\u636e\u5c5e\u6027", dumpref=true, ignorepf=true)
    public IPSDEField getOne2XDataPSDEField() throws Exception {
        if (this.one2XDataPSDEField == null && !this.bCalcOne2XDataPSDEField) {
            Iterator<IPSDEField> psDEFields = this.getMajorPSDataEntity().getAllPSDEFields();
            if (psDEFields != null) {
                while (psDEFields.hasNext()) {
                    IPSOne2OneDataDEField iPSOne2OneDataDEField;
                    IPSOne2ManyDataDEField iPSOne2ManyDataDEField;
                    IPSDEField iPSDEField = psDEFields.next();
                    if (iPSDEField instanceof IPSOne2ManyDataDEField && (iPSOne2ManyDataDEField = (IPSOne2ManyDataDEField)iPSDEField).getPSDER() != null && StringHelper.Compare((String)iPSOne2ManyDataDEField.getPSDER().getId(), (String)this.getId(), (boolean)false) == 0) {
                        if (this.one2XDataPSDEField != null) break;
                        this.one2XDataPSDEField = iPSOne2ManyDataDEField;
                        break;
                    }
                    if (!(iPSDEField instanceof IPSOne2OneDataDEField) || (iPSOne2OneDataDEField = (IPSOne2OneDataDEField)iPSDEField).getPSDER() == null || StringHelper.Compare((String)iPSOne2OneDataDEField.getPSDER().getId(), (String)this.getId(), (boolean)false) != 0) continue;
                    if (this.one2XDataPSDEField != null) break;
                    this.one2XDataPSDEField = iPSOne2OneDataDEField;
                    break;
                }
            }
            this.bCalcOne2XDataPSDEField = true;
        }
        return this.one2XDataPSDEField;
    }

    @Override
    @PSModelRTMeta(description="\u5220\u9664\u6b21\u5e8f", fields={"REMOVEORDER"})
    public int getRemoveOrder() {
        return this.nRemoveOrder;
    }

    @Override
    @PSModelRTMeta(description="\u5220\u9664\u65b9\u5f0f", codelist="RemoveActionType", fields={"REMOVEACTIONTYPE"})
    public int getRemoveActionType() {
        return this.nRemoveActionType;
    }

    @Override
    @PSModelRTMeta(description="\u5220\u9664\u62d2\u7edd\u6d88\u606f", fields={"REMOVEREJECTMSG"})
    public String getRemoveRejectMsg() {
        return this.psDER.getREMOVEREJECTMSG();
    }

    @Override
    @PSModelRTMeta(description="\u5220\u9664\u62d2\u7edd\u6d88\u606f\u8bed\u8a00\u8d44\u6e90", fields={"REMOVEREJECTPSLANRESID"})
    public IPSLanguageRes getRRMPSLanguageRes() {
        return this.removeRejectMsgPSLanguageRes;
    }

    @Override
    @PSModelRTMeta(description="\u5220\u9664\u62d2\u7edd\u6d88\u606f\u8bed\u8a00\u6807\u8bb0")
    public String getRRMLanResTag() {
        if (this.getRRMPSLanguageRes() == null) {
            return "";
        }
        return this.getRRMPSLanguageRes().getLanResTag();
    }

    @Override
    @PSModelRTMeta(description="\u5173\u7cfb\u5b50\u7c7b\u578b", hideempty2=true, codelist="DERSubType", fields={"DERSUBTYPE"})
    public String getDERSubType() {
        return this.psDER.getDERSUBTYPE();
    }

    @Override
    @PSModelRTMeta(description="\u5173\u7cfb\u8bc6\u522b\u503c", fields={"INDEXVALUE"})
    public String getTypeValue() {
        return this.psDER.getINDEXVALUE();
    }

    @Override
    @PSModelRTMeta(description="\u4e3b\u4ece\u5173\u7cfb\u7c7b\u578b", codelist="DER1NMasterRS", fields={"MASTERRS"})
    public int getMasterRS() {
        return this.nMasterRS;
    }

    @Override
    @PSModelRTMeta(description="\u4e3b\u63a7\u6b21\u5e8f", fields={"MASTERORDERVALUE"}, ignoredumpvalues="-1")
    public int getMasterOrder() {
        return this.nMasterOrder;
    }

    @Override
    @PSModelRTMeta(description="\u81ea\u5b9a\u4e49\u5bfc\u51fa\u6b21\u5e8f", ignoredumpvalues="-1", fields={"EXPORTSCOPE"})
    public int getCustomExportOrder() {
        return this.nCustomExportOrder;
    }

    @Override
    @PSModelRTMeta(description="\u81ea\u5b9a\u4e49\u5bfc\u51fa\u6b21\u5e8f2", ignoredumpvalues="-1", fields={"EXPORTSCOPE2"})
    public int getCustomExportOrder2() {
        return this.nCustomExportOrder2;
    }

    @Override
    public String getNestedPSDEDataSetId() {
        return this.psDER.getMINORPSDEDSID();
    }

    @Override
    @PSModelRTMeta(description="\u5d4c\u5957\u6210\u5458\u6570\u636e\u96c6\u5bf9\u8c61", hideempty2=true, dumpref=true, ignorepf=true, from="__self__", from_method="getMinorPSDataEntityMust().getPSDEDataSet", fields={"MINORPSDEDSID"})
    public IPSDEDataSet getNestedPSDEDataSet() throws Exception {
        if (this.nestedPSDEDataSet != null) {
            return this.nestedPSDEDataSet;
        }
        if (!StringHelper.IsNullOrEmpty((String)this.getNestedPSDEDataSetId())) {
            this.nestedPSDEDataSet = this.getMinorPSDataEntity().getPSDEDataSet(this.getNestedPSDEDataSetId());
        }
        return this.nestedPSDEDataSet;
    }

    @Override
    @PSModelRTMeta(description="\u542f\u7528\u7269\u7406\u5316\u66f4\u65b0", ignoredumpvalues="false", fields={"UPDATEPHYSICALDEFIELD"})
    public boolean isEnablePhysicalDEFieldUpdate() {
        return this.psDER.getUPDATEPHYSICALDEFIELD();
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
    @PSModelRTMeta(description="\u5f15\u7528\u5b9e\u4f53\u6570\u636e\u96c6", hideempty=true, dumpref=true, ignorepf=true, from="__self__", from_method="getMajorPSDataEntityMust().getPSDEDataSet", fields={"PSDEDATASETID"})
    public IPSDEDataSet getRefPSDEDataSet() throws Exception {
        if (StringHelper.IsNullOrEmpty((String)this.getRefPSDEDataSetId())) {
            return null;
        }
        if (this.refPSDEDataSet == null) {
            this.refPSDEDataSet = this.getMajorPSDataEntity().getPSDEDataSet(this.getRefPSDEDataSetId());
        }
        return this.refPSDEDataSet;
    }

    @Override
    public String getRefPSDEFGroupId() {
        return this.psDER.getPSDEFGROUPID();
    }

    @Override
    public String getRefPSDEFGroupName() throws Exception {
        if (this.getRefPSDEFGroup() == null) {
            return "";
        }
        return this.getRefPSDEFGroup().getName();
    }

    @Override
    @PSModelRTMeta(description="\u5f15\u7528\u5b9e\u4f53\u5c5e\u6027\u7ec4", hideempty=true, dumpref=true, ignorepf=true, from="__self__", from_method="getMajorPSDataEntityMust().getPSDEFGroup", fields={"PSDEFGROUPID"})
    public IPSDEFGroup getRefPSDEFGroup() throws Exception {
        if (StringHelper.IsNullOrEmpty((String)this.getRefPSDEFGroupId())) {
            return null;
        }
        if (this.refPSDEFGroup == null) {
            this.refPSDEFGroup = this.getMajorPSDataEntity().getPSDEFGroup(this.getRefPSDEFGroupId());
        }
        return this.refPSDEFGroup;
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
    @PSModelRTMeta(description="\u7236\u7c7b\u578b")
    public String getParentType() {
        String[] items;
        String strTypeValue = this.getTypeValue();
        if (!StringHelper.IsNullOrEmpty((String)strTypeValue) && (items = strTypeValue.split("[:]")).length == 2) {
            return items[0];
        }
        return null;
    }

    @Override
    @PSModelRTMeta(description="\u7236\u5b50\u7c7b\u578b")
    public String getParentSubType() {
        String[] items;
        String strTypeValue = this.getTypeValue();
        if (!StringHelper.IsNullOrEmpty((String)strTypeValue) && (items = strTypeValue.split("[:]")).length == 2) {
            return items[1];
        }
        return strTypeValue;
    }

    @Override
    @PSModelRTMeta(description="\u514b\u9686\u6b21\u5e8f", ignoredumpvalues="-1", fields={"CLONEORDERVALUE"})
    public int getCloneOrder() {
        return this.nCloneOrder;
    }
}

