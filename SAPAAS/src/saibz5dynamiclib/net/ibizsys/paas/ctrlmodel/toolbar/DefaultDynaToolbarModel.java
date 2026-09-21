/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package net.ibizsys.paas.ctrlmodel.toolbar;

import net.ibizsys.paas.ctrlmodel.DynaToolbarModelBase;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class DefaultDynaToolbarModel
extends DynaToolbarModelBase {
    private static Log log = LogFactory.getLog(DefaultDynaToolbarModel.class);
    public static final String MODEL_NODE_TOOLBAR = "TOOLBAR";
    public static final String MODEL_NODE_ITEMS = "ITEMS";
    public static final String MODEL_NODE_SEPARATOR = "SEPARATOR";
    public static final String MODEL_NODE_UIACTION = "UIACTION";
    public static final String MODEL_ATTR_UIACTIONID = "UIACTIONID";
    public static final String MODEL_ATTR_UIACTIONPARAM = "UIACTIONPARAM";
    public static final String MODEL_ATTR_GROUPEXTRACTMODE = "GROUPEXTRACTMODE";
    public static final String MODEL_ATTR_SHOWMODE = "SHOWMODE";
    public static final String MODEL_ATTR_CAPTION = "CAPTION";
    public static final String MODEL_ATTR_CAPLANRESTAG = "CAPLANRESTAG";
    public static final String MODEL_ATTR_TOOLTIP = "TOOLTIP";
    public static final String MODEL_ATTR_TOOLTIPLANRESTAG = "TOOLTIPLANRESTAG";
    public static final String GROUPEXTRACTMODE_ITEM = "ITEM";
    public static final String GROUPEXTRACTMODE_ITEMS = "ITEMS";
}

