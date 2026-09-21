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
package net.ibizsys.pscore.srv.sysdevstudio.demodel.psdsconsole.dataquery;

import net.ibizsys.paas.core.DEDataQuery;
import net.ibizsys.paas.core.DEDataQueryCode;
import net.ibizsys.paas.core.DEDataQueryCodeExp;
import net.ibizsys.paas.core.DEDataQueryCodes;
import net.ibizsys.paas.demodel.DEDataQueryModelBase;

@DEDataQuery(id="BE387868-AB8E-4ADC-B8FB-95371D6FC36D", name="DEFAULT", defaultmode=true)
@DEDataQueryCodes(value={@DEDataQueryCode(querycode="SELECT t1.`CREATEDATE`, t1.`CREATEMAN`, t1.`DSTAG`, t1.`DSTAG2`, t1.`DSTAG3`, t1.`DSTAG4`, t1.`HTTPADDRESS`, t1.`HTTPPORT`, t1.`PSCONSOLESERVERID`, t1.`PSCONSOLESERVERNAME`, t1.`PSDEVSLNSYSID`, t1.`PSDEVUSERID`, t1.`PSDSCONSOLEID`, t1.`PSDSCONSOLENAME`, t1.`UPDATEDATE`, t1.`UPDATEMAN` FROM `T_SRFPSDSCONSOLE` t1  ", querycodetemp="", declarecode="", dbtype="MYSQL5", fieldexps={@DEDataQueryCodeExp(name="CREATEDATE", expression="t1.`CREATEDATE`", showorder=0), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.`CREATEMAN`", showorder=1), @DEDataQueryCodeExp(name="DSTAG", expression="t1.`DSTAG`", showorder=2), @DEDataQueryCodeExp(name="DSTAG2", expression="t1.`DSTAG2`", showorder=3), @DEDataQueryCodeExp(name="DSTAG3", expression="t1.`DSTAG3`", showorder=4), @DEDataQueryCodeExp(name="DSTAG4", expression="t1.`DSTAG4`", showorder=5), @DEDataQueryCodeExp(name="HTTPADDRESS", expression="t1.`HTTPADDRESS`", showorder=6), @DEDataQueryCodeExp(name="HTTPPORT", expression="t1.`HTTPPORT`", showorder=7), @DEDataQueryCodeExp(name="PSCONSOLESERVERID", expression="t1.`PSCONSOLESERVERID`", showorder=8), @DEDataQueryCodeExp(name="PSCONSOLESERVERNAME", expression="t1.`PSCONSOLESERVERNAME`", showorder=9), @DEDataQueryCodeExp(name="PSDEVSLNSYSID", expression="t1.`PSDEVSLNSYSID`", showorder=10), @DEDataQueryCodeExp(name="PSDEVUSERID", expression="t1.`PSDEVUSERID`", showorder=11), @DEDataQueryCodeExp(name="PSDSCONSOLEID", expression="t1.`PSDSCONSOLEID`", showorder=12), @DEDataQueryCodeExp(name="PSDSCONSOLENAME", expression="t1.`PSDSCONSOLENAME`", showorder=13), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.`UPDATEDATE`", showorder=14), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.`UPDATEMAN`", showorder=15)}, conds={}), @DEDataQueryCode(querycode="SELECT t1.CREATEDATE, t1.CREATEMAN, t1.DSTAG, t1.DSTAG2, t1.DSTAG3, t1.DSTAG4, t1.HTTPADDRESS, t1.HTTPPORT, t1.PSCONSOLESERVERID, t1.PSCONSOLESERVERNAME, t1.PSDEVSLNSYSID, t1.PSDEVUSERID, t1.PSDSCONSOLEID, t1.PSDSCONSOLENAME, t1.UPDATEDATE, t1.UPDATEMAN FROM T_SRFPSDSCONSOLE t1  ", querycodetemp="", declarecode="", dbtype="ORACLE", fieldexps={@DEDataQueryCodeExp(name="CREATEDATE", expression="t1.CREATEDATE", showorder=0), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.CREATEMAN", showorder=1), @DEDataQueryCodeExp(name="DSTAG", expression="t1.DSTAG", showorder=2), @DEDataQueryCodeExp(name="DSTAG2", expression="t1.DSTAG2", showorder=3), @DEDataQueryCodeExp(name="DSTAG3", expression="t1.DSTAG3", showorder=4), @DEDataQueryCodeExp(name="DSTAG4", expression="t1.DSTAG4", showorder=5), @DEDataQueryCodeExp(name="HTTPADDRESS", expression="t1.HTTPADDRESS", showorder=6), @DEDataQueryCodeExp(name="HTTPPORT", expression="t1.HTTPPORT", showorder=7), @DEDataQueryCodeExp(name="PSCONSOLESERVERID", expression="t1.PSCONSOLESERVERID", showorder=8), @DEDataQueryCodeExp(name="PSCONSOLESERVERNAME", expression="t1.PSCONSOLESERVERNAME", showorder=9), @DEDataQueryCodeExp(name="PSDEVSLNSYSID", expression="t1.PSDEVSLNSYSID", showorder=10), @DEDataQueryCodeExp(name="PSDEVUSERID", expression="t1.PSDEVUSERID", showorder=11), @DEDataQueryCodeExp(name="PSDSCONSOLEID", expression="t1.PSDSCONSOLEID", showorder=12), @DEDataQueryCodeExp(name="PSDSCONSOLENAME", expression="t1.PSDSCONSOLENAME", showorder=13), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.UPDATEDATE", showorder=14), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.UPDATEMAN", showorder=15)}, conds={})})
public class PSDSConsoleDefaultDQModel
extends DEDataQueryModelBase {
    public PSDSConsoleDefaultDQModel() {
        this.initAnnotation(PSDSConsoleDefaultDQModel.class);
    }
}

