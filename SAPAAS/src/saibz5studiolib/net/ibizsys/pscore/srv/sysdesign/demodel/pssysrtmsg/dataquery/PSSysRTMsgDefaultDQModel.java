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
package net.ibizsys.pscore.srv.sysdesign.demodel.pssysrtmsg.dataquery;

import net.ibizsys.paas.core.DEDataQuery;
import net.ibizsys.paas.core.DEDataQueryCode;
import net.ibizsys.paas.core.DEDataQueryCodeExp;
import net.ibizsys.paas.core.DEDataQueryCodes;
import net.ibizsys.paas.demodel.DEDataQueryModelBase;

@DEDataQuery(id="8A3166AF-6C47-44D8-8FFD-E2B7B51C035E", name="DEFAULT", defaultmode=true)
@DEDataQueryCodes(value={@DEDataQueryCode(querycode="SELECT t1.`CONTENT`, t1.`CREATEDATE`, t1.`CREATEMAN`, t1.`ENABLEREMOVE`, t1.`MSGPOS`, t1.`MSGTYPE`, t1.`PSOBJID`, t1.`PSOBJTYPE`, t1.`PSSYSRTMSGID`, t1.`PSSYSRTMSGNAME`, t1.`PSSYSTEMID`, t1.`TITLE`, t1.`UPDATEDATE`, t1.`UPDATEMAN`, t1.`USERTAG`, t1.`USERTAG2` FROM `T_SRFPSSYSRTMSG` t1  ", querycodetemp="", declarecode="", dbtype="MYSQL5", fieldexps={@DEDataQueryCodeExp(name="CONTENT", expression="t1.`CONTENT`", showorder=0), @DEDataQueryCodeExp(name="CREATEDATE", expression="t1.`CREATEDATE`", showorder=1), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.`CREATEMAN`", showorder=2), @DEDataQueryCodeExp(name="ENABLEREMOVE", expression="t1.`ENABLEREMOVE`", showorder=3), @DEDataQueryCodeExp(name="MSGPOS", expression="t1.`MSGPOS`", showorder=4), @DEDataQueryCodeExp(name="MSGTYPE", expression="t1.`MSGTYPE`", showorder=5), @DEDataQueryCodeExp(name="PSOBJID", expression="t1.`PSOBJID`", showorder=6), @DEDataQueryCodeExp(name="PSOBJTYPE", expression="t1.`PSOBJTYPE`", showorder=7), @DEDataQueryCodeExp(name="PSSYSRTMSGID", expression="t1.`PSSYSRTMSGID`", showorder=8), @DEDataQueryCodeExp(name="PSSYSRTMSGNAME", expression="t1.`PSSYSRTMSGNAME`", showorder=9), @DEDataQueryCodeExp(name="PSSYSTEMID", expression="t1.`PSSYSTEMID`", showorder=10), @DEDataQueryCodeExp(name="TITLE", expression="t1.`TITLE`", showorder=11), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.`UPDATEDATE`", showorder=12), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.`UPDATEMAN`", showorder=13), @DEDataQueryCodeExp(name="USERTAG", expression="t1.`USERTAG`", showorder=14), @DEDataQueryCodeExp(name="USERTAG2", expression="t1.`USERTAG2`", showorder=15)}, conds={}), @DEDataQueryCode(querycode="SELECT t1.CONTENT, t1.CREATEDATE, t1.CREATEMAN, t1.ENABLEREMOVE, t1.MSGPOS, t1.MSGTYPE, t1.PSOBJID, t1.PSOBJTYPE, t1.PSSYSRTMSGID, t1.PSSYSRTMSGNAME, t1.PSSYSTEMID, t1.TITLE, t1.UPDATEDATE, t1.UPDATEMAN, t1.USERTAG, t1.USERTAG2 FROM T_SRFPSSYSRTMSG t1  ", querycodetemp="", declarecode="", dbtype="ORACLE", fieldexps={@DEDataQueryCodeExp(name="CONTENT", expression="t1.CONTENT", showorder=0), @DEDataQueryCodeExp(name="CREATEDATE", expression="t1.CREATEDATE", showorder=1), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.CREATEMAN", showorder=2), @DEDataQueryCodeExp(name="ENABLEREMOVE", expression="t1.ENABLEREMOVE", showorder=3), @DEDataQueryCodeExp(name="MSGPOS", expression="t1.MSGPOS", showorder=4), @DEDataQueryCodeExp(name="MSGTYPE", expression="t1.MSGTYPE", showorder=5), @DEDataQueryCodeExp(name="PSOBJID", expression="t1.PSOBJID", showorder=6), @DEDataQueryCodeExp(name="PSOBJTYPE", expression="t1.PSOBJTYPE", showorder=7), @DEDataQueryCodeExp(name="PSSYSRTMSGID", expression="t1.PSSYSRTMSGID", showorder=8), @DEDataQueryCodeExp(name="PSSYSRTMSGNAME", expression="t1.PSSYSRTMSGNAME", showorder=9), @DEDataQueryCodeExp(name="PSSYSTEMID", expression="t1.PSSYSTEMID", showorder=10), @DEDataQueryCodeExp(name="TITLE", expression="t1.TITLE", showorder=11), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.UPDATEDATE", showorder=12), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.UPDATEMAN", showorder=13), @DEDataQueryCodeExp(name="USERTAG", expression="t1.USERTAG", showorder=14), @DEDataQueryCodeExp(name="USERTAG2", expression="t1.USERTAG2", showorder=15)}, conds={})})
public class PSSysRTMsgDefaultDQModel
extends DEDataQueryModelBase {
    public PSSysRTMsgDefaultDQModel() {
        this.initAnnotation(PSSysRTMsgDefaultDQModel.class);
    }
}

