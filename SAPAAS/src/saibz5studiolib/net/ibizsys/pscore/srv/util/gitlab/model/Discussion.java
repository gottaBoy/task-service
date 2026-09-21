/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.pscore.srv.util.gitlab.model;

import java.util.List;
import net.ibizsys.pscore.srv.util.gitlab.model.Note;
import net.ibizsys.pscore.srv.util.gitlab.util.JacksonJson;

public class Discussion {
    private String id;
    private Boolean individualNote;
    private List<Note> notes;

    public String getId() {
        return this.id;
    }

    public Boolean getIndividualNote() {
        return this.individualNote;
    }

    public List<Note> getNotes() {
        return this.notes;
    }

    public void setId(String string) {
        this.id = string;
    }

    public void setIndividualNote(Boolean bl) {
        this.individualNote = bl;
    }

    public void setNotes(List<Note> list) {
        this.notes = list;
    }

    public String toString() {
        return JacksonJson.toJsonString(this);
    }
}

