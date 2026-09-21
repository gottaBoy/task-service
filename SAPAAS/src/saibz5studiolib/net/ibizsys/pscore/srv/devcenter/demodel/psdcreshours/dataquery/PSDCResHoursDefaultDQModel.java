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
package net.ibizsys.pscore.srv.devcenter.demodel.psdcreshours.dataquery;

import net.ibizsys.paas.core.DEDataQuery;
import net.ibizsys.paas.core.DEDataQueryCode;
import net.ibizsys.paas.core.DEDataQueryCodeExp;
import net.ibizsys.paas.core.DEDataQueryCodes;
import net.ibizsys.paas.demodel.DEDataQueryModelBase;

@DEDataQuery(id="3FCC1A50-FB42-4FB1-8AC7-BA1A693363A3", name="DEFAULT", defaultmode=true)
@DEDataQueryCodes(value={@DEDataQueryCode(querycode="SELECT t1.`BEGINTIME`, t1.`CREATEDATE`, t1.`CREATEMAN`, t1.`ENDTIME`, t1.`HOURS`, t1.`MEMO`, t1.`PSDCRESHOURSID`, t1.`PSDCRESHOURSNAME`, t1.`PSDEVCENTERID`, t1.`PSDEVCENTERNAME`, t1.`RESHOURSINFO`, t1.`RESSPEC`, t1.`RESSTATE`, t1.`RESTYPE`, t1.`UPDATEDATE`, t1.`UPDATEMAN`, t1.`USERTAG`, t1.`USERTAG2`, t1.`USERTAG3`, t1.`USERTAG4` FROM `T_SRFPSDCRESHOURS` t1  ", querycodetemp="", declarecode="", dbtype="MYSQL5", fieldexps={@DEDataQueryCodeExp(name="BEGINTIME", expression="t1.`BEGINTIME`", showorder=0), @DEDataQueryCodeExp(name="CREATEDATE", expression="t1.`CREATEDATE`", showorder=1), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.`CREATEMAN`", showorder=2), @DEDataQueryCodeExp(name="ENDTIME", expression="t1.`ENDTIME`", showorder=3), @DEDataQueryCodeExp(name="HOURS", expression="t1.`HOURS`", showorder=4), @DEDataQueryCodeExp(name="MEMO", expression="t1.`MEMO`", showorder=5), @DEDataQueryCodeExp(name="PSDCRESHOURSID", expression="t1.`PSDCRESHOURSID`", showorder=6), @DEDataQueryCodeExp(name="PSDCRESHOURSNAME", expression="t1.`PSDCRESHOURSNAME`", showorder=7), @DEDataQueryCodeExp(name="PSDEVCENTERID", expression="t1.`PSDEVCENTERID`", showorder=8), @DEDataQueryCodeExp(name="PSDEVCENTERNAME", expression="t1.`PSDEVCENTERNAME`", showorder=9), @DEDataQueryCodeExp(name="RESHOURSINFO", expression="t1.`RESHOURSINFO`", showorder=10), @DEDataQueryCodeExp(name="RESSPEC", expression="t1.`RESSPEC`", showorder=11), @DEDataQueryCodeExp(name="RESSTATE", expression="t1.`RESSTATE`", showorder=12), @DEDataQueryCodeExp(name="RESTYPE", expression="t1.`RESTYPE`", showorder=13), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.`UPDATEDATE`", showorder=14), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.`UPDATEMAN`", showorder=15), @DEDataQueryCodeExp(name="USERTAG", expression="t1.`USERTAG`", showorder=16), @DEDataQueryCodeExp(name="USERTAG2", expression="t1.`USERTAG2`", showorder=17), @DEDataQueryCodeExp(name="USERTAG3", expression="t1.`USERTAG3`", showorder=18), @DEDataQueryCodeExp(name="USERTAG4", expression="t1.`USERTAG4`", showorder=19)}, conds={}), @DEDataQueryCode(querycode="SELECT t1.BEGINTIME, t1.CREATEDATE, t1.CREATEMAN, t1.ENDTIME, t1.HOURS, t1.MEMO, t1.PSDCRESHOURSID, t1.PSDCRESHOURSNAME, t1.PSDEVCENTERID, t1.PSDEVCENTERNAME, t1.RESHOURSINFO, t1.RESSPEC, t1.RESSTATE, t1.RESTYPE, t1.UPDATEDATE, t1.UPDATEMAN, t1.USERTAG, t1.USERTAG2, t1.USERTAG3, t1.USERTAG4 FROM T_SRFPSDCRESHOURS t1  ", querycodetemp="", declarecode="", dbtype="ORACLE", fieldexps={@DEDataQueryCodeExp(name="BEGINTIME", expression="t1.BEGINTIME", showorder=0), @DEDataQueryCodeExp(name="CREATEDATE", expression="t1.CREATEDATE", showorder=1), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.CREATEMAN", showorder=2), @DEDataQueryCodeExp(name="ENDTIME", expression="t1.ENDTIME", showorder=3), @DEDataQueryCodeExp(name="HOURS", expression="t1.HOURS", showorder=4), @DEDataQueryCodeExp(name="MEMO", expression="t1.MEMO", showorder=5), @DEDataQueryCodeExp(name="PSDCRESHOURSID", expression="t1.PSDCRESHOURSID", showorder=6), @DEDataQueryCodeExp(name="PSDCRESHOURSNAME", expression="t1.PSDCRESHOURSNAME", showorder=7), @DEDataQueryCodeExp(name="PSDEVCENTERID", expression="t1.PSDEVCENTERID", showorder=8), @DEDataQueryCodeExp(name="PSDEVCENTERNAME", expression="t1.PSDEVCENTERNAME", showorder=9), @DEDataQueryCodeExp(name="RESHOURSINFO", expression="t1.RESHOURSINFO", showorder=10), @DEDataQueryCodeExp(name="RESSPEC", expression="t1.RESSPEC", showorder=11), @DEDataQueryCodeExp(name="RESSTATE", expression="t1.RESSTATE", showorder=12), @DEDataQueryCodeExp(name="RESTYPE", expression="t1.RESTYPE", showorder=13), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.UPDATEDATE", showorder=14), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.UPDATEMAN", showorder=15), @DEDataQueryCodeExp(name="USERTAG", expression="t1.USERTAG", showorder=16), @DEDataQueryCodeExp(name="USERTAG2", expression="t1.USERTAG2", showorder=17), @DEDataQueryCodeExp(name="USERTAG3", expression="t1.USERTAG3", showorder=18), @DEDataQueryCodeExp(name="USERTAG4", expression="t1.USERTAG4", showorder=19)}, conds={})})
public class PSDCResHoursDefaultDQModel
extends DEDataQueryModelBase {
    public PSDCResHoursDefaultDQModel() {
        this.initAnnotation(PSDCResHoursDefaultDQModel.class);
    }
}

