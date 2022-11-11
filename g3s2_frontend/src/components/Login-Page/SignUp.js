import axios from 'axios';
import React from 'react';
import { useState, useEffect } from "react";
import {useSelector,useDispatch} from "react-redux";



function SignUp() {
   const history=useNavigate();
  const initialValues={username:"",password:"",usertype:""};
  const [formValues, setFormValues] = useState(initialValues);
  const [formErrors, setFormErrors] = useState({});
  const [isSubmit, setIsSubmit] = useState(false);
  const dispatch=useDispatch();
  const isRegistered=useSelector((state)=>state.register);


  const handleChange = (e) => {
    const { name, value } = e.target;
    setFormValues({ ...formValues, [name]: value });
  };
  //const dis1=()=>{dispatch(register())};
  const fetchProducts = async () =>{
    await axios.post('http://localhost:8080/users/addUsers', JSON.stringify(formValues),{headers:{"Content-Type" : "application/json"}}).then((data)=>console.log(data.data)).catch((error)=>console.log(error));
  }
 

  const handleSubmit = (e) => {
    e.preventDefault();
    setFormErrors(validate(formValues));
    setIsSubmit(true);
  };
  

  useEffect(() => {
    console.log(formErrors);
    if (Object.keys(formErrors).length === 0 && isSubmit) {
      console.log(formValues);
    }
  }, [formErrors]);

  const validate = (values) => {
    const errors = {};
    if (!values.username) {
      errors.username = "Username is Required!";
    }
    if (!values.userType) {
      errors.userType = "User Type is Required!";
    } 
    if (!values.password) {
      errors.password = "Password is Required";
    } else if (values.password.length < 4) {
      errors.password = "Password must be more than 4 Characters";
    } else if (values.password.length > 10) {
      errors.password = "Password cannot exceed more than 10 Characters";
    }
    if(!isLogged){
       errors.login="Invalid Credentials";
     }
     return errors;
   };

  return (
    <div className="container">
      <form onSubmit={handleSubmit}>
        <h1>Register Form</h1>
        <div className="ui divider"></div>
        <div className="ui form">
          <div className="field">
            <label>UserName:</label>
            <input
              type="text"
              name="UserName"
              placeholder="UserName"
              value={formValues.loginName}
              onChange={handleChange}
            />
          </div>
          <p>{formErrors.loginName}</p>
          <div className="field">
            <label>Email:</label>
            <input
              type="text"
              name="email"
              placeholder="Email"
              value={formValues.email}
              onChange={handleChange}
            />
          </div>
          <p>{formErrors.email}</p>
          <div className="field">
            <label>Password:</label>
            <input
              type="password"
              name="password"
              placeholder="Password"
              value={formValues.password}
              onChange={handleChange}
            />
          </div>
          <p>{formErrors.password}</p>
          <div className="field">
            <label>Role:</label>
            <input
              type="text"
              name="role"
              placeholder="Role"
              value={formValues.role}
              onChange={handleChange}
            />
          </div>
          <p>{formErrors.role}</p>

          <button className="fluid ui button blue" onClick={fetchProducts}>Submit</button>
          
        </div>
      </form>
      
    </div>
  )
}

export default SignUp;