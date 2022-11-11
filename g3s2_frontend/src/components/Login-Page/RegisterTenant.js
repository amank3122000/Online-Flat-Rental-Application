import React, { useState } from 'react';
import axios from 'axios';
import styles from '../Login-Page/login.module.css';
import { Link } from 'react-router-dom';

function RegisterTenant(){
    let initialuser={userId:0,userName:'',password:'',userType:'tenant'};
    let [user,setUser]=useState(initialuser);
    // const [formErrors, setFormErrors] = useState({});
    // const [isSubmit, setIsSubmit] = useState(false);

    let initialtenant={taddress:{
        houseNo:0,
        street:'',
        city:'',
        state:'',
        pin:0,
        country:''
        },age:'',
    tenantId:0};
      let [tenant,setTenant]=useState(initialtenant);

      function handleTenant(e)
        {
            e.preventDefault();
            console.log(tenant);
            const URL1='http://localhost:8080/users/addUser';
            axios.post(URL1,user).then((response) => 
            {                    
                setUser(initialuser);
            }).catch(error => console.log(error.message))    

            const URL2='http://localhost:8080/tenant/addtenant';
            axios.post(URL2,tenant).then((response) => 
            {
                 // setMsg(response.data);
                setTenant(initialtenant);
            }).catch(error => console.log(error.message))
            window.alert("Tenant Registered...");
        }

    return (
        <React.Fragment>
            <form className="c2" method="POST">
            <h1 className="form-text ">Register Tenant</h1>
             <br/><br/><br/><br/>
             <label>Username</label>
            <input name="username" type="text" placeholder="Username*" className="username"
             value={user.userName} onChange={e=>setUser({...user,userName:e.target.value})}
            />
            {/* <p>{formErrors.userName}</p> */}
            <br/>
            <label>Password</label>
            <input name="password" type="password" placeholder="Password*" className="username"
            value={user.password} onChange={e=>setUser({...user,password:e.target.value})}
            />
            {/* <p>{formErrors.password}</p> */}
            <br/>
            <div className='form-group'>
                <label>House Number<span style={{color: "red"}}>*</span></label>
                <input name="flatid" placeholder="Flat Number" type='number' className="username"
                     value={tenant.taddress.houseNo}
                    //  onInput={formValidate}
                     onChange={e=>setTenant({...tenant,taddress:{...tenant.taddress,houseNo:e.target.value}})}/>
            </div>
            <div className='form-group'>
                <label>Street<span style={{color: "red"}}>*</span></label>
                <input name="street" placeholder="Street name" className="username" 
                    value={tenant.taddress.street} 
                    // onInput={formValidate}
                    onChange={e=>setTenant({...tenant,taddress:{...tenant.taddress,street:e.target.value}})}/>
            </div>
            <div className='form-group'>
                <label>Pin code<span style={{color: "red"}}>*</span></label>
                <input name="pincode" placeholder="If other than India--> 999999" type='number' 
                className="username"
                value={tenant.taddress.pin} 
                // onInput={formValidate}
                onChange={e=>setTenant({...tenant,taddress:{...tenant.taddress,pin:e.target.value}})}/>
            </div>
            <div className='form-group'>
                <label>City<span style={{color: "red"}}>*</span></label>
                <input name="city" placeholder="City name" className="username" 
                value={tenant.taddress.city} 
                // onInput={formValidate}
                onChange={e=>setTenant({...tenant,taddress:{...tenant.taddress,city:e.target.value}})}/>
            </div>
            <div className='form-group'>
                <label>State<span style={{color: "red"}}>*</span></label>
                <input name="state" placeholder="State name" 
                className="username" value={tenant.taddress.state} 
                // onInput={formValidate}
                onChange={e=>setTenant({...tenant,taddress:{...tenant.taddress,state:e.target.value}})}/>
            </div>
            <div className='form-group'>
                <label>Country<span style={{color: "red"}}>*</span></label>
                <input name="country" placeholder="Country name"  className="username" 
                // onInput={formValidate}
                value={tenant.taddress.country} 
                onChange={e=>setTenant({...tenant,taddress:{...tenant.taddress,country:e.target.value}})}/>
            </div>
        <br/><br/>
        <input name="tenantage" type="number" placeholder="Tenant Age" className="username"
         value={tenant.age} onChange={e=>setTenant({...tenant,age:e.target.value})}
        />
            <br/>
            <button className="btn" type="submit" onClick={handleTenant}>Register Tenant</button>
            </form>
        </React.Fragment>
    )
}

export default RegisterTenant