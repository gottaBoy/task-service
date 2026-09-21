/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Utility.StringHelper
 */
package SA.SRFDA.Ctrl;

import SA.SRFDA.Ctrl.BaseDAObjectHelper;
import SA.SRFDA.Ctrl.Data.DER1N;
import SA.SRFDA.Ctrl.IDEHelper;
import SA.SRFDA.Ctrl.IDER1NHelper;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.Utility.StringHelper;

public class DER1NHelper
extends BaseDAObjectHelper
implements IDER1NHelper {
    private String strDERLogicName = "";
    private String strDescription = "";
    private String strReserver = "";
    private String strReserver2 = "";
    private boolean bNullable = false;
    private boolean bSystem = false;
    private int nShowOrder = 0;
    private int nDERType = 0;
    private String strMajorDEName = "";
    private String strMinorDEName = "";
    private String strDERTypeName = "";
    private String strMajorKeyDEFName = "";
    private String strMajorTextDEFName = "";
    private String strMajorDEId = "";
    private String strMinorDEId = "";
    private int nDERSubType = 0;
    private String strDERTypeId = "";
    private String strMajorDELogicName = "";
    private String strMinorDELogicName = "";
    private int nRemoveActionType = 0;
    private boolean bMTField = false;
    private String strRangeCond = "";
    private String strShowName1N = "";
    private String strPickupPageId = "";
    private String strPickupPageName = "";
    private String strRelatedPageId = "";
    private String strRelatedPageName = "";
    private String strSmallIcon = "";
    private String strMPickupPageId = "";
    private String strMPickupPageName = "";
    private String strTabViewbarCond = "";
    private boolean bPhysicalMode = false;
    private String strPhysicalUpdateMode = "";
    private String strDEACModeId = "";
    private String strDEACModeName = "";
    private boolean bForeignKey = false;
    private int nExportOrder = 0;
    private String strShowNameLanResId = "";
    private String strShowNameLanResName = "";
    private boolean bSyncModel = false;
    private String strQueryModelId = "";
    protected DER1N der1n;

    @Override
    public void Init(ISRFDAGlobalHelper iDAGlobalHelper, DER1N der1n) throws Exception {
        this.setDAGlobalHelper(iDAGlobalHelper);
        this.der1n = der1n;
        if (this.der1n == null) {
            throw new Exception("1:N\u5173\u7cfb\u5bf9\u8c61\u65e0\u6548");
        }
        this.setId(der1n.getDERID());
        this.setName(der1n.getDERNAME());
        this.InitModel(der1n);
        this.OnInit();
    }

    @Override
    public String getDERLogicName() {
        return this.strDERLogicName;
    }

    protected void setDERLogicName(String strValue) {
        this.strDERLogicName = strValue;
    }

    @Override
    public String getDescription() {
        return this.strDescription;
    }

    protected void setDescription(String strValue) {
        this.strDescription = strValue;
    }

    @Override
    public String getReserver() {
        return this.strReserver;
    }

    protected void setReserver(String strValue) {
        this.strReserver = strValue;
    }

    @Override
    public String getReserver2() {
        return this.strReserver2;
    }

    protected void setReserver2(String strValue) {
        this.strReserver2 = strValue;
    }

    @Override
    public boolean isNullable() {
        return this.bNullable;
    }

    protected void setNullable(boolean bValue) {
        this.bNullable = bValue;
    }

    @Override
    public boolean isSystem() {
        return this.bSystem;
    }

    protected void setSystem(boolean bValue) {
        this.bSystem = bValue;
    }

    @Override
    public int getShowOrder() {
        return this.nShowOrder;
    }

    protected void setShowOrder(int nValue) {
        this.nShowOrder = nValue;
    }

    @Override
    public int getDERType() {
        return this.nDERType;
    }

    protected void setDERType(int nValue) {
        this.nDERType = nValue;
    }

    @Override
    public String getMajorDEName() {
        return this.strMajorDEName;
    }

    protected void setMajorDEName(String strValue) {
        this.strMajorDEName = strValue;
    }

    @Override
    public String getMinorDEName() {
        return this.strMinorDEName;
    }

    protected void setMinorDEName(String strValue) {
        this.strMinorDEName = strValue;
    }

    @Override
    public String getDERTypeName() {
        return this.strDERTypeName;
    }

    protected void setDERTypeName(String strValue) {
        this.strDERTypeName = strValue;
    }

    @Override
    public String getMajorKeyDEFName() {
        return this.strMajorKeyDEFName;
    }

    protected void setMajorKeyDEFName(String strValue) {
        this.strMajorKeyDEFName = strValue;
    }

    @Override
    public String getMajorTextDEFName() {
        return this.strMajorTextDEFName;
    }

    protected void setMajorTextDEFName(String strValue) {
        this.strMajorTextDEFName = strValue;
    }

    @Override
    public String getMajorDEId() {
        return this.strMajorDEId;
    }

    protected void setMajorDEId(String strValue) {
        this.strMajorDEId = strValue;
    }

    @Override
    public String getMinorDEId() {
        return this.strMinorDEId;
    }

    protected void setMinorDEId(String strValue) {
        this.strMinorDEId = strValue;
    }

    @Override
    public int getDERSubType() {
        return this.nDERSubType;
    }

    protected void setDERSubType(int nValue) {
        this.nDERSubType = nValue;
    }

    @Override
    public String getDERTypeId() {
        return this.strDERTypeId;
    }

    protected void setDERTypeId(String strValue) {
        this.strDERTypeId = strValue;
    }

    @Override
    public String getMajorDELogicName() {
        return this.strMajorDELogicName;
    }

    protected void setMajorDELogicName(String strValue) {
        this.strMajorDELogicName = strValue;
    }

    @Override
    public String getMinorDELogicName() {
        return this.strMinorDELogicName;
    }

    protected void setMinorDELogicName(String strValue) {
        this.strMinorDELogicName = strValue;
    }

    @Override
    public int getRemoveActionType() {
        return this.nRemoveActionType;
    }

    protected void setRemoveActionType(int nValue) {
        this.nRemoveActionType = nValue;
    }

    @Override
    public boolean isMTField() {
        return this.bMTField;
    }

    protected void setMTField(boolean bValue) {
        this.bMTField = bValue;
    }

    @Override
    public String getRangeCond() {
        return this.strRangeCond;
    }

    protected void setRangeCond(String strValue) {
        this.strRangeCond = strValue;
    }

    @Override
    public String getShowName1N() {
        return this.strShowName1N;
    }

    protected void setShowName1N(String strValue) {
        this.strShowName1N = strValue;
    }

    @Override
    public String getPickupPageId() {
        return this.strPickupPageId;
    }

    protected void setPickupPageId(String strValue) {
        this.strPickupPageId = strValue;
    }

    @Override
    public String getPickupPageName() {
        return this.strPickupPageName;
    }

    protected void setPickupPageName(String strValue) {
        this.strPickupPageName = strValue;
    }

    @Override
    public String getRelatedPageId() throws Exception {
        if (!StringHelper.IsNullOrEmpty((String)this.strRelatedPageId)) {
            return this.strRelatedPageId;
        }
        IDEHelper iMinorDEHelper = this.getDAModelStorage().FindDEHelper2(this.getMinorDEId());
        return iMinorDEHelper.GetGridPageId();
    }

    protected void setRelatedPageId(String strValue) {
        this.strRelatedPageId = strValue;
    }

    @Override
    public String getRelatedPageName() {
        return this.strRelatedPageName;
    }

    protected void setRelatedPageName(String strValue) {
        this.strRelatedPageName = strValue;
    }

    @Override
    public String getSmallIcon() {
        return this.strSmallIcon;
    }

    protected void setSmallIcon(String strValue) {
        this.strSmallIcon = strValue;
    }

    @Override
    public String getMPickupPageId() {
        return this.strMPickupPageId;
    }

    protected void setMPickupPageId(String strValue) {
        this.strMPickupPageId = strValue;
    }

    @Override
    public String getMPickupPageName() {
        return this.strMPickupPageName;
    }

    protected void setMPickupPageName(String strValue) {
        this.strMPickupPageName = strValue;
    }

    @Override
    public String getTabViewbarCond() {
        return this.strTabViewbarCond;
    }

    protected void setTabViewbarCond(String strValue) {
        this.strTabViewbarCond = strValue;
    }

    @Override
    public boolean isPhysicalMode() {
        return this.bPhysicalMode;
    }

    protected void setPhysicalMode(boolean bValue) {
        this.bPhysicalMode = bValue;
    }

    @Override
    public String getPhysicalUpdateMode() {
        return this.strPhysicalUpdateMode;
    }

    protected void setPhysicalUpdateMode(String strValue) {
        this.strPhysicalUpdateMode = strValue;
    }

    @Override
    public String getDEACModeId() {
        return this.strDEACModeId;
    }

    protected void setDEACModeId(String strValue) {
        this.strDEACModeId = strValue;
    }

    @Override
    public String getDEACModeName() {
        return this.strDEACModeName;
    }

    protected void setDEACModeName(String strValue) {
        this.strDEACModeName = strValue;
    }

    @Override
    public boolean isForeignKey() {
        return this.bForeignKey;
    }

    protected void setForeignKey(boolean bValue) {
        this.bForeignKey = bValue;
    }

    @Override
    public int getExportOrder() {
        return this.nExportOrder;
    }

    protected void setExportOrder(int nValue) {
        this.nExportOrder = nValue;
    }

    @Override
    public String getShowNameLanResId() {
        return this.strShowNameLanResId;
    }

    protected void setShowNameLanResId(String strValue) {
        this.strShowNameLanResId = strValue;
    }

    @Override
    public String getShowNameLanResName() {
        return this.strShowNameLanResName;
    }

    protected void setShowNameLanResName(String strValue) {
        this.strShowNameLanResName = strValue;
    }

    @Override
    public boolean isSyncModel() {
        return this.bSyncModel;
    }

    protected void setSyncModel(boolean bValue) {
        this.bSyncModel = bValue;
    }

    @Override
    public final String getQueryModelId() {
        return this.strQueryModelId;
    }

    protected final void setQueryModelId(String strValue) {
        this.strQueryModelId = strValue;
    }

    private void InitModel(DER1N item) {
        this.setDERLogicName(item.getDERLOGICNAME());
        this.setDescription(item.getDESCRIPTION());
        this.setReserver(item.getRESERVER());
        this.setReserver2(item.getRESERVER2());
        this.setNullable(item.getISNULLABLE());
        this.setSystem(item.getISSYSTEM());
        this.setShowOrder(item.getSHOWORDER());
        this.setDERType(item.getDERTYPE());
        this.setMajorDEName(item.getMAJORDENAME());
        this.setMinorDEName(item.getMINORDENAME());
        this.setDERTypeName(item.getDERTYPENAME());
        this.setMajorKeyDEFName(item.getMAJORKEYDEFNAME());
        this.setMajorTextDEFName(item.getMAJORTEXTDEFNAME());
        this.setMajorDEId(item.getMAJORDEID());
        this.setMinorDEId(item.getMINORDEID());
        this.setDERSubType(item.getDERSUBTYPE());
        this.setDERTypeId(item.getDERTYPEID());
        this.setMajorDELogicName(item.getMAJORDELOGICNAME());
        this.setMinorDELogicName(item.getMINORDELOGICNAME());
        this.setRemoveActionType(item.getREMOVEACTIONTYPE());
        this.setMTField(item.getISMTFIELD());
        this.setRangeCond(item.getRANGECOND());
        this.setShowName1N(item.getSHOWNAME1N());
        this.setPickupPageId(item.getPICKUPPAGEID());
        this.setPickupPageName(item.getPICKUPPAGENAME());
        this.setRelatedPageId(item.getRELATEDPAGEID());
        this.setRelatedPageName(item.getRELATEDPAGENAME());
        this.setSmallIcon(item.getSMALLICON());
        this.setMPickupPageId(item.getMPICKUPPAGEID());
        this.setMPickupPageName(item.getMPICKUPPAGENAME());
        this.setTabViewbarCond(item.getTABVIEWBARCOND());
        this.setPhysicalMode(item.getPHYSICALMODE());
        this.setPhysicalUpdateMode(item.getPHYSICALUPDATEMODE());
        this.setDEACModeId(item.getDEACMODEID());
        this.setDEACModeName(item.getDEACMODENAME());
        this.setForeignKey(item.getFOREIGNKEY());
        this.setExportOrder(item.getEXPORTORDER());
        this.setShowNameLanResId(item.getSHOWNAMELANRESID());
        this.setShowNameLanResName(item.getSHOWNAMELANRESNAME());
        this.setSyncModel(item.getSYNCMODEL());
        if (!item.isQUERYMODELIDNull()) {
            this.setQueryModelId(item.getQUERYMODELID());
        }
    }
}

