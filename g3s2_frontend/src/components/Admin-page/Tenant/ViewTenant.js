import React, { useEffect, useState } from 'react';
import axios from 'axios';

function ViewTenant() {

  const [tenantid,setTenant] = useState(0);
  const [tenant,setTenantDetail] = useState([]);
  const [btn,setButton] = useState(0);
  const [deletebtn,setdeleteButton] = useState(0);

  useEffect(() => {
    // DELETE request using axios inside useEffect React hook
    const URL=`http://localhost:8080/tenant/viewtenant/${tenantid}`
    axios
      .get(URL)
      .then((response) => {
      
      console.log(response.data);
      setTenantDetail(response.data)})
      .catch((error)=>console.log(error.response));
}, [btn]);

     useEffect(()=>{
         const URL=`http://localhost:8080/tenant/deletetenant/${tenantid}`
         axios
          .delete(URL)
          .then((response)=>
             {
                 setTenantDetail([]);
                 setTenant(0);
                 btn(0);
             })
             .catch(error=>console.log(error.response));
     },[deletebtn]);




const handleBtnClick = (e)=>{
 e.preventDefault();
 setButton(tenantid)
   
}


const handleDeleteBtnClick =(e)=>{
   e.preventDefault();
   setdeleteButton(1)
}


   return (
      <React.Fragment>
            <form className="view-form">
    <h1 className="form-text ">View Tenant By ID</h1>
    <br/>
    <input name="username" type="number" placeholder="Tenant ID*" class="username"
     value = {tenantid}
     onChange={e=>setTenant(e.target.value)}
    />
    <br/>
    <button class="btn" onClick={handleBtnClick}>View Tenant</button>
   </form>
   

 <table className="table table-data table-striped table-bordered view-table">
    <thead>
        <tr className="table-warning">
          <th>ID</th>
          <th>Tenant Name</th>
          <th>Age</th>
          <th>Flat List</th>
          <th>Actions</th>
        </tr>
      </thead>
      <tbody className="table-success ">
        <tr>
          <td>{tenant&&tenant.tenantId}</td>
          <td>{tenant&&tenant.tenantName}</td>
          <td>{tenant&&tenant.age}</td>
          <td>
            <button className="btn btn-info logout-btn" type="submit">View Flats</button>
          </td>
          <td>
            <button className="btn btn-warning logout-btn" type="submit">Update</button>
            <button className="btn btn-danger logout-btn" type="submit"
            onClick={handleDeleteBtnClick}
            >Delete</button>
          </td>
        </tr>
      
       
      </tbody>

  </table>     

      </React.Fragment>
    );
}

export default ViewTenant;