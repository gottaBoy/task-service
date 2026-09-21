/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Ctrl.BaseDAObjectHelper
 *  SA.SRFDA.Ctrl.Data.SummaryPage
 *  SA.SRFDA.Ctrl.ISummaryPageHelper
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 */
package SA.SRFDA.Ctrl;

import SA.SRFDA.Ctrl.BaseDAObjectHelper;
import SA.SRFDA.Ctrl.Data.SummaryPage;
import SA.SRFDA.Ctrl.ISummaryPageHelper;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;

public class SummaryPageHelper
extends BaseDAObjectHelper
implements ISummaryPageHelper {
    private String strSPType = "";
    private String strDEId = "";
    private String strFormId = "";
    private String strPageId = "";
    private String strDERTypeId = "";
    private String strSmallIcon = "";
    private int nDERShowOrder = 0;
    private int nSumShowOrder = 0;
    private String strAppendparam = "";
    private String strDescription = "";
    private String strNameLanResId = "";
    protected SummaryPage summaryPage = null;

    public void Init(ISRFDAGlobalHelper iDAGlobalHelper, SummaryPage summaryPage) throws Exception {
        this.setDAGlobalHelper(iDAGlobalHelper);
        this.summaryPage = summaryPage;
        this.setId(summaryPage.getSUMMARYPAGEID());
        this.setName(summaryPage.getSUMMARYPAGENAME());
        this.InitModel(summaryPage);
        this.OnInit();
    }

    public String getSPType() {
        return this.strSPType;
    }

    protected void setSPType(String strValue) {
        this.strSPType = strValue;
    }

    public String getDEId() {
        return this.strDEId;
    }

    protected void setDEId(String strValue) {
        this.strDEId = strValue;
    }

    public String getFormId() {
        return this.strFormId;
    }

    protected void setFormId(String strValue) {
        this.strFormId = strValue;
    }

    public String getPageId() {
        return this.strPageId;
    }

    protected void setPageId(String strValue) {
        this.strPageId = strValue;
    }

    public String getDERTypeId() {
        return this.strDERTypeId;
    }

    protected void setDERTypeId(String strValue) {
        this.strDERTypeId = strValue;
    }

    public String getSmallIcon() {
        return this.strSmallIcon;
    }

    protected void setSmallIcon(String strValue) {
        this.strSmallIcon = strValue;
    }

    public int getDERShowOrder() {
        return this.nDERShowOrder;
    }

    protected void setDERShowOrder(int nValue) {
        this.nDERShowOrder = nValue;
    }

    public int getSumShowOrder() {
        return this.nSumShowOrder;
    }

    protected void setSumShowOrder(int nValue) {
        this.nSumShowOrder = nValue;
    }

    public String getAppendparam() {
        return this.strAppendparam;
    }

    protected void setAppendparam(String strValue) {
        this.strAppendparam = strValue;
    }

    public String getDescription() {
        return this.strDescription;
    }

    protected void setDescription(String strValue) {
        this.strDescription = strValue;
    }

    public String getNameLanResId() {
        return this.strNameLanResId;
    }

    protected void setNameLanResId(String strValue) {
        this.strNameLanResId = strValue;
    }

    protected void InitModel(SummaryPage item) {
        this.setSPType(item.getSPTYPE());
        this.setDEId(item.getDEID());
        this.setFormId(item.getFORMID());
        this.setPageId(item.getPAGEID());
        this.setDERTypeId(item.getDERTYPEID());
        this.setSmallIcon(item.getSMALLICON());
        this.setDERShowOrder(item.getDERSHOWORDER());
        this.setSumShowOrder(item.getSUMSHOWORDER());
        this.setAppendparam(item.getAPPENDPARAM());
        this.setDescription(item.getDESCRIPTION());
        this.setNameLanResId(item.getNAMELANRESID());
    }
}

