/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEDataQuery
 *  net.ibizsys.paas.core.DEDataQueryCode
 *  net.ibizsys.paas.core.DEDataQueryCodeExp
 *  net.ibizsys.paas.core.DEDataQueryCodes
 *  net.ibizsys.paas.demodel.DEDataQueryModelBase
 */
package net.ibizsys.pscore.srv.sysdevstudio.demodel.psviewrtmsg.dataquery;

import net.ibizsys.paas.core.DEDataQuery;
import net.ibizsys.paas.core.DEDataQueryCode;
import net.ibizsys.paas.core.DEDataQueryCodeExp;
import net.ibizsys.paas.core.DEDataQueryCodes;
import net.ibizsys.paas.demodel.DEDataQueryModelBase;

@DEDataQuery(id="99D6568D-7B7A-4497-95D2-DFBC0F8DF571", name="DEFAULT", defaultmode=true)
@DEDataQueryCodes(value={@DEDataQueryCode(querycode="SELECT t1.`CONTENT`, t1.`CREATEDATE`, t1.`CREATEMAN`, t1.`MAINCAT`, t1.`MSGPOS`, t1.`MSGTYPE`, t1.`ORDERVALUE`, t1.`PSVIEWRTMSGID`, t1.`PSVIEWRTMSGNAME`, t1.`SRFVIEWID`, t1.`SUBCAT`, t1.`TITLE`, t1.`UPDATEDATE`, t1.`UPDATEMAN` FROM `T_SRFPSVIEWRTMSG` t1  ", querycodetemp="", declarecode="", dbtype="MYSQL5", fieldexps={@DEDataQueryCodeExp(name="CONTENT", expression="t1.`CONTENT`", showorder=0), @DEDataQueryCodeExp(name="CREATEDATE", expression="t1.`CREATEDATE`", showorder=1), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.`CREATEMAN`", showorder=2), @DEDataQueryCodeExp(name="MAINCAT", expression="t1.`MAINCAT`", showorder=3), @DEDataQueryCodeExp(name="MSGPOS", expression="t1.`MSGPOS`", showorder=4), @DEDataQueryCodeExp(name="MSGTYPE", expression="t1.`MSGTYPE`", showorder=5), @DEDataQueryCodeExp(name="ORDERVALUE", expression="t1.`ORDERVALUE`", showorder=6), @DEDataQueryCodeExp(name="PSVIEWRTMSGID", expression="t1.`PSVIEWRTMSGID`", showorder=7), @DEDataQueryCodeExp(name="PSVIEWRTMSGNAME", expression="t1.`PSVIEWRTMSGNAME`", showorder=8), @DEDataQueryCodeExp(name="SRFVIEWID", expression="t1.`SRFVIEWID`", showorder=9), @DEDataQueryCodeExp(name="SUBCAT", expression="t1.`SUBCAT`", showorder=10), @DEDataQueryCodeExp(name="TITLE", expression="t1.`TITLE`", showorder=11), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.`UPDATEDATE`", showorder=12), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.`UPDATEMAN`", showorder=13)}, conds={}), @DEDataQueryCode(querycode="SELECT t1.CONTENT, t1.CREATEDATE, t1.CREATEMAN, t1.MAINCAT, t1.MSGPOS, t1.MSGTYPE, t1.ORDERVALUE, t1.PSVIEWRTMSGID, t1.PSVIEWRTMSGNAME, t1.SRFVIEWID, t1.SUBCAT, t1.TITLE, t1.UPDATEDATE, t1.UPDATEMAN FROM T_SRFPSVIEWRTMSG t1  ", querycodetemp="", declarecode="", dbtype="ORACLE", fieldexps={@DEDataQueryCodeExp(name="CONTENT", expression="t1.CONTENT", showorder=0), @DEDataQueryCodeExp(name="CREATEDATE", expression="t1.CREATEDATE", showorder=1), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.CREATEMAN", showorder=2), @DEDataQueryCodeExp(name="MAINCAT", expression="t1.MAINCAT", showorder=3), @DEDataQueryCodeExp(name="MSGPOS", expression="t1.MSGPOS", showorder=4), @DEDataQueryCodeExp(name="MSGTYPE", expression="t1.MSGTYPE", showorder=5), @DEDataQueryCodeExp(name="ORDERVALUE", expression="t1.ORDERVALUE", showorder=6), @DEDataQueryCodeExp(name="PSVIEWRTMSGID", expression="t1.PSVIEWRTMSGID", showorder=7), @DEDataQueryCodeExp(name="PSVIEWRTMSGNAME", expression="t1.PSVIEWRTMSGNAME", showorder=8), @DEDataQueryCodeExp(name="SRFVIEWID", expression="t1.SRFVIEWID", showorder=9), @DEDataQueryCodeExp(name="SUBCAT", expression="t1.SUBCAT", showorder=10), @DEDataQueryCodeExp(name="TITLE", expression="t1.TITLE", showorder=11), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.UPDATEDATE", showorder=12), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.UPDATEMAN", showorder=13)}, conds={})})
public class PSViewRTMsgDefaultDQModel
extends DEDataQueryModelBase {
    public PSViewRTMsgDefaultDQModel() {
        this.initAnnotation(PSViewRTMsgDefaultDQModel.class);
    }
}

