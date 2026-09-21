/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.pscore.srv.util;

import java.util.HashMap;

public class PSRTHelper {
    private static HashMap<String, String> rtDEMap = new HashMap();

    public static boolean isRTDE(String string) {
        return rtDEMap.containsKey(string);
    }

    static {
        rtDEMap.put("USEROBJECT", "");
        rtDEMap.put("USERROLEDETAIL", "");
        rtDEMap.put("USERGROUPDETAIL", "");
        rtDEMap.put("USERROLE", "");
        rtDEMap.put("USERGROUP", "");
        rtDEMap.put("USER", "");
        rtDEMap.put("WFWORKFLOW", "");
        rtDEMap.put("WFWORKLIST", "");
        rtDEMap.put("WFAPPSETTING", "");
        rtDEMap.put("WFINSTANCE", "");
        rtDEMap.put("WFSTEP", "");
        rtDEMap.put("WFIAACTION", "");
        rtDEMap.put("WFSTEPDATA", "");
        rtDEMap.put("WFSTEPACTOR", "");
        rtDEMap.put("WFUSER", "");
        rtDEMap.put("WFUSERGROUP", "");
        rtDEMap.put("WFUSERGROUPDETAIL", "");
        rtDEMap.put("WFSYSTEMUSER", "");
        rtDEMap.put("WFACTOR", "");
        rtDEMap.put("WFDYNAMICUSER", "");
        rtDEMap.put("WFUSERCANDIDATE", "");
        rtDEMap.put("WFUSERASSIST", "");
        rtDEMap.put("WFREMINDER", "");
        rtDEMap.put("WFTMPSTEPACTOR", "");
        rtDEMap.put("WFCUSTOMPROCESS", "");
        rtDEMap.put("WFSTEPINST", "");
        rtDEMap.put("WFACTION", "");
        rtDEMap.put("WFWFVERSION", "");
        rtDEMap.put("LOGINACCOUNT", "");
        rtDEMap.put("DATAENTITY", "");
        rtDEMap.put("QUERYMODEL", "");
        rtDEMap.put("USERROLEDATAS", "");
        rtDEMap.put("USERROLEDATAACTION", "");
        rtDEMap.put("USERROLEDATADETAIL", "");
        rtDEMap.put("USERROLEDATA", "");
        rtDEMap.put("FILE", "");
        rtDEMap.put("USERDGTHEME", "");
        rtDEMap.put("ORGSECUSERTYPE", "");
        rtDEMap.put("ORGSECUSER", "");
        rtDEMap.put("ORGUSER", "");
        rtDEMap.put("ORGUSERLEVEL", "");
        rtDEMap.put("ORGSECTOR", "");
        rtDEMap.put("ORGUNITCAT", "");
        rtDEMap.put("ORGTYPE", "");
        rtDEMap.put("ORG", "");
        rtDEMap.put("LOGINLOG", "");
        rtDEMap.put("CODEITEM", "");
        rtDEMap.put("CODELIST", "");
        rtDEMap.put("USERDICT", "");
        rtDEMap.put("USERDICTCAT", "");
        rtDEMap.put("USERDICTITEM", "");
        rtDEMap.put("MSGACCOUNT", "");
        rtDEMap.put("MSGTEMPLATE", "");
        rtDEMap.put("MSGSENDQUEUE", "");
        rtDEMap.put("MSGSENDQUEUEHIS", "");
        rtDEMap.put("MSGACCOUNTDETAIL", "");
        rtDEMap.put("SERVICE", "");
        rtDEMap.put("USERROLERES", "");
        rtDEMap.put("DATAAUDIT", "");
        rtDEMap.put("USERROLEDEFIELDS", "");
        rtDEMap.put("DATAAUDITDETAIL", "");
        rtDEMap.put("USERROLEDEFIELD", "");
        rtDEMap.put("DALOG", "");
        rtDEMap.put("UNIRES", "");
        rtDEMap.put("PORTALPAGE", "");
        rtDEMap.put("PVPART", "");
        rtDEMap.put("PPMODEL", "");
        rtDEMap.put("REGISTRY", "");
        rtDEMap.put("SYSTEM", "");
        rtDEMap.put("SYSADMIN", "");
        rtDEMap.put("SYSADMINFUNC", "");
        rtDEMap.put("WFUIWIZARD", "");
        rtDEMap.put("USERROLETYPE", "");
        rtDEMap.put("WFUCPOLICY", "");
        rtDEMap.put("WFASSISTWORK", "");
        rtDEMap.put("DATASYNCIN2", "");
        rtDEMap.put("DATASYNCAGENT", "");
        rtDEMap.put("DATASYNCIN", "");
        rtDEMap.put("DATASYNCOUT", "");
        rtDEMap.put("DATASYNCOUT2", "");
        rtDEMap.put("TSSDENGINE", "");
        rtDEMap.put("TSSDGROUP", "");
        rtDEMap.put("TSSDGROUPDETAIL", "");
        rtDEMap.put("TSSDITEM", "");
        rtDEMap.put("TSSDPOLICY", "");
        rtDEMap.put("TSSDPOLICYOWNER", "");
        rtDEMap.put("TSSDTASK", "");
        rtDEMap.put("TSSDTASKLOG", "");
        rtDEMap.put("TSSDTASKPOLICY", "");
        rtDEMap.put("TSSDTASKTYPE", "");
        rtDEMap.put("DEDATACHG", "");
        rtDEMap.put("DEDATACHG2", "");
        rtDEMap.put("DEDATACHGDISP", "");
        rtDEMap.put("WXACCOUNT", "");
        rtDEMap.put("WXACCESSTOKEN", "");
        rtDEMap.put("WXORGSECTOR", "");
        rtDEMap.put("WXMESSAGE", "");
        rtDEMap.put("WXMEDIA", "");
        rtDEMap.put("WXENTAPP", "");
    }
}

