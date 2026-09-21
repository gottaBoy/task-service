/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Utility.StringHelper
 */
package SA.SRFDA.Ctrl;

import SA.SRFDA.Ctrl.BaseDAObjectHelper;
import SA.SRFDA.Ctrl.Data.DER11;
import SA.SRFDA.Ctrl.IDER11Helper;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.Utility.StringHelper;

public class DER11Helper
extends BaseDAObjectHelper
implements IDER11Helper {
    private boolean bSystem = false;
    private int nRemoveActionType = 0;
    private String strMajorDEName = "";
    private String strMajorDEId = "";
    private String strMinorDEId = "";
    private String strMinorDEName = "";
    private String strMajorDELogicName = "";
    private String strMinorDELogicName = "";
    private String strDERLogicName = "";
    private int nShowOrder = 0;
    private String strEditPageId = "";
    private String strEditPageName = "";
    private String strDERTypeId = "";
    private String strDERTypeName = "";
    private String strSmallIcon = "";
    private String strShowName = "";
    protected DER11 der11 = null;

    @Override
    public void Init(ISRFDAGlobalHelper iDAGlobalHelper, DER11 der11) throws Exception {
        this.setDAGlobalHelper(iDAGlobalHelper);
        this.der11 = der11;
        this.setId(this.der11.getDER11_ID());
        this.setName(this.der11.getDER11_NAME());
        this.InitModel(der11);
        this.OnInit();
    }

    @Override
    public boolean isSystem() {
        return this.bSystem;
    }

    protected void setSystem(boolean bValue) {
        this.bSystem = bValue;
    }

    @Override
    public int getRemoveActionType() {
        return this.nRemoveActionType;
    }

    protected void setRemoveActionType(int nValue) {
        this.nRemoveActionType = nValue;
    }

    @Override
    public String getMajorDEName() {
        return this.strMajorDEName;
    }

    protected void setMajorDEName(String strValue) {
        this.strMajorDEName = strValue;
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
    public String getMinorDEName() {
        return this.strMinorDEName;
    }

    protected void setMinorDEName(String strValue) {
        this.strMinorDEName = strValue;
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
    public String getDERLogicName() {
        return this.strDERLogicName;
    }

    protected void setDERLogicName(String strValue) {
        this.strDERLogicName = strValue;
    }

    @Override
    public int getShowOrder() {
        return this.nShowOrder;
    }

    protected void setShowOrder(int nValue) {
        this.nShowOrder = nValue;
    }

    @Override
    public String getEditPageId() {
        return this.strEditPageId;
    }

    protected void setEditPageId(String strValue) {
        this.strEditPageId = strValue;
    }

    @Override
    public String getEditPageName() {
        return this.strEditPageName;
    }

    protected void setEditPageName(String strValue) {
        this.strEditPageName = strValue;
    }

    @Override
    public String getDERTypeId() {
        return this.strDERTypeId;
    }

    protected void setDERTypeId(String strValue) {
        this.strDERTypeId = strValue;
    }

    @Override
    public String getDERTypeName() {
        return this.strDERTypeName;
    }

    protected void setDERTypeName(String strValue) {
        this.strDERTypeName = strValue;
    }

    @Override
    public String getSmallIcon() {
        if (!StringHelper.IsNullOrEmpty((String)this.strSmallIcon)) {
            return this.strSmallIcon;
        }
        return this.strSmallIcon;
    }

    protected void setSmallIcon(String strValue) {
        this.strSmallIcon = strValue;
    }

    @Override
    public String getShowName() {
        return this.strShowName;
    }

    protected void setShowName(String strValue) {
        this.strShowName = strValue;
    }

    protected void InitModel(DER11 item) {
        this.setSystem(item.getISSYSTEM());
        this.setRemoveActionType(item.getREMOVEACTIONTYPE());
        this.setMajorDEName(item.getMAJORDENAME());
        this.setMajorDEId(item.getMAJORDEID());
        this.setMinorDEId(item.getMINORDEID());
        this.setMinorDEName(item.getMINORDENAME());
        this.setMajorDELogicName(item.getMAJORDELOGICNAME());
        this.setMinorDELogicName(item.getMINORDELOGICNAME());
        this.setDERLogicName(item.getDERLOGICNAME());
        this.setShowOrder(item.getSHOWORDER());
        this.setEditPageId(item.getEDITPAGEID());
        this.setEditPageName(item.getEDITPAGNAME());
        this.setDERTypeId(item.getDERTYPEID());
        this.setDERTypeName(item.getDERTYPENAME());
        this.setSmallIcon(item.getSMALLICON());
        this.setShowName(item.getDERShowName());
    }
}

