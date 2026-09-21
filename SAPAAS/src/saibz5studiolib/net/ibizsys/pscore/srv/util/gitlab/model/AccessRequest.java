/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.pscore.srv.util.gitlab.model;

import java.util.Date;
import net.ibizsys.pscore.srv.util.gitlab.model.AbstractUser;
import net.ibizsys.pscore.srv.util.gitlab.model.AccessLevel;

public class AccessRequest
extends AbstractUser<AccessRequest> {
    private Date requestedAt;
    private AccessLevel accessLevel;

    public Date getRequestedAt() {
        return this.requestedAt;
    }

    public void setRequestedAt(Date date) {
        this.requestedAt = date;
    }

    public AccessLevel getAccessLevel() {
        return this.accessLevel;
    }

    public void setAccessLevel(AccessLevel accessLevel) {
        this.accessLevel = accessLevel;
    }
}

