/**
 *Copyright 2014-2017 蜂鸟钱包 All rights reserved.
 */
package com.hxb.core.common.persistence.criteria;
/**
 * SQL WHERE过滤条件(单个)，与逻辑关系(and,or,not)配对
 * @author MARK
 * @version 2017-06-30
 */
public class CriterionPair {
	
	/**
	 * 逻辑关系
	 */
	private LogicType logicType;
	/**
	 * 过滤条件
	 */
	private Criterion criterion;
	
	/**
	 * 逻辑关系-对应LogicType的取值
	 */
	private String logic;
	
	public CriterionPair(){
	}
	
	public CriterionPair(LogicType logicType,Criterion criterion){
		this.logicType = logicType;
		this.logic = logicType.getValue();
		this.criterion = criterion;
	}

	public LogicType getLogicType() {
		return logicType;
	}

	public void setLogicType(LogicType logicType) {
		this.logicType = logicType;
	}

	public Criterion getcriterion() {
		return criterion;
	}

	public void setcriterion(Criterion criterion) {
		this.criterion = criterion;
	}

	public String getLogic() {
		return logic;
	}

	public void setLogic(String logic) {
		this.logic = logic;
	}
	
}
