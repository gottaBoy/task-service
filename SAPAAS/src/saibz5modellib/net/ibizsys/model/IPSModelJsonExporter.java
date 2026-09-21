/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.fasterxml.jackson.databind.node.ObjectNode
 */
package net.ibizsys.model;

import com.fasterxml.jackson.databind.node.ObjectNode;

public interface IPSModelJsonExporter {
    public static final String ATTR_ID = "id";
    public static final String ATTR_NAME = "name";
    public static final String ATTR_TYPE = "type";
    public static final String ATTR_ITEMS = "items";
    public static final String ATTR_CAPTION = "caption";
    public static final String ATTR_SHOWCAP = "showcap";
    public static final String ATTR_WIDTH = "width";
    public static final String ATTR_HEIGHT = "height";
    public static final String ATTR_MODE = "mode";
    public static final String ATTR_TITLE = "title";
    public static final String ATTR_VIEW = "view";
    public static final String ATTR_URL = "url";
    public static final String ATTR_OPENMODE = "OPENMODE";
    public static final String ATTR_REDIRECTVIEW = "redirectview";
    public static final String ATTR_TAG = "tag";
    public static final String ATTR_VALUE = "value";
    public static final String ATTR_TEXT = "text";

    public ObjectNode toJsonObject(ObjectNode var1) throws Exception;
}

