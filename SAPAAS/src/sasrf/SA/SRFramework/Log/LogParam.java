/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFramework.Log;

public class LogParam {
    protected Object objInfo;
    protected Throwable arg1;
    protected Object objContext;
    protected String strUserData;
    protected String strUserData2;
    protected String strUserData3;
    protected String strUserData4;

    public LogParam(Object objInfo, Throwable arg1, Object obj1, Object objUserData, Object objUserData2, Object objUserData3, Object objUserData4) {
        this.objInfo = objInfo;
        this.arg1 = arg1;
        this.objContext = obj1;
        if (objUserData != null) {
            this.strUserData = objUserData.toString();
        }
        if (objUserData2 != null) {
            this.strUserData2 = objUserData2.toString();
        }
        if (objUserData3 != null) {
            this.strUserData3 = objUserData3.toString();
        }
        if (objUserData4 != null) {
            this.strUserData4 = objUserData4.toString();
        }
    }

    public String getUserData() {
        return this.strUserData;
    }

    public String getUserData2() {
        return this.strUserData2;
    }

    public String getUserData3() {
        return this.strUserData3;
    }

    public String getUserData4() {
        return this.strUserData4;
    }

    public void setUserData(String strUserData) {
        this.strUserData = strUserData;
    }

    public void setUserData2(String strUserData2) {
        this.strUserData2 = strUserData2;
    }

    public void setUserData3(String strUserData3) {
        this.strUserData3 = strUserData3;
    }

    public void setUserData4(String strUserData4) {
        this.strUserData4 = strUserData4;
    }

    public String toString() {
        return this.objInfo.toString();
    }

    public Object getObjContext() {
        return this.objContext;
    }

    public void setObjContext(Object objContext) {
        this.objContext = objContext;
    }

    public String getLogInfo() {
        if (this.objInfo == null) {
            return "";
        }
        return this.objInfo.toString();
    }

    public void setLogInfo(Object objInfo) {
        this.objInfo = objInfo;
    }
}

