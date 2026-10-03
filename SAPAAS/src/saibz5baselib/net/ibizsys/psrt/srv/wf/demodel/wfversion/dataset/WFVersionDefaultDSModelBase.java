/**
 *  iBizSys 5.0 机器人生产代码（不要直接修改当前代码）
 *  http://www.ibizsys.net
 */
package net.ibizsys.psrt.srv.wf.demodel.wfversion.dataset;


import net.ibizsys.paas.core.DEDataSet;
import net.ibizsys.paas.core.DEDataSetQuery;
import net.ibizsys.paas.sysmodel.CodeListGlobal;
import net.ibizsys.paas.codelist.ICodeList;
import net.ibizsys.paas.demodel.DEDataSetGroupParamModel;

@DEDataSet(id="f0abca40127ddf436270635ba0e3c135",name="DEFAULT",queries= {
    @DEDataSetQuery(queryid="FBE320B4-2982-47F7-BB0D-EC7F21E4EF12",queryname="DEFAULT")
})

/**
 *  实体数据集合[DEFAULT]模型基类
 */
public abstract class WFVersionDefaultDSModelBase extends net.ibizsys.paas.demodel.DEDataSetModelBase {
    public WFVersionDefaultDSModelBase() {
        super();

        this.initAnnotation(WFVersionDefaultDSModelBase.class);
    }




}