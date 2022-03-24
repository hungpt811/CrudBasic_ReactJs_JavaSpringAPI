package com.hungpt.crudbasic.Service;

import java.util.List;

import com.hungpt.crudbasic.Model.Employee;

public interface IEmployee {
//	Ham them nhan vien
	public Employee addEmployee(Employee e);
	
//	Ham chinh sua thong tin nv
	public Employee updateEmployee(Integer id, Employee e);
	
//	Ham xoa nhan vien
	public boolean deleteEmployee(Integer id);
	
//	Ham lay ra toan bo nhan vien
	public List<Employee> getAllEmployee();
	
//	Ham lay ra 1 nhan vien
	public Employee getOneEmployee(Integer id);
}
