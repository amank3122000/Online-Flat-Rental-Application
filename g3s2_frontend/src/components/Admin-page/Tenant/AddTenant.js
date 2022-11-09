
import React, { useEffect, useState } from 'react';
import axios from 'axios';

function AddTenant() {


  let initialtenant={tenantId:0,
    tAddress:{
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

  function formValidate() {
    const form = document.querySelector('form')
    var tid=form.elements.tenantId.value
    var fid=form.elements.flatid.value
    var str=form.elements.street.value
    var pn=form.elements.pincode.value
    var ct=form.elements.city.value
    var st=form.elements.state.value
    var con=form.elements.country.value
    var tage=form.elements.tenantage.value
    // var flt=form.elements.flatA.value

    var error=document.getElementById("error")

    var savebtn=document.getElementById("savebutton")

    if(tenant.tenantId<=0){
        error.innerHTML="Tenant ID: Provide a positive integer"
    }
    else if(tenant.tenantId%1!==0){
        error.innerHTML="Tenant ID: Provide an integer value"
    }
    else if(fid<=0){
        error.innerHTML="Flat Number: Provide a positive integer"
    }
    else if(fid%1!==0){
        error.innerHTML="Flat Number: Provide an integer value"
    }
    else if(str==''){
        error.innerHTML="Street: Street cannot be empty"
    }
    else if(pn.toString().charAt(0)=="0"){
        error.innerHTML="PIN: Pincode should not start with 0"
    }
    else if(pn.toString().length!==6){
        error.innerHTML="PIN: Pincode should be in six digits"
    }
    else if(pn<=0){
        error.innerHTML="PIN: Pincode should be in six digits"
    }
    else if(pn%1!==0){
        error.innerHTML="PIN: Provide integer value"
    }
    else if(ct==''){
        error.innerHTML="City: City cannot be empty"
    }
    else if(st==''){
        error.innerHTML="State: State cannot be empty"
    }
    else if(con==''){
        error.innerHTML="Country: Country cannot be empty"
    }
    else if(tage<=0){
        error.innerHTML="Cost: Cannot be zero or less than zero"
    }
    //else if(flt!=="Yes"&&flt!=="No"){
       // error.innerHTML="Flat Availability: Select options"
    //}
    else{
        error.innerHTML=""
        savebtn.style.pointerEvents="auto"
    }
}



  useEffect(() => {
    const URL='http://localhost:8080/tenant/addTenant';
    axios.post(URL,tenant).then((response) => 
    {
        setMsg(response.data)
        //window.alert("tenant Added...");
        setId(0);
    }).catch(error => console.log(error.response))
    },[id])

    function handleBtnClick(e)
    {
        e.preventDefault();
        setId(1)
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
            <h6 id="error" className="text text-danger"></h6>
        </form>
    
     </React.Fragment>
    );
}

export default AddTenant;