/**
 *  iBizSys 5.0 机器人生产代码（不要直接修改当前代码）
 *  http://www.ibizsys.net
 */
package net.ibizsys.psrt.srv.wx.demodel.wxmessage.dataset;


import net.ibizsys.paas.core.DEDataSet;
import net.ibizsys.paas.core.DEDataSetQuery;
import net.ibizsys.paas.sysmodel.CodeListGlobal;
import net.ibizsys.paas.codelist.ICodeList;
import net.ibizsys.paas.demodel.DEDataSetGroupParamModel;

@DEDataSet(id="657d40a805a0f204934829160a198bb7",name="DEFAULT",queries= {
    @DEDataSetQuery(queryid="1805ABF4-2C99-4835-887B-A19B34376483",queryname="DEFAULT")
})

/**
 *  实体数据集合[DEFAULT]模型基类
 */
public abstract class WXMessageDefaultDSModelBase extends net.ibizsys.paas.demodel.DEDataSetModelBase {
    public WXMessageDefaultDSModelBase() {
        super();

        this.initAnnotation(WXMessageDefaultDSModelBase.class);
    }




}