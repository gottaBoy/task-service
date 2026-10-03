package SA.SRFDA.EAI.Ctrl;

import org.mule.api.lifecycle.Initialisable;
import org.mule.api.lifecycle.InitialisationException;

public class ServerEx extends Server implements Initialisable {
    public void initialise() throws InitialisationException {
        if (this.getServiceMgr() == null) {
            throw new InitialisationException(
                    new IllegalStateException("Mule registry has no EAISERVICEMGR"), this);
        }
    }
}
