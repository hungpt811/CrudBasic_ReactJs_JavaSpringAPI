import React from 'react'
import Todo from './Todo'


export default function TodoList({ employeeList, onDeleteEmployee }) {
  return (
    <>
      {employeeList.map((employee) => 
        <Todo key={employee.id} employee={employee} onDeleteEmployee={onDeleteEmployee} />
      )}  
    </>
  )
}
