/**
 *  iBizSys 5.0 机器人生产代码（不要直接修改当前代码）
 *  http://www.ibizsys.net
 */
package net.ibizsys.psrt.srv.common.demodel.org.dataset;


import net.ibizsys.paas.core.DEDataSet;
import net.ibizsys.paas.core.DEDataSetQuery;
import net.ibizsys.paas.sysmodel.CodeListGlobal;
import net.ibizsys.paas.codelist.ICodeList;
import net.ibizsys.paas.demodel.DEDataSetGroupParamModel;

@DEDataSet(id="F3D170A8-E879-44F2-832F-B7322AC7C421",name="CurCat",queries= {
    @DEDataSetQuery(queryid="55EDF036-7AC4-4A3C-99DF-7E33B2A7B0A9",queryname="CurCat")
})

/**
 *  实体数据集合[当前组织分类]模型基类
 */
public abstract class OrgCurCatDSModelBase extends net.ibizsys.paas.demodel.DEDataSetModelBase {
    public OrgCurCatDSModelBase() {
        super();

        this.initAnnotation(OrgCurCatDSModelBase.class);
    }




}