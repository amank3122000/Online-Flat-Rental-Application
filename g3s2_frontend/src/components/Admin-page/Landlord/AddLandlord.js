import React, { useEffect, useState } from 'react';
import axios from 'axios';


function AddLandlord() {

  let initiallandlord={landlordName:'',landlordAge:''};
  let [landlord,setLandlord]=useState(initiallandlord);
  let [msg,setMsg]=useState('');
  let [id,setId]=useState(0);
  const [isSubmit, setIsSubmit] = useState(false);

  useEffect(() => {
    const URL='http://localhost:8080/landlord/addlandlord';
    axios.post(URL,landlord).then((response) => 
    {
        setMsg(response.data)
        window.alert("Landlord Added...");
    }).catch(error => console.log(error.message))
    },[id])

    function handleBtnClick(e)
  {
      e.preventDefault();
      //setFormErrors(validate(user));
      setIsSubmit(true);
      setId(1);
      setLandlord(initiallandlord);
      
  }

  // useEffect(() => {
  //   console.log(formErrors);
  //   if (Object.keys(formErrors).length === 0 && isSubmit) {
  //     console.log(user);
  //   }
  // }, [formErrors]);
  
  return (
      <React.Fragment>
        <form class="c2">
    <h1 class="form-text">Add Landlord</h1>
    <br/><br/>
    {/* <input name="landlordid" type="number" placeholder="Landlord ID" class="col-md-4 address-tags" 
    onChange={e=>setLandlord({...landlord,landlordId:e.target.value})}/>
    <button className="btn btn-info logout-btn" type="submit">Add Flat</button> */}

    <input name="landlordname" type="text" placeholder="Landlord Name" class="col-md-4 address-tags"
    value={landlord.landlordName} onChange={e=>setLandlord({...landlord,landlordName:e.target.value})}/>
    <input name="landlordeage" type="number" placeholder="Landlord Age" class="col-md-4 address-tags"
    value={landlord.landlordAge} onChange={e=>setLandlord({...landlord,landlordAge:e.target.value})}/>
    <br/><br/><br/><br/>
  
    <button  className="btn" type="submit" onClick={handleBtnClick}>Add Landlord</button>
 </form>
    
     </React.Fragment>
    );
}

export default AddLandlord;