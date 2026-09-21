/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.servlet.ServletRequest
 *  javax.servlet.ServletResponse
 *  javax.servlet.http.HttpSession
 */
package SA.SRFramework.WebEx;

import SA.SRFramework.WebEx.ISRFExWebContext;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpSession;

public interface ISRFExUserSessionMgr {
    public void CreateSession(HttpSession var1);

    public boolean UpdateSession(ISRFExWebContext var1, ServletRequest var2, ServletResponse var3);

    public void RemoveSession(HttpSession var1);
}

