/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Ctrl.BaseDAObjectHelper
 *  SA.SRFDA.Ctrl.Data.DERType
 *  SA.SRFDA.Ctrl.IDERTypeHelper
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 */
package SA.SRFDA.Ctrl;

import SA.SRFDA.Ctrl.BaseDAObjectHelper;
import SA.SRFDA.Ctrl.Data.DERType;
import SA.SRFDA.Ctrl.IDERTypeHelper;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;

public class DERTypeHelper
extends BaseDAObjectHelper
implements IDERTypeHelper {
    private String strDEName = "";
    private String strDEId = "";
    private String strDescription = "";
    private String strSmallIcon = "";
    private String strReserver = "";
    private String strReserver2 = "";
    private int nOrderFlag = 0;
    private boolean bCollapse = false;
    private String strDERTypeNameLanResId = "";
    private String strDERTypeNameLanResName = "";
    protected DERType derType = null;

    public void Init(ISRFDAGlobalHelper iDAGlobalHelper, DERType derType) throws Exception {
        this.setDAGlobalHelper(iDAGlobalHelper);
        this.setId(derType.getDERTYPEID());
        this.setName(derType.getDERTYPENAME());
        this.derType = derType;
        this.InitModel(derType);
        this.OnInit();
    }

    public String getDEName() {
        return this.strDEName;
    }

    protected void setDEName(String strValue) {
        this.strDEName = strValue;
    }

    public String getDEId() {
        return this.strDEId;
    }

    protected void setDEId(String strValue) {
        this.strDEId = strValue;
    }

    public String getDescription() {
        return this.strDescription;
    }

    protected void setDescription(String strValue) {
        this.strDescription = strValue;
    }

    public String getSmallIcon() {
        return this.strSmallIcon;
    }

    protected void setSmallIcon(String strValue) {
        this.strSmallIcon = strValue;
    }

    public String getReserver() {
        return this.strReserver;
    }

    protected void setReserver(String strValue) {
        this.strReserver = strValue;
    }

    public String getReserver2() {
        return this.strReserver2;
    }

    protected void setReserver2(String strValue) {
        this.strReserver2 = strValue;
    }

    public int getOrderFlag() {
        return this.nOrderFlag;
    }

    protected void setOrderFlag(int nValue) {
        this.nOrderFlag = nValue;
    }

    public boolean isCollapse() {
        return this.bCollapse;
    }

    protected void setCollapse(boolean bValue) {
        this.bCollapse = bValue;
    }

    public String getDERTypeNameLanResId() {
        return this.strDERTypeNameLanResId;
    }

    protected void setDERTypeNameLanResId(String strValue) {
        this.strDERTypeNameLanResId = strValue;
    }

    public String getDERTypeNameLanResName() {
        return this.strDERTypeNameLanResName;
    }

    protected void setDERTypeNameLanResName(String strValue) {
        this.strDERTypeNameLanResName = strValue;
    }

    protected void InitModel(DERType item) {
        this.setDEName(item.getDATAENTITY_DENAME());
        this.setDEId(item.getDEID());
        this.setDescription(item.getDESCRIPTION());
        this.setSmallIcon(item.getSMALLICON());
        this.setReserver(item.getRESERVER());
        this.setReserver2(item.getRESERVER2());
        this.setOrderFlag(item.getORDERFLAG());
        this.setCollapse(item.getISCOLLAPSE());
        this.setDERTypeNameLanResId(item.getDERTYPENAMELANRESID());
        this.setDERTypeNameLanResName(item.getDERTYPENAMELANRESNAME());
    }
}

