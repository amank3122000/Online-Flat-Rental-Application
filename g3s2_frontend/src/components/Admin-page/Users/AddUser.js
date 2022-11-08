import React, { useEffect, useState } from 'react';
import axios from 'axios';

function AddUser() {

  let initialuser={userName:'',password:'',userType:''};
  let [user,setUser]=useState(initialuser);
  let [msg,setMsg]=useState('');
  let [id,setId]=useState(0);
  const [formErrors, setFormErrors] = useState({});
  const [isSubmit, setIsSubmit] = useState(false);

  useEffect(() => {
      const URL='http://localhost:8080/onlineflatrental/users/addUser';
      axios.post(URL,user).then((response) => 
      {
          setMsg(response.data)
      }).catch(error => console.log(error.message))
  },[id])

  function handleBtnClick(e)
  {
      e.preventDefault();
      setFormErrors(validate(user));
      setIsSubmit(true);
      setId(1)
      setUser(initialuser)
      window.alert("User Added...");
  }

  useEffect(() => {
    console.log(formErrors);
    if (Object.keys(formErrors).length === 0 && isSubmit) {
      console.log(user);
    }
  }, [formErrors]);

  const validate = (values) => {
    const errors = {};
    if (!values.username) {
      errors.username = "Username is required!";
    }
    if (!values.userType) {
      errors.email = "User type is required!";
    } 
    if (!values.password) {
      errors.password = "Password is required";
    } else if (values.password.length < 4) {
      errors.password = "Password must be more than 4 characters";
    } else if (values.password.length > 10) {
      errors.password = "Password cannot exceed more than 10 characters";
    }
    return errors;
  };

  return (
      <React.Fragment>
        {Object.keys(formErrors).length === 0 && isSubmit ? (
        <div className="ui message success">User Added.</div>
      ) : (
        <pre>{JSON.stringify(user, undefined, 2)}</pre>
      )}
        <form className="c2" method="POST">
    <h1 className="form-text ">Add User</h1>
    <br/><br/><br/><br/>
       <input name="username" type="text" placeholder="Username*" className="username"
       value={user.userName} onChange={e=>setUser({...user,userName:e.target.value})}
       />
       <p>{formErrors.username}</p>
       <br/>
       <input name="password" type="password" placeholder="Password*" className="username"
       value={user.password} onChange={e=>setUser({...user,password:e.target.value})}
       />
       <p>{formErrors.password}</p>
       <br/>
       <select name="usertype" className="username" 
        value={user.userType} 
        onChange={e=>setUser({...user,userType:e.target.value})}
       >
         <option value="">Select one option</option>
         <option value="landlord">Landlord</option>
         <option value="tenant">Tenant</option>
         <option value="admin">Admin</option>

       </select>
       <p>{formErrors.userType}</p>
    <br/>
    <button className="btn" type="submit" onClick={handleBtnClick}>Add User</button>
        </form>
     </React.Fragment>
    );
}

export default AddUser;