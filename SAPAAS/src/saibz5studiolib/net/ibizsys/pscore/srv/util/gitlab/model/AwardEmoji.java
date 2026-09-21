/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.fasterxml.jackson.annotation.JsonCreator
 *  com.fasterxml.jackson.annotation.JsonValue
 */
package net.ibizsys.pscore.srv.util.gitlab.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import java.util.Date;
import net.ibizsys.pscore.srv.util.gitlab.model.User;
import net.ibizsys.pscore.srv.util.gitlab.util.JacksonJson;
import net.ibizsys.pscore.srv.util.gitlab.util.JacksonJsonEnumHelper;

public class AwardEmoji {
    private Integer id;
    private String name;
    private User user;
    private Date createdAt;
    private Date updatedAt;
    private Integer awardableId;
    private AwardableType awardableType;

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

    public User getUser() {
        return this.user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Date getCreatedAt() {
        return this.createdAt;
    }

    public void setCreatedAt(Date date) {
        this.createdAt = date;
    }

    public Date getUpdatedAt() {
        return this.updatedAt;
    }

    public void setUpdatedAt(Date date) {
        this.updatedAt = date;
    }

    public Integer getAwardableId() {
        return this.awardableId;
    }

    public void setAwardableId(Integer n) {
        this.awardableId = n;
    }

    public AwardableType getAwardableType() {
        return this.awardableType;
    }

    public void setAwardableType(AwardableType awardableType) {
        this.awardableType = awardableType;
    }

    public String toString() {
        return JacksonJson.toJsonString(this);
    }

    public static enum AwardableType {
        ISSUE,
        MERGE_REQUEST,
        NOTE,
        SNIPPET;

        private static JacksonJsonEnumHelper<AwardableType> enumHelper;

        @JsonCreator
        public static AwardableType forValue(String string) {
            return enumHelper.forValue(string);
        }

        @JsonValue
        public String toValue() {
            return enumHelper.toString(this);
        }

        public String toString() {
            return enumHelper.toString(this);
        }

        static {
            enumHelper = new JacksonJsonEnumHelper<AwardableType>(AwardableType.class, true);
        }
    }
}

