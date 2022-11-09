
import React, { useEffect, useState } from 'react';
import axios from 'axios';


function ViewLandlord() {
  
    const [landlordid,setLandlordid] = useState(0);
    const [landlordDetails,setLandlordDetail] = useState([]);
    const [btn,setButton] = useState(0);
    //const [deletebtn,setdeleteButton] = useState(0);
    //const [formErrors, setFormErrors] = useState({});
    const [isSubmit, setIsSubmit] = useState(false);

 
    useEffect(() => {
       // DELETE request using axios inside useEffect React hook
       axios.get(`http://localhost:8080/users/viewlandlord/${landlordid}`)
       .then((response) => setLandlordDetail(response.data));

   }, [btn]);

        // useEffect(()=>{
        //     const URL=`http://localhost:8080/users/removeUser/${userid}`
        //     axios.delete(URL).then(response=>
        //         {
        //             setUserDetail([]);
        //             setUserid(0);
        //             btn(0);
        //         }).catch(error=>console.log(error.response));
        // },[deletebtn]);


 
 
   const handleBtnClick = (e)=>{
    e.preventDefault();
    //setFormErrors(validate(userDetails));
    setIsSubmit(true);
    setButton(landlordid)
      
  }

  // useEffect(() => {
  //   console.log(formErrors);
  //   if (Object.keys(formErrors).length === 0 && isSubmit) {
  //     console.log(userid);
  //   }
  // }, [formErrors]);

  // const validate = (values) => {
  //   const errors = {};
  //   if (!values.username) {
  //       errors.userid = "User id is required!";
  //   }
  //   return errors;
  // };

  // const handleDeleteBtnClick =(e)=>{
  //     e.preventDefault();
  //     setdeleteButton(userid)
  // }


   return (
      <React.Fragment>
        
        <form className="view-form">
    <h1 className="form-text ">View LandLord By ID</h1>
    <br/>
    <input name="username" type="number" placeholder="User ID*" className="username"/>
    <br/>
    <button className="btn" onClick={handleBtnClick}>View Landlord</button>
   </form>
   

 <table className="table table-data table-striped table-bordered view-table">
    <thead>
        <tr className="table-warning">
          <th className="col-md-2">ID</th>
          <th className="col-md-3">Landlord Name</th>
          <th className="col-md-1">Age</th>
          <th className="col-md-3">Flat List</th>
          {/* <th className="col-md-3">Actions</th> */}
        </tr>
      </thead>
      <tbody className="table-success ">
        <tr>
          <td className="col-md-2">{landlordDetails.landlordId}</td>
          <td className="col-md-3">{landlordDetails.landlordName}</td>
          <td className="col-md-1">{landlordDetails.landlordAge}</td>
          <td className="col-md-3">{landlordDetails.flatList}</td>
          {/* <td className="col-md-3">
            <button className="btn btn-warning logout-btn" type="submit">Update</button>
            <button className="btn btn-danger logout-btn" type="submit">Delete</button>
          </td> */}
        </tr>
      
       
      </tbody>

  </table>     


    </React.Fragment>
    );
}

export default ViewLandlord;