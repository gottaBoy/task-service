/*
 * Decompiled with CFR 0.152.
 */
package SA.IM.Ctrl;

import SA.IM.Ctrl.Data.IMUser;
import SA.IM.Ctrl.IIMFuncServerContext;
import java.util.Vector;

public interface IIMStateServerContext
extends IIMFuncServerContext {
    public void ListUsers(Vector<IMUser> var1);
}

