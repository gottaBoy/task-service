/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Data.DBResult
 *  SA.SRFramework.Utility.StringHelper
 */
package SA.SRFramework.DataEx;

import SA.SRFramework.CommonEx.Errors;
import SA.SRFramework.Data.DBResult;
import SA.SRFramework.Utility.StringHelper;

public class CallResult {
    protected int nRetCode = 0;
    protected String strErrorInfo = "";
    protected String strErrorInfoRes = "";
    protected String strErrorInfoResArg = "";
    protected Object userObject = null;

    public int getRetCode() {
        return this.nRetCode;
    }

    public void setRetCode(int value) {
        this.nRetCode = value;
        if (this.nRetCode == -1) {
            this.nRetCode = 1;
        }
    }

    public String getErrorInfo() {
        if (this.nRetCode == 0) {
            return "";
        }
        if (StringHelper.Length((String)this.strErrorInfo) == 0) {
            return Errors.GetErrorInfo(this.nRetCode);
        }
        return this.strErrorInfo;
    }

    public void setErrorInfo(String value) {
        this.strErrorInfo = value;
    }

    public boolean isUserError() {
        return this.IsUserError();
    }

    @Deprecated
    public boolean IsUserError() {
        return Errors.IsUserError(this.nRetCode);
    }

    public boolean isError() {
        return this.IsError();
    }

    @Deprecated
    public boolean IsError() {
        return this.nRetCode != 0;
    }

    public boolean isOk() {
        return this.IsOk();
    }

    @Deprecated
    public boolean IsOk() {
        return this.nRetCode == 0;
    }

    public void fill(CallResult result) {
        this.Fill(result);
    }

    @Deprecated
    public void Fill(CallResult result) {
        result.setRetCode(this.nRetCode);
        result.setErrorInfo(this.strErrorInfo);
        result.setUserObject(this.userObject);
    }

    public void from(CallResult result) {
        this.From(result);
    }

    @Deprecated
    public void From(CallResult result) {
        this.setRetCode(result.getRetCode());
        this.setErrorInfo(result.getErrorInfo());
        this.setUserObject(result.getUserObject());
        this.setErrorInfoRes(result.getErrorInfoRes());
        this.setErrorInfoResArg(result.getErrorInfoResArg());
    }

    public void from(DBResult dbResult) {
        this.From(dbResult);
    }

    @Deprecated
    public void From(DBResult dbResult) {
        this.setRetCode(dbResult.getRetCode());
        this.setErrorInfo(dbResult.getErrorInfo());
    }

    public Object getUserObject() {
        return this.userObject;
    }

    public void setUserObject(Object userObject) {
        this.userObject = userObject;
    }

    public String getErrorInfoRes() {
        return this.strErrorInfoRes;
    }

    public String getErrorInfoResArg() {
        return this.strErrorInfoResArg;
    }

    public void setErrorInfoRes(String strErrorInfoRes) {
        this.strErrorInfoRes = strErrorInfoRes;
    }

    public void setErrorInfoResArg(String strErrorInfoResArg) {
        this.strErrorInfoResArg = strErrorInfoResArg;
    }

    public void reformatErrorInfo(String strFormat) {
        this.strErrorInfo = StringHelper.Format((String)strFormat, (Object)this.strErrorInfo);
    }

    @Deprecated
    public void ReformatErrorInfo(String strFormat) {
        this.strErrorInfo = StringHelper.Format((String)strFormat, (Object)this.strErrorInfo);
    }

    public void reset() {
        this.Reset();
    }

    @Deprecated
    public void Reset() {
        this.nRetCode = 0;
        this.strErrorInfo = "";
        this.strErrorInfoRes = "";
        this.strErrorInfoResArg = "";
        this.userObject = null;
    }

    public static CallResult create(int nCode) {
        return CallResult.Create(nCode);
    }

    @Deprecated
    public static CallResult Create(int nCode) {
        CallResult callResult = new CallResult();
        callResult.setRetCode(nCode);
        return callResult;
    }

    public static CallResult create(int nCode, String strErrorInfo) {
        return CallResult.Create(nCode, strErrorInfo);
    }

    @Deprecated
    public static CallResult Create(int nCode, String strErrorInfo) {
        CallResult callResult = new CallResult();
        callResult.setRetCode(nCode);
        callResult.setErrorInfo(strErrorInfo);
        return callResult;
    }

    public static CallResult create(int nCode, String strErrorInfo, Object objUserObject) {
        return CallResult.Create(nCode, strErrorInfo, objUserObject);
    }

    @Deprecated
    public static CallResult Create(int nCode, String strErrorInfo, Object objUserObject) {
        CallResult callResult = new CallResult();
        callResult.setRetCode(nCode);
        callResult.setErrorInfo(strErrorInfo);
        callResult.setUserObject(objUserObject);
        return callResult;
    }

    public static CallResult toCallResult(CallResult callResult) {
        return CallResult.ToCallResult(callResult);
    }

    @Deprecated
    public static CallResult ToCallResult(CallResult callResult) {
        if (callResult != null) {
            return callResult;
        }
        CallResult cr = new CallResult();
        cr.setRetCode(1);
        cr.setErrorInfo("\u5904\u7406\u5f02\u5e38\uff0c\u8fd4\u56de\u7a7a\u7ed3\u679c");
        return cr;
    }
}

