import React, { useEffect, useState } from 'react';
import axios from 'axios';
import { Link } from 'react-router-dom';

function UpdateUser() {

   const [user,setUser] = useState([]);
   const [btn,setButton] = useState(0);
   const [formErrors, setFormErrors] = useState({});
   const [isSubmit, setIsSubmit] = useState(false);


   useEffect(() => {
      const URL='http://localhost:8080/users/updateUser';
      axios.put(URL,user).then((response) => 
      { setUser(response.data);
        window.alert("User Updated...");}
      )
      .catch(error => console.log(error.message))
  },[btn]);
  
  function handleBtnClick(e)
  {
      e.preventDefault();
      setFormErrors(validate(user));
      setIsSubmit(true);
      setButton(user.userid)

  }

  useEffect(() => {
    console.log(formErrors);
    if (Object.keys(formErrors).length === 0 && isSubmit) {
      console.log(user);
    }
  }, [formErrors]);

  const validate = (values) => {
    const errors = {};
    if (!values.userid) {
      errors.userid = "Username is required!";
    }
    if (!values.username) {
      errors.username = "User id is required!";
    }
    if (!values.userType) {
      errors.userType = "User type is required!";
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
        <nav className="navbar navbar-dark bg-dark justify-content-between fixed-top">
        <Link className="navbar-brand navbar-brand-margin">Admin Panel</Link>
        <span className="header-right">Flat Rental Application</span>
        <form className="form-inline">
       
          <button className="btn btn-outline-danger my-2 my-sm-0 logout-btn" type="submit"><a href="/login">Logout</a></button>
        </form>
      </nav>
        <form className="c2">
            <h1 className="form-text ">Update User</h1>
            <br/>  <br/>  
            <label>User I</label>
       <input name="userid" type="nummber" placeholder="User ID" className="username" 
       value={user.userid} onChange={e=>setUser({...user,userid:e.target.value})}
       />
       <p>{formErrors.userid}</p>
       <br/>
       <label>Username</label>
       <input name="username" type="text" placeholder="New Username*" className="username"
       value={user.userName} onChange={e=>setUser({...user,userName:e.target.value})}
       />
       <p>{formErrors.username}</p>
       <br/>
       <label>Password</label>
       <input name="password" type="password" placeholder="New Password*" className="username"
       value={user.password} onChange={e=>setUser({...user,password:e.target.value})}
       />
       <p>{formErrors.password}</p>
       <br/>
       <label>User Type</label>
        <select name="usertype" className="username"
        value={user.userType} onChange={e=>setUser({...user,userType:e.target.value})}
        >
          <option value="">New User Type</option>
          <option value="admin">Admin</option>
          <option value="landlord">Landlord</option>
          <option value="tenant">Tenant</option>
         </select>
         <p>{formErrors.userType}</p>
        <br/>  <br/>  <br/>
    <button className="btn" onClick={handleBtnClick}>Update User</button>
 </form>
    </React.Fragment>
    );
}

export default UpdateUser;