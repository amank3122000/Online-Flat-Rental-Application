
import React, { useEffect, useState } from 'react';
import axios from 'axios';

function AddTenant() {


  let initialtenant={tAddress:{
    houseNo:0,
    street:'',
    city:'',
    state:'',
    pin:0,
    country:''
    },age:''};
  let [tenant,setTenant]=useState(initialtenant);
  let [msg,setMsg]=useState('');
  let [id,setId]=useState(0);

  useEffect(() => {
    const URL='http://localhost:8080/tenant/addTenant';
    axios.post(URL,tenant).then((response) => 
    {
        setMsg(response.data)
    }).catch(error => console.log(error.message))
    },[id])

    function handleBtnClick(e)
    {
        e.preventDefault();
        setId(1)
        window.alert("tenant Added...");

    }




  return (
      <React.Fragment>
        <form className="c2">
            <h1 className="form-text">Add Tenant</h1>
         <br/><br/><br/>
            
            <input name="tenantid" type="text" placeholder="Tenant ID" className="col-md-4 address-tags"
             value={tenant.tenantId} onChange={e=>setTenant({...tenant,tenantId:e.target.value})}
            /><br/><br/>
                <div className='form-group'>
                    <label>Flat Number<span style={{color: "red"}}>*</span></label>
                    <input name="flatid" placeholder="Flat Number" type='number' className='form-control'
                         value={tenant.tAddress.houseNo}
                         onInput={formValidate}
                         onChange={e=>setTenant({...tenant,tAddress:{...tenant.tAddress,houseNo:e.target.value}})}/>
                </div>
                <div className='form-group'>
                    <label>Street<span style={{color: "red"}}>*</span></label>
                    <input name="street" placeholder="Street name" className='form-control' 
                        value={tenant.tAddress.street} 
                        onInput={formValidate}
                        onChange={e=>setTenant({...tenant,tAddress:{...tenant.tAddress,street:e.target.value}})}/>
                </div>
                <div className='form-group'>
                    <label>Pin code<span style={{color: "red"}}>*</span></label>
                    <input name="pincode" placeholder="If other than India--> 999999" type='number' 
                    className='form-control' 
                    value={tenant.tAddress.pin} 
                    onInput={formValidate}
                    onChange={e=>setTenant({...tenant,tAddress:{...tenant.tAddress,pin:e.target.value}})}/>
                </div>
                <div className='form-group'>
                    <label>City<span style={{color: "red"}}>*</span></label>
                    <input name="city" placeholder="City name" className='form-control' 
                    value={tenant.tAddress.city} 
                    onInput={formValidate}
                    onChange={e=>setTenant({...tenant,tAddress:{...tenant.tAddress,city:e.target.value}})}/>
                </div>
                <div className='form-group'>
                    <label>State<span style={{color: "red"}}>*</span></label>
                    <input name="state" placeholder="State name" 
                    className='form-control' value={tenant.tAddress.state} 
                    onInput={formValidate}
                    onChange={e=>setTenant({...tenant,tAddress:{...tenant.tAddress,state:e.target.value}})}/>
                </div>
                <div className='form-group'>
                    <label>Country<span style={{color: "red"}}>*</span></label>
                    <input name="country" placeholder="Country name"  className='form-control' 
                    onInput={formValidate}
                    value={tenant.tAddress.country} 
                    onChange={e=>setTenant({...tenant,tAddress:{...tenant.tAddress,country:e.target.value}})}/>
                </div>
<br/><br/>
            <input name="tenantage" type="number" placeholder="Tenant Age" className="col-md-4 address-tags"
             value={tenant.age} onChange={e=>setTenant({...tenant,age:e.target.value})}
            />
        <br/><br/>
            <button className="btn" onClick={handleBtnClick}>Add Tenant</button>
        </form>
    
     </React.Fragment>
    );
}

export default AddTenant;