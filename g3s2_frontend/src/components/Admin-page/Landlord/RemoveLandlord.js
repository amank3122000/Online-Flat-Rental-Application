import React, { useEffect, useState } from 'react';
import axios from 'axios';

function RemoveLandlord() {

   const [status, setStatus] = useState(null);
   const [landlordid,setLandlordid] = useState(0);
   const [isSubmit, setIsSubmit] = useState(false);
   

   useEffect(() => {
      // DELETE request using axios inside useEffect React hook
      axios.delete(`http://localhost:8080/landlord/removeLandlord/${landlordid}`)
      .then(() => setStatus('Delete successful'));
  // empty dependency array means this effect will only run once (like componentDidMount in classes)
  }, [landlordid]);


  const handleBtnClick = (e)=>{
      console.log(e.target.response)
      //setFormErrors(validate(landlordid));
      setIsSubmit(true);
      window.alert("Landlord Removed");
  }



   return (
      <React.Fragment>
        <form className="c2">
            <h1 className="form-text ">Remove Landlord By ID</h1>
            <br/>
            <label>Landlord Id</label>
            <input name="landlordid" type="number" placeholder="Landlord ID*" className="landlordname" 
            value = {landlordid} onChange={e=>setLandlordid(e.target.value)}/>
            <br/><br/>
            <br/><br/>
            <button className="btn" onSubmit={handleBtnClick}>Remove Landlord</button>
         </form>
    </React.Fragment>
    );
}

export default RemoveLandlord;