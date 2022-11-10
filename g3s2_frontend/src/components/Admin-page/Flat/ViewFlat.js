import React, { useEffect, useState } from 'react';
import axios from 'axios';


function ViewFlat() {
  let initialFlat = [] ;
  let [flat, setFlat] = useState(initialFlat);

  const [flatId,setUserid] = useState(0);
    //const [userDetails,setUserDetail] = useState([]);
    const [btn,setButton] = useState(0);
    //const [deletebtn,setdeleteButton] = useState(0);
    //const [formErrors, setFormErrors] = useState({});
    //const [isSubmit, setIsSubmit] = useState(false);
  
useEffect(() => {
  const URL = `http://localhost:8080/flat/viewflat/${flatId}`;
  axios
    .get(URL)
    .then((response) => {
        setFlat(response.data)
        console.log(response.data)
    })
    .catch((error) => console.log(error.message));
},[btn])

console.log(flat.flatAddress);

const handleBtnClick = (e)=>{
  e.preventDefault();
  //setFormErrors(validate(userDetails));
  //setIsSubmit(true);
  setButton(flatId)
    
}

   return (
      <React.Fragment>
        
        <form className="view-form">
    <h1 className="form-text ">View Flat By ID</h1>
    <br/>
    <input name="username" type="number" placeholder="Flat ID*" className="username"
    value = {flatId}
    onChange={e=>setUserid(e.target.value)}
    />
    
    <br/>
    <button className="btn" onClick={handleBtnClick}>View Flat</button>
   </form>
   

 <table className="table table-data table-striped table-bordered view-table">
    <thead>
        <tr className="table-warning">
        <th>Flat ID</th>
            <th>HOUSE NO</th>
            <th>STREET</th>
            <th>CITY</th>
            <th>PIN</th>
            <th>STATE</th>
            <th>COUNTRY</th>
            <th>FLAT COST</th>
            <th>AVAILABILITY</th>
          <th>Actions</th>
        </tr>
      </thead>
      <tbody className="table-success ">
        <tr>
          <td>{flat&&flat.flatId}</td>
          <td>{flat&&flat.flatAddress&&flat.flatAddress.houseNo}</td>
          <td>{flat&&flat.flatAddress&&flat.flatAddress.street}</td>
          <td>{flat&&flat.flatAddress&&flat.flatAddress.city}</td>
          <td>{flat&&flat.flatAddress&&flat.flatAddress.pin}</td>
          <td>{flat&&flat.flatAddress&&flat.flatAddress.state}</td>
          <td>{flat&&flat.flatAddress&&flat.flatAddress.country}</td>
         <td>{flat&&flat.cost}</td>
         <td>{flat&&flat.availability}</td>
          <td>
            <button className="btn btn-warning logout-btn" type="submit">Update</button>
            <button className="btn btn-danger logout-btn" type="submit">Delete</button>
          </td>
        </tr>
      
       
      </tbody>
      </table>

    </React.Fragment>
    );
}

export default ViewFlat;