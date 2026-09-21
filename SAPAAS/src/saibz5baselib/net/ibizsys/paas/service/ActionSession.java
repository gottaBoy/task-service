/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package net.ibizsys.paas.service;

import java.util.HashMap;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.entity.SimpleEntity;
import net.ibizsys.paas.util.StringBuilderEx;
import net.ibizsys.paas.util.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class ActionSession {
    private static final Log log = LogFactory.getLog(ActionSession.class);
    private HashMap<String, String> recursionDataMap = new HashMap();
    private HashMap<String, Object> actionParamMap = new HashMap();
    private String strName = "";
    private StringBuilderEx actionInfoSB = new StringBuilderEx();
    private IEntity envEntity = null;
    private ActionSession childActionSession = null;
    private int nLevel = 0;

    public ActionSession() {
    }

    protected ActionSession(ActionSession parentActionSession, int nLevel) {
        try {
            this.nLevel = nLevel;
            if (parentActionSession.getEnvEntity(false) != null) {
                this.envEntity = new SimpleEntity();
                parentActionSession.getEnvEntity(false).copyTo(this.envEntity, false);
            }
        }
        catch (Exception ex) {
            log.error((Object)ex);
        }
    }

    public ActionSession openChildSession(String strName) {
        if (this.childActionSession == null) {
            this.childActionSession = new ActionSession(this, this.nLevel + 1);
            this.childActionSession.setName(strName);
            return this.childActionSession;
        }
        return this.childActionSession.openChildSession(strName);
    }

    public int closeChildSession() {
        if (this.childActionSession == null) {
            return -1;
        }
        int nLastLevel = this.childActionSession.closeChildSession();
        if (nLastLevel == -1) {
            this.childActionSession = null;
            return this.nLevel;
        }
        return nLastLevel;
    }

    public ActionSession getCurrentSession() {
        if (this.childActionSession == null) {
            return this;
        }
        return this.childActionSession.getCurrentSession();
    }

    public String getName() {
        return this.strName;
    }

    public void setName(String strName) {
        this.strName = strName;
    }

    public boolean registerRecursion(String strDEId, Object objKeyValue) {
        String strRecursionTag = StringHelper.format("%1$s||%2$s", strDEId, objKeyValue);
        if (this.recursionDataMap.containsKey(strRecursionTag)) {
            return false;
        }
        this.recursionDataMap.put(strRecursionTag, "");
        return true;
    }

    public void unregisterRecursion(String strDEId, Object objKeyValue) {
        String strRecursionTag = StringHelper.format("%1$s||%2$s", strDEId, objKeyValue);
        this.recursionDataMap.remove(strRecursionTag);
    }

    public boolean registerRecursion(String strActionType, String strDEId, Object objKeyValue) {
        String strRecursionTag = StringHelper.format("%1$s||%2$s||%3$s", strActionType, strDEId, objKeyValue);
        if (this.recursionDataMap.containsKey(strRecursionTag)) {
            return false;
        }
        this.recursionDataMap.put(strRecursionTag, "");
        return true;
    }

    public void unregisterRecursion(String strActionType, String strDEId, Object objKeyValue) {
        String strRecursionTag = StringHelper.format("%1$s||%2$s||%3$s", strActionType, strDEId, objKeyValue);
        this.recursionDataMap.remove(strRecursionTag);
    }

    public boolean registerRecursion(String strActionType, String strDEId, Object objKeyValue, Object objTag) {
        String strRecursionTag = StringHelper.format("%1$s||%2$s||%3$s||%4$s", strActionType, strDEId, objKeyValue, objTag);
        if (this.recursionDataMap.containsKey(strRecursionTag)) {
            return false;
        }
        this.recursionDataMap.put(strRecursionTag, "");
        return true;
    }

    public void unregisterRecursion(String strActionType, String strDEId, Object objKeyValue, Object objTag) {
        String strRecursionTag = StringHelper.format("%1$s||%2$s||%3$s||%4$s", strActionType, strDEId, objKeyValue, objTag);
        this.recursionDataMap.remove(strRecursionTag);
    }

    public void appendActionInfo(String strInfo) {
        this.actionInfoSB.append(strInfo);
    }

    public String getActionInfo() {
        return this.actionInfoSB.toString();
    }

    public void setActionParam(String strName, Object objValue) {
        this.actionParamMap.put(strName, objValue);
    }

    public Object removeActionParam(String strName) {
        return this.actionParamMap.remove(strName);
    }

    public boolean containsActionParam(String strName) {
        return this.actionParamMap.containsKey(strName);
    }

    public Object getActionParam(String strName) {
        return this.actionParamMap.get(strName);
    }

    public IEntity getEnvEntity(boolean bIfCreate) {
        if (this.envEntity == null && bIfCreate) {
            this.envEntity = new SimpleEntity();
        }
        return this.envEntity;
    }

    public IEntity getEnvEntity() {
        return this.getEnvEntity(false);
    }

    public void resetEnvEntity() {
        this.envEntity = null;
    }

    public int getLevel() {
        return this.nLevel;
    }
}

