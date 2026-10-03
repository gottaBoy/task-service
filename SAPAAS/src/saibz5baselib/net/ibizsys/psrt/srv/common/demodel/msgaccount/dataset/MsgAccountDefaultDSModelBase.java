/**
 *  iBizSys 5.0 机器人生产代码（不要直接修改当前代码）
 *  http://www.ibizsys.net
 */
package net.ibizsys.psrt.srv.common.demodel.msgaccount.dataset;


import net.ibizsys.paas.core.DEDataSet;
import net.ibizsys.paas.core.DEDataSetQuery;
import net.ibizsys.paas.sysmodel.CodeListGlobal;
import net.ibizsys.paas.codelist.ICodeList;
import net.ibizsys.paas.demodel.DEDataSetGroupParamModel;

@DEDataSet(id="7ce656616f83e08ed4aeba648bb0a30b",name="DEFAULT",queries= {
    @DEDataSetQuery(queryid="B62E6807-6EBA-4D27-A5CB-ACA8E4987130",queryname="DEFAULT")
})

/**
 *  实体数据集合[DEFAULT]模型基类
 */
public abstract class MsgAccountDefaultDSModelBase extends net.ibizsys.paas.demodel.DEDataSetModelBase {
    public MsgAccountDefaultDSModelBase() {
        super();

        this.initAnnotation(MsgAccountDefaultDSModelBase.class);
    }




}