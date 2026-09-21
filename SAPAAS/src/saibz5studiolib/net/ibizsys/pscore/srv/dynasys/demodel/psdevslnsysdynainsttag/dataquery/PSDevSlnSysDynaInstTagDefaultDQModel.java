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
package net.ibizsys.pscore.srv.dynasys.demodel.psdevslnsysdynainsttag.dataquery;

import net.ibizsys.paas.core.DEDataQuery;
import net.ibizsys.paas.core.DEDataQueryCode;
import net.ibizsys.paas.core.DEDataQueryCodeExp;
import net.ibizsys.paas.core.DEDataQueryCodes;
import net.ibizsys.paas.demodel.DEDataQueryModelBase;

@DEDataQuery(id="A5638572-3FCC-4CBD-B2F5-0FEE72B30527", name="DEFAULT", defaultmode=true)
@DEDataQueryCodes(value={@DEDataQueryCode(querycode="SELECT t1.`CREATEDATE`, t1.`CREATEMAN`, t1.`MEMO`, t1.`PSDEVSLNSYSDYNAINSTID`, t1.`PSDEVSLNSYSDYNAINSTNAME`, t1.`PSDEVSLNSYSDYNAINSTTAGID`, t1.`PSDEVSLNSYSDYNAINSTTAGNAME`, t1.`TAGTAG`, t1.`TAGTAG2`, t1.`TAGTAG3`, t1.`TAGTAG4`, t1.`TAGTAG5`, t1.`TAGTAG6`, t1.`TAGTAG7`, t1.`TAGTAG8`, t1.`UPDATEDATE`, t1.`UPDATEMAN` FROM `T_SRFPSDEVSLNSYSDYNAINSTTAG` t1  ", querycodetemp="", declarecode="", dbtype="MYSQL5", fieldexps={@DEDataQueryCodeExp(name="CREATEDATE", expression="t1.`CREATEDATE`", showorder=0), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.`CREATEMAN`", showorder=1), @DEDataQueryCodeExp(name="MEMO", expression="t1.`MEMO`", showorder=2), @DEDataQueryCodeExp(name="PSDEVSLNSYSDYNAINSTID", expression="t1.`PSDEVSLNSYSDYNAINSTID`", showorder=3), @DEDataQueryCodeExp(name="PSDEVSLNSYSDYNAINSTNAME", expression="t1.`PSDEVSLNSYSDYNAINSTNAME`", showorder=4), @DEDataQueryCodeExp(name="PSDEVSLNSYSDYNAINSTTAGID", expression="t1.`PSDEVSLNSYSDYNAINSTTAGID`", showorder=5), @DEDataQueryCodeExp(name="PSDEVSLNSYSDYNAINSTTAGNAME", expression="t1.`PSDEVSLNSYSDYNAINSTTAGNAME`", showorder=6), @DEDataQueryCodeExp(name="TAGTAG", expression="t1.`TAGTAG`", showorder=7), @DEDataQueryCodeExp(name="TAGTAG2", expression="t1.`TAGTAG2`", showorder=8), @DEDataQueryCodeExp(name="TAGTAG3", expression="t1.`TAGTAG3`", showorder=9), @DEDataQueryCodeExp(name="TAGTAG4", expression="t1.`TAGTAG4`", showorder=10), @DEDataQueryCodeExp(name="TAGTAG5", expression="t1.`TAGTAG5`", showorder=11), @DEDataQueryCodeExp(name="TAGTAG6", expression="t1.`TAGTAG6`", showorder=12), @DEDataQueryCodeExp(name="TAGTAG7", expression="t1.`TAGTAG7`", showorder=13), @DEDataQueryCodeExp(name="TAGTAG8", expression="t1.`TAGTAG8`", showorder=14), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.`UPDATEDATE`", showorder=15), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.`UPDATEMAN`", showorder=16)}, conds={}), @DEDataQueryCode(querycode="SELECT t1.CREATEDATE, t1.CREATEMAN, t1.MEMO, t1.PSDEVSLNSYSDYNAINSTID, t1.PSDEVSLNSYSDYNAINSTNAME, t1.PSDEVSLNSYSDYNAINSTTAGID, t1.PSDEVSLNSYSDYNAINSTTAGNAME, t1.TAGTAG, t1.TAGTAG2, t1.TAGTAG3, t1.TAGTAG4, t1.TAGTAG5, t1.TAGTAG6, t1.TAGTAG7, t1.TAGTAG8, t1.UPDATEDATE, t1.UPDATEMAN FROM T_SRFPSDEVSLNSYSDYNAINSTTAG t1  ", querycodetemp="", declarecode="", dbtype="ORACLE", fieldexps={@DEDataQueryCodeExp(name="CREATEDATE", expression="t1.CREATEDATE", showorder=0), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.CREATEMAN", showorder=1), @DEDataQueryCodeExp(name="MEMO", expression="t1.MEMO", showorder=2), @DEDataQueryCodeExp(name="PSDEVSLNSYSDYNAINSTID", expression="t1.PSDEVSLNSYSDYNAINSTID", showorder=3), @DEDataQueryCodeExp(name="PSDEVSLNSYSDYNAINSTNAME", expression="t1.PSDEVSLNSYSDYNAINSTNAME", showorder=4), @DEDataQueryCodeExp(name="PSDEVSLNSYSDYNAINSTTAGID", expression="t1.PSDEVSLNSYSDYNAINSTTAGID", showorder=5), @DEDataQueryCodeExp(name="PSDEVSLNSYSDYNAINSTTAGNAME", expression="t1.PSDEVSLNSYSDYNAINSTTAGNAME", showorder=6), @DEDataQueryCodeExp(name="TAGTAG", expression="t1.TAGTAG", showorder=7), @DEDataQueryCodeExp(name="TAGTAG2", expression="t1.TAGTAG2", showorder=8), @DEDataQueryCodeExp(name="TAGTAG3", expression="t1.TAGTAG3", showorder=9), @DEDataQueryCodeExp(name="TAGTAG4", expression="t1.TAGTAG4", showorder=10), @DEDataQueryCodeExp(name="TAGTAG5", expression="t1.TAGTAG5", showorder=11), @DEDataQueryCodeExp(name="TAGTAG6", expression="t1.TAGTAG6", showorder=12), @DEDataQueryCodeExp(name="TAGTAG7", expression="t1.TAGTAG7", showorder=13), @DEDataQueryCodeExp(name="TAGTAG8", expression="t1.TAGTAG8", showorder=14), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.UPDATEDATE", showorder=15), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.UPDATEMAN", showorder=16)}, conds={})})
public class PSDevSlnSysDynaInstTagDefaultDQModel
extends DEDataQueryModelBase {
    public PSDevSlnSysDynaInstTagDefaultDQModel() {
        this.initAnnotation(PSDevSlnSysDynaInstTagDefaultDQModel.class);
    }
}

