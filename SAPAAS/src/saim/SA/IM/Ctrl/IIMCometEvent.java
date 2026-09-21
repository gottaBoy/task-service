/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.servlet.http.HttpServletRequest
 *  javax.servlet.http.HttpServletResponse
 */
package SA.IM.Ctrl;

import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface IIMCometEvent {
    public HttpServletRequest getHttpServletRequest();

    public HttpServletResponse getHttpServletResponse();

    public void close() throws IOException;
}

