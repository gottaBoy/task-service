/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Utility.StringHelper
 */
package SRFWF.Model;

import SA.SRFramework.Utility.StringHelper;
import SRFWF.Model.WFBaseConnectionConfig;
import java.util.HashMap;
import java.util.Iterator;

public class WFInteractiveActionConfig
extends WFBaseConnectionConfig {
    public static final String TAG_WFIAACTION = "SRFEXWFIAACTION";
    public static final String TAG_PAGEPATH = "PAGEPATH";
    public static final String TAG_PAGESTYLE = "PAGESTYLE";
    public static final String TAG_PANELID = "PANELID";
    public static final String TAG_FAHELPER = "FAHELPER";
    public static final String TAG_ACTIONCOUNT = "ACTIONCOUNT";
    public static final String TAG_NEXTCONDITION = "NEXTCONDITION";
    public static final String TAG_NEXTCONDITION_ALL = "ALL";
    public static final String TAG_NEXTCONDITION_ANY = "ANY";
    public static final String TAG_SHOWORDER = "SHOWORDER";
    public static final String TAG_ACTIONTYPE = "ACTIONTYPE";
    public static final int ACTIONTYPE_BACKEND = 1;
    public static final int ACTIONTYPE_PAGELINK = 2;
    public static final String TAG_BUTTONACTIONHELPER = "BUTTONACTIONHELPER";
    public static final String TAG_SUPPORTMULTI = "SUPPORTMULTI";
    public static String TAG_USERVISIBLE = "USERVISIBLE";
    public static String TAG_ACTORS = "ACTORS";
    public static String TAG_UDACTORS = "UDACTORS";
    protected String strPagePath = "";
    protected String strPanelId = "";
    protected String strFAHelper = "";
    protected int nActionCount = 1;
    protected String strNextCondition = "ANY";
    protected String strPageStyle = "";
    protected int nShowOrder = 0;
    protected int nActionType = 2;
    protected String strButtonActionHelper = "";
    protected boolean bSupportMulti = true;
    protected boolean bUserVisible = true;
    protected String strActors = "";
    protected String strUDActors = "";
    protected HashMap<String, String> actorMap = new HashMap();
    protected HashMap<String, String> udActorMap = new HashMap();

    @Override
    protected void OnSetProperty(String strName, String strValue) {
        if (StringHelper.Compare((String)strName, (String)TAG_PAGEPATH, (boolean)true) == 0) {
            this.strPagePath = strValue;
            return;
        }
        if (StringHelper.Compare((String)strName, (String)TAG_PANELID, (boolean)true) == 0) {
            this.strPanelId = strValue;
            return;
        }
        if (StringHelper.Compare((String)strName, (String)TAG_FAHELPER, (boolean)true) == 0) {
            this.strFAHelper = strValue;
            return;
        }
        if (StringHelper.Compare((String)strName, (String)TAG_ACTIONCOUNT, (boolean)true) == 0) {
            this.nActionCount = WFInteractiveActionConfig.GetValue((String)strValue, (int)this.nActionCount);
            return;
        }
        if (StringHelper.Compare((String)strName, (String)TAG_NEXTCONDITION, (boolean)true) == 0) {
            this.strNextCondition = strValue;
            return;
        }
        if (StringHelper.Compare((String)strName, (String)TAG_PAGESTYLE, (boolean)true) == 0) {
            this.strPageStyle = strValue;
            return;
        }
        if (StringHelper.Compare((String)strName, (String)TAG_SHOWORDER, (boolean)true) == 0) {
            this.setShowOrder(WFInteractiveActionConfig.GetValue((String)strValue, (int)this.nShowOrder));
            return;
        }
        if (StringHelper.Compare((String)strName, (String)TAG_ACTIONTYPE, (boolean)true) == 0) {
            this.nActionType = WFInteractiveActionConfig.GetValue((String)strValue, (int)this.nActionType);
            return;
        }
        if (StringHelper.Compare((String)strName, (String)TAG_BUTTONACTIONHELPER, (boolean)true) == 0) {
            this.strButtonActionHelper = strValue;
            return;
        }
        if (StringHelper.Compare((String)strName, (String)TAG_SUPPORTMULTI, (boolean)true) == 0) {
            this.bSupportMulti = WFInteractiveActionConfig.GetValue((String)strValue, (boolean)this.bSupportMulti);
            return;
        }
        if (StringHelper.Compare((String)strName, (String)TAG_USERVISIBLE, (boolean)true) == 0) {
            this.bUserVisible = WFInteractiveActionConfig.GetValue((String)strValue, (boolean)this.bUserVisible);
            return;
        }
        if (StringHelper.Compare((String)strName, (String)TAG_ACTORS, (boolean)true) == 0) {
            this.setActors(strValue);
            return;
        }
        if (StringHelper.Compare((String)strName, (String)TAG_UDACTORS, (boolean)true) == 0) {
            this.setUDActors(strValue);
            return;
        }
        super.OnSetProperty(strName, strValue);
    }

    public String getPagePath() {
        return this.strPagePath;
    }

    public void setPagePath(String strPagePath) {
        this.strPagePath = strPagePath;
    }

    public String getPanelId() {
        return this.strPanelId;
    }

    public void setPanelId(String strPanelId) {
        this.strPanelId = strPanelId;
    }

    public String getFAHelper() {
        return this.strFAHelper;
    }

    public void setFAHelper(String strFAHelper) {
        this.strFAHelper = strFAHelper;
    }

    public int getActionCount() {
        return this.nActionCount;
    }

    public void setActionCount(int actionCount) {
        this.nActionCount = actionCount;
    }

    public String getNextCondition() {
        return this.strNextCondition;
    }

    public void setNextCondition(String strNextCondition) {
        this.strNextCondition = strNextCondition;
    }

    public String getPageStyle() {
        return this.strPageStyle;
    }

    public void setPageStyle(String strPageStyle) {
        this.strPageStyle = strPageStyle;
    }

    public int getShowOrder() {
        return this.nShowOrder;
    }

    public void setShowOrder(int showOrder) {
        this.nShowOrder = showOrder;
        if (this.nShowOrder < 0) {
            this.nShowOrder = 0;
        }
    }

    public int getActionType() {
        return this.nActionType;
    }

    public void setActionType(int nActionType) {
        this.nActionType = nActionType;
    }

    public String getButtonActionHelper() {
        return this.strButtonActionHelper;
    }

    public void setButtonActionHelper(String strButtonActionHelper) {
        this.strButtonActionHelper = strButtonActionHelper;
    }

    public boolean isSupportMulti() {
        return this.bSupportMulti;
    }

    public void setSupportMulti(boolean bSupportMulti) {
        this.bSupportMulti = bSupportMulti;
    }

    public boolean isUserVisible() {
        return this.bUserVisible;
    }

    public void setUserVisible(boolean userVisible) {
        this.bUserVisible = userVisible;
    }

    public String getActors() {
        return this.strActors;
    }

    public void setActors(String strActors) {
        this.strActors = strActors;
        this.actorMap.clear();
        if (!StringHelper.IsNullOrEmpty((String)strActors)) {
            String[] actors;
            String[] stringArray = actors = strActors.split(";");
            int n = actors.length;
            int n2 = 0;
            while (n2 < n) {
                String strActor = stringArray[n2];
                if (!StringHelper.IsNullOrEmpty((String)(strActor = strActor.trim()))) {
                    this.actorMap.put(strActor, "");
                }
                ++n2;
            }
        }
    }

    public String getUDActors() {
        return this.strUDActors;
    }

    public void setUDActors(String strUDActors) {
        this.strUDActors = strUDActors;
        this.udActorMap.clear();
        if (!StringHelper.IsNullOrEmpty((String)strUDActors)) {
            String[] actors;
            String[] stringArray = actors = strUDActors.split(";");
            int n = actors.length;
            int n2 = 0;
            while (n2 < n) {
                String strActor = stringArray[n2];
                if (!StringHelper.IsNullOrEmpty((String)(strActor = strActor.trim()))) {
                    this.udActorMap.put(strActor, "");
                }
                ++n2;
            }
        }
    }

    public boolean isActorIAActionControl() {
        return this.actorMap.size() > 0 || this.udActorMap.size() > 0;
    }

    public Iterator<String> ListActorIds() {
        return this.actorMap.keySet().iterator();
    }

    public Iterator<String> ListUDActorIds() {
        return this.udActorMap.keySet().iterator();
    }

    public boolean isContainsActor(String strActorId) {
        return this.actorMap.containsKey(strActorId);
    }

    public boolean isContainsUDActor(String strActorId) {
        return this.udActorMap.containsKey(strActorId);
    }
}

