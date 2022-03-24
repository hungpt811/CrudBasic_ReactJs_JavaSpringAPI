package com.hungpt.crudbasic.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hungpt.crudbasic.Model.Employee;
import com.hungpt.crudbasic.Repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements IEmployee {
	@Autowired 
	private EmployeeRepository employeeRepository;
	

	@Override
	public Employee addEmployee(Employee e) {
		if(e != null) {
			return employeeRepository.save(e);
		}
		return null;
	}

	@Override
	public Employee updateEmployee(Integer id, Employee e) {
		if(e != null) {
			Employee e1 = employeeRepository.getOne(id);
			if(e1 != null) {
				e1.setName(e.getName());
				e1.setAddress(e.getAddress());
				
				return employeeRepository.save(e1);
			}			
		}
		return null;
	}

	@Override
	public boolean deleteEmployee(Integer id) {
		if(id >= 1) {
			Employee e = employeeRepository.getOne(id);
			if(e != null) {
				employeeRepository.delete(e);
				return true;
			}
		}	
		return false;
	}

	@Override
	public List<Employee> getAllEmployee() {
		return employeeRepository.findAll();
	}

	@Override
	public Employee getOneEmployee(Integer id) {
		return employeeRepository.getOne(id);
	}

}
