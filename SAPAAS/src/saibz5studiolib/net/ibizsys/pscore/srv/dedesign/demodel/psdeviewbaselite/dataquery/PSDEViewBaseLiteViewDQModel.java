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
package net.ibizsys.pscore.srv.dedesign.demodel.psdeviewbaselite.dataquery;

import net.ibizsys.paas.core.DEDataQuery;
import net.ibizsys.paas.core.DEDataQueryCode;
import net.ibizsys.paas.core.DEDataQueryCodeExp;
import net.ibizsys.paas.core.DEDataQueryCodes;
import net.ibizsys.paas.demodel.DEDataQueryModelBase;

@DEDataQuery(id="eb37dd4ab2061ea4f5aef8a2e2b63fe8", name="VIEW", viewlevel=0)
@DEDataQueryCodes(value={@DEDataQueryCode(querycode="SELECT t1.`CAPTION`, t1.`MEMO`, t1.`PDTPARAMPRE`, t1.`PDVTPARAM`, t1.`PREDEFINEVIEWTYPE`, t1.`PSDEID`, t1.`PSDEVIEWBASEID`, t1.`PSDEVIEWBASENAME`, t1.`PSDEVIEWBASETYPE`, t1.`PSSYSTEMID`, t1.`TITLE`, t1.`UPDATEDATE`, t1.`UPDATEMAN` FROM `T_SRFPSDEVIEWBASE` t1  ", querycodetemp="", declarecode="", dbtype="MYSQL5", fieldexps={@DEDataQueryCodeExp(name="CAPTION", expression="t1.`CAPTION`", showorder=0), @DEDataQueryCodeExp(name="MEMO", expression="t1.`MEMO`", showorder=1), @DEDataQueryCodeExp(name="PDTPARAMPRE", expression="t1.`PDTPARAMPRE`", showorder=2), @DEDataQueryCodeExp(name="PDVTPARAM", expression="t1.`PDVTPARAM`", showorder=3), @DEDataQueryCodeExp(name="PREDEFINEVIEWTYPE", expression="t1.`PREDEFINEVIEWTYPE`", showorder=4), @DEDataQueryCodeExp(name="PSDEID", expression="t1.`PSDEID`", showorder=5), @DEDataQueryCodeExp(name="PSDEVIEWBASEID", expression="t1.`PSDEVIEWBASEID`", showorder=6), @DEDataQueryCodeExp(name="PSDEVIEWBASENAME", expression="t1.`PSDEVIEWBASENAME`", showorder=7), @DEDataQueryCodeExp(name="PSDEVIEWBASETYPE", expression="t1.`PSDEVIEWBASETYPE`", showorder=8), @DEDataQueryCodeExp(name="PSSYSTEMID", expression="t1.`PSSYSTEMID`", showorder=9), @DEDataQueryCodeExp(name="TITLE", expression="t1.`TITLE`", showorder=10), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.`UPDATEDATE`", showorder=11), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.`UPDATEMAN`", showorder=12)}, conds={}), @DEDataQueryCode(querycode="SELECT t1.CAPTION, t1.MEMO, t1.PDTPARAMPRE, t1.PDVTPARAM, t1.PREDEFINEVIEWTYPE, t1.PSDEID, t1.PSDEVIEWBASEID, t1.PSDEVIEWBASENAME, t1.PSDEVIEWBASETYPE, t1.PSSYSTEMID, t1.TITLE, t1.UPDATEDATE, t1.UPDATEMAN FROM T_SRFPSDEVIEWBASE t1  ", querycodetemp="", declarecode="", dbtype="ORACLE", fieldexps={@DEDataQueryCodeExp(name="CAPTION", expression="t1.CAPTION", showorder=0), @DEDataQueryCodeExp(name="MEMO", expression="t1.MEMO", showorder=1), @DEDataQueryCodeExp(name="PDTPARAMPRE", expression="t1.PDTPARAMPRE", showorder=2), @DEDataQueryCodeExp(name="PDVTPARAM", expression="t1.PDVTPARAM", showorder=3), @DEDataQueryCodeExp(name="PREDEFINEVIEWTYPE", expression="t1.PREDEFINEVIEWTYPE", showorder=4), @DEDataQueryCodeExp(name="PSDEID", expression="t1.PSDEID", showorder=5), @DEDataQueryCodeExp(name="PSDEVIEWBASEID", expression="t1.PSDEVIEWBASEID", showorder=6), @DEDataQueryCodeExp(name="PSDEVIEWBASENAME", expression="t1.PSDEVIEWBASENAME", showorder=7), @DEDataQueryCodeExp(name="PSDEVIEWBASETYPE", expression="t1.PSDEVIEWBASETYPE", showorder=8), @DEDataQueryCodeExp(name="PSSYSTEMID", expression="t1.PSSYSTEMID", showorder=9), @DEDataQueryCodeExp(name="TITLE", expression="t1.TITLE", showorder=10), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.UPDATEDATE", showorder=11), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.UPDATEMAN", showorder=12)}, conds={})})
public class PSDEViewBaseLiteViewDQModel
extends DEDataQueryModelBase {
    public PSDEViewBaseLiteViewDQModel() {
        this.initAnnotation(PSDEViewBaseLiteViewDQModel.class);
    }
}

