
import React, { useEffect, useState } from 'react';
import axios from 'axios';


function ViewLandlord() {

  let initiallandlord={flatList:[], landlordAge: 0, landlordId: 0, landlordName: ''};
    const [landlordid,setLandlordid] = useState(0);
    const [landlordDetails,setLandlordDetails] = useState(initiallandlord);
    // const [btn,setButton] = useState(0);
    //const [deletebtn,setdeleteButton] = useState(0);
    //const [formErrors, setFormErrors] = useState({});
    const [isSubmit, setIsSubmit] = useState(false);

 
  //   useEffect(() => {
  //      // DELETE request using axios inside useEffect React hook
  //      axios.get(`http://localhost:8080/users/viewlandlord/${landlordid}`)
  //      .then((response) => setLandlordDetail(response.data));

  //  }, [btn]);

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
    axios.get(`http://localhost:8080/landlord/viewlandlord/${landlordid}`)
       .then((response) => {setLandlordDetails(response.data)
        setLandlordid(0);}).catch(error => console.log(error.message));
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

console.log(landlordDetails);
   return (
      <React.Fragment>
        
        <form className="view-form">
    <h1 className="form-text ">View LandLord By ID</h1>
    <br/>
    <input name="landlordname" type="number" placeholder="Landlord ID*" className="username"
    value = {landlordid} onChange={e=>setLandlordid(e.target.value)}/>
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
          <td className="col-md-2">{landlordDetails&&landlordDetails.landlordId}</td>
          <td className="col-md-3">{landlordDetails&&landlordDetails.landlordName}</td>
          <td className="col-md-1">{landlordDetails&&landlordDetails.landlordAge}</td>
          <td className="col-md-3">{landlordDetails&&landlordDetails.flatList.map(flat=><div>{flat.flatId},</div>)}</td>
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