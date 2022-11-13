import React, { useEffect, useState } from 'react';
import axios from 'axios';

function RemoveLandlord() {

   
   const [landlordId,setLandlordId] = useState('');
   const [formErrors, setFormErrors] = useState({});
   const [isSubmit, setIsSubmit] = useState(false);
   

  const handleBtnClick = (e)=>{
      e.preventDefault();
      setFormErrors(validate(landlordId));
      setIsSubmit(true);
      axios.delete(`http://localhost:8080/landlord/deletelandlord/${landlordId}`)
      .then(() =>
      {
        window.alert("Landlord Removed");
        setLandlordId(0)
    }).catch(error => console.log(error.message))
  }
  useEffect(() => {
    console.log(formErrors);
    if (Object.keys(formErrors).length === 0 && isSubmit) {
      console.log(landlordId);
    }
  }, [formErrors]);

  const validate = (values) => {
    const errors = {};
    if (!values) {
        errors.landlordId = "Landlord id is required!";
    }
    return errors;
  };


   return (
      <React.Fragment>
        <form className="c2">
            <h1 className="form-text ">Remove Landlord By ID</h1>
            <br/><br/>
            {/* <label>Landlord Id</label> */}
            <input name="landlordid" type="number" placeholder="Landlord ID" className="username" 
            value = {landlordId} onChange={e=>setLandlordId(e.target.value)}/>
            <br/>
            <p>{formErrors.landlordId}</p>
            <br/><br/>
            <button className="btn" data-testid="button" onClick={handleBtnClick}>Remove Landlord</button>
         </form>
    </React.Fragment>
    );
}

export default RemoveLandlord;