package com.personal.model;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

public class EmpMessage {
	private int empId;
	@NotEmpty(message="员工姓名为必填项")
	private String name;
	@Size(min=18,max=18,message="请输入正确的省份证号" )
	private String idCard;
	@Size(min=1,max=2,message="请输入1到100")
	private String age;
	private String sex;
	private String addr;
	//专业
	private String specialty;
	private String job;
	//学历
	private String studyeffort;
	private String school;
	@Size(min=11,max=11,message="请输入正确的手机号码")
	private String tel;
	@Email(message= "请输入正确的邮箱")
	private String email;
	private String qq;
	//备注
	private String note;
	
	
	public EmpMessage() {
		
	}

	public EmpMessage(int empId, String name, String idCard, String age,
			String sex, String addr, String specialty, String job,
			String studyeffort, String school, String tel, String email,
			String qq, String note) {
		super();
		this.empId = empId;
		this.name = name;
		this.idCard = idCard;
		this.age = age;
		this.sex = sex;
		this.addr = addr;
		this.specialty = specialty;
		this.job = job;
		this.studyeffort = studyeffort;
		this.school = school;
		this.tel = tel;
		this.email = email;
		this.qq = qq;
		this.note = note;
	}

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getIdCard() {
		return idCard;
	}

	public void setIdCard(String idCard) {
		this.idCard = idCard;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	public String getSpecialty() {
		return specialty;
	}

	public void setSpecialty(String specialty) {
		this.specialty = specialty;
	}

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	public String getStudyeffort() {
		return studyeffort;
	}

	public void setStudyeffort(String studyeffort) {
		this.studyeffort = studyeffort;
	}

	public String getSchool() {
		return school;
	}

	public void setSchool(String school) {
		this.school = school;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getQq() {
		return qq;
	}

	public void setQq(String qq) {
		this.qq = qq;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}
}