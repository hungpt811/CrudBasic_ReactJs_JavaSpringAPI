import {useState, useCallback, useRef, useEffect} from 'react';
import React from 'react';
import TodoList from './components/TodoList';
import TextField from '@atlaskit/textfield';
import Button from '@atlaskit/button';


function App() {
  const [employeeList, setEmployeeList] = useState([]);
  const [name, setName] = useState('');

  const inputRef = useRef();

  const textInputChange = useCallback((e) => {
    setName(e.target.value);
  });
  
  
  useEffect(() => {
        const requestUrl = 'http://localhost:8080/employee/list';
        fetch(requestUrl)
          .then(res => res.json())
          .then(employee => {
            setEmployeeList(employee);
          })
  }, [])

  const addEmployee = () => {   
    let data = {name}
    
    var postApi = "http://localhost:8080/employee/add";
    var options = {
      method: 'POST',
      headers:{
        "Content-Type": "application/json",
        "Access-Control-Allow-Origin": "*"
      },
      body: JSON.stringify(data)
    }
    fetch(postApi,options)
      .then(reponse => {
        reponse.json()
        .then(result => {
          setEmployeeList([
            ...employeeList,
            result
          ])
        })     
      })  
    setName("");
    inputRef.current.focus();
  }

  const onDeleteEmployee = (id) => {
 
    var deleteApi = "http://localhost:8080/employee/delete";
    var options = {
      method: 'DELETE',
      headers:{
        "Content-Type": "application/json",
      }
    }
    fetch(deleteApi+'/'+id,options)
      .then(reponse => {
        reponse.json()
        .then(result => {
          window.location.reload(!result)
        })     
      })  
       
  }
  return (
    <>
      <h3 style={{textAlign: "center", padding: "6px"}}>Danh sách nhân viên</h3>
      <TextField
        ref={inputRef}
        value={name}
        name="name"
        placeholder="Thêm nhân viên"
        elemAfterInput={
          <Button className="button"isDisabled={!name} appearance='primary' onClick={addEmployee}>
            Thêm
          </Button>
        }
        css={{padding: "2px 4px 2px"}}
        onChange={textInputChange}
      ></TextField>
      <TodoList employeeList={employeeList} onDeleteEmployee={onDeleteEmployee} />
    </>
  );
}

export default App;
