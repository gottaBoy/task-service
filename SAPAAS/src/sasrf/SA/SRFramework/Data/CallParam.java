/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFramework.Data;

public class CallParam {
    protected Object objValue = null;
    protected int nDirection = 1;
    protected String strOutputParamName = "";
    protected int nDataType = 0;
    protected String strParamName = "";

    public CallParam() {
    }

    public CallParam Clone() {
        CallParam callParam = new CallParam();
        callParam.setDataType(this.nDataType);
        callParam.setDirection(this.nDirection);
        callParam.setOutputParamName(this.strOutputParamName);
        callParam.setParamName(this.strParamName);
        callParam.setValue(this.objValue);
        return callParam;
    }

    public CallParam(Object objValue) {
        this.objValue = objValue;
    }

    public CallParam(Object objValue, int nDataType) {
        this.objValue = objValue;
        this.nDataType = nDataType;
    }

    public Object getValue() {
        return this.objValue;
    }

    public void setValue(Object objValue) {
        this.objValue = objValue;
    }

    public int getDirection() {
        return this.nDirection;
    }

    public void setDirection(int direction) {
        this.nDirection = direction;
    }

    public String getOutputParamName() {
        return this.strOutputParamName;
    }

    public void setOutputParamName(String strOutputParamName) {
        this.strOutputParamName = strOutputParamName;
    }

    public int getDataType() {
        return this.nDataType;
    }

    public void setDataType(int nDataType) {
        this.nDataType = nDataType;
    }

    public String getParamName() {
        return this.strParamName;
    }

    public void setParamName(String strParamName) {
        this.strParamName = strParamName;
    }
}

