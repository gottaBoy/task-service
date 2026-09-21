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
package net.ibizsys.pscore.srv.dedesign.demodel.psdespfield.dataquery;

import net.ibizsys.paas.core.DEDataQuery;
import net.ibizsys.paas.core.DEDataQueryCode;
import net.ibizsys.paas.core.DEDataQueryCodeExp;
import net.ibizsys.paas.core.DEDataQueryCodes;
import net.ibizsys.paas.demodel.DEDataQueryModelBase;

@DEDataQuery(id="3BA6C071-6E4B-4CB1-9B7B-B51AB3AB2939", name="DEFAULT", defaultmode=true)
@DEDataQueryCodes(value={@DEDataQueryCode(querycode="SELECT t1.`CREATEDATE`, t1.`CREATEMAN`, t1.`DECLAREPARAM`, t1.`MEMO`, t1.`ORDERVALUE`, t1.`PROCPARAM`, t1.`PSDEFID`, t1.`PSDEFNAME`, t1.`PSDESPFIELDID`, t1.`PSDESPFIELDNAME`, t1.`PSDESYSPROCID`, t1.`PSDESYSPROCNAME`, t1.`UPDATEDATE`, t1.`UPDATEMAN` FROM `T_SRFPSDESPFIELD` t1  ", querycodetemp="", declarecode="", dbtype="MYSQL5", fieldexps={@DEDataQueryCodeExp(name="CREATEDATE", expression="t1.`CREATEDATE`", showorder=0), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.`CREATEMAN`", showorder=1), @DEDataQueryCodeExp(name="DECLAREPARAM", expression="t1.`DECLAREPARAM`", showorder=2), @DEDataQueryCodeExp(name="MEMO", expression="t1.`MEMO`", showorder=3), @DEDataQueryCodeExp(name="ORDERVALUE", expression="t1.`ORDERVALUE`", showorder=4), @DEDataQueryCodeExp(name="PROCPARAM", expression="t1.`PROCPARAM`", showorder=5), @DEDataQueryCodeExp(name="PSDEFID", expression="t1.`PSDEFID`", showorder=6), @DEDataQueryCodeExp(name="PSDEFNAME", expression="t1.`PSDEFNAME`", showorder=7), @DEDataQueryCodeExp(name="PSDESPFIELDID", expression="t1.`PSDESPFIELDID`", showorder=8), @DEDataQueryCodeExp(name="PSDESPFIELDNAME", expression="t1.`PSDESPFIELDNAME`", showorder=9), @DEDataQueryCodeExp(name="PSDESYSPROCID", expression="t1.`PSDESYSPROCID`", showorder=10), @DEDataQueryCodeExp(name="PSDESYSPROCNAME", expression="t1.`PSDESYSPROCNAME`", showorder=11), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.`UPDATEDATE`", showorder=12), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.`UPDATEMAN`", showorder=13)}, conds={}), @DEDataQueryCode(querycode="SELECT t1.CREATEDATE, t1.CREATEMAN, t1.DECLAREPARAM, t1.MEMO, t1.ORDERVALUE, t1.PROCPARAM, t1.PSDEFID, t1.PSDEFNAME, t1.PSDESPFIELDID, t1.PSDESPFIELDNAME, t1.PSDESYSPROCID, t1.PSDESYSPROCNAME, t1.UPDATEDATE, t1.UPDATEMAN FROM T_SRFPSDESPFIELD t1  ", querycodetemp="", declarecode="", dbtype="ORACLE", fieldexps={@DEDataQueryCodeExp(name="CREATEDATE", expression="t1.CREATEDATE", showorder=0), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.CREATEMAN", showorder=1), @DEDataQueryCodeExp(name="DECLAREPARAM", expression="t1.DECLAREPARAM", showorder=2), @DEDataQueryCodeExp(name="MEMO", expression="t1.MEMO", showorder=3), @DEDataQueryCodeExp(name="ORDERVALUE", expression="t1.ORDERVALUE", showorder=4), @DEDataQueryCodeExp(name="PROCPARAM", expression="t1.PROCPARAM", showorder=5), @DEDataQueryCodeExp(name="PSDEFID", expression="t1.PSDEFID", showorder=6), @DEDataQueryCodeExp(name="PSDEFNAME", expression="t1.PSDEFNAME", showorder=7), @DEDataQueryCodeExp(name="PSDESPFIELDID", expression="t1.PSDESPFIELDID", showorder=8), @DEDataQueryCodeExp(name="PSDESPFIELDNAME", expression="t1.PSDESPFIELDNAME", showorder=9), @DEDataQueryCodeExp(name="PSDESYSPROCID", expression="t1.PSDESYSPROCID", showorder=10), @DEDataQueryCodeExp(name="PSDESYSPROCNAME", expression="t1.PSDESYSPROCNAME", showorder=11), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.UPDATEDATE", showorder=12), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.UPDATEMAN", showorder=13)}, conds={})})
public class PSDESPFieldDefaultDQModel
extends DEDataQueryModelBase {
    public PSDESPFieldDefaultDQModel() {
        this.initAnnotation(PSDESPFieldDefaultDQModel.class);
    }
}

