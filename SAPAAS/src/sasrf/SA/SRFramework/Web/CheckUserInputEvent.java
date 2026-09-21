/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFramework.Web;

import java.util.EventObject;
import java.util.Hashtable;

public class CheckUserInputEvent
extends EventObject {
    private Hashtable UserInputs;

    public CheckUserInputEvent(Object source) {
        super(source);
    }

    public void setUserInputs(Hashtable UserInputs) {
        this.UserInputs = UserInputs;
    }

    public Hashtable getUserInputs() {
        return this.UserInputs;
    }
}

