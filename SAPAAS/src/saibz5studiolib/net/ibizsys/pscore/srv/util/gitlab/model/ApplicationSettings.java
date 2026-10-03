/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.fasterxml.jackson.annotation.JsonIgnore
 *  com.fasterxml.jackson.databind.JsonNode
 *  com.fasterxml.jackson.databind.node.ArrayNode
 *  com.fasterxml.jackson.databind.node.BooleanNode
 *  com.fasterxml.jackson.databind.node.DoubleNode
 *  com.fasterxml.jackson.databind.node.FloatNode
 *  com.fasterxml.jackson.databind.node.IntNode
 *  com.fasterxml.jackson.databind.node.NullNode
 *  com.fasterxml.jackson.databind.node.TextNode
 */
package net.ibizsys.pscore.srv.util.gitlab.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.BooleanNode;
import com.fasterxml.jackson.databind.node.DoubleNode;
import com.fasterxml.jackson.databind.node.FloatNode;
import com.fasterxml.jackson.databind.node.IntNode;
import com.fasterxml.jackson.databind.node.NullNode;
import com.fasterxml.jackson.databind.node.TextNode;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import net.ibizsys.pscore.srv.util.gitlab.GitLabApiException;
import net.ibizsys.pscore.srv.util.gitlab.model.Setting;
import net.ibizsys.pscore.srv.util.gitlab.util.JacksonJson;

public class ApplicationSettings {
    private Integer id;
    private Date createdAt;
    private Date updatedAt;
    private Map<String, Object> settings = new HashMap<String, Object>();

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer n) {
        this.id = n;
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

    public Map<String, Object> getSettings() {
        return this.settings;
    }

    public void setSettings(Map<String, Object> map) {
        this.settings = map;
    }

    @JsonIgnore
    public Object getSetting(Setting setting) {
        if (setting == null) {
            return null;
        }
        String string = setting.toString();
        return this.settings.get(string);
    }

    @JsonIgnore
    public Object getSetting(String string) {
        if (string == null) {
            return null;
        }
        return this.settings.get(string);
    }

    public Object addSetting(String string, Object object) throws GitLabApiException {
        Setting setting = Setting.forValue(string);
        if (setting != null) {
            return this.addSetting(setting, object);
        }
        this.settings.put(string, object);
        return object;
    }

    public Object addSetting(Setting setting, Object object) throws GitLabApiException {
        if (object instanceof JsonNode) {
            object = this.jsonNodeToValue((JsonNode)object);
        }
        setting.validate(object);
        this.settings.put(setting.toString(), object);
        return object;
    }

    public Object removeSetting(Setting setting) {
        return this.settings.remove(setting.toString());
    }

    public Object removeSetting(String string) {
        return this.settings.remove(string);
    }

    public void clearSettings() {
        this.settings.clear();
    }

    private Object jsonNodeToValue(JsonNode jsonNode) {
        Object value = jsonNode;
        if (jsonNode instanceof NullNode) {
            value = null;
        } else if (jsonNode instanceof TextNode) {
            value = jsonNode.asText();
        } else if (jsonNode instanceof BooleanNode) {
            value = jsonNode.asBoolean();
        } else if (jsonNode instanceof IntNode) {
            value = jsonNode.asInt();
        } else if (jsonNode instanceof FloatNode) {
            value = Float.valueOf((float)((FloatNode)jsonNode).asDouble());
        } else if (jsonNode instanceof DoubleNode) {
            value = Float.valueOf((float)((DoubleNode)jsonNode).asDouble());
        } else if (jsonNode instanceof ArrayNode) {
            int n = jsonNode.size();
            String[] stringArray2 = new String[n];
            for (int i = 0; i < n; ++i) {
                stringArray2[i] = jsonNode.path(i).asText();
            }
            value = stringArray2;
        }
        return value;
    }

    public String toString() {
        return JacksonJson.toJsonString(this);
    }
}
