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
package net.ibizsys.pscore.srv.config.demodel.psmodelrs.dataquery;

import net.ibizsys.paas.core.DEDataQuery;
import net.ibizsys.paas.core.DEDataQueryCode;
import net.ibizsys.paas.core.DEDataQueryCodeExp;
import net.ibizsys.paas.core.DEDataQueryCodes;
import net.ibizsys.paas.demodel.DEDataQueryModelBase;

@DEDataQuery(id="806A88A0-BF04-4AE9-8F20-E46350CFB9BB", name="DEFAULT", defaultmode=true)
@DEDataQueryCodes(value={@DEDataQueryCode(querycode="SELECT t1.`CREATEDATE`, t1.`CREATEMAN`, t1.`MAJORPSMODELID`, t1.`MAJORPSMODELNAME`, t1.`MEMO`, t1.`MINORPSMODELID`, t1.`MINORPSMODELNAME`, t1.`PSMODELRSID`, t1.`PSMODELRSNAME`, t1.`UPDATEDATE`, t1.`UPDATEMAN`, t1.`VALIDFLAG` FROM `T_SRFPSMODELRS` t1  ", querycodetemp="", declarecode="", dbtype="MYSQL5", fieldexps={@DEDataQueryCodeExp(name="CREATEDATE", expression="t1.`CREATEDATE`", showorder=0), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.`CREATEMAN`", showorder=1), @DEDataQueryCodeExp(name="MAJORPSMODELID", expression="t1.`MAJORPSMODELID`", showorder=2), @DEDataQueryCodeExp(name="MAJORPSMODELNAME", expression="t1.`MAJORPSMODELNAME`", showorder=3), @DEDataQueryCodeExp(name="MEMO", expression="t1.`MEMO`", showorder=4), @DEDataQueryCodeExp(name="MINORPSMODELID", expression="t1.`MINORPSMODELID`", showorder=5), @DEDataQueryCodeExp(name="MINORPSMODELNAME", expression="t1.`MINORPSMODELNAME`", showorder=6), @DEDataQueryCodeExp(name="PSMODELRSID", expression="t1.`PSMODELRSID`", showorder=7), @DEDataQueryCodeExp(name="PSMODELRSNAME", expression="t1.`PSMODELRSNAME`", showorder=8), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.`UPDATEDATE`", showorder=9), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.`UPDATEMAN`", showorder=10), @DEDataQueryCodeExp(name="VALIDFLAG", expression="t1.`VALIDFLAG`", showorder=11)}, conds={}), @DEDataQueryCode(querycode="SELECT t1.CREATEDATE, t1.CREATEMAN, t1.MAJORPSMODELID, t1.MAJORPSMODELNAME, t1.MEMO, t1.MINORPSMODELID, t1.MINORPSMODELNAME, t1.PSMODELRSID, t1.PSMODELRSNAME, t1.UPDATEDATE, t1.UPDATEMAN, t1.VALIDFLAG FROM T_SRFPSMODELRS t1  ", querycodetemp="", declarecode="", dbtype="ORACLE", fieldexps={@DEDataQueryCodeExp(name="CREATEDATE", expression="t1.CREATEDATE", showorder=0), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.CREATEMAN", showorder=1), @DEDataQueryCodeExp(name="MAJORPSMODELID", expression="t1.MAJORPSMODELID", showorder=2), @DEDataQueryCodeExp(name="MAJORPSMODELNAME", expression="t1.MAJORPSMODELNAME", showorder=3), @DEDataQueryCodeExp(name="MEMO", expression="t1.MEMO", showorder=4), @DEDataQueryCodeExp(name="MINORPSMODELID", expression="t1.MINORPSMODELID", showorder=5), @DEDataQueryCodeExp(name="MINORPSMODELNAME", expression="t1.MINORPSMODELNAME", showorder=6), @DEDataQueryCodeExp(name="PSMODELRSID", expression="t1.PSMODELRSID", showorder=7), @DEDataQueryCodeExp(name="PSMODELRSNAME", expression="t1.PSMODELRSNAME", showorder=8), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.UPDATEDATE", showorder=9), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.UPDATEMAN", showorder=10), @DEDataQueryCodeExp(name="VALIDFLAG", expression="t1.VALIDFLAG", showorder=11)}, conds={})})
public class PSModelRSDefaultDQModel
extends DEDataQueryModelBase {
    public PSModelRSDefaultDQModel() {
        this.initAnnotation(PSModelRSDefaultDQModel.class);
    }
}

