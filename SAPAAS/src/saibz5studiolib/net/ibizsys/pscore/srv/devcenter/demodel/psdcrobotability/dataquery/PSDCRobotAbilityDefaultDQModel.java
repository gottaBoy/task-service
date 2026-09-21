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
package net.ibizsys.pscore.srv.devcenter.demodel.psdcrobotability.dataquery;

import net.ibizsys.paas.core.DEDataQuery;
import net.ibizsys.paas.core.DEDataQueryCode;
import net.ibizsys.paas.core.DEDataQueryCodeExp;
import net.ibizsys.paas.core.DEDataQueryCodes;
import net.ibizsys.paas.demodel.DEDataQueryModelBase;

@DEDataQuery(id="B80A2F44-0111-4672-B1FD-8E2095E1F8A0", name="DEFAULT", defaultmode=true)
@DEDataQueryCodes(value={@DEDataQueryCode(querycode="SELECT t1.`CREATEDATE`, t1.`CREATEMAN`, t1.`ENERGY`, t1.`EXPIREDTIME`, t1.`MEMO`, t1.`PSDCROBOTABILITYID`, t1.`PSDCROBOTABILITYNAME`, t1.`PSDCROBOTID`, t1.`PSDCROBOTNAME`, t1.`PSDEVCENTERID`, t1.`PSDEVCENTERNAME`, t1.`PSROBOTABILITYID`, t1.`PSROBOTABILITYNAME`, t1.`ROBOTWORKTYPE`, t1.`UPDATEDATE`, t1.`UPDATEMAN`, t1.`VALIDFLAG` FROM `T_SRFPSDCROBOTABILITY` t1  ", querycodetemp="", declarecode="", dbtype="MYSQL5", fieldexps={@DEDataQueryCodeExp(name="CREATEDATE", expression="t1.`CREATEDATE`", showorder=0), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.`CREATEMAN`", showorder=1), @DEDataQueryCodeExp(name="ENERGY", expression="t1.`ENERGY`", showorder=2), @DEDataQueryCodeExp(name="EXPIREDTIME", expression="t1.`EXPIREDTIME`", showorder=3), @DEDataQueryCodeExp(name="MEMO", expression="t1.`MEMO`", showorder=4), @DEDataQueryCodeExp(name="PSDCROBOTABILITYID", expression="t1.`PSDCROBOTABILITYID`", showorder=5), @DEDataQueryCodeExp(name="PSDCROBOTABILITYNAME", expression="t1.`PSDCROBOTABILITYNAME`", showorder=6), @DEDataQueryCodeExp(name="PSDCROBOTID", expression="t1.`PSDCROBOTID`", showorder=7), @DEDataQueryCodeExp(name="PSDCROBOTNAME", expression="t1.`PSDCROBOTNAME`", showorder=8), @DEDataQueryCodeExp(name="PSDEVCENTERID", expression="t1.`PSDEVCENTERID`", showorder=9), @DEDataQueryCodeExp(name="PSDEVCENTERNAME", expression="t1.`PSDEVCENTERNAME`", showorder=10), @DEDataQueryCodeExp(name="PSROBOTABILITYID", expression="t1.`PSROBOTABILITYID`", showorder=11), @DEDataQueryCodeExp(name="PSROBOTABILITYNAME", expression="t1.`PSROBOTABILITYNAME`", showorder=12), @DEDataQueryCodeExp(name="ROBOTWORKTYPE", expression="t1.`ROBOTWORKTYPE`", showorder=13), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.`UPDATEDATE`", showorder=14), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.`UPDATEMAN`", showorder=15), @DEDataQueryCodeExp(name="VALIDFLAG", expression="t1.`VALIDFLAG`", showorder=16)}, conds={}), @DEDataQueryCode(querycode="SELECT t1.CREATEDATE, t1.CREATEMAN, t1.ENERGY, t1.EXPIREDTIME, t1.MEMO, t1.PSDCROBOTABILITYID, t1.PSDCROBOTABILITYNAME, t1.PSDCROBOTID, t1.PSDCROBOTNAME, t1.PSDEVCENTERID, t1.PSDEVCENTERNAME, t1.PSROBOTABILITYID, t1.PSROBOTABILITYNAME, t1.ROBOTWORKTYPE, t1.UPDATEDATE, t1.UPDATEMAN, t1.VALIDFLAG FROM T_SRFPSDCROBOTABILITY t1  ", querycodetemp="", declarecode="", dbtype="ORACLE", fieldexps={@DEDataQueryCodeExp(name="CREATEDATE", expression="t1.CREATEDATE", showorder=0), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.CREATEMAN", showorder=1), @DEDataQueryCodeExp(name="ENERGY", expression="t1.ENERGY", showorder=2), @DEDataQueryCodeExp(name="EXPIREDTIME", expression="t1.EXPIREDTIME", showorder=3), @DEDataQueryCodeExp(name="MEMO", expression="t1.MEMO", showorder=4), @DEDataQueryCodeExp(name="PSDCROBOTABILITYID", expression="t1.PSDCROBOTABILITYID", showorder=5), @DEDataQueryCodeExp(name="PSDCROBOTABILITYNAME", expression="t1.PSDCROBOTABILITYNAME", showorder=6), @DEDataQueryCodeExp(name="PSDCROBOTID", expression="t1.PSDCROBOTID", showorder=7), @DEDataQueryCodeExp(name="PSDCROBOTNAME", expression="t1.PSDCROBOTNAME", showorder=8), @DEDataQueryCodeExp(name="PSDEVCENTERID", expression="t1.PSDEVCENTERID", showorder=9), @DEDataQueryCodeExp(name="PSDEVCENTERNAME", expression="t1.PSDEVCENTERNAME", showorder=10), @DEDataQueryCodeExp(name="PSROBOTABILITYID", expression="t1.PSROBOTABILITYID", showorder=11), @DEDataQueryCodeExp(name="PSROBOTABILITYNAME", expression="t1.PSROBOTABILITYNAME", showorder=12), @DEDataQueryCodeExp(name="ROBOTWORKTYPE", expression="t1.ROBOTWORKTYPE", showorder=13), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.UPDATEDATE", showorder=14), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.UPDATEMAN", showorder=15), @DEDataQueryCodeExp(name="VALIDFLAG", expression="t1.VALIDFLAG", showorder=16)}, conds={})})
public class PSDCRobotAbilityDefaultDQModel
extends DEDataQueryModelBase {
    public PSDCRobotAbilityDefaultDQModel() {
        this.initAnnotation(PSDCRobotAbilityDefaultDQModel.class);
    }
}

