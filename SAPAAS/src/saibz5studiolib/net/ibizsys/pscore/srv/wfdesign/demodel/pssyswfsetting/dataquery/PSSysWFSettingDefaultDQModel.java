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
package net.ibizsys.pscore.srv.wfdesign.demodel.pssyswfsetting.dataquery;

import net.ibizsys.paas.core.DEDataQuery;
import net.ibizsys.paas.core.DEDataQueryCode;
import net.ibizsys.paas.core.DEDataQueryCodeExp;
import net.ibizsys.paas.core.DEDataQueryCodes;
import net.ibizsys.paas.demodel.DEDataQueryModelBase;

@DEDataQuery(id="448E4992-F5B6-47BB-B58B-CF4A7F5F740A", name="DEFAULT", defaultmode=true)
@DEDataQueryCodes(value={@DEDataQueryCode(querycode="SELECT t1.`CODENAME`, t1.`CREATEDATE`, t1.`CREATEMAN`, t1.`MEMO`, t1.`PSSYSMSGTEMPLID`, t11.`PSSYSMSGTEMPLNAME`, t1.`PSSYSTEMID`, t1.`PSSYSTEMNAME`, t1.`PSSYSWFSETTINGID`, t1.`PSSYSWFSETTINGNAME`, t1.`UPDATEDATE`, t1.`UPDATEMAN`, t1.`USERPARAMS` FROM `T_SRFPSSYSWFSETTING` t1  LEFT JOIN T_SRFPSSYSMSGTEMPL t11 ON t1.PSSYSMSGTEMPLID = t11.PSSYSMSGTEMPLID  ", querycodetemp="", declarecode="", dbtype="MYSQL5", fieldexps={@DEDataQueryCodeExp(name="CODENAME", expression="t1.`CODENAME`", showorder=0), @DEDataQueryCodeExp(name="CREATEDATE", expression="t1.`CREATEDATE`", showorder=1), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.`CREATEMAN`", showorder=2), @DEDataQueryCodeExp(name="MEMO", expression="t1.`MEMO`", showorder=3), @DEDataQueryCodeExp(name="PSSYSMSGTEMPLID", expression="t1.`PSSYSMSGTEMPLID`", showorder=4), @DEDataQueryCodeExp(name="PSSYSMSGTEMPLNAME", expression="t11.`PSSYSMSGTEMPLNAME`", showorder=5), @DEDataQueryCodeExp(name="PSSYSTEMID", expression="t1.`PSSYSTEMID`", showorder=6), @DEDataQueryCodeExp(name="PSSYSTEMNAME", expression="t1.`PSSYSTEMNAME`", showorder=7), @DEDataQueryCodeExp(name="PSSYSWFSETTINGID", expression="t1.`PSSYSWFSETTINGID`", showorder=8), @DEDataQueryCodeExp(name="PSSYSWFSETTINGNAME", expression="t1.`PSSYSWFSETTINGNAME`", showorder=9), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.`UPDATEDATE`", showorder=10), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.`UPDATEMAN`", showorder=11), @DEDataQueryCodeExp(name="USERPARAMS", expression="t1.`USERPARAMS`", showorder=12)}, conds={}), @DEDataQueryCode(querycode="SELECT t1.CODENAME, t1.CREATEDATE, t1.CREATEMAN, t1.MEMO, t1.PSSYSMSGTEMPLID, t11.PSSYSMSGTEMPLNAME, t1.PSSYSTEMID, t1.PSSYSTEMNAME, t1.PSSYSWFSETTINGID, t1.PSSYSWFSETTINGNAME, t1.UPDATEDATE, t1.UPDATEMAN, t1.USERPARAMS FROM T_SRFPSSYSWFSETTING t1  LEFT JOIN T_SRFPSSYSMSGTEMPL t11 ON t1.PSSYSMSGTEMPLID = t11.PSSYSMSGTEMPLID  ", querycodetemp="", declarecode="", dbtype="ORACLE", fieldexps={@DEDataQueryCodeExp(name="CODENAME", expression="t1.CODENAME", showorder=0), @DEDataQueryCodeExp(name="CREATEDATE", expression="t1.CREATEDATE", showorder=1), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.CREATEMAN", showorder=2), @DEDataQueryCodeExp(name="MEMO", expression="t1.MEMO", showorder=3), @DEDataQueryCodeExp(name="PSSYSMSGTEMPLID", expression="t1.PSSYSMSGTEMPLID", showorder=4), @DEDataQueryCodeExp(name="PSSYSMSGTEMPLNAME", expression="t11.PSSYSMSGTEMPLNAME", showorder=5), @DEDataQueryCodeExp(name="PSSYSTEMID", expression="t1.PSSYSTEMID", showorder=6), @DEDataQueryCodeExp(name="PSSYSTEMNAME", expression="t1.PSSYSTEMNAME", showorder=7), @DEDataQueryCodeExp(name="PSSYSWFSETTINGID", expression="t1.PSSYSWFSETTINGID", showorder=8), @DEDataQueryCodeExp(name="PSSYSWFSETTINGNAME", expression="t1.PSSYSWFSETTINGNAME", showorder=9), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.UPDATEDATE", showorder=10), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.UPDATEMAN", showorder=11), @DEDataQueryCodeExp(name="USERPARAMS", expression="t1.USERPARAMS", showorder=12)}, conds={})})
public class PSSysWFSettingDefaultDQModel
extends DEDataQueryModelBase {
    public PSSysWFSettingDefaultDQModel() {
        this.initAnnotation(PSSysWFSettingDefaultDQModel.class);
    }
}

