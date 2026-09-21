/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.ISRFDAWebContext
 */
package SA.IM.Ctrl;

import SA.SRFDA.Web.ISRFDAWebContext;
import java.util.Hashtable;

public interface IIMRemoteAction {
    public boolean isFromServer();

    public String getFromServerId();

    public String getAction();

    public String getParam(String var1, String var2);

    public Hashtable<String, String> getParams();

    public String getRemoteAddress();

    public void FromWebContext(ISRFDAWebContext var1) throws Exception;

    public void FromRemoteAction(IIMRemoteAction var1) throws Exception;

    public String getContent();

    public String getParamString();
}

