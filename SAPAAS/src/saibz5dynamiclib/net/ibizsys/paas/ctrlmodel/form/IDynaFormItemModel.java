/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.ctrlmodel.IFormItemModel
 */
package net.ibizsys.paas.ctrlmodel.form;

import net.ibizsys.paas.ctrlmodel.IFormItemModel;
import net.ibizsys.paas.ctrlmodel.form.IDynaFormDetailModel;

public interface IDynaFormItemModel
extends IDynaFormDetailModel,
IFormItemModel {
    public static final String ATTR_EDITORHEIGHT = "editorheight";
    public static final String ATTR_EDITORWIDTH = "editorwidth";
    public static final String ATTR_EDITORSTYLE = "editorstyle";
    public static final String ATTR_EDITORTYPE = "editortype";
    public static final String ATTR_LABELPOS = "labelpos";
    public static final String ATTR_LABELWIDTH = "labelwidth";
    public static final String ATTR_PLACEHOLDER = "placeholder";
    public static final String ATTR_ALLOWEMPTY = "allowempty";
    public static final String ATTR_EDITABLE = "editable";
    public static final String ATTR_EMPTYCAPTION = "emptycaption";
    public static final String ATTR_HIDDEN = "hidden";
    public static final String LABELPOS_LEFT = "LEFT";
    public static final String LABELPOS_TOP = "TOP";
    public static final String LABELPOS_RIGHT = "RIGHT";
    public static final String LABELPOS_BOTTOM = "BOTTOM";
    public static final String LABELPOS_NONE = "NONE";

    public boolean isEmptyCaption();

    public double getEditorWidth();

    public double getEditorHeight();

    public boolean isAllowEmpty();

    public String getLabelPos();

    public int getLabelWidth();

    public boolean isHidden();

    public String getEditorType();

    public boolean isEditable();

    public String getEditorStyle();

    public String getPlaceHolder();
}

