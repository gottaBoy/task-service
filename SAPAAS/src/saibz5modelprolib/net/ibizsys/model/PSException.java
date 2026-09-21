/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.model.core.IPSModelObject
 */
package net.ibizsys.model;

import net.ibizsys.model.IPSModelObjectRuntime;
import net.ibizsys.model.IPSModelQueryHelper;
import net.ibizsys.model.PSModelQueryHelperFactory;
import net.ibizsys.model.core.IPSModelObject;

public class PSException
extends Exception {
    private static final long serialVersionUID = -1534072111308135761L;
    public static final int ERROR_UNKNOWN = 0;
    protected static final int ERROR_SYSTEMSTART = 10000;
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

    protected static IPSModelQueryHelper getPSModelQueryHelper(IPSModelObject iPSObject) throws Exception {
        if (iPSObject instanceof IPSModelObjectRuntime) {
            return PSModelQueryHelperFactory.getInstance(((IPSModelObjectRuntime)iPSObject).getPSSysModelInstId());
        }
        return PSModelQueryHelperFactory.getInstance();
    }
}

