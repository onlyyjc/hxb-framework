/**
 *Copyright 2014-2017 蜂鸟钱包 All rights reserved.
 */
package com.hxb.core.common.service;

import com.hxb.core.common.persistence.BaseDao;
import com.hxb.core.common.persistence.BaseEntity;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;

/**
 * Service基类
 * @author Mark
 * @version 2017-05-16
 */
public class CrudService<D extends BaseDao<T,PK>,T extends BaseEntity<T>, PK extends Serializable>  extends BaseService {
	
	/**
	 * 持久层对象
	 */
	@Autowired
	protected D dao;
	


}
