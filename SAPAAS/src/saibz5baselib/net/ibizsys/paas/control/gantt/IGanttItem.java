/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.sf.json.JSONObject
 */
package net.ibizsys.paas.control.gantt;

import java.sql.Timestamp;
import net.ibizsys.paas.core.IModelBase;
import net.sf.json.JSONObject;

public interface IGanttItem
extends IModelBase {
    public String getItemType();

    public boolean isDisabled();

    public String getCssClass();

    public String getIconCssClass();

    public String getIcon();

    public String getHref();

    public String getHrefTarget();

    public String getTips();

    public String getText();

    public String getContent();

    public String getColor();

    public String getBKColor();

    public Timestamp getBeginTime();

    public Timestamp getEndTime();

    public Object getTagValue(String var1);

    public JSONObject getTag();

    public Object getDataSource();
}

