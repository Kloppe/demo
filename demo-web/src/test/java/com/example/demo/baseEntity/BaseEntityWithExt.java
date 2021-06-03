package com.example.demo.baseEntity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;

/**
 * @author xuww
 * @datetime 2021/4/22 12:31 下午
 */
public class BaseEntityWithExt extends BaseEntity{

	@TableField(
			fill = FieldFill.INSERT
	)
	private String creator;

	@TableField(
			fill = FieldFill.INSERT_UPDATE
	)
	private String modifier;

	@TableField("is_deleted")
	private Integer isDeleted;

	public void initBaseField() {
		super.initBaseField();
		this.creator = "system";
		this.modifier = "system";
		this.isDeleted = 0;
	}

	public BaseEntityWithExt() {
	}

	public String getCreator() {
		return creator;
	}

	public void setCreator(String creator) {
		this.creator = creator;
	}

	public String getModifier() {
		return modifier;
	}

	public void setModifier(String modifier) {
		this.modifier = modifier;
	}

	public Integer getIsDeleted() {
		return isDeleted;
	}

	public void setIsDeleted(Integer isDeleted) {
		this.isDeleted = isDeleted;
	}
}
