/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.pscore.srv.util.gitlab.model;

import java.util.List;
import net.ibizsys.pscore.srv.util.gitlab.model.BoardList;
import net.ibizsys.pscore.srv.util.gitlab.model.Milestone;
import net.ibizsys.pscore.srv.util.gitlab.model.Project;
import net.ibizsys.pscore.srv.util.gitlab.util.JacksonJson;

public class Board {
    private Integer id;
    private String name;
    private Project project;
    private Milestone milestone;
    private List<BoardList> lists;

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer n) {
        this.id = n;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String string) {
        this.name = string;
    }

    public Project getProject() {
        return this.project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public Milestone getMilestone() {
        return this.milestone;
    }

    public void setMilestone(Milestone milestone) {
        this.milestone = milestone;
    }

    public List<BoardList> getLists() {
        return this.lists;
    }

    public void setLists(List<BoardList> list) {
        this.lists = list;
    }

    public String toString() {
        return JacksonJson.toJsonString(this);
    }
}

