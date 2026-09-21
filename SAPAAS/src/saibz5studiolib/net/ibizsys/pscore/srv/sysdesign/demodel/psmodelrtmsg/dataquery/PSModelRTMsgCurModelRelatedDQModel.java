/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEDataQuery
 *  net.ibizsys.paas.core.DEDataQueryCode
 *  net.ibizsys.paas.core.DEDataQueryCodeCond
 *  net.ibizsys.paas.core.DEDataQueryCodeExp
 *  net.ibizsys.paas.core.DEDataQueryCodes
 *  net.ibizsys.paas.demodel.DEDataQueryModelBase
 */
package net.ibizsys.pscore.srv.sysdesign.demodel.psmodelrtmsg.dataquery;

import net.ibizsys.paas.core.DEDataQuery;
import net.ibizsys.paas.core.DEDataQueryCode;
import net.ibizsys.paas.core.DEDataQueryCodeCond;
import net.ibizsys.paas.core.DEDataQueryCodeExp;
import net.ibizsys.paas.core.DEDataQueryCodes;
import net.ibizsys.paas.demodel.DEDataQueryModelBase;

@DEDataQuery(id="EA7A16DF-32CF-47FA-965E-112DED5C5EF6", name="CurModelRelated")
@DEDataQueryCodes(value={@DEDataQueryCode(querycode="SELECT t1.`CONTENT`, t1.`CREATEDATE`, t1.`CREATEMAN`, t1.`MAINCAT`, t1.`MSGPOS`, t1.`MSGTYPE`, t1.`ORDERVALUE`, t1.`PSMODELRTMSGID`, t1.`PSMODELRTMSGNAME`, t1.`SRFDEID`, t1.`SRFDERID`, t1.`SRFKEY`, t1.`SUBCAT`, t1.`TITLE`, t1.`UPDATEDATE`, t1.`UPDATEMAN` FROM `T_SRFPSMODELRTMSG` t1  ", querycodetemp="", declarecode="", dbtype="MYSQL5", fieldexps={@DEDataQueryCodeExp(name="CONTENT", expression="t1.`CONTENT`", showorder=0), @DEDataQueryCodeExp(name="CREATEDATE", expression="t1.`CREATEDATE`", showorder=1), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.`CREATEMAN`", showorder=2), @DEDataQueryCodeExp(name="MAINCAT", expression="t1.`MAINCAT`", showorder=3), @DEDataQueryCodeExp(name="MSGPOS", expression="t1.`MSGPOS`", showorder=4), @DEDataQueryCodeExp(name="MSGTYPE", expression="t1.`MSGTYPE`", showorder=5), @DEDataQueryCodeExp(name="ORDERVALUE", expression="t1.`ORDERVALUE`", showorder=6), @DEDataQueryCodeExp(name="PSMODELRTMSGID", expression="t1.`PSMODELRTMSGID`", showorder=7), @DEDataQueryCodeExp(name="PSMODELRTMSGNAME", expression="t1.`PSMODELRTMSGNAME`", showorder=8), @DEDataQueryCodeExp(name="SRFDEID", expression="t1.`SRFDEID`", showorder=9), @DEDataQueryCodeExp(name="SRFDERID", expression="t1.`SRFDERID`", showorder=10), @DEDataQueryCodeExp(name="SRFKEY", expression="t1.`SRFKEY`", showorder=11), @DEDataQueryCodeExp(name="SUBCAT", expression="t1.`SUBCAT`", showorder=12), @DEDataQueryCodeExp(name="TITLE", expression="t1.`TITLE`", showorder=13), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.`UPDATEDATE`", showorder=14), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.`UPDATEMAN`", showorder=15)}, conds={@DEDataQueryCodeCond(condition="( t1.`SRFDEID` =  ${srfdatacontext('srfdeid','{\"defname\":\"SRFDEID\",\"dename\":\"PSMODELRTMSG\"}')}  AND  t1.`SRFKEY` =  ${srfdatacontext('srfkey','{\"defname\":\"SRFKEY\",\"dename\":\"PSMODELRTMSG\"}')}  AND  t1.`SRFDERID` =  ${srfdatacontext('srfderid','{\"defname\":\"SRFDERID\",\"dename\":\"PSMODELRTMSG\"}')} )")}), @DEDataQueryCode(querycode="SELECT t1.CONTENT, t1.CREATEDATE, t1.CREATEMAN, t1.MAINCAT, t1.MSGPOS, t1.MSGTYPE, t1.ORDERVALUE, t1.PSMODELRTMSGID, t1.PSMODELRTMSGNAME, t1.SRFDEID, t1.SRFDERID, t1.SRFKEY, t1.SUBCAT, t1.TITLE, t1.UPDATEDATE, t1.UPDATEMAN FROM T_SRFPSMODELRTMSG t1  ", querycodetemp="", declarecode="", dbtype="ORACLE", fieldexps={@DEDataQueryCodeExp(name="CONTENT", expression="t1.CONTENT", showorder=0), @DEDataQueryCodeExp(name="CREATEDATE", expression="t1.CREATEDATE", showorder=1), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.CREATEMAN", showorder=2), @DEDataQueryCodeExp(name="MAINCAT", expression="t1.MAINCAT", showorder=3), @DEDataQueryCodeExp(name="MSGPOS", expression="t1.MSGPOS", showorder=4), @DEDataQueryCodeExp(name="MSGTYPE", expression="t1.MSGTYPE", showorder=5), @DEDataQueryCodeExp(name="ORDERVALUE", expression="t1.ORDERVALUE", showorder=6), @DEDataQueryCodeExp(name="PSMODELRTMSGID", expression="t1.PSMODELRTMSGID", showorder=7), @DEDataQueryCodeExp(name="PSMODELRTMSGNAME", expression="t1.PSMODELRTMSGNAME", showorder=8), @DEDataQueryCodeExp(name="SRFDEID", expression="t1.SRFDEID", showorder=9), @DEDataQueryCodeExp(name="SRFDERID", expression="t1.SRFDERID", showorder=10), @DEDataQueryCodeExp(name="SRFKEY", expression="t1.SRFKEY", showorder=11), @DEDataQueryCodeExp(name="SUBCAT", expression="t1.SUBCAT", showorder=12), @DEDataQueryCodeExp(name="TITLE", expression="t1.TITLE", showorder=13), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.UPDATEDATE", showorder=14), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.UPDATEMAN", showorder=15)}, conds={@DEDataQueryCodeCond(condition="( t1.SRFDEID =  ${srfdatacontext('srfdeid','{\"defname\":\"SRFDEID\",\"dename\":\"PSMODELRTMSG\"}')}  AND  t1.SRFKEY =  ${srfdatacontext('srfkey','{\"defname\":\"SRFKEY\",\"dename\":\"PSMODELRTMSG\"}')}  AND  t1.SRFDERID =  ${srfdatacontext('srfderid','{\"defname\":\"SRFDERID\",\"dename\":\"PSMODELRTMSG\"}')} )")})})
public class PSModelRTMsgCurModelRelatedDQModel
extends DEDataQueryModelBase {
    public PSModelRTMsgCurModelRelatedDQModel() {
        this.initAnnotation(PSModelRTMsgCurModelRelatedDQModel.class);
    }
}

