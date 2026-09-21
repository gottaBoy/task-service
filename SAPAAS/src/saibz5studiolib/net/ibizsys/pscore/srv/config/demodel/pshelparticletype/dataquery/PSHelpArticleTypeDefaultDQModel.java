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
package net.ibizsys.pscore.srv.config.demodel.pshelparticletype.dataquery;

import net.ibizsys.paas.core.DEDataQuery;
import net.ibizsys.paas.core.DEDataQueryCode;
import net.ibizsys.paas.core.DEDataQueryCodeExp;
import net.ibizsys.paas.core.DEDataQueryCodes;
import net.ibizsys.paas.demodel.DEDataQueryModelBase;

@DEDataQuery(id="B446BECB-3E54-4A60-978E-00F37BCD1B2B", name="DEFAULT", defaultmode=true)
@DEDataQueryCodes(value={@DEDataQueryCode(querycode="SELECT t1.`ARTICLEOBJ`, t1.`CREATEDATE`, t1.`CREATEMAN`, t1.`MEMO`, t1.`PSHELPARTICLETEMPLID`, t11.`PSHELPARTICLETEMPLNAME`, t1.`PSHELPARTICLETYPEID`, t1.`PSHELPARTICLETYPENAME`, t1.`PUBOBJ`, t1.`TYPEOBJ`, t1.`UPDATEDATE`, t1.`UPDATEMAN`, t1.`VALIDFLAG` FROM `T_SRFPSHELPARTICLETYPE` t1  LEFT JOIN T_SRFPSHELPARTICLETEMPL t11 ON t1.PSHELPARTICLETEMPLID = t11.PSHELPARTICLETEMPLID  ", querycodetemp="", declarecode="", dbtype="MYSQL5", fieldexps={@DEDataQueryCodeExp(name="ARTICLEOBJ", expression="t1.`ARTICLEOBJ`", showorder=0), @DEDataQueryCodeExp(name="CREATEDATE", expression="t1.`CREATEDATE`", showorder=1), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.`CREATEMAN`", showorder=2), @DEDataQueryCodeExp(name="MEMO", expression="t1.`MEMO`", showorder=3), @DEDataQueryCodeExp(name="PSHELPARTICLETEMPLID", expression="t1.`PSHELPARTICLETEMPLID`", showorder=4), @DEDataQueryCodeExp(name="PSHELPARTICLETEMPLNAME", expression="t11.`PSHELPARTICLETEMPLNAME`", showorder=5), @DEDataQueryCodeExp(name="PSHELPARTICLETYPEID", expression="t1.`PSHELPARTICLETYPEID`", showorder=6), @DEDataQueryCodeExp(name="PSHELPARTICLETYPENAME", expression="t1.`PSHELPARTICLETYPENAME`", showorder=7), @DEDataQueryCodeExp(name="PUBOBJ", expression="t1.`PUBOBJ`", showorder=8), @DEDataQueryCodeExp(name="TYPEOBJ", expression="t1.`TYPEOBJ`", showorder=9), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.`UPDATEDATE`", showorder=10), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.`UPDATEMAN`", showorder=11), @DEDataQueryCodeExp(name="VALIDFLAG", expression="t1.`VALIDFLAG`", showorder=12)}, conds={}), @DEDataQueryCode(querycode="SELECT t1.ARTICLEOBJ, t1.CREATEDATE, t1.CREATEMAN, t1.MEMO, t1.PSHELPARTICLETEMPLID, t11.PSHELPARTICLETEMPLNAME, t1.PSHELPARTICLETYPEID, t1.PSHELPARTICLETYPENAME, t1.PUBOBJ, t1.TYPEOBJ, t1.UPDATEDATE, t1.UPDATEMAN, t1.VALIDFLAG FROM T_SRFPSHELPARTICLETYPE t1  LEFT JOIN T_SRFPSHELPARTICLETEMPL t11 ON t1.PSHELPARTICLETEMPLID = t11.PSHELPARTICLETEMPLID  ", querycodetemp="", declarecode="", dbtype="ORACLE", fieldexps={@DEDataQueryCodeExp(name="ARTICLEOBJ", expression="t1.ARTICLEOBJ", showorder=0), @DEDataQueryCodeExp(name="CREATEDATE", expression="t1.CREATEDATE", showorder=1), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.CREATEMAN", showorder=2), @DEDataQueryCodeExp(name="MEMO", expression="t1.MEMO", showorder=3), @DEDataQueryCodeExp(name="PSHELPARTICLETEMPLID", expression="t1.PSHELPARTICLETEMPLID", showorder=4), @DEDataQueryCodeExp(name="PSHELPARTICLETEMPLNAME", expression="t11.PSHELPARTICLETEMPLNAME", showorder=5), @DEDataQueryCodeExp(name="PSHELPARTICLETYPEID", expression="t1.PSHELPARTICLETYPEID", showorder=6), @DEDataQueryCodeExp(name="PSHELPARTICLETYPENAME", expression="t1.PSHELPARTICLETYPENAME", showorder=7), @DEDataQueryCodeExp(name="PUBOBJ", expression="t1.PUBOBJ", showorder=8), @DEDataQueryCodeExp(name="TYPEOBJ", expression="t1.TYPEOBJ", showorder=9), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.UPDATEDATE", showorder=10), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.UPDATEMAN", showorder=11), @DEDataQueryCodeExp(name="VALIDFLAG", expression="t1.VALIDFLAG", showorder=12)}, conds={})})
public class PSHelpArticleTypeDefaultDQModel
extends DEDataQueryModelBase {
    public PSHelpArticleTypeDefaultDQModel() {
        this.initAnnotation(PSHelpArticleTypeDefaultDQModel.class);
    }
}

