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
package net.ibizsys.pscore.srv.config.demodel.pssfsahandler.dataquery;

import net.ibizsys.paas.core.DEDataQuery;
import net.ibizsys.paas.core.DEDataQueryCode;
import net.ibizsys.paas.core.DEDataQueryCodeExp;
import net.ibizsys.paas.core.DEDataQueryCodes;
import net.ibizsys.paas.demodel.DEDataQueryModelBase;

@DEDataQuery(id="A26D8632-91F5-46C1-90CE-DE855FD47A00", name="DEFAULT", defaultmode=true)
@DEDataQueryCodes(value={@DEDataQueryCode(querycode="SELECT t1.`CLIENTHANDLEROBJ`, t1.`CLIENTHANDLEROBJ2`, t1.`CREATEDATE`, t1.`CREATEMAN`, t1.`HANDLEROBJ`, t1.`HANDLEROBJ2`, t1.`HANDLEROBJ3`, t1.`HANDLEROBJ4`, t1.`MEMO`, t1.`PSSAHANDLERID`, t11.`PSSAHANDLERNAME`, t1.`PSSFID`, t1.`PSSFNAME`, t1.`PSSFSAHANDLERID`, t1.`PSSFSAHANDLERNAME`, t1.`SATYPE`, t1.`UPDATEDATE`, t1.`UPDATEMAN`, t1.`VALIDFLAG` FROM `T_SRFPSSFSAHANDLER` t1  LEFT JOIN T_SRFPSSAHANDLER t11 ON t1.PSSAHANDLERID = t11.PSSAHANDLERID  ", querycodetemp="", declarecode="", dbtype="MYSQL5", fieldexps={@DEDataQueryCodeExp(name="CLIENTHANDLEROBJ", expression="t1.`CLIENTHANDLEROBJ`", showorder=0), @DEDataQueryCodeExp(name="CLIENTHANDLEROBJ2", expression="t1.`CLIENTHANDLEROBJ2`", showorder=1), @DEDataQueryCodeExp(name="CREATEDATE", expression="t1.`CREATEDATE`", showorder=2), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.`CREATEMAN`", showorder=3), @DEDataQueryCodeExp(name="HANDLEROBJ", expression="t1.`HANDLEROBJ`", showorder=4), @DEDataQueryCodeExp(name="HANDLEROBJ2", expression="t1.`HANDLEROBJ2`", showorder=5), @DEDataQueryCodeExp(name="HANDLEROBJ3", expression="t1.`HANDLEROBJ3`", showorder=6), @DEDataQueryCodeExp(name="HANDLEROBJ4", expression="t1.`HANDLEROBJ4`", showorder=7), @DEDataQueryCodeExp(name="MEMO", expression="t1.`MEMO`", showorder=8), @DEDataQueryCodeExp(name="PSSAHANDLERID", expression="t1.`PSSAHANDLERID`", showorder=9), @DEDataQueryCodeExp(name="PSSAHANDLERNAME", expression="t11.`PSSAHANDLERNAME`", showorder=10), @DEDataQueryCodeExp(name="PSSFID", expression="t1.`PSSFID`", showorder=11), @DEDataQueryCodeExp(name="PSSFNAME", expression="t1.`PSSFNAME`", showorder=12), @DEDataQueryCodeExp(name="PSSFSAHANDLERID", expression="t1.`PSSFSAHANDLERID`", showorder=13), @DEDataQueryCodeExp(name="PSSFSAHANDLERNAME", expression="t1.`PSSFSAHANDLERNAME`", showorder=14), @DEDataQueryCodeExp(name="SATYPE", expression="t1.`SATYPE`", showorder=15), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.`UPDATEDATE`", showorder=16), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.`UPDATEMAN`", showorder=17), @DEDataQueryCodeExp(name="VALIDFLAG", expression="t1.`VALIDFLAG`", showorder=18)}, conds={}), @DEDataQueryCode(querycode="SELECT t1.CLIENTHANDLEROBJ, t1.CLIENTHANDLEROBJ2, t1.CREATEDATE, t1.CREATEMAN, t1.HANDLEROBJ, t1.HANDLEROBJ2, t1.HANDLEROBJ3, t1.HANDLEROBJ4, t1.MEMO, t1.PSSAHANDLERID, t11.PSSAHANDLERNAME, t1.PSSFID, t1.PSSFNAME, t1.PSSFSAHANDLERID, t1.PSSFSAHANDLERNAME, t1.SATYPE, t1.UPDATEDATE, t1.UPDATEMAN, t1.VALIDFLAG FROM T_SRFPSSFSAHANDLER t1  LEFT JOIN T_SRFPSSAHANDLER t11 ON t1.PSSAHANDLERID = t11.PSSAHANDLERID  ", querycodetemp="", declarecode="", dbtype="ORACLE", fieldexps={@DEDataQueryCodeExp(name="CLIENTHANDLEROBJ", expression="t1.CLIENTHANDLEROBJ", showorder=0), @DEDataQueryCodeExp(name="CLIENTHANDLEROBJ2", expression="t1.CLIENTHANDLEROBJ2", showorder=1), @DEDataQueryCodeExp(name="CREATEDATE", expression="t1.CREATEDATE", showorder=2), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.CREATEMAN", showorder=3), @DEDataQueryCodeExp(name="HANDLEROBJ", expression="t1.HANDLEROBJ", showorder=4), @DEDataQueryCodeExp(name="HANDLEROBJ2", expression="t1.HANDLEROBJ2", showorder=5), @DEDataQueryCodeExp(name="HANDLEROBJ3", expression="t1.HANDLEROBJ3", showorder=6), @DEDataQueryCodeExp(name="HANDLEROBJ4", expression="t1.HANDLEROBJ4", showorder=7), @DEDataQueryCodeExp(name="MEMO", expression="t1.MEMO", showorder=8), @DEDataQueryCodeExp(name="PSSAHANDLERID", expression="t1.PSSAHANDLERID", showorder=9), @DEDataQueryCodeExp(name="PSSAHANDLERNAME", expression="t11.PSSAHANDLERNAME", showorder=10), @DEDataQueryCodeExp(name="PSSFID", expression="t1.PSSFID", showorder=11), @DEDataQueryCodeExp(name="PSSFNAME", expression="t1.PSSFNAME", showorder=12), @DEDataQueryCodeExp(name="PSSFSAHANDLERID", expression="t1.PSSFSAHANDLERID", showorder=13), @DEDataQueryCodeExp(name="PSSFSAHANDLERNAME", expression="t1.PSSFSAHANDLERNAME", showorder=14), @DEDataQueryCodeExp(name="SATYPE", expression="t1.SATYPE", showorder=15), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.UPDATEDATE", showorder=16), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.UPDATEMAN", showorder=17), @DEDataQueryCodeExp(name="VALIDFLAG", expression="t1.VALIDFLAG", showorder=18)}, conds={})})
public class PSSFSAHandlerDefaultDQModel
extends DEDataQueryModelBase {
    public PSSFSAHandlerDefaultDQModel() {
        this.initAnnotation(PSSFSAHandlerDefaultDQModel.class);
    }
}

