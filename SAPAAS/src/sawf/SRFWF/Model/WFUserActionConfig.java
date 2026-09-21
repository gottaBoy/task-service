/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Base.XMLConfig
 */
package SRFWF.Model;

import SA.SRFramework.Base.XMLConfig;
import SRFWF.Ctrl.Data.WFAction;

public class WFUserActionConfig
extends XMLConfig {
    public static final int ACTIONTYPE_BACKEND = 1;
    public static final int ACTIONTYPE_PAGELINK = 2;
    protected String strWFActionId = "";
    protected String strWFWorkflowID = "";
    protected String strActionName = "";
    protected String strActionLogicName = "";
    protected int nActionType = 2;
    protected String strBAHelper = "";
    protected String strPagePath = "";
    protected String strPageStyle = "";
    protected String strIconStyle = "";
    protected int nIsSupportMulti = 0;
    protected String strDescription = "";
    protected String strReserver = "";
    protected String strReserver2 = "";

    public String getReserver2() {
        return this.strReserver2;
    }

    public String getReserver() {
        return this.strReserver;
    }

    public String getDescription() {
        return this.strDescription;
    }

    public String getIconStyle() {
        return this.strIconStyle;
    }

    public String getPageStyle() {
        return this.strPageStyle;
    }

    public String getPagePath() {
        return this.strPagePath;
    }

    public String getButtonActionHelper() {
        return this.strBAHelper;
    }

    public String getActionLogicName() {
        return this.strActionLogicName;
    }

    public String getActionName() {
        return this.strActionName;
    }

    public String getWFWorkflowID() {
        return this.strWFWorkflowID;
    }

    public String getWFActionId() {
        return this.strWFActionId;
    }

    public void setReserver2(String strValue) {
        this.strReserver2 = strValue;
    }

    public void setReserver(String strValue) {
        this.strReserver = strValue;
    }

    public void setDescription(String strValue) {
        this.strDescription = strValue;
    }

    public void setIconStyle(String strValue) {
        this.strIconStyle = strValue;
    }

    public void setPageStyle(String strValue) {
        this.strPageStyle = strValue;
    }

    public void setPagePath(String strValue) {
        this.strPagePath = strValue;
    }

    public void setButtonActionHelper(String strValue) {
        this.strBAHelper = strValue;
    }

    public void setActionLogicName(String strValue) {
        this.strActionLogicName = strValue;
    }

    public void setActionName(String strValue) {
        this.strActionName = strValue;
    }

    public void setWFWorkflowID(String strValue) {
        this.strWFWorkflowID = strValue;
    }

    public void setWFActionId(String strValue) {
        this.strWFActionId = strValue;
    }

    public boolean isSUPPORTMULTI() {
        return this.nIsSupportMulti == 1;
    }

    public int getActionType() {
        return this.nActionType;
    }

    public void setActionType(int nValue) {
        this.nActionType = nValue;
    }

    public void setSUPPORTMULTI(boolean bValue) {
        this.nIsSupportMulti = bValue ? 1 : 0;
    }

    public void From(WFAction action) {
        this.setWFActionId(action.getWFACTIONID());
        this.setWFWorkflowID(action.getWFWORKFLOWID());
        this.setActionName(action.getACTIONNAME());
        this.setActionLogicName(action.getACTIONLOGICNAME());
        this.setActionType(action.getACTIONTYPE());
        this.setButtonActionHelper(action.getBAHELPER());
        this.setPagePath(action.getPAGEPATH());
        this.setPageStyle(action.getPAGESTYLE());
        this.setIconStyle(action.getICONSTYLE());
        this.setSUPPORTMULTI(action.isSUPPORTMULTI());
        this.setDescription(action.getDESCRIPTION());
        this.setReserver(action.getRESERVER());
        this.setReserver2(action.getRESERVER2());
    }
}

