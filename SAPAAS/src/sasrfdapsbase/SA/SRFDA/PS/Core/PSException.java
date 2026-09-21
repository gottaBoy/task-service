/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.GlobalHelperEx
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 */
package SA.SRFDA.PS.Core;

import SA.SRFDA.PS.Core.IPSModelHelper;
import SA.SRFDA.PS.Core.IPSObject;
import SA.SRFDA.PS.Core.IPSObjectRuntime;
import SA.SRFDA.PS.Core.PSObjectFactory;
import SA.SRFDA.Web.Utility.GlobalHelperEx;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;

public class PSException
extends Exception {
    private static final long serialVersionUID = -1534072111308135761L;
    public static final int ERROR_UNKNOWN = 0;
    public static final int ERROR_MODELLIMIT = 1000;
    public static final int ERROR_ACTIONLIMIT = 1010;
    protected static final int ERROR_SYSTEMSTART = 10000;
    protected static final int ERROR_SYSAPISTART = 12000;
    protected static final int ERROR_DATAENTITYSTART = 20000;
    protected static final int ERROR_DEFIELDSTART = 30000;
    protected static final int ERROR_APPSTART = 40000;
    private int nErrorCode = 0;
    private Object objArg = null;
    private Object objArg2 = null;

    public PSException(int nErrorCode, String strErrorInfo) {
        super(strErrorInfo);
        this.setErrorCode(nErrorCode);
    }

    public int getErrorCode() {
        return this.nErrorCode;
    }

    protected void setErrorCode(int nErrorCode) {
        this.nErrorCode = nErrorCode;
    }

    public Object getArg() {
        return this.objArg;
    }

    public Object getArg2() {
        return this.objArg2;
    }

    protected void setArg(Object objArg) {
        this.objArg = objArg;
    }

    protected void setArg2(Object objArg2) {
        this.objArg2 = objArg2;
    }

    protected static IPSModelHelper getPSModelHelper(IPSObject iPSObject) throws Exception {
        ISRFDAGlobalHelper iDAGlobalHelper = null;
        iDAGlobalHelper = iPSObject instanceof IPSObjectRuntime ? ((IPSObjectRuntime)((Object)iPSObject)).getDAGlobalHelper() : GlobalHelperEx.getInstance();
        return PSObjectFactory.getPSModelHelper(iDAGlobalHelper, iPSObject.getPSSysModelInstId());
    }
}

