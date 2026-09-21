/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.pscore.srv.util.gitlab.model;

import java.util.Date;
import net.ibizsys.pscore.srv.util.gitlab.model.AbstractUser;
import net.ibizsys.pscore.srv.util.gitlab.model.AccessLevel;
import net.ibizsys.pscore.srv.util.gitlab.util.JacksonJson;

public class Member
extends AbstractUser<Member> {
    private AccessLevel accessLevel;
    private Date expiresAt;

    public AccessLevel getAccessLevel() {
        return this.accessLevel;
    }

    public void setAccessLevel(AccessLevel accessLevel) {
        this.accessLevel = accessLevel;
    }

    public Date getExpiresAt() {
        return this.expiresAt;
    }

    public void setExpiresAt(Date date) {
        this.expiresAt = date;
    }

    public Member withAccessLevel(AccessLevel accessLevel) {
        this.accessLevel = accessLevel;
        return this;
    }

    public Member withExpiresAt(Date date) {
        this.expiresAt = date;
        return this;
    }

    @Override
    public String toString() {
        return JacksonJson.toJsonString(this);
    }
}

