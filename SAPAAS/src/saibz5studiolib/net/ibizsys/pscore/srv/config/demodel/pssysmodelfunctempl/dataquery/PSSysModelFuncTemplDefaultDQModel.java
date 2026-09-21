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
package net.ibizsys.pscore.srv.config.demodel.pssysmodelfunctempl.dataquery;

import net.ibizsys.paas.core.DEDataQuery;
import net.ibizsys.paas.core.DEDataQueryCode;
import net.ibizsys.paas.core.DEDataQueryCodeExp;
import net.ibizsys.paas.core.DEDataQueryCodes;
import net.ibizsys.paas.demodel.DEDataQueryModelBase;

@DEDataQuery(id="5D1FDE26-6B91-48AA-A21E-5C6F655F0F3A", name="DEFAULT", defaultmode=true)
@DEDataQueryCodes(value={@DEDataQueryCode(querycode="SELECT t1.`ANGULARJS`, t1.`CREATEDATE`, t1.`CREATEMAN`, t1.`EXTJS`, t1.`FR7`, t1.`J2EE6_IBIZSYSRT`, t1.`J2EE6_IBIZSYSRT_R2`, t1.`JQUERY`, t1.`JQUERY_R2`, t1.`MEMO`, t1.`PSSYSMODELFUNCID`, t11.`PSSYSMODELFUNCNAME`, t1.`PSSYSMODELFUNCTEMPLID`, t1.`PSSYSMODELFUNCTEMPLNAME`, t1.`UPDATEDATE`, t1.`UPDATEMAN` FROM `T_SRFPSSYSMODELFUNCTEMPL` t1  LEFT JOIN T_SRFPSSYSMODELFUNC t11 ON t1.PSSYSMODELFUNCID = t11.PSSYSMODELFUNCID  ", querycodetemp="", declarecode="", dbtype="MYSQL5", fieldexps={@DEDataQueryCodeExp(name="ANGULARJS", expression="t1.`ANGULARJS`", showorder=0), @DEDataQueryCodeExp(name="CREATEDATE", expression="t1.`CREATEDATE`", showorder=1), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.`CREATEMAN`", showorder=2), @DEDataQueryCodeExp(name="EXTJS", expression="t1.`EXTJS`", showorder=3), @DEDataQueryCodeExp(name="FR7", expression="t1.`FR7`", showorder=4), @DEDataQueryCodeExp(name="J2EE6_IBIZSYSRT", expression="t1.`J2EE6_IBIZSYSRT`", showorder=5), @DEDataQueryCodeExp(name="J2EE6_IBIZSYSRT_R2", expression="t1.`J2EE6_IBIZSYSRT_R2`", showorder=6), @DEDataQueryCodeExp(name="JQUERY", expression="t1.`JQUERY`", showorder=7), @DEDataQueryCodeExp(name="JQUERY_R2", expression="t1.`JQUERY_R2`", showorder=8), @DEDataQueryCodeExp(name="MEMO", expression="t1.`MEMO`", showorder=9), @DEDataQueryCodeExp(name="PSSYSMODELFUNCID", expression="t1.`PSSYSMODELFUNCID`", showorder=10), @DEDataQueryCodeExp(name="PSSYSMODELFUNCNAME", expression="t11.`PSSYSMODELFUNCNAME`", showorder=11), @DEDataQueryCodeExp(name="PSSYSMODELFUNCTEMPLID", expression="t1.`PSSYSMODELFUNCTEMPLID`", showorder=12), @DEDataQueryCodeExp(name="PSSYSMODELFUNCTEMPLNAME", expression="t1.`PSSYSMODELFUNCTEMPLNAME`", showorder=13), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.`UPDATEDATE`", showorder=14), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.`UPDATEMAN`", showorder=15)}, conds={}), @DEDataQueryCode(querycode="SELECT t1.ANGULARJS, t1.CREATEDATE, t1.CREATEMAN, t1.EXTJS, t1.FR7, t1.J2EE6_IBIZSYSRT, t1.J2EE6_IBIZSYSRT_R2, t1.JQUERY, t1.JQUERY_R2, t1.MEMO, t1.PSSYSMODELFUNCID, t11.PSSYSMODELFUNCNAME, t1.PSSYSMODELFUNCTEMPLID, t1.PSSYSMODELFUNCTEMPLNAME, t1.UPDATEDATE, t1.UPDATEMAN FROM T_SRFPSSYSMODELFUNCTEMPL t1  LEFT JOIN T_SRFPSSYSMODELFUNC t11 ON t1.PSSYSMODELFUNCID = t11.PSSYSMODELFUNCID  ", querycodetemp="", declarecode="", dbtype="ORACLE", fieldexps={@DEDataQueryCodeExp(name="ANGULARJS", expression="t1.ANGULARJS", showorder=0), @DEDataQueryCodeExp(name="CREATEDATE", expression="t1.CREATEDATE", showorder=1), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.CREATEMAN", showorder=2), @DEDataQueryCodeExp(name="EXTJS", expression="t1.EXTJS", showorder=3), @DEDataQueryCodeExp(name="FR7", expression="t1.FR7", showorder=4), @DEDataQueryCodeExp(name="J2EE6_IBIZSYSRT", expression="t1.J2EE6_IBIZSYSRT", showorder=5), @DEDataQueryCodeExp(name="J2EE6_IBIZSYSRT_R2", expression="t1.J2EE6_IBIZSYSRT_R2", showorder=6), @DEDataQueryCodeExp(name="JQUERY", expression="t1.JQUERY", showorder=7), @DEDataQueryCodeExp(name="JQUERY_R2", expression="t1.JQUERY_R2", showorder=8), @DEDataQueryCodeExp(name="MEMO", expression="t1.MEMO", showorder=9), @DEDataQueryCodeExp(name="PSSYSMODELFUNCID", expression="t1.PSSYSMODELFUNCID", showorder=10), @DEDataQueryCodeExp(name="PSSYSMODELFUNCNAME", expression="t11.PSSYSMODELFUNCNAME", showorder=11), @DEDataQueryCodeExp(name="PSSYSMODELFUNCTEMPLID", expression="t1.PSSYSMODELFUNCTEMPLID", showorder=12), @DEDataQueryCodeExp(name="PSSYSMODELFUNCTEMPLNAME", expression="t1.PSSYSMODELFUNCTEMPLNAME", showorder=13), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.UPDATEDATE", showorder=14), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.UPDATEMAN", showorder=15)}, conds={})})
public class PSSysModelFuncTemplDefaultDQModel
extends DEDataQueryModelBase {
    public PSSysModelFuncTemplDefaultDQModel() {
        this.initAnnotation(PSSysModelFuncTemplDefaultDQModel.class);
    }
}

