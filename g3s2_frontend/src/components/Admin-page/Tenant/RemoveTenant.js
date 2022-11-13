import React, { useEffect, useState } from 'react';
import axios from 'axios';

function RemoveTenant() {

   const [status, setStatus] = useState(null);
   const [tenantid,setTenantid] = useState(0);

   useEffect(() => {
      
  }, [tenantid]);


  const handleBtnClick = (e)=>{
      console.log(e.target.response)
      axios.delete(`http://localhost:8080/tenant/deletetenant/${tenantid}`)
      .then(() => {
        setStatus('Delete successful')
      window.alert("User Removed")
      setTenantid(0);}).catch(error => console.log(error.message));
  }

   return (
      <React.Fragment>
        <form className="c2 view-form">
            <h1 className="form-text ">Remove Tenant By ID</h1>
            <br/>
            <input name="tenentid" type="number" placeholder="Tenant ID*" className="username"
            value = {tenantid}
            onChange={e=>setTenantid(e.target.value)}
            />
            <br/><br/>
            <button className="btn" data-testid="button" onClick={handleBtnClick}>Remove Tenant</button>
         </form>
    </React.Fragment>
    );
}

export default RemoveTenant;