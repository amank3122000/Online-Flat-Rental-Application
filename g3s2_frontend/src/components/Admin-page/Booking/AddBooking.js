
import React ,{useState,useEffect} from 'react'
import axios from 'axios'

function AddBooking() {

    let initialFlatBooking={
        bookingId :0,
        bookingFromDate:'',
        bookingToDate:'',
        flatId:0,
        bookingNo :0,
        tenant:{tenantId:0},
        flat : {
            flatId : 0,
           


        }

        }
    let [FlatBooking,setFlatBooking]=useState(initialFlatBooking)
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
        const URL=`http://localhost:8080/flatbooking/addflatbooking`;
        axios.post(URL,FlatBooking).then(response=>
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
        <h2 className='text-primary container'>Add flatbooking details</h2>
            <hr/>
            <form 
            onSubmit={handleBtnClick} 
            className="col-4 container">

<div className='form-group'>
                    <label>Enter Booking ID<span style={{color: "red"}}>*</span></label>
                    <input name="bookingId" placeholder="Booking ID" type='number' className='form-control'
                         value={FlatBooking.bookingId}
                         onInput={formValidate}
                         onChange={e=>setFlatBooking({...FlatBooking,bookingId:e.target.value})}/>
                </div>

                <div className='form-group'>
                    <label>Enter tenant ID<span style={{color: "red"}}>*</span></label>
                    <input name="tenantId" placeholder="tenant ID" type='number' className='form-control'
                         value={FlatBooking.tenant.tenantId}
                         onInput={formValidate}
                         onChange={e=>setFlatBooking({...FlatBooking,tenant:{...FlatBooking.tenant,tenantId:e.target.value}})}/>
                </div>

                <div className='form-group'>
                    <label>Enter Flat ID<span style={{color: "red"}}>*</span></label>
                    <input name="flatid" placeholder="Flat ID" type='number' className='form-control'
                         value={FlatBooking.flat.flatId}
                         onInput={formValidate}
                         onChange={e=>setFlatBooking({...FlatBooking,flat:{...FlatBooking.flat,flatId:e.target.value}})}/>
                </div>

                <div className='form-group'>
                    <label>bookingFromDate<span style={{color: "red"}}>*</span></label>
                    <input name="fromDate" placeholder="Booking from" type='text' className='form-control'
                         value={FlatBooking.bookingFromDate}
                         onInput={formValidate}
                         onChange={e=>setFlatBooking({...FlatBooking,bookingFromDate:e.target.value})}/>
                </div>

                <div className='form-group'>
                    <label>bookingToDate<span style={{color: "red"}}>*</span></label>
                    <input name="toDate" placeholder="Booking to" type='text' className='form-control'
                         value={FlatBooking.bookingToDate}
                         onInput={formValidate}
                         onChange={e=>setFlatBooking({...FlatBooking,bookingToDate:e.target.value})}/>
                </div>

      
       {/* <p>{formErrors.userType}</p> */}
                <button id="savebutton" className='btn btn-success mt-2' >Add Booking</button>
                <h6 id="error" className="text text-danger"></h6>
            </form>
            <h6>{msg}</h6>
        </div>
           
        </>
        
    )
}

export default AddBooking;
