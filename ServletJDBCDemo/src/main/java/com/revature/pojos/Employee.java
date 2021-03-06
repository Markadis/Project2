package com.revature.pojos;

import java.sql.Date;

public class Employee {

	public Employee(int id, String name, Date birthday, int monthlySalary, int departmentId, Date hireDate,
			String position, int managerId, int locationId) {
		super();
		this.id = id;
		this.name = name;
		this.birthday = birthday;
		this.monthlySalary = monthlySalary;
		this.departmentId = departmentId;
		this.hireDate = hireDate;
		this.position = position;
		this.managerId = managerId;
		this.locationId = locationId;
	}
	
	public Employee(String name, Date birthday, int monthlySalary, int departmentId, Date hireDate,
			String position, int managerId, int locationId) {
		super();
		this.name = name;
		this.birthday = birthday;
		this.monthlySalary = monthlySalary;
		this.departmentId = departmentId;
		this.hireDate = hireDate;
		this.position = position;
		this.managerId = managerId;
		this.locationId = locationId;
	}

	private int id;
	private String name;
	private Date birthday;
	private int monthlySalary;
//	private Department department; // not department id, this way includes all info in an object
	private int departmentId;
	private Date hireDate;
	private String position;
	private int managerId;
// 	private Location location; // not location id
	private int locationId;
	
	
	
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}



	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", birthday=" + birthday + ", monthlySalary=" + monthlySalary
				+ ", departmentId=" + departmentId + ", hireDate=" + hireDate + ", position=" + position
				+ ", managerId=" + managerId + ", locationId=" + locationId + "]";
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((birthday == null) ? 0 : birthday.hashCode());
		result = prime * result + departmentId;
		result = prime * result + ((hireDate == null) ? 0 : hireDate.hashCode());
		result = prime * result + id;
		result = prime * result + locationId;
		result = prime * result + managerId;
		result = prime * result + monthlySalary;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((position == null) ? 0 : position.hashCode());
		return result;
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		if (birthday == null) {
			if (other.birthday != null)
				return false;
		} else if (!birthday.equals(other.birthday))
			return false;
		if (departmentId != other.departmentId)
			return false;
		if (hireDate == null) {
			if (other.hireDate != null)
				return false;
		} else if (!hireDate.equals(other.hireDate))
			return false;
		if (id != other.id)
			return false;
		if (locationId != other.locationId)
			return false;
		if (managerId != other.managerId)
			return false;
		if (monthlySalary != other.monthlySalary)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (position == null) {
			if (other.position != null)
				return false;
		} else if (!position.equals(other.position))
			return false;
		return true;
	}



	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public Date getBirthday() {
		return birthday;
	}



	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}



	public int getMonthlySalary() {
		return monthlySalary;
	}



	public void setMonthlySalary(int monthlySalary) {
		this.monthlySalary = monthlySalary;
	}



	public int getDepartmentId() {
		return departmentId;
	}



	public void setDepartmentId(int departmentId) {
		this.departmentId = departmentId;
	}



	public Date getHireDate() {
		return hireDate;
	}



	public void setHireDate(Date hireDate) {
		this.hireDate = hireDate;
	}



	public String getPosition() {
		return position;
	}



	public void setPosition(String position) {
		this.position = position;
	}



	public int getManagerId() {
		return managerId;
	}



	public void setManagerId(int managerId) {
		this.managerId = managerId;
	}



	public int getLocationId() {
		return locationId;
	}



	public void setLocationId(int locationId) {
		this.locationId = locationId;
	}

	

	
	
}
