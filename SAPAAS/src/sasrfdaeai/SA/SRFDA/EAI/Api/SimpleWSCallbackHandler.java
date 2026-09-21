/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.EAI.Api;

import SA.SRFDA.EAI.Api.SimpleWSStub;

public abstract class SimpleWSCallbackHandler {
    protected Object clientData;

    public SimpleWSCallbackHandler(Object clientData) {
        this.clientData = clientData;
    }

    public SimpleWSCallbackHandler() {
        this.clientData = null;
    }

    public Object getClientData() {
        return this.clientData;
    }

    public void receiveResultCall(SimpleWSStub.CallResponse result) {
    }

    public void receiveErrorCall(Exception e) {
    }
}

