/*
 * Decompiled with CFR 0.152.
 */
package SRFWF.Client;

import SRFWF.Client.WFCallResult;
import SRFWF.Model.WFInteractiveActionConfig;
import SRFWF.Model.WFUserActionConfig;
import java.util.ArrayList;

public class WFGetIAActionsResult
extends WFCallResult {
    protected String strProcessName = "";
    protected String strUserTag = "";
    protected int nVersion = 0;
    protected ArrayList<WFInteractiveActionConfig> iaActionList = new ArrayList();
    protected ArrayList<WFUserActionConfig> userActionList = new ArrayList();

    public void ReOrder() {
        ArrayList<WFInteractiveActionConfig> tempList = new ArrayList<WFInteractiveActionConfig>();
        for (WFInteractiveActionConfig iaActionConfig : this.iaActionList) {
            int nShowOrder = iaActionConfig.getShowOrder();
            if (nShowOrder < 0) {
                nShowOrder = 0;
                iaActionConfig.setShowOrder(nShowOrder);
            }
            boolean bAdd = false;
            int i = 0;
            while (i < tempList.size()) {
                WFInteractiveActionConfig tempIAActionConfig = (WFInteractiveActionConfig)((Object)tempList.get(i));
                if (tempIAActionConfig.getShowOrder() > nShowOrder) {
                    tempList.add(i, iaActionConfig);
                    bAdd = true;
                    break;
                }
                ++i;
            }
            if (bAdd) continue;
            tempList.add(iaActionConfig);
        }
        this.iaActionList.clear();
        this.iaActionList.addAll(tempList);
    }

    public ArrayList<WFInteractiveActionConfig> getIAActionList() {
        return this.iaActionList;
    }

    public ArrayList<WFUserActionConfig> getUserActionList() {
        return this.userActionList;
    }

    public String getProcessName() {
        return this.strProcessName;
    }

    public void setProcessName(String strProcessName) {
        this.strProcessName = strProcessName;
    }

    public int getVersion() {
        return this.nVersion;
    }

    public void setVersion(int version) {
        this.nVersion = version;
    }

    public String getUserTag() {
        return this.strUserTag;
    }

    public void setUserTag(String strUserTag) {
        this.strUserTag = strUserTag;
    }
}

