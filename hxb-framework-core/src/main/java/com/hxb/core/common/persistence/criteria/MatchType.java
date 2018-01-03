/**
 *Copyright 2014-2017 蜂鸟钱包 All rights reserved.
 */
package com.hxb.core.common.persistence.criteria;

/**
 * SQL WHERE过滤条件
 * @author MARK
 * @version 2017-06-30
 */
public enum MatchType {
	
	EQ(" = "), NE(" != "),LIKE(" LIKE "), LT(" < "), GT(" > "), LE(" <= "), GE(" >= "),IN(" IN "),BETWEEN(" BETWEEN ");
	
	private String value;
	
	MatchType(){		
	}
	
	MatchType(String value){
		this.value = value;
	}
	
	public String value(){
		return getValue();
	}

	public String getValue() {
		return this.value;
	}

	public void setValue(String value) {
		this.value = value;
	}
	
}
