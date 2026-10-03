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

@DEDataSet(id="3FC6CC32-B1F2-4BA2-B9C6-FC524C68FB4A",name="CurChild",queries= {
    @DEDataSetQuery(queryid="32FD68B7-A570-4C25-B60D-4A7A8BFC8177",queryname="CurChild")
})

/**
 *  实体数据集合[当前子组织]模型基类
 */
public abstract class OrgCurChildDSModelBase extends net.ibizsys.paas.demodel.DEDataSetModelBase {
    public OrgCurChildDSModelBase() {
        super();

        this.initAnnotation(OrgCurChildDSModelBase.class);
    }




}