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
package net.ibizsys.pscore.srv.paasmgr.demodel.psworkspacepolicy.dataquery;

import net.ibizsys.paas.core.DEDataQuery;
import net.ibizsys.paas.core.DEDataQueryCode;
import net.ibizsys.paas.core.DEDataQueryCodeExp;
import net.ibizsys.paas.core.DEDataQueryCodes;
import net.ibizsys.paas.demodel.DEDataQueryModelBase;

@DEDataQuery(id="5B2E61C8-C11E-45AF-846C-BDEB44D05E54", name="DEFAULT", defaultmode=true)
@DEDataQueryCodes(value={@DEDataQueryCode(querycode="SELECT t1.`CREATEDATE`, t1.`CREATEMAN`, t1.`POLICYTAG`, t1.`POLICYTAG2`, t1.`POLICYTAG3`, t1.`POLICYTAG4`, t1.`POLICYTYPE`, t1.`PSDCWORKSPACEID`, t1.`PSWORKSPACEID`, t1.`PSWORKSPACENAME`, t1.`PSWORKSPACEPOLICYID`, t1.`PSWORKSPACEPOLICYNAME`, t1.`UPDATEDATE`, t1.`UPDATEMAN`, t1.`VALUE`, t1.`VALUE2`, t1.`VALUE3`, t1.`VALUE4` FROM `T_SRFPSWORKSPACEPOLICY` t1  ", querycodetemp="", declarecode="", dbtype="MYSQL5", fieldexps={@DEDataQueryCodeExp(name="CREATEDATE", expression="t1.`CREATEDATE`", showorder=0), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.`CREATEMAN`", showorder=1), @DEDataQueryCodeExp(name="POLICYTAG", expression="t1.`POLICYTAG`", showorder=2), @DEDataQueryCodeExp(name="POLICYTAG2", expression="t1.`POLICYTAG2`", showorder=3), @DEDataQueryCodeExp(name="POLICYTAG3", expression="t1.`POLICYTAG3`", showorder=4), @DEDataQueryCodeExp(name="POLICYTAG4", expression="t1.`POLICYTAG4`", showorder=5), @DEDataQueryCodeExp(name="POLICYTYPE", expression="t1.`POLICYTYPE`", showorder=6), @DEDataQueryCodeExp(name="PSDCWORKSPACEID", expression="t1.`PSDCWORKSPACEID`", showorder=7), @DEDataQueryCodeExp(name="PSWORKSPACEID", expression="t1.`PSWORKSPACEID`", showorder=8), @DEDataQueryCodeExp(name="PSWORKSPACENAME", expression="t1.`PSWORKSPACENAME`", showorder=9), @DEDataQueryCodeExp(name="PSWORKSPACEPOLICYID", expression="t1.`PSWORKSPACEPOLICYID`", showorder=10), @DEDataQueryCodeExp(name="PSWORKSPACEPOLICYNAME", expression="t1.`PSWORKSPACEPOLICYNAME`", showorder=11), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.`UPDATEDATE`", showorder=12), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.`UPDATEMAN`", showorder=13), @DEDataQueryCodeExp(name="VALUE", expression="t1.`VALUE`", showorder=14), @DEDataQueryCodeExp(name="VALUE2", expression="t1.`VALUE2`", showorder=15), @DEDataQueryCodeExp(name="VALUE3", expression="t1.`VALUE3`", showorder=16), @DEDataQueryCodeExp(name="VALUE4", expression="t1.`VALUE4`", showorder=17)}, conds={}), @DEDataQueryCode(querycode="SELECT t1.CREATEDATE, t1.CREATEMAN, t1.POLICYTAG, t1.POLICYTAG2, t1.POLICYTAG3, t1.POLICYTAG4, t1.POLICYTYPE, t1.PSDCWORKSPACEID, t1.PSWORKSPACEID, t1.PSWORKSPACENAME, t1.PSWORKSPACEPOLICYID, t1.PSWORKSPACEPOLICYNAME, t1.UPDATEDATE, t1.UPDATEMAN, t1.VALUE, t1.VALUE2, t1.VALUE3, t1.VALUE4 FROM T_SRFPSWORKSPACEPOLICY t1  ", querycodetemp="", declarecode="", dbtype="ORACLE", fieldexps={@DEDataQueryCodeExp(name="CREATEDATE", expression="t1.CREATEDATE", showorder=0), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.CREATEMAN", showorder=1), @DEDataQueryCodeExp(name="POLICYTAG", expression="t1.POLICYTAG", showorder=2), @DEDataQueryCodeExp(name="POLICYTAG2", expression="t1.POLICYTAG2", showorder=3), @DEDataQueryCodeExp(name="POLICYTAG3", expression="t1.POLICYTAG3", showorder=4), @DEDataQueryCodeExp(name="POLICYTAG4", expression="t1.POLICYTAG4", showorder=5), @DEDataQueryCodeExp(name="POLICYTYPE", expression="t1.POLICYTYPE", showorder=6), @DEDataQueryCodeExp(name="PSDCWORKSPACEID", expression="t1.PSDCWORKSPACEID", showorder=7), @DEDataQueryCodeExp(name="PSWORKSPACEID", expression="t1.PSWORKSPACEID", showorder=8), @DEDataQueryCodeExp(name="PSWORKSPACENAME", expression="t1.PSWORKSPACENAME", showorder=9), @DEDataQueryCodeExp(name="PSWORKSPACEPOLICYID", expression="t1.PSWORKSPACEPOLICYID", showorder=10), @DEDataQueryCodeExp(name="PSWORKSPACEPOLICYNAME", expression="t1.PSWORKSPACEPOLICYNAME", showorder=11), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.UPDATEDATE", showorder=12), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.UPDATEMAN", showorder=13), @DEDataQueryCodeExp(name="VALUE", expression="t1.VALUE", showorder=14), @DEDataQueryCodeExp(name="VALUE2", expression="t1.VALUE2", showorder=15), @DEDataQueryCodeExp(name="VALUE3", expression="t1.VALUE3", showorder=16), @DEDataQueryCodeExp(name="VALUE4", expression="t1.VALUE4", showorder=17)}, conds={})})
public class PSWorkspacePolicyDefaultDQModel
extends DEDataQueryModelBase {
    public PSWorkspacePolicyDefaultDQModel() {
        this.initAnnotation(PSWorkspacePolicyDefaultDQModel.class);
    }
}

