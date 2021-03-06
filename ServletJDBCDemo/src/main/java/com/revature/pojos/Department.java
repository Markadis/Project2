package com.revature.pojos;

public class Department {

	public Department(int id, String name, int monthlyBudget) {
		super();
		this.id = id;
		this.name = name;
		this.monthlyBudget = monthlyBudget;
	}
	public Department() {
		super();
		// TODO Auto-generated constructor stub
	}
	private int id;
	private String name;
	private int monthlyBudget;
	@Override
	public String toString() {
		return "Department [id=" + id + ", name=" + name + ", monthlyBudget=" + monthlyBudget + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + monthlyBudget;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
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
		Department other = (Department) obj;
		if (id != other.id)
			return false;
		if (monthlyBudget != other.monthlyBudget)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
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
	public int getMonthlyBudget() {
		return monthlyBudget;
	}
	public void setMonthlyBudget(int monthlyBudget) {
		this.monthlyBudget = monthlyBudget;
	}
	
	
}
