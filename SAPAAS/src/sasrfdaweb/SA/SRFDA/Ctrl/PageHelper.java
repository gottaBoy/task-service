/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Ctrl.BaseDAObjectHelper
 *  SA.SRFDA.Ctrl.Data.Page
 *  SA.SRFDA.Ctrl.IPageHelper
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 */
package SA.SRFDA.Ctrl;

import SA.SRFDA.Ctrl.BaseDAObjectHelper;
import SA.SRFDA.Ctrl.Data.Page;
import SA.SRFDA.Ctrl.IPageHelper;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;

public class PageHelper
extends BaseDAObjectHelper
implements IPageHelper {
    protected Page page = null;
    private String strPageId = "";
    private String strPageName = "";
    private int nPageType = 0;
    private String strPagePath = "";
    private String strWindowStyle = "";
    private int nWidth = 0;
    private int nHeight = 0;
    private boolean bModalStyle = false;
    private String strDescription = "";
    private String strReserver = "";
    private String strReserver2 = "";
    private String strWTParam = "";
    private String strPageParam = "";
    private String strPageTemplId = "";
    private String strPageTemplName = "";
    private String strToolbar = "";
    private String strDEId = "";
    private String strDEName = "";
    private String strPageObject = "";
    private String strUserMode = "";
    private String strAppendParam = "";
    private String strResourceId = "";
    private String strResType = "";
    private String strResDataAction = "";
    private String strPageHeader = "";
    private String strPageScript = "";
    private int nPageFunc = 0;
    private boolean bEnableAdvPageParam = false;
    private String strPageFuncType = "";
    private String strToolbarId = "";
    private String strToolbarName = "";
    private String strSLUIPart = "";
    private String strPageHelper = "";
    private String strFullPagePath = "";

    public void Init(ISRFDAGlobalHelper iDAGlobalHelper, Page page) throws Exception {
        this.page = page;
        this.setDAGlobalHelper(iDAGlobalHelper);
        this.setId(page.getPAGEID());
        this.setName(page.getPAGENAME());
        this.setVersion(page.getVERSION() * page.getPTVERSION());
        this.InitModel(this.page);
        this.OnInit();
    }

    public Page getData() {
        return this.page;
    }

    public String getPageId() {
        return this.strPageId;
    }

    protected void setPageId(String strValue) {
        this.strPageId = strValue;
    }

    public String getPageName() {
        return this.strPageName;
    }

    protected void setPageName(String strValue) {
        this.strPageName = strValue;
    }

    public int getPageType() {
        return this.nPageType;
    }

    protected void setPageType(int nValue) {
        this.nPageType = nValue;
    }

    public String getPagePath() {
        return this.strPagePath;
    }

    protected void setPagePath(String strValue) {
        this.strPagePath = strValue;
    }

    public String getWindowStyle() {
        return this.strWindowStyle;
    }

    protected void setWindowStyle(String strValue) {
        this.strWindowStyle = strValue;
    }

    public int getWidth() {
        return this.nWidth;
    }

    protected void setWidth(int nValue) {
        this.nWidth = nValue;
    }

    public int getHeight() {
        return this.nHeight;
    }

    protected void setHeight(int nValue) {
        this.nHeight = nValue;
    }

    public boolean isModalStyle() {
        return this.bModalStyle;
    }

    protected void setModalStyle(boolean bValue) {
        this.bModalStyle = bValue;
    }

    public String getDescription() {
        return this.strDescription;
    }

    protected void setDescription(String strValue) {
        this.strDescription = strValue;
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

    public String getWTParam() {
        return this.strWTParam;
    }

    protected void setWTParam(String strValue) {
        this.strWTParam = strValue;
    }

    public String getPageParam() {
        return this.strPageParam;
    }

    protected void setPageParam(String strValue) {
        this.strPageParam = strValue;
    }

    public String getPageTemplId() {
        return this.strPageTemplId;
    }

    protected void setPageTemplId(String strValue) {
        this.strPageTemplId = strValue;
    }

    public String getPageTemplName() {
        return this.strPageTemplName;
    }

    protected void setPageTemplName(String strValue) {
        this.strPageTemplName = strValue;
    }

    public String getToolbar() {
        return this.strToolbar;
    }

    protected void setToolbar(String strValue) {
        this.strToolbar = strValue;
    }

    public String getDEId() {
        return this.strDEId;
    }

    protected void setDEId(String strValue) {
        this.strDEId = strValue;
    }

    public String getDEName() {
        return this.strDEName;
    }

    protected void setDEName(String strValue) {
        this.strDEName = strValue;
    }

    public String getPageObject() {
        return this.strPageObject;
    }

    protected void setPageObject(String strValue) {
        this.strPageObject = strValue;
    }

    public String getUserMode() {
        return this.strUserMode;
    }

    protected void setUserMode(String strValue) {
        this.strUserMode = strValue;
    }

    public String getAppendParam() {
        return this.strAppendParam;
    }

    protected void setAppendParam(String strValue) {
        this.strAppendParam = strValue;
    }

    public String getResourceId() {
        return this.strResourceId;
    }

    protected void setResourceId(String strValue) {
        this.strResourceId = strValue;
    }

    public String getResType() {
        return this.strResType;
    }

    protected void setResType(String strValue) {
        this.strResType = strValue;
    }

    public String getResDataAction() {
        return this.strResDataAction;
    }

    protected void setResDataAction(String strValue) {
        this.strResDataAction = strValue;
    }

    public String getPageHeader() {
        return this.strPageHeader;
    }

    protected void setPageHeader(String strValue) {
        this.strPageHeader = strValue;
    }

    public String getPageScript() {
        return this.strPageScript;
    }

    protected void setPageScript(String strValue) {
        this.strPageScript = strValue;
    }

    public int getPageFunc() {
        return this.nPageFunc;
    }

    protected void setPageFunc(int nValue) {
        this.nPageFunc = nValue;
    }

    public boolean isEnableAdvPageParam() {
        return this.bEnableAdvPageParam;
    }

    protected void setEnableAdvPageParam(boolean bValue) {
        this.bEnableAdvPageParam = bValue;
    }

    public String getPageFuncType() {
        return this.strPageFuncType;
    }

    protected void setPageFuncType(String strValue) {
        this.strPageFuncType = strValue;
    }

    public String getToolbarId() {
        return this.strToolbarId;
    }

    protected void setToolbarId(String strValue) {
        this.strToolbarId = strValue;
    }

    public String getToolbarName() {
        return this.strToolbarName;
    }

    protected void setToolbarName(String strValue) {
        this.strToolbarName = strValue;
    }

    public String getSLUIPart() {
        return this.strSLUIPart;
    }

    protected void setSLUIPart(String strValue) {
        this.strSLUIPart = strValue;
    }

    public String getPageHelper() {
        return this.strPageHelper;
    }

    protected void setPageHelper(String strValue) {
        this.strPageHelper = strValue;
    }

    protected void InitModel(Page item) {
        this.setPageId(item.getPAGEID());
        this.setPageName(item.getPAGENAME());
        this.setPageType(item.getPAGETYPE());
        this.setPagePath(item.getPAGEPATH());
        this.setWindowStyle(item.getWINDOWSTYLE());
        this.setWidth(item.getWIDTH());
        this.setHeight(item.getHEIGHT());
        this.setModalStyle(item.getISMODELSTYLE());
        this.setDescription(item.getDESCRIPTION());
        this.setReserver(item.getRESERVER());
        this.setReserver2(item.getRESERVER2());
        this.setWTParam(item.getWTPARAM());
        this.setPageParam(item.getPAGEPARAM());
        this.setVersion(item.getVERSION());
        this.setPageTemplId(item.getPAGETEMPLID());
        this.setPageTemplName(item.getPAGETEMPLNAME());
        this.setToolbar(item.getTOOLBAR());
        this.setDEId(item.getDEID());
        this.setDEName(item.getDENAME());
        this.setPageObject(item.getPAGEOBJECT());
        this.setUserMode(item.getUSERMODE());
        this.setAppendParam(item.getAPPENDPARAM());
        this.setResourceId(item.getRESOURCEID());
        this.setResType(item.getRESTYPE());
        this.setResDataAction(item.getRESDATAACTION());
        this.setPageHeader(item.getPAGEHEADER());
        this.setPageScript(item.getPAGESCRIPT());
        this.setPageFunc(item.getPAGEFUNC());
        this.setEnableAdvPageParam(item.getENABLEADVPAGEPARAM());
        this.setPageFuncType(item.getPAGEFUNCTYPE());
        this.setToolbarId(item.getTOOLBARID());
        this.setToolbarName(item.getTOOLBARNAME());
        this.setSLUIPart(item.getSLUIPART());
        this.setPageHelper(item.getPAGEHELPER());
        this.setFullPagePath(item.GetTotalPagePath());
    }

    public String getFullPagePath() {
        return this.strFullPagePath;
    }

    protected void setFullPagePath(String strValue) {
        this.strFullPagePath = strValue;
    }

    public String getResourceId(String strDEId) throws Exception {
        return this.page.getRESOURCEID(strDEId);
    }

    public String getPageParam(String strKey, String strDefault) {
        return this.page.GetPageProperty(strKey, strDefault);
    }

    public boolean getPageParam(String strKey, boolean bDefault) {
        return this.page.GetPageProperty(strKey, bDefault);
    }

    public int getPageParam(String strKey, int nDefault) {
        return this.page.GetPageProperty(strKey, nDefault);
    }
}

