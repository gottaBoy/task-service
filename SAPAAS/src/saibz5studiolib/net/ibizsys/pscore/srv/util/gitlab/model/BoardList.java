/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.pscore.srv.util.gitlab.model;

import net.ibizsys.pscore.srv.util.gitlab.model.Label;
import net.ibizsys.pscore.srv.util.gitlab.util.JacksonJson;

public class BoardList {
    private Integer id;
    private Label label;
    private Integer position;

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer n) {
        this.id = n;
    }

    public Label getLabel() {
        return this.label;
    }

    public void setLabel(Label label) {
        this.label = label;
    }

    public Integer getPosition() {
        return this.position;
    }

    public void setPosition(Integer n) {
        this.position = n;
    }

    public String toString() {
        return JacksonJson.toJsonString(this);
    }
}

