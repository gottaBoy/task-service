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
package net.ibizsys.pscore.srv.sysdesign.demodel.psmodelseq.dataquery;

import net.ibizsys.paas.core.DEDataQuery;
import net.ibizsys.paas.core.DEDataQueryCode;
import net.ibizsys.paas.core.DEDataQueryCodeExp;
import net.ibizsys.paas.core.DEDataQueryCodes;
import net.ibizsys.paas.demodel.DEDataQueryModelBase;

@DEDataQuery(id="D73325EC-9FB9-4253-A8C2-6DFF186ECF29", name="DEFAULT", defaultmode=true)
@DEDataQueryCodes(value={@DEDataQueryCode(querycode="SELECT t1.`CREATEDATE`, t1.`CREATEMAN`, t1.`CURVAL`, t1.`PSMODELSEQID`, t1.`PSMODELSEQNAME`, t1.`SYSROWKEY`, t1.`UPDATEDATE`, t1.`UPDATEMAN`, t1.`USERTAG`, t1.`USERTAG2` FROM `T_SRFPSMODELSEQ` t1  ", querycodetemp="", declarecode="", dbtype="MYSQL5", fieldexps={@DEDataQueryCodeExp(name="CREATEDATE", expression="t1.`CREATEDATE`", showorder=0), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.`CREATEMAN`", showorder=1), @DEDataQueryCodeExp(name="CURVAL", expression="t1.`CURVAL`", showorder=2), @DEDataQueryCodeExp(name="PSMODELSEQID", expression="t1.`PSMODELSEQID`", showorder=3), @DEDataQueryCodeExp(name="PSMODELSEQNAME", expression="t1.`PSMODELSEQNAME`", showorder=4), @DEDataQueryCodeExp(name="SYSROWKEY", expression="t1.`SYSROWKEY`", showorder=5), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.`UPDATEDATE`", showorder=6), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.`UPDATEMAN`", showorder=7), @DEDataQueryCodeExp(name="USERTAG", expression="t1.`USERTAG`", showorder=8), @DEDataQueryCodeExp(name="USERTAG2", expression="t1.`USERTAG2`", showorder=9)}, conds={}), @DEDataQueryCode(querycode="SELECT t1.CREATEDATE, t1.CREATEMAN, t1.CURVAL, t1.PSMODELSEQID, t1.PSMODELSEQNAME, t1.SYSROWKEY, t1.UPDATEDATE, t1.UPDATEMAN, t1.USERTAG, t1.USERTAG2 FROM T_SRFPSMODELSEQ t1  ", querycodetemp="", declarecode="", dbtype="ORACLE", fieldexps={@DEDataQueryCodeExp(name="CREATEDATE", expression="t1.CREATEDATE", showorder=0), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.CREATEMAN", showorder=1), @DEDataQueryCodeExp(name="CURVAL", expression="t1.CURVAL", showorder=2), @DEDataQueryCodeExp(name="PSMODELSEQID", expression="t1.PSMODELSEQID", showorder=3), @DEDataQueryCodeExp(name="PSMODELSEQNAME", expression="t1.PSMODELSEQNAME", showorder=4), @DEDataQueryCodeExp(name="SYSROWKEY", expression="t1.SYSROWKEY", showorder=5), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.UPDATEDATE", showorder=6), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.UPDATEMAN", showorder=7), @DEDataQueryCodeExp(name="USERTAG", expression="t1.USERTAG", showorder=8), @DEDataQueryCodeExp(name="USERTAG2", expression="t1.USERTAG2", showorder=9)}, conds={})})
public class PSModelSeqDefaultDQModel
extends DEDataQueryModelBase {
    public PSModelSeqDefaultDQModel() {
        this.initAnnotation(PSModelSeqDefaultDQModel.class);
    }
}

