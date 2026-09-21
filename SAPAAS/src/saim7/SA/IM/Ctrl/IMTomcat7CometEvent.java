/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.IM.Ctrl.IIMCometEvent
 *  javax.servlet.http.HttpServletRequest
 *  javax.servlet.http.HttpServletResponse
 *  org.apache.catalina.comet.CometEvent
 */
package SA.IM.Ctrl;

import SA.IM.Ctrl.IIMCometEvent;
import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.catalina.comet.CometEvent;

public class IMTomcat7CometEvent
implements IIMCometEvent {
    protected CometEvent cometEvent = null;

    public IMTomcat7CometEvent(CometEvent cometEvent) throws Exception {
        this.cometEvent = cometEvent;
        if (this.cometEvent == null) {
            throw new Exception("CometEvent\u5bf9\u8c61\u65e0\u6548");
        }
    }

    public void close() throws IOException {
        this.cometEvent.close();
    }

    public HttpServletRequest getHttpServletRequest() {
        return this.cometEvent.getHttpServletRequest();
    }

    public HttpServletResponse getHttpServletResponse() {
        return this.cometEvent.getHttpServletResponse();
    }
}

