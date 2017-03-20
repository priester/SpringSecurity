package com.root.resc.model;

import java.util.HashSet;
import java.util.Set;

import com.root.role.model.Role;

public class Resources {

	private Integer rescId;
	private String rescName;
	//private Integer parentId; //父类Id
	private String parentName;
	private String rescKey;//这个权限KEY是唯一的，新增时要注意，
	private String resUrl;//URL地址．例如：/videoType/query　　不需要项目名和http://xxx:8080
	//private Integer level;
	private String type;//权限类型，0．表示目录　1，表示菜单．2，表示按扭．．在spring security3安全权限中，涉及精确到按扭控制
	private String description;
	private Set<Role> roles = new HashSet<Role>(0);
	private Set<Resources> childs = new HashSet<Resources>(0);
	
	public Resources() {
		
	}

	public Resources(Integer rescId, String rescName, String parentName,
			String rescKey, String resUrl, String type, String description,
			Set<Role> roles, Set<Resources> childs) {
		super();
		this.rescId = rescId;
		this.rescName = rescName;
		this.parentName = parentName;
		this.rescKey = rescKey;
		this.resUrl = resUrl;
		this.type = type;
		this.description = description;
		this.roles = roles;
		this.childs = childs;
	}

	public Integer getRescId() {
		return rescId;
	}

	public void setRescId(Integer rescId) {
		this.rescId = rescId;
	}

	public String getRescName() {
		return rescName;
	}

	public void setRescName(String rescName) {
		this.rescName = rescName;
	}

	

	public String getParentName() {
		return parentName;
	}

	public void setParentName(String parentName) {
		this.parentName = parentName;
	}



	public String getRescKey() {
		return rescKey;
	}




	public void setRescKey(String rescKey) {
		this.rescKey = rescKey;
	}




	public String getResUrl() {
		return resUrl;
	}

	public void setResUrl(String resUrl) {
		this.resUrl = resUrl;
	}

	/*public Integer getLevel() {
		return level;
	}

	public void setLevel(Integer level) {
		this.level = level;
	}
*/
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}



	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

	public Set<Resources> getChilds() {
		return childs;
	}

	public void setChilds(Set<Resources> childs) {
		this.childs = childs;
	}
	
	
}
