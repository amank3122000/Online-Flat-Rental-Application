import React, { useEffect, useState } from 'react';
import axios from 'axios';

function RemoveLandlord() {

   
   const [landlordId,setLandlordId] = useState(0);
   const [isSubmit, setIsSubmit] = useState(false);
   

  const handleBtnClick = (e)=>{
      // console.log(e.target.response)
      e.preventDefault();
      //setFormErrors(validate(landlordid));
      setIsSubmit(true);
      axios.delete(`http://localhost:8080/landlord/deletelandlord/${landlordId}`)
      .then(() =>
      {
        window.alert("Landlord Removed");
        setLandlordId(0)
    }).catch(error => console.log(error.message))
  }



   return (
      <React.Fragment>
        <form className="c2">
            <h1 className="form-text ">Remove Landlord By ID</h1>
            <br/>
            <label>Landlord Id</label>
            <input name="landlordid" type="number" placeholder="Landlord ID*" className="username" 
            value = {landlordId} onChange={e=>setLandlordId(e.target.value)}/>
            <br/><br/>
            <br/><br/>
            <button className="btn" onClick={handleBtnClick}>Remove Landlord</button>
         </form>
    </React.Fragment>
    );
}

export default RemoveLandlord;