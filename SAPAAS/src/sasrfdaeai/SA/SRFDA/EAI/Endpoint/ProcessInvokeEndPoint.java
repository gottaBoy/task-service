package SA.SRFDA.EAI.Endpoint;

import org.mule.api.MuleEventContext;
import org.mule.api.MuleMessage;
import org.mule.api.lifecycle.Callable;

public class ProcessInvokeEndPoint extends BaseProcessEndpoint implements Callable {
    public Object onCall(MuleEventContext event) throws Exception {
        String target = EndpointRuntime.setting(event, "PROCESS");
        if (target == null || target.trim().length() == 0) {
            throw new IllegalArgumentException("PROCESS is required");
        }
        MuleMessage reply = event.sendEvent(event.getMessage(), target);
        if (reply == null) {
            throw new IllegalStateException("No response from process " + target);
        }
        if (reply.getExceptionPayload() != null) {
            throw new IllegalStateException("Process " + target + " failed: "
                    + reply.getExceptionPayload());
        }
        return reply.getPayload();
    }
}
