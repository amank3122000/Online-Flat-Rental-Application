import React, { useEffect, useState } from 'react';
import axios from 'axios';

function UpdateLandlord() {

    const [landlord,setLandlord] = useState([]);
    const [btn,setButton] = useState(0);
    const [isSubmit, setIsSubmit] = useState(false);
 
 
    useEffect(() => {
       const URL='http://localhost:8080/landlord/updatelandlord';
       axios.put(URL,landlord).then((response) => 
       setLandlord(response.data)
       )
       .catch(error => console.log(error.message))
   },[btn]);
   
   function handleBtnClick(e)
   {
       e.preventDefault();
       //setFormErrors(validate(user));
       setIsSubmit(true);
       setButton(landlord.landlordid)
       window.alert("Landlord Updated");
 
   }
 
  //  useEffect(() => {
  //    console.log(formErrors);
  //    if (Object.keys(formErrors).length === 0 && isSubmit) {
  //      console.log(user);
  //    }
  //  }, [formErrors]);
 
  //  const validate = (values) => {
  //    const errors = {};
  //    if (!values.userid) {
  //      errors.userid = "Username is required!";
  //    }
  //    if (!values.username) {
  //      errors.username = "User id is required!";
  //    }
  //    if (!values.userType) {
  //      errors.email = "User type is required!";
  //    } 
  //    if (!values.password) {
  //      errors.password = "Password is required";
  //    } else if (values.password.length < 4) {
  //      errors.password = "Password must be more than 4 characters";
  //    } else if (values.password.length > 10) {
  //      errors.password = "Password cannot exceed more than 10 characters";
  //    }
  //    return errors;
  //  };

   return (
      <React.Fragment>
        
       <form id = "" className="c2 booking-form updatelandlordform">
        <h1 className="form-text">Update Landlord</h1><br/>
        <input name="landlordid" type="text" placeholder="Landlord ID" className="col-md-4 address-tags"/><br/>
        <input name="landlordname" type="text" placeholder="Landlord Name" className="col-md-4 address-tags"/>
        <input name="landlordage" type="number" placeholder="Landlord Age" min="18" className="col-md-3 address-tags"/>

        <div className="col-md-12 text-center"> 
          <button id="singlebutton" name="singlebutton" className="btn btn-info">View Flat List</button> 
        </div>
        
        <button className="btn" onClick={handleBtnClick}>Update Landlord</button>
        
     </form>
<br/><br/>

     {/* <table className="table table-data table-striped table-bordered view-table updatelandlordtable">
      <thead>
        <tr className="table-warning">
          <th className="col-md-1">Flat ID</th>
          <th className="col-md-2">Flat Cost</th>
          <th className="col-md-5">Flat Address</th>
          <th className="col-md-1">Flat Availability</th>
          <th className="col-md-3">Actions</th>
        </tr>
      </thead>
      <tbody className="table-success ">
        <tr>
          <td className="col-md-1">Rohit</td>
          <td className="col-md-2">2000</td>
          <td className="col-md-5">Newadsdasd</td>
          <td className="col-md-1">Yes</td>
          <td className="col-md-3">
            <button className="btn btn-warning logout-btn" type="submit">Update</button>
            <button className="btn btn-danger logout-btn" type="submit">Delete</button>
          </td>
        </tr>
      
       
      </tbody>
    </table> */}

    </React.Fragment>
    );
}

export default UpdateLandlord;