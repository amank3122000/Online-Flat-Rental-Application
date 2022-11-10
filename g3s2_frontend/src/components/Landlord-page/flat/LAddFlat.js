import React ,{useState,useEffect} from 'react'
import axios from 'axios'

function LAddFlat() {

    let initialFlat={
        flatAddress:{
            houseNo:0,
            street:'',
            city:'',
            state:'',
            pin:0,
            country:''
            },
        availability:'',
        cost:0,
        flatId:0
        }
    let [Flat,setFlat]=useState(initialFlat)
    let [msg,setMsg]=useState('')
    let [id,setId]=useState(0)

    function formValidate() {
        // const form = document.querySelector('form')
        // var lid=form.elements.flatid.value
        // var fid=form.elements.houseNo.value
        // var str=form.elements.street.value
        // var pn=form.elements.pincode.value
        // var ct=form.elements.city.value
        // var st=form.elements.state.value
        // var con=form.elements.country.value
        // var cst=form.elements.cost.value
        // var flt=form.elements.flatA.value

        // var error=document.getElementById("error")

        // var savebtn=document.getElementById("savebutton")

        // if(lid<=0){
        //     error.innerHTML="Landlord ID: Provide a positive integer"
        // }
        // else if(lid%1!==0){
        //     error.innerHTML="Landlord ID: Provide an integer value"
        // }
        // else if(fid<=0){
        //     error.innerHTML="Flat Number: Provide a positive integer"
        // }
        // else if(fid%1!==0){
        //     error.innerHTML="Flat Number: Provide an integer value"
        // }
        // else if(str==''){
        //     error.innerHTML="Street: Street cannot be empty"
        // }
        // else if(pn.toString().charAt(0)=="0"){
        //     error.innerHTML="PIN: Pincode should not start with 0"
        // }
        // else if(pn.toString().length!==6){
        //     error.innerHTML="PIN: Pincode should be in six digits"
        // }
        // else if(pn<=0){
        //     error.innerHTML="PIN: Pincode should be in six digits"
        // }
        // else if(pn%1!==0){
        //     error.innerHTML="PIN: Provide integer value"
        // }
        // else if(ct==''){
        //     error.innerHTML="City: City cannot be empty"
        // }
        // else if(st==''){
        //     error.innerHTML="State: State cannot be empty"
        // }
        // else if(con==''){
        //     error.innerHTML="Country: Country cannot be empty"
        // }
        // else if(cst<=0){
        //     error.innerHTML="Cost: Cannot be zero or less than zero"
        // }
        // else if(flt!=="Yes"&&flt!=="No"){
        //     error.innerHTML="Flat Availability: Select options"
        // }
        // else{
        //     error.innerHTML=""
        //     savebtn.style.pointerEvents="auto"
        // }
    }

    useEffect(()=>
    {
        const URL=`http://localhost:8080/flat/addflat`
        axios.post(URL,Flat).then(response=>
            {
                setMsg(response.data)
                setId(0);
            }).catch(error=>console.log(error.response))
    },[id])


   const handleBtnClick=(event)=>
    {
        event.preventDefault()
        setId(1)
        
    }
    return (
        <>
        <div style={{backgroundImage: "linear-gradient(15deg, #fdf9f1 0%, #f6e4c0 100%)", height:700}}>
        <h2 className='text-primary container'>Add flat details</h2>
            <hr/>
            <form 
            onSubmit={handleBtnClick} 
            className="col-4 container">
                <div className='form-group'>
                    <label>Enter Flat ID<span style={{color: "red"}}>*</span></label>
                    <input name="flatid" placeholder="Flat ID" type='number' className='form-control'
                         value={Flat.flatId}
                         onInput={formValidate}
                         onChange={e=>setFlat({...Flat,flatId:e.target.value})}/>
                </div>
                <div className='form-group'>
                    <label>House Number<span style={{color: "red"}}>*</span></label>
                    <input name="houseNo" placeholder="House Number" type='number' className='form-control'
                         value={Flat.flatAddress.houseNo}
                         onInput={formValidate}
                         onChange={e=>setFlat({...Flat,flatAddress:{...Flat.flatAddress,houseNo:e.target.value}})}/>
                </div>
                <div className='form-group'>
                    <label>Street<span style={{color: "red"}}>*</span></label>
                    <input name="street" placeholder="Street name" className='form-control' 
                        value={Flat.flatAddress.street} 
                        onInput={formValidate}
                        onChange={e=>setFlat({...Flat,flatAddress:{...Flat.flatAddress,street:e.target.value}})}/>
                </div>
                <div className='form-group'>
                    <label>Pin code<span style={{color: "red"}}>*</span></label>
                    <input name="pincode" placeholder="If other than India--> 999999" type='number' 
                    className='form-control' 
                    value={Flat.flatAddress.pin} 
                    onInput={formValidate}
                    onChange={e=>setFlat({...Flat,flatAddress:{...Flat.flatAddress,pin:e.target.value}})}/>
                </div>
                <div className='form-group'>
                    <label>City<span style={{color: "red"}}>*</span></label>
                    <input name="city" placeholder="City name" className='form-control' 
                    value={Flat.flatAddress.city} 
                    onInput={formValidate}
                    onChange={e=>setFlat({...Flat,flatAddress:{...Flat.flatAddress,city:e.target.value}})}/>
                </div>
                <div className='form-group'>
                    <label>State<span style={{color: "red"}}>*</span></label>
                    <input name="state" placeholder="State name" 
                    className='form-control' value={Flat.flatAddress.state} 
                    onInput={formValidate}
                    onChange={e=>setFlat({...Flat,flatAddress:{...Flat.flatAddress,state:e.target.value}})}/>
                </div>
                <div className='form-group'>
                    <label>Country<span style={{color: "red"}}>*</span></label>
                    <input name="country" placeholder="Country name"  className='form-control' 
                    onInput={formValidate}
                    value={Flat.flatAddress.country} 
                    onChange={e=>setFlat({...Flat,flatAddress:{...Flat.flatAddress,country:e.target.value}})}/>
                </div>
                <div className='form-group'>
                    <label>Monthly rent<span style={{color: "red"}}>*</span></label>
                    <input name="cost" placeholder="in RS" className='form-control' 
                    value={Flat.cost} 
                    onInput={formValidate}
                    onChange={e=>setFlat({...Flat,cost:e.target.value})}/>
                </div>
                {/* <div className='form-group'>
                    <label>Flat Availability<span style={{color: "red"}}>*</span></label>
                    <div>
                        <div className="form-check form-check-inline">
                        <input onInput={formValidate} className="form-check-input" type="radio" name="flatA" id="flatYes" value="Yes" onChange={e=>setFlat({...Flat,flatAvailability:e.target.value})}/>
                            <label className="form-check-label" for="flatYes">
                                Available
                            </label>
                        </div>
                        <div className="form-check form-check-inline">
                            <input onInput={formValidate} className="form-check-input" type="radio" name="flatA" id="flatNo" value="No" onChange={e=>setFlat({...Flat,flatAvailability:e.target.value})}/>
                            <label className="form-check-label" for="flatNo">
                                Unavailable
                            </label>
                        </div>
                    </div>
                </div> */}
                <label>UserType</label>
       <select name="usertype" className="username" 
        value={Flat.availability} 
        onChange={e=>setFlat({...Flat,availability:e.target.value})}
       >
         <option value="">Select one option</option>
         <option value="available">Available</option>
         <option value="unavailable">Unavailable</option>
         
       </select>
       {/* <p>{formErrors.userType}</p> */}
                <button id="savebutton" className='btn btn-success mt-2' >Add Flat</button>
                <h6 id="error" className="text text-danger"></h6>
            </form>
            <h6>{msg}</h6>
        </div>
           
        </>
        
    )
}

export default LAddFlat 
