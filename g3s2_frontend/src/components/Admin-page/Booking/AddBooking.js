
import React ,{useState,useEffect} from 'react'
import axios from 'axios'

function AddBooking() {

    let initialFlatBooking={
        bookingNo: 0,
            flat: {
              flatId: 0,
              cost: 0,
              flatAddress: {
                houseNo: 0,
                street: "",
                city: "",
                state: "",
                pin: 0,
                country: ""
              },
              availability: ""
            },
            tenantId: {
              tenantId: 0,
              age: 0,
              taddress: {
                houseNo: 0,
                street: "",
                city: "",
                state: "",
                pin:0 ,
                country: ""
              }
            },
            bookingFromDate: "",
            bookingToDate: ""
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

    // useEffect(()=>
    // {
    //     const URL=`http://localhost:8080/flatbooking/addflatbooking`;
    //     axios.post(URL,FlatBooking).catch(error=>console.log(error.response))
    // },[id])


   const handleBtnClick=(event)=>
    {
        event.preventDefault()
        const URL=`http://localhost:8080/flatbooking/addflatbooking`;
        axios.post(URL,FlatBooking).then((response) => {
            window.alert(response.data);
        }).catch(error=>console.log(error.response))
        
    }
    return (
        <>
        <div style={{backgroundImage: "linear-gradient(15deg, #fdf9f1 0%, #f6e4c0 100%)"}}>
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
                         value={FlatBooking.tenantId.tenantId}
                        //  onInput={formValidate}
                         onChange={e=>setFlatBooking({...FlatBooking,tenantId:{...FlatBooking.tenantId,tenantId:e.target.value}})}/>
                </div>
                <div className='form-group'>
                    <label>House Number<span style={{color: "red"}}>*</span></label>
                    <input name="flatid" placeholder="Flat Number" type='number' className='form-control'
                         value={FlatBooking.tenantId.taddress.houseNo}
                        //  onInput={formValidate}
                         onChange={e=>setFlatBooking({...FlatBooking,tenantId:{...FlatBooking.tenantId.taddress,
                         taddress:{...FlatBooking.tenantId.taddress,houseNo:e.target.value}}})}/>
                </div>
                <div className='form-group'>
                    <label>Street<span style={{color: "red"}}>*</span></label>
                    <input name="street" placeholder="Street name" className='form-control' 
                        value={FlatBooking.tenantId.taddress.street} 
                        // onInput={formValidate}
                        onChange={e=>setFlatBooking({...FlatBooking,tenantId:{...FlatBooking.tenantId.taddress,
                            taddress:{...FlatBooking.tenantId.taddress,street:e.target.value}}})}
                        />
                </div>
                <div className='form-group'>
                    <label>Pin code<span style={{color: "red"}}>*</span></label>
                    <input name="pincode" placeholder="If other than India--> 999999" type='number' 
                    className='form-control' 
                    value={FlatBooking.tenantId.taddress.pin} 
                    // onInput={formValidate}
                    onChange={e=>setFlatBooking({...FlatBooking,tenantId:{...FlatBooking.tenantId.taddress,
                        taddress:{...FlatBooking.tenantId.taddress,pin:e.target.value}}})}
                    />
                </div>
                <div className='form-group'>
                    <label>City<span style={{color: "red"}}>*</span></label>
                    <input name="city" placeholder="City name" className='form-control' 
                    value={FlatBooking.tenantId.taddress.city} 
                    // onInput={formValidate}
                    onChange={e=>setFlatBooking({...FlatBooking,tenantId:{...FlatBooking.tenantId.taddress,
                        taddress:{...FlatBooking.tenantId.taddress,city:e.target.value}}})}
                    />
                </div>
                <div className='form-group'>
                    <label>State<span style={{color: "red"}}>*</span></label>
                    <input name="state" placeholder="State name" 
                    className='form-control' value={FlatBooking.tenantId.taddress.state} 
                    // onInput={formValidate}
                    onChange={e=>setFlatBooking({...FlatBooking,tenantId:{...FlatBooking.tenantId.taddress,
                        taddress:{...FlatBooking.tenantId.taddress,state:e.target.value}}})}
                    />
                </div>
                <div className='form-group'>
                    <label>Country<span style={{color: "red"}}>*</span></label>
                    <input name="country" placeholder="Country name"  className='form-control' 
                    // onInput={formValidate}
                    value={FlatBooking.tenantId.taddress.country} 
                    onChange={e=>setFlatBooking({...FlatBooking,tenantId:{...FlatBooking.tenantId.taddress,
                        taddress:{...FlatBooking.tenantId.taddress,country:e.target.value}}})}
                    />
                </div>
            <br/><br/>
            <input name="tenantage" type="number" placeholder="Tenant Age" className="col-md-4 address-tags"
             value={FlatBooking.tenantId.age}  onChange={e=>setFlatBooking({...FlatBooking,age:{...FlatBooking.age,age:e.target.value}})}
            />

                <div className='form-group'>
                    <label>Enter Flat ID<span style={{color: "red"}}>*</span></label>
                    <input name="flatid" placeholder="Flat ID" type='number' className='form-control'
                         value={FlatBooking.flat.flatId}
                        //  onInput={formValidate}
                        onChange={e=>setFlatBooking({...FlatBooking,flat:{...FlatBooking.flat.flatId,
                            flatId:{...FlatBooking.flat.flatId,flatId:e.target.value}}})}
                         />
                </div>

                <div className='form-group'>
                    <label>House Number<span style={{color: "red"}}>*</span></label>
                    <input name="houseNo" placeholder="House Number" type='number' className='form-control'
                         value={FlatBooking.flat.flatAddress.houseNo}
                        //  onInput={formValidate}
                        onChange={e=>setFlatBooking({...FlatBooking,flat:{...FlatBooking.flat.taddress,
                            taddress:{...FlatBooking.flat.taddress,houseNo:e.target.value}}})}
                         />
                </div>

                <div className='form-group'>
                    <label>Street<span style={{color: "red"}}>*</span></label>
                    <input name="street" placeholder="Street name" className='form-control' 
                        value={FlatBooking.flat.flatAddress.street} 
                        // onInput={formValidate}
                        onChange={e=>setFlatBooking({...FlatBooking,flat:{...FlatBooking.flat.taddress,
                            taddress:{...FlatBooking.flat.taddress,street:e.target.value}}})}
                        />
                </div>

                <div className='form-group'>
                    <label>Pin code<span style={{color: "red"}}>*</span></label>
                    <input name="pincode" placeholder="If other than India--> 999999" type='number' 
                    className='form-control' 
                    value={FlatBooking.flat.flatAddress.pin} 
                    // onInput={formValidate}
                    onChange={e=>setFlatBooking({...FlatBooking,flat:{...FlatBooking.flat.taddress,
                        taddress:{...FlatBooking.flat.taddress,pin:e.target.value}}})}
                    />
                </div>

                <div className='form-group'>
                    <label>City<span style={{color: "red"}}>*</span></label>
                    <input name="city" placeholder="City name" className='form-control' 
                    value={FlatBooking.flat.flatAddress.city} 
                    // onInput={formValidate}
                    onChange={e=>setFlatBooking({...FlatBooking,flat:{...FlatBooking.flat.taddress,
                        taddress:{...FlatBooking.flat.taddress,city:e.target.value}}})}
                    />
                </div>

                <div className='form-group'>
                    <label>State<span style={{color: "red"}}>*</span></label>
                    <input name="state" placeholder="State name" 
                    className='form-control' value={FlatBooking.flat.flatAddress.state} 
                    // onInput={formValidate}
                    onChange={e=>setFlatBooking({...FlatBooking,flat:{...FlatBooking.flat.taddress,
                        taddress:{...FlatBooking.flat.taddress,state:e.target.value}}})}
                    />
                </div>

                <div className='form-group'>
                    <label>Country<span style={{color: "red"}}>*</span></label>
                    <input name="country" placeholder="Country name"  className='form-control' 
                    // onInput={formValidate}
                    value={FlatBooking.flat.flatAddress.country} 
                    onChange={e=>setFlatBooking({...FlatBooking,flat:{...FlatBooking.flat.taddress,
                        taddress:{...FlatBooking.flat.taddress,country:e.target.value}}})}
                    />
                </div>

                <div className='form-group'>
                    <label>Monthly rent<span style={{color: "red"}}>*</span></label>
                    <input name="cost" placeholder="in RS" className='form-control' 
                    value={FlatBooking.flat.cost} 
                    // onInput={formValidate}
                    onChange={e=>setFlatBooking({...FlatBooking,flat:{...FlatBooking.flat.cost,
                        cost:{...FlatBooking.flat.cost,cost:e.target.value}}})}
                    />
                </div>
                
                <label>Availability</label>
       <select name="availability" className="username" 
        value={FlatBooking.flat.availability} 
        onChange={e=>setFlatBooking({...FlatBooking,flat:{...FlatBooking.flat.availability,
            availability:{...FlatBooking.flat.availability,availability:e.target.value}}})}
       >
         <option value="">Select one option</option>
         <option value="available">Available</option>
         <option value="unavailable">Unavailable</option>
         
       </select>
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
