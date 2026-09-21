/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.sf.json.JSONObject
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package net.ibizsys.paas.control.gantt;

import java.sql.Timestamp;
import java.util.Iterator;
import net.ibizsys.paas.control.gantt.IGanttItem;
import net.ibizsys.paas.util.DateHelper;
import net.ibizsys.paas.util.JSONObjectHelper;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.xml.SimpleXmlNode;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class GanttItem
extends SimpleXmlNode
implements IGanttItem {
    private static final Log log = LogFactory.getLog(GanttItem.class);
    public static final String GANTTITEM_GANTTITEM = "SRFEXGANTTITEM";
    public static final String GANTTITEM_TEXT = "TEXT";
    public static final String GANTTITEM_TIPS = "TIPS";
    public static final String GANTTITEM_CSSCLASS = "CSSCLASS";
    public static final String GANTTITEM_ICONCSSCLASS = "ICONCSSCLASS";
    public static final String GANTTITEM_ICON = "ICON";
    public static final String GANTTITEM_HREF = "HREF";
    public static final String GANTTITEM_HREFTARGET = "HREFTARGET";
    public static final String GANTTITEM_TAG = "TAG";
    public static final String GANTTITEM_CONTENT = "CONTENT";
    public static final String GANTTITEM_BEGINTIME = "BEGINTIME";
    public static final String GANTTITEM_ENDTIME = "ENDTIME";
    public static final String GANTTITEM_COLOR = "COLOR";
    public static final String GANTTITEM_BKCOLOR = "BKCOLOR";
    public static final String GANTTITEM_DISABLE = "DISABLE";
    public static final String GANTTITEM_TYPE = "TYPE";
    protected String strText = "";
    protected String strTips = "";
    protected String strCssClass = "";
    protected String strIconCssClass = "";
    protected String strIcon = "";
    protected String strHref = "";
    protected String strHrefTarget = "";
    private String strItemType = "";
    private String strContent = "";
    private String strColor = "";
    private String strBKColor = "";
    private Timestamp beginTime = null;
    private Timestamp endTime = null;
    private boolean bDisable = false;
    protected JSONObject tagObj = null;
    private Object dataSource = null;

    @Override
    protected void onSetAttribute(String strName, String strValue) {
        if (StringHelper.compare(strName, GANTTITEM_TIPS, true) == 0) {
            this.strTips = strValue;
            return;
        }
        if (StringHelper.compare(strName, GANTTITEM_TAG, true) == 0) {
            this.tagObj = JSONObjectHelper.fromString(strValue);
            return;
        }
        if (StringHelper.compare(strName, GANTTITEM_HREFTARGET, true) == 0) {
            this.strHrefTarget = strValue;
            return;
        }
        if (StringHelper.compare(strName, GANTTITEM_HREF, true) == 0) {
            this.strHref = strValue;
            return;
        }
        if (StringHelper.compare(strName, GANTTITEM_CSSCLASS, true) == 0) {
            this.strCssClass = strValue;
            return;
        }
        if (StringHelper.compare(strName, GANTTITEM_ICONCSSCLASS, true) == 0) {
            this.strIconCssClass = strValue;
            return;
        }
        if (StringHelper.compare(strName, GANTTITEM_ICON, true) == 0) {
            this.strIcon = strValue;
            return;
        }
        if (StringHelper.compare(strName, GANTTITEM_TEXT, true) == 0) {
            this.strText = strValue;
            return;
        }
        if (StringHelper.compare(strName, GANTTITEM_CONTENT, true) == 0) {
            this.strContent = strValue;
            return;
        }
        if (StringHelper.compare(strName, GANTTITEM_COLOR, true) == 0) {
            this.strColor = strValue;
            return;
        }
        if (StringHelper.compare(strName, GANTTITEM_BKCOLOR, true) == 0) {
            this.strBKColor = strValue;
            return;
        }
        if (StringHelper.compare(strName, GANTTITEM_TYPE, true) == 0) {
            this.strItemType = strValue;
            return;
        }
        if (StringHelper.compare(strName, GANTTITEM_DISABLE, true) == 0) {
            this.bDisable = GanttItem.getValue(strValue, this.bDisable);
            return;
        }
        if (StringHelper.compare(strName, GANTTITEM_BEGINTIME, true) == 0) {
            try {
                this.beginTime = new Timestamp(DateHelper.parse(strValue).getTime());
            }
            catch (Exception ex) {
                log.error((Object)ex);
            }
            return;
        }
        if (StringHelper.compare(strName, GANTTITEM_ENDTIME, true) == 0) {
            try {
                this.endTime = new Timestamp(DateHelper.parse(strValue).getTime());
            }
            catch (Exception ex) {
                log.error((Object)ex);
            }
            return;
        }
        super.onSetAttribute(strName, strValue);
    }

    @Override
    public String getCssClass() {
        return this.strCssClass;
    }

    public void setCssClass(String strCssClass) {
        this.strCssClass = strCssClass;
    }

    @Override
    public String getIconCssClass() {
        return this.strIconCssClass;
    }

    public void setIconCssClass(String strIconCssClass) {
        this.strIconCssClass = strIconCssClass;
    }

    @Override
    public String getIcon() {
        return this.strIcon;
    }

    public void setIcon(String strIcon) {
        this.strIcon = strIcon;
    }

    @Override
    public String getHref() {
        return this.strHref;
    }

    public void setHref(String strHref) {
        this.strHref = strHref;
    }

    @Override
    public String getHrefTarget() {
        return this.strHrefTarget;
    }

    public void setHrefTarget(String strHrefTarget) {
        this.strHrefTarget = strHrefTarget;
    }

    @Override
    public String getTips() {
        return this.strTips;
    }

    public void setTips(String strTips) {
        this.strTips = strTips;
    }

    @Override
    public String getText() {
        return this.strText;
    }

    public void setText(String strText) {
        this.strText = strText;
    }

    @Override
    public String getContent() {
        return this.strContent;
    }

    public void setContent(String strContent) {
        this.strContent = strContent;
    }

    @Override
    public String getColor() {
        return this.strColor;
    }

    public void setColor(String strColor) {
        this.strColor = strColor;
    }

    @Override
    public String getBKColor() {
        return this.strBKColor;
    }

    public void setBKColor(String strBKColor) {
        this.strBKColor = strBKColor;
    }

    @Override
    public Timestamp getBeginTime() {
        return this.beginTime;
    }

    public void setBeginTime(Timestamp beginTime) {
        this.beginTime = beginTime;
    }

    @Override
    public Timestamp getEndTime() {
        return this.endTime;
    }

    public void setEndTime(Timestamp endTime) {
        this.endTime = endTime;
    }

    public void setTagValue(String strKey, Object objValue) {
        if (this.tagObj == null) {
            this.tagObj = new JSONObject();
        }
        if (this.tagObj.has(strKey)) {
            this.tagObj.remove(strKey);
        }
        if (objValue == null) {
            return;
        }
        this.tagObj.put(strKey, JSONObjectHelper.stripQuotes(objValue));
    }

    @Override
    public Object getTagValue(String strKey) {
        return this.tagObj.get(strKey);
    }

    @Override
    public JSONObject getTag() {
        return this.tagObj;
    }

    public static JSONObject toJSONObject(IGanttItem calendarItem, boolean bSimple) {
        JSONObject objJSON = new JSONObject();
        objJSON.put("id", JSONObjectHelper.stripQuotes(calendarItem.getId(), true));
        objJSON.put("text", JSONObjectHelper.stripQuotes(calendarItem.getText(), true));
        objJSON.put("content", JSONObjectHelper.stripQuotes(calendarItem.getContent(), true));
        if (!StringHelper.isNullOrEmpty(calendarItem.getColor())) {
            objJSON.put("color", JSONObjectHelper.stripQuotes(calendarItem.getColor(), true));
        }
        if (!StringHelper.isNullOrEmpty(calendarItem.getBKColor())) {
            objJSON.put("bkcolor", JSONObjectHelper.stripQuotes(calendarItem.getBKColor(), true));
        }
        if (!StringHelper.isNullOrEmpty(calendarItem.getItemType())) {
            objJSON.put("type", JSONObjectHelper.stripQuotes(calendarItem.getItemType(), true));
        }
        if (calendarItem.getBeginTime() != null) {
            objJSON.put("begintime", (Object)DateHelper.toDateTimeString(calendarItem.getBeginTime()));
        }
        if (calendarItem.getEndTime() != null) {
            objJSON.put("endtime", (Object)DateHelper.toDateTimeString(calendarItem.getEndTime()));
        }
        if (!StringHelper.isNullOrEmpty(calendarItem.getTips()) || !bSimple) {
            objJSON.put("qtip", JSONObjectHelper.stripQuotes(calendarItem.getTips(), true));
        }
        if (!StringHelper.isNullOrEmpty(calendarItem.getCssClass()) || !bSimple) {
            objJSON.put("cls", JSONObjectHelper.stripQuotes(calendarItem.getCssClass(), true));
        }
        if (calendarItem.isDisabled() || !bSimple) {
            objJSON.put("disabled", calendarItem.isDisabled());
        }
        if (!StringHelper.isNullOrEmpty(calendarItem.getHref()) || !bSimple) {
            objJSON.put("href", JSONObjectHelper.stripQuotes(calendarItem.getHref(), true));
        }
        if (!StringHelper.isNullOrEmpty(calendarItem.getHrefTarget()) || !bSimple) {
            objJSON.put("hrefTarget", JSONObjectHelper.stripQuotes(calendarItem.getHrefTarget(), true));
        }
        if (!StringHelper.isNullOrEmpty(calendarItem.getIcon()) || !bSimple) {
            objJSON.put("icon", JSONObjectHelper.stripQuotes(calendarItem.getIcon(), true));
        }
        if (!StringHelper.isNullOrEmpty(calendarItem.getIconCssClass()) || !bSimple) {
            objJSON.put("iconCls", JSONObjectHelper.stripQuotes(calendarItem.getIconCssClass(), true));
        }
        if (calendarItem.getTag() != null) {
            Iterator en = calendarItem.getTag().keys();
            while (en.hasNext()) {
                String strKey = (String)en.next();
                if (objJSON.has(strKey)) continue;
                objJSON.put(strKey, calendarItem.getTag().get(strKey));
            }
        }
        return objJSON;
    }

    public static JSONObject toJSONObject(IGanttItem calendarItem) {
        return GanttItem.toJSONObject(calendarItem, false);
    }

    @Override
    public String getName() {
        return null;
    }

    @Override
    public String getItemType() {
        return this.strItemType;
    }

    public void setItemType(String strItemType) {
        this.strItemType = strItemType;
    }

    public void setDataSource(Object dataSource) {
        this.dataSource = dataSource;
    }

    public void setDisabled(boolean bDisable) {
        this.bDisable = bDisable;
    }

    @Override
    public boolean isDisabled() {
        return this.bDisable;
    }

    @Override
    public Object getDataSource() {
        return this.dataSource;
    }
}

