/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.BR.Client;

public class BRParam {
    protected String strOpPersonId;
    protected String strParam;
    protected String strBREngineId;
    protected String strInstData;
    protected String strBRAction;
    protected String strDescription;
    protected String strMgrAction;

    public String getOpPersonId() {
        return this.strOpPersonId;
    }

    public String getParam() {
        return this.strParam;
    }

    public String getRuleEngineId() {
        return this.strBREngineId;
    }

    public String getInstData() {
        return this.strInstData;
    }

    public String getRuleAction() {
        return this.strBRAction;
    }

    public String getDescription() {
        return this.strDescription;
    }

    public void setOpPersonId(String strOpPersonId) {
        this.strOpPersonId = strOpPersonId;
    }

    public void setParam(String strParam) {
        this.strParam = strParam;
    }

    public void setRuleEngineId(String strBREngineId) {
        this.strBREngineId = strBREngineId;
    }

    public void setInstData(String strInstData) {
        this.strInstData = strInstData;
    }

    public void setRuleAction(String strBRAction) {
        this.strBRAction = strBRAction;
    }

    public void setDescription(String strDescription) {
        this.strDescription = strDescription;
    }

    public String getMgrAction() {
        return this.strMgrAction;
    }

    public void setMgrAction(String strMgrAction) {
        this.strMgrAction = strMgrAction;
    }
}

