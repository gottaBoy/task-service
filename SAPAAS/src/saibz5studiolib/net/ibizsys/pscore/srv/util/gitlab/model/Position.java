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
import net.ibizsys.pscore.srv.util.gitlab.util.JacksonJson;
import net.ibizsys.pscore.srv.util.gitlab.util.JacksonJsonEnumHelper;

public class Position {
    private String baseSha;
    private String startSha;
    private String headSha;
    private String oldPath;
    private String newPath;
    private PositionType positionType;
    private Integer oldLine;
    private Integer newLine;
    private Integer width;
    private Integer height;
    private Integer x;
    private Integer y;

    public String getBaseSha() {
        return this.baseSha;
    }

    public void setBaseSha(String string) {
        this.baseSha = string;
    }

    public Position withBaseSha(String string) {
        this.baseSha = string;
        return this;
    }

    public String getStartSha() {
        return this.startSha;
    }

    public void setStartSha(String string) {
        this.startSha = string;
    }

    public Position withStartSha(String string) {
        this.startSha = string;
        return this;
    }

    public String getHeadSha() {
        return this.headSha;
    }

    public void setHeadSha(String string) {
        this.headSha = string;
    }

    public Position withHeadSha(String string) {
        this.headSha = string;
        return this;
    }

    public String getOldPath() {
        return this.oldPath;
    }

    public void setOldPath(String string) {
        this.oldPath = string;
    }

    public Position withOldPath(String string) {
        this.oldPath = string;
        return this;
    }

    public String getNewPath() {
        return this.newPath;
    }

    public void setNewPath(String string) {
        this.newPath = string;
    }

    public Position withNewPath(String string) {
        this.newPath = string;
        return this;
    }

    public PositionType getPositionType() {
        return this.positionType;
    }

    public void setPositionType(PositionType positionType) {
        this.positionType = positionType;
    }

    public Position withPositionType(PositionType positionType) {
        this.positionType = positionType;
        return this;
    }

    public Integer getOldLine() {
        return this.oldLine;
    }

    public void setOldLine(Integer n) {
        this.oldLine = n;
    }

    public Position withOldLine(Integer n) {
        this.oldLine = n;
        return this;
    }

    public Integer getNewLine() {
        return this.newLine;
    }

    public void setNewLine(Integer n) {
        this.newLine = n;
    }

    public Position withNewLine(Integer n) {
        this.newLine = n;
        return this;
    }

    public Integer getWidth() {
        return this.width;
    }

    public void setWidth(Integer n) {
        this.width = n;
    }

    public Position withWidth(Integer n) {
        this.width = n;
        return this;
    }

    public Integer getHeight() {
        return this.height;
    }

    public void setHeight(Integer n) {
        this.height = n;
    }

    public Position withHeight(Integer n) {
        this.height = n;
        return this;
    }

    public Integer getX() {
        return this.x;
    }

    public void setX(Integer n) {
        this.x = n;
    }

    public Position withX(Integer n) {
        this.x = n;
        return this;
    }

    public Integer getY() {
        return this.y;
    }

    public void setY(Integer n) {
        this.y = n;
    }

    public Position withY(Integer n) {
        this.y = n;
        return this;
    }

    public String toString() {
        return JacksonJson.toJsonString(this);
    }

    public static enum PositionType {
        TEXT,
        IMAGE;

        private static JacksonJsonEnumHelper<PositionType> enumHelper;

        @JsonCreator
        public static PositionType forValue(String string) {
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
            enumHelper = new JacksonJsonEnumHelper<PositionType>(PositionType.class, false, false);
        }
    }
}

